import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

public class Java08Ex_01 {

	public static void main(String[] args) {
		
		try {
			int n = 1/0;
			System.out.println(n);
		}catch(Exception e) {
			Calendar now = Calendar.getInstance();
			int y = now.get(Calendar.YEAR);
			int m = now.get(Calendar.MONTH) + 1;
			int d = now.get(Calendar.DAY_OF_MONTH);
			int h = now.get(Calendar.HOUR_OF_DAY);
			int mn = now.get(Calendar.MINUTE);
			int sc = now.get(Calendar.SECOND);
			int ms = now.get(Calendar.MILLISECOND);
			File log = new File("/Users/kimjunghwan/TIL/govermentEdu_Java/log/" + y + m + d + h + mn + sc + ms + ".log");
			
			FileWriter writer = null;
			
			String error = e.getMessage();

			try {
				log.createNewFile();
				writer = new FileWriter(log, true);
				writer.write(error);
				writer.flush();
				writer.close();
			} catch(Exception e1) {
					System.out.println("프로그램 작동 오류입니다.");
				}
			}
		}
	}

