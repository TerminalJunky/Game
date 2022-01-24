import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class io_external {

	storage s;
	
	public String directory_primary;
	public String directory_language;
	public String directory_offical_games;
	public String directory_mods;
	public String directory_game_current;
	public String directory_language_texts;
	public String directory_language_captions;
	public String directory_settings;
	public String directory_debug;
	public String file_slash;
	public String file_setting_language_native;
	public String file_setting_language_english;
	public String file_setting_max_log;
	public String file_setting_license;
	public String file_setting_debug;
	public String file_language_license;
	public String file_language_notice;
	public String file_output_debug;
	public String directory_assets;
	public String directory_images;
	public String directory_images_land;
	public String directory_images_border;
	public String directory_images_resource;
	public String directory_images_city;
	public String directory_images_unit;
	public String directory_images_count;
	public String directory_images_faction;
	public String directory_images_health;
	public String directory_images_special;
	public String file_images_clear;
	public String file_images_black;
	
	public String directory_language_license;
	public String directory_language_launcher;
	public String directory_language_general;
	public String file_languages_native;
	public String file_languages_english;
	public String preference_langauge;
	public String directory_saves;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("io:io_external:start");
		directory_primary = "";
		directory_language = "";
		directory_offical_games = "";
		directory_mods = "";
		directory_game_current = "";
		directory_language_texts = "";
		directory_language_captions = "";
		directory_settings = "";
		directory_debug = "";
		file_language_license = "";
		file_language_notice = "";
		file_setting_debug = "";
		file_setting_license = "";
		file_setting_max_log = "";
		file_setting_language_native = "";
		file_setting_language_english = "";
		file_slash = "";
		file_output_debug = "";
		directory_language_license = "";
		directory_language_launcher = "";
		directory_language_general = "";
		file_languages_english = "";
		file_languages_native = "";
		preference_langauge = "english";
		directory_saves = "";
		locate_core_files();
	}
	public void locate_core_files()
	{
		s.debug.message("io:external:locate_core_files");
		file_slash = s.debug.file_slash;
		directory_primary = System.getProperty("user.dir") + file_slash;
		directory_debug = directory_primary + "debug" + file_slash;
		directory_offical_games = directory_primary + "offical" + file_slash;
		directory_mods = directory_primary + "mods" + file_slash;
		directory_game_current = directory_offical_games + "default" + file_slash;
		directory_assets = directory_game_current + "assets" + file_slash;
		directory_images = directory_assets + "images" + file_slash;
		directory_images_land = directory_images + "land" + file_slash;
		directory_images_border = directory_images + "border" + file_slash;
		directory_images_resource = directory_images + "resource" + file_slash;
		directory_images_city = directory_images + "city" + file_slash;
		directory_images_unit = directory_images + "unit" + file_slash;
		directory_images_count = directory_images + "count" + file_slash;
		directory_images_faction = directory_images + "faction" + file_slash;
		directory_images_health = directory_images + "health" + file_slash;
		directory_images_special = directory_images + "special" + file_slash;
		file_images_clear = directory_images + "clear.png";
		file_images_black = directory_images + "black.png";
		directory_language = directory_game_current + "language" + file_slash;
		directory_language_texts = directory_language + "texts" + file_slash;
		directory_language_captions = directory_language + "captions" + file_slash;
		directory_settings = directory_primary + "settings" + file_slash;
		file_language_license = directory_language + "license" + file_slash + "license.txt";
		file_language_notice = directory_language + "license" + file_slash + "notice.txt";
		file_setting_debug = directory_settings + "debug.txt";
		file_setting_license = directory_settings + "signed.txt";
		file_setting_max_log = directory_settings + "max_log.txt";
		file_setting_language_native = directory_settings + "language_native.txt";
		file_setting_language_english = directory_settings + "language_english.txt";	
		directory_language_general = directory_primary + "language" + file_slash;
		directory_language_license = directory_language_general + "license" + file_slash;
		directory_language_launcher = directory_language_general + "launcher" + file_slash;
		file_languages_native = directory_language_general + "native.txt";
		file_languages_english = directory_language_general + "languages.txt";
		directory_saves = directory_primary + "saves" + file_slash;
	}
	public ArrayList<String> get_file_locations()
	{
		s.debug.message("io_external:get_file_locations");
		ArrayList<String> file_locations = new ArrayList<>();
		file_locations.add("file_slash:" + file_slash); 
		file_locations.add("directory_primary:" + directory_primary);
		file_locations.add("directory_offical_games:" + directory_offical_games);
		file_locations.add("directory_mods:" + directory_mods);
		file_locations.add("directory_game_current:" + directory_game_current);
		file_locations.add("directory_language:" + directory_language);
		file_locations.add("directory_language_text:" + directory_language_texts);
		file_locations.add("directory_language_captions:" + directory_language_captions);
		file_locations.add("directory_settings:" + directory_settings);
		file_locations.add("file_language_license:" + file_language_license);
		file_locations.add("file_setting_debug:" + file_setting_debug);
		file_locations.add("file_setting_license:" + file_setting_license);
		file_locations.add("file_setting_max_log:" + file_setting_max_log);
		file_locations.add("file_setting_langauge_native:" + file_setting_language_native);
		file_locations.add("file_setting_language_english:" + file_setting_language_english);
		return file_locations;
	}
	public void print_file_locations()
	{
		s.debug.message("io_external:print_file_locations");
		ArrayList<String> file_locations = get_file_locations();
		for(int x = 0; x < file_locations.size(); x++){
			System.out.println(file_locations.get(x));
		}
	}
	public String get_generic_file_name()
	{
		s.debug.message("io:io_external:get_generic_file_name");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		return new SimpleDateFormat( "yyyyMMddHHmmssSS" ).format( time ) +".txt";
	}
	public void write_overwrite_utf8(String file_name, ArrayList<String> output)
	{
		if(file_name != null && output != null) {
		s.debug.message("io:io_external:write_overwrite_utf8:" + file_name + " :size: " + output.size() );
			File location = new File(file_name);
			try {
			FileOutputStream out = new FileOutputStream(location);
			OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8 );
			try (BufferedWriter buffer = new BufferedWriter(writer)) {
				for(int x = 0; x < output.size(); x++) {
					buffer.append(output.get(x));
					buffer.newLine();
				}
				buffer.close();
				writer.close();
				out.close();
			} 
			} catch (FileNotFoundException e) { s.debug.message("ERROR:io:io_external:write_overwrite_utf8: java io file not found catch"); s.debug.bug(); } 
			  catch (IOException e) { s.debug.message("ERROR:io:io_external:write_overwrite_utf8: java io exception catch"); s.debug.bug(); }
		} else {
			if(file_name == null && output == null) {
				s.debug.message("ERROR:io:io_external:write_overwrite_utf8:null file_name & output");
				s.debug.bug();
			} else if(file_name == null && output != null) {
				s.debug.message("ERROR:io:io_external:write_overwrite_utf8:null file_name");
				s.debug.bug();
			} else {
				s.debug.message("ERROR:io:io_external:write_overwrite_utf8:null output");	
				s.debug.bug();
			}
		}
	}
	public void write_overwrite_utf8_create_directories(String file_name, ArrayList<String> output)
	{
		if(file_name != null || output != null) {
			s.debug.message("io:io_external:write_overwrite_utf8_create_directories:" + file_name + " :size: " + output.size() );
			create_all_subdirectories(file_name);
			write_overwrite_utf8(file_name, output);
		} else {
			if(file_name == null && output == null) {
				s.debug.message("ERROR:io:io_external:write_overwrite_utf8_create_directories:null file_name & output");
				s.debug.bug();
			} else if(file_name == null && output != null) {
				s.debug.message("ERROR:io:io_external:write_overwrite_utf8_create_directories:null file_name");
				s.debug.bug();
			} else {
				s.debug.message("ERROR:io:io_external:write_overwrite_utf8_create_directories:null output");	
				s.debug.bug();
			}
		}
	}
	public String get_current_directory(String file_name)
	{
		String current_directory = "";
		if(file_name != null) {
		s.debug.message("io:io_external:get_current_directory:" + file_name);
		StringBuilder sb = new StringBuilder(file_name);
		sb.reverse();
		int index_slash = sb.indexOf(file_slash);
		if(index_slash > 0) {
		String temp = sb.substring(index_slash);
		sb = new StringBuilder(temp);
		current_directory = sb.reverse().toString();
		}
		} else {
			s.debug.message("ERROR:io:io_external:get_current_directory:null file_name");
			s.debug.bug();
		}
		return current_directory;
	}
	public void create_all_subdirectories(String file_name)
	{
		if(file_name == null) {
			s.debug.message("ERROR:io:io_external:create_all_subdirectories:null file_name");
			s.debug.bug();
		}
		s.debug.message("io:io_external:create_all_subdirectories:");
		String location = get_current_directory(file_name);
		if( location == null || location.length() < 1) {
			s.debug.message("ERROR:io:io_external:create_all_subdirectories:null or empty location");
			s.debug.bug();
		} else {
			File file_path = new File(location);
			if(!file_path.isDirectory()) {
			file_path.mkdirs();
			}
		}
	}
	public ArrayList<String> read_file_utf8(String file_name)
	{
		ArrayList<String> input = new ArrayList<>();
		if(file_name != null) {
			s.debug.message("io:io_external:read_file_utf8:" + file_name);
			File file_in = new File(file_name);
			if(file_in.isFile()) {
				String line = "";
				try {
					FileInputStream fin = new FileInputStream(file_name);
					InputStreamReader in = new InputStreamReader(fin, "UTF8");
					BufferedReader buffer = new BufferedReader(in);
					while( ( line = buffer.readLine() ) != null ) {
						input.add(line);
						line = "";
					}
					buffer.close();
				} catch (IOException e) { e.printStackTrace(); }
			} else {
				s.debug.message("ERROR:io:io_external:read_file_utf8:is not a file:" + file_name);
				s.debug.bug();
			}
		} else {
			s.debug.message("ERROR:io:io_external:read_file_utf8:null file_name");	
			s.debug.bug();
		}
		return input;
	}
	public void print_read_file(String file_name)
	{
		if(file_name != null) {
			s.debug.message("io:io_external:print_read_file:" + file_name);
			ArrayList<String> input = read_file_utf8(file_name);
			for(int x = 0; x < input.size(); x++) {
				System.out.println(input.get(x));
			}
		} else {
			s.debug.message("ERROR:io:io_external:print_read_file:null file_name");
			s.debug.bug();
		}
	}
	public ArrayList<String> get_all_files_in_directory(String directory_name)
	{
		ArrayList<String> all_files = new ArrayList<>();
		if(directory_name != null) {
		s.debug.message("io_external:get_all_files_in_directory:" + directory_name);
			File directory = new File(directory_name);
			if(directory.isDirectory()) {
					File[] files = directory.listFiles();
					for(int x = 0; x < files.length; x++) {
						if(files[x].isFile()) {
							all_files.add(files[x].toString());
						}
					}
			}else {
				s.debug.message("ERROR:io_external:get_all_files_in_directory: file is not directory:" + directory_name);
				s.debug.bug();
			}
		} else {
			s.debug.message("ERROR:io_external:get_all_files_in_directory:null directory name");
			s.debug.bug();
		}
		return all_files;
	}
	public BufferedImage get_image(String file_name)
	{
		s.debug.message("io_external:get_image");
		BufferedImage bi = null;
		if(file_name != null) {
			s.debug.message("io_external:get_image:file_name:" + file_name);
			File temp = new File(file_name);
			try {
				bi = ImageIO.read(temp);
			} catch (IOException e) { s.debug.message("io_external:get_image:file_name:" + file_name +":failed to open file"); s.debug.bug();}
		} else {
			s.debug.message("ERROR:io_external:get_image:null file name"); s.debug.bug();
		}
		return bi;
	}
	public ArrayList<BufferedImage> get_all_images(String directory)
	{
		ArrayList<BufferedImage> images = new ArrayList<>();
		if(directory != null) {
			s.debug.message("io_external:get_all_images:from:" + directory);
			ArrayList<String> extensions = new ArrayList<>();
			extensions.add("jpeg");
			extensions.add("png");
			extensions.add("bmp");
			ArrayList<String> files = get_files_of_extension_type(directory, extensions);
			for(int x = 0; x < files.size(); x++) {
				images.add(get_image(files.get(x)) );
			}
		} else {
			s.debug.message("ERROR:io_external:get_all_images:null directory");
			s.debug.bug();
		}
		return images;
	}
	public ArrayList<String> get_files_of_extension_type(String directory, ArrayList<String> valid_extensions)
	{
		ArrayList<String> files = new ArrayList<>();
		if(directory != null && valid_extensions != null) {
			String ext = ""; 
			for(int x = 0; x < valid_extensions.size(); x++) { ext = ext + valid_extensions.get(x) + ":";  }
			s.debug.message("io_external:get_files_of_extension_type:directory:" + directory + ":extensions:" + ext);
			ArrayList<String> raw_files = get_all_files_in_directory(directory);
			String extension = "";
			for(int x = 0; x < raw_files.size(); x++) {
				extension = get_file_extension(raw_files.get(x));
				for(int y = 0; y < valid_extensions.size(); y++) {
					if(extension.equalsIgnoreCase(valid_extensions.get(y))) {
						files.add(raw_files.get(x));
						y = valid_extensions.size() + 1;
					}
				}
			}
		} else {
			if(directory == null) {
				s.debug.message("ERROR:io_external:get_files_of_extension_type: null directory"); s.debug.bug();
			}
			if(valid_extensions == null) {
				s.debug.message("ERROR:io_external:get_file_of_extension_type: null valid extensions"); s.debug.bug();
			}
		}
		return files;
	}
	public String get_file_extension(String file_name)
	{
		String extension = "";
		if(file_name != null) {
			s.debug.message("io_external:get_file_extension:file_name:" + file_name);
			StringBuilder sb = new StringBuilder(file_name);
			sb.reverse();
			int index = sb.indexOf(".");
			if(index > 0) {
			String temp = sb.substring(0, index);
			sb = new StringBuilder(temp);
			sb.reverse();
			extension = sb.toString();
			}
		} else {
			s.debug.message("ERROR:io_external:get_file_extension:null file name"); s.debug.bug();
		}
		return extension;
	}
	public void write_debugger_only(String debug_directory, ArrayList<String> output)
	{
		if(debug_directory != null || output != null) {
			Timestamp time = new Timestamp(System.currentTimeMillis());
			String file_name = debug_directory + (new SimpleDateFormat( "yyyyMMddHHmmssSS" ).format( time ) +".txt" );
			System.out.println("io:io_external:write_debugger_only:" + file_name + " :size: " + output.size() );
			String current_directory = "";
			StringBuilder sb = new StringBuilder(file_name);
			sb.reverse();
			int index_slash = sb.indexOf(file_slash);
			if(index_slash > 0) {
			String temp = sb.substring(index_slash);
			sb = new StringBuilder(temp);
			current_directory = sb.reverse().toString();
			}
			if( current_directory == null || current_directory.length() < 1) {
				System.out.println("ERROR:io:io_external:write_debugger_only:null or empty location");
			} else {
				File file_path = new File(current_directory);
				if(!file_path.isDirectory()) {
				file_path.mkdirs();
				}
			}
			File location = new File(file_name);
					try {
					FileOutputStream out = new FileOutputStream(location);
					OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8 );
					try (BufferedWriter buffer = new BufferedWriter(writer)) {
						for(int x = 0; x < output.size(); x++) {
							buffer.append(output.get(x));
							buffer.newLine();
						}
						buffer.close();
						writer.close();
						out.close();
					} 
					} catch (FileNotFoundException e) { System.out.println("ERROR:io:io_external:write_debugger_only: java io file not found catch"); } 
					  catch (IOException e) { System.out.println("ERROR:io:io_external:write_debugger_only: java io exception catch"); }
			} else {
				if(debug_directory == null && output == null) {
					System.out.println("ERROR:io:io_external:write_debugger_only:null file_name & output");
				} else if(debug_directory == null && output != null) {
					System.out.println("ERROR:io:io_external:write_debugger_only:null file_name");
				} else {
					System.out.println("ERROR:io:io_external:write_debugger_only:null output");	
				}
			}
	}
}