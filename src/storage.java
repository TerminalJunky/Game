
public class storage {

	storage s;
	debug debug;
	in_out io;
	
	public void start(String build_number)
	{
		System.out.println("storage:start:build_number:" + build_number);
		debug = new debug();
		io = new in_out();
	}
	public void recursive_start(storage store, String build_number)
	{
		s = store;
		debug.start(s, build_number);
		io.start(s);
	}
}
