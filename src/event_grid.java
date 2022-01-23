
public class event_grid {

	storage s;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("event_grid:start");
	}
	public void grid_press(int row, int column)
	{
		s.debug.message("event_grid:grid_press:row:" + row + ":column:" + column);
		// WORK PENDING NOTHING DONE YET
	}
	public void grid_left_click(int row, int column)
	{
		s.debug.message("event_grid:grid_left_click:row:" + row + ":" + column);
		// WORK PENDING NOTHING DONE YET
	}
	public void grid_right_click(int row, int column)
	{
		s.debug.message("event_grid:grid_right_click:row:" + row + ":" + column);
		// WORK PENDING NOTHING DONE YET
	}
	public void grid_scroll_wheel_pressed(int row, int column)
	{
		s.debug.message("event_grid_grid_scroll_wheel_pressed:row:" + row + ":column:" + column);
		// WORK PENDING NOTHING DONE YET
	}
	public void grid_scroll_up(int row, int column)
	{
		s.debug.message("io_external:grid_scroll_up:row:" + row + ":" + column);
		// WORK PENDING NOTHING DONE YET
	}
	public void grid_scroll_down(int row, int column)
	{
		s.debug.message("io_external:grid_scroll_down:row:" + row + ":" + column);
		// WORK PENDING NOTHING DONE YET
	}
	
	
}
