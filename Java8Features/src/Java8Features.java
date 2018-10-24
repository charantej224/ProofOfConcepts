
public class Java8Features {
	
	public static void main(String[] args) {
		MyInterface myInterface = (n) -> {
			System.out.println("print hello message" + n);
		};
		myInterface.printMessage(" \nHello from input");
		
		MyInterface myInterface1 = (n) -> {
			System.out.println("whatever messages" + n);
		};
		myInterface1.printMessage("\n whatever message + ");
	}

}
