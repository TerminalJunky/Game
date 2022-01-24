
public class assets {

	storage s;
	asset_images images;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("assets:start");
		images = new asset_images();
		images.start(s);
	}
}
