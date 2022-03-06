import java.awt.Dimension;

public class datas {

	storage s;
	//OLD_data_button_grid grid;
	data_game_grid grid;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("data:start");
		//grid = new OLD_data_button_grid();
		//grid.start(s);
		grid = new data_game_grid();
		grid.start(s);
	}
}
