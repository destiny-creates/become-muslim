package okhttp3;

import p286d.C5869f;

public interface WebSocket {

    public interface Factory {
        WebSocket newWebSocket(Request request, WebSocketListener webSocketListener);
    }

    void cancel();

    boolean close(int i, String str);

    long queueSize();

    Request request();

    boolean send(C5869f c5869f);

    boolean send(String str);
}
