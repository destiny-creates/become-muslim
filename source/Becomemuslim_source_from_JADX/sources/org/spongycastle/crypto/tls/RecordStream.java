package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

class RecordStream {
    /* renamed from: a */
    private static int f22519a = 16384;
    /* renamed from: b */
    private TlsProtocol f22520b;
    /* renamed from: c */
    private InputStream f22521c;
    /* renamed from: d */
    private OutputStream f22522d;
    /* renamed from: e */
    private TlsCompression f22523e;
    /* renamed from: f */
    private TlsCompression f22524f;
    /* renamed from: g */
    private TlsCompression f22525g;
    /* renamed from: h */
    private TlsCipher f22526h;
    /* renamed from: i */
    private TlsCipher f22527i;
    /* renamed from: j */
    private TlsCipher f22528j;
    /* renamed from: k */
    private long f22529k;
    /* renamed from: l */
    private long f22530l;
    /* renamed from: m */
    private ByteArrayOutputStream f22531m;
    /* renamed from: n */
    private TlsHandshakeHash f22532n;
    /* renamed from: o */
    private ProtocolVersion f22533o;
    /* renamed from: p */
    private ProtocolVersion f22534p;
    /* renamed from: q */
    private boolean f22535q;
    /* renamed from: r */
    private int f22536r;
    /* renamed from: s */
    private int f22537s;
    /* renamed from: t */
    private int f22538t;

    /* renamed from: a */
    int m27578a() {
        return this.f22536r;
    }

    /* renamed from: a */
    void m27579a(int i) {
        this.f22536r = i;
        this.f22537s = this.f22536r + 1024;
        this.f22538t = this.f22537s + 1024;
    }

    /* renamed from: b */
    ProtocolVersion m27586b() {
        return this.f22533o;
    }

    /* renamed from: a */
    void m27580a(ProtocolVersion protocolVersion) {
        this.f22533o = protocolVersion;
    }

    /* renamed from: b */
    void m27587b(ProtocolVersion protocolVersion) {
        this.f22534p = protocolVersion;
    }

    /* renamed from: a */
    void m27583a(boolean z) {
        this.f22535q = z;
    }

    /* renamed from: a */
    void m27581a(TlsCompression tlsCompression, TlsCipher tlsCipher) {
        this.f22523e = tlsCompression;
        this.f22526h = tlsCipher;
    }

    /* renamed from: c */
    void m27588c() {
        if (this.f22523e == null || this.f22526h == null) {
            throw new TlsFatalAlert((short) 40);
        }
        this.f22525g = this.f22523e;
        this.f22528j = this.f22526h;
        this.f22530l = 0;
    }

    /* renamed from: d */
    void m27589d() {
        if (this.f22523e == null || this.f22526h == null) {
            throw new TlsFatalAlert((short) 40);
        }
        this.f22524f = this.f22523e;
        this.f22527i = this.f22526h;
        this.f22529k = 0;
    }

    /* renamed from: e */
    boolean m27590e() {
        byte[] a = TlsUtils.m27826a(5, this.f22521c);
        if (a == null) {
            return false;
        }
        short a2 = TlsUtils.m27804a(a, 0);
        m27576a(a2, (short) 10);
        if (this.f22535q) {
            ProtocolVersion d = TlsUtils.m27865d(a, 1);
            if (this.f22533o == null) {
                this.f22533o = d;
            } else if (!d.m27572c(this.f22533o)) {
                throw new TlsFatalAlert((short) 47);
            }
        } else if ((TlsUtils.m27869e(a, 1) & -256) != 768) {
            throw new TlsFatalAlert((short) 47);
        }
        a = m27585a(a2, this.f22521c, TlsUtils.m27838b(a, 3));
        this.f22520b.m27753a(a2, a, 0, a.length);
        return true;
    }

