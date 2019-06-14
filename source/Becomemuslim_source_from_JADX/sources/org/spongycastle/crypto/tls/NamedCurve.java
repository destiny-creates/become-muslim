package org.spongycastle.crypto.tls;

public class NamedCurve {
    /* renamed from: a */
    public static boolean m27561a(int i) {
        return (i < 1 || i > 28) ? i >= 65281 && i <= 65282 : true;
    }

    /* renamed from: b */
    public static boolean m27562b(int i) {
        switch (i) {
            case 65281:
            case 65282:
                return false;
            default:
                return true;
        }
    }
}
