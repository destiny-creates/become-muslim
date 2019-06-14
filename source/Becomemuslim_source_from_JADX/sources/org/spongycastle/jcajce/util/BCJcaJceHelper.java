package org.spongycastle.jcajce.util;

import java.security.Provider;
import java.security.Security;
import org.spongycastle.jce.provider.BouncyCastleProvider;

public class BCJcaJceHelper extends ProviderJcaJceHelper {
    /* renamed from: a */
    private static Provider m41115a() {
        if (Security.getProvider("SC") != null) {
            return Security.getProvider("SC");
        }
        return new BouncyCastleProvider();
    }

    public BCJcaJceHelper() {
        super(m41115a());
    }
}
