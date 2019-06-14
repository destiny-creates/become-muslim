package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.internal.p211j.aj;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.location.i */
public class C5078i {
    /* renamed from: a */
    private final int f17374a;
    /* renamed from: b */
    private final int f17375b;
    /* renamed from: c */
    private final List<C5076f> f17376c;
    /* renamed from: d */
    private final Location f17377d;

    private C5078i(int i, int i2, List<C5076f> list, Location location) {
        this.f17374a = i;
        this.f17375b = i2;
        this.f17376c = list;
        this.f17377d = location;
    }

    /* renamed from: a */
    public static C5078i m21560a(Intent intent) {
        List list = null;
        if (intent == null) {
            return null;
        }
        int i = -1;
        int intExtra = intent.getIntExtra("gms_error_code", -1);
        int intExtra2 = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        if (intExtra2 != -1 && (intExtra2 == 1 || intExtra2 == 2 || intExtra2 == 4)) {
            i = intExtra2;
        }
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList != null) {
            list = new ArrayList(arrayList.size());
            arrayList = arrayList;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                list.add(aj.m38023a((byte[]) obj));
            }
        }
        return new C5078i(intExtra, i, list, (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }

    /* renamed from: a */
    public boolean m21561a() {
        return this.f17374a != -1;
    }

    /* renamed from: b */
    public int m21562b() {
        return this.f17374a;
    }

    /* renamed from: c */
    public int m21563c() {
        return this.f17375b;
    }

    /* renamed from: d */
    public List<C5076f> m21564d() {
        return this.f17376c;
    }

    /* renamed from: e */
    public Location m21565e() {
        return this.f17377d;
    }
}
