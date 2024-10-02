package no2;

public class enemy implements ability {

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("enemy is moving forward");
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("Enemy is attacking turret");
		System.out.println("Enemy is attacking npc");
	}

	@Override
	public void buyitems() {
		// TODO Auto-generated method stub
		System.out.println("Enemy is buying sword");
	}

}
