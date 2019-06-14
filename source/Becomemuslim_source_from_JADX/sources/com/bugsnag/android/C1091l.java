package com.bugsnag.android;

import android.text.TextUtils;
import com.bugsnag.android.NativeInterface.C1068a;
import com.bugsnag.android.NativeInterface.C1069b;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Configuration */
/* renamed from: com.bugsnag.android.l */
public class C1091l extends Observable implements Observer {
    /* renamed from: a */
    private final String f3060a;
    /* renamed from: b */
    private String f3061b;
    /* renamed from: c */
    private String f3062c;
    /* renamed from: d */
    private String f3063d;
    /* renamed from: e */
    private volatile String f3064e = "https://notify.bugsnag.com";
    /* renamed from: f */
    private volatile String f3065f = "https://sessions.bugsnag.com";
    /* renamed from: g */
    private String[] f3066g;
    /* renamed from: h */
    private String[] f3067h = null;
    /* renamed from: i */
    private String[] f3068i;
    /* renamed from: j */
    private String f3069j;
    /* renamed from: k */
    private boolean f3070k = true;
    /* renamed from: l */
    private boolean f3071l = true;
    /* renamed from: m */
    private boolean f3072m = false;
    /* renamed from: n */
    private long f3073n = 5000;
    /* renamed from: o */
    private boolean f3074o = true;
    /* renamed from: p */
    private boolean f3075p = true;
    /* renamed from: q */
    private af f3076q;
    /* renamed from: r */
    private final Collection<C1077c> f3077r = new ConcurrentLinkedQueue();
    /* renamed from: s */
    private final Collection<C1079e> f3078s = new ConcurrentLinkedQueue();
    /* renamed from: t */
    private final Collection<C1078d> f3079t = new ConcurrentLinkedQueue();
    /* renamed from: u */
    private String f3080u;
    /* renamed from: v */
    private String f3081v;
    /* renamed from: w */
    private C1094o f3082w;
    /* renamed from: x */
    private int f3083x = 32;

    public C1091l(String str) {
        this.f3060a = str;
        this.f3076q = new af();
        this.f3076q.addObserver(this);
    }

    public void update(Observable observable, Object obj) {
        if ((obj instanceof C1068a) != null) {
            setChanged();
            notifyObservers(obj);
        }
    }

    /* renamed from: a */
    public String m3829a() {
        return this.f3060a;
    }

    /* renamed from: b */
    public String m3835b() {
        return this.f3062c;
    }

    /* renamed from: a */
    public void m3831a(String str) {
        this.f3062c = str;
        setChanged();
        notifyObservers(new C1068a(C1069b.UPDATE_APP_VERSION, str));
    }

    /* renamed from: c */
    public String m3839c() {
        return this.f3063d;
    }

    /* renamed from: b */
    public void m3836b(String str) {
        this.f3063d = str;
        setChanged();
        notifyObservers(new C1068a(C1069b.UPDATE_CONTEXT, str));
    }

    /* renamed from: d */
    public String m3843d() {
        return this.f3064e;
    }

    @Deprecated
    /* renamed from: c */
    public void m3840c(String str) {
        this.f3064e = str;
    }

