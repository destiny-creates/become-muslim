package com.google.android.gms.internal.ads;

import android.support.v7.widget.LinearLayoutManager;
import java.lang.reflect.Field;

final class adn {
    /* renamed from: A */
    private int f14278A;
    /* renamed from: B */
    private int f14279B;
    /* renamed from: C */
    private Field f14280C;
    /* renamed from: D */
    private Object f14281D;
    /* renamed from: E */
    private Object f14282E;
    /* renamed from: F */
    private Object f14283F;
    /* renamed from: a */
    private final ado f14284a;
    /* renamed from: b */
    private final Object[] f14285b;
    /* renamed from: c */
    private Class<?> f14286c;
    /* renamed from: d */
    private final int f14287d;
    /* renamed from: e */
    private final int f14288e;
    /* renamed from: f */
    private final int f14289f;
    /* renamed from: g */
    private final int f14290g;
    /* renamed from: h */
    private final int f14291h;
    /* renamed from: i */
    private final int f14292i;
    /* renamed from: j */
    private final int f14293j;
    /* renamed from: k */
    private final int f14294k;
    /* renamed from: l */
    private final int f14295l;
    /* renamed from: m */
    private final int f14296m;
    /* renamed from: n */
    private final int[] f14297n;
    /* renamed from: o */
    private int f14298o;
    /* renamed from: p */
    private int f14299p;
    /* renamed from: q */
    private int f14300q = Integer.MAX_VALUE;
    /* renamed from: r */
    private int f14301r = LinearLayoutManager.INVALID_OFFSET;
    /* renamed from: s */
    private int f14302s = 0;
    /* renamed from: t */
    private int f14303t = 0;
    /* renamed from: u */
    private int f14304u = 0;
    /* renamed from: v */
    private int f14305v = 0;
    /* renamed from: w */
    private int f14306w = 0;
    /* renamed from: x */
    private int f14307x;
    /* renamed from: y */
    private int f14308y;
    /* renamed from: z */
    private int f14309z;

    adn(Class<?> cls, String str, Object[] objArr) {
        this.f14286c = cls;
        this.f14284a = new ado(str);
        this.f14285b = objArr;
        this.f14287d = this.f14284a.m18039b();
        this.f14288e = this.f14284a.m18039b();
        int[] iArr = null;
        if (this.f14288e == 0) {
            this.f14289f = 0;
            this.f14290g = 0;
            this.f14291h = 0;
            this.f14292i = 0;
            this.f14293j = 0;
            this.f14295l = 0;
            this.f14294k = 0;
            this.f14296m = 0;
            this.f14297n = null;
            return;
        }
        this.f14289f = this.f14284a.m18039b();
        this.f14290g = this.f14284a.m18039b();
        this.f14291h = this.f14284a.m18039b();
        this.f14292i = this.f14284a.m18039b();
        this.f14295l = this.f14284a.m18039b();
        this.f14294k = this.f14284a.m18039b();
        this.f14293j = this.f14284a.m18039b();
        this.f14296m = this.f14284a.m18039b();
        int b = this.f14284a.m18039b();
        if (b != 0) {
            iArr = new int[b];
        }
        this.f14297n = iArr;
        this.f14298o = (this.f14289f << 1) + this.f14290g;
    }

