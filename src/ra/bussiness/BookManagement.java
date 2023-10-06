package ra.bussiness;

import java.util.*;

public class BookManagement {
    static Scanner scanner = new Scanner(System.in);
    static Book[] books = new Book[100];
    static int index = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                           ****************MENU***************
                     1. Thêm mới
                     2.	Hiển thị thông tin tất cả sách trong thư viện
                     3. Thay đổi thông tin sách theo mã sách
                     4.	Xóa sách theo mã sách
                     5.	Sắp xếp sách theo lợi nhuận tăng dần
                     6.	Tìm kiếm tương đối sách theo tên sách hoặc mô tả
                     7.	Nhập sách
                     8. Bán sách
                     9.	Thoát
                     """);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    addNewBook();
                    break;
                case 2:
                    showAllBooks();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    sortBooks();
                    break;
                case 6:
                    findBook();
                    break;
                case 7:
                    buyLargeBook();
                    break;
                case 8:
                    buyBook();
                    break;
                default:
                    System.out.println("Thoát thành công");
                    System.exit(0);
                    break;
            }
        }
    }

    public static void buyBook(){
        System.out.println("Nhập id sách muốn mua");
        int idBookBuy = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < index; i++){
            if (idBookBuy == books[i].getBookId()){
                if (books[i].getBookStatus()){
                    books[i].setQuantity(books[i].getQuantity() - 1);
                    if (books[i].getQuantity() < 1) {
                        books[i].setBookStatus(false);
                    }
                }else{
                    System.out.println("Sách đã hết hàng");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy sách bạn muốn mua");
    }

    public static void buyLargeBook() {
        System.out.println("Nhập id sách muốn mua");
        int idBo = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < index; i++) {
            if (books[i].getBookId() == idBo) {
                if (idBo == books[i].getBookId()){
                    System.out.println("Nhập số lượng sách muốn mua");
                    int quanti = Integer.parseInt(scanner.nextLine());
                    if (quanti <= books[i].getQuantity()) {
                        books[i].setQuantity(books[i].getQuantity() - quanti);
                        if (books[i].getQuantity() < 1) {
                            books[i].setBookStatus(false);
                        }
                        System.out.println("Mua thành công");
                    } else {
                        System.out.println("Số lượng không đủ");
                    }
                    return;
                }else{
                    System.out.println("Sách đã hết hàng");
                }
            }
        }
        System.out.println("Không tìm thấy sách bạn muốn nhập");
    }

    private static void findBook() {
        System.out.println("Nhập tên hoặc mô tả về sách");
        String searchValue = scanner.nextLine();
        System.out.println("Kết quả tìm kiếm:");
        boolean check = false;
        for (int i = 0; i < index; i++) {
            if (books[i].getBookName().contains(searchValue.trim()) || books[i].getDescriptions().contains(searchValue.trim())) {
                books[i].displayData();
                System.out.println();
                check = true;
            }
        }
        if (!check){
            System.out.println("Không có cuốn sách nào khớp vời thông tin bạn tìm kiếm");
        }
    }

    private static void sortBooks() {
        Arrays.sort(books, Comparator.comparing(Book::getInterest));
        System.out.println("Đã sắp xếp");
    }

    private static void deleteBook() {
        System.out.println("Nhập id sách muốn xóa");
        int idDelete = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < index; i++) {
            if (idDelete == books[i].getBookId()){
                for (int j = i; j < index; j++) {
                    books[j] = books[j+1];
                }
                System.out.println("Xóa thành công");
                index--;
                return;
            }
        }
        System.out.println("Không tìm thấy sách có id: " + idDelete);
    }

    private static void updateBook() {
        System.out.println("Nhập id sách muốn sửa");
        int idEdit = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < index; i++) {
            if (idEdit == books[i].getBookId()){
                books[i].inputData();
                System.out.println("Cập nhật thông tin thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy sách có id: " + idEdit);
    }

    private static void showAllBooks() {
        for (int i = 0; i < index; i++) {
            books[i].displayData();
            System.out.println();
        }
    }

    private static void addNewBook() {
        Book book = new Book();
        book.inputData();
        books[index++] = book;
        System.out.println("Thêm sách thành công");
    }

}
