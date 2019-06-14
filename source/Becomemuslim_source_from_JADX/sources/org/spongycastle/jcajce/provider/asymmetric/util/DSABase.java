package org.spongycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;

public abstract class DSABase extends SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    protected Digest bF;
    protected DSA bG;
    protected DSAEncoder bH;

    protected DSABase(Digest digest, DSA dsa, DSAEncoder dSAEncoder) {
        this.bF = digest;
        this.bG = dsa;
        this.bH = dSAEncoder;
    }

    protected void engineUpdate(byte b) {
        this.bF.mo5730a(b);
    }

    protected void engineUpdate(byte[] bArr, int i, int i2) {
        this.bF.mo5731a(bArr, i, i2);
    }

    protected byte[] engineSign() {
        byte[] bArr = new byte[this.bF.mo5732b()];
        this.bF.mo5728a(bArr, 0);
        try {
            BigInteger[] a = this.bG.mo5802a(bArr);
            return this.bH.mo5853a(a[0], a[1]);
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    protected boolean engineVerify(byte[] r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.bF;
        r0 = r0.mo5732b();
        r0 = new byte[r0];
        r1 = r4.bF;
        r2 = 0;
        r1.mo5728a(r0, r2);
        r1 = r4.bH;	 Catch:{ Exception -> 0x0020 }
        r5 = r1.mo5854a(r5);	 Catch:{ Exception -> 0x0020 }
        r1 = r4.bG;
        r2 = r5[r2];
        r3 = 1;
        r5 = r5[r3];
        r5 = r1.mo5801a(r0, r2, r5);
        return r5;
    L_0x0020:
        r5 = new java.security.SignatureException;
        r0 = "error decoding signature bytes.";
        r5.<init>(r0);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.util.DSABase.engineVerify(byte[]):boolean");
    }

    protected void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }
}
