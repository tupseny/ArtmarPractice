package ru.itmotourism;

import ru.itmotourism.tex.TexLoader;
import ru.itmotourism.tex.templates.RepresentationLow;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File tex = TexLoader.TEX_DIR;
        TexLoader.saveFile(TexLoader.TEX_DIR);

        String[] values = {"1", "name", "birth date", "rang", "rang date", "competition", "result", "teachers name"};

        RepresentationLow representationLow = new RepresentationLow(tex, values);
        representationLow.generate();

        TexLoader.createPdfFromTex(representationLow.getTex());
        //TODO: Ошибка доступа
    }
}
