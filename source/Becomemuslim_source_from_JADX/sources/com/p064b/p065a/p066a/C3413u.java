package com.p064b.p065a.p066a;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.facebook.stetho.common.Utf8Charset;
import io.p347a.p348a.p349a.p350a.p355d.C6467a;
import java.io.IOException;
import org.json.JSONObject;

/* compiled from: SessionEventTransform */
/* renamed from: com.b.a.a.u */
class C3413u implements C6467a<C0999s> {
    C3413u() {
    }

    /* renamed from: a */
    public byte[] m10879a(C0999s c0999s) {
        return m10881b(c0999s).toString().getBytes(Utf8Charset.NAME);
    }

    @TargetApi(9)
    /* renamed from: b */
    public JSONObject m10881b(C0999s c0999s) {
        try {
            JSONObject jSONObject = new JSONObject();
            C1000t c1000t = c0999s.f2780a;
            jSONObject.put("appBundleId", c1000t.f2789a);
            jSONObject.put("executionId", c1000t.f2790b);
            jSONObject.put("installationId", c1000t.f2791c);
            jSONObject.put("androidId", c1000t.f2792d);
            jSONObject.put("advertisingId", c1000t.f2793e);
            jSONObject.put("limitAdTrackingEnabled", c1000t.f2794f);
            jSONObject.put("betaDeviceToken", c1000t.f2795g);
            jSONObject.put("buildId", c1000t.f2796h);
            jSONObject.put("osVersion", c1000t.f2797i);
            jSONObject.put("deviceModel", c1000t.f2798j);
            jSONObject.put("appVersionCode", c1000t.f2799k);
            jSONObject.put("appVersionName", c1000t.f2800l);
            jSONObject.put("timestamp", c0999s.f2781b);
            jSONObject.put("type", c0999s.f2782c.toString());
            if (c0999s.f2783d != null) {
                jSONObject.put("details", new JSONObject(c0999s.f2783d));
            }
            jSONObject.put("customType", c0999s.f2784e);
            if (c0999s.f2785f != null) {
                jSONObject.put("customAttributes", new JSONObject(c0999s.f2785f));
            }
            jSONObject.put("predefinedType", c0999s.f2786g);
            if (c0999s.f2787h != null) {
                jSONObject.put("predefinedAttributes", new JSONObject(c0999s.f2787h));
            }
            return jSONObject;
        } catch (C0999s c0999s2) {
            if (VERSION.SDK_INT >= 9) {
                throw new IOException(c0999s2.getMessage(), c0999s2);
            }
            throw new IOException(c0999s2.getMessage());
        }
    }
}
