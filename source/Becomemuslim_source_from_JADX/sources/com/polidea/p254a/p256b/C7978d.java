package com.polidea.p254a.p256b;

import android.bluetooth.BluetoothDevice;
import com.polidea.p254a.p256b.p262f.C5610w;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;

/* compiled from: DeviceModule_ProvideBluetoothDeviceFactory */
/* renamed from: com.polidea.a.b.d */
public final class C7978d implements C3086c<BluetoothDevice> {
    /* renamed from: a */
    private final C5584c f29706a;
    /* renamed from: b */
    private final C0003a<C5610w> f29707b;

    /* renamed from: a */
    public /* synthetic */ Object m38725a() {
        return m38726b();
    }

    public C7978d(C5584c c5584c, C0003a<C5610w> c0003a) {
        this.f29706a = c5584c;
        this.f29707b = c0003a;
    }

    /* renamed from: b */
    public BluetoothDevice m38726b() {
        return (BluetoothDevice) C0000d.a(this.f29706a.m23769a((C5610w) this.f29707b.a()), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: a */
    public static C7978d m38724a(C5584c c5584c, C0003a<C5610w> c0003a) {
        return new C7978d(c5584c, c0003a);
    }

    /* renamed from: a */
    public static BluetoothDevice m38723a(C5584c c5584c, C5610w c5610w) {
        return (BluetoothDevice) C0000d.a(c5584c.m23769a(c5610w), "Cannot return null from a non-@Nullable @Provides method");
    }
}
