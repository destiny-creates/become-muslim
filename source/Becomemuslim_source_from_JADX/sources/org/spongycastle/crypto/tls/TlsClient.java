package org.spongycastle.crypto.tls;

import java.util.Hashtable;
import java.util.Vector;

public interface TlsClient extends TlsPeer {
    /* renamed from: a */
    void mo6455a(int i);

    /* renamed from: a */
    void mo6456a(Hashtable hashtable);

    /* renamed from: a */
    void mo6457a(Vector vector);

    /* renamed from: a */
    void mo6458a(NewSessionTicket newSessionTicket);

    /* renamed from: a */
    void mo6459a(ProtocolVersion protocolVersion);

    /* renamed from: a */
    void mo6460a(short s);

    /* renamed from: a */
    void mo6461a(byte[] bArr);

    /* renamed from: b */
    Vector mo6462b();

    /* renamed from: e */
    TlsKeyExchange mo6815e();

    /* renamed from: f */
    TlsAuthentication mo6816f();
}
