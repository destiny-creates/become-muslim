package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.Map;

@cm
public final class qd implements ae<pn> {
    /* renamed from: a */
    private static java.lang.Integer m31002a(java.util.Map<java.lang.String, java.lang.String> r3, java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r3.containsKey(r4);
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = r3.get(r4);	 Catch:{ NumberFormatException -> 0x0017 }
        r0 = (java.lang.String) r0;	 Catch:{ NumberFormatException -> 0x0017 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0017 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ NumberFormatException -> 0x0017 }
        return r0;
    L_0x0017:
        r3 = r3.get(r4);
        r3 = (java.lang.String) r3;
        r0 = java.lang.String.valueOf(r4);
        r0 = r0.length();
        r0 = r0 + 39;
        r2 = java.lang.String.valueOf(r3);
        r2 = r2.length();
        r0 = r0 + r2;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r0);
        r0 = "Precache invalid numeric parameter '";
        r2.append(r0);
        r2.append(r4);
        r4 = "': ";
        r2.append(r4);
        r2.append(r3);
        r3 = r2.toString();
        com.google.android.gms.internal.ads.mt.m19924e(r3);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.qd.a(java.util.Map, java.lang.String):java.lang.Integer");
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        pn pnVar = (pn) obj;
        ax.z();
        if (map.containsKey("abort")) {
            if (!py.m20029a(pnVar)) {
                mt.m19924e("Precache abort but no precache task running.");
            }
            return;
        }
        String str;
        String str2 = (String) map.get("src");
        Integer a;
        if (str2 == null) {
            if (py.m20030b(pnVar) == null) {
                str = "Precache must specify a source.";
            }
            a = m31002a(map, "minBufferMs");
            if (a != null) {
                a.intValue();
            }
            a = m31002a(map, "maxBufferMs");
            if (a != null) {
                a.intValue();
            }
            a = m31002a(map, "bufferForPlaybackMs");
            if (a != null) {
                a.intValue();
            }
            a = m31002a(map, "bufferForPlaybackAfterRebufferMs");
            if (a != null) {
                a.intValue();
            }
            return;
        } else if (py.m20030b(pnVar) != null) {
            str = "Precache task is already running.";
        } else if (pnVar.mo6129e() == null) {
            str = "Precache requires a dependency provider.";
        } else {
            pm pmVar = new pm((String) map.get("flags"));
            Integer a2 = m31002a(map, "player");
            if (a2 == null) {
                a2 = Integer.valueOf(0);
            }
            new pw(pnVar, pnVar.mo6129e().f6843a.mo4337a(pnVar, a2.intValue(), null, pmVar), str2).mo3819c();
            a = m31002a(map, "minBufferMs");
            if (a != null) {
                a.intValue();
            }
            a = m31002a(map, "maxBufferMs");
            if (a != null) {
                a.intValue();
            }
            a = m31002a(map, "bufferForPlaybackMs");
            if (a != null) {
                a.intValue();
            }
            a = m31002a(map, "bufferForPlaybackAfterRebufferMs");
            if (a != null) {
                a.intValue();
            }
            return;
        }
        mt.m19924e(str);
    }
}
