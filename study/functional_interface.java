package study;

@FunctionalInterface
interface MyInterface {
	void printMsg(String msg);
}

class MyApp {
	MyApp() {
		print(System.out::println);
	}
	void print(MyInterface arg) {
		arg.printMsg("Hello");
	}
}

public class functional_interface{
	public static void main(String[] args) {
		MyApp myapp=new MyApp();
	}
}
