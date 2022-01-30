
public class OLD_panels {

	storage s;
	OLD_panel_launcher launcher;
	OLD_panel_mods mods;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("panels:start");
		launcher = new OLD_panel_launcher();
		mods = new OLD_panel_mods();
	}
}