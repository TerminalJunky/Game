import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class button_grid {

	
	storage s;
	asset assets;
	button_layer layer;
	int row;
	int column;
	
	public void start(storage store, asset resources, int index_row, int index_column)
	{
		s = store;
		row = index_row; 
		column = index_column;
		s.debug.message("button_grid:start:row:" + row +":column:" + column);
		assets = resources;
		layer = new button_layer();
		layer.start(store, assets);
		layer.button.setText(row + ":" + column);
		layer.button.addMouseListener(new MouseAdapter()
			{
				public void mousePressed(MouseEvent mouse_press)
				{
					if(mouse_press.getButton() == s.input.mouse_left_press ) {
						s.event.grid.grid_left_click(row, column);
					} else if(mouse_press.getButton() == s.input.mouse_right_press) {
						s.event.grid.grid_right_click(row, column);
					} else if(mouse_press.getButton() == s.input.mouse_scroll_press) {
						s.event.grid.grid_scroll_down(row, column);
					}
				}
			}
		);
	}
	public void set_image(int layer_number, int value)
	{
		layer.layer_indexes[layer_number] = value;
		layer.button.repaint();
	}
	public void repaint()
	{
		layer.button.repaint();
	}
	public void set_dimension(Dimension dimension)
	{
		layer.set_dimensions(dimension);
	}
	public void set_dimension_custom(int width, int height)
	{
		layer.set_dimensions_custom(width, height);
	}
	public void set_asset(asset new_asset)
	{
		assets = new_asset;
		layer.set_assets(assets);
	}
}
