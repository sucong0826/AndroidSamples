package com.su.androidsample.basicjni.entity;

/**
 * Book is a dummy class for testing JNI.
 * <p>
 * Created by Zoom. Clever Su on 09/08/2017.
 */

public class Book {
    private double bookPrice = 0D;
    private String bookName = "UNKNOWN";
    private long snCode = 0L;

    public static final Book DEF_BOOK = new Book();

    public Book() {
        // do nothing
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public long getSnCode() {
        return snCode;
    }

    public void setSnCode(long snCode) {
        this.snCode = snCode;
    }

    public void setTitle(String title) {

    }

    @Override
    public String toString() {
        return "Book{" +
                "bookPrice=" + bookPrice +
                ", bookName='" + bookName + '\'' +
                ", snCode=" + snCode +
                '}';
    }
}
