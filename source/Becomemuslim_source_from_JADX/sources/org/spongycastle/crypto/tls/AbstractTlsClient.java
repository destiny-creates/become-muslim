package org.spongycastle.crypto.tls;

import java.util.Hashtable;
import java.util.Vector;

public abstract class AbstractTlsClient extends AbstractTlsPeer implements TlsClient {
    /* renamed from: a */
    protected TlsCipherFactory f31788a;
    /* renamed from: b */
    protected TlsClientContext f31789b;
    /* renamed from: c */
    protected Vector f31790c;
    /* renamed from: d */
    protected int[] f31791d;
    /* renamed from: e */
    protected short[] f31792e;
    /* renamed from: f */
    protected short[] f31793f;
    /* renamed from: g */
    protected int f31794g;
    /* renamed from: h */
    protected short f31795h;

    /* renamed from: a */
    public void mo6458a(NewSessionTicket newSessionTicket) {
    }

    /* renamed from: a */
    public void mo6461a(byte[] bArr) {
    }

    /* renamed from: b */
    public Vector mo6462b() {
        return null;
    }

    public AbstractTlsClient() {
        this(new DefaultTlsCipherFactory());
    }

    public AbstractTlsClient(TlsCipherFactory tlsCipherFactory) {
        this.f31788a = tlsCipherFactory;
    }

    /* renamed from: a */
    protected boolean m40832a(Integer num, byte[] bArr) {
        if (num.intValue() != 10) {
            return null;
        }
        TlsECCUtils.m27673a(bArr);
        return true;
    }

    /* renamed from: a */
    protected void m40826a(Hashtable hashtable, Integer num) {
        byte[] a = TlsUtils.m27827a(hashtable, num);
        if (a == null) {
            return;
        }
        if (m40832a(num, a) == null) {
            throw new TlsFatalAlert((short) 47);
        }
    }

    /* renamed from: a */
    public ProtocolVersion m40823a() {
        return ProtocolVersion.f22512b;
    }

    /* renamed from: a */
    public void mo6459a(ProtocolVersion protocolVersion) {
        if (m40823a().m27568a(protocolVersion) == null) {
            throw new TlsFatalAlert((short) 70);
        }
    }

    /* renamed from: a */
    public void mo6455a(int i) {
        this.f31794g = i;
    }

    /* renamed from: a */
    public void mo6460a(short s) {
        this.f31795h = s;
    }

    /* renamed from: a */
    public void mo6456a(Hashtable hashtable) {
        if (hashtable != null) {
            m40826a(hashtable, TlsUtils.f22638e);
            m40826a(hashtable, TlsECCUtils.f22581a);
            if (TlsECCUtils.m27679c(this.f31794g)) {
                this.f31793f = TlsECCUtils.m27677b(hashtable);
            } else {
                m40826a(hashtable, TlsECCUtils.f22582b);
            }
        }
    }

    /* renamed from: a */
    public void mo6457a(Vector vector) {
        if (vector != null) {
            throw new TlsFatalAlert((short) 10);
        }
    }

    /* renamed from: c */
    public TlsCompression mo6463c() {
        if (this.f31795h == (short) 0) {
            return new TlsNullCompression();
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: d */
    public TlsCipher mo6464d() {
        return this.f31788a.mo5807a(this.f31789b, TlsUtils.m27881j(this.f31794g), TlsUtils.m27883l(this.f31794g));
    }
}
