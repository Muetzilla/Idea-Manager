package ch.muetzilla.ideamanager.scanner;

import java.time.LocalDate;
import java.util.Scanner;

public class Scan {
    private Scanner scanner;

    public Scan() {
        scanner = new Scanner(System.in);
    }

    public int scanInt() {
        int input = 0;
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Bitte einen gültigen Wert eingeben > ");
        }
        input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public String scanString() {
        String input = scanner.nextLine();
        return input;
    }

    public boolean scanBoolean() {
        boolean input = scanner.nextBoolean();
        scanner.nextLine();
        return input;
    }

    public char scanAnyChar() {
        char input = scanner.next().charAt(0);
        scanner.nextLine();
        return input;
    }

    public char scanJustLetter() {
        char input = scanner.next().charAt(0);
        while (!Character.isLetter(input)) {
            System.out.print("Bitte einen Buchstaben eingeben >  ");
            input = scanner.next().charAt(0);

        }
        return input;
    }

    public double scanNextDouble() {
        double input = 0;
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.print("Bitte einen gültigen Wert eingeben > ");
        }
        input = scanner.nextDouble();
        scanner.nextLine();
        return input;
    }

    public float scanNextFloat() {
        float input = 0;
        while (!scanner.hasNextFloat()) {
            scanner.next();
            System.out.print("Bitte einen gültigen Wert eingeben > ");
        }
        input = scanner.nextFloat();
        scanner.nextLine();
        return input;
    }

    public LocalDate scanDate() {
        int year;
        int month;
        int day;

        System.out.print("Bitte geben Sie das Jahr ein > ");
        year = scanInt();
        System.out.print("Bitte geben Sie den Monat ein > ");
        month = scanInt();
        System.out.print("Bitte geben Sie den Tag ein > ");
        day = scanInt();
        return LocalDate.of(year, month, day);
    }
}
