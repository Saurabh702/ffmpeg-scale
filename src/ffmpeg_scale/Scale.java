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

	/* Help
	 * ====
	 * 
	 * java Scale <input-file> <new-resolution> <output-file> [<segment-length>]
	 * 		input-file     : file path for input video
	 *  	new-resolution : a resolution for the output video which is divisible by 2
	 *  	output-file    : file path for output video
	 *  	segment-length : duration of segment in seconds (optional)
	 */
	
	public static void main(String[] args) throws IOException {

		String command, input_filepath, new_resolution, segment_length, output_filepath;
		
		//Scanner reader = new Scanner(System.in);
		
		// Get user input
		//System.out.print("Enter the Input file path : ");
		input_filepath = args[0];//reader.nextLine();
		
		//System.out.print("Enter new resolution (144,240,360,480,720...) : ");
		new_resolution = args[1];//reader.nextLine();
		
		//System.out.print("Enter the Output file path : ");
	    output_filepath = args[2];//reader.nextLine();
	    
	    if(args.length == 4) {
	    	
	    	//System.out.print("Enter segment length (15,30,60) : "); 
	    	segment_length = args[3];//reader.nextLine();
			
		    //reader.close();
		    
		    //long startTime = System.nanoTime();
		    
	    	//Create temp directory
	    	command = "mkdir temp";
	    	Processes.run(new String[] {"sh","-c",command});
	    	
		    // Command to segment only the video stream and store audio stream separately
		    command = "ffmpeg -v quiet "
		    		+ "-i " + input_filepath
		    		+ " -dn -sn -an -c:v copy "
		    		+ "-bsf:v h264_mp4toannexb -copyts -start_at_zero "
		    		+ "-f segment -segment_list list.ffconcat "
		    		+ "-segment_time " + segment_length
		    		+ " temp/output_%03d.mp4"
		    		+ " -dn -sn -vn -c:a copy temp/audio.aac";
		    
		    Processes.run(new String[] {"sh","-c",command});
		    
		    // Get list of files from segment_list
		    File obj = new File("list.ffconcat");
		    List<String> file_list = new ArrayList<String>();
		    Scanner reader = new Scanner(obj);
		    
		    while(reader.hasNextLine()) {
		    	String data = reader.nextLine();
		    	data = data.split(" ")[1];
		    	if (data.endsWith("mp4")) {
		    		file_list.add("temp/"+data);
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
		    
		    // Store the list of m3u8 files generated in list.txt in this format `file 'segment.m3u8'`
		    command = "for f in temp/*.m3u8; do echo file \"'$f'\" >> list.txt; done";
		    Processes.run(new String[] {"sh","-c",command});
		    
		    // Command to join video segments and audio
		    command = "ffmpeg -v quiet "
		    		+ "-f concat -i list.txt "
		    		+ "-i temp/audio.aac -c copy "
		    		+ "-hls_list_size 0 "
		    		+ "-hls_time 10 "
		    		+ output_filepath;
			    
			Processes.run(new String[] {"sh","-c",command});
			
			// Perform cleanup
			Processes.run(new String[] {"sh","-c","rm -rf temp list.ffconcat list.txt"});
		    
			//long elapsedTime = System.nanoTime() - startTime;
			
			//System.out.print("Time : " + TimeUnit.NANOSECONDS.toSeconds(elapsedTime) + "s");
	    }
	    else {
	    	// Command to scale the video to <new-resolution> as a whole 
	    	command = "ffmpeg -v quiet"
					+ " -i " + input_filepath
					+ " -c:a copy"
					+ " -vf scale=-2:" + new_resolution
					+ " -hls_list_size 0"
					+ " -hls_time 10 "
					+ output_filepath;
	    	
	    	Processes.run(new String[] {"sh","-c",command});
	    }
	}
	
	static class Task implements Runnable {
		
		String command;
		
		public Task(String filename, String resolution) {
			
			// Command to scale the video stream to <resolution>
			command = "ffmpeg -v quiet"
					+ " -i " + filename
					+ " -vf scale=-2:" + resolution
					+ " -hls_list_size 0 " 
					+ filename + ".m3u8";
		}

		public void run() {
			try {
				Processes.run(new String[] {"sh","-c",command});
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
