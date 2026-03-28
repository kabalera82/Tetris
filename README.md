# Tetris — Java Edition

A Tetris clone written in Java using Swing/AWT. Features classic gameplay mechanics, keyboard controls, progressive difficulty, and sound effects.

## Overview

Pure Java Tetris implementation with a custom game loop running at 60 FPS, 7 tetromino piece types, line-clearing logic, and progressive speed increase as levels go up. Each piece is its own class extending a shared `Mino` abstract base.

## Tech Stack

![Java](https://img.shields.io/badge/Java_24-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apachemaven&logoColor=white)

- Java 24 (compatible with Java 8+)
- Swing / AWT for rendering
- Maven build system

## Features

- 7 classic tetromino shapes with individual rotation logic
- 60 FPS game loop via a dedicated thread
- Progressive difficulty — drop speed increases with each level
- Background music and retro sound effects
- Pause / resume support
- Game Over screen with final score

## Controls

| Key | Action |
|-----|--------|
| Arrow Up | Rotate piece |
| Arrow Down | Soft drop |
| Arrow Left | Move left |
| Arrow Right | Move right |
| Spacebar | Pause / Resume |

## Project Structure

```
src/main/java/kabaDev/
├── Main.java           # Entry point — creates the game window
├── GamePanel.java      # Game loop and rendering canvas
├── KeyHandler.java     # Keyboard input handling
├── PlayManager.java    # Game logic: scoring, line clearing, piece management
├── mino/               # Tetromino classes (L, T, Z, S, I, O, J)
└── sound/              # Audio resource loader and playback
```

## Getting Started

```bash
mvn clean package
java -cp target/Tetris-1.0-SNAPSHOT.jar kabaDev.Main
```

Or compile and run directly:

```bash
javac -sourcepath src/main/java src/main/java/kabaDev/Main.java -d out
java -cp out kabaDev.Main
```

## Notes

Project developed following the tutorial by [RyiSnow](https://www.youtube.com/watch?v=N1ktYfszqnM) as a learning exercise for Java game development with Swing.

## Author

Marcos Padilla — [github.com/kabalera82](https://github.com/kabalera82)
