package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.util.Hashtable;
import org.spongycastle.util.Arrays;

public final class SessionParameters {
    /* renamed from: a */
    private int f22566a;
    /* renamed from: b */
    private short f22567b;
    /* renamed from: c */
    private byte[] f22568c;
    /* renamed from: d */
    private byte[] f22569d;

    public static final class Builder {
        /* renamed from: a */
        private int f22559a = -1;
        /* renamed from: b */
        private short f22560b = (short) -1;
        /* renamed from: c */
        private byte[] f22561c = null;
        /* renamed from: d */
        private Certificate f22562d = null;
        /* renamed from: e */
        private byte[] f22563e = null;
        /* renamed from: f */
        private byte[] f22564f = null;
        /* renamed from: g */
        private byte[] f22565g = null;
    }

    /* renamed from: a */
    public void m27612a() {
        if (this.f22568c != null) {
            Arrays.m29351a(this.f22568c, (byte) 0);
        }
    }

    /* renamed from: b */
    public int m27613b() {
        return this.f22566a;
    }

    /* renamed from: c */
    public short m27614c() {
        return this.f22567b;
    }

    /* renamed from: d */
    public byte[] m27615d() {
        return this.f22568c;
    }

    /* renamed from: e */
    public Hashtable m27616e() {
        if (this.f22569d == null) {
            return null;
        }
        return TlsProtocol.m27741e(new ByteArrayInputStream(this.f22569d));
    }
}
