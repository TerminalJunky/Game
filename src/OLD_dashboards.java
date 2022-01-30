
public class OLD_dashboards {

	storage s;
	OLD_dash_launcher launcher;
	OLD_dash_mods mods;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("dashboards:start");
		launcher = new OLD_dash_launcher();
		mods = new OLD_dash_mods();
	}
}
