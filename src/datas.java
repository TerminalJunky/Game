
public class datas {

	storage s;
	data_button_grid grid;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("data:start");
		grid = new data_button_grid();
		grid.start(s);
	}
}
