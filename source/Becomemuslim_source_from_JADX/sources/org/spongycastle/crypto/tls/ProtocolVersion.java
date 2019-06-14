package org.spongycastle.crypto.tls;

import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.NativeProtocol;
import com.facebook.soloader.MinElf;
import org.spongycastle.util.Strings;

public final class ProtocolVersion {
    /* renamed from: a */
    public static final ProtocolVersion f22511a = new ProtocolVersion(768, "SSL 3.0");
    /* renamed from: b */
    public static final ProtocolVersion f22512b = new ProtocolVersion(769, "TLS 1.0");
    /* renamed from: c */
    public static final ProtocolVersion f22513c = new ProtocolVersion(770, "TLS 1.1");
    /* renamed from: d */
    public static final ProtocolVersion f22514d = new ProtocolVersion(771, "TLS 1.2");
    /* renamed from: e */
    public static final ProtocolVersion f22515e = new ProtocolVersion(65279, "DTLS 1.0");
    /* renamed from: f */
    public static final ProtocolVersion f22516f = new ProtocolVersion(65277, "DTLS 1.2");
    /* renamed from: g */
    private int f22517g;
    /* renamed from: h */
    private String f22518h;

    private ProtocolVersion(int i, String str) {
        this.f22517g = i & MinElf.PN_XNUM;
        this.f22518h = str;
    }

    /* renamed from: a */
    public int m27567a() {
        return this.f22517g >> 8;
    }

    /* renamed from: b */
    public int m27569b() {
        return this.f22517g & JfifUtil.MARKER_FIRST_BYTE;
    }

    /* renamed from: c */
    public boolean m27571c() {
        return m27567a() == 254;
    }

    /* renamed from: d */
    public boolean m27573d() {
        return this == f22511a;
    }

    /* renamed from: e */
    public ProtocolVersion m27574e() {
        if (!m27571c()) {
            return this;
        }
        if (this == f22515e) {
            return f22513c;
        }
        return f22514d;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public boolean m27568a(org.spongycastle.crypto.tls.ProtocolVersion r4) {
        /*
        r3 = this;
        r0 = r3.m27567a();
        r1 = r4.m27567a();
        r2 = 0;
        if (r0 == r1) goto L_0x000c;
    L_0x000b:
        return r2;
    L_0x000c:
        r4 = r4.m27569b();
        r0 = r3.m27569b();
        r4 = r4 - r0;
        r0 = r3.m27571c();
        r1 = 1;
        if (r0 == 0) goto L_0x0021;
    L_0x001c:
        if (r4 > 0) goto L_0x001f;
    L_0x001e:
        goto L_0x0023;
    L_0x001f:
        r1 = 0;
        goto L_0x0023;
    L_0x0021:
        if (r4 < 0) goto L_0x001f;
    L_0x0023:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.ProtocolVersion.a(org.spongycastle.crypto.tls.ProtocolVersion):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public boolean m27570b(org.spongycastle.crypto.tls.ProtocolVersion r4) {
        /*
        r3 = this;
        r0 = r3.m27567a();
        r1 = r4.m27567a();
        r2 = 0;
        if (r0 == r1) goto L_0x000c;
    L_0x000b:
        return r2;
    L_0x000c:
        r4 = r4.m27569b();
        r0 = r3.m27569b();
        r4 = r4 - r0;
        r0 = r3.m27571c();
        r1 = 1;
        if (r0 == 0) goto L_0x0021;
    L_0x001c:
        if (r4 <= 0) goto L_0x001f;
    L_0x001e:
        goto L_0x0023;
    L_0x001f:
        r1 = 0;
        goto L_0x0023;
    L_0x0021:
        if (r4 >= 0) goto L_0x001f;
    L_0x0023:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.ProtocolVersion.b(org.spongycastle.crypto.tls.ProtocolVersion):boolean");
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof ProtocolVersion) || m27572c((ProtocolVersion) obj) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: c */
    public boolean m27572c(ProtocolVersion protocolVersion) {
        return (protocolVersion == null || this.f22517g != protocolVersion.f22517g) ? null : true;
    }

    public int hashCode() {
        return this.f22517g;
    }

    /* renamed from: a */
    public static ProtocolVersion m27565a(int i, int i2) {
        if (i == 3) {
            switch (i2) {
                case 0:
                    return f22511a;
                case 1:
                    return f22512b;
                case 2:
                    return f22513c;
                case 3:
                    return f22514d;
                default:
                    return m27566a(i, i2, "TLS");
            }
        } else if (i == 254) {
            switch (i2) {
                case 253:
                    return f22516f;
                case 254:
                    throw new TlsFatalAlert((short) 47);
                case JfifUtil.MARKER_FIRST_BYTE /*255*/:
                    return f22515e;
                default:
                    return m27566a(i, i2, "DTLS");
            }
        } else {
            throw new TlsFatalAlert((short) 47);
        }
    }

    public String toString() {
        return this.f22518h;
    }

    /* renamed from: a */
    private static ProtocolVersion m27566a(int i, int i2, String str) {
        TlsUtils.m27805a(i);
        TlsUtils.m27805a(i2);
        i = (i << 8) | i2;
        i2 = Strings.m29424b(Integer.toHexString(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST | i).substring(1));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" 0x");
        stringBuilder.append(i2);
        return new ProtocolVersion(i, stringBuilder.toString());
    }
}
