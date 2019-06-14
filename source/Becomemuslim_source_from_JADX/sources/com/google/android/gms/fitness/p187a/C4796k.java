package com.google.android.gms.fitness.p187a;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.fitness.data.C3009y;
import com.google.android.gms.fitness.data.C4414z;
import com.google.android.gms.internal.p208g.ax;
import com.google.android.gms.internal.p208g.ay;

/* renamed from: com.google.android.gms.fitness.a.k */
public final class C4796k extends C4363a {
    public static final Creator<C4796k> CREATOR = new C2976l();
    /* renamed from: a */
    private final C3009y f13357a;
    /* renamed from: b */
    private final PendingIntent f13358b;
    /* renamed from: c */
    private final ax f13359c;

    C4796k(IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2) {
        this.f13357a = iBinder == null ? null : C4414z.m14686a(iBinder);
        this.f13358b = pendingIntent;
        this.f13359c = ay.a(iBinder2);
    }

    public C4796k(C3009y c3009y, PendingIntent pendingIntent, ax axVar) {
        this.f13357a = c3009y;
        this.f13358b = pendingIntent;
        this.f13359c = axVar;
    }

    public final String toString() {
        return String.format("SensorUnregistrationRequest{%s}", new Object[]{this.f13357a});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        IBinder iBinder = null;
        C2835c.m8187a(parcel, 1, this.f13357a == null ? null : this.f13357a.asBinder(), false);
        C2835c.m8188a(parcel, 2, this.f13358b, i, false);
        if (this.f13359c != null) {
            iBinder = this.f13359c.asBinder();
        }
        C2835c.m8187a(parcel, 3, iBinder, false);
        C2835c.m8180a(parcel, a);
    }
}
