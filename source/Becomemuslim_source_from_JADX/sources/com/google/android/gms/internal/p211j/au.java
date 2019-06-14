package com.google.android.gms.internal.p211j;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.common.internal.C4785j;

/* renamed from: com.google.android.gms.internal.j.au */
public class au extends C4785j<C5019p> {
    /* renamed from: e */
    protected final al<C5019p> f32304e = new av(this);
    /* renamed from: f */
    private final String f32305f;

    public au(Context context, Looper looper, C2775b c2775b, C2776c c2776c, String str, C2853f c2853f) {
        super(context, looper, 23, c2853f, c2775b, c2776c);
        this.f32305f = str;
    }

    /* renamed from: a */
    protected /* synthetic */ IInterface m42501a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof C5019p ? (C5019p) queryLocalInterface : new C6803q(iBinder);
    }

    /* renamed from: b */
    protected String m42502b() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    /* renamed from: f */
    public int m42503f() {
        return 11925000;
    }

    protected String q_() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    /* renamed from: u */
    protected Bundle m42504u() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.f32305f);
        return bundle;
    }
}
