package com.facebook.ads.internal;

import android.content.Context;
import android.os.Handler;
import com.amplitude.api.Constants;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.C1327e;
import com.facebook.ads.internal.adapters.C1346z;
import com.facebook.ads.internal.adapters.C3572y;
import com.facebook.ads.internal.p093h.C1386a;
import com.facebook.ads.internal.p093h.C1388c;
import com.facebook.ads.internal.p094i.C1391a;
import com.facebook.ads.internal.p094i.C1394c;
import com.facebook.ads.internal.p097l.C1405a;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p098m.C3580d;
import com.facebook.ads.internal.p100o.C1434b;
import com.facebook.ads.internal.p100o.C1438c;
import com.facebook.ads.internal.p100o.C1438c.C1437a;
import com.facebook.ads.internal.p100o.C3593g;
import com.facebook.ads.internal.p105q.p106a.C1496d;
import com.facebook.ads.internal.p105q.p106a.C1509l;
import com.facebook.ads.internal.p105q.p106a.C1512o;
import com.facebook.ads.internal.p105q.p106a.C1524x;
import com.facebook.ads.internal.p105q.p110e.C1542a;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.protocol.C1481a;
import com.facebook.ads.internal.protocol.C1482b;
import com.facebook.ads.internal.protocol.C1484c;
import com.facebook.ads.internal.protocol.C1485d;
import com.facebook.ads.internal.protocol.C1487f;
import com.facebook.ads.internal.protocol.C1491h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.a */
public class C3548a implements C1437a {
    /* renamed from: a */
    private final Context f9468a;
    /* renamed from: b */
    private final String f9469b;
    /* renamed from: c */
    private final C1438c f9470c;
    /* renamed from: d */
    private final C1487f f9471d;
    /* renamed from: e */
    private final C1485d f9472e;
    /* renamed from: f */
    private final AdSize f9473f;
    /* renamed from: g */
    private final int f9474g;
    /* renamed from: h */
    private boolean f9475h = true;
    /* renamed from: i */
    private final Handler f9476i = new Handler();
    /* renamed from: j */
    private final Runnable f9477j = new C3544b(this);
    /* renamed from: k */
    private final C1412c f9478k;
    /* renamed from: l */
    private C1295a f9479l;
    /* renamed from: m */
    private C1388c f9480m;

    /* renamed from: com.facebook.ads.internal.a$a */
    public interface C1295a {
        /* renamed from: a */
        void mo884a(C1481a c1481a);

        /* renamed from: a */
        void mo885a(List<C3572y> list);
    }

    /* renamed from: com.facebook.ads.internal.a$b */
    private static final class C3544b extends C1524x<C3548a> {
        public C3544b(C3548a c3548a) {
            super(c3548a);
        }

        public void run() {
            C3548a c3548a = (C3548a) m5347a();
            if (c3548a != null) {
                if (C1542a.m5399a(c3548a.f9468a)) {
                    c3548a.m11503a();
                } else {
                    c3548a.f9476i.postDelayed(c3548a.f9477j, 5000);
                }
            }
        }
    }

    static {
        C1496d.m5270a();
    }

    public C3548a(Context context, String str, C1487f c1487f, AdSize adSize, C1485d c1485d, int i) {
        this.f9468a = context;
        this.f9469b = str;
        this.f9471d = c1487f;
        this.f9473f = adSize;
        this.f9472e = c1485d;
        this.f9474g = i;
        this.f9470c = new C1438c(context);
        this.f9470c.m5084a((C1437a) this);
        this.f9478k = C3580d.m11662a(context);
        C1391a.m4778a(context).m4779a();
    }

    /* renamed from: d */
    private List<C3572y> m11502d() {
        C1388c c1388c = this.f9480m;
        final List<C3572y> arrayList = new ArrayList(c1388c.m4762c());
        for (C1386a d = c1388c.m4763d(); d != null; d = c1388c.m4763d()) {
            AdAdapter a = C1327e.m4596a(d.m4753a(), AdPlacementType.NATIVE);
            if (a != null && a.getPlacementType() == AdPlacementType.NATIVE) {
                Map hashMap = new HashMap();
                hashMap.put("data", d.m4755b());
                hashMap.put("definition", c1388c.m4759a());
                ((C3572y) a).mo2827a(this.f9468a, new C1346z(this) {
                    /* renamed from: b */
                    final /* synthetic */ C3548a f9461b;

                    /* renamed from: a */
                    public void mo897a(C3572y c3572y) {
                        arrayList.add(c3572y);
                    }

                    /* renamed from: a */
                    public void mo898a(C3572y c3572y, C1481a c1481a) {
                    }

                    /* renamed from: b */
                    public void mo899b(C3572y c3572y) {
                    }

                    /* renamed from: c */
                    public void mo900c(C3572y c3572y) {
                    }
                }, this.f9478k, hashMap, NativeAdBase.getViewTraversalPredicate());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void m11503a() {
        try {
            C1509l c1509l = null;
            C1491h c1491h = new C1491h(this.f9468a, null, null, null);
            Context context = r1.f9468a;
            C1394c c1394c = new C1394c(r1.f9468a, false);
            String str = r1.f9469b;
            if (r1.f9473f != null) {
                c1509l = new C1509l(r1.f9473f.getHeight(), r1.f9473f.getWidth());
            }
            r1.f9470c.m5083a(new C1434b(context, c1394c, str, c1509l, r1.f9471d, r1.f9472e, null, C1327e.m4597a(C1484c.m5247a(r1.f9471d).m5248a()), r1.f9474g, AdSettings.isTestMode(r1.f9468a), AdSettings.isChildDirected(), c1491h, C1512o.m5316a(C1405a.m4837r(r1.f9468a))));
        } catch (C1482b e) {
            mo916a(C1481a.m5242a(e));
        }
    }

    /* renamed from: a */
    public void m11504a(C1295a c1295a) {
        this.f9479l = c1295a;
    }

    /* renamed from: a */
    public void mo915a(C3593g c3593g) {
        C1388c a = c3593g.mo968a();
        if (a != null) {
            if (this.f9475h) {
                long c = a.m4759a().m4768c();
                if (c == 0) {
                    c = Constants.SESSION_TIMEOUT_MILLIS;
                }
                this.f9476i.postDelayed(this.f9477j, c);
            }
            this.f9480m = a;
            List d = m11502d();
            if (this.f9479l != null) {
                if (d.isEmpty()) {
                    this.f9479l.mo884a(C1481a.m5241a(AdErrorType.NO_FILL, ""));
                    return;
                }
                this.f9479l.mo885a(d);
            }
            return;
        }
        throw new IllegalStateException("no placement in response");
    }

    /* renamed from: a */
    public void mo916a(C1481a c1481a) {
        if (this.f9475h) {
            this.f9476i.postDelayed(this.f9477j, Constants.SESSION_TIMEOUT_MILLIS);
        }
        if (this.f9479l != null) {
            this.f9479l.mo884a(c1481a);
        }
    }

    /* renamed from: b */
    public void m11507b() {
    }

    /* renamed from: c */
    public void m11508c() {
        this.f9475h = false;
        this.f9476i.removeCallbacks(this.f9477j);
    }
}
