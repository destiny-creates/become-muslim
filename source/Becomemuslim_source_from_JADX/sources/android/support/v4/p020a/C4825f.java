package android.support.v4.p020a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.support.v4.content.p027b.C0360a.C0359c;
import android.support.v4.content.p027b.C0360a.C3193b;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* compiled from: TypefaceCompatApi26Impl */
/* renamed from: android.support.v4.a.f */
public class C4825f extends C4453d {
    /* renamed from: a */
    private static final Class f13677a;
    /* renamed from: b */
    private static final Constructor f13678b;
    /* renamed from: c */
    private static final Method f13679c;
    /* renamed from: d */
    private static final Method f13680d;
    /* renamed from: e */
    private static final Method f13681e;
    /* renamed from: f */
    private static final Method f13682f;
    /* renamed from: g */
    private static final Method f13683g;

    static {
        Class cls;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method declaredMethod;
        Constructor constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor constructor2 = cls.getConstructor(new Class[0]);
            method = cls.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class});
            method2 = cls.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE});
            method3 = cls.getMethod("freeze", new Class[0]);
            method4 = cls.getMethod("abortCreation", new Class[0]);
            declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE});
            declaredMethod.setAccessible(true);
            constructor = constructor2;
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to collect necessary methods for class ");
            stringBuilder.append(e.getClass().getName());
            Log.e("TypefaceCompatApi26Impl", stringBuilder.toString(), e);
            cls = null;
            declaredMethod = cls;
            method = declaredMethod;
            method2 = method;
            method3 = method2;
            method4 = method3;
        }
        f13678b = constructor;
        f13677a = cls;
        f13679c = method;
        f13680d = method2;
        f13681e = method3;
        f13682f = method4;
        f13683g = declaredMethod;
    }

    /* renamed from: a */
    private static boolean m17112a() {
        if (f13679c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return f13679c != null;
    }

    /* renamed from: b */
    private static Object m17115b() {
        try {
            return f13678b.newInstance(new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static boolean m17113a(Context context, Object obj, String str, int i, int i2, int i3) {
        try {
            return ((Boolean) f13679c.invoke(obj, new Object[]{context.getAssets(), str, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), null})).booleanValue();
        } catch (Context context2) {
            throw new RuntimeException(context2);
        }
    }

    /* renamed from: a */
    private static boolean m17114a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) f13680d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), 0, Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        } catch (Object obj2) {
            throw new RuntimeException(obj2);
        }
    }

    /* renamed from: a */
    private static Typeface m17111a(Object obj) {
        try {
            Array.set(Array.newInstance(f13677a, 1), 0, obj);
            return (Typeface) f13683g.invoke(null, new Object[]{r0, Integer.valueOf(-1), Integer.valueOf(-1)});
        } catch (Object obj2) {
            throw new RuntimeException(obj2);
        }
    }

    /* renamed from: b */
    private static boolean m17116b(Object obj) {
        try {
            return ((Boolean) f13681e.invoke(obj, new Object[0])).booleanValue();
        } catch (Object obj2) {
            throw new RuntimeException(obj2);
        }
    }

    /* renamed from: c */
    private static void m17117c(Object obj) {
        try {
            f13682f.invoke(obj, new Object[0]);
        } catch (Object obj2) {
            throw new RuntimeException(obj2);
        }
    }

    /* renamed from: a */
    public Typeface mo171a(Context context, C3193b c3193b, Resources resources, int i) {
        if (!C4825f.m17112a()) {
            return super.mo171a(context, c3193b, resources, i);
        }
        resources = C4825f.m17115b();
        c3193b = c3193b.m9665a();
        i = c3193b.length;
        int i2 = 0;
        while (i2 < i) {
            C0359c c0359c = c3193b[i2];
            if (C4825f.m17113a(context, resources, c0359c.m1075a(), 0, c0359c.m1076b(), c0359c.m1077c())) {
                i2++;
            } else {
                C4825f.m17117c(resources);
                return null;
            }
        }
        if (C4825f.m17116b(resources) == null) {
            return null;
        }
        return C4825f.m17111a(resources);
    }

    /* renamed from: a */
    public android.graphics.Typeface mo170a(android.content.Context r10, android.os.CancellationSignal r11, android.support.v4.p031g.C0404b.C0402b[] r12, int r13) {
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
        r9 = this;
        r0 = r12.length;
        r1 = 1;
        r2 = 0;
        if (r0 >= r1) goto L_0x0006;
    L_0x0005:
        return r2;
    L_0x0006:
        r0 = android.support.v4.p020a.C4825f.m17112a();
        if (r0 != 0) goto L_0x0064;
    L_0x000c:
        r12 = r9.m9407a(r12, r13);
        r10 = r10.getContentResolver();
        r13 = r12.m1188a();	 Catch:{ IOException -> 0x0063 }
        r0 = "r";	 Catch:{ IOException -> 0x0063 }
        r10 = r10.openFileDescriptor(r13, r0, r11);	 Catch:{ IOException -> 0x0063 }
        if (r10 != 0) goto L_0x0026;	 Catch:{ IOException -> 0x0063 }
    L_0x0020:
        if (r10 == 0) goto L_0x0025;	 Catch:{ IOException -> 0x0063 }
    L_0x0022:
        r10.close();	 Catch:{ IOException -> 0x0063 }
    L_0x0025:
        return r2;
    L_0x0026:
        r11 = new android.graphics.Typeface$Builder;	 Catch:{ Throwable -> 0x004c, all -> 0x0049 }
        r13 = r10.getFileDescriptor();	 Catch:{ Throwable -> 0x004c, all -> 0x0049 }
        r11.<init>(r13);	 Catch:{ Throwable -> 0x004c, all -> 0x0049 }
        r13 = r12.m1190c();	 Catch:{ Throwable -> 0x004c, all -> 0x0049 }
        r11 = r11.setWeight(r13);	 Catch:{ Throwable -> 0x004c, all -> 0x0049 }
        r12 = r12.m1191d();	 Catch:{ Throwable -> 0x004c, all -> 0x0049 }
        r11 = r11.setItalic(r12);	 Catch:{ Throwable -> 0x004c, all -> 0x0049 }
        r11 = r11.build();	 Catch:{ Throwable -> 0x004c, all -> 0x0049 }
        if (r10 == 0) goto L_0x0048;
    L_0x0045:
        r10.close();	 Catch:{ IOException -> 0x0063 }
    L_0x0048:
        return r11;
    L_0x0049:
        r11 = move-exception;
        r12 = r2;
        goto L_0x0052;
    L_0x004c:
        r11 = move-exception;
        throw r11;	 Catch:{ all -> 0x004e }
    L_0x004e:
        r12 = move-exception;
        r8 = r12;
        r12 = r11;
        r11 = r8;
    L_0x0052:
        if (r10 == 0) goto L_0x0062;
    L_0x0054:
        if (r12 == 0) goto L_0x005f;
    L_0x0056:
        r10.close();	 Catch:{ Throwable -> 0x005a }
        goto L_0x0062;
    L_0x005a:
        r10 = move-exception;
        r12.addSuppressed(r10);	 Catch:{ IOException -> 0x0063 }
        goto L_0x0062;	 Catch:{ IOException -> 0x0063 }
    L_0x005f:
        r10.close();	 Catch:{ IOException -> 0x0063 }
    L_0x0062:
        throw r11;	 Catch:{ IOException -> 0x0063 }
    L_0x0063:
        return r2;
    L_0x0064:
        r10 = android.support.v4.p031g.C0404b.m1200a(r10, r12, r11);
        r11 = android.support.v4.p020a.C4825f.m17115b();
        r0 = r12.length;
        r3 = 0;
        r4 = 0;
    L_0x006f:
        if (r3 >= r0) goto L_0x009a;
    L_0x0071:
        r5 = r12[r3];
        r6 = r5.m1188a();
        r6 = r10.get(r6);
        r6 = (java.nio.ByteBuffer) r6;
        if (r6 != 0) goto L_0x0080;
    L_0x007f:
        goto L_0x0097;
    L_0x0080:
        r4 = r5.m1189b();
        r7 = r5.m1190c();
        r5 = r5.m1191d();
        r4 = android.support.v4.p020a.C4825f.m17114a(r11, r6, r4, r7, r5);
        if (r4 != 0) goto L_0x0096;
    L_0x0092:
        android.support.v4.p020a.C4825f.m17117c(r11);
        return r2;
    L_0x0096:
        r4 = 1;
    L_0x0097:
        r3 = r3 + 1;
        goto L_0x006f;
    L_0x009a:
        if (r4 != 0) goto L_0x00a0;
    L_0x009c:
        android.support.v4.p020a.C4825f.m17117c(r11);
        return r2;
    L_0x00a0:
        r10 = android.support.v4.p020a.C4825f.m17116b(r11);
        if (r10 != 0) goto L_0x00a7;
    L_0x00a6:
        return r2;
    L_0x00a7:
        r10 = android.support.v4.p020a.C4825f.m17111a(r11);
        r10 = android.graphics.Typeface.create(r10, r13);
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.f.a(android.content.Context, android.os.CancellationSignal, android.support.v4.g.b$b[], int):android.graphics.Typeface");
    }

    /* renamed from: a */
    public Typeface mo169a(Context context, Resources resources, int i, String str, int i2) {
        if (!C4825f.m17112a()) {
            return super.mo169a(context, resources, i, str, i2);
        }
        resources = C4825f.m17115b();
        if (C4825f.m17113a(context, resources, str, 0, -1, -1) == null) {
            C4825f.m17117c(resources);
            return null;
        } else if (C4825f.m17116b(resources) == null) {
            return null;
        } else {
            return C4825f.m17111a(resources);
        }
    }
}
