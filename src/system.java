
public class system {
	
	Runtime runtime;
	long memory_total;
	long memory_used;
	long memory_peak;
	long memory_max;
	
	public void start()
	{
		runtime = Runtime.getRuntime();
		memory_total = runtime.totalMemory();
		memory_max = runtime.maxMemory();
		memory_used = memory_total - runtime.freeMemory();
		memory_peak = memory_used;
	}
	public void print_stats()
	{
		System.out.println("memory_total:" + memory_total);
		System.out.println("memory_max:" + memory_max);
		System.out.println("memory_used:" + memory_used);
		System.out.println("memory_peak:" + memory_peak);
	}
	
	
}
