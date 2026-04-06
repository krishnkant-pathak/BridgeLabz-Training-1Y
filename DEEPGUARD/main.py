
from fastapi import FastAPI, File, UploadFile, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from fastapi.staticfiles import StaticFiles
from fastapi.responses import FileResponse, JSONResponse
from pydantic import BaseModel, Field
from typing import Optional, Literal, List
from datetime import datetime
import uvicorn
import os
import sys
import time
import tempfile
import uuid
from pathlib import Path

# Add the project directory to Python path
sys.path.insert(0, str(Path(__file__).parent))

app = FastAPI(
    title="DEEPGUARD API",
    description="API for detecting AI-generated video and audio content",
    version="2.0.0"
)

# CORS Configuration
app.add_middleware(
    CORSMiddleware,
    allow_origins=[
        "http://localhost:3000",
        "http://localhost:5173",
        "http://localhost:8000",
        "http://127.0.0.1:3000",
        "http://127.0.0.1:5173",
        "http://127.0.0.1:8000",
        "*"  # Allow all origins during development
    ],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
    expose_headers=["*"]
)

# ============================================================================
# IN-MEMORY HISTORY STORAGE
# Note: In production, use a proper database like SQLite, PostgreSQL, etc.
# ============================================================================

_analysis_history: List[dict] = []

# ============================================================================
# Pydantic Models
# ============================================================================

class DetectionResult(BaseModel):
    verdict: Literal["AI_GENERATED", "LIKELY_AI", "AUTHENTIC", "UNCERTAIN"]
    confidence: int = Field(..., ge=1, le=10, description="Confidence score 1-10")
    reasons: List[str]
    video_score: Optional[float] = None
    audio_score: Optional[float] = None
    processing_time: float
    frames_analyzed: Optional[int] = None
    analysis_duration: Optional[float] = None


class HealthResponse(BaseModel):
    status: str
    timestamp: float
    version: str = "2.0.0"


class HistoryItem(BaseModel):
    id: str
    filename: str
    fileSize: int
    fileType: str
    timestamp: str
    verdict: str
    confidence: int
    reasons: List[str]
    videoScore: Optional[float] = None
    audioScore: Optional[float] = None
    processingTime: float
    framesAnalyzed: Optional[int] = None
    analysisDuration: Optional[float] = None
    analysisMode: str


class HistoryResponse(BaseModel):
    items: List[HistoryItem]
    total: int
    limit: int


class ClearHistoryResponse(BaseModel):
    success: bool
    message: str
    cleared_count: int


# ============================================================================
# FILE CONFIGURATION
# ============================================================================

ALLOWED_VIDEO_TYPES = {
    'video/mp4', 'video/avi', 'video/quicktime', 'video/x-matroska',
    'video/webm', 'video/x-msvideo'
}
ALLOWED_AUDIO_TYPES = {
    'audio/mpeg', 'audio/wav', 'audio/aac', 'audio/mp3',
    'audio/x-wav', 'audio/mpeg3'
}
ALLOWED_EXTENSIONS = {'.mp4', '.avi', '.mov', '.mkv', '.mp3', '.wav', '.aac', '.webm'}

MAX_FILE_SIZE = 100 * 1024 * 1024  # 100MB
MAX_HISTORY_ITEMS = 100


# ============================================================================
# FILE VALIDATION
# ============================================================================

def validate_file(file: UploadFile) -> tuple[bool, str]:
    """Validate uploaded file type and size."""
    # Check file size (read content temporarily)
    content = file.file.read()
    file.file.seek(0)  # Reset file pointer

    if len(content) > MAX_FILE_SIZE:
        return False, f"File too large. Maximum size is {MAX_FILE_SIZE // (1024*1024)}MB"

    # Check content type
    content_type = file.content_type or ""
    filename = file.filename or ""
    ext = os.path.splitext(filename)[1].lower()

    is_valid_type = (
        content_type in ALLOWED_VIDEO_TYPES or
        content_type in ALLOWED_AUDIO_TYPES or
        ext in ALLOWED_EXTENSIONS
    )

    if not is_valid_type:
        return False, f"Invalid file type: {content_type or ext}. Allowed: video/*, audio/*"

    return True, ""


# ============================================================================
# ANALYSIS LOGIC
# ============================================================================

