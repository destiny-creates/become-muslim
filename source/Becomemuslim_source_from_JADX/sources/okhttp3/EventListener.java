package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

public abstract class EventListener {
    public static final EventListener NONE = new C76521();

    public interface Factory {
        EventListener create(Call call);
    }

    /* renamed from: okhttp3.EventListener$1 */
    class C76521 extends EventListener {
        C76521() {
        }
    }

    /* renamed from: okhttp3.EventListener$2 */
    class C76532 implements Factory {
        final /* synthetic */ EventListener val$listener;

        C76532(EventListener eventListener) {
            this.val$listener = eventListener;
        }

        public EventListener create(Call call) {
            return this.val$listener;
        }
    }

    public void callEnd(Call call) {
    }

    public void callFailed(Call call, IOException iOException) {
    }

    public void callStart(Call call) {
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    public void connectionAcquired(Call call, Connection connection) {
    }

    public void connectionReleased(Call call, Connection connection) {
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
    }

    public void dnsStart(Call call, String str) {
    }

    public void requestBodyEnd(Call call, long j) {
    }

    public void requestBodyStart(Call call) {
    }

    public void requestHeadersEnd(Call call, Request request) {
    }

    public void requestHeadersStart(Call call) {
    }

    public void responseBodyEnd(Call call, long j) {
    }

    public void responseBodyStart(Call call) {
    }

    public void responseHeadersEnd(Call call, Response response) {
    }

    public void responseHeadersStart(Call call) {
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
    }

    public void secureConnectStart(Call call) {
    }

    static Factory factory(EventListener eventListener) {
        return new C76532(eventListener);
    }
}
