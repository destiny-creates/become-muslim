package com.facebook.ads.internal.p099n;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.internal.DisplayAdController;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.C1322a;
import com.facebook.ads.internal.adapters.C1324c;
import com.facebook.ads.internal.adapters.C1346z;
import com.facebook.ads.internal.adapters.C3571x;
import com.facebook.ads.internal.adapters.C3571x.C1345a;
import com.facebook.ads.internal.adapters.C3572y;
import com.facebook.ads.internal.adapters.C4563m;
import com.facebook.ads.internal.p089d.C1359a;
import com.facebook.ads.internal.p089d.C1364b;
import com.facebook.ads.internal.p093h.C1389d;
import com.facebook.ads.internal.p095j.C1397a;
import com.facebook.ads.internal.p095j.C1397a.C1396b;
import com.facebook.ads.internal.p095j.C1398b;
import com.facebook.ads.internal.p097l.C1405a;
import com.facebook.ads.internal.p105q.p106a.C1508k;
import com.facebook.ads.internal.p105q.p106a.C1520t;
import com.facebook.ads.internal.p111r.C1545a;
import com.facebook.ads.internal.p111r.C1545a.C1544a;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.protocol.C1481a;
import com.facebook.ads.internal.protocol.C1485d;
import com.facebook.ads.internal.protocol.C1487f;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.view.C1679v;
import com.facebook.ads.internal.view.C1680w;
import com.facebook.ads.internal.view.p113b.C1576c;
import com.facebook.ads.internal.view.p113b.C1577d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;

/* renamed from: com.facebook.ads.internal.n.f */
public class C1425f {
    /* renamed from: b */
    private static final C1485d f4183b = C1485d.ADS;
    /* renamed from: c */
    private static final String f4184c = C1425f.class.getSimpleName();
    /* renamed from: d */
    private static WeakHashMap<View, WeakReference<C1425f>> f4185d = new WeakHashMap();
    /* renamed from: A */
    private boolean f4186A;
    /* renamed from: B */
    private boolean f4187B;
    /* renamed from: C */
    private boolean f4188C;
    /* renamed from: D */
    private long f4189D;
    /* renamed from: E */
    private C1576c f4190E;
    /* renamed from: F */
    private C1422e f4191F;
    /* renamed from: G */
    private C1345a f4192G;
    /* renamed from: H */
    private View f4193H;
    /* renamed from: a */
    protected C3572y f4194a;
    /* renamed from: e */
    private final Context f4195e;
    /* renamed from: f */
    private final String f4196f;
    /* renamed from: g */
    private final String f4197g;
    /* renamed from: h */
    private final C1364b f4198h;
    /* renamed from: i */
    private C3591i f4199i;
    /* renamed from: j */
    private final C1424c f4200j;
    /* renamed from: k */
    private DisplayAdController f4201k;
    /* renamed from: l */
    private volatile boolean f4202l;
    /* renamed from: m */
    private C1389d f4203m;
    /* renamed from: n */
    private C1487f f4204n;
    /* renamed from: o */
    private View f4205o;
    /* renamed from: p */
    private final List<View> f4206p;
    /* renamed from: q */
    private OnTouchListener f4207q;
    /* renamed from: r */
    private C1545a f4208r;
    /* renamed from: s */
    private C1544a f4209s;
    /* renamed from: t */
    private WeakReference<C1544a> f4210t;
    /* renamed from: u */
    private final C1520t f4211u;
    /* renamed from: v */
    private C3571x f4212v;
    /* renamed from: w */
    private C1423a f4213w;
    /* renamed from: x */
    private C1680w f4214x;
    /* renamed from: y */
    private C1430l f4215y;
    /* renamed from: z */
    private boolean f4216z;

    /* renamed from: com.facebook.ads.internal.n.f$a */
    private class C1423a implements OnClickListener, OnLongClickListener, OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ C1425f f4182a;

        private C1423a(C1425f c1425f) {
            this.f4182a = c1425f;
        }

