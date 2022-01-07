import java.util.ArrayList;

public class Main {
	public static void main(String args[])
	{
		String build_number = "20220106";
		storage s = new storage();
		s.start(build_number);
		s.recursive_start(s, build_number);
		gui_bug gc = new gui_bug();
		gc.start(s);
	}
}
 