package dbot;

public class ServerData extends Database {
	private int gems = 100;
	//längste online-zeit
	//flip-room id
	private int flipRoomID = 1;
	private String test = "test";
	private int daysOnline = 0;
	private int lottoPot = 420000;
	private int lastLottoDay = 1;

	ServerData() {}
	
	public void addGems(int aGems) {
		gems += aGems;
	}
	
	public boolean subGems(int sGems) {
		if ((gems - sGems) >= 0) {
			gems -= sGems;
			return true;
		}
		else {
			System.out.println("ACHTUNG: BANK LEER");
		}
		return false;
		
	}
	
	public int getGems() {
		return gems;
	}

	public int getFlipRoomID() {
		return flipRoomID;
	}

	void setFlipRoomID(int flipRoomID) {
		this.flipRoomID = flipRoomID;
	}

	public int getLottoPot() {
		return lottoPot;
	}

	public void setLottoPot(int lottoPot) {
		System.out.println("setting lottopot");
		this.lottoPot = lottoPot;
	}

	public int getLastLottoDay() {
		return lastLottoDay;
	}

	public void setLastLottoDay(int lastLottoDay) {
		System.out.println("setting lottoDay");
		this.lastLottoDay = lastLottoDay;
	}

	public int getDaysOnline() {
		return daysOnline;
	}

	public void addDay() {
		daysOnline += 1;
	}
}
