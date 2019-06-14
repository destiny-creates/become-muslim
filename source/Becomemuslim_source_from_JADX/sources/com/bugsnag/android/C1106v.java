package com.bugsnag.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: EventReceiver */
/* renamed from: com.bugsnag.android.v */
public class C1106v extends BroadcastReceiver {
    /* renamed from: a */
    private static final Map<String, BreadcrumbType> f3114a = C1106v.m3926b();
    /* renamed from: b */
    private final C1089j f3115b;

    public C1106v(C1089j c1089j) {
        this.f3115b = c1089j;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            Map hashMap = new HashMap();
            String action = intent.getAction();
            String b = C1106v.m3925b(intent.getAction());
            hashMap.put("Intent Action", action);
            intent = intent.getExtras();
            if (intent != null) {
                for (String str : intent.keySet()) {
                    String obj = intent.get(str).toString();
                    if (C1106v.m3924a(str)) {
                        hashMap.put("Extra", String.format("%s: %s", new Object[]{b, obj}));
                    } else {
                        hashMap.put(str, obj);
                    }
                }
            }
            BreadcrumbType breadcrumbType = f3114a.containsKey(action) != null ? (BreadcrumbType) f3114a.get(action) : BreadcrumbType.LOG;
            if (this.f3115b.m3826o().m3865r()) {
                this.f3115b.m3797a(b, breadcrumbType, hashMap);
            }
        } catch (Context context2) {
            intent = new StringBuilder();
            intent.append("Failed to leave breadcrumb in EventReceiver: ");
            intent.append(context2.getMessage());
            ad.m3736b(intent.toString());
        }
    }

    /* renamed from: a */
    static boolean m3924a(String str) {
        return str.startsWith("android.");
    }

    /* renamed from: b */
    static String m3925b(String str) {
        return C1106v.m3924a(str) ? str.substring(str.lastIndexOf(".") + 1, str.length()) : str;
    }

    /* renamed from: b */
    private static Map<String, BreadcrumbType> m3926b() {
        Map<String, BreadcrumbType> hashMap = new HashMap();
        hashMap.put("android.appwidget.action.APPWIDGET_DELETED", BreadcrumbType.USER);
        hashMap.put("android.appwidget.action.APPWIDGET_DISABLED", BreadcrumbType.USER);
        hashMap.put("android.appwidget.action.APPWIDGET_ENABLED", BreadcrumbType.USER);
        hashMap.put("android.appwidget.action.APPWIDGET_HOST_RESTORED", BreadcrumbType.STATE);
        hashMap.put("android.appwidget.action.APPWIDGET_RESTORED", BreadcrumbType.STATE);
        hashMap.put("android.appwidget.action.APPWIDGET_UPDATE", BreadcrumbType.STATE);
        hashMap.put("android.appwidget.action.APPWIDGET_UPDATE_OPTIONS", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.ACTION_POWER_CONNECTED", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.ACTION_POWER_DISCONNECTED", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.ACTION_SHUTDOWN", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.AIRPLANE_MODE", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.BATTERY_LOW", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.BATTERY_OKAY", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.BOOT_COMPLETED", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.CAMERA_BUTTON", BreadcrumbType.USER);
        hashMap.put("android.intent.action.CLOSE_SYSTEM_DIALOGS", BreadcrumbType.USER);
        hashMap.put("android.intent.action.CONFIGURATION_CHANGED", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.CONTENT_CHANGED", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.DATE_CHANGED", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.DEVICE_STORAGE_LOW", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.DEVICE_STORAGE_OK", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.DOCK_EVENT", BreadcrumbType.USER);
        hashMap.put("android.intent.action.DREAMING_STARTED", BreadcrumbType.NAVIGATION);
        hashMap.put("android.intent.action.DREAMING_STOPPED", BreadcrumbType.NAVIGATION);
        hashMap.put("android.intent.action.INPUT_METHOD_CHANGED", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.LOCALE_CHANGED", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.REBOOT", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.SCREEN_OFF", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.SCREEN_ON", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.TIMEZONE_CHANGED", BreadcrumbType.STATE);
        hashMap.put("android.intent.action.TIME_SET", BreadcrumbType.STATE);
        hashMap.put("android.media.RINGER_MODE_CHANGED", BreadcrumbType.STATE);
        hashMap.put("android.os.action.DEVICE_IDLE_MODE_CHANGED", BreadcrumbType.STATE);
        hashMap.put("android.os.action.POWER_SAVE_MODE_CHANGED", BreadcrumbType.STATE);
        return hashMap;
    }

    /* renamed from: a */
    public static IntentFilter m3923a() {
        IntentFilter intentFilter = new IntentFilter();
        for (String addAction : f3114a.keySet()) {
            intentFilter.addAction(addAction);
        }
        return intentFilter;
    }
}
