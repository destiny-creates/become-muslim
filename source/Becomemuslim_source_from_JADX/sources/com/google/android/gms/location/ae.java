package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.Collections;
import java.util.List;

public final class ae extends C4363a {
    public static final Creator<ae> CREATOR = new af();
    /* renamed from: a */
    private final List<String> f29171a;
    /* renamed from: b */
    private final PendingIntent f29172b;
    /* renamed from: c */
    private final String f29173c;

    ae(List<String> list, PendingIntent pendingIntent, String str) {
        this.f29171a = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f29172b = pendingIntent;
        this.f29173c = str;
    }

    /* renamed from: a */
    public static ae m38219a(PendingIntent pendingIntent) {
        C2872v.a(pendingIntent, "PendingIntent can not be null.");
        return new ae(null, pendingIntent, "");
    }

    /* renamed from: a */
    public static ae m38220a(List<String> list) {
        C2872v.a(list, "geofence can't be null.");
        C2872v.b(list.isEmpty() ^ 1, "Geofences must contains at least one id.");
        return new ae(list, null, "");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.b(parcel, 1, this.f29171a, false);
        C2835c.a(parcel, 2, this.f29172b, i, false);
        C2835c.a(parcel, 3, this.f29173c, false);
        C2835c.a(parcel, a);
    }
}
