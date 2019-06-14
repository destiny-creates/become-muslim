package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.ax;

@cm
public final class jf {
    /* renamed from: a */
    private final Object f15654a;
    /* renamed from: b */
    private int f15655b;
    /* renamed from: c */
    private int f15656c;
    /* renamed from: d */
    private final jg f15657d;
    /* renamed from: e */
    private final String f15658e;

    private jf(jg jgVar, String str) {
        this.f15654a = new Object();
        this.f15657d = jgVar;
        this.f15658e = str;
    }

    public jf(String str) {
        this(ax.j(), str);
    }

    /* renamed from: a */
    public final String m19599a() {
        return this.f15658e;
    }

    /* renamed from: a */
    public final void m19600a(int i, int i2) {
        synchronized (this.f15654a) {
            this.f15655b = i;
            this.f15656c = i2;
            this.f15657d.m30855a(this);
        }
    }

    /* renamed from: b */
    public final Bundle m19601b() {
        Bundle bundle;
        synchronized (this.f15654a) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.f15655b);
            bundle.putInt("pmnll", this.f15656c);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                jf jfVar = (jf) obj;
                if (this.f15658e != null) {
                    return this.f15658e.equals(jfVar.f15658e);
                }
                if (jfVar.f15658e == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f15658e != null ? this.f15658e.hashCode() : 0;
    }
}
