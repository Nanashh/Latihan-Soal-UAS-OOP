package UAS;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<Worker> worker = new ArrayList<>();
	ArrayList<Task> task = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	
	public void randomtask() {
		Integer taskcook=0;
		Integer taskclean=0;
		Integer total;
		do {
			taskcook=((int)(Math.random()*7)+2);
			taskclean=((int)(Math.random()*7)+2);
			total=taskcook+taskclean;
		}while(total>8);
		task.add(new Task("Cooking tasks", taskcook));
		task.add(new Task("Cleaning tasks", taskclean));
	}
	public void genworker() {
		worker.add(new Human("Human",2));
		worker.add(new Human("Human",2));
	}
	public void taskdesc() {
		for(Task t: task) {
			t.display();
		}
	}
	public void availworker(int indexing) {
		worker.get(indexing).menudisplay();
	}
	public void mainmenu() {
		Integer menu=0;
		do{
		if(task.get(0).getValue()==0 && (task.get(1).getValue()+task.get(2).getValue())!=0) {//no remaining move
			System.out.println("No remaining moves left");
			System.out.println("YOU LOSE!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			break;
		}
		else if((task.get(1).getValue()+task.get(2).getValue())==0) {//no remaining task
			System.out.println("All Tasks are done");
			System.out.println("YOU WIN!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			break;
		}
		else if(worker.size()==4 && worker.get(2).gettype().equals(worker.get(3).gettype())&& (worker.get(0).getStamina()+worker.get(1).getStamina())==0) {
			//kondisi dimana worker sudah 4, human tidak ada stamina, namun task tersisa berbeda dengan robot yang tersedia
			if(task.get(1).getValue()!=0 && worker.get(2).gettype().equals("Cleaner") ) {
				System.out.println("There are no more helpers!");
				System.out.println("YOU LOSE!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			else if(task.get(2).getValue()!=0 && worker.get(2).gettype().equals("Chef")) {
				System.out.println("There are no more helpers!");
				System.out.println("YOU LOSE!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
		}
		
		taskdesc();
		System.out.println("----------------------------------");
		System.out.println("Helper type               Stamina ");
		System.out.println("----------------------------------");
		for(int i=0;i<worker.size();i++) {
		availworker(i);
		}
		System.out.println("----------------------------------");
		System.out.println("1. Buy new robot");
		System.out.println("2. Recharge a robot");
		System.out.println("3. Perform a cooking task");
		System.out.println("4. Perform a cleaning task");
		System.out.println("5. Exit");
		System.out.print(">>");
	
		try {
			menu=scan.nextInt();
		} catch (Exception e) {
			System.out.println("Numerical Value Needed!");
			// TODO: handle exception
		}
			scan.nextLine();
			
		switch(menu) {
			case 1:
				buyrobot();
				break;
			case 2:
				rechargerobot();
				break;
			case 3:
				cooktask();
				break;
			case 4:
				cleantask();
			case 5:
				break;
		}
		}while(menu!=5);
	}
	public void buyrobot(){
		if(worker.size()>=4) {
			System.out.println("You cannot buy more robots!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			return;
		}
		Integer menu=0;
		do {
			System.out.println("Choose Robot Type:");
			System.out.println("1. Chef Robot");
			System.out.println("2. Cleaner Robot");
			System.out.print(">>");
			try {
				menu=scan.nextInt();
			} catch (Exception e) {
				System.out.println("Numerical Value Needed!");
				// TODO: handle exception
			}
				scan.nextLine();
			switch(menu) {
				case 1:
					worker.add(new Robot("Robot",3,"Chef"));
					System.out.println("You bought a chef robot!");
					System.out.println("Press enter to continue...");
					scan.nextLine();
					break;
				case 2:
					worker.add(new Robot("Robot",3,"Cleaner"));
					System.out.println("You bought a cleaner robot!");
					System.out.println("Press enter to continue...");
					scan.nextLine();
					break;
			}
		}while(menu<1 || menu>2);
	}
	
	public void rechargerobot(){
		if(worker.size()<=2) {
			System.out.println("You do not have any robots!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			return;
		}
		Integer menu=0;
		do {
			System.out.println("----------------------------------------");
			System.out.println("No.   Helper type               Stamina ");
			System.out.println("----------------------------------------");
			for(int i=0;i<worker.size();i++) {
				if(worker.get(i).getName().equals("Robot")) {
					System.out.printf("%-6d",i-1);
					availworker(i);
				}
			}
			System.out.println("----------------------------------------");
			System.out.println("Enter robot number to recharge");
			System.out.print(">>");
			try {
				menu=scan.nextInt();
			} catch (Exception e) {
				System.out.println("Numerical Value Needed!");
				// TODO: handle exception
			}
				scan.nextLine();
		}while(menu>worker.size()-2 || menu<=0);
		menu+=1;
		if(worker.get(menu).getStamina()>=3) {
			System.out.println("This robot has full stamina");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			return;
		}
		else {
			worker.get(menu).recharge();
			task.get(0).recharge();;
		}
	}
	
	public Integer checker(String type) {
		int marker=0;
		int counter=0;
		for(int i=0;i<worker.size();i++) {
			if(worker.get(i).getName().equals("Robot") && worker.get(i).gettype().equals(type) && worker.get(i).getStamina()!=0) {
				marker=i;
				counter++;
				break;
			}
		}
		if(counter==0) {
			for(int i=0;i<worker.size();i++) {
				if(worker.get(i).getName().equals("Human") && worker.get(i).getStamina()!=0) {
					marker=i;
					counter++;
					break;
				}
			}
		}
		if(counter==0) {
			return -1;
		}
		return marker;
	}
	
	public void cooktask(){
		if(task.get(1).getValue()==0) {
			System.out.println("There are no cooking tasks left!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			return;
		}
		int marker=checker("Chef");
		if(marker==-1) {
			System.out.println("There are no available helpers to cook!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			return;
		}
		worker.get(marker).dotask();
		task.get(1).dotask();
		task.get(0).dotask();
		if(worker.get(marker).getName().equals("Human")) {
			System.out.println(worker.get(marker).getName()+" finished a cooking task!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			return;
		}
		else if(worker.get(marker).getName().equals("Robot")) {
			System.out.println(worker.get(marker).gettype()+" "+worker.get(marker).getName()+" finished a cooking task!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			return;
		}
	}
	
	public void cleantask(){
		if(task.get(2).getValue()==0) {
			System.out.println("There are no cleaning tasks left!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			return;
		}
		int marker=checker("Cleaner");
		if(marker==-1) {
			System.out.println("There are no available helpers to clean!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			return;
		}
		worker.get(marker).dotask();
		task.get(2).dotask();
		task.get(0).dotask();
		if(worker.get(marker).getName().equals("Human")) {
			System.out.println(worker.get(marker).getName()+" finished a cleaning task!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			return;
		}
		else if(worker.get(marker).getName().equals("Robot")) {
			System.out.println(worker.get(marker).gettype()+" "+worker.get(marker).getName()+" finished a cleaning task!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			return;
		}
	}


	
	public Main() {
		System.out.println("Nama : Bernardus Ignasio");
		System.out.println("NIM  : 2602063913");
		System.out.println("Kelas: LA01");
		System.out.println("");
		task.add(new Task("Remaining moves",10));
		randomtask();
		genworker();
		mainmenu();
	}
}
