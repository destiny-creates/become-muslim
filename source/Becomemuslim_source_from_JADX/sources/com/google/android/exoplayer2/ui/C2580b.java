package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import com.google.android.exoplayer2.p157i.C2448a;
import com.google.android.exoplayer2.p157i.C2458b;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: SubtitlePainter */
/* renamed from: com.google.android.exoplayer2.ui.b */
final class C2580b {
    /* renamed from: A */
    private float f6578A;
    /* renamed from: B */
    private float f6579B;
    /* renamed from: C */
    private int f6580C;
    /* renamed from: D */
    private int f6581D;
    /* renamed from: E */
    private int f6582E;
    /* renamed from: F */
    private int f6583F;
    /* renamed from: G */
    private StaticLayout f6584G;
    /* renamed from: H */
    private int f6585H;
    /* renamed from: I */
    private int f6586I;
    /* renamed from: J */
    private int f6587J;
    /* renamed from: K */
    private Rect f6588K;
    /* renamed from: a */
    private final RectF f6589a = new RectF();
    /* renamed from: b */
    private final float f6590b;
    /* renamed from: c */
    private final float f6591c;
    /* renamed from: d */
    private final float f6592d;
    /* renamed from: e */
    private final float f6593e;
    /* renamed from: f */
    private final float f6594f;
    /* renamed from: g */
    private final float f6595g;
    /* renamed from: h */
    private final TextPaint f6596h;
    /* renamed from: i */
    private final Paint f6597i;
    /* renamed from: j */
    private CharSequence f6598j;
    /* renamed from: k */
    private Alignment f6599k;
    /* renamed from: l */
    private Bitmap f6600l;
    /* renamed from: m */
    private float f6601m;
    /* renamed from: n */
    private int f6602n;
    /* renamed from: o */
    private int f6603o;
    /* renamed from: p */
    private float f6604p;
    /* renamed from: q */
    private int f6605q;
    /* renamed from: r */
    private float f6606r;
    /* renamed from: s */
    private float f6607s;
    /* renamed from: t */
    private boolean f6608t;
    /* renamed from: u */
    private boolean f6609u;
    /* renamed from: v */
    private int f6610v;
    /* renamed from: w */
    private int f6611w;
    /* renamed from: x */
    private int f6612x;
    /* renamed from: y */
    private int f6613y;
    /* renamed from: z */
    private int f6614z;

