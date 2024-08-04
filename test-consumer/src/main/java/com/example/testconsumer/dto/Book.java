package com.example.testconsumer.dto;

public class Book {

    // Class data members
    private String bookName;
    private String isbn;

    // Constructor 1
    public Book() {}

    // Constructor 2
    public Book(String bookName, String isbn)
    {
        // This keyword refers to
        // current instance itself
        this.bookName = bookName;
        this.isbn = isbn;
    }

    // Setter
    public String getBookName() { return bookName; }

    // Setter
    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    // Setter
    public String getIsbn() { return isbn; }

    // Setter
    public void setIsbn(String isbn) { this.isbn = isbn; }
}