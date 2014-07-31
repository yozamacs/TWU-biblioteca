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
        Menu menu = new Menu(System.out);
        BibliotecaApp ba = new BibliotecaApp(library, System.out, new BufferedReader(new InputStreamReader(System.in)),menu);
        ba.start();

    }

    PrintStream out;
    BufferedReader reader;
    private Library library;
    private Menu menu;

    public BibliotecaApp(Library library, PrintStream out, BufferedReader reader, Menu menu) {
        this.out=out;
        this.library = library;
        this.reader = reader;
        this.menu = menu;
    }

    public void start() {
        displayWelcome();
        boolean keepGoing = true;
        while(keepGoing) {
            menu.display();
            keepGoing = chooseOption(getUserChoice());
        }
    }

    public void displayWelcome() {
        out.println("Welcome to Biblioteca!!!!!");
    }

    public int getUserChoice() {
        String choice = getInputFromUser();
        return Integer.parseInt(choice);
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
            library.checkOut(getInputFromUser());
        } else {
            out.println("Option not valid, please choose again");
        }
        return keepGoing;
    }


    public String getBookTitleFromUser() {
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

    public String getInputFromUser() {
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
