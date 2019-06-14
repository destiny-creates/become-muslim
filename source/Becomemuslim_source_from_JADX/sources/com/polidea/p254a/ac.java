package com.polidea.p254a;

import android.content.Context;
import com.polidea.p254a.C5550a.C5547b;
import com.polidea.p254a.p256b.C5615p;
import com.polidea.p254a.p263c.C5619b;
import com.polidea.p254a.p263c.C5621d;
import com.polidea.p254a.p263c.C5624e;
import p289e.C5974e;

/* compiled from: RxBleClient */
/* renamed from: com.polidea.a.ac */
public abstract class ac {

    /* compiled from: RxBleClient */
    /* renamed from: com.polidea.a.ac$a */
    public enum C5553a {
        BLUETOOTH_NOT_AVAILABLE,
        LOCATION_PERMISSION_NOT_GRANTED,
        BLUETOOTH_NOT_ENABLED,
        LOCATION_SERVICES_NOT_ENABLED,
        READY
    }

    /* renamed from: a */
    public abstract ah mo4977a(String str);

    /* renamed from: a */
    public abstract C5974e<C5621d> mo4978a(C5624e c5624e, C5619b... c5619bArr);

    /* renamed from: a */
    public static ac m23618a(Context context) {
        return C7095y.m33033b().m23931a(new C5547b(context)).m23930a().mo5037a();
    }

    /* renamed from: a */
    public static void m23619a(int i) {
        C5615p.m23860a(i);
    }
}
