package ru.itmotourism.tex.templates;

import java.io.File;
import java.io.IOException;

public class RepresentationLow extends Template{
    private StringBuilder t = new StringBuilder();
    private File file;
    private String title1 = "ПРЕДСТАВЛЕНИЕ";
    private String title2 = "на присвоение (подтверждение),юношеских спортивных разрядов, I спортивного разряда, II спортивного разряда, III спортивного разряда";
    private String title3 = "Региональная спортивная федерация спортивного туризма,Санкт-Петербурга";
    private String title4 = "Спортивный туризм";

    public RepresentationLow(File file){
        this.file = file;
    }

    public boolean generate(){
        t.append("\\documentclass[a4paper, landscape]{article}\n" +
                "\\usepackage[utf8]{inputenc}\n" +
                "\\usepackage[russian]{babel}\n" +
                "\\usepackage[a4paper,landscape]{geometry}\n" +
                "\\usepackage[normalem]{ulem}\n" +
                "\\usepackage{calc}\n" +
                "\\usepackage{array}\n" +
                "\\usepackage{multirow}\n" +
                "\\usepackage{longtable}\n" +
                "\\newcolumntype{L}[1]{>{\\raggedright\\let\\newline\\\\\\arraybackslash\\hspace{0pt}}m{#1}}\n" +
                "\\newcolumntype{C}[1]{>{\\centering\\let\\newline\\\\\\arraybackslash\\hspace{0pt}}m{#1}}\n" +
                "\\newcolumntype{R}[1]{>{\\raggedleft\\let\\newline\\\\\\arraybackslash\\hspace{0pt}}m{#1}}\n" +
                "\\useunder{\\uline}{\\ul}{}\n" +
                "\\textwidth = 800pt\n" +
                "\\hoffset = -105pt\n" +
                "\\thispagestyle{empty}\n");
        t.append("\\begin{document}\n");
        t.append("\\centering\\section*{\\textbf{").append(title1).append("}\\\\}\n");
        t.append("\\renewcommand{\\arraystretch}{1.5}\n" +
                "\\begin{table}[h]\n" +
                "\\centering\n" +
                "\\begin{tabular}{ll}\n");
        t.append("\\multicolumn{2}{c}{").append(title2).append("}\\\\\n");
        t.append("\\cline{1-2}\n");
        t.append("& {").append(title3).append("}\\\\\n");
        t.append("\\cline{2-2}\n");
        t.append("{по виду спорта} & {").append(title4).append("}\\\\\n");
        t.append("\\cline{2-2}\n" +
                "\\end{tabular}\n" +
                "\\end{table}\n" +
                "\\centering\n");

        System.out.println("Template has been generated");
        return true;
    }

    public boolean complete(){
        try {
            if (file == null){
                System.out.println("Template file is not defined");
                return false;
            }
            writeToFile(t.toString(), file);
            this.finalize();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return true;
    }
}
