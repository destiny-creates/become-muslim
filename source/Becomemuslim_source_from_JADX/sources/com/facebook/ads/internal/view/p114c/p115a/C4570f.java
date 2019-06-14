package com.facebook.ads.internal.view.p114c.p115a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.C0689a;
import android.support.v7.widget.az;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.adapters.p086a.C1312d;
import com.facebook.ads.internal.adapters.p086a.C1315g;
import com.facebook.ads.internal.adapters.p086a.C1316h;
import com.facebook.ads.internal.p089d.C1364b;
import com.facebook.ads.internal.p095j.C1397a;
import com.facebook.ads.internal.p095j.C1397a.C1395a;
import com.facebook.ads.internal.p095j.C1398b;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1508k;
import com.facebook.ads.internal.p105q.p106a.C1520t;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.p111r.C1545a;
import com.facebook.ads.internal.p111r.C1545a.C1544a;
import com.facebook.ads.internal.view.C1566a.C1551a;
import com.facebook.ads.internal.view.C3692i;
import com.facebook.ads.internal.view.component.C1602d;
import com.facebook.ads.internal.view.p114c.p115a.C3622d.C1581a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.view.c.a.f */
public class C4570f extends C3692i {
    /* renamed from: e */
    private static final int f12437e = ((int) (C1523w.f4503b * 48.0f));
    /* renamed from: f */
    private static final int f12438f = ((int) (C1523w.f4503b * 8.0f));
    /* renamed from: g */
    private static final int f12439g = ((int) (C1523w.f4503b * 8.0f));
    /* renamed from: h */
    private static final int f12440h = ((int) (C1523w.f4503b * 56.0f));
    /* renamed from: i */
    private static final int f12441i = ((int) (C1523w.f4503b * 12.0f));
    /* renamed from: j */
    private final C1520t f12442j = new C1520t();
    /* renamed from: k */
    private C1364b f12443k;
    /* renamed from: l */
    private LinearLayout f12444l;
    /* renamed from: m */
    private String f12445m;
    /* renamed from: n */
    private long f12446n;
    /* renamed from: o */
    private String f12447o;
    /* renamed from: p */
    private List<C1580b> f12448p;
    /* renamed from: q */
    private C1602d f12449q;
    /* renamed from: r */
    private C4845c f12450r;
    /* renamed from: s */
    private C1545a f12451s;
    /* renamed from: t */
    private C1544a f12452t;
    /* renamed from: u */
    private int f12453u;
    /* renamed from: v */
    private int f12454v;

    /* renamed from: com.facebook.ads.internal.view.c.a.f$1 */
    class C36231 extends C1544a {
        /* renamed from: a */
        final /* synthetic */ C4570f f9689a;

        C36231(C4570f c4570f) {
            this.f9689a = c4570f;
        }

