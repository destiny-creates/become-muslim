package com.facebook.ads.internal.p092g;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.facebook.ads.internal.g.a */
public class C1384a {
    /* renamed from: a */
    private static SensorManager f4018a;
    /* renamed from: b */
    private static Sensor f4019b;
    /* renamed from: c */
    private static Sensor f4020c;
    /* renamed from: d */
    private static volatile float[] f4021d;
    /* renamed from: e */
    private static volatile float[] f4022e;
    /* renamed from: f */
    private static Map<String, String> f4023f = new ConcurrentHashMap();
    /* renamed from: g */
    private static String[] f4024g = new String[]{"x", "y", "z"};
    /* renamed from: h */
    private static SensorEventListener f4025h;
    /* renamed from: i */
    private static SensorEventListener f4026i;

    /* renamed from: com.facebook.ads.internal.g.a$a */
    private static class C1382a implements SensorEventListener {
        private C1382a() {
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            C1384a.f4021d = sensorEvent.values;
            C1384a.m4740d();
        }
    }

    /* renamed from: com.facebook.ads.internal.g.a$b */
    private static class C1383b implements SensorEventListener {
        private C1383b() {
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            C1384a.f4022e = sensorEvent.values;
            C1384a.m4742e();
        }
    }

    /* renamed from: a */
    public static Map<String, String> m4731a() {
        Map hashMap = new HashMap();
        hashMap.putAll(f4023f);
        C1384a.m4733a(hashMap);
        return hashMap;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static synchronized void m4732a(android.content.Context r5) {
        /*
        r0 = com.facebook.ads.internal.p092g.C1384a.class;
        monitor-enter(r0);
        com.facebook.ads.internal.p092g.C1384a.m4736b(r5);	 Catch:{ all -> 0x006e }
        com.facebook.ads.internal.p092g.C1384a.m4739c(r5);	 Catch:{ all -> 0x006e }
        com.facebook.ads.internal.p092g.C1384a.m4741d(r5);	 Catch:{ all -> 0x006e }
        r1 = f4018a;	 Catch:{ all -> 0x006e }
        if (r1 != 0) goto L_0x0020;
    L_0x0010:
        r1 = "sensor";
        r5 = r5.getSystemService(r1);	 Catch:{ all -> 0x006e }
        r5 = (android.hardware.SensorManager) r5;	 Catch:{ all -> 0x006e }
        f4018a = r5;	 Catch:{ all -> 0x006e }
        r5 = f4018a;	 Catch:{ all -> 0x006e }
        if (r5 != 0) goto L_0x0020;
    L_0x001e:
        monitor-exit(r0);
        return;
    L_0x0020:
        r5 = f4019b;	 Catch:{ all -> 0x006e }
        if (r5 != 0) goto L_0x002d;
    L_0x0024:
        r5 = f4018a;	 Catch:{ all -> 0x006e }
        r1 = 1;
        r5 = r5.getDefaultSensor(r1);	 Catch:{ all -> 0x006e }
        f4019b = r5;	 Catch:{ all -> 0x006e }
    L_0x002d:
        r5 = f4020c;	 Catch:{ all -> 0x006e }
        if (r5 != 0) goto L_0x003a;
    L_0x0031:
        r5 = f4018a;	 Catch:{ all -> 0x006e }
        r1 = 4;
        r5 = r5.getDefaultSensor(r1);	 Catch:{ all -> 0x006e }
        f4020c = r5;	 Catch:{ all -> 0x006e }
    L_0x003a:
        r5 = f4025h;	 Catch:{ all -> 0x006e }
        r1 = 3;
        r2 = 0;
        if (r5 != 0) goto L_0x0054;
    L_0x0040:
        r5 = new com.facebook.ads.internal.g.a$a;	 Catch:{ all -> 0x006e }
        r5.<init>();	 Catch:{ all -> 0x006e }
        f4025h = r5;	 Catch:{ all -> 0x006e }
        r5 = f4019b;	 Catch:{ all -> 0x006e }
        if (r5 == 0) goto L_0x0054;
    L_0x004b:
        r5 = f4018a;	 Catch:{ all -> 0x006e }
        r3 = f4025h;	 Catch:{ all -> 0x006e }
        r4 = f4019b;	 Catch:{ all -> 0x006e }
        r5.registerListener(r3, r4, r1);	 Catch:{ all -> 0x006e }
    L_0x0054:
        r5 = f4026i;	 Catch:{ all -> 0x006e }
        if (r5 != 0) goto L_0x006c;
    L_0x0058:
        r5 = new com.facebook.ads.internal.g.a$b;	 Catch:{ all -> 0x006e }
        r5.<init>();	 Catch:{ all -> 0x006e }
        f4026i = r5;	 Catch:{ all -> 0x006e }
        r5 = f4020c;	 Catch:{ all -> 0x006e }
        if (r5 == 0) goto L_0x006c;
    L_0x0063:
        r5 = f4018a;	 Catch:{ all -> 0x006e }
        r2 = f4026i;	 Catch:{ all -> 0x006e }
        r3 = f4020c;	 Catch:{ all -> 0x006e }
        r5.registerListener(r2, r3, r1);	 Catch:{ all -> 0x006e }
    L_0x006c:
        monitor-exit(r0);
        return;
    L_0x006e:
        r5 = move-exception;
        monitor-exit(r0);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.g.a.a(android.content.Context):void");
    }

    /* renamed from: a */
    private static void m4733a(Map<String, String> map) {
        float[] fArr = f4021d;
        float[] fArr2 = f4022e;
        if (fArr != null) {
            int min = Math.min(f4024g.length, fArr.length);
            for (int i = 0; i < min; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("accelerometer_");
                stringBuilder.append(f4024g[i]);
                map.put(stringBuilder.toString(), String.valueOf(fArr[i]));
            }
        }
        if (fArr2 != null) {
            int min2 = Math.min(f4024g.length, fArr2.length);
            for (int i2 = 0; i2 < min2; i2++) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("rotation_");
                stringBuilder2.append(f4024g[i2]);
                map.put(stringBuilder2.toString(), String.valueOf(fArr2[i2]));
            }
        }
    }

    /* renamed from: b */
    private static void m4736b(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        f4023f.put("available_memory", String.valueOf(memoryInfo.availMem));
        if (VERSION.SDK_INT >= 16) {
            f4023f.put("total_memory", String.valueOf(memoryInfo.totalMem));
        }
    }

    /* renamed from: c */
    private static void m4739c(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long availableBlocks = (long) statFs.getAvailableBlocks();
        f4023f.put("free_space", String.valueOf(availableBlocks * ((long) statFs.getBlockSize())));
    }

    /* renamed from: d */
    private static synchronized void m4740d() {
        synchronized (C1384a.class) {
            if (f4018a != null) {
                f4018a.unregisterListener(f4025h);
            }
            f4025h = null;
        }
    }

    /* renamed from: d */
    private static void m4741d(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            Object obj;
            float f;
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            int intExtra3 = registerReceiver.getIntExtra(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, -1);
            if (intExtra3 != 2) {
                if (intExtra3 != 5) {
                    obj = null;
                    f = 0.0f;
                    if (intExtra2 > 0) {
                        f = 100.0f * (((float) intExtra) / ((float) intExtra2));
                    }
                    f4023f.put("battery", String.valueOf(f));
                    f4023f.put("charging", obj == null ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
            }
            obj = 1;
            f = 0.0f;
            if (intExtra2 > 0) {
                f = 100.0f * (((float) intExtra) / ((float) intExtra2));
            }
            f4023f.put("battery", String.valueOf(f));
            if (obj == null) {
            }
            f4023f.put("charging", obj == null ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
    }

    /* renamed from: e */
    private static synchronized void m4742e() {
        synchronized (C1384a.class) {
            if (f4018a != null) {
                f4018a.unregisterListener(f4026i);
            }
            f4026i = null;
        }
    }
}
