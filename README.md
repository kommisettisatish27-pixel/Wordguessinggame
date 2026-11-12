# Word Guessing Game (Java)

A console game built for **Object Oriented Programming through Java**.
Guess the hidden Java/OOP word one letter at a time (or the whole word) within 6 wrong attempts.

## Project structure
```
WordGuessingGame/
├── src/com/wordgame/
│   ├── Main.java                         Entry point
│   ├── model/
│   │   ├── Word.java                     Word + hint
│   │   ├── Player.java                   Abstract class
│   │   └── HumanPlayer.java              Inherits Player
│   ├── service/
│   │   ├── Scoring.java                  Interface
│   │   ├── WordBank.java                 Collection of words (ArrayList)
│   │   └── GameRound.java                Game logic (implements Scoring)
│   └── exception/
│       └── InvalidGuessException.java    User-defined exception
├── MANIFEST.MF
├── build.sh / build.bat
├── .gitignore
└── README.md
```

## Requirements
JDK 8 or higher (`javac -version` to check).

## Build and run
Linux / macOS:
```
./build.sh
java -jar WordGuessingGame.jar
```
Windows:
```
build.bat
java -jar WordGuessingGame.jar
```

## Syllabus concepts covered
Classes and objects, constructors, encapsulation, inheritance, abstract class,
interface, polymorphism (method overriding), packages, exception handling
(user-defined), strings, arrays, collections (ArrayList, HashSet).

## Scoring
`score = attemptsLeft * 10 + wordLength`
