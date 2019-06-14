package com.onesignal;

/* compiled from: UserStatePush */
class bh extends be {
    bh(String str, boolean z) {
        super(str, z);
    }

    /* renamed from: a */
    be mo4943a(String str) {
        return new bh(str, false);
    }

    /* renamed from: a */
    protected void mo4944a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.b;	 Catch:{ JSONException -> 0x000b }
        r1 = "notification_types";	 Catch:{ JSONException -> 0x000b }
        r2 = r3.m32640e();	 Catch:{ JSONException -> 0x000b }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x000b }
    L_0x000b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.bh.a():void");
    }

    /* renamed from: e */
    private int m32640e() {
        int optInt = this.a.optInt("subscribableStatus", 1);
        if (optInt < -2) {
            return optInt;
        }
        if (this.a.optBoolean("androidPermission", true)) {
            return !this.a.optBoolean("userSubscribePref", true) ? -2 : 1;
        } else {
            return 0;
        }
    }

    /* renamed from: b */
    boolean mo4945b() {
        return m32640e() > 0;
    }
}
