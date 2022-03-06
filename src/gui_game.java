import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class gui_game {

	storage s;
	Dimension dimension_background;
	Dimension dimension_left_side;
	Dimension dimension_right_side;
	Dimension dimension_game_board;
	Dimension dimension_mini_map;
	Dimension dimension_button_grid;
	Dimension dimension_info;
	Dimension dimension_grid_square;
	
	JPanel panel_background;
	JPanel panel_left_side;
	JPanel panel_right_side;
	JPanel panel_game_board;
	JPanel panel_mini_map;
	JPanel panel_button_grid;
	JPanel panel_info;
	
	JFrame gui;
	
	int resolution_x;
	int resolution_y;
	
	int data_index_x;
	int data_index_y;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("gui_game:start");
		data_index_x = 0;
		data_index_y = 0;
		resolution_x = 1280;
		resolution_y = 720;
	}
	public void launch(int width, int height)
	{
		set_resolution(width, height);
		make_dimensions();
		make_panels();
		populate_frame();
	}
	public void set_resolution(int width, int height)
	{
		s.debug.message("gui_game:set_resolution");
		resolution_x = width;
		resolution_y = height;
	}
	public void make_dimensions()
	{
		s.debug.message("gui_game:make_dimensions");
		switch(resolution_y) {
			case 720:
				dimension_background = new Dimension(1280, 720);
				dimension_left_side = new Dimension(290, 720);
				dimension_right_side = new Dimension(990, 720);
				dimension_game_board = new Dimension(dimension_right_side);
				dimension_mini_map = new Dimension(290, 290);
				dimension_button_grid = new Dimension(290, 147);
				dimension_info = new Dimension(290, 283);
				dimension_grid_square = new Dimension(45 , 45);
		}
	}
	public void make_panels()
	{
		s.debug.message("gui_game:make_panels");
		panel_background = new JPanel();
		panel_left_side = new JPanel();
		panel_right_side = new JPanel();
		panel_game_board = new JPanel();
		panel_mini_map = new JPanel();
		panel_button_grid = new JPanel();
		panel_info = new JPanel();
		
		panel_background.setPreferredSize(dimension_background);
		panel_background.setMaximumSize(dimension_background);
		panel_background.setMinimumSize(dimension_background);
		
		panel_left_side.setPreferredSize(dimension_left_side);
		panel_left_side.setMaximumSize(dimension_left_side);
		panel_left_side.setMinimumSize(dimension_left_side);
		
		panel_right_side.setPreferredSize(dimension_right_side);
		panel_right_side.setMaximumSize(dimension_right_side);
		panel_right_side.setMinimumSize(dimension_right_side);
		
		panel_game_board.setPreferredSize(dimension_right_side);
		panel_game_board.setMaximumSize(dimension_right_side);
		panel_game_board.setMinimumSize(dimension_right_side);
		
		panel_mini_map.setPreferredSize(dimension_mini_map);
		panel_mini_map.setMaximumSize(dimension_mini_map);
		panel_mini_map.setMinimumSize(dimension_mini_map);
		
		panel_button_grid.setPreferredSize(dimension_button_grid);
		panel_button_grid.setMaximumSize(dimension_button_grid);
		panel_button_grid.setMinimumSize(dimension_button_grid);
		
		panel_info.setPreferredSize(dimension_info);
		panel_info.setMaximumSize(dimension_info);
		panel_info.setMinimumSize(dimension_info);
		
		BoxLayout background_x_axis = new BoxLayout(panel_background, BoxLayout.X_AXIS);
		BoxLayout left_side_y_axis = new BoxLayout(panel_left_side, BoxLayout.Y_AXIS);
		FlowLayout right_side_y_axis = new FlowLayout(FlowLayout.CENTER,0,0);
		
		panel_background.setLayout(background_x_axis);
		panel_left_side.setLayout(left_side_y_axis);
		panel_right_side.setLayout(right_side_y_axis);
		
		//PENDING GET GRID FOR game_board
		
		panel_right_side.setBackground(Color.GREEN);
		panel_left_side.setBackground(Color.PINK);
		panel_game_board.setBackground(Color.GRAY);
		panel_mini_map.setBackground(Color.ORANGE);
		panel_button_grid.setBackground(Color.MAGENTA);
		panel_info.setBackground(Color.RED);
		
		
		s.data.grid.launch("C:\\Users\\Bryan\\code\\Game\\offical\\default\\scenario\\0000.txt", dimension_right_side);
		panel_game_board = s.data.grid.get_grid();
		panel_right_side.add(panel_game_board);
		
		panel_left_side.add(panel_mini_map);
		panel_left_side.add(panel_button_grid);
		panel_left_side.add(panel_info);
		
		panel_background.add(panel_left_side);
		panel_background.add(panel_right_side);
	}
	public void populate_frame()
	{
		s.debug.message("gui_game:populate_frame");
		gui = new JFrame();
		
		gui.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		gui.setTitle("AND HER BOOBS WERE AWESOME");
		gui.add(panel_background);
		
		// pack is whitespace bug fix
		gui.pack();
		gui.setVisible(true);
	}
	public JPanel get_game_grid()
	{
		s.debug.message("data_game_grid:get_game_grid");
		// PENDING WORK
		s.data.grid.launch("C:\\Users\\Bryan\\code\\Game\\offical\\default\\scenario\\0000.txt", dimension_right_side);
		return s.data.grid.get_grid();
	}
}
