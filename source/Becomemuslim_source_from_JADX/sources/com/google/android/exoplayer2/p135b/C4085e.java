package com.google.android.exoplayer2.p135b;

import java.nio.ByteBuffer;

/* compiled from: DecoderInputBuffer */
/* renamed from: com.google.android.exoplayer2.b.e */
public class C4085e extends C2244a {
    /* renamed from: a */
    public final C2247b f10317a = new C2247b();
    /* renamed from: b */
    public ByteBuffer f10318b;
    /* renamed from: c */
    public long f10319c;
    /* renamed from: d */
    private final int f10320d;

    /* renamed from: e */
    public static C4085e m12750e() {
        return new C4085e(0);
    }

    public C4085e(int i) {
        this.f10320d = i;
    }

    /* renamed from: e */
    public void m12753e(int i) {
        if (this.f10318b == null) {
            this.f10318b = m12751f(i);
            return;
        }
        int capacity = this.f10318b.capacity();
        int position = this.f10318b.position();
        i += position;
        if (capacity < i) {
            i = m12751f(i);
            if (position > 0) {
                this.f10318b.position(0);
                this.f10318b.limit(position);
                i.put(this.f10318b);
            }
            this.f10318b = i;
        }
    }

    /* renamed from: f */
    public final boolean m12754f() {
        return this.f10318b == null && this.f10320d == 0;
    }

    /* renamed from: g */
    public final boolean m12755g() {
        return m6208d(1073741824);
    }

    /* renamed from: h */
    public final void m12756h() {
        this.f10318b.flip();
    }

    /* renamed from: a */
    public void mo2145a() {
        super.mo2145a();
        if (this.f10318b != null) {
            this.f10318b.clear();
        }
    }

    /* renamed from: f */
    private ByteBuffer m12751f(int i) {
        if (this.f10320d == 1) {
            return ByteBuffer.allocate(i);
        }
        if (this.f10320d == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        int capacity = this.f10318b == null ? 0 : this.f10318b.capacity();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Buffer too small (");
        stringBuilder.append(capacity);
        stringBuilder.append(" < ");
        stringBuilder.append(i);
        stringBuilder.append(")");
        throw new IllegalStateException(stringBuilder.toString());
    }
}
