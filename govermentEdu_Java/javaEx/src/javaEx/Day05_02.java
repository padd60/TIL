package javaEx;

class Student{
	String name;
	String sub;
	public Student() {};
	public Student(String name, String sub){
		this.name = name;
		this.sub = sub;
	}
}

public class Day05_02 {

	public static void main(String[] args) {
		Student s = new Student("춘식이", "컴퓨터공학과");
		System.out.print(s.name + " : " + s.sub);
	}

}
