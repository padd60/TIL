
public class NumException {

	public static void main(String[] args) {
		String [] stringNumber = {"23", "12", "3.1435652", "998"};
		
		int i = 0;
		try {
			for(i = 0; i < stringNumber.length; i++) {
				int j = Integer.parseInt(stringNumber[i]);
				System.out.println("정수로 변환된 값은 " + j);
			}
		}catch(Exception e) {
			System.out.println(stringNumber[i] + "정수로 변환할 수 없습니다.");
		}

	}

}
