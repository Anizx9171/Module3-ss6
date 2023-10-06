package QLHS;

import java.util.Arrays;
import java.util.Scanner;

public class Qlhs {
    static Student[] students = new Student[100];
    static Subject[] subjects = new Subject[100];
    static Mark[] marks = new Mark[100];
    static int index = 0;
    static int indexSub = 0;
    static int indexMark = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    ************************SCHOOL-MANAGEMENT*************************
                    1.	Quản lý học sinh
                    2.	Quản lý môn học
                    3.	Quản lí điểm thi
                    4.	Thoát
                    """);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    quanLiHS();
                    break;
                case 2:
                    quanLiSubject();
                    break;
                case 3:
                    quanLiMark();
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    private static void quanLiMark() {
        while (true) {
            System.out.println("""
                     *********************MARK-MANAGEMENT************************
                    1.Thêm mới điểm thi cho 1 sinh vien
                    2.Hiển thị danh sách tất cả điểm thi theo thứ tự điểm tăng dần
                    3.Thay đổi điểm theo mã id
                    4.Xóa điểm theo mã id
                    5.Hiển thị danh sách điểm thi theo mã môn học
                    6.Hiển thị đánh giá học lực của từng học sinh theo mã môn học.
                    """);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addNewMark();
                    break;
                case 2:
                    showAllMarks();
                    break;
                case 3:
                    UpdateMark();
                    break;
                case 4:
                    deleteMark();
                    break;
                case 5:
                    showMarkBySubjectId();
                    break;
                case 6:
                    showAllEvaluate();
                    break;
                default:
                    return;
            }
        }
    }

    private static void showAllEvaluate() {
        Arrays.sort(marks, 0, indexMark, (b1, b2) -> Float.compare((float) b1.getStudent().getStudentId(), (float) b2.getStudent().getStudentId()));
        System.out.println("Nhap ma mon hoc");
        String maMH = scanner.nextLine();
        for (int j = 0; j < indexSub; j++) {
            if (subjects[j].getSubjectId().equals(maMH)) {
                for (int k = 0; k < indexMark; k++) {
                    if (marks[k].getSubject().getSubjectId().equals(subjects[j].getSubjectId())) {
                        System.out.println("Name: " + marks[k].student.getStudentName() + ", " + "Subject: " + marks[k].subject.getSubjectName() + "evaluate: " + (marks[k].point < 5 ? "yếu" : (marks[k].point < 6.5 ? "Trung bình" : (marks[k].point < 8 ? "Khá" : (marks[k].point < 9 ? "giỏi" : "xuất sắc")))));
                    }
                }
            }
        }
    }


    private static void deleteMark() {
        System.out.println("id mark cần xóa");
        int idDel = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < indexMark; i++) {
            if (marks[i].markId == idDel) {
                for (int j = i; j < indexMark; j++) {
                    marks[j] = marks[j + 1];
                }
                System.out.println("Xóa thành công");
                indexMark--;
                return;
            }
        }
    }

    private static void showMarkBySubjectId() {
        System.out.println("Nhập id môn học");
        String idS = scanner.nextLine();
        for (int i = 0; i < indexSub; i++) {
            if (subjects[i].getSubjectId().equals(idS)) {
                for (int j = 0; j < indexMark; j++) {
                    if (subjects[j].getSubjectId().equals(marks[i].getSubject().getSubjectId())) {
                        marks[i].displayData();
                    }
                }
            }
        }
    }

    private static void UpdateMark() {
        System.out.println("id mark cần sửa");
        int idE = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < indexMark; i++) {
            if (marks[i].markId == idE) {
                marks[i].displayData();
                System.out.println("Nhập điểm muốn sửa");
                marks[i].setPoint();
                System.out.println("Sửa thành công");
                return;
            }
        }
    }

    private static void showAllMarks() {
        Arrays.sort(marks, 0, indexMark, (b1, b2) -> Float.compare((float) b1.getPoint(), (float) b2.getPoint()));
        for (int i = 0; i < indexMark; i++) {
            marks[i].displayData();
        }
    }

    private static Mark addNewMark() {
        Student student = new Student();
        Subject subject = new Subject();
        String idObject;
        while (true) {
            System.out.println("Nhập id học sinh");
            int idHs = Integer.parseInt(scanner.nextLine());
            boolean flag = false;
            for (int i = 0; i < index; i++) {
                if (students[i].getStudentId() == idHs) {
                    student = students[i];
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        ;

        while (true) {
            System.out.println("Nhập id môn học");
            String idSj = scanner.nextLine();
            boolean flag = false;
            for (int i = 0; i < indexSub; i++) {
                if (subjects[i].getSubjectId().equals(idSj)) {
                    subject = subjects[i];
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        ;
        Mark mark = new Mark();
        mark.inputData(student, subject);
        marks[indexMark++] = mark;
        return mark;
    }

    private static void quanLiSubject() {
        while (true) {
            System.out.println("""
                    **********************SUBJECT-MANAGEMENT*************************
                    1.Thêm mới môn học
                    2.Hiển thị danh sách tất cả môn học đã lưu trữ
                    3.Thay đổi thông tin học môn học theo mã id
                    4.Xóa môn học theo mã id (kiểm tra nếu môn học  có điểm thi thì không xóa được
                    5.Thoát
                    """);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addNewSubject();
                    break;
                case 2:
                    showAllSubject();
                    break;
                case 3:
                    updateSubject();
                case 4:
                    deleteSubject();
                case 5:
                    return;
                default:
                    break;
            }
        }
    }

    private static void deleteSubject() {
        System.out.println("Nhập id môn học");
        String idEdit = scanner.nextLine();
        for (int i = 0; i < indexSub; i++) {
            if (subjects[i].getSubjectId().equals(idEdit)) {
                for (int j = i; j < indexSub; j++) {
                    subjects[j] = subjects[j + 1];
                }
                System.out.println("Cập nhật thành công");
                indexSub--;
                return;
            }
        }
        System.out.println("Không tìm thấy môn học có id: " + idEdit);
    }

    private static void updateSubject() {
        System.out.println("Nhập id môn học");
        String idEdit = scanner.nextLine();
        for (int i = 0; i < indexSub; i++) {
            if (subjects[i].getSubjectId().equals(idEdit)) {
                subjects[i].inputData();
                System.out.println("Cập nhật thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy môn học có id: " + idEdit);
    }

    private static void showAllSubject() {
        for (int i = 0; i < indexSub; i++) {
            subjects[i].displayData();
        }
    }


    private static void addNewSubject() {
        Subject subject = new Subject();
        subject.inputData();
        subjects[indexSub++] = subject;
    }

    private static void quanLiHS() {
        while (true) {
            System.out.println("""
                    **********************STUDENT-MANAGEMENT************************
                    1.Thêm mới học sinh
                    2.Hiển thị danh sách tất cả học sinh đã lưu trữ
                    3.Thay đổi thông tin học sinh theo mã id
                    4.Xóa học sinh theo mã id (kiểm tra xem nếu sinh viên có điểm thi thì không xóa được)
                    5.Thoát
                    """);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    showAllStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    return;
                default:
                    break;
            }
        }
    }

    private static void deleteStudent() {
        System.out.println("Nhập id học sinh cần xóa");
        int idDelete = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < index; i++) {
            if (students[i].getStudentId() == idDelete) {
                for (int j = i; j < index; j++) {
                    students[j] = students[j + 1];
                }
                System.out.println("Xóa thành công");
                index--;
                return;
            }
        }
        System.out.println("Không tìm thấy học sinh có id: " + idDelete);
    }


    private static void updateStudent() {
        System.out.println("Nhập id học sinh cần sửa");
        int idEdit = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < index; i++) {
            if (students[i].getStudentId() == idEdit) {
                students[i].inputData(students, index);
                System.out.println("Cập nhật thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy học sinh có id: " + idEdit);
    }

    private static void showAllStudent() {
        System.out.println("-----Danh sách học sinh------");
        for (int i = 0; i < index; i++) {
            students[i].displayData();
        }
    }

    private static void addNewStudent() {
        Student student = new Student();
        student.inputData(students, index);
        students[index++] = student;
    }
}
