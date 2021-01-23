package com.dimitris;

import java.sql.SQLException;
import java.util.Scanner;

public class menu {

	public static void print_menu() throws SQLException {

		Scanner scan = new Scanner(System.in);
		int choice;

		do {

			System.out.println("1. INSERT A PATIENT");
			System.out.println("2. SEARCH FOR A PATIENT");
			System.out.println("3. END DAY AND STATISTICS");
			System.out.println("4. END PROGRAMM");
			System.out.println("ENTER YOUR CHOICE: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:

				int ans;

				System.out.println("AMKA: ");
				int AMKA = scan.nextInt();
				System.out.println("NAME: ");
				String name = scan.next();
				System.out.println("SURNAME: ");
				String surname = scan.next();
				System.out.println("AGE: ");
				int age = scan.nextInt();
				System.out.println("TESTED: ");
				int test = scan.nextInt();
				System.out.println("SEX: ");
				String sex = scan.next();
				System.out.println("GEO LOCATION: ");
				int geo = scan.nextInt();
				//StoredProc.insert_patient(AMKA, name, surname, age, test, sex, geo);

				int result = execute.search_contact(name, surname);

				if (result == 1) {
					System.out.println("FOUND IN CONTACTS LIST");
					execute.modify_contact(name, surname, test);

				}

				System.out.println("PATIENT ADDED SUCCESFULLY");

				if (test == 1) {
					System.out.println("DO YOU WANT TO ADD CONTACTS?");
					ans = scan.nextInt();
					// search if the contact to be added exists to the contacts list; if it exists
					// use its already given id to make the connetion betwwen AMKA and contact;
					// if not just add the contact with test =-1

					if (ans == 1) {

						System.out.println("TYPE IN THE NUMBER OF CONTACTS TO BE ADDED");
						int contacts = scan.nextInt();

						for (int i = 0; i < contacts; i++) {
							System.out.println("NAME: ");
							String nam = scan.next();
							System.out.println("SURNAME:");
							String surnam = scan.next();
							System.out.println("AGE: ");
							int ag = scan.nextInt();
							int ret = execute.search_contact(nam, surnam);
							if (ret == 1) {
								execute.existing_add(nam, surnam, AMKA);
								// get his id
							} else {
								execute.insert_cont(nam, surnam, ag, AMKA, -1);
							}

							// search

						}

					}

				}

				break;
			case 2:
				System.out.println("ENTER PATIENS AMKA TO START SEARCHING");
				int AMKA1 = scan.nextInt();
				int search_res = StoredProc.search_patient(AMKA1);
				
				if (search_res == 1 || search_res ==0) {

					System.out.println("DO YOU WANT TO VIEW PATIENTS CONTACTS?");
					int ans1 = scan.nextInt();

					if (ans1 == 1) {

						StoredProc.show_contacts(AMKA1);
						break;
					}
				}else {
					System.out.println("THE PERSON IS NOT FOUND");
					break;
				}
				
			case 3:

				System.out.println(execute.insert_count);

				break;
			case 4:
				System.out.println("PROGRAMM ENDED");
				break;

			}

			System.out.println("//........................................................//");
		} while (choice != 4);

	}

}
