
public class OLD_languages {

	storage s;
	OLD_lang_launcher launcher;
	OLD_lang_license license;
	OLD_lang_mods mods;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("languages:start");
		launcher = new OLD_lang_launcher();
		license = new OLD_lang_license();
		mods = new OLD_lang_mods();
	}
}