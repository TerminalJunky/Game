import java.awt.Dimension;

public class Main {
	
	public static void main(String args[])
	{
		String build_number = "20220204";
		storage s = new storage();
		s.start(build_number);
		s.recursive_start(s, build_number);
	
		////s.gui.launcher.start(s);
		//s.gui.launcher.launch();
		
		//testing remove later
		//gui_test gt = new gui_test();
		//gt.start(s);	
		
		s.gui.game.launch(1280, 720);
		/*
		gui_game game = new gui_game();
		game.start(s);
		game.launch(1280, 720);
		
		data_game_grid dgg = new data_game_grid();
		dgg.start(s);
		Dimension dim = new Dimension(1280,720);
		dgg.launch("C:\\Users\\Bryan\\code\\Game\\offical\\default\\scenario\\0000.txt", dim);
		*/
		/*
		gui_game_v2 g2 = new gui_game_v2();
		g2.start(s);
		g2.launch(1280, 720);
		*/
	}
}