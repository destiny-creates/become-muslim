package com.google.android.exoplayer2.p163k;

import android.net.Uri;
import com.google.android.exoplayer2.p164l.C2516a;
import java.util.Arrays;

/* compiled from: DataSpec */
/* renamed from: com.google.android.exoplayer2.k.j */
public final class C2501j {
    /* renamed from: a */
    public final Uri f6349a;
    /* renamed from: b */
    public final byte[] f6350b;
    /* renamed from: c */
    public final long f6351c;
    /* renamed from: d */
    public final long f6352d;
    /* renamed from: e */
    public final long f6353e;
    /* renamed from: f */
    public final String f6354f;
    /* renamed from: g */
    public final int f6355g;

    public C2501j(Uri uri, int i) {
        this(uri, 0, -1, null, i);
    }

    public C2501j(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
    }

    public C2501j(Uri uri, long j, long j2, String str, int i) {
        this(uri, j, j, j2, str, i);
    }

    public C2501j(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    public C2501j(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        boolean z = false;
        C2516a.m7017a(j >= 0);
        C2516a.m7017a(j2 >= 0);
        if (j3 > 0 || j3 == -1) {
            z = true;
        }
        C2516a.m7017a(z);
        this.f6349a = uri;
        this.f6350b = bArr;
        this.f6351c = j;
        this.f6352d = j2;
        this.f6353e = j3;
        this.f6354f = str;
        this.f6355g = i;
    }

    /* renamed from: a */
    public boolean m6958a(int i) {
        return (this.f6355g & i) == i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataSpec[");
        stringBuilder.append(this.f6349a);
        stringBuilder.append(", ");
        stringBuilder.append(Arrays.toString(this.f6350b));
        stringBuilder.append(", ");
        stringBuilder.append(this.f6351c);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6352d);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6353e);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6354f);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6355g);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public C2501j m6956a(long j) {
        long j2 = -1;
        if (this.f6353e != -1) {
            j2 = this.f6353e - j;
        }
        return m6957a(j, j2);
    }

    /* renamed from: a */
    public C2501j m6957a(long j, long j2) {
        C2501j c2501j = this;
        if (j == 0 && c2501j.f6353e == j2) {
            return c2501j;
        }
        return new C2501j(c2501j.f6349a, c2501j.f6350b, c2501j.f6351c + j, c2501j.f6352d + j, j2, c2501j.f6354f, c2501j.f6355g);
    }
}
