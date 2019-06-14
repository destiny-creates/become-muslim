package com.google.android.gms.internal.ads;

public enum wx implements abt {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA224(2),
    SHA256(3),
    SHA512(4),
    UNRECOGNIZED(-1);
    
    /* renamed from: g */
    private static final abu<wx> f24361g = null;
    /* renamed from: h */
    private final int f24363h;

    static {
        f24361g = new wy();
    }

    private wx(int i) {
        this.f24363h = i;
    }

    /* renamed from: a */
    public static wx m31223a(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_HASH;
            case 1:
                return SHA1;
            case 2:
                return SHA224;
            case 3:
                return SHA256;
            case 4:
                return SHA512;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public final int mo3849a() {
        if (this != UNRECOGNIZED) {
            return this.f24363h;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
