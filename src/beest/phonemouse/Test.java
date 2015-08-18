package beest.phonemouse;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		Mouse mouse = new Mouse();
		mouse.setSensitivity(1);
		for (int i = 0; i < 500; i++) {
			Thread.sleep(10);
			mouse.move(1, 1);
		}
	}
}
