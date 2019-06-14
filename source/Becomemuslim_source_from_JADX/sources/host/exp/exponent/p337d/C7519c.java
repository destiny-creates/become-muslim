package host.exp.exponent.p337d;

import org.json.JSONObject;

/* compiled from: ManifestException */
/* renamed from: host.exp.exponent.d.c */
public class C7519c extends C6300b {
    /* renamed from: a */
    private String f26080a;
    /* renamed from: b */
    private JSONObject f26081b;

    public C7519c(Exception exception, String str) {
        super(exception);
        this.f26080a = str;
        this.f26081b = null;
    }

    public C7519c(Exception exception, String str, JSONObject jSONObject) {
        super(exception);
        this.f26081b = jSONObject;
        this.f26080a = str;
    }

    public java.lang.String toString() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = "";
        r1 = host.exp.p333a.C6263a.f20400b;
        if (r1 == 0) goto L_0x0008;
    L_0x0006:
        r0 = " Are you sure XDE or exp is running?";
    L_0x0008:
        r1 = r7.f26080a;
        if (r1 != 0) goto L_0x001e;
    L_0x000c:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Could not load experience.";
        r1.append(r2);
        r1.append(r0);
        r0 = r1.toString();
        return r0;
    L_0x001e:
        r1 = r7.f26080a;
        r2 = host.exp.exponent.C6301d.f20496b;
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x003a;
    L_0x0028:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Could not load app.";
        r1.append(r2);
        r1.append(r0);
        r0 = r1.toString();
        return r0;
    L_0x003a:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Could not load ";
        r1.append(r2);
        r2 = r7.f26080a;
        r1.append(r2);
        r2 = ".";
        r1.append(r2);
        r1.append(r0);
        r0 = r1.toString();
        r1 = r7.f26081b;
        if (r1 == 0) goto L_0x0158;
    L_0x0059:
        r1 = r7.f26081b;	 Catch:{ JSONException -> 0x0157 }
        r2 = "errorCode";	 Catch:{ JSONException -> 0x0157 }
        r1 = r1.getString(r2);	 Catch:{ JSONException -> 0x0157 }
        r2 = r7.f26081b;	 Catch:{ JSONException -> 0x0157 }
        r3 = "message";	 Catch:{ JSONException -> 0x0157 }
        r2 = r2.getString(r3);	 Catch:{ JSONException -> 0x0157 }
        r3 = -1;	 Catch:{ JSONException -> 0x0157 }
        r4 = r1.hashCode();	 Catch:{ JSONException -> 0x0157 }
        r5 = 1;	 Catch:{ JSONException -> 0x0157 }
        r6 = 0;	 Catch:{ JSONException -> 0x0157 }
        switch(r4) {
            case -1024515519: goto L_0x00d1;
            case -668892608: goto L_0x00c7;
            case -552299434: goto L_0x00bd;
            case 163137541: goto L_0x00b3;
            case 216913097: goto L_0x00a9;
            case 528161524: goto L_0x009f;
            case 663718801: goto L_0x0095;
            case 1703471890: goto L_0x008b;
            case 1928692419: goto L_0x0080;
            case 2014384609: goto L_0x0075;
            default: goto L_0x0073;
        };	 Catch:{ JSONException -> 0x0157 }
    L_0x0073:
        goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x0075:
        r4 = "SNACK_RUNTIME_NOT_RELEASED";	 Catch:{ JSONException -> 0x0157 }
        r1 = r1.equals(r4);	 Catch:{ JSONException -> 0x0157 }
        if (r1 == 0) goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x007d:
        r3 = 8;	 Catch:{ JSONException -> 0x0157 }
        goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x0080:
        r4 = "SNACK_NOT_FOUND_FOR_SDK_VERSION";	 Catch:{ JSONException -> 0x0157 }
        r1 = r1.equals(r4);	 Catch:{ JSONException -> 0x0157 }
        if (r1 == 0) goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x0088:
        r3 = 9;	 Catch:{ JSONException -> 0x0157 }
        goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x008b:
        r4 = "EXPERIENCE_RELEASE_NOT_FOUND_ERROR";	 Catch:{ JSONException -> 0x0157 }
        r1 = r1.equals(r4);	 Catch:{ JSONException -> 0x0157 }
        if (r1 == 0) goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x0093:
        r3 = 2;	 Catch:{ JSONException -> 0x0157 }
        goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x0095:
        r4 = "USER_SNACK_NOT_FOUND";	 Catch:{ JSONException -> 0x0157 }
        r1 = r1.equals(r4);	 Catch:{ JSONException -> 0x0157 }
        if (r1 == 0) goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x009d:
        r3 = 6;	 Catch:{ JSONException -> 0x0157 }
        goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x009f:
        r4 = "EXPERIENCE_SDK_VERSION_TOO_NEW";	 Catch:{ JSONException -> 0x0157 }
        r1 = r1.equals(r4);	 Catch:{ JSONException -> 0x0157 }
        if (r1 == 0) goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x00a7:
        r3 = 4;	 Catch:{ JSONException -> 0x0157 }
        goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x00a9:
        r4 = "EXPERIENCE_SDK_VERSION_OUTDATED";	 Catch:{ JSONException -> 0x0157 }
        r1 = r1.equals(r4);	 Catch:{ JSONException -> 0x0157 }
        if (r1 == 0) goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x00b1:
        r3 = 3;	 Catch:{ JSONException -> 0x0157 }
        goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x00b3:
        r4 = "SNACK_NOT_FOUND";	 Catch:{ JSONException -> 0x0157 }
        r1 = r1.equals(r4);	 Catch:{ JSONException -> 0x0157 }
        if (r1 == 0) goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x00bb:
        r3 = 7;	 Catch:{ JSONException -> 0x0157 }
        goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x00bd:
        r4 = "EXPERIENCE_NOT_PUBLISHED_ERROR";	 Catch:{ JSONException -> 0x0157 }
        r1 = r1.equals(r4);	 Catch:{ JSONException -> 0x0157 }
        if (r1 == 0) goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x00c5:
        r3 = 1;	 Catch:{ JSONException -> 0x0157 }
        goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x00c7:
        r4 = "EXPERIENCE_NOT_VIEWABLE";	 Catch:{ JSONException -> 0x0157 }
        r1 = r1.equals(r4);	 Catch:{ JSONException -> 0x0157 }
        if (r1 == 0) goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x00cf:
        r3 = 5;	 Catch:{ JSONException -> 0x0157 }
        goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x00d1:
        r4 = "EXPERIENCE_NOT_FOUND";	 Catch:{ JSONException -> 0x0157 }
        r1 = r1.equals(r4);	 Catch:{ JSONException -> 0x0157 }
        if (r1 == 0) goto L_0x00da;	 Catch:{ JSONException -> 0x0157 }
    L_0x00d9:
        r3 = 0;	 Catch:{ JSONException -> 0x0157 }
    L_0x00da:
        switch(r3) {
            case 0: goto L_0x013e;
            case 1: goto L_0x013e;
            case 2: goto L_0x013e;
            case 3: goto L_0x00fe;
            case 4: goto L_0x00fa;
            case 5: goto L_0x00f8;
            case 6: goto L_0x00df;
            case 7: goto L_0x00df;
            case 8: goto L_0x00f8;
            case 9: goto L_0x00f8;
            default: goto L_0x00dd;
        };	 Catch:{ JSONException -> 0x0157 }
    L_0x00dd:
        goto L_0x0158;	 Catch:{ JSONException -> 0x0157 }
    L_0x00df:
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0157 }
        r1.<init>();	 Catch:{ JSONException -> 0x0157 }
        r2 = "No snack found at ";	 Catch:{ JSONException -> 0x0157 }
        r1.append(r2);	 Catch:{ JSONException -> 0x0157 }
        r2 = r7.f26080a;	 Catch:{ JSONException -> 0x0157 }
        r1.append(r2);	 Catch:{ JSONException -> 0x0157 }
        r2 = ".";	 Catch:{ JSONException -> 0x0157 }
        r1.append(r2);	 Catch:{ JSONException -> 0x0157 }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x0157 }
        goto L_0x00fc;	 Catch:{ JSONException -> 0x0157 }
    L_0x00f8:
        r0 = r2;	 Catch:{ JSONException -> 0x0157 }
        goto L_0x0158;	 Catch:{ JSONException -> 0x0157 }
    L_0x00fa:
        r1 = "This experience requires a newer version of the Expo client - please download the latest version from the Play Store.";	 Catch:{ JSONException -> 0x0157 }
    L_0x00fc:
        r0 = r1;	 Catch:{ JSONException -> 0x0157 }
        goto L_0x0158;	 Catch:{ JSONException -> 0x0157 }
    L_0x00fe:
        r1 = r7.f26081b;	 Catch:{ JSONException -> 0x0157 }
        r2 = "metadata";	 Catch:{ JSONException -> 0x0157 }
        r1 = r1.getJSONObject(r2);	 Catch:{ JSONException -> 0x0157 }
        r2 = "availableSDKVersions";	 Catch:{ JSONException -> 0x0157 }
        r1 = r1.getJSONArray(r2);	 Catch:{ JSONException -> 0x0157 }
        r1 = r1.getString(r6);	 Catch:{ JSONException -> 0x0157 }
        r2 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0157 }
        r2.<init>();	 Catch:{ JSONException -> 0x0157 }
        r3 = "This experience uses SDK v";	 Catch:{ JSONException -> 0x0157 }
        r2.append(r3);	 Catch:{ JSONException -> 0x0157 }
        r2.append(r1);	 Catch:{ JSONException -> 0x0157 }
        r1 = " , but this Expo client requires at least v";	 Catch:{ JSONException -> 0x0157 }
        r2.append(r1);	 Catch:{ JSONException -> 0x0157 }
        r1 = host.exp.exponent.C6301d.f20500f;	 Catch:{ JSONException -> 0x0157 }
        r3 = host.exp.exponent.C6301d.f20500f;	 Catch:{ JSONException -> 0x0157 }
        r3 = r3.size();	 Catch:{ JSONException -> 0x0157 }
        r3 = r3 - r5;	 Catch:{ JSONException -> 0x0157 }
        r1 = r1.get(r3);	 Catch:{ JSONException -> 0x0157 }
        r1 = (java.lang.String) r1;	 Catch:{ JSONException -> 0x0157 }
        r2.append(r1);	 Catch:{ JSONException -> 0x0157 }
        r1 = ".";	 Catch:{ JSONException -> 0x0157 }
        r2.append(r1);	 Catch:{ JSONException -> 0x0157 }
        r1 = r2.toString();	 Catch:{ JSONException -> 0x0157 }
        goto L_0x00fc;	 Catch:{ JSONException -> 0x0157 }
    L_0x013e:
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0157 }
        r1.<init>();	 Catch:{ JSONException -> 0x0157 }
        r2 = "No experience found at ";	 Catch:{ JSONException -> 0x0157 }
        r1.append(r2);	 Catch:{ JSONException -> 0x0157 }
        r2 = r7.f26080a;	 Catch:{ JSONException -> 0x0157 }
        r1.append(r2);	 Catch:{ JSONException -> 0x0157 }
        r2 = ".";	 Catch:{ JSONException -> 0x0157 }
        r1.append(r2);	 Catch:{ JSONException -> 0x0157 }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x0157 }
        goto L_0x00fc;
    L_0x0157:
        return r0;
    L_0x0158:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.d.c.toString():java.lang.String");
    }
}
