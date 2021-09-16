class Person{
	String name;
	public void speak() {
		System.out.println("speak");
	}
	public void eat() {
		System.out.println("eat");
	}
	public void walk() {
		System.out.println("walk");
	}
	public void sleep() {
		System.out.println("sleep");
	}
}

class Student extends Person {
	public void study() {
		System.out.println("study");
	}
}
class StudentWorker extends Student{
	public void work() {
		System.out.println("work");
	}
}

public class inheritanceTest {

	public static void main(String[] args) {
		//Person
		Person p = new Person();
		p.name = "김이박";
		System.out.println(p.name);
		p.sleep();
		
		//Student
		Student s = new Student();
		s.study();
		s.eat();
		s.name = "앱등이";
		System.out.println(s.name);
		
		//StudentWorker
		StudentWorker sw = new StudentWorker();
		sw.name = "갤럭시";
		sw.study();
		sw.work();
		System.out.println(sw.name);
		
	}

}
