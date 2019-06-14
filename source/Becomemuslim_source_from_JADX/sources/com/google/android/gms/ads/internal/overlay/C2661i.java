package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.qo;

@cm
/* renamed from: com.google.android.gms.ads.internal.overlay.i */
public final class C2661i {
    /* renamed from: a */
    public final int f6904a;
    /* renamed from: b */
    public final LayoutParams f6905b;
    /* renamed from: c */
    public final ViewGroup f6906c;
    /* renamed from: d */
    public final Context f6907d;

    public C2661i(qo qoVar) {
        this.f6905b = qoVar.getLayoutParams();
        ViewParent parent = qoVar.getParent();
        this.f6907d = qoVar.q();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new C2659g("Could not get the parent of the WebView for an overlay.");
        }
        this.f6906c = (ViewGroup) parent;
        this.f6904a = this.f6906c.indexOfChild(qoVar.getView());
        this.f6906c.removeView(qoVar.getView());
        qoVar.b(true);
    }
}
