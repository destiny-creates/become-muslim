package io.p347a.p348a.p349a.p350a.p352b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.facebook.common.util.ByteConstants;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.ServerProtocol;
import io.p347a.p348a.p349a.C6514c;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/* compiled from: CommonUtils */
/* renamed from: io.a.a.a.a.b.i */
public class C6428i {
    /* renamed from: a */
    public static final Comparator<File> f20767a = new C64261();
    /* renamed from: b */
    private static Boolean f20768b;
    /* renamed from: c */
    private static final char[] f20769c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    /* renamed from: d */
    private static long f20770d = -1;

    /* compiled from: CommonUtils */
    /* renamed from: io.a.a.a.a.b.i$1 */
    static class C64261 implements Comparator<File> {
        C64261() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m26346a((File) obj, (File) obj2);
        }

        /* renamed from: a */
        public int m26346a(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    /* compiled from: CommonUtils */
    /* renamed from: io.a.a.a.a.b.i$a */
    enum C6427a {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        
        /* renamed from: k */
        private static final Map<String, C6427a> f20765k = null;

        static {
            f20765k = new HashMap(4);
            f20765k.put("armeabi-v7a", ARMV7);
            f20765k.put("armeabi", ARMV6);
            f20765k.put("x86", X86_32);
        }

        /* renamed from: a */
        static C6427a m26347a() {
            Object obj = Build.CPU_ABI;
            if (TextUtils.isEmpty(obj)) {
                C6514c.m26634h().mo5472a("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            C6427a c6427a = (C6427a) f20765k.get(obj.toLowerCase(Locale.US));
            if (c6427a == null) {
                c6427a = UNKNOWN;
            }
            return c6427a;
        }
    }

    /* renamed from: a */
    public static SharedPreferences m26353a(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    /* renamed from: a */
    public static String m26355a(File file, String str) {
        Closeable bufferedReader;
        String str2 = null;
        if (file.exists()) {
            try {
                String[] split;
                bufferedReader = new BufferedReader(new FileReader(file), 1024);
                while (true) {
                    try {
                        CharSequence readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        split = Pattern.compile("\\s*:\\s*").split(readLine, 2);
                        if (split.length > 1 && split[0].equals(str)) {
                            break;
                        }
                    } catch (Exception e) {
                        str = e;
                    }
                }
                str2 = split[1];
            } catch (Exception e2) {
                str = e2;
                bufferedReader = null;
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Error parsing ");
                    stringBuilder.append(file);
                    C6514c.m26634h().mo5480e("Fabric", stringBuilder.toString(), str);
                    C6428i.m26367a(bufferedReader, "Failed to close system file reader.");
                    return str2;
                } catch (Throwable th) {
                    file = th;
                    C6428i.m26367a(bufferedReader, "Failed to close system file reader.");
                    throw file;
                }
            } catch (Throwable th2) {
                file = th2;
                bufferedReader = null;
                C6428i.m26367a(bufferedReader, "Failed to close system file reader.");
                throw file;
            }
            C6428i.m26367a(bufferedReader, "Failed to close system file reader.");
        }
        return str2;
    }

    /* renamed from: a */
    public static int m26348a() {
        return C6427a.m26347a().ordinal();
    }

    /* renamed from: b */
    public static synchronized long m26371b() {
        long j;
        synchronized (C6428i.class) {
            if (f20770d == -1) {
                j = 0;
                Object a = C6428i.m26355a(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(a)) {
                    String toUpperCase = a.toUpperCase(Locale.US);
                    try {
                        long a2;
                        if (toUpperCase.endsWith("KB")) {
                            a2 = C6428i.m26351a(toUpperCase, "KB", 1024);
                        } else if (toUpperCase.endsWith("MB")) {
                            a2 = C6428i.m26351a(toUpperCase, "MB", (int) ByteConstants.MB);
                        } else if (toUpperCase.endsWith("GB")) {
                            a2 = C6428i.m26351a(toUpperCase, "GB", 1073741824);
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unexpected meminfo format while computing RAM: ");
                            stringBuilder.append(toUpperCase);
                            C6514c.m26634h().mo5472a("Fabric", stringBuilder.toString());
                        }
                        j = a2;
                    } catch (Throwable e) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Unexpected meminfo format while computing RAM: ");
                        stringBuilder2.append(toUpperCase);
                        C6514c.m26634h().mo5480e("Fabric", stringBuilder2.toString(), e);
                    }
                }
                f20770d = j;
            }
            j = f20770d;
        }
        return j;
    }

    /* renamed from: a */
    static long m26351a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[null].trim()) * ((long) i);
    }