    /* renamed from: a */
    private static java.lang.reflect.Field m18012a(java.lang.Class<?> r5, java.lang.String r6) {
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
        r0 = r5.getDeclaredField(r6);	 Catch:{ NoSuchFieldException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = r5.getDeclaredFields();
        r1 = r0.length;
        r2 = 0;
    L_0x000b:
        if (r2 >= r1) goto L_0x001d;
    L_0x000d:
        r3 = r0[r2];
        r4 = r3.getName();
        r4 = r6.equals(r4);
        if (r4 == 0) goto L_0x001a;
    L_0x0019:
        return r3;
    L_0x001a:
        r2 = r2 + 1;
        goto L_0x000b;
    L_0x001d:
        r1 = new java.lang.RuntimeException;
        r5 = r5.getName();
        r0 = java.util.Arrays.toString(r0);
        r2 = java.lang.String.valueOf(r6);
        r2 = r2.length();
        r2 = r2 + 40;
        r3 = java.lang.String.valueOf(r5);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = java.lang.String.valueOf(r0);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Field ";
        r3.append(r2);
        r3.append(r6);
        r6 = " for ";
        r3.append(r6);
        r3.append(r5);
        r5 = " not found. Known fields are ";
        r3.append(r5);
        r3.append(r0);
        r5 = r3.toString();
        r1.<init>(r5);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.adn.a(java.lang.Class, java.lang.String):java.lang.reflect.Field");
    }

    /* renamed from: p */
    private final Object m18021p() {
        Object[] objArr = this.f14285b;
        int i = this.f14298o;
        this.f14298o = i + 1;
        return objArr[i];
    }

    /* renamed from: q */
    private final boolean m18022q() {
        return (this.f14287d & 1) == 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    final boolean m18023a() {
        /*
        r5 = this;
        r0 = r5.f14284a;
        r0 = r0.m18038a();
        r1 = 0;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r0 = r5.f14284a;
        r0 = r0.m18039b();
        r5.f14307x = r0;
        r0 = r5.f14284a;
        r0 = r0.m18039b();
        r5.f14308y = r0;
        r0 = r5.f14308y;
        r0 = r0 & 255;
        r5.f14309z = r0;
        r0 = r5.f14307x;
        r2 = r5.f14300q;
        if (r0 >= r2) goto L_0x002a;
    L_0x0026:
        r0 = r5.f14307x;
        r5.f14300q = r0;
    L_0x002a:
        r0 = r5.f14307x;
        r2 = r5.f14301r;
        if (r0 <= r2) goto L_0x0034;
    L_0x0030:
        r0 = r5.f14307x;
        r5.f14301r = r0;
    L_0x0034:
        r0 = r5.f14309z;
        r2 = com.google.android.gms.internal.ads.abl.MAP;
        r2 = r2.m17928a();
        r3 = 1;
        if (r0 != r2) goto L_0x0045;
    L_0x003f:
        r0 = r5.f14302s;
        r0 = r0 + r3;
        r5.f14302s = r0;
        goto L_0x005e;
    L_0x0045:
        r0 = r5.f14309z;
        r2 = com.google.android.gms.internal.ads.abl.DOUBLE_LIST;
        r2 = r2.m17928a();
        if (r0 < r2) goto L_0x005e;
    L_0x004f:
        r0 = r5.f14309z;
        r2 = com.google.android.gms.internal.ads.abl.GROUP_LIST;
        r2 = r2.m17928a();
        if (r0 > r2) goto L_0x005e;
    L_0x0059:
        r0 = r5.f14303t;
        r0 = r0 + r3;
        r5.f14303t = r0;
    L_0x005e:
        r0 = r5.f14306w;
        r0 = r0 + r3;
        r5.f14306w = r0;
        r0 = r5.f14300q;
        r2 = r5.f14307x;
        r4 = r5.f14306w;
        r0 = com.google.android.gms.internal.ads.ads.m18109a(r0, r2, r4);
        if (r0 == 0) goto L_0x007c;
    L_0x006f:
        r0 = r5.f14307x;
        r0 = r0 + r3;
        r5.f14305v = r0;
        r0 = r5.f14305v;
        r2 = r5.f14300q;
        r0 = r0 - r2;
    L_0x0079:
        r5.f14304u = r0;
        goto L_0x0080;
    L_0x007c:
        r0 = r5.f14304u;
        r0 = r0 + r3;
        goto L_0x0079;
    L_0x0080:
        r0 = r5.f14308y;
        r0 = r0 & 1024;
        if (r0 == 0) goto L_0x0088;
    L_0x0086:
        r0 = 1;
        goto L_0x0089;
    L_0x0088:
        r0 = 0;
    L_0x0089:
        if (r0 == 0) goto L_0x0097;
    L_0x008b:
        r0 = r5.f14297n;
        r2 = r5.f14299p;
        r4 = r2 + 1;
        r5.f14299p = r4;
        r4 = r5.f14307x;
        r0[r2] = r4;
    L_0x0097:
        r0 = 0;
        r5.f14281D = r0;
        r5.f14282E = r0;
        r5.f14283F = r0;
        r0 = r5.m18026d();
        if (r0 == 0) goto L_0x00e7;
    L_0x00a4:
        r0 = r5.f14284a;
        r0 = r0.m18039b();
        r5.f14278A = r0;
        r0 = r5.f14309z;
        r1 = com.google.android.gms.internal.ads.abl.MESSAGE;
        r1 = r1.m17928a();
        r1 = r1 + 51;
        if (r0 == r1) goto L_0x00df;
    L_0x00b8:
        r0 = r5.f14309z;
        r1 = com.google.android.gms.internal.ads.abl.GROUP;
        r1 = r1.m17928a();
        r1 = r1 + 51;
        if (r0 != r1) goto L_0x00c5;
    L_0x00c4:
        goto L_0x00df;
    L_0x00c5:
        r0 = r5.f14309z;
        r1 = com.google.android.gms.internal.ads.abl.ENUM;
        r1 = r1.m17928a();
        r1 = r1 + 51;
        if (r0 != r1) goto L_0x0177;
    L_0x00d1:
        r0 = r5.m18022q();
        if (r0 == 0) goto L_0x0177;
    L_0x00d7:
        r0 = r5.m18021p();
        r5.f14282E = r0;
        goto L_0x0177;
    L_0x00df:
        r0 = r5.m18021p();
    L_0x00e3:
        r5.f14281D = r0;
        goto L_0x0177;
    L_0x00e7:
        r0 = r5.f14286c;
        r2 = r5.m18021p();
        r2 = (java.lang.String) r2;
        r0 = m18012a(r0, r2);
        r5.f14280C = r0;
        r0 = r5.m18030h();
        if (r0 == 0) goto L_0x0103;
    L_0x00fb:
        r0 = r5.f14284a;
        r0 = r0.m18039b();
        r5.f14279B = r0;
    L_0x0103:
        r0 = r5.f14309z;
        r2 = com.google.android.gms.internal.ads.abl.MESSAGE;
        r2 = r2.m17928a();
        if (r0 == r2) goto L_0x016f;
    L_0x010d:
        r0 = r5.f14309z;
        r2 = com.google.android.gms.internal.ads.abl.GROUP;
        r2 = r2.m17928a();
        if (r0 != r2) goto L_0x0118;
    L_0x0117:
        goto L_0x016f;
    L_0x0118:
        r0 = r5.f14309z;
        r2 = com.google.android.gms.internal.ads.abl.MESSAGE_LIST;
        r2 = r2.m17928a();
        if (r0 == r2) goto L_0x00df;
    L_0x0122:
        r0 = r5.f14309z;
        r2 = com.google.android.gms.internal.ads.abl.GROUP_LIST;
        r2 = r2.m17928a();
        if (r0 != r2) goto L_0x012d;
    L_0x012c:
        goto L_0x00df;
    L_0x012d:
        r0 = r5.f14309z;
        r2 = com.google.android.gms.internal.ads.abl.ENUM;
        r2 = r2.m17928a();
        if (r0 == r2) goto L_0x0167;
    L_0x0137:
        r0 = r5.f14309z;
        r2 = com.google.android.gms.internal.ads.abl.ENUM_LIST;
        r2 = r2.m17928a();
        if (r0 == r2) goto L_0x0167;
    L_0x0141:
        r0 = r5.f14309z;
        r2 = com.google.android.gms.internal.ads.abl.ENUM_LIST_PACKED;
        r2 = r2.m17928a();
        if (r0 != r2) goto L_0x014c;
    L_0x014b:
        goto L_0x0167;
    L_0x014c:
        r0 = r5.f14309z;
        r2 = com.google.android.gms.internal.ads.abl.MAP;
        r2 = r2.m17928a();
        if (r0 != r2) goto L_0x0177;
    L_0x0156:
        r0 = r5.m18021p();
        r5.f14283F = r0;
        r0 = r5.f14308y;
        r0 = r0 & 2048;
        if (r0 == 0) goto L_0x0163;
    L_0x0162:
        r1 = 1;
    L_0x0163:
        if (r1 == 0) goto L_0x0177;
    L_0x0165:
        goto L_0x00d7;
    L_0x0167:
        r0 = r5.m18022q();
        if (r0 == 0) goto L_0x0177;
    L_0x016d:
        goto L_0x00d7;
    L_0x016f:
        r0 = r5.f14280C;
        r0 = r0.getType();
        goto L_0x00e3;
    L_0x0177:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.adn.a():boolean");
    }

    /* renamed from: b */
    final int m18024b() {
        return this.f14307x;
    }

    /* renamed from: c */
    final int m18025c() {
        return this.f14309z;
    }

    /* renamed from: d */
    final boolean m18026d() {
        return this.f14309z > abl.MAP.m17928a();
    }

    /* renamed from: e */
    final Field m18027e() {
        int i = this.f14278A << 1;
        Object obj = this.f14285b[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field a = m18012a(this.f14286c, (String) obj);
        this.f14285b[i] = a;
        return a;
    }

    /* renamed from: f */
    final Field m18028f() {
        int i = (this.f14278A << 1) + 1;
        Object obj = this.f14285b[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field a = m18012a(this.f14286c, (String) obj);
        this.f14285b[i] = a;
        return a;
    }

    /* renamed from: g */
    final Field m18029g() {
        return this.f14280C;
    }

    /* renamed from: h */
    final boolean m18030h() {
        return m18022q() && this.f14309z <= abl.GROUP.m17928a();
    }

    /* renamed from: i */
    final Field m18031i() {
        int i = (this.f14289f << 1) + (this.f14279B / 32);
        Object obj = this.f14285b[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field a = m18012a(this.f14286c, (String) obj);
        this.f14285b[i] = a;
        return a;
    }

    /* renamed from: j */
    final int m18032j() {
        return this.f14279B % 32;
    }

    /* renamed from: k */
    final boolean m18033k() {
        return (this.f14308y & 256) != 0;
    }

    /* renamed from: l */
    final boolean m18034l() {
        return (this.f14308y & 512) != 0;
    }

    /* renamed from: m */
    final Object m18035m() {
        return this.f14281D;
    }

    /* renamed from: n */
    final Object m18036n() {
        return this.f14282E;
    }

    /* renamed from: o */
    final Object m18037o() {
        return this.f14283F;
    }
}
