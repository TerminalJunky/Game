import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class gui_launcher {

	storage s;
	JFrame gui;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("gui_launcher:start");
	}
	public void launch()
	{
		s.lang.launcher.start(s);
		s.dimension.launcher.start(s);
		s.dashboard.launcher.start(s);
		s.panel.launcher.start(s);
		gui = new JFrame();
		gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		gui.setTitle("Launcher");
		gui.add(s.panel.launcher.background);
		gui.pack();
		gui.setVisible(true);
	}
	public void close()
	{
		s.gui.launcher.gui.dispose();
		s.lang.launcher = new lang_launcher();
		s.dimension.launcher = new dimension_launcher();
		s.dashboard.launcher = new dash_launcher();
		s.panel.launcher = new panel_launcher();
		s.gui.launcher = new gui_launcher();
		System.gc();
	}
}