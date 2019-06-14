package com.onesignal;

import org.json.JSONObject;

public class OSSubscriptionState implements Cloneable {
    /* renamed from: a */
    ag<Object, OSSubscriptionState> f18245a = new ag("changed", false);
    /* renamed from: b */
    private boolean f18246b;
    /* renamed from: c */
    private boolean f18247c;
    /* renamed from: d */
    private String f18248d;
    /* renamed from: e */
    private String f18249e;

    OSSubscriptionState(boolean z, boolean z2) {
        if (z) {
            this.f18247c = aq.m23285b(aq.f18435a, "ONESIGNAL_SUBSCRIPTION_LAST", false);
            this.f18248d = aq.m23283b(aq.f18435a, "ONESIGNAL_PLAYER_ID_LAST", null);
            this.f18249e = aq.m23283b(aq.f18435a, "ONESIGNAL_PUSH_TOKEN_LAST", null);
            this.f18246b = aq.m23285b(aq.f18435a, "ONESIGNAL_PERMISSION_ACCEPTED_LAST", false);
            return;
        }
        this.f18247c = as.m23317f();
        this.f18248d = am.m23244m();
        this.f18249e = as.m23319h();
        this.f18246b = z2;
    }

    void changed(ah ahVar) {
        m23036b(ahVar.m23077b());
    }

    /* renamed from: a */
    void m23038a(String str) {
        int equals = str.equals(this.f18248d) ^ 1;
        this.f18248d = str;
        if (equals != 0) {
            this.f18245a.m23074c(this);
        }
    }

    /* renamed from: a */
    public String m23037a() {
        return this.f18248d;
    }

    /* renamed from: b */
    void m23041b(String str) {
        if (str != null) {
            int equals = str.equals(this.f18249e) ^ 1;
            this.f18249e = str;
            if (equals != 0) {
                this.f18245a.m23074c(this);
            }
        }
    }

    /* renamed from: b */
    public String m23040b() {
        return this.f18249e;
    }

    /* renamed from: a */
    void m23039a(boolean z) {
        Object obj = this.f18247c != z ? 1 : null;
        this.f18247c = z;
        if (obj != null) {
            this.f18245a.m23074c(this);
        }
    }

    /* renamed from: c */
    public boolean m23042c() {
        return this.f18247c;
    }

    /* renamed from: b */
    private void m23036b(boolean z) {
        boolean d = m23043d();
        this.f18246b = z;
        if (d != m23043d()) {
            this.f18245a.m23074c(this);
        }
    }

    /* renamed from: d */
    public boolean m23043d() {
        return this.f18248d != null && this.f18249e != null && this.f18247c && this.f18246b;
    }

    /* renamed from: e */
    void m23044e() {
        aq.m23280a(aq.f18435a, "ONESIGNAL_SUBSCRIPTION_LAST", this.f18247c);
        aq.m23279a(aq.f18435a, "ONESIGNAL_PLAYER_ID_LAST", this.f18248d);
        aq.m23279a(aq.f18435a, "ONESIGNAL_PUSH_TOKEN_LAST", this.f18249e);
        aq.m23280a(aq.f18435a, "ONESIGNAL_PERMISSION_ACCEPTED_LAST", this.f18246b);
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
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OSSubscriptionState.clone():java.lang.Object");
    }

    /* renamed from: f */
    public JSONObject m23045f() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f18248d != null) {
                jSONObject.put("userId", this.f18248d);
            } else {
                jSONObject.put("userId", JSONObject.NULL);
            }
            if (this.f18249e != null) {
                jSONObject.put("pushToken", this.f18249e);
            } else {
                jSONObject.put("pushToken", JSONObject.NULL);
            }
            jSONObject.put("userSubscriptionSetting", this.f18247c);
            jSONObject.put("subscribed", m23043d());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return m23045f().toString();
    }
}
