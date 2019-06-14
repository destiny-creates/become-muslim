package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.ct */
public final class ct extends jb<ct> {
    /* renamed from: o */
    private static volatile ct[] f28856o;
    /* renamed from: a */
    public int f28857a;
    /* renamed from: b */
    public String f28858b;
    /* renamed from: c */
    public ct[] f28859c;
    /* renamed from: d */
    public ct[] f28860d;
    /* renamed from: e */
    public ct[] f28861e;
    /* renamed from: f */
    public String f28862f;
    /* renamed from: g */
    public String f28863g;
    /* renamed from: h */
    public long f28864h;
    /* renamed from: i */
    public boolean f28865i;
    /* renamed from: j */
    public ct[] f28866j;
    /* renamed from: k */
    public int[] f28867k;
    /* renamed from: l */
    public boolean f28868l;

    /* renamed from: a */
    private static int m37801a(int i) {
        if (i > 0 && i <= 17) {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder(40);
        stringBuilder.append(i);
        stringBuilder.append(" is not a valid enum Escaping");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: b */
    public static ct[] m37803b() {
        if (f28856o == null) {
            synchronized (jf.f16791b) {
                if (f28856o == null) {
                    f28856o = new ct[0];
                }
            }
        }
        return f28856o;
    }

    public ct() {
        this.f28857a = 1;
        this.f28858b = "";
        this.f28859c = ct.m37803b();
        this.f28860d = ct.m37803b();
        this.f28861e = ct.m37803b();
        this.f28862f = "";
        this.f28863g = "";
        this.f28864h = 0;
        this.f28865i = false;
        this.f28866j = ct.m37803b();
        this.f28867k = jk.f16796a;
        this.f28868l = false;
        this.m = null;
        this.n = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ct)) {
            return false;
        }
        ct ctVar = (ct) obj;
        if (this.f28857a != ctVar.f28857a) {
            return false;
        }
        if (this.f28858b == null) {
            if (ctVar.f28858b != null) {
                return false;
            }
        } else if (!this.f28858b.equals(ctVar.f28858b)) {
            return false;
        }
        if (!jf.m21004a(this.f28859c, ctVar.f28859c) || !jf.m21004a(this.f28860d, ctVar.f28860d) || !jf.m21004a(this.f28861e, ctVar.f28861e)) {
            return false;
        }
        if (this.f28862f == null) {
            if (ctVar.f28862f != null) {
                return false;
            }
        } else if (!this.f28862f.equals(ctVar.f28862f)) {
            return false;
        }
        if (this.f28863g == null) {
            if (ctVar.f28863g != null) {
                return false;
            }
        } else if (!this.f28863g.equals(ctVar.f28863g)) {
            return false;
        }
        if (this.f28864h != ctVar.f28864h || this.f28865i != ctVar.f28865i || !jf.m21004a(this.f28866j, ctVar.f28866j) || !jf.m21003a(this.f28867k, ctVar.f28867k) || this.f28868l != ctVar.f28868l) {
            return false;
        }
        if (this.m != null) {
            if (!this.m.m20993b()) {
                return this.m.equals(ctVar.m);
            }
        }
        if (ctVar.m != null) {
            if (ctVar.m.m20993b() == null) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int i2 = 1237;
        int hashCode = (((((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + this.f28857a) * 31) + (this.f28858b == null ? 0 : this.f28858b.hashCode())) * 31) + jf.m21001a(this.f28859c)) * 31) + jf.m21001a(this.f28860d)) * 31) + jf.m21001a(this.f28861e)) * 31) + (this.f28862f == null ? 0 : this.f28862f.hashCode())) * 31) + (this.f28863g == null ? 0 : this.f28863g.hashCode())) * 31) + ((int) (this.f28864h ^ (this.f28864h >>> 32)))) * 31) + (this.f28865i ? 1231 : 1237)) * 31) + jf.m21001a(this.f28866j)) * 31) + jf.m21000a(this.f28867k)) * 31;
        if (this.f28868l) {
            i2 = 1231;
        }
        hashCode = (hashCode + i2) * 31;
        if (this.m != null) {
            if (!this.m.m20993b()) {
                i = this.m.hashCode();
            }
        }
        return hashCode + i;
    }

    /* renamed from: a */
    public final void mo4622a(iz izVar) {
        izVar.m20971a(1, this.f28857a);
        if (!(this.f28858b == null || this.f28858b.equals(""))) {
            izVar.m20975a(2, this.f28858b);
        }
        if (this.f28859c != null && this.f28859c.length > 0) {
            for (jh jhVar : this.f28859c) {
                if (jhVar != null) {
                    izVar.m20974a(3, jhVar);
                }
            }
        }
        if (this.f28860d != null && this.f28860d.length > 0) {
            for (jh jhVar2 : this.f28860d) {
                if (jhVar2 != null) {
                    izVar.m20974a(4, jhVar2);
                }
            }
        }
        if (this.f28861e != null && this.f28861e.length > 0) {
            for (jh jhVar22 : this.f28861e) {
                if (jhVar22 != null) {
                    izVar.m20974a(5, jhVar22);
                }
            }
        }
        if (!(this.f28862f == null || this.f28862f.equals(""))) {
            izVar.m20975a(6, this.f28862f);
        }
        if (!(this.f28863g == null || this.f28863g.equals(""))) {
            izVar.m20975a(7, this.f28863g);
        }
        if (this.f28864h != 0) {
            izVar.m20972a(8, this.f28864h);
        }
        if (this.f28868l) {
            izVar.m20976a(9, this.f28868l);
        }
        if (this.f28867k != null && this.f28867k.length > 0) {
            for (int a : this.f28867k) {
                izVar.m20971a(10, a);
            }
        }
        if (this.f28866j != null && this.f28866j.length > 0) {
            for (jh jhVar3 : this.f28866j) {
                if (jhVar3 != null) {
                    izVar.m20974a(11, jhVar3);
                }
            }
        }
        if (this.f28865i) {
            izVar.m20976a(12, this.f28865i);
        }
        super.mo4622a(izVar);
    }

    /* renamed from: a */
    protected final int mo4621a() {
        int i;
        int a = super.mo4621a() + iz.m20963b(1, this.f28857a);
        if (!(this.f28858b == null || this.f28858b.equals(""))) {
            a += iz.m20966b(2, this.f28858b);
        }
        if (this.f28859c != null && this.f28859c.length > 0) {
            i = a;
            for (jh jhVar : this.f28859c) {
                if (jhVar != null) {
                    i += iz.m20965b(3, jhVar);
                }
            }
            a = i;
        }
        if (this.f28860d != null && this.f28860d.length > 0) {
            i = a;
            for (jh jhVar2 : this.f28860d) {
                if (jhVar2 != null) {
                    i += iz.m20965b(4, jhVar2);
                }
            }
            a = i;
        }
        if (this.f28861e != null && this.f28861e.length > 0) {
            i = a;
            for (jh jhVar22 : this.f28861e) {
                if (jhVar22 != null) {
                    i += iz.m20965b(5, jhVar22);
                }
            }
            a = i;
        }
        if (!(this.f28862f == null || this.f28862f.equals(""))) {
            a += iz.m20966b(6, this.f28862f);
        }
        if (!(this.f28863g == null || this.f28863g.equals(""))) {
            a += iz.m20966b(7, this.f28863g);
        }
        if (this.f28864h != 0) {
            a += iz.m20964b(8, this.f28864h);
        }
        if (this.f28868l) {
            a += iz.m20962b(9) + 1;
        }
        if (this.f28867k != null && this.f28867k.length > 0) {
            int i2 = 0;
            for (int a2 : this.f28867k) {
                i2 += iz.m20955a(a2);
            }
            a = (a + i2) + (this.f28867k.length * 1);
        }
        if (this.f28866j != null && this.f28866j.length > 0) {
            for (jh jhVar3 : this.f28866j) {
                if (jhVar3 != null) {
                    a += iz.m20965b(11, jhVar3);
                }
            }
        }
        return this.f28865i ? a + (iz.m20962b(12) + 1) : a;
    }

    /* renamed from: b */
    private final com.google.android.gms.internal.p210i.ct m37802b(com.google.android.gms.internal.p210i.iy r9) {
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
        r8 = this;
    L_0x0000:
        r0 = r9.m20937a();
        r1 = 80;
        r2 = 0;
        switch(r0) {
            case 0: goto L_0x021d;
            case 8: goto L_0x01ea;
            case 18: goto L_0x01e2;
            case 26: goto L_0x01a2;
            case 34: goto L_0x0162;
            case 42: goto L_0x0122;
            case 50: goto L_0x011a;
            case 58: goto L_0x0112;
            case 64: goto L_0x010a;
            case 72: goto L_0x0102;
            case 80: goto L_0x00b3;
            case 82: goto L_0x0057;
            case 90: goto L_0x0018;
            case 96: goto L_0x0011;
            default: goto L_0x000a;
        };
    L_0x000a:
        r0 = super.m31766a(r9, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x0010:
        return r8;
    L_0x0011:
        r0 = r9.m20944b();
        r8.f28865i = r0;
        goto L_0x0000;
    L_0x0018:
        r0 = 90;
        r0 = com.google.android.gms.internal.p210i.jk.m21021a(r9, r0);
        r1 = r8.f28866j;
        if (r1 != 0) goto L_0x0024;
    L_0x0022:
        r1 = 0;
        goto L_0x0027;
    L_0x0024:
        r1 = r8.f28866j;
        r1 = r1.length;
    L_0x0027:
        r0 = r0 + r1;
        r0 = new com.google.android.gms.internal.p210i.ct[r0];
        if (r1 == 0) goto L_0x0031;
    L_0x002c:
        r3 = r8.f28866j;
        java.lang.System.arraycopy(r3, r2, r0, r2, r1);
    L_0x0031:
        r2 = r0.length;
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x0048;
    L_0x0036:
        r2 = new com.google.android.gms.internal.i.ct;
        r2.<init>();
        r0[r1] = r2;
        r2 = r0[r1];
        r9.m20940a(r2);
        r9.m20937a();
        r1 = r1 + 1;
        goto L_0x0031;
    L_0x0048:
        r2 = new com.google.android.gms.internal.i.ct;
        r2.<init>();
        r0[r1] = r2;
        r1 = r0[r1];
        r9.m20940a(r1);
        r8.f28866j = r0;
        goto L_0x0000;
    L_0x0057:
        r0 = r9.m20948d();
        r0 = r9.m20946c(r0);
        r3 = r9.m20954h();
        r4 = 0;
    L_0x0064:
        r5 = r9.m20953g();
        if (r5 <= 0) goto L_0x0076;
    L_0x006a:
        r5 = r9.m20948d();	 Catch:{ IllegalArgumentException -> 0x0074 }
        com.google.android.gms.internal.p210i.ct.m37801a(r5);	 Catch:{ IllegalArgumentException -> 0x0074 }
        r4 = r4 + 1;
        goto L_0x0064;
        goto L_0x0064;
    L_0x0076:
        if (r4 == 0) goto L_0x00ae;
    L_0x0078:
        r9.m20951e(r3);
        r3 = r8.f28867k;
        if (r3 != 0) goto L_0x0081;
    L_0x007f:
        r3 = 0;
        goto L_0x0084;
    L_0x0081:
        r3 = r8.f28867k;
        r3 = r3.length;
    L_0x0084:
        r4 = r4 + r3;
        r4 = new int[r4];
        if (r3 == 0) goto L_0x008e;
    L_0x0089:
        r5 = r8.f28867k;
        java.lang.System.arraycopy(r5, r2, r4, r2, r3);
    L_0x008e:
        r2 = r9.m20953g();
        if (r2 <= 0) goto L_0x00ac;
    L_0x0094:
        r2 = r9.m20954h();
        r5 = r9.m20948d();	 Catch:{ IllegalArgumentException -> 0x00a5 }
        r5 = com.google.android.gms.internal.p210i.ct.m37801a(r5);	 Catch:{ IllegalArgumentException -> 0x00a5 }
        r4[r3] = r5;	 Catch:{ IllegalArgumentException -> 0x00a5 }
        r3 = r3 + 1;
        goto L_0x008e;
    L_0x00a5:
        r9.m20951e(r2);
        r8.m31766a(r9, r1);
        goto L_0x008e;
    L_0x00ac:
        r8.f28867k = r4;
    L_0x00ae:
        r9.m20949d(r0);
        goto L_0x0000;
    L_0x00b3:
        r1 = com.google.android.gms.internal.p210i.jk.m21021a(r9, r1);
        r3 = new int[r1];
        r4 = 0;
        r5 = 0;
    L_0x00bb:
        if (r4 >= r1) goto L_0x00dc;
    L_0x00bd:
        if (r4 == 0) goto L_0x00c2;
    L_0x00bf:
        r9.m20937a();
    L_0x00c2:
        r6 = r9.m20954h();
        r7 = r9.m20948d();	 Catch:{ IllegalArgumentException -> 0x00d3 }
        r7 = com.google.android.gms.internal.p210i.ct.m37801a(r7);	 Catch:{ IllegalArgumentException -> 0x00d3 }
        r3[r5] = r7;	 Catch:{ IllegalArgumentException -> 0x00d3 }
        r5 = r5 + 1;
        goto L_0x00d9;
    L_0x00d3:
        r9.m20951e(r6);
        r8.m31766a(r9, r0);
    L_0x00d9:
        r4 = r4 + 1;
        goto L_0x00bb;
    L_0x00dc:
        if (r5 == 0) goto L_0x0000;
    L_0x00de:
        r0 = r8.f28867k;
        if (r0 != 0) goto L_0x00e4;
    L_0x00e2:
        r0 = 0;
        goto L_0x00e7;
    L_0x00e4:
        r0 = r8.f28867k;
        r0 = r0.length;
    L_0x00e7:
        if (r0 != 0) goto L_0x00f0;
    L_0x00e9:
        r1 = r3.length;
        if (r5 != r1) goto L_0x00f0;
    L_0x00ec:
        r8.f28867k = r3;
        goto L_0x0000;
    L_0x00f0:
        r1 = r0 + r5;
        r1 = new int[r1];
        if (r0 == 0) goto L_0x00fb;
    L_0x00f6:
        r4 = r8.f28867k;
        java.lang.System.arraycopy(r4, r2, r1, r2, r0);
    L_0x00fb:
        java.lang.System.arraycopy(r3, r2, r1, r0, r5);
        r8.f28867k = r1;
        goto L_0x0000;
    L_0x0102:
        r0 = r9.m20944b();
        r8.f28868l = r0;
        goto L_0x0000;
    L_0x010a:
        r0 = r9.m20950e();
        r8.f28864h = r0;
        goto L_0x0000;
    L_0x0112:
        r0 = r9.m20947c();
        r8.f28863g = r0;
        goto L_0x0000;
    L_0x011a:
        r0 = r9.m20947c();
        r8.f28862f = r0;
        goto L_0x0000;
    L_0x0122:
        r0 = 42;
        r0 = com.google.android.gms.internal.p210i.jk.m21021a(r9, r0);
        r1 = r8.f28861e;
        if (r1 != 0) goto L_0x012e;
    L_0x012c:
        r1 = 0;
        goto L_0x0131;
    L_0x012e:
        r1 = r8.f28861e;
        r1 = r1.length;
    L_0x0131:
        r0 = r0 + r1;
        r0 = new com.google.android.gms.internal.p210i.ct[r0];
        if (r1 == 0) goto L_0x013b;
    L_0x0136:
        r3 = r8.f28861e;
        java.lang.System.arraycopy(r3, r2, r0, r2, r1);
    L_0x013b:
        r2 = r0.length;
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x0152;
    L_0x0140:
        r2 = new com.google.android.gms.internal.i.ct;
        r2.<init>();
        r0[r1] = r2;
        r2 = r0[r1];
        r9.m20940a(r2);
        r9.m20937a();
        r1 = r1 + 1;
        goto L_0x013b;
    L_0x0152:
        r2 = new com.google.android.gms.internal.i.ct;
        r2.<init>();
        r0[r1] = r2;
        r1 = r0[r1];
        r9.m20940a(r1);
        r8.f28861e = r0;
        goto L_0x0000;
    L_0x0162:
        r0 = 34;
        r0 = com.google.android.gms.internal.p210i.jk.m21021a(r9, r0);
        r1 = r8.f28860d;
        if (r1 != 0) goto L_0x016e;
    L_0x016c:
        r1 = 0;
        goto L_0x0171;
    L_0x016e:
        r1 = r8.f28860d;
        r1 = r1.length;
    L_0x0171:
        r0 = r0 + r1;
        r0 = new com.google.android.gms.internal.p210i.ct[r0];
        if (r1 == 0) goto L_0x017b;
    L_0x0176:
        r3 = r8.f28860d;
        java.lang.System.arraycopy(r3, r2, r0, r2, r1);
    L_0x017b:
        r2 = r0.length;
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x0192;
    L_0x0180:
        r2 = new com.google.android.gms.internal.i.ct;
        r2.<init>();
        r0[r1] = r2;
        r2 = r0[r1];
        r9.m20940a(r2);
        r9.m20937a();
        r1 = r1 + 1;
        goto L_0x017b;
    L_0x0192:
        r2 = new com.google.android.gms.internal.i.ct;
        r2.<init>();
        r0[r1] = r2;
        r1 = r0[r1];
        r9.m20940a(r1);
        r8.f28860d = r0;
        goto L_0x0000;
    L_0x01a2:
        r0 = 26;
        r0 = com.google.android.gms.internal.p210i.jk.m21021a(r9, r0);
        r1 = r8.f28859c;
        if (r1 != 0) goto L_0x01ae;
    L_0x01ac:
        r1 = 0;
        goto L_0x01b1;
    L_0x01ae:
        r1 = r8.f28859c;
        r1 = r1.length;
    L_0x01b1:
        r0 = r0 + r1;
        r0 = new com.google.android.gms.internal.p210i.ct[r0];
        if (r1 == 0) goto L_0x01bb;
    L_0x01b6:
        r3 = r8.f28859c;
        java.lang.System.arraycopy(r3, r2, r0, r2, r1);
    L_0x01bb:
        r2 = r0.length;
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x01d2;
    L_0x01c0:
        r2 = new com.google.android.gms.internal.i.ct;
        r2.<init>();
        r0[r1] = r2;
        r2 = r0[r1];
        r9.m20940a(r2);
        r9.m20937a();
        r1 = r1 + 1;
        goto L_0x01bb;
    L_0x01d2:
        r2 = new com.google.android.gms.internal.i.ct;
        r2.<init>();
        r0[r1] = r2;
        r1 = r0[r1];
        r9.m20940a(r1);
        r8.f28859c = r0;
        goto L_0x0000;
    L_0x01e2:
        r0 = r9.m20947c();
        r8.f28858b = r0;
        goto L_0x0000;
    L_0x01ea:
        r1 = r9.m20954h();
        r2 = r9.m20948d();	 Catch:{ IllegalArgumentException -> 0x0215 }
        if (r2 <= 0) goto L_0x01fc;	 Catch:{ IllegalArgumentException -> 0x0215 }
    L_0x01f4:
        r3 = 8;	 Catch:{ IllegalArgumentException -> 0x0215 }
        if (r2 > r3) goto L_0x01fc;	 Catch:{ IllegalArgumentException -> 0x0215 }
    L_0x01f8:
        r8.f28857a = r2;	 Catch:{ IllegalArgumentException -> 0x0215 }
        goto L_0x0000;	 Catch:{ IllegalArgumentException -> 0x0215 }
    L_0x01fc:
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x0215 }
        r4 = 36;	 Catch:{ IllegalArgumentException -> 0x0215 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x0215 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x0215 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0215 }
        r2 = " is not a valid enum Type";	 Catch:{ IllegalArgumentException -> 0x0215 }
        r5.append(r2);	 Catch:{ IllegalArgumentException -> 0x0215 }
        r2 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x0215 }
        r3.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x0215 }
        throw r3;	 Catch:{ IllegalArgumentException -> 0x0215 }
    L_0x0215:
        r9.m20951e(r1);
        r8.m31766a(r9, r0);
        goto L_0x0000;
    L_0x021d:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.ct.b(com.google.android.gms.internal.i.iy):com.google.android.gms.internal.i.ct");
    }

    /* renamed from: a */
    public final /* synthetic */ jh mo6147a(iy iyVar) {
        return m37802b(iyVar);
    }
}
