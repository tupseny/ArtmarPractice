package ru.itmotourism.tex;

import java.io.File;

public class TexLoader {
    public static final File TEX_DIR = new File(System.getProperty("user.dir")
            + File.separator + "res" + File.separator + "TeX");
    public static final File PDF_LATEX = new File(TEX_DIR.getAbsolutePath() + File.separator + "bin"
            + File.separator + "pdflatex.exe");
    public static final File TEMPLATE_DIR = new File(TEX_DIR.getAbsolutePath() + File.separator + "templates");

    static {
        System.out.println("Static block loaded!");

        if (!TEX_DIR.isDirectory()) {
            if (!TEX_DIR.mkdir()) System.err.println("Can't create new directory! (" + TEX_DIR.getAbsolutePath() + ")");
        }
        if (!TEMPLATE_DIR.isDirectory()) {
            if (!TEMPLATE_DIR.mkdir()) System.err.println("Can't create new directory! (" + TEMPLATE_DIR.getAbsolutePath() + ")");
        }
    }


}