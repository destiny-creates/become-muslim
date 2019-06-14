package com.facebook.ads.internal.p105q.p106a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import java.util.concurrent.Executors;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.facebook.ads.internal.q.a.e */
public class C1499e {
    /* renamed from: a */
    public static volatile C1498a f4435a = C1498a.NOT_INITIALIZED;
    /* renamed from: b */
    private static int f4436b = -1;

    /* renamed from: com.facebook.ads.internal.q.a.e$a */
    enum C1498a {
        NOT_INITIALIZED,
        INITIALIZING,
        INITIALIZED
    }

    /* renamed from: a */
    public static int m5273a(XmlPullParser xmlPullParser) {
        while (true) {
            int i = 0;
            if (xmlPullParser.next() == 1) {
                return 0;
            }
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("uses-sdk")) {
                while (i < xmlPullParser.getAttributeCount()) {
                    if (xmlPullParser.getAttributeName(i).equals("minSdkVersion")) {
                        return Integer.parseInt(xmlPullParser.getAttributeValue(i));
                    }
                    i++;
                }
                continue;
            }
        }
    }

    /* renamed from: a */
    public static void m5274a(Context context) {
        if (!C1499e.m5275a()) {
            C1499e.m5279e(context);
        }
    }

    /* renamed from: a */
    public static boolean m5275a() {
        return f4435a == C1498a.INITIALIZED;
    }

    /* renamed from: b */
    public static int m5276b(Context context) {
        if (f4435a == C1498a.NOT_INITIALIZED) {
            C1499e.m5274a(context);
        }
        return f4436b;
    }

    /* renamed from: c */
    public static int m5277c(android.content.Context r1) {
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
        r1 = r1.getAssets();	 Catch:{ XmlPullParserException -> 0x000f, XmlPullParserException -> 0x000f }
        r0 = "AndroidManifest.xml";	 Catch:{ XmlPullParserException -> 0x000f, XmlPullParserException -> 0x000f }
        r1 = r1.openXmlResourceParser(r0);	 Catch:{ XmlPullParserException -> 0x000f, XmlPullParserException -> 0x000f }
        r1 = com.facebook.ads.internal.p105q.p106a.C1499e.m5273a(r1);	 Catch:{ XmlPullParserException -> 0x000f, XmlPullParserException -> 0x000f }
        return r1;
    L_0x000f:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.q.a.e.c(android.content.Context):int");
    }

    /* renamed from: e */
    private static void m5279e(final Context context) {
        if (f4435a == C1498a.NOT_INITIALIZED) {
            f4435a = C1498a.INITIALIZING;
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                public void run() {
                    if (C1499e.f4435a != C1498a.INITIALIZED) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("FBAdPrefs", 0);
                        int i = sharedPreferences.getInt("AppMinSdkVersion", -1);
                        if (i != -1) {
                            C1499e.f4436b = i;
                        } else {
                            i = VERSION.SDK_INT >= 24 ? C1499e.m5280f(context) : C1499e.m5277c(context);
                            C1499e.f4436b = i;
                            sharedPreferences.edit().putInt("AppMinSdkVersion", i).commit();
                        }
                        C1499e.f4435a = C1498a.INITIALIZED;
                    }
                }
            });
        }
    }

    /* renamed from: f */
    private static int m5280f(android.content.Context r2) {
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
        r1 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0010 }
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x0010 }
        r2 = r1.getApplicationInfo(r2, r0);	 Catch:{ NameNotFoundException -> 0x0010 }
        r2 = r2.minSdkVersion;	 Catch:{ NameNotFoundException -> 0x0010 }
        return r2;
    L_0x0010:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.q.a.e.f(android.content.Context):int");
    }
}
