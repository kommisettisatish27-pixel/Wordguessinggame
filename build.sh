#!/bin/sh
# Compile and package the game into WordGuessingGame.jar
set -e
mkdir -p out
javac -d out $(find src -name "*.java")
jar cfm WordGuessingGame.jar MANIFEST.MF -C out .
echo "Build successful. Run with: java -jar WordGuessingGame.jar"
