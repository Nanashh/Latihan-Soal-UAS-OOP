package UAS;

public abstract class Worker implements Perform{
	private String name;
	private Integer Stamina;
	public Worker(String name, Integer stamina) {
		super();
		this.name = name;
		Stamina = stamina;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStamina() {
		return Stamina;
	}
	public void setStamina(Integer stamina) {
		Stamina = stamina;
	}
	
	public abstract void menudisplay();
	public abstract String gettype();

	@Override
	public void dotask() {
		// TODO Auto-generated method stub
		this.setStamina(this.getStamina()-1);
	}

	@Override
	public void recharge() {
		// TODO Auto-generated method stub
		
	}
	
}
