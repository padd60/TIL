import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BlockBinaryCopyEx {

	public static void main(String[] args) {
		File src = new File("/Users/kimjunghwan/Desktop/짤/chunsikWallPaper.png");
		
		File dest = new File("/Users/kimjunghwan/Desktop/chunsikCopy.png");
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo  = new FileOutputStream(dest);
			byte [] buf = new byte[1024*10];
			while(true) {
				int n = fi.read(buf);
				fo.write(buf,0,n);
				if(n < buf.length) {
					break;
				}
			}
			fi.close();
			fo.close();
			System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다.");
		}catch(Exception e){
			System.out.println("파일복사오류");
		}
	}

}
