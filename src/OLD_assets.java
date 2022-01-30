
public class OLD_assets {

	storage s;
	OLD_asset_images images;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("assets:start");
		images = new OLD_asset_images();
		images.start(s);
	}
}
