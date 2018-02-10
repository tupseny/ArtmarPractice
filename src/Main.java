import ru.itmotourism.tex.TexLoader;
import ru.itmotourism.tex.templates.RepresentationLow;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        new TexLoader();

        File repres = new File(TexLoader.TEX_DIR.getAbsolutePath() + File.separator + "representationLow.tex");

        RepresentationLow template = new RepresentationLow(repres);
        template.generate();
        try {
            TexLoader.createPdfFromTex(template.getTex());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
