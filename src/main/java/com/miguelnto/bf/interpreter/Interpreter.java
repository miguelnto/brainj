package com.miguelnto.bf.interpreter;

import com.miguelnto.bf.Token;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

public class Interpreter {
    private final byte[] bfArray;
    private final InputStream in;
    private final PrintStream out;
    private int dataPointer;
    private int instructionPointer;

    public Interpreter(InputStream in, PrintStream out, byte[] bfArray) {
        this.in = in;
        this.out = out;
        this.bfArray = bfArray;
        this.dataPointer = 0;
        this.instructionPointer = 0;
    }

    public void run(List<Token> tokens) throws IllegalArgumentException, IOException {
        
        while (instructionPointer < tokens.size()) {
            Token token = tokens.get(instructionPointer);

            switch (token) {
                case INCREMENT_DP:
                    incrementDP();
                    break;
                case DECREMENT_DP:
                    decrementDP();
                    break;
                case INCREMENT:
                    incrementByte();
                    break;
                case DECREMENT:
                    decrementByte();
                    break;
                case PRINT:
                    printChar();
                    break;
                case READ:
                    readChar();
                    break;
                case JUMP_IF_ZERO:
                    if (bfArray[dataPointer] == 0) {
                        int i = 1;
                        while (i > 0) {
                            Token nextToken = tokens.get(++instructionPointer);
                            if (nextToken == Token.JUMP_IF_ZERO) {
                                i++;
                            } else if (nextToken == Token.JUMP_IF_NONZERO) {
                                i--;
                            }
                        }
                    }
                    break;
                case JUMP_IF_NONZERO:
                    int i = 1;
                    while (i > 0) {
                        Token previousToken = tokens.get(--instructionPointer);
                        if (previousToken == Token.JUMP_IF_ZERO) {
                            i--;
                        } else if (previousToken == Token.JUMP_IF_NONZERO) {
                            i++;
                        }
                    }
                    instructionPointer--;
                    break;
            }
            instructionPointer++;
        }
    }

    int getDataPointer() {
        return dataPointer;
    }

    private void incrementDP() {
        dataPointer++;
    }

    private void decrementDP() {
        dataPointer--;
    }

    private byte readByte() {
        return bfArray[dataPointer];
    }

    private void writeByte(byte value) {
        bfArray[dataPointer] = (byte)value;
    }

    private void incrementByte() {
        //bfArray[dataPointer] += value;
        bfArray[dataPointer]++;
    }

    private void decrementByte() {
        bfArray[dataPointer]--;
        //bfArray[dataPointer] -= value;
    }

    private void printChar() {
        out.print((char) readByte());
    }

    private void readChar() throws IOException {
        int read = in.read();
        if (read != -1) {
            writeByte((byte) read);
        }
    }

}
