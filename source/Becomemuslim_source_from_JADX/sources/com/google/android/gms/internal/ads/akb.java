package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;

public final class akb implements alh {
    /* renamed from: a */
    private final WeakReference<View> f23679a;
    /* renamed from: b */
    private final WeakReference<is> f23680b;

    public akb(View view, is isVar) {
        this.f23679a = new WeakReference(view);
        this.f23680b = new WeakReference(isVar);
    }

    /* renamed from: a */
    public final View mo3831a() {
        return (View) this.f23679a.get();
    }

    /* renamed from: b */
    public final boolean mo3832b() {
        if (this.f23679a.get() != null) {
            if (this.f23680b.get() != null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public final alh mo3833c() {
        return new aka((View) this.f23679a.get(), (is) this.f23680b.get());
    }
}
