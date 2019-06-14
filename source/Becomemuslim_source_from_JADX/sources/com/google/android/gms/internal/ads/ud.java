package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class ud {
    /* renamed from: a */
    private static final CopyOnWriteArrayList<uc> f16044a = new CopyOnWriteArrayList();

    /* renamed from: a */
    public static uc m20138a(String str) {
        Iterator it = f16044a.iterator();
        while (it.hasNext()) {
            uc ucVar = (uc) it.next();
            if (ucVar.m20136a(str)) {
                return ucVar;
            }
        }
        String str2 = "No KMS client does support: ";
        str = String.valueOf(str);
        throw new GeneralSecurityException(str.length() != 0 ? str2.concat(str) : new String(str2));
    }
}
