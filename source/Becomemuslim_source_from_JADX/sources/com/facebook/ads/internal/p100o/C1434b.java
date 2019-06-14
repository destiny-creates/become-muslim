package com.facebook.ads.internal.p100o;

import android.content.Context;
import com.facebook.ads.internal.p088c.C1355b;
import com.facebook.ads.internal.p094i.C1394c;
import com.facebook.ads.internal.p095j.C1398b;
import com.facebook.ads.internal.p105q.p106a.C1509l;
import com.facebook.ads.internal.p105q.p106a.C1519s;
import com.facebook.ads.internal.p105q.p106a.C1525y;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.protocol.C1484c;
import com.facebook.ads.internal.protocol.C1485d;
import com.facebook.ads.internal.protocol.C1487f;
import com.facebook.ads.internal.protocol.C1491h;
import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.facebook.ads.internal.o.b */
public class C1434b {
    /* renamed from: a */
    protected String f4246a;
    /* renamed from: b */
    public Context f4247b;
    /* renamed from: c */
    public C1487f f4248c;
    /* renamed from: d */
    private C1484c f4249d;
    /* renamed from: e */
    private final AdPlacementType f4250e = this.f4249d.m5248a();
    /* renamed from: f */
    private final String f4251f;
    /* renamed from: g */
    private final String f4252g;
    /* renamed from: h */
    private C1485d f4253h;
    /* renamed from: i */
    private boolean f4254i;
    /* renamed from: j */
    private boolean f4255j;
    /* renamed from: k */
    private int f4256k;
    /* renamed from: l */
    private C1509l f4257l;
    /* renamed from: m */
    private final Map<String, String> f4258m;
    /* renamed from: n */
    private final C1491h f4259n;
    /* renamed from: o */
    private String f4260o;

    public C1434b(Context context, C1394c c1394c, String str, C1509l c1509l, C1487f c1487f, C1485d c1485d, String str2, String str3, int i, boolean z, boolean z2, C1491h c1491h, String str4) {
        this.f4246a = str;
        this.f4257l = c1509l;
        this.f4248c = c1487f;
        this.f4249d = C1484c.m5247a(c1487f);
        this.f4253h = c1485d;
        this.f4251f = str2;
        this.f4252g = str3;
        this.f4256k = i;
        this.f4254i = z;
        this.f4255j = z2;
        this.f4258m = c1394c.m4791b();
        this.f4259n = c1491h;
        this.f4247b = context;
        this.f4260o = str4;
    }

    /* renamed from: a */
    private void m5058a(Map<String, String> map, String str, String str2) {
        map.put(str, str2);
    }

    /* renamed from: a */
    public String m5059a() {
        return this.f4246a;
    }

    /* renamed from: b */
    public C1484c m5060b() {
        return this.f4249d;
    }

    /* renamed from: c */
    public C1509l m5061c() {
        return this.f4257l;
    }

    /* renamed from: d */
    public int m5062d() {
        return this.f4256k;
    }

    /* renamed from: e */
    public C1491h m5063e() {
        return this.f4259n;
    }

    /* renamed from: f */
    public Map<String, String> m5064f() {
        Map<String, String> hashMap = new HashMap(this.f4258m);
        m5058a(hashMap, "IDFA", C1355b.f3939b);
        m5058a(hashMap, "IDFA_FLAG", C1355b.f3940c ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        m5058a(hashMap, "COPPA", String.valueOf(this.f4255j));
        m5058a(hashMap, "PLACEMENT_ID", this.f4246a);
        if (this.f4250e != AdPlacementType.UNKNOWN) {
            m5058a(hashMap, "PLACEMENT_TYPE", this.f4250e.toString().toLowerCase());
        }
        if (this.f4257l != null) {
            m5058a(hashMap, "WIDTH", String.valueOf(this.f4257l.m5310b()));
            m5058a(hashMap, "HEIGHT", String.valueOf(this.f4257l.m5309a()));
        }
        m5058a(hashMap, "ADAPTERS", this.f4252g);
        if (this.f4248c != null) {
            m5058a(hashMap, "TEMPLATE_ID", String.valueOf(this.f4248c.m5253a()));
        }
        if (this.f4253h != null) {
            m5058a(hashMap, "REQUEST_TYPE", String.valueOf(this.f4253h.m5249a()));
        }
        if (this.f4254i) {
            m5058a(hashMap, "TEST_MODE", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        if (this.f4251f != null) {
            m5058a(hashMap, "DEMO_AD_ID", this.f4251f);
        }
        if (this.f4256k != 0) {
            m5058a(hashMap, "NUM_ADS_REQUESTED", String.valueOf(this.f4256k));
        }
        m5058a(hashMap, "CLIENT_EVENTS", C1398b.m4796a());
        m5058a(hashMap, "KG_RESTRICTED", String.valueOf(C1525y.m5348a(this.f4247b)));
        m5058a(hashMap, "REQUEST_TIME", C1519s.m5328a(System.currentTimeMillis()));
        if (this.f4259n.m5260c()) {
            m5058a(hashMap, "BID_ID", this.f4259n.m5261d());
        }
        if (this.f4260o != null) {
            m5058a(hashMap, "STACK_TRACE", this.f4260o);
        }
        m5058a(hashMap, "CLIENT_REQUEST_ID", UUID.randomUUID().toString());
        return hashMap;
    }
}
