package okhttp3;

import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.List;

public final class JavaNetAuthenticator implements Authenticator {
    public Request authenticate(Route route, Response response) {
        JavaNetAuthenticator javaNetAuthenticator = this;
        List challenges = response.challenges();
        Request request = response.request();
        HttpUrl url = request.url();
        Object obj = response.code() == 407 ? 1 : null;
        Proxy proxy = route.proxy();
        int size = challenges.size();
        for (int i = 0; i < size; i++) {
            Challenge challenge = (Challenge) challenges.get(i);
            if ("Basic".equalsIgnoreCase(challenge.scheme())) {
                PasswordAuthentication requestPasswordAuthentication;
                if (obj != null) {
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                    requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(inetSocketAddress.getHostName(), getConnectToInetAddress(proxy, url), inetSocketAddress.getPort(), url.scheme(), challenge.realm(), challenge.scheme(), url.url(), RequestorType.PROXY);
                } else {
                    requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(url.host(), getConnectToInetAddress(proxy, url), url.port(), url.scheme(), challenge.realm(), challenge.scheme(), url.url(), RequestorType.SERVER);
                }
                if (requestPasswordAuthentication != null) {
                    return request.newBuilder().header(obj != null ? "Proxy-Authorization" : "Authorization", Credentials.basic(requestPasswordAuthentication.getUserName(), new String(requestPasswordAuthentication.getPassword()), challenge.charset())).build();
                }
            }
        }
        return null;
    }

    private InetAddress getConnectToInetAddress(Proxy proxy, HttpUrl httpUrl) {
        if (proxy == null || proxy.type() == Type.DIRECT) {
            return InetAddress.getByName(httpUrl.host());
        }
        return ((InetSocketAddress) proxy.address()).getAddress();
    }
}
