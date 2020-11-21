import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RepeatTest {
	
	public static void PositiveSub() {
		Date date = new Date(System.currentTimeMillis()); //today's date
		System.out.println("Positive patients that need to repeat test: ");
		for (int i=0;i<positivePatients.length; i++) {
			if (positivePatients[i]!=null) {
				long diff1 = (date.getTime()-positivePatients[i].//getDate().getTime());
				long diff = TimeUnit.DAYS.convert(diff1, TimeUnit.MILLISECONDS);
				if (diff = 15) {
					System.out.println (positivePatients[i]);
				}
			}
		}
	}
	
	public static void NegativeSub() {
		Date date = new Date(System.currentTimeMillis()); //today's date
		System.out.println("Negative patients that need to repeat test: ");
		for (int i=0;i<negativePatients.length; i++) {
			if (negativePatients[i]!=null) {
				long diff1 = (date.getTime()-negativePatients[i].//getDate().getTime());
				long diff = TimeUnit.DAYS.convert(diff1, TimeUnit.MILLISECONDS); //difference between today's date
				// and the day of the test
				if (diff = 3) {
					System.out.println (negativePatients[i]);
				}
			}
		}
	}
}
