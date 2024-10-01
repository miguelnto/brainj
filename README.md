# BrainJ

A Brainf interpreter written in Java.

Most of my inspiration when I was writing this actually came from resources available on the original [Brainf*ck Website.](https://brainfuck.org/)

## TODO

- [ ] I still need to make more tests, as there are probably some programs in standard Brainf*ck that doesn't work well with this implementation.
- [ ] Create a compiler
  - [ ] That compiles to Java Bytecode
  - [ ] That compiles to native machine code
- [ ] Make this implementation embeddable so you can execute Brainf*ck programs inside another app.

## Usage

You can build and run the interpreter like any other Maven project:

```
mvn package
java -jar target/bf.jar <program name>.b
```

## Tests

The following programs were tested successfully:

- [Conway's Game of Life](https://brainfuck.org/life.b) (life.b)
- [Number prettifier](https://brainfuck.org/numwarp.png) (numwarp.b)
- [TicTacToe](https://brainfuck.org/tictactoe.b) (tictactoe.b)
- [Sierpiński triangle](https://brainfuck.org/sierpinski.b) (sierpinski.b)

These all came from the [Brainf*ck Website.](https://brainfuck.org/).

## Resources

- [An introduction to Brainf*ck by roachhd](https://gist.github.com/roachhd/dce54bec8ba55fb17d3a)
- [Wikipedia Article](https://en.wikipedia.org/wiki/Brainfuck)

