package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;

public abstract class TlsProtocol {
    /* renamed from: h */
    protected static final Integer f22604h = Integers.m29396a(65281);
    /* renamed from: i */
    protected static final Integer f22605i = Integers.m29396a(35);
    /* renamed from: a */
    private ByteQueue f22606a;
    /* renamed from: b */
    private ByteQueue f22607b;
    /* renamed from: c */
    private ByteQueue f22608c;
    /* renamed from: d */
    private volatile boolean f22609d;
    /* renamed from: e */
    private volatile boolean f22610e;
    /* renamed from: f */
    private volatile boolean f22611f;
    /* renamed from: g */
    private volatile boolean f22612g;
    /* renamed from: j */
    RecordStream f22613j;
    /* renamed from: k */
    protected TlsSession f22614k;
    /* renamed from: l */
    protected SessionParameters f22615l;
    /* renamed from: m */
    protected SecurityParameters f22616m;
    /* renamed from: n */
    protected Certificate f22617n;
    /* renamed from: o */
    protected int[] f22618o;
    /* renamed from: p */
    protected short[] f22619p;
    /* renamed from: q */
    protected Hashtable f22620q;
    /* renamed from: r */
    protected Hashtable f22621r;
    /* renamed from: s */
    protected short f22622s;
    /* renamed from: t */
    protected boolean f22623t;
    /* renamed from: u */
    protected boolean f22624u;
    /* renamed from: v */
    protected boolean f22625v;
    /* renamed from: w */
    protected boolean f22626w;
    /* renamed from: x */
    protected boolean f22627x;
    /* renamed from: y */
    private byte[] f22628y;

    class HandshakeMessage extends ByteArrayOutputStream {
        /* renamed from: a */
        final /* synthetic */ TlsProtocol f22603a;

        HandshakeMessage(TlsProtocol tlsProtocol, short s) {
            this(tlsProtocol, s, 60);
        }

        HandshakeMessage(TlsProtocol tlsProtocol, short s, int i) {
            this.f22603a = tlsProtocol;
            super(i + 4);
            TlsUtils.m27817a(s, (OutputStream) this);
            this.count += 3;
        }

        /* renamed from: a */
        void m27731a() {
            int i = this.count - 4;
            TlsUtils.m27856c(i);
            TlsUtils.m27858c(i, this.buf, 1);
            this.f22603a.m27764c(this.buf, 0, this.count);
            this.buf = null;
        }
    }

    /* renamed from: o */
    private void mo5843o() {
    }

    /* renamed from: a */
    protected abstract TlsContext mo5835a();

    /* renamed from: a */
    protected void mo5842a(short s) {
    }

    /* renamed from: a */
    protected abstract void mo5836a(short s, byte[] bArr);

    /* renamed from: b */
    abstract AbstractTlsContext mo5837b();

    /* renamed from: c */
    protected abstract TlsPeer mo5838c();

    /* renamed from: e */
    protected void m27765e() {
    }

