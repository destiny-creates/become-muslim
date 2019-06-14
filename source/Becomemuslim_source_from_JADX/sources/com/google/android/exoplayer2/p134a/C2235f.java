package com.google.android.exoplayer2.p134a;

import com.google.android.exoplayer2.C2573r;
import java.nio.ByteBuffer;

/* compiled from: AudioSink */
/* renamed from: com.google.android.exoplayer2.a.f */
public interface C2235f {

    /* compiled from: AudioSink */
    /* renamed from: com.google.android.exoplayer2.a.f$a */
    public static final class C2231a extends Exception {
        public C2231a(Throwable th) {
            super(th);
        }

        public C2231a(String str) {
            super(str);
        }
    }

    /* compiled from: AudioSink */
    /* renamed from: com.google.android.exoplayer2.a.f$b */
    public static final class C2232b extends Exception {
        /* renamed from: a */
        public final int f5305a;

        public C2232b(int i, int i2, int i3, int i4) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AudioTrack init failed: ");
            stringBuilder.append(i);
            stringBuilder.append(", Config(");
            stringBuilder.append(i2);
            stringBuilder.append(", ");
            stringBuilder.append(i3);
            stringBuilder.append(", ");
            stringBuilder.append(i4);
            stringBuilder.append(")");
            super(stringBuilder.toString());
            this.f5305a = i;
        }
    }

    /* compiled from: AudioSink */
    /* renamed from: com.google.android.exoplayer2.a.f$c */
    public interface C2233c {
        /* renamed from: a */
        void mo2142a();

        /* renamed from: a */
        void mo2143a(int i);

        /* renamed from: a */
        void mo2144a(int i, long j, long j2);
    }

    /* compiled from: AudioSink */
    /* renamed from: com.google.android.exoplayer2.a.f$d */
    public static final class C2234d extends Exception {
        /* renamed from: a */
        public final int f5306a;

        public C2234d(int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AudioTrack write failed: ");
            stringBuilder.append(i);
            super(stringBuilder.toString());
            this.f5306a = i;
        }
    }

    /* renamed from: a */
    long mo2123a(boolean z);

    /* renamed from: a */
    C2573r mo2124a(C2573r c2573r);

    /* renamed from: a */
    void mo2125a();

    /* renamed from: a */
    void mo2126a(float f);

    /* renamed from: a */
    void mo2127a(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6);

    /* renamed from: a */
    void mo2128a(C2219b c2219b);

    /* renamed from: a */
    void mo2129a(C2233c c2233c);

    /* renamed from: a */
    boolean mo2130a(int i);

    /* renamed from: a */
    boolean mo2131a(ByteBuffer byteBuffer, long j);

    /* renamed from: b */
    void mo2132b();

    /* renamed from: b */
    void mo2133b(int i);

    /* renamed from: c */
    void mo2134c();

    /* renamed from: d */
    boolean mo2135d();

    /* renamed from: e */
    boolean mo2136e();

    /* renamed from: f */
    C2573r mo2137f();

    /* renamed from: g */
    void mo2138g();

    /* renamed from: h */
    void mo2139h();

    /* renamed from: i */
    void mo2140i();

    /* renamed from: j */
    void mo2141j();
}
