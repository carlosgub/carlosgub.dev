#!/bin/bash
# Script to export the Kobweb project as a static website

# Get the directory of the script
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
PROJECT_ROOT="$DIR/../../../../"

echo "Navigating to project root: $PROJECT_ROOT"
cd "$PROJECT_ROOT/site" || exit 1

echo "Running kobweb export..."
kobweb export --notty

if [ $? -eq 0 ]; then
    echo "Static site exported successfully to site/.kobweb/site/"
else
    echo "Error: static site export failed."
    exit 1
fi
