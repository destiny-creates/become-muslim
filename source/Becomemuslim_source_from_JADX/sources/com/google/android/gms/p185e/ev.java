package com.google.android.gms.p185e;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.analytics.C2709e.C2708c;
import com.google.android.gms.analytics.C2709e.C4304d;
import com.google.android.gms.analytics.C4748h;
import com.google.android.gms.analytics.p171a.C2703b;
import com.google.android.gms.analytics.p171a.C2704c;
import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ab;
import com.google.android.gms.internal.p210i.ct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.e.ev */
public final class ev extends es {
    /* renamed from: a */
    private static final String f13272a = C4992a.f16248P.toString();
    /* renamed from: b */
    private static final String f13273b = ab.f16312a.toString();
    /* renamed from: c */
    private static final String f13274c = ab.f16317e.toString();
    /* renamed from: d */
    private static final String f13275d = ab.f16327o.toString();
    /* renamed from: e */
    private static final String f13276e = ab.f16326n.toString();
    /* renamed from: f */
    private static final String f13277f = ab.f16325m.toString();
    /* renamed from: g */
    private static final String f13278g = ab.f16315d.toString();
    /* renamed from: h */
    private static final String f13279h = ab.f16291F.toString();
    /* renamed from: i */
    private static final String f13280i = ab.f16292G.toString();
    /* renamed from: j */
    private static final String f13281j = ab.f16293H.toString();
    /* renamed from: k */
    private static final List<String> f13282k = Arrays.asList(new String[]{"detail", "checkout", "checkout_option", "click", "add", "remove", "purchase", "refund"});
    /* renamed from: l */
    private static final Pattern f13283l = Pattern.compile("dimension(\\d+)");
    /* renamed from: m */
    private static final Pattern f13284m = Pattern.compile("metric(\\d+)");
    /* renamed from: n */
    private static Map<String, String> f13285n;
    /* renamed from: o */
    private static Map<String, String> f13286o;
    /* renamed from: p */
    private final Set<String> f13287p;
    /* renamed from: q */
    private final eq f13288q;
    /* renamed from: r */
    private final C2934c f13289r;

    public ev(Context context, C2934c c2934c) {
        this(context, c2934c, new eq(context));
    }

