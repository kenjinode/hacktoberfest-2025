import java.io.*;
import java.net.*;

public class SimpleChat {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            new Thread(() -> startServer()).start();
            Thread.sleep(1000);
            startClient();
        }
    }

    static void startServer() {
        try (ServerSocket server = new ServerSocket(5000)) {
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Server received: " + in.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void startClient() {
        try (Socket socket = new Socket("localhost", 5000)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello from client!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
