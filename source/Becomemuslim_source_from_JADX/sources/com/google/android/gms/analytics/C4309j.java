package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.facebook.ads.internal.p088c.C1354a;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.analytics.p171a.C2702a;
import com.google.android.gms.analytics.p171a.C2703b;
import com.google.android.gms.analytics.p171a.C2704c;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p210i.C5006n;
import com.google.android.gms.internal.p210i.C5007p;
import com.google.android.gms.internal.p210i.C5008q;
import com.google.android.gms.internal.p210i.C5011t;
import com.google.android.gms.internal.p210i.C6788b;
import com.google.android.gms.internal.p210i.C6790c;
import com.google.android.gms.internal.p210i.C6791d;
import com.google.android.gms.internal.p210i.bg;
import com.google.android.gms.internal.p210i.bz;
import com.google.android.gms.internal.p210i.eg;
import com.google.android.gms.internal.p210i.fh;
import com.google.android.gms.internal.p210i.gi;
import com.google.android.gms.internal.p210i.hj;
import com.google.android.gms.internal.p210i.ik;
import com.google.android.gms.internal.p210i.jl;
import com.google.android.gms.internal.p210i.jm;
import com.google.android.gms.internal.p210i.jn;
import com.google.android.gms.internal.p210i.jo;
import com.google.android.gms.internal.p210i.jp;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.analytics.j */
public final class C4309j extends C5006n implements C2725w {
    /* renamed from: a */
    private static DecimalFormat f11356a;
    /* renamed from: b */
    private final C5008q f11357b;
    /* renamed from: c */
    private final String f11358c;
    /* renamed from: d */
    private final Uri f11359d;

    public C4309j(C5008q c5008q, String str) {
        this(c5008q, str, true, false);
    }

    private C4309j(C5008q c5008q, String str, boolean z, boolean z2) {
        super(c5008q);
        C2872v.m8382a(str);
        this.f11357b = c5008q;
        this.f11358c = str;
        this.f11359d = C4309j.m13990a(this.f11358c);
    }

