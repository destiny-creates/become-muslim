package com.facebook.ads.internal.view.p120f.p123c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.p120f.p121a.C1624a;
import com.facebook.ads.internal.view.p120f.p121a.C3639c;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3649c;
import com.facebook.ads.internal.view.p120f.p122b.C3654h;
import com.facebook.ads.internal.view.p120f.p122b.C3655i;
import com.facebook.ads.internal.view.p120f.p122b.C3656j;
import com.facebook.ads.internal.view.p120f.p122b.C3657k;

/* renamed from: com.facebook.ads.internal.view.f.c.l */
public class C4611l extends C3639c {
    /* renamed from: a */
    private final C3655i f12534a;
    /* renamed from: b */
    private final C3657k f12535b;
    /* renamed from: c */
    private final C3649c f12536c;
    /* renamed from: d */
    private final C1649m f12537d;
    /* renamed from: e */
    private final Paint f12538e;

    /* renamed from: com.facebook.ads.internal.view.f.c.l$4 */
    class C16464 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C4611l f4933a;

        C16464(C4611l c4611l) {
            this.f4933a = c4611l;
        }

        public void onClick(View view) {
            if (this.f4933a.getVideoView() != null) {
                switch (this.f4933a.getVideoView().getState()) {
                    case PREPARED:
                    case IDLE:
                    case PAUSED:
                    case PLAYBACK_COMPLETED:
                        this.f4933a.getVideoView().m11914a(C1624a.USER_STARTED);
                        break;
                    case STARTED:
                        this.f4933a.getVideoView().m11917a(true);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.l$1 */
    class C46081 extends C3655i {
        /* renamed from: a */
        final /* synthetic */ C4611l f12531a;

        C46081(C4611l c4611l) {
            this.f12531a = c4611l;
        }

        /* renamed from: a */
        public void m15885a(C3654h c3654h) {
            this.f12531a.f12537d.setChecked(true);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.l$2 */
    class C46092 extends C3657k {
        /* renamed from: a */
        final /* synthetic */ C4611l f12532a;

        C46092(C4611l c4611l) {
            this.f12532a = c4611l;
        }

        /* renamed from: a */
        public void m15887a(C3656j c3656j) {
            this.f12532a.f12537d.setChecked(false);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.l$3 */
    class C46103 extends C3649c {
        /* renamed from: a */
        final /* synthetic */ C4611l f12533a;

        C46103(C4611l c4611l) {
            this.f12533a = c4611l;
        }

        /* renamed from: a */
        public void m15889a(C3648b c3648b) {
            this.f12533a.f12537d.setChecked(true);
        }
    }

    public C4611l(Context context) {
        this(context, false);
    }

    public C4611l(Context context, boolean z) {
        super(context);
        this.f12534a = new C46081(this);
        this.f12535b = new C46092(this);
        this.f12536c = new C46103(this);
        this.f12537d = new C1649m(context, z);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((double) displayMetrics.density) * 23.76d), (int) (((double) displayMetrics.density) * 23.76d));
        layoutParams.addRule(13);
        this.f12537d.setLayoutParams(layoutParams);
        this.f12537d.setChecked(true);
        this.f12538e = new Paint();
        this.f12538e.setStyle(Style.FILL);
        if (z) {
            this.f12538e.setColor(-1728053248);
        } else {
            this.f12538e.setColor(-1);
            this.f12538e.setAlpha(204);
        }
        C1523w.m5342a((View) this, 0);
        addView(this.f12537d);
        setGravity(17);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (((double) displayMetrics.density) * 72.0d), (int) (((double) displayMetrics.density) * 72.0d));
        layoutParams2.addRule(13);
        setLayoutParams(layoutParams2);
    }

    /* renamed from: a */
    protected void mo2877a() {
        super.mo2877a();
        if (getVideoView() != null) {
            getVideoView().getEventBus().m4804a(this.f12534a, this.f12535b, this.f12536c);
        }
        OnClickListener c16464 = new C16464(this);
        this.f12537d.setClickable(false);
        setOnClickListener(c16464);
    }

    /* renamed from: b */
    protected void mo2878b() {
        setOnClickListener(null);
        if (getVideoView() != null) {
            getVideoView().getEventBus().m4806b(this.f12536c, this.f12535b, this.f12534a);
        }
        super.mo2878b();
    }

    protected void onDraw(Canvas canvas) {
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom()) / 2;
        canvas.drawCircle((float) (getPaddingLeft() + min), (float) (getPaddingTop() + min), (float) min, this.f12538e);
        super.onDraw(canvas);
    }
}
