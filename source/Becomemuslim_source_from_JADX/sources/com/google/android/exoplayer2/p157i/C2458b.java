package com.google.android.exoplayer2.p157i;

import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Layout.Alignment;

/* compiled from: Cue */
/* renamed from: com.google.android.exoplayer2.i.b */
public class C2458b {
    /* renamed from: a */
    public final CharSequence f6207a;
    /* renamed from: b */
    public final Alignment f6208b;
    /* renamed from: c */
    public final Bitmap f6209c;
    /* renamed from: d */
    public final float f6210d;
    /* renamed from: e */
    public final int f6211e;
    /* renamed from: f */
    public final int f6212f;
    /* renamed from: g */
    public final float f6213g;
    /* renamed from: h */
    public final int f6214h;
    /* renamed from: i */
    public final float f6215i;
    /* renamed from: j */
    public final float f6216j;
    /* renamed from: k */
    public final boolean f6217k;
    /* renamed from: l */
    public final int f6218l;

    public C2458b(Bitmap bitmap, float f, int i, float f2, int i2, float f3, float f4) {
        this(null, null, bitmap, f2, 0, i2, f, i, f3, f4, false, -16777216);
    }

    public C2458b(CharSequence charSequence) {
        this(charSequence, null, Float.MIN_VALUE, LinearLayoutManager.INVALID_OFFSET, LinearLayoutManager.INVALID_OFFSET, Float.MIN_VALUE, LinearLayoutManager.INVALID_OFFSET, Float.MIN_VALUE);
    }

    public C2458b(CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        this(charSequence, alignment, f, i, i2, f2, i3, f3, false, -16777216);
    }

    public C2458b(CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4) {
        this(charSequence, alignment, null, f, i, i2, f2, i3, f3, Float.MIN_VALUE, z, i4);
    }

    private C2458b(CharSequence charSequence, Alignment alignment, Bitmap bitmap, float f, int i, int i2, float f2, int i3, float f3, float f4, boolean z, int i4) {
        this.f6207a = charSequence;
        this.f6208b = alignment;
        this.f6209c = bitmap;
        this.f6210d = f;
        this.f6211e = i;
        this.f6212f = i2;
        this.f6213g = f2;
        this.f6214h = i3;
        this.f6215i = f3;
        this.f6216j = f4;
        this.f6217k = z;
        this.f6218l = i4;
    }
}