    private ev(Context context, C2934c c2934c, eq eqVar) {
        super(f13272a, new String[0]);
        this.f13289r = c2934c;
        this.f13288q = eqVar;
        this.f13287p = new HashSet();
        this.f13287p.add("");
        this.f13287p.add(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.f13287p.add("false");
    }

    /* renamed from: a */
    private static boolean m16896a(Map<String, ct> map, String str) {
        ct ctVar = (ct) map.get(str);
        if (ctVar == null) {
            return null;
        }
        return eu.m8731e(ctVar).booleanValue();
    }

    /* renamed from: b */
    public final void mo3297b(Map<String, ct> map) {
        String str;
        String valueOf;
        C4748h a = this.f13288q.m8709a("_GTM_DEFAULT_TRACKER_");
        a.m16645c(ev.m16896a(map, "collect_adid"));
        int i = 0;
        List list = null;
        Map b;
        if (ev.m16896a(map, f13275d)) {
            String str2;
            Object obj;
            C2704c c2704c;
            List<Map> list2;
            C2703b c2703b;
            Object obj2;
            Object obj3;
            C2708c c4304d = new C4304d();
            Map b2 = m16898b((ct) map.get(f13278g));
            c4304d.m7720a(b2);
            if (ev.m16896a(map, f13276e)) {
                map = this.f13289r.m8618b("ecommerce");
                if (map instanceof Map) {
                    map = map;
                    if (map != null) {
                        str2 = (String) b2.get("&cu");
                        if (str2 == null) {
                            str2 = (String) map.get("currencyCode");
                        }
                        if (str2 != null) {
                            c4304d.m7719a("&cu", str2);
                        }
                        obj = map.get("impressions");
                        if (obj instanceof List) {
                            for (Map b3 : (List) obj) {
                                try {
                                    c4304d.m7716a(ev.m16899c(b3), (String) b3.get("list"));
                                } catch (RuntimeException e) {
                                    str = "Failed to extract a product from DataLayer. ";
                                    valueOf = String.valueOf(e.getMessage());
                                    bs.m8582a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                                }
                            }
                        }
                        if (!map.containsKey("promoClick")) {
                            list = (List) ((Map) map.get("promoClick")).get("promotions");
                        } else if (map.containsKey("promoView")) {
                            list = (List) ((Map) map.get("promoView")).get("promotions");
                        }
                        if (r3 != null) {
                            for (Map b22 : r3) {
                                try {
                                    c2704c = new C2704c();
                                    str = (String) b22.get("id");
                                    if (str != null) {
                                        c2704c.m7702a(String.valueOf(str));
                                    }
                                    str = (String) b22.get("name");
                                    if (str != null) {
                                        c2704c.m7703b(String.valueOf(str));
                                    }
                                    str = (String) b22.get("creative");
                                    if (str != null) {
                                        c2704c.m7704c(String.valueOf(str));
                                    }
                                    str2 = (String) b22.get(ViewProps.POSITION);
                                    if (str2 != null) {
                                        c2704c.m7705d(String.valueOf(str2));
                                    }
                                    c4304d.m7718a(c2704c);
                                } catch (RuntimeException e2) {
                                    valueOf = "Failed to extract a promotion from DataLayer. ";
                                    str2 = String.valueOf(e2.getMessage());
                                    bs.m8582a(str2.length() != 0 ? valueOf.concat(str2) : new String(valueOf));
                                }
                            }
                            if (map.containsKey("promoClick")) {
                                c4304d.m7719a("&promoa", "click");
                                if (i != 0) {
                                    for (String str3 : f13282k) {
                                        if (map.containsKey(str3)) {
                                            map = (Map) map.get(str3);
                                            list2 = (List) map.get("products");
                                            if (list2 != null) {
                                                for (Map b222 : list2) {
                                                    try {
                                                        c4304d.m7715a(ev.m16899c(b222));
                                                    } catch (RuntimeException e22) {
                                                        valueOf = "Failed to extract a product from DataLayer. ";
                                                        str2 = String.valueOf(e22.getMessage());
                                                        bs.m8582a(str2.length() != 0 ? valueOf.concat(str2) : new String(valueOf));
                                                    }
                                                }
                                            }
                                            try {
                                                if (map.containsKey("actionField")) {
                                                    c2703b = new C2703b(str3);
                                                } else {
                                                    map = (Map) map.get("actionField");
                                                    c2703b = new C2703b(str3);
                                                    obj2 = map.get("id");
                                                    if (obj2 != null) {
                                                        c2703b.m7692a(String.valueOf(obj2));
                                                    }
                                                    obj2 = map.get("affiliation");
                                                    if (obj2 != null) {
                                                        c2703b.m7695b(String.valueOf(obj2));
                                                    }
                                                    obj2 = map.get("coupon");
                                                    if (obj2 != null) {
                                                        c2703b.m7697c(String.valueOf(obj2));
                                                    }
                                                    obj2 = map.get("list");
                                                    if (obj2 != null) {
                                                        c2703b.m7699e(String.valueOf(obj2));
                                                    }
                                                    obj2 = map.get("option");
                                                    if (obj2 != null) {
                                                        c2703b.m7698d(String.valueOf(obj2));
                                                    }
                                                    obj2 = map.get("revenue");
                                                    if (obj2 != null) {
                                                        c2703b.m7690a(ev.m16892a(obj2).doubleValue());
                                                    }
                                                    obj2 = map.get("tax");
                                                    if (obj2 != null) {
                                                        c2703b.m7694b(ev.m16892a(obj2).doubleValue());
                                                    }
                                                    obj2 = map.get("shipping");
                                                    if (obj2 != null) {
                                                        c2703b.m7696c(ev.m16892a(obj2).doubleValue());
                                                    }
                                                    obj3 = map.get("step");
                                                    if (obj3 != null) {
                                                        c2703b.m7691a(ev.m16897b(obj3).intValue());
                                                    }
                                                }
                                                c4304d.m7717a(c2703b);
                                            } catch (Map<String, ct> map2) {
                                                String str4 = "Failed to extract a product action from DataLayer. ";
                                                map2 = String.valueOf(map2.getMessage());
                                                bs.m8582a(map2.length() != 0 ? str4.concat(map2) : new String(str4));
                                            }
                                        }
                                    }
                                }
                            } else {
                                c4304d.m7719a("&promoa", "view");
                            }
                        }
                        i = 1;
                        if (i != 0) {
                            for (String str32 : f13282k) {
                                if (map2.containsKey(str32)) {
                                    map2 = (Map) map2.get(str32);
                                    list2 = (List) map2.get("products");
                                    if (list2 != null) {
                                        while (r2.hasNext()) {
                                            c4304d.m7715a(ev.m16899c(b222));
                                        }
                                    }
                                    if (map2.containsKey("actionField")) {
                                        c2703b = new C2703b(str32);
                                    } else {
                                        map2 = (Map) map2.get("actionField");
                                        c2703b = new C2703b(str32);
                                        obj2 = map2.get("id");
                                        if (obj2 != null) {
                                            c2703b.m7692a(String.valueOf(obj2));
                                        }
                                        obj2 = map2.get("affiliation");
                                        if (obj2 != null) {
                                            c2703b.m7695b(String.valueOf(obj2));
                                        }
                                        obj2 = map2.get("coupon");
                                        if (obj2 != null) {
                                            c2703b.m7697c(String.valueOf(obj2));
                                        }
                                        obj2 = map2.get("list");
                                        if (obj2 != null) {
                                            c2703b.m7699e(String.valueOf(obj2));
                                        }
                                        obj2 = map2.get("option");
                                        if (obj2 != null) {
                                            c2703b.m7698d(String.valueOf(obj2));
                                        }
                                        obj2 = map2.get("revenue");
                                        if (obj2 != null) {
                                            c2703b.m7690a(ev.m16892a(obj2).doubleValue());
                                        }
                                        obj2 = map2.get("tax");
                                        if (obj2 != null) {
                                            c2703b.m7694b(ev.m16892a(obj2).doubleValue());
                                        }
                                        obj2 = map2.get("shipping");
                                        if (obj2 != null) {
                                            c2703b.m7696c(ev.m16892a(obj2).doubleValue());
                                        }
                                        obj3 = map2.get("step");
                                        if (obj3 != null) {
                                            c2703b.m7691a(ev.m16897b(obj3).intValue());
                                        }
                                    }
                                    c4304d.m7717a(c2703b);
                                }
                            }
                        }
                    }
                    a.m16640a(c4304d.m7721b());
                }
            }
            map2 = eu.m8734f((ct) map2.get(f13277f));
            if (map2 instanceof Map) {
                map2 = map2;
                if (map2 != null) {
                    str2 = (String) b222.get("&cu");
                    if (str2 == null) {
                        str2 = (String) map2.get("currencyCode");
                    }
                    if (str2 != null) {
                        c4304d.m7719a("&cu", str2);
                    }
                    obj = map2.get("impressions");
                    if (obj instanceof List) {
                        for (Map b32 : (List) obj) {
                            c4304d.m7716a(ev.m16899c(b32), (String) b32.get("list"));
                        }
                    }
                    if (!map2.containsKey("promoClick")) {
                        list = (List) ((Map) map2.get("promoClick")).get("promotions");
                    } else if (map2.containsKey("promoView")) {
                        list = (List) ((Map) map2.get("promoView")).get("promotions");
                    }
                    if (r3 != null) {
                        for (Map b2222 : r3) {
                            c2704c = new C2704c();
                            str = (String) b2222.get("id");
                            if (str != null) {
                                c2704c.m7702a(String.valueOf(str));
                            }
                            str = (String) b2222.get("name");
                            if (str != null) {
                                c2704c.m7703b(String.valueOf(str));
                            }
                            str = (String) b2222.get("creative");
                            if (str != null) {
                                c2704c.m7704c(String.valueOf(str));
                            }
                            str2 = (String) b2222.get(ViewProps.POSITION);
                            if (str2 != null) {
                                c2704c.m7705d(String.valueOf(str2));
                            }
                            c4304d.m7718a(c2704c);
                        }
                        if (map2.containsKey("promoClick")) {
                            c4304d.m7719a("&promoa", "view");
                        } else {
                            c4304d.m7719a("&promoa", "click");
                            if (i != 0) {
                                for (String str322 : f13282k) {
                                    if (map2.containsKey(str322)) {
                                        map2 = (Map) map2.get(str322);
                                        list2 = (List) map2.get("products");
                                        if (list2 != null) {
                                            while (r2.hasNext()) {
                                                c4304d.m7715a(ev.m16899c(b2222));
                                            }
                                        }
                                        if (map2.containsKey("actionField")) {
                                            map2 = (Map) map2.get("actionField");
                                            c2703b = new C2703b(str322);
                                            obj2 = map2.get("id");
                                            if (obj2 != null) {
                                                c2703b.m7692a(String.valueOf(obj2));
                                            }
                                            obj2 = map2.get("affiliation");
                                            if (obj2 != null) {
                                                c2703b.m7695b(String.valueOf(obj2));
                                            }
                                            obj2 = map2.get("coupon");
                                            if (obj2 != null) {
                                                c2703b.m7697c(String.valueOf(obj2));
                                            }
                                            obj2 = map2.get("list");
                                            if (obj2 != null) {
                                                c2703b.m7699e(String.valueOf(obj2));
                                            }
                                            obj2 = map2.get("option");
                                            if (obj2 != null) {
                                                c2703b.m7698d(String.valueOf(obj2));
                                            }
                                            obj2 = map2.get("revenue");
                                            if (obj2 != null) {
                                                c2703b.m7690a(ev.m16892a(obj2).doubleValue());
                                            }
                                            obj2 = map2.get("tax");
                                            if (obj2 != null) {
                                                c2703b.m7694b(ev.m16892a(obj2).doubleValue());
                                            }
                                            obj2 = map2.get("shipping");
                                            if (obj2 != null) {
                                                c2703b.m7696c(ev.m16892a(obj2).doubleValue());
                                            }
                                            obj3 = map2.get("step");
                                            if (obj3 != null) {
                                                c2703b.m7691a(ev.m16897b(obj3).intValue());
                                            }
                                        } else {
                                            c2703b = new C2703b(str322);
                                        }
                                        c4304d.m7717a(c2703b);
                                    }
                                }
                            }
                        }
                    }
                    i = 1;
                    if (i != 0) {
                        for (String str3222 : f13282k) {
                            if (map2.containsKey(str3222)) {
                                map2 = (Map) map2.get(str3222);
                                list2 = (List) map2.get("products");
                                if (list2 != null) {
                                    while (r2.hasNext()) {
                                        c4304d.m7715a(ev.m16899c(b2222));
                                    }
                                }
                                if (map2.containsKey("actionField")) {
                                    c2703b = new C2703b(str3222);
                                } else {
                                    map2 = (Map) map2.get("actionField");
                                    c2703b = new C2703b(str3222);
                                    obj2 = map2.get("id");
                                    if (obj2 != null) {
                                        c2703b.m7692a(String.valueOf(obj2));
                                    }
                                    obj2 = map2.get("affiliation");
                                    if (obj2 != null) {
                                        c2703b.m7695b(String.valueOf(obj2));
                                    }
                                    obj2 = map2.get("coupon");
                                    if (obj2 != null) {
                                        c2703b.m7697c(String.valueOf(obj2));
                                    }
                                    obj2 = map2.get("list");
                                    if (obj2 != null) {
                                        c2703b.m7699e(String.valueOf(obj2));
                                    }
                                    obj2 = map2.get("option");
                                    if (obj2 != null) {
                                        c2703b.m7698d(String.valueOf(obj2));
                                    }
                                    obj2 = map2.get("revenue");
                                    if (obj2 != null) {
                                        c2703b.m7690a(ev.m16892a(obj2).doubleValue());
                                    }
                                    obj2 = map2.get("tax");
                                    if (obj2 != null) {
                                        c2703b.m7694b(ev.m16892a(obj2).doubleValue());
                                    }
                                    obj2 = map2.get("shipping");
                                    if (obj2 != null) {
                                        c2703b.m7696c(ev.m16892a(obj2).doubleValue());
                                    }
                                    obj3 = map2.get("step");
                                    if (obj3 != null) {
                                        c2703b.m7691a(ev.m16897b(obj3).intValue());
                                    }
                                }
                                c4304d.m7717a(c2703b);
                            }
                        }
                    }
                }
                a.m16640a(c4304d.m7721b());
            }
            map2 = null;
            if (map2 != null) {
                str2 = (String) b2222.get("&cu");
                if (str2 == null) {
                    str2 = (String) map2.get("currencyCode");
                }
                if (str2 != null) {
                    c4304d.m7719a("&cu", str2);
                }
                obj = map2.get("impressions");
                if (obj instanceof List) {
                    for (Map b322 : (List) obj) {
                        c4304d.m7716a(ev.m16899c(b322), (String) b322.get("list"));
                    }
                }
                if (!map2.containsKey("promoClick")) {
                    list = (List) ((Map) map2.get("promoClick")).get("promotions");
                } else if (map2.containsKey("promoView")) {
                    list = (List) ((Map) map2.get("promoView")).get("promotions");
                }
                if (r3 != null) {
                    for (Map b22222 : r3) {
                        c2704c = new C2704c();
                        str = (String) b22222.get("id");
                        if (str != null) {
                            c2704c.m7702a(String.valueOf(str));
                        }
                        str = (String) b22222.get("name");
                        if (str != null) {
                            c2704c.m7703b(String.valueOf(str));
                        }
                        str = (String) b22222.get("creative");
                        if (str != null) {
                            c2704c.m7704c(String.valueOf(str));
                        }
                        str2 = (String) b22222.get(ViewProps.POSITION);
                        if (str2 != null) {
                            c2704c.m7705d(String.valueOf(str2));
                        }
                        c4304d.m7718a(c2704c);
                    }
                    if (map2.containsKey("promoClick")) {
                        c4304d.m7719a("&promoa", "click");
                        if (i != 0) {
                            for (String str32222 : f13282k) {
                                if (map2.containsKey(str32222)) {
                                    map2 = (Map) map2.get(str32222);
                                    list2 = (List) map2.get("products");
                                    if (list2 != null) {
                                        while (r2.hasNext()) {
                                            c4304d.m7715a(ev.m16899c(b22222));
                                        }
                                    }
                                    if (map2.containsKey("actionField")) {
                                        map2 = (Map) map2.get("actionField");
                                        c2703b = new C2703b(str32222);
                                        obj2 = map2.get("id");
                                        if (obj2 != null) {
                                            c2703b.m7692a(String.valueOf(obj2));
                                        }
                                        obj2 = map2.get("affiliation");
                                        if (obj2 != null) {
                                            c2703b.m7695b(String.valueOf(obj2));
                                        }
                                        obj2 = map2.get("coupon");
                                        if (obj2 != null) {
                                            c2703b.m7697c(String.valueOf(obj2));
                                        }
                                        obj2 = map2.get("list");
                                        if (obj2 != null) {
                                            c2703b.m7699e(String.valueOf(obj2));
                                        }
                                        obj2 = map2.get("option");
                                        if (obj2 != null) {
                                            c2703b.m7698d(String.valueOf(obj2));
                                        }
                                        obj2 = map2.get("revenue");
                                        if (obj2 != null) {
                                            c2703b.m7690a(ev.m16892a(obj2).doubleValue());
                                        }
                                        obj2 = map2.get("tax");
                                        if (obj2 != null) {
                                            c2703b.m7694b(ev.m16892a(obj2).doubleValue());
                                        }
                                        obj2 = map2.get("shipping");
                                        if (obj2 != null) {
                                            c2703b.m7696c(ev.m16892a(obj2).doubleValue());
                                        }
                                        obj3 = map2.get("step");
                                        if (obj3 != null) {
                                            c2703b.m7691a(ev.m16897b(obj3).intValue());
                                        }
                                    } else {
                                        c2703b = new C2703b(str32222);
                                    }
                                    c4304d.m7717a(c2703b);
                                }
                            }
                        }
                    } else {
                        c4304d.m7719a("&promoa", "view");
                    }
                }
                i = 1;
                if (i != 0) {
                    for (String str322222 : f13282k) {
                        if (map2.containsKey(str322222)) {
                            map2 = (Map) map2.get(str322222);
                            list2 = (List) map2.get("products");
                            if (list2 != null) {
                                while (r2.hasNext()) {
                                    c4304d.m7715a(ev.m16899c(b22222));
                                }
                            }
                            if (map2.containsKey("actionField")) {
                                c2703b = new C2703b(str322222);
                            } else {
                                map2 = (Map) map2.get("actionField");
                                c2703b = new C2703b(str322222);
                                obj2 = map2.get("id");
                                if (obj2 != null) {
                                    c2703b.m7692a(String.valueOf(obj2));
                                }
                                obj2 = map2.get("affiliation");
                                if (obj2 != null) {
                                    c2703b.m7695b(String.valueOf(obj2));
                                }
                                obj2 = map2.get("coupon");
                                if (obj2 != null) {
                                    c2703b.m7697c(String.valueOf(obj2));
                                }
                                obj2 = map2.get("list");
                                if (obj2 != null) {
                                    c2703b.m7699e(String.valueOf(obj2));
                                }
                                obj2 = map2.get("option");
                                if (obj2 != null) {
                                    c2703b.m7698d(String.valueOf(obj2));
                                }
                                obj2 = map2.get("revenue");
                                if (obj2 != null) {
                                    c2703b.m7690a(ev.m16892a(obj2).doubleValue());
                                }
                                obj2 = map2.get("tax");
                                if (obj2 != null) {
                                    c2703b.m7694b(ev.m16892a(obj2).doubleValue());
                                }
                                obj2 = map2.get("shipping");
                                if (obj2 != null) {
                                    c2703b.m7696c(ev.m16892a(obj2).doubleValue());
                                }
                                obj3 = map2.get("step");
                                if (obj3 != null) {
                                    c2703b.m7691a(ev.m16897b(obj3).intValue());
                                }
                            }
                            c4304d.m7717a(c2703b);
                        }
                    }
                }
            }
            a.m16640a(c4304d.m7721b());
        } else if (ev.m16896a(map2, f13274c)) {
            a.m16640a(m16898b((ct) map2.get(f13278g)));
        } else if (ev.m16896a(map2, f13279h)) {
            String a2 = m16893a("transactionId");
            if (a2 == null) {
                bs.m8582a("Cannot find transactionId in data layer.");
                return;
            }
            List arrayList = new ArrayList();
            try {
                Map a3;
                b322 = m16898b((ct) map2.get(f13278g));
                b322.put("&t", "transaction");
                ct ctVar = (ct) map2.get(f13280i);
                if (ctVar != null) {
                    a3 = ev.m16894a(ctVar);
                } else {
                    if (f13285n == null) {
                        a3 = new HashMap();
                        a3.put("transactionId", "&ti");
                        a3.put("transactionAffiliation", "&ta");
                        a3.put("transactionTax", "&tt");
                        a3.put("transactionShipping", "&ts");
                        a3.put("transactionTotal", "&tr");
                        a3.put("transactionCurrency", "&cu");
                        f13285n = a3;
                    }
                    a3 = f13285n;
                }
                for (Entry entry : r6.entrySet()) {
                    ev.m16895a(b322, (String) entry.getValue(), m16893a((String) entry.getKey()));
                }
                arrayList.add(b322);
                Object b4 = this.f13289r.m8618b("transactionProducts");
                if (b4 != null) {
                    if (b4 instanceof List) {
                        for (Object obj4 : (List) b4) {
                            if (!(obj4 instanceof Map)) {
                                throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
                            }
                        }
                        list = (List) b4;
                    } else {
                        throw new IllegalArgumentException("transactionProducts should be of type List.");
                    }
                }
                if (r3 != null) {
                    for (Map b3222 : r3) {
                        if (b3222.get("name") == null) {
                            bs.m8582a("Unable to send transaction item hit due to missing 'name' field.");
                            return;
                        }
                        a3 = m16898b((ct) map2.get(f13278g));
                        a3.put("&t", "item");
                        a3.put("&ti", a2);
                        ct ctVar2 = (ct) map2.get(f13281j);
                        Map a4;
                        if (ctVar2 != null) {
                            a4 = ev.m16894a(ctVar2);
                        } else {
                            if (f13286o == null) {
                                a4 = new HashMap();
                                a4.put("name", "&in");
                                a4.put("sku", "&ic");
                                a4.put("category", "&iv");
                                a4.put("price", "&ip");
                                a4.put("quantity", "&iq");
                                a4.put("currency", "&cu");
                                f13286o = a4;
                            }
                            a4 = f13286o;
                        }
                        for (Entry entry2 : r7.entrySet()) {
                            ev.m16895a(a3, (String) entry2.getValue(), (String) b3222.get(entry2.getKey()));
                        }
                        arrayList.add(a3);
                    }
                }
                ArrayList arrayList2 = (ArrayList) arrayList;
                map2 = arrayList2.size();
                while (i < map2) {
                    Object obj5 = arrayList2.get(i);
                    i++;
                    a.m16640a((Map) obj5);
                }
            } catch (Map<String, ct> map22) {
                bs.m8583a("Unable to send transaction", map22);
            }
        } else {
            bs.m8584b("Ignoring unknown tag.");
        }
    }

    /* renamed from: a */
    private final String m16893a(String str) {
        str = this.f13289r.m8618b(str);
        if (str == null) {
            return null;
        }
        return str.toString();
    }

    /* renamed from: a */
    private static void m16895a(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    /* renamed from: c */
    private static com.google.android.gms.analytics.p171a.C2702a m16899c(java.util.Map<java.lang.String, java.lang.Object> r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = new com.google.android.gms.analytics.a.a;
        r0.<init>();
        r1 = "id";
        r1 = r6.get(r1);
        if (r1 == 0) goto L_0x0014;
    L_0x000d:
        r1 = java.lang.String.valueOf(r1);
        r0.m7681a(r1);
    L_0x0014:
        r1 = "name";
        r1 = r6.get(r1);
        if (r1 == 0) goto L_0x0023;
    L_0x001c:
        r1 = java.lang.String.valueOf(r1);
        r0.m7683b(r1);
    L_0x0023:
        r1 = "brand";
        r1 = r6.get(r1);
        if (r1 == 0) goto L_0x0032;
    L_0x002b:
        r1 = java.lang.String.valueOf(r1);
        r0.m7684c(r1);
    L_0x0032:
        r1 = "category";
        r1 = r6.get(r1);
        if (r1 == 0) goto L_0x0041;
    L_0x003a:
        r1 = java.lang.String.valueOf(r1);
        r0.m7685d(r1);
    L_0x0041:
        r1 = "variant";
        r1 = r6.get(r1);
        if (r1 == 0) goto L_0x0050;
    L_0x0049:
        r1 = java.lang.String.valueOf(r1);
        r0.m7686e(r1);
    L_0x0050:
        r1 = "coupon";
        r1 = r6.get(r1);
        if (r1 == 0) goto L_0x005f;
    L_0x0058:
        r1 = java.lang.String.valueOf(r1);
        r0.m7687f(r1);
    L_0x005f:
        r1 = "position";
        r1 = r6.get(r1);
        if (r1 == 0) goto L_0x0072;
    L_0x0067:
        r1 = com.google.android.gms.p185e.ev.m16897b(r1);
        r1 = r1.intValue();
        r0.m7678a(r1);
    L_0x0072:
        r1 = "price";
        r1 = r6.get(r1);
        if (r1 == 0) goto L_0x0085;
    L_0x007a:
        r1 = com.google.android.gms.p185e.ev.m16892a(r1);
        r1 = r1.doubleValue();
        r0.m7677a(r1);
    L_0x0085:
        r1 = "quantity";
        r1 = r6.get(r1);
        if (r1 == 0) goto L_0x0098;
    L_0x008d:
        r1 = com.google.android.gms.p185e.ev.m16897b(r1);
        r1 = r1.intValue();
        r0.m7682b(r1);
    L_0x0098:
        r1 = r6.keySet();
        r1 = r1.iterator();
    L_0x00a0:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0126;
    L_0x00a6:
        r2 = r1.next();
        r2 = (java.lang.String) r2;
        r3 = f13283l;
        r3 = r3.matcher(r2);
        r4 = r3.matches();
        r5 = 1;
        if (r4 == 0) goto L_0x00e7;
    L_0x00b9:
        r3 = r3.group(r5);	 Catch:{ NumberFormatException -> 0x00cd }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x00cd }
        r2 = r6.get(r2);
        r2 = java.lang.String.valueOf(r2);
        r0.m7680a(r3, r2);
        goto L_0x00a0;
    L_0x00cd:
        r3 = "illegal number in custom dimension value: ";
        r2 = java.lang.String.valueOf(r2);
        r4 = r2.length();
        if (r4 == 0) goto L_0x00de;
    L_0x00d9:
        r2 = r3.concat(r2);
        goto L_0x00e3;
    L_0x00de:
        r2 = new java.lang.String;
        r2.<init>(r3);
    L_0x00e3:
        com.google.android.gms.p185e.bs.m8584b(r2);
        goto L_0x00a0;
    L_0x00e7:
        r3 = f13284m;
        r3 = r3.matcher(r2);
        r4 = r3.matches();
        if (r4 == 0) goto L_0x00a0;
    L_0x00f3:
        r3 = r3.group(r5);	 Catch:{ NumberFormatException -> 0x010b }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x010b }
        r2 = r6.get(r2);
        r2 = com.google.android.gms.p185e.ev.m16897b(r2);
        r2 = r2.intValue();
        r0.m7679a(r3, r2);
        goto L_0x00a0;
    L_0x010b:
        r3 = "illegal number in custom metric value: ";
        r2 = java.lang.String.valueOf(r2);
        r4 = r2.length();
        if (r4 == 0) goto L_0x011c;
    L_0x0117:
        r2 = r3.concat(r2);
        goto L_0x0121;
    L_0x011c:
        r2 = new java.lang.String;
        r2.<init>(r3);
    L_0x0121:
        com.google.android.gms.p185e.bs.m8584b(r2);
        goto L_0x00a0;
    L_0x0126:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.ev.c(java.util.Map):com.google.android.gms.analytics.a.a");
    }

