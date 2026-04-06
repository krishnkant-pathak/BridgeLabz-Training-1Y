#!/bin/bash
echo "Starting AI Detection Server..."
echo ""
echo "Frontend will be available at: http://localhost:8000"
echo "API Documentation: http://localhost:8000/docs"
echo ""
cd "$(dirname "$0")"
python main.py
