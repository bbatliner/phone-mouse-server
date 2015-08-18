package beest.phonemouse;

import java.io.DataInputStream;
import java.io.InputStream;

import javax.microedition.io.StreamConnection;

public class ProcessConnectionThread implements Runnable {

	private StreamConnection mConnection;

	// Constant that indicate command from devices
	private static final float RMB = 123.456f;
	private static final float LMB = 654.321f;

	private float mAccelX;
	private float mAccelY;

	private static Mouse mouse;

	public ProcessConnectionThread(StreamConnection connection) {
		mConnection = connection;
		mouse = new Mouse();
		mouse.setSensitivity(BluetoothServer.sensitivity);
	}

	@Override
	public void run() {
		try {
			// prepare to receive data
			InputStream inputStream = mConnection.openInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);

			System.out.println("waiting for input");

			while (true) {
				float data = dataInputStream.readFloat();

				if (data == RMB) {
					mouse.rightClick();
				}
				else if (data == LMB) {
					mouse.leftClick();
				}
				else {
					mAccelX = data;
//					System.out.println("X: " + data);
					mAccelY = dataInputStream.readFloat();
//					System.out.println("Y: " + data);
					// read through the accelZ data
					dataInputStream.readFloat();
//					System.out.println("Z: " + data);
					// move the mouse with the current accelerometer readings
					moveMouse();
				}
			}
		} catch (Exception e) {
			System.out.println("Client disconnected.");
		}
	}

	private void moveMouse() {
		mouse.move((int) -mAccelX, (int) mAccelY);
	}
}