package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.eg.C4925a;
import java.util.Collections;
import java.util.Map;

public abstract class awi<T> implements Comparable<awi<T>> {
    /* renamed from: a */
    private final C4925a f15016a;
    /* renamed from: b */
    private final int f15017b;
    /* renamed from: c */
    private final String f15018c;
    /* renamed from: d */
    private final int f15019d;
    /* renamed from: e */
    private final Object f15020e;
    /* renamed from: f */
    private bdl f15021f;
    /* renamed from: g */
    private Integer f15022g;
    /* renamed from: h */
    private bai f15023h;
    /* renamed from: i */
    private boolean f15024i;
    /* renamed from: j */
    private boolean f15025j;
    /* renamed from: k */
    private boolean f15026k;
    /* renamed from: l */
    private boolean f15027l;
    /* renamed from: m */
    private ac f15028m;
    /* renamed from: n */
    private agz f15029n;
    /* renamed from: o */
    private ayg f15030o;

    public awi(int i, String str, bdl bdl) {
        this.f15016a = C4925a.f15331a ? new C4925a() : null;
        this.f15020e = new Object();
        this.f15024i = true;
        int i2 = 0;
        this.f15025j = false;
        this.f15026k = false;
        this.f15027l = false;
        this.f15029n = null;
        this.f15017b = i;
        this.f15018c = str;
        this.f15021f = bdl;
        this.f15028m = new ame();
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    i2 = host.hashCode();
                }
            }
        }
        this.f15019d = i2;
    }

    /* renamed from: a */
    public final awi<?> m19051a(int i) {
        this.f15022g = Integer.valueOf(i);
        return this;
    }

    /* renamed from: a */
    public final awi<?> m19052a(agz agz) {
        this.f15029n = agz;
        return this;
    }

    /* renamed from: a */
    public final awi<?> m19053a(bai bai) {
        this.f15023h = bai;
        return this;
    }

    /* renamed from: a */
    protected abstract bck<T> mo4314a(aug aug);

    /* renamed from: a */
    final void m19055a(ayg ayg) {
        synchronized (this.f15020e) {
            this.f15030o = ayg;
        }
    }

    /* renamed from: a */
    final void m19056a(bck<?> bck) {
        synchronized (this.f15020e) {
            ayg ayg = this.f15030o;
        }
        if (ayg != null) {
            ayg.mo3835a(this, bck);
        }
    }

    /* renamed from: a */
    public final void m19057a(df dfVar) {
        synchronized (this.f15020e) {
            bdl bdl = this.f15021f;
        }
        if (bdl != null) {
            bdl.mo4310a(dfVar);
        }
    }

    /* renamed from: a */
    protected abstract void mo4315a(T t);

    /* renamed from: a */
    public byte[] mo6108a() {
        return null;
    }

    /* renamed from: b */
    public Map<String, String> mo6109b() {
        return Collections.emptyMap();
    }

    /* renamed from: b */
    public final void m19061b(String str) {
        if (C4925a.f15331a) {
            this.f15016a.m19387a(str, Thread.currentThread().getId());
        }
    }

    /* renamed from: c */
    public final int m19062c() {
        return this.f15017b;
    }

    /* renamed from: c */
    final void m19063c(String str) {
        if (this.f15023h != null) {
            this.f15023h.m19195b(this);
        }
        if (C4925a.f15331a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new axi(this, str, id));
            } else {
                this.f15016a.m19387a(str, id);
                this.f15016a.m19386a(toString());
            }
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        awi awi = (awi) obj;
        azh azh = azh.NORMAL;
        azh azh2 = azh.NORMAL;
        return azh == azh2 ? this.f15022g.intValue() - awi.f15022g.intValue() : azh2.ordinal() - azh.ordinal();
    }

    /* renamed from: d */
    public final int m19064d() {
        return this.f15019d;
    }

    /* renamed from: e */
    public final String m19065e() {
        return this.f15018c;
    }

    /* renamed from: f */
    public final agz m19066f() {
        return this.f15029n;
    }

    /* renamed from: g */
    public final boolean m19067g() {
        synchronized (this.f15020e) {
        }
        return false;
    }

    /* renamed from: h */
    public final boolean m19068h() {
        return this.f15024i;
    }

    /* renamed from: i */
    public final int m19069i() {
        return this.f15028m.mo3843a();
    }

    /* renamed from: j */
    public final ac m19070j() {
        return this.f15028m;
    }

    /* renamed from: k */
    public final void m19071k() {
        synchronized (this.f15020e) {
            this.f15026k = true;
        }
    }

    /* renamed from: l */
    public final boolean m19072l() {
        boolean z;
        synchronized (this.f15020e) {
            z = this.f15026k;
        }
        return z;
    }

    /* renamed from: m */
    final void m19073m() {
        synchronized (this.f15020e) {
            ayg ayg = this.f15030o;
        }
        if (ayg != null) {
            ayg.mo3834a(this);
        }
    }

    public String toString() {
        String str = "0x";
        String valueOf = String.valueOf(Integer.toHexString(this.f15019d));
        str = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        valueOf = "[ ] ";
        String str2 = this.f15018c;
        String valueOf2 = String.valueOf(azh.NORMAL);
        String valueOf3 = String.valueOf(this.f15022g);
        StringBuilder stringBuilder = new StringBuilder(((((String.valueOf(valueOf).length() + 3) + String.valueOf(str2).length()) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length());
        stringBuilder.append(valueOf);
        stringBuilder.append(str2);
        stringBuilder.append(" ");
        stringBuilder.append(str);
        stringBuilder.append(" ");
        stringBuilder.append(valueOf2);
        stringBuilder.append(" ");
        stringBuilder.append(valueOf3);
        return stringBuilder.toString();
    }
}
