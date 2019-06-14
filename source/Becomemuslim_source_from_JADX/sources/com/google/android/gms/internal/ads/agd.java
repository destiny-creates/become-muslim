package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.support.p015c.C0104b;
import android.support.p015c.C0108d;
import java.lang.ref.WeakReference;

public final class agd extends C0108d {
    /* renamed from: a */
    private WeakReference<age> f23570a;

    public agd(age age) {
        this.f23570a = new WeakReference(age);
    }

    /* renamed from: a */
    public final void m29906a(ComponentName componentName, C0104b c0104b) {
        age age = (age) this.f23570a.get();
        if (age != null) {
            age.mo3966a(c0104b);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        age age = (age) this.f23570a.get();
        if (age != null) {
            age.mo3965a();
        }
    }
}
