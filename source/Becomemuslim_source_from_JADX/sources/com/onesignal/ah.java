package com.onesignal;

import com.facebook.react.uimanager.ViewProps;
import org.json.JSONObject;

/* compiled from: OSPermissionState */
public class ah implements Cloneable {
    /* renamed from: a */
    ag<Object, ah> f18316a = new ag("changed", false);
    /* renamed from: b */
    private boolean f18317b;

    ah(boolean z) {
        if (z) {
            this.f18317b = aq.m23285b(aq.f18435a, "ONESIGNAL_ACCEPTED_NOTIFICATION_LAST", false);
        } else {
            m23076a();
        }
    }

    /* renamed from: a */
    void m23076a() {
        m23075a(al.m23092a(am.f18401b));
    }

    /* renamed from: b */
    public boolean m23077b() {
        return this.f18317b;
    }

    /* renamed from: a */
    private void m23075a(boolean z) {
        Object obj = this.f18317b != z ? 1 : null;
        this.f18317b = z;
        if (obj != null) {
            this.f18316a.m23074c(this);
        }
    }

    /* renamed from: c */
    void m23078c() {
        aq.m23280a(aq.f18435a, "ONESIGNAL_ACCEPTED_NOTIFICATION_LAST", this.f18317b);
    }

    protected java.lang.Object clone() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = super.clone();	 Catch:{ Throwable -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.ah.clone():java.lang.Object");
    }

    /* renamed from: d */
    public JSONObject m23079d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ViewProps.ENABLED, this.f18317b);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return m23079d().toString();
    }
}
