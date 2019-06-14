package com.google.android.gms.internal.p210i;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.i.bi */
public final class bi extends cu implements bh {
    bi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.analytics.internal.IAnalyticsService");
    }

    /* renamed from: a */
    public final void mo4421a(Map map, long j, String str, List<am> list) {
        Parcel b = m20396b();
        b.writeMap(map);
        b.writeLong(j);
        b.writeString(str);
        b.writeTypedList(list);
        m20395a(1, b);
    }

    /* renamed from: a */
    public final void mo4420a() {
        m20395a(2, m20396b());
    }
}
