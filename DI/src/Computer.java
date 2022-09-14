
public class Computer {

	//private Hardisk harDisk = new Hardisk();
	private Hardisk harDisk;
	
	public Computer(Hardisk hardisk) { // inject via consturctor
		this.harDisk = hardisk;
	}
	public Computer() 
	{
		
	}
	public void setHarDisk(Hardisk harDisk) { // inject vai setter
		this.harDisk = harDisk;
	}
	public void execute() {
		harDisk.storage();
		System.out.println("exexute method");
	}
}
