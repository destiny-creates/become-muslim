package com.facebook.ads.internal.view;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.adapters.p086a.C1305a;
import com.facebook.ads.internal.adapters.p086a.C1312d;
import com.facebook.ads.internal.adapters.p086a.C1315g;
import com.facebook.ads.internal.adapters.p086a.C1316h;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1518r;
import com.facebook.ads.internal.p105q.p106a.C1518r.C1517a;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.C1566a.C1551a;
import com.facebook.ads.internal.view.C3686f.C1618a;

/* renamed from: com.facebook.ads.internal.view.i */
public abstract class C3692i extends RelativeLayout implements C1566a {
    /* renamed from: a */
    protected static final int f9899a = ((int) (C1523w.f4503b * 56.0f));
    /* renamed from: b */
    protected final C1412c f9900b;
    /* renamed from: c */
    protected final C3686f f9901c = new C3686f(getContext());
    /* renamed from: d */
    protected C1305a f9902d;
    /* renamed from: e */
    private C1551a f9903e;
    /* renamed from: f */
    private final C1518r f9904f = new C1518r(this);

    protected C3692i(Context context, C1412c c1412c) {
        super(context.getApplicationContext());
        this.f9900b = c1412c;
    }

    /* renamed from: a */
    private void mo2871a() {
        removeAllViews();
        C1523w.m5346b(this);
    }

    /* renamed from: a */
    protected void m12103a(View view, boolean z, int i) {
        C3686f c3686f;
        C1312d a;
        this.f9904f.m5326a(C1517a.DEFAULT);
        mo2871a();
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, z ? 0 : f9899a, 0, 0);
        addView(view, layoutParams);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, f9899a);
        layoutParams2.addRule(10);
        if (i == 1) {
            i = this.f9902d.m4463a().m4509d(z);
            c3686f = this.f9901c;
            a = this.f9902d.m4463a();
        } else {
            i = this.f9902d.m4464b().m4509d(z);
            c3686f = this.f9901c;
            a = this.f9902d.m4464b();
        }
        c3686f.m12088a(a, z);
        addView(this.f9901c, layoutParams2);
        C1523w.m5342a((View) this, i);
        if (this.f9903e != null) {
            this.f9903e.mo853a((View) this);
            if (z && VERSION.SDK_INT >= 19) {
                this.f9904f.m5326a(C1517a.FULL_SCREEN);
            }
        }
    }

    /* renamed from: a */
    public void m12104a(final AudienceNetworkActivity audienceNetworkActivity, C1315g c1315g) {
        this.f9904f.m5325a(audienceNetworkActivity.getWindow());
        this.f9902d = c1315g.m4525b();
        this.f9901c.m12089a(c1315g.m4523a(), c1315g.m4526c(), ((C1316h) c1315g.m4527d().get(0)).m4535c().m4487c());
        this.f9901c.setToolbarListener(new C1618a(this) {
            /* renamed from: b */
            final /* synthetic */ C3692i f9898b;

            /* renamed from: a */
            public void mo1062a() {
                audienceNetworkActivity.finish();
            }
        });
    }

    protected C1551a getAudienceNetworkListener() {
        return this.f9903e;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        this.f9901c.m12096d();
        super.onConfigurationChanged(configuration);
        final ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            /* renamed from: b */
            final /* synthetic */ C3692i f4963b;

            public void onGlobalLayout() {
                this.f4963b.f9901c.m12097e();
                if (VERSION.SDK_INT >= 14) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
            }
        });
    }

    public void onDestroy() {
        this.f9904f.m5324a();
        this.f9901c.setToolbarListener(null);
        mo2871a();
    }

    public void setListener(C1551a c1551a) {
        this.f9903e = c1551a;
    }
}
