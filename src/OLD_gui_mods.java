import javax.swing.JFrame;

public class OLD_gui_mods {

	storage s;
	JFrame gui;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("gui_mods:start");
	}
	public void launch()
	{
		
	}
	public void close()
	{
		//s.gui.mods.gui.dispose();
		//s.lang.mods = new lang_mods();
		//s.dimension.mods = new dimension_mods();
		//s.dashboard.mods = new dash_mods();
		//s.panel.mods = new panel_mods();
		//s.gui.mods = new OLD_gui_mods();
		System.gc();
	}
}