    /* renamed from: a */
    public static RunningAppProcessInfo m26352a(String str, Context context) {
        Context<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m26356a(InputStream inputStream) {
        inputStream = new Scanner(inputStream).useDelimiter("\\A");
        return inputStream.hasNext() ? inputStream.next() : "";
    }

    /* renamed from: a */
    public static String m26358a(String str) {
        return C6428i.m26359a(str, "SHA-1");
    }

    /* renamed from: b */
    public static String m26375b(InputStream inputStream) {
        return C6428i.m26357a(inputStream, "SHA-1");
    }

    /* renamed from: a */
    private static String m26357a(InputStream inputStream, String str) {
        try {
            str = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return C6428i.m26360a(str.digest());
                }
                str.update(bArr, 0, read);
            }
        } catch (InputStream inputStream2) {
            C6514c.m26634h().mo5480e("Fabric", "Could not calculate hash for app icon.", inputStream2);
            return "";
        }
    }

    /* renamed from: a */
    private static String m26361a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return C6428i.m26360a(instance.digest());
        } catch (byte[] bArr2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not create hashing algorithm: ");
            stringBuilder.append(str);
            stringBuilder.append(", returning empty string.");
            C6514c.m26634h().mo5480e("Fabric", stringBuilder.toString(), bArr2);
            return "";
        }
    }

    /* renamed from: a */
    private static String m26359a(String str, String str2) {
        return C6428i.m26361a(str.getBytes(), str2);
    }

    /* renamed from: a */
    public static String m26362a(String... strArr) {
        String str = null;
        if (strArr != null) {
            if (strArr.length != 0) {
                List<String> arrayList = new ArrayList();
                for (String str2 : strArr) {
                    if (str2 != null) {
                        arrayList.add(str2.replace("-", "").toLowerCase(Locale.US));
                    }
                }
                Collections.sort(arrayList);
                strArr = new StringBuilder();
                for (String append : arrayList) {
                    strArr.append(append);
                }
                String stringBuilder = strArr.toString();
                if (stringBuilder.length() > 0) {
                    str = C6428i.m26358a(stringBuilder);
                }
                return str;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static long m26372b(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    /* renamed from: b */
    public static long m26373b(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (blockSize * ((long) statFs.getAvailableBlocks()));
    }

    /* renamed from: c */
    public static float m26376c(Context context) {
        context = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return ((float) context.getIntExtra("level", -1)) / ((float) context.getIntExtra("scale", -1));
    }

    /* renamed from: d */
    public static boolean m26380d(Context context) {
        boolean z = false;
        if (C6428i.m26382f(context)) {
            return false;
        }
        if (((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public static void m26364a(Context context, String str) {
        if (C6428i.m26381e(context) != null) {
            C6514c.m26634h().mo5472a("Fabric", str);
        }
    }

    /* renamed from: a */
    public static void m26365a(Context context, String str, Throwable th) {
        if (C6428i.m26381e(context) != null) {
            C6514c.m26634h().mo5479e("Fabric", str);
        }
    }

    /* renamed from: a */
    public static void m26363a(Context context, int i, String str, String str2) {
        if (C6428i.m26381e(context) != null) {
            C6514c.m26634h().mo5471a(i, "Fabric", str2);
        }
    }

    /* renamed from: e */
    public static boolean m26381e(Context context) {
        if (f20768b == null) {
            f20768b = Boolean.valueOf(C6428i.m26370a(context, "com.crashlytics.Trace", false));
        }
        return f20768b.booleanValue();
    }

    /* renamed from: a */
    public static boolean m26370a(Context context, String str, boolean z) {
        if (context != null) {
            Resources resources = context.getResources();
            if (resources != null) {
                int a = C6428i.m26349a(context, str, "bool");
                if (a > 0) {
                    return resources.getBoolean(a);
                }
                str = C6428i.m26349a(context, str, "string");
                if (str > null) {
                    return Boolean.parseBoolean(context.getString(str));
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public static int m26349a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, C6428i.m26386j(context));
    }

    /* renamed from: f */
    public static boolean m26382f(Context context) {
        context = Secure.getString(context.getContentResolver(), "android_id");
        if (!(ServerProtocol.DIALOG_PARAM_SDK_VERSION.equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT))) {
            if (context != null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: g */
    public static boolean m26383g(Context context) {
        context = C6428i.m26382f(context);
        String str = Build.TAGS;
        if ((context == null && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (context != null || file.exists() == null) {
            return null;
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m26377c() {
        if (!Debug.isDebuggerConnected()) {
            if (!Debug.waitingForDebugger()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: h */
    public static int m26384h(Context context) {
        int i = C6428i.m26382f(context) ? 1 : 0;
        if (C6428i.m26383g(context) != null) {
            i |= 2;
        }
        return C6428i.m26377c() != null ? i | 4 : i;
    }

    /* renamed from: a */
    public static int m26350a(Context context, boolean z) {
        context = C6428i.m26376c(context);
        if (!z) {
            return 1;
        }
        if (!z || ((double) context) < 99.0d) {
            return (!z || ((double) context) >= 4636666922610458624) ? null : 2;
        } else {
            return 3;
        }
    }

    /* renamed from: a */
    public static String m26360a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & JfifUtil.MARKER_FIRST_BYTE;
            int i3 = i * 2;
            cArr[i3] = f20769c[i2 >>> 4];
            cArr[i3 + 1] = f20769c[i2 & 15];
        }
        return new String(cArr);
    }

    /* renamed from: i */
    public static boolean m26385i(Context context) {
        return (context.getApplicationInfo().flags & 2) != null ? true : null;
    }

    /* renamed from: b */
    public static String m26374b(Context context, String str) {
        str = C6428i.m26349a(context, str, "string");
        return str > null ? context.getString(str) : "";
    }

    /* renamed from: a */
    public static void m26367a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Closeable closeable2) {
                C6514c.m26634h().mo5480e("Fabric", str, closeable2);
            }
        }
    }

    /* renamed from: a */
    public static void m26368a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Flushable flushable2) {
                C6514c.m26634h().mo5480e("Fabric", str, flushable2);
            }
        }
    }

    /* renamed from: c */
    public static boolean m26379c(String str) {
        if (str != null) {
            if (str.length() != null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static String m26354a(int i) {
        if (i >= 0) {
            return String.format(Locale.US, "%1$10s", new Object[]{Integer.valueOf(i)}).replace(' ', '0');
        }
        throw new IllegalArgumentException("value must be zero or greater");
    }

    /* renamed from: j */
    public static String m26386j(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            return context.getResources().getResourcePackageName(i);
        }
        return context.getPackageName();
    }

    /* renamed from: a */
    public static void m26369a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    /* renamed from: k */
    public static String m26387k(Context context) {
        Throwable e;
        Throwable th;
        String str = null;
        Closeable openRawResource;
        try {
            openRawResource = context.getResources().openRawResource(C6428i.m26388l(context));
            try {
                String b = C6428i.m26375b((InputStream) openRawResource);
                if (!C6428i.m26379c(b)) {
                    str = b;
                }
                C6428i.m26367a(openRawResource, "Failed to close icon input stream.");
                return str;
            } catch (Exception e2) {
                e = e2;
                try {
                    C6514c.m26634h().mo5480e("Fabric", "Could not calculate hash for app icon.", e);
                    C6428i.m26367a(openRawResource, "Failed to close icon input stream.");
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    C6428i.m26367a(openRawResource, "Failed to close icon input stream.");
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            openRawResource = null;
            C6514c.m26634h().mo5480e("Fabric", "Could not calculate hash for app icon.", e);
            C6428i.m26367a(openRawResource, "Failed to close icon input stream.");
            return null;
        } catch (Context context2) {
            th = context2;
            openRawResource = null;
            C6428i.m26367a(openRawResource, "Failed to close icon input stream.");
            throw th;
        }
    }

    /* renamed from: l */
    public static int m26388l(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    /* renamed from: m */
    public static String m26389m(Context context) {
        int a = C6428i.m26349a(context, "io.fabric.android.build_id", "string");
        if (a == 0) {
            a = C6428i.m26349a(context, "com.crashlytics.android.build_id", "string");
        }
        if (a == 0) {
            return null;
        }
        context = context.getResources().getString(a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Build ID is: ");
        stringBuilder.append(context);
        C6514c.m26634h().mo5472a("Fabric", stringBuilder.toString());
        return context;
    }

    /* renamed from: a */
    public static void m26366a(java.io.Closeable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0008;
    L_0x0002:
        r0.close();	 Catch:{ RuntimeException -> 0x0006, Exception -> 0x0008 }
        goto L_0x0008;
    L_0x0006:
        r0 = move-exception;
        throw r0;
    L_0x0008:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.b.i.a(java.io.Closeable):void");
    }

    /* renamed from: c */
    public static boolean m26378c(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == null ? true : null;
    }

    /* renamed from: n */
    public static boolean m26390n(Context context) {
        boolean z = true;
        if (!C6428i.m26378c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        context = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (context == null || context.isConnectedOrConnecting() == null) {
            z = false;
        }
        return z;
    }
}
