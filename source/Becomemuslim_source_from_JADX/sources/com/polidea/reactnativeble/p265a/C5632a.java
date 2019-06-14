package com.polidea.reactnativeble.p265a;

import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.common.Utf8Charset;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: AdvertisementData */
/* renamed from: com.polidea.reactnativeble.a.a */
public class C5632a {
    /* renamed from: a */
    private byte[] f18813a;
    /* renamed from: b */
    private Map<UUID, byte[]> f18814b;
    /* renamed from: c */
    private ArrayList<UUID> f18815c;
    /* renamed from: d */
    private String f18816d;
    /* renamed from: e */
    private Integer f18817e;
    /* renamed from: f */
    private ArrayList<UUID> f18818f;

    /* renamed from: a */
    public String m23941a() {
        return this.f18816d;
    }

    /* renamed from: b */
    public byte[] m23942b() {
        return this.f18813a;
    }

    /* renamed from: c */
    public Map<UUID, byte[]> m23943c() {
        return this.f18814b;
    }

    /* renamed from: d */
    public ArrayList<UUID> m23944d() {
        return this.f18815c;
    }

    /* renamed from: e */
    public Integer m23945e() {
        return this.f18817e;
    }

    /* renamed from: f */
    public ArrayList<UUID> m23946f() {
        return this.f18818f;
    }

    /* renamed from: a */
    public static C5632a m23932a(byte[] bArr) {
        C5632a c5632a = new C5632a();
        bArr = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        while (bArr.remaining() >= 2) {
            int i = bArr.get() & JfifUtil.MARKER_FIRST_BYTE;
            if (i == 0) {
                break;
            }
            i--;
            int i2 = bArr.get() & JfifUtil.MARKER_FIRST_BYTE;
            if (bArr.remaining() < i) {
                break;
            }
            C5632a.m23934a(c5632a, i2, i, bArr.slice().order(ByteOrder.LITTLE_ENDIAN));
            bArr.position(bArr.position() + i);
        }
        return c5632a;
    }

    /* renamed from: a */
    private static void m23934a(C5632a c5632a, int i, int i2, ByteBuffer byteBuffer) {
        if (i != JfifUtil.MARKER_FIRST_BYTE) {
            switch (i) {
                case 2:
                case 3:
                    C5632a.m23939b(c5632a, i2, byteBuffer, 2);
                    return;
                case 4:
                case 5:
                    C5632a.m23939b(c5632a, i2, byteBuffer, 4);
                    return;
                case 6:
                case 7:
                    C5632a.m23939b(c5632a, i2, byteBuffer, 16);
                    return;
                case 8:
                case 9:
                    C5632a.m23937b(c5632a, i, i2, byteBuffer);
                    return;
                case 10:
                    C5632a.m23935a(c5632a, i2, byteBuffer);
                    return;
                default:
                    switch (i) {
                        case 20:
                            C5632a.m23936a(c5632a, i2, byteBuffer, 2);
                            return;
                        case 21:
                            C5632a.m23936a(c5632a, i2, byteBuffer, 16);
                            return;
                        case 22:
                            C5632a.m23940c(c5632a, i2, byteBuffer, 2);
                            return;
                        default:
                            switch (i) {
                                case 31:
                                    C5632a.m23936a(c5632a, i2, byteBuffer, 4);
                                    return;
                                case 32:
                                    C5632a.m23940c(c5632a, i2, byteBuffer, 4);
                                    return;
                                case 33:
                                    C5632a.m23940c(c5632a, i2, byteBuffer, 16);
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        }
        C5632a.m23938b(c5632a, i2, byteBuffer);
    }

    /* renamed from: b */
    private static void m23937b(C5632a c5632a, int i, int i2, ByteBuffer byteBuffer) {
        if (c5632a.f18816d == null || i == 9) {
            i = new byte[i2];
            byteBuffer.get(i, 0, i2);
            c5632a.f18816d = new String(i, Charset.forName(Utf8Charset.NAME));
        }
    }

    /* renamed from: a */
    private static UUID m23933a(ByteBuffer byteBuffer, int i) {
        long j = -9223371485494954757L;
        if (i == 2) {
            byteBuffer = ((((long) byteBuffer.getShort()) & 65535) << 32) + 4096;
        } else if (i == 4) {
            byteBuffer = (((long) byteBuffer.getInt()) << 32) + 4096;
        } else if (i != 16) {
            byteBuffer.position(byteBuffer.position() + i);
            return null;
        } else {
            j = byteBuffer.getLong();
            byteBuffer = byteBuffer.getLong();
        }
        return new UUID(byteBuffer, j);
    }

    /* renamed from: a */
    private static void m23936a(C5632a c5632a, int i, ByteBuffer byteBuffer, int i2) {
        if (c5632a.f18818f == null) {
            c5632a.f18818f = new ArrayList();
        }
        while (byteBuffer.remaining() >= i2 && byteBuffer.position() < i) {
            c5632a.f18818f.add(C5632a.m23933a(byteBuffer, i2));
        }
    }

    /* renamed from: b */
    private static void m23939b(C5632a c5632a, int i, ByteBuffer byteBuffer, int i2) {
        if (c5632a.f18815c == null) {
            c5632a.f18815c = new ArrayList();
        }
        while (byteBuffer.remaining() >= i2 && byteBuffer.position() < i) {
            c5632a.f18815c.add(C5632a.m23933a(byteBuffer, i2));
        }
    }

    /* renamed from: c */
    private static void m23940c(C5632a c5632a, int i, ByteBuffer byteBuffer, int i2) {
        if (i >= i2) {
            if (c5632a.f18814b == null) {
                c5632a.f18814b = new HashMap();
            }
            UUID a = C5632a.m23933a(byteBuffer, i2);
            i -= i2;
            i2 = new byte[i];
            byteBuffer.get(i2, 0, i);
            c5632a.f18814b.put(a, i2);
        }
    }

    /* renamed from: a */
    private static void m23935a(C5632a c5632a, int i, ByteBuffer byteBuffer) {
        if (i == 1) {
            c5632a.f18817e = Integer.valueOf(byteBuffer.get());
        }
    }

    /* renamed from: b */
    private static void m23938b(C5632a c5632a, int i, ByteBuffer byteBuffer) {
        if (i >= 2) {
            c5632a.f18813a = new byte[i];
            byteBuffer.get(c5632a.f18813a, 0, i);
        }
    }
}
