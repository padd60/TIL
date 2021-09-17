import java.util.Scanner;

public class mainClass {
	public static void play() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("게임을 시작하시겠습니까?(y/n)");
		String start = scanner.nextLine();
		
		if(start.equals("y")) {
			System.out.println("총 정답숫자 세자리 중 첫번째 숫자를 입력하세요.(1 ~ 9)");
			String userNum1 = scanner.nextLine();
			while(userNum1.length() > 1) {
				System.out.println("한자리 숫자만 입력해주세요.(1 ~ 9)");
				userNum1 = scanner.nextLine();
			}
			
			System.out.println("총 정답숫자 세자리 중 두번째 숫자를 입력하세요.(1 ~ 9)");
			String userNum2 = scanner.nextLine();
			while(userNum2.length() > 1) {
				System.out.println("한자리 숫자만 입력해주세요.(1 ~ 9)");
				userNum2 = scanner.nextLine();
			}
			while(userNum2.equals(userNum1)) {				
				System.out.println("중복된 숫자는 입력하실 수 없습니다. 다른 숫자를 입력해주세요.(1 ~ 9)");
				userNum2 = scanner.nextLine();
			}
			
			System.out.println("총 정답숫자 세자리 중 세번째 숫자를 입력하세요.(1 ~ 9)");
			String userNum3 = scanner.nextLine();
			while(userNum3.length() > 1) {
				System.out.println("한자리 숫자만 입력해주세요.(1 ~ 9)");
				userNum3 = scanner.nextLine();
			}
			while(userNum3.equals(userNum2) || userNum3.equals(userNum1)) {				
				System.out.println("중복된 숫자는 입력하실 수 없습니다. 다른 숫자를 입력해주세요.(1 ~ 9)");
				userNum3 = scanner.nextLine();
			}
			
			String userNum = userNum1 + userNum2 + userNum3;
			System.out.println("입력하신 정답은 " + userNum + "입니다.");
			
		} else if(start.equals("n")) {
			System.out.println("게임을 종료합니다...");
		} else {
			System.out.println("y 또는 n으로만 대답해주십시요.");
			play();
		}
		scanner.close();

	}

	public static void main(String[] args) {
		int randomNum1;
		int randomNum2;
		int randomNum3;
		
		while(true) {
			randomNum1 = (int)Math.ceil((Math.random()*9));
			randomNum2 = (int)Math.ceil((Math.random()*9));
			randomNum3 = (int)Math.ceil((Math.random()*9));
			if(randomNum1 != randomNum2 && randomNum2 != randomNum3 && randomNum3 != randomNum1 ) {
				break;
			}
		}

		String num1 = Integer.toString(randomNum1);
		String num2 = Integer.toString(randomNum2);
		String num3 = Integer.toString(randomNum3);		
		String computerNum = num1 + num2 + num3;
		System.out.println("정답은: " + computerNum);
		
		
		play();

		
	}

}
