package com.nihilo;

import com.nihilo.controller.LibraryManagerController;

import java.text.ParseException;

public class Main {


    public static void main(String[] args) throws ParseException, InterruptedException {
        System.out.println("welcome");

        LibraryManagerController libraryManagerController =new LibraryManagerController();
          libraryManagerController.menu();



    }



}
