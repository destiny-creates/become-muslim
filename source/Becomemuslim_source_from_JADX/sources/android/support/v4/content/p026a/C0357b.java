package android.support.v4.content.p026a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutManager;
import android.os.Build.VERSION;
import android.support.v4.content.C0366b;
import android.text.TextUtils;

/* compiled from: ShortcutManagerCompat */
/* renamed from: android.support.v4.content.a.b */
public class C0357b {
    /* renamed from: a */
    public static boolean m1073a(Context context) {
        if (VERSION.SDK_INT >= 26) {
            return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
        }
        if (C0366b.m1109b(context, "com.android.launcher.permission.INSTALL_SHORTCUT") != 0) {
            return false;
        }
        for (ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"), 0)) {
            CharSequence charSequence = resolveInfo.activityInfo.permission;
            if (!TextUtils.isEmpty(charSequence)) {
                if ("com.android.launcher.permission.INSTALL_SHORTCUT".equals(charSequence)) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m1074a(Context context, C0355a c0355a, final IntentSender intentSender) {
        if (VERSION.SDK_INT >= 26) {
            return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).requestPinShortcut(c0355a.m1072a(), intentSender);
        }
        if (!C0357b.m1073a(context)) {
            return null;
        }
        Intent a = c0355a.m1071a(new Intent("com.android.launcher.action.INSTALL_SHORTCUT"));
        if (intentSender == null) {
            context.sendBroadcast(a);
            return true;
        }
        context.sendOrderedBroadcast(a, null, new BroadcastReceiver() {
            public void onReceive(android.content.Context r7, android.content.Intent r8) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                /*
                r6 = this;
                r0 = r12;	 Catch:{ SendIntentException -> 0x000a }
                r2 = 0;	 Catch:{ SendIntentException -> 0x000a }
                r3 = 0;	 Catch:{ SendIntentException -> 0x000a }
                r4 = 0;	 Catch:{ SendIntentException -> 0x000a }
                r5 = 0;	 Catch:{ SendIntentException -> 0x000a }
                r1 = r7;	 Catch:{ SendIntentException -> 0x000a }
                r0.sendIntent(r1, r2, r3, r4, r5);	 Catch:{ SendIntentException -> 0x000a }
            L_0x000a:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.a.b.1.onReceive(android.content.Context, android.content.Intent):void");
            }
        }, null, -1, null, null);
        return true;
    }
}
