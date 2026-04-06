// ============================================================================
// DEEPGUARD - Frontend Application
// Cyberpunk Security Theme with History Feature
// ============================================================================

// API Configuration
const API_BASE_URL = window.location.origin.includes('localhost')
    ? 'http://localhost:8000'
    : window.location.origin;

// State
let currentFile = null;
let currentAnalysisMode = 'detect';
let currentAnalysisResult = null;
let currentFilePreview = null;
let abortController = null;

// DOM Elements
const dropZone = document.getElementById('drop-zone');
const fileInput = document.getElementById('file-input');
const selectFileBtn = document.getElementById('select-file-btn');
const uploadSection = document.getElementById('upload-section');
const loadingSection = document.getElementById('loading-section');
const resultsSection = document.getElementById('results-section');
const errorSection = document.getElementById('error-section');
const historySection = document.getElementById('history-section');
const progressBar = document.getElementById('progress-bar');
const progressText = document.getElementById('progress-text');
const loadingText = document.getElementById('loading-text');

// File Preview Elements
const filePreviewContainer = document.getElementById('file-preview-container');
const fileThumbnail = document.getElementById('file-thumbnail');
const previewFileName = document.getElementById('preview-file-name');
const previewFileSize = document.getElementById('preview-file-size');
const previewFileType = document.getElementById('preview-file-type');
const previewFileDuration = document.getElementById('preview-file-duration');
const removeFileBtn = document.getElementById('remove-file-btn');
const analyzeBtnContainer = document.getElementById('analyze-btn-container');
const analyzeBtn = document.getElementById('analyze-btn');

// History Storage Key
const HISTORY_KEY = 'deepguard_history';
const MAX_HISTORY_ITEMS = 50;

// Verdict Configuration
const VERDICT_CONFIG = {
    'AI_GENERATED': {
        class: 'ai-generated',
        label: 'AI Generated',
        icon: '⚠️',
        shortLabel: 'AI'
    },
    'LIKELY_AI': {
        class: 'likely-ai',
        label: 'Likely AI',
        icon: '⚡',
        shortLabel: 'Likely'
    },
    'AUTHENTIC': {
        class: 'authentic',
        label: 'Authentic',
        icon: '✓',
        shortLabel: 'Authentic'
    },
    'UNCERTAIN': {
        class: 'uncertain',
        label: 'Uncertain',
        icon: '?',
        shortLabel: 'Uncertain'
    }
};

// ============================================================================
// INITIALIZATION
// ============================================================================

function init() {
    setupEventListeners();
    setupAnalysisModeSelection();
    setupNavigationTabs();
    setupKeyboardShortcuts();
    loadHistory();
}

// ============================================================================
// EVENT LISTENERS
// ============================================================================

function setupEventListeners() {
    // Drag and Drop
    dropZone.addEventListener('dragover', handleDragOver);
    dropZone.addEventListener('dragleave', handleDragLeave);
    dropZone.addEventListener('drop', handleDrop);

    // File Input
    selectFileBtn.addEventListener('click', () => fileInput.click());
    fileInput.addEventListener('change', handleFileSelect);

    // Prevent default drag behavior on document
    document.addEventListener('dragover', (e) => e.preventDefault());
    document.addEventListener('drop', (e) => e.preventDefault());

    // Remove File Button
    removeFileBtn.addEventListener('click', (e) => {
        e.stopPropagation();
        clearFileSelection();
    });

    // Analyze Button
    analyzeBtn.addEventListener('click', () => {
        if (currentFile) {
            analyzeFile(currentFile);
        }
    });

    // New Analysis Button
    document.getElementById('new-analysis-btn').addEventListener('click', resetAnalysis);

    // Retry Button
    document.getElementById('retry-btn').addEventListener('click', resetAnalysis);

    // Details Toggle
    document.getElementById('details-toggle').addEventListener('click', toggleDetails);

    // Export Button
    document.getElementById('export-btn').addEventListener('click', exportReport);

    // Clear History Button
    document.getElementById('clear-history-btn').addEventListener('click', clearHistory);
}

