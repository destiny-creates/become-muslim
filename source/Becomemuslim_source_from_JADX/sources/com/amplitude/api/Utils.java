package com.amplitude.api;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class Utils {
    public static final String TAG = "com.amplitude.api.Utils";
    private static AmplitudeLog logger = AmplitudeLog.getLogger();

    static JSONObject cloneJSONObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray names;
        try {
            names = jSONObject.names();
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.m3415e(TAG, e.toString());
            names = null;
        }
        int length = names != null ? names.length() : 0;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = names.optString(i);
        }
        try {
            return new JSONObject(jSONObject, strArr);
        } catch (JSONObject jSONObject2) {
            logger.m3415e(TAG, jSONObject2.toString());
            return null;
        }
    }

    static boolean compareJSONObjects(org.json.JSONObject r7, org.json.JSONObject r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = 1;
        if (r7 != r8) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        if (r7 == 0) goto L_0x0009;
    L_0x0007:
        if (r8 == 0) goto L_0x000d;
    L_0x0009:
        if (r7 != 0) goto L_0x000e;
    L_0x000b:
        if (r8 == 0) goto L_0x000e;
    L_0x000d:
        return r1;
    L_0x000e:
        r2 = r7.length();	 Catch:{ JSONException -> 0x0062 }
        r3 = r8.length();	 Catch:{ JSONException -> 0x0062 }
        if (r2 == r3) goto L_0x0019;	 Catch:{ JSONException -> 0x0062 }
    L_0x0018:
        return r1;	 Catch:{ JSONException -> 0x0062 }
    L_0x0019:
        r2 = r7.keys();	 Catch:{ JSONException -> 0x0062 }
    L_0x001d:
        r3 = r2.hasNext();	 Catch:{ JSONException -> 0x0062 }
        if (r3 == 0) goto L_0x0061;	 Catch:{ JSONException -> 0x0062 }
    L_0x0023:
        r3 = r2.next();	 Catch:{ JSONException -> 0x0062 }
        r3 = (java.lang.String) r3;	 Catch:{ JSONException -> 0x0062 }
        r4 = r8.has(r3);	 Catch:{ JSONException -> 0x0062 }
        if (r4 != 0) goto L_0x0030;	 Catch:{ JSONException -> 0x0062 }
    L_0x002f:
        return r1;	 Catch:{ JSONException -> 0x0062 }
    L_0x0030:
        r4 = r7.get(r3);	 Catch:{ JSONException -> 0x0062 }
        r3 = r8.get(r3);	 Catch:{ JSONException -> 0x0062 }
        r5 = r4.getClass();	 Catch:{ JSONException -> 0x0062 }
        r6 = r3.getClass();	 Catch:{ JSONException -> 0x0062 }
        r5 = r5.equals(r6);	 Catch:{ JSONException -> 0x0062 }
        if (r5 != 0) goto L_0x0047;	 Catch:{ JSONException -> 0x0062 }
    L_0x0046:
        return r1;	 Catch:{ JSONException -> 0x0062 }
    L_0x0047:
        r5 = r4.getClass();	 Catch:{ JSONException -> 0x0062 }
        r6 = org.json.JSONObject.class;	 Catch:{ JSONException -> 0x0062 }
        if (r5 != r6) goto L_0x005a;	 Catch:{ JSONException -> 0x0062 }
    L_0x004f:
        r4 = (org.json.JSONObject) r4;	 Catch:{ JSONException -> 0x0062 }
        r3 = (org.json.JSONObject) r3;	 Catch:{ JSONException -> 0x0062 }
        r3 = compareJSONObjects(r4, r3);	 Catch:{ JSONException -> 0x0062 }
        if (r3 != 0) goto L_0x001d;	 Catch:{ JSONException -> 0x0062 }
    L_0x0059:
        return r1;	 Catch:{ JSONException -> 0x0062 }
    L_0x005a:
        r3 = r4.equals(r3);	 Catch:{ JSONException -> 0x0062 }
        if (r3 != 0) goto L_0x001d;
    L_0x0060:
        return r1;
    L_0x0061:
        return r0;
    L_0x0062:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.Utils.compareJSONObjects(org.json.JSONObject, org.json.JSONObject):boolean");
    }

    static String normalizeInstanceName(String str) {
        if (TextUtils.isEmpty(str)) {
            str = Constants.DEFAULT_INSTANCE;
        }
        return str.toLowerCase();
    }
}
