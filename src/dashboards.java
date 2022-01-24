
public class dashboards {

	storage s;
	dash_launcher launcher;
	dash_mods mods;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("dashboards:start");
		launcher = new dash_launcher();
		mods = new dash_mods();
	}
}
