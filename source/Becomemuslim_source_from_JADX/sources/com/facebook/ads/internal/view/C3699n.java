package com.facebook.ads.internal.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebSettings;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkActivity.BackButtonInterceptor;
import com.facebook.ads.internal.adapters.C1324c;
import com.facebook.ads.internal.adapters.aa;
import com.facebook.ads.internal.adapters.p086a.C1305a;
import com.facebook.ads.internal.adapters.p086a.C1320j;
import com.facebook.ads.internal.adapters.p086a.C1321k;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1502f;
import com.facebook.ads.internal.p105q.p106a.C1502f.C1501a;
import com.facebook.ads.internal.p105q.p106a.C1508k;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.p105q.p108c.C1537e;
import com.facebook.ads.internal.p105q.p108c.C1537e.C1536a;
import com.facebook.ads.internal.p105q.p108c.C1538f;
import com.facebook.ads.internal.view.C1566a.C1551a;
import com.facebook.ads.internal.view.C3686f.C1618a;
import com.facebook.ads.internal.view.component.C1599a;
import com.facebook.ads.internal.view.p113b.C3616a;
import com.facebook.ads.internal.view.p113b.C3616a.C1568b;
import com.facebook.ads.internal.view.p113b.C3616a.C1569d;
import com.facebook.ads.internal.view.p113b.C3616a.C3615c;
import com.facebook.ads.internal.view.p118d.C1607a;
import com.facebook.ads.internal.view.p120f.p122b.C1627z;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(16)
/* renamed from: com.facebook.ads.internal.view.n */
public class C3699n extends RelativeLayout implements C1501a, C1566a, C1569d {
    /* renamed from: a */
    private static final LayoutParams f9911a = new LayoutParams(-1, -1);
    /* renamed from: b */
    private final RelativeLayout f9912b;
    /* renamed from: c */
    private final C1412c f9913c;
    /* renamed from: d */
    private final C1321k f9914d;
    /* renamed from: e */
    private final C1320j f9915e;
    /* renamed from: f */
    private final C1305a f9916f;
    /* renamed from: g */
    private final C3686f f9917g;
    /* renamed from: h */
    private final C1502f f9918h;
    /* renamed from: i */
    private final C1502f f9919i;
    /* renamed from: j */
    private int f9920j;
    /* renamed from: k */
    private WeakReference<C3616a> f9921k;
    /* renamed from: l */
    private boolean f9922l = false;
    /* renamed from: m */
    private Context f9923m;
    /* renamed from: n */
    private AudienceNetworkActivity f9924n;
    /* renamed from: o */
    private C1551a f9925o;
    /* renamed from: p */
    private C1568b f9926p;
    /* renamed from: q */
    private final AtomicBoolean f9927q = new AtomicBoolean();
    /* renamed from: r */
    private Executor f9928r = AsyncTask.THREAD_POOL_EXECUTOR;
    /* renamed from: s */
    private final BackButtonInterceptor f9929s = new C36941(this);
    /* renamed from: t */
    private aa f9930t;

    /* renamed from: com.facebook.ads.internal.view.n$a */
    private static class C1669a implements OnTouchListener {
        /* renamed from: a */
        final WeakReference<C3616a> f4964a;
        /* renamed from: b */
        final C1412c f4965b;
        /* renamed from: c */
        final C1321k f4966c;

        private C1669a(C3616a c3616a, C1412c c1412c, C1321k c1321k) {
            this.f4964a = new WeakReference(c3616a);
            this.f4965b = c1412c;
            this.f4966c = c1321k;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f4964a.get() != null && motionEvent.getAction() == 1) {
                Map hashMap = new HashMap();
                ((C3616a) this.f4964a.get()).getViewabilityChecker().m5433a(hashMap);
                hashMap.put("touch", C1508k.m5306a(((C3616a) this.f4964a.get()).getTouchDataRecorder().m5335e()));
                this.f4965b.mo949d(this.f4966c.m4565g(), hashMap);
            }
            return false;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.n$b */
    private class C1670b {
        /* renamed from: a */
        final /* synthetic */ C3699n f4967a;

        private C1670b(C3699n c3699n) {
            this.f4967a = c3699n;
        }

        @JavascriptInterface
        public void onCTAClick() {
            if (this.f4967a.f9921k.get() != null) {
                C3616a c3616a = (C3616a) this.f4967a.f9921k.get();
                C1599a c1599a = new C1599a(this.f4967a.f9923m, true, false, C1627z.REWARDED_VIDEO_AD_CLICK.m5610a(), this.f4967a.f9916f.m4463a(), this.f4967a.f9913c, this.f4967a.f9925o, c3616a.getViewabilityChecker(), c3616a.getTouchDataRecorder());
                c1599a.m5582a(this.f4967a.f9914d.m4561c(), this.f4967a.f9914d.m4565g(), new HashMap());
                c1599a.performClick();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.n$1 */
    class C36941 implements BackButtonInterceptor {
        /* renamed from: a */
        final /* synthetic */ C3699n f9906a;

        C36941(C3699n c3699n) {
            this.f9906a = c3699n;
        }

        public boolean interceptBackButton() {
            return this.f9906a.f9918h.m5289d() ^ 1;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.n$2 */
    class C36952 implements C1501a {
        /* renamed from: a */
        final /* synthetic */ C3699n f9907a;

        C36952(C3699n c3699n) {
            this.f9907a = c3699n;
        }

        /* renamed from: a */
        public void mo1063a() {
            this.f9907a.m12117c();
        }

        /* renamed from: a */
        public void mo1064a(int i) {
        }
    }

    /* renamed from: com.facebook.ads.internal.view.n$3 */
    class C36963 implements C1618a {
        /* renamed from: a */
        final /* synthetic */ C3699n f9908a;

        C36963(C3699n c3699n) {
            this.f9908a = c3699n;
        }

        /* renamed from: a */
        public void mo1062a() {
            if (this.f9908a.f9925o != null) {
                this.f9908a.f9925o.mo854a(C1627z.REWARDED_VIDEO_END_ACTIVITY.m5610a());
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.n$5 */
    class C36975 extends C1324c {
        /* renamed from: a */
        final /* synthetic */ C3699n f9909a;

        C36975(C3699n c3699n) {
            this.f9909a = c3699n;
        }

        /* renamed from: a */
        public void mo929a() {
            if (this.f9909a.f9925o != null) {
                this.f9909a.f9925o.mo854a(C1627z.REWARDED_VIDEO_IMPRESSION.m5610a());
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.n$c */
    private static class C3698c implements C1536a {
        /* renamed from: a */
        final WeakReference<C1551a> f9910a;

        private C3698c(WeakReference<C1551a> weakReference) {
            this.f9910a = weakReference;
        }

        /* renamed from: a */
        public void mo1027a() {
            if (this.f9910a.get() != null) {
                ((C1551a) this.f9910a.get()).mo854a(C1627z.REWARD_SERVER_FAILED.m5610a());
            }
        }

        /* renamed from: a */
        public void mo1028a(C1538f c1538f) {
            if (this.f9910a.get() != null) {
                C1551a c1551a;
                C1627z c1627z;
                if (c1538f == null || !c1538f.m5386a()) {
                    c1551a = (C1551a) this.f9910a.get();
                    c1627z = C1627z.REWARD_SERVER_FAILED;
                } else {
                    c1551a = (C1551a) this.f9910a.get();
                    c1627z = C1627z.REWARD_SERVER_SUCCESS;
                }
                c1551a.mo854a(c1627z.m5610a());
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.n$4 */
    class C46314 extends C3615c {
        /* renamed from: a */
        final /* synthetic */ C3699n f12628a;

        C46314(C3699n c3699n) {
            this.f12628a = c3699n;
        }

        /* renamed from: a */
        public void mo1007a(WebResourceError webResourceError) {
            this.f12628a.f9922l = true;
            if (this.f12628a.f9921k.get() != null) {
                ((C3616a) this.f12628a.f9921k.get()).setVisibility(4);
            }
            if (this.f12628a.f9925o != null) {
                this.f12628a.f9925o.mo854a(C1627z.REWARDED_VIDEO_ERROR.m5610a());
            }
        }

        /* renamed from: b */
        public void mo1009b() {
            if (this.f12628a.f9927q.compareAndSet(false, true)) {
                this.f12628a.f9918h.m5286a();
                this.f12628a.f9930t.m4591a();
            }
        }
    }

    public C3699n(Context context, C1412c c1412c, C1551a c1551a, C1321k c1321k) {
        super(context);
        this.f9923m = context;
        this.f9925o = c1551a;
        this.f9913c = c1412c;
        this.f9914d = c1321k;
        this.f9915e = c1321k.m4563e().m4494j();
        this.f9916f = c1321k.m4562d();
        this.f9912b = new RelativeLayout(context);
        this.f9917g = new C3686f(context);
        this.f9918h = new C1502f(this.f9915e.m4550b(), this);
        this.f9919i = new C1502f(3, new C36952(this));
    }

    /* renamed from: a */
    private void m12112a(AudienceNetworkActivity audienceNetworkActivity) {
        this.f9920j = audienceNetworkActivity.getRequestedOrientation();
        audienceNetworkActivity.setRequestedOrientation(1);
    }

    /* renamed from: a */
    private void m12113a(C3616a c3616a) {
        if (this.f9923m != null) {
            this.f9930t = new aa(this.f9923m, this.f9913c, c3616a.getViewabilityChecker(), c3616a.getTouchDataRecorder(), new C36975(this));
            this.f9930t.m11509a(this.f9914d);
        }
    }

    /* renamed from: c */
    private void m12117c() {
        View d = m12118d();
        d.loadUrl(this.f9915e.m4549a());
        d.setOnTouchListener(new C1669a(d, this.f9913c, this.f9914d));
        d.addJavascriptInterface(new C1670b(), "FbPlayableAd");
        C1523w.m5342a(this.f9912b, this.f9916f.m4463a().m4509d(true));
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(3, this.f9917g.getId());
        d.setLayoutParams(layoutParams);
        d.setVisibility(4);
        d.setOnAssetsLoadedListener(this);
        this.f9912b.addView(this.f9917g);
        this.f9912b.addView(d);
    }

    /* renamed from: d */
    private C3616a m12118d() {
        this.f9926p = new C46314(this);
        C3616a c3616a = new C3616a(this.f9923m, new WeakReference(this.f9926p), 10);
        c3616a.setLogMultipleImpressions(false);
        c3616a.setWaitForAssetsToLoad(true);
        c3616a.setCheckAssetsByJavascriptBridge(false);
        WebSettings settings = c3616a.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        m12113a(c3616a);
        this.f9921k = new WeakReference(c3616a);
        return c3616a;
    }

    /* renamed from: e */
    private void m12121e() {
        CharSequence a = this.f9914d.m4564f().m4516a();
        if (this.f9923m != null || !TextUtils.isEmpty(a)) {
            C1537e c1537e = new C1537e(this.f9923m, new HashMap());
            c1537e.m5384a(new C3698c(new WeakReference(this.f9925o)));
            c1537e.executeOnExecutor(this.f9928r, new String[]{a});
        }
    }

    /* renamed from: f */
    private void m12123f() {
        if (this.f9925o != null) {
            this.f9925o.mo855a(C1627z.REWARDED_VIDEO_COMPLETE.m5610a(), new C3648b(0, 0));
        }
    }

    /* renamed from: a */
    public void mo1063a() {
        this.f9917g.m12091a(true);
        m12121e();
        m12123f();
    }

    /* renamed from: a */
    public void mo1064a(int i) {
        this.f9917g.setProgress((1.0f - (((float) i) / ((float) this.f9915e.m4550b()))) * 100.0f);
    }

    /* renamed from: a */
    public void mo1010a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        if (this.f9925o == null) {
            return;
        }
        if (this.f9923m != null) {
            this.f9924n = audienceNetworkActivity;
            this.f9924n.addBackButtonInterceptor(this.f9929s);
            m12112a(audienceNetworkActivity);
            this.f9917g.m12088a(this.f9916f.m4463a(), true);
            this.f9917g.setShowPageDetails(false);
            this.f9917g.m12089a(this.f9914d.m4556a(), this.f9914d.m4565g(), this.f9915e.m4550b());
            this.f9917g.setToolbarListener(new C36963(this));
            C1523w.m5341a(this.f9917g);
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.addRule(10);
            this.f9917g.setLayoutParams(layoutParams);
            View c1607a = new C1607a(this.f9923m, this.f9914d);
            this.f9912b.setLayoutParams(f9911a);
            C1523w.m5342a(this.f9912b, this.f9916f.m4463a().m4509d(true));
            this.f9912b.addView(c1607a, f9911a);
            addView(this.f9912b);
            setLayoutParams(f9911a);
            this.f9925o.mo853a((View) this);
            this.f9919i.m5286a();
        }
    }

    /* renamed from: a */
    public void mo1011a(Bundle bundle) {
    }

    /* renamed from: b */
    public void mo1065b() {
        if (!this.f9922l && this.f9921k.get() != null) {
            ((C3616a) this.f9921k.get()).setVisibility(0);
        }
    }

    /* renamed from: i */
    public void mo1012i() {
        this.f9919i.m5287b();
        this.f9918h.m5287b();
    }

    /* renamed from: j */
    public void mo1013j() {
        C1502f c1502f;
        if (!this.f9919i.m5289d()) {
            c1502f = this.f9919i;
        } else if (!this.f9918h.m5288c()) {
            c1502f = this.f9918h;
        } else {
            return;
        }
        c1502f.m5286a();
    }

    public void onDestroy() {
        this.f9919i.m5287b();
        this.f9918h.m5287b();
        this.f9917g.setToolbarListener(null);
        if (this.f9924n != null) {
            this.f9924n.removeBackButtonInterceptor(this.f9929s);
            this.f9924n.setRequestedOrientation(this.f9920j);
        }
        C3616a c3616a = (C3616a) this.f9921k.get();
        if (c3616a != null) {
            c3616a.removeJavascriptInterface("FbPlayableAd");
        }
        if (!(c3616a == null || TextUtils.isEmpty(this.f9914d.m4565g()))) {
            Map hashMap = new HashMap();
            c3616a.getViewabilityChecker().m5433a(hashMap);
            hashMap.put("touch", C1508k.m5306a(c3616a.getTouchDataRecorder().m5335e()));
            this.f9913c.mo954i(this.f9914d.m4565g(), hashMap);
        }
        this.f9925o = null;
        this.f9926p = null;
        this.f9924n = null;
        this.f9923m = null;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f9921k == null) {
            return;
        }
        if (this.f9921k.get() != null) {
            if (z) {
                mo1013j();
            } else {
                mo1012i();
            }
        }
    }

    public void setListener(C1551a c1551a) {
        this.f9925o = c1551a;
    }
}
