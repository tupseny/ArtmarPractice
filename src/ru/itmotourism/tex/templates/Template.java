package ru.itmotourism.tex.templates;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Template {
    protected void writeToFile(String txt, File file)throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(txt);

        writer.close();
    }
}