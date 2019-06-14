package com.polidea.reactnativeble.p269e;

import java.util.UUID;

/* compiled from: UUIDConverter */
/* renamed from: com.polidea.reactnativeble.e.i */
public class C5649i {
    /* renamed from: a */
    private static String f18888a = "0000";
    /* renamed from: b */
    private static String f18889b = "-0000-1000-8000-00805F9B34FB";

    /* renamed from: a */
    public static java.util.UUID m23983a(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r3.length();
        r2 = 4;
        if (r1 != r2) goto L_0x0022;
    L_0x000b:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = f18888a;
        r1.append(r2);
        r1.append(r3);
        r3 = f18889b;
        r1.append(r3);
        r3 = r1.toString();
        goto L_0x003b;
    L_0x0022:
        r1 = r3.length();
        r2 = 8;
        if (r1 != r2) goto L_0x003b;
    L_0x002a:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r3);
        r3 = f18889b;
        r1.append(r3);
        r3 = r1.toString();
    L_0x003b:
        r3 = java.util.UUID.fromString(r3);	 Catch:{ Throwable -> 0x0040 }
        return r3;
    L_0x0040:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.polidea.reactnativeble.e.i.a(java.lang.String):java.util.UUID");
    }

    /* renamed from: a */
    public static java.util.UUID[] m23985a(java.lang.String... r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r5.length;
        r0 = new java.util.UUID[r0];
        r1 = 0;
    L_0x0004:
        r2 = r5.length;
        if (r1 >= r2) goto L_0x005c;
    L_0x0007:
        r2 = r5[r1];
        r3 = 0;
        if (r2 != 0) goto L_0x000d;
    L_0x000c:
        return r3;
    L_0x000d:
        r2 = r5[r1];
        r2 = r2.length();
        r4 = 4;
        if (r2 != r4) goto L_0x0031;
    L_0x0016:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = f18888a;
        r2.append(r4);
        r4 = r5[r1];
        r2.append(r4);
        r4 = f18889b;
        r2.append(r4);
        r2 = r2.toString();
        r5[r1] = r2;
        goto L_0x0050;
    L_0x0031:
        r2 = r5[r1];
        r2 = r2.length();
        r4 = 8;
        if (r2 != r4) goto L_0x0050;
    L_0x003b:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = r5[r1];
        r2.append(r4);
        r4 = f18889b;
        r2.append(r4);
        r2 = r2.toString();
        r5[r1] = r2;
    L_0x0050:
        r2 = r5[r1];	 Catch:{ Throwable -> 0x005b }
        r2 = java.util.UUID.fromString(r2);	 Catch:{ Throwable -> 0x005b }
        r0[r1] = r2;	 Catch:{ Throwable -> 0x005b }
        r1 = r1 + 1;
        goto L_0x0004;
    L_0x005b:
        return r3;
    L_0x005c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.polidea.reactnativeble.e.i.a(java.lang.String[]):java.util.UUID[]");
    }

    /* renamed from: a */
    public static java.util.UUID[] m23984a(com.facebook.react.bridge.ReadableArray r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r5.size();
        r0 = new java.util.UUID[r0];
        r1 = 0;
    L_0x0007:
        r2 = r5.size();
        if (r1 >= r2) goto L_0x0053;
    L_0x000d:
        r2 = r5.getString(r1);	 Catch:{ Throwable -> 0x0051 }
        r3 = r2.length();	 Catch:{ Throwable -> 0x0051 }
        r4 = 4;	 Catch:{ Throwable -> 0x0051 }
        if (r3 != r4) goto L_0x002f;	 Catch:{ Throwable -> 0x0051 }
    L_0x0018:
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0051 }
        r3.<init>();	 Catch:{ Throwable -> 0x0051 }
        r4 = f18888a;	 Catch:{ Throwable -> 0x0051 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0051 }
        r3.append(r2);	 Catch:{ Throwable -> 0x0051 }
        r2 = f18889b;	 Catch:{ Throwable -> 0x0051 }
        r3.append(r2);	 Catch:{ Throwable -> 0x0051 }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x0051 }
        goto L_0x0048;	 Catch:{ Throwable -> 0x0051 }
    L_0x002f:
        r3 = r2.length();	 Catch:{ Throwable -> 0x0051 }
        r4 = 8;	 Catch:{ Throwable -> 0x0051 }
        if (r3 != r4) goto L_0x0048;	 Catch:{ Throwable -> 0x0051 }
    L_0x0037:
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0051 }
        r3.<init>();	 Catch:{ Throwable -> 0x0051 }
        r3.append(r2);	 Catch:{ Throwable -> 0x0051 }
        r2 = f18889b;	 Catch:{ Throwable -> 0x0051 }
        r3.append(r2);	 Catch:{ Throwable -> 0x0051 }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x0051 }
    L_0x0048:
        r2 = java.util.UUID.fromString(r2);	 Catch:{ Throwable -> 0x0051 }
        r0[r1] = r2;	 Catch:{ Throwable -> 0x0051 }
        r1 = r1 + 1;
        goto L_0x0007;
    L_0x0051:
        r5 = 0;
        return r5;
    L_0x0053:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.polidea.reactnativeble.e.i.a(com.facebook.react.bridge.ReadableArray):java.util.UUID[]");
    }

    /* renamed from: a */
    public static String m23982a(UUID uuid) {
        return uuid.toString().toLowerCase();
    }
}
