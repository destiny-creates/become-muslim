package com.polidea.p254a.p263c;

import com.polidea.p254a.ah;

/* compiled from: ScanResult */
/* renamed from: com.polidea.a.c.d */
public class C5621d {
    /* renamed from: a */
    private final ah f18783a;
    /* renamed from: b */
    private final int f18784b;
    /* renamed from: c */
    private final long f18785c;
    /* renamed from: d */
    private final C5616a f18786d;
    /* renamed from: e */
    private final C5620c f18787e;

    public C5621d(ah ahVar, int i, long j, C5616a c5616a, C5620c c5620c) {
        this.f18783a = ahVar;
        this.f18784b = i;
        this.f18785c = j;
        this.f18786d = c5616a;
        this.f18787e = c5620c;
    }

    /* renamed from: a */
    public ah m23906a() {
        return this.f18783a;
    }

    /* renamed from: b */
    public int m23907b() {
        return this.f18784b;
    }

    /* renamed from: c */
    public C5620c m23908c() {
        return this.f18787e;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ScanResult{bleDevice=");
        stringBuilder.append(this.f18783a);
        stringBuilder.append(", rssi=");
        stringBuilder.append(this.f18784b);
        stringBuilder.append(", timestampNanos=");
        stringBuilder.append(this.f18785c);
        stringBuilder.append(", callbackType=");
        stringBuilder.append(this.f18786d);
        stringBuilder.append(", scanRecord=");
        stringBuilder.append(this.f18787e);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
