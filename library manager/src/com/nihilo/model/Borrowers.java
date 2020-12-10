package com.nihilo.model;


import com.nihilo.model.Book;

import java.util.Date;

public class Borrowers {
    private int borrowersLicense;
    private Date dueDate;
    private Book book;

    public Borrowers(int borrowersLicense, Date dueDate, Book book) {
        this.borrowersLicense = borrowersLicense;
        this.dueDate = dueDate;
        this.book = book;
    }

    public int getBorrowersLicense() {
        return borrowersLicense;
    }

    public void setBorrowersLicense(int borrowersLicense) {
        this.borrowersLicense = borrowersLicense;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book=book;
    }

    @Override
    public String toString() {

        return String.format("|%1$-8s|%2$-20s|%3$-20s|\n", borrowersLicense, dueDate, book);


    }







}