// ============================================================================
// NAVIGATION TABS
// ============================================================================

function setupNavigationTabs() {
    const tabs = document.querySelectorAll('.nav-tab');

    tabs.forEach(tab => {
        tab.addEventListener('click', () => {
            const targetTab = tab.dataset.tab;

            // Update active tab
            tabs.forEach(t => t.classList.remove('active'));
            tab.classList.add('active');

            // Show target section, hide others
            if (targetTab === 'upload') {
                showSection('upload');
            } else if (targetTab === 'history') {
                showSection('history');
                renderHistory();
            }
        });
    });
}

function showSection(sectionName) {
    // Hide all sections
    uploadSection.classList.add('hidden');
    loadingSection.classList.add('hidden');
    resultsSection.classList.add('hidden');
    errorSection.classList.add('hidden');
    historySection.classList.add('hidden');

    // Show target section
    switch (sectionName) {
        case 'upload':
            uploadSection.classList.remove('hidden');
            break;
        case 'loading':
            loadingSection.classList.remove('hidden');
            break;
        case 'results':
            resultsSection.classList.remove('hidden');
            break;
        case 'error':
            errorSection.classList.remove('hidden');
            break;
        case 'history':
            historySection.classList.remove('hidden');
            break;
    }
}

// ============================================================================
// ANALYSIS MODE SELECTION
// ============================================================================

function setupAnalysisModeSelection() {
    const optionCards = document.querySelectorAll('.option-card');

    optionCards.forEach(card => {
        card.addEventListener('click', () => {
            // Remove active from all
            optionCards.forEach(c => c.classList.remove('active'));
            // Add active to clicked
            card.classList.add('active');
            // Update mode
            currentAnalysisMode = card.dataset.mode;
            // Check the radio input
            card.querySelector('input').checked = true;
        });
    });
}

// ============================================================================
// KEYBOARD SHORTCUTS
// ============================================================================

function setupKeyboardShortcuts() {
    document.addEventListener('keydown', (e) => {
        // Ctrl+U - Upload
        if (e.ctrlKey && e.key === 'u') {
            e.preventDefault();
            fileInput.click();
        }

        // Ctrl+E - Export
        if (e.ctrlKey && e.key === 'e') {
            e.preventDefault();
            if (currentAnalysisResult) {
                exportReport();
            }
        }

        // Escape - Reset/Close
        if (e.key === 'Escape') {
            if (!uploadSection.classList.contains('hidden')) {
                // If on upload tab, clear file
                clearFileSelection();
            } else {
                // Otherwise go back to upload
                resetAnalysis();
            }
        }

        // Ctrl+H - History
        if (e.ctrlKey && e.key === 'h') {
            e.preventDefault();
            document.querySelector('[data-tab="history"]').click();
        }
    });
}

// ============================================================================
// FILE HANDLING
// ============================================================================

function handleDragOver(e) {
    e.preventDefault();
    dropZone.classList.add('drag-over');
}

function handleDragLeave(e) {
    e.preventDefault();
    dropZone.classList.remove('drag-over');
}

function handleDrop(e) {
    e.preventDefault();
    dropZone.classList.remove('drag-over');

    const files = e.dataTransfer.files;
    if (files.length > 0) {
        processFile(files[0]);
    }
}

function handleFileSelect(e) {
    const files = e.target.files;
    if (files.length > 0) {
        processFile(files[0]);
    }
}

function processFile(file) {
    // Validate file type
    if (!isValidFileType(file)) {
        showToast('Invalid file type. Please upload a video or audio file.', 'error');
        return;
    }

    // Validate file size (100MB limit)
    const MAX_SIZE = 100 * 1024 * 1024;
    if (file.size > MAX_SIZE) {
        showToast('File too large. Maximum size is 100MB.', 'error');
        return;
    }

    currentFile = file;
    displayFilePreview(file);
}

