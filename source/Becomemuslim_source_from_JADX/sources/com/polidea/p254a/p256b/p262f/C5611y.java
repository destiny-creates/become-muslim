package com.polidea.p254a.p256b.p262f;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.polidea.p254a.ai;
import com.polidea.p254a.p256b.C5615p;
import com.polidea.p254a.p264d.C5626b;

/* compiled from: RxBleServicesLogger */
/* renamed from: com.polidea.a.b.f.y */
public class C5611y {
    /* renamed from: a */
    private final C5603f f18743a;

    C5611y(C5603f c5603f) {
        this.f18743a = c5603f;
    }

    /* renamed from: a */
    public void m23856a(ai aiVar, BluetoothDevice bluetoothDevice) {
        if (C5615p.m23867b(2)) {
            C5615p.m23863a("Preparing services description", new Object[0]);
            C5615p.m23863a(m23852b(aiVar, bluetoothDevice), new Object[0]);
        }
    }

    /* renamed from: b */
    private String m23852b(ai aiVar, BluetoothDevice bluetoothDevice) {
        StringBuilder stringBuilder = new StringBuilder();
        m23846a(bluetoothDevice, stringBuilder);
        for (BluetoothGattService bluetoothGattService : aiVar.m23638a()) {
            stringBuilder.append('\n');
            m23850a(stringBuilder, bluetoothGattService);
        }
        stringBuilder.append("\n--------------- ====== Finished peripheral content ====== ---------------");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private void m23850a(StringBuilder stringBuilder, BluetoothGattService bluetoothGattService) {
        m23854b(stringBuilder, bluetoothGattService);
        stringBuilder.append("-> Characteristics:");
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
            m23853b(stringBuilder, bluetoothGattCharacteristic);
            m23855c(stringBuilder, bluetoothGattCharacteristic);
            m23848a(stringBuilder, bluetoothGattCharacteristic);
        }
    }

    /* renamed from: a */
    private void m23848a(StringBuilder stringBuilder, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (!bluetoothGattCharacteristic.getDescriptors().isEmpty()) {
            m23847a(stringBuilder);
            for (BluetoothGattDescriptor a : bluetoothGattCharacteristic.getDescriptors()) {
                m23849a(stringBuilder, a);
            }
        }
    }

    /* renamed from: a */
    private void m23847a(StringBuilder stringBuilder) {
        stringBuilder.append('\n');
        stringBuilder.append('\t');
        stringBuilder.append("  ");
        stringBuilder.append("-> Descriptors: ");
    }

    /* renamed from: b */
    private void m23853b(StringBuilder stringBuilder, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        stringBuilder.append('\n');
        stringBuilder.append('\t');
        stringBuilder.append("* ");
        stringBuilder.append(m23843a(bluetoothGattCharacteristic));
        stringBuilder.append(" (");
        stringBuilder.append(bluetoothGattCharacteristic.getUuid().toString());
        stringBuilder.append(")");
    }

    /* renamed from: a */
    private void m23849a(StringBuilder stringBuilder, BluetoothGattDescriptor bluetoothGattDescriptor) {
        stringBuilder.append('\n');
        stringBuilder.append('\t');
        stringBuilder.append('\t');
        stringBuilder.append("* ");
        stringBuilder.append(m23844a(bluetoothGattDescriptor));
        stringBuilder.append(" (");
        stringBuilder.append(bluetoothGattDescriptor.getUuid().toString());
        stringBuilder.append(")");
    }

    /* renamed from: a */
    private String m23844a(BluetoothGattDescriptor bluetoothGattDescriptor) {
        bluetoothGattDescriptor = C5626b.m23924c(bluetoothGattDescriptor.getUuid());
        return bluetoothGattDescriptor == null ? "Unknown descriptor" : bluetoothGattDescriptor;
    }

    /* renamed from: c */
    private void m23855c(StringBuilder stringBuilder, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        stringBuilder.append('\n');
        stringBuilder.append('\t');
        stringBuilder.append("  ");
        stringBuilder.append("Properties: ");
        stringBuilder.append(this.f18743a.m23824a(bluetoothGattCharacteristic.getProperties()));
    }

    /* renamed from: a */
    private String m23843a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        bluetoothGattCharacteristic = C5626b.m23923b(bluetoothGattCharacteristic.getUuid());
        return bluetoothGattCharacteristic == null ? "Unknown characteristic" : bluetoothGattCharacteristic;
    }

    /* renamed from: a */
    private void m23846a(BluetoothDevice bluetoothDevice, StringBuilder stringBuilder) {
        stringBuilder.append("--------------- ====== Printing peripheral content ====== ---------------\n");
        stringBuilder.append("PERIPHERAL ADDRESS: ");
        stringBuilder.append(bluetoothDevice.getAddress());
        stringBuilder.append('\n');
        stringBuilder.append("PERIPHERAL NAME: ");
        stringBuilder.append(bluetoothDevice.getName());
        stringBuilder.append('\n');
        stringBuilder.append("-------------------------------------------------------------------------");
    }

    /* renamed from: b */
    private void m23854b(StringBuilder stringBuilder, BluetoothGattService bluetoothGattService) {
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder.append(m23851b(bluetoothGattService));
        stringBuilder.append(" - ");
        stringBuilder.append(m23845a(bluetoothGattService));
        stringBuilder.append(" (");
        stringBuilder.append(bluetoothGattService.getUuid().toString());
        stringBuilder.append(")\n");
        stringBuilder.append("Instance ID: ");
        stringBuilder.append(bluetoothGattService.getInstanceId());
        stringBuilder.append('\n');
    }

    /* renamed from: a */
    private String m23845a(BluetoothGattService bluetoothGattService) {
        bluetoothGattService = C5626b.m23921a(bluetoothGattService.getUuid());
        return bluetoothGattService == null ? "Unknown service" : bluetoothGattService;
    }

    /* renamed from: b */
    private String m23851b(BluetoothGattService bluetoothGattService) {
        return bluetoothGattService.getType() == null ? "Primary Service" : "Secondary Service";
    }
}
