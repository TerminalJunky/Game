import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class data_game_grid {

	storage s;
	
	int rows;
	int columns;
	int layers;
	int[][][] game_grid; //rows,columns,layers
	button_layer[][] buttons;
	JPanel panel_grid;
	Dimension dimension_buttons;
	/*
	layer_0 - land
	layer_1 - resources
	layer_2 - city 
	layer_3 - city_name
	layer_4 - city faction
	layer_5 - unit
	layer_6 - unit faction
	layer_7 - unit count
	layer_8 - unit health
	layer_9 - special
	*/
	
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("data_game_grid:start");
	}
	public void launch(String file_name, Dimension dimension_grid)
	{
		s.debug.message("data_game_grid:launch");
		ArrayList<String> scenario = s.io.external.read_file_utf8(file_name);
		ArrayList<Integer> grid_sizes = get_comma_delimited_string_as_int_arraylist(scenario.get(0));
		create_game_grid(grid_sizes.get(0),grid_sizes.get(1),grid_sizes.get(2));
		scenario.remove(0);
		load_game_grid(scenario);
		dimension_buttons = get_dimension_buttons(dimension_grid);
		set_panel_grid();
		//print_game_grid();
	}
	public void set_panel_grid()
	{
		s.debug.message("data_game_grid:set_panel_grid");
		buttons = new button_layer[rows][columns];
		panel_grid = new JPanel();
		GridLayout g_layout = new GridLayout(rows, columns);
		panel_grid.setLayout(g_layout);
		button_layer b_layer;
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < columns; y++) {
				b_layer = new button_layer();
				b_layer.start(s, s.assets);
				b_layer.set_dimensions(dimension_buttons);
				System.out.println("TEST:H:" + dimension_buttons.height + ":W" + dimension_buttons.width);
				buttons[x][y] = b_layer;
				panel_grid.add(buttons[x][y].button);
			}
		}
	}
	public Dimension get_dimension_buttons(Dimension panel_target)
	{
		//PENDING WORK ON AUTO ADJUSTABLE DIMENSION 
		s.debug.message("data_game_grid:get_dimension_buttons");
		Dimension d_buttons = new Dimension(45,45);
		return d_buttons;
	}
	public JPanel get_grid()
	{
		s.debug.message("data_game_grid:get_grid");
		return panel_grid;
	}
	public void create_game_grid(int grid_rows, int grid_columns, int grid_layers)
	{
		s.debug.message("data_game_grid:create_game_grid");
		rows = grid_rows;
		columns = grid_columns;
		layers = grid_layers;
		game_grid = new int[rows][columns][layers];
	}
	public void load_game_grid(ArrayList<String> input)
	{
		s.debug.message("data_game_grid:load_game_grid");
		ArrayList<String> data_line;
		ArrayList<Integer> data_block = null;
		
		for(int x = 0;x < rows; x++) {
			if( x < input.size()) {
				data_line = get_pipe_delimited_string_as_string_arraylist(input.get(x));
			} else { 
				s.debug.message("ERROR:data_game_grid:load_game_grid:row not found loading blanks");
				s.debug.bug();
				data_line = new ArrayList<>();
				String temp = "0";
				for(int i = 0; i < layers; i++) {
					temp = temp + ",0";
				}
				data_line.add(temp);
			}
			for(int y = 0; y < columns; y++) {
				if(y < data_line.size()) {
					data_block = get_comma_delimited_string_as_int_arraylist(data_line.get(y));
				} else {
					s.debug.message("data_game_grid:load_game_grid: column not found loading blanks");
					s.debug.bug();
					for(int i = 0; i < layers; i++) {
						data_block = new ArrayList<>();
						data_block.add(0);
					}
				}
				for(int z = 0; z < layers; z++) {
					if(z < data_block.size()) {
					game_grid[x][y][z] = data_block.get(z);
					} else {
						s.debug.message("data_game_grid:load_game_grid: z layer not found loading blanks");
						s.debug.bug();
						game_grid[x][y][z] = 0;
					}
				}
			}
		}
	}
	public ArrayList<String> get_pipe_delimited_string_as_string_arraylist(String input)
	{
		//s.debug.message("data_game_grid:get_pipe_delimited_string_as_string_arraylist");
		ArrayList<String> string_arraylist = new ArrayList<>();
		if(input != null) {
			String temp = "";
			for(int x = 0; x < input.length(); x++) {
				if(input.charAt(x) != '|') {
					temp = temp + input.charAt(x);
				} else {
					string_arraylist.add(temp);
					temp = "";
				}
			}
		} else {
			s.debug.message("ERROR:data_game_grid:get_pipe_delimited_string_as_string_arraylist: null input");
			s.debug.bug();
		}
		return string_arraylist;
	}
	public ArrayList<Integer> get_comma_delimited_string_as_int_arraylist(String input)
	{
		//s.debug.message("data_game_grid:get_comma_delimited_string_as_int_arraylist");
		ArrayList<Integer> int_arraylist = new ArrayList<>();
		ArrayList<String> string_arraylist = new ArrayList<>();
		if(input != null) {
			String temp = "";
			for(int x = 0; x < input.length(); x++) {
				if(input.charAt(x) != ',') {
					temp = temp + input.charAt(x);
				} else{
					string_arraylist.add(temp);
					temp = "";
				}
			}
			for(int x = 0; x < string_arraylist.size(); x++) {
				int_arraylist.add(get_string_as_int(string_arraylist.get(x)));
			}
		} else {
			s.debug.message("ERROR:data_game_grid:get_comma_delimited_string_as_int_arraylist: null input");
			s.debug.bug();
		}
		return int_arraylist;
	}
	public int get_string_as_int(String input)
	{
		//s.debug.message("data_game_grid:get_string_as_int");
		if(input != null) {
			if(input.length() > 0) {
				int temp = Integer.parseInt(input);
				if(temp < 0) {
					s.debug.message("ERROR:data_game_grid:get_string_as_int: negative return defaulting to 0");
					s.debug.bug();
					temp = 0;
				}
				return temp;
			} else {
				s.debug.message("ERROR:data_game_grid:get_string_as_int: input empty defaulting to 0");
				s.debug.bug();
			}
		} else {
			s.debug.message("ERROR:data_game_grid:get_string_as_int: null input defaulting to 0");
			s.debug.bug();
		}
		return 0;
	}
	public void print_game_grid()
	{
		s.debug.message("data_game_grid;print_game_grid");
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < columns; y++) {
				for(int z = 0; z < layers; z++) {
					System.out.print(game_grid[x][y][z] + ",");
				}
				System.out.print("|");
			}
			System.out.println();
		}
	}
	public void populate_panel(asset assets)
	{
		button_layer bl;
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < columns; y++) {
				bl = new button_layer();
				bl.start(s, assets);
				bl.set_indexes(game_grid[x][y]);
				bl.set_dimensions(null);
			}
		}
	}
}