def analyze_content(
    file_path: str,
    analyze_video: bool = True,
    analyze_audio: bool = True
) -> DetectionResult:
    """
    Analyze content for AI generation markers.
    This is a placeholder - integrate with actual ML models.
    """
    import random
    import hashlib

    start_time = time.time()

    # TODO: Replace with actual AI detection logic
    # Implement deterministic mock analysis logic based on file contents
    time.sleep(1.2)  # Simulate a realistic processing delay
    
    # Read a chunk from the file to generate a consistent hash seed
    file_hash = 0
    try:
        with open(file_path, "rb") as f:
            chunk = f.read(1024 * 1024)  # Read up to 1MB
            file_hash = int(hashlib.md5(chunk).hexdigest(), 16)
    except Exception:
        file_hash = os.path.getsize(file_path) if os.path.exists(file_path) else 1024

    # Use a local random instance to avoid global state interference
    rng = random.Random(file_hash)
    
    # Generate an "AI probability" score from 1 to 10
    confidence = rng.randint(1, 10)
    
    if confidence >= 9:
        verdict = "AI_GENERATED"
    elif confidence >= 7:
        verdict = "LIKELY_AI"
    elif confidence >= 4:
        verdict = "UNCERTAIN"
    else:
        verdict = "AUTHENTIC"

    # Generate mock reasons based on verdict
    ai_reasons = [
        "Unnatural facial micro-expressions detected",
        "Inconsistent temporal coherence between frames",
        "Audio-visual synchronization anomalies",
        "Artifacts in hair and fine detail rendering",
        "Unnatural eye movement patterns",
        "Skin texture inconsistencies detected",
        "Background blur artifacts typical of GAN generation"
    ]

    authentic_reasons = [
        "Natural facial expressions consistent with human behavior",
        "Consistent lighting and shadows throughout",
        "Realistic motion blur in fast movements",
        "Natural audio-visual synchronization",
        "Consistent skin texture and pores visible",
        "Natural eye reflection patterns"
    ]

    if verdict == "AI_GENERATED":
        reasons = rng.sample(ai_reasons, min(4, len(ai_reasons)))
    elif verdict == "LIKELY_AI":
        reasons = rng.sample(ai_reasons, min(2, len(ai_reasons)))
        reasons.append("Some natural elements present but suspicious")
    elif verdict == "AUTHENTIC":
        reasons = rng.sample(authentic_reasons, min(3, len(authentic_reasons)))
    else:
        reasons = ["Analysis inconclusive - mixed signals detected"]

    processing_time = time.time() - start_time

    return DetectionResult(
        verdict=verdict,
        confidence=confidence,
        reasons=reasons,
        video_score=rng.uniform(0.3, 0.9) if analyze_video else None,
        audio_score=rng.uniform(0.3, 0.9) if analyze_audio else None,
        processing_time=processing_time,
        frames_analyzed=rng.randint(10, 50) if analyze_video else None
    )


# ============================================================================
# API ENDPOINTS - DETECTION
# ============================================================================

@app.post("/detect", response_model=DetectionResult)
async def detect_full(file: UploadFile = File(...)):
    """
    Analyze video with both video frames and audio.
    Returns verdict, confidence score, and reasons.
    """
    is_valid, error_msg = validate_file(file)
    if not is_valid:
        raise HTTPException(status_code=400, detail=error_msg)

    # Save uploaded file temporarily
    suffix = Path(file.filename).suffix
    with tempfile.NamedTemporaryFile(delete=False, suffix=suffix) as tmp_file:
        content = await file.read()
        tmp_file.write(content)
        tmp_path = tmp_file.name

    try:
        result = analyze_content(tmp_path, analyze_video=True, analyze_audio=True)
        return result
    finally:
        # Clean up temporary file
        try:
            os.unlink(tmp_path)
        except:
            pass


@app.post("/detect-video", response_model=DetectionResult)
async def detect_video_only(file: UploadFile = File(...)):
    """
    Analyze video frames only (no audio analysis).
    """
    is_valid, error_msg = validate_file(file)
    if not is_valid:
        raise HTTPException(status_code=400, detail=error_msg)

    suffix = Path(file.filename).suffix
    with tempfile.NamedTemporaryFile(delete=False, suffix=suffix) as tmp_file:
        content = await file.read()
        tmp_file.write(content)
        tmp_path = tmp_file.name

    try:
        result = analyze_content(tmp_path, analyze_video=True, analyze_audio=False)
        return result
    finally:
        try:
            os.unlink(tmp_path)
        except:
            pass


@app.post("/detect-audio", response_model=DetectionResult)
async def detect_audio_only(file: UploadFile = File(...)):
    """
    Analyze audio only.
    """
    is_valid, error_msg = validate_file(file)
    if not is_valid:
        raise HTTPException(status_code=400, detail=error_msg)

    suffix = Path(file.filename).suffix
    with tempfile.NamedTemporaryFile(delete=False, suffix=suffix) as tmp_file:
        content = await file.read()
        tmp_file.write(content)
        tmp_path = tmp_file.name

    try:
        result = analyze_content(tmp_path, analyze_video=False, analyze_audio=True)
        return result
    finally:
        try:
            os.unlink(tmp_path)
        except:
            pass


# ============================================================================
# API ENDPOINTS - HISTORY
# ============================================================================

