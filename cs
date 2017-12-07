import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientMain {

	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket soc = new Socket("localhost", 30333);
		Scanner scan = new Scanner(System.in);
		while(true) {
			String str = scan.nextLine();
			str = str + '\n';
			BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(soc.getOutputStream()));
			writer.write(str);
			writer.flush();
			
			if ("exit\n".equals(str)) break;
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		
			str = reader.readLine();	
			System.out.println("Got  " +str +" from server\n");
		}
	}

}
-------------------------------------
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {

	
	public static void main(String[] args) throws IOException {
		
		ServerSocket srvSocket = new ServerSocket(30333);
		while(true) {
			Socket soc= srvSocket.accept();
			System.out.println("New connection from  " + soc.getInetAddress().getCanonicalHostName() );
			
			Thread th = new ServerThread(soc);
			th.start();
			
		} 
	}		
}

class ServerThread extends Thread{
	
	private Socket soc;
	
	ServerThread(Socket soc) {
		this.soc = soc;
	}
	

	
	@Override
	public void run() {
		while(true) {
			BufferedReader reader;
			String str;
			try {
				reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				str= reader.readLine();
			} catch (IOException ex) {
				System.out.println("IO");
				continue;
			}
			if("exit".equals(str)) {
				System.out.println("Client exit");
				break ;
			}
			System.out.println("Got massage: " +str);
			
			BufferedWriter writer;
			
			try {
				Scanner scan = new Scanner(System.in);
				String str2 = scan.nextLine();
				str2 = str2 + '\n';
				writer = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
				//writer.write("accept \n");
				writer.write(str2);
				writer.flush();
			} catch (IOException e) {
				System.out.println("Can't write to socket");
				break;
			}
		}
		
		System.out.println(getName() + " client thread quits");
		
		
	}
}
