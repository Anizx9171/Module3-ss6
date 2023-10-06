package QLHS;

import java.util.Scanner;

public class Subject {
   private String subjectId;

   private String subjectName;

    public Subject() {
        this.subjectId = "MH" + (Math.round(Math.random()+899) + 100);
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    Scanner scanner = new Scanner(System.in);
    public void inputData() {
        do {
            System.out.println("Nhập tên Subject");
            this.subjectName = scanner.nextLine();
        } while (this.subjectName.isEmpty());
    }
    public void displayData() {
        System.out.println( "Subject{" +
                "subjectId= '" + subjectId + '\'' +
                ", subjectName= '" + subjectName + '\'' +
                '}');
    }
}
