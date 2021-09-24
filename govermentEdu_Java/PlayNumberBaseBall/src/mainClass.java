import java.util.Scanner;

public class mainClass {
	static Scanner scanner = new Scanner(System.in);
	public static String user() {
		
		System.out.println("총 정답숫자 세자리 중 첫번째 숫자를 입력하세요.(1 ~ 9)");
		String userNum1 = scanner.next();
		while(userNum1.length() > 1) {
			System.out.println("한자리 숫자만 입력해주세요.(1 ~ 9)");
			userNum1 = scanner.next();
		}
		System.out.println("총 정답숫자 세자리 중 두번째 숫자를 입력하세요.(1 ~ 9)");
		String userNum2 = scanner.next();
		while(userNum2.length() > 1) {
			System.out.println("한자리 숫자만 입력해주세요.(1 ~ 9)");
			userNum2 = scanner.next();
		}
		while(userNum2.equals(userNum1)) {				
			System.out.println("중복된 숫자는 입력하실 수 없습니다. 다른 숫자를 입력해주세요.(1 ~ 9)");
			userNum2 = scanner.next();
		}
		
		System.out.println("총 정답숫자 세자리 중 세번째 숫자를 입력하세요.(1 ~ 9)");
		String userNum3 = scanner.next();
		while(userNum3.length() > 1) {
			System.out.println("한자리 숫자만 입력해주세요.(1 ~ 9)");
			userNum3 = scanner.next();
		}
		while(userNum3.equals(userNum2) || userNum3.equals(userNum1)) {				
			System.out.println("중복된 숫자는 입력하실 수 없습니다. 다른 숫자를 입력해주세요.(1 ~ 9)");
			userNum3 = scanner.next();
		}
		
		String userNum = userNum1+ " " + userNum2 + " " + userNum3;
		System.out.println("입력하신 정답은 " + userNum + "입니다.");
		
		return userNum;
		
	}
	
	public static String computer() {
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
		String computerNum = num1 + " " + num2 + " " + num3;
		
		return computerNum;
	}
	
	public static void run() {
			
			String cn = computer();
			
			System.out.println("정답은: " + cn);
			
			String un = user();
			
			System.out.println(un);
			
			String [] cnArr = cn.split(" ");
			String [] unArr = un.split(" ");
			
			int ball =0;
			int strike = 0;
			
			for(int i = 0; i < unArr.length; i++) {
				if(unArr[i].equals(cnArr[i])){
					strike += 1;
				}
				for(int j = 0; j < cnArr.length; j++) {
					if(i == j){
						continue;
					}
					if(unArr[i].equals(cnArr[j])) {
						ball += 1;
					}
					
				}
			}
			
			if(strike == 3) {
				System.out.println("정답입니다.");
			}else {
				System.out.println(ball + "볼 " + strike + "스트라이크입니다.");
			}

	}
	
	public static void main(String[] args) {		
		while(true) {				
			System.out.println("게임을 시작하시겠습니까? (y/n)");
			String start = scanner.next();	
			
			if(start.equals("y")) {
				run();
			}else if (start.equals("n")) {
				break;
			} else {
				System.out.println("다시 입력해주세요...");
			}
		}		
		System.out.println("게임을 종료합니다...");
		
		scanner.close();
	}
}
