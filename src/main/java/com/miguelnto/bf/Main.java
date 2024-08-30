package com.miguelnto.bf;

import java.io.IOException;
import java.util.List;

import com.miguelnto.bf.interpreter.Interpreter;
import com.miguelnto.bf.lexer.Lexer;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("No file specified.");
            return;
        }
        String filepath = args[0];
        Interpreter interpreter = new Interpreter(System.in, System.out, new byte[30000]);
        try {
            char[] code = ProgramReader.readToCharArray(filepath);
            List<Token> tokens = Lexer.tokenize(code);
            interpreter.run(tokens);
            System.out.print("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}