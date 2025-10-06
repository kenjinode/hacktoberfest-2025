import java.io.*;
import java.net.*;

public class EvenOddServer {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            new Thread(() -> server()).start();
            Thread.sleep(1000);
            client();
        }
    }

    static void server() {
        try (ServerSocket server = new ServerSocket(8000)) {
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            int num = Integer.parseInt(in.readLine());
            out.println(num % 2 == 0 ? "Even" : "Odd");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void client() {
        try (Socket socket = new Socket("localhost", 8000)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println(25);
            System.out.println("Server says: " + in.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
