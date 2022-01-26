import java.util.ArrayList;

public class lang_mods {
	
	storage s;
	String directory_texts;
	String directory_captions;
	String directory_labels;
	String directory_subtitles;
	ArrayList<String> labels;
	ArrayList<String> captions;
	ArrayList<String> texts;
	ArrayList<String> subtitles;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("lang_mods:start");
		set_language(s.settings.language_english);
		get_language_files();
	}
	public void set_language(String language_name)
	{
		if(language_name != null) {
		s.debug.message("lang_mods:set_language:" + language_name);
		directory_texts = s.io.external.directory_language_launcher + "texts" + 
                s.io.external.file_slash + s.settings.language_english + s.io.external.file_slash;
		
		directory_captions = s.io.external.directory_language_launcher + "captions" + 
      			 s.io.external.file_slash + s.settings.language_english + s.io.external.file_slash;
		
		directory_labels = s.io.external.directory_language_launcher + "labels" + 
      		   s.io.external.file_slash + s.settings.language_english + s.io.external.file_slash;
		
		directory_subtitles = s.io.external.directory_language_launcher + "texts" + 
					  s.io.external.file_slash + s.settings.language_english + s.io.external.file_slash;
		} else {
			s.debug.message("ERROR:lang_mods:set_langauge: null language_name");
		}
	}
	public void get_language_files()
	{
		s.debug.message("lang_mods:get_language_files");
		labels = new ArrayList<>();
		captions = new ArrayList<>();
		texts = new ArrayList<>();
		subtitles = new ArrayList<>();
		ArrayList<String> text_files = s.io.external.get_all_files_in_directory(directory_texts);
		ArrayList<String> caption_files = s.io.external.get_all_files_in_directory(directory_captions);
		ArrayList<String> label_files = s.io.external.get_all_files_in_directory(directory_labels);
		ArrayList<String> subtitle_files = s.io.external.get_all_files_in_directory(directory_subtitles);
		ArrayList<String> file_input;
		for(int x = 0; x < text_files.size(); x++) {
			file_input = s.io.external.read_file_utf8(text_files.get(x));
			for(int y = 0; y < file_input.size(); y++) {
				texts.add(file_input.get(y));
			}
		}
		for(int x = 0; x < caption_files.size(); x++) {
			file_input = s.io.external.read_file_utf8(caption_files.get(x));
			for(int y = 0; y < file_input.size(); y++) {
				captions.add(file_input.get(y));
			}
		}
		for(int x = 0; x < label_files.size(); x++) {
			file_input = s.io.external.read_file_utf8(label_files.get(x));
			for(int y = 0; y < file_input.size(); y++) {
				labels.add(file_input.get(y));
			}
		}
		for(int x = 0; x < subtitle_files.size(); x++) {
			file_input = s.io.external.read_file_utf8(subtitle_files.get(x));
			for(int y = 0; y < file_input.size(); y++) {
				subtitles.add(file_input.get(y));
			}
		}
	}
	public String get_label(int index)
	{
		s.debug.message("lang_mods:get_label:index:" + index);
		String temp = "";
		if(index < labels.size()) {
			temp = labels.get(index);
		}
		return temp;
	}
	public String get_caption(int index)
	{
		s.debug.message("lang_mods:get_caption:index:" + index);
		String temp = "";
		if(index < captions.size()) {
			temp = captions.get(index);
		}
		return temp;
	}
	public String get_text(int index)
	{
		s.debug.message("lang_mods:get_text:index:" + index);
		String temp = "";
		if(index < texts.size()) {
			temp = texts.get(index);
		}
		return temp;
	}
	public String get_subtitle(int index)
	{
		s.debug.message("lang_mods:get_subtitle:index:" + index);
		String temp = "";
		if(index < subtitles.size()) {
			temp = subtitles.get(index);
		}
		return temp;
	}
}
