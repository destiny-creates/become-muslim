package expolib_v1.p321a.p322a.p324b;

import expolib_v1.p321a.C6226k;
import expolib_v1.p321a.p322a.C6148a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpecSelector */
/* renamed from: expolib_v1.a.a.b.b */
public final class C6149b {
    /* renamed from: a */
    private final List<C6226k> f19869a;
    /* renamed from: b */
    private int f19870b = 0;
    /* renamed from: c */
    private boolean f19871c;
    /* renamed from: d */
    private boolean f19872d;

    public C6149b(List<C6226k> list) {
        this.f19869a = list;
    }

    /* renamed from: a */
    public C6226k m25231a(SSLSocket sSLSocket) {
        C6226k c6226k;
        int size = this.f19869a.size();
        for (int i = this.f19870b; i < size; i++) {
            c6226k = (C6226k) this.f19869a.get(i);
            if (c6226k.m25666a(sSLSocket)) {
                this.f19870b = i + 1;
                break;
            }
        }
        c6226k = null;
        if (c6226k != null) {
            this.f19871c = m25230b(sSLSocket);
            C6148a.f19868a.mo5333a(c6226k, sSLSocket, this.f19872d);
            return c6226k;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to find acceptable protocols. isFallback=");
        stringBuilder.append(this.f19872d);
        stringBuilder.append(", modes=");
        stringBuilder.append(this.f19869a);
        stringBuilder.append(", supported protocols=");
        stringBuilder.append(Arrays.toString(sSLSocket.getEnabledProtocols()));
        throw new UnknownServiceException(stringBuilder.toString());
    }

    /* renamed from: a */
    public boolean m25232a(IOException iOException) {
        boolean z = true;
        this.f19872d = true;
        if (!this.f19871c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z2 = iOException instanceof SSLHandshakeException;
        if ((z2 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (!z2) {
            if ((iOException instanceof SSLProtocolException) == null) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: b */
    private boolean m25230b(SSLSocket sSLSocket) {
        for (int i = this.f19870b; i < this.f19869a.size(); i++) {
            if (((C6226k) this.f19869a.get(i)).m25666a(sSLSocket)) {
                return true;
            }
        }
        return null;
    }
}
