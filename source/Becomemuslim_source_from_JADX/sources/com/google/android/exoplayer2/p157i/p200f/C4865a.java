package com.google.android.exoplayer2.p157i.p200f;

import android.support.v7.widget.LinearLayoutManager;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.exoplayer2.p157i.C2458b;
import com.google.android.exoplayer2.p157i.C2464e;
import com.google.android.exoplayer2.p157i.C2473g;
import com.google.android.exoplayer2.p157i.C4725c;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;
import java.nio.charset.Charset;
import java.util.List;

/* compiled from: Tx3gDecoder */
/* renamed from: com.google.android.exoplayer2.i.f.a */
public final class C4865a extends C4725c {
    /* renamed from: a */
    private static final int f13898a = C2541v.m7193g("styl");
    /* renamed from: b */
    private static final int f13899b = C2541v.m7193g("tbox");
    /* renamed from: c */
    private final C2529l f13900c = new C2529l();
    /* renamed from: d */
    private boolean f13901d;
    /* renamed from: e */
    private int f13902e;
    /* renamed from: f */
    private int f13903f;
    /* renamed from: g */
    private String f13904g;
    /* renamed from: h */
    private float f13905h;
    /* renamed from: i */
    private int f13906i;

    public C4865a(List<byte[]> list) {
        super("Tx3gDecoder");
        m17388a((List) list);
    }

    /* renamed from: a */
    private void m17388a(List<byte[]> list) {
        boolean z = false;
        if (list != null && list.size() == 1 && (((byte[]) list.get(0)).length == 48 || ((byte[]) list.get(0)).length == 53)) {
            byte[] bArr = (byte[]) list.get(0);
            this.f13902e = bArr[24];
            this.f13903f = ((((bArr[26] & JfifUtil.MARKER_FIRST_BYTE) << 24) | ((bArr[27] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | ((bArr[28] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | (bArr[29] & JfifUtil.MARKER_FIRST_BYTE);
            this.f13904g = "Serif".equals(new String(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
            this.f13906i = bArr[25] * 20;
            if ((bArr[0] & 32) != 0) {
                z = true;
            }
            this.f13901d = z;
            if (this.f13901d) {
                this.f13905h = ((float) ((bArr[11] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[10] & JfifUtil.MARKER_FIRST_BYTE) << 8))) / ((float) this.f13906i);
                this.f13905h = C2541v.m7162a(this.f13905h, 0.0f, 0.95f);
                return;
            }
            this.f13905h = 0.85f;
            return;
        }
        this.f13902e = 0;
        this.f13903f = -1;
        this.f13904g = "sans-serif";
        this.f13901d = false;
        this.f13905h = 0.85f;
    }

    /* renamed from: a */
    protected C2464e mo3431a(byte[] bArr, int i, boolean z) {
        this.f13900c.m7091a(bArr, i);
        bArr = C4865a.m17384a(this.f13900c);
        if (bArr.isEmpty() != 0) {
            return C4229b.f11134a;
        }
        i = new SpannableStringBuilder(bArr);
        SpannableStringBuilder spannableStringBuilder = i;
        C4865a.m17385a(spannableStringBuilder, this.f13902e, 0, 0, i.length(), 16711680);
        C4865a.m17390b(spannableStringBuilder, this.f13903f, -1, 0, i.length(), 16711680);
        C4865a.m17386a(spannableStringBuilder, this.f13904g, "sans-serif", 0, i.length(), 16711680);
        float f = this.f13905h;
        while (this.f13900c.m7093b() >= true) {
            bArr = this.f13900c.m7097d();
            z = this.f13900c.m7111o();
            int o = this.f13900c.m7111o();
            boolean z2 = false;
            boolean z3 = true;
            if (o == f13898a) {
                if (this.f13900c.m7093b() < 2) {
                    z3 = false;
                }
                C4865a.m17389a(z3);
                o = this.f13900c.m7104h();
                int i2;
                while (i2 < o) {
                    m17387a(this.f13900c, i);
                    i2++;
                }
            } else if (o == f13899b && this.f13901d) {
                if (this.f13900c.m7093b() >= 2) {
                    z2 = true;
                }
                C4865a.m17389a(z2);
                f = C2541v.m7162a(((float) this.f13900c.m7104h()) / ((float) this.f13906i), 0.0f, 0.95f);
            }
            this.f13900c.m7096c(bArr + z);
        }
        return new C4229b(new C2458b(i, null, f, 0, 0, Float.MIN_VALUE, LinearLayoutManager.INVALID_OFFSET, Float.MIN_VALUE));
    }

    /* renamed from: a */
    private static String m17384a(C2529l c2529l) {
        C4865a.m17389a(c2529l.m7093b() >= 2);
        int h = c2529l.m7104h();
        if (h == 0) {
            return "";
        }
        if (c2529l.m7093b() >= 2) {
            char f = c2529l.m7101f();
            if (f == '﻿' || f == '￾') {
                return c2529l.m7087a(h, Charset.forName("UTF-16"));
            }
        }
        return c2529l.m7087a(h, Charset.forName(Utf8Charset.NAME));
    }

    /* renamed from: a */
    private void m17387a(C2529l c2529l, SpannableStringBuilder spannableStringBuilder) {
        C4865a.m17389a(c2529l.m7093b() >= 12);
        int h = c2529l.m7104h();
        int h2 = c2529l.m7104h();
        c2529l.m7098d(2);
        int g = c2529l.m7103g();
        c2529l.m7098d(1);
        c2529l = c2529l.m7111o();
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        int i = h;
        int i2 = h2;
        C4865a.m17385a(spannableStringBuilder2, g, this.f13902e, i, i2, 0);
        C4865a.m17390b(spannableStringBuilder2, c2529l, this.f13903f, i, i2, 0);
    }

    /* renamed from: a */
    private static void m17385a(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            i2 = i5 | 33;
            int i6 = 1;
            i5 = (i & 1) != 0 ? 1 : 0;
            Object obj = (i & 2) != 0 ? 1 : null;
            if (i5 != 0) {
                if (obj != null) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i2);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i2);
                }
            } else if (obj != null) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i2);
            }
            if ((i & 4) == 0) {
                i6 = 0;
            }
            if (i6 != 0) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i2);
            }
            if (i6 == 0 && i5 == 0 && obj == null) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i2);
            }
        }
    }

    /* renamed from: b */
    private static void m17390b(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & JfifUtil.MARKER_FIRST_BYTE) << 24)), i3, i4, i5 | 33);
        }
    }

    /* renamed from: a */
    private static void m17386a(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i, int i2, int i3) {
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i, i2, i3 | 33);
        }
    }

    /* renamed from: a */
    private static void m17389a(boolean z) {
        if (!z) {
            throw new C2473g("Unexpected subtitle format.");
        }
    }
}
