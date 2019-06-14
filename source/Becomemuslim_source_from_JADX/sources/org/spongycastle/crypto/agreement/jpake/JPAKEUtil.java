package org.spongycastle.crypto.agreement.jpake;

import java.math.BigInteger;

public class JPAKEUtil {
    /* renamed from: a */
    static final BigInteger f22228a = BigInteger.valueOf(0);
    /* renamed from: b */
    static final BigInteger f22229b = BigInteger.valueOf(1);

    /* renamed from: a */
    public static void m27361a(Object obj, String str) {
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" must not be null");
            throw new NullPointerException(stringBuilder.toString());
        }
    }
}
