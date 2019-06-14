package com.google.android.gms.internal.p208g;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.common.api.C2781a;
import com.google.android.gms.common.api.C2781a.C4341g;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.internal.C2853f;

/* renamed from: com.google.android.gms.internal.g.by */
public final class by extends bs<ak> {
    /* renamed from: e */
    public static final C2781a<Object> f32762e = new C2781a("Fitness.CONFIG_API", new ca(), f32764g);
    /* renamed from: f */
    public static final C2781a<Object> f32763f = new C2781a("Fitness.CONFIG_CLIENT", new cb(), f32764g);
    /* renamed from: g */
    private static final C4341g<by> f32764g = new C4341g();

    private by(Context context, Looper looper, C2853f c2853f, C2775b c2775b, C2776c c2776c) {
        super(context, looper, 60, c2775b, c2776c, c2853f);
    }

    /* renamed from: a */
    public final /* synthetic */ IInterface mo6845a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
        return queryLocalInterface instanceof ak ? (ak) queryLocalInterface : new al(iBinder);
    }

    /* renamed from: b */
    public final String mo6846b() {
        return "com.google.android.gms.fitness.internal.IGoogleFitConfigApi";
    }

    /* renamed from: f */
    public final int mo6847f() {
        return C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public final String q_() {
        return "com.google.android.gms.fitness.ConfigApi";
    }
}
