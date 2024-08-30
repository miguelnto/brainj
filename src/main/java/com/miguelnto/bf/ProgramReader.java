package com.miguelnto.bf;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProgramReader {
    public static char[] readToCharArray(String filepath) throws IOException {
        String code = new String(Files.readAllBytes(Paths.get(filepath)));
        return code.toCharArray();
    }
}
