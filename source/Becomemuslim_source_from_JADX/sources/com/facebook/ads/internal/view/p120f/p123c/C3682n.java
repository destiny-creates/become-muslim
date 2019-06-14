package com.facebook.ads.internal.view.p120f.p123c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.View;
import com.facebook.ads.internal.view.p120f.C3640a;
import com.facebook.ads.internal.view.p120f.p121a.C1625b;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3649c;
import com.facebook.ads.internal.view.p120f.p122b.C3660n;
import com.facebook.ads.internal.view.p120f.p122b.C3661o;

/* renamed from: com.facebook.ads.internal.view.f.c.n */
public class C3682n extends View implements C1625b {
    /* renamed from: a */
    private final Paint f9823a = new Paint();
    /* renamed from: b */
    private final Rect f9824b;
    /* renamed from: c */
    private float f9825c;
    /* renamed from: d */
    private final C3661o f9826d = new C46121(this);
    /* renamed from: e */
    private final C3649c f9827e = new C46132(this);
    /* renamed from: f */
    private C3640a f9828f;

    /* renamed from: com.facebook.ads.internal.view.f.c.n$1 */
    class C46121 extends C3661o {
        /* renamed from: a */
        final /* synthetic */ C3682n f12539a;

        C46121(C3682n c3682n) {
            this.f12539a = c3682n;
        }

        /* renamed from: a */
        public void m15898a(C3660n c3660n) {
            if (this.f12539a.f9828f != null) {
                int duration = this.f12539a.f9828f.getDuration();
                if (duration > 0) {
                    this.f12539a.f9825c = ((float) this.f12539a.f9828f.getCurrentPositionInMillis()) / ((float) duration);
                } else {
                    this.f12539a.f9825c = 0.0f;
                }
                this.f12539a.postInvalidate();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.n$2 */
    class C46132 extends C3649c {
        /* renamed from: a */
        final /* synthetic */ C3682n f12540a;

        C46132(C3682n c3682n) {
            this.f12540a = c3682n;
        }

        /* renamed from: a */
        public void m15900a(C3648b c3648b) {
            if (this.f12540a.f9828f != null) {
                this.f12540a.f9825c = 0.0f;
                this.f12540a.postInvalidate();
            }
        }
    }

    public C3682n(Context context) {
        super(context);
        this.f9823a.setStyle(Style.FILL);
        this.f9823a.setColor(-9528840);
        this.f9824b = new Rect();
    }

    /* renamed from: a */
    public void mo1029a(C3640a c3640a) {
        this.f9828f = c3640a;
        c3640a.getEventBus().m4804a(this.f9826d, this.f9827e);
    }

    /* renamed from: b */
    public void mo1030b(C3640a c3640a) {
        c3640a.getEventBus().m4806b(this.f9827e, this.f9826d);
        this.f9828f = null;
    }

    public void draw(Canvas canvas) {
        this.f9824b.set(0, 0, (int) (((float) getWidth()) * this.f9825c), getHeight());
        canvas.drawRect(this.f9824b, this.f9823a);
        super.draw(canvas);
    }
}
