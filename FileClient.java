import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
public class FileClient {
	private Socket s;
	public FileClient(String host, int port, String file) {
		try {
			s = new Socket(host, port);
			sendFile(file);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void sendFile(String file) throws IOException {
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[4096];
		while (fis.read(buffer) > 0) {
			dos.write(buffer);	
		}
		if(fis.read(buffer)==-1)
			System.out.println("File Sent Successfully !!!");
		else
			System.out.println("Something Went Wrong !!");
		
		fis.close();
		dos.close();	
	}
	public static void main(String[] args) {
		String ip_server="192.168.231.1";
		FileClient fc = new FileClient(ip_server, 1988, "GOLDBOY- CHAHTAAN Full Video - Latest Punjabi Song 2016 - NIRMAAN.mp4");
	}
}
