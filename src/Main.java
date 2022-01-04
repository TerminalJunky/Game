import java.util.ArrayList;

public class Main {
	public static void main(String args[])
	{
		String build_number = "20220102";
		storage s = new storage();
		s.start(build_number);
		s.recursive_start(s, build_number);
		
		s.io.external.print_read_file(null);
	}
}
 