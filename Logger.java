public class Logger {
	public static void main(String[] args) {
		Abc obj1 = Abc.getInstance(); // Getting the singleton instance
		Abc obj2 =Abc.getInstance();
		if(obj1==obj2) {
			System.out.println("Both logger instances are the same (singleton works)");  
		}else {
			 System.out.println("Different logger instances (singleton failed).");
		}
	}
}

class Abc {
	private static Abc obj1 = new Abc();  // Singleton instance

	private Abc() {                        // Private constructor
		// Prevent instantiation from outside
	}

	public static Abc getInstance() {      // Global access point
		return obj1;
		
	}
}
