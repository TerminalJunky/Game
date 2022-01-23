
public class events {
	
	storage s;
	event_grid grid;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("event:start");
		grid = new event_grid();
		grid.start(s);
	}
}
