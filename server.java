import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.NullPointerException;

public class server {

	public static void main(String[] args) {
		Socket socket = null;
		ServerSocket server_socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		
		
		try {
			server_socket = new ServerSocket(9800);
		}catch(IOException e) {
			System.out.println("해당포트가 열려있습니다.");
		}
		
		try {
			System.out.println("서버오픈!!");
			socket = server_socket.accept();
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
			
			String str = null;
			str = in.readLine();
			
			System.out.println("Client로 부터 온 메세지 : "+str);
			
			out.write(str);
			out.flush();
			socket.close();
		}catch(IOException e) {}

	}

}