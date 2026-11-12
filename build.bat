@echo off
REM Compile and package the game into WordGuessingGame.jar
if not exist out mkdir out
dir /s /b src\*.java > sources.txt
javac -d out @sources.txt
del sources.txt
jar cfm WordGuessingGame.jar MANIFEST.MF -C out .
echo Build successful. Run with: java -jar WordGuessingGame.jar
