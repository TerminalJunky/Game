
public class io_internal {

	storage s;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("io:io_internal:start");
	}
}
