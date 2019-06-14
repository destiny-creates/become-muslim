package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2781a.C4337a;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.p175c.C2770b;
import com.google.android.gms.p175c.C4764e;
import com.google.android.gms.p175c.C4882a;
import com.google.android.gms.p175c.p176a.C4759d;
import com.google.android.gms.p175c.p176a.C4761k;
import java.util.Set;

public final class br extends C4759d implements C2775b, C2776c {
    /* renamed from: a */
    private static C4337a<? extends C4764e, C4882a> f13976a = C2770b.f7057a;
    /* renamed from: b */
    private final Context f13977b;
    /* renamed from: c */
    private final Handler f13978c;
    /* renamed from: d */
    private final C4337a<? extends C4764e, C4882a> f13979d;
    /* renamed from: e */
    private Set<Scope> f13980e;
    /* renamed from: f */
    private C2853f f13981f;
    /* renamed from: g */
    private C4764e f13982g;
    /* renamed from: h */
    private bu f13983h;

    public br(Context context, Handler handler, C2853f c2853f) {
        this(context, handler, c2853f, f13976a);
    }

    public br(Context context, Handler handler, C2853f c2853f, C4337a<? extends C4764e, C4882a> c4337a) {
        this.f13977b = context;
        this.f13978c = handler;
        this.f13981f = (C2853f) C2872v.m8381a((Object) c2853f, (Object) "ClientSettings must not be null");
        this.f13980e = c2853f.m8322d();
        this.f13979d = c4337a;
    }

    /* renamed from: a */
    public final void m17496a(bu buVar) {
        if (this.f13982g != null) {
            this.f13982g.m14045g();
        }
        this.f13981f.m8319a(Integer.valueOf(System.identityHashCode(this)));
        this.f13982g = (C4764e) this.f13979d.mo3263a(this.f13977b, this.f13978c.getLooper(), this.f13981f, this.f13981f.m8327i(), this, this);
        this.f13983h = buVar;
        if (this.f13980e != null) {
            if (this.f13980e.isEmpty() == null) {
                this.f13982g.mo3454A();
                return;
            }
        }
        this.f13978c.post(new bs(this));
    }

    /* renamed from: a */
    public final C4764e m17494a() {
        return this.f13982g;
    }

    /* renamed from: b */
    public final void m17497b() {
        if (this.f13982g != null) {
            this.f13982g.m14045g();
        }
    }

    public final void onConnected(Bundle bundle) {
        this.f13982g.mo3455a(this);
    }

    public final void onConnectionSuspended(int i) {
        this.f13982g.m14045g();
    }

    public final void onConnectionFailed(C4775b c4775b) {
        this.f13983h.mo2452b(c4775b);
    }

    /* renamed from: a */
    public final void mo3273a(C4761k c4761k) {
        this.f13978c.post(new bt(this, c4761k));
    }

    /* renamed from: b */
    private final void m17493b(C4761k c4761k) {
        C4775b a = c4761k.m16692a();
        if (a.m16826b()) {
            c4761k = c4761k.m16693b();
            a = c4761k.m16855b();
            if (a.m16826b()) {
                this.f13983h.mo2451a(c4761k.m16854a(), this.f13980e);
            } else {
                String valueOf = String.valueOf(a);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 48);
                stringBuilder.append("Sign-in succeeded with resolve account failure: ");
                stringBuilder.append(valueOf);
                Log.wtf("SignInCoordinator", stringBuilder.toString(), new Exception());
                this.f13983h.mo2452b(a);
                this.f13982g.m14045g();
                return;
            }
        }
        this.f13983h.mo2452b(a);
        this.f13982g.m14045g();
    }
}
