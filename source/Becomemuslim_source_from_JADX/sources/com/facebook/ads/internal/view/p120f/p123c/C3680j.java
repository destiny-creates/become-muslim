package com.facebook.ads.internal.view.p120f.p123c;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import com.facebook.ads.internal.view.p120f.C3640a;
import com.facebook.ads.internal.view.p120f.p121a.C1625b;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3649c;
import com.facebook.ads.internal.view.p120f.p122b.C3658l;
import com.facebook.ads.internal.view.p120f.p122b.C3659m;
import com.facebook.ads.internal.view.p120f.p122b.C3660n;
import com.facebook.ads.internal.view.p120f.p122b.C3661o;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.ads.internal.view.f.c.j */
public class C3680j extends View implements C1625b {
    /* renamed from: a */
    private final Paint f9809a;
    /* renamed from: b */
    private final Paint f9810b;
    /* renamed from: c */
    private final Paint f9811c;
    /* renamed from: d */
    private C1645a f9812d = C1645a.CLOSE_BUTTON_MODE;
    /* renamed from: e */
    private final Paint f9813e;
    /* renamed from: f */
    private final RectF f9814f;
    /* renamed from: g */
    private C3640a f9815g;
    /* renamed from: h */
    private int f9816h;
    /* renamed from: i */
    private final AtomicInteger f9817i = new AtomicInteger(0);
    /* renamed from: j */
    private final AtomicBoolean f9818j = new AtomicBoolean(false);
    /* renamed from: k */
    private final C3659m f9819k = new C46041(this);
    /* renamed from: l */
    private final C3661o f9820l = new C46052(this);
    /* renamed from: m */
    private final C3649c f9821m = new C46063(this);

    /* renamed from: com.facebook.ads.internal.view.f.c.j$a */
    public enum C1645a {
        CLOSE_BUTTON_MODE,
        SKIP_BUTTON_MODE
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.j$1 */
    class C46041 extends C3659m {
        /* renamed from: a */
        final /* synthetic */ C3680j f12527a;

        C46041(C3680j c3680j) {
            this.f12527a = c3680j;
        }

        /* renamed from: a */
        public void m15877a(C3658l c3658l) {
            this.f12527a.f9818j.set(true);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.j$2 */
    class C46052 extends C3661o {
        /* renamed from: a */
        final /* synthetic */ C3680j f12528a;

        C46052(C3680j c3680j) {
            this.f12528a = c3680j;
        }

        /* renamed from: a */
        public void m15879a(C3660n c3660n) {
            if (this.f12528a.f9815g != null) {
                int c = this.f12528a.f9816h;
                int duration = this.f12528a.f9815g.getDuration();
                if (c <= 0) {
                    this.f12528a.f9817i.set(0);
                } else {
                    c = Math.min(duration, c * 1000);
                    if (c != 0) {
                        this.f12528a.f9817i.set(((c - this.f12528a.f9815g.getCurrentPositionInMillis()) * 100) / c);
                    } else {
                        return;
                    }
                }
                this.f12528a.postInvalidate();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.j$3 */
    class C46063 extends C3649c {
        /* renamed from: a */
        final /* synthetic */ C3680j f12529a;

        C46063(C3680j c3680j) {
            this.f12529a = c3680j;
        }

        /* renamed from: a */
        public void m15881a(C3648b c3648b) {
            this.f12529a.f9816h = 0;
            this.f12529a.f9817i.set(0);
            this.f12529a.postInvalidate();
        }
    }

    public C3680j(Context context, int i, int i2) {
        super(context);
        float f = getResources().getDisplayMetrics().density;
        this.f9816h = i;
        this.f9810b = new Paint();
        this.f9810b.setStyle(Style.FILL);
        this.f9810b.setColor(i2);
        this.f9811c = new Paint();
        this.f9811c.setColor(-1);
        this.f9811c.setAlpha(230);
        this.f9811c.setStyle(Style.FILL);
        this.f9811c.setStrokeWidth(1.0f * f);
        this.f9811c.setAntiAlias(true);
        this.f9809a = new Paint();
        this.f9809a.setColor(-16777216);
        this.f9809a.setStyle(Style.STROKE);
        this.f9809a.setAlpha(102);
        this.f9809a.setStrokeWidth(1.5f * f);
        this.f9809a.setAntiAlias(true);
        setLayerType(1, null);
        this.f9809a.setMaskFilter(new BlurMaskFilter(6.0f, Blur.NORMAL));
        this.f9813e = new Paint();
        this.f9813e.setColor(-10066330);
        this.f9813e.setStyle(Style.STROKE);
        this.f9813e.setStrokeWidth(f * 2.0f);
        this.f9813e.setAntiAlias(true);
        this.f9814f = new RectF();
    }

    /* renamed from: a */
    public void mo1029a(C3640a c3640a) {
        this.f9815g = c3640a;
        this.f9815g.getEventBus().m4804a(this.f9819k, this.f9820l, this.f9821m);
    }

    /* renamed from: a */
    public boolean m12018a() {
        return this.f9815g != null && (this.f9816h <= 0 || this.f9817i.get() < 0);
    }

    /* renamed from: b */
    public void mo1030b(C3640a c3640a) {
        this.f9815g.getEventBus().m4806b(this.f9821m, this.f9820l, this.f9819k);
        this.f9815g = null;
    }

    public int getSkipSeconds() {
        return this.f9816h;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f9818j.get()) {
            int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
            int i = min / 2;
            float f = (float) i;
            canvas.drawCircle((float) (getPaddingLeft() + i), (float) (getPaddingTop() + i), f, this.f9809a);
            canvas.drawCircle((float) (getPaddingLeft() + i), (float) (getPaddingTop() + i), f, this.f9811c);
            if (this.f9817i.get() > 0) {
                this.f9814f.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()));
                canvas.drawArc(this.f9814f, -90.0f, ((float) (-(this.f9817i.get() * 360))) / 100.0f, true, this.f9810b);
            } else if (this.f9812d == C1645a.SKIP_BUTTON_MODE) {
                int i2 = min / 4;
                min /= 3;
                Path path = new Path();
                path.moveTo((float) (getPaddingLeft() + i2), (float) (getPaddingTop() + min));
                path.lineTo((float) (getPaddingLeft() + i), (float) (getPaddingTop() + i));
                int i3 = min * 2;
                path.lineTo((float) (getPaddingLeft() + i2), (float) (getPaddingTop() + i3));
                canvas.drawPath(path, this.f9813e);
                path = new Path();
                path.moveTo((float) (getPaddingLeft() + i), (float) (min + getPaddingTop()));
                path.lineTo((float) ((i2 * 3) + getPaddingLeft()), (float) (getPaddingTop() + i));
                path.lineTo((float) (i + getPaddingLeft()), (float) (i3 + getPaddingTop()));
                canvas.drawPath(path, this.f9813e);
            } else {
                min /= 3;
                i = min * 2;
                Canvas canvas2 = canvas;
                canvas2.drawLine((float) (getPaddingLeft() + min), (float) (getPaddingTop() + min), (float) (getPaddingLeft() + i), (float) (getPaddingTop() + i), this.f9813e);
                canvas.drawLine((float) (getPaddingLeft() + i), (float) (getPaddingTop() + min), (float) (min + getPaddingLeft()), (float) (i + getPaddingTop()), this.f9813e);
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
    }

    public void setButtonMode(C1645a c1645a) {
        this.f9812d = c1645a;
    }
}
