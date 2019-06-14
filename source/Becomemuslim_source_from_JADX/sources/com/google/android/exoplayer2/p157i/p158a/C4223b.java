package com.google.android.exoplayer2.p157i.p158a;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.p157i.C2458b;

/* compiled from: Cea708Cue */
/* renamed from: com.google.android.exoplayer2.i.a.b */
final class C4223b extends C2458b implements Comparable<C4223b> {
    /* renamed from: m */
    public final int f11123m;

    public /* synthetic */ int compareTo(Object obj) {
        return m13690a((C4223b) obj);
    }

    public C4223b(CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4, int i5) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3, z, i4);
        this.f11123m = i5;
    }

    /* renamed from: a */
    public int m13690a(C4223b c4223b) {
        if (c4223b.f11123m < this.f11123m) {
            return -1;
        }
        return c4223b.f11123m > this.f11123m ? 1 : null;
    }
}
