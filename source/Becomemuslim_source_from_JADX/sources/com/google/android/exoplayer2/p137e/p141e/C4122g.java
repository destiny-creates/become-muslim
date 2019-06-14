package com.google.android.exoplayer2.p137e.p141e;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.p141e.C2295h.C2294a;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: OpusReader */
/* renamed from: com.google.android.exoplayer2.e.e.g */
final class C4122g extends C2295h {
    /* renamed from: a */
    private static final int f10562a = C2541v.m7193g("Opus");
    /* renamed from: b */
    private static final byte[] f10563b = new byte[]{(byte) 79, (byte) 112, (byte) 117, (byte) 115, (byte) 72, (byte) 101, (byte) 97, (byte) 100};
    /* renamed from: c */
    private boolean f10564c;

    C4122g() {
    }

    /* renamed from: a */
    public static boolean m13023a(C2529l c2529l) {
        if (c2529l.m7093b() < f10563b.length) {
            return false;
        }
        byte[] bArr = new byte[f10563b.length];
        c2529l.m7092a(bArr, 0, f10563b.length);
        return Arrays.equals(bArr, f10563b);
    }

    /* renamed from: a */
    protected void mo2204a(boolean z) {
        super.mo2204a(z);
        if (z) {
            this.f10564c = false;
        }
    }

    /* renamed from: b */
    protected long mo2206b(C2529l c2529l) {
        return m6352b(m13021a(c2529l.f6441a));
    }

    /* renamed from: a */
    protected boolean mo2205a(C2529l c2529l, long j, C2294a c2294a) {
        boolean z = true;
        if (this.f10564c == null) {
            c2529l = Arrays.copyOf(c2529l.f6441a, c2529l.m7095c());
            int i = c2529l[9] & JfifUtil.MARKER_FIRST_BYTE;
            j = ((c2529l[11] & JfifUtil.MARKER_FIRST_BYTE) << 8) | (c2529l[10] & JfifUtil.MARKER_FIRST_BYTE);
            List arrayList = new ArrayList(3);
            arrayList.add(c2529l);
            m13022a(arrayList, j);
            m13022a(arrayList, 3840);
            c2294a.f5631a = C2515k.m6988a(null, "audio/opus", null, -1, -1, i, 48000, arrayList, null, 0, null);
            this.f10564c = true;
            return true;
        }
        if (c2529l.m7111o() != f10562a) {
            z = false;
        }
        c2529l.m7096c(0);
        return z;
    }

    /* renamed from: a */
    private void m13022a(List<byte[]> list, int i) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) i) * 1000000000) / 48000).array());
    }

    /* renamed from: a */
    private long m13021a(byte[] bArr) {
        int i = bArr[0] & JfifUtil.MARKER_FIRST_BYTE;
        switch (i & 3) {
            case 0:
                bArr = 1;
                break;
            case 1:
            case 2:
                bArr = 2;
                break;
            default:
                bArr = bArr[1] & 63;
                break;
        }
        i >>= 3;
        int i2 = i & 3;
        i = i >= 16 ? 2500 << i2 : i >= 12 ? 10000 << (i2 & 1) : i2 == 3 ? 60000 : 10000 << i2;
        return (long) (bArr * i);
    }
}
