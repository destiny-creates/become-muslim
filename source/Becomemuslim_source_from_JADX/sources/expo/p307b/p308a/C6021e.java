package expo.p307b.p308a;

/* compiled from: BarCodeScannerSettingsKey */
/* renamed from: expo.b.a.e */
public enum C6021e {
    TYPES("barCodeTypes");
    
    /* renamed from: b */
    private final String f19809b;

    private C6021e(String str) {
        this.f19809b = str;
    }

    /* renamed from: a */
    public static C6021e m25165a(String str) {
        for (C6021e c6021e : C6021e.values()) {
            if (c6021e.m25166a().equalsIgnoreCase(str)) {
                return c6021e;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String m25166a() {
        return this.f19809b;
    }
}
