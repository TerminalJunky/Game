import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;

public class button_layer {

	storage s;
	asset assets;
	Dimension dimensions;
	int[] layer_indexes;
	b_layer button;
	/* always 10 index for images within asset a layer_0-layer_9 */
	
	public void start(storage store, asset a)
	{
		s = store;
		s.debug.message("button:start");
		assets = a;
		layer_indexes = new int[10];
		layer_indexes[0] = 0;
		for(int x = 1; x < 10; x++) {
			layer_indexes[x] = 1;
		}
		button = new b_layer();
	}
	public void set_dimensions(Dimension dimension)
	{
		dimensions = dimension;
		button.setSize(dimension);
		button.setMinimumSize(dimension);
		button.setMaximumSize(dimension);
	}
	public void set_dimensions_custom(int width, int height)
	{
		dimensions = new Dimension(width, height);
	}
	public void set_indexes(int[] index)
	{
		layer_indexes = index;
	}
	public void set_assets(asset new_assets)
	{
		assets = new_assets;
	}
	class b_layer extends JButton{ // allows layered drawing don't mod this code
		private static final long serialVersionUID = 1L; // a useless java thing
		public void blayer() { }
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
				g.drawImage(assets.scaled_layer_0.get(layer_indexes[0]), 0, 0, null );
				g.drawImage(assets.scaled_layer_1.get(layer_indexes[1]), 0, 0, null );
				g.drawImage(assets.scaled_layer_2.get(layer_indexes[2]), 0, 0, null );
				g.drawImage(assets.scaled_layer_3.get(layer_indexes[3]), 0, 0, null );
				g.drawImage(assets.scaled_layer_4.get(layer_indexes[4]), 0, 0, null );
				g.drawImage(assets.scaled_layer_5.get(layer_indexes[5]), 0, 0, null );
				g.drawImage(assets.scaled_layer_6.get(layer_indexes[6]), 0, 0, null );
				g.drawImage(assets.scaled_layer_7.get(layer_indexes[7]), 0, 0, null );
				g.drawImage(assets.scaled_layer_8.get(layer_indexes[8]), 0, 0, null );
				g.drawImage(assets.scaled_layer_9.get(layer_indexes[9]), 0, 0, null );
		}
	}
}