package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.common.util.UriUtil;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.ads.C2624b;
import com.google.android.gms.ads.C2634h;
import com.google.android.gms.ads.C4263e;
import com.google.android.gms.ads.p167a.C2600e;
import com.google.android.gms.ads.p167a.C2601f;
import com.google.android.gms.ads.p170d.C2630b;
import com.google.android.gms.common.C2830f;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.LinkedList;

@cm
public final class mi {
    /* renamed from: a */
    public static final Handler f15796a = new Handler(Looper.getMainLooper());
    /* renamed from: b */
    private static final String f15797b = C4263e.class.getName();
    /* renamed from: c */
    private static final String f15798c = C2634h.class.getName();
    /* renamed from: d */
    private static final String f15799d = C2600e.class.getName();
    /* renamed from: e */
    private static final String f15800e = C2601f.class.getName();
    /* renamed from: f */
    private static final String f15801f = C2630b.class.getName();
    /* renamed from: g */
    private static final String f15802g = C2624b.class.getName();

    /* renamed from: a */
    public static int m19864a(Context context, int i) {
        return m19865a(context.getResources().getDisplayMetrics(), i);
    }

    /* renamed from: a */
    public static int m19865a(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    /* renamed from: a */
    public static String m19866a(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String string = contentResolver == null ? null : Secure.getString(contentResolver, "android_id");
        if (string == null || m19873a()) {
            string = "emulator";
        }
        return m19867a(string);
    }

    /* renamed from: a */
    public static java.lang.String m19867a(java.lang.String r9) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = 0;
        r1 = 0;
    L_0x0002:
        r2 = 2;
        r3 = 0;
        if (r1 >= r2) goto L_0x002e;
    L_0x0006:
        r2 = "MD5";	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r2 = java.security.MessageDigest.getInstance(r2);	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r4 = r9.getBytes();	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r2.update(r4);	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r4 = java.util.Locale.US;	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r5 = "%032X";	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r6 = 1;	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r7 = new java.lang.Object[r6];	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r8 = new java.math.BigInteger;	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r2 = r2.digest();	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r8.<init>(r6, r2);	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r7[r0] = r8;	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        r2 = java.lang.String.format(r4, r5, r7);	 Catch:{ NoSuchAlgorithmException -> 0x002b, ArithmeticException -> 0x002a }
        return r2;
    L_0x002a:
        return r3;
    L_0x002b:
        r1 = r1 + 1;
        goto L_0x0002;
    L_0x002e:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.mi.a(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static java.lang.String m19868a(java.lang.StackTraceElement[] r5, java.lang.String r6) {
        /*
        r0 = 0;
    L_0x0001:
        r1 = r0 + 1;
        r2 = r5.length;
        r3 = 0;
        if (r1 >= r2) goto L_0x0052;
    L_0x0007:
        r0 = r5[r0];
        r2 = r0.getClassName();
        r0 = r0.getMethodName();
        r4 = "loadAd";
        r0 = r4.equalsIgnoreCase(r0);
        if (r0 == 0) goto L_0x0050;
    L_0x0019:
        r0 = f15797b;
        r0 = r0.equalsIgnoreCase(r2);
        if (r0 != 0) goto L_0x0049;
    L_0x0021:
        r0 = f15798c;
        r0 = r0.equalsIgnoreCase(r2);
        if (r0 != 0) goto L_0x0049;
    L_0x0029:
        r0 = f15799d;
        r0 = r0.equalsIgnoreCase(r2);
        if (r0 != 0) goto L_0x0049;
    L_0x0031:
        r0 = f15800e;
        r0 = r0.equalsIgnoreCase(r2);
        if (r0 != 0) goto L_0x0049;
    L_0x0039:
        r0 = f15801f;
        r0 = r0.equalsIgnoreCase(r2);
        if (r0 != 0) goto L_0x0049;
    L_0x0041:
        r0 = f15802g;
        r0 = r0.equalsIgnoreCase(r2);
        if (r0 == 0) goto L_0x0050;
    L_0x0049:
        r5 = r5[r1];
        r5 = r5.getClassName();
        goto L_0x0053;
    L_0x0050:
        r0 = r1;
        goto L_0x0001;
    L_0x0052:
        r5 = r3;
    L_0x0053:
        if (r6 == 0) goto L_0x0094;
    L_0x0055:
        r0 = ".";
        r1 = new java.util.StringTokenizer;
        r1.<init>(r6, r0);
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = 2;
        r4 = r1.hasMoreElements();
        if (r4 == 0) goto L_0x008b;
    L_0x0068:
        r6 = r1.nextToken();
        r0.append(r6);
    L_0x006f:
        r6 = r2 + -1;
        if (r2 <= 0) goto L_0x0087;
    L_0x0073:
        r2 = r1.hasMoreElements();
        if (r2 == 0) goto L_0x0087;
    L_0x0079:
        r2 = ".";
        r0.append(r2);
        r2 = r1.nextToken();
        r0.append(r2);
        r2 = r6;
        goto L_0x006f;
    L_0x0087:
        r6 = r0.toString();
    L_0x008b:
        if (r5 == 0) goto L_0x0094;
    L_0x008d:
        r6 = r5.contains(r6);
        if (r6 != 0) goto L_0x0094;
    L_0x0093:
        return r5;
    L_0x0094:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.mi.a(java.lang.StackTraceElement[], java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static Throwable m19869a(Throwable th) {
        if (((Boolean) aph.m18688f().m18889a(asp.f14939d)).booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        th = null;
        while (!linkedList.isEmpty()) {
            Throwable th2 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th2.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th2.getClass().getName(), "<filtered>", "<filtered>", 1));
            Object obj = null;
            for (Object obj2 : stackTrace) {
                Object obj22;
                if (m19878b(obj22.getClassName())) {
                    arrayList.add(obj22);
                    obj = 1;
                } else {
                    String className = obj22.getClassName();
                    Object obj3 = (TextUtils.isEmpty(className) || !(className.startsWith("android.") || className.startsWith("java."))) ? null : 1;
                    if (obj3 == null) {
                        obj22 = new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1);
                    }
                    arrayList.add(obj22);
                }
            }
            if (obj != null) {
                th = th == null ? new Throwable(th2.getMessage()) : new Throwable(th2.getMessage(), th);
                th.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            }
        }
        return th;
    }

    /* renamed from: a */
    public static void m19870a(Context context, String str, String str2, Bundle bundle, boolean z, ml mlVar) {
        if (z) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            bundle.putString("os", VERSION.RELEASE);
            bundle.putString("api", String.valueOf(VERSION.SDK_INT));
            bundle.putString("appid", applicationContext.getPackageName());
            if (str == null) {
                int d = C2830f.b().d(context);
                StringBuilder stringBuilder = new StringBuilder(20);
                stringBuilder.append(d);
                stringBuilder.append(".12451000");
                str = stringBuilder.toString();
            }
            bundle.putString("js", str);
        }
        Builder appendQueryParameter = new Builder().scheme(UriUtil.HTTPS_SCHEME).path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", str2);
        for (String str22 : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(str22, bundle.getString(str22));
        }
        mlVar.mo4306a(appendQueryParameter.toString());
    }

    /* renamed from: a */
    private final void m19871a(ViewGroup viewGroup, aou aou, String str, int i, int i2) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            View textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(i2);
            View frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i);
            i = m19864a(context, 3);
            frameLayout.addView(textView, new LayoutParams(aou.f28284f - i, aou.f28281c - i, 17));
            viewGroup.addView(frameLayout, aou.f28284f, aou.f28281c);
        }
    }

    /* renamed from: a */
    public static void m19872a(boolean z, HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setReadTimeout(60000);
        if (str != null) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
        httpURLConnection.setUseCaches(false);
    }

    /* renamed from: a */
    public static boolean m19873a() {
        return Build.DEVICE.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE);
    }

    /* renamed from: b */
    public static int m19874b(Context context, int i) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return m19875b(displayMetrics, i);
    }

    /* renamed from: b */
    public static int m19875b(DisplayMetrics displayMetrics, int i) {
        return Math.round(((float) i) / displayMetrics.density);
    }

    /* renamed from: b */
    public static String m19876b(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        return contentResolver == null ? null : Secure.getString(contentResolver, "android_id");
    }

    /* renamed from: b */
    public static boolean m19877b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: b */
    public static boolean m19878b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith((String) aph.m18688f().m18889a(asp.f14941e))) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(cm.class);
        } catch (Throwable e) {
            String str2 = "Fail to check class type for class ";
            str = String.valueOf(str);
            mt.m19916a(str.length() != 0 ? str2.concat(str) : new String(str2), e);
            return false;
        }
    }

    /* renamed from: c */
    public static java.lang.String m19879c() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = java.util.UUID.randomUUID();
        r1 = r0.getLeastSignificantBits();
        r1 = java.math.BigInteger.valueOf(r1);
        r1 = r1.toByteArray();
        r2 = r0.getMostSignificantBits();
        r0 = java.math.BigInteger.valueOf(r2);
        r0 = r0.toByteArray();
        r2 = new java.math.BigInteger;
        r3 = 1;
        r2.<init>(r3, r1);
        r2 = r2.toString();
        r4 = 0;
        r5 = r2;
        r2 = 0;
    L_0x0029:
        r6 = 2;
        if (r2 >= r6) goto L_0x0050;
    L_0x002c:
        r6 = "MD5";	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r6 = java.security.MessageDigest.getInstance(r6);	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r6.update(r1);	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r6.update(r0);	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r7 = 8;	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r8 = new byte[r7];	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r6 = r6.digest();	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        java.lang.System.arraycopy(r6, r4, r8, r4, r7);	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r6 = new java.math.BigInteger;	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r6.<init>(r3, r8);	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r6 = r6.toString();	 Catch:{ NoSuchAlgorithmException -> 0x004d }
        r5 = r6;
    L_0x004d:
        r2 = r2 + 1;
        goto L_0x0029;
    L_0x0050:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.mi.c():java.lang.String");
    }

    /* renamed from: c */
    public static boolean m19880c(Context context) {
        return C2830f.b().b(context, C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE) == 0;
    }

    /* renamed from: d */
    public static int m19881d(Context context) {
        return DynamiteModule.b(context, ModuleDescriptor.MODULE_ID);
    }

    /* renamed from: e */
    public static int m19882e(Context context) {
        return DynamiteModule.a(context, ModuleDescriptor.MODULE_ID);
    }

    /* renamed from: f */
    public static boolean m19883f(Context context) {
        int b = C2830f.b().b(context, C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        if (b != 0) {
            if (b != 2) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public static boolean m19884g(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((int) (((float) displayMetrics.heightPixels) / displayMetrics.density)) < 600;
    }

    @android.annotation.TargetApi(17)
    /* renamed from: h */
    public static boolean m19885h(android.content.Context r6) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = r6.getResources();
        r0 = r0.getDisplayMetrics();
        r1 = "window";
        r6 = r6.getSystemService(r1);
        r6 = (android.view.WindowManager) r6;
        r6 = r6.getDefaultDisplay();
        r1 = com.google.android.gms.common.util.C2904o.e();
        r2 = 0;
        if (r1 == 0) goto L_0x0023;
    L_0x001b:
        r6.getRealMetrics(r0);
        r1 = r0.heightPixels;
        r3 = r0.widthPixels;
        goto L_0x004f;
    L_0x0023:
        r1 = android.view.Display.class;	 Catch:{ Exception -> 0x005c }
        r3 = "getRawHeight";	 Catch:{ Exception -> 0x005c }
        r4 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x005c }
        r1 = r1.getMethod(r3, r4);	 Catch:{ Exception -> 0x005c }
        r3 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x005c }
        r1 = r1.invoke(r6, r3);	 Catch:{ Exception -> 0x005c }
        r1 = (java.lang.Integer) r1;	 Catch:{ Exception -> 0x005c }
        r1 = r1.intValue();	 Catch:{ Exception -> 0x005c }
        r3 = android.view.Display.class;	 Catch:{ Exception -> 0x005c }
        r4 = "getRawWidth";	 Catch:{ Exception -> 0x005c }
        r5 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x005c }
        r3 = r3.getMethod(r4, r5);	 Catch:{ Exception -> 0x005c }
        r4 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x005c }
        r3 = r3.invoke(r6, r4);	 Catch:{ Exception -> 0x005c }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x005c }
        r3 = r3.intValue();	 Catch:{ Exception -> 0x005c }
    L_0x004f:
        r6.getMetrics(r0);
        r6 = r0.heightPixels;
        r0 = r0.widthPixels;
        if (r6 != r1) goto L_0x005c;
    L_0x0058:
        if (r0 != r3) goto L_0x005c;
    L_0x005a:
        r6 = 1;
        return r6;
    L_0x005c:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.mi.h(android.content.Context):boolean");
    }

    /* renamed from: i */
    public static int m19886i(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
    }

    /* renamed from: a */
    public final void m19887a(Context context, String str, String str2, Bundle bundle, boolean z) {
        m19870a(context, null, str2, bundle, true, new mj(this));
    }

    /* renamed from: a */
    public final void m19888a(ViewGroup viewGroup, aou aou, String str) {
        m19871a(viewGroup, aou, str, -16777216, -1);
    }

    /* renamed from: a */
    public final void m19889a(ViewGroup viewGroup, aou aou, String str, String str2) {
        mt.m19924e(str2);
        m19871a(viewGroup, aou, str, -65536, -16777216);
    }
}
