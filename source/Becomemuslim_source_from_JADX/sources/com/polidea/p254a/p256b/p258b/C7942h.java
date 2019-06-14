package com.polidea.p254a.p256b.p258b;

import android.bluetooth.BluetoothGatt;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;

/* compiled from: ConnectionModuleBinder_ProvideBluetoothGattFactory */
/* renamed from: com.polidea.a.b.b.h */
public final class C7942h implements C3086c<BluetoothGatt> {
    /* renamed from: a */
    private final C0003a<C5562a> f29607a;

    /* renamed from: a */
    public /* synthetic */ Object m38607a() {
        return m38608b();
    }

    public C7942h(C0003a<C5562a> c0003a) {
        this.f29607a = c0003a;
    }

    /* renamed from: b */
    public BluetoothGatt m38608b() {
        return (BluetoothGatt) C0000d.a(C5569e.m23743a((C5562a) this.f29607a.a()), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: a */
    public static C7942h m38606a(C0003a<C5562a> c0003a) {
        return new C7942h(c0003a);
    }
}
