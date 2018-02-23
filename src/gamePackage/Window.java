package gamePackage;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.text.IconView;

public class Window extends Canvas{
	public static final long serialVersionUID = -240840600533728354L;
	public Window (final float width, final float height, final String title, final Game game) {
		final JFrame frame = new JFrame(title);
		frame.setPreferredSize(new Dimension((int)width, (int)height));
		frame.setMaximumSize(new Dimension((int)width, (int)height));
		frame.setMinimumSize(new Dimension((int)width, (int)height));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}


}
