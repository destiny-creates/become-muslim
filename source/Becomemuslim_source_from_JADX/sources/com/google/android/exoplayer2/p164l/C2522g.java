package com.google.android.exoplayer2.p164l;

import java.util.Arrays;

/* compiled from: LongArray */
/* renamed from: com.google.android.exoplayer2.l.g */
public final class C2522g {
    /* renamed from: a */
    private int f6418a;
    /* renamed from: b */
    private long[] f6419b;

    public C2522g() {
        this(32);
    }

    public C2522g(int i) {
        this.f6419b = new long[i];
    }

    /* renamed from: a */
    public void m7045a(long j) {
        if (this.f6418a == this.f6419b.length) {
            this.f6419b = Arrays.copyOf(this.f6419b, this.f6418a * 2);
        }
        long[] jArr = this.f6419b;
        int i = this.f6418a;
        this.f6418a = i + 1;
        jArr[i] = j;
    }

    /* renamed from: a */
    public long m7044a(int i) {
        if (i >= 0 && i < this.f6418a) {
            return this.f6419b[i];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid index ");
        stringBuilder.append(i);
        stringBuilder.append(", size is ");
        stringBuilder.append(this.f6418a);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    /* renamed from: a */
    public int m7043a() {
        return this.f6418a;
    }

    /* renamed from: b */
    public long[] m7046b() {
        return Arrays.copyOf(this.f6419b, this.f6418a);
    }
}
