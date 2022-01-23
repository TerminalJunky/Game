import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class data_button_grid {

	storage s;
	button_grid[][] grid;
	Dimension button_size;
	JPanel panel_grid;
	int rows;
	int columns;
	int pixel_width;
	int pixel_height;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("button_grid:start");
		pixel_width = 1;
		pixel_height = 1;
		rows = 0;
		columns = 0;
	}
	public JPanel set_grid_size(int grid_rows, int grid_columns, Dimension target_dimension)
	{
		s.debug.message("button_grid:set_grid_size:rows:" + grid_rows + ":columns:" + grid_columns);
		System.out.println("R:" + rows + ":C:" + columns);
		rows = grid_rows;
		columns = grid_columns;
		System.out.println("R:" + rows + ":C:" + columns);
		panel_grid = new JPanel();
		panel_grid.setPreferredSize(target_dimension);
		panel_grid.setMaximumSize(target_dimension);
		panel_grid.setMinimumSize(target_dimension);
		panel_grid.setLayout(new GridLayout(rows, columns));
		grid = new button_grid[rows][columns];
		int modulus_x = target_dimension.width / rows;
		int modulus_y = target_dimension.height / columns;
		pixel_width = ( target_dimension.width - modulus_x) / rows;
		pixel_height = ( target_dimension.height - modulus_y) / columns;
		button_size = new Dimension(pixel_width, pixel_height);
		System.out.println("pw:" + pixel_width + ":ph:" + pixel_height);
		button_grid temp;
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < columns; y++) {
				temp = new button_grid();
				temp.start(s, x, y);
				grid[x][y] = temp;
			}
		}
		JButton test;
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < columns; y++) {
				panel_grid.add(grid[x][y].layer.button);
			}
		}
		
		System.out.println("R:" + rows + ":C:" + columns);
		//System.out.println("test" + panel_grid.countComponents() );
		return panel_grid;
	}
	public void repaint_button_all()
	{
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < columns; y++) {
				grid[x][y].layer.button.repaint();
			}
		}
	}
}