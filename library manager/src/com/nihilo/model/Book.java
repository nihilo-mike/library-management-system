package com.nihilo.model;




public class Book {


    public Book(int id, String title, String author, int stockInLibrary, int totalStock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.stockInLibrary = stockInLibrary;
        this.totalStock = totalStock;
    }

    private int id;
    private String title;
    private String author;
    private int stockInLibrary;
    private int totalStock;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStockInLibrary() {
        return stockInLibrary;
    }

    public void setStockInLibrary(int stockInLibrary) {
        this.stockInLibrary = stockInLibrary;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }


    @Override
    public String toString() {

        return String.format("|%1$-8s|%2$-20s|%3$-20s|%4$-16s|%5$-16s|\n", id, title, author, stockInLibrary, totalStock);


    }


}
