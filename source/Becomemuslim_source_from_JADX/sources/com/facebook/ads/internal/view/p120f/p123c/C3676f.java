package com.facebook.ads.internal.view.p120f.p123c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.ads.internal.p105q.p107b.C1527b;
import com.facebook.ads.internal.p105q.p107b.C1528c;
import com.facebook.ads.internal.view.p120f.C3640a;
import com.facebook.ads.internal.view.p120f.p121a.C1625b;
import com.facebook.ads.internal.view.p120f.p122b.C3668v;
import com.facebook.ads.internal.view.p120f.p122b.C3669w;

/* renamed from: com.facebook.ads.internal.view.f.c.f */
public class C3676f extends ImageView implements C1625b {
    /* renamed from: a */
    private static final int f9802a = ((int) (Resources.getSystem().getDisplayMetrics().density * 4.0f));
    /* renamed from: b */
    private final Paint f9803b = new Paint();
    /* renamed from: c */
    private C3640a f9804c;
    /* renamed from: d */
    private final C3669w f9805d = new C45961(this);

    /* renamed from: com.facebook.ads.internal.view.f.c.f$2 */
    class C16422 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C3676f f4925a;

        C16422(C3676f c3676f) {
            this.f4925a = c3676f;
        }

        public void onClick(View view) {
            if (this.f4925a.f9804c != null) {
                C3640a a;
                float f;
                if (this.f4925a.m11996b()) {
                    a = this.f4925a.f9804c;
                    f = 1.0f;
                } else {
                    a = this.f4925a.f9804c;
                    f = 0.0f;
                }
                a.setVolume(f);
                this.f4925a.m12000a();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.f$1 */
    class C45961 extends C3669w {
        /* renamed from: a */
        final /* synthetic */ C3676f f12508a;

        C45961(C3676f c3676f) {
            this.f12508a = c3676f;
        }

        /* renamed from: a */
        public void m15850a(C3668v c3668v) {
            this.f12508a.m12000a();
        }
    }

    public C3676f(Context context) {
        super(context);
        this.f9803b.setColor(-1728053248);
        setColorFilter(-1);
        setPadding(f9802a, f9802a, f9802a, f9802a);
        m11998c();
        setOnClickListener(new C16422(this));
    }

    /* renamed from: b */
    private boolean m11996b() {
        return this.f9804c != null && this.f9804c.getVolume() == 0.0f;
    }

    /* renamed from: c */
    private void m11998c() {
        setImageBitmap(C1528c.m5354a(C1527b.SOUND_ON));
    }

    /* renamed from: d */
    private void m11999d() {
        setImageBitmap(C1528c.m5354a(C1527b.SOUND_OFF));
    }

    /* renamed from: a */
    public final void m12000a() {
        if (this.f9804c != null) {
            if (m11996b()) {
                m11999d();
            } else {
                m11998c();
            }
        }
    }

    /* renamed from: a */
    public void mo1029a(C3640a c3640a) {
        this.f9804c = c3640a;
        if (this.f9804c != null) {
            this.f9804c.getEventBus().m4805a(this.f9805d);
        }
    }

    /* renamed from: b */
    public void mo1030b(C3640a c3640a) {
        if (this.f9804c != null) {
            this.f9804c.getEventBus().m4807b(this.f9805d);
        }
        this.f9804c = null;
    }

    protected void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        canvas.drawCircle((float) width, (float) height, (float) Math.min(width, height), this.f9803b);
        super.onDraw(canvas);
    }
}
