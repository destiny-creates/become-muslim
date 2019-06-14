package com.facebook.ads.internal.view.p120f.p123c;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.p095j.C1402f;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.p120f.C3640a;
import com.facebook.ads.internal.view.p120f.p121a.C1625b;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3649c;
import com.facebook.ads.internal.view.p120f.p122b.C3654h;
import com.facebook.ads.internal.view.p120f.p122b.C3655i;
import com.facebook.ads.internal.view.p120f.p122b.C3656j;
import com.facebook.ads.internal.view.p120f.p122b.C3657k;
import com.facebook.ads.internal.view.p120f.p122b.C3660n;
import com.facebook.ads.internal.view.p120f.p122b.C3661o;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.ads.internal.view.f.c.o */
public class C3683o extends RelativeLayout implements C1625b {
    /* renamed from: a */
    private static final int f9829a = ((int) (C1523w.f4503b * 6.0f));
    /* renamed from: b */
    private ObjectAnimator f9830b;
    /* renamed from: c */
    private AtomicInteger f9831c;
    /* renamed from: d */
    private ProgressBar f9832d;
    /* renamed from: e */
    private C3640a f9833e;
    /* renamed from: f */
    private C1402f f9834f;
    /* renamed from: g */
    private C1402f f9835g;
    /* renamed from: h */
    private C1402f f9836h;
    /* renamed from: i */
    private C1402f f9837i;

    /* renamed from: com.facebook.ads.internal.view.f.c.o$1 */
    class C46141 extends C3661o {
        /* renamed from: a */
        final /* synthetic */ C3683o f12541a;

        C46141(C3683o c3683o) {
            this.f12541a = c3683o;
        }

        /* renamed from: a */
        public void m15902a(C3660n c3660n) {
            if (this.f12541a.f9833e != null) {
                this.f12541a.m12028a(this.f12541a.f9833e.getDuration(), this.f12541a.f9833e.getCurrentPositionInMillis());
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.o$2 */
    class C46152 extends C3655i {
        /* renamed from: a */
        final /* synthetic */ C3683o f12542a;

        C46152(C3683o c3683o) {
            this.f12542a = c3683o;
        }

        /* renamed from: a */
        public void m15904a(C3654h c3654h) {
            this.f12542a.m12030b();
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.o$3 */
    class C46163 extends C3657k {
        /* renamed from: a */
        final /* synthetic */ C3683o f12543a;

        C46163(C3683o c3683o) {
            this.f12543a = c3683o;
        }

        /* renamed from: a */
        public void m15906a(C3656j c3656j) {
            if (this.f12543a.f9833e != null) {
                this.f12543a.m12028a(this.f12543a.f9833e.getDuration(), this.f12543a.f9833e.getCurrentPositionInMillis());
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.o$4 */
    class C46174 extends C3649c {
        /* renamed from: a */
        final /* synthetic */ C3683o f12544a;

        C46174(C3683o c3683o) {
            this.f12544a = c3683o;
        }

        /* renamed from: a */
        public void m15908a(C3648b c3648b) {
            if (this.f12544a.f9833e != null) {
                this.f12544a.m12032c();
            }
        }
    }

    public C3683o(Context context) {
        this(context, f9829a, -12549889);
    }

    public C3683o(Context context, int i, int i2) {
        super(context);
        this.f9834f = new C46141(this);
        this.f9835g = new C46152(this);
        this.f9836h = new C46163(this);
        this.f9837i = new C46174(this);
        this.f9831c = new AtomicInteger(-1);
        this.f9832d = new ProgressBar(context, null, 16842872);
        this.f9832d.setLayoutParams(new LayoutParams(-1, i));
        setProgressBarColor(i2);
        this.f9832d.setMax(10000);
        addView(this.f9832d);
    }

    /* renamed from: a */
    private void m12028a(int i, int i2) {
        m12030b();
        if (this.f9831c.get() >= i2) {
            return;
        }
        if (i > i2) {
            int i3 = (i2 * 10000) / i;
            int min = (Math.min(i2 + 250, i) * 10000) / i;
            this.f9830b = ObjectAnimator.ofInt(this.f9832d, "progress", new int[]{i3, min});
            this.f9830b.setDuration((long) Math.min(250, i - i2));
            this.f9830b.setInterpolator(new LinearInterpolator());
            this.f9830b.start();
            this.f9831c.set(i2);
        }
    }

    /* renamed from: b */
    private void m12030b() {
        if (this.f9830b != null) {
            this.f9830b.cancel();
            this.f9830b.setTarget(null);
            this.f9830b = null;
            this.f9832d.clearAnimation();
        }
    }

    /* renamed from: c */
    private void m12032c() {
        m12030b();
        this.f9830b = ObjectAnimator.ofInt(this.f9832d, "progress", new int[]{0, 0});
        this.f9830b.setDuration(0);
        this.f9830b.setInterpolator(new LinearInterpolator());
        this.f9830b.start();
        this.f9831c.set(0);
    }

    /* renamed from: a */
    public void m12034a() {
        m12030b();
        this.f9832d = null;
        this.f9833e = null;
    }

    /* renamed from: a */
    public void mo1029a(C3640a c3640a) {
        this.f9833e = c3640a;
        c3640a.getEventBus().m4804a(this.f9835g, this.f9836h, this.f9834f, this.f9837i);
    }

    /* renamed from: b */
    public void mo1030b(C3640a c3640a) {
        c3640a.getEventBus().m4806b(this.f9834f, this.f9836h, this.f9835g, this.f9837i);
        this.f9833e = null;
    }

    public void setProgressBarColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        ColorDrawable colorDrawable2 = new ColorDrawable(0);
        ScaleDrawable scaleDrawable = new ScaleDrawable(new ColorDrawable(i), 8388611, 1.0f, -1.0f);
        Drawable layerDrawable = new LayerDrawable(new Drawable[]{colorDrawable, colorDrawable2, scaleDrawable});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908303);
        layerDrawable.setId(2, 16908301);
        this.f9832d.setProgressDrawable(layerDrawable);
    }
}
