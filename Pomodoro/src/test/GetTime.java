package test;

import java.util.Timer;
import java.util.TimerTask;

public class GetTime {
	static int interval;
	static Timer timer;
	public static void main(String[] args) throws InterruptedException {
	}
	
	public static void countdown() {
	    int delay = 1000;
	    int period = 1000;
	    String secs = "10";
	    timer = new Timer();
	    interval = Integer.parseInt(secs);
	    System.out.println(secs);
		timer.scheduleAtFixedRate(new TimerTask() {

	        public void run() {
	            System.out.println(setInterval());
	            System.out.println(java.time.LocalTime.now());
	            
	        }
	    }, delay, period);
	}

	private static final int setInterval() {
	    if (interval == 1)
	        timer.cancel();
	    return --interval;
	}
	
	
}
