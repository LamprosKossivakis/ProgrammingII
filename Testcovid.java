import java.text.ParseException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Testcovid {
	public static void test(String[]args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Δώσε ονοματεπώνυμο:");
		String name = scanner.next();
		System.out.println("Δώσε ημερομηνία γέννησης:");
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
        String d = scanner.next();
        Date date = format.parse(d);
        Testcovid patient = new Testcovid(name,date);
        System.out.println(patient.getName() + " getting tested");
	}
	
}
