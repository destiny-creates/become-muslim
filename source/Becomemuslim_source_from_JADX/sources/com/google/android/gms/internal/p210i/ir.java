package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.ir */
public enum ir {
    DOUBLE(iw.DOUBLE, 1),
    FLOAT(iw.FLOAT, 5),
    INT64(iw.LONG, 0),
    UINT64(iw.LONG, 0),
    INT32(iw.INT, 0),
    FIXED64(iw.LONG, 1),
    FIXED32(iw.INT, 5),
    BOOL(iw.BOOLEAN, 0),
    STRING(iw.STRING, 2),
    GROUP(iw.MESSAGE, 3),
    MESSAGE(iw.MESSAGE, 2),
    BYTES(iw.BYTE_STRING, 2),
    UINT32(iw.INT, 0),
    ENUM(iw.ENUM, 0),
    SFIXED32(iw.INT, 5),
    SFIXED64(iw.LONG, 1),
    SINT32(iw.INT, 0),
    SINT64(iw.LONG, 0);
    
    /* renamed from: s */
    private final iw f16747s;
    /* renamed from: t */
    private final int f16748t;

    private ir(iw iwVar, int i) {
        this.f16747s = iwVar;
        this.f16748t = i;
    }

    /* renamed from: a */
    public final iw m20888a() {
        return this.f16747s;
    }

    /* renamed from: b */
    public final int m20889b() {
        return this.f16748t;
    }
}
