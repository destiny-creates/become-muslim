package com.google.android.gms.internal.p210i;

import java.lang.reflect.Type;

/* renamed from: com.google.android.gms.internal.i.fd */
public enum fd {
    DOUBLE(0, ff.SCALAR, fu.DOUBLE),
    FLOAT(1, ff.SCALAR, fu.FLOAT),
    INT64(2, ff.SCALAR, fu.LONG),
    UINT64(3, ff.SCALAR, fu.LONG),
    INT32(4, ff.SCALAR, fu.INT),
    FIXED64(5, ff.SCALAR, fu.LONG),
    FIXED32(6, ff.SCALAR, fu.INT),
    BOOL(7, ff.SCALAR, fu.BOOLEAN),
    STRING(8, ff.SCALAR, fu.STRING),
    MESSAGE(9, ff.SCALAR, fu.MESSAGE),
    BYTES(10, ff.SCALAR, fu.BYTE_STRING),
    UINT32(11, ff.SCALAR, fu.INT),
    ENUM(12, ff.SCALAR, fu.ENUM),
    SFIXED32(13, ff.SCALAR, fu.INT),
    SFIXED64(14, ff.SCALAR, fu.LONG),
    SINT32(15, ff.SCALAR, fu.INT),
    SINT64(16, ff.SCALAR, fu.LONG),
    GROUP(17, ff.SCALAR, fu.MESSAGE),
    DOUBLE_LIST(18, ff.VECTOR, fu.DOUBLE),
    FLOAT_LIST(19, ff.VECTOR, fu.FLOAT),
    INT64_LIST(20, ff.VECTOR, fu.LONG),
    UINT64_LIST(21, ff.VECTOR, fu.LONG),
    INT32_LIST(22, ff.VECTOR, fu.INT),
    FIXED64_LIST(23, ff.VECTOR, fu.LONG),
    FIXED32_LIST(24, ff.VECTOR, fu.INT),
    BOOL_LIST(25, ff.VECTOR, fu.BOOLEAN),
    STRING_LIST(26, ff.VECTOR, fu.STRING),
    MESSAGE_LIST(27, ff.VECTOR, fu.MESSAGE),
    BYTES_LIST(28, ff.VECTOR, fu.BYTE_STRING),
    UINT32_LIST(29, ff.VECTOR, fu.INT),
    ENUM_LIST(30, ff.VECTOR, fu.ENUM),
    SFIXED32_LIST(31, ff.VECTOR, fu.INT),
    SFIXED64_LIST(32, ff.VECTOR, fu.LONG),
    SINT32_LIST(33, ff.VECTOR, fu.INT),
    SINT64_LIST(34, ff.VECTOR, fu.LONG),
    DOUBLE_LIST_PACKED(35, ff.PACKED_VECTOR, fu.DOUBLE),
    FLOAT_LIST_PACKED(36, ff.PACKED_VECTOR, fu.FLOAT),
    INT64_LIST_PACKED(37, ff.PACKED_VECTOR, fu.LONG),
    UINT64_LIST_PACKED(38, ff.PACKED_VECTOR, fu.LONG),
    INT32_LIST_PACKED(39, ff.PACKED_VECTOR, fu.INT),
    FIXED64_LIST_PACKED(40, ff.PACKED_VECTOR, fu.LONG),
    FIXED32_LIST_PACKED(41, ff.PACKED_VECTOR, fu.INT),
    BOOL_LIST_PACKED(42, ff.PACKED_VECTOR, fu.BOOLEAN),
    UINT32_LIST_PACKED(43, ff.PACKED_VECTOR, fu.INT),
    ENUM_LIST_PACKED(44, ff.PACKED_VECTOR, fu.ENUM),
    SFIXED32_LIST_PACKED(45, ff.PACKED_VECTOR, fu.INT),
    SFIXED64_LIST_PACKED(46, ff.PACKED_VECTOR, fu.LONG),
    SINT32_LIST_PACKED(47, ff.PACKED_VECTOR, fu.INT),
    SINT64_LIST_PACKED(48, ff.PACKED_VECTOR, fu.LONG),
    GROUP_LIST(49, ff.VECTOR, fu.MESSAGE),
    MAP(50, ff.MAP, fu.VOID);
    
    private static final fd[] ae = null;
    private static final Type[] af = null;
    /* renamed from: Z */
    private final fu f16592Z;
    private final int aa;
    private final ff ab;
    private final Class<?> ac;
    private final boolean ad;

    private fd(int r3, com.google.android.gms.internal.p210i.ff r4, com.google.android.gms.internal.p210i.fu r5) {
        /* JADX: method processing error */
/*
Error: java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
	at java.util.ArrayList$Itr.next(ArrayList.java:851)
	at jadx.core.dex.visitors.ReSugarCode.getEnumMap(ReSugarCode.java:173)
	at jadx.core.dex.visitors.ReSugarCode.processEnumSwitch(ReSugarCode.java:124)
	at jadx.core.dex.visitors.ReSugarCode.process(ReSugarCode.java:68)
	at jadx.core.dex.visitors.ReSugarCode.visit(ReSugarCode.java:52)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = this;
        r0.<init>(r1, r2);
        r0.aa = r3;
        r0.ab = r4;
        r0.f16592Z = r5;
        r1 = com.google.android.gms.internal.p210i.fe.f16593a;
        r2 = r4.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x001f;
            case 2: goto L_0x0018;
            default: goto L_0x0014;
        };
    L_0x0014:
        r1 = 0;
        r0.ac = r1;
        goto L_0x0025;
    L_0x0018:
        r1 = r5.m20577a();
        r0.ac = r1;
        goto L_0x0025;
    L_0x001f:
        r1 = r5.m20577a();
        r0.ac = r1;
    L_0x0025:
        r1 = 0;
        r2 = com.google.android.gms.internal.p210i.ff.SCALAR;
        if (r4 != r2) goto L_0x0036;
    L_0x002a:
        r2 = com.google.android.gms.internal.p210i.fe.f16594b;
        r3 = r5.ordinal();
        r2 = r2[r3];
        switch(r2) {
            case 1: goto L_0x0036;
            case 2: goto L_0x0036;
            case 3: goto L_0x0036;
            default: goto L_0x0035;
        };
    L_0x0035:
        r1 = 1;
    L_0x0036:
        r0.ad = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.fd.<init>(java.lang.String, int, int, com.google.android.gms.internal.i.ff, com.google.android.gms.internal.i.fu):void");
    }

    /* renamed from: a */
    public final int m20549a() {
        return this.aa;
    }

    static {
        af = new Type[0];
        fd[] values = fd.values();
        ae = new fd[values.length];
        int length = values.length;
        int i;
        while (i < length) {
            fd fdVar = values[i];
            ae[fdVar.aa] = fdVar;
            i++;
        }
    }
}
