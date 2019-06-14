package me.leolin.shortcutbadger;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import java.util.LinkedList;
import java.util.List;
import me.leolin.shortcutbadger.impl.AdwHomeBadger;
import me.leolin.shortcutbadger.impl.ApexHomeBadger;
import me.leolin.shortcutbadger.impl.AsusHomeLauncher;
import me.leolin.shortcutbadger.impl.DefaultBadger;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;
import me.leolin.shortcutbadger.impl.NovaHomeBadger;
import me.leolin.shortcutbadger.impl.SolidHomeBadger;
import me.leolin.shortcutbadger.impl.SonyHomeBadger;
import me.leolin.shortcutbadger.impl.XiaomiHomeBadger;

/* compiled from: ShortcutBadger */
/* renamed from: me.leolin.shortcutbadger.c */
public final class C6565c {
    /* renamed from: a */
    private static final String f21092a = "c";
    /* renamed from: b */
    private static final List<Class<? extends C6563a>> f21093b = new LinkedList();
    /* renamed from: c */
    private static C6563a f21094c;
    /* renamed from: d */
    private static ComponentName f21095d;

    static {
        f21093b.add(AdwHomeBadger.class);
        f21093b.add(ApexHomeBadger.class);
        f21093b.add(NewHtcHomeBadger.class);
        f21093b.add(NovaHomeBadger.class);
        f21093b.add(SolidHomeBadger.class);
        f21093b.add(SonyHomeBadger.class);
        f21093b.add(XiaomiHomeBadger.class);
        f21093b.add(AsusHomeLauncher.class);
    }

    /* renamed from: a */
    public static boolean m26768a(Context context, int i) {
        try {
            C6565c.m26770b(context, i);
            return true;
        } catch (Context context2) {
            i = f21092a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to execute badge:");
            stringBuilder.append(context2.getMessage());
            Log.e(i, stringBuilder.toString());
            return null;
        }
    }

    /* renamed from: b */
    public static void m26770b(Context context, int i) {
        if (f21094c == null) {
            C6565c.m26769b(context);
        }
        try {
            f21094c.mo5508a(context, f21095d, i);
        } catch (Context context2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to execute badge:");
            stringBuilder.append(context2.getMessage());
            i = new C6564b(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public static boolean m26767a(Context context) {
        return C6565c.m26768a(context, 0);
    }

    /* renamed from: b */
    private static void m26769b(Context context) {
        f21095d = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()).getComponent();
        Log.d(f21092a, "Finding badger");
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            context = context.getPackageManager().resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST).activityInfo.packageName;
            if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
                f21094c = new XiaomiHomeBadger();
                return;
            }
            for (Class newInstance : f21093b) {
                C6563a c6563a = (C6563a) newInstance.newInstance();
                if (c6563a.mo5507a().contains(context)) {
                    f21094c = c6563a;
                    break;
                }
            }
            if (f21094c == null) {
                f21094c = new DefaultBadger();
            }
            context = f21092a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Current badger:");
            stringBuilder.append(f21094c.getClass().getCanonicalName());
            Log.d(context, stringBuilder.toString());
        } catch (Context context2) {
            Log.e(f21092a, context2.getMessage(), context2);
        }
    }

    private C6565c() {
    }
}
