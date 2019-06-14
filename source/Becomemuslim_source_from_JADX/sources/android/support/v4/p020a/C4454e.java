package android.support.v4.p020a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.v4.content.p027b.C0360a.C0359c;
import android.support.v4.content.p027b.C0360a.C3193b;
import android.support.v4.p031g.C0404b.C0402b;
import android.support.v4.util.C0463l;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: TypefaceCompatApi24Impl */
/* renamed from: android.support.v4.a.e */
class C4454e extends C3164g {
    /* renamed from: a */
    private static final Class f11899a;
    /* renamed from: b */
    private static final Constructor f11900b;
    /* renamed from: c */
    private static final Method f11901c;
    /* renamed from: d */
    private static final Method f11902d;

    C4454e() {
    }

    static {
        Class cls;
        Method method;
        Method method2;
        Constructor constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor constructor2 = cls.getConstructor(new Class[0]);
            method = cls.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE});
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            constructor = constructor2;
        } catch (Throwable e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method2 = cls;
            method = method2;
        }
        f11900b = constructor;
        f11899a = cls;
        f11901c = method;
        f11902d = method2;
    }

    /* renamed from: a */
    public static boolean m14870a() {
        if (f11901c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f11901c != null;
    }

    /* renamed from: b */
    private static Object m14872b() {
        try {
            return f11900b.newInstance(new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static boolean m14871a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f11901c.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), 0, Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        } catch (Object obj2) {
            throw new RuntimeException(obj2);
        }
    }

    /* renamed from: a */
    private static Typeface m14869a(Object obj) {
        try {
            Array.set(Array.newInstance(f11899a, 1), 0, obj);
            return (Typeface) f11902d.invoke(null, new Object[]{r0});
        } catch (Object obj2) {
            throw new RuntimeException(obj2);
        }
    }

    /* renamed from: a */
    public Typeface mo170a(Context context, CancellationSignal cancellationSignal, C0402b[] c0402bArr, int i) {
        Object b = C4454e.m14872b();
        C0463l c0463l = new C0463l();
        for (C0402b c0402b : c0402bArr) {
            Uri a = c0402b.m1188a();
            ByteBuffer byteBuffer = (ByteBuffer) c0463l.get(a);
            if (byteBuffer == null) {
                byteBuffer = C0271h.m746a(context, cancellationSignal, a);
                c0463l.put(a, byteBuffer);
            }
            if (!C4454e.m14871a(b, byteBuffer, c0402b.m1189b(), c0402b.m1190c(), c0402b.m1191d())) {
                return null;
            }
        }
        return Typeface.create(C4454e.m14869a(b), i);
    }

    /* renamed from: a */
    public Typeface mo171a(Context context, C3193b c3193b, Resources resources, int i) {
        i = C4454e.m14872b();
        for (C0359c c0359c : c3193b.m9665a()) {
            ByteBuffer a = C0271h.m745a(context, resources, c0359c.m1078d());
            if (a == null || !C4454e.m14871a(i, a, 0, c0359c.m1076b(), c0359c.m1077c())) {
                return null;
            }
        }
        return C4454e.m14869a(i);
    }
}
