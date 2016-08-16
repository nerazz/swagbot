package dbot;

class ServerData extends DataBase {
	private int gems = 100;
	//l�ngste online-zeit
	//flip-room id
	private int flipRoomID = 1;
	private String test = "test";

	ServerData() {
		
	}
	
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

	public void setFlipRoomID(int flipRoomID) {
		this.flipRoomID = flipRoomID;
	}
	
}
