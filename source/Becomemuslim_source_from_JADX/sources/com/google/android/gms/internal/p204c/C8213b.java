package com.google.android.gms.internal.p204c;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.C2732b;
import com.google.android.gms.auth.api.C4875c;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.common.internal.C4785j;

/* renamed from: com.google.android.gms.internal.c.b */
public final class C8213b extends C4785j<C4946c> {
    /* renamed from: e */
    private final Bundle f32296e;

    public C8213b(Context context, Looper looper, C2853f c2853f, C4875c c4875c, C2775b c2775b, C2776c c2776c) {
        super(context, looper, 16, c2853f, c2775b, c2776c);
        if (c4875c == null) {
            this.f32296e = new Bundle();
            return;
        }
        throw new NoSuchMethodError();
    }

    /* renamed from: b */
    protected final String m42457b() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    /* renamed from: f */
    public final int m42458f() {
        return C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    protected final String q_() {
        return "com.google.android.gms.auth.service.START";
    }

    /* renamed from: j */
    public final boolean m42459j() {
        C2853f z = z();
        return (TextUtils.isEmpty(z.a()) || z.a(C2732b.f7011a).isEmpty()) ? false : true;
    }

    /* renamed from: u */
    protected final Bundle m42460u() {
        return this.f32296e;
    }

    /* renamed from: a */
    protected final /* synthetic */ IInterface m42456a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        if (queryLocalInterface instanceof C4946c) {
            return (C4946c) queryLocalInterface;
        }
        return new C6776d(iBinder);
    }
}
