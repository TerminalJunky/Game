import java.util.ArrayList;

public class debug {

	storage s;
	public long memory_total;
	public long memory_used;
	public long memory_peak;
	public long memory_max;
	public long time_start;
	public long time_end;
	public long time_run;
	public int max_log;
	public int cpu_cores;
	public String cpu_arch;
	public Runtime java_runtime;
	public String os_name;
	public String os_version;
	public String java_path;
	public String java_home;
	public String java_vendor;
	public String java_version;
	public String file_slash;
	public String build_number;
	public boolean debug_on;
	public boolean debug_gui_on;
	public ArrayList<String> messages;
	
	public void start(storage store, String build)
	{
		System.out.println("debug:start");
		s = store;
		debug_on = true;
		debug_gui_on = false;
		java_runtime = Runtime.getRuntime();
		cpu_cores = java_runtime.availableProcessors();
		cpu_arch = System.getProperty("os.arch");
		os_name = System.getProperty("os.name");
		os_version = System.getProperty("os.version");
		file_slash = System.getProperty("file.separator").toString();
		java_path = System.getProperty("java.class.path");
		java_home = System.getProperty("java.home");
		java_vendor = System.getProperty("java.vendor");
		java_version = System.getProperty("java.version");
		build_number = build;
		memory_total = java_runtime.totalMemory();
		memory_max = java_runtime.maxMemory();
		memory_used = memory_total - java_runtime.freeMemory();
		memory_peak = memory_used;
		messages = new ArrayList<>();
		time_start = System.currentTimeMillis();
		time_end = time_start;
	}
	public void bug()
	{
		messages.add("build_number:" + build_number);
		messages.add("os_name:" + os_name);
		messages.add("os_version:" + os_version );
		messages.add("cpu_arch:" + cpu_arch);
		messages.add("cpu_cores:" + cpu_cores);
		messages.add("file_slash:" + file_slash);
		messages.add("java_path:" + java_path);
		messages.add("memory_max:" + memory_max);
		messages.add("memory_total:" + memory_total);
		messages.add("memory_peak:" + memory_peak);
		messages.add("memory_used:" + memory_used);

		for(int x = 0; x < messages.size(); x++) {
		System.out.println(messages.get(x));
		}
		write_debug();
	}
	public void write_debug()
	{
		// pending work needs file manager
	}
	public void message(String message)
	{
		if(debug_on == true) {
			message = "MEM:" + calculate_memory() + ":TIME:" + time_to_run() + ":LOG:" + message;
			System.out.println(message);
			messages.add(message);
			if(messages.size() > max_log) {
				messages.remove(0);
			}
			if(debug_gui_on) {
				// pending work gui output not built
			}
		}
	}
	public long calculate_memory()
	{
		memory_used = memory_total - java_runtime.freeMemory();
		if(memory_used > memory_peak) {
			memory_peak = memory_used;
		}
		return memory_used;
	}
	public long time_to_run()
	{
		time_end = System.currentTimeMillis();
		time_run = time_end - time_start;
		return time_run;
	}
}
