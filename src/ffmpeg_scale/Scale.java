package ffmpeg_scale;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Scale {

	public static void main(String[] args) throws IOException {

		String command, input_filepath, new_resolution, segment_length, output_filepath;
		
		Scanner reader = new Scanner(System.in);
		
		// Get user input
		System.out.print("Enter the Input file path : ");
		input_filepath = reader.nextLine();
		
		System.out.print("Enter new resolution (144,240,360,480,720...) : ");
		new_resolution = reader.nextLine();
		
		System.out.print("Enter segment length (15,30,60) : "); 
		segment_length = reader.nextLine();
		
		System.out.print("Enter the Output file path : ");
	    output_filepath = reader.nextLine();
	    
	    reader.close();
	    
	    long startTime = System.nanoTime();
	    
	    // Command to segment only the video stream and store audio stream separately
	    command = "ffmpeg -v quiet "
	    		+ "-i " + input_filepath
	    		+ " -dn -sn -an -c:v copy "
	    		+ "-bsf:v h264_mp4toannexb -copyts -start_at_zero "
	    		+ "-f segment -segment_list list.ffconcat "
	    		+ "-segment_time " + segment_length
	    		+ " output_%03d.mp4"
	    		+ " -dn -sn -vn -c:a copy audio.aac";
	    
	    Processes.run(new String[] {"cmd.exe","/c",command});
	    
	    // Get list of files from segment_list
	    File obj = new File("list.ffconcat");
	    List<String> file_list = new ArrayList<String>();
	    reader = new Scanner(obj);
	    
	    while(reader.hasNextLine()) {
	    	String data = reader.nextLine();
	    	data = data.split(" ")[1];
	    	if (data.endsWith("mp4")) {
	    		file_list.add(data);
	    	} 
	    }
	    
	    reader.close();
	    
	    // Get number of CPUs available
	    int coreCount = Runtime.getRuntime().availableProcessors();
	    
	    // Create a fixed ThreadPool based on number of CPUs available
	    ExecutorService service = Executors.newFixedThreadPool(coreCount);
	    
	    // Execute the thread for each segment
	    for (int i = 0; i < file_list.size(); i++) {
	    	service.execute(new Task(file_list.get(i),new_resolution));
	    }
	    
		// Wait for all tasks to finish in the thread pool
		service.shutdown();

		try {
			service.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    // Command to join video segments and audio
	    command = "ffmpeg -v quiet "
	    		+ "-f concat -i list.ffconcat "
	    		+ "-i audio.aac -c:a copy "
	    		+ "-c:v copy " + output_filepath;
		    
		Processes.run(new String[] {"cmd.exe","/c",command});
		
		// Perform cleanup
		Processes.run(new String[] {"cmd.exe","/c","rm output_* *.ffconcat audio.aac"});
	    
		long elapsedTime = System.nanoTime() - startTime;
		
		System.out.print("Time : " + TimeUnit.NANOSECONDS.toSeconds(elapsedTime) + "s");
	}
	
	static class Task implements Runnable {
		
		String command;
		
		public Task(String filename, String resolution) {
			
			// Command to scale the video stream to <resolution>
			command = "ffmpeg -v quiet "
					+ "-i " + filename
					+ " -vf scale=-2:" + resolution
					+ " temp_" + filename
					+ " && mv temp_" + filename + " " + filename;
		}

		public void run() {
			try {
				Processes.run(new String[] {"cmd.exe","/c",command});
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
