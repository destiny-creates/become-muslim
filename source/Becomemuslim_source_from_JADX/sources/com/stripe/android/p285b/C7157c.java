package com.stripe.android.p285b;

import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.AnalyticsEvents;
import com.stripe.android.C5712a;
import com.stripe.android.C5756m.C5749d;
import com.stripe.android.C5772r;
import com.stripe.android.C5775u;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Card */
/* renamed from: com.stripe.android.b.c */
public class C7157c extends C5729q implements C5731s {
    /* renamed from: a */
    public static final Map<String, Integer> f25315a = new C57231();
    /* renamed from: b */
    public static final String[] f25316b = new String[]{"34", "37"};
    /* renamed from: c */
    public static final String[] f25317c = new String[]{"60", "62", "64", "65"};
    /* renamed from: d */
    public static final String[] f25318d = new String[]{"35"};
    /* renamed from: e */
    public static final String[] f25319e = new String[]{"300", "301", "302", "303", "304", "305", "309", "36", "38", "39"};
    /* renamed from: f */
    public static final String[] f25320f = new String[]{"4"};
    /* renamed from: g */
    public static final String[] f25321g = new String[]{"2221", "2222", "2223", "2224", "2225", "2226", "2227", "2228", "2229", "223", "224", "225", "226", "227", "228", "229", "23", "24", "25", "26", "270", "271", "2720", "50", "51", "52", "53", "54", "55"};
    /* renamed from: A */
    private String f25322A;
    /* renamed from: B */
    private String f25323B;
    /* renamed from: C */
    private String f25324C;
    /* renamed from: D */
    private List<String> f25325D;
    /* renamed from: E */
    private String f25326E;
    /* renamed from: h */
    private String f25327h;
    /* renamed from: i */
    private String f25328i;
    /* renamed from: j */
    private Integer f25329j;
    /* renamed from: k */
    private Integer f25330k;
    /* renamed from: l */
    private String f25331l;
    /* renamed from: m */
    private String f25332m;
    /* renamed from: n */
    private String f25333n;
    /* renamed from: o */
    private String f25334o;
    /* renamed from: p */
    private String f25335p;
    /* renamed from: q */
    private String f25336q;
    /* renamed from: r */
    private String f25337r;
    /* renamed from: s */
    private String f25338s;
    /* renamed from: t */
    private String f25339t;
    /* renamed from: u */
    private String f25340u;
    /* renamed from: v */
    private String f25341v;
    /* renamed from: w */
    private String f25342w;
    /* renamed from: x */
    private String f25343x;
    /* renamed from: y */
    private String f25344y;
    /* renamed from: z */
    private String f25345z;

    /* compiled from: Card */
    /* renamed from: com.stripe.android.b.c$1 */
    static class C57231 extends HashMap<String, Integer> {
        C57231() {
            put("American Express", Integer.valueOf(C5749d.ic_amex));
            put("Diners Club", Integer.valueOf(C5749d.ic_diners));
            put("Discover", Integer.valueOf(C5749d.ic_discover));
            put("JCB", Integer.valueOf(C5749d.ic_jcb));
            put("MasterCard", Integer.valueOf(C5749d.ic_mastercard));
            put("Visa", Integer.valueOf(C5749d.ic_visa));
            put(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, Integer.valueOf(C5749d.ic_unknown));
        }
    }

    /* compiled from: Card */
    /* renamed from: com.stripe.android.b.c$a */
    public static class C5724a {
        /* renamed from: a */
        private final String f19057a;
        /* renamed from: b */
        private final String f19058b;
        /* renamed from: c */
        private final Integer f19059c;
        /* renamed from: d */
        private final Integer f19060d;
        /* renamed from: e */
        private String f19061e;
        /* renamed from: f */
        private String f19062f;
        /* renamed from: g */
        private String f19063g;
        /* renamed from: h */
        private String f19064h;
        /* renamed from: i */
        private String f19065i;
        /* renamed from: j */
        private String f19066j;
        /* renamed from: k */
        private String f19067k;
        /* renamed from: l */
        private String f19068l;
        /* renamed from: m */
        private String f19069m;
        /* renamed from: n */
        private String f19070n;
        /* renamed from: o */
        private String f19071o;
        /* renamed from: p */
        private String f19072p;
        /* renamed from: q */
        private String f19073q;
        /* renamed from: r */
        private String f19074r;
        /* renamed from: s */
        private String f19075s;
        /* renamed from: t */
        private String f19076t;
        /* renamed from: u */
        private String f19077u;
        /* renamed from: v */
        private String f19078v;
        /* renamed from: w */
        private String f19079w;

