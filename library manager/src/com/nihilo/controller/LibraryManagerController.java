package com.nihilo.controller;

import com.nihilo.model.Book;
import com.nihilo.model.Borrowers;
import com.nihilo.repository.BooksRepository;
import com.nihilo.repository.BorrowersRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LibraryManagerController {
    Scanner sc = new Scanner(System.in);
    BooksRepository books = BooksRepository.getInstance();
    BorrowersRepository borrowers = BorrowersRepository.getInstance();


    public void menu() throws InterruptedException, ParseException {
        boolean quit = false;
        while (!quit) {

            System.out.print("|Choose 1:| to add books \n" +
                    "|Choose 2:| to delete a  book\n"
                    + "|Choose 3:| to borrow a book\n" +
                    "|Choose 4:| to return a book\n" +
                    "|Choose 5:| to display a list of books\n" +
                    "|Choose 6:| to see a list of borrowers\n" +
                    "|Choose 0:| to quit\n");
            int menuItem = check();

            sc.nextLine();
            switch (menuItem) {

                case 1:
                    System.out.println("please enter the following information");
                    receiveBookInput();

                    break;

                case 2:
                    removeBook();


                    break;

                case 3:
                    receiveBorrowerInput();

                    break;

                case 4:
                    removeBorrower();

                    break;
                case 5:
                    books.display();

                    break;

                case 6:
                    borrowers.display();

                    break;

                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }


        }


    }

  private void receiveBookInput() throws InterruptedException {
        System.out.println("please input the id(must be a number)");
        Integer id = check();
        sc.nextLine();
        //here if the book exists i will just add the value by one
        if (books.get(id) != null) {
            System.out.println("book already exists the total has been increased");
            int totalStock = books.get(id).getTotalStock() + 1;
            int inLibrary = books.get(id).getStockInLibrary() + 1;
            books.get(id).setStockInLibrary(inLibrary);
            books.get(id).setTotalStock(totalStock);
        } else {
            System.out.println("please input the title");
            String title = sc.nextLine();
            System.out.println("please input the author");
            String author = sc.nextLine();
            System.out.println("enter the amount of stock in the library");
            int stockInLibrary = check();
            sc.nextLine();
            System.out.println("enter the amount of total stock");
            int totalStock = check();
            sc.nextLine();
            //here after taking all the inputs i add it to the hashmap
            books.add(id, new Book(id, title, author, stockInLibrary, totalStock));
        }

        Thread.sleep(1500);
        for (int i = 0; i < 50; ++i) System.out.println();

    }

   private void receiveBorrowerInput() throws ParseException, InterruptedException {
        System.out.println("please enter your borrowers id ");
        Integer borrowersLicense = check();
        sc.nextLine();
        System.out.println("Enter the book id you want to rent");
        int id = check();
        sc.nextLine();
        if (books.get(id) != null && books.get(id).getStockInLibrary() > 1) {
            System.out.println("please insert due date in the format(dd/mm/yyyy)");
            Date dueDate = inputDate();
            System.out.println("successful check out");
            //here i add it to the hash map then decrease the stock in the library
            borrowers.add(borrowersLicense, new Borrowers(borrowersLicense, dueDate, books.get(id)));
            int stock = books.get(id).getStockInLibrary();
            books.get(id).setStockInLibrary(stock - 1);
        } else {
            System.out.println("the book cannot be borrowed");
        }
        Thread.sleep(1500);
        //i wait for 1.5 seconds and print 50 lines in order to clear the screen
        // i wrote it in this way so that it can work on any system
        for (int i = 0; i < 50; ++i) System.out.println();
    }

   private void removeBook() throws InterruptedException {
        System.out.println("please enter the id of the book you want to remove");
        int id = check();
        sc.nextLine();
        if (books.get(id) != null) {
            System.out.println("are you sure you want to delete[y to confirm]press any other key to quit ...\n"
                    + books.get(id));
            String confirm = sc.nextLine();
            boolean confirmation = confirm.equalsIgnoreCase("y");
            if (confirmation) {
                books.deleteBook(id);
            } else {
                System.out.println("the book is not deleted");

            }
        } else {
            System.out.println("there is no such book");
        }
        Thread.sleep(1500);
        for (int i = 0; i < 50; ++i) System.out.println();

    }

  private  void removeBorrower() throws InterruptedException {
        System.out.println("please enter your borrower id ");
        int borrowersLicense = check();
        sc.nextLine();
        if (borrowers.get(borrowersLicense) != null) {
            System.out.println("are you sure you want to delete[y to confirm]press any other key to quit ...\n"
                    + borrowers.get(borrowersLicense));
            String confirm = sc.nextLine();
            boolean confirmation = confirm.equalsIgnoreCase("y");
            if (confirmation) {
                Book returnedBooks = books.get(borrowers.get(borrowersLicense).getBook().getId());
                int increaseStock = returnedBooks.getStockInLibrary();
                returnedBooks.setStockInLibrary(increaseStock + 1);
                borrowers.deleteBorrower(borrowersLicense);
            } else {
                System.out.println("the borrower is not deleted");
            }
        } else {
            System.out.println("the borrower is not in the system");
        }
        Thread.sleep(1500);
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    //an input check method that i wrote to make sure that proper input will be entered
  private   Integer check() {
        Integer I = null;
        while (I == null) {
            try {
                I = Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                System.out.println("please enter a valid input\n" + "enter again(number)");
            }
        }
        return I;
    }

   private  Date inputDate(){
        Date returnDate=null;
        while (returnDate==null){
             try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                String date =sc.nextLine();
                if(validateDate(date)) {
                    returnDate = format.parse(date);
                }
             }catch (ParseException e){
                   System.out.println("please try again(input it in the format dd/mm/yyyy");
               } catch (Exception e) {
                 System.out.println("please enter the date in the correct format");;
             }
        }
        return returnDate;
    }

private boolean validateDate(String input) throws Exception {
        if (input.matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$")) {
        return true;
    }
    throw new Exception("date is not in the format dd/mm/yyyy");
    }


}











