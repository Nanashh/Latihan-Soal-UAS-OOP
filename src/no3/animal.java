package no3;

public abstract class animal implements movement{
	private String name;
	private String sound;
	private Integer age;
	private Integer type;
	
	public abstract void displayidentity();
	public void introduction() {
		System.out.println("Hello my name is "+ name);
	}
	
}
