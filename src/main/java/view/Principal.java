package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	public Principal() {

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		JTabbedPane tabedPane = new JTabbedPane();

		tabedPane.add("Primer Panel", new Ventana());

		this.setMinimumSize(new Dimension(800, 600));

		this.setContentPane(tabedPane);
	}

	/**
	 * Create the frame.
	 */
	public static void main(String[] args) {
		Principal v = new Principal();
		v.setVisible(true);
	}

}
