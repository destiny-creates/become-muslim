package com.google.android.gms.internal.p208g;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.common.internal.C4785j;
import com.google.android.gms.common.util.C2898i;
import com.google.android.gms.fitness.C3014i;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.g.bs */
public abstract class bs<T extends IInterface> extends C4785j<T> {
    protected bs(Context context, Looper looper, int i, C2775b c2775b, C2776c c2776c, C2853f c2853f) {
        super(context, looper, i, c2853f, c2775b, c2776c);
    }

    /* renamed from: a */
    public abstract T mo6845a(IBinder iBinder);

    /* renamed from: a */
    protected Set<Scope> m42462a(Set<Scope> set) {
        return C3014i.a(set);
    }

    /* renamed from: b */
    public abstract String mo6846b();

    /* renamed from: f */
    public int mo6847f() {
        return C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* renamed from: j */
    public boolean m42465j() {
        return !C2898i.a(r());
    }

    public abstract String q_();

    /* renamed from: x */
    public boolean m42466x() {
        return true;
    }
}
