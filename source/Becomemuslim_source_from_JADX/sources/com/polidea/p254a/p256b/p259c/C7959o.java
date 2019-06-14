package com.polidea.p254a.p256b.p259c;

import android.bluetooth.BluetoothGatt;
import com.polidea.p254a.p256b.p258b.av;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;

/* compiled from: ReadRssiOperation_Factory */
/* renamed from: com.polidea.a.b.c.o */
public final class C7959o implements C3086c<C8244n> {
    /* renamed from: a */
    private final C0003a<av> f29665a;
    /* renamed from: b */
    private final C0003a<BluetoothGatt> f29666b;
    /* renamed from: c */
    private final C0003a<C5583t> f29667c;

    /* renamed from: a */
    public /* synthetic */ Object m38668a() {
        return m38669b();
    }

    public C7959o(C0003a<av> c0003a, C0003a<BluetoothGatt> c0003a2, C0003a<C5583t> c0003a3) {
        this.f29665a = c0003a;
        this.f29666b = c0003a2;
        this.f29667c = c0003a3;
    }

    /* renamed from: b */
    public C8244n m38669b() {
        return new C8244n((av) this.f29665a.a(), (BluetoothGatt) this.f29666b.a(), (C5583t) this.f29667c.a());
    }

    /* renamed from: a */
    public static C7959o m38667a(C0003a<av> c0003a, C0003a<BluetoothGatt> c0003a2, C0003a<C5583t> c0003a3) {
        return new C7959o(c0003a, c0003a2, c0003a3);
    }
}
