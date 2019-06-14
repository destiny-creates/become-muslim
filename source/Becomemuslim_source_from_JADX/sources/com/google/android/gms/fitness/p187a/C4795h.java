package com.google.android.gms.fitness.p187a;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C4783e;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.fitness.data.C3009y;
import com.google.android.gms.fitness.data.C4414z;
import com.google.android.gms.fitness.data.C4801a;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.p208g.ax;
import com.google.android.gms.internal.p208g.ay;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.fitness.a.h */
public final class C4795h extends C4363a {
    public static final Creator<C4795h> CREATOR = new C2974i();
    /* renamed from: a */
    private C4801a f13345a;
    /* renamed from: b */
    private DataType f13346b;
    /* renamed from: c */
    private C3009y f13347c;
    /* renamed from: d */
    private final long f13348d;
    /* renamed from: e */
    private final long f13349e;
    /* renamed from: f */
    private final PendingIntent f13350f;
    /* renamed from: g */
    private final long f13351g;
    /* renamed from: h */
    private final int f13352h;
    /* renamed from: i */
    private final List<LocationRequest> f13353i;
    /* renamed from: j */
    private final long f13354j;
    /* renamed from: k */
    private final List<C4783e> f13355k;
    /* renamed from: l */
    private final ax f13356l;

    public C4795h(C2972d c2972d, C3009y c3009y, PendingIntent pendingIntent, ax axVar) {
        C2972d c2972d2 = c2972d;
        this(c2972d.m8830a(), c2972d.m8832b(), c3009y, pendingIntent, c2972d2.m8829a(TimeUnit.MICROSECONDS), c2972d2.m8831b(TimeUnit.MICROSECONDS), c2972d2.m8834c(TimeUnit.MICROSECONDS), c2972d.m8833c(), null, Collections.emptyList(), c2972d.m8835d(), axVar);
    }

    C4795h(C4801a c4801a, DataType dataType, IBinder iBinder, int i, int i2, long j, long j2, PendingIntent pendingIntent, long j3, int i3, List<LocationRequest> list, long j4, IBinder iBinder2) {
        this.f13345a = c4801a;
        this.f13346b = dataType;
        r0.f13347c = iBinder == null ? null : C4414z.m14686a(iBinder);
        r0.f13348d = j == 0 ? (long) i : j;
        r0.f13351g = j3;
        r0.f13349e = j2 == 0 ? (long) i2 : j2;
        r0.f13353i = list;
        r0.f13350f = pendingIntent;
        r0.f13352h = i3;
        r0.f13355k = Collections.emptyList();
        r0.f13354j = j4;
        r0.f13356l = ay.a(iBinder2);
    }

    private C4795h(C4801a c4801a, DataType dataType, C3009y c3009y, PendingIntent pendingIntent, long j, long j2, long j3, int i, List<LocationRequest> list, List<C4783e> list2, long j4, ax axVar) {
        this.f13345a = c4801a;
        this.f13346b = dataType;
        this.f13347c = c3009y;
        this.f13350f = pendingIntent;
        this.f13348d = j;
        this.f13351g = j2;
        this.f13349e = j3;
        this.f13352h = i;
        this.f13353i = null;
        this.f13355k = list2;
        this.f13354j = j4;
        this.f13356l = axVar;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C4795h) {
                C4795h c4795h = (C4795h) obj;
                obj = (C2868t.m8374a(this.f13345a, c4795h.f13345a) && C2868t.m8374a(this.f13346b, c4795h.f13346b) && C2868t.m8374a(this.f13347c, c4795h.f13347c) && this.f13348d == c4795h.f13348d && this.f13351g == c4795h.f13351g && this.f13349e == c4795h.f13349e && this.f13352h == c4795h.f13352h && C2868t.m8374a(this.f13353i, c4795h.f13353i)) ? 1 : null;
                if (obj != null) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return C2868t.m8372a(this.f13345a, this.f13346b, this.f13347c, Long.valueOf(this.f13348d), Long.valueOf(this.f13351g), Long.valueOf(this.f13349e), Integer.valueOf(this.f13352h), this.f13353i);
    }

    public final String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[]{this.f13346b, this.f13345a, Long.valueOf(this.f13348d), Long.valueOf(this.f13351g), Long.valueOf(this.f13349e)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8188a(parcel, 1, this.f13345a, i, false);
        C2835c.m8188a(parcel, 2, this.f13346b, i, false);
        IBinder iBinder = null;
        C2835c.m8187a(parcel, 3, this.f13347c == null ? null : this.f13347c.asBinder(), false);
        C2835c.m8184a(parcel, 4, 0);
        C2835c.m8184a(parcel, 5, 0);
        C2835c.m8185a(parcel, 6, this.f13348d);
        C2835c.m8185a(parcel, 7, this.f13349e);
        C2835c.m8188a(parcel, 8, this.f13350f, i, false);
        C2835c.m8185a(parcel, 9, this.f13351g);
        C2835c.m8184a(parcel, 10, this.f13352h);
        C2835c.m8207c(parcel, 11, this.f13353i, false);
        C2835c.m8185a(parcel, 12, this.f13354j);
        if (this.f13356l != null) {
            iBinder = this.f13356l.asBinder();
        }
        C2835c.m8187a(parcel, 13, iBinder, false);
        C2835c.m8180a(parcel, a);
    }
}
