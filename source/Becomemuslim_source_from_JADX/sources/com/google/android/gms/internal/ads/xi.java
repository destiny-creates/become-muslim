package com.google.android.gms.internal.ads;

public enum xi implements abt {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);
    
    /* renamed from: f */
    private static final abu<xi> f24378f = null;
    /* renamed from: g */
    private final int f24380g;

    static {
        f24378f = new xj();
    }

    private xi(int i) {
        this.f24380g = i;
    }

    /* renamed from: a */
    public static xi m31229a(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_STATUS;
            case 1:
                return ENABLED;
            case 2:
                return DISABLED;
            case 3:
                return DESTROYED;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public final int mo3849a() {
        if (this != UNRECOGNIZED) {
            return this.f24380g;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
