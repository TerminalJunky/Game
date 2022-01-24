
public class panels {

	storage s;
	panel_launcher launcher;
	panel_mods mods;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("panels:start");
		launcher = new panel_launcher();
		mods = new panel_mods();
	}
}