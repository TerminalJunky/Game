
public class event_controls {

	storage s;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("event_controls:start");
	}
	public void load_game(String file_name)
	{
		s.debug.message("event_controls:load_game");
		//PENDING WORK GAME LOADING INCOMPLETE
	}
}
