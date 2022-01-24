import java.awt.event.MouseEvent;

public class inputs {

	storage s;
	
	// keyboard event table https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
	// mouse + other constants table https://docs.oracle.com/javase/7/docs/api/constant-values.html#java.awt.event.MouseEvent.BUTTON1
	
	public int mouse_left_press;
	public int mouse_scroll_press;
	public int mouse_right_press;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("inputs:start");
		set_defaults();
		get_user_preferences();
	}
	public void get_user_preferences()
	{
		s.debug.message("inputs:get_user_preferences");
		//PENDING WORK
	}
	public void set_defaults()
	{
		s.debug.message("inputs:set_defaults");
		mouse_left_press = MouseEvent.BUTTON1; // 1;
		mouse_scroll_press = MouseEvent.BUTTON2; // 2;
		mouse_right_press = MouseEvent.BUTTON3; // 3;
		
		// PENDING WORK OTHER KEYS NOT SET
	}
}