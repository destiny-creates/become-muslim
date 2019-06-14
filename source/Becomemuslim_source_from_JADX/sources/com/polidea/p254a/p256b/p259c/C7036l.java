package com.polidea.p254a.p256b.p259c;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.polidea.p254a.p256b.p258b.av;
import com.polidea.p254a.p256b.p262f.C5611y;
import java.util.concurrent.TimeUnit;
import p000a.p003b.p004a.C0003a;
import p289e.C5986h;

/* compiled from: OperationsProviderImpl */
/* renamed from: com.polidea.a.b.c.l */
public class C7036l implements C5579k {
    /* renamed from: a */
    private final av f24981a;
    /* renamed from: b */
    private final BluetoothGatt f24982b;
    /* renamed from: c */
    private final C5611y f24983c;
    /* renamed from: d */
    private final C5583t f24984d;
    /* renamed from: e */
    private final C5986h f24985e;
    /* renamed from: f */
    private final C5986h f24986f;
    /* renamed from: g */
    private final C0003a<C8244n> f24987g;

    C7036l(av avVar, BluetoothGatt bluetoothGatt, C5611y c5611y, C5583t c5583t, C5986h c5986h, C5986h c5986h2, C0003a<C8244n> c0003a) {
        this.f24981a = avVar;
        this.f24982b = bluetoothGatt;
        this.f24983c = c5611y;
        this.f24984d = c5583t;
        this.f24985e = c5986h;
        this.f24986f = c5986h2;
        this.f24987g = c0003a;
    }

    /* renamed from: a */
    public C8243i mo5006a(int i) {
        return new C8243i(this.f24981a, this.f24982b, this.f24984d, i);
    }

    /* renamed from: a */
    public C8239a mo5002a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return new C8239a(this.f24981a, this.f24982b, this.f24984d, bluetoothGattCharacteristic);
    }

    /* renamed from: a */
    public C8244n mo5007a() {
        return (C8244n) this.f24987g.a();
    }

    /* renamed from: a */
    public C8247s mo5008a(long j, TimeUnit timeUnit) {
        return new C8247s(this.f24981a, this.f24982b, this.f24983c, new C5583t(j, timeUnit, this.f24986f));
    }

    /* renamed from: a */
    public C8240b mo5003a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        return new C8240b(this.f24981a, this.f24982b, this.f24984d, bluetoothGattCharacteristic, bArr);
    }

    /* renamed from: a */
    public C8242f mo5005a(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        return new C8242f(this.f24981a, this.f24982b, this.f24984d, 2, bluetoothGattDescriptor, bArr);
    }

    /* renamed from: a */
    public C8241e mo5004a(int i, long j, TimeUnit timeUnit) {
        return new C8241e(this.f24981a, this.f24982b, this.f24984d, i, j, timeUnit, this.f24986f);
    }
}
