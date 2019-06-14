package com.facebook.ads.internal.view.p113b;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.facebook.ads.internal.p111r.C1545a;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.AnalyticsEvents;
import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.internal.view.b.c */
public class C1576c extends Drawable {
    /* renamed from: a */
    private final Paint f4697a = new Paint();
    /* renamed from: b */
    private final Paint f4698b = new Paint();
    /* renamed from: c */
    private final Path f4699c = new Path();
    /* renamed from: d */
    private final TextPaint f4700d = new TextPaint();
    /* renamed from: e */
    private final Paint f4701e = new Paint();
    /* renamed from: f */
    private int f4702f;
    /* renamed from: g */
    private int f4703g;
    /* renamed from: h */
    private String f4704h;
    /* renamed from: i */
    private int f4705i;
    /* renamed from: j */
    private boolean f4706j;
    /* renamed from: k */
    private String f4707k;
    /* renamed from: l */
    private String f4708l;
    /* renamed from: m */
    private long f4709m;
    /* renamed from: n */
    private final Handler f4710n = new Handler();
    /* renamed from: o */
    private WeakReference<C1545a> f4711o;
    /* renamed from: p */
    private final Runnable f4712p = new C15751(this);

    /* renamed from: com.facebook.ads.internal.view.b.c$1 */
    class C15751 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1576c f4696a;

        C15751(C1576c c1576c) {
            this.f4696a = c1576c;
        }

        public void run() {
            this.f4696a.m5494c();
            if (this.f4696a.f4706j) {
                this.f4696a.f4710n.postDelayed(this.f4696a.f4712p, 250);
            }
        }
    }

    public C1576c() {
        this.f4697a.setColor(Color.argb(127, 36, 36, 36));
        this.f4697a.setStyle(Style.FILL_AND_STROKE);
        this.f4698b.setAntiAlias(true);
        this.f4698b.setColor(Color.argb(191, 0, JfifUtil.MARKER_FIRST_BYTE, 0));
        this.f4698b.setStrokeWidth(20.0f);
        this.f4698b.setStyle(Style.STROKE);
        this.f4700d.setAntiAlias(true);
        this.f4700d.setColor(-1);
        this.f4700d.setStyle(Style.FILL_AND_STROKE);
        this.f4700d.setTextSize(30.0f);
        this.f4701e.setColor(Color.argb(212, 0, 0, 0));
        this.f4701e.setStyle(Style.FILL_AND_STROKE);
        m5502b();
    }

    /* renamed from: c */
    private void m5494c() {
        String str;
        float f;
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        if (this.f4702f <= 0) {
            if (!TextUtils.isEmpty(this.f4707k)) {
                stringBuilder.append(this.f4707k);
                stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            }
            if (!TextUtils.isEmpty(this.f4708l)) {
                stringBuilder.append(this.f4708l);
                stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            }
            stringBuilder.append("Sdk ");
            stringBuilder.append("4.99.0");
            stringBuilder.append(", Loaded ");
            if (this.f4709m > 0) {
                long max = Math.max(0, System.currentTimeMillis() - this.f4709m);
                int i2 = (int) (max / 3600000);
                max %= 3600000;
                int i3 = (int) (max / 60000);
                int i4 = (int) ((max % 60000) / 1000);
                if (i2 > 0) {
                    stringBuilder.append(i2);
                    stringBuilder.append("h ");
                }
                if (i2 > 0 || i3 > 0) {
                    stringBuilder.append(i3);
                    stringBuilder.append("m ");
                }
                stringBuilder.append(i4);
                str = "s ago";
            } else {
                str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            stringBuilder.append(str);
        } else {
            stringBuilder.append("Card ");
            stringBuilder.append(this.f4703g + 1);
            stringBuilder.append(" of ");
            stringBuilder.append(this.f4702f);
        }
        stringBuilder.append("\nView: ");
        if (this.f4711o != null) {
            if (this.f4711o.get() != null) {
                str = ((C1545a) this.f4711o.get()).m5437d();
                stringBuilder.append(str);
                this.f4704h = stringBuilder.toString();
                f = -2.14748365E9f;
                for (String str2 : this.f4704h.split(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)) {
                    f = Math.max(f, this.f4700d.measureText(str2, 0, str2.length()));
                }
                this.f4705i = (int) (f + 0.5f);
                invalidateSelf();
            }
        }
        str = "Viewability Checker not set";
        stringBuilder.append(str);
        this.f4704h = stringBuilder.toString();
        f = -2.14748365E9f;
        for (i = 0; i < r2; i++) {
            f = Math.max(f, this.f4700d.measureText(str2, 0, str2.length()));
        }
        this.f4705i = (int) (f + 0.5f);
        invalidateSelf();
    }

    /* renamed from: a */
    public void m5496a(int i, int i2) {
        this.f4702f = i;
        this.f4703g = i2;
        m5494c();
    }

    /* renamed from: a */
    public void m5497a(long j) {
        this.f4709m = j;
        m5494c();
    }

    /* renamed from: a */
    public void m5498a(C1545a c1545a) {
        this.f4711o = new WeakReference(c1545a);
        m5494c();
    }

    /* renamed from: a */
    public void m5499a(String str) {
        this.f4707k = str;
        m5494c();
    }

    /* renamed from: a */
    public void m5500a(boolean z) {
        this.f4706j = z;
        if (this.f4706j) {
            this.f4710n.post(this.f4712p);
        } else {
            this.f4710n.removeCallbacks(this.f4712p);
        }
        invalidateSelf();
    }

    /* renamed from: a */
    public boolean m5501a() {
        return this.f4706j;
    }

    /* renamed from: b */
    public void m5502b() {
        this.f4702f = 0;
        this.f4703g = -1;
        this.f4704h = "Initializing...";
        this.f4705i = 100;
        this.f4707k = null;
        this.f4709m = -1;
        this.f4711o = null;
        m5500a(false);
    }

    /* renamed from: b */
    public void m5503b(String str) {
        this.f4708l = str;
        m5494c();
    }

    public void draw(Canvas canvas) {
        Canvas canvas2 = canvas;
        if (this.f4706j) {
            float width = (float) canvas.getWidth();
            float height = (float) canvas.getHeight();
            canvas.drawRect(0.0f, 0.0f, width, height, r0.f4697a);
            StaticLayout staticLayout = new StaticLayout(r0.f4704h, r0.f4700d, r0.f4705i, Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            float f = width / 2.0f;
            float f2 = height / 2.0f;
            float width2 = ((float) staticLayout.getWidth()) / 2.0f;
            float height2 = ((float) staticLayout.getHeight()) / 2.0f;
            float f3 = f - width2;
            float f4 = f2 - height2;
            StaticLayout staticLayout2 = staticLayout;
            canvas.drawRect(f3 - 40.0f, f4 - 40.0f, (f + width2) + 40.0f, (f2 + height2) + 40.0f, r0.f4701e);
            canvas.save();
            canvas2.translate(f3, f4);
            staticLayout2.draw(canvas2);
            canvas.restore();
            r0.f4699c.reset();
            r0.f4699c.moveTo(0.0f, 0.0f);
            r0.f4699c.lineTo(width, 0.0f);
            r0.f4699c.lineTo(width, height);
            r0.f4699c.lineTo(0.0f, height);
            r0.f4699c.lineTo(0.0f, 0.0f);
            canvas2.drawPath(r0.f4699c, r0.f4698b);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
