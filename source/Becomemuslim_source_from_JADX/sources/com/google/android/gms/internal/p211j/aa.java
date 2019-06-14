package com.google.android.gms.internal.p211j;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C2796c.C2795b;
import com.google.android.gms.common.api.internal.C2804h;
import com.google.android.gms.common.api.internal.C2804h.C2802a;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.location.C5081l;
import com.google.android.gms.location.C7835j;
import com.google.android.gms.location.C7836n;
import com.google.android.gms.location.C7837o;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.ae;

/* renamed from: com.google.android.gms.internal.j.aa */
public final class aa extends au {
    /* renamed from: f */
    private final C5021t f32777f;

    public aa(Context context, Looper looper, C2775b c2775b, C2776c c2776c, String str) {
        this(context, looper, c2775b, c2776c, str, C2853f.a(context));
    }

    public aa(Context context, Looper looper, C2775b c2775b, C2776c c2776c, String str, C2853f c2853f) {
        super(context, looper, c2775b, c2776c, str, c2853f);
        this.f32777f = new C5021t(context, this.e);
    }

    /* renamed from: a */
    public final void m43881a(long j, PendingIntent pendingIntent) {
        v();
        C2872v.a(pendingIntent);
        C2872v.b(j >= 0, "detectionIntervalMillis must be >= 0");
        ((C5019p) w()).mo4642a(j, true, pendingIntent);
    }

    /* renamed from: a */
    public final void m43882a(PendingIntent pendingIntent, C5017k c5017k) {
        this.f32777f.m21114a(pendingIntent, c5017k);
    }

    /* renamed from: a */
    public final void m43883a(C2802a<C5081l> c2802a, C5017k c5017k) {
        this.f32777f.m21115a((C2802a) c2802a, c5017k);
    }

    /* renamed from: a */
    public final void m43884a(LocationRequest locationRequest, PendingIntent pendingIntent, C5017k c5017k) {
        this.f32777f.m21116a(locationRequest, pendingIntent, c5017k);
    }

    /* renamed from: a */
    public final void m43885a(LocationRequest locationRequest, C2804h<C5081l> c2804h, C5017k c5017k) {
        synchronized (this.f32777f) {
            this.f32777f.m21117a(locationRequest, (C2804h) c2804h, c5017k);
        }
    }

    /* renamed from: a */
    public final void m43886a(ae aeVar, C2795b<Status> c2795b) {
        v();
        C2872v.a(aeVar, "removeGeofencingRequest can't be null.");
        C2872v.a(c2795b, "ResultHolder not provided.");
        ((C5019p) w()).mo4645a(aeVar, new ad(c2795b));
    }

    /* renamed from: a */
    public final void m43887a(C7835j c7835j, PendingIntent pendingIntent, C2795b<Status> c2795b) {
        v();
        C2872v.a(c7835j, "geofencingRequest can't be null.");
        C2872v.a(pendingIntent, "PendingIntent must be specified.");
        C2872v.a(c2795b, "ResultHolder not provided.");
        ((C5019p) w()).mo4646a(c7835j, pendingIntent, new ac(c2795b));
    }

    /* renamed from: a */
    public final void m43888a(C7836n c7836n, C2795b<C7837o> c2795b, String str) {
        v();
        boolean z = false;
        C2872v.b(c7836n != null, "locationSettingsRequest can't be null nor empty.");
        if (c2795b != null) {
            z = true;
        }
        C2872v.b(z, "listener can't be null.");
        ((C5019p) w()).mo4647a(c7836n, new ae(c2795b), str);
    }

    /* renamed from: e */
    public final Location m43889e() {
        return this.f32777f.m21113a();
    }

    /* renamed from: g */
    public final void m43890g() {
        synchronized (this.f32777f) {
            if (h()) {
                try {
                    this.f32777f.m21119b();
                    this.f32777f.m21120c();
                } catch (Throwable e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.g();
        }
    }
}
