package com.miguelnto.bf.lexer;

import java.util.ArrayList;
import java.util.List;

import com.miguelnto.bf.Token;

public class Lexer {

    public static List<Token> tokenize(char[] chars) {
        List<Token> tokens = new ArrayList<>();
        int instructionPointer = 0;

        while (instructionPointer < chars.length) {
            switch (chars[instructionPointer]) {
                case '<':
                    tokens.add(Token.DECREMENT_DP);
                    break;
                case '>':
                    tokens.add(Token.INCREMENT_DP);
                    break;
                case '+':
                    tokens.add(Token.INCREMENT);
                    break;
                case '-':
                    tokens.add(Token.DECREMENT);
                    break;
                case '.':
                    tokens.add(Token.PRINT);
                    break;
                case ',':
                    tokens.add(Token.READ);
                    break;
                case '[':
                    tokens.add(Token.JUMP_IF_ZERO);
                    break;
                case ']':
                    tokens.add(Token.JUMP_IF_NONZERO);
                    break;
            }
            instructionPointer++;
        }

        return tokens;
    }

}
