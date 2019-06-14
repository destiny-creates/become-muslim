package com.polidea.p254a.p255a;

/* compiled from: BleGattOperationType */
/* renamed from: com.polidea.a.a.m */
public class C5549m {
    /* renamed from: a */
    public static final C5549m f18595a = new C5549m("CONNECTION_STATE");
    /* renamed from: b */
    public static final C5549m f18596b = new C5549m("SERVICE_DISCOVERY");
    /* renamed from: c */
    public static final C5549m f18597c = new C5549m("CHARACTERISTIC_READ");
    /* renamed from: d */
    public static final C5549m f18598d = new C5549m("CHARACTERISTIC_WRITE");
    /* renamed from: e */
    public static final C5549m f18599e = new C5549m("CHARACTERISTIC_LONG_WRITE");
    /* renamed from: f */
    public static final C5549m f18600f = new C5549m("CHARACTERISTIC_CHANGED");
    /* renamed from: g */
    public static final C5549m f18601g = new C5549m("DESCRIPTOR_READ");
    /* renamed from: h */
    public static final C5549m f18602h = new C5549m("DESCRIPTOR_WRITE");
    /* renamed from: i */
    public static final C5549m f18603i = new C5549m("RELIABLE_WRITE_COMPLETED");
    /* renamed from: j */
    public static final C5549m f18604j = new C5549m("READ_RSSI");
    /* renamed from: k */
    public static final C5549m f18605k = new C5549m("ON_MTU_CHANGED");
    /* renamed from: l */
    public static final C5549m f18606l = new C5549m("CONNECTION_PRIORITY_CHANGE");
    /* renamed from: m */
    private final String f18607m;

    private C5549m(String str) {
        this.f18607m = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BleGattOperation{description='");
        stringBuilder.append(this.f18607m);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
