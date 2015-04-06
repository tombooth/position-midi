package uk.co.tombooth.positionmidi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;


public class Server extends WebSocketServer {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Server(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        System.out.println("Web socket open");
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        System.out.println("Web socket closed");
    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {
        try {
            Motion motion = objectMapper.readValue(s, Motion.class);
            System.out.println(motion);
        } catch (IOException e) {
            System.err.println("Failed to parse motion object");
            System.err.println(s);
            e.printStackTrace();
        }
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {
        System.out.println("Web socket error");
        e.printStackTrace();
    }

    public static void main(String[] args) throws UnknownHostException {
        int port = 6543;
        new Server(new InetSocketAddress(port)).start();
        System.out.println("Running on " + port);
    }
}