    /* renamed from: a */
    private static Map<String, String> m16894a(ct ctVar) {
        ctVar = eu.m8734f(ctVar);
        if (!(ctVar instanceof Map)) {
            return null;
        }
        Map map = (Map) ctVar;
        Map<String, String> linkedHashMap = new LinkedHashMap();
        for (Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    /* renamed from: b */
    private final Map<String, String> m16898b(ct ctVar) {
        if (ctVar == null) {
            return new HashMap();
        }
        ctVar = ev.m16894a(ctVar);
        if (ctVar == null) {
            return new HashMap();
        }
        String str = (String) ctVar.get("&aip");
        if (str != null && this.f13287p.contains(str.toLowerCase())) {
            ctVar.remove("&aip");
        }
        return ctVar;
    }

    /* renamed from: a */
    private static Double m16892a(Object obj) {
        String str;
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (Object obj2) {
                str = "Cannot convert the object to Double: ";
                obj2 = String.valueOf(obj2.getMessage());
                throw new RuntimeException(obj2.length() != 0 ? str.concat(obj2) : new String(str));
            }
        } else if (obj2 instanceof Integer) {
            return Double.valueOf(((Integer) obj2).doubleValue());
        } else {
            if (obj2 instanceof Double) {
                return (Double) obj2;
            }
            str = "Cannot convert the object to Double: ";
            obj2 = String.valueOf(obj2.toString());
            throw new RuntimeException(obj2.length() != 0 ? str.concat(obj2) : new String(str));
        }
    }

    /* renamed from: b */
    private static Integer m16897b(Object obj) {
        String str;
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (Object obj2) {
                str = "Cannot convert the object to Integer: ";
                obj2 = String.valueOf(obj2.getMessage());
                throw new RuntimeException(obj2.length() != 0 ? str.concat(obj2) : new String(str));
            }
        } else if (obj2 instanceof Double) {
            return Integer.valueOf(((Double) obj2).intValue());
        } else {
            if (obj2 instanceof Integer) {
                return (Integer) obj2;
            }
            str = "Cannot convert the object to Integer: ";
            obj2 = String.valueOf(obj2.toString());
            throw new RuntimeException(obj2.length() != 0 ? str.concat(obj2) : new String(str));
        }
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boolean mo2507a() {
        return super.mo2507a();
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Set mo2513c() {
        return super.mo2513c();
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ String mo2512b() {
        return super.mo2512b();
    }
}