    public C2580b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.f6595g = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f6594f = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        context = (float) Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * 2.0f) / 160.0f);
        this.f6590b = context;
        this.f6591c = context;
        this.f6592d = context;
        this.f6593e = context;
        this.f6596h = new TextPaint();
        this.f6596h.setAntiAlias(true);
        this.f6596h.setSubpixelText(true);
        this.f6597i = new Paint();
        this.f6597i.setAntiAlias(true);
        this.f6597i.setStyle(Style.FILL);
    }

    /* renamed from: a */
    public void m7297a(C2458b c2458b, boolean z, boolean z2, C2448a c2448a, float f, float f2, Canvas canvas, int i, int i2, int i3, int i4) {
        boolean z3 = c2458b.f6209c == null;
        int i5 = -16777216;
        if (z3) {
            if (!TextUtils.isEmpty(c2458b.f6207a)) {
                i5 = (c2458b.f6217k && z) ? c2458b.f6218l : c2448a.f6147d;
            } else {
                return;
            }
        }
        if (C2580b.m7294a(this.f6598j, c2458b.f6207a) && C2541v.m7179a(this.f6599k, c2458b.f6208b) && this.f6600l == c2458b.f6209c && this.f6601m == c2458b.f6210d && this.f6602n == c2458b.f6211e && C2541v.m7179a(Integer.valueOf(this.f6603o), Integer.valueOf(c2458b.f6212f)) && this.f6604p == c2458b.f6213g && C2541v.m7179a(Integer.valueOf(this.f6605q), Integer.valueOf(c2458b.f6214h)) && this.f6606r == c2458b.f6215i && this.f6607s == c2458b.f6216j && this.f6608t == z && this.f6609u == z2 && this.f6610v == c2448a.f6145b && this.f6611w == c2448a.f6146c && this.f6612x == i5 && this.f6614z == c2448a.f6148e && this.f6613y == c2448a.f6149f && C2541v.m7179a(this.f6596h.getTypeface(), c2448a.f6150g) && this.f6578A == f && this.f6579B == f2 && this.f6580C == i && this.f6581D == i2 && this.f6582E == i3 && this.f6583F == i4) {
            m7293a(canvas, z3);
            return;
        }
        this.f6598j = c2458b.f6207a;
        this.f6599k = c2458b.f6208b;
        this.f6600l = c2458b.f6209c;
        this.f6601m = c2458b.f6210d;
        this.f6602n = c2458b.f6211e;
        this.f6603o = c2458b.f6212f;
        this.f6604p = c2458b.f6213g;
        this.f6605q = c2458b.f6214h;
        this.f6606r = c2458b.f6215i;
        this.f6607s = c2458b.f6216j;
        this.f6608t = z;
        this.f6609u = z2;
        this.f6610v = c2448a.f6145b;
        this.f6611w = c2448a.f6146c;
        this.f6612x = i5;
        this.f6614z = c2448a.f6148e;
        this.f6613y = c2448a.f6149f;
        this.f6596h.setTypeface(c2448a.f6150g);
        this.f6578A = f;
        this.f6579B = f2;
        this.f6580C = i;
        this.f6581D = i2;
        this.f6582E = i3;
        this.f6583F = i4;
        if (z3) {
            m7291a();
        } else {
            m7295b();
        }
        m7293a(canvas, z3);
    }

    /* renamed from: a */
    private void m7291a() {
        int i = this.f6582E - this.f6580C;
        int i2 = this.f6583F - this.f6581D;
        this.f6596h.setTextSize(this.f6578A);
        int i3 = (int) ((this.f6578A * 0.125f) + 0.5f);
        int i4 = i3 * 2;
        int i5 = i - i4;
        if (this.f6606r != Float.MIN_VALUE) {
            i5 = (int) (((float) i5) * r0.f6606r);
        }
        if (i5 <= 0) {
            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        CharSequence charSequence;
        int length;
        int i6;
        if (r0.f6609u && r0.f6608t) {
            charSequence = r0.f6598j;
        } else if (r0.f6608t) {
            charSequence = new SpannableStringBuilder(r0.f6598j);
            length = charSequence.length();
            AbsoluteSizeSpan[] absoluteSizeSpanArr = (AbsoluteSizeSpan[]) charSequence.getSpans(0, length, AbsoluteSizeSpan.class);
            RelativeSizeSpan[] relativeSizeSpanArr = (RelativeSizeSpan[]) charSequence.getSpans(0, length, RelativeSizeSpan.class);
            for (Object removeSpan : absoluteSizeSpanArr) {
                charSequence.removeSpan(removeSpan);
            }
            for (Object removeSpan2 : relativeSizeSpanArr) {
                charSequence.removeSpan(removeSpan2);
            }
        } else {
            charSequence = r0.f6598j.toString();
        }
        CharSequence charSequence2 = charSequence;
        Alignment alignment = r0.f6599k == null ? Alignment.ALIGN_CENTER : r0.f6599k;
        r0.f6584G = new StaticLayout(charSequence2, r0.f6596h, i5, alignment, r0.f6594f, r0.f6595g, true);
        int height = r0.f6584G.getHeight();
        length = r0.f6584G.getLineCount();
        int i7 = 0;
        for (i6 = 0; i6 < length; i6++) {
            i7 = Math.max((int) Math.ceil((double) r0.f6584G.getLineWidth(i6)), i7);
        }
        if (r0.f6606r == Float.MIN_VALUE || i7 >= i5) {
            i5 = i7;
        }
        i5 += i4;
        if (r0.f6604p != Float.MIN_VALUE) {
            i = Math.round(((float) i) * r0.f6604p) + r0.f6580C;
            if (r0.f6605q == 2) {
                i -= i5;
            } else if (r0.f6605q == 1) {
                i = ((i * 2) - i5) / 2;
            }
            i = Math.max(i, r0.f6580C);
            i4 = Math.min(i5 + i, r0.f6582E);
        } else {
            i = (i - i5) / 2;
            i4 = i + i5;
        }
        int i8 = i4 - i;
        if (i8 <= 0) {
            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        if (r0.f6601m != Float.MIN_VALUE) {
            if (r0.f6602n == 0) {
                i2 = Math.round(((float) i2) * r0.f6601m) + r0.f6581D;
            } else {
                i2 = r0.f6584G.getLineBottom(0) - r0.f6584G.getLineTop(0);
                if (r0.f6601m >= 0.0f) {
                    i2 = Math.round(r0.f6601m * ((float) i2)) + r0.f6581D;
                } else {
                    i2 = Math.round((r0.f6601m + 1.0f) * ((float) i2)) + r0.f6583F;
                }
            }
            if (r0.f6603o == 2) {
                i2 -= height;
            } else if (r0.f6603o == 1) {
                i2 = ((i2 * 2) - height) / 2;
            }
            if (i2 + height > r0.f6583F) {
                i2 = r0.f6583F - height;
            } else if (i2 < r0.f6581D) {
                i2 = r0.f6581D;
            }
        } else {
            i2 = (r0.f6583F - height) - ((int) (((float) i2) * r0.f6579B));
        }
        r0.f6584G = new StaticLayout(charSequence2, r0.f6596h, i8, alignment, r0.f6594f, r0.f6595g, true);
        r0.f6585H = i;
        r0.f6586I = i2;
        r0.f6587J = i3;
    }

    /* renamed from: b */
    private void m7295b() {
        int round;
        float f;
        int round2;
        int round3;
        float f2 = (float) (this.f6582E - this.f6580C);
        float f3 = ((float) this.f6580C) + (this.f6604p * f2);
        float f4 = (float) (this.f6583F - this.f6581D);
        float f5 = ((float) this.f6581D) + (this.f6601m * f4);
        int round4 = Math.round(f2 * this.f6606r);
        if (this.f6607s != Float.MIN_VALUE) {
            round = Math.round(f4 * this.f6607s);
        } else {
            round = Math.round(((float) round4) * (((float) this.f6600l.getHeight()) / ((float) this.f6600l.getWidth())));
        }
        if (this.f6603o == 2) {
            f = (float) round4;
        } else {
            if (this.f6603o == 1) {
                f = (float) (round4 / 2);
            }
            round2 = Math.round(f3);
            if (this.f6605q != 2) {
                f = (float) round;
            } else {
                if (this.f6605q == 1) {
                    f = (float) (round / 2);
                }
                round3 = Math.round(f5);
                this.f6588K = new Rect(round2, round3, round4 + round2, round + round3);
            }
            f5 -= f;
            round3 = Math.round(f5);
            this.f6588K = new Rect(round2, round3, round4 + round2, round + round3);
        }
        f3 -= f;
        round2 = Math.round(f3);
        if (this.f6605q != 2) {
            if (this.f6605q == 1) {
                f = (float) (round / 2);
            }
            round3 = Math.round(f5);
            this.f6588K = new Rect(round2, round3, round4 + round2, round + round3);
        }
        f = (float) round;
        f5 -= f;
        round3 = Math.round(f5);
        this.f6588K = new Rect(round2, round3, round4 + round2, round + round3);
    }

    /* renamed from: a */
    private void m7293a(Canvas canvas, boolean z) {
        if (z) {
            m7292a(canvas);
        } else {
            m7296b(canvas);
        }
    }

    /* renamed from: a */
    private void m7292a(Canvas canvas) {
        StaticLayout staticLayout = this.f6584G;
        if (staticLayout != null) {
            int i;
            int save = canvas.save();
            canvas.translate((float) this.f6585H, (float) this.f6586I);
            if (Color.alpha(this.f6612x) > 0) {
                this.f6597i.setColor(this.f6612x);
                canvas.drawRect((float) (-this.f6587J), 0.0f, (float) (staticLayout.getWidth() + this.f6587J), (float) staticLayout.getHeight(), this.f6597i);
            }
            if (Color.alpha(this.f6611w) > 0) {
                this.f6597i.setColor(this.f6611w);
                float lineTop = (float) staticLayout.getLineTop(0);
                int lineCount = staticLayout.getLineCount();
                float f = lineTop;
                for (i = 0; i < lineCount; i++) {
                    this.f6589a.left = staticLayout.getLineLeft(i) - ((float) this.f6587J);
                    this.f6589a.right = staticLayout.getLineRight(i) + ((float) this.f6587J);
                    this.f6589a.top = f;
                    this.f6589a.bottom = (float) staticLayout.getLineBottom(i);
                    f = this.f6589a.bottom;
                    canvas.drawRoundRect(this.f6589a, this.f6590b, this.f6590b, this.f6597i);
                }
            }
            Object obj = 1;
            if (this.f6614z == 1) {
                this.f6596h.setStrokeJoin(Join.ROUND);
                this.f6596h.setStrokeWidth(this.f6591c);
                this.f6596h.setColor(this.f6613y);
                this.f6596h.setStyle(Style.FILL_AND_STROKE);
                staticLayout.draw(canvas);
            } else if (this.f6614z == 2) {
                this.f6596h.setShadowLayer(this.f6592d, this.f6593e, this.f6593e, this.f6613y);
            } else if (this.f6614z == 3 || this.f6614z == 4) {
                int i2;
                if (this.f6614z != 3) {
                    obj = null;
                }
                i = -1;
                if (obj != null) {
                    i2 = -1;
                } else {
                    i2 = this.f6613y;
                }
                if (obj != null) {
                    i = this.f6613y;
                }
                float f2 = this.f6592d / 2.0f;
                this.f6596h.setColor(this.f6610v);
                this.f6596h.setStyle(Style.FILL);
                float f3 = -f2;
                this.f6596h.setShadowLayer(this.f6592d, f3, f3, i2);
                staticLayout.draw(canvas);
                this.f6596h.setShadowLayer(this.f6592d, f2, f2, i);
            }
            this.f6596h.setColor(this.f6610v);
            this.f6596h.setStyle(Style.FILL);
            staticLayout.draw(canvas);
            this.f6596h.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    /* renamed from: b */
    private void m7296b(Canvas canvas) {
        canvas.drawBitmap(this.f6600l, null, this.f6588K, null);
    }

    /* renamed from: a */
    private static boolean m7294a(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != charSequence2) {
            if (charSequence == null || charSequence.equals(charSequence2) == null) {
                return null;
            }
        }
        return true;
    }
}
