package io.p347a.p348a.p349a;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.facebook.appevents.AppEventsConstants;
import io.p347a.p348a.p349a.p350a.p352b.C6424g;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import io.p347a.p348a.p349a.p350a.p352b.C6431l;
import io.p347a.p348a.p349a.p350a.p356e.C6484e;
import io.p347a.p348a.p349a.p350a.p356e.C7615b;
import io.p347a.p348a.p349a.p350a.p358g.C6493d;
import io.p347a.p348a.p349a.p350a.p358g.C6494e;
import io.p347a.p348a.p349a.p350a.p358g.C6498n;
import io.p347a.p348a.p349a.p350a.p358g.C6504q;
import io.p347a.p348a.p349a.p350a.p358g.C6507t;
import io.p347a.p348a.p349a.p350a.p358g.C8184h;
import io.p347a.p348a.p349a.p350a.p358g.C8185y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: Onboarding */
/* renamed from: io.a.a.a.m */
class C7629m extends C6520i<Boolean> {
    /* renamed from: a */
    private final C6484e f26348a = new C7615b();
    /* renamed from: b */
    private PackageManager f26349b;
    /* renamed from: c */
    private String f26350c;
    /* renamed from: d */
    private PackageInfo f26351d;
    /* renamed from: j */
    private String f26352j;
    /* renamed from: k */
    private String f26353k;
    /* renamed from: l */
    private String f26354l;
    /* renamed from: m */
    private String f26355m;
    /* renamed from: n */
    private String f26356n;
    /* renamed from: o */
    private final Future<Map<String, C6522k>> f26357o;
    /* renamed from: p */
    private final Collection<C6520i> f26358p;

    /* renamed from: a */
    public String mo5486a() {
        return "1.3.10.97";
    }

    /* renamed from: b */
    public String mo5487b() {
        return "io.fabric.sdk.android:fabric";
    }

    /* renamed from: f */
    protected /* synthetic */ Object mo5489f() {
        return m34461d();
    }

    public C7629m(Future<Map<String, C6522k>> future, Collection<C6520i> collection) {
        this.f26357o = future;
        this.f26358p = collection;
    }

    protected boolean d_() {
        try {
            this.f26354l = m26654D().m26414j();
            this.f26349b = m26655E().getPackageManager();
            this.f26350c = m26655E().getPackageName();
            this.f26351d = this.f26349b.getPackageInfo(this.f26350c, 0);
            this.f26352j = Integer.toString(this.f26351d.versionCode);
            this.f26353k = this.f26351d.versionName == null ? "0.0" : this.f26351d.versionName;
            this.f26355m = this.f26349b.getApplicationLabel(m26655E().getApplicationInfo()).toString();
            this.f26356n = Integer.toString(m26655E().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (Throwable e) {
            C6514c.m26634h().mo5480e("Fabric", "Failed init", e);
            return false;
        }
    }

    /* renamed from: d */
    protected Boolean m34461d() {
        boolean a;
        String k = C6428i.m26387k(m26655E());
        C6507t g = m34457g();
        if (g != null) {
            try {
                Map map;
                if (this.f26357o != null) {
                    map = (Map) this.f26357o.get();
                } else {
                    map = new HashMap();
                }
                a = m34454a(k, g.f20966a, m34459a(map, this.f26358p).values());
            } catch (Throwable e) {
                C6514c.m26634h().mo5480e("Fabric", "Error performing auto configuration.", e);
            }
            return Boolean.valueOf(a);
        }
        a = false;
        return Boolean.valueOf(a);
    }

    /* renamed from: g */
    private C6507t m34457g() {
        try {
            C6504q.m26608a().m26610a(this, this.i, this.f26348a, this.f26352j, this.f26353k, m34462e()).m26613c();
            return C6504q.m26608a().m26612b();
        } catch (Throwable e) {
            C6514c.m26634h().mo5480e("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    /* renamed from: a */
    Map<String, C6522k> m34459a(Map<String, C6522k> map, Collection<C6520i> collection) {
        for (C6520i c6520i : collection) {
            if (!map.containsKey(c6520i.mo5487b())) {
                map.put(c6520i.mo5487b(), new C6522k(c6520i.mo5487b(), c6520i.mo5486a(), "binary"));
            }
        }
        return map;
    }

    /* renamed from: a */
    private boolean m34454a(String str, C6494e c6494e, Collection<C6522k> collection) {
        if ("new".equals(c6494e.f20929b)) {
            if (m34455b(str, c6494e, collection) != null) {
                return C6504q.m26608a().m26614d();
            }
            C6514c.m26634h().mo5480e("Fabric", "Failed to create app with Crashlytics service.", null);
            return null;
        } else if ("configured".equals(c6494e.f20929b)) {
            return C6504q.m26608a().m26614d();
        } else {
            if (c6494e.f20932e) {
                C6514c.m26634h().mo5472a("Fabric", "Server says an update is required - forcing a full App update.");
                m34456c(str, c6494e, collection);
            }
            return true;
        }
    }

    /* renamed from: b */
    private boolean m34455b(String str, C6494e c6494e, Collection<C6522k> collection) {
        return new C8184h(this, m34462e(), c6494e.f20930c, this.f26348a).mo6416a(m34452a(C6498n.m26605a(m26655E(), str), (Collection) collection));
    }

    /* renamed from: c */
    private boolean m34456c(String str, C6494e c6494e, Collection<C6522k> collection) {
        return m34453a(c6494e, C6498n.m26605a(m26655E(), str), (Collection) collection);
    }

    /* renamed from: a */
    private boolean m34453a(C6494e c6494e, C6498n c6498n, Collection<C6522k> collection) {
        return new C8185y(this, m34462e(), c6494e.f20930c, this.f26348a).mo6416a(m34452a(c6498n, (Collection) collection));
    }

    /* renamed from: a */
    private C6493d m34452a(C6498n c6498n, Collection<C6522k> collection) {
        return new C6493d(new C6424g().m26341a(m26655E()), m26654D().m26407c(), this.f26353k, this.f26352j, C6428i.m26362a(C6428i.m26389m(r1)), this.f26355m, C6431l.m26393a(this.f26354l).m26394a(), this.f26356n, AppEventsConstants.EVENT_PARAM_VALUE_NO, c6498n, collection);
    }

    /* renamed from: e */
    String m34462e() {
        return C6428i.m26374b(m26655E(), "com.crashlytics.ApiEndpoint");
    }
}
