package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.ax;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@cm
public final class iu {
    /* renamed from: a */
    private final jg f15610a;
    /* renamed from: b */
    private final LinkedList<iv> f15611b;
    /* renamed from: c */
    private final Object f15612c;
    /* renamed from: d */
    private final String f15613d;
    /* renamed from: e */
    private final String f15614e;
    /* renamed from: f */
    private long f15615f;
    /* renamed from: g */
    private long f15616g;
    /* renamed from: h */
    private boolean f15617h;
    /* renamed from: i */
    private long f15618i;
    /* renamed from: j */
    private long f15619j;
    /* renamed from: k */
    private long f15620k;
    /* renamed from: l */
    private long f15621l;

    private iu(jg jgVar, String str, String str2) {
        this.f15612c = new Object();
        this.f15615f = -1;
        this.f15616g = -1;
        this.f15617h = false;
        this.f15618i = -1;
        this.f15619j = 0;
        this.f15620k = -1;
        this.f15621l = -1;
        this.f15610a = jgVar;
        this.f15613d = str;
        this.f15614e = str2;
        this.f15611b = new LinkedList();
    }

    public iu(String str, String str2) {
        this(ax.j(), str, str2);
    }

    /* renamed from: a */
    public final void m19567a() {
        synchronized (this.f15612c) {
            if (this.f15621l != -1 && this.f15616g == -1) {
                this.f15616g = SystemClock.elapsedRealtime();
                this.f15610a.m30854a(this);
            }
            this.f15610a.m30858b();
        }
    }

    /* renamed from: a */
    public final void m19568a(long j) {
        synchronized (this.f15612c) {
            this.f15621l = j;
            if (this.f15621l != -1) {
                this.f15610a.m30854a(this);
            }
        }
    }

    /* renamed from: a */
    public final void m19569a(aoq aoq) {
        synchronized (this.f15612c) {
            this.f15620k = SystemClock.elapsedRealtime();
            this.f15610a.m30853a(aoq, this.f15620k);
        }
    }

    /* renamed from: a */
    public final void m19570a(boolean z) {
        synchronized (this.f15612c) {
            if (this.f15621l != -1) {
                this.f15618i = SystemClock.elapsedRealtime();
                if (!z) {
                    this.f15616g = this.f15618i;
                    this.f15610a.m30854a(this);
                }
            }
        }
    }

    /* renamed from: b */
    public final void m19571b() {
        synchronized (this.f15612c) {
            if (this.f15621l != -1) {
                iv ivVar = new iv();
                ivVar.m19578c();
                this.f15611b.add(ivVar);
                this.f15619j++;
                this.f15610a.m30852a();
                this.f15610a.m30854a(this);
            }
        }
    }

    /* renamed from: b */
    public final void m19572b(long j) {
        synchronized (this.f15612c) {
            if (this.f15621l != -1) {
                this.f15615f = j;
                this.f15610a.m30854a(this);
            }
        }
    }

    /* renamed from: b */
    public final void m19573b(boolean z) {
        synchronized (this.f15612c) {
            if (this.f15621l != -1) {
                this.f15617h = z;
                this.f15610a.m30854a(this);
            }
        }
    }

    /* renamed from: c */
    public final void m19574c() {
        synchronized (this.f15612c) {
            if (!(this.f15621l == -1 || this.f15611b.isEmpty())) {
                iv ivVar = (iv) this.f15611b.getLast();
                if (ivVar.m19576a() == -1) {
                    ivVar.m19577b();
                    this.f15610a.m30854a(this);
                }
            }
        }
    }

    /* renamed from: d */
    public final Bundle m19575d() {
        Bundle bundle;
        synchronized (this.f15612c) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.f15613d);
            bundle.putString("slotid", this.f15614e);
            bundle.putBoolean("ismediation", this.f15617h);
            bundle.putLong("treq", this.f15620k);
            bundle.putLong("tresponse", this.f15621l);
            bundle.putLong("timp", this.f15616g);
            bundle.putLong("tload", this.f15618i);
            bundle.putLong("pcc", this.f15619j);
            bundle.putLong("tfetch", this.f15615f);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f15611b.iterator();
            while (it.hasNext()) {
                arrayList.add(((iv) it.next()).m19579d());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }
}
