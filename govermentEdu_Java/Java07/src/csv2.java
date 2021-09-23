
public class csv2 {

	public static void main(String[] args) {
		String csv = "EL201800001,CH201800021,EN12231";
		String [] ar = csv.split(",");
		for(int i = 0; i < ar.length; i++) {
			String t = ar[i].substring(0, 2);

			if(t.equals("EL")) {
				System.out.println("전자공학과");
			}else if(t.equals("CH")) {
				System.out.println("화학공학과");
			} else if(t.equals("EN")) {
				System.out.println("영어영문학과");
			}
		}
	}
}
