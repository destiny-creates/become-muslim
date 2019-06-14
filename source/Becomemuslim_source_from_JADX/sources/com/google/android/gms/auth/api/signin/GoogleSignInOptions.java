package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.C2741b;
import com.google.android.gms.auth.api.signin.internal.C4752a;
import com.google.android.gms.common.api.C2781a.C2779d.C4767e;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInOptions extends C4363a implements C4767e, ReflectedParcelable {
    public static final Creator<GoogleSignInOptions> CREATOR = new C2740i();
    /* renamed from: a */
    public static final Scope f13940a = new Scope("profile");
    /* renamed from: b */
    public static final Scope f13941b = new Scope("email");
    /* renamed from: c */
    public static final Scope f13942c = new Scope("openid");
    /* renamed from: d */
    public static final Scope f13943d = new Scope("https://www.googleapis.com/auth/games_lite");
    /* renamed from: e */
    public static final Scope f13944e = new Scope("https://www.googleapis.com/auth/games");
    /* renamed from: f */
    public static final GoogleSignInOptions f13945f = new C2733a().m7783a().m7789c().m7791d();
    /* renamed from: g */
    public static final GoogleSignInOptions f13946g = new C2733a().m7784a(f13943d, new Scope[0]).m7791d();
    /* renamed from: r */
    private static Comparator<Scope> f13947r = new C2739h();
    /* renamed from: h */
    private final int f13948h;
    /* renamed from: i */
    private final ArrayList<Scope> f13949i;
    /* renamed from: j */
    private Account f13950j;
    /* renamed from: k */
    private boolean f13951k;
    /* renamed from: l */
    private final boolean f13952l;
    /* renamed from: m */
    private final boolean f13953m;
    /* renamed from: n */
    private String f13954n;
    /* renamed from: o */
    private String f13955o;
    /* renamed from: p */
    private ArrayList<C4752a> f13956p;
    /* renamed from: q */
    private Map<Integer, C4752a> f13957q;

    /* renamed from: com.google.android.gms.auth.api.signin.GoogleSignInOptions$a */
    public static final class C2733a {
        /* renamed from: a */
        private Set<Scope> f7015a = new HashSet();
        /* renamed from: b */
        private boolean f7016b;
        /* renamed from: c */
        private boolean f7017c;
        /* renamed from: d */
        private boolean f7018d;
        /* renamed from: e */
        private String f7019e;
        /* renamed from: f */
        private Account f7020f;
        /* renamed from: g */
        private String f7021g;
        /* renamed from: h */
        private Map<Integer, C4752a> f7022h = new HashMap();

        public C2733a(GoogleSignInOptions googleSignInOptions) {
            C2872v.m8380a((Object) googleSignInOptions);
            this.f7015a = new HashSet(googleSignInOptions.f13949i);
            this.f7016b = googleSignInOptions.f13952l;
            this.f7017c = googleSignInOptions.f13953m;
            this.f7018d = googleSignInOptions.f13951k;
            this.f7019e = googleSignInOptions.f13954n;
            this.f7020f = googleSignInOptions.f13950j;
            this.f7021g = googleSignInOptions.f13955o;
            this.f7022h = GoogleSignInOptions.m17446b(googleSignInOptions.f13956p);
        }

        /* renamed from: a */
        public final C2733a m7783a() {
            this.f7015a.add(GoogleSignInOptions.f13942c);
            return this;
        }

        /* renamed from: b */
        public final C2733a m7787b() {
            this.f7015a.add(GoogleSignInOptions.f13941b);
            return this;
        }

        /* renamed from: c */
        public final C2733a m7789c() {
            this.f7015a.add(GoogleSignInOptions.f13940a);
            return this;
        }

        /* renamed from: a */
        public final C2733a m7784a(Scope scope, Scope... scopeArr) {
            this.f7015a.add(scope);
            this.f7015a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        /* renamed from: a */
        public final C2733a m7785a(String str) {
            this.f7018d = true;
            this.f7019e = m7782d(str);
            return this;
        }

        /* renamed from: a */
        public final C2733a m7786a(String str, boolean z) {
            this.f7016b = true;
            this.f7019e = m7782d(str);
            this.f7017c = z;
            return this;
        }

        /* renamed from: b */
        public final C2733a m7788b(String str) {
            this.f7020f = new Account(C2872v.m8382a(str), "com.google");
            return this;
        }

        /* renamed from: c */
        public final C2733a m7790c(String str) {
            this.f7021g = C2872v.m8382a(str);
            return this;
        }

        /* renamed from: d */
        public final GoogleSignInOptions m7791d() {
            if (this.f7015a.contains(GoogleSignInOptions.f13944e) && this.f7015a.contains(GoogleSignInOptions.f13943d)) {
                this.f7015a.remove(GoogleSignInOptions.f13943d);
            }
            if (this.f7018d && (this.f7020f == null || !this.f7015a.isEmpty())) {
                m7783a();
            }
            return new GoogleSignInOptions(new ArrayList(this.f7015a), this.f7020f, this.f7018d, this.f7016b, this.f7017c, this.f7019e, this.f7021g, this.f7022h);
        }

        /* renamed from: d */
        private final String m7782d(String str) {
            boolean z;
            C2872v.m8382a(str);
            if (this.f7019e != null) {
                if (!this.f7019e.equals(str)) {
                    z = false;
                    C2872v.m8391b(z, "two different server client ids provided");
                    return str;
                }
            }
            z = true;
            C2872v.m8391b(z, "two different server client ids provided");
            return str;
        }
    }

    /* renamed from: a */
    public static GoogleSignInOptions m17443a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        str = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            str.add(new Scope(jSONArray.getString(i)));
        }
        Object optString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(3, new ArrayList(str), !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap());
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, ArrayList<C4752a> arrayList2) {
        this(i, (ArrayList) arrayList, account, z, z2, z3, str, str2, m17446b((List) arrayList2));
    }

    private GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, C4752a> map) {
        this.f13948h = i;
        this.f13949i = arrayList;
        this.f13950j = account;
        this.f13951k = z;
        this.f13952l = z2;
        this.f13953m = z3;
        this.f13954n = str;
        this.f13955o = str2;
        this.f13956p = new ArrayList(map.values());
        this.f13957q = map;
    }

    /* renamed from: a */
    public ArrayList<Scope> m17455a() {
        return new ArrayList(this.f13949i);
    }

    /* renamed from: b */
    public Account m17456b() {
        return this.f13950j;
    }

    /* renamed from: c */
    public boolean m17457c() {
        return this.f13951k;
    }

    /* renamed from: d */
    public boolean m17458d() {
        return this.f13952l;
    }

    /* renamed from: e */
    public boolean m17459e() {
        return this.f13953m;
    }

    /* renamed from: f */
    public String m17460f() {
        return this.f13954n;
    }

    /* renamed from: g */
    public ArrayList<C4752a> m17461g() {
        return this.f13956p;
    }

    /* renamed from: b */
    private static Map<Integer, C4752a> m17446b(List<C4752a> list) {
        Map<Integer, C4752a> hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (C4752a c4752a : list) {
            hashMap.put(Integer.valueOf(c4752a.m16673a()), c4752a);
        }
        return hashMap;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, this.f13948h);
        C2835c.m8207c(parcel, 2, m17455a(), false);
        C2835c.m8188a(parcel, 3, m17456b(), i, false);
        C2835c.m8196a(parcel, 4, m17457c());
        C2835c.m8196a(parcel, 5, m17458d());
        C2835c.m8196a(parcel, 6, m17459e());
        C2835c.m8193a(parcel, 7, m17460f(), false);
        C2835c.m8193a(parcel, 8, this.f13955o, false);
        C2835c.m8207c(parcel, 9, m17461g(), false);
        C2835c.m8180a(parcel, a);
    }

    public boolean equals(java.lang.Object r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4;	 Catch:{ ClassCastException -> 0x0088 }
        r1 = r3.f13956p;	 Catch:{ ClassCastException -> 0x0088 }
        r1 = r1.size();	 Catch:{ ClassCastException -> 0x0088 }
        if (r1 > 0) goto L_0x0087;	 Catch:{ ClassCastException -> 0x0088 }
    L_0x000e:
        r1 = r4.f13956p;	 Catch:{ ClassCastException -> 0x0088 }
        r1 = r1.size();	 Catch:{ ClassCastException -> 0x0088 }
        if (r1 <= 0) goto L_0x0018;	 Catch:{ ClassCastException -> 0x0088 }
    L_0x0016:
        goto L_0x0087;	 Catch:{ ClassCastException -> 0x0088 }
    L_0x0018:
        r1 = r3.f13949i;	 Catch:{ ClassCastException -> 0x0088 }
        r1 = r1.size();	 Catch:{ ClassCastException -> 0x0088 }
        r2 = r4.m17455a();	 Catch:{ ClassCastException -> 0x0088 }
        r2 = r2.size();	 Catch:{ ClassCastException -> 0x0088 }
        if (r1 != r2) goto L_0x0086;	 Catch:{ ClassCastException -> 0x0088 }
    L_0x0028:
        r1 = r3.f13949i;	 Catch:{ ClassCastException -> 0x0088 }
        r2 = r4.m17455a();	 Catch:{ ClassCastException -> 0x0088 }
        r1 = r1.containsAll(r2);	 Catch:{ ClassCastException -> 0x0088 }
        if (r1 != 0) goto L_0x0035;	 Catch:{ ClassCastException -> 0x0088 }
    L_0x0034:
        goto L_0x0086;	 Catch:{ ClassCastException -> 0x0088 }
    L_0x0035:
        r1 = r3.f13950j;	 Catch:{ ClassCastException -> 0x0088 }
        if (r1 != 0) goto L_0x0040;	 Catch:{ ClassCastException -> 0x0088 }
    L_0x0039:
        r1 = r4.m17456b();	 Catch:{ ClassCastException -> 0x0088 }
        if (r1 != 0) goto L_0x0085;	 Catch:{ ClassCastException -> 0x0088 }
    L_0x003f:
        goto L_0x004c;	 Catch:{ ClassCastException -> 0x0088 }
    L_0x0040:
        r1 = r3.f13950j;	 Catch:{ ClassCastException -> 0x0088 }
        r2 = r4.m17456b();	 Catch:{ ClassCastException -> 0x0088 }
        r1 = r1.equals(r2);	 Catch:{ ClassCastException -> 0x0088 }
        if (r1 == 0) goto L_0x0085;	 Catch:{ ClassCastException -> 0x0088 }
    L_0x004c:
        r1 = r3.f13954n;	 Catch:{ ClassCastException -> 0x0088 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ ClassCastException -> 0x0088 }
        if (r1 == 0) goto L_0x005f;	 Catch:{ ClassCastException -> 0x0088 }
    L_0x0054:
        r1 = r4.m17460f();	 Catch:{ ClassCastException -> 0x0088 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ ClassCastException -> 0x0088 }
        if (r1 == 0) goto L_0x0085;	 Catch:{ ClassCastException -> 0x0088 }
    L_0x005e:
        goto L_0x006b;	 Catch:{ ClassCastException -> 0x0088 }
    L_0x005f:
        r1 = r3.f13954n;	 Catch:{ ClassCastException -> 0x0088 }
        r2 = r4.m17460f();	 Catch:{ ClassCastException -> 0x0088 }
        r1 = r1.equals(r2);	 Catch:{ ClassCastException -> 0x0088 }
        if (r1 == 0) goto L_0x0085;	 Catch:{ ClassCastException -> 0x0088 }
    L_0x006b:
        r1 = r3.f13953m;	 Catch:{ ClassCastException -> 0x0088 }
        r2 = r4.m17459e();	 Catch:{ ClassCastException -> 0x0088 }
        if (r1 != r2) goto L_0x0085;	 Catch:{ ClassCastException -> 0x0088 }
    L_0x0073:
        r1 = r3.f13951k;	 Catch:{ ClassCastException -> 0x0088 }
        r2 = r4.m17457c();	 Catch:{ ClassCastException -> 0x0088 }
        if (r1 != r2) goto L_0x0085;	 Catch:{ ClassCastException -> 0x0088 }
    L_0x007b:
        r1 = r3.f13952l;	 Catch:{ ClassCastException -> 0x0088 }
        r4 = r4.m17458d();	 Catch:{ ClassCastException -> 0x0088 }
        if (r1 != r4) goto L_0x0085;
    L_0x0083:
        r4 = 1;
        return r4;
    L_0x0085:
        return r0;
    L_0x0086:
        return r0;
    L_0x0087:
        return r0;
    L_0x0088:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Object arrayList = new ArrayList();
        ArrayList arrayList2 = this.f13949i;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            arrayList.add(((Scope) obj).m16700a());
        }
        Collections.sort(arrayList);
        return new C2741b().m7798a(arrayList).m7798a(this.f13950j).m7798a(this.f13954n).m7799a(this.f13953m).m7799a(this.f13951k).m7799a(this.f13952l).m7797a();
    }

    /* renamed from: h */
    public final String m17462h() {
        return m17454i().toString();
    }

    /* renamed from: i */
    private final JSONObject m17454i() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f13949i, f13947r);
            ArrayList arrayList = this.f13949i;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                jSONArray.put(((Scope) obj).m16700a());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.f13950j != null) {
                jSONObject.put("accountName", this.f13950j.name);
            }
            jSONObject.put("idTokenRequested", this.f13951k);
            jSONObject.put("forceCodeForRefreshToken", this.f13953m);
            jSONObject.put("serverAuthRequested", this.f13952l);
            if (!TextUtils.isEmpty(this.f13954n)) {
                jSONObject.put("serverClientId", this.f13954n);
            }
            if (!TextUtils.isEmpty(this.f13955o)) {
                jSONObject.put("hostedDomain", this.f13955o);
            }
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
