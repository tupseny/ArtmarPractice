import de.nixosoft.jlr.JLRConverter;
import de.nixosoft.jlr.JLRGenerator;
import de.nixosoft.jlr.JLROpener;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File pdfLaTeX = new File("C:\\Program Files\\MiKTeX 2.9\\miktex\\bin\\x64\\pdflatex.exe");

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

        //Where pdf files are located
        File out = new File(System.getProperty("user.dir") + File.separator + "TeX/out");
        if (!out.isDirectory()) out.mkdir();

        //temp variables (delete in future!)
        String name1 = "Martin";
        String name2 = "Arthur";


        //replacing and parsing
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

            //Generating pdf files
            //create pdf generator
            JLRGenerator pdfGen = new JLRGenerator();

            //generate pdf file from complete .tex file
            if (!pdfGen.generate(pdfLaTeX, 3, finish1, out, workingDirectory)) System.out.println(pdfGen.getErrorMessage());

            //get pdf file
            File pdf1 = pdfGen.getPDF();

            //debug
            //open pdf file
            JLROpener.open(pdf1);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }


    }
}
