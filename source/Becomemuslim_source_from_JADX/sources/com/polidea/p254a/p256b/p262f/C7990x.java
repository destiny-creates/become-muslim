package com.polidea.p254a.p256b.p262f;

import android.bluetooth.BluetoothAdapter;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;

/* compiled from: RxBleAdapterWrapper_Factory */
/* renamed from: com.polidea.a.b.f.x */
public final class C7990x implements C3086c<C5610w> {
    /* renamed from: a */
    private final C0003a<BluetoothAdapter> f29737a;

    /* renamed from: a */
    public /* synthetic */ Object m38768a() {
        return m38769b();
    }

    public C7990x(C0003a<BluetoothAdapter> c0003a) {
        this.f29737a = c0003a;
    }

    /* renamed from: b */
    public C5610w m38769b() {
        return new C5610w((BluetoothAdapter) this.f29737a.a());
    }

    /* renamed from: a */
    public static C7990x m38767a(C0003a<BluetoothAdapter> c0003a) {
        return new C7990x(c0003a);
    }
}
