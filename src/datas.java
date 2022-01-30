
public class datas {

	storage s;
	OLD_data_button_grid grid;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("data:start");
		grid = new OLD_data_button_grid();
		grid.start(s);
	}
}
