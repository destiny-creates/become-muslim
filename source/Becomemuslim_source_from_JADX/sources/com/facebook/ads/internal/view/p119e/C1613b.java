package com.facebook.ads.internal.view.p119e;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.adapters.p086a.C1312d;
import com.facebook.ads.internal.adapters.p086a.C1321k;
import com.facebook.ads.internal.p085a.C1297b;
import com.facebook.ads.internal.p085a.C1298c;
import com.facebook.ads.internal.p095j.C1399c;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1520t;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.p105q.p108c.C1532b;
import com.facebook.ads.internal.p105q.p108c.C1537e;
import com.facebook.ads.internal.p105q.p108c.C1537e.C1536a;
import com.facebook.ads.internal.p105q.p108c.C1538f;
import com.facebook.ads.internal.p111r.C1545a;
import com.facebook.ads.internal.view.C1566a.C1551a;
import com.facebook.ads.internal.view.component.C1599a;
import com.facebook.ads.internal.view.component.C1603e;
import com.facebook.ads.internal.view.component.C1606h;
import com.facebook.ads.internal.view.p113b.C1577d;
import com.facebook.ads.internal.view.p113b.C3616a;
import com.facebook.ads.internal.view.p113b.C3616a.C1568b;
import com.facebook.ads.internal.view.p113b.C3616a.C3615c;
import com.facebook.ads.internal.view.p120f.p122b.C1627z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: com.facebook.ads.internal.view.e.b */
public class C1613b {
    /* renamed from: a */
    private static final String f4842a = "b";
    /* renamed from: b */
    private static final int f4843b = ((int) (C1523w.f4503b * 4.0f));
    /* renamed from: c */
    private static final int f4844c = ((int) (C1523w.f4503b * 72.0f));
    /* renamed from: d */
    private static final int f4845d = ((int) (C1523w.f4503b * 8.0f));
    /* renamed from: e */
    private final Context f4846e;
    /* renamed from: f */
    private final C1412c f4847f;
    /* renamed from: g */
    private final C1321k f4848g;
    /* renamed from: h */
    private final String f4849h;
    /* renamed from: i */
    private final C1312d f4850i;
    /* renamed from: j */
    private final C1545a f4851j;
    /* renamed from: k */
    private final C1520t f4852k;
    /* renamed from: l */
    private Executor f4853l = AsyncTask.THREAD_POOL_EXECUTOR;
    /* renamed from: m */
    private C1551a f4854m;
    /* renamed from: n */
    private C3616a f4855n;
    /* renamed from: o */
    private C1568b f4856o;

    /* renamed from: com.facebook.ads.internal.view.e.b$a */
    public enum C1612a {
        SCREENSHOTS,
        MARKUP,
        INFO
    }

    /* renamed from: com.facebook.ads.internal.view.e.b$2 */
    class C36342 implements C1536a {
        /* renamed from: a */
        final /* synthetic */ C1613b f9732a;

        C36342(C1613b c1613b) {
            this.f9732a = c1613b;
        }

        /* renamed from: a */
        public void mo1027a() {
            if (this.f9732a.f4854m != null) {
                this.f9732a.f4854m.mo854a(C1627z.REWARD_SERVER_FAILED.m5610a());
            }
        }

