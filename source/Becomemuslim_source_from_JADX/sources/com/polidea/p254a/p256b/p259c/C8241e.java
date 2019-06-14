package com.polidea.p254a.p256b.p259c;

import android.bluetooth.BluetoothGatt;
import com.polidea.p254a.p255a.C5549m;
import com.polidea.p254a.p256b.C7998q;
import com.polidea.p254a.p256b.p258b.av;
import java.util.concurrent.TimeUnit;
import p289e.C5974e;
import p289e.C5986h;

/* compiled from: ConnectionPriorityChangeOperation */
/* renamed from: com.polidea.a.b.c.e */
public class C8241e extends C7998q<Long> {
    /* renamed from: a */
    private final int f32410a;
    /* renamed from: b */
    private final long f32411b;
    /* renamed from: c */
    private final TimeUnit f32412c;
    /* renamed from: d */
    private final C5986h f32413d;

    C8241e(av avVar, BluetoothGatt bluetoothGatt, C5583t c5583t, int i, long j, TimeUnit timeUnit, C5986h c5986h) {
        super(bluetoothGatt, avVar, C5549m.f18606l, c5583t);
        this.f32410a = i;
        this.f32411b = j;
        this.f32412c = timeUnit;
        this.f32413d = c5986h;
    }

    /* renamed from: a */
    protected C5974e<Long> mo6755a(av avVar) {
        return C5974e.m24969a(this.f32411b, this.f32412c, this.f32413d);
    }

    /* renamed from: a */
    protected boolean mo6756a(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.requestConnectionPriority(this.f32410a);
    }
}
