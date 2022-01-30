import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class gui_game_v2 {

	storage s;
	
	int width;
	int height;
	
	JFrame gui;
	
	Color clear;
	
	Dimension dimension_background;
	Dimension dimension_top;
	Dimension dimension_center;
	Dimension dimension_bottom;
	Dimension dimension_top_left;
	Dimension dimension_top_center;
	Dimension dimension_top_right;
	Dimension dimension_center_left;
	Dimension dimension_center_center;
	Dimension dimension_center_right;
	Dimension dimension_bottom_left;
	Dimension dimension_bottom_center;
	Dimension dimension_bottom_right;
	Dimension dimension_tile;
	
	JLayeredPane background;
	
	//JPanel background;
	JPanel panel_map_layer;
	JPanel panel_animation_layer;
	JPanel panel_interface_layer;
	JPanel panel_command_layer;
	
	JPanel panel_controls;
	JPanel panel_units;
	JPanel panel_mini_map;
	JPanel panel_info;
	JPanel panel_extras;
	
	JPanel panel_top;
	JPanel panel_center;
	JPanel panel_bottom;
	
	JPanel panel_top_left;
	JPanel panel_top_center;
	JPanel panel_top_right;
	JPanel panel_center_left;
	JPanel panel_center_center;
	JPanel panel_center_right;
	JPanel panel_bottom_left;
	JPanel panel_bottom_center;
	JPanel panel_bottom_right;
	
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("gui_game_:start");
		clear = new Color(0, 0, 0, 255);
	}
	public void launch(int gui_width, int gui_height)
	{
		set_resolution(gui_width, gui_height);
	}
	public void set_resolution(int gui_width, int gui_height)
	{
		width = gui_width;
		height = gui_height;
		set_dimensions();
		make_panels();
		populate_panels();
		
		gui = new JFrame();
		
		gui.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		gui.setTitle("AND HER BOOBS WERE AWESOME");
		gui.add(background);
		
		// pack is whitespace bug fix
		gui.pack();
		gui.setVisible(true);
	}
	public void set_dimensions()
	{
		switch(height) 
		{
			case 720:
				dimension_background = new Dimension(width, height);
				dimension_tile = new Dimension(40,40);
				dimension_top = new Dimension(1280, 160);
				dimension_center = new Dimension(1280, 400);
				dimension_bottom = new Dimension(1280, 160);
				dimension_top_left = new Dimension(320, 160);
				dimension_top_center = new Dimension(640, 160);
				dimension_top_right = new Dimension(320, 160);
				dimension_center_left = new Dimension(320, 400);
				dimension_center_center = new Dimension(640, 400);
				dimension_center_right = new Dimension(320, 400);
				dimension_bottom_left = new Dimension(320, 160);
				dimension_bottom_center = new Dimension(640, 160);
				dimension_bottom_right = new Dimension(320, 160);
			break;
		}
	}
	public void make_panels()
	{	
		background = new JLayeredPane();
		
		//background = new JPanel();
		panel_map_layer = new JPanel();
		panel_animation_layer = new JPanel();
		panel_interface_layer = new JPanel();
		panel_command_layer = new JPanel();
		panel_controls = new JPanel();
		panel_units = new JPanel();
		panel_mini_map = new JPanel();
		panel_info = new JPanel();
		panel_extras = new JPanel();
		panel_top = new JPanel();
		panel_center = new JPanel();
		panel_bottom = new JPanel();
		
		panel_top_left = new JPanel();
		panel_top_center = new JPanel();
		panel_top_right = new JPanel();
		panel_center_left = new JPanel();
		panel_center_center = new JPanel();
		panel_center_right = new JPanel();
		panel_bottom_left = new JPanel();
		panel_bottom_center = new JPanel();
		panel_bottom_right = new JPanel();
		
		//layers.setPreferredSize(dimension_background);
		//layers.setMaximumSize(dimension_background);
		//layers.setMinimumSize(dimension_background);
		
		panel_top.setPreferredSize(dimension_top);
		panel_top.setMaximumSize(dimension_top);
		panel_top.setMinimumSize(dimension_top);
		
		panel_center.setPreferredSize(dimension_center);
		panel_center.setMaximumSize(dimension_center);
		panel_center.setMinimumSize(dimension_center);
		
		panel_bottom.setPreferredSize(dimension_bottom);
		panel_bottom.setMaximumSize(dimension_bottom);
		panel_bottom.setMinimumSize(dimension_bottom);
		
		background.setPreferredSize(dimension_background);
		background.setMaximumSize(dimension_background);
		background.setMinimumSize(dimension_background);
		
		panel_map_layer.setPreferredSize(dimension_background);
		panel_map_layer.setMaximumSize(dimension_background);
		panel_map_layer.setMinimumSize(dimension_background);
		
		panel_animation_layer.setPreferredSize(dimension_background);
		panel_animation_layer.setMaximumSize(dimension_background);
		panel_animation_layer.setMinimumSize(dimension_background);
		
		panel_command_layer.setPreferredSize(dimension_background);
		panel_command_layer.setMaximumSize(dimension_background);
		panel_command_layer.setMinimumSize(dimension_background);
		
		panel_controls.setPreferredSize(dimension_bottom_right);
		panel_controls.setMaximumSize(dimension_bottom_right);
		panel_controls.setMinimumSize(dimension_bottom_right);
		
		panel_units.setPreferredSize(dimension_bottom_center);
		panel_units.setMaximumSize(dimension_bottom_center);
		panel_units.setMinimumSize(dimension_bottom_center);
		
		panel_mini_map.setPreferredSize(dimension_top_left);
		panel_mini_map.setMaximumSize(dimension_top_left);
		panel_mini_map.setMinimumSize(dimension_top_left);
		
		panel_info.setPreferredSize(dimension_bottom_left);
		panel_info.setMaximumSize(dimension_bottom_left);
		panel_info.setMinimumSize(dimension_bottom_left);
		
		panel_extras.setPreferredSize(dimension_top_right);
		panel_extras.setMaximumSize(dimension_top_right);
		panel_extras.setMinimumSize(dimension_top_right);
	}
	public void populate_panels()
	{
		BoxLayout layout_background = new BoxLayout(background, BoxLayout.Y_AXIS);
		BoxLayout layout_map_layer = new BoxLayout(panel_map_layer, BoxLayout.X_AXIS);
		BoxLayout layout_command_layer = new BoxLayout(panel_command_layer, BoxLayout.Y_AXIS);
		
		BoxLayout layout_top = new BoxLayout(panel_top, BoxLayout.X_AXIS);
		BoxLayout layout_middle = new BoxLayout(panel_center, BoxLayout.X_AXIS);
		BoxLayout layout_bottom = new BoxLayout(panel_bottom, BoxLayout.X_AXIS);
		
		background.setLayout(layout_background);
		panel_map_layer.setLayout(layout_map_layer);
		panel_command_layer.setLayout(layout_command_layer);
		panel_top.setLayout(layout_top);
		panel_center.setLayout(layout_middle);
		panel_bottom.setLayout(layout_bottom);
		
		panel_map_layer.add(get_panel_map_layer(dimension_background));
		panel_controls.add(get_panel_controls(dimension_bottom_right));
		panel_units.add(get_panel_units(dimension_bottom_center));
		panel_mini_map.add(get_panel_mini_map(dimension_top_left));
		panel_info.add(get_panel_info(dimension_bottom_left));
		panel_extras.add(get_panel_extras(dimension_top_right));
		
		panel_top_left.add(panel_mini_map);
		panel_top_right.add(panel_extras);
		panel_bottom_right.add(panel_controls);
		panel_bottom_center.add(panel_units);
		panel_bottom_left.add(panel_info);
		
		panel_top.add(panel_top_left);
		panel_top.add(panel_top_center);
		panel_top.add(panel_top_right);
		panel_center.add(panel_center_left);
		panel_center.add(panel_center_center);
		panel_center.add(panel_center_right);
		panel_bottom.add(panel_bottom_left);
		panel_bottom.add(panel_bottom_center);
		panel_bottom.add(panel_bottom_right);
		
		panel_command_layer.add(panel_top);
		panel_command_layer.add(panel_center);
		panel_command_layer.add(panel_bottom);
		
		//panel_command_layer.setOpaque(true);
		//panel_center.setBackground(clear);
		
		//panel_center_center.setBackground(clear);
		Integer i = 1;
		Integer t = 0;
		background.add(panel_command_layer, t);
		background.add(panel_map_layer, i);
		
		//background.add(panel_animation_layer); 
		//background.add(panel_interface_layer);
		 
		 
		background.add(panel_controls, 0);
		background.add(panel_map_layer, 1);
		
	}
	public JPanel get_panel_map_layer(Dimension dimensions)
	{
		JPanel temp = new JPanel();
		temp.setBackground(Color.GREEN);
		temp.setPreferredSize(dimensions);
		return temp;
	}
	public JPanel get_panel_controls(Dimension dimensions)
	{
		JPanel temp = new JPanel();
		temp.setBackground(Color.ORANGE);
		temp.setPreferredSize(dimensions);
		return temp;
	}
	public JPanel get_panel_units(Dimension dimensions)
	{
		JPanel temp = new JPanel();
		temp.setBackground(Color.CYAN);
		temp.setPreferredSize(dimensions);
		return temp;
	}
	public JPanel get_panel_mini_map(Dimension dimensions)
	{
		JPanel temp = new JPanel();
		temp.setBackground(Color.YELLOW);
		temp.setPreferredSize(dimensions);
		return temp;
	}
	public JPanel get_panel_info(Dimension dimensions)
	{
		JPanel temp = new JPanel();
		temp.setBackground(Color.MAGENTA);
		temp.setPreferredSize(dimensions);
		return temp;
	}
	public JPanel get_panel_extras(Dimension dimensions)
	{
		JPanel temp = new JPanel();
		temp.setBackground(Color.BLUE);
		temp.setPreferredSize(dimensions);
		return temp;
	}
}
