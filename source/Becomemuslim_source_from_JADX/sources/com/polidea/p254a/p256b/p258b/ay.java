package com.polidea.p254a.p256b.p258b;

import android.bluetooth.BluetoothGatt;
import com.polidea.p254a.p256b.p259c.C5579k;
import com.polidea.p254a.p256b.p261e.C7062d;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;

/* compiled from: ServiceDiscoveryManager_Factory */
/* renamed from: com.polidea.a.b.b.ay */
public final class ay implements C3086c<ax> {
    /* renamed from: a */
    private final C0003a<C7062d> f29600a;
    /* renamed from: b */
    private final C0003a<BluetoothGatt> f29601b;
    /* renamed from: c */
    private final C0003a<C5579k> f29602c;

    /* renamed from: a */
    public /* synthetic */ Object m38592a() {
        return m38593b();
    }

    public ay(C0003a<C7062d> c0003a, C0003a<BluetoothGatt> c0003a2, C0003a<C5579k> c0003a3) {
        this.f29600a = c0003a;
        this.f29601b = c0003a2;
        this.f29602c = c0003a3;
    }

    /* renamed from: b */
    public ax m38593b() {
        return new ax((C7062d) this.f29600a.a(), (BluetoothGatt) this.f29601b.a(), (C5579k) this.f29602c.a());
    }

    /* renamed from: a */
    public static ay m38591a(C0003a<C7062d> c0003a, C0003a<BluetoothGatt> c0003a2, C0003a<C5579k> c0003a3) {
        return new ay(c0003a, c0003a2, c0003a3);
    }
}