        /* renamed from: a */
        public void mo925a() {
            Map hashMap = new HashMap();
            if (!this.f9689a.f12442j.m5332b()) {
                this.f9689a.f12442j.m5330a();
                if (this.f9689a.getAudienceNetworkListener() != null) {
                    this.f9689a.getAudienceNetworkListener().mo854a("com.facebook.ads.interstitial.impression.logged");
                }
                if (!TextUtils.isEmpty(this.f9689a.f12445m)) {
                    this.f9689a.f12451s.m5433a(hashMap);
                    hashMap.put("touch", C1508k.m5306a(this.f9689a.f12442j.m5335e()));
                    this.f9689a.b.mo945a(this.f9689a.f12445m, hashMap);
                }
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c.a.f$2 */
    class C36242 implements C1581a {
        /* renamed from: a */
        final /* synthetic */ C4570f f9690a;

        C36242(C4570f c4570f) {
            this.f9690a = c4570f;
        }

        /* renamed from: a */
        public void mo1021a(int i) {
            if (this.f9690a.f12449q != null) {
                this.f9690a.f12449q.m5585a(i);
            }
        }
    }

    public C4570f(Context context, C1412c c1412c, C1364b c1364b) {
        super(context, c1412c);
        this.f12443k = c1364b;
    }

    /* renamed from: a */
    private void m15758a(C1315g c1315g) {
        this.f12445m = c1315g.m4526c();
        this.f12447o = c1315g.m4528e();
        this.f12453u = c1315g.m4529f();
        this.f12454v = c1315g.m4530g();
        List d = c1315g.m4527d();
        this.f12448p = new ArrayList(d.size());
        for (int i = 0; i < d.size(); i++) {
            this.f12448p.add(new C1580b(i, d.size(), (C1316h) d.get(i)));
        }
    }

    /* renamed from: a */
    private void m15759a(C3621a c3621a) {
        new az().m10539a(this.f12450r);
        c3621a.m11837a(new C36242(this));
        this.f12449q = new C1602d(getContext(), this.d.m4463a(), this.f12448p.size());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, f12439g);
        layoutParams.setMargins(0, f12441i, 0, 0);
        this.f12449q.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    public void mo2871a() {
        if (this.f12444l != null) {
            this.f12444l.removeAllViews();
            this.f12444l = null;
        }
        if (this.f12450r != null) {
            this.f12450r.removeAllViews();
            this.f12450r = null;
        }
        if (this.f12449q != null) {
            this.f12449q.removeAllViews();
            this.f12449q = null;
        }
    }

    /* renamed from: a */
    public void mo1010a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        C1315g c1315g = (C1315g) intent.getSerializableExtra("ad_data_bundle");
        super.m12104a(audienceNetworkActivity, c1315g);
        m15758a(c1315g);
        setUpLayout(audienceNetworkActivity.getResources().getConfiguration().orientation);
        this.f12446n = System.currentTimeMillis();
    }

    /* renamed from: a */
    public void mo1011a(Bundle bundle) {
    }

    /* renamed from: i */
    public void mo1012i() {
    }

    /* renamed from: j */
    public void mo1013j() {
    }

    public void onConfigurationChanged(Configuration configuration) {
        mo2871a();
        setUpLayout(configuration.orientation);
        super.onConfigurationChanged(configuration);
    }

    public void onDestroy() {
        super.onDestroy();
        C1398b.m4797a(C1397a.m4792a(this.f12446n, C1395a.XOUT, this.f12447o));
        if (!TextUtils.isEmpty(this.f12445m)) {
            Map hashMap = new HashMap();
            this.f12451s.m5433a(hashMap);
            hashMap.put("touch", C1508k.m5306a(this.f12442j.m5335e()));
            this.b.mo954i(this.f12445m, hashMap);
        }
        mo2871a();
        this.f12451s.m5436c();
        this.f12451s = null;
        this.f12452t = null;
        this.f12448p = null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f12442j.m5331a(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setUpLayout(int i) {
        LinearLayout linearLayout;
        int i2;
        int i3;
        C4570f c4570f;
        int i4 = i;
        this.f12444l = new LinearLayout(getContext());
        if (i4 == 1) {
            linearLayout = r0.f12444l;
            i2 = 17;
        } else {
            linearLayout = r0.f12444l;
            i2 = 48;
        }
        linearLayout.setGravity(i2);
        r0.f12444l.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        r0.f12444l.setOrientation(1);
        int i5 = C1523w.f4502a.widthPixels;
        i2 = C1523w.f4502a.heightPixels;
        if (i4 == 1) {
            i2 = Math.min(i5 - (f12438f * 4), i2 / 2);
            i5 = (i5 - i2) / 8;
            i3 = i5 * 4;
        } else {
            i2 -= (f12440h + f12437e) + (f12438f * 2);
            i5 = f12438f;
            i3 = i5 * 2;
        }
        int i6 = i5;
        int i7 = i2;
        int i8 = i3;
        r0.f12452t = new C36231(r0);
        r0.f12451s = new C1545a(r0, 1, r0.f12452t);
        r0.f12451s.m5432a(r0.f12453u);
        r0.f12451s.m5434b(r0.f12454v);
        r0.f12450r = new C4845c(getContext());
        r0.f12450r.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        C3621a c3621a = new C3621a(r0.f12450r, i4, r0.f12448p, r0.f12451s);
        C4845c c4845c = r0.f12450r;
        List list = r0.f12448p;
        C1412c c1412c = r0.b;
        C1364b c1364b = r0.f12443k;
        C1545a c1545a = r0.f12451s;
        C1520t c1520t = r0.f12442j;
        C1551a audienceNetworkListener = getAudienceNetworkListener();
        C1312d a = i4 == 1 ? r0.d.m4463a() : r0.d.m4464b();
        C0689a c0689a = r1;
        C4845c c4845c2 = c4845c;
        C3621a c3621a2 = c3621a;
        C0689a c3622d = new C3622d(list, c1412c, c1364b, c1545a, c1520t, audienceNetworkListener, a, r0.f12445m, i7, i6, i8, i, c3621a2);
        c4845c2.setAdapter(c0689a);
        int i9 = i;
        if (i9 == 1) {
            m15759a(c3621a2);
        } else {
            c4570f = this;
        }
        c4570f.f12444l.addView(c4570f.f12450r);
        if (c4570f.f12449q != null) {
            c4570f.f12444l.addView(c4570f.f12449q);
        }
        c4570f.m12103a(c4570f.f12444l, false, i9);
    }
}
