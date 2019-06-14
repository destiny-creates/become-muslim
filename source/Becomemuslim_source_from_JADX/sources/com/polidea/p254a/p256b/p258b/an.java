package com.polidea.p254a.p256b.p258b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

/* compiled from: NativeCallbackDispatcher */
/* renamed from: com.polidea.a.b.b.an */
class an {
    /* renamed from: a */
    private BluetoothGattCallback f18647a;

    an() {
    }

    /* renamed from: a */
    public void m23659a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.f18647a != null) {
            this.f18647a.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        }
    }

    /* renamed from: a */
    public void m23658a(BluetoothGatt bluetoothGatt, int i, int i2) {
        if (this.f18647a != null) {
            this.f18647a.onConnectionStateChange(bluetoothGatt, i, i2);
        }
    }

    /* renamed from: a */
    public void m23661a(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        if (this.f18647a != null) {
            this.f18647a.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
        }
    }

    /* renamed from: b */
    public void m23666b(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        if (this.f18647a != null) {
            this.f18647a.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        }
    }

    @TargetApi(21)
    /* renamed from: b */
    public void m23664b(BluetoothGatt bluetoothGatt, int i, int i2) {
        if (this.f18647a != null) {
            this.f18647a.onMtuChanged(bluetoothGatt, i, i2);
        }
    }

    /* renamed from: c */
    public void m23667c(BluetoothGatt bluetoothGatt, int i, int i2) {
        if (this.f18647a != null) {
            this.f18647a.onReadRemoteRssi(bluetoothGatt, i, i2);
        }
    }

    /* renamed from: a */
    public void m23657a(BluetoothGatt bluetoothGatt, int i) {
        if (this.f18647a != null) {
            this.f18647a.onReliableWriteCompleted(bluetoothGatt, i);
        }
    }

    /* renamed from: b */
    public void m23663b(BluetoothGatt bluetoothGatt, int i) {
        if (this.f18647a != null) {
            this.f18647a.onServicesDiscovered(bluetoothGatt, i);
        }
    }

    /* renamed from: a */
    public void m23660a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        if (this.f18647a != null) {
            this.f18647a.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        }
    }

    /* renamed from: a */
    void m23662a(BluetoothGattCallback bluetoothGattCallback) {
        this.f18647a = bluetoothGattCallback;
    }

    /* renamed from: b */
    void m23665b(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        if (this.f18647a != null) {
            this.f18647a.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        }
    }
}
