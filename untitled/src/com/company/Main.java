package com.company;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static String userinput;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение");
        userinput = in.nextLine();
        Logic logic = new Logic();
    }
}
