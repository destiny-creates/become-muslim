package com.polidea.p254a.p256b.p259c;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.p254a.p255a.C5549m;
import com.polidea.p254a.p256b.C7998q;
import com.polidea.p254a.p256b.p258b.av;
import com.polidea.p254a.p256b.p262f.C5601c;
import java.util.UUID;
import p289e.C5974e;
import p289e.p291b.C5919g;

/* compiled from: CharacteristicReadOperation */
/* renamed from: com.polidea.a.b.c.a */
public class C8239a extends C7998q<byte[]> {
    /* renamed from: a */
    private final BluetoothGattCharacteristic f32407a;

    /* compiled from: CharacteristicReadOperation */
    /* renamed from: com.polidea.a.b.c.a$1 */
    class C70191 implements C5919g<C5601c<UUID>, byte[]> {
        /* renamed from: a */
        final /* synthetic */ C8239a f24961a;

        C70191(C8239a c8239a) {
            this.f24961a = c8239a;
        }

        /* renamed from: a */
        public byte[] m32866a(C5601c<UUID> c5601c) {
            return c5601c.f18726b;
        }
    }

    /* compiled from: CharacteristicReadOperation */
    /* renamed from: com.polidea.a.b.c.a$2 */
    class C70202 implements C5919g<C5601c<UUID>, Boolean> {
        /* renamed from: a */
        final /* synthetic */ C8239a f24962a;

        C70202(C8239a c8239a) {
            this.f24962a = c8239a;
        }

        /* renamed from: a */
        public Boolean m32867a(C5601c<UUID> c5601c) {
            return Boolean.valueOf(((UUID) c5601c.f18725a).equals(this.f24962a.f32407a.getUuid()));
        }
    }

    C8239a(av avVar, BluetoothGatt bluetoothGatt, C5583t c5583t, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGatt, avVar, C5549m.f18597c, c5583t);
        this.f32407a = bluetoothGattCharacteristic;
    }

    /* renamed from: a */
    protected C5974e<byte[]> mo6755a(av avVar) {
        return avVar.m23717f().m25013b(new C70202(this)).m25030e(new C70191(this));
    }

    /* renamed from: a */
    protected boolean mo6756a(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.readCharacteristic(this.f32407a);
    }
}
