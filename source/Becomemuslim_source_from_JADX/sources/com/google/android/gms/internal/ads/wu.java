package com.google.android.gms.internal.ads;

public enum wu implements abt {
    UNKNOWN_CURVE(0),
    NIST_P224(1),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4),
    UNRECOGNIZED(-1);
    
    /* renamed from: g */
    private static final abu<wu> f24352g = null;
    /* renamed from: h */
    private final int f24354h;

    static {
        f24352g = new wv();
    }

    private wu(int i) {
        this.f24354h = i;
    }

    /* renamed from: a */
    public static wu m31220a(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_CURVE;
            case 1:
                return NIST_P224;
            case 2:
                return NIST_P256;
            case 3:
                return NIST_P384;
            case 4:
                return NIST_P521;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public final int mo3849a() {
        if (this != UNRECOGNIZED) {
            return this.f24354h;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
