
public class csv {

	public static void main(String[] args) {
		String csv = "홍길동,010-1111-2222,hkd@hkd.com";
		
		String [] ar = csv.split(",");
		
		for(String out : ar) {
			System.out.println(out);
		}
	}

}
