
public class in_out {

	storage s;
	io_external external;
	io_internal internal;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("io:start");
		internal = new io_internal();
		internal.start(s);
		external = new io_external();
		external.start(s);
	}
}
