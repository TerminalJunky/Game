import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class asset_images {
	
	/* References
	scale_method
	https://docs.oracle.com/javase/7/docs/api/java/awt/image/AffineTransformOp.html#TYPE_BICUBIC
	https://docs.oracle.com/javase/7/docs/api/constant-values.html#java.awt.image.AffineTransformOp.TYPE_BICUBIC
	
	scale_type 
	https://docs.oracle.com/javase/7/docs/api/java/awt/Image.html
	https://docs.oracle.com/javase/7/docs/api/constant-values.html#java.awt.Image.SCALE_SMOOTH
	
	example code
	https://stackoverflow.com/questions/4216123/how-to-scale-a-bufferedimage
	 */
	
	/* 0 is black, 1 is clear for all arraylists */
	/* Image Layer Key
	images[0] = index_land;
	images[1] = index_border;
	images[2] = index_resource;
	images[3] = index_city;
	images[4] = index_unit;
	images[5] = index_faction;
	images[6] = index_health;
	images[7] = index_count;
	images[8] = index_special;
	 */
	
	storage s;
	
	ArrayList<BufferedImage> source_images_land;
	ArrayList<BufferedImage> source_images_border;
	ArrayList<BufferedImage> source_images_resource;
	ArrayList<BufferedImage> source_images_city;
	ArrayList<BufferedImage> source_images_unit;
	ArrayList<BufferedImage> source_images_count;
	ArrayList<BufferedImage> source_images_faction;
	ArrayList<BufferedImage> source_images_health;
	ArrayList<BufferedImage> source_images_special;
	
	ArrayList<BufferedImage> grid_images_land;
	ArrayList<BufferedImage> grid_images_border;
	ArrayList<BufferedImage> grid_images_resource;
	ArrayList<BufferedImage> grid_images_city;
	ArrayList<BufferedImage> grid_images_unit;
	ArrayList<BufferedImage> grid_images_count;
	ArrayList<BufferedImage> grid_images_faction;
	ArrayList<BufferedImage> grid_images_health;
	ArrayList<BufferedImage> grid_images_special;
	BufferedImage black;
	BufferedImage clear;
	int scale_type; // 1 default , 2 fast, 4 smooth, 8 replicate, 16 area_average
	int scale_method; // 3 bicubic, 2 bilinear, 1 nearest_neighbor
	int max_width;
	int max_height;
	int grid_scale_width;
	int grid_scale_height;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("asset_images:start");
		source_images_land = new ArrayList<>();
		source_images_border = new ArrayList<>();
		source_images_resource = new ArrayList<>();
		source_images_city = new ArrayList<>();
		source_images_unit = new ArrayList<>();
		source_images_count = new ArrayList<>();
		source_images_faction = new ArrayList<>();
		source_images_health = new ArrayList<>();
		source_images_special = new ArrayList<>();
		grid_images_land = new ArrayList<>();
		grid_images_border = new ArrayList<>();
		grid_images_resource = new ArrayList<>();
		grid_images_city = new ArrayList<>();
		grid_images_unit = new ArrayList<>();
		grid_images_count = new ArrayList<>();
		grid_images_faction = new ArrayList<>();
		grid_images_health = new ArrayList<>();
		grid_images_special = new ArrayList<>();
		scale_type = 1;
		scale_method = 3;
		max_width = 100;
		max_height = 100;
		grid_scale_width = 100;
		grid_scale_height = 100;
	}
	public void get_all_images() 
	{
		s.debug.message("asset_images:get_all_images");
		black = s.io.external.get_image(s.io.external.file_images_black);
		clear = s.io.external.get_image(s.io.external.file_images_clear);
		
		/* must be set to 0 is black, 1 is clear for all arraylists  as default values*/
		source_images_land = s.io.external.get_all_images(s.io.external.directory_images_land);
		source_images_border = s.io.external.get_all_images(s.io.external.directory_images_border);
		source_images_resource = s.io.external.get_all_images(s.io.external.directory_images_resource);
		source_images_city = s.io.external.get_all_images(s.io.external.directory_images_city);
		source_images_unit = s.io.external.get_all_images(s.io.external.directory_images_unit);
		source_images_health = s.io.external.get_all_images(s.io.external.directory_images_health);
		source_images_count = s.io.external.get_all_images(s.io.external.directory_images_count);
		source_images_faction = s.io.external.get_all_images(s.io.external.directory_images_faction);
		source_images_special = s.io.external.get_all_images(s.io.external.directory_images_special);
		
		source_images_land.add(0, clear);
		source_images_border.add(0, clear);
		source_images_resource.add(0, clear);
		source_images_city.add(0, clear);
		source_images_unit.add(0, clear);
		source_images_health.add(0, clear);
		source_images_count.add(0, clear);
		source_images_faction.add(0, clear);
		source_images_special.add(0, clear);
		
		source_images_land.add(0, black);
		source_images_border.add(0, black);
		source_images_resource.add(0, black);
		source_images_city.add(0, black);
		source_images_unit.add(0, black);
		source_images_health.add(0, black);
		source_images_count.add(0, black);
		source_images_faction.add(0, black);
		source_images_special.add(0, black);
		
		
		//PENDING WORK THIS IS FOR TESTING NOT FINAL SPOT
		get_rescaled_sources(max_width, max_height);
		get_rescaled_grid_images(grid_scale_width, grid_scale_height);
	}
	public BufferedImage get_rescaled_image(BufferedImage source, int width, int height)
	{
		s.debug.message("asset_images:get_rescaled_image");
		Image origonal = source.getScaledInstance(width, height, source.getType());
		BufferedImage resized = new BufferedImage(width, height, source.getType());
		Graphics2D graphic = resized.createGraphics();
		graphic.drawImage(origonal, 0, 0, null);
		graphic.dispose();
		return resized;
	}
	public void get_rescaled_sources(int width, int height)
	{
		s.debug.message("asset_images:get_rescaled_sources");
		for(int x = 0; x < source_images_land.size(); x++) {
			source_images_land.set(x, get_rescaled_image(source_images_land.get(x), width, height));
		}
		for(int x = 0; x < source_images_border.size(); x++) {
			source_images_border.set(x, get_rescaled_image(source_images_border.get(x), width, height));
		}
		for(int x = 0; x < source_images_resource.size(); x++) {
			source_images_resource.set(x, get_rescaled_image(source_images_resource.get(x), width, height));
		}
		for(int x = 0; x < source_images_city.size(); x++) {
			source_images_city.set(x, get_rescaled_image(source_images_city.get(x), width, height));
		}
		for(int x = 0; x < source_images_unit.size(); x++) {
			source_images_unit.set(x, get_rescaled_image(source_images_unit.get(x), width, height));
		}
		for(int x = 0; x < source_images_health.size(); x++) {
			source_images_health.set(x, get_rescaled_image(source_images_health.get(x), width, height));
		}
		for(int x = 0; x < source_images_count.size(); x++) {
			source_images_count.set(x, get_rescaled_image(source_images_count.get(x), width, height));
		}
		for(int x = 0; x < source_images_faction.size(); x++) {
			source_images_faction.set(x, get_rescaled_image(source_images_faction.get(x), width, height));
		}
		for(int x = 0; x < source_images_special.size(); x++) {
			source_images_special.set(x, get_rescaled_image(source_images_special.get(x), width, height));
		}
	}
	public void get_rescaled_grid_images(int width, int height)
	{
		s.debug.message("asset_images:get_rescaled_grid_images");
		for(int x = 0; x < source_images_land.size(); x++) {
			grid_images_land.add(get_rescaled_image(source_images_land.get(x), width, height));
		}
		for(int x = 0; x < source_images_border.size(); x++) {
			grid_images_border.add(get_rescaled_image(source_images_border.get(x), width, height));
		}
		for(int x = 0; x < source_images_resource.size(); x++) {
			grid_images_resource.add(get_rescaled_image(source_images_resource.get(x), width, height));
		}
		for(int x = 0; x < source_images_city.size(); x++) {
			grid_images_city.add(get_rescaled_image(source_images_city.get(x), width, height));
		}
		for(int x = 0; x < source_images_unit.size(); x++) {
			grid_images_unit.add(get_rescaled_image(source_images_unit.get(x), width, height)); 
		}
		for(int x = 0; x < source_images_health.size(); x++) {
			grid_images_health.add(get_rescaled_image(source_images_health.get(x), width, height));
		}
		for(int x = 0; x < source_images_count.size(); x++) {
			grid_images_count.add(get_rescaled_image(source_images_count.get(x), width, height));
		}
		for(int x = 0; x < source_images_faction.size(); x++) {
			grid_images_faction.add(get_rescaled_image(source_images_faction.get(x), width, height));
		}
		for(int x = 0; x < source_images_special.size(); x++) {
			grid_images_special.add(get_rescaled_image(source_images_special.get(x), width, height));
		}
	}
}
