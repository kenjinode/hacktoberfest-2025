import java.io.*;
import java.net.*;

public class WordCountServer {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            new Thread(() -> server()).start();
            Thread.sleep(1000);
            client();
        }
    }

    static void server() {
        try (ServerSocket server = new ServerSocket(9000)) {
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String text = in.readLine();
            int count = text.split("\\s+").length;
            out.println("Word Count: " + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void client() {
        try (Socket socket = new Socket("localhost", 9000)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("Hacktoberfest is fun and educational");
            System.out.println(in.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
