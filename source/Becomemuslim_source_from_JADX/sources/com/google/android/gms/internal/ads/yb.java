package com.google.android.gms.internal.ads;

public enum yb implements abt {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);
    
    /* renamed from: g */
    private static final abu<yb> f24387g = null;
    /* renamed from: h */
    private final int f24389h;

    static {
        f24387g = new yc();
    }

    private yb(int i) {
        this.f24389h = i;
    }

    /* renamed from: a */
    public static yb m31232a(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_PREFIX;
            case 1:
                return TINK;
            case 2:
                return LEGACY;
            case 3:
                return RAW;
            case 4:
                return CRUNCHY;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public final int mo3849a() {
        if (this != UNRECOGNIZED) {
            return this.f24389h;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