function isValidFileType(file) {
    const validTypes = [
        'video/mp4', 'video/avi', 'video/quicktime', 'video/x-matroska',
        'video/webm', 'audio/mpeg', 'audio/wav', 'audio/aac', 'audio/mp3',
        'video/x-msvideo', 'video/x-matroska'
    ];
    const validExtensions = ['.mp4', '.avi', '.mov', '.mkv', '.mp3', '.wav', '.aac', '.webm'];

    const isValidMime = validTypes.includes(file.type);
    const isValidExt = validExtensions.some(ext =>
        file.name.toLowerCase().endsWith(ext)
    );

    return isValidMime || isValidExt;
}

function displayFilePreview(file) {
    filePreviewContainer.classList.add('visible');
    analyzeBtnContainer.style.display = 'flex';

    previewFileName.textContent = file.name;
    previewFileSize.textContent = formatFileSize(file.size);
    previewFileType.textContent = file.type || 'Unknown Type';
    previewFileDuration.textContent = '-';

    // Create thumbnail preview
    if (file.type.startsWith('video/')) {
        createVideoThumbnail(file);
    } else if (file.type.startsWith('audio/')) {
        createAudioThumbnail(file);
    } else {
        fileThumbnail.innerHTML = `
            <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                <rect x="3" y="3" width="18" height="18" rx="2" ry="2"/>
                <circle cx="8.5" cy="8.5" r="1.5"/>
                <polyline points="21 15 16 10 5 21"/>
            </svg>
        `;
    }

    showToast('File ready for analysis', 'success');
}

function createVideoThumbnail(file) {
    const video = document.createElement('video');
    video.preload = 'metadata';
    video.src = URL.createObjectURL(file);
    video.muted = true;

    video.onloadedmetadata = () => {
        previewFileDuration.textContent = formatDuration(video.duration);
        // Seek to 1 second for thumbnail
        video.currentTime = Math.min(1, video.duration / 4);
    };

    video.onseeked = () => {
        const canvas = document.createElement('canvas');
        canvas.width = 160;
        canvas.height = 90;
        const ctx = canvas.getContext('2d');
        ctx.drawImage(video, 0, 0, canvas.width, canvas.height);
        fileThumbnail.innerHTML = '';
        fileThumbnail.appendChild(canvas);
        URL.revokeObjectURL(video.src);
    };

    video.onerror = () => {
        fileThumbnail.innerHTML = `
            <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                <rect x="2" y="3" width="20" height="14" rx="2" ry="2"/>
                <line x1="8" y1="21" x2="16" y2="21"/>
                <line x1="12" y1="17" x2="12" y2="21"/>
            </svg>
        `;
    };
}

function createAudioThumbnail(file) {
    const audio = document.createElement('audio');
    audio.preload = 'metadata';
    audio.src = URL.createObjectURL(file);

    audio.onloadedmetadata = () => {
        previewFileDuration.textContent = formatDuration(audio.duration);
    };

    fileThumbnail.innerHTML = `
        <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
            <path d="M12 1a3 3 0 0 0-3 3v8a3 3 0 0 0 6 0V4a3 3 0 0 0-3-3z"/>
            <path d="M19 10v2a7 7 0 0 1-14 0v-2"/>
        </svg>
    `;
}

function clearFileSelection() {
    currentFile = null;
    fileInput.value = '';
    filePreviewContainer.classList.remove('visible');
    analyzeBtnContainer.style.display = 'none';
}

// ============================================================================
// ANALYSIS
// ============================================================================

async function analyzeFile(file) {
    showLoading();

    // Simulate progress
    const progressInterval = simulateProgress();

    const formData = new FormData();
    formData.append('file', file);

    const startTime = Date.now();
    abortController = new AbortController();

    try {
        const endpoint = `/${currentAnalysisMode}`;
        const response = await fetch(`${API_BASE_URL}${endpoint}`, {
            method: 'POST',
            body: formData,
            signal: abortController.signal
        });

        clearInterval(progressInterval);

        if (!response.ok) {
            const errorData = await response.json().catch(() => ({}));
            throw new Error(errorData.detail || `HTTP error! status: ${response.status}`);
        }

        const data = await response.json();
        const analysisDuration = ((Date.now() - startTime) / 1000).toFixed(2);

        // Add duration to data
        data.analysis_duration = parseFloat(analysisDuration);

        // Save to history
        saveToHistory(file, data);

        // Show results
        showResults(data, file);

        showToast('Analysis complete!', 'success');
    } catch (error) {
        clearInterval(progressInterval);

        if (error.name === 'AbortError') {
            console.log('Request aborted');
            return;
        }

        console.error('Analysis error:', error);
        showError(error.message || 'Failed to analyze file. Please try again.');
    }
}

