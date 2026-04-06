
# DEEPGUARD - Cyberpunk Edition v2.0

A full-stack application for detecting AI-generated video and audio content with a cyberpunk/security-themed interface and history tracking.

![Cyberpunk Theme](frontend/images/screenshot-main.png)

## Design Overview

### Cyberpunk/Security Theme

The application features a dark, futuristic design inspired by security forensics tools and cyberpunk aesthetics:

- **Neon Accents**: Cyan (#00f0ff), Magenta (#ff00ff), Green (#00ff41) on dark backgrounds
- **Grid Background**: Subtle cyberpunk grid pattern with cyan glow
- **CRT Scanline Effect**: Simulated CRT monitor scanlines for authentic retro-futuristic feel
- **Glitch Text Effects**: Animated glitch effect on the logo for cyberpunk authenticity
- **Monospace Fonts**: JetBrains Mono for technical/forensic appearance
- **Neon Glows**: Verdict badges and buttons feature glowing neon borders
- **Matrix-style Loading**: Animated scanning effects during analysis

### Screenshots

**Main Upload Interface:**
- Drag-and-drop zone with neon hover effects
- File preview with thumbnail generation for videos
- Three analysis mode options with glowing borders

**Analysis Loading:**
- Dual-ring cyberpunk spinner
- Progress bar with neon gradient and trailing glow
- Matrix-style scanline animation

**Results Display:**
- Glitch-effect verdict badge with color-coded neon glow
- Confidence meter with gradient progress bar
- Detection reasons with categorized icons
- Expandable detailed results

**History Panel:**
- List of previous analyses with verdict indicators
- Click to reload and view previous results
- Clear all history option

**Toast Notifications:**
- Neon-styled success/error/info notifications
- Slide-in animation from the right
- Auto-dismiss after 4 seconds

## Project Structure

```
ai-detector/
├── main.py              # FastAPI backend with history endpoints
├── requirements.txt     # Python dependencies
├── README.md           # This file
├── services/           # ML model services (add your models here)
│   └── __init__.py
├── utils/              # Utility functions
│   └── __init__.py
└── frontend/           # Static frontend files
    ├── index.html      # Main page with history section
    ├── style.css       # Cyberpunk theme stylesheet
    └── app.js          # Frontend logic with history & export
```

## Quick Start

### 1. Install Dependencies

```bash
cd ~/ai-detector
pip install -r requirements.txt
```

### 2. Run the Backend

```bash
python main.py
```

The server will start on `http://localhost:8000`

### 3. Access the Frontend

Open your browser and navigate to:
- **Frontend UI**: http://localhost:8000/
- **API Documentation**: http://localhost:8000/docs
- **Health Check**: http://localhost:8000/health

## Features

### Core Features

- **Drag-and-Drop Upload**: Modern upload interface with file preview
- **File Preview**: Video thumbnail generation, audio icon display
- **Three Analysis Modes**: Full, Video Only, Audio Only
- **Real-Time Progress**: Cyberpunk-themed loading animation with progress bar
- **Detailed Results**: Verdict, confidence score, detection reasons, technical details
- **Export Reports**: Download analysis as JSON file (Ctrl+E)

### History Feature

- **Automatic Saving**: Every analysis is saved to localStorage and backend
- **History Panel**: View all previous analyses with timestamps
- **Persistent Storage**: Works across browser sessions via localStorage
- **Click to Reload**: Click any history item to view full results again
- **Clear History**: Remove all history with confirmation

### Keyboard Shortcuts

| Shortcut | Action |
|----------|--------|
| `Ctrl+U` | Open file upload dialog |
| `Ctrl+E` | Export current analysis report |
| `Ctrl+H` | Open history panel |
| `Esc` | Reset/Clear current file or go back to upload |

### Verdict Types

Color-coded verdicts with neon glow effects:

| Verdict | Color | Description |
|---------|-------|-------------|
| **AI_GENERATED** | Red | High confidence AI-generated content |
| **LIKELY_AI** | Amber | Suspicious indicators present |
| **AUTHENTIC** | Green | Natural content detected |
| **UNCERTAIN** | Gray | Inconclusive analysis |

## API Endpoints

### Detection Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/` | GET | Serves the frontend web interface |
| `/detect` | POST | Full analysis (video + audio) |
| `/detect-video` | POST | Video frames only |
| `/detect-audio` | POST | Audio only |

### History Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/history` | GET | Retrieve analysis history |
| `/history` | POST | Add item to history |
| `/history/clear` | POST | Clear all history |
| `/history/{id}` | GET | Get specific history item |
| `/history/{id}` | DELETE | Delete specific history item |

### Status Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/health` | GET | Health check with timestamp |
| `/api/status` | GET | Extended API status and info |

### Request/Response Examples

**Detection Request:**
```bash
curl -X POST "http://localhost:8000/detect" \
  -H "accept: application/json" \
  -F "file=@video.mp4"
```

**Detection Response:**
```json
{
  "verdict": "AI_GENERATED",
  "confidence": 8,
  "reasons": [
    "Unnatural facial micro-expressions detected",
    "Inconsistent temporal coherence between frames",
    "Artifacts in hair and fine detail rendering"
  ],
  "video_score": 0.85,
  "audio_score": 0.72,
  "processing_time": 2.34,
  "frames_analyzed": 30,
  "analysis_duration": 2.5
}
```

**History Response:**
```json
{
  "items": [
    {
      "id": "ANALYSIS-XYZ123",
      "filename": "video.mp4",
      "fileSize": 10485760,
      "fileType": "video/mp4",
      "timestamp": "2024-01-15T10:30:00Z",
      "verdict": "AI_GENERATED",
      "confidence": 8,
      "reasons": [...],
      "videoScore": 0.85,
      "audioScore": 0.72,
      "processingTime": 2.34,
      "framesAnalyzed": 30,
      "analysisDuration": 2.5,
      "analysisMode": "detect"
    }
  ],
  "total": 1,
  "limit": 50
}
```

## Frontend Features

### Design Features

- **Cyberpunk Grid Background**: Subtle animated grid with cyan accents
- **CRT Scanlines**: Simulated CRT monitor effect
- **Glitch Text Animation**: Logo features periodic glitch effects
- **Neon Glow Effects**: Buttons and badges glow on hover/selection
- **Smooth Transitions**: All state changes have smooth animations
- **Custom Scrollbars**: Themed scrollbar styling
- **Text Selection**: Cyan highlight color

### Interactive Elements

- **Toast Notifications**: Success, error, warning, info notifications with neon styling
- **Progress Animation**: Cyberpunk-themed loading with dual-ring spinner
- **Hover Effects**: All interactive elements have neon glow on hover
- **Drag & Drop**: Visual feedback with border color change and scale effect
- **Expandable Details**: Smooth accordion for technical details

### Mobile Responsive

- Responsive layout adapts to mobile screens
- Touch-friendly buttons and controls
- Stacked layout on narrow screens
- Optimized typography for small screens

## Supported File Formats

- **Video**: MP4, AVI, MOV, MKV, WEBM
- **Audio**: MP3, WAV, AAC

Maximum file size: **100MB**

## Development

### Running Backend Only

```bash
uvicorn main:app --reload --port 8000
```

### Frontend Development

The frontend is static HTML/CSS/JS. You can serve it with any static file server:

```bash
cd frontend
python -m http.server 3000
```

Then access at `http://localhost:3000`

### CORS Configuration

The backend is configured with CORS to allow requests from:
- localhost:3000
- localhost:5173
- localhost:8000
- All origins (development mode)

Edit `main.py` to modify CORS settings for production.

## Integrating Real ML Models

The current backend uses mock detection logic. To integrate real models:

1. Add your model loading code in `services/`:

```python
# services/detector.py
class AIDetector:
    def __init__(self):
        self.video_model = load_video_model()
        self.audio_model = load_audio_model()

    def analyze(self, file_path: str, mode: str):
        # Your detection logic here
        return {
            "verdict": "AI_GENERATED",
            "confidence": 8,
            "reasons": [...]
        }
```

2. Update the `analyze_content()` function in `main.py` to call your models.

## Production Deployment

### Using Docker

Create a `Dockerfile`:

```dockerfile
FROM python:3.11-slim

WORKDIR /app

COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

COPY . .

EXPOSE 8000

CMD ["uvicorn", "main:app", "--host", "0.0.0.0", "--port", "8000"]
```

Build and run:
```bash
docker build -t ai-detector .
docker run -p 8000:8000 ai-detector
```

### Environment Variables

- `PORT`: Server port (default: 8000)
- `HOST`: Bind address (default: 0.0.0.0)

## Troubleshooting

### CORS Errors

If you see CORS errors in the browser:
1. Ensure backend is running
2. Check `allow_origins` in `main.py` includes your frontend URL
3. Use `*` for development (not recommended for production)

### File Upload Fails

- Check file size is under 100MB
- Verify file format is supported
- Check browser console for errors

### History Not Persisting

- localStorage is limited to ~5MB
- Backend history resets on server restart (in-memory storage)
- Consider implementing SQLite for persistent storage in production

### Port Already in Use

```bash
# Find process using port 8000
lsof -i :8000  # macOS/Linux
netstat -ano | findstr :8000  # Windows

# Kill process or use different port
python main.py  # change PORT in code or use --port flag with uvicorn
```

## Theme Customization

The CSS file contains CSS variables for easy customization:

```css
:root {
    --neon-cyan: #00f0ff;
    --neon-magenta: #ff00ff;
    --neon-green: #00ff41;
    --neon-amber: #ffaa00;
    /* ... more variables */
}
```

To change the theme, modify these color values in `frontend/style.css`.

## Browser Compatibility

- Chrome/Edge 90+
- Firefox 90+
- Safari 14+

Requires ES6+ and CSS Grid/Flexbox support.

## License

MIT License - Feel free to use for your own projects.

---

**DEEPGUARD - Forensic Analysis Platform v2.0**
