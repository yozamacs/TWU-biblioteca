package com.twu.biblioteca;

import java.io.*;
import java.nio.Buffer;
import java.util.*;
public class BibliotecaApp {

    private String inputLn;

    public static void main(String[] args) {
        ArrayList<Book> bl = new ArrayList<Book>();
        bl.add(new Book("A Wrinkle In Time", "Madeline L'engle", 1995));
        bl.add(new Book("Great Gatsby", "F. Scott Fitzgerald", 1953));
        bl.add(new Book("Anne of Green Gables", "A Lady", 1901));
        BibliotecaApp ba = new BibliotecaApp(System.out, bl,System.in);
        ba.start();

    }

    PrintStream out;
    InputStream in;
    ArrayList<Book> bl;

    public BibliotecaApp(PrintStream out, ArrayList<Book> bl, InputStream in) {
        this.out=out;
        this.bl = bl;
        this.in = in;
    }

    public void start() {
        display();
        chooseOption(getUserChoice(new BufferedReader(new InputStreamReader(in))));
    }

    public void display() {
        out.println("Welcome to Biblioteca!!!!!");
        out.println("Menu");
        out.println("1. Print Book List");
    }

    public void printBookList() {
        out.println(String.format("%-18s| %-22s| %-4s", "Title", "Author", "Year"));
        for(Book b : bl) {
            out.println(b.getDetails());
        }
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

    public void chooseOption(int choice) {
        if(choice==1){
            printBookList();
        }
        else
            out.println("Option not valid, please choose again");
    }


}
