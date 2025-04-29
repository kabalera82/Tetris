# 🎮 Simple Tetris — Java Edition

A fun and lightweight Tetris clone crafted in pure Java using `Swing`. Built for learning and nostalgic enjoyment! 👾

---

## ✨ Highlights
- Smooth 2D gameplay with pixel-perfect piece movement.
- 7 classic tetromino shapes, each with individual rotation logic.
- Progressive difficulty: speeds up as you clear more lines.
- Pause/resume support and a satisfying "Game Over" screen.
- Fully playable using keyboard inputs.
- Background music and retro sound effects 🎵

---

## 🧠 How It's Made
This project uses an object-oriented approach where each Tetris piece ("mino") is its own class:

- `Mino.java`: Abstract base class defining shared behavior (movement, rotation, collisions).
- Individual pieces like `Mino_L1`, `Mino_T`, etc., extend from `Mino` and implement custom rotations.
- `Block.java`: Represents individual colored squares making up a mino.
- `PlayManager.java`: Central brain controlling gameplay, scoring, piece generation, and line clearing.
- `GamePanel.java`: Main canvas that handles drawing and the game loop using a separate thread.
- `KeyHandler.java`: Captures keyboard input to control the gameplay.
- `Main.java`: Entry point that creates the game window and starts everything up.

The game loop runs at 60 FPS and automatically drops pieces every few frames. As the level increases, drop speed ramps up. All interactions (collisions, movement, rotations) are manually handled via grid math.

---

## 🚀 Getting Started

1. Install **Java 8** or later.
2. Compile the game:
```bash
javac kabaDev/**/*.java
```
3. Launch it:
```bash
java kabaDev.Main
```

Enjoy your retro-style fun! 🧱

---

## 🎮 Controls
- 🔼 **Arrow Up**: Rotate
- 🔽 **Arrow Down**: Soft drop
- ◀️ **Arrow Left**: Move left
- ▶️ **Arrow Right**: Move right
- ␣ **Spacebar**: Pause / Resume

---

## 📁 Folder Overview
```
kabaDev/
├── Main.java           # Game launcher
├── GamePanel.java      # Game loop & rendering
├── KeyHandler.java     # Input management
├── PlayManager.java    # Game logic and scoring
└── mino/               # Tetromino classes (L, T, Z, etc)
```

---

## 👤 Author
Made with ❤️ by **Marcos Padilla**

---

🧩 This is just the beginning! Try adding new features like:
- "Hold" functionality
- Hard Drop (instant fall)
- Ghost piece preview
- Scoreboards and themes

Happy coding and may your tetrominoes fall in your favor! 🌟

Special thank to the Tutorial Guide of RyiSnow

https://www.youtube.com/watch?v=N1ktYfszqnM