        public void onClick(View view) {
            if (!this.f4182a.f4211u.m5334d()) {
                Log.e("FBAudienceNetworkLog", "No touch data recorded, please ensure touch events reach the ad View by returning false if you intercept the event.");
            }
            int q = C1405a.m4836q(this.f4182a.f4195e);
            if (q < 0 || this.f4182a.f4211u.m5333c() >= ((long) q)) {
                Map hashMap = new HashMap();
                hashMap.put("touch", C1508k.m5306a(this.f4182a.f4211u.m5335e()));
                if (this.f4182a.f4215y != null) {
                    hashMap.put("nti", String.valueOf(this.f4182a.f4215y.m5050c()));
                }
                if (this.f4182a.f4216z) {
                    hashMap.put("nhs", String.valueOf(this.f4182a.f4216z));
                }
                this.f4182a.f4208r.m5433a(hashMap);
                if (this.f4182a.f4194a != null) {
                    this.f4182a.f4194a.mo2831b(hashMap);
                }
                return;
            }
            String str;
            String str2;
            if (this.f4182a.f4211u.m5332b()) {
                str = "FBAudienceNetworkLog";
                str2 = "Clicks happened too fast.";
            } else {
                str = "FBAudienceNetworkLog";
                str2 = "Ad cannot be clicked before it is viewed.";
            }
            Log.e(str, str2);
        }

