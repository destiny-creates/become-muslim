package com.polidea.p254a.p256b;

import android.bluetooth.BluetoothDevice;
import com.p071c.p072a.C4535a;
import com.polidea.p254a.af.C5554a;
import com.polidea.p254a.p256b.p258b.C5572o;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;

/* compiled from: RxBleDeviceImpl_Factory */
/* renamed from: com.polidea.a.b.m */
public final class C7996m implements C3086c<C7087l> {
    /* renamed from: a */
    private final C0003a<BluetoothDevice> f29743a;
    /* renamed from: b */
    private final C0003a<C5572o> f29744b;
    /* renamed from: c */
    private final C0003a<C4535a<C5554a>> f29745c;

    /* renamed from: a */
    public /* synthetic */ Object m38786a() {
        return m38787b();
    }

    public C7996m(C0003a<BluetoothDevice> c0003a, C0003a<C5572o> c0003a2, C0003a<C4535a<C5554a>> c0003a3) {
        this.f29743a = c0003a;
        this.f29744b = c0003a2;
        this.f29745c = c0003a3;
    }

    /* renamed from: b */
    public C7087l m38787b() {
        return new C7087l((BluetoothDevice) this.f29743a.a(), (C5572o) this.f29744b.a(), (C4535a) this.f29745c.a());
    }

    /* renamed from: a */
    public static C7996m m38785a(C0003a<BluetoothDevice> c0003a, C0003a<C5572o> c0003a2, C0003a<C4535a<C5554a>> c0003a3) {
        return new C7996m(c0003a, c0003a2, c0003a3);
    }
}
