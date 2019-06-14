package com.p073d.p074a.p076b;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.facebook.places.model.PlaceFields;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Utils */
/* renamed from: com.d.a.b.b */
public final class C1139b {

    /* compiled from: Utils */
    /* renamed from: com.d.a.b.b$a */
    public static class C1135a extends ThreadPoolExecutor {
        public C1135a() {
            super(1, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new C1137c());
        }
    }

    /* compiled from: Utils */
    /* renamed from: com.d.a.b.b$b */
    private static class C1136b extends Thread {
        /* renamed from: a */
        private static final AtomicInteger f3235a = new AtomicInteger(1);

        public C1136b(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Segment-");
            stringBuilder.append(f3235a.getAndIncrement());
            super(runnable, stringBuilder.toString());
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* compiled from: Utils */
    /* renamed from: com.d.a.b.b$c */
    public static class C1137c implements ThreadFactory {
        public Thread newThread(Runnable runnable) {
            return new C1136b(runnable);
        }
    }

    /* compiled from: Utils */
    /* renamed from: com.d.a.b.b$d */
    public static class C1138d<K, V> extends ConcurrentHashMap<K, V> {
        public C1138d(Map<? extends K, ? extends V> map) {
            super(map);
        }

        public V put(K k, V v) {
            if (k != null) {
                if (v != null) {
                    return super.put(k, v);
                }
            }
            return null;
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    /* renamed from: a */
    public static String m4013a(Date date) {
        return C1139b.m4025b(date);
    }

    /* renamed from: b */
    public static String m4025b(Date date) {
        return C1134a.m4006a(date);
    }

    /* renamed from: a */
    public static boolean m4019a(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == null ? true : null;
    }

    /* renamed from: b */
    public static boolean m4028b(Context context, String str) {
        return context.getPackageManager().hasSystemFeature(str);
    }

    /* renamed from: c */
    public static <T> T m4031c(Context context, String str) {
        return context.getSystemService(str);
    }

    /* renamed from: a */
    public static boolean m4020a(CharSequence charSequence) {
        if (!C1139b.m4029b(charSequence)) {
            if (C1139b.m4030c(charSequence) != null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: b */
    private static boolean m4029b(CharSequence charSequence) {
        if (charSequence != null) {
            if (charSequence.length() != null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: c */
    private static int m4030c(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) <= ' ') {
            i++;
        }
        while (length > i && charSequence.charAt(length - 1) <= ' ') {
            length--;
        }
        return length - i;
    }

    /* renamed from: a */
    public static boolean m4022a(Collection collection) {
        if (collection != null) {
            if (collection.size() != null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m4023a(Map map) {
        if (map != null) {
            if (map.size() != null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static String m4012a(String str, String str2) {
        if (!C1139b.m4020a((CharSequence) str)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(" cannot be null or empty");
        throw new NullPointerException(stringBuilder.toString());
    }

    /* renamed from: a */
    public static <T> T m4009a(T t, String str) {
        if (t != null) {
            return t;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" == null");
        throw new NullPointerException(stringBuilder.toString());
    }

    /* renamed from: b */
    public static <K, V> Map<K, V> m4026b(Map<K, V> map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    /* renamed from: a */
    public static <T> List<T> m4014a(List<T> list) {
        if (C1139b.m4022a((Collection) list)) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(list));
    }

    /* renamed from: a */
    public static String m4010a(Context context) {
        CharSequence string = Secure.getString(context.getContentResolver(), "android_id");
        if (!C1139b.m4020a(string) && !"9774d56d682e549c".equals(string) && !"unknown".equals(string) && !"000000000000000".equals(string)) {
            return string;
        }
        if (!C1139b.m4020a(Build.SERIAL)) {
            return Build.SERIAL;
        }
        if (C1139b.m4019a(context, "android.permission.READ_PHONE_STATE") && C1139b.m4028b(context, "android.hardware.telephony")) {
            CharSequence deviceId = ((TelephonyManager) C1139b.m4031c(context, PlaceFields.PHONE)).getDeviceId();
            if (!C1139b.m4020a(deviceId)) {
                return deviceId;
            }
        }
        return UUID.randomUUID().toString();
    }

    /* renamed from: d */
    public static SharedPreferences m4032d(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("analytics-android-");
        stringBuilder.append(str);
        return context.getSharedPreferences(stringBuilder.toString(), 0);
    }

    /* renamed from: b */
    public static boolean m4027b(Context context) {
        boolean z = true;
        if (!C1139b.m4019a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        context = ((ConnectivityManager) C1139b.m4031c(context, "connectivity")).getActiveNetworkInfo();
        if (context == null || context.isConnectedOrConnecting() == null) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m4021a(java.lang.String r0) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0005 }
        r0 = 1;
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.d.a.b.b.a(java.lang.String):boolean");
    }

    /* renamed from: a */
    public static void m4017a(java.io.Closeable r0) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        if (r0 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0.close();	 Catch:{ IOException -> 0x0006 }
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.d.a.b.b.a(java.io.Closeable):void");
    }

    /* renamed from: a */
    public static BufferedReader m4008a(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    /* renamed from: b */
    public static String m4024b(InputStream inputStream) {
        return C1139b.m4011a(C1139b.m4008a(inputStream));
    }

    /* renamed from: a */
    public static String m4011a(BufferedReader bufferedReader) {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return stringBuilder.toString();
            }
            stringBuilder.append(readLine);
        }
    }

    /* renamed from: a */
    public static <T> Map<String, T> m4015a() {
        return new C1138d();
    }

    /* renamed from: a */
    public static void m4018a(File file) {
        if (!file.exists() && !file.mkdirs()) {
            if (!file.isDirectory()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not create directory at ");
                stringBuilder.append(file);
                throw new IOException(stringBuilder.toString());
            }
        }
    }

    /* renamed from: a */
    public static void m4016a(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        sharedPreferences2 = sharedPreferences2.edit();
        for (Entry entry : sharedPreferences.getAll().entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                sharedPreferences2.putString(str, (String) value);
            } else if (value instanceof Set) {
                sharedPreferences2.putStringSet(str, (Set) value);
            } else if (value instanceof Integer) {
                sharedPreferences2.putInt(str, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                sharedPreferences2.putLong(str, ((Long) value).longValue());
            } else if (value instanceof Float) {
                sharedPreferences2.putFloat(str, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                sharedPreferences2.putBoolean(str, ((Boolean) value).booleanValue());
            }
        }
        sharedPreferences2.apply();
    }
}
