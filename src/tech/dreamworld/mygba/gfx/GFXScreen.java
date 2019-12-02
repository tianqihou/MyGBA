package tech.dreamworld.mygba.gfx;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

public final class GFXScreen extends JComponent {

	private GFX gfx;
	private Image image;

	public GFXScreen(GFX gfx) {
		this.gfx = gfx;
		image = gfx.getImage();

		Dimension screenDimension = new Dimension(GFX.XScreenSize,
				GFX.YScreenSize);
		setMinimumSize(screenDimension);
		setMaximumSize(screenDimension);
		setPreferredSize(screenDimension);
		setDoubleBuffered(false);
	}

	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}

	public void clear() {
		gfx.reset();
	}

}
