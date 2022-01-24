import java.awt.Graphics;
import javax.swing.JButton;

public class button_layered {
	
	/* * References
	Graphics 
	https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
	
	possible replacement
	Graphics2d
	https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics2D.html
	 */
	 
	storage s;
	button_layer button = new button_layer();
	int[] images;
	
	public void start(storage store)
	{
		s = store;
		images = new int[9];
		images[0] = 0; //index_land
		images[1] = 1; //index_border
		images[2] = 1; //index_resource
		images[3] = 1; //index_city
		images[4] = 2; //index_unit
		images[5] = 1; //index_faction
		images[6] = 1; //index_health
		images[7] = 1; //index_count
		images[8] = 1; //index_special
	}
	public void load_images(int index_border, int index_land, int index_resource, 
			int index_city, int index_unit, int index_faction, int index_health, 
							int index_count, int index_special)
	{
		images[0] = index_land;
		images[1] = index_border;
		images[2] = index_resource;
		images[3] = index_city;
		images[4] = index_unit;
		images[5] = index_faction;
		images[6] = index_health;
		images[7] = index_count;
		images[8] = index_special;
	}
	public void repaint()
	{
		button.repaint();
	}
	class button_layer extends JButton{ // allows layered drawing don't mod this code
		private static final long serialVersionUID = 1L; // a useless java thing
		public button_layer() { }
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
				g.drawImage(s.asset.images.grid_images_land.get(images[0]), 0, 0, null);
				g.drawImage(s.asset.images.grid_images_border.get(images[1]), 0, 0, null);
				g.drawImage(s.asset.images.grid_images_resource.get(images[2]), 0, 0, null);
				g.drawImage(s.asset.images.grid_images_city.get(images[3]), 0, 0, null);
				g.drawImage(s.asset.images.grid_images_unit.get(images[4]), 0, 0, null);
				g.drawImage(s.asset.images.grid_images_faction.get(images[5]), 0, 0, null);
				g.drawImage(s.asset.images.grid_images_health.get(images[6]), 0, 0, null);
				g.drawImage(s.asset.images.grid_images_count.get(images[7]), 0, 0, null);
				g.drawImage(s.asset.images.grid_images_special.get(images[8]), 0, 0, null);
				
		}
	}
}