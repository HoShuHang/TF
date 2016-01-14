package tw.edu.ntut.csie.game.service;

import android.os.Handler;
import android.util.Log;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;
import java.net.URISyntaxException;

public class WSClient {
    private WebSocketClient mWebSocketClient;
    private static WSClient wsClient;
    private final String HOST = "127.0.0.1";
    private final int PORT = 8000;

    public static WSClient getInstance(){
        if(wsClient==null) {
            wsClient = new WSClient();
            wsClient.connectWebSocket();
        }
        return wsClient;
    }

    private void connectWebSocket() {
        URI uri;
        try {
            uri = new URI(HOST + ":" + String.valueOf(PORT));
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        mWebSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                Log.i("Websocket", "Opened");
                mWebSocketClient.send("Hello world");
            }

            @Override
            public void onMessage(String s) {
                Handler mHandler = new Handler();
                final String message = s;
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("Websocket", "onMessage");
                    }
                });
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                Log.i("Websocket", "Closed " + s);
            }

            @Override
            public void onError(Exception e) {
                Log.i("Websocket", "Error " + e.getMessage());
            }
        };
        mWebSocketClient.connect();
    }
}
