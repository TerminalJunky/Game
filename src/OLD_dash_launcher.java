import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class OLD_dash_launcher {

	/*
	storage s;
	JButton button_new;
	JButton button_load;
	JButton button_mods;
	JButton button_mod_tools;
	JButton button_settings;
	JLabel  label_version;
	JLabel  label_language;
	String[] text_version;
	String[] text_language;
	JComboBox<String> drop_version;
	JComboBox<String> drop_language;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("dash_launcher:start");
		load_buttons();
		add_button_function();
	}
	public void load_buttons()
	{
		s.debug.message("dash_launcher:load_buttons");
		
		button_new = new JButton();
		button_load = new JButton();
		button_mods = new JButton();
		button_mod_tools = new JButton();
		button_settings = new JButton();
		
		label_version = new JLabel();
		label_language = new JLabel();
		
		button_new.setPreferredSize(s.dimension.launcher.buttons);
		button_new.setMinimumSize(s.dimension.launcher.buttons);
		button_new.setMaximumSize(s.dimension.launcher.buttons);
		
		button_load.setPreferredSize(s.dimension.launcher.buttons);
		button_load.setMinimumSize(s.dimension.launcher.buttons);
		button_load.setMaximumSize(s.dimension.launcher.buttons);
		
		button_mods.setPreferredSize(s.dimension.launcher.buttons);
		button_mods.setMinimumSize(s.dimension.launcher.buttons);
		button_mods.setMaximumSize(s.dimension.launcher.buttons);
		
		button_mod_tools.setPreferredSize(s.dimension.launcher.buttons);
		button_mod_tools.setMinimumSize(s.dimension.launcher.buttons);
		button_mod_tools.setMaximumSize(s.dimension.launcher.buttons);
		
		button_settings.setPreferredSize(s.dimension.launcher.buttons);
		button_settings.setMinimumSize(s.dimension.launcher.buttons);
		button_settings.setMaximumSize(s.dimension.launcher.buttons);
		
		label_version.setPreferredSize(s.dimension.launcher.labels);
		label_version.setMinimumSize(s.dimension.launcher.labels);
		label_version.setMaximumSize(s.dimension.launcher.labels);
		
		label_language.setPreferredSize(s.dimension.launcher.labels);
		label_language.setMinimumSize(s.dimension.launcher.labels);
		label_language.setMaximumSize(s.dimension.launcher.labels);
		
		button_new.setText(s.lang.launcher.get_label(0));
		button_load.setText(s.lang.launcher.get_label(1));
		button_mods.setText(s.lang.launcher.get_label(2));
		button_mod_tools.setText(s.lang.launcher.get_label(3));
		button_settings.setText(s.lang.launcher.get_label(4));
		label_language.setText(s.lang.launcher.get_label(5));
		label_version.setText(s.lang.launcher.get_label(6));
		
		label_language.setHorizontalAlignment(SwingConstants.RIGHT);
		label_version.setHorizontalAlignment(SwingConstants.RIGHT);
		
		ArrayList<String> extensions = new ArrayList<>();
		extensions.add("jar");
		
		ArrayList<String> version_temp = s.io.external.get_files_of_extension_type(s.io.external.directory_primary, extensions); 
		ArrayList<String> lang_temp = s.io.external.read_file_utf8(s.settings.file_language_preferred);
		
		text_version = new String[version_temp.size()];
		text_language = new String[lang_temp.size()];
		
		for(int x = 0; x < version_temp.size(); x++) {
			text_version[x] = s.io.external.get_file_name_only_without_extension( version_temp.get(x) );
		}
		for(int x = 0; x < lang_temp.size(); x++) {
			text_language[x] = lang_temp.get(x);
		}
		
		drop_version = new JComboBox<String>(text_version);
		drop_language = new JComboBox<String>(text_language);
		
		drop_version.setPreferredSize(s.dimension.launcher.drop_downs);
		drop_version.setMinimumSize(s.dimension.launcher.drop_downs);
		drop_version.setMaximumSize(s.dimension.launcher.drop_downs);
		
		drop_language.setPreferredSize(s.dimension.launcher.drop_downs);
		drop_language.setMinimumSize(s.dimension.launcher.drop_downs);
		drop_language.setMaximumSize(s.dimension.launcher.drop_downs);
	}
	public void add_button_function()
	{
		button_new.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				s.debug.message("dash_launcher:add_button_function:button_new:pressed");
			}
		});
		button_load.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				s.debug.message("dash_launcher:add_button_function:button_new:pressed");
				String game_load = s.file_manager.get_file("Load Game", s.io.external.directory_saves);
				s.event.controls.load_game(game_load);
			}
		});
		button_mods.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				s.debug.message("dash_launcher:add_button_function:button_new:pressed");
				s.gui.mods.launch();
			}
		});
		button_mod_tools.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				s.debug.message("dash_launcher:add_button_function:button_new:pressed");
			}
		});
		button_settings.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				s.debug.message("dash_launcher:add_button_function:button_new:pressed");
			}
		});
		drop_version.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				s.debug.message("dash_launcher:add_button_function:drop_version:selected:");
			}
		});
		drop_language.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				s.debug.message("dash_launcher:add_button_function:drop_language:selected:");
			}
		});
	}
	*/
}