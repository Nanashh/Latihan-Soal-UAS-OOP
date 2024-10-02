package UAS;

public class Robot extends Worker implements Perform {
	private String robottype;

	public Robot(String name, Integer stamina, String robottype) {
		super(name, stamina);
		this.robottype = robottype;
	}

	public String getRobottype() {
		return robottype;
	}

	public void setRobottype(String robottype) {
		this.robottype = robottype;
	}

	@Override
	public void menudisplay() {
		// TODO Auto-generated method stub
		if(this.getRobottype().equals("Chef")) {
		System.out.printf("class %s%s %11d\n", this.getRobottype(),this.getName(),this.getStamina());
		}
		else {
			System.out.printf("class %s%s %8d\n", this.getRobottype(),this.getName(),this.getStamina());
		}
	}

	@Override
	public void recharge() {
		// TODO Auto-generated method stub
		this.setStamina(this.getStamina()+1);
	}

	@Override
	public String gettype() {
		// TODO Auto-generated method stub
		return this.getRobottype();
	}
	

}
