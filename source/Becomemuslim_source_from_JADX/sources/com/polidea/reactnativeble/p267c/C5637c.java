package com.polidea.reactnativeble.p267c;

import com.facebook.react.bridge.ReadableArray;

/* compiled from: BleErrorUtils */
/* renamed from: com.polidea.reactnativeble.c.c */
public class C5637c {
    /* renamed from: a */
    public static C5635a m23954a() {
        return new C5635a(C5636b.OperationCancelled, null, null);
    }

    /* renamed from: a */
    public static C5635a m23959a(String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : strArr) {
            stringBuilder.append(append);
            stringBuilder.append(", ");
        }
        strArr = new C5635a(C5636b.InvalidIdentifiers, null, null);
        strArr.f18830e = stringBuilder.toString();
        return strArr;
    }

    /* renamed from: a */
    public static C5635a m23955a(ReadableArray readableArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < readableArray.size(); i++) {
            stringBuilder.append(readableArray.getString(i));
            stringBuilder.append(", ");
        }
        readableArray = new C5635a(C5636b.InvalidIdentifiers, null, null);
        readableArray.f18830e = stringBuilder.toString();
        return readableArray;
    }

    /* renamed from: a */
    public static C5635a m23956a(String str) {
        C5635a c5635a = new C5635a(C5636b.DeviceNotFound, null, null);
        c5635a.f18826a = str;
        return c5635a;
    }

    /* renamed from: b */
    public static C5635a m23960b(String str) {
        C5635a c5635a = new C5635a(C5636b.DeviceNotConnected, null, null);
        c5635a.f18826a = str;
        return c5635a;
    }

    /* renamed from: c */
    public static C5635a m23961c(String str) {
        C5635a c5635a = new C5635a(C5636b.CharacteristicNotFound, null, null);
        c5635a.f18828c = str;
        return c5635a;
    }

    /* renamed from: a */
    public static C5635a m23957a(String str, String str2) {
        C5635a c5635a = new C5635a(C5636b.CharacteristicInvalidDataFormat, null, null);
        c5635a.f18828c = str2;
        c5635a.f18830e = str;
        return c5635a;
    }

    /* renamed from: d */
    public static C5635a m23962d(String str) {
        C5635a c5635a = new C5635a(C5636b.ServiceNotFound, null, null);
        c5635a.f18827b = str;
        return c5635a;
    }

    /* renamed from: a */
    public static C5635a m23958a(String str, String str2, String str3, String str4) {
        C5635a c5635a = new C5635a(C5636b.CharacteristicNotifyChangeFailed, str, null);
        c5635a.f18826a = str2;
        c5635a.f18827b = str3;
        c5635a.f18828c = str4;
        return c5635a;
    }

    /* renamed from: e */
    public static C5635a m23963e(String str) {
        C5635a c5635a = new C5635a(C5636b.ServicesNotDiscovered, null, null);
        c5635a.f18826a = str;
        return c5635a;
    }
}
