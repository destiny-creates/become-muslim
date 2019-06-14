package com.facebook.ads.internal.view.p120f.p123c;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.p095j.C1402f;
import com.facebook.ads.internal.view.p120f.p121a.C3639c;
import com.facebook.ads.internal.view.p120f.p122b.C3658l;

/* renamed from: com.facebook.ads.internal.view.f.c.k */
public class C4607k extends C3639c {
    /* renamed from: a */
    private final C1402f<C3658l> f12530a;

    /* renamed from: com.facebook.ads.internal.view.f.c.k$1 */
    class C36811 extends C1402f<C3658l> {
        /* renamed from: a */
        final /* synthetic */ C4607k f9822a;

        C36811(C4607k c4607k) {
            this.f9822a = c4607k;
        }

        /* renamed from: a */
        public Class<C3658l> mo930a() {
            return C3658l.class;
        }

        /* renamed from: a */
        public void m12022a(C3658l c3658l) {
            this.f9822a.setVisibility(8);
        }
    }

    public C4607k(Context context) {
        this(context, null);
    }

    public C4607k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C4607k(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12530a = new C36811(this);
        int applyDimension = (int) TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics());
        View progressBar = new ProgressBar(getContext());
        progressBar.setIndeterminate(true);
        progressBar.getIndeterminateDrawable().setColorFilter(-1, Mode.SRC_IN);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(applyDimension, applyDimension);
        layoutParams.addRule(13);
        addView(progressBar, layoutParams);
    }

    /* renamed from: a */
    protected void mo2877a() {
        super.mo2877a();
        setVisibility(0);
        if (getVideoView() != null) {
            getVideoView().getEventBus().m4805a(this.f12530a);
        }
    }

    /* renamed from: b */
    protected void mo2878b() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().m4807b(this.f12530a);
        }
        setVisibility(8);
        super.mo2878b();
    }
}
