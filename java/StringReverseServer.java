import java.io.*;
import java.net.*;

public class StringReverseServer {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            new Thread(() -> server()).start();
            Thread.sleep(1000);
            client();
        }
    }

    static void server() {
        try (ServerSocket server = new ServerSocket(7000)) {
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String input = in.readLine();
            out.println(new StringBuilder(input).reverse().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void client() {
        try (Socket socket = new Socket("localhost", 7000)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("SocketProgramming");
            System.out.println("Reversed: " + in.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
