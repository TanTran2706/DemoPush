package poromodo;

import java.util.Timer;

public class PomodoroCore {
	
	public static void main(String[] args) {
		
		Peer peer = new Peer(0,5);
		Timer timer = new Timer();
		Countdown countdown = new Countdown(peer, timer);
		System.out.println(java.time.LocalTime.now());
		timer.scheduleAtFixedRate(countdown, 1000, 1000);
	}
	
}
