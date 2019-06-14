package com.google.android.exoplayer2.p149h.p150a;

import android.util.Log;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.C4115d;
import com.google.android.exoplayer2.p149h.C4220l;
import com.google.android.exoplayer2.p149h.p150a.C4170d.C2370b;

/* compiled from: BaseMediaChunkOutput */
/* renamed from: com.google.android.exoplayer2.h.a.b */
final class C4167b implements C2370b {
    /* renamed from: a */
    private final int[] f10802a;
    /* renamed from: b */
    private final C4220l[] f10803b;

    public C4167b(int[] iArr, C4220l[] c4220lArr) {
        this.f10802a = iArr;
        this.f10803b = c4220lArr;
    }

    /* renamed from: a */
    public C2329m mo2230a(int i, int i2) {
        for (i = 0; i < this.f10802a.length; i++) {
            if (i2 == this.f10802a[i]) {
                return this.f10803b[i];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unmatched track of type: ");
        stringBuilder.append(i2);
        Log.e("BaseMediaChunkOutput", stringBuilder.toString());
        return new C4115d();
    }

    /* renamed from: a */
    public int[] m13260a() {
        int[] iArr = new int[this.f10803b.length];
        for (int i = 0; i < this.f10803b.length; i++) {
            if (this.f10803b[i] != null) {
                iArr[i] = this.f10803b[i].m13675c();
            }
        }
        return iArr;
    }

    /* renamed from: a */
    public void m13259a(long j) {
        for (C4220l c4220l : this.f10803b) {
            if (c4220l != null) {
                c4220l.m13665a(j);
            }
        }
    }
}
