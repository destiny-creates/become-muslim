package com.google.android.gms.internal.p203b;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.C2730a.C4874a;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.common.internal.C4785j;

/* renamed from: com.google.android.gms.internal.b.f */
public final class C8212f extends C4785j<C4944g> {
    /* renamed from: e */
    private final C4874a f32295e;

    public C8212f(Context context, Looper looper, C2853f c2853f, C4874a c4874a, C2775b c2775b, C2776c c2776c) {
        super(context, looper, 68, c2853f, c2775b, c2776c);
        this.f32295e = c4874a;
    }

    /* renamed from: b */
    protected final String m42453b() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    /* renamed from: f */
    public final int m42454f() {
        return 12800000;
    }

    protected final String q_() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    /* renamed from: u */
    protected final Bundle m42455u() {
        return this.f32295e == null ? new Bundle() : this.f32295e.a();
    }

    /* renamed from: a */
    protected final /* synthetic */ IInterface m42452a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        if (queryLocalInterface instanceof C4944g) {
            return (C4944g) queryLocalInterface;
        }
        return new C6775h(iBinder);
    }
}
