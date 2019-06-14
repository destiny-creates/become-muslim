package ai.api.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: SoundLevelCircleDrawable */
/* renamed from: ai.api.ui.c */
public class C0057c extends Drawable {
    /* renamed from: a */
    public static final int f156a = Color.argb(16, 0, 0, 0);
    /* renamed from: b */
    private final float f157b;
    /* renamed from: c */
    private final float f158c;
    /* renamed from: d */
    private final float f159d;
    /* renamed from: e */
    private final float f160e;
    /* renamed from: f */
    private float f161f;
    /* renamed from: g */
    private float f162g;
    /* renamed from: h */
    private boolean f163h;
    /* renamed from: i */
    private final Paint f164i;
    /* renamed from: j */
    private final Paint f165j;
    /* renamed from: k */
    private float f166k;
    /* renamed from: l */
    private final Rect f167l;
    /* renamed from: m */
    private boolean f168m;

    /* compiled from: SoundLevelCircleDrawable */
    /* renamed from: ai.api.ui.c$a */
    public static class C0056a {
        /* renamed from: a */
        public final float f150a;
        /* renamed from: b */
        public final float f151b;
        /* renamed from: c */
        public final float f152c;
        /* renamed from: d */
        public final float f153d;
        /* renamed from: e */
        private final int f154e;
        /* renamed from: f */
        private final int f155f;

        public C0056a(float f, float f2, float f3, float f4, int i, int i2) {
            this.f150a = f;
            this.f151b = f2;
            this.f152c = f3;
            this.f153d = f4;
            this.f154e = i;
            this.f155f = i2;
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    /* renamed from: a */
    private static Paint m129a(int i) {
        Paint paint = new Paint();
        paint.setStyle(Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i);
        return paint;
    }

    public C0057c() {
        this(null);
    }

    public C0057c(C0056a c0056a) {
        int a;
        int b;
        this.f161f = 0.5f;
        this.f162g = 10.0f;
        this.f163h = false;
        this.f166k = 2.5f;
        this.f167l = new Rect();
        this.f168m = false;
        if (c0056a != null) {
            this.f157b = c0056a.f150a;
            this.f158c = c0056a.f151b;
            this.f159d = c0056a.f152c;
            this.f160e = c0056a.f153d;
            a = c0056a.f154e;
            b = c0056a.f155f;
        } else {
            this.f157b = -1.0f;
            this.f158c = -1.0f;
            this.f159d = -1.0f;
            this.f160e = -1.0f;
            a = -889815;
            b = f156a;
        }
        this.f164i = C0057c.m129a(b);
        this.f165j = C0057c.m129a(a);
    }

    public void draw(Canvas canvas) {
        if (this.f163h || this.f168m) {
            canvas.save();
            try {
                if (this.f157b < 0.0f || this.f159d < 0.0f || this.f160e < 0.0f) {
                    canvas.getClipBounds(this.f167l);
                }
                canvas.drawColor(0);
                float f = (this.f166k - this.f161f) / (this.f162g - this.f161f);
                float width = this.f157b < 0.0f ? ((float) this.f167l.width()) / 2.0f : this.f157b;
                float f2 = this.f158c < 0.0f ? 0.5777778f * width : this.f158c;
                float f3 = 0.8f * f2;
                f3 += (width - f3) * f;
                f = this.f159d < 0.0f ? ((float) this.f167l.width()) / 2.0f : this.f159d;
                float height = this.f160e < 0.0f ? ((float) this.f167l.height()) / 2.0f : this.f160e;
                if (this.f163h) {
                    canvas.drawCircle(f, height, f3, this.f164i);
                }
                if (this.f168m || this.f163h) {
                    canvas.drawCircle(f, height, f2, this.f165j);
                }
                canvas.restore();
            } catch (Throwable th) {
                canvas.restore();
            }
        }
    }

    /* renamed from: a */
    public boolean m132a(boolean z) {
        if (this.f163h == z) {
            return false;
        }
        this.f163h = z;
        if (z) {
            this.f161f = true;
            this.f162g = true;
            this.f166k = true;
        }
        return true;
    }

    /* renamed from: b */
    public void m133b(boolean z) {
        this.f168m = z;
    }

    /* renamed from: a */
    public void m131a(float f) {
        f = Math.abs(f);
        if (f < this.f161f) {
            this.f161f = (this.f161f + f) / 2.0f;
        }
        if (f > this.f162g) {
            this.f162g = (this.f162g + f) / 2.0f;
        }
        this.f166k = (this.f166k * 0.8f) + (f * 0.2f);
        if (this.f166k > this.f162g) {
            this.f166k = this.f162g;
        } else if (this.f166k < this.f161f) {
            this.f166k = this.f161f;
        }
    }

    /* renamed from: a */
    public float m130a() {
        return this.f158c;
    }
}
