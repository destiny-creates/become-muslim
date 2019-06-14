package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.p180d.C2829c;
import com.google.android.gms.common.util.C2904o;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@cm
public final class jw {
    /* renamed from: a */
    public static final Handler f15691a = new jo(Looper.getMainLooper());
    /* renamed from: b */
    private final Object f15692b = new Object();
    /* renamed from: c */
    private boolean f15693c = true;
    /* renamed from: d */
    private String f15694d;
    /* renamed from: e */
    private boolean f15695e = false;
    /* renamed from: f */
    private boolean f15696f = false;
    /* renamed from: g */
    private Pattern f15697g;
    /* renamed from: h */
    private Pattern f15698h;

    /* renamed from: a */
    public static Bitmap m19682a(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    /* renamed from: a */
    public static Bundle m19683a(alo alo) {
        if (alo == null) {
            return null;
        }
        if (!((Boolean) aph.m18688f().m18889a(asp.f14932W)).booleanValue()) {
            if (!((Boolean) aph.m18688f().m18889a(asp.f14934Y)).booleanValue()) {
                return null;
            }
        }
        if (ax.i().m30847l().m19659b() && ax.i().m30847l().m19665d()) {
            return null;
        }
        String b;
        String c;
        String d;
        if (alo.m18607d()) {
            alo.m18606c();
        }
        ali b2 = alo.m18605b();
        if (b2 != null) {
            b = b2.m18570b();
            c = b2.m18572c();
            d = b2.m18573d();
            if (b != null) {
                ax.i().m30847l().m19651a(b);
            }
            if (d != null) {
                ax.i().m30847l().m19657b(d);
            }
        } else {
            b = ax.i().m30847l().m19660c();
            d = ax.i().m30847l().m19666e();
            c = null;
        }
        Bundle bundle = new Bundle(1);
        if (d != null) {
            if (((Boolean) aph.m18688f().m18889a(asp.f14934Y)).booleanValue() && !ax.i().m30847l().m19665d()) {
                bundle.putString("v_fp_vertical", d);
            }
        }
        if (b != null) {
            if (((Boolean) aph.m18688f().m18889a(asp.f14932W)).booleanValue() && !ax.i().m30847l().m19659b()) {
                bundle.putString("fingerprint", b);
                if (!b.equals(c)) {
                    bundle.putString("v_fp", c);
                }
            }
        }
        return !bundle.isEmpty() ? bundle : null;
    }

    /* renamed from: a */
    public static DisplayMetrics m19684a(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: a */
    public static WebResourceResponse m19685a(HttpURLConnection httpURLConnection) {
        String trim;
        ax.e();
        Object contentType = httpURLConnection.getContentType();
        String trim2 = TextUtils.isEmpty(contentType) ? "" : contentType.split(";")[0].trim();
        ax.e();
        contentType = httpURLConnection.getContentType();
        if (!TextUtils.isEmpty(contentType)) {
            String[] split = contentType.split(";");
            if (split.length != 1) {
                for (int i = 1; i < split.length; i++) {
                    if (split[i].trim().startsWith("charset")) {
                        String[] split2 = split[i].trim().split("=");
                        if (split2.length > 1) {
                            trim = split2[1].trim();
                            break;
                        }
                    }
                }
            }
        }
        trim = "";
        String str = trim;
        Map headerFields = httpURLConnection.getHeaderFields();
        Map hashMap = new HashMap(headerFields.size());
        for (Entry entry : headerFields.entrySet()) {
            if (!(entry.getKey() == null || entry.getValue() == null || ((List) entry.getValue()).size() <= 0)) {
                hashMap.put((String) entry.getKey(), (String) ((List) entry.getValue()).get(0));
            }
        }
        return ax.g().mo6907a(trim2, str, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
    }

    /* renamed from: a */
    public static PopupWindow m19686a(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, false);
    }

    /* renamed from: a */
    public static String m19688a() {
        return UUID.randomUUID().toString();
    }

    /* renamed from: a */
    public static String m19689a(Context context, View view, aou aou) {
        if (!((Boolean) aph.m18688f().m18889a(asp.ak)).booleanValue()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", aou.f28283e);
            jSONObject2.put("height", aou.f28280b);
            jSONObject.put("size", jSONObject2);
            jSONObject.put("activity", m19734l(context));
            if (!aou.f28282d) {
                JSONArray jSONArray = new JSONArray();
                while (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent != null) {
                        int i = -1;
                        if (parent instanceof ViewGroup) {
                            i = ((ViewGroup) parent).indexOfChild(view);
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("type", parent.getClass().getName());
                        jSONObject3.put("index_of_child", i);
                        jSONArray.put(jSONObject3);
                    }
                    view = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("parents", jSONArray);
                }
            }
            return jSONObject.toString();
        } catch (Throwable e) {
            mt.m19921c("Fail to get view hierarchy json", e);
            return null;
        }
    }

    /* renamed from: a */
    public static String m19691a(InputStreamReader inputStreamReader) {
        StringBuilder stringBuilder = new StringBuilder(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return stringBuilder.toString();
            }
            stringBuilder.append(cArr, 0, read);
        }
    }

    /* renamed from: a */
    public static String m19692a(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }

    /* renamed from: a */
    public static Map<String, String> m19693a(Uri uri) {
        if (uri == null) {
            return null;
        }
        Map hashMap = new HashMap();
        for (String str : ax.g().mo6102a(uri)) {
            hashMap.put(str, uri.getQueryParameter(str));
        }
        return hashMap;
    }

    /* renamed from: a */
    private final JSONArray m19694a(Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            m19702a(jSONArray, a);
        }
        return jSONArray;
    }