        /* renamed from: a */
        public void mo1028a(C1538f c1538f) {
            if (this.f9732a.f4854m != null) {
                C1551a b;
                C1627z c1627z;
                if (c1538f == null || !c1538f.m5386a()) {
                    b = this.f9732a.f4854m;
                    c1627z = C1627z.REWARD_SERVER_FAILED;
                } else {
                    b = this.f9732a.f4854m;
                    c1627z = C1627z.REWARD_SERVER_SUCCESS;
                }
                b.mo854a(c1627z.m5610a());
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.e.b$1 */
    class C45791 extends C3615c {
        /* renamed from: a */
        final /* synthetic */ C1613b f12467a;

        /* renamed from: com.facebook.ads.internal.view.e.b$1$1 */
        class C16101 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C45791 f4836a;

            C16101(C45791 c45791) {
                this.f4836a = c45791;
            }

            public void run() {
                if (this.f4836a.f12467a.f4855n != null) {
                    if (!this.f4836a.f12467a.f4855n.m5364c()) {
                        C3616a f = this.f4836a.f12467a.f4855n;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("javascript:");
                        stringBuilder.append(this.f4836a.f12467a.f4848g.m4564f().m4519c());
                        f.loadUrl(stringBuilder.toString());
                        return;
                    }
                }
                Log.w(C1613b.f4842a, "Webview already destroyed, cannot activate");
            }
        }

        C45791(C1613b c1613b) {
            this.f12467a = c1613b;
        }

        /* renamed from: a */
        public void mo1005a() {
            if (this.f12467a.f4855n != null && !TextUtils.isEmpty(this.f12467a.f4848g.m4564f().m4519c())) {
                this.f12467a.f4855n.post(new C16101(this));
            }
        }

        /* renamed from: a */
        public void mo1008a(String str, Map<String, String> map) {
            Uri parse = Uri.parse(str);
            if ("fbad".equals(parse.getScheme()) && parse.getAuthority().equals("close")) {
                this.f12467a.m5598g();
                return;
            }
            if ("fbad".equals(parse.getScheme()) && C1298c.m4445a(parse.getAuthority()) && this.f12467a.f4854m != null) {
                this.f12467a.f4854m.mo854a(C1627z.REWARDED_VIDEO_AD_CLICK.m5610a());
            }
            C1297b a = C1298c.m4444a(this.f12467a.f4846e, this.f12467a.f4847f, this.f12467a.f4848g.m4565g(), parse, map);
            if (a != null) {
                try {
                    a.mo917b();
                } catch (Throwable e) {
                    Log.e(C1613b.f4842a, "Error executing action", e);
                }
            }
        }
    }

    public C1613b(Context context, C1412c c1412c, C1321k c1321k, C1551a c1551a, C1545a c1545a, C1520t c1520t) {
        this.f4846e = context;
        this.f4847f = c1412c;
        this.f4848g = c1321k;
        this.f4854m = c1551a;
        this.f4849h = C1399c.m4799a(this.f4848g.m4564f().m4518b());
        this.f4850i = this.f4848g.m4562d().m4463a();
        this.f4851j = c1545a;
        this.f4852k = c1520t;
    }

    /* renamed from: g */
    private void m5598g() {
        if (this.f4854m != null) {
            this.f4854m.mo854a(C1627z.REWARDED_VIDEO_END_ACTIVITY.m5610a());
        }
    }

    /* renamed from: h */
    private View m5599h() {
        View c1606h = new C1606h(this.f4846e, this.f4850i, true, false, false);
        c1606h.m5586a(this.f4848g.m4559b().m4502a(), this.f4848g.m4559b().m4504c(), false, true);
        c1606h.setAlignment(17);
        View c1599a = new C1599a(this.f4846e, true, false, C1627z.REWARDED_VIDEO_AD_CLICK.m5610a(), this.f4850i, this.f4847f, this.f4854m, this.f4851j, this.f4852k);
        c1599a.m5582a(this.f4848g.m4561c(), this.f4848g.m4565g(), new HashMap());
        ImageView c1603e = new C1603e(this.f4846e);
        C1523w.m5342a((View) c1603e, 0);
        c1603e.setRadius(50);
        new C1577d(c1603e).m5504a().m5508a(this.f4848g.m4556a().m4546b());
        View linearLayout = new LinearLayout(this.f4846e);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.addView(c1603e, new LayoutParams(f4844c, f4844c));
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.setMargins(0, f4845d, 0, f4845d);
        linearLayout.addView(c1606h, layoutParams);
        linearLayout.addView(c1599a, layoutParams);
        return linearLayout;
    }

    /* renamed from: i */
    private View m5600i() {
        View recyclerView = new RecyclerView(this.f4846e);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f4846e, 0, false));
        recyclerView.setAdapter(new C3635c(this.f4848g.m4564f().m4520d(), f4843b));
        return recyclerView;
    }

    /* renamed from: j */
    private View m5601j() {
        this.f4856o = new C45791(this);
        this.f4855n = new C3616a(this.f4846e, new WeakReference(this.f4856o), 1);
        this.f4855n.loadDataWithBaseURL(C1532b.m5365a(), this.f4849h, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, AudienceNetworkActivity.WEBVIEW_ENCODING, null);
        return this.f4855n;
    }

    /* renamed from: a */
    public boolean m5602a() {
        return m5603b() == C1612a.MARKUP;
    }

    /* renamed from: b */
    public C1612a m5603b() {
        return !this.f4848g.m4564f().m4520d().isEmpty() ? C1612a.SCREENSHOTS : !TextUtils.isEmpty(this.f4849h) ? C1612a.MARKUP : C1612a.INFO;
    }

    /* renamed from: c */
    public Pair<C1612a, View> m5604c() {
        C1612a b = m5603b();
        switch (b) {
            case MARKUP:
                return new Pair(b, m5601j());
            case SCREENSHOTS:
                return new Pair(b, m5600i());
            default:
                return new Pair(b, m5599h());
        }
    }

    /* renamed from: d */
    public void m5605d() {
        if (!TextUtils.isEmpty(this.f4848g.m4564f().m4516a())) {
            C1537e c1537e = new C1537e(this.f4846e, new HashMap());
            c1537e.m5384a(new C36342(this));
            c1537e.executeOnExecutor(this.f4853l, new String[]{r0});
        }
    }

    /* renamed from: e */
    public void m5606e() {
        if (this.f4855n != null) {
            this.f4855n.destroy();
            this.f4855n = null;
            this.f4856o = null;
        }
    }
}
