package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

final /* synthetic */ class mn implements ms {
    /* renamed from: a */
    private final String f24170a;
    /* renamed from: b */
    private final String f24171b;
    /* renamed from: c */
    private final Map f24172c;
    /* renamed from: d */
    private final byte[] f24173d;

    mn(String str, String str2, Map map, byte[] bArr) {
        this.f24170a = str;
        this.f24171b = str2;
        this.f24172c = map;
        this.f24173d = bArr;
    }

    /* renamed from: a */
    public final void mo4316a(JsonWriter jsonWriter) {
        mm.m19896a(this.f24170a, this.f24171b, this.f24172c, this.f24173d, jsonWriter);
    }
}
