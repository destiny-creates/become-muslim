package com.onesignal;

import com.onesignal.C5526p.C5525f;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserState */
abstract class be {
    /* renamed from: c */
    private static final String[] f18494c = new String[]{"lat", "long", "loc_acc", "loc_type", "loc_bg", "loc_time_stamp", "ad_id"};
    /* renamed from: d */
    private static final Set<String> f18495d = new HashSet(Arrays.asList(f18494c));
    /* renamed from: e */
    private static final Object f18496e = new C54921();
    /* renamed from: a */
    JSONObject f18497a;
    /* renamed from: b */
    JSONObject f18498b;
    /* renamed from: f */
    private String f18499f;

    /* compiled from: UserState */
    /* renamed from: com.onesignal.be$1 */
    static class C54921 {
        C54921() {
        }
    }

    /* renamed from: a */
    abstract be mo4943a(String str);

    /* renamed from: a */
    protected abstract void mo4944a();

    /* renamed from: b */
    abstract boolean mo4945b();

    be(String str, boolean z) {
        this.f18499f = str;
        if (z) {
            m23378e();
            return;
        }
        this.f18497a = new JSONObject();
        this.f18498b = new JSONObject();
    }

    /* renamed from: b */
    be m23384b(String str) {
        str = mo4943a(str);
        try {
            str.f18497a = new JSONObject(this.f18497a.toString());
            str.f18498b = new JSONObject(this.f18498b.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return str;
    }

    /* renamed from: a */
    private java.util.Set<java.lang.String> m23375a(com.onesignal.be r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.f18497a;	 Catch:{ Throwable -> 0x0035 }
        r1 = "loc_time_stamp";	 Catch:{ Throwable -> 0x0035 }
        r0 = r0.optLong(r1);	 Catch:{ Throwable -> 0x0035 }
        r2 = r5.f18497a;	 Catch:{ Throwable -> 0x0035 }
        r3 = "loc_time_stamp";	 Catch:{ Throwable -> 0x0035 }
        r2 = r2.getLong(r3);	 Catch:{ Throwable -> 0x0035 }
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ Throwable -> 0x0035 }
        if (r0 == 0) goto L_0x0035;	 Catch:{ Throwable -> 0x0035 }
    L_0x0014:
        r0 = r5.f18498b;	 Catch:{ Throwable -> 0x0035 }
        r1 = "loc_bg";	 Catch:{ Throwable -> 0x0035 }
        r2 = r5.f18497a;	 Catch:{ Throwable -> 0x0035 }
        r3 = "loc_bg";	 Catch:{ Throwable -> 0x0035 }
        r2 = r2.opt(r3);	 Catch:{ Throwable -> 0x0035 }
        r0.put(r1, r2);	 Catch:{ Throwable -> 0x0035 }
        r0 = r5.f18498b;	 Catch:{ Throwable -> 0x0035 }
        r1 = "loc_time_stamp";	 Catch:{ Throwable -> 0x0035 }
        r5 = r5.f18497a;	 Catch:{ Throwable -> 0x0035 }
        r2 = "loc_time_stamp";	 Catch:{ Throwable -> 0x0035 }
        r5 = r5.opt(r2);	 Catch:{ Throwable -> 0x0035 }
        r0.put(r1, r5);	 Catch:{ Throwable -> 0x0035 }
        r5 = f18495d;	 Catch:{ Throwable -> 0x0035 }
        return r5;
    L_0x0035:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.be.a(com.onesignal.be):java.util.Set<java.lang.String>");
    }

    /* renamed from: a */
    void m23382a(C5525f c5525f) {
        try {
            this.f18498b.put("lat", c5525f.f18549a);
            this.f18498b.put("long", c5525f.f18550b);
            this.f18498b.put("loc_acc", c5525f.f18551c);
            this.f18498b.put("loc_type", c5525f.f18552d);
            this.f18497a.put("loc_bg", c5525f.f18553e);
            this.f18497a.put("loc_time_stamp", c5525f.f18554f);
        } catch (C5525f c5525f2) {
            c5525f2.printStackTrace();
        }
    }

    /* renamed from: c */
    void m23387c() {
        try {
            this.f18498b.put("lat", null);
            this.f18498b.put("long", null);
            this.f18498b.put("loc_acc", null);
            this.f18498b.put("loc_type", null);
            this.f18498b.put("loc_bg", null);
            this.f18498b.put("loc_time_stamp", null);
            this.f18497a.put("loc_bg", null);
            this.f18497a.put("loc_time_stamp", null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    JSONObject m23380a(be beVar, boolean z) {
        mo4944a();
        beVar.mo4944a();
        beVar = m23376a(this.f18498b, beVar.f18498b, null, m23375a(beVar));
        if (!z && beVar.toString().equals("{}")) {
            return null;
        }
        try {
            if (!beVar.has("app_id")) {
                beVar.put("app_id", this.f18498b.optString("app_id"));
            }
            if (this.f18498b.has("email_auth_hash")) {
                beVar.put("email_auth_hash", this.f18498b.optString("email_auth_hash"));
            }
        } catch (boolean z2) {
            z2.printStackTrace();
        }
        return beVar;
    }

    /* renamed from: e */
    private void m23378e() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = com.onesignal.aq.f18435a;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "ONESIGNAL_USERSTATE_DEPENDVALYES_";
        r1.append(r2);
        r2 = r5.f18499f;
        r1.append(r2);
        r1 = r1.toString();
        r2 = 0;
        r0 = com.onesignal.aq.m23283b(r0, r1, r2);
        if (r0 != 0) goto L_0x0054;
    L_0x001c:
        r0 = new org.json.JSONObject;
        r0.<init>();
        r5.f18497a = r0;
        r0 = r5.f18499f;	 Catch:{ JSONException -> 0x0060 }
        r1 = "CURRENT_STATE";	 Catch:{ JSONException -> 0x0060 }
        r0 = r0.equals(r1);	 Catch:{ JSONException -> 0x0060 }
        r1 = 1;	 Catch:{ JSONException -> 0x0060 }
        if (r0 == 0) goto L_0x0037;	 Catch:{ JSONException -> 0x0060 }
    L_0x002e:
        r0 = com.onesignal.aq.f18435a;	 Catch:{ JSONException -> 0x0060 }
        r3 = "ONESIGNAL_SUBSCRIPTION";	 Catch:{ JSONException -> 0x0060 }
        r0 = com.onesignal.aq.m23273a(r0, r3, r1);	 Catch:{ JSONException -> 0x0060 }
        goto L_0x003f;	 Catch:{ JSONException -> 0x0060 }
    L_0x0037:
        r0 = com.onesignal.aq.f18435a;	 Catch:{ JSONException -> 0x0060 }
        r3 = "ONESIGNAL_SYNCED_SUBSCRIPTION";	 Catch:{ JSONException -> 0x0060 }
        r0 = com.onesignal.aq.m23273a(r0, r3, r1);	 Catch:{ JSONException -> 0x0060 }
    L_0x003f:
        r3 = -2;	 Catch:{ JSONException -> 0x0060 }
        if (r0 != r3) goto L_0x0045;	 Catch:{ JSONException -> 0x0060 }
    L_0x0042:
        r0 = 0;	 Catch:{ JSONException -> 0x0060 }
        r0 = 1;	 Catch:{ JSONException -> 0x0060 }
        r1 = 0;	 Catch:{ JSONException -> 0x0060 }
    L_0x0045:
        r3 = r5.f18497a;	 Catch:{ JSONException -> 0x0060 }
        r4 = "subscribableStatus";	 Catch:{ JSONException -> 0x0060 }
        r3.put(r4, r0);	 Catch:{ JSONException -> 0x0060 }
        r0 = r5.f18497a;	 Catch:{ JSONException -> 0x0060 }
        r3 = "userSubscribePref";	 Catch:{ JSONException -> 0x0060 }
        r0.put(r3, r1);	 Catch:{ JSONException -> 0x0060 }
        goto L_0x0060;
    L_0x0054:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x005c }
        r1.<init>(r0);	 Catch:{ JSONException -> 0x005c }
        r5.f18497a = r1;	 Catch:{ JSONException -> 0x005c }
        goto L_0x0060;
    L_0x005c:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0060:
        r0 = com.onesignal.aq.f18435a;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "ONESIGNAL_USERSTATE_SYNCVALYES_";
        r1.append(r3);
        r3 = r5.f18499f;
        r1.append(r3);
        r1 = r1.toString();
        r0 = com.onesignal.aq.m23283b(r0, r1, r2);
        if (r0 != 0) goto L_0x0094;
    L_0x007b:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0092 }
        r0.<init>();	 Catch:{ JSONException -> 0x0092 }
        r5.f18498b = r0;	 Catch:{ JSONException -> 0x0092 }
        r0 = com.onesignal.aq.f18435a;	 Catch:{ JSONException -> 0x0092 }
        r1 = "GT_REGISTRATION_ID";	 Catch:{ JSONException -> 0x0092 }
        r0 = com.onesignal.aq.m23283b(r0, r1, r2);	 Catch:{ JSONException -> 0x0092 }
        r1 = r5.f18498b;	 Catch:{ JSONException -> 0x0092 }
        r2 = "identifier";	 Catch:{ JSONException -> 0x0092 }
        r1.put(r2, r0);	 Catch:{ JSONException -> 0x0092 }
        goto L_0x009f;	 Catch:{ JSONException -> 0x0092 }
    L_0x0092:
        r0 = move-exception;	 Catch:{ JSONException -> 0x0092 }
        goto L_0x009c;	 Catch:{ JSONException -> 0x0092 }
    L_0x0094:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0092 }
        r1.<init>(r0);	 Catch:{ JSONException -> 0x0092 }
        r5.f18498b = r1;	 Catch:{ JSONException -> 0x0092 }
        goto L_0x009f;
    L_0x009c:
        r0.printStackTrace();
    L_0x009f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.be.e():void");
    }

