package beest.phonemouse;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Mouse {

	private float sensitivity;
	private static Robot r;

	public Mouse() {
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public float getSensitivity() {
		return sensitivity;
	}

	public void setSensitivity(float sensitivity) {
		this.sensitivity = sensitivity;
	}

	public void move(int dx, int dy) {
		Point curPos = MouseInfo.getPointerInfo().getLocation();
		r.mouseMove(curPos.x + (int) (dx*sensitivity), curPos.y + (int) (dy*sensitivity));
	}

	public void leftClick() {
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	public void rightClick() {
		r.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		r.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
	}
}
