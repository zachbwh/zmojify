package backend;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CLI {

	public static void main(String[] args) {
		try {
			int port = 8082;

			ServerSocket ss = new ServerSocket(port);
			System.out.println("Server Socket created");

			for (; ; ) {

				Socket client = ss.accept();
				System.out.println("Client Socket accepted");

				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter out = new PrintWriter(client.getOutputStream());
				String rawRequest = "";

				String line = in.readLine();
				rawRequest += line + "\n";

				boolean isPost = line.startsWith("POST");
				final String contentHeader = "Content-Length: ";
				int contentLength = 0;

				while ((line = in.readLine()) != null) {
					if (line.length() == 0) {
						break;
					}
					rawRequest += line + "\n";
					System.out.println(line);
					if (isPost) {
						if (line.startsWith(contentHeader)) {
							contentLength = Integer.parseInt(line.substring(contentHeader.length()));
						}
					}
				}

				String query = "";
				System.out.println(query);
				int queryByte = 0;

				if (isPost) {
					for (int i = 0; i < contentLength; i++) {
						queryByte = in.read();
						query = query + (char)queryByte;
					}
				}

				System.out.println(query);

				String inputs[] = {"-z", "en", query};

				Input inpute = new Input();


				out.print("HTTP/1.1 200 \r\n"); // Version & status code
				out.print("Content-Type: text/plain\r\n"); // The type of data
				out.print("Connection: close\r\n"); // Will close stream
				out.print("\r\n"); // End of headers

				try {
					inpute.chooseQuery(inputs);
					out.print(inpute._emojiString);

				} catch (Exception e) {
					System.out.println(" file not found. or file I/O error occured");
				}

				out.close(); // Flush and close the output stream
				in.close(); // Close the input stream
				client.close(); // Close the socket itself
			}
		} catch (Exception e) {
			System.err.println(e);
			System.err.println("oh no");
		}
	}

}
