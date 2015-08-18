package beest.phonemouse;

import java.util.Scanner;

public class BluetoothServer {
	
	public static float sensitivity = 1.0f;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the mouse sensitivity (scalar multiple): ");
		sensitivity = scan.nextFloat();
		scan.close();
		Thread waitThread = new Thread(new WaitThread());
		waitThread.start();
	}
}
