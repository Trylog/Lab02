package pkgData;

public class Jug {
	private int tasteId;
	private int volume;
	private int bestDestination=-1;
	public Jug(int tasteId, int volume){

		this.tasteId=tasteId;
		this.volume=volume;
	}
	public int getTasteId() {
		return tasteId;
	}
	public int getVolume() {
		return volume;
	}
	public void subtractVolume(int volume) {
		this.volume -= volume;
	}
	public int getBestDestination() {
		return bestDestination;
	}
	public void setBestDestination(int bestDestination) {
		this.bestDestination = bestDestination;
	}
}
