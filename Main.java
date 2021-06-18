package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.io.*;
import java.lang.*;
import java.util.Set;

public class Main {
   public static Set<String>  SS = new HashSet<String>();
    public static int SSsize=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean counten = true;
        int inputt;
        while (counten) {
            System.out.print("Enter 1 to Add chars to table\nEnter 2 to print the table\nEnter 3 to search for a word\n");
            inputt = sc.nextInt();
            if (inputt == 1) addchars();
            else if (inputt == 2) printTable();
            else Search();
            System.out.print("Enter 1 to back\n");
            inputt = sc.nextInt();
            if (inputt != 1) counten = false;

        }

    }

    public static char[][] myBadGlobalArray = new char[5][5];

    public static void addchars() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {
                myBadGlobalArray[i][j] = sc.next().charAt(0);
            }
        }


    }

    public static Boolean get_string(int row, int coulmn, String s) {
        String s1 = new String(), s2, s3, s4, s5, s6, s7, s8;
        s2 = s3 = s4 = s5 = s6 = s7 = s8 = s1;
        for (int i = 0; i < s.length(); i++) {
            if(coulmn+1<5)s1 += myBadGlobalArray[row][coulmn + i];
           if(coulmn - i>0) s2 += myBadGlobalArray[row][coulmn - i];
            if(row+1<5)s3 += myBadGlobalArray[row + i][coulmn];
            if(row-1>0)s4 += myBadGlobalArray[row - i][coulmn];
            if(row+1<5&&coulmn+1<5)s5 += myBadGlobalArray[row + i][coulmn + i];
            if(row-1>0&&coulmn-1>0)s6 += myBadGlobalArray[row - i][coulmn - i];
            if(coulmn-1>0&&row+1<5)s7 += myBadGlobalArray[row + i][coulmn - i];
            if(row-1>0&&coulmn+1<5)s8 += myBadGlobalArray[row - i][coulmn + i];


        }
        if(s1.equals(s)|s2.equals(s)|s3.equals(s)|s4.equals(s)|s5.equals(s)|s6.equals(s)|s7.equals(s)|s8.equals(s))
        return true;
        else return false;
    }

    public static void Search() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string\n");
        String in = sc.next();
        char frist = in.charAt(0);
        int coulmn = 0, row = 0;


        if (in.length() > 5) System.out.print("Not Found\n");
        else {
SS.add(in);
if(SS.size()== SSsize){
    System.out.print("This word taked before\n");
}else{
    SSsize++;
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            if (myBadGlobalArray[i][j] == frist) {
                coulmn = j;
                row = i;
                if(get_string(row,coulmn,in)){
                    System.out.print("Found this word\n");
                    break;
                }

            }
        }
    }
}

        }


    }

    public static void printTable() {

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {
                System.out.print(myBadGlobalArray[i][j] + " ");

            }
            System.out.print("\n");

        }


    }

}
