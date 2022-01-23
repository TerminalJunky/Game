
public class Main {
	
	public static void main(String args[])
	{
		String build_number = "20220116";
		storage s = new storage();
		s.start(build_number);
		s.recursive_start(s, build_number);
	
		System.out.println( s.asset.images.grid_images_unit.size() );
	}
}