function simulateProgress() {
    let progress = 0;
    const steps = [
        { at: 5, text: 'Uploading file...' },
        { at: 20, text: 'Extracting frames...' },
        { at: 35, text: 'Analyzing visual patterns...' },
        { at: 50, text: 'Processing audio frequencies...' },
        { at: 65, text: 'Running AI detection models...' },
        { at: 80, text: 'Cross-referencing signatures...' },
        { at: 90, text: 'Generating report...' },
        { at: 95, text: 'Finalizing results...' }
    ];

    return setInterval(() => {
        progress += Math.random() * 4;
        if (progress > 100) progress = 100;

        updateProgress(progress);

        const step = steps.find(s => progress >= s.at && progress < s.at + 15);
        if (step) {
            loadingText.textContent = step.text;
        }

        if (progress >= 100) {
            loadingText.textContent = 'Processing complete!';
        }
    }, 100);
}

function updateProgress(value) {
    const percentage = Math.min(Math.round(value), 100);
    progressBar.style.width = `${percentage}%`;
    progressText.textContent = `${percentage}%`;
}

// ============================================================================
// UI STATE MANAGEMENT
// ============================================================================

function showLoading() {
    hideAllSections();
    loadingSection.classList.remove('hidden');
    updateProgress(0);
    loadingText.textContent = 'Initializing scan...';
}

function showResults(data, file) {
    currentAnalysisResult = data;
    hideAllSections();
    resultsSection.classList.remove('hidden');

    // Populate results
    populateVerdict(data);
    populateFileInfo(file);
    populateReasons(data.reasons || []);
    populateDetails(data);

    // Scroll to results
    resultsSection.scrollIntoView({ behavior: 'smooth', block: 'start' });
}

function showError(message) {
    hideAllSections();
    errorSection.classList.remove('hidden');
    document.getElementById('error-message').textContent = message;
    showToast(message, 'error');
}

function hideAllSections() {
    uploadSection.classList.add('hidden');
    loadingSection.classList.add('hidden');
    resultsSection.classList.add('hidden');
    errorSection.classList.add('hidden');
    historySection.classList.add('hidden');
}

function resetAnalysis() {
    currentFile = null;
    currentAnalysisResult = null;
    fileInput.value = '';
    clearFileSelection();

    if (abortController) {
        abortController.abort();
    }

    // Switch to upload tab
    document.querySelector('[data-tab="upload"]').click();
}

// ============================================================================
// RESULTS POPULATION
// ============================================================================

function populateVerdict(data) {
    const verdict = data.verdict || 'UNCERTAIN';
    const confidence = data.confidence || 0;

    const config = VERDICT_CONFIG[verdict] || VERDICT_CONFIG['UNCERTAIN'];
    const badge = document.getElementById('verdict-badge');
    const text = document.getElementById('verdict-text');

    // Reset classes
    badge.className = 'verdict-badge';
    badge.classList.add(config.class);

    text.textContent = `${config.icon} ${config.label}`;

    // Update confidence bar
    const confidenceBar = document.getElementById('confidence-bar');
    const confidenceValue = document.getElementById('confidence-value');

    confidenceBar.style.width = `${(confidence / 10) * 100}%`;
    confidenceValue.textContent = `${confidence}/10`;
}

function populateFileInfo(file) {
    document.getElementById('file-name').textContent = file.name;
    document.getElementById('file-size').textContent = formatFileSize(file.size);

    const modeLabels = {
        'detect': 'Full Analysis (Video + Audio)',
        'detect-video': 'Video Only',
        'detect-audio': 'Audio Only'
    };
    document.getElementById('analysis-type').textContent = modeLabels[currentAnalysisMode] || 'Unknown';
}