@app.get("/history", response_model=HistoryResponse)
async def get_history(limit: int = 50):
    """
    Retrieve analysis history.
    Returns the most recent analyses.
    """
    # Return most recent items, limited by 'limit' parameter
    items = _analysis_history[:limit]

    return HistoryResponse(
        items=items,
        total=len(_analysis_history),
        limit=limit
    )


@app.post("/history")
async def add_history_item(item: HistoryItem):
    """
    Add a new analysis result to history.
    Called by the frontend after successful analysis.
    """
    global _analysis_history

    # Add to beginning of list
    _analysis_history.insert(0, item)

    # Keep only MAX_HISTORY_ITEMS
    if len(_analysis_history) > MAX_HISTORY_ITEMS:
        _analysis_history = _analysis_history[:MAX_HISTORY_ITEMS]

    return {"success": True, "message": "History item added"}


@app.post("/history/clear", response_model=ClearHistoryResponse)
async def clear_history():
    """
    Clear all analysis history.
    """
    global _analysis_history

    cleared_count = len(_analysis_history)
    _analysis_history = []

    return ClearHistoryResponse(
        success=True,
        message="History cleared successfully",
        cleared_count=cleared_count
    )


@app.get("/history/{item_id}")
async def get_history_item(item_id: str):
    """
    Retrieve a specific history item by ID.
    """
    for item in _analysis_history:
        if item.get("id") == item_id:
            return item

    raise HTTPException(status_code=404, detail="History item not found")


@app.delete("/history/{item_id}")
async def delete_history_item(item_id: str):
    """
    Delete a specific history item by ID.
    """
    global _analysis_history

    original_len = len(_analysis_history)
    _analysis_history = [item for item in _analysis_history if item.get("id") != item_id]

    if len(_analysis_history) == original_len:
        raise HTTPException(status_code=404, detail="History item not found")

    return {"success": True, "message": "History item deleted"}


# ============================================================================
# API ENDPOINTS - STATUS & HEALTH
# ============================================================================

@app.get("/health", response_model=HealthResponse)
async def health_check():
    """
    Health check endpoint.
    """
    return HealthResponse(
        status="healthy",
        timestamp=time.time(),
        version="2.0.0"
    )


@app.get("/api/status")
async def status():
    """
    Extended status endpoint with API info.
    """
    return {
        "status": "operational",
        "version": "2.0.0",
        "theme": "cyberpunk",
        "features": [
            "video_analysis",
            "audio_analysis",
            "history_tracking",
            "export_reports"
        ],
        "endpoints": [
            {"path": "/detect", "method": "POST", "description": "Full analysis (video + audio)"},
            {"path": "/detect-video", "method": "POST", "description": "Video frames only"},
            {"path": "/detect-audio", "method": "POST", "description": "Audio only"},
            {"path": "/health", "method": "GET", "description": "Health check"},
            {"path": "/history", "method": "GET", "description": "Get analysis history"},
            {"path": "/history", "method": "POST", "description": "Add history item"},
            {"path": "/history/clear", "method": "POST", "description": "Clear all history"}
        ],
        "supported_formats": list(ALLOWED_EXTENSIONS),
        "max_file_size": f"{MAX_FILE_SIZE // (1024*1024)}MB",
        "history_count": len(_analysis_history)
    }


# ============================================================================
# FRONTEND SERVING
# ============================================================================

FRONTEND_DIR = Path(__file__).parent / "frontend"

# Mount static files from the frontend directory
if FRONTEND_DIR.exists():
    app.mount("/static", StaticFiles(directory=str(FRONTEND_DIR), html=True), name="static")

    @app.get("/")
    async def serve_index():
        """Serve the frontend index.html"""
        return FileResponse(str(FRONTEND_DIR / "index.html"))

    @app.get("/{path:path}")
    async def serve_frontend(path: str):
        """Serve frontend files"""
        # API paths should be handled by FastAPI
        if path.startswith("api/") or path in ["docs", "openapi.json", "redoc"]:
            raise HTTPException(status_code=404, detail="Not found")

        file_path = FRONTEND_DIR / path
        if file_path.exists() and file_path.is_file():
            return FileResponse(str(file_path))
        # For SPA routing, return index.html
        return FileResponse(str(FRONTEND_DIR / "index.html"))


# ============================================================================
# MAIN ENTRY POINT
# ============================================================================

if __name__ == "__main__":
    port = int(os.environ.get("PORT", 8000))
    host = os.environ.get("HOST", "0.0.0.0")

    print(f"=" * 60)
    print(f"  DEEPGUARD API - Cyberpunk Edition v2.0")
    print(f"=" * 60)
    print(f"  Server: http://{host}:{port}")
    print(f"  Frontend: http://localhost:{port}/")
    print(f"  API Docs: http://localhost:{port}/docs")
    print(f"  Health: http://localhost:{port}/health")
    print(f"=" * 60)

    uvicorn.run(app, host=host, port=port, reload=False)
