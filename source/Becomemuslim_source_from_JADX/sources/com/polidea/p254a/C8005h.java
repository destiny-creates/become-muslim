package com.polidea.p254a;

import android.bluetooth.BluetoothManager;
import com.polidea.p254a.C5550a.C5547b;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C3086c;

/* compiled from: ClientComponent_ClientModule_ProvideBluetoothManagerFactory */
/* renamed from: com.polidea.a.h */
public final class C8005h implements C3086c<BluetoothManager> {
    /* renamed from: a */
    private final C5547b f29758a;

    /* renamed from: a */
    public /* synthetic */ Object m38816a() {
        return m38817b();
    }

    public C8005h(C5547b c5547b) {
        this.f29758a = c5547b;
    }

    /* renamed from: b */
    public BluetoothManager m38817b() {
        return (BluetoothManager) C0000d.a(this.f29758a.m23612b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: a */
    public static C8005h m38815a(C5547b c5547b) {
        return new C8005h(c5547b);
    }
}
