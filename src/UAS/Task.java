package UAS;

public class Task implements Perform{
	private String taskname;
	private Integer value;
	public Task(String taskname, Integer value) {
		super();
		this.taskname = taskname;
		this.value = value;
	}
	
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public void display() {
		System.out.println(taskname + ": "+ value);
	}

	@Override
	public void dotask() {
		// TODO Auto-generated method stub
		this.value-=1;
	}

	@Override
	public void recharge() {
		// TODO Auto-generated method stub
		this.value-=1;
	}
	
}
