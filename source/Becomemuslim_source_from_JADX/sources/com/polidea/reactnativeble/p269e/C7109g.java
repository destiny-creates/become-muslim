package com.polidea.reactnativeble.p269e;

import android.bluetooth.BluetoothGatt;
import com.polidea.p254a.ag;
import com.polidea.p254a.p256b.C5615p;
import com.polidea.p254a.p256b.p258b.av;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import p289e.C5974e;
import p289e.C5986h;

/* compiled from: RefreshGattCustomOperation */
/* renamed from: com.polidea.reactnativeble.e.g */
public class C7109g implements ag<Boolean> {
    /* renamed from: a */
    public C5974e<Boolean> mo5039a(final BluetoothGatt bluetoothGatt, av avVar, C5986h c5986h) {
        return C5974e.m24974a(C5974e.m24978a(new Callable<Boolean>(this) {
            /* renamed from: b */
            final /* synthetic */ C7109g f18885b;

            public /* synthetic */ Object call() {
                return m23979a();
            }

            /* renamed from: a */
            public Boolean m23979a() {
                boolean z;
                boolean z2;
                Throwable th;
                String str;
                Object[] objArr;
                try {
                    Method method = bluetoothGatt.getClass().getMethod("refresh", new Class[0]);
                    if (method == null) {
                        C5615p.m23865b("Could not find function BluetoothGatt.refresh()", new Object[0]);
                        z = false;
                    } else {
                        z = ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                        if (!z) {
                            try {
                                C5615p.m23865b("BluetoothGatt.refresh() returned false", new Object[0]);
                            } catch (Throwable e) {
                                Throwable th2 = e;
                                z2 = z;
                                th = th2;
                                C5615p.m23864a(th, "Could not call function BluetoothGatt.refresh()", new Object[0]);
                                z = z2;
                                str = "Calling BluetoothGatt.refresh() status: %s";
                                objArr = new Object[1];
                                objArr[0] = z ? "Failure" : "Success";
                                C5615p.m23868c(str, objArr);
                                return Boolean.valueOf(z);
                            }
                        }
                    }
                } catch (Exception e2) {
                    th = e2;
                    z2 = false;
                    C5615p.m23864a(th, "Could not call function BluetoothGatt.refresh()", new Object[0]);
                    z = z2;
                    str = "Calling BluetoothGatt.refresh() status: %s";
                    objArr = new Object[1];
                    if (z) {
                    }
                    objArr[0] = z ? "Failure" : "Success";
                    C5615p.m23868c(str, objArr);
                    return Boolean.valueOf(z);
                }
                str = "Calling BluetoothGatt.refresh() status: %s";
                objArr = new Object[1];
                if (z) {
                }
                objArr[0] = z ? "Failure" : "Success";
                C5615p.m23868c(str, objArr);
                return Boolean.valueOf(z);
            }
        }).m25014b(c5986h).m25017c(1, TimeUnit.SECONDS, c5986h), avVar.m23713b());
    }
}