function populateReasons(reasons) {
    const list = document.getElementById('reasons-list');
    list.innerHTML = '';

    if (!reasons || reasons.length === 0) {
        const li = document.createElement('li');
        li.className = 'reason-item';
        li.innerHTML = `
            <svg class="reason-icon" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                <circle cx="12" cy="12" r="10"/>
                <path d="M12 16v-4M12 8h.01"/>
            </svg>
            <span class="reason-text">No specific indicators detected</span>
        `;
        list.appendChild(li);
        return;
    }

    reasons.forEach(reason => {
        const li = document.createElement('li');
        li.className = 'reason-item';

        const iconType = getReasonIconType(reason);

        li.innerHTML = `
            <svg class="reason-icon ${iconType}" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                ${getReasonIconSvg(reason)}
            </svg>
            <span class="reason-text">${formatReason(reason)}</span>
        `;
        list.appendChild(li);
    });
}

function getReasonIconType(reason) {
    const lower = reason.toLowerCase();
    if (lower.includes('artifact') || lower.includes('unnatural') || lower.includes('synthetic')) {
        return 'ai';
    }
    if (lower.includes('suspicious') || lower.includes('possible') || lower.includes('potential')) {
        return 'likely';
    }
    if (lower.includes('natural') || lower.includes('consistent') || lower.includes('authentic')) {
        return 'authentic';
    }
    return '';
}

function getReasonIconSvg(reason) {
    const lower = reason.toLowerCase();

    if (lower.includes('artifact')) {
        return '<path d="M3 6h18M3 12h18M3 18h18"/>';
    }
    if (lower.includes('face') || lower.includes('eye')) {
        return '<circle cx="12" cy="12" r="10"/><circle cx="12" cy="12" r="3"/>';
    }
    if (lower.includes('audio') || lower.includes('voice') || lower.includes('sound')) {
        return '<path d="M12 1a3 3 0 0 0-3 3v8a3 3 0 0 0 6 0V4a3 3 0 0 0-3-3z"/><path d="M19 10v2a7 7 0 0 1-14 0v-2"/>';
    }
    if (lower.includes('temporal') || lower.includes('motion') || lower.includes('frame')) {
        return '<path d="M4 4h16v16H4z"/><path d="M4 12h16"/>';
    }

    // Default info icon
    return '<circle cx="12" cy="12" r="10"/><path d="M12 16v-4M12 8h.01"/>';
}

function formatReason(reason) {
    // Capitalize first letter and clean up
    return reason.charAt(0).toUpperCase() + reason.slice(1);
}

function populateDetails(data) {
    // Video score
    const videoScoreEl = document.getElementById('video-score');
    const videoContainer = document.getElementById('video-score-container');
    if (data.video_score !== undefined && data.video_score !== null) {
        videoScoreEl.textContent = data.video_score.toFixed(3);
        videoContainer.classList.remove('hidden');
    } else {
        videoContainer.classList.add('hidden');
    }

    // Audio score
    const audioScoreEl = document.getElementById('audio-score');
    const audioContainer = document.getElementById('audio-score-container');
    if (data.audio_score !== undefined && data.audio_score !== null) {
        audioScoreEl.textContent = data.audio_score.toFixed(3);
        audioContainer.classList.remove('hidden');
    } else {
        audioContainer.classList.add('hidden');
    }

    // Processing time
    document.getElementById('processing-time').textContent =
        data.processing_time ? `${data.processing_time.toFixed(3)}s` : '-';

    // Frames analyzed
    document.getElementById('frames-analyzed').textContent =
        data.frames_analyzed || '-';

    // Analysis ID (generated timestamp)
    document.getElementById('analysis-id').textContent =
        data.id || `ANALYSIS-${Date.now().toString(36).toUpperCase()}`;

    // Timestamp
    document.getElementById('analysis-timestamp').textContent =
        new Date().toLocaleString();

    // Raw JSON
    document.getElementById('raw-json').textContent = JSON.stringify(data, null, 2);
}

