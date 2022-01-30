public class storage {

	storage s;
	debug debug;
	in_out io;
	datas data;
	inputs input;
	events event;
	//old_assets asset;
	//dimensions dimension;
	guis gui;
	//dashboards dashboard;
	//panels panel;
	//languages lang;
	gui_file_manager file_manager;
	setting settings;
	
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
		//asset = new old_assets();
		gui = new guis();
		//dashboard = new dashboards();
		//dimension = new dimensions();
		//panel = new panels();
		//lang = new languages();
		file_manager = new gui_file_manager();
		settings = new setting();
	}
	public void recursive_start(storage store, String build_number)
	{
		s = store;
		debug.start(s, build_number);
		s.debug.message("storage:recursive_start");
		io.start(s);
		file_manager.start(s);
		settings.start(s);
		input.start(s);
		data.start(s);
		event.start(s);
		//asset.start(s);
		//asset.images.start(s);
		//asset.images.get_all_images();
		//lang.start(s);
		//dimension.start(s);
		//dashboard.start(s);
		//panel.start(s);
		gui.start(s);
	}
}