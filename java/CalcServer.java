import java.io.*;
import java.net.*;

public class CalcServer {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            new Thread(() -> server()).start();
            Thread.sleep(1000);
            client();
        }
    }

    static void server() {
        try (ServerSocket server = new ServerSocket(9100)) {
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String[] parts = in.readLine().split(" ");
            double a = Double.parseDouble(parts[0]);
            double b = Double.parseDouble(parts[2]);
            String op = parts[1];
            double result = switch (op) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> b != 0 ? a / b : Double.NaN;
                default -> 0;
            };
            out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void client() {
        try (Socket socket = new Socket("localhost", 9100)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("10 + 5");
            System.out.println(in.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
