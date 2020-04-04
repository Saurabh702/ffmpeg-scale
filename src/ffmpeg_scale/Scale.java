package ffmpeg_scale;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Scale {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String command, input_filepath, new_resolution, segment_length, output_filepath;
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("Enter the Input file path : ");
		input_filepath = reader.nextLine();
		
		System.out.print("Enter new resolution (144,240,360,480,720...) : ");
		new_resolution = reader.nextLine();
		
		System.out.print("Enter segment length (15,30,60) : "); 
		segment_length = reader.nextLine();
		
		System.out.print("Enter the Output file path : ");
	    output_filepath = reader.nextLine();
	    
	    reader.close();
	    
	    command = "ffmpeg -v quiet "
	    		+ "-i " + input_filepath
	    		+ " -dn -sn -an -c:v copy "
	    		+ "-bsf:v h264_mp4toannexb -copyts -start_at_zero "
	    		+ "-f segment -segment_list list.ffconcat "
	    		+ "-segment_time " + segment_length
	    		+ " output_%03d.mp4"
	    		+ " -dn -sn -vn -c:a copy audio.aac";
	    
	    Processes.run(new String[] {"cmd.exe","/c",command});
	    
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
	    
	    int coreCount = Runtime.getRuntime().availableProcessors();
	    ExecutorService service = Executors.newFixedThreadPool(coreCount + 1);
	    
	    for (int i = 0; i < file_list.size(); i++) {
	    	service.execute(new Task(file_list.get(i),new_resolution));
	    }
	    
	    service.shutdown();
	    
	    while(!service.isTerminated());
	    
	    command = "ffmpeg -v quiet "
	    		+ "-f concat -i list.ffconcat "
	    		+ "-i audio.aac -c:a copy "
	    		+ "-c:v copy " + output_filepath;
		    
		Processes.run(new String[] {"cmd.exe","/c",command});
		
		Processes.run(new String[] {"cmd.exe","/c","rm output_* *.ffconcat audio.aac"});
	    
	}
	
	static class Task implements Runnable {
		
		String command;
		
		public Task(String filename, String resolution) {
			
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
