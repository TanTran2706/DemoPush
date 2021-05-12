package test;

import java.util.Timer;

public class DemoTaskOnce {
	public static void main(String[] args) {
		MyTask myTask = new MyTask();
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(myTask, 1000, 1000);
	}
}