    /* renamed from: a */
    byte[] m27585a(short s, InputStream inputStream, int i) {
        m27575a(i, this.f22538t, (short) 22);
        byte[] b = TlsUtils.m27849b(i, inputStream);
        TlsCipher tlsCipher = this.f22527i;
        long j = this.f22529k;
        this.f22529k = 1 + j;
        inputStream = tlsCipher.mo5832b(j, s, b, 0, b.length);
        m27575a(inputStream.length, this.f22537s, (short) 22);
        i = this.f22524f.mo5841b(this.f22531m);
        if (i != this.f22531m) {
            i.write(inputStream, 0, inputStream.length);
            i.flush();
            inputStream = m27577k();
        }
        m27575a(inputStream.length, this.f22536r, (short) 30);
        if (inputStream.length < 1) {
            if (s != (short) 23) {
                throw new TlsFatalAlert((short) 47);
            }
        }
        return inputStream;
    }

    /* renamed from: a */
    void m27582a(short s, byte[] bArr, int i, int i2) {
        short s2 = s;
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        if (this.f22534p != null) {
            Object a;
            m27576a(s, (short) 80);
            m27575a(i4, r0.f22536r, (short) 80);
            if (i4 < 1) {
                if (s2 != (short) 23) {
                    throw new TlsFatalAlert((short) 80);
                }
            }
            if (s2 == (short) 22) {
                m27584a(bArr, i3, i4);
            }
            OutputStream a2 = r0.f22525g.mo5840a(r0.f22531m);
            TlsCipher tlsCipher;
            if (a2 == r0.f22531m) {
                tlsCipher = r0.f22528j;
                long j = r0.f22530l;
                r0.f22530l = 1 + j;
                a = tlsCipher.mo5831a(j, s, bArr, i, i2);
            } else {
                a2.write(bArr, i3, i4);
                a2.flush();
                bArr2 = m27577k();
                m27575a(bArr2.length, i4 + 1024, (short) 80);
                tlsCipher = r0.f22528j;
                long j2 = r0.f22530l;
                r0.f22530l = 1 + j2;
                a = tlsCipher.mo5831a(j2, s, bArr2, 0, bArr2.length);
            }
            m27575a(a.length, r0.f22538t, (short) 80);
            byte[] bArr3 = new byte[(a.length + 5)];
            TlsUtils.m27818a(s, bArr3, 0);
            TlsUtils.m27814a(r0.f22534p, bArr3, 1);
            TlsUtils.m27843b(a.length, bArr3, 3);
            System.arraycopy(a, 0, bArr3, 5, a.length);
            r0.f22522d.write(bArr3);
            r0.f22522d.flush();
        }
    }

    /* renamed from: f */
    void m27591f() {
        this.f22532n = this.f22532n.mo6483d();
    }

    /* renamed from: g */
    TlsHandshakeHash m27592g() {
        return this.f22532n;
    }

    /* renamed from: h */
    TlsHandshakeHash m27593h() {
        TlsHandshakeHash tlsHandshakeHash = this.f22532n;
        this.f22532n = this.f22532n.mo6485f();
        return tlsHandshakeHash;
    }

    /* renamed from: a */
    void m27584a(byte[] bArr, int i, int i2) {
        this.f22532n.mo5731a(bArr, i, i2);
    }

    /* renamed from: i */
    void m27594i() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.f22521c;	 Catch:{ IOException -> 0x0005 }
        r0.close();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        r0 = r1.f22522d;	 Catch:{ IOException -> 0x000a }
        r0.close();	 Catch:{ IOException -> 0x000a }
    L_0x000a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.RecordStream.i():void");
    }

    /* renamed from: j */
    void m27595j() {
        this.f22522d.flush();
    }

    /* renamed from: k */
    private byte[] m27577k() {
        byte[] toByteArray = this.f22531m.toByteArray();
        this.f22531m.reset();
        return toByteArray;
    }

    /* renamed from: a */
    private static void m27576a(short s, short s2) {
        switch (s) {
            case (short) 20:
            case (short) 21:
            case (short) 22:
            case (short) 23:
            case (short) 24:
                return;
            default:
                throw new TlsFatalAlert(s2);
        }
    }

    /* renamed from: a */
    private static void m27575a(int i, int i2, short s) {
        if (i > i2) {
            throw new TlsFatalAlert(s);
        }
    }
}
