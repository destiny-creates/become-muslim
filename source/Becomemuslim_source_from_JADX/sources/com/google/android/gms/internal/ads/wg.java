package com.google.android.gms.internal.ads;

public enum wg implements abt {
    UNKNOWN_FORMAT(0),
    UNCOMPRESSED(1),
    COMPRESSED(2),
    UNRECOGNIZED(-1);
    
    /* renamed from: e */
    private static final abu<wg> f24343e = null;
    /* renamed from: f */
    private final int f24345f;

    static {
        f24343e = new wh();
    }

    private wg(int i) {
        this.f24345f = i;
    }

    /* renamed from: a */
    public static wg m31217a(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_FORMAT;
            case 1:
                return UNCOMPRESSED;
            case 2:
                return COMPRESSED;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public final int mo3849a() {
        if (this != UNRECOGNIZED) {
            return this.f24345f;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
