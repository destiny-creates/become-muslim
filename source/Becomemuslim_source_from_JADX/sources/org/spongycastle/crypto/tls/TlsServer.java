package org.spongycastle.crypto.tls;

import java.util.Hashtable;
import java.util.Vector;

public interface TlsServer extends TlsPeer {
    /* renamed from: a */
    void mo6465a(Hashtable hashtable);

    /* renamed from: a */
    void mo6466a(Vector vector);

    /* renamed from: a */
    void mo6467a(Certificate certificate);

    /* renamed from: a */
    void mo6468a(ProtocolVersion protocolVersion);

    /* renamed from: a */
    void mo6469a(int[] iArr);

    /* renamed from: a */
    void mo6470a(short[] sArr);

    /* renamed from: b */
    void mo6471b(boolean z);

    /* renamed from: j */
    ProtocolVersion mo6472j();

    /* renamed from: k */
    int mo6473k();

    /* renamed from: l */
    short mo6474l();

    /* renamed from: m */
    Hashtable mo6475m();

    /* renamed from: n */
    Vector mo6476n();

    /* renamed from: o */
    CertificateStatus mo6477o();

    /* renamed from: p */
    CertificateRequest mo6478p();

    /* renamed from: q */
    NewSessionTicket mo6479q();

    /* renamed from: t */
    TlsCredentials mo6818t();

    /* renamed from: u */
    TlsKeyExchange mo6819u();
}
