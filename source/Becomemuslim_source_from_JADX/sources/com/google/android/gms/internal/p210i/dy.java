package com.google.android.gms.internal.p210i;

import com.facebook.imageutils.JfifUtil;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.i.dy */
public abstract class dy implements Serializable, Iterable<Byte> {
    /* renamed from: a */
    public static final dy f16513a = new ej(fm.f16618b);
    /* renamed from: b */
    private static final ee f16514b = (dv.m20447a() ? new ek() : new ec());
    /* renamed from: d */
    private static final Comparator<dy> f16515d = new ea();
    /* renamed from: c */
    private int f16516c = 0;

    dy() {
    }

    /* renamed from: b */
    private static int m20454b(byte b) {
        return b & JfifUtil.MARKER_FIRST_BYTE;
    }

    /* renamed from: a */
    public abstract byte mo6159a(int i);

    /* renamed from: a */
    public abstract int mo6160a();

    /* renamed from: a */
    protected abstract int mo6161a(int i, int i2, int i3);

    /* renamed from: a */
    public abstract dy mo6162a(int i, int i2);

    /* renamed from: a */
    protected abstract String mo6163a(Charset charset);

    /* renamed from: a */
    abstract void mo6164a(dx dxVar);

    /* renamed from: b */
    abstract byte mo6166b(int i);

    /* renamed from: c */
    public abstract boolean mo6167c();

    public abstract boolean equals(Object obj);

    /* renamed from: a */
    public static dy m20453a(byte[] bArr, int i, int i2) {
        dy.m20455b(i, i + i2, bArr.length);
        return new ej(f16514b.mo4431a(bArr, i, i2));
    }

    /* renamed from: a */
    static dy m20452a(byte[] bArr) {
        return new ej(bArr);
    }

    /* renamed from: a */
    public static dy m20451a(String str) {
        return new ej(str.getBytes(fm.f16617a));
    }

    /* renamed from: b */
    public final String m20464b() {
        return mo6160a() == 0 ? "" : mo6163a(fm.f16617a);
    }

    public final int hashCode() {
        int i = this.f16516c;
        if (i == 0) {
            i = mo6160a();
            i = mo6161a(i, 0, i);
            if (i == 0) {
                i = 1;
            }
            this.f16516c = i;
        }
        return i;
    }

    /* renamed from: c */
    static eh m20456c(int i) {
        return new eh(i);
    }

    /* renamed from: d */
    protected final int m20466d() {
        return this.f16516c;
    }

    /* renamed from: b */
    static int m20455b(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((((i | i2) | i4) | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder(32);
            stringBuilder.append("Beginning index: ");
            stringBuilder.append(i);
            stringBuilder.append(" < 0");
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        } else if (i2 < i) {
            r1 = new StringBuilder(66);
            r1.append("Beginning index larger than ending index: ");
            r1.append(i);
            r1.append(", ");
            r1.append(i2);
            throw new IndexOutOfBoundsException(r1.toString());
        } else {
            r1 = new StringBuilder(37);
            r1.append("End index: ");
            r1.append(i2);
            r1.append(" >= ");
            r1.append(i3);
            throw new IndexOutOfBoundsException(r1.toString());
        }
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(mo6160a())});
    }

    public /* synthetic */ Iterator iterator() {
        return new dz(this);
    }
}
