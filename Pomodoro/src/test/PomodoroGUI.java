package test;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class PomodoroGUI {
	
	private JFrame frmGUI;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PomodoroGUI window = new PomodoroGUI();
					window.frmGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PomodoroGUI() {
		initialize();
	}

	private void initialize() {
		frmGUI = new JFrame();
		frmGUI.setBounds(1342, 630, 200, 200);
		
	}
}