    /* renamed from: f */
    protected void m27766f() {
        if (this.f22616m.f22550l < (short) 0) {
            return;
        }
        if (MaxFragmentLength.m27560a(this.f22616m.f22550l)) {
            this.f22613j.m27579a(1 << (this.f22616m.f22550l + 8));
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: a */
    protected void m27754a(boolean z) {
        if (z != this.f22624u) {
            throw new TlsFatalAlert((short) 10);
        }
    }

    /* renamed from: a */
    protected void m27753a(short s, byte[] bArr, int i, int i2) {
        switch (s) {
            case (short) 20:
                m27740d(bArr, i, i2);
                return;
            case (short) 21:
                this.f22607b.m27537a(bArr, i, i2);
                mo5844p();
                return;
            case (short) 22:
                this.f22608c.m27537a(bArr, i, i2);
                mo5839d();
                return;
            case (short) 23:
                if (this.f22611f != (short) 0) {
                    this.f22606a.m27537a(bArr, i, i2);
                    mo5843o();
                    return;
                }
                throw new TlsFatalAlert((short) 10);
            case (short) 24:
                if (this.f22611f == (short) 0) {
                    throw new TlsFatalAlert((short) 10);
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: d */
    private void mo5839d() {
        int i;
        do {
            i = 1;
            if (this.f22608c.m27536a() >= 4) {
                byte[] bArr = new byte[4];
                this.f22608c.m27538a(bArr, 0, 4, 0);
                short a = TlsUtils.m27804a(bArr, 0);
                int c = TlsUtils.m27852c(bArr, 1);
                if (this.f22608c.m27536a() >= c + 4) {
                    boolean z;
                    TlsContext a2;
                    byte[] a3 = this.f22608c.m27539a(c, 4);
                    if (this.f22622s != (short) 16) {
                        if (a != (short) 20) {
                            z = false;
                            m27754a(z);
                            if (a != (short) 0) {
                                if (a != (short) 20) {
                                    a2 = mo5835a();
                                    if (this.f22628y == null && a2.mo5810c().m27599d() != null) {
                                        this.f22628y = m27760b(a2.mo6487f() ^ true);
                                    }
                                }
                                this.f22613j.m27584a(bArr, 0, 4);
                                this.f22613j.m27584a(a3, 0, c);
                            }
                            mo5836a(a, a3);
                            continue;
                        }
                    }
                    z = true;
                    m27754a(z);
                    if (a != (short) 0) {
                        if (a != (short) 20) {
                            a2 = mo5835a();
                            this.f22628y = m27760b(a2.mo6487f() ^ true);
                        }
                        this.f22613j.m27584a(bArr, 0, 4);
                        this.f22613j.m27584a(a3, 0, c);
                    }
                    mo5836a(a, a3);
                    continue;
                }
            }
            i = 0;
            continue;
        } while (i != 0);
    }

    /* renamed from: p */
    private void mo5844p() {
        while (this.f22607b.m27536a() >= 2) {
            byte[] a = this.f22607b.m27539a(2, 0);
            short s = (short) a[0];
            short s2 = (short) a[1];
            mo5838c().mo5822a(s, s2);
            if (s != (short) 2) {
                if (s2 == (short) 0) {
                    m27763c(false);
                }
                mo5842a(s2);
            } else {
                m27769i();
                this.f22610e = true;
                this.f22609d = true;
                this.f22613j.m27594i();
                throw new IOException("Internal TLS error, this could be an attack");
            }
        }
    }

    /* renamed from: d */
    private void m27740d(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            if (TlsUtils.m27804a(bArr, i + i3) != (short) 1) {
                throw new TlsFatalAlert(50);
            } else if (this.f22624u || this.f22607b.m27536a() > 0 || this.f22608c.m27536a() > 0) {
                throw new TlsFatalAlert(10);
            } else {
                this.f22613j.m27589d();
                this.f22624u = true;
                m27765e();
                i3++;
            }
        }
    }

    /* renamed from: g */
    protected int m27767g() {
        return this.f22606a.m27536a();
    }

    /* renamed from: a */
    protected int m27745a(byte[] bArr, int i, int i2) {
        if (i2 < 1) {
            return 0;
        }
        while (this.f22606a.m27536a() == 0) {
            if (!this.f22609d) {
                m27768h();
            } else if (this.f22610e == null) {
                return -1;
            } else {
                throw new IOException("Internal TLS error, this could be an attack");
            }
        }
        i2 = Math.min(i2, this.f22606a.m27536a());
        this.f22606a.m27541b(bArr, i, i2, 0);
        return i2;
    }

    /* renamed from: h */
    protected void m27768h() {
        try {
            if (!this.f22613j.m27590e()) {
                throw new EOFException();
            }
        } catch (Throwable e) {
            if (!this.f22609d) {
                m27751a((short) 2, e.m27700a(), "Failed to read record", e);
            }
            throw e;
        } catch (Throwable e2) {
            if (!this.f22609d) {
                m27751a((short) 2, (short) 80, "Failed to read record", e2);
            }
            throw e2;
        } catch (Throwable e22) {
            if (!this.f22609d) {
                m27751a((short) 2, (short) 80, "Failed to read record", e22);
            }
            throw e22;
        }
    }

    /* renamed from: b */
    protected void m27758b(short s, byte[] bArr, int i, int i2) {
        try {
            this.f22613j.m27582a(s, bArr, i, i2);
        } catch (Throwable e) {
            if (this.f22609d == null) {
                m27751a((short) 2, e.m27700a(), "Failed to write record", e);
            }
            throw e;
        } catch (Throwable e2) {
            if (this.f22609d == null) {
                m27751a((short) 2, (short) 80, "Failed to write record", e2);
            }
            throw e2;
        } catch (Throwable e22) {
            if (this.f22609d == null) {
                m27751a((short) 2, (short) 80, "Failed to write record", e22);
            }
            throw e22;
        }
    }

    /* renamed from: b */
    protected void m27759b(byte[] bArr, int i, int i2) {
        if (!this.f22609d) {
            while (i2 > 0) {
                if (this.f22612g) {
                    m27758b((short) 23, bArr, i, 1);
                    i++;
                    i2--;
                }
                if (i2 > 0) {
                    int min = Math.min(i2, this.f22613j.m27578a());
                    m27758b((short) 23, bArr, i, min);
                    i += min;
                    i2 -= min;
                }
            }
        } else if (this.f22610e != null) {
            throw new IOException("Internal TLS error, this could be an attack");
        } else {
            throw new IOException("Sorry, connection has been closed, you cannot write more data");
        }
    }

    /* renamed from: c */
    protected void m27764c(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            int min = Math.min(i2, this.f22613j.m27578a());
            m27758b((short) 22, bArr, i, min);
            i += min;
            i2 -= min;
        }
    }

    /* renamed from: a */
    protected void m27751a(short s, short s2, String str, Throwable th) {
        if (!this.f22609d) {
            this.f22609d = true;
            if (s == (short) 2) {
                m27769i();
                this.f22610e = true;
            }
            m27757b(s, s2, str, th);
            this.f22613j.m27594i();
            if (s != (short) 2) {
                return;
            }
        }
        throw new IOException("Internal TLS error, this could be an attack");
    }

    /* renamed from: i */
    protected void m27769i() {
        if (this.f22615l != null) {
            this.f22615l.m27612a();
            this.f22615l = null;
        }
        if (this.f22614k != null) {
            this.f22614k.mo5846b();
            this.f22614k = null;
        }
    }

    /* renamed from: c */
    protected void m27762c(ByteArrayInputStream byteArrayInputStream) {
        if (this.f22628y != null) {
            byte[] b = TlsUtils.m27849b(this.f22628y.length, (InputStream) byteArrayInputStream);
            m27739d(byteArrayInputStream);
            if (Arrays.m29372b(this.f22628y, b) == null) {
                throw new TlsFatalAlert((short) 51);
            }
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: b */
    protected void m27757b(short s, short s2, String str, Throwable th) {
        mo5838c().mo5823a(s, s2, str, th);
        m27758b((short) 21, new byte[]{(byte) s, (byte) s2}, 0, 2);
    }

    /* renamed from: a */
    protected void m27750a(short s, String str) {
        m27757b((short) 1, s, str, null);
    }

    /* renamed from: a */
    protected void m27748a(Certificate certificate) {
        if (certificate == null) {
            certificate = Certificate.f22464a;
        }
        if (certificate.m27545a() && !mo5835a().mo6487f()) {
            ProtocolVersion e = mo5835a().mo5812e();
            if (e.m27573d()) {
                certificate = new StringBuilder();
                certificate.append(e.toString());
                certificate.append(" client didn't provide credentials");
                m27750a((short) 41, certificate.toString());
                return;
            }
        }
        OutputStream handshakeMessage = new HandshakeMessage(this, (short) 11);
        certificate.m27544a(handshakeMessage);
        handshakeMessage.m27731a();
    }

    /* renamed from: j */
    protected void m27770j() {
        byte[] bArr = new byte[]{(byte) 1};
        m27758b((short) 20, bArr, 0, bArr.length);
        this.f22613j.m27588c();
    }

    /* renamed from: k */
    protected void m27771k() {
        byte[] b = m27760b(mo5835a().mo6487f());
        HandshakeMessage handshakeMessage = new HandshakeMessage(this, (short) 20, b.length);
        handshakeMessage.write(b);
        handshakeMessage.m27731a();
    }

    /* renamed from: b */
    protected void m27756b(Vector vector) {
        OutputStream handshakeMessage = new HandshakeMessage(this, (short) 23);
        m27734a(handshakeMessage, vector);
        handshakeMessage.m27731a();
    }

    /* renamed from: b */
    protected byte[] m27760b(boolean z) {
        TlsContext a = mo5835a();
        return TlsUtils.m27829a(a, z ? "server finished" : "client finished", m27736a(a, this.f22613j.m27592g(), z ? TlsUtils.f22640g : TlsUtils.f22639f));
    }

    /* renamed from: l */
    public void m27772l() {
        m27763c(true);
    }

    /* renamed from: c */
    protected void m27763c(boolean z) {
        if (!this.f22609d) {
            if (z && !this.f22611f) {
                m27750a((short) true, "User canceled handshake");
            }
            m27751a((short) true, (short) 0, "Connection closed", null);
        }
    }

    /* renamed from: m */
    protected void m27773m() {
        this.f22613j.m27595j();
    }

    /* renamed from: a */
    protected short m27747a(Hashtable hashtable, Hashtable hashtable2, short s) {
        hashtable2 = TlsExtensionsUtils.m27695e(hashtable2);
        if (hashtable2 >= null) {
            if (MaxFragmentLength.m27560a(hashtable2)) {
                if (!this.f22623t) {
                    if (hashtable2 == TlsExtensionsUtils.m27695e(hashtable)) {
                    }
                }
            }
            throw new TlsFatalAlert(s);
        }
        return hashtable2;
    }

    /* renamed from: n */
    protected void m27774n() {
        if (TlsUtils.m27825a(mo5835a())) {
            throw new TlsFatalAlert((short) 40);
        }
        m27750a((short) 100, "Renegotiation not supported");
    }

    /* renamed from: d */
    protected static void m27739d(ByteArrayInputStream byteArrayInputStream) {
        if (byteArrayInputStream.available() > null) {
            throw new TlsFatalAlert((short) 50);
        }
    }

    /* renamed from: a */
    protected static byte[] m27737a(byte[] bArr) {
        return TlsUtils.m27832a(bArr);
    }

    /* renamed from: a */
    protected static void m27735a(TlsContext tlsContext, TlsKeyExchange tlsKeyExchange) {
        byte[] f = tlsKeyExchange.mo6493f();
        try {
            tlsContext.mo5810c().f22544f = TlsUtils.m27830a(tlsContext, f);
        } finally {
            if (f != null) {
                Arrays.m29351a(f, (byte) 0);
            }
        }
    }

    /* renamed from: a */
    protected static byte[] m27736a(TlsContext tlsContext, TlsHandshakeHash tlsHandshakeHash, byte[] bArr) {
        tlsHandshakeHash = tlsHandshakeHash.mo6486g();
        if (!(bArr == null || TlsUtils.m27825a(tlsContext) == null)) {
            tlsHandshakeHash.mo5731a(bArr, 0, bArr.length);
        }
        tlsContext = new byte[tlsHandshakeHash.mo5732b()];
        tlsHandshakeHash.mo5728a(tlsContext, 0);
        return tlsContext;
    }

    /* renamed from: e */
    protected static Hashtable m27741e(ByteArrayInputStream byteArrayInputStream) {
        if (byteArrayInputStream.available() < 1) {
            return null;
        }
        byte[] f = TlsUtils.m27875f((InputStream) byteArrayInputStream);
        m27739d(byteArrayInputStream);
        InputStream byteArrayInputStream2 = new ByteArrayInputStream(f);
        Hashtable hashtable = new Hashtable();
        while (byteArrayInputStream2.available() > 0) {
            if (hashtable.put(Integers.m29396a(TlsUtils.m27837b(byteArrayInputStream2)), TlsUtils.m27875f(byteArrayInputStream2)) != null) {
                throw new TlsFatalAlert((short) 47);
            }
        }
        return hashtable;
    }

    /* renamed from: f */
    protected static Vector m27742f(ByteArrayInputStream byteArrayInputStream) {
        byte[] g = TlsUtils.m27877g((InputStream) byteArrayInputStream);
        m27739d(byteArrayInputStream);
        InputStream byteArrayInputStream2 = new ByteArrayInputStream(g);
        Vector vector = new Vector();
        while (byteArrayInputStream2.available() > 0) {
            vector.addElement(new SupplementalDataEntry(TlsUtils.m27837b(byteArrayInputStream2), TlsUtils.m27875f(byteArrayInputStream2)));
        }
        return vector;
    }

    /* renamed from: a */
    protected static void m27733a(OutputStream outputStream, Hashtable hashtable) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Integer num = (Integer) keys.nextElement();
            int intValue = num.intValue();
            byte[] bArr = (byte[]) hashtable.get(num);
            TlsUtils.m27841b(intValue);
            TlsUtils.m27842b(intValue, byteArrayOutputStream);
            TlsUtils.m27844b(bArr, byteArrayOutputStream);
        }
        TlsUtils.m27844b(byteArrayOutputStream.toByteArray(), outputStream);
    }

    /* renamed from: a */
    protected static void m27734a(OutputStream outputStream, Vector vector) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < vector.size(); i++) {
            SupplementalDataEntry supplementalDataEntry = (SupplementalDataEntry) vector.elementAt(i);
            int a = supplementalDataEntry.m27622a();
            TlsUtils.m27841b(a);
            TlsUtils.m27842b(a, byteArrayOutputStream);
            TlsUtils.m27844b(supplementalDataEntry.m27623b(), byteArrayOutputStream);
        }
        TlsUtils.m27859c(byteArrayOutputStream.toByteArray(), outputStream);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    protected static int m27732a(org.spongycastle.crypto.tls.TlsContext r4, int r5) {
        /*
        r4 = org.spongycastle.crypto.tls.TlsUtils.m27860c(r4);
        r0 = 47;
        r1 = 1;
        switch(r5) {
            case 59: goto L_0x0038;
            case 60: goto L_0x0038;
            case 61: goto L_0x0038;
            case 62: goto L_0x0038;
            case 63: goto L_0x0038;
            case 64: goto L_0x0038;
            default: goto L_0x000a;
        };
    L_0x000a:
        switch(r5) {
            case 103: goto L_0x0038;
            case 104: goto L_0x0038;
            case 105: goto L_0x0038;
            case 106: goto L_0x0038;
            case 107: goto L_0x0038;
            default: goto L_0x000d;
        };
    L_0x000d:
        r2 = 2;
        switch(r5) {
            case 156: goto L_0x0038;
            case 157: goto L_0x002f;
            case 158: goto L_0x0038;
            case 159: goto L_0x002f;
            case 160: goto L_0x0038;
            case 161: goto L_0x002f;
            case 162: goto L_0x0038;
            case 163: goto L_0x002f;
            case 164: goto L_0x0038;
            case 165: goto L_0x002f;
            default: goto L_0x0011;
        };
    L_0x0011:
        switch(r5) {
            case 168: goto L_0x0038;
            case 169: goto L_0x002f;
            case 170: goto L_0x0038;
            case 171: goto L_0x002f;
            case 172: goto L_0x0038;
            case 173: goto L_0x002f;
            default: goto L_0x0014;
        };
    L_0x0014:
        r3 = 0;
        switch(r5) {
            case 185: goto L_0x002b;
            case 186: goto L_0x0038;
            case 187: goto L_0x0038;
            case 188: goto L_0x0038;
            case 189: goto L_0x0038;
            case 190: goto L_0x0038;
            case 191: goto L_0x0038;
            case 192: goto L_0x0038;
            case 193: goto L_0x0038;
            case 194: goto L_0x0038;
            case 195: goto L_0x0038;
            case 196: goto L_0x0038;
            case 197: goto L_0x0038;
            default: goto L_0x0018;
        };
    L_0x0018:
        switch(r5) {
            case 49187: goto L_0x0038;
            case 49188: goto L_0x002f;
            case 49189: goto L_0x0038;
            case 49190: goto L_0x002f;
            case 49191: goto L_0x0038;
            case 49192: goto L_0x002f;
            case 49193: goto L_0x0038;
            case 49194: goto L_0x002f;
            case 49195: goto L_0x0038;
            case 49196: goto L_0x002f;
            case 49197: goto L_0x0038;
            case 49198: goto L_0x002f;
            case 49199: goto L_0x0038;
            case 49200: goto L_0x002f;
            case 49201: goto L_0x0038;
            case 49202: goto L_0x002f;
            default: goto L_0x001b;
        };
    L_0x001b:
        switch(r5) {
            case 49266: goto L_0x0038;
            case 49267: goto L_0x002f;
            case 49268: goto L_0x0038;
            case 49269: goto L_0x002f;
            case 49270: goto L_0x0038;
            case 49271: goto L_0x002f;
            case 49272: goto L_0x0038;
            case 49273: goto L_0x002f;
            case 49274: goto L_0x0038;
            case 49275: goto L_0x002f;
            case 49276: goto L_0x0038;
            case 49277: goto L_0x002f;
            case 49278: goto L_0x0038;
            case 49279: goto L_0x002f;
            case 49280: goto L_0x0038;
            case 49281: goto L_0x002f;
            case 49282: goto L_0x0038;
            case 49283: goto L_0x002f;
            case 49284: goto L_0x0038;
            case 49285: goto L_0x002f;
            case 49286: goto L_0x0038;
            case 49287: goto L_0x002f;
            case 49288: goto L_0x0038;
            case 49289: goto L_0x002f;
            case 49290: goto L_0x0038;
            case 49291: goto L_0x002f;
            case 49292: goto L_0x0038;
            case 49293: goto L_0x002f;
            case 49294: goto L_0x0038;
            case 49295: goto L_0x002f;
            case 49296: goto L_0x0038;
            case 49297: goto L_0x002f;
            case 49298: goto L_0x0038;
            case 49299: goto L_0x002f;
            default: goto L_0x001e;
        };
    L_0x001e:
        switch(r5) {
            case 49307: goto L_0x002b;
            case 49308: goto L_0x0038;
            case 49309: goto L_0x0038;
            case 49310: goto L_0x0038;
            case 49311: goto L_0x0038;
            case 49312: goto L_0x0038;
            case 49313: goto L_0x0038;
            case 49314: goto L_0x0038;
            case 49315: goto L_0x0038;
            case 49316: goto L_0x0038;
            case 49317: goto L_0x0038;
            case 49318: goto L_0x0038;
            case 49319: goto L_0x0038;
            case 49320: goto L_0x0038;
            case 49321: goto L_0x0038;
            case 49322: goto L_0x0038;
            case 49323: goto L_0x0038;
            case 49324: goto L_0x0038;
            case 49325: goto L_0x0038;
            case 49326: goto L_0x0038;
            case 49327: goto L_0x0038;
            default: goto L_0x0021;
        };
    L_0x0021:
        switch(r5) {
            case 52243: goto L_0x0038;
            case 52244: goto L_0x0038;
            case 52245: goto L_0x0038;
            default: goto L_0x0024;
        };
    L_0x0024:
        switch(r5) {
            case 175: goto L_0x002b;
            case 177: goto L_0x002b;
            case 179: goto L_0x002b;
            case 181: goto L_0x002b;
            case 183: goto L_0x002b;
            case 49208: goto L_0x002b;
            case 49211: goto L_0x002b;
            case 49301: goto L_0x002b;
            case 49303: goto L_0x002b;
            case 49305: goto L_0x002b;
            default: goto L_0x0027;
        };
    L_0x0027:
        if (r4 == 0) goto L_0x002a;
    L_0x0029:
        return r1;
    L_0x002a:
        return r3;
    L_0x002b:
        if (r4 == 0) goto L_0x002e;
    L_0x002d:
        return r2;
    L_0x002e:
        return r3;
    L_0x002f:
        if (r4 == 0) goto L_0x0032;
    L_0x0031:
        return r2;
    L_0x0032:
        r4 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r4.<init>(r0);
        throw r4;
    L_0x0038:
        if (r4 == 0) goto L_0x003b;
    L_0x003a:
        return r1;
    L_0x003b:
        r4 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r4.<init>(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsProtocol.a(org.spongycastle.crypto.tls.TlsContext, int):int");
    }
}
