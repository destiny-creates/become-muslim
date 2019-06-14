package com.google.android.exoplayer2.p157i;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: CaptionStyleCompat */
/* renamed from: com.google.android.exoplayer2.i.a */
public final class C2448a {
    /* renamed from: a */
    public static final C2448a f6144a = new C2448a(-1, -16777216, 0, 0, -1, null);
    /* renamed from: b */
    public final int f6145b;
    /* renamed from: c */
    public final int f6146c;
    /* renamed from: d */
    public final int f6147d;
    /* renamed from: e */
    public final int f6148e;
    /* renamed from: f */
    public final int f6149f;
    /* renamed from: g */
    public final Typeface f6150g;

    @TargetApi(19)
    /* renamed from: a */
    public static C2448a m6767a(CaptionStyle captionStyle) {
        if (C2541v.f6467a >= 21) {
            return C2448a.m6769c(captionStyle);
        }
        return C2448a.m6768b(captionStyle);
    }

    public C2448a(int i, int i2, int i3, int i4, int i5, Typeface typeface) {
        this.f6145b = i;
        this.f6146c = i2;
        this.f6147d = i3;
        this.f6148e = i4;
        this.f6149f = i5;
        this.f6150g = typeface;
    }

    @TargetApi(19)
    /* renamed from: b */
    private static C2448a m6768b(CaptionStyle captionStyle) {
        return new C2448a(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @TargetApi(21)
    /* renamed from: c */
    private static C2448a m6769c(CaptionStyle captionStyle) {
        return new C2448a(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f6144a.f6145b, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f6144a.f6146c, captionStyle.hasWindowColor() ? captionStyle.windowColor : f6144a.f6147d, captionStyle.hasEdgeType() ? captionStyle.edgeType : f6144a.f6148e, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f6144a.f6149f, captionStyle.getTypeface());
    }
}
