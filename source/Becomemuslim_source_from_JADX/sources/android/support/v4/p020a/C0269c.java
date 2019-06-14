package android.support.v4.p020a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.support.v4.content.p027b.C0360a.C3193b;
import android.support.v4.p031g.C0404b.C0402b;
import android.support.v4.util.C0453g;

/* compiled from: TypefaceCompat */
/* renamed from: android.support.v4.a.c */
public class C0269c {
    /* renamed from: a */
    private static final C0268a f671a;
    /* renamed from: b */
    private static final C0453g<String, Typeface> f672b = new C0453g(16);

    /* compiled from: TypefaceCompat */
    /* renamed from: android.support.v4.a.c$a */
    interface C0268a {
        /* renamed from: a */
        Typeface mo169a(Context context, Resources resources, int i, String str, int i2);

        /* renamed from: a */
        Typeface mo170a(Context context, CancellationSignal cancellationSignal, C0402b[] c0402bArr, int i);

        /* renamed from: a */
        Typeface mo171a(Context context, C3193b c3193b, Resources resources, int i);
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f671a = new C4825f();
        } else if (VERSION.SDK_INT >= 24 && C4454e.m14870a()) {
            f671a = new C4454e();
        } else if (VERSION.SDK_INT >= 21) {
            f671a = new C4453d();
        } else {
            f671a = new C3164g();
        }
    }

    /* renamed from: a */
    public static Typeface m740a(Resources resources, int i, int i2) {
        return (Typeface) f672b.m1423a(C0269c.m741b(resources, i, i2));
    }

    /* renamed from: b */
    private static String m741b(Resources resources, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(resources.getResourcePackageName(i));
        stringBuilder.append("-");
        stringBuilder.append(i);
        stringBuilder.append("-");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static android.graphics.Typeface m739a(android.content.Context r7, android.support.v4.content.p027b.C0360a.C0358a r8, android.content.res.Resources r9, int r10, int r11, android.support.v4.content.p027b.C0364b.C0363a r12, android.os.Handler r13, boolean r14) {
        /*
        r4 = r8 instanceof android.support.v4.content.p027b.C0360a.C3194d;
        if (r4 == 0) goto L_0x002d;
    L_0x0004:
        r0 = r8;
        r0 = (android.support.v4.content.p027b.C0360a.C3194d) r0;
        r4 = 0;
        r5 = 1;
        if (r14 == 0) goto L_0x0013;
    L_0x000b:
        r6 = r0.m9667b();
        if (r6 != 0) goto L_0x0016;
    L_0x0011:
        r4 = 1;
        goto L_0x0016;
    L_0x0013:
        if (r12 != 0) goto L_0x0016;
    L_0x0015:
        goto L_0x0011;
    L_0x0016:
        if (r14 == 0) goto L_0x001e;
    L_0x0018:
        r1 = r0.m9668c();
        r5 = r1;
        goto L_0x0020;
    L_0x001e:
        r1 = -1;
        r5 = -1;
    L_0x0020:
        r1 = r0.m9666a();
        r0 = r7;
        r2 = r12;
        r3 = r13;
        r6 = r11;
        r0 = android.support.v4.p031g.C0404b.m1194a(r0, r1, r2, r3, r4, r5, r6);
        goto L_0x0042;
    L_0x002d:
        r1 = f671a;
        r0 = r8;
        r0 = (android.support.v4.content.p027b.C0360a.C3193b) r0;
        r0 = r1.mo171a(r7, r0, r9, r11);
        if (r12 == 0) goto L_0x0042;
    L_0x0038:
        if (r0 == 0) goto L_0x003e;
    L_0x003a:
        r12.m1089a(r0, r13);
        goto L_0x0042;
    L_0x003e:
        r1 = -3;
        r12.m1087a(r1, r13);
    L_0x0042:
        if (r0 == 0) goto L_0x004d;
    L_0x0044:
        r1 = f672b;
        r2 = android.support.v4.p020a.C0269c.m741b(r9, r10, r11);
        r1.m1424a(r2, r0);
    L_0x004d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.c.a(android.content.Context, android.support.v4.content.b.a$a, android.content.res.Resources, int, int, android.support.v4.content.b.b$a, android.os.Handler, boolean):android.graphics.Typeface");
    }

    /* renamed from: a */
    public static Typeface m737a(Context context, Resources resources, int i, String str, int i2) {
        context = f671a.mo169a(context, resources, i, str, i2);
        if (context != null) {
            f672b.m1424a(C0269c.m741b(resources, i, i2), context);
        }
        return context;
    }

    /* renamed from: a */
    public static Typeface m738a(Context context, CancellationSignal cancellationSignal, C0402b[] c0402bArr, int i) {
        return f671a.mo170a(context, cancellationSignal, c0402bArr, i);
    }
}
