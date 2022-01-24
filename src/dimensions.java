
public class dimensions {

	storage s;
	dimension_launcher launcher;
	dimension_mods mods;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("dimensions:start");
		launcher = new dimension_launcher();
		mods = new dimension_mods();
	}
	
}
