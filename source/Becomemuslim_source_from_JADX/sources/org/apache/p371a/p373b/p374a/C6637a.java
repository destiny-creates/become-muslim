package org.apache.p371a.p373b.p374a;

import java.nio.charset.Charset;
import org.apache.p371a.p373b.C6638a;

/* compiled from: Hex */
/* renamed from: org.apache.a.b.a.a */
public class C6637a {
    /* renamed from: a */
    public static final Charset f21326a = C6638a.f21335f;
    /* renamed from: b */
    private static final char[] f21327b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    /* renamed from: c */
    private static final char[] f21328c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* renamed from: d */
    private final Charset f21329d;

    /* renamed from: a */
    public static char[] m27021a(byte[] bArr) {
        return C6637a.m27022a(bArr, true);
    }

    /* renamed from: a */
    public static char[] m27022a(byte[] bArr, boolean z) {
        return C6637a.m27023a(bArr, z ? f21327b : f21328c);
    }

    /* renamed from: a */
    protected static char[] m27023a(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return cArr2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("[charsetName=");
        stringBuilder.append(this.f21329d);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