        public boolean onLongClick(View view) {
            if (this.f4182a.f4205o != null) {
                if (this.f4182a.f4190E != null) {
                    this.f4182a.f4190E.setBounds(0, 0, this.f4182a.f4205o.getWidth(), this.f4182a.f4205o.getHeight());
                    this.f4182a.f4190E.m5500a(this.f4182a.f4190E.m5501a() ^ true);
                    return true;
                }
            }
            return false;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f4182a.f4211u.m5331a(motionEvent, this.f4182a.f4205o, view);
            return this.f4182a.f4207q != null && this.f4182a.f4207q.onTouch(view, motionEvent);
        }
    }

    /* renamed from: com.facebook.ads.internal.n.f$c */
    public interface C1424c {
        /* renamed from: a */
        boolean mo878a(View view);
    }

    /* renamed from: com.facebook.ads.internal.n.f$1 */
    class C35861 extends C1322a {
        /* renamed from: a */
        final /* synthetic */ C1425f f9591a;

        /* renamed from: com.facebook.ads.internal.n.f$1$1 */
        class C35851 implements C1346z {
            /* renamed from: a */
            final /* synthetic */ C35861 f9590a;

            C35851(C35861 c35861) {
                this.f9590a = c35861;
            }

            /* renamed from: a */
            public void mo897a(C3572y c3572y) {
            }

            /* renamed from: a */
            public void mo898a(C3572y c3572y, C1481a c1481a) {
            }

            /* renamed from: b */
            public void mo899b(C3572y c3572y) {
            }

            /* renamed from: c */
            public void mo900c(C3572y c3572y) {
                if (this.f9590a.f9591a.f4199i != null) {
                    this.f9590a.f9591a.f4199i.mo2813c();
                }
            }
        }

        C35861(C1425f c1425f) {
            this.f9591a = c1425f;
        }

        /* renamed from: a */
        public void mo843a() {
            if (this.f9591a.f4199i != null) {
                this.f9591a.f4199i.mo2813c();
            }
        }

        /* renamed from: a */
        public void mo845a(AdAdapter adAdapter) {
            if (this.f9591a.f4201k != null) {
                this.f9591a.f4201k.m11482b();
            }
        }

        /* renamed from: a */
        public void mo963a(C3572y c3572y) {
            C1398b.m4797a(C1397a.m4793a(C1396b.LOADING_AD, this.f9591a.m4937K().toString(), System.currentTimeMillis() - this.f9591a.f4189D, null));
            this.f9591a.m4947a(c3572y, true);
            if (this.f9591a.f4199i != null && c3572y.mo2821F() != null) {
                C1346z c35851 = new C35851(this);
                for (C1425f a : c3572y.mo2821F()) {
                    a.m4985a(c35851);
                }
            }
        }

        /* renamed from: a */
        public void mo846a(C1481a c1481a) {
            if (this.f9591a.f4199i != null) {
                this.f9591a.f4199i.mo2811a(c1481a);
            }
        }

        /* renamed from: b */
        public void mo847b() {
            throw new IllegalStateException("Native ads manager their own impressions.");
        }
    }

    /* renamed from: com.facebook.ads.internal.n.f$3 */
    class C35883 implements C1679v {
        /* renamed from: a */
        final /* synthetic */ C1425f f9595a;

        C35883(C1425f c1425f) {
            this.f9595a = c1425f;
        }

        /* renamed from: a */
        public void mo964a(int i) {
            if (this.f9595a.f4194a != null) {
                this.f9595a.f4194a.mo2826a(i);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.n.f$4 */
    class C35894 extends C1544a {
        /* renamed from: a */
        final /* synthetic */ C1425f f9596a;

        C35894(C1425f c1425f) {
            this.f9596a = c1425f;
        }

        /* renamed from: a */
        public void mo925a() {
            if (!this.f9596a.f4211u.m5332b()) {
                this.f9596a.f4211u.m5330a();
                this.f9596a.f4208r.m5436c();
                if (!(this.f9596a.f4210t == null || this.f9596a.f4210t.get() == null)) {
                    ((C1544a) this.f9596a.f4210t.get()).mo925a();
                }
                if (this.f9596a.f4212v == null) {
                    return;
                }
                if (this.f9596a.f4205o != null) {
                    this.f9596a.f4212v.m11583a(this.f9596a.f4205o);
                    this.f9596a.f4212v.m11585a(this.f9596a.f4215y);
                    this.f9596a.f4212v.m11588a(this.f9596a.f4216z);
                    this.f9596a.f4212v.m11589b(this.f9596a.f4186A);
                    this.f9596a.f4212v.m11591d(this.f9596a.f4187B);
                    this.f9596a.f4212v.m11590c(this.f9596a.m4943Q());
                    this.f9596a.f4212v.m11584a(this.f9596a.f4192G);
                    this.f9596a.f4212v.m11592e(this.f9596a.f4188C);
                    this.f9596a.f4212v.m4591a();
                }
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.n.f$b */
    private class C3590b extends C1324c {
        /* renamed from: a */
        final /* synthetic */ C1425f f9597a;

        private C3590b(C1425f c1425f) {
            this.f9597a = c1425f;
        }

        /* renamed from: a */
        public void mo929a() {
            if (this.f9597a.f4199i != null) {
                this.f9597a.f4199i.mo2814d();
            }
        }

        /* renamed from: b */
        public void mo965b() {
        }
    }

    public C1425f(Context context, C3572y c3572y, C1389d c1389d, C1424c c1424c) {
        this(context, null, c1424c);
        this.f4194a = c3572y;
        this.f4203m = c1389d;
        this.f4202l = true;
        this.f4193H = new View(context);
    }

    public C1425f(Context context, String str, C1424c c1424c) {
        this.f4197g = UUID.randomUUID().toString();
        this.f4204n = C1487f.NATIVE_UNKNOWN;
        this.f4206p = new ArrayList();
        this.f4211u = new C1520t();
        this.f4186A = false;
        this.f4187B = false;
        this.f4191F = C1422e.ALL;
        this.f4192G = C1345a.ALL;
        this.f4195e = context;
        this.f4196f = str;
        this.f4200j = c1424c;
        this.f4198h = new C1364b(context);
        this.f4193H = new View(context);
    }

    public C1425f(C1425f c1425f) {
        this(c1425f.f4195e, null, c1425f.f4200j);
        this.f4203m = c1425f.f4203m;
        this.f4194a = c1425f.f4194a;
        this.f4202l = true;
        this.f4193H = new View(this.f4195e);
    }

    /* renamed from: K */
    private AdPlacementType m4937K() {
        return this.f4204n == C1487f.NATIVE_UNKNOWN ? AdPlacementType.NATIVE : AdPlacementType.NATIVE_BANNER;
    }

    /* renamed from: L */
    private boolean m4938L() {
        return this.f4194a != null && ((C4563m) this.f4194a).m15606L();
    }

    /* renamed from: M */
    private int m4939M() {
        C1389d c1389d;
        if (this.f4203m != null) {
            c1389d = this.f4203m;
        } else if (this.f4201k == null || this.f4201k.m11474a() == null) {
            return 1;
        } else {
            c1389d = this.f4201k.m11474a();
        }
        return c1389d.m4771f();
    }

    /* renamed from: N */
    private int m4940N() {
        C1389d c1389d;
        if (this.f4203m != null) {
            c1389d = this.f4203m;
        } else if (this.f4201k == null || this.f4201k.m11474a() == null) {
            return 0;
        } else {
            c1389d = this.f4201k.m11474a();
        }
        return c1389d.m4772g();
    }

    /* renamed from: O */
    private int m4941O() {
        return this.f4203m != null ? this.f4203m.m4773h() : this.f4194a != null ? this.f4194a.mo2840i() : (this.f4201k == null || this.f4201k.m11474a() == null) ? 0 : this.f4201k.m11474a().m4773h();
    }

    /* renamed from: P */
    private int m4942P() {
        return this.f4203m != null ? this.f4203m.m4774i() : this.f4194a != null ? this.f4194a.mo2841j() : (this.f4201k == null || this.f4201k.m11474a() == null) ? 1000 : this.f4201k.m11474a().m4774i();
    }

    /* renamed from: Q */
    private boolean m4943Q() {
        return m4975E() == C1431m.ON;
    }

    /* renamed from: R */
    private void m4944R() {
        for (View view : this.f4206p) {
            view.setOnClickListener(null);
            view.setOnTouchListener(null);
            view.setOnLongClickListener(null);
        }
        this.f4206p.clear();
    }

    /* renamed from: a */
    private void m4946a(View view) {
        this.f4206p.add(view);
        view.setOnClickListener(this.f4213w);
        view.setOnTouchListener(this.f4213w);
        if (C1405a.m4820b(view.getContext())) {
            view.setOnLongClickListener(this.f4213w);
        }
    }

    /* renamed from: a */
    private void m4947a(final C3572y c3572y, final boolean z) {
        if (c3572y != null) {
            if (this.f4191F.equals(C1422e.ALL)) {
                if (c3572y.mo2842k() != null) {
                    this.f4198h.m4659a(c3572y.mo2842k().m5022a(), c3572y.mo2842k().m5024c(), c3572y.mo2842k().m5023b());
                }
                if (c3572y.mo2843l() != null) {
                    this.f4198h.m4659a(c3572y.mo2843l().m5022a(), c3572y.mo2843l().m5024c(), c3572y.mo2843l().m5023b());
                }
                if (c3572y.mo2821F() != null) {
                    for (C1425f c1425f : c3572y.mo2821F()) {
                        if (c1425f.m5005k() != null) {
                            this.f4198h.m4659a(c1425f.m5005k().m5022a(), c1425f.m5005k().m5024c(), c1425f.m5005k().m5023b());
                        }
                    }
                }
                if (!TextUtils.isEmpty(c3572y.mo2816A())) {
                    this.f4198h.m4658a(c3572y.mo2816A());
                }
            }
            this.f4198h.m4657a(new C1359a(this) {
                /* renamed from: c */
                final /* synthetic */ C1425f f9594c;

                /* renamed from: a */
                public void mo882a() {
                    this.f9594c.f4194a = c3572y;
                    if (this.f9594c.f4199i != null) {
                        if (this.f9594c.f4191F.equals(C1422e.ALL) && !this.f9594c.m4938L()) {
                            this.f9594c.f4199i.mo2810a();
                        }
                        if (z) {
                            this.f9594c.f4199i.mo2812b();
                        }
                    }
                }

                /* renamed from: b */
                public void mo883b() {
                    if (this.f9594c.f4194a != null) {
                        this.f9594c.f4194a.b_();
                        this.f9594c.f4194a = null;
                    }
                    if (this.f9594c.f4199i != null) {
                        this.f9594c.f4199i.mo2811a(C1481a.m5241a(AdErrorType.CACHE_FAILURE_ERROR, "Failed to download a media."));
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m4949a(C1427h c1427h, ImageView imageView) {
        if (c1427h != null && imageView != null) {
            new C1577d(imageView).m5505a(c1427h.m5024c(), c1427h.m5023b()).m5508a(c1427h.m5022a());
        }
    }

    /* renamed from: a */
    private void m4950a(List<View> list, View view) {
        if (this.f4200j == null || !this.f4200j.mo878a(view)) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    m4950a((List) list, viewGroup.getChildAt(i));
                }
            } else {
                list.add(view);
            }
        }
    }

    /* renamed from: A */
    public String m4971A() {
        return !m5001g() ? null : this.f4194a.mo2858z();
    }

    /* renamed from: B */
    public String m4972B() {
        if (m5001g()) {
            if (!TextUtils.isEmpty(this.f4194a.mo2816A())) {
                return this.f4198h.m4660b(this.f4194a.mo2816A());
            }
        }
        return null;
    }

    /* renamed from: C */
    public String m4973C() {
        return !m5001g() ? null : this.f4194a.mo2817B();
    }

    /* renamed from: D */
    public String m4974D() {
        return !m5001g() ? null : this.f4194a.mo2820E();
    }

    /* renamed from: E */
    public C1431m m4975E() {
        return !m5001g() ? C1431m.DEFAULT : this.f4194a.mo2818C();
    }

    /* renamed from: F */
    public List<C1425f> m4976F() {
        return !m5001g() ? null : this.f4194a.mo2821F();
    }

    /* renamed from: G */
    public String m4977G() {
        return !m5001g() ? null : this.f4194a.mo2833c();
    }

    /* renamed from: H */
    public void m4978H() {
        this.f4193H.performClick();
    }

    /* renamed from: I */
    public C1430l m4979I() {
        return this.f4215y;
    }

    /* renamed from: J */
    public void m4980J() {
        if (this.f4205o != null) {
            if (f4185d.containsKey(this.f4205o) && ((WeakReference) f4185d.get(this.f4205o)).get() == this) {
                if ((this.f4205o instanceof ViewGroup) && this.f4214x != null) {
                    ((ViewGroup) this.f4205o).removeView(this.f4214x);
                    this.f4214x = null;
                }
                if (this.f4194a != null) {
                    this.f4194a.b_();
                }
                if (this.f4190E != null && C1405a.m4820b(this.f4195e)) {
                    this.f4190E.m5502b();
                    this.f4205o.getOverlay().remove(this.f4190E);
                }
                f4185d.remove(this.f4205o);
                m4944R();
                this.f4205o = null;
                if (this.f4208r != null) {
                    this.f4208r.m5436c();
                    this.f4208r = null;
                }
                this.f4212v = null;
                return;
            }
            throw new IllegalStateException("View not registered with this NativeAd");
        }
    }

    /* renamed from: a */
    public C3572y m4981a() {
        return this.f4194a;
    }

    /* renamed from: a */
    public void m4982a(OnTouchListener onTouchListener) {
        this.f4207q = onTouchListener;
    }

    /* renamed from: a */
    public void m4983a(View view, C1426g c1426g) {
        List arrayList = new ArrayList();
        m4950a(arrayList, view);
        m4984a(view, c1426g, arrayList);
    }

    /* renamed from: a */
    public void m4984a(View view, C1426g c1426g, List<View> list) {
        if (view == null) {
            throw new IllegalArgumentException("Must provide a View");
        } else if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("Invalid set of clickable views");
        } else if (!m5001g()) {
            Log.e(f4184c, "Ad not loaded");
        } else if (c1426g == null) {
            String str;
            String str2;
            if (this.f4204n == C1487f.NATIVE_UNKNOWN) {
                if (this.f4199i != null) {
                    this.f4199i.mo2811a(new C1481a(AdErrorType.NO_MEDIAVIEW_IN_NATIVEAD, "MediaView is missing."));
                }
                if (AdInternalSettings.isDebugBuild()) {
                    str = f4184c;
                    str2 = "MediaView is missing.";
                }
            }
            if (this.f4199i != null) {
                this.f4199i.mo2811a(new C1481a(AdErrorType.NO_ICONVIEW_IN_NATIVEBANNERAD, "AdIconView is missing."));
            }
            if (AdInternalSettings.isDebugBuild()) {
                str = f4184c;
                str2 = "AdIconView is missing.";
            }
            Log.e(str, str2);
        } else if (c1426g.getAdContentsView() == null) {
            if (this.f4199i != null) {
                this.f4199i.mo2811a(new C1481a(AdErrorType.UNSUPPORTED_AD_ASSET_NATIVEAD, "ad media type is not supported."));
            }
        } else {
            if (this.f4205o != null) {
                Log.w(f4184c, "Native Ad was already registered with a View. Auto unregistering and proceeding.");
                m4980J();
            }
            if (f4185d.containsKey(view) && ((WeakReference) f4185d.get(view)).get() != null) {
                Log.w(f4184c, "View already registered with a NativeAd. Auto unregistering and proceeding.");
                ((C1425f) ((WeakReference) f4185d.get(view)).get()).m4980J();
            }
            this.f4213w = new C1423a();
            this.f4205o = view;
            if (view instanceof ViewGroup) {
                this.f4214x = new C1680w(view.getContext(), new C35883(this));
                ((ViewGroup) view).addView(this.f4214x);
            }
            List<View> arrayList = new ArrayList(list);
            if (this.f4193H != null) {
                arrayList.add(this.f4193H);
            }
            for (View a : arrayList) {
                m4946a(a);
            }
            this.f4194a.mo2828a(view, arrayList);
            int M = m4939M();
            this.f4209s = new C35894(this);
            this.f4208r = new C1545a(c1426g != null ? c1426g.getAdContentsView() : this.f4205o, M, m4940N(), true, this.f4209s);
            this.f4208r.m5432a(m4941O());
            this.f4208r.m5434b(m4942P());
            this.f4212v = new C3571x(this.f4195e, new C3590b(), this.f4208r, this.f4194a);
            this.f4212v.m11586a((List) arrayList);
            f4185d.put(view, new WeakReference(this));
            if (C1405a.m4820b(this.f4195e)) {
                C1576c c1576c;
                C1389d c1389d;
                this.f4190E = new C1576c();
                this.f4190E.m5499a(this.f4196f);
                this.f4190E.m5503b(this.f4195e.getPackageName());
                this.f4190E.m5498a(this.f4208r);
                if (this.f4194a.mo2823H() > 0) {
                    this.f4190E.m5496a(this.f4194a.mo2823H(), this.f4194a.mo2822G());
                }
                if (this.f4203m != null) {
                    c1576c = this.f4190E;
                    c1389d = this.f4203m;
                } else {
                    if (!(this.f4201k == null || this.f4201k.m11474a() == null)) {
                        c1576c = this.f4190E;
                        c1389d = this.f4201k.m11474a();
                    }
                    this.f4205o.getOverlay().add(this.f4190E);
                }
                c1576c.m5497a(c1389d.m4766a());
                this.f4205o.getOverlay().add(this.f4190E);
            }
        }
    }

    /* renamed from: a */
    public void m4985a(C1346z c1346z) {
        if (this.f4194a != null) {
            this.f4194a.mo2829a(c1346z);
        }
    }

    /* renamed from: a */
    public void m4986a(C1422e c1422e, String str) {
        if (this.f4202l) {
            throw new IllegalStateException("loadAd cannot be called more than once");
        }
        this.f4189D = System.currentTimeMillis();
        this.f4202l = true;
        this.f4191F = c1422e;
        if (c1422e.equals(C1422e.NONE)) {
            this.f4192G = C1345a.NONE;
        }
        this.f4201k = new DisplayAdController(this.f4195e, this.f4196f, this.f4204n, m4937K(), null, f4183b, 1, true);
        this.f4201k.m11477a(new C35861(this));
        this.f4201k.m11480a(str);
    }

    /* renamed from: a */
    public void m4987a(C3591i c3591i) {
        this.f4199i = c3591i;
    }

    /* renamed from: a */
    public void m4988a(C1430l c1430l) {
        this.f4215y = c1430l;
    }

    /* renamed from: a */
    public void m4989a(C1487f c1487f) {
        this.f4204n = c1487f;
    }

    /* renamed from: a */
    public void m4990a(C1544a c1544a) {
        this.f4210t = new WeakReference(c1544a);
    }

    /* renamed from: a */
    public void m4991a(boolean z) {
        this.f4216z = z;
    }

    /* renamed from: a */
    public void m4992a(boolean z, boolean z2) {
        if (z) {
            if (!(!this.f4191F.equals(C1422e.NONE) || m4938L() || this.f4199i == null)) {
                this.f4199i.mo2810a();
            }
            if (this.f4208r != null) {
                this.f4208r.m5431a();
                return;
            }
            return;
        }
        if (this.f4208r != null) {
            this.f4208r.m5436c();
        }
        if (this.f4199i != null && z2) {
            this.f4199i.mo2811a(C1481a.m5241a(AdErrorType.BROKEN_MEDIA_ERROR, "Failed to load Media."));
        }
    }

    /* renamed from: b */
    public C1418c m4993b() {
        return (!m5001g() || this.f4194a == null) ? null : this.f4194a.mo2824I();
    }

    /* renamed from: b */
    public void m4994b(boolean z) {
        this.f4188C = z;
    }

    /* renamed from: c */
    public void m4995c(boolean z) {
        this.f4186A = z;
    }

    /* renamed from: c */
    public boolean m4996c() {
        if (this.f4201k != null) {
            if (!this.f4201k.m11485d()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public void m4997d() {
        if (this.f4191F.equals(C1422e.NONE)) {
            this.f4192G = C1345a.MANUAL;
        }
        this.f4191F = C1422e.ALL;
        m4947a(this.f4194a, false);
    }

    /* renamed from: d */
    public void m4998d(boolean z) {
        this.f4187B = z;
    }

    /* renamed from: e */
    public void m4999e() {
        if (this.f4201k != null) {
            this.f4201k.m11483b(true);
            this.f4201k = null;
        }
    }

    /* renamed from: f */
    public String m5000f() {
        return this.f4196f;
    }

    /* renamed from: g */
    public boolean m5001g() {
        return this.f4194a != null && this.f4194a.c_();
    }

    /* renamed from: h */
    public boolean m5002h() {
        return m5001g() && this.f4194a.mo2837f();
    }

    /* renamed from: i */
    public boolean m5003i() {
        return this.f4194a != null && this.f4194a.a_();
    }

    /* renamed from: j */
    public C1427h m5004j() {
        return !m5001g() ? null : this.f4194a.mo2842k();
    }

    /* renamed from: k */
    public C1427h m5005k() {
        return !m5001g() ? null : this.f4194a.mo2843l();
    }

    /* renamed from: l */
    public C1429k m5006l() {
        return !m5001g() ? null : this.f4194a.mo2844m();
    }

    /* renamed from: m */
    public String m5007m() {
        return !m5001g() ? null : this.f4194a.mo2845n();
    }

    /* renamed from: n */
    public String m5008n() {
        return !m5001g() ? null : this.f4194a.mo2846o();
    }

    /* renamed from: o */
    public String m5009o() {
        return !m5001g() ? null : this.f4194a.mo2848p();
    }

    /* renamed from: p */
    public String m5010p() {
        return !m5001g() ? null : this.f4194a.mo2864K();
    }

    /* renamed from: q */
    public String m5011q() {
        return !m5001g() ? null : this.f4194a.mo2849q();
    }

    /* renamed from: r */
    public String m5012r() {
        return !m5001g() ? null : this.f4194a.mo2850r();
    }

    /* renamed from: s */
    public String m5013s() {
        return !m5001g() ? null : this.f4194a.mo2851s();
    }

    /* renamed from: t */
    public String m5014t() {
        return !m5001g() ? null : this.f4194a.mo2852t();
    }

    /* renamed from: u */
    public String m5015u() {
        return !m5001g() ? null : this.f4194a.mo2853u();
    }

    /* renamed from: v */
    public String m5016v() {
        return !m5001g() ? null : this.f4194a.mo2854v();
    }

    /* renamed from: w */
    public C1428j m5017w() {
        return !m5001g() ? null : this.f4194a.mo2855w();
    }

    /* renamed from: x */
    public String m5018x() {
        return !m5001g() ? null : this.f4197g;
    }

    /* renamed from: y */
    public C1427h m5019y() {
        return !m5001g() ? null : this.f4194a.mo2856x();
    }

    /* renamed from: z */
    public String m5020z() {
        return !m5001g() ? null : this.f4194a.mo2857y();
    }
}
