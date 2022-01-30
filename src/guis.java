
public class guis {

	storage s;
	OLD_gui_launcher launcher;
	OLD_gui_mods mods;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("guis:start");
		launcher = new OLD_gui_launcher();
		mods = new OLD_gui_mods();
	}
}