    /* renamed from: a */
    static Uri m13990a(String str) {
        C2872v.m8382a(str);
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    /* renamed from: a */
    public final Uri mo2357a() {
        return this.f11359d;
    }

    /* renamed from: a */
    public final void mo2358a(C2714o c2714o) {
        C2872v.m8380a((Object) c2714o);
        C2872v.m8391b(c2714o.m7751f(), "Can't deliver not submitted measurement");
        C2872v.m8393c("deliver should be called on worker thread");
        C2714o a = c2714o.m7742a();
        jp jpVar = (jp) a.m7746b(jp.class);
        if (TextUtils.isEmpty(jpVar.a())) {
            l().a(C4309j.m13996b(a), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(jpVar.b())) {
            l().a(C4309j.m13996b(a), "Ignoring measurement without client id");
        } else if (!this.f11357b.j().m16620e()) {
            double h = jpVar.h();
            if (bz.a(h, jpVar.b())) {
                b("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(h));
                return;
            }
            Map b = C4309j.m13996b(a);
            b.put("v", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            b.put("_v", C5007p.f16814b);
            b.put("tid", this.f11358c);
            if (this.f11357b.j().m16619d()) {
                c2714o = new StringBuilder();
                for (Entry entry : b.entrySet()) {
                    if (c2714o.length() != 0) {
                        c2714o.append(", ");
                    }
                    c2714o.append((String) entry.getKey());
                    c2714o.append("=");
                    c2714o.append((String) entry.getValue());
                }
                c("Dry run is enabled. GoogleAnalytics would have sent", c2714o.toString());
                return;
            }
            Map hashMap = new HashMap();
            bz.a(hashMap, "uid", jpVar.c());
            eg egVar = (eg) c2714o.m7743a(eg.class);
            if (egVar != null) {
                bz.a(hashMap, "an", egVar.a());
                bz.a(hashMap, "aid", egVar.c());
                bz.a(hashMap, "av", egVar.b());
                bz.a(hashMap, "aiid", egVar.d());
            }
            b.put("_s", String.valueOf(p().a(new C5011t(0, jpVar.b(), this.f11358c, TextUtils.isEmpty(jpVar.d()) ^ 1, 0, hashMap))));
            p().a(new bg(l(), b, c2714o.m7749d(), true));
        }
    }

    /* renamed from: b */
    private static Map<String, String> m13996b(C2714o c2714o) {
        CharSequence b;
        Map hashMap = new HashMap();
        ik ikVar = (ik) c2714o.m7743a(ik.class);
        if (ikVar != null) {
            for (Entry entry : ikVar.a().entrySet()) {
                Boolean value = entry.getValue();
                Object obj = null;
                if (value != null) {
                    if (value instanceof String) {
                        String str = (String) value;
                        if (!TextUtils.isEmpty(str)) {
                            obj = str;
                        }
                    } else if (value instanceof Double) {
                        Double d = (Double) value;
                        if (d.doubleValue() != 0.0d) {
                            obj = C4309j.m13991a(d.doubleValue());
                        }
                    } else if (!(value instanceof Boolean)) {
                        obj = String.valueOf(value);
                    } else if (value != Boolean.FALSE) {
                        obj = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                    }
                }
                if (obj != null) {
                    hashMap.put((String) entry.getKey(), obj);
                }
            }
        }
        jp jpVar = (jp) c2714o.m7743a(jp.class);
        if (jpVar != null) {
            C4309j.m13994a(hashMap, "t", jpVar.a());
            C4309j.m13994a(hashMap, "cid", jpVar.b());
            C4309j.m13994a(hashMap, "uid", jpVar.c());
            C4309j.m13994a(hashMap, "sc", jpVar.f());
            C4309j.m13992a(hashMap, "sf", jpVar.h());
            C4309j.m13995a(hashMap, "ni", jpVar.g());
            C4309j.m13994a(hashMap, "adid", jpVar.d());
            C4309j.m13995a(hashMap, "ate", jpVar.e());
        }
        C6788b c6788b = (C6788b) c2714o.m7743a(C6788b.class);
        if (c6788b != null) {
            C4309j.m13994a(hashMap, "cd", c6788b.a());
            C4309j.m13992a(hashMap, C1354a.f3934a, (double) c6788b.b());
            C4309j.m13994a(hashMap, "dr", c6788b.c());
        }
        jn jnVar = (jn) c2714o.m7743a(jn.class);
        if (jnVar != null) {
            C4309j.m13994a(hashMap, "ec", jnVar.a());
            C4309j.m13994a(hashMap, "ea", jnVar.b());
            C4309j.m13994a(hashMap, "el", jnVar.c());
            C4309j.m13992a(hashMap, "ev", (double) jnVar.d());
        }
        fh fhVar = (fh) c2714o.m7743a(fh.class);
        if (fhVar != null) {
            C4309j.m13994a(hashMap, "cn", fhVar.a());
            C4309j.m13994a(hashMap, "cs", fhVar.b());
            C4309j.m13994a(hashMap, "cm", fhVar.c());
            C4309j.m13994a(hashMap, "ck", fhVar.d());
            C4309j.m13994a(hashMap, "cc", fhVar.e());
            C4309j.m13994a(hashMap, "ci", fhVar.f());
            C4309j.m13994a(hashMap, "anid", fhVar.g());
            C4309j.m13994a(hashMap, "gclid", fhVar.h());
            C4309j.m13994a(hashMap, "dclid", fhVar.i());
            C4309j.m13994a(hashMap, "aclid", fhVar.j());
        }
        jo joVar = (jo) c2714o.m7743a(jo.class);
        if (joVar != null) {
            C4309j.m13994a(hashMap, "exd", joVar.f24552a);
            C4309j.m13995a(hashMap, "exf", joVar.f24553b);
        }
        C6790c c6790c = (C6790c) c2714o.m7743a(C6790c.class);
        if (c6790c != null) {
            C4309j.m13994a(hashMap, "sn", c6790c.f24455a);
            C4309j.m13994a(hashMap, "sa", c6790c.f24456b);
            C4309j.m13994a(hashMap, UserDataStore.STATE, c6790c.f24457c);
        }
        C6791d c6791d = (C6791d) c2714o.m7743a(C6791d.class);
        if (c6791d != null) {
            C4309j.m13994a(hashMap, "utv", c6791d.f24460a);
            C4309j.m13992a(hashMap, "utt", (double) c6791d.f24461b);
            C4309j.m13994a(hashMap, "utc", c6791d.f24462c);
            C4309j.m13994a(hashMap, "utl", c6791d.f24463d);
        }
        gi giVar = (gi) c2714o.m7743a(gi.class);
        if (giVar != null) {
            for (Entry entry2 : giVar.a().entrySet()) {
                b = C2712l.m7729b(((Integer) entry2.getKey()).intValue());
                if (!TextUtils.isEmpty(b)) {
                    hashMap.put(b, (String) entry2.getValue());
                }
            }
        }
        hj hjVar = (hj) c2714o.m7743a(hj.class);
        if (hjVar != null) {
            for (Entry entry22 : hjVar.a().entrySet()) {
                b = C2712l.m7731d(((Integer) entry22.getKey()).intValue());
                if (!TextUtils.isEmpty(b)) {
                    hashMap.put(b, C4309j.m13991a(((Double) entry22.getValue()).doubleValue()));
                }
            }
        }
        jm jmVar = (jm) c2714o.m7743a(jm.class);
        if (jmVar != null) {
            C2703b a = jmVar.a();
            if (a != null) {
                for (Entry entry3 : a.m7693a().entrySet()) {
                    if (((String) entry3.getKey()).startsWith("&")) {
                        hashMap.put(((String) entry3.getKey()).substring(1), (String) entry3.getValue());
                    } else {
                        hashMap.put((String) entry3.getKey(), (String) entry3.getValue());
                    }
                }
            }
            int i = 1;
            for (C2704c e : jmVar.d()) {
                hashMap.putAll(e.m7706e(C2712l.m7735h(i)));
                i++;
            }
            i = 1;
            for (C2702a g : jmVar.b()) {
                hashMap.putAll(g.m7688g(C2712l.m7733f(i)));
                i++;
            }
            int i2 = 1;
            for (Entry entry32 : jmVar.c().entrySet()) {
                List<C2702a> list = (List) entry32.getValue();
                String k = C2712l.m7738k(i2);
                int i3 = 1;
                for (C2702a c2702a : list) {
                    String valueOf = String.valueOf(k);
                    String valueOf2 = String.valueOf(C2712l.m7736i(i3));
                    hashMap.putAll(c2702a.m7688g(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i3++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry32.getKey())) {
                    String valueOf3 = String.valueOf(k);
                    k = String.valueOf("nm");
                    hashMap.put(k.length() != 0 ? valueOf3.concat(k) : new String(valueOf3), (String) entry32.getKey());
                }
                i2++;
            }
        }
        jl jlVar = (jl) c2714o.m7743a(jl.class);
        if (jlVar != null) {
            C4309j.m13994a(hashMap, "ul", jlVar.a());
            C4309j.m13992a(hashMap, "sd", (double) jlVar.f24538a);
            C4309j.m13993a(hashMap, "sr", jlVar.f24539b, jlVar.f24540c);
            C4309j.m13993a(hashMap, "vp", jlVar.f24541d, jlVar.f24542e);
        }
        eg egVar = (eg) c2714o.m7743a(eg.class);
        if (egVar != null) {
            C4309j.m13994a(hashMap, "an", egVar.a());
            C4309j.m13994a(hashMap, "aid", egVar.c());
            C4309j.m13994a(hashMap, "aiid", egVar.d());
            C4309j.m13994a(hashMap, "av", egVar.b());
        }
        return hashMap;
    }

    /* renamed from: a */
    private static void m13994a(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    /* renamed from: a */
    private static String m13991a(double d) {
        if (f11356a == null) {
            f11356a = new DecimalFormat("0.######");
        }
        return f11356a.format(d);
    }

    /* renamed from: a */
    private static void m13992a(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, C4309j.m13991a(d));
        }
    }

    /* renamed from: a */
    private static void m13995a(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
    }

    /* renamed from: a */
    private static void m13993a(Map<String, String> map, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            StringBuilder stringBuilder = new StringBuilder(23);
            stringBuilder.append(i);
            stringBuilder.append("x");
            stringBuilder.append(i2);
            map.put(str, stringBuilder.toString());
        }
    }
}
