package no2;

public class npc implements ability {

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("npc is moving forward");

	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("Friendly npc is attacking enemy");
		System.out.println("Enemey npc is attacking player");
	}

	@Override
	public void buyitems() {
		// TODO Auto-generated method stub
		System.out.println("Npc is buying shield");
	}

}
