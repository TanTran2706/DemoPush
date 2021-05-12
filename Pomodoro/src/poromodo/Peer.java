package poromodo;

public class Peer {
	int minutePo;
	int secondsPo;

	public Peer(int minutePo, int secondsPo) {
		super();

		this.minutePo = minutePo;
		this.secondsPo = secondsPo;
	}

	public int getMinutePo() {
		return minutePo;
	}

	public void setMinutePo(int minutePo) {
		this.minutePo = minutePo;
	}

	public int getSecondsPo() {
		return secondsPo;
	}

	public void setSecondsPo(int secondsPo) {
		this.secondsPo = secondsPo;
	}

}
