package expolib_v1.p321a.p322a.p327e;

/* compiled from: ErrorCode */
/* renamed from: expolib_v1.a.a.e.b */
public enum C6169b {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    
    /* renamed from: g */
    public final int f19930g;

    private C6169b(int i) {
        this.f19930g = i;
    }

    /* renamed from: a */
    public static C6169b m25329a(int i) {
        for (C6169b c6169b : C6169b.values()) {
            if (c6169b.f19930g == i) {
                return c6169b;
            }
        }
        return 0;
    }
}