function toggleDetails() {
    const toggle = document.getElementById('details-toggle');
    const content = document.getElementById('details-content');
    const isExpanded = toggle.getAttribute('aria-expanded') === 'true';

    toggle.setAttribute('aria-expanded', !isExpanded);
    content.classList.toggle('hidden');
}

// ============================================================================
// HISTORY MANAGEMENT
// ============================================================================

function saveToHistory(file, result) {
    const history = getHistory();

    const historyItem = {
        id: `ANALYSIS-${Date.now().toString(36).toUpperCase()}`,
        filename: file.name,
        fileSize: file.size,
        fileType: file.type || 'unknown',
        timestamp: new Date().toISOString(),
        verdict: result.verdict,
        confidence: result.confidence,
        reasons: result.reasons || [],
        videoScore: result.video_score,
        audioScore: result.audio_score,
        processingTime: result.processing_time,
        framesAnalyzed: result.frames_analyzed,
        analysisDuration: result.analysis_duration,
        analysisMode: currentAnalysisMode
    };

    // Add to beginning
    history.unshift(historyItem);

    // Keep only MAX_HISTORY_ITEMS
    if (history.length > MAX_HISTORY_ITEMS) {
        history.pop();
    }

    // Save to localStorage
    try {
        localStorage.setItem(HISTORY_KEY, JSON.stringify(history));
    } catch (e) {
        console.warn('Could not save to localStorage:', e);
    }

    // Also save to backend
    saveToBackend(historyItem);
}

async function saveToBackend(item) {
    try {
        await fetch(`${API_BASE_URL}/history`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(item)
        });
    } catch (e) {
        // Silent fail - localStorage is primary
        console.log('Could not save to backend:', e);
    }
}

function getHistory() {
    try {
        const history = localStorage.getItem(HISTORY_KEY);
        return history ? JSON.parse(history) : [];
    } catch (e) {
        console.warn('Could not load from localStorage:', e);
        return [];
    }
}

function loadHistory() {
    // History is loaded when needed (renderHistory)
}

function clearHistory() {
    if (confirm('Are you sure you want to clear all analysis history?')) {
        try {
            localStorage.removeItem(HISTORY_KEY);
            renderHistory();
            showToast('History cleared', 'success');

            // Also clear backend
            fetch(`${API_BASE_URL}/history/clear`, { method: 'POST' })
                .catch(() => {}); // Silent fail
        } catch (e) {
            console.warn('Could not clear history:', e);
        }
    }
}

function renderHistory() {
    const history = getHistory();
    const historyList = document.getElementById('history-list');
    const historyEmpty = document.getElementById('history-empty');

    if (history.length === 0) {
        historyList.innerHTML = '';
        historyEmpty.style.display = 'block';
        return;
    }

    historyEmpty.style.display = 'none';
    historyList.innerHTML = '';

    history.forEach(item => {
        const historyEl = createHistoryItem(item);
        historyList.appendChild(historyEl);
    });
}

function createHistoryItem(item) {
    const div = document.createElement('div');
    div.className = 'history-item';

    const config = VERDICT_CONFIG[item.verdict] || VERDICT_CONFIG['UNCERTAIN'];

    div.innerHTML = `
        <div class="verdict-indicator ${config.class}"></div>
        <div class="history-item-info">
            <div class="history-item-name">${escapeHtml(item.filename)}</div>
            <div class="history-item-meta">
                <span>${formatDate(item.timestamp)}</span>
                <span>${formatFileSize(item.fileSize)}</span>
            </div>
        </div>
        <div class="history-item-verdict ${config.class}">${config.shortLabel}</div>
        <div class="history-item-confidence">${item.confidence}/10</div>
    `;

    div.addEventListener('click', () => loadHistoryItem(item));

    return div;
}

