package com.p064b.p065a.p068c;

import com.facebook.stetho.common.Utf8Charset;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* compiled from: ByteString */
/* renamed from: com.b.a.c.b */
final class C1017b {
    /* renamed from: a */
    public static final C1017b f2866a = new C1017b(new byte[0]);
    /* renamed from: b */
    private final byte[] f2867b;
    /* renamed from: c */
    private volatile int f2868c = 0;

    private C1017b(byte[] bArr) {
        this.f2867b = bArr;
    }

    /* renamed from: a */
    public int m3496a() {
        return this.f2867b.length;
    }

    /* renamed from: a */
    public static C1017b m3495a(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return new C1017b(obj);
    }

    /* renamed from: a */
    public static C1017b m3494a(String str) {
        try {
            return new C1017b(str.getBytes(Utf8Charset.NAME));
        } catch (String str2) {
            throw new RuntimeException("UTF-8 not supported.", str2);
        }
    }

    /* renamed from: a */
    public void m3497a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f2867b, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1017b)) {
            return false;
        }
        C1017b c1017b = (C1017b) obj;
        int length = this.f2867b.length;
        if (length != c1017b.f2867b.length) {
            return false;
        }
        byte[] bArr = this.f2867b;
        obj = c1017b.f2867b;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != obj[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f2868c;
        if (i == 0) {
            byte[] bArr = this.f2867b;
            int length = this.f2867b.length;
            int i2 = length;
            for (int i3 = 0; i3 < length; i3++) {
                i2 = (i2 * 31) + bArr[i3];
            }
            i = i2 == 0 ? 1 : i2;
            this.f2868c = i;
        }
        return i;
    }

    /* renamed from: b */
    public InputStream m3498b() {
        return new ByteArrayInputStream(this.f2867b);
    }
}
