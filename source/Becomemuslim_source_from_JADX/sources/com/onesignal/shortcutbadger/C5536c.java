package com.onesignal.shortcutbadger;

import android.content.ComponentName;
import android.content.Context;
import com.onesignal.shortcutbadger.impl.AdwHomeBadger;
import com.onesignal.shortcutbadger.impl.ApexHomeBadger;
import com.onesignal.shortcutbadger.impl.C6966a;
import com.onesignal.shortcutbadger.impl.EverythingMeHomeBadger;
import com.onesignal.shortcutbadger.impl.HuaweiHomeBadger;
import com.onesignal.shortcutbadger.impl.NewHtcHomeBadger;
import com.onesignal.shortcutbadger.impl.NovaHomeBadger;
import com.onesignal.shortcutbadger.impl.OPPOHomeBader;
import com.onesignal.shortcutbadger.impl.SamsungHomeBadger;
import com.onesignal.shortcutbadger.impl.SonyHomeBadger;
import com.onesignal.shortcutbadger.impl.VivoHomeBadger;
import com.onesignal.shortcutbadger.impl.ZukHomeBadger;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ShortcutBadger */
/* renamed from: com.onesignal.shortcutbadger.c */
public final class C5536c {
    /* renamed from: a */
    private static final List<Class<? extends C5534a>> f18571a = new LinkedList();
    /* renamed from: b */
    private static final Object f18572b = new Object();
    /* renamed from: c */
    private static C5534a f18573c;
    /* renamed from: d */
    private static ComponentName f18574d;

    static {
        f18571a.add(AdwHomeBadger.class);
        f18571a.add(ApexHomeBadger.class);
        f18571a.add(NewHtcHomeBadger.class);
        f18571a.add(NovaHomeBadger.class);
        f18571a.add(SonyHomeBadger.class);
        f18571a.add(C6966a.class);
        f18571a.add(HuaweiHomeBadger.class);
        f18571a.add(OPPOHomeBader.class);
        f18571a.add(SamsungHomeBadger.class);
        f18571a.add(ZukHomeBadger.class);
        f18571a.add(VivoHomeBadger.class);
        f18571a.add(EverythingMeHomeBadger.class);
    }

    /* renamed from: a */
    public static void m23560a(Context context, int i) {
        if (f18573c == null) {
            if (!C5536c.m23561a(context)) {
                throw new C5535b("No default launcher available");
            }
        }
        try {
            f18573c.mo4971a(context, f18574d, i);
        } catch (Context context2) {
            throw new C5535b("Unable to execute badge", context2);
        }
    }

    /* renamed from: a */
    private static boolean m23561a(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r4.getPackageManager();
        r1 = r4.getPackageName();
        r0 = r0.getLaunchIntentForPackage(r1);
        r1 = 0;
        if (r0 != 0) goto L_0x002a;
    L_0x000f:
        r0 = "ShortcutBadger";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Unable to find launch intent for package ";
        r2.append(r3);
        r4 = r4.getPackageName();
        r2.append(r4);
        r4 = r2.toString();
        android.util.Log.e(r0, r4);
        return r1;
    L_0x002a:
        r0 = r0.getComponent();
        f18574d = r0;
        r0 = new android.content.Intent;
        r2 = "android.intent.action.MAIN";
        r0.<init>(r2);
        r2 = "android.intent.category.HOME";
        r0.addCategory(r2);
        r4 = r4.getPackageManager();
        r2 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r4 = r4.resolveActivity(r0, r2);
        if (r4 == 0) goto L_0x00ca;
    L_0x0048:
        r0 = r4.activityInfo;
        r0 = r0.name;
        r0 = r0.toLowerCase();
        r2 = "resolver";
        r0 = r0.contains(r2);
        if (r0 == 0) goto L_0x005a;
    L_0x0058:
        goto L_0x00ca;
    L_0x005a:
        r4 = r4.activityInfo;
        r4 = r4.packageName;
        r0 = f18571a;
        r0 = r0.iterator();
    L_0x0064:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0087;
    L_0x006a:
        r1 = r0.next();
        r1 = (java.lang.Class) r1;
        r2 = 0;
        r1 = r1.newInstance();	 Catch:{ Exception -> 0x0078 }
        r1 = (com.onesignal.shortcutbadger.C5534a) r1;	 Catch:{ Exception -> 0x0078 }
        goto L_0x0079;
    L_0x0078:
        r1 = r2;
    L_0x0079:
        if (r1 == 0) goto L_0x0064;
    L_0x007b:
        r2 = r1.mo4970a();
        r2 = r2.contains(r4);
        if (r2 == 0) goto L_0x0064;
    L_0x0085:
        f18573c = r1;
    L_0x0087:
        r4 = f18573c;
        if (r4 != 0) goto L_0x00c8;
    L_0x008b:
        r4 = android.os.Build.MANUFACTURER;
        r0 = "ZUK";
        r4 = r4.equalsIgnoreCase(r0);
        if (r4 == 0) goto L_0x009d;
    L_0x0095:
        r4 = new com.onesignal.shortcutbadger.impl.ZukHomeBadger;
        r4.<init>();
        f18573c = r4;
        goto L_0x00c8;
    L_0x009d:
        r4 = android.os.Build.MANUFACTURER;
        r0 = "OPPO";
        r4 = r4.equalsIgnoreCase(r0);
        if (r4 == 0) goto L_0x00af;
    L_0x00a7:
        r4 = new com.onesignal.shortcutbadger.impl.OPPOHomeBader;
        r4.<init>();
        f18573c = r4;
        goto L_0x00c8;
    L_0x00af:
        r4 = android.os.Build.MANUFACTURER;
        r0 = "VIVO";
        r4 = r4.equalsIgnoreCase(r0);
        if (r4 == 0) goto L_0x00c1;
    L_0x00b9:
        r4 = new com.onesignal.shortcutbadger.impl.VivoHomeBadger;
        r4.<init>();
        f18573c = r4;
        goto L_0x00c8;
    L_0x00c1:
        r4 = new com.onesignal.shortcutbadger.impl.DefaultBadger;
        r4.<init>();
        f18573c = r4;
    L_0x00c8:
        r4 = 1;
        return r4;
    L_0x00ca:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.shortcutbadger.c.a(android.content.Context):boolean");
    }
}
