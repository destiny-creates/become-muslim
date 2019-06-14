package com.polidea.p254a.p256b.p262f;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.content.Context;
import android.os.Build.VERSION;
import com.polidea.p254a.p256b.C5615p;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: BleConnectionCompat */
/* renamed from: com.polidea.a.b.f.b */
public class C5600b {
    /* renamed from: a */
    private final Context f18724a;

    public C5600b(Context context) {
        this.f18724a = context;
    }

    /* renamed from: a */
    public BluetoothGatt m23820a(BluetoothDevice bluetoothDevice, boolean z, BluetoothGattCallback bluetoothGattCallback) {
        if (bluetoothDevice == null) {
            return null;
        }
        if (VERSION.SDK_INT < 24) {
            if (z) {
                try {
                    C5615p.m23863a("Trying to connectGatt using reflection.", new Object[0]);
                    Object a = m23816a(m23815a());
                    if (a == null) {
                        C5615p.m23870d("Couldn't get iBluetoothGatt object", new Object[0]);
                        return m23813a(bluetoothGattCallback, bluetoothDevice, true);
                    }
                    BluetoothGatt a2 = m23814a(a, bluetoothDevice);
                    if (a2 == null) {
                        C5615p.m23870d("Couldn't create BluetoothGatt object", new Object[0]);
                        return m23813a(bluetoothGattCallback, bluetoothDevice, true);
                    }
                    if (!m23819a(a2, bluetoothGattCallback, true)) {
                        C5615p.m23870d("Connection using reflection failed, closing gatt", new Object[0]);
                        a2.close();
                    }
                    return a2;
                } catch (Throwable e) {
                    C5615p.m23866b(e, "Error during reflection", new Object[0]);
                    return m23813a(bluetoothGattCallback, bluetoothDevice, true);
                }
            }
        }
        return m23813a(bluetoothGattCallback, bluetoothDevice, z);
    }

    /* renamed from: a */
    private BluetoothGatt m23813a(BluetoothGattCallback bluetoothGattCallback, BluetoothDevice bluetoothDevice, boolean z) {
        C5615p.m23863a("Connecting without reflection", new Object[0]);
        if (VERSION.SDK_INT >= 23) {
            return bluetoothDevice.connectGatt(this.f18724a, z, bluetoothGattCallback, 2);
        }
        return bluetoothDevice.connectGatt(this.f18724a, z, bluetoothGattCallback);
    }

    /* renamed from: a */
    private boolean m23819a(BluetoothGatt bluetoothGatt, BluetoothGattCallback bluetoothGattCallback, boolean z) {
        C5615p.m23863a("Connecting using reflection", new Object[0]);
        m23818a(bluetoothGatt, z);
        z = bluetoothGatt.getClass().getDeclaredMethod("connect", new Class[]{Boolean.class, BluetoothGattCallback.class});
        z.setAccessible(true);
        return ((Boolean) z.invoke(bluetoothGatt, new Object[]{Boolean.valueOf(true), bluetoothGattCallback})).booleanValue();
    }

    @TargetApi(23)
    /* renamed from: a */
    private BluetoothGatt m23814a(Object obj, BluetoothDevice bluetoothDevice) {
        Constructor constructor = BluetoothGatt.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Found constructor with args count = ");
        stringBuilder.append(constructor.getParameterTypes().length);
        C5615p.m23863a(stringBuilder.toString(), new Object[0]);
        if (constructor.getParameterTypes().length == 4) {
            return (BluetoothGatt) constructor.newInstance(new Object[]{this.f18724a, obj, bluetoothDevice, Integer.valueOf(2)});
        }
        return (BluetoothGatt) constructor.newInstance(new Object[]{this.f18724a, obj, bluetoothDevice});
    }

    /* renamed from: a */
    private Object m23816a(Object obj) {
        if (obj == null) {
            return null;
        }
        return m23817a(obj.getClass(), "getBluetoothGatt").invoke(obj, new Object[0]);
    }

    /* renamed from: a */
    private Object m23815a() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            return null;
        }
        return m23817a(defaultAdapter.getClass(), "getBluetoothManager").invoke(defaultAdapter, new Object[0]);
    }

    /* renamed from: a */
    private Method m23817a(Class<?> cls, String str) {
        cls = cls.getDeclaredMethod(str, new Class[0]);
        cls.setAccessible(true);
        return cls;
    }

    /* renamed from: a */
    private void m23818a(BluetoothGatt bluetoothGatt, boolean z) {
        Field declaredField = bluetoothGatt.getClass().getDeclaredField("mAutoConnect");
        declaredField.setAccessible(true);
        declaredField.setBoolean(bluetoothGatt, z);
    }
}
