import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.sound.sampled.Clip;

public class asset {
	
	/*
	Sound use Clip found here limited to .wav mostly
	https://docs.oracle.com/javase/tutorial/sound/playing.html
	
	References
	scale_method
	https://docs.oracle.com/javase/7/docs/api/java/awt/image/AffineTransformOp.html#TYPE_BICUBIC
	https://docs.oracle.com/javase/7/docs/api/constant-values.html#java.awt.image.AffineTransformOp.TYPE_BICUBIC
	
	scale_type 
	https://docs.oracle.com/javase/7/docs/api/java/awt/Image.html
	https://docs.oracle.com/javase/7/docs/api/constant-values.html#java.awt.Image.SCALE_SMOOTH
	
	example code
	https://stackoverflow.com/questions/4216123/how-to-scale-a-bufferedimage
	 */
	
	storage s;
	
	String file_slash;
	String language;
	
	String directory_primary;
	String directory_images;
	String directory_audio;
	String directory_audio_music;
	String directory_audio_speech;
	String directory_audio_sounds;
	String directory_language;
	String directory_language_texts;
	String directory_language_captions;
	String directory_language_labels;
	String directory_language_subtitles;
	String directory_images_layer_0;
	String directory_images_layer_1;
	String directory_images_layer_2;
	String directory_images_layer_3;
	String directory_images_layer_4;
	String directory_images_layer_5;
	String directory_images_layer_6;
	String directory_images_layer_7;
	String directory_images_layer_8;
	String directory_images_layer_9;

	ArrayList<String> labels;
	ArrayList<String> captions;
	ArrayList<String> texts;
	ArrayList<String> subtitles;
	
	ArrayList<BufferedImage> source_layer_0;
	ArrayList<BufferedImage> source_layer_1;
	ArrayList<BufferedImage> source_layer_2;
	ArrayList<BufferedImage> source_layer_3;
	ArrayList<BufferedImage> source_layer_4;
	ArrayList<BufferedImage> source_layer_5;
	ArrayList<BufferedImage> source_layer_6;
	ArrayList<BufferedImage> source_layer_7;
	ArrayList<BufferedImage> source_layer_8;
	ArrayList<BufferedImage> source_layer_9;
	
	ArrayList<BufferedImage> scaled_layer_0;
	ArrayList<BufferedImage> scaled_layer_1;
	ArrayList<BufferedImage> scaled_layer_2;
	ArrayList<BufferedImage> scaled_layer_3;
	ArrayList<BufferedImage> scaled_layer_4;
	ArrayList<BufferedImage> scaled_layer_5;
	ArrayList<BufferedImage> scaled_layer_6;
	ArrayList<BufferedImage> scaled_layer_7;
	ArrayList<BufferedImage> scaled_layer_8;
	ArrayList<BufferedImage> scaled_layer_9;
	
	BufferedImage black;
	BufferedImage clear;
	
	int source_width;
	int source_height;
	int width;
	int height;
	