    /* renamed from: d */
    void m23388d() {
        synchronized (f18496e) {
            m23377c("pkgs");
            String str = aq.f18435a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ONESIGNAL_USERSTATE_SYNCVALYES_");
            stringBuilder.append(this.f18499f);
            aq.m23279a(str, stringBuilder.toString(), this.f18498b.toString());
            str = aq.f18435a;
            stringBuilder = new StringBuilder();
            stringBuilder.append("ONESIGNAL_USERSTATE_DEPENDVALYES_");
            stringBuilder.append(this.f18499f);
            aq.m23279a(str, stringBuilder.toString(), this.f18497a.toString());
        }
    }

    /* renamed from: c */
    private void m23377c(java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r6.f18498b;	 Catch:{ Throwable -> 0x00db }
        r0 = r0.has(r7);	 Catch:{ Throwable -> 0x00db }
        if (r0 == 0) goto L_0x000f;	 Catch:{ Throwable -> 0x00db }
    L_0x0008:
        r0 = r6.f18498b;	 Catch:{ Throwable -> 0x00db }
        r0 = r0.getJSONArray(r7);	 Catch:{ Throwable -> 0x00db }
        goto L_0x0014;	 Catch:{ Throwable -> 0x00db }
    L_0x000f:
        r0 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x00db }
        r0.<init>();	 Catch:{ Throwable -> 0x00db }
    L_0x0014:
        r1 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x00db }
        r1.<init>();	 Catch:{ Throwable -> 0x00db }
        r2 = r6.f18498b;	 Catch:{ Throwable -> 0x00db }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00db }
        r3.<init>();	 Catch:{ Throwable -> 0x00db }
        r3.append(r7);	 Catch:{ Throwable -> 0x00db }
        r4 = "_d";	 Catch:{ Throwable -> 0x00db }
        r3.append(r4);	 Catch:{ Throwable -> 0x00db }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00db }
        r2 = r2.has(r3);	 Catch:{ Throwable -> 0x00db }
        r3 = 0;	 Catch:{ Throwable -> 0x00db }
        if (r2 == 0) goto L_0x006a;	 Catch:{ Throwable -> 0x00db }
    L_0x0033:
        r2 = r6.f18498b;	 Catch:{ Throwable -> 0x00db }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00db }
        r4.<init>();	 Catch:{ Throwable -> 0x00db }
        r4.append(r7);	 Catch:{ Throwable -> 0x00db }
        r5 = "_d";	 Catch:{ Throwable -> 0x00db }
        r4.append(r5);	 Catch:{ Throwable -> 0x00db }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x00db }
        r2 = r2.getJSONArray(r4);	 Catch:{ Throwable -> 0x00db }
        r2 = com.onesignal.C5518o.m23502a(r2);	 Catch:{ Throwable -> 0x00db }
        r4 = 0;	 Catch:{ Throwable -> 0x00db }
    L_0x004f:
        r5 = r0.length();	 Catch:{ Throwable -> 0x00db }
        if (r4 >= r5) goto L_0x0069;	 Catch:{ Throwable -> 0x00db }
    L_0x0055:
        r5 = r0.getString(r4);	 Catch:{ Throwable -> 0x00db }
        r5 = r2.contains(r5);	 Catch:{ Throwable -> 0x00db }
        if (r5 != 0) goto L_0x0066;	 Catch:{ Throwable -> 0x00db }
    L_0x005f:
        r5 = r0.get(r4);	 Catch:{ Throwable -> 0x00db }
        r1.put(r5);	 Catch:{ Throwable -> 0x00db }
    L_0x0066:
        r4 = r4 + 1;	 Catch:{ Throwable -> 0x00db }
        goto L_0x004f;	 Catch:{ Throwable -> 0x00db }
    L_0x0069:
        r0 = r1;	 Catch:{ Throwable -> 0x00db }
    L_0x006a:
        r1 = r6.f18498b;	 Catch:{ Throwable -> 0x00db }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00db }
        r2.<init>();	 Catch:{ Throwable -> 0x00db }
        r2.append(r7);	 Catch:{ Throwable -> 0x00db }
        r4 = "_a";	 Catch:{ Throwable -> 0x00db }
        r2.append(r4);	 Catch:{ Throwable -> 0x00db }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00db }
        r1 = r1.has(r2);	 Catch:{ Throwable -> 0x00db }
        if (r1 == 0) goto L_0x00aa;	 Catch:{ Throwable -> 0x00db }
    L_0x0083:
        r1 = r6.f18498b;	 Catch:{ Throwable -> 0x00db }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00db }
        r2.<init>();	 Catch:{ Throwable -> 0x00db }
        r2.append(r7);	 Catch:{ Throwable -> 0x00db }
        r4 = "_a";	 Catch:{ Throwable -> 0x00db }
        r2.append(r4);	 Catch:{ Throwable -> 0x00db }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00db }
        r1 = r1.getJSONArray(r2);	 Catch:{ Throwable -> 0x00db }
    L_0x009a:
        r2 = r1.length();	 Catch:{ Throwable -> 0x00db }
        if (r3 >= r2) goto L_0x00aa;	 Catch:{ Throwable -> 0x00db }
    L_0x00a0:
        r2 = r1.get(r3);	 Catch:{ Throwable -> 0x00db }
        r0.put(r2);	 Catch:{ Throwable -> 0x00db }
        r3 = r3 + 1;	 Catch:{ Throwable -> 0x00db }
        goto L_0x009a;	 Catch:{ Throwable -> 0x00db }
    L_0x00aa:
        r1 = r6.f18498b;	 Catch:{ Throwable -> 0x00db }
        r1.put(r7, r0);	 Catch:{ Throwable -> 0x00db }
        r0 = r6.f18498b;	 Catch:{ Throwable -> 0x00db }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00db }
        r1.<init>();	 Catch:{ Throwable -> 0x00db }
        r1.append(r7);	 Catch:{ Throwable -> 0x00db }
        r2 = "_a";	 Catch:{ Throwable -> 0x00db }
        r1.append(r2);	 Catch:{ Throwable -> 0x00db }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x00db }
        r0.remove(r1);	 Catch:{ Throwable -> 0x00db }
        r0 = r6.f18498b;	 Catch:{ Throwable -> 0x00db }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00db }
        r1.<init>();	 Catch:{ Throwable -> 0x00db }
        r1.append(r7);	 Catch:{ Throwable -> 0x00db }
        r7 = "_d";	 Catch:{ Throwable -> 0x00db }
        r1.append(r7);	 Catch:{ Throwable -> 0x00db }
        r7 = r1.toString();	 Catch:{ Throwable -> 0x00db }
        r0.remove(r7);	 Catch:{ Throwable -> 0x00db }
    L_0x00db:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.be.c(java.lang.String):void");
    }

    /* renamed from: a */
    void m23383a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            m23376a(this.f18497a, jSONObject, this.f18497a, null);
        }
        if (jSONObject2 != null) {
            m23376a(this.f18498b, jSONObject2, this.f18498b, null);
            m23385b(jSONObject2, null);
        }
        if (jSONObject != null || jSONObject2 != null) {
            m23388d();
        }
    }

    /* renamed from: b */
    void m23385b(org.json.JSONObject r7, org.json.JSONObject r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = f18496e;
        monitor-enter(r0);
        r1 = "tags";	 Catch:{ all -> 0x0081 }
        r1 = r7.has(r1);	 Catch:{ all -> 0x0081 }
        if (r1 == 0) goto L_0x007f;	 Catch:{ all -> 0x0081 }
    L_0x000b:
        r1 = r6.f18498b;	 Catch:{ all -> 0x0081 }
        r2 = "tags";	 Catch:{ all -> 0x0081 }
        r1 = r1.has(r2);	 Catch:{ all -> 0x0081 }
        if (r1 == 0) goto L_0x0029;
    L_0x0015:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0023 }
        r2 = r6.f18498b;	 Catch:{ JSONException -> 0x0023 }
        r3 = "tags";	 Catch:{ JSONException -> 0x0023 }
        r2 = r2.optString(r3);	 Catch:{ JSONException -> 0x0023 }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x0023 }
        goto L_0x002e;
    L_0x0023:
        r1 = new org.json.JSONObject;	 Catch:{ all -> 0x0081 }
        r1.<init>();	 Catch:{ all -> 0x0081 }
        goto L_0x002e;	 Catch:{ all -> 0x0081 }
    L_0x0029:
        r1 = new org.json.JSONObject;	 Catch:{ all -> 0x0081 }
        r1.<init>();	 Catch:{ all -> 0x0081 }
    L_0x002e:
        r2 = "tags";	 Catch:{ all -> 0x0081 }
        r7 = r7.optJSONObject(r2);	 Catch:{ all -> 0x0081 }
        r2 = r7.keys();	 Catch:{ all -> 0x0081 }
    L_0x0038:
        r3 = r2.hasNext();	 Catch:{ Throwable -> 0x007f }
        if (r3 == 0) goto L_0x0064;	 Catch:{ Throwable -> 0x007f }
    L_0x003e:
        r3 = r2.next();	 Catch:{ Throwable -> 0x007f }
        r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x007f }
        r4 = "";	 Catch:{ Throwable -> 0x007f }
        r5 = r7.optString(r3);	 Catch:{ Throwable -> 0x007f }
        r4 = r4.equals(r5);	 Catch:{ Throwable -> 0x007f }
        if (r4 == 0) goto L_0x0054;	 Catch:{ Throwable -> 0x007f }
    L_0x0050:
        r1.remove(r3);	 Catch:{ Throwable -> 0x007f }
        goto L_0x0038;	 Catch:{ Throwable -> 0x007f }
    L_0x0054:
        if (r8 == 0) goto L_0x005c;	 Catch:{ Throwable -> 0x007f }
    L_0x0056:
        r4 = r8.has(r3);	 Catch:{ Throwable -> 0x007f }
        if (r4 != 0) goto L_0x0038;	 Catch:{ Throwable -> 0x007f }
    L_0x005c:
        r4 = r7.optString(r3);	 Catch:{ Throwable -> 0x007f }
        r1.put(r3, r4);	 Catch:{ Throwable -> 0x007f }
        goto L_0x0038;	 Catch:{ Throwable -> 0x007f }
    L_0x0064:
        r7 = r1.toString();	 Catch:{ Throwable -> 0x007f }
        r8 = "{}";	 Catch:{ Throwable -> 0x007f }
        r7 = r7.equals(r8);	 Catch:{ Throwable -> 0x007f }
        if (r7 == 0) goto L_0x0078;	 Catch:{ Throwable -> 0x007f }
    L_0x0070:
        r7 = r6.f18498b;	 Catch:{ Throwable -> 0x007f }
        r8 = "tags";	 Catch:{ Throwable -> 0x007f }
        r7.remove(r8);	 Catch:{ Throwable -> 0x007f }
        goto L_0x007f;	 Catch:{ Throwable -> 0x007f }
    L_0x0078:
        r7 = r6.f18498b;	 Catch:{ Throwable -> 0x007f }
        r8 = "tags";	 Catch:{ Throwable -> 0x007f }
        r7.put(r8, r1);	 Catch:{ Throwable -> 0x007f }
    L_0x007f:
        monitor-exit(r0);	 Catch:{ all -> 0x0081 }
        return;	 Catch:{ all -> 0x0081 }
    L_0x0081:
        r7 = move-exception;	 Catch:{ all -> 0x0081 }
        monitor-exit(r0);	 Catch:{ all -> 0x0081 }
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.be.b(org.json.JSONObject, org.json.JSONObject):void");
    }

    /* renamed from: a */
    private static JSONObject m23376a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Set<String> set) {
        synchronized (f18496e) {
            jSONObject = C5518o.m23504a(jSONObject, jSONObject2, jSONObject3, (Set) set);
        }
        return jSONObject;
    }
}
