package ru.itmotourism;

import tex.TexLoader;
import tex.templates.RepresentationLow;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        File pdflatex = new File(System.getenv("ProgramFiles(x86)")
                + File.separator + "MiKTeX 2.9"
                + File.separator + "miktex"
                + File.separator + "bin"
                + File.separator + "pdflatex.exe");

        if (args.length > 0){
            pdflatex = new File(args[0]);
        }

        try {
            TexLoader.setPdfLatex(pdflatex);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return;
        }

        //Sets resource directory
        TexLoader.setResDir(new File(System.getProperty("user.dir") + File.separator + "res"));

        RepresentationLow pattern = new RepresentationLow();

        //add person to document
        pattern.add(RepresentationLow.EXAMPLE_ARRAY);

        //generate TeX document
        pattern.generate();

        //generate PDF from TeX (saves it in output directory)
        //TexLoader.OUT_DIR.getAbsolutePath(); //get output directory
        TexLoader.createPdfFromTex(pattern.getTex());
    }
}
