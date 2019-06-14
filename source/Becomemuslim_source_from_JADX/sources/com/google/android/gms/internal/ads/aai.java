package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

public abstract class aai implements Serializable, Iterable<Byte> {
    /* renamed from: a */
    public static final aai f14132a = new aap(abs.f14237b);
    /* renamed from: b */
    private static final aam f14133b = (aad.m17813a() ? new aaq() : new aak());
    /* renamed from: c */
    private int f14134c = 0;

    aai() {
    }

    /* renamed from: a */
    public static aai m17830a(String str) {
        return new aap(str.getBytes(abs.f14236a));
    }

    /* renamed from: a */
    public static aai m17831a(byte[] bArr) {
        return m17832a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static aai m17832a(byte[] bArr, int i, int i2) {
        return new aap(f14133b.mo3616a(bArr, i, i2));
    }

    /* renamed from: b */
    static int m17833b(int i, int i2, int i3) {
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

    /* renamed from: b */
    static aai m17834b(byte[] bArr) {
        return new aap(bArr);
    }

    /* renamed from: b */
    static aan m17835b(int i) {
        return new aan(i);
    }

    /* renamed from: a */
    public abstract byte mo6035a(int i);

    /* renamed from: a */
    public abstract int mo6036a();

    /* renamed from: a */
    protected abstract int mo6037a(int i, int i2, int i3);

    /* renamed from: a */
    public abstract aai mo6038a(int i, int i2);

    /* renamed from: a */
    protected abstract String mo6039a(Charset charset);

    /* renamed from: a */
    abstract void mo6040a(aah aah);

    /* renamed from: a */
    protected abstract void mo6041a(byte[] bArr, int i, int i2, int i3);

    /* renamed from: b */
    public final byte[] m17843b() {
        int a = mo6036a();
        if (a == 0) {
            return abs.f14237b;
        }
        byte[] bArr = new byte[a];
        mo6041a(bArr, 0, 0, a);
        return bArr;
    }

    /* renamed from: c */
    public final String m17844c() {
        return mo6036a() == 0 ? "" : mo6039a(abs.f14236a);
    }

    /* renamed from: d */
    public abstract boolean mo6043d();

    /* renamed from: e */
    public abstract aar mo6044e();

    public abstract boolean equals(Object obj);

    /* renamed from: f */
    protected final int m17847f() {
        return this.f14134c;
    }

    public final int hashCode() {
        int i = this.f14134c;
        if (i == 0) {
            i = mo6036a();
            i = mo6037a(i, 0, i);
            if (i == 0) {
                i = 1;
            }
            this.f14134c = i;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return new aaj(this);
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(mo6036a())});
    }
}