    /* renamed from: a */
    public void m3832a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Notify endpoint cannot be empty or null.");
        }
        this.f3064e = str;
        if (TextUtils.isEmpty(str2) != null) {
            ad.m3736b("The session tracking endpoint has not been set. Session tracking is disabled");
            this.f3065f = null;
            this.f3074o = null;
            return;
        }
        this.f3065f = str2;
    }

    /* renamed from: e */
    public String m3846e() {
        return this.f3065f;
    }

    @Deprecated
    /* renamed from: d */
    public void m3844d(String str) {
        this.f3065f = str;
    }

    /* renamed from: f */
    public String m3849f() {
        return this.f3061b;
    }

    /* renamed from: e */
    public void m3847e(String str) {
        this.f3061b = str;
        setChanged();
        notifyObservers(new C1068a(C1069b.UPDATE_BUILD_UUID, str));
    }

    /* renamed from: a */
    public void m3834a(String[] strArr) {
        this.f3066g = strArr;
    }

    /* renamed from: g */
    public String[] m3852g() {
        return this.f3067h;
    }

    /* renamed from: b */
    public void m3838b(String[] strArr) {
        this.f3067h = strArr;
    }

    /* renamed from: h */
    public String[] m3854h() {
        return this.f3068i;
    }

    /* renamed from: c */
    public void m3842c(String[] strArr) {
        this.f3068i = strArr;
    }

    /* renamed from: i */
    public String m3855i() {
        return this.f3069j;
    }

    /* renamed from: f */
    public void m3850f(String str) {
        this.f3069j = str;
        setChanged();
        notifyObservers(new C1068a(C1069b.UPDATE_RELEASE_STAGE, str));
    }

    /* renamed from: j */
    public boolean m3857j() {
        return this.f3070k;
    }

    /* renamed from: a */
    public void m3833a(boolean z) {
        this.f3070k = z;
    }

    /* renamed from: k */
    public boolean m3858k() {
        return this.f3071l;
    }

    /* renamed from: b */
    public void m3837b(boolean z) {
        this.f3071l = z;
    }

    /* renamed from: l */
    public boolean m3859l() {
        return this.f3074o;
    }

    /* renamed from: c */
    public void m3841c(boolean z) {
        this.f3074o = z;
    }

    /* renamed from: m */
    public af m3860m() {
        return this.f3076q;
    }

    /* renamed from: n */
    protected Collection<C1077c> m3861n() {
        return this.f3077r;
    }

    /* renamed from: o */
    protected Collection<C1079e> m3862o() {
        return this.f3078s;
    }

    /* renamed from: p */
    public boolean m3863p() {
        return this.f3072m;
    }

    /* renamed from: d */
    public void m3845d(boolean z) {
        this.f3072m = z;
    }

    /* renamed from: q */
    public long m3864q() {
        return this.f3073n;
    }

    /* renamed from: r */
    public boolean m3865r() {
        return this.f3075p;
    }

    /* renamed from: e */
    public void m3848e(boolean z) {
        this.f3075p = z;
    }

    /* renamed from: s */
    public String m3866s() {
        return this.f3080u;
    }

    /* renamed from: t */
    public String m3867t() {
        return this.f3081v;
    }

    /* renamed from: u */
    public int m3868u() {
        return this.f3083x;
    }

    /* renamed from: v */
    public C1094o m3869v() {
        return this.f3082w;
    }

    /* renamed from: a */
    public void m3830a(C1094o c1094o) {
        if (c1094o != null) {
            this.f3082w = c1094o;
            return;
        }
        throw new IllegalArgumentException("Delivery cannot be null");
    }

    /* renamed from: w */
    public Map<String, String> m3870w() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("Bugsnag-Payload-Version", "4.0");
        hashMap.put("Bugsnag-Api-Key", this.f3060a);
        hashMap.put("Bugsnag-Sent-At", C1093m.m3874a(new Date()));
        return hashMap;
    }

    /* renamed from: x */
    public Map<String, String> m3871x() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("Bugsnag-Payload-Version", "1.0");
        hashMap.put("Bugsnag-Api-Key", this.f3060a);
        hashMap.put("Bugsnag-Sent-At", C1093m.m3874a(new Date()));
        return hashMap;
    }

    /* renamed from: g */
    protected boolean m3851g(String str) {
        if (this.f3067h == null) {
            return true;
        }
        return Arrays.asList(this.f3067h).contains(str);
    }

    /* renamed from: h */
    protected boolean m3853h(String str) {
        if (this.f3066g == null) {
            return null;
        }
        return Arrays.asList(this.f3066g).contains(str);
    }

    /* renamed from: i */
    protected boolean m3856i(String str) {
        if (this.f3068i != null) {
            for (String str2 : this.f3068i) {
                if (str2 != null && str.startsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: y */
    protected Collection<C1078d> m3872y() {
        return this.f3079t;
    }
}
