package ra.bussiness;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private int quantity;
    private boolean bookStatus = true;
    public Scanner scanner = new Scanner(System.in);

    public DecimalFormat formatter = new DecimalFormat("###,###,###");

    public Book() {
        this.bookId = (int) (Math.round(Math.random() * 8999999) + 1000000);
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = (float) interest;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData() {
        System.out.println("-------------Thêm sách-------------");

        while (true) {
            System.out.println("Nhập tên sách");
            String name = scanner.nextLine();
            if (name.trim().length() > 1) {
                this.bookName = name;
                break;
            }
            System.out.println("Không được để trống");
        }

        while (true) {
            System.out.println("Nhập tên tác giả");
            String name = scanner.nextLine();
            if (name.trim().length() > 1) {
                this.author = name;
                break;
            }
            System.out.println("Không được để trống");
        }

        while (true) {
            System.out.println("Nhập mô tả");
            String name = scanner.nextLine();
            if (name.trim().length() > 9) {
                this.descriptions = name;
                break;
            }
            System.out.println("ít nhất 10 kí tự");
        }

        while (true) {
            System.out.println("Nhập tên giá mua");
            this.importPrice = Double.parseDouble(scanner.nextLine());
            if (this.importPrice > 0) {
                break;
            }
        }

        while (true) {
            System.out.println("Nhập tên giá bán");
            this.exportPrice = Double.parseDouble(scanner.nextLine());
            if (this.exportPrice / this.importPrice > 1.2) {
                break;
            }
        }

        this.interest = (float) (this.exportPrice - this.importPrice);

        while (true) {
            System.out.println("Nhập số lượng");
            this.quantity = Integer.parseInt(scanner.nextLine());
            if (this.quantity > 0) {
                break;
            }
        }
    }
    public boolean getBookStatus(){
        return this.bookStatus;
    }

    public void displayData() {
        System.out.println(
                "id: " + this.bookId + "; \n"
                        + "Tên sách: " + this.bookName + "; \n"
                        + "Tên tác giả: " + this.author + "; \n"
                        + "Mô tả: " + this.descriptions + "; \n"
                        + "Giá mua: " + formatter.format(this.importPrice) + "; \n"
                        + "Giá bán: " + formatter.format(this.exportPrice) + "; \n"
                        + "Lợi nhuận: " + formatter.format(this.interest) + "; \n"
                        + "Số lượng: " + this.quantity + "; \n"
                        + "Trạng thái: " + (this.bookStatus ? "Bán." : "Không bán.")
        );
    }
}
