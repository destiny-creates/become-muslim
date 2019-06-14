package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.security.spec.ECGenParameterSpec;
import org.spongycastle.asn1.x9.X9ECParameters;

class ECUtils {
    ECUtils() {
    }

    /* renamed from: a */
    static X9ECParameters m27969a(ECGenParameterSpec eCGenParameterSpec) {
        return m27968a(eCGenParameterSpec.getName());
    }

    /* renamed from: a */
    static org.spongycastle.asn1.x9.X9ECParameters m27968a(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r3.charAt(r0);	 Catch:{ IllegalArgumentException -> 0x003a }
        r2 = 48;	 Catch:{ IllegalArgumentException -> 0x003a }
        if (r1 < r2) goto L_0x001b;	 Catch:{ IllegalArgumentException -> 0x003a }
    L_0x0009:
        r0 = r3.charAt(r0);	 Catch:{ IllegalArgumentException -> 0x003a }
        r1 = 50;	 Catch:{ IllegalArgumentException -> 0x003a }
        if (r0 > r1) goto L_0x001b;	 Catch:{ IllegalArgumentException -> 0x003a }
    L_0x0011:
        r0 = new org.spongycastle.asn1.ASN1ObjectIdentifier;	 Catch:{ IllegalArgumentException -> 0x003a }
        r0.<init>(r3);	 Catch:{ IllegalArgumentException -> 0x003a }
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28008a(r0);	 Catch:{ IllegalArgumentException -> 0x003a }
        goto L_0x003e;	 Catch:{ IllegalArgumentException -> 0x003a }
    L_0x001b:
        r0 = 32;	 Catch:{ IllegalArgumentException -> 0x003a }
        r1 = r3.indexOf(r0);	 Catch:{ IllegalArgumentException -> 0x003a }
        if (r1 <= 0) goto L_0x0035;	 Catch:{ IllegalArgumentException -> 0x003a }
    L_0x0023:
        r0 = r3.indexOf(r0);	 Catch:{ IllegalArgumentException -> 0x003a }
        r0 = r0 + 1;	 Catch:{ IllegalArgumentException -> 0x003a }
        r0 = r3.substring(r0);	 Catch:{ IllegalArgumentException -> 0x003a }
        r3 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28013b(r0);	 Catch:{ IllegalArgumentException -> 0x0033 }
        r0 = r3;
        goto L_0x003e;
    L_0x0033:
        r3 = r0;
        goto L_0x003a;
    L_0x0035:
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28013b(r3);	 Catch:{ IllegalArgumentException -> 0x003a }
        goto L_0x003e;
    L_0x003a:
        r0 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.m28013b(r3);
    L_0x003e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ec.ECUtils.a(java.lang.String):org.spongycastle.asn1.x9.X9ECParameters");
    }
}