        public C5724a(String str, Integer num, Integer num2, String str2) {
            this.f19057a = str;
            this.f19059c = num;
            this.f19060d = num2;
            this.f19058b = str2;
        }

        /* renamed from: a */
        public C5724a m24220a(String str) {
            this.f19061e = str;
            return this;
        }

        /* renamed from: b */
        public C5724a m24222b(String str) {
            this.f19062f = str;
            return this;
        }

        /* renamed from: c */
        public C5724a m24223c(String str) {
            this.f19063g = str;
            return this;
        }

        /* renamed from: d */
        public C5724a m24224d(String str) {
            this.f19064h = str;
            return this;
        }

        /* renamed from: e */
        public C5724a m24225e(String str) {
            this.f19065i = str;
            return this;
        }

        /* renamed from: f */
        public C5724a m24226f(String str) {
            this.f19066j = str;
            return this;
        }

        /* renamed from: g */
        public C5724a m24227g(String str) {
            this.f19067k = str;
            return this;
        }

        /* renamed from: h */
        public C5724a m24228h(String str) {
            this.f19068l = str;
            return this;
        }

        /* renamed from: i */
        public C5724a m24229i(String str) {
            this.f19069m = str;
            return this;
        }

        /* renamed from: j */
        public C5724a m24230j(String str) {
            this.f19070n = str;
            return this;
        }

        /* renamed from: k */
        public C5724a m24231k(String str) {
            this.f19073q = str;
            return this;
        }

        /* renamed from: l */
        public C5724a m24232l(String str) {
            this.f19071o = str;
            return this;
        }

        /* renamed from: m */
        public C5724a m24233m(String str) {
            this.f19074r = str;
            return this;
        }

        /* renamed from: n */
        public C5724a m24234n(String str) {
            this.f19075s = str;
            return this;
        }

        /* renamed from: o */
        public C5724a m24235o(String str) {
            this.f19076t = str;
            return this;
        }

        /* renamed from: p */
        public C5724a m24236p(String str) {
            this.f19077u = str;
            return this;
        }

        /* renamed from: q */
        public C5724a m24237q(String str) {
            this.f19072p = str;
            return this;
        }

        /* renamed from: r */
        public C5724a m24238r(String str) {
            this.f19078v = str;
            return this;
        }

        /* renamed from: s */
        public C5724a m24239s(String str) {
            this.f19079w = str;
            return this;
        }

        /* renamed from: a */
        public C7157c m24221a() {
            return new C7157c();
        }
    }

