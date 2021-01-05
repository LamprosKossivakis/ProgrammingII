import java.util.Scanner;
public class Statistics {
	static double menper = 0;
	static double womenper = 0;
	static int todaypos = 0;
	static double todayper = 0;
	static double avgpos = 0;
	static int dailyregion[]= new int[13];
	static int sumregion[]= new int[13];
	static int level[]= new int[13];
	static int population[] = new int[13];
	static int men = 0;
	static int women = 0;
	static int totalpos = 0;
	static int todaytested = 0;
	static int contacts = 0;
	public Statistics() {
		super();
	}
	public void AllStats() {
		System.out.printf("�� ��������� ��� �������� ������ ����� %f.\n",todaypos);
		System.out.printf("�� ������������� ��� �������� ����� ���� %f ������ "
				+ "��� ���� %f ��������.\n",menper, womenper);
		System.out.printf("�� �������� ������� ����������� ����� %d%.\n",todayper);
		System.out.printf("���� ������ ������� ����������� ���� ���� ��� %f ������.\n", avgpos);
		System.out.println("�������� ���������� ���������(1.��������� ��������� ��� �����,"
				+ "2.�������� ���������,3.������ ���������,4.�������,5.��������,6.������ �����,"
				+ "7.������ ������,8.������ ������,9.������,10.������������,11.������ ������,"
				+ "12.����� ������,13.�����");
		Scanner sc = new Scanner(System.in); //create a Scanner object
		int region = sc.nextInt();
		System.out.printf("� ���������� ��� �������� ������ %d ��������� "
				+ "��� ��� ��� ���� ��� ��������� ���� ����������� %d ���������.\n", dailyregion[region - 1], sumregion[region - 1] );
		System.out.printf("�����, � ���������� ��� ��������� ��� ������� ���������� %d.\n",level[region - 1]);	
	}
	public void countTodayPos(int number) {
		todaypos++;
		contacts = contacts + number;
		avgpos = contacts / todaypos;
	}
	public void genderPer(int gender) {
		if (gender == 0) {
			men = men + 1;
		} else {
			women = women + 1;
		}
		totalpos = totalpos + 1;
		menper = (men / totalpos) * 100;
		womenper = (women / totalpos) * 100;
	}
	public void findTodayPer(int tested) {
		if (tested == 1) {
			todaypos++;
		}
		todaytested++;
		todayper = (todaypos / todaytested) * 100;
	}
	public void regionStats(int region) {
		dailyregion[region - 1]++;
		sumregion[region - 1]++;
		if ((dailyregion[region - 1] / population[region - 1] > 1/20000) && (dailyregion[region - 1] / population[region - 1] < 1/10000)) {
			level[region-1] = 2;
		} else if (dailyregion[region - 1] / population[region - 1] < 1/5000) {
			level[region-1] = 3;
		} else if (dailyregion[region - 1] / population[region - 1] < 1/20000) {
			level[region-1] = 1;
		} else {
			level[region-1] = 4;
		}
	}
	public void insertPopulation() {
		population[0] = 606170;
		population[1] = 1874590;
		population[2] = 282120;
		population[3] = 336650;
		population[4] = 730730;
		population[5] = 206470;
		population[6] = 680190;
		population[7] = 546870;
		population[8] = 3812330;
		population[9] = 581980;
		population[10] = 197810;
		population[11] = 308610;
		population[12] = 621340;
		for (int i = 0; i<level.length; i++) {
			level[i] = 1;
		}
	}
}
