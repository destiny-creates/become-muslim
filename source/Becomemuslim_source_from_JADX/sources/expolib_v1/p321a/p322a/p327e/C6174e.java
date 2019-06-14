package expolib_v1.p321a.p322a.p327e;

import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p332b.C6251f;
import java.io.IOException;

/* compiled from: Http2 */
/* renamed from: expolib_v1.a.a.e.e */
public final class C6174e {
    /* renamed from: a */
    static final C6251f f19960a = C6251f.m25837a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    /* renamed from: b */
    static final String[] f19961b = new String[64];
    /* renamed from: c */
    static final String[] f19962c = new String[256];
    /* renamed from: d */
    private static final String[] f19963d = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    static {
        int i = 0;
        for (int i2 = 0; i2 < f19962c.length; i2++) {
            f19962c[i2] = C6165c.m25308a("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
        }
        f19961b[0] = "";
        f19961b[1] = "END_STREAM";
        int[] iArr = new int[]{1};
        f19961b[8] = "PADDED";
        for (int i3 : iArr) {
            String[] strArr = f19961b;
            int i4 = i3 | 8;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f19961b[i3]);
            stringBuilder.append("|PADDED");
            strArr[i4] = stringBuilder.toString();
        }
        f19961b[4] = "END_HEADERS";
        f19961b[32] = "PRIORITY";
        f19961b[36] = "END_HEADERS|PRIORITY";
        for (int i32 : new int[]{4, 32, 36}) {
            for (int i5 : iArr) {
                String[] strArr2 = f19961b;
                int i6 = i5 | i32;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(f19961b[i5]);
                stringBuilder2.append('|');
                stringBuilder2.append(f19961b[i32]);
                strArr2[i6] = stringBuilder2.toString();
                strArr2 = f19961b;
                i6 |= 8;
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(f19961b[i5]);
                stringBuilder2.append('|');
                stringBuilder2.append(f19961b[i32]);
                stringBuilder2.append("|PADDED");
                strArr2[i6] = stringBuilder2.toString();
            }
        }
        while (i < f19961b.length) {
            if (f19961b[i] == null) {
                f19961b[i] = f19962c[i];
            }
            i++;
        }
    }

    private C6174e() {
    }

    /* renamed from: a */
    static IllegalArgumentException m25357a(String str, Object... objArr) {
        throw new IllegalArgumentException(C6165c.m25308a(str, objArr));
    }

    /* renamed from: b */
    static IOException m25360b(String str, Object... objArr) {
        throw new IOException(C6165c.m25308a(str, objArr));
    }

    /* renamed from: a */
    static String m25359a(boolean z, int i, int i2, byte b, byte b2) {
        String a = b < f19963d.length ? f19963d[b] : C6165c.m25308a("0x%02x", Byte.valueOf(b));
        b = C6174e.m25358a(b, b2);
        String str = "%s 0x%08x %5d %-13s %s";
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[true] = Integer.valueOf(i2);
        objArr[true] = a;
        objArr[true] = b;
        return C6165c.m25308a(str, objArr);
    }

    /* renamed from: a */
    static String m25358a(byte b, byte b2) {
        if (b2 == (byte) 0) {
            return "";
        }
        switch (b) {
            case (byte) 2:
            case (byte) 3:
            case (byte) 7:
            case (byte) 8:
                return f19962c[b2];
            case (byte) 4:
            case (byte) 6:
                return b2 == (byte) 1 ? "ACK" : f19962c[b2];
            default:
                String str;
                if (b2 < f19961b.length) {
                    str = f19961b[b2];
                } else {
                    str = f19962c[b2];
                }
                if (b != (byte) 5 || (b2 & 4) == 0) {
                    return (b != (byte) 0 || (b2 & 32) == (byte) 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                } else {
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
        }
    }
}
