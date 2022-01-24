
public class languages {

	storage s;
	lang_launcher launcher;
	lang_license license;
	lang_mods mods;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("languages:start");
		launcher = new lang_launcher();
		license = new lang_license();
		mods = new lang_mods();
	}
}