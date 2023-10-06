package QLHS;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Student {
    static int count = 1;
    private int studentId;
    private String studentName;
    private String birthDay;
    private String address;

    boolean gender;
    String phone;

    public Student() {
        this.studentId = Student.count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Student.count = count;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    Scanner scanner = new Scanner(System.in);
    public void inputData(Student[] students, int index) {
        System.out.println("---------------Thêm mới học sinh---------------");
        while (true){
            System.out.println("Nhập tên học sinh");
            this.studentName = scanner.nextLine();
            if (!this.studentName.isEmpty()){
                break;
            }
        }

        System.out.println("Ngày tháng năm sinh");
        this.birthDay = scanner.nextLine();

        while (true){
            System.out.println("Nhập địa chỉ");
            this.address = scanner.nextLine();
            if (!this.address.isEmpty()){
                break;
            }
        }

        System.out.println("""
                Nhập giới tính
                1. Nam
                2. Nữ
                """);
        this.gender = Integer.parseInt(scanner.nextLine()) == 1 ? true : false;

        while (true){
           String regex = "^0\\d{9,10}$";
            System.out.println("Nhập số điện thoại");
            this.phone = scanner.nextLine();
            if (this.phone.matches(regex)){
                boolean check = true;
                for (int i = 0; i < index; i++) {
                    if (students[i].getPhone().equals(this.phone)){
                        System.out.println("Số điện thoại đã tồn tại");
                        check = false;
                        break;
                    }
                }
                if (check){
                    break;
                }
            }else{
                System.out.println("Số điện thoại không hợp lệ");
            }
        }
        System.out.println("Thêm mới thành công");
    }
    public void displayData(){
        System.out.println("studentId: "+ this.studentId +"; \n"
        + "studentName: " + this.studentName+ "; \n"
        + "birthDay: " + this.birthDay + "; \n"
        + "gender: " + (this.gender?"nam":"nu") + "; \n"
        +"address: " + this.address);
    }
}
