package com.bookutil;

import com.book.BookStore;
import com.book.Book;

import java.util.Scanner;

public class BookUtil {
    public static void main(String[] args) {
        BookStore bs = new BookStore();
        Scanner sc= new Scanner(System.in);
        String bookId, title, author, category;
        double price;

        // Adding Book1

        System.out.println("Enter BookId (Book1): ");
        bookId = sc.nextLine();
        System.out.println("Enter title (Book1): ");
        title = sc.nextLine();
        System.out.println("Enter author (Book1): ");
        author = sc.nextLine();
        System.out.println("Enter category (Book1): ");
        category = sc.nextLine();
        System.out.println("Enter price (Book1): ");
        price = sc.nextDouble();
        if(bs.addBook(new Book(bookId, title, author, category, price)))
            System.out.println("Book details added");
        else
            System.out.println("Book insertion failed");

        // Adding Book2

        System.out.println("Enter BookId (Book2): ");
        bookId = sc.nextLine();
        System.out.println("Enter title (Book2): ");
        title = sc.nextLine();
        System.out.println("Enter author (Book2): ");
        author = sc.nextLine();
        System.out.println("Enter category (Book2): ");
        category = sc.nextLine();
        System.out.println("Enter price (Book2): ");
        price = sc.nextDouble();
        if(bs.addBook(new Book(bookId, title, author, category, price)))
            System.out.println("Book details added");
        else
            System.out.println("Book insertion failed");

        // Adding Book3

        System.out.println("Enter BookId (Book3): ");
        bookId = sc.nextLine();
        System.out.println("Enter title (Book3): ");
        title = sc.nextLine();
        System.out.println("Enter author (Book3): ");
        author = sc.nextLine();
        System.out.println("Enter category (Book3): ");
        category = sc.nextLine();
        System.out.println("Enter price (Book3): ");
        price = sc.nextDouble();
        if(bs.addBook(new Book(bookId, title, author, category, price)))
            System.out.println("Book details added");
        else
            System.out.println("Book insertion failed");

        // Searching by title of the book

        System.out.println("Enter the title to search:");
        String str = sc.nextLine();
        if(!bs.searchByTitle(str))
            System.out.println("Book not found");

        // Searching by author of the book

        System.out.println("Enter the author to search:");
        String str1 = sc.nextLine();
        if(!bs.searchByAuthor(str1))
            System.out.println("Book not found");

        // Displaying all the data

        bs.displayAll();
    }
}