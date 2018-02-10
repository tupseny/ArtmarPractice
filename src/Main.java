import ru.itmotourism.tex.TexLoader;
import ru.itmotourism.tex.templates.RepresentationLow;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String[] values = {"1",
                "Имя",
                "31.05.1997",
                "КМС",
                "12.05.2017",
                "Соревнования соревнования соревнования...",
                "1 место",
                "Черкасова М. О."};

        new TexLoader();

        File representation = new File(TexLoader.TEX_DIR.getAbsolutePath() + File.separator + "representationLow.tex");

        RepresentationLow template = new RepresentationLow(representation, values);
        if (!template.generate())
            System.err.println("Can't generate Tex file");

        try {
            TexLoader.createPdfFromTex(template.getTex());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}