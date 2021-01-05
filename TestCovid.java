import java.sql.SQLException;
import java.util.Scanner;
public class TestCovid {
	private String name;
	private String surname;
	private int age;
	private int amka;
	private int gender;
	private int region;
	private int tested;
	public void test() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������� �����:");
		name = scanner.next();
		System.out.println("�������� �������:");
		surname = scanner.next();
		System.out.println("�������� ������:");
		age = scanner.nextInt();
		System.out.println("�������������� ����:");
		amka = scanner.nextInt();
		System.out.println("�������� ����(0 ��� �����, 1 ��� �������)");
		gender = scanner.nextInt();
		System.out.println("�������� ���������� ���������(1.��������� ��������� ��� �����,"
				+ "2.�������� ���������,3.������ ���������,4.�������,5.��������,6.������ �����,"
				+ "7.������ ������,8.������ ������,9.������,10.������������,11.������ ������,"
				+ "12.����� ������,13.�����");
		region = scanner.nextInt();
		System.out.println("�������� 0 �� ����� ��������� � 1 �� ����� �������");
		tested = scanner.nextInt();
		execute.insert(amka, name, surname, age, tested);
		// search if the name exists in the contacts; if so add its test to the contacts
		// list and the patient to the people list

		int result = execute.search_contact(name, surname);

		if (result == 1) {
			System.out.println("FOUND IN CONTACTS LIST");
			execute.modify_contact(name, surname, tested);

		}

		System.out.println("PATIENT ADDED SUCCESFULLY");

		if (tested == 1) {
			System.out.println("DO YOU WANT TO ADD CONTACTS?");
			int ans = scanner.nextInt();
			// search if the contact to be added exists to the contacts list; if it exists
			// use its already given id to make the connetion betwwen AMKA and contact;
			// if not just add the contact with test =-1

			if (ans == 1) {

				System.out.println("TYPE IN THE NUMBER OF CONTACTS TO BE ADDED");
				int contacts = scanner.nextInt();

				for (int i = 0; i < contacts; i++) {
					System.out.println("NAME: ");
					String nam = scanner.next();
					System.out.println("SURNAME:");
					String surnam = scanner.next();
					System.out.println("AGE: ");
					int ag = scanner.nextInt();
					int ret = execute.search_contact(nam,surnam);
					if (ret == 1) {
							execute.existing_add(nam, surnam, amka);
						// get his id
					} else {
						execute.insert_cont(nam, surnam, ag, amka, -1);
					}

					// search

				}

			}

		}

		Statistics stats = new Statistics();
		stats.findTodayPer(tested);
		if (tested == 1) {
			stats.regionStats(region);
		}
		
        TestCovid patient = new TestCovid(name, surname, age, amka, gender, region, tested);
        System.out.println(patient.getName() + "is getting tested");
	}
	
	

	public TestCovid() {
		super();
	}


	public TestCovid(String name, String surname, int age, int amka, int gender, int region, int tested) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.amka = amka;
		this.gender = gender;
		this.region = region;
		this.tested = tested;
	}
	public String getName() {
		return name;
	}
}

