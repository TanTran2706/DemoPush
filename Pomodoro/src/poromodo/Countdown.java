package poromodo;

import java.util.Timer;
import java.util.TimerTask;

public class Countdown extends TimerTask {

	Peer peer;
	Timer timer;

	public Countdown(Peer peer, Timer timer) {
		super();
		this.peer = peer;
		this.timer = timer;
	}

	@Override
	public void run() {
		if (peer.getMinutePo() == 0 && peer.getSecondsPo() == 1) {
			timer.cancel();
		}
		if (peer.getSecondsPo() == 0) {
			peer.setMinutePo(peer.getMinutePo() - 1);
			peer.setSecondsPo(60);
		}

		peer.setSecondsPo(peer.getSecondsPo() - 1);
		System.out.println(peer.getMinutePo() + " : " + peer.getSecondsPo());
		System.out.println(java.time.LocalTime.now());
	}
}
