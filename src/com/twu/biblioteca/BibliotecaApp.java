package com.twu.biblioteca;

import java.io.*;
import java.util.*;
public class BibliotecaApp {


    public static void main(String[] args) {
        ArrayList<Book> bl = new ArrayList<Book>();
        bl.add(new Book("A Wrinkle In Time", "Madeline L'engle", 1995));
        bl.add(new Book("Great Gatsby", "F. Scott Fitzgerald", 1953));
        bl.add(new Book("Anne of Green Gables", "A Lady", 1901));
        Library library = new Library(bl);
        BibliotecaApp ba = new BibliotecaApp(library, System.out, new BufferedReader(new InputStreamReader(System.in)));
        ba.start();

    }

    PrintStream out;
    BufferedReader reader;
    private Library library;

    public BibliotecaApp(Library library, PrintStream out, BufferedReader reader) {
        this.out=out;
        this.library = library;
        this.reader = reader;
    }

    public void start() {
        displayWelcome();
        boolean keepGoing = true;
        while(keepGoing) {
            displayMenu();
            keepGoing = chooseOption(getUserChoice(reader));
        }
    }

    public void displayMenu() {
        out.println("Menu");
        out.println("1. Print Book List");
        out.println("2. Checkout a Book");
        out.println("If you would like to exit, please enter -1");
    }

    public void displayWelcome() {
        out.println("Welcome to Biblioteca!!!!!");
    }

    public int getUserChoice(BufferedReader reader) {
        String inputLn = "";

        try {
            inputLn = reader.readLine();
            if(inputLn.length()==0){
                return -1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(inputLn);
    }

    public boolean chooseOption(int choice) {
        boolean keepGoing = true;
        if (choice == -1) {
            out.println("Goodbye!");
            keepGoing =  false;
        } else if (choice==1) {
            library.printBookList(out);
        } else if (choice==2) {
            out.println("Please enter a book title");
            library.checkOut(getBookTitleFromUser(reader));
        } else {
            out.println("Option not valid, please choose again");
        }
        return keepGoing;
    }


    public String getBookTitleFromUser(BufferedReader reader) {
        String inputLn = "";

        try {
            inputLn = reader.readLine();
            if(inputLn.length()==0){
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputLn;
    }
}
