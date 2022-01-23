
public class assets {

	storage s;
	asset_images images;
	
	public void start(storage store)
	{
		s = store;
		images = new asset_images();
		images.start(s);
	}
}
