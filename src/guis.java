
public class guis {

	storage s;
	gui_launcher launcher;
	gui_mods mods;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("guis:start");
		launcher = new gui_launcher();
		mods = new gui_mods();
	}
}