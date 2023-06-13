package ra.model;

import java.util.Date;

public class Cart {
    private int id;
    private String bookName;
    private double bookPrice;
    private String bookAuthor;
    private int quantity;
    private String categoryName;
    private Date borrowedDate;
    private Date dueDate;

    public Cart() {

    }

    public Cart(int id, String bookName, double bookPrice, String bookAuthor, int quantity, String categoryName, Date borrowedDate, Date dueDate) {
        this.id = id;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookAuthor = bookAuthor;
        this.quantity = quantity;
        this.categoryName = categoryName;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "--------------------------------------------------\n" +
                "ID" + id + "| Name : " + bookName +
                "\nPrice : " + bookPrice + " | quantity : " + quantity +
                "\nBorrwedDate : " + borrowedDate + " | DueDate : " + dueDate
                ;
    }
}