    /* renamed from: a */
    public static String m33214a(String str) {
        if (str != null) {
            if (!TextUtils.isEmpty(str.trim())) {
                if ("American Express".equalsIgnoreCase(str)) {
                    return "American Express";
                }
                if ("MasterCard".equalsIgnoreCase(str)) {
                    return "MasterCard";
                }
                if ("Diners Club".equalsIgnoreCase(str)) {
                    return "Diners Club";
                }
                if ("Discover".equalsIgnoreCase(str)) {
                    return "Discover";
                }
                if ("JCB".equalsIgnoreCase(str)) {
                    return "JCB";
                }
                return "Visa".equalsIgnoreCase(str) != null ? "Visa" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static String m33215b(String str) {
        if (str != null) {
            if (!TextUtils.isEmpty(str.trim())) {
                if ("credit".equalsIgnoreCase(str)) {
                    return "credit";
                }
                if ("debit".equalsIgnoreCase(str)) {
                    return "debit";
                }
                return "prepaid".equalsIgnoreCase(str) != null ? "prepaid" : "unknown";
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C7157c m33213a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if ("card".equals(jSONObject.optString("object"))) {
                Integer b = C5730r.m24285b(jSONObject, "exp_month");
                Integer b2 = C5730r.m24285b(jSONObject, "exp_year");
                if (b != null && (b.intValue() < 1 || b.intValue() > 12)) {
                    b = null;
                }
                if (b2 != null && b2.intValue() < 0) {
                    b2 = null;
                }
                C5724a c5724a = new C5724a(null, b, b2, null);
                c5724a.m24225e(C5730r.m24288d(jSONObject, "address_city"));
                c5724a.m24222b(C5730r.m24288d(jSONObject, "address_line1"));
                c5724a.m24223c(C5730r.m24288d(jSONObject, "address_line1_check"));
                c5724a.m24224d(C5730r.m24288d(jSONObject, "address_line2"));
                c5724a.m24229i(C5730r.m24288d(jSONObject, "address_country"));
                c5724a.m24226f(C5730r.m24288d(jSONObject, "address_state"));
                c5724a.m24227g(C5730r.m24288d(jSONObject, "address_zip"));
                c5724a.m24228h(C5730r.m24288d(jSONObject, "address_zip_check"));
                c5724a.m24230j(C7157c.m33214a(C5730r.m24288d(jSONObject, "brand")));
                c5724a.m24233m(C5730r.m24289e(jSONObject, UserDataStore.COUNTRY));
                c5724a.m24235o(C5730r.m24288d(jSONObject, "customer"));
                c5724a.m24234n(C5730r.m24290f(jSONObject, "currency"));
                c5724a.m24236p(C5730r.m24288d(jSONObject, "cvc_check"));
                c5724a.m24232l(C7157c.m33215b(C5730r.m24288d(jSONObject, "funding")));
                c5724a.m24231k(C5730r.m24288d(jSONObject, "fingerprint"));
                c5724a.m24238r(C5730r.m24288d(jSONObject, "id"));
                c5724a.m24237q(C5730r.m24288d(jSONObject, "last4"));
                c5724a.m24220a(C5730r.m24288d(jSONObject, "name"));
                c5724a.m24239s(C5730r.m24288d(jSONObject, "tokenization_method"));
                return c5724a.m24221a();
            }
        }
        return null;
    }

    public C7157c(String str, Integer num, Integer num2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        this.f25325D = new ArrayList();
        this.f25327h = C5775u.m24416a(m33216e(str));
        this.f25329j = num;
        this.f25330k = num2;
        this.f25328i = C5775u.m24416a(str2);
        this.f25331l = C5775u.m24416a(str3);
        this.f25332m = C5775u.m24416a(str4);
        this.f25334o = C5775u.m24416a(str5);
        this.f25335p = C5775u.m24416a(str6);
        this.f25336q = C5775u.m24416a(str7);
        this.f25337r = C5775u.m24416a(str8);
        this.f25339t = C5775u.m24416a(str9);
        r0.f25341v = C7157c.m33214a(str10) == null ? m33241u() : str10;
        r0.f25340u = C5775u.m24416a(str11) == null ? m33240t() : str11;
        r0.f25343x = C5775u.m24416a(str12);
        r0.f25342w = C7157c.m33215b(str13);
        r0.f25344y = C5775u.m24416a(str14);
        r0.f25345z = C5775u.m24416a(str15);
        r0.f25324C = C5775u.m24416a(str16);
    }

    public C7157c(String str, Integer num, Integer num2, String str2) {
        this(str, num, num2, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /* renamed from: c */
    public boolean m33222c() {
        return C5712a.m24161b(this.f25327h);
    }

    /* renamed from: d */
    public boolean m33224d() {
        return m33220b(Calendar.getInstance());
    }

    /* renamed from: e */
    public boolean m33225e() {
        boolean z = false;
        if (C5775u.m24419b(this.f25328i)) {
            return false;
        }
        String trim = this.f25328i.trim();
        String u = m33241u();
        Object obj = ((u != null || trim.length() < 3 || trim.length() > 4) && !(("American Express".equals(u) && trim.length() == 4) || trim.length() == 3)) ? null : 1;
        if (C5725f.m24242a(trim) && obj != null) {
            z = true;
        }
        return z;
    }

    /* renamed from: f */
    public boolean m33226f() {
        return this.f25329j != null && this.f25329j.intValue() >= 1 && this.f25329j.intValue() <= 12;
    }

    /* renamed from: a */
    boolean m33218a(Calendar calendar) {
        return (this.f25330k == null || C5725f.m24241a(this.f25330k.intValue(), calendar) != null) ? null : true;
    }

    /* renamed from: g */
    public String m33227g() {
        return this.f25327h;
    }

    /* renamed from: h */
    public List<String> m33228h() {
        return this.f25325D;
    }

    /* renamed from: c */
    public C7157c m33221c(String str) {
        this.f25325D.add(str);
        return this;
    }

    /* renamed from: i */
    public String m33229i() {
        return this.f25328i;
    }

    /* renamed from: j */
    public Integer m33230j() {
        return this.f25329j;
    }

    /* renamed from: k */
    public Integer m33231k() {
        return this.f25330k;
    }

    /* renamed from: l */
    public String m33232l() {
        return this.f25331l;
    }

    /* renamed from: m */
    public String m33233m() {
        return this.f25332m;
    }

    /* renamed from: n */
    public String m33234n() {
        return this.f25334o;
    }

    /* renamed from: o */
    public String m33235o() {
        return this.f25335p;
    }

    /* renamed from: p */
    public String m33236p() {
        return this.f25337r;
    }

    /* renamed from: d */
    public void m33223d(String str) {
        this.f25337r = str;
    }

    /* renamed from: q */
    public String m33237q() {
        return this.f25336q;
    }

    /* renamed from: r */
    public String m33238r() {
        return this.f25339t;
    }

    /* renamed from: s */
    public String m33239s() {
        return this.f25345z;
    }

    /* renamed from: t */
    public String m33240t() {
        if (!C5775u.m24419b(this.f25340u)) {
            return this.f25340u;
        }
        if (this.f25327h == null || this.f25327h.length() <= 4) {
            return null;
        }
        this.f25340u = this.f25327h.substring(this.f25327h.length() - 4, this.f25327h.length());
        return this.f25340u;
    }

    /* renamed from: u */
    public String m33241u() {
        if (C5775u.m24419b(this.f25341v) && !C5775u.m24419b(this.f25327h)) {
            this.f25341v = C5712a.m24158a(this.f25327h);
        }
        return this.f25341v;
    }

    /* renamed from: v */
    public String m33242v() {
        return this.f25343x;
    }

    /* renamed from: w */
    public String m33243w() {
        return this.f25342w;
    }

    /* renamed from: x */
    public String m33244x() {
        return this.f25344y;
    }

    /* renamed from: y */
    public String mo5067y() {
        return this.f25324C;
    }

    /* renamed from: a */
    public JSONObject mo5065a() {
        JSONObject jSONObject = new JSONObject();
        C5730r.m24283a(jSONObject, "name", this.f25331l);
        C5730r.m24283a(jSONObject, "address_city", this.f25335p);
        C5730r.m24283a(jSONObject, "address_country", this.f25339t);
        C5730r.m24283a(jSONObject, "address_line1", this.f25332m);
        C5730r.m24283a(jSONObject, "address_line1_check", this.f25333n);
        C5730r.m24283a(jSONObject, "address_line2", this.f25334o);
        C5730r.m24283a(jSONObject, "address_state", this.f25336q);
        C5730r.m24283a(jSONObject, "address_zip", this.f25337r);
        C5730r.m24283a(jSONObject, "address_zip_check", this.f25338s);
        C5730r.m24283a(jSONObject, "brand", this.f25341v);
        C5730r.m24283a(jSONObject, "currency", this.f25345z);
        C5730r.m24283a(jSONObject, UserDataStore.COUNTRY, this.f25344y);
        C5730r.m24283a(jSONObject, "customer", this.f25322A);
        C5730r.m24281a(jSONObject, "exp_month", this.f25329j);
        C5730r.m24281a(jSONObject, "exp_year", this.f25330k);
        C5730r.m24283a(jSONObject, "fingerprint", this.f25343x);
        C5730r.m24283a(jSONObject, "funding", this.f25342w);
        C5730r.m24283a(jSONObject, "cvc_check", this.f25323B);
        C5730r.m24283a(jSONObject, "last4", this.f25340u);
        C5730r.m24283a(jSONObject, "id", this.f25324C);
        C5730r.m24283a(jSONObject, "tokenization_method", this.f25326E);
        C5730r.m24283a(jSONObject, "object", "card");
        return jSONObject;
    }

    /* renamed from: b */
    public Map<String, Object> mo5066b() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("name", this.f25331l);
        hashMap.put("address_city", this.f25335p);
        hashMap.put("address_country", this.f25339t);
        hashMap.put("address_line1", this.f25332m);
        hashMap.put("address_line1_check", this.f25333n);
        hashMap.put("address_line2", this.f25334o);
        hashMap.put("address_state", this.f25336q);
        hashMap.put("address_zip", this.f25337r);
        hashMap.put("address_zip_check", this.f25338s);
        hashMap.put("brand", this.f25341v);
        hashMap.put("currency", this.f25345z);
        hashMap.put(UserDataStore.COUNTRY, this.f25344y);
        hashMap.put("customer", this.f25322A);
        hashMap.put("cvc_check", this.f25323B);
        hashMap.put("exp_month", this.f25329j);
        hashMap.put("exp_year", this.f25330k);
        hashMap.put("fingerprint", this.f25343x);
        hashMap.put("funding", this.f25342w);
        hashMap.put("id", this.f25324C);
        hashMap.put("last4", this.f25340u);
        hashMap.put("tokenization_method", this.f25326E);
        hashMap.put("object", "card");
        C5772r.m24411a(hashMap);
        return hashMap;
    }

    /* renamed from: z */
    String m33246z() {
        return this.f25326E;
    }

    /* renamed from: b */
    boolean m33220b(Calendar calendar) {
        if (m33226f() && m33218a(calendar)) {
            return C5725f.m24240a(this.f25330k.intValue(), this.f25329j.intValue(), calendar) ^ 1;
        }
        return false;
    }

    private C7157c(C5724a c5724a) {
        String t;
        this.f25325D = new ArrayList();
        this.f25327h = C5775u.m24416a(m33216e(c5724a.f19057a));
        this.f25329j = c5724a.f19059c;
        this.f25330k = c5724a.f19060d;
        this.f25328i = C5775u.m24416a(c5724a.f19058b);
        this.f25331l = C5775u.m24416a(c5724a.f19061e);
        this.f25332m = C5775u.m24416a(c5724a.f19062f);
        this.f25333n = C5775u.m24416a(c5724a.f19063g);
        this.f25334o = C5775u.m24416a(c5724a.f19064h);
        this.f25335p = C5775u.m24416a(c5724a.f19065i);
        this.f25336q = C5775u.m24416a(c5724a.f19066j);
        this.f25337r = C5775u.m24416a(c5724a.f19067k);
        this.f25338s = C5775u.m24416a(c5724a.f19068l);
        this.f25339t = C5775u.m24416a(c5724a.f19069m);
        if (C5775u.m24416a(c5724a.f19072p) == null) {
            t = m33240t();
        } else {
            t = c5724a.f19072p;
        }
        this.f25340u = t;
        if (C7157c.m33214a(c5724a.f19070n) == null) {
            t = m33241u();
        } else {
            t = c5724a.f19070n;
        }
        this.f25341v = t;
        this.f25343x = C5775u.m24416a(c5724a.f19073q);
        this.f25342w = C7157c.m33215b(c5724a.f19071o);
        this.f25344y = C5775u.m24416a(c5724a.f19074r);
        this.f25345z = C5775u.m24416a(c5724a.f19075s);
        this.f25322A = C5775u.m24416a(c5724a.f19076t);
        this.f25323B = C5775u.m24416a(c5724a.f19077u);
        this.f25324C = C5775u.m24416a(c5724a.f19078v);
        this.f25326E = C5775u.m24416a(c5724a.f19079w);
    }

    /* renamed from: e */
    private String m33216e(String str) {
        return str == null ? null : str.trim().replaceAll("\\s+|-", "");
    }
}
