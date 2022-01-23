
public class storage {

	storage s;
	debug debug;
	in_out io;
	datas data;
	inputs input;
	events event;
	assets asset;
	
	//testing remove later
	gui_test gt;
	
	public void start(String build_number)
	{
		System.out.println("storage:start:build_number:" + build_number);
		debug = new debug();
		io = new in_out();
		input = new inputs();
		data = new datas();
		event = new events();
		asset = new assets();
	}
	public void recursive_start(storage store, String build_number)
	{
		s = store;
		debug.start(s, build_number);
		io.start(s);
		input.start(s);
		data.start(s);
		event.start(s);
		asset.start(s);
		asset.images.start(s);
		asset.images.get_all_images();
		
		//testing remove later
		gt = new gui_test();
		gt.start(s);
	}
}
