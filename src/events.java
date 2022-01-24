
public class events {
	
	storage s;
	event_grid grid;
	event_controls controls;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("event:start");
		grid = new event_grid();
		controls = new event_controls();
		grid.start(s);
		controls.start(s);
	}
}