	ArrayList<Clip> music;
	ArrayList<Clip> sounds;
	ArrayList<Clip> speech;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("asset:start");
	}
	public void launch(String directory_root)
	{
		if(directory_root != null) {
			s.debug.message("asset:launch:" + directory_root);
			set_language(s.settings.file_language_preferred);
			//PENDING GET_IMAGE SCALE INCOMPLETE
			set_directories(directory_root);
			get_language_files();
		} else {
			s.debug.message("asset:launch:null directory_root");
		}
	}
	public void set_directories(String directory_root)
	{
		if(directory_root != null) {
		directory_primary = directory_root;
			if(s.settings.file_language_preferred != null) {
				language = s.settings.file_language_preferred;
			} else {
				language = "english";
			}
			set_images(directory_primary);
			set_language(directory_primary);
			set_audio(directory_primary);
			get_language_files();
		} else {
			s.debug.message("ERROR:asset:set_directories:null directory_root");
		}
	}
	public void set_image_scale(int image_scale_x, int image_scale_y)
	{
		s.debug.message("asset:image_scale:width:" + image_scale_x + ":height:" + image_scale_y);
		width = image_scale_x;
		height = image_scale_y;
	}
	public void set_images(String directory_primary)
	{
		if(directory_primary != null) {
			s.debug.message("asset:get_images:" + directory_primary);
			directory_images = directory_primary + "images" + file_slash;
			directory_images_layer_0 = directory_images + "layer_0" + file_slash;
			directory_images_layer_1 = directory_images + "layer_1" + file_slash;
			directory_images_layer_2 = directory_images + "layer_2" + file_slash;
			directory_images_layer_3 = directory_images + "layer_3" + file_slash;
			directory_images_layer_4 = directory_images + "layer_4" + file_slash;
			directory_images_layer_5 = directory_images + "layer_5" + file_slash;
			directory_images_layer_6 = directory_images + "layer_6" + file_slash;
			directory_images_layer_7 = directory_images + "layer_7" + file_slash;
			directory_images_layer_8 = directory_images + "layer_8" + file_slash;
			directory_images_layer_9 = directory_images + "layer_9" + file_slash;
			
			black = s.io.external.get_image(s.io.external.file_images_black);
			clear = s.io.external.get_image(s.io.external.file_images_clear);
			
			/* must be set to 0 is black, 1 is clear for all arraylists as default values*/
			source_layer_0 = s.io.external.get_all_images(directory_images_layer_0);
			source_layer_1 = s.io.external.get_all_images(directory_images_layer_1);
			source_layer_2 = s.io.external.get_all_images(directory_images_layer_2);
			source_layer_3 = s.io.external.get_all_images(directory_images_layer_3);
			source_layer_4 = s.io.external.get_all_images(directory_images_layer_4);
			source_layer_5 = s.io.external.get_all_images(directory_images_layer_5);
			source_layer_6 = s.io.external.get_all_images(directory_images_layer_6);
			source_layer_7 = s.io.external.get_all_images(directory_images_layer_7);
			source_layer_8 = s.io.external.get_all_images(directory_images_layer_8);
			source_layer_9 = s.io.external.get_all_images(directory_images_layer_9);
			
			source_layer_0.add(0, clear);
			source_layer_1.add(0, clear);
			source_layer_2.add(0, clear);
			source_layer_3.add(0, clear);
			source_layer_4.add(0, clear);
			source_layer_5.add(0, clear);
			source_layer_6.add(0, clear);
			source_layer_7.add(0, clear);
			source_layer_8.add(0, clear);
			source_layer_9.add(0, clear);
			
			source_layer_0.add(0, black);
			source_layer_1.add(0, black);
			source_layer_2.add(0, black);
			source_layer_3.add(0, black);
			source_layer_4.add(0, black);
			source_layer_5.add(0, black);
			source_layer_6.add(0, black);
			source_layer_7.add(0, black);
			source_layer_8.add(0, black);
			source_layer_9.add(0, black);
			
			//PENDING WORK THIS IS FOR TESTING NOT FINAL SPOT
			get_rescaled_sources(width,  height);
			get_rescaled_grid_images(width, height);
		} else {
			s.debug.message("asset:set_images: null directory_primary");
		}
	}
	public BufferedImage get_rescaled_image(BufferedImage source, int image_scale_x, int image_scale_y)
	{
		s.debug.message("asset:get_rescaled_image");
		Image origonal = source.getScaledInstance(image_scale_x, image_scale_y, source.getType());
		BufferedImage resized = new BufferedImage(image_scale_x, image_scale_y, source.getType());
		Graphics2D graphic = resized.createGraphics();
		graphic.drawImage(origonal, 0, 0, null);
		graphic.dispose();
		return resized;
	}
	public void get_rescaled_sources(int image_scale_x, int image_scale_y)
	{
		s.debug.message("asset_images:get_rescaled_sources");
		for(int x = 0; x < source_layer_0.size(); x++) {
			source_layer_0.set(x, get_rescaled_image(source_layer_0.get(x), image_scale_x, image_scale_y));
		}
		for(int x = 0; x < source_layer_0.size(); x++) {
			source_layer_1.set(x, get_rescaled_image(source_layer_1.get(x), image_scale_x, image_scale_y));
		}
		for(int x = 0; x < source_layer_0.size(); x++) {
			source_layer_2.set(x, get_rescaled_image(source_layer_2.get(x), image_scale_x, image_scale_y));
		}
		for(int x = 0; x < source_layer_0.size(); x++) {
			source_layer_3.set(x, get_rescaled_image(source_layer_3.get(x), image_scale_x, image_scale_y));
		}
		for(int x = 0; x < source_layer_0.size(); x++) {
			source_layer_4.set(x, get_rescaled_image(source_layer_4.get(x), image_scale_x, image_scale_y));
		}
		for(int x = 0; x < source_layer_0.size(); x++) {
			source_layer_5.set(x, get_rescaled_image(source_layer_5.get(x), image_scale_x, image_scale_y));
		}
		for(int x = 0; x < source_layer_0.size(); x++) {
			source_layer_6.set(x, get_rescaled_image(source_layer_6.get(x), image_scale_x, image_scale_y));
		}
		for(int x = 0; x < source_layer_0.size(); x++) {
			source_layer_7.set(x, get_rescaled_image(source_layer_7.get(x), image_scale_x, image_scale_y));
		}
		for(int x = 0; x < source_layer_0.size(); x++) {
			source_layer_8.set(x, get_rescaled_image(source_layer_8.get(x), image_scale_x, image_scale_y));
		}
		for(int x = 0; x < source_layer_0.size(); x++) {
			source_layer_9.set(x, get_rescaled_image(source_layer_9.get(x), image_scale_x, image_scale_y));
		}
	}
	public void get_rescaled_grid_images(int image_scale_x, int image_scale_y)
	{
		s.debug.message("asset_images:get_rescaled_grid_images");
		for(int x = 0; x < source_layer_0.size(); x++) {
			scaled_layer_0.add(get_rescaled_image(source_layer_0.get(x), image_scale_x, image_scale_y));
		}
		for(int x = 0; x < source_layer_1.size(); x++) {
			scaled_layer_1.add(get_rescaled_image(source_layer_1.get(x), image_scale_x, image_scale_y));
		}
		for(int x = 0; x < source_layer_2.size(); x++) {
			scaled_layer_2.add(get_rescaled_image(source_layer_2.get(x), image_scale_x, image_scale_y));
		}
		for(int x = 0; x < source_layer_3.size(); x++) {
			scaled_layer_3.add(get_rescaled_image(source_layer_3.get(x), image_scale_x, image_scale_y));
		}
		for(int x = 0; x < source_layer_4.size(); x++) {
			scaled_layer_4.add(get_rescaled_image(source_layer_4.get(x), image_scale_x, image_scale_y)); 
		}
		for(int x = 0; x < source_layer_5.size(); x++) {
			scaled_layer_5.add(get_rescaled_image(source_layer_5.get(x), image_scale_x, image_scale_y));
		}
		for(int x = 0; x < source_layer_6.size(); x++) {
			scaled_layer_6.add(get_rescaled_image(source_layer_6.get(x), image_scale_x, image_scale_y));
		}
		for(int x = 0; x < source_layer_7.size(); x++) {
			scaled_layer_7.add(get_rescaled_image(source_layer_7.get(x), image_scale_x, image_scale_y));
		}
		for(int x = 0; x < source_layer_8.size(); x++) {
			scaled_layer_8.add(get_rescaled_image(source_layer_8.get(x), image_scale_x, image_scale_y));
		}
		for(int x = 0; x < source_layer_9.size(); x++) {
			scaled_layer_9.add(get_rescaled_image(source_layer_9.get(x), image_scale_x, image_scale_y));
		}
	}
	public void set_audio(String directory_primary)
	{
		if(directory_primary != null) {
			s.debug.message("asset:set_audio:" + directory_primary);
			directory_audio = directory_primary + "audio" + file_slash;
			directory_audio_sounds = directory_audio + "sound" + file_slash;
			directory_audio_music = directory_audio + "music" + file_slash;
			directory_audio_speech = directory_audio + "speech" + file_slash;
		
			sounds = new ArrayList<>();
			music = new ArrayList<>();
			speech = new ArrayList<>();
		
			ArrayList<String> file_names = get_all_audio_file_names(directory_audio_sounds);	
			for(int x = 0; x < file_names.size(); x++){
				sounds.add(get_file_to_audio_clip(file_names.get(x)));
			}
			file_names = get_all_audio_file_names(directory_audio_music);
			for(int x = 0; x < file_names.size(); x++){
				music.add(get_file_to_audio_clip(file_names.get(x)));
			}
			file_names = get_all_audio_file_names(directory_audio_speech);
			for(int x = 0; x < file_names.size(); x++){
				speech.add(get_file_to_audio_clip(file_names.get(x)));
			}
		} else {
			s.debug.message("ERROR:asset:directory_audio:null directory_primary");
		}
	}
	public ArrayList<String> get_all_audio_file_names(String directory_source)
	{
		ArrayList<String> file_names = new ArrayList<>();
		if(directory_source != null) {
			s.debug.message("asset:get_all_audio_file_names");
			// Clips is native to java doesn't support much use wav
			ArrayList<String> valid_extensions = new ArrayList<>();
			valid_extensions.add("wav");
			file_names = s.io.external.get_files_of_extension_type(directory_source, valid_extensions);
		} else {
			 s.debug.message("ERROR:asset:get_all_audio_file_names: null directory_source");
		}
		return file_names;
	}
	public Clip get_file_to_audio_clip(String file_name)
	{
		if(file_name != null) {
			s.debug.message("asset:get_file_to_audio_clip:" + file_name);
		} else {
			s.debug.message("ERROR:asset_get_file_to_audio_clip:null file_name");
		}
		s.debug.message("ERROR:asset:get_file_to_audio:clip:PENDING WORK NOTHING DONE: AUTO NULL");
		// PENDING WORK NOTHING DONE SEE ABOVE FOR REFERENCE
		return null;
	}
	public void set_language(String language_name)
	{
		if(language_name != null) {
		s.debug.message("asset:set_language:" + language_name);
		directory_language = directory_primary + "language" + file_slash + language + file_slash;
		directory_language_captions = directory_language + "captions" + file_slash;
		directory_language_labels = directory_language + "labels" + file_slash;
		directory_language_subtitles = directory_language + "subtitles" + file_slash;
		directory_language_texts = directory_language + "texts" + file_slash;
		} else {
			s.debug.message("ERROR:lang_launcher:set_langauge: null language_name");
		}
		get_language_files();
	}
	public void get_language_files()
	{
		s.debug.message("asset:get_language_files");
		labels = new ArrayList<>();
		captions = new ArrayList<>();
		texts = new ArrayList<>();
		subtitles = new ArrayList<>();
		ArrayList<String> text_files = s.io.external.get_all_files_in_directory(directory_language_texts);
		ArrayList<String> caption_files = s.io.external.get_all_files_in_directory(directory_language_captions);
		ArrayList<String> label_files = s.io.external.get_all_files_in_directory(directory_language_labels);
		ArrayList<String> subtitle_files = s.io.external.get_all_files_in_directory(directory_language_subtitles);
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
		s.debug.message("asset:get_label:index:" + index);
		if(index < labels.size()) {
			return labels.get(index);
		}
		return "";
	}
	public String get_caption(int index)
	{
		s.debug.message("asset:get_caption:index:" + index);
		if(index < captions.size()) {
			return captions.get(index);
		}
		return "";
	}
	public String get_text(int index)
	{
		s.debug.message("asset:get_text:index:" + index);
		if(index < texts.size()) {
			return texts.get(index);
		}
		return "";
	}
	public String get_subtitle(int index)
	{
		s.debug.message("asset:get_subtitle:index:" + index);
		if(index < subtitles.size()) {
			return subtitles.get(index);
		}
		return "";
	}
	public Clip get_music(int index)
	{
		s.debug.message("asset:get_music:index:" + index);
		if(index < music.size()) {
			return music.get(index);
		}
		return null; // PENDING WORK SHOULD NEVER RETURN NULL CREATE BLANK
	}
	public Clip get_sound(int index)
	{
		s.debug.message("asset:get_sound:index:" + index);
		if(index < sounds.size()) {
			return sounds.get(index);
		}
		return null; // PENDING WORK SHOULD NEVER RETURN NULL CREATE BLANK
	}
	public Clip get_speech(int index)
	{
		s.debug.message("asset:get_speech:index:" + index);
		if(index < speech.size()) {
			return speech.get(index);
		}
		return null; // PENDING WORK SHOULD NEVER RETURN NULL CREATE BLANK
	}
	public BufferedImage get_scaled_layer_0(int index)
	{
		s.debug.message("asset:get_layer_0");
		if(index < scaled_layer_0.size()) {
			return scaled_layer_0.get(index);
		}
		return clear;
	}
	public BufferedImage get_scaled_layer_1(int index)
	{
		s.debug.message("asset:get_layer_1");
		if(index < scaled_layer_1.size()) {
			return scaled_layer_1.get(index);
		}
		return clear;
	}
	public BufferedImage get_scaled_layer_2(int index)
	{
		s.debug.message("asset:get_layer_0");
		if(index < scaled_layer_2.size()) {
			return scaled_layer_2.get(index);
		}
		return clear;
	}
	public BufferedImage get_scaled_layer_3(int index)
	{
		s.debug.message("asset:get_layer_3");
		if(index < scaled_layer_3.size()) {
			return scaled_layer_3.get(index);
		}
		return clear;
	}
	public BufferedImage get_scaled_layer_4(int index)
	{
		s.debug.message("asset:get_layer_4");
		if(index < scaled_layer_4.size()) {
			return scaled_layer_4.get(index);
		}
		return clear;
	}
	public BufferedImage get_scaled_layer_5(int index)
	{
		s.debug.message("asset:get_layer_5");
		if(index < scaled_layer_5.size()) {
			return scaled_layer_5.get(index);
		}
		return clear;
	}
	public BufferedImage get_scaled_layer_6(int index)
	{
		s.debug.message("asset:get_layer_6");
		if(index < scaled_layer_6.size()) {
			return scaled_layer_6.get(index);
		}
		return clear;
	}
	public BufferedImage get_scaled_layer_7(int index)
	{
		s.debug.message("asset:get_layer_7");
		if(index < scaled_layer_7.size()) {
			return scaled_layer_7.get(index);
		}
		return clear;
	}
	public BufferedImage get_scaled_layer_8(int index)
	{
		s.debug.message("asset:get_layer_8");
		if(index < scaled_layer_8.size()) {
			return scaled_layer_8.get(index);
		}
		return clear;
	}
	public BufferedImage get_scaled_layer_9(int index)
	{
		s.debug.message("asset:get_layer_9");
		if(index < scaled_layer_9.size()) {
			return scaled_layer_9.get(index);
		}
		return clear;
	}
}