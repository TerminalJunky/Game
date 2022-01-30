import java.awt.Dimension;

public class aspect_ratio {

	storage s;
	/* 
	scale is dimension / ratio example
	scale example 1920x1080
	scale_x is 16
	scale_y is 9
	scale_multiple is 120 time
	 */
	int ratio_x; 
	int ratio_y;
	int ratio_multiple;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("aspect_ratio:start");
	}
	public void get_ratio(int width, int height)
	{
		//PENDING WORK DOES NOT ACCOUNT FOR TALLER THAN LONGER
		int mod_x = width % 2;
		int mod_y = height % 2;
		if(mod_x > 0) {
			width--;
		} 
		if(mod_y > 0) {
			height--;
		}
		if( width == height ) {
			// ratio 1x1
			ratio_x = 1;
			ratio_y = 1;
			ratio_multiple = 4;
		} else if( (width / 16) == (height / 9)  ) {
			// ratio 16x9
			ratio_x = 16;
			ratio_y = 9;
			ratio_multiple = height / 9;
		} else if( (width / 16) == (height / 10)  ) {
			// ratio 16x10
			ratio_x = 16;
			ratio_y = 10;
			ratio_multiple = height / 10;
			
		} else if( (width / 4) == (height / 3)  ) {
			// ratio 4x3
			ratio_x = 4;
			ratio_y = 3;
			ratio_multiple = height / 3;
		} else if( (width / 21) == (height / 9)  ) {
			// ratio 21x9
			ratio_x = 21;
			ratio_y = 9;
			ratio_multiple = height / 9;
		} else if( (width / 7) == (height / 5)  ) {
			// ratio 7x5
			ratio_x = 7;
			ratio_y = 5;
			ratio_multiple = height / 5;
		} else if( (width / 3) == (height / 2)  ) {
			// ratio 3x2
			ratio_x = 3;
			ratio_y = 2;
			ratio_multiple = height / 2;
		} else if( (width / 8) == (height / 5)  ) {
			// ratio 8x5
			ratio_x = 8;
			ratio_y = 5;
			ratio_multiple = height / 5;
		}  else if( (width / 9) == (height / 5)  ) {
			// ratio 9x5
			ratio_x = 9;
			ratio_y = 5;
			ratio_multiple = height / 5;
		}  else if( (width / 25) == (height / 16)  ) {
			// ratio 25x16
			ratio_x = 25;
			ratio_y = 16;
			ratio_multiple = height / 16;
		}  else if( (width / 5) == (height / 3)  ) {
			// ratio 5x3
			ratio_x = 5;
			ratio_y = 3;
			ratio_multiple = height / 3;
		}  else if( (width / 2) == (height / 1)  ) {
			// ratio 2x1
			ratio_x = 2;
			ratio_y = 1;
			ratio_multiple = height;
		}  else if( (width / 21) == (height / 9)  ) {
			// ratio 21x9
			ratio_x = 21;
			ratio_y = 9;
			ratio_multiple = height / 9;
		} else {
			//PENDING WORK RATIO NOT FOUND
		}
	}
	public void get_ratio_from_dimension(Dimension dimensions)
	{
		
	}
}