    /* renamed from: a */
    private final JSONObject m19695a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            m19703a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m19696a(android.content.Context r1, android.content.Intent r2) {
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
        r1.startActivity(r2);	 Catch:{ Throwable -> 0x0004 }
        return;
    L_0x0004:
        r0 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r2.addFlags(r0);
        r1.startActivity(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jw.a(android.content.Context, android.content.Intent):void");
    }

    @TargetApi(18)
    /* renamed from: a */
    public static void m19697a(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            if (((Boolean) aph.m18688f().m18889a(asp.cL)).booleanValue()) {
                m19714b(context, intent);
            }
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(uri2).length() + 26);
            stringBuilder.append("Opening ");
            stringBuilder.append(uri2);
            stringBuilder.append(" in a new browser.");
            mt.m19918b(stringBuilder.toString());
        } catch (Throwable e) {
            mt.m19919b("No browser is found.", e);
        }
    }

    /* renamed from: a */
    public static void m19698a(Context context, String str, String str2) {
        List arrayList = new ArrayList();
        arrayList.add(str2);
        m19699a(context, str, arrayList);
    }

    /* renamed from: a */
    public static void m19699a(Context context, String str, List<String> list) {
        for (String lwVar : list) {
            new lw(context, str, lwVar).mo3819c();
        }
    }

    /* renamed from: a */
    public static void m19700a(android.content.Context r3, java.lang.Throwable r4) {
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
        if (r3 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = 0;
        r1 = com.google.android.gms.internal.ads.asp.f14938c;	 Catch:{ IllegalStateException -> 0x0015 }
        r2 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ IllegalStateException -> 0x0015 }
        r1 = r2.m18889a(r1);	 Catch:{ IllegalStateException -> 0x0015 }
        r1 = (java.lang.Boolean) r1;	 Catch:{ IllegalStateException -> 0x0015 }
        r1 = r1.booleanValue();	 Catch:{ IllegalStateException -> 0x0015 }
        r0 = r1;
    L_0x0015:
        if (r0 == 0) goto L_0x001a;
    L_0x0017:
        com.google.android.gms.common.util.C2897g.a(r3, r4);
    L_0x001a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jw.a(android.content.Context, java.lang.Throwable):void");
    }

    /* renamed from: a */
    public static void m19701a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            ju.m19678a(runnable);
        }
    }

    /* renamed from: a */
    private final void m19702a(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            obj = m19695a((Bundle) obj);
        } else if (obj instanceof Map) {
            obj = m19737a((Map) obj);
        } else if (obj instanceof Collection) {
            obj = m19694a((Collection) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            JSONArray jSONArray2 = new JSONArray();
            for (Object a : objArr) {
                m19702a(jSONArray2, a);
            }
            jSONArray.put(jSONArray2);
            return;
        } else {
            jSONArray.put(obj);
            return;
        }
        jSONArray.put(obj);
    }

    /* renamed from: a */
    private final void m19703a(JSONObject jSONObject, String str, Object obj) {
        if (obj instanceof Bundle) {
            obj = m19695a((Bundle) obj);
        } else if (obj instanceof Map) {
            obj = m19737a((Map) obj);
        } else {
            Collection collection;
            if (obj instanceof Collection) {
                if (str == null) {
                    str = "null";
                }
                collection = (Collection) obj;
            } else if (obj instanceof Object[]) {
                collection = Arrays.asList((Object[]) obj);
            } else {
                jSONObject.put(str, obj);
                return;
            }
            obj = m19694a(collection);
        }
        jSONObject.put(str, obj);
    }

    /* renamed from: a */
    private static boolean m19704a(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    @TargetApi(24)
    /* renamed from: a */
    public static boolean m19705a(Activity activity, Configuration configuration) {
        aph.m18683a();
        int a = mi.m19864a((Context) activity, configuration.screenHeightDp);
        int a2 = mi.m19864a((Context) activity, configuration.screenWidthDp);
        DisplayMetrics a3 = m19684a((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = a3.heightPixels;
        int i2 = a3.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        identifier = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        int round = ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d)) * ((Integer) aph.m18688f().m18889a(asp.cX)).intValue();
        return m19704a(i, a + identifier, round) && m19704a(i2, a2, round);
    }

    /* renamed from: a */
    public static boolean m19706a(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        boolean z = false;
        try {
            String format;
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            if (resolveActivity != null) {
                if (resolveActivity.activityInfo != null) {
                    boolean z2;
                    String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
                    if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
                        mt.m19924e(String.format(str, new Object[]{"keyboard"}));
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
                        mt.m19924e(String.format(str, new Object[]{"keyboardHidden"}));
                        z2 = false;
                    }
                    if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
                        mt.m19924e(String.format(str, new Object[]{"orientation"}));
                        z2 = false;
                    }
                    if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
                        mt.m19924e(String.format(str, new Object[]{"screenLayout"}));
                        z2 = false;
                    }
                    if ((resolveActivity.activityInfo.configChanges & 512) == 0) {
                        mt.m19924e(String.format(str, new Object[]{"uiMode"}));
                        z2 = false;
                    }
                    if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
                        mt.m19924e(String.format(str, new Object[]{"screenSize"}));
                        z2 = false;
                    }
                    if ((resolveActivity.activityInfo.configChanges & 2048) == 0) {
                        format = String.format(str, new Object[]{"smallestScreenSize"});
                        mt.m19924e(format);
                        return z;
                    }
                    z = z2;
                    return z;
                }
            }
            format = "Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.";
            mt.m19924e(format);
            return z;
        } catch (Throwable e) {
            mt.m19921c("Could not verify that com.google.android.gms.ads.AdActivity is declared in AndroidManifest.xml", e);
            ax.i().m30834a(e, "AdUtil.hasAdActivity");
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m19707a(Context context, String str) {
        return C2829c.a(context).a(str, context.getPackageName()) == 0;
    }

    /* renamed from: a */
    public static boolean m19709a(java.lang.ClassLoader r1, java.lang.Class<?> r2, java.lang.String r3) {
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
        r1 = java.lang.Class.forName(r3, r0, r1);	 Catch:{ Throwable -> 0x000a }
        r1 = r2.isAssignableFrom(r1);	 Catch:{ Throwable -> 0x000a }
        return r1;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jw.a(java.lang.ClassLoader, java.lang.Class, java.lang.String):boolean");
    }

    /* renamed from: a */
    public static int[] m19710a(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || window.findViewById(16908290) == null) {
            return m19726e();
        }
        return new int[]{window.findViewById(16908290).getWidth(), window.findViewById(16908290).getHeight()};
    }

    /* renamed from: b */
    public static int m19711b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            str = String.valueOf(e);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 22);
            stringBuilder.append("Could not parse value:");
            stringBuilder.append(str);
            mt.m19924e(stringBuilder.toString());
            return 0;
        }
    }

    /* renamed from: b */
    public static Bitmap m19712b(View view) {
        if (view == null) {
            return null;
        }
        Bitmap f = m19727f(view);
        if (f == null) {
            f = m19725e(view);
        }
        return f;
    }

    /* renamed from: b */
    public static String m19713b() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(str2).length());
        stringBuilder.append(str);
        stringBuilder.append(" ");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    @TargetApi(18)
    /* renamed from: b */
    public static void m19714b(Context context, Intent intent) {
        if (intent != null && C2904o.f()) {
            Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
            extras.putBinder("android.support.customtabs.extra.SESSION", null);
            extras.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(extras);
        }
    }

    /* renamed from: b */
    public static void m19715b(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes(Utf8Charset.NAME));
            openFileOutput.close();
        } catch (Throwable e) {
            mt.m19919b("Error writing to file in internal storage.", e);
        }
    }

    /* renamed from: c */
    public static Bundle m19716c() {
        Bundle bundle = new Bundle();
        try {
            if (((Boolean) aph.m18688f().m18889a(asp.f14912C)).booleanValue()) {
                Parcelable memoryInfo = new MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
                bundle.putParcelable("debug_memory_info", memoryInfo);
            }
            if (((Boolean) aph.m18688f().m18889a(asp.f14913D)).booleanValue()) {
                Runtime runtime = Runtime.getRuntime();
                bundle.putLong("runtime_free_memory", runtime.freeMemory());
                bundle.putLong("runtime_max_memory", runtime.maxMemory());
                bundle.putLong("runtime_total_memory", runtime.totalMemory());
            }
            bundle.putInt("web_view_count", ax.i().m30846k());
        } catch (Throwable e) {
            mt.m19921c("Unable to gather memory stats", e);
        }
        return bundle;
    }

    /* renamed from: c */
    public static WebResourceResponse m19717c(Context context, String str, String str2) {
        try {
            Map hashMap = new HashMap();
            hashMap.put("User-Agent", ax.e().m19744b(context, str));
            hashMap.put("Cache-Control", "max-stale=3600");
            String str3 = (String) new lg(context).m19833a(str2, hashMap).get(60, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", Utf8Charset.NAME, new ByteArrayInputStream(str3.getBytes(Utf8Charset.NAME)));
            }
        } catch (Throwable e) {
            mt.m19921c("Could not fetch MRAID JS.", e);
        }
        return null;
    }

    /* renamed from: c */
    public static java.lang.String m19718c(android.content.Context r1, java.lang.String r2) {
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
        r1 = r1.openFileInput(r2);	 Catch:{ IOException -> 0x0011 }
        r2 = new java.lang.String;	 Catch:{ IOException -> 0x0011 }
        r0 = 1;	 Catch:{ IOException -> 0x0011 }
        r1 = com.google.android.gms.common.util.C2902m.a(r1, r0);	 Catch:{ IOException -> 0x0011 }
        r0 = "UTF-8";	 Catch:{ IOException -> 0x0011 }
        r2.<init>(r1, r0);	 Catch:{ IOException -> 0x0011 }
        return r2;
    L_0x0011:
        r1 = "Error reading from internal storage.";
        com.google.android.gms.internal.ads.mt.m19918b(r1);
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jw.c(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: c */
    public static boolean m19719c(View view) {
        Activity activity;
        Window window;
        view = view.getRootView();
        LayoutParams layoutParams = null;
        if (view != null) {
            Context context = view.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
                if (activity == null) {
                    return false;
                }
                window = activity.getWindow();
                if (window == null) {
                    layoutParams = window.getAttributes();
                }
                return layoutParams == null && (layoutParams.flags & 524288) != 0;
            }
        }
        activity = null;
        if (activity == null) {
            return false;
        }
        window = activity.getWindow();
        if (window == null) {
            layoutParams = window.getAttributes();
        }
        if (layoutParams == null) {
        }
    }

    /* renamed from: c */
    public static boolean m19720c(String str) {
        return TextUtils.isEmpty(str) ? false : str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    /* renamed from: d */
    public static int m19721d(View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        return parent == null ? -1 : ((AdapterView) parent).getPositionForView(view);
    }

    /* renamed from: d */
    private static String m19722d() {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("Mozilla/5.0 (Linux; U; Android");
        if (VERSION.RELEASE != null) {
            stringBuilder.append(" ");
            stringBuilder.append(VERSION.RELEASE);
        }
        stringBuilder.append("; ");
        stringBuilder.append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuilder.append("; ");
            stringBuilder.append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuilder.append(" Build/");
                stringBuilder.append(Build.DISPLAY);
            }
        }
        stringBuilder.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuilder.toString();
    }

    /* renamed from: d */
    protected static java.lang.String m19723d(android.content.Context r1) {
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
        r0 = new android.webkit.WebView;	 Catch:{ Throwable -> 0x000e }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x000e }
        r1 = r0.getSettings();	 Catch:{ Throwable -> 0x000e }
        r1 = r1.getUserAgentString();	 Catch:{ Throwable -> 0x000e }
        return r1;
    L_0x000e:
        r1 = m19722d();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jw.d(android.content.Context):java.lang.String");
    }

    /* renamed from: e */
    public static Builder m19724e(Context context) {
        return new Builder(context);
    }

    /* renamed from: e */
    private static Bitmap m19725e(View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width != 0) {
                if (height != 0) {
                    Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.RGB_565);
                    Canvas canvas = new Canvas(createBitmap);
                    view.layout(0, 0, width, height);
                    view.draw(canvas);
                    return createBitmap;
                }
            }
            mt.m19924e("Width or height of view is zero");
            return null;
        } catch (Throwable e) {
            mt.m19919b("Fail to capture the webview", e);
            return null;
        }
    }

    /* renamed from: e */
    private static int[] m19726e() {
        return new int[]{0, 0};
    }

    /* renamed from: f */
    private static Bitmap m19727f(View view) {
        Bitmap bitmap = null;
        try {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                bitmap = Bitmap.createBitmap(drawingCache);
            }
            view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        } catch (Throwable e) {
            mt.m19919b("Fail to capture the web view", e);
        }
        return bitmap;
    }

    /* renamed from: f */
    public static asa m19728f(Context context) {
        return new asa(context);
    }

    /* renamed from: g */
    public static boolean m19729g(android.content.Context r6) {
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
        r1 = "activity";	 Catch:{ Throwable -> 0x0055 }
        r1 = r6.getSystemService(r1);	 Catch:{ Throwable -> 0x0055 }
        r1 = (android.app.ActivityManager) r1;	 Catch:{ Throwable -> 0x0055 }
        r2 = "keyguard";	 Catch:{ Throwable -> 0x0055 }
        r2 = r6.getSystemService(r2);	 Catch:{ Throwable -> 0x0055 }
        r2 = (android.app.KeyguardManager) r2;	 Catch:{ Throwable -> 0x0055 }
        if (r1 == 0) goto L_0x0055;	 Catch:{ Throwable -> 0x0055 }
    L_0x0013:
        if (r2 != 0) goto L_0x0016;	 Catch:{ Throwable -> 0x0055 }
    L_0x0015:
        goto L_0x0055;	 Catch:{ Throwable -> 0x0055 }
    L_0x0016:
        r1 = r1.getRunningAppProcesses();	 Catch:{ Throwable -> 0x0055 }
        if (r1 != 0) goto L_0x001d;	 Catch:{ Throwable -> 0x0055 }
    L_0x001c:
        return r0;	 Catch:{ Throwable -> 0x0055 }
    L_0x001d:
        r1 = r1.iterator();	 Catch:{ Throwable -> 0x0055 }
    L_0x0021:
        r3 = r1.hasNext();	 Catch:{ Throwable -> 0x0055 }
        if (r3 == 0) goto L_0x0055;	 Catch:{ Throwable -> 0x0055 }
    L_0x0027:
        r3 = r1.next();	 Catch:{ Throwable -> 0x0055 }
        r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3;	 Catch:{ Throwable -> 0x0055 }
        r4 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x0055 }
        r5 = r3.pid;	 Catch:{ Throwable -> 0x0055 }
        if (r4 != r5) goto L_0x0021;	 Catch:{ Throwable -> 0x0055 }
    L_0x0035:
        r1 = r3.importance;	 Catch:{ Throwable -> 0x0055 }
        r3 = 100;	 Catch:{ Throwable -> 0x0055 }
        if (r1 != r3) goto L_0x0055;	 Catch:{ Throwable -> 0x0055 }
    L_0x003b:
        r1 = r2.inKeyguardRestrictedInputMode();	 Catch:{ Throwable -> 0x0055 }
        if (r1 != 0) goto L_0x0055;	 Catch:{ Throwable -> 0x0055 }
    L_0x0041:
        r1 = "power";	 Catch:{ Throwable -> 0x0055 }
        r6 = r6.getSystemService(r1);	 Catch:{ Throwable -> 0x0055 }
        r6 = (android.os.PowerManager) r6;	 Catch:{ Throwable -> 0x0055 }
        if (r6 != 0) goto L_0x004d;	 Catch:{ Throwable -> 0x0055 }
    L_0x004b:
        r6 = 0;	 Catch:{ Throwable -> 0x0055 }
        goto L_0x0051;	 Catch:{ Throwable -> 0x0055 }
    L_0x004d:
        r6 = r6.isScreenOn();	 Catch:{ Throwable -> 0x0055 }
    L_0x0051:
        if (r6 == 0) goto L_0x0055;
    L_0x0053:
        r6 = 1;
        return r6;
    L_0x0055:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jw.g(android.content.Context):boolean");
    }

    /* renamed from: h */
    public static Bitmap m19730h(Context context) {
        Bitmap bitmap = null;
        if (!(context instanceof Activity)) {
            return null;
        }
        try {
            Bitmap f;
            if (((Boolean) aph.m18688f().m18889a(asp.bS)).booleanValue()) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    f = m19727f(window.getDecorView().getRootView());
                }
                return bitmap;
            }
            f = m19725e(((Activity) context).getWindow().getDecorView());
            bitmap = f;
        } catch (Throwable e) {
            mt.m19919b("Fail to capture screen shot", e);
        }
        return bitmap;
    }

    /* renamed from: i */
    public static int m19731i(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo == null ? 0 : applicationInfo.targetSdkVersion;
    }

    @TargetApi(16)
    /* renamed from: j */
    public static boolean m19732j(Context context) {
        if (context != null) {
            if (C2904o.d()) {
                KeyguardManager m = m19735m(context);
                if (m != null && m.isKeyguardLocked()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: k */
    public static boolean m19733k(android.content.Context r3) {
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
        r3 = r3.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x001b, Throwable -> 0x000b }
        r1 = "com.google.android.gms.ads.internal.ClientApi";	 Catch:{ ClassNotFoundException -> 0x001b, Throwable -> 0x000b }
        r3.loadClass(r1);	 Catch:{ ClassNotFoundException -> 0x001b, Throwable -> 0x000b }
        return r0;
    L_0x000b:
        r3 = move-exception;
        r1 = "Error loading class.";
        com.google.android.gms.internal.ads.mt.m19919b(r1, r3);
        r1 = com.google.android.gms.ads.internal.ax.i();
        r2 = "AdUtil.isLiteSdk";
        r1.m30834a(r3, r2);
        return r0;
    L_0x001b:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jw.k(android.content.Context):boolean");
    }

    /* renamed from: l */
    private static java.lang.String m19734l(android.content.Context r2) {
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
        r1 = "activity";	 Catch:{ Exception -> 0x002d }
        r2 = r2.getSystemService(r1);	 Catch:{ Exception -> 0x002d }
        r2 = (android.app.ActivityManager) r2;	 Catch:{ Exception -> 0x002d }
        if (r2 != 0) goto L_0x000c;	 Catch:{ Exception -> 0x002d }
    L_0x000b:
        return r0;	 Catch:{ Exception -> 0x002d }
    L_0x000c:
        r1 = 1;	 Catch:{ Exception -> 0x002d }
        r2 = r2.getRunningTasks(r1);	 Catch:{ Exception -> 0x002d }
        if (r2 == 0) goto L_0x002d;	 Catch:{ Exception -> 0x002d }
    L_0x0013:
        r1 = r2.isEmpty();	 Catch:{ Exception -> 0x002d }
        if (r1 != 0) goto L_0x002d;	 Catch:{ Exception -> 0x002d }
    L_0x0019:
        r1 = 0;	 Catch:{ Exception -> 0x002d }
        r2 = r2.get(r1);	 Catch:{ Exception -> 0x002d }
        r2 = (android.app.ActivityManager.RunningTaskInfo) r2;	 Catch:{ Exception -> 0x002d }
        if (r2 == 0) goto L_0x002d;	 Catch:{ Exception -> 0x002d }
    L_0x0022:
        r1 = r2.topActivity;	 Catch:{ Exception -> 0x002d }
        if (r1 == 0) goto L_0x002d;	 Catch:{ Exception -> 0x002d }
    L_0x0026:
        r2 = r2.topActivity;	 Catch:{ Exception -> 0x002d }
        r2 = r2.getClassName();	 Catch:{ Exception -> 0x002d }
        return r2;
    L_0x002d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jw.l(android.content.Context):java.lang.String");
    }

    /* renamed from: m */
    private static KeyguardManager m19735m(Context context) {
        Object systemService = context.getSystemService("keyguard");
        return (systemService == null || !(systemService instanceof KeyguardManager)) ? null : (KeyguardManager) systemService;
    }

    /* renamed from: a */
    public final JSONObject m19736a(Bundle bundle, JSONObject jSONObject) {
        if (bundle != null) {
            try {
                return m19695a(bundle);
            } catch (Throwable e) {
                mt.m19919b("Error converting Bundle to JSON", e);
            }
        }
        return null;
    }

    /* renamed from: a */
    public final JSONObject m19737a(Map<String, ?> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                m19703a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String str2 = "Could not convert map to JSON: ";
            String valueOf = String.valueOf(e.getMessage());
            throw new JSONException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }

    /* renamed from: a */
    public final void m19738a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(m19744b(context, str));
    }

    /* renamed from: a */
    public final void m19739a(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (z) {
            ax.e();
            bundle.putString("device", m19713b());
            bundle.putString("eids", TextUtils.join(",", asp.m18891a()));
        }
        aph.m18683a();
        mi.m19870a(context, str, str2, bundle, z, new jz(this, context, str));
    }

    /* renamed from: a */
    public final void m19740a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", m19744b(context, str));
        httpURLConnection.setUseCaches(false);
    }

    /* renamed from: a */
    public final void m19741a(Context context, List<String> list) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!TextUtils.isEmpty(agc.m18398a(activity))) {
                if (list == null) {
                    jn.m30864a("Cannot ping urls: empty list.");
                } else if (atn.m30191a(context)) {
                    atn atn = new atn();
                    atn.m30195a(new jx(this, list, atn, context));
                    atn.m30197b(activity);
                } else {
                    jn.m30864a("Cannot ping url because custom tabs is not supported");
                }
            }
        }
    }

    /* renamed from: a */
    public final boolean m19742a(View view, Context context) {
        Context applicationContext = context.getApplicationContext();
        return m19743a(view, applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null, m19735m(context));
    }

    /* renamed from: a */
    public final boolean m19743a(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        Object obj;
        Object obj2;
        if (!ax.e().f15693c) {
            if (keyguardManager == null ? false : keyguardManager.inKeyguardRestrictedInputMode()) {
                if (!((Boolean) aph.m18688f().m18889a(asp.bo)).booleanValue() || !m19719c(view)) {
                    obj = null;
                    if (view.getVisibility() == 0 && view.isShown()) {
                        if (powerManager != null) {
                            if (powerManager.isScreenOn()) {
                                obj2 = null;
                                if (!(obj2 == null || r6 == null)) {
                                    if (((Boolean) aph.m18688f().m18889a(asp.bm)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                                        return true;
                                    }
                                }
                            }
                        }
                        obj2 = 1;
                        if (((Boolean) aph.m18688f().m18889a(asp.bm)).booleanValue()) {
                        }
                        return true;
                    }
                    return false;
                }
            }
        }
        obj = 1;
        if (powerManager != null) {
            if (powerManager.isScreenOn()) {
                obj2 = null;
                if (((Boolean) aph.m18688f().m18889a(asp.bm)).booleanValue()) {
                }
                return true;
            }
        }
        obj2 = 1;
        if (((Boolean) aph.m18688f().m18889a(asp.bm)).booleanValue()) {
        }
        return true;
    }

    /* renamed from: b */
    public final java.lang.String m19744b(android.content.Context r5, java.lang.String r6) {
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
        r4 = this;
        r0 = r4.f15692b;
        monitor-enter(r0);
        r1 = r4.f15694d;	 Catch:{ all -> 0x00d2 }
        if (r1 == 0) goto L_0x000b;	 Catch:{ all -> 0x00d2 }
    L_0x0007:
        r5 = r4.f15694d;	 Catch:{ all -> 0x00d2 }
        monitor-exit(r0);	 Catch:{ all -> 0x00d2 }
        return r5;	 Catch:{ all -> 0x00d2 }
    L_0x000b:
        if (r6 != 0) goto L_0x0013;	 Catch:{ all -> 0x00d2 }
    L_0x000d:
        r5 = m19722d();	 Catch:{ all -> 0x00d2 }
        monitor-exit(r0);	 Catch:{ all -> 0x00d2 }
        return r5;
    L_0x0013:
        r1 = com.google.android.gms.ads.internal.ax.g();	 Catch:{ Exception -> 0x001d }
        r1 = r1.mo6868a(r5);	 Catch:{ Exception -> 0x001d }
        r4.f15694d = r1;	 Catch:{ Exception -> 0x001d }
    L_0x001d:
        r1 = r4.f15694d;	 Catch:{ all -> 0x00d2 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x00d2 }
        if (r1 == 0) goto L_0x006e;	 Catch:{ all -> 0x00d2 }
    L_0x0025:
        com.google.android.gms.internal.ads.aph.m18683a();	 Catch:{ all -> 0x00d2 }
        r1 = com.google.android.gms.internal.ads.mi.m19877b();	 Catch:{ all -> 0x00d2 }
        if (r1 != 0) goto L_0x0068;	 Catch:{ all -> 0x00d2 }
    L_0x002e:
        r1 = 0;	 Catch:{ all -> 0x00d2 }
        r4.f15694d = r1;	 Catch:{ all -> 0x00d2 }
        r1 = f15691a;	 Catch:{ all -> 0x00d2 }
        r2 = new com.google.android.gms.internal.ads.jy;	 Catch:{ all -> 0x00d2 }
        r2.<init>(r4, r5);	 Catch:{ all -> 0x00d2 }
        r1.post(r2);	 Catch:{ all -> 0x00d2 }
    L_0x003b:
        r1 = r4.f15694d;	 Catch:{ all -> 0x00d2 }
        if (r1 != 0) goto L_0x006e;
    L_0x003f:
        r1 = r4.f15692b;	 Catch:{ InterruptedException -> 0x0045 }
        r1.wait();	 Catch:{ InterruptedException -> 0x0045 }
        goto L_0x003b;
    L_0x0045:
        r1 = m19722d();	 Catch:{ all -> 0x00d2 }
        r4.f15694d = r1;	 Catch:{ all -> 0x00d2 }
        r1 = "Interrupted, use default user agent: ";	 Catch:{ all -> 0x00d2 }
        r2 = r4.f15694d;	 Catch:{ all -> 0x00d2 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x00d2 }
        r3 = r2.length();	 Catch:{ all -> 0x00d2 }
        if (r3 == 0) goto L_0x005e;	 Catch:{ all -> 0x00d2 }
    L_0x0059:
        r1 = r1.concat(r2);	 Catch:{ all -> 0x00d2 }
        goto L_0x0064;	 Catch:{ all -> 0x00d2 }
    L_0x005e:
        r2 = new java.lang.String;	 Catch:{ all -> 0x00d2 }
        r2.<init>(r1);	 Catch:{ all -> 0x00d2 }
        r1 = r2;	 Catch:{ all -> 0x00d2 }
    L_0x0064:
        com.google.android.gms.internal.ads.mt.m19924e(r1);	 Catch:{ all -> 0x00d2 }
        goto L_0x003b;	 Catch:{ all -> 0x00d2 }
    L_0x0068:
        r1 = m19723d(r5);	 Catch:{ all -> 0x00d2 }
        r4.f15694d = r1;	 Catch:{ all -> 0x00d2 }
    L_0x006e:
        r1 = r4.f15694d;	 Catch:{ all -> 0x00d2 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x00d2 }
        r2 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x00d2 }
        r2 = r2.length();	 Catch:{ all -> 0x00d2 }
        r2 = r2 + 10;	 Catch:{ all -> 0x00d2 }
        r3 = java.lang.String.valueOf(r6);	 Catch:{ all -> 0x00d2 }
        r3 = r3.length();	 Catch:{ all -> 0x00d2 }
        r2 = r2 + r3;	 Catch:{ all -> 0x00d2 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d2 }
        r3.<init>(r2);	 Catch:{ all -> 0x00d2 }
        r3.append(r1);	 Catch:{ all -> 0x00d2 }
        r1 = " (Mobile; ";	 Catch:{ all -> 0x00d2 }
        r3.append(r1);	 Catch:{ all -> 0x00d2 }
        r3.append(r6);	 Catch:{ all -> 0x00d2 }
        r6 = r3.toString();	 Catch:{ all -> 0x00d2 }
        r4.f15694d = r6;	 Catch:{ all -> 0x00d2 }
        r5 = com.google.android.gms.common.p180d.C2829c.a(r5);	 Catch:{ Exception -> 0x00b6 }
        r5 = r5.a();	 Catch:{ Exception -> 0x00b6 }
        if (r5 == 0) goto L_0x00c0;	 Catch:{ Exception -> 0x00b6 }
    L_0x00a7:
        r5 = r4.f15694d;	 Catch:{ Exception -> 0x00b6 }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x00b6 }
        r6 = ";aia";	 Catch:{ Exception -> 0x00b6 }
        r5 = r5.concat(r6);	 Catch:{ Exception -> 0x00b6 }
        r4.f15694d = r5;	 Catch:{ Exception -> 0x00b6 }
        goto L_0x00c0;
    L_0x00b6:
        r5 = move-exception;
        r6 = com.google.android.gms.ads.internal.ax.i();	 Catch:{ all -> 0x00d2 }
        r1 = "AdUtil.getUserAgent";	 Catch:{ all -> 0x00d2 }
        r6.m30834a(r5, r1);	 Catch:{ all -> 0x00d2 }
    L_0x00c0:
        r5 = r4.f15694d;	 Catch:{ all -> 0x00d2 }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ all -> 0x00d2 }
        r6 = ")";	 Catch:{ all -> 0x00d2 }
        r5 = r5.concat(r6);	 Catch:{ all -> 0x00d2 }
        r4.f15694d = r5;	 Catch:{ all -> 0x00d2 }
        r5 = r4.f15694d;	 Catch:{ all -> 0x00d2 }
        monitor-exit(r0);	 Catch:{ all -> 0x00d2 }
        return r5;	 Catch:{ all -> 0x00d2 }
    L_0x00d2:
        r5 = move-exception;	 Catch:{ all -> 0x00d2 }
        monitor-exit(r0);	 Catch:{ all -> 0x00d2 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jw.b(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public final void m19745b(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (((Boolean) aph.m18688f().m18889a(asp.br)).booleanValue()) {
            m19739a(context, str, str2, bundle, z);
        }
    }

    /* renamed from: b */
    public final boolean m19746b(Context context) {
        if (this.f15695e) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new kb(), intentFilter);
        this.f15695e = true;
        return true;
    }

    /* renamed from: b */
    public final int[] m19747b(Activity activity) {
        int[] a = m19710a(activity);
        r1 = new int[2];
        aph.m18683a();
        r1[0] = mi.m19874b((Context) activity, a[0]);
        aph.m18683a();
        r1[1] = mi.m19874b((Context) activity, a[1]);
        return r1;
    }

    /* renamed from: c */
    public final boolean m19748c(Context context) {
        if (this.f15696f) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver(new ka(), intentFilter);
        this.f15696f = true;
        return true;
    }

    /* renamed from: c */
    public final int[] m19749c(Activity activity) {
        Window window = activity.getWindow();
        int[] e = (window == null || window.findViewById(16908290) == null) ? m19726e() : new int[]{window.findViewById(16908290).getTop(), window.findViewById(16908290).getBottom()};
        r0 = new int[2];
        aph.m18683a();
        r0[0] = mi.m19874b((Context) activity, e[0]);
        aph.m18683a();
        r0[1] = mi.m19874b((Context) activity, e[1]);
        return r0;
    }

    /* renamed from: d */
    public final boolean m19750d(java.lang.String r4) {
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
        r3 = this;
        r0 = android.text.TextUtils.isEmpty(r4);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        monitor-enter(r3);	 Catch:{ PatternSyntaxException -> 0x0046 }
        r0 = r3.f15697g;	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x0025;	 Catch:{ all -> 0x0043 }
    L_0x000d:
        r0 = com.google.android.gms.internal.ads.asp.aq;	 Catch:{ all -> 0x0043 }
        r2 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ all -> 0x0043 }
        r0 = r2.m18889a(r0);	 Catch:{ all -> 0x0043 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0043 }
        r2 = r3.f15697g;	 Catch:{ all -> 0x0043 }
        r2 = r2.pattern();	 Catch:{ all -> 0x0043 }
        r0 = r0.equals(r2);	 Catch:{ all -> 0x0043 }
        if (r0 != 0) goto L_0x0037;	 Catch:{ all -> 0x0043 }
    L_0x0025:
        r0 = com.google.android.gms.internal.ads.asp.aq;	 Catch:{ all -> 0x0043 }
        r2 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ all -> 0x0043 }
        r0 = r2.m18889a(r0);	 Catch:{ all -> 0x0043 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0043 }
        r0 = java.util.regex.Pattern.compile(r0);	 Catch:{ all -> 0x0043 }
        r3.f15697g = r0;	 Catch:{ all -> 0x0043 }
    L_0x0037:
        r0 = r3.f15697g;	 Catch:{ all -> 0x0043 }
        r4 = r0.matcher(r4);	 Catch:{ all -> 0x0043 }
        r4 = r4.matches();	 Catch:{ all -> 0x0043 }
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
        return r4;	 Catch:{ all -> 0x0043 }
    L_0x0043:
        r4 = move-exception;	 Catch:{ all -> 0x0043 }
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
        throw r4;	 Catch:{ PatternSyntaxException -> 0x0046 }
    L_0x0046:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jw.d(java.lang.String):boolean");
    }

    /* renamed from: e */
    public final boolean m19751e(java.lang.String r4) {
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
        r3 = this;
        r0 = android.text.TextUtils.isEmpty(r4);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        monitor-enter(r3);	 Catch:{ PatternSyntaxException -> 0x0046 }
        r0 = r3.f15698h;	 Catch:{ all -> 0x0043 }
        if (r0 == 0) goto L_0x0025;	 Catch:{ all -> 0x0043 }
    L_0x000d:
        r0 = com.google.android.gms.internal.ads.asp.ar;	 Catch:{ all -> 0x0043 }
        r2 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ all -> 0x0043 }
        r0 = r2.m18889a(r0);	 Catch:{ all -> 0x0043 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0043 }
        r2 = r3.f15698h;	 Catch:{ all -> 0x0043 }
        r2 = r2.pattern();	 Catch:{ all -> 0x0043 }
        r0 = r0.equals(r2);	 Catch:{ all -> 0x0043 }
        if (r0 != 0) goto L_0x0037;	 Catch:{ all -> 0x0043 }
    L_0x0025:
        r0 = com.google.android.gms.internal.ads.asp.ar;	 Catch:{ all -> 0x0043 }
        r2 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ all -> 0x0043 }
        r0 = r2.m18889a(r0);	 Catch:{ all -> 0x0043 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0043 }
        r0 = java.util.regex.Pattern.compile(r0);	 Catch:{ all -> 0x0043 }
        r3.f15698h = r0;	 Catch:{ all -> 0x0043 }
    L_0x0037:
        r0 = r3.f15698h;	 Catch:{ all -> 0x0043 }
        r4 = r0.matcher(r4);	 Catch:{ all -> 0x0043 }
        r4 = r4.matches();	 Catch:{ all -> 0x0043 }
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
        return r4;	 Catch:{ all -> 0x0043 }
    L_0x0043:
        r4 = move-exception;	 Catch:{ all -> 0x0043 }
        monitor-exit(r3);	 Catch:{ all -> 0x0043 }
        throw r4;	 Catch:{ PatternSyntaxException -> 0x0046 }
    L_0x0046:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jw.e(java.lang.String):boolean");
    }
}
