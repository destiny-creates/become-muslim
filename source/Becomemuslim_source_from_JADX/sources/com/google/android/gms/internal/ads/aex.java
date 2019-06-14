package com.google.android.gms.internal.ads;

public enum aex {
    DOUBLE(afc.DOUBLE, 1),
    FLOAT(afc.FLOAT, 5),
    INT64(afc.LONG, 0),
    UINT64(afc.LONG, 0),
    INT32(afc.INT, 0),
    FIXED64(afc.LONG, 1),
    FIXED32(afc.INT, 5),
    BOOL(afc.BOOLEAN, 0),
    STRING(afc.STRING, 2),
    GROUP(afc.MESSAGE, 3),
    MESSAGE(afc.MESSAGE, 2),
    BYTES(afc.BYTE_STRING, 2),
    UINT32(afc.INT, 0),
    ENUM(afc.ENUM, 0),
    SFIXED32(afc.INT, 5),
    SFIXED64(afc.LONG, 1),
    SINT32(afc.INT, 0),
    SINT64(afc.LONG, 0);
    
    /* renamed from: s */
    private final afc f14394s;
    /* renamed from: t */
    private final int f14395t;

    private aex(afc afc, int i) {
        this.f14394s = afc;
        this.f14395t = i;
    }

    /* renamed from: a */
    public final afc m18277a() {
        return this.f14394s;
    }

    /* renamed from: b */
    public final int m18278b() {
        return this.f14395t;
    }
}
