package com.google.firebase.components;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
/* renamed from: com.google.firebase.components.k */
final class C6905k implements C5346l<Context> {
    private C6905k() {
    }

    /* renamed from: a */
    public final /* synthetic */ List mo4879a(Object obj) {
        obj = C6905k.m32364a((Context) obj);
        if (obj == null) {
            Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
            return Collections.emptyList();
        }
        List arrayList = new ArrayList();
        for (String str : obj.keySet()) {
            if ("com.google.firebase.components.ComponentRegistrar".equals(obj.get(str)) && str.startsWith("com.google.firebase.components:")) {
                arrayList.add(str.substring(31));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static android.os.Bundle m32364a(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r4.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0029 }
        if (r1 != 0) goto L_0x000f;	 Catch:{ NameNotFoundException -> 0x0029 }
    L_0x0007:
        r4 = "ComponentDiscovery";	 Catch:{ NameNotFoundException -> 0x0029 }
        r1 = "Context has no PackageManager.";	 Catch:{ NameNotFoundException -> 0x0029 }
        android.util.Log.w(r4, r1);	 Catch:{ NameNotFoundException -> 0x0029 }
        return r0;	 Catch:{ NameNotFoundException -> 0x0029 }
    L_0x000f:
        r2 = new android.content.ComponentName;	 Catch:{ NameNotFoundException -> 0x0029 }
        r3 = com.google.firebase.components.ComponentDiscoveryService.class;	 Catch:{ NameNotFoundException -> 0x0029 }
        r2.<init>(r4, r3);	 Catch:{ NameNotFoundException -> 0x0029 }
        r4 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x0029 }
        r4 = r1.getServiceInfo(r2, r4);	 Catch:{ NameNotFoundException -> 0x0029 }
        if (r4 != 0) goto L_0x0026;	 Catch:{ NameNotFoundException -> 0x0029 }
    L_0x001e:
        r4 = "ComponentDiscovery";	 Catch:{ NameNotFoundException -> 0x0029 }
        r1 = "ComponentDiscoveryService has no service info.";	 Catch:{ NameNotFoundException -> 0x0029 }
        android.util.Log.w(r4, r1);	 Catch:{ NameNotFoundException -> 0x0029 }
        return r0;	 Catch:{ NameNotFoundException -> 0x0029 }
    L_0x0026:
        r4 = r4.metaData;	 Catch:{ NameNotFoundException -> 0x0029 }
        return r4;
    L_0x0029:
        r4 = "ComponentDiscovery";
        r1 = "Application info not found.";
        android.util.Log.w(r4, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.k.a(android.content.Context):android.os.Bundle");
    }
}
