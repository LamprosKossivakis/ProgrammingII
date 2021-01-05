import java.sql.SQLException;
import java.util.Scanner;

public class Menu2 {
	public static void print_menu() throws SQLException {
			int success=0;
			while (success==0) {
				System.out.println("Καλωσήρθate στην εφαρμογή μας!");
				System.out.println("Επιλέξτε ένα από τα παρακάτω:");
				System.out.println("1.Διεξαγωγή Τεστ για τον Covid-19");
				System.out.println("2.Μετάβαση σε λίστα με όσους έχουν ήδη κάνει το τεστ");
				System.out.println("3.Μέταβαση σε λίστα με τους θετικούς στον κορονοϊό");
				System.out.println("4.Μετάβαση σε λίστα με αυτούς που βρέθηκαν αρνητικοί στον ιό");
				System.out.println("5.Παρακολούθηση της επιδημιολογικής εικόνας της περιοχής σας "
				+ "και ενδιαφερόντων στατιστικών στοιχείων σχετικά με τον ιό");
				System.out.println("6.Αναζήτηση ασθενούς μέσω του ΑΜΚΑ του.");
				Scanner sc = new Scanner(System.in); //create a Scanner object
				int choice = sc.nextInt(); //Read user input
				if (choice==1) {
					TestCovid test1 = new TestCovid();
					test1.test();
					success=1; 
				} else if (choice==2) {
					AllTested.printTested();
					success=1;
				} else if (choice==3) {
					Positive.printPositive();
					success=1;
				} else if (choice==4) {
					Negative.printNegative();
					success=1;
				} else if (choice==5) {
					Statistics stats = new Statistics();
					stats.AllStats();
					success=1;
				} else if (choice==6) {
					System.out.println("ENTER PATIENS AMKA TO START SEARCHING");
					int AMKA1 = sc.nextInt();
					int test_res= execute.search(AMKA1);
					
					if (test_res ==1) {
					
					
					System.out.println("DO YOU WANT TO VIEW PATIENTS CONTACTS?");
					int ans1 = sc.nextInt();

					if (ans1 == 1) {

						execute.show_contacts(AMKA1);

					}
				} else {
					System.out.println("Η επιλογή σας δεν είναι η ενδεδειγμένη.Δοκιμάστε ξανά.");
				}
			}
		}
	}
}
