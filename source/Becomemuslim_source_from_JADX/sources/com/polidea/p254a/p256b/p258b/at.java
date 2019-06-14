package com.polidea.p254a.p256b.p258b;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.DeadObjectException;
import com.polidea.p254a.C5631z;
import com.polidea.p254a.af;
import com.polidea.p254a.ag;
import com.polidea.p254a.ai;
import com.polidea.p254a.p255a.C5548g;
import com.polidea.p254a.p255a.C6973f;
import com.polidea.p254a.p256b.C7084k;
import com.polidea.p254a.p256b.p259c.C5579k;
import com.polidea.p254a.p256b.p261e.C5598i;
import com.polidea.p254a.p256b.p261e.C7062d;
import com.polidea.p254a.p256b.p262f.C7082v;
import java.util.concurrent.TimeUnit;
import p000a.p003b.p004a.C0003a;
import p289e.C5912a;
import p289e.C5974e;
import p289e.C5986h;
import p289e.C7332c;
import p289e.p291b.C5913a;

/* compiled from: RxBleConnectionImpl */
/* renamed from: com.polidea.a.b.b.at */
public class at implements af {
    /* renamed from: a */
    private final C7062d f24918a;
    /* renamed from: b */
    private final av f24919b;
    /* renamed from: c */
    private final BluetoothGatt f24920c;
    /* renamed from: d */
    private final C5579k f24921d;
    /* renamed from: e */
    private final C0003a<Object> f24922e;
    /* renamed from: f */
    private final C5986h f24923f;
    /* renamed from: g */
    private final ax f24924g;
    /* renamed from: h */
    private final aq f24925h;
    /* renamed from: i */
    private final ak f24926i;
    /* renamed from: j */
    private final C5574r f24927j;
    /* renamed from: k */
    private final C5576y f24928k;

    public at(C7062d c7062d, av avVar, BluetoothGatt bluetoothGatt, ax axVar, aq aqVar, ak akVar, C5574r c5574r, C5579k c5579k, C0003a<Object> c0003a, C5986h c5986h, C5576y c5576y) {
        this.f24918a = c7062d;
        this.f24919b = avVar;
        this.f24920c = bluetoothGatt;
        this.f24924g = axVar;
        this.f24925h = aqVar;
        this.f24926i = akVar;
        this.f24927j = c5574r;
        this.f24921d = c5579k;
        this.f24922e = c0003a;
        this.f24923f = c5986h;
        this.f24928k = c5576y;
    }

    /* renamed from: a */
    public C5912a mo4986a(int i, long j, TimeUnit timeUnit) {
        if (i != 2 && i != 0 && i != 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Connection priority must have valid value from BluetoothGatt (received ");
            stringBuilder.append(i);
            stringBuilder.append(")");
            return C5912a.m24804a(new IllegalArgumentException(stringBuilder.toString()));
        } else if (j <= 0) {
            return C5912a.m24804a(new IllegalArgumentException("Delay must be bigger than 0"));
        } else {
            return this.f24918a.mo5016a(this.f24921d.mo5004a(i, j, timeUnit)).m25028e();
        }
    }

    /* renamed from: a */
    public C5974e<Integer> mo4988a(int i) {
        return this.f24918a.mo5016a(this.f24921d.mo5006a(i));
    }

    /* renamed from: c */
    public int mo4995c() {
        return this.f24926i.mo4984c();
    }

    /* renamed from: a */
    public C5974e<ai> mo4987a() {
        return this.f24924g.m23731a(20, TimeUnit.SECONDS);
    }

    /* renamed from: a */
    public C5974e<C5974e<byte[]>> mo4990a(BluetoothGattCharacteristic bluetoothGattCharacteristic, C5631z c5631z) {
        return this.f24928k.m23753a(bluetoothGattCharacteristic, 16).m24821b(this.f24925h.m23685a(bluetoothGattCharacteristic, c5631z, false));
    }

    /* renamed from: b */
    public C5974e<C5974e<byte[]>> mo4994b(BluetoothGattCharacteristic bluetoothGattCharacteristic, C5631z c5631z) {
        return this.f24928k.m23753a(bluetoothGattCharacteristic, 32).m24821b(this.f24925h.m23685a(bluetoothGattCharacteristic, c5631z, true));
    }

    /* renamed from: a */
    public C5974e<byte[]> mo4989a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return this.f24928k.m23753a(bluetoothGattCharacteristic, 2).m24821b(this.f24918a.mo5016a(this.f24921d.mo5002a(bluetoothGattCharacteristic)));
    }

    /* renamed from: a */
    public C5974e<byte[]> mo4991a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        return this.f24928k.m23753a(bluetoothGattCharacteristic, 76).m24821b(this.f24918a.mo5016a(this.f24921d.mo5003a(bluetoothGattCharacteristic, bArr)));
    }

    /* renamed from: b */
    public C5974e<Integer> mo4993b() {
        return this.f24918a.mo5016a(this.f24921d.mo5007a());
    }

    /* renamed from: a */
    public <T> C5974e<T> mo4992a(final ag<T> agVar) {
        return this.f24918a.mo5016a(new C7084k<T>(this) {
            /* renamed from: b */
            final /* synthetic */ at f29584b;

            /* compiled from: RxBleConnectionImpl */
            /* renamed from: com.polidea.a.b.b.at$1$1 */
            class C69981 implements C5913a {
                /* renamed from: a */
                final /* synthetic */ C79381 f24917a;

                C69981(C79381 c79381) {
                    this.f24917a = c79381;
                }

                /* renamed from: a */
                public void mo4985a() {
                    this.f24917a.f29584b.f24919b.m23712a(null);
                }
            }

            /* renamed from: a */
            protected void mo6272a(C7332c<T> c7332c, C5598i c5598i) {
                try {
                    C5974e a = agVar.mo5039a(this.f29584b.f24920c, this.f29584b.f24919b, this.f29584b.f24923f);
                    if (a != null) {
                        a.m25010b(m38582b()).m25006a(new C7082v(c7332c, c5598i));
                        return;
                    }
                    throw new IllegalArgumentException("The custom operation asObservable method must return a non-null observable");
                } finally {
                    c5598i.mo5017a();
                }
            }

            /* renamed from: b */
            private C5913a m38582b() {
                return new C69981(this);
            }

            /* renamed from: a */
            protected C5548g mo6271a(DeadObjectException deadObjectException) {
                return new C6973f(deadObjectException, this.f29584b.f24920c.getDevice().getAddress(), -1);
            }
        });
    }
}
