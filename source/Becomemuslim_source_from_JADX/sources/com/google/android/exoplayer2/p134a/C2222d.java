package com.google.android.exoplayer2.p134a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: AudioProcessor */
/* renamed from: com.google.android.exoplayer2.a.d */
public interface C2222d {
    /* renamed from: a */
    public static final ByteBuffer f5286a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* compiled from: AudioProcessor */
    /* renamed from: com.google.android.exoplayer2.a.d$a */
    public static final class C2221a extends Exception {
        public C2221a(int i, int i2, int i3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unhandled format: ");
            stringBuilder.append(i);
            stringBuilder.append(" Hz, ");
            stringBuilder.append(i2);
            stringBuilder.append(" channels in encoding ");
            stringBuilder.append(i3);
            super(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    void mo2108a(ByteBuffer byteBuffer);

    /* renamed from: a */
    boolean mo2109a();

    /* renamed from: a */
    boolean mo2110a(int i, int i2, int i3);

    /* renamed from: b */
    int mo2111b();

    /* renamed from: c */
    int mo2112c();

    /* renamed from: d */
    int mo2113d();

    /* renamed from: e */
    void mo2114e();

    /* renamed from: f */
    ByteBuffer mo2115f();

    /* renamed from: g */
    boolean mo2116g();

    /* renamed from: h */
    void mo2117h();

    /* renamed from: i */
    void mo2118i();
}
