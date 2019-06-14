package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.ax;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@cm
public final class bcr {
    /* renamed from: a */
    private static String m19234a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    /* renamed from: a */
    public static List<String> m19235a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        List arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    public static void m19236a(Context context, String str, is isVar, String str2, boolean z, List<String> list) {
        if (list == null) {
            return;
        }
        if (!list.isEmpty()) {
            String str3 = z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
            for (String a : list) {
                String a2 = m19234a(m19234a(m19234a(m19234a(m19234a(m19234a(m19234a(a2, "@gw_adlocid@", str2), "@gw_adnetrefresh@", str3), "@gw_qdata@", isVar.f15591r.f15202i), "@gw_sdkver@", str), "@gw_sessid@", aph.m18685c()), "@gw_seqnum@", isVar.f15583j), "@gw_adnetstatus@", isVar.f15593t);
                if (isVar.f15588o != null) {
                    a2 = m19234a(m19234a(a2, "@gw_adnetid@", isVar.f15588o.f15174b), "@gw_allocid@", isVar.f15588o.f15176d);
                }
                a2 = im.m19559a(a2, context);
                ax.e();
                jw.m19698a(context, str, a2);
            }
        }
    }

    /* renamed from: a */
    public static void m19237a(Context context, String str, List<String> list, String str2, hq hqVar) {
        if (list == null) {
            return;
        }
        if (!list.isEmpty()) {
            if (!TextUtils.isEmpty(str2) && mm.m19905c()) {
                str2 = "fakeUserForAdDebugLog";
            }
            long a = ax.l().a();
            for (String a2 : list) {
                String a22 = m19234a(m19234a(a22, "@gw_rwd_userid@", Uri.encode(str2)), "@gw_tmstmp@", Long.toString(a));
                if (hqVar != null) {
                    a22 = m19234a(m19234a(a22, "@gw_rwd_itm@", Uri.encode(hqVar.f28691a)), "@gw_rwd_amt@", Integer.toString(hqVar.f28692b));
                }
                ax.e();
                jw.m19698a(context, str, a22);
            }
        }
    }

    /* renamed from: a */
    public static boolean m19238a(java.lang.String r3, int[] r4) {
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
        r0 = android.text.TextUtils.isEmpty(r3);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = r4.length;
        r2 = 2;
        if (r0 == r2) goto L_0x000d;
    L_0x000c:
        return r1;
    L_0x000d:
        r0 = "x";
        r3 = r3.split(r0);
        r0 = r3.length;
        if (r0 == r2) goto L_0x0017;
    L_0x0016:
        return r1;
    L_0x0017:
        r0 = r3[r1];	 Catch:{ NumberFormatException -> 0x0029 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0029 }
        r4[r1] = r0;	 Catch:{ NumberFormatException -> 0x0029 }
        r0 = 1;	 Catch:{ NumberFormatException -> 0x0029 }
        r3 = r3[r0];	 Catch:{ NumberFormatException -> 0x0029 }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x0029 }
        r4[r0] = r3;	 Catch:{ NumberFormatException -> 0x0029 }
        return r0;
    L_0x0029:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bcr.a(java.lang.String, int[]):boolean");
    }
}
