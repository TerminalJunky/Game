import java.io.File;

import javax.swing.JFileChooser;

public class gui_file_manager {

	storage s;
	JFileChooser manager;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("gui_file_manager:start");
	}
	public String get_file(String title_bar, String start_directory)
	{
		s.debug.message("gui_file_manager:get_file");
		String return_string = "";
		manager = new JFileChooser();
		manager.setCurrentDirectory(new File(start_directory));
		manager.setDialogTitle(title_bar);
		manager.setFileSelectionMode(JFileChooser.FILES_ONLY);
		manager.setAcceptAllFileFilterUsed(false);
		if(manager.showOpenDialog(manager) == JFileChooser.APPROVE_OPTION){
			return_string = manager.getSelectedFile().toString();
		}
		return return_string;
	}
	public String get_directory(String title_bar, String start_directory)
	{
		s.debug.message("gui_file_manager:get_file");
		String return_string = "";
		manager = new JFileChooser();
		manager.setCurrentDirectory(new File(start_directory));
		manager.setDialogTitle(title_bar);
		manager.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		manager.setAcceptAllFileFilterUsed(false);
		if(manager.showOpenDialog(manager) == JFileChooser.APPROVE_OPTION){
			return_string = manager.getSelectedFile().toString();
		}
		return return_string;
	}
}