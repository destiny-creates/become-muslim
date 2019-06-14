package com.polidea.p254a.p256b.p258b;

import android.bluetooth.BluetoothGatt;
import p000a.p001a.p002a.C3086c;
import p000a.p003b.p004a.C0003a;

/* compiled from: NotificationAndIndicationManager_Factory */
/* renamed from: com.polidea.a.b.b.ar */
public final class ar implements C3086c<aq> {
    /* renamed from: a */
    private final C0003a<byte[]> f29577a;
    /* renamed from: b */
    private final C0003a<byte[]> f29578b;
    /* renamed from: c */
    private final C0003a<byte[]> f29579c;
    /* renamed from: d */
    private final C0003a<BluetoothGatt> f29580d;
    /* renamed from: e */
    private final C0003a<av> f29581e;
    /* renamed from: f */
    private final C0003a<C5574r> f29582f;

    /* renamed from: a */
    public /* synthetic */ Object m38580a() {
        return m38581b();
    }

    public ar(C0003a<byte[]> c0003a, C0003a<byte[]> c0003a2, C0003a<byte[]> c0003a3, C0003a<BluetoothGatt> c0003a4, C0003a<av> c0003a5, C0003a<C5574r> c0003a6) {
        this.f29577a = c0003a;
        this.f29578b = c0003a2;
        this.f29579c = c0003a3;
        this.f29580d = c0003a4;
        this.f29581e = c0003a5;
        this.f29582f = c0003a6;
    }

    /* renamed from: b */
    public aq m38581b() {
        return new aq((byte[]) this.f29577a.a(), (byte[]) this.f29578b.a(), (byte[]) this.f29579c.a(), (BluetoothGatt) this.f29580d.a(), (av) this.f29581e.a(), (C5574r) this.f29582f.a());
    }

    /* renamed from: a */
    public static ar m38579a(C0003a<byte[]> c0003a, C0003a<byte[]> c0003a2, C0003a<byte[]> c0003a3, C0003a<BluetoothGatt> c0003a4, C0003a<av> c0003a5, C0003a<C5574r> c0003a6) {
        return new ar(c0003a, c0003a2, c0003a3, c0003a4, c0003a5, c0003a6);
    }
}
