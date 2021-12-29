
public class Main {
	public static void main(String args[])
	{
		long start_time = System.currentTimeMillis();
		long end_time = 0;

		system sys = new system();
		
		sys.start();
		sys.print_stats();

		end_time = System.currentTimeMillis();
		System.out.println("start_time:" + start_time + " :end_time:" + end_time + " diff:" + ( end_time - start_time) );
	}
}
