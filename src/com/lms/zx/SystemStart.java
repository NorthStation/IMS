package com.lms.zx;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.jvnet.substance.skin.SubstanceBusinessBlueSteelLookAndFeel;

import com.lms.zx.view.LoginFrame;
public class SystemStart {
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel(new SubstanceBusinessBlueSteelLookAndFeel());
		} catch (Exception e) {
			System.out.println("Substance Raven Graphite failed to initialize");
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LoginFrame("ÓÃ»§µÇÂ¼").setVisible(true);
				//new MainFrameSystem().setVisible(true);
			}
		});
	}
}
