package com.polidea.p254a;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.p254a.p255a.C6974l;
import java.util.concurrent.TimeUnit;
import p289e.C5912a;
import p289e.C5974e;
import p289e.C5974e.C7337c;

/* compiled from: RxBleConnection */
/* renamed from: com.polidea.a.af */
public interface af {

    /* compiled from: RxBleConnection */
    /* renamed from: com.polidea.a.af$a */
    public enum C5554a {
        CONNECTING("CONNECTING"),
        CONNECTED("CONNECTED"),
        DISCONNECTED("DISCONNECTED"),
        DISCONNECTING("DISCONNECTING");
        
        /* renamed from: e */
        private final String f18626e;

        private C5554a(String str) {
            this.f18626e = str;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RxBleConnectionState{");
            stringBuilder.append(this.f18626e);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    /* compiled from: RxBleConnection */
    /* renamed from: com.polidea.a.af$b */
    public interface C7933b extends C7337c<Boolean, Boolean> {
    }

    /* compiled from: RxBleConnection */
    /* renamed from: com.polidea.a.af$c */
    public interface C7934c extends C7337c<C5555a, C5555a> {

        /* compiled from: RxBleConnection */
        /* renamed from: com.polidea.a.af$c$a */
        public static class C5555a {
            /* renamed from: a */
            final C6974l f18627a;

            /* renamed from: a */
            public C6974l m23622a() {
                return this.f18627a;
            }
        }
    }

    /* renamed from: a */
    C5912a mo4986a(int i, long j, TimeUnit timeUnit);

    /* renamed from: a */
    C5974e<ai> mo4987a();

    /* renamed from: a */
    C5974e<Integer> mo4988a(int i);

    /* renamed from: a */
    C5974e<byte[]> mo4989a(BluetoothGattCharacteristic bluetoothGattCharacteristic);

    /* renamed from: a */
    C5974e<C5974e<byte[]>> mo4990a(BluetoothGattCharacteristic bluetoothGattCharacteristic, C5631z c5631z);

    /* renamed from: a */
    C5974e<byte[]> mo4991a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr);

    /* renamed from: a */
    <T> C5974e<T> mo4992a(ag<T> agVar);

    /* renamed from: b */
    C5974e<Integer> mo4993b();

    /* renamed from: b */
    C5974e<C5974e<byte[]>> mo4994b(BluetoothGattCharacteristic bluetoothGattCharacteristic, C5631z c5631z);

    /* renamed from: c */
    int mo4995c();
}
