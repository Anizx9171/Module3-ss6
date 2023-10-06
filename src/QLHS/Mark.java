package QLHS;

import java.util.Scanner;

public class Mark {

    private static int count = 1;
    int markId;
    Student student;

    Subject subject;

    double point;

    public Mark() {
        this.markId = Mark.count++;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint() {
        do{
            System.out.println("Nhập điểm");
            this.point = Double.parseDouble(scanner.nextLine());
        }while (this.point > 10 || this.point < 0);
    }
   static Scanner scanner = new Scanner(System.in);
   public void inputData(Student student, Subject subject){
       this.student = student;
       this.subject = subject;
      do{
           System.out.println("Nhập điểm");
           this.point = Double.parseDouble(scanner.nextLine());
       }while (this.point > 10 || this.point < 0);
   }

    public void displayData() {
        System.out.println("Mark{" +
                "markId=" + markId +
                ", Mã học sinh=" + this.student.getStudentId() +
                ", Tên học sinh=" + this.student.getStudentName() +
                ", subject=" + this.subject.getSubjectName() +
                ", point=" + point +
                '}');
    }
}