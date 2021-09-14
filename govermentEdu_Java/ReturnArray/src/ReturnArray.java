
public class ReturnArray {
	
	static int[] makeArray() { // 메서드 생성
		int[] temp = new int [4]; // 배열 생성
		for(int i = 0; i<temp.length; i++) { // 배열 인덱스 값 0 1 2 3으로 초기화
			temp[i] = i;
		}
		return temp; // 배열을 가르키는 참조값 리턴
	}

	public static void main(String[] args) {
		int[] intArray; // 배열 참조변수 선언
		intArray = makeArray(); // 메서드 실행해 배열 전달받음
		for(int i = 0; i<intArray.length; i++) { // 배열 원소 출력
			System.out.print(intArray[i] + " ");
		}
	}

}
