package UAS;

public class Human extends Worker implements Perform {

	public Human(String name, Integer stamina) {
		super(name, stamina);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void menudisplay() {
		// TODO Auto-generated method stub
		System.out.printf("class %s %15d\n", this.getName(),this.getStamina());
	}

	@Override
	public String gettype() {
		// TODO Auto-generated method stub
		return null;
	}


}
