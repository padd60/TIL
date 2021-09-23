
public class StringSample {

	public static void main(String[] args) {
		String fileName = "2021.report.java";
		System.out.println(fileName.lastIndexOf("."));
		int positionofDot = fileName.lastIndexOf(".");
		System.out.println(fileName.substring(positionofDot + 1));
		
		String num = "213123-1343247";
		System.out.println(num.lastIndexOf("-"));
		int positionOfDash = num.lastIndexOf("-");
		System.out.println(positionOfDash + 1);
		
		String hp = "010-1111-1111";
		String[] result = hp.split("-");
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
		// CSV(Comma Seperated Value)
		String data = "홍길동,010-2222-2222,qqq@qqq.com";
		String[] result2 = data.split(",");
		for(String d : result2) {
			System.out.println(d);
		}
	}

}
