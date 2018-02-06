import de.nixosoft.jlr.JLRConverter;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //temp variables (delete in future!)
        String name1 = "Martin";
        String name2 = "Arthur";

        //Directory where tex TEMPLATES are located
        File workingDirectory = new File(System.getProperty("user.dir") + File.separator + "TeX/");

        //Directory where tex FINISHED files are located
        File tempDir = new File(workingDirectory.getAbsolutePath() + File.separator + "temp");
        if (!tempDir.isDirectory()) tempDir.mkdir();

        //Tex template files
        File template1 = new File(workingDirectory.getAbsolutePath() + File.separator + "test1.tex");

        //Tex finished files
        File finish1 = new File(tempDir.getAbsolutePath() + File.separator + "finish1.tex");
        File finish2 = new File(tempDir.getAbsolutePath() + File.separator + "finish2.tex");

        try {
            //init converter that will work with .tex files
            //link it with directory with .tex templates
            JLRConverter converter = new JLRConverter(workingDirectory);

            //begin replacing variables in .tex templates
            converter.replace("name", name1);

            //parse template with replaced variables
            converter.parse(template1, finish1);

            //parse template but with another value
            converter.replace("name", name2);
            converter. parse(template1, finish2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
