import java.awt.Dimension;

public class OLD_dimension_launcher {

	storage s;
	Dimension buttons;
	Dimension drop_downs;
	Dimension labels;
	Dimension background;
	Dimension spacers;
	Dimension row;
	Dimension gaps;
	Dimension bottom;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("dimension_launcher:start");
		create_dimensions();
		set_dimensions();
	}
	public void create_dimensions()
	{
		background = new Dimension();
		buttons = new Dimension();
		spacers = new Dimension();
		row = new Dimension();
		gaps = new Dimension();
		labels = new Dimension();
		drop_downs = new Dimension();
		bottom = new Dimension();
	}
	public void set_dimensions()
	{
		background.setSize(480, 442);
		buttons.setSize(240, 60);
		spacers.setSize(120, 60);
		row.setSize(480,60);
		gaps.setSize(480, 16);
		labels.setSize(80, 60);
		drop_downs.setSize(160, 60);
		bottom.setSize(480, 30);
	}
}