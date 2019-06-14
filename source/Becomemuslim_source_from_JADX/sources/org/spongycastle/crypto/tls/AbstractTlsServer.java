package org.spongycastle.crypto.tls;

import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.util.Arrays;

public abstract class AbstractTlsServer extends AbstractTlsPeer implements TlsServer {
    /* renamed from: a */
    protected TlsCipherFactory f31796a;
    /* renamed from: b */
    protected TlsServerContext f31797b;
    /* renamed from: c */
    protected ProtocolVersion f31798c;
    /* renamed from: d */
    protected int[] f31799d;
    /* renamed from: e */
    protected short[] f31800e;
    /* renamed from: f */
    protected Hashtable f31801f;
    /* renamed from: g */
    protected boolean f31802g;
    /* renamed from: h */
    protected short f31803h;
    /* renamed from: i */
    protected boolean f31804i;
    /* renamed from: j */
    protected Vector f31805j;
    /* renamed from: k */
    protected boolean f31806k;
    /* renamed from: l */
    protected int[] f31807l;
    /* renamed from: m */
    protected short[] f31808m;
    /* renamed from: n */
    protected short[] f31809n;
    /* renamed from: o */
    protected ProtocolVersion f31810o;
    /* renamed from: p */
    protected int f31811p;
    /* renamed from: q */
    protected short f31812q;
    /* renamed from: r */
    protected Hashtable f31813r;

    /* renamed from: a */
    protected boolean m40842a() {
        return true;
    }

    /* renamed from: b */
    protected boolean m40845b() {
        return false;
    }

    /* renamed from: f */
    protected abstract int[] mo6817f();

    /* renamed from: n */
    public Vector mo6476n() {
        return null;
    }

    /* renamed from: o */
    public CertificateStatus mo6477o() {
        return null;
    }

    /* renamed from: p */
    public CertificateRequest mo6478p() {
        return null;
    }

    public AbstractTlsServer() {
        this(new DefaultTlsCipherFactory());
    }

    public AbstractTlsServer(TlsCipherFactory tlsCipherFactory) {
        this.f31796a = tlsCipherFactory;
    }

    /* renamed from: e */
    protected Hashtable m40848e() {
        Hashtable a = TlsExtensionsUtils.m27681a(this.f31813r);
        this.f31813r = a;
        return a;
    }

    /* renamed from: g */
    protected short[] m40850g() {
        return new short[]{(short) 0};
    }

    /* renamed from: h */
    protected ProtocolVersion m40851h() {
        return ProtocolVersion.f22513c;
    }

    /* renamed from: i */
    protected ProtocolVersion m40852i() {
        return ProtocolVersion.f22512b;
    }

    /* renamed from: a */
    protected boolean m40843a(int[] iArr, short[] sArr) {
        if (iArr == null) {
            return TlsECCUtils.m27666a();
        }
        for (int i : iArr) {
            if (NamedCurve.m27561a(i) && (!NamedCurve.m27562b(i) || TlsECCUtils.m27680d(i))) {
                return 1;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo6468a(ProtocolVersion protocolVersion) {
        this.f31798c = protocolVersion;
    }

    /* renamed from: b */
    public void mo6471b(boolean z) {
        if (!z) {
            return;
        }
        if (m40851h().m27570b(this.f31798c)) {
            throw new TlsFatalAlert((short) 86);
        }
    }

    /* renamed from: a */
    public void mo6469a(int[] iArr) {
        this.f31799d = iArr;
        this.f31806k = TlsECCUtils.m27667a(this.f31799d);
    }

    /* renamed from: a */
    public void mo6470a(short[] sArr) {
        this.f31800e = sArr;
    }

    /* renamed from: a */
    public void mo6465a(Hashtable hashtable) {
        this.f31801f = hashtable;
        if (hashtable != null) {
            this.f31802g = TlsExtensionsUtils.m27697f(hashtable);
            this.f31803h = TlsExtensionsUtils.m27695e(hashtable);
            if (this.f31803h >= (short) 0) {
                if (!MaxFragmentLength.m27560a(this.f31803h)) {
                    throw new TlsFatalAlert((short) 47);
                }
            }
            this.f31804i = TlsExtensionsUtils.m27699h(hashtable);
            this.f31805j = TlsUtils.m27797a(hashtable);
            if (this.f31805j != null) {
                if (!TlsUtils.m27824a(this.f31798c)) {
                    throw new TlsFatalAlert((short) 47);
                }
            }
            this.f31807l = TlsECCUtils.m27672a(hashtable);
            this.f31808m = TlsECCUtils.m27677b(hashtable);
        }
    }

    /* renamed from: j */
    public ProtocolVersion mo6472j() {
        if (m40852i().m27568a(this.f31798c)) {
            ProtocolVersion h = m40851h();
            if (this.f31798c.m27568a(h)) {
                h = this.f31798c;
                this.f31810o = h;
                return h;
            } else if (this.f31798c.m27570b(h)) {
                this.f31810o = h;
                return h;
            }
        }
        throw new TlsFatalAlert((short) 70);
    }

    /* renamed from: k */
    public int mo6473k() {
        boolean a = m40843a(this.f31807l, this.f31808m);
        int[] f = mo6817f();
        int i = 0;
        while (i < f.length) {
            int i2 = f[i];
            if (!Arrays.m29355a(this.f31799d, i2) || ((!a && TlsECCUtils.m27679c(i2)) || !TlsUtils.m27822a(i2, this.f31810o))) {
                i++;
            } else {
                this.f31811p = i2;
                return i2;
            }
        }
        throw new TlsFatalAlert((short) 40);
    }

    /* renamed from: l */
    public short mo6474l() {
        short[] g = m40850g();
        for (int i = 0; i < g.length; i++) {
            if (Arrays.m29359a(this.f31800e, g[i])) {
                short s = g[i];
                this.f31812q = s;
                return s;
            }
        }
        throw new TlsFatalAlert((short) 40);
    }

    /* renamed from: m */
    public Hashtable mo6475m() {
        if (this.f31802g && m40842a() && TlsUtils.m27885n(this.f31811p)) {
            TlsExtensionsUtils.m27686b(m40848e());
        }
        if (this.f31803h >= (short) 0 && MaxFragmentLength.m27560a(this.f31803h)) {
            TlsExtensionsUtils.m27682a(m40848e(), this.f31803h);
        }
        if (this.f31804i && m40845b()) {
            TlsExtensionsUtils.m27692d(m40848e());
        }
        if (this.f31808m != null && TlsECCUtils.m27679c(this.f31811p)) {
            this.f31809n = new short[]{(short) 0, (short) 1, (short) 2};
            TlsECCUtils.m27661a(m40848e(), this.f31809n);
        }
        return this.f31813r;
    }

    /* renamed from: a */
    public void mo6466a(Vector vector) {
        if (vector != null) {
            throw new TlsFatalAlert((short) 10);
        }
    }

    /* renamed from: a */
    public void mo6467a(Certificate certificate) {
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: c */
    public TlsCompression mo6463c() {
        if (this.f31812q == (short) 0) {
            return new TlsNullCompression();
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: d */
    public TlsCipher mo6464d() {
        return this.f31796a.mo5807a(this.f31797b, TlsUtils.m27881j(this.f31811p), TlsUtils.m27883l(this.f31811p));
    }

    /* renamed from: q */
    public NewSessionTicket mo6479q() {
        return new NewSessionTicket(0, TlsUtils.f22634a);
    }
}
