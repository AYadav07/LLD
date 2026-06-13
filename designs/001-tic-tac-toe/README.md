# Tic-Tac-Toe — Design & Implementation

This folder contains a low-level design and a reference Java implementation of a Tic-Tac-Toe game.

Contents
- diagrams/: UML diagrams for the design
- src/: Java source code for the implementation

Diagrams
- UML (editable): diagrams/tic-tac-toe-uml.drawio
- UML (PNG/JPG): diagrams/tic-tac-toe-uml.jpg

Quick overview

This implementation provides a simple console-based Tic-Tac-Toe for two players (configurable for multi-player in the design). The entry point is `src/TicTacToe.java`. The code is organized into packages under `tictactoe`:

- `tictactoe.entity` — core domain objects: `Board`, `Game`, `Player`, `Symbol`, `GAMETYPE`
- `tictactoe.service` — rules for the game: `TicTacToeRules` (interface) and `StdTicTacToeRules` (standard 3x3 rules)
- `tictactoe.config` — `GameFactory` that wires up a `Game` instance and creates players at runtime

Design highlights

- Single responsibility: Board handles storage & rendering; Game orchestrates gameplay; Rules encapsulate win/draw/validation logic
- Rules are pluggable via `TicTacToeRules` so variant rule-sets (e.g., larger boards, different win conditions) can be added
- `GameFactory` demonstrates a simple configuration/factory for two-player (interactive) setup

Files of interest

- `src/TicTacToe.java` — application entry point (runs `GameFactory.createGame(...).startGame()`)
- `src/tictactoe/config/GameFactory.java` — prompts for player names and symbols; builds `Game` with `StdTicTacToeRules`
- `src/tictactoe/entity/Board.java` — board storage and print/reset helpers
- `src/tictactoe/entity/Game.java` — main game loop: input parsing, invoking rules, tracking scores, replay
- `src/tictactoe/service/StdTicTacToeRules.java` — standard implementation of win/draw/validation

How to build & run (command-line)

From the workspace root (project root `LLD`) you can compile and run the game using the JDK:

```bash
# compile
javac -d out $(find designs/001-tic-tac-toe/src -name "*.java")

# run (main class is in the default package)
java -cp out TicTacToe
```

Notes and assumptions

- The current implementation uses console input (Scanner) and expects rows/cols indexed from 0 to 2 (for a 3x3 board). Example move: `0 0` for top-left.
- `GameFactory` reads player names and their chosen single-character symbols from stdin at startup.
- `StdTicTacToeRules` assumes equality by `Symbol` instance used for each player; equality checks rely on object equality of the `Symbol` reference assigned to the player (the code compares objects directly). For clarity, `Symbol.getValue()` returns the char mark and the board prints the char.
- `Game` supports replaying the same session (scores are kept across rounds) and announces winner(s) by score when the players stop.

Extending the implementation

- Add AI player(s) by implementing a Player subclass or providing move-decider strategy objects
- Support variable board sizes and dynamic win-length configuration (e.g., 4-in-a-row on 6x6)
- Replace console I/O with a GUI or REST API layer for richer UX

If you'd like, I can:

- add a small script to build & run the game
- add unit tests for `StdTicTacToeRules`
- change comparisons in `StdTicTacToeRules` to compare `Symbol.getValue()` (char) instead of object references for robustness

Diagrams
Open the editable diagram at `diagrams/tic-tac-toe-uml.drawio` or view `diagrams/tic-tac-toe-uml.jpg` for the class diagram and flow.

---
Last updated: 2026-06-13

