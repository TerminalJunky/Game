
public class guis {

	storage s;
	//OLD_gui_launcher launcher;
	//OLD_gui_mods mods;
	gui_game game;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("guis:start");
		game = new gui_game();
		game.start(s);
		
		//launcher = new OLD_gui_launcher();
		//mods = new OLD_gui_mods();
	}
}