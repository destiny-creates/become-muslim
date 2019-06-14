package com.polidea.p254a.p256b.p262f;

import com.polidea.p254a.p256b.C5615p;

/* compiled from: CharacteristicPropertiesParser */
/* renamed from: com.polidea.a.b.f.f */
public class C5603f {
    /* renamed from: a */
    private final int f18727a;
    /* renamed from: b */
    private final int f18728b;
    /* renamed from: c */
    private final int f18729c;
    /* renamed from: d */
    private final int f18730d;
    /* renamed from: e */
    private final int f18731e;
    /* renamed from: f */
    private final int f18732f;
    /* renamed from: g */
    private final int f18733g;
    /* renamed from: h */
    private final int[] f18734h = m23822a();

    /* renamed from: a */
    private static boolean m23821a(int i, int i2) {
        return (i & i2) != 0;
    }

    public C5603f(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f18727a = i;
        this.f18728b = i2;
        this.f18729c = i3;
        this.f18730d = i4;
        this.f18731e = i5;
        this.f18732f = i6;
        this.f18733g = i7;
    }

    /* renamed from: a */
    public String m23824a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (int i2 : this.f18734h) {
            if (C5603f.m23821a(i, i2)) {
                stringBuilder.append(m23823b(i2));
                stringBuilder.append(" ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private int[] m23822a() {
        return new int[]{this.f18727a, this.f18728b, this.f18729c, this.f18730d, this.f18731e, this.f18732f, this.f18733g};
    }

    /* renamed from: b */
    private String m23823b(int i) {
        if (i == this.f18728b) {
            return "READ";
        }
        if (i == this.f18730d) {
            return "WRITE";
        }
        if (i == this.f18729c) {
            return "WRITE_NO_RESPONSE";
        }
        if (i == this.f18733g) {
            return "SIGNED_WRITE";
        }
        if (i == this.f18732f) {
            return "INDICATE";
        }
        if (i == this.f18727a) {
            return "BROADCAST";
        }
        if (i == this.f18731e) {
            return "NOTIFY";
        }
        if (i == 0) {
            return "";
        }
        C5615p.m23871e("Unknown property specified", new Object[0]);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UNKNOWN (");
        stringBuilder.append(i);
        stringBuilder.append(" -> check android.bluetooth.BluetoothGattCharacteristic)");
        return stringBuilder.toString();
    }
}
