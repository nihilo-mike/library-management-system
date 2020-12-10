package com.nihilo.repository;

import com.nihilo.model.Borrowers;
import com.nihilo.container.hashmap;

public class BorrowersRepository {

    private static final BorrowersRepository instance = new BorrowersRepository();
    private final hashmap<Integer, Borrowers> borrowers = new hashmap<>();


    private BorrowersRepository() {
    }

    public static BorrowersRepository getInstance() {
        return instance;
    }

    public void add(int id, Borrowers borrower) {
        borrowers.put(id, borrower);
    }

    public Borrowers get(int id) {
        return borrowers.get(id);
    }

    public void deleteBorrower(int borrowerLicense) {
        borrowers.remove(borrowerLicense);
    }
    public void display(){
        String format = "|%1$-8s|%2$-20s|%3$-20s|\n\n";
        System.out.format(format,"ID","DUE DATE","BOOK");
        borrowers.print();



    }

}