function loadHistoryItem(item) {
    // Populate results with history item data
    currentAnalysisResult = {
        verdict: item.verdict,
        confidence: item.confidence,
        reasons: item.reasons,
        video_score: item.videoScore,
        audio_score: item.audioScore,
        processing_time: item.processingTime,
        frames_analyzed: item.framesAnalyzed
    };

    // Create a mock file object for display
    const mockFile = {
        name: item.filename,
        size: item.fileSize
    };

    // Switch to upload tab and show results
    document.querySelector('[data-tab="upload"]').click();
    showResults(currentAnalysisResult, mockFile);

    showToast('Loaded from history', 'info');
}

// ============================================================================
// EXPORT REPORT
// ============================================================================

function exportReport() {
    if (!currentAnalysisResult || !currentFile) {
        showToast('No analysis to export', 'error');
        return;
    }

    const report = {
        reportType: 'AI Content Analysis Report',
        generatedAt: new Date().toISOString(),
        fileInfo: {
            name: currentFile.name,
            size: formatFileSize(currentFile.size),
            type: currentFile.type || 'Unknown'
        },
        analysis: {
            mode: currentAnalysisMode,
            verdict: currentAnalysisResult.verdict,
            confidence: currentAnalysisResult.confidence,
            reasons: currentAnalysisResult.reasons,
            videoScore: currentAnalysisResult.video_score,
            audioScore: currentAnalysisResult.audio_score,
            processingTime: currentAnalysisResult.processing_time,
            framesAnalyzed: currentAnalysisResult.frames_analyzed
        },
        rawData: currentAnalysisResult
    };

    const blob = new Blob([JSON.stringify(report, null, 2)], { type: 'application/json' });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = `analysis-report-${Date.now()}.json`;
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
    URL.revokeObjectURL(url);

    showToast('Report exported successfully', 'success');
}

// ============================================================================
// TOAST NOTIFICATIONS
// ============================================================================

function showToast(message, type = 'info') {
    const container = document.getElementById('toast-container');

    const toast = document.createElement('div');
    toast.className = `toast ${type}`;

    const icon = type === 'success' ? '✓' :
                 type === 'error' ? '✕' :
                 type === 'warning' ? '⚠' : 'ℹ';

    toast.innerHTML = `
        <span>${icon}</span>
        <span>${escapeHtml(message)}</span>
    `;

    container.appendChild(toast);

    // Auto remove after 4 seconds
    setTimeout(() => {
        toast.classList.add('hiding');
        toast.addEventListener('animationend', () => {
            toast.remove();
        });
    }, 4000);
}

// ============================================================================
// UTILITY FUNCTIONS
// ============================================================================

function formatFileSize(bytes) {
    if (bytes === 0) return '0 B';
    const k = 1024;
    const sizes = ['B', 'KB', 'MB', 'GB'];
    const i = Math.floor(Math.log(bytes) / Math.log(k));
    return parseFloat((bytes / Math.pow(k, i)).toFixed(2)) + ' ' + sizes[i];
}

function formatDuration(seconds) {
    if (!seconds || isNaN(seconds)) return '-';
    const mins = Math.floor(seconds / 60);
    const secs = Math.floor(seconds % 60);
    if (mins > 0) {
        return `${mins}m ${secs}s`;
    }
    return `${secs}s`;
}

function formatDate(isoString) {
    const date = new Date(isoString);
    const now = new Date();
    const diff = now - date;

    // Less than a minute
    if (diff < 60000) {
        return 'Just now';
    }

    // Less than an hour
    if (diff < 3600000) {
        const mins = Math.floor(diff / 60000);
        return `${mins}m ago`;
    }

    // Less than a day
    if (diff < 86400000) {
        const hours = Math.floor(diff / 3600000);
        return `${hours}h ago`;
    }

    // Less than a week
    if (diff < 604800000) {
        const days = Math.floor(diff / 86400000);
        return `${days}d ago`;
    }

    // Default format
    return date.toLocaleDateString();
}

function escapeHtml(text) {
    const div = document.createElement('div');
    div.textContent = text;
    return div.innerHTML;
}

// ============================================================================
// INITIALIZE APP
// ============================================================================

// Wait for DOM to be ready
document.addEventListener('DOMContentLoaded', init);

// Also try init immediately in case DOM is already loaded
if (document.readyState === 'complete' || document.readyState === 'interactive') {
    init();
}
