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
        BibliotecaApp ba = new BibliotecaApp(library, System.out, System.in);
        ba.start();

    }

    PrintStream out;
    InputStream in;
    ArrayList<Book> bl;
    private Library library;

    public BibliotecaApp(Library library, PrintStream out, InputStream in) {
        this.out=out;
        this.bl = bl;
        this.in = in;
    }

    public void start() {
        displayWelcome();
        boolean keepGoing = true;
        while(keepGoing) {
            displayMenu();
            keepGoing = chooseOption(getUserChoice(new BufferedReader(new InputStreamReader(in))));
        }
    }

    public void displayMenu() {
        out.println("Menu");
        out.println("1. Print Book List");
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
        if(choice == -1) {
            out.println("Goodbye!");
            keepGoing =  false;
        }
        else if(choice==1){
            library.printBookList(out);
        }
        else {
            out.println("Option not valid, please choose again");
        }
        return keepGoing;
    }


}
