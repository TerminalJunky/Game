
public class OLD_dimensions {

	storage s;
	OLD_dimension_launcher launcher;
	OLD_dimension_mods mods;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("dimensions:start");
		launcher = new OLD_dimension_launcher();
		mods = new OLD_dimension_mods();
	}
	
}
