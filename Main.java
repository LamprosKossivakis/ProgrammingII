package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws ParseException{

        Scanner scanner = new Scanner(System.in);
        int cont = 1;
        while (cont != 0) {
            System.out.println("** Menu **");
            System.out.println("Press 1 to do test for COVID19");
            System.out.println("Press 2 to see the list with everyone tested for COVID19");
            System.out.println("Press 3 to see the list of positive on COVID19");
            System.out.println("Press 4 to see the list of negative on COVID19");
            System.out.println("Press 5 to see the numbers of our community");
            System.out.println("Press 6 to get info of COVID19");
            cont = scanner.nextInt();

            switch (cont) {
                case 0:
                    break;
                case 1:
                    System.out.println("Patient's name: ");
                    String name = scanner.next();
                    System.out.println("Patient's date of birth: dd/MM/yyyy");
                    String pattern = "dd/MM/yyyy";
                    SimpleDateFormat format = new SimpleDateFormat(pattern);
                    String d = scanner.next();
                    Date date = format.parse(d);
                    TestCovid19 patient = new TestCovid19(name,date);
                    System.out.println(patient.getName() + " getting tested");
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                default:
                    System.out.println("Wrong input please try again");
            }
        }
    }
}
