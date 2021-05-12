package poromodo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PomodoroGui {

	private int delay = 1000;
	private int period = 1000;
	private JFrame frmPomo;
	private JLabel lblMinute;
	private JLabel lblSeconds;
	Peer peer = new Peer(25, 0);
	Timer timer = new Timer();
	Countdown countdown = new Countdown(peer, timer);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PomodoroGui window = new PomodoroGui();
					window.frmPomo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PomodoroGui() {
		initialize();
	}

	private void initialize() {
		frmPomo = new JFrame();
		frmPomo.setBounds(1342, 730, 200, 100);
		frmPomo.setAlwaysOnTop( true );
		frmPomo.setResizable(false);
		frmPomo.setUndecorated(true);
		frmPomo.getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		frmPomo.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		frmPomo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPomo.getContentPane().setLayout(null);
		frmPomo.setVisible(true);
		
		lblMinute = new JLabel(String.format("%02d", peer.getMinutePo()));
		lblMinute.setFont(new Font("Segoe UI", Font.PLAIN, 80));
		lblMinute.setBounds(0, 0, 90, 90);
		frmPomo.getContentPane().add(lblMinute);
		
		JLabel lblColon = new JLabel(":");
		lblColon.setFont(new Font("Segoe UI", Font.PLAIN, 80));
		lblColon.setBounds(85,0,20,90);
		frmPomo.getContentPane().add(lblColon);
		
		lblSeconds = new JLabel(String.format("%02d", peer.getSecondsPo()));
		lblSeconds.setFont(new Font("Segoe UI", Font.PLAIN, 80));
		lblSeconds.setBounds(100, 0, 90, 90);
		frmPomo.getContentPane().add(lblSeconds);
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			public void run() {
				if (peer.getMinutePo() == 0 && peer.getSecondsPo() == 1) {
					timer.cancel();
				}
				if (peer.getSecondsPo() == 0) {
					peer.setMinutePo(peer.getMinutePo() - 1);
					peer.setSecondsPo(60);
					lblMinute.setText(String.format("%02d", peer.getMinutePo()));
				}

				peer.setSecondsPo(peer.getSecondsPo() - 1);
				
				
				
				lblSeconds.setText(String.format("%02d", peer.getSecondsPo()));
				if (peer.getMinutePo() == 0 && peer.getSecondsPo() == 0) {
					JFrame dialog = new JFrame();
					dialog.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(dialog, "Bạn nên nghỉ ngơi 5 phút", "Pomodoro", JOptionPane.WARNING_MESSAGE);
					frmPomo.dispatchEvent(new WindowEvent(frmPomo, WindowEvent.WINDOW_CLOSING));
				}
			}
		}, delay, period);
		
	}
	 

}
