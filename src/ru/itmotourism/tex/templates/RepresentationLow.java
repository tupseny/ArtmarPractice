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
    private float c1 = 0.015f;
    private float c2 = 0.13f;
    private float c3 = 0.08f;
    private float c4 = 0.075f;
    private float c5 = 0.07f;
    private float c6 = 0.24f;
    private float c7 = 0.08f;
    private float c8 = 0.1f;
    private int No = 1;
    private String playerName = "Кузьменко";
    private String birthDate = "21.02.1992";
    private String rangName = "КМС";
    private String rangDate = "12.12.2012";
    private String competitionName = "Соревки";
    private String result = "2 place";
    private String teacherName = "Cherkasova";
    private String organisationMaster = "Руководитель";
    private String organisationName = "Организация";
    private String year = "2016";

    public RepresentationLow(File file){
        this.file = file;
    }

    public boolean generate(){
        System.out.println("%-- TEX generating --%");
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
        t.append("\\begin{longtable}{|C{")
                .append(c1).append("\\textwidth}|C{")
                .append(c2).append("\\textwidth}|C{")
                .append(c3).append("\\textwidth}|C{")
                .append(c4).append("\\textwidth}|C{")
                .append(c5).append("\\textwidth}|C{")
                .append(c6).append("\\textwidth}|C{")
                .append(c7).append("\\textwidth}|C{")
                .append(c8).append("\\textwidth}|}\n");
        t.append("\\hline\n");
        t.append("{№}&{Ф.И.О.}&{Дата\\newlineрождения}&{Наличие\\newlineспортивного\\newlineразряда}" +
                "&{Дата\\newlineвыполнения\\newlineразряда}&{Наименование соревнований, место и сроки проведения}" +
                "&{Показанный\\newlineрезультат}&{Ф.И.О. тренера-преподавателя}\\\\\\hline\n");
        t.append("{")
                .append(No).append("}&{")
                .append(playerName).append("}&{")
                .append(birthDate).append("}&{")
                .append(rangName).append("}&{")
                .append(rangDate).append("}&\\multirow{2}{0.24\\textwidth}{")
                .append(competitionName).append("}&{")
                .append(result).append("}&{")
                .append(teacherName).append("}\\\\[5em]\\cline{1-5}\\cline{7-8}\n");
        t.append("\\hline\n" +
                "\\endfoot\n" +
                "\\end{longtable}\n" +
                "\n" +
                "\\renewcommand{\\arraystretch}{1}\n" +
                "\\begin{flushleft}\n" +
                "\\begin{table}[!htbp]\n" +
                "\\hspace{0.08\\textwidth}\n" +
                "\\begin{tabular}{L{0.23\\textwidth}C{0.13\\textwidth}C{0.3\\textwidth}}\n");
        t.append("{").append(organisationMaster).append("}&\\rule{2cm}{0.5pt}&\\rule{4cm}{0.5pt}\\\\\n");
        t.append("&{подпись}&{Ф.И.О.}\\\\\n");
        t.append("{").append(organisationName).append("}&\\rule{0pt}{20pt}{\\rule{2cm}{0.5pt}}" +
                "&\\rule{0pt}{20pt}{\\rule{4cm}{0.5pt}}\\\\\n");
        t.append("&{подпись}&{Ф.И.О.}\\\\\n");
        t.append("\\rule{0pt}{24pt}&&\\\\\n");
        t.append("<<\\rule{0.7cm}{0.5pt}>> \\rule{2.5cm}{0.5pt} ").append(year).append(" год&&\n");
        t.append("\\end{tabular}\n" +
                "\\end{table}\n" +
                "\\end{flushleft}\n" +
                "\\end{document}\n");

        return true;
    }

    public File getTex(){
        try {
            if (file == null){
                System.out.println("Template file is not defined");
            }
            writeToFile(t.toString(), file);
            lock();
            System.out.println("TEX is ready!");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return file;
    }

    private void lock() throws Throwable {
        this.finalize();
    }
}
