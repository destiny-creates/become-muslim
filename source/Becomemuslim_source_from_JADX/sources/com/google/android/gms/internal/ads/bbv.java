package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import org.json.JSONObject;

final /* synthetic */ class bbv implements bbr {
    /* renamed from: a */
    static final bbr f23887a = new bbv();

    private bbv() {
    }

    /* renamed from: a */
    public final Object mo4094a(JSONObject jSONObject) {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(bbu.f15168b));
    }
}
