package com.miguelnto.bf;

public enum Token {
    
    INCREMENT_DP('>'),
    DECREMENT_DP('<'),
    INCREMENT('+'),
    DECREMENT('-'),

    PRINT('.'),
    READ(','),
    JUMP_IF_ZERO('['),
    JUMP_IF_NONZERO(']');


    public final char token;

    Token(char token) {
        this.token = token;
    }
}
