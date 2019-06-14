package com.facebook.ads.internal.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.adapters.p086a.C1315g;
import com.facebook.ads.internal.adapters.p086a.C1316h;
import com.facebook.ads.internal.p095j.C1397a;
import com.facebook.ads.internal.p095j.C1397a.C1395a;
import com.facebook.ads.internal.p095j.C1398b;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1508k;
import com.facebook.ads.internal.p105q.p106a.C1520t;
import com.facebook.ads.internal.p111r.C1545a;
import com.facebook.ads.internal.p111r.C1545a.C1544a;
import com.facebook.ads.internal.view.component.p116a.C1594c;
import com.facebook.ads.internal.view.component.p116a.C1597d.C1596a;
import com.facebook.ads.internal.view.p113b.C1577d;
import com.facebook.ads.internal.view.p113b.C1578e;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.view.g */
public class C4619g extends C3692i {
    /* renamed from: e */
    private final C1315g f12570e;
    /* renamed from: f */
    private final C1545a f12571f;
    /* renamed from: g */
    private final C1520t f12572g = new C1520t();
    /* renamed from: h */
    private final C1544a f12573h;
    /* renamed from: i */
    private long f12574i;

    /* renamed from: com.facebook.ads.internal.view.g$1 */
    class C36871 extends C1544a {
        /* renamed from: a */
        final /* synthetic */ C4619g f9893a;

        C36871(C4619g c4619g) {
            this.f9893a = c4619g;
        }

        /* renamed from: a */
        public void mo925a() {
            if (!this.f9893a.f12572g.m5332b()) {
                this.f9893a.f12572g.m5330a();
                Map hashMap = new HashMap();
                this.f9893a.f12571f.m5433a(hashMap);
                hashMap.put("touch", C1508k.m5306a(this.f9893a.f12572g.m5335e()));
                this.f9893a.b.mo945a(this.f9893a.f12570e.m4526c(), hashMap);
                if (this.f9893a.getAudienceNetworkListener() != null) {
                    this.f9893a.getAudienceNetworkListener().mo854a("com.facebook.ads.interstitial.impression.logged");
                }
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.g$2 */
    class C36882 implements C1578e {
        /* renamed from: a */
        final /* synthetic */ C4619g f9894a;

        C36882(C4619g c4619g) {
            this.f9894a = c4619g;
        }

        /* renamed from: a */
        public void mo841a(boolean z) {
            if (z) {
                this.f9894a.f12571f.m5431a();
            }
        }
    }

    public C4619g(Context context, C1315g c1315g, C1412c c1412c) {
        super(context, c1412c);
        this.f12570e = c1315g;
        this.f12573h = new C36871(this);
        this.f12571f = new C1545a(this, 100, this.f12573h);
        this.f12571f.m5432a(c1315g.m4529f());
    }

    private void setUpContent(int i) {
        C1316h c1316h = (C1316h) this.f12570e.m4527d().get(0);
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ScaleType.CENTER);
        imageView.setAdjustViewBounds(true);
        C1577d a = new C1577d(imageView).m5505a(c1316h.m4535c().m4493i(), c1316h.m4535c().m4492h());
        a.m5506a(new C36882(this));
        a.m5508a(c1316h.m4535c().m4491g());
        View a2 = C1594c.m5543a(new C1596a(getContext(), this.b, getAudienceNetworkListener(), this.f12570e, imageView, this.f12571f, this.f12572g).m5559a(a).m5563b(i).m5562a());
        m12103a(a2, a2.mo1023a(), i);
    }

    /* renamed from: a */
    public void mo1010a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        super.m12104a(audienceNetworkActivity, this.f12570e);
        setUpContent(audienceNetworkActivity.getResources().getConfiguration().orientation);
        this.f12574i = System.currentTimeMillis();
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
        removeAllViews();
        setUpContent(configuration.orientation);
        super.onConfigurationChanged(configuration);
    }

    public void onDestroy() {
        if (this.f12570e != null) {
            C1398b.m4797a(C1397a.m4792a(this.f12574i, C1395a.XOUT, this.f12570e.m4528e()));
            if (!TextUtils.isEmpty(this.f12570e.m4526c())) {
                Map hashMap = new HashMap();
                this.f12571f.m5433a(hashMap);
                hashMap.put("touch", C1508k.m5306a(this.f12572g.m5335e()));
                this.b.mo954i(this.f12570e.m4526c(), hashMap);
            }
        }
        this.f12571f.m5436c();
        super.onDestroy();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f12572g.m5331a(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }
}
