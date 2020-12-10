package com.nihilo.repository;

import com.nihilo.model.Book;
import com.nihilo.container.hashmap;


public class BooksRepository {
    private static final BooksRepository instance =new BooksRepository();
    private final hashmap<Integer, Book>books= new hashmap<>();


    private BooksRepository() {
    }
public static BooksRepository getInstance(){
        return instance;
}

public void add(int id,Book book){

        books.put(id, book);
       }







public Book get(int id){
      return books.get(id);
}
public void deleteBook(int id){
        books.remove(id);
}


public void display(){
    String format = "|%1$-8s|%2$-20s|%3$-20s|%4$-16s|%5$-16s|\n";
    System.out.format(format,"ID","TITLE","AUTHOR","STOCK_IN_LIBRARY","TOTAL_STOCK");
    books.print();



}


}