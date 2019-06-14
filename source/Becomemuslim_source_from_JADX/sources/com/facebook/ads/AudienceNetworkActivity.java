package com.facebook.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.C0373d;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.internal.adapters.C4562k;
import com.facebook.ads.internal.adapters.C4844l;
import com.facebook.ads.internal.adapters.p086a.C1315g;
import com.facebook.ads.internal.adapters.p086a.C1321k;
import com.facebook.ads.internal.p089d.C1364b;
import com.facebook.ads.internal.p095j.C1397a;
import com.facebook.ads.internal.p095j.C1398b;
import com.facebook.ads.internal.p095j.C1400d;
import com.facebook.ads.internal.p097l.C1405a;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p098m.C3580d;
import com.facebook.ads.internal.p105q.p106a.C1496d;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.settings.C1550a.C1549a;
import com.facebook.ads.internal.view.C1566a;
import com.facebook.ads.internal.view.C1566a.C1551a;
import com.facebook.ads.internal.view.C3617b;
import com.facebook.ads.internal.view.C3638e;
import com.facebook.ads.internal.view.C3699n;
import com.facebook.ads.internal.view.C3703o;
import com.facebook.ads.internal.view.C3704u;
import com.facebook.ads.internal.view.C4619g;
import com.facebook.ads.internal.view.C4625h;
import com.facebook.ads.internal.view.p113b.C1576c;
import com.facebook.ads.internal.view.p114c.p115a.C4570f;
import com.facebook.ads.internal.view.p120f.C3640a;
import com.facebook.ads.internal.view.p120f.p122b.C1627z;
import com.facebook.stetho.server.http.HttpStatus;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AudienceNetworkActivity extends Activity {
    @Deprecated
    public static final String AD_ICON_URL = "adIconUrl";
    @Deprecated
    public static final String AD_SUBTITLE = "adSubtitle";
    @Deprecated
    public static final String AD_TITLE = "adTitle";
    public static final String AUDIENCE_NETWORK_UNIQUE_ID_EXTRA = "uniqueId";
    public static final String AUTOPLAY = "autoplay";
    public static final String BROWSER_URL = "browserURL";
    public static final String CLIENT_TOKEN = "clientToken";
    @Deprecated
    public static final String CONTEXT_SWITCH_BEHAVIOR = "contextSwitchBehavior";
    @Deprecated
    public static final String END_CARD_ACTIVATION_COMMAND = "facebookRewardedVideoEndCardActivationCommand";
    @Deprecated
    public static final String END_CARD_MARKUP = "facebookRewardedVideoEndCardMarkup";
    public static final String HANDLER_TIME = "handlerTime";
    public static final String PLACEMENT_ID = "placementId";
    public static final String PREDEFINED_ORIENTATION_KEY = "predefinedOrientationKey";
    public static final String REQUEST_TIME = "requestTime";
    public static final String REWARD_SERVER_URL = "rewardServerURL";
    public static final String SKIP_DELAY_SECONDS_KEY = "skipAfterSeconds";
    public static final String USE_CACHE = "useCache";
    public static final String VIDEO_LOGGER = "videoLogger";
    public static final String VIDEO_MPD = "videoMPD";
    @Deprecated
    public static final String VIDEO_REPORT_URL = "videoReportURL";
    public static final String VIDEO_SEEK_TIME = "videoSeekTime";
    public static final String VIDEO_URL = "videoURL";
    public static final String VIEW_TYPE = "viewType";
    @Deprecated
    public static final String WEBVIEW_ENCODING = "utf-8";
    @Deprecated
    public static final String WEBVIEW_MIME_TYPE = "text/html";
    /* renamed from: a */
    private final List<BackButtonInterceptor> f3665a = new ArrayList();
    /* renamed from: b */
    private RelativeLayout f3666b;
    /* renamed from: c */
    private int f3667c = -1;
    /* renamed from: d */
    private String f3668d;
    /* renamed from: e */
    private C1549a f3669e;
    /* renamed from: f */
    private long f3670f;
    /* renamed from: g */
    private long f3671g;
    /* renamed from: h */
    private int f3672h;
    /* renamed from: i */
    private C1566a f3673i;
    /* renamed from: j */
    private C1576c f3674j;

    public interface BackButtonInterceptor {
        boolean interceptBackButton();
    }

    public enum Type {
        INTERSTITIAL_WEB_VIEW(C1549a.INTERSTITIAL_WEB_VIEW),
        INTERSTITIAL_OLD_NATIVE_VIDEO(C1549a.INTERSTITIAL_OLD_NATIVE_VIDEO),
        INTERSTITIAL_NATIVE_VIDEO(C1549a.INTERSTITIAL_NATIVE_VIDEO),
        INTERSTITIAL_NATIVE_IMAGE(C1549a.INTERSTITIAL_NATIVE_IMAGE),
        INTERSTITIAL_NATIVE_CAROUSEL(C1549a.INTERSTITIAL_NATIVE_CAROUSEL),
        FULL_SCREEN_VIDEO(C1549a.FULL_SCREEN_VIDEO),
        REWARDED_VIDEO(C1549a.REWARDED_VIDEO),
        BROWSER(C1549a.BROWSER);
        
        /* renamed from: a */
        C1549a f3660a;

        private Type(C1549a c1549a) {
            this.f3660a = c1549a;
        }
    }

    /* renamed from: com.facebook.ads.AudienceNetworkActivity$b */
    private static class C1282b {
        /* renamed from: a */
        private final AudienceNetworkActivity f3661a;
        /* renamed from: b */
        private final Intent f3662b;
        /* renamed from: c */
        private final C1412c f3663c;

        private C1282b(AudienceNetworkActivity audienceNetworkActivity, Intent intent, C1412c c1412c) {
            this.f3661a = audienceNetworkActivity;
            this.f3662b = intent;
            this.f3663c = c1412c;
        }

        /* renamed from: a */
        private C1566a m4385a() {
            C1566a c4625h = new C4625h(this.f3661a, this.f3663c, m4403i(), m4402h() ? new C1364b(this.f3661a) : null);
            m4389a(c4625h);
            return c4625h;
        }

        /* renamed from: a */
        private C1566a m4386a(RelativeLayout relativeLayout) {
            C1566a c3704u = new C3704u(this.f3661a, this.f3663c, new C3523a());
            c3704u.m12166a((View) relativeLayout);
            c3704u.m12163a(this.f3662b.getIntExtra("video_time_polling_interval", HttpStatus.HTTP_OK));
            return c3704u;
        }

        /* renamed from: a */
        private void m4389a(C1566a c1566a) {
            c1566a.setListener(new C3523a());
        }

        /* renamed from: b */
        private C1566a m4390b() {
            C1566a a = C4562k.m15581a(this.f3662b.getStringExtra(AudienceNetworkActivity.AUDIENCE_NETWORK_UNIQUE_ID_EXTRA));
            if (a == null) {
                return null;
            }
            m4389a(a);
            return a;
        }

        /* renamed from: c */
        private C1566a m4392c() {
            return new C3617b(this.f3661a, this.f3663c, new C3523a());
        }

        /* renamed from: d */
        private C1566a m4394d() {
            C3699n c3699n;
            C1321k c1321k = (C1321k) this.f3662b.getSerializableExtra("rewardedVideoAdDataBundle");
            if (c1321k.m4563e().m4494j() != null) {
                c3699n = new C3699n(this.f3661a, this.f3663c, new C4547d(), c1321k);
            } else {
                RelativeLayout c3703o = new C3703o(this.f3661a, this.f3663c, new C3640a(this.f3661a), new C4547d(), c1321k);
            }
            return c3699n;
        }

        /* renamed from: e */
        private C1566a m4396e() {
            return new C3638e(this.f3661a, this.f3663c, new C3523a());
        }

        /* renamed from: f */
        private C1566a m4398f() {
            C1566a c4570f = new C4570f(this.f3661a, this.f3663c, m4402h() ? new C1364b(this.f3661a) : null);
            m4389a(c4570f);
            return c4570f;
        }

        /* renamed from: g */
        private C1566a m4400g() {
            C1566a c4619g = new C4619g(this.f3661a, m4403i(), this.f3663c);
            m4389a(c4619g);
            return c4619g;
        }

        /* renamed from: h */
        private boolean m4402h() {
            return this.f3662b.getBooleanExtra(AudienceNetworkActivity.USE_CACHE, false);
        }

        /* renamed from: i */
        private C1315g m4403i() {
            return (C1315g) this.f3662b.getSerializableExtra("ad_data_bundle");
        }
    }

    /* renamed from: com.facebook.ads.AudienceNetworkActivity$c */
    private class C1283c implements OnLongClickListener {
        /* renamed from: a */
        final /* synthetic */ AudienceNetworkActivity f3664a;

        private C1283c(AudienceNetworkActivity audienceNetworkActivity) {
            this.f3664a = audienceNetworkActivity;
        }

        public boolean onLongClick(View view) {
            if (!(this.f3664a.f3674j == null || this.f3664a.f3666b == null)) {
                this.f3664a.f3674j.setBounds(0, 0, this.f3664a.f3666b.getWidth(), this.f3664a.f3666b.getHeight());
                this.f3664a.f3674j.m5500a(this.f3664a.f3674j.m5501a() ^ true);
            }
            return true;
        }
    }

    /* renamed from: com.facebook.ads.AudienceNetworkActivity$a */
    private static class C3523a implements C1551a {
        /* renamed from: a */
        final WeakReference<AudienceNetworkActivity> f9362a;

        private C3523a(AudienceNetworkActivity audienceNetworkActivity) {
            this.f9362a = new WeakReference(audienceNetworkActivity);
        }

        /* renamed from: a */
        public void mo853a(View view) {
            if (this.f9362a.get() != null) {
                ((AudienceNetworkActivity) this.f9362a.get()).f3666b.addView(view);
            }
        }

        /* renamed from: a */
        public void mo854a(String str) {
            if (this.f9362a.get() != null) {
                ((AudienceNetworkActivity) this.f9362a.get()).m4410a(str);
            }
        }

        /* renamed from: a */
        public void mo855a(String str, C1400d c1400d) {
            if (this.f9362a.get() != null) {
                ((AudienceNetworkActivity) this.f9362a.get()).m4411a(str, c1400d);
            }
        }
    }

    /* renamed from: com.facebook.ads.AudienceNetworkActivity$d */
    private static class C4547d extends C3523a {
        private C4547d(AudienceNetworkActivity audienceNetworkActivity) {
            super();
        }

        /* renamed from: a */
        public void mo854a(String str) {
            if (this.a.get() != null) {
                ((AudienceNetworkActivity) this.a.get()).m4410a(str);
                String a = C1627z.REWARDED_VIDEO_END_ACTIVITY.m5610a();
                String a2 = C1627z.REWARDED_VIDEO_ERROR.m5610a();
                if (str.equals(a) || str.equals(a2)) {
                    ((AudienceNetworkActivity) this.a.get()).finish();
                }
            }
        }
    }

    /* renamed from: a */
    private C1566a m4404a() {
        C1282b c1282b = new C1282b(getIntent(), C3580d.m11662a((Context) this));
        if (this.f3669e == null) {
            return null;
        }
        switch (this.f3669e) {
            case FULL_SCREEN_VIDEO:
                return c1282b.m4386a(this.f3666b);
            case REWARDED_VIDEO:
                return c1282b.m4394d();
            case INTERSTITIAL_WEB_VIEW:
                return c1282b.m4396e();
            case BROWSER:
                return c1282b.m4392c();
            case INTERSTITIAL_OLD_NATIVE_VIDEO:
                return c1282b.m4390b();
            case INTERSTITIAL_NATIVE_VIDEO:
                return c1282b.m4385a();
            case INTERSTITIAL_NATIVE_IMAGE:
                return c1282b.m4400g();
            case INTERSTITIAL_NATIVE_CAROUSEL:
                return c1282b.m4398f();
            default:
                return null;
        }
    }

    /* renamed from: a */
    private void m4406a(Intent intent, Bundle bundle) {
        if (bundle != null) {
            this.f3667c = bundle.getInt(PREDEFINED_ORIENTATION_KEY, -1);
            this.f3668d = bundle.getString(AUDIENCE_NETWORK_UNIQUE_ID_EXTRA);
            this.f3669e = (C1549a) bundle.getSerializable(VIEW_TYPE);
            return;
        }
        this.f3667c = intent.getIntExtra(PREDEFINED_ORIENTATION_KEY, -1);
        this.f3668d = intent.getStringExtra(AUDIENCE_NETWORK_UNIQUE_ID_EXTRA);
        this.f3669e = (C1549a) intent.getSerializableExtra(VIEW_TYPE);
        this.f3672h = intent.getIntExtra(SKIP_DELAY_SECONDS_KEY, 0) * 1000;
    }

    /* renamed from: a */
    private void m4407a(Intent intent, boolean z) {
        if (C1405a.m4820b(this) && this.f3669e != C1549a.BROWSER) {
            this.f3674j = new C1576c();
            this.f3674j.m5499a(intent.getStringExtra(PLACEMENT_ID));
            this.f3674j.m5503b(getPackageName());
            long longExtra = intent.getLongExtra(REQUEST_TIME, 0);
            if (longExtra != 0) {
                this.f3674j.m5497a(longExtra);
            }
            View textView = new TextView(this);
            textView.setText("Debug");
            textView.setTextColor(-1);
            C1523w.m5342a(textView, Color.argb(160, 0, 0, 0));
            textView.setPadding(5, 5, 5, 5);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12, -1);
            layoutParams.addRule(11, -1);
            textView.setLayoutParams(layoutParams);
            OnLongClickListener c1283c = new C1283c();
            textView.setOnLongClickListener(c1283c);
            if (z) {
                this.f3666b.addView(textView);
            } else {
                this.f3666b.setOnLongClickListener(c1283c);
            }
            this.f3666b.getOverlay().add(this.f3674j);
        }
    }

    /* renamed from: a */
    private void m4410a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(":");
        stringBuilder.append(this.f3668d);
        C0373d.m1138a((Context) this).m1143a(new Intent(stringBuilder.toString()));
    }

    /* renamed from: a */
    private void m4411a(String str, C1400d c1400d) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(":");
        stringBuilder.append(this.f3668d);
        Intent intent = new Intent(stringBuilder.toString());
        intent.putExtra("event", c1400d);
        C0373d.m1138a((Context) this).m1143a(intent);
    }

    public void addBackButtonInterceptor(BackButtonInterceptor backButtonInterceptor) {
        this.f3665a.add(backButtonInterceptor);
    }

    public void finish() {
        if (!isFinishing()) {
            m4410a(this.f3669e == C1549a.REWARDED_VIDEO ? C1627z.REWARDED_VIDEO_CLOSED.m5610a() : "com.facebook.ads.interstitial.dismissed");
            super.finish();
        }
    }

    public void onBackPressed() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f3671g += currentTimeMillis - this.f3670f;
        this.f3670f = currentTimeMillis;
        if (this.f3671g > ((long) this.f3672h)) {
            Object obj = null;
            for (BackButtonInterceptor interceptBackButton : this.f3665a) {
                if (interceptBackButton.interceptBackButton()) {
                    obj = 1;
                }
            }
            if (obj == null) {
                super.onBackPressed();
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.f3673i instanceof C4844l) {
            ((C4844l) this.f3673i).m17225a(configuration);
        } else if (this.f3673i instanceof C3703o) {
            ((C3703o) this.f3673i).onConfigurationChanged(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1496d.m5270a();
        boolean z = true;
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        this.f3666b = new RelativeLayout(this);
        C1523w.m5342a(this.f3666b, -16777216);
        setContentView(this.f3666b, new RelativeLayout.LayoutParams(-1, -1));
        Intent intent = getIntent();
        m4406a(intent, bundle);
        this.f3673i = m4404a();
        if (this.f3673i == null) {
            C1398b.m4797a(C1397a.m4794a(null, "Unable to infer viewType from intent or savedInstanceState"));
            m4410a("com.facebook.ads.interstitial.error");
            finish();
            return;
        }
        this.f3673i.mo1010a(intent, bundle, this);
        m4410a("com.facebook.ads.interstitial.displayed");
        this.f3670f = System.currentTimeMillis();
        if (this.f3669e != C1549a.INTERSTITIAL_WEB_VIEW) {
            z = false;
        }
        m4407a(intent, z);
    }

    protected void onDestroy() {
        if (this.f3666b != null) {
            this.f3666b.removeAllViews();
        }
        if (this.f3673i != null) {
            C4562k.m15582a(this.f3673i);
            this.f3673i.onDestroy();
            this.f3673i = null;
        }
        if (this.f3674j != null && C1405a.m4820b(this)) {
            this.f3674j.m5502b();
        }
        super.onDestroy();
    }

    public void onPause() {
        this.f3671g += System.currentTimeMillis() - this.f3670f;
        if (this.f3673i != null) {
            this.f3673i.mo1012i();
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f3670f = System.currentTimeMillis();
        if (this.f3673i != null) {
            this.f3673i.mo1013j();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f3673i != null) {
            this.f3673i.mo1011a(bundle);
        }
        bundle.putInt(PREDEFINED_ORIENTATION_KEY, this.f3667c);
        bundle.putString(AUDIENCE_NETWORK_UNIQUE_ID_EXTRA, this.f3668d);
        bundle.putSerializable(VIEW_TYPE, this.f3669e);
    }

    public void onStart() {
        super.onStart();
        if (this.f3667c != -1) {
            setRequestedOrientation(this.f3667c);
        }
    }

    public void removeBackButtonInterceptor(BackButtonInterceptor backButtonInterceptor) {
        this.f3665a.remove(backButtonInterceptor);
    }
}
