package no2;

public class player implements ability{

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("Player is moving backward");
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("Player is attacking turret");
		System.out.println("Player is attacking npc");
	}

	@Override
	public void buyitems() {
		// TODO Auto-generated method stub
		System.out.println("Player is buying gun");
	}

}
