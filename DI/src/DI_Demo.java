
public class DI_Demo {

	public static void main(String[] args) {
		var hardisk = new Hardisk();
		//var computer = new Computer(hardisk);
		var computer = new Computer();
		
		computer.setHarDisk(hardisk);
		computer.execute();
	}
}
