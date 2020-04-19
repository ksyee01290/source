import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		Socket socket = null;

		BufferedReader in = null;
		BufferedReader in2 = null;

		PrintWriter out = null;
		InetAddress ia = null;

		try {
			ia = InetAddress.getByName("127.0.0.1");
			socket = new Socket(ia, 9700);

			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			in2 = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));

			System.out.println(socket.toString());
		} catch (IOException e) {
		}

		try {
			System.out.print("서버로 보낼 메세지:");
			String data = in2.readLine();
			out.println(data);
			out.flush();
			String str2 = in.readLine();

			System.out.println("서버로부터 되돌아온 메세지:" + str2);
			socket.close();
		} catch (IOException e) {
		}

	}

}
