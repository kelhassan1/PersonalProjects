#!/bin/bash

# Prompt the user for commit message
read -p "Enter commit message: " commit_message

# Add all files
git add .

# Commit with the provided message
git commit -m "$commit_message"

# Push to the remote repository
git push
