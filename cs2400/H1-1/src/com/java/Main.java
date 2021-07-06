package com.java;
import library.service.classes.BookGenre;
import library.service.classes.BookRecord;

import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception{
    BookRecord [] arrayBookRecord = new BookRecord[5];
    int recordsInArray = 0;
        Scanner scanner = new Scanner(System.in);
    String bookTextFile = scanner.next();
    int expansionFactor = scanner.nextInt();
    File books = new File("/Users/maxhartke/code/java/CS2400HW1/src/com/java/" + bookTextFile);
    Scanner sc = new Scanner(books);

    for(var x = 0;(sc.hasNextLine()); x++) {
        String test = sc.nextLine();
        boolean arrayFull = false;
        Scanner scanLine = new Scanner(test);
        scanLine.useDelimiter(":");
        BookRecord book = new BookRecord();
        book.setBookTitle(scanLine.next());
        book.setBookGenre(BookGenre.valueOf(scanLine.next()));
        book.setBookAuthors(scanLine.next());

        for (int i = 0; i < recordsInArray; i++) {
            if (arrayBookRecord[i].equals(book)) {
                System.out.println("Found a duplicate " + "\n" + "===================================" + "\n" + arrayBookRecord[i].toString() + "\n" + "===================================" + "\n");
            }
        }
        recordsInArray++;
        arrayBookRecord[x] = book;
        for (int i = 0; i < arrayBookRecord.length; i++) {
            if (arrayBookRecord[i] == null) {
                arrayFull = false;
            } else {
                arrayFull = true;

            }
        }

        if (arrayFull == true) {
            int oldArraySize = arrayBookRecord.length;
            int newArraySize = arrayBookRecord.length + expansionFactor;
            BookRecord[] temporaryArray = new BookRecord[newArraySize];
            System.arraycopy(arrayBookRecord, 0, temporaryArray, 0, oldArraySize);
            arrayBookRecord = temporaryArray;
            temporaryArray = null;
            System.out.println("Resized the array from " + oldArraySize + " to " + newArraySize);

        }
    }

    while(true) {
        System.out.println("Select an option:");
        System.out.println("Type \"S\" to list books of a genre");
        System.out.println("Type \"P\" to print out all the book recors");
        System.out.println("Type \"Q\" to Quit");
        Scanner option = new Scanner(System.in);
        String userOption = option.next();
        switch (userOption) {
            case "S":
                    System.out.println("Type a genre. The genres are:");
                    for (BookGenre d : BookGenre.values()) {
                        System.out.println(d);
                    }
                    while (true) {
                        String genre = option.nextLine();
                        switch (genre) {
                            case "GENRE_HISTORY":
                                for (int i = 0; i < recordsInArray; i++) {
                                    if (arrayBookRecord[i].getBookGenre() == BookGenre.valueOf("GENRE_HISTORY")) {
                                        System.out.println("===================================" + "\n" + arrayBookRecord[i].toString() + "\n" + "===================================");
                                    }

                                }
                                System.exit(0);
                            case "GENRE_SCIENCE":
                                for (int i = 0; i < recordsInArray; i++) {
                                    if (arrayBookRecord[i].getBookGenre() == BookGenre.valueOf("GENRE_SCIENCE")) {
                                        System.out.println("===================================" + "\n" + arrayBookRecord[i].toString() + "\n" + "===================================");
                                    }

                                }
                                System.exit(0);
                            case "GENRE_ENGINEERING":
                                for (int i = 0; i < recordsInArray; i++) {
                                    if (arrayBookRecord[i].getBookGenre() == BookGenre.valueOf("GENRE_ENGINEERING")) {
                                        System.out.println("===================================" + "\n" + arrayBookRecord[i].toString() + "\n" + "===================================");
                                    }

                                }
                                System.exit(0);
                            case "GENRE_LITERATURE":
                                for (int i = 0; i < recordsInArray; i++) {
                                    if (arrayBookRecord[i].getBookGenre() == BookGenre.valueOf("GENRE_LITERATURE")) {
                                        System.out.println("===================================" + "\n" + arrayBookRecord[i].toString() + "\n" + "===================================");
                                    }

                                }
                                System.exit(0);
                        }
                    }

            case "P":
                for (int i = 0; i <recordsInArray; i++) {
                        System.out.println("===================================" + "\n" + arrayBookRecord[i].toString() + "\n" + "===================================" + "\n");
                }
                break;

            case "Q":
                System.out.println("Quitting program");
                System.exit(0);

            default:
                System.out.println("Wrong option! Try again");
                break;
        }
    }
    }
}
