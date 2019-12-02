package tech.dreamworld.mygba.ui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public final class MyGBAFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MyGBAFrame() {
		super("MyGBA");

		setLocation(0, 0);
		setResizable(false);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MyGBAApplet mygbaApple = new MyGBAApplet(false);
		mygbaApple.init();

		MyGBAFrame ygbaFrame = new MyGBAFrame();
		ygbaFrame.add(mygbaApple);
		ygbaFrame.pack();
		ygbaFrame.setVisible(true);
	}

}