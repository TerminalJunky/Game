import java.util.ArrayList;

public class setting {

	storage s;
	
	String directory_settings;
	
	String language_native;
	String language_english;
	
	String file_language_native;
	String file_language_english;
	String file_language_preferred;
	
	ArrayList<String> possible_languages_native;
	ArrayList<String> possible_languages_english;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("settings:start");
		launch();
	}
	public void launch()
	{
		directory_settings = s.io.external.directory_primary + "settings" + s.io.external.file_slash;
		file_language_native = directory_settings + "language_native.txt";
		file_language_english = directory_settings + "language_english.txt";
		file_language_preferred = directory_settings + "language_preferred.txt";
		possible_languages_english = s.io.external.read_file_utf8(file_language_english);
		possible_languages_native = s.io.external.read_file_utf8(file_language_native);
		set_language(get_preferred_language());
	}
	public String get_preferred_language()
	{
		ArrayList<String> temp = s.io.external.read_file_utf8(file_language_preferred);
		if(temp.size() < 1) {
			return "english";
		}
		return temp.get(0);
	}
	public void set_language(String language)
	{
		if(language == null) {
			s.debug.message("ERROR:settings:set_language: null language setting to english");
			language = "english";
		}
			s.debug.message("settings:set_language:" + language);
			language_english = language.toLowerCase();
			int index = search_first_index_arraylist(language_english, possible_languages_english);
			if(index < 0) {
				s.debug.message("ERROR:settings:set_language:language not found setting to english");
				language_native = "english";
				language_english = "english";
			} else {
				language_native = possible_languages_native.get(index);
			} 
	}
	public int search_first_index_arraylist(String search, ArrayList<String> source)
	{
		int index = -1;
		int source_size = source.size(); 
		for(int x = 0; x < source_size; x++) {
			if(source.get(x).equalsIgnoreCase(search)) {
				index = x;
				x = source_size;
			}
		}
		return index;
	}
}
