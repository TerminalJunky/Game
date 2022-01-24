
public class Main {
	
	public static void main(String args[])
	{
		String build_number = "20220123";
		storage s = new storage();
		s.start(build_number);
		s.recursive_start(s, build_number);
	
		s.gui.launcher.start(s);
		s.gui.launcher.launch();
		
		//testing remove later
		//gui_test gt = new gui_test();
		//gt.start(s);
	}
}