package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.ahe;
import com.google.android.gms.internal.ads.ahh;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.ju;
import com.google.android.gms.internal.ads.mi;
import com.google.android.gms.internal.ads.mv;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@cm
/* renamed from: com.google.android.gms.ads.internal.h */
public final class C4286h implements ahe, Runnable {
    /* renamed from: a */
    private final List<Object[]> f11309a;
    /* renamed from: b */
    private final AtomicReference<ahe> f11310b;
    /* renamed from: c */
    private Context f11311c;
    /* renamed from: d */
    private mv f11312d;
    /* renamed from: e */
    private CountDownLatch f11313e;

    private C4286h(Context context, mv mvVar) {
        this.f11309a = new Vector();
        this.f11310b = new AtomicReference();
        this.f11313e = new CountDownLatch(1);
        this.f11311c = context;
        this.f11312d = mvVar;
        aph.a();
        if (mi.b()) {
            ju.a(this);
        } else {
            run();
        }
    }

    public C4286h(ay ayVar) {
        this(ayVar.f6792c, ayVar.f6794e);
    }

    /* renamed from: a */
    private final boolean m13909a() {
        try {
            this.f11313e.await();
            return true;
        } catch (Throwable e) {
            jn.c("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    /* renamed from: b */
    private static Context m13910b(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    /* renamed from: b */
    private final void m13911b() {
        if (!this.f11309a.isEmpty()) {
            for (Object[] objArr : this.f11309a) {
                if (objArr.length == 1) {
                    ((ahe) this.f11310b.get()).a((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    ((ahe) this.f11310b.get()).a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.f11309a.clear();
        }
    }

    /* renamed from: a */
    public final String m13912a(Context context) {
        if (m13909a()) {
            ahe ahe = (ahe) this.f11310b.get();
            if (ahe != null) {
                m13911b();
                return ahe.a(C4286h.m13910b(context));
            }
        }
        return "";
    }

    /* renamed from: a */
    public final String m13913a(Context context, String str, View view) {
        return m13914a(context, str, view, null);
    }

    /* renamed from: a */
    public final String m13914a(Context context, String str, View view, Activity activity) {
        if (m13909a()) {
            ahe ahe = (ahe) this.f11310b.get();
            if (ahe != null) {
                m13911b();
                return ahe.a(C4286h.m13910b(context), str, view, activity);
            }
        }
        return "";
    }

    /* renamed from: a */
    public final void m13915a(int i, int i2, int i3) {
        ahe ahe = (ahe) this.f11310b.get();
        if (ahe != null) {
            m13911b();
            ahe.a(i, i2, i3);
            return;
        }
        this.f11309a.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    /* renamed from: a */
    public final void m13916a(MotionEvent motionEvent) {
        ahe ahe = (ahe) this.f11310b.get();
        if (ahe != null) {
            m13911b();
            ahe.a(motionEvent);
            return;
        }
        this.f11309a.add(new Object[]{motionEvent});
    }

    /* renamed from: a */
    public final void m13917a(View view) {
        ahe ahe = (ahe) this.f11310b.get();
        if (ahe != null) {
            ahe.a(view);
        }
    }

    public final void run() {
        boolean z = false;
        try {
            boolean z2 = this.f11312d.f28712d;
            if (!((Boolean) aph.f().a(asp.aL)).booleanValue() && z2) {
                z = true;
            }
            this.f11310b.set(ahh.a(this.f11312d.f28709a, C4286h.m13910b(this.f11311c), z));
        } finally {
            this.f11313e.countDown();
            this.f11311c = null;
            this.f11312d = null;
        }
    }
}
