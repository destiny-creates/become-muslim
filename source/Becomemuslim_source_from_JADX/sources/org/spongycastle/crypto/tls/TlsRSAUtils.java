package org.spongycastle.crypto.tls;

import java.io.OutputStream;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;

public class TlsRSAUtils {
    /* renamed from: a */
    public static byte[] m27775a(TlsContext tlsContext, RSAKeyParameters rSAKeyParameters, OutputStream outputStream) {
        byte[] bArr = new byte[48];
        tlsContext.mo5809b().nextBytes(bArr);
        TlsUtils.m27814a(tlsContext.mo5811d(), bArr, 0);
        PKCS1Encoding pKCS1Encoding = new PKCS1Encoding(new RSABlindedEngine());
        pKCS1Encoding.mo5737a(true, new ParametersWithRandom(rSAKeyParameters, tlsContext.mo5809b()));
        try {
            byte[] a = pKCS1Encoding.mo5738a(bArr, 0, bArr.length);
            if (TlsUtils.m27825a(tlsContext) != null) {
                outputStream.write(a);
            } else {
                TlsUtils.m27844b(a, outputStream);
            }
            return bArr;
        } catch (TlsContext tlsContext2) {
            throw new TlsFatalAlert((short) 80, tlsContext2);
        }
    }

    /* renamed from: a */
    public static byte[] m27776a(org.spongycastle.crypto.tls.TlsContext r7, org.spongycastle.crypto.params.RSAKeyParameters r8, byte[] r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r7.mo5811d();
        r1 = 48;
        r2 = new byte[r1];
        r3 = r7.mo5809b();
        r3.nextBytes(r2);
        r3 = org.spongycastle.util.Arrays.m29373b(r2);
        r4 = 0;
        r5 = new org.spongycastle.crypto.encodings.PKCS1Encoding;	 Catch:{ Exception -> 0x0030 }
        r6 = new org.spongycastle.crypto.engines.RSABlindedEngine;	 Catch:{ Exception -> 0x0030 }
        r6.<init>();	 Catch:{ Exception -> 0x0030 }
        r5.<init>(r6, r2);	 Catch:{ Exception -> 0x0030 }
        r6 = new org.spongycastle.crypto.params.ParametersWithRandom;	 Catch:{ Exception -> 0x0030 }
        r7 = r7.mo5809b();	 Catch:{ Exception -> 0x0030 }
        r6.<init>(r8, r7);	 Catch:{ Exception -> 0x0030 }
        r5.mo5737a(r4, r6);	 Catch:{ Exception -> 0x0030 }
        r7 = r9.length;	 Catch:{ Exception -> 0x0030 }
        r7 = r5.mo5738a(r9, r4, r7);	 Catch:{ Exception -> 0x0030 }
        goto L_0x0031;
    L_0x0030:
        r7 = r3;
    L_0x0031:
        r8 = r0.m27567a();
        r9 = r7[r4];
        r9 = r9 & 255;
        r8 = r8 ^ r9;
        r9 = r0.m27569b();
        r0 = 1;
        r3 = r7[r0];
        r3 = r3 & 255;
        r9 = r9 ^ r3;
        r8 = r8 | r9;
        r9 = r8 >> 1;
        r8 = r8 | r9;
        r9 = r8 >> 2;
        r8 = r8 | r9;
        r9 = r8 >> 4;
        r8 = r8 | r9;
        r8 = r8 & r0;
        r8 = r8 - r0;
        r8 = ~r8;
    L_0x0051:
        if (r4 >= r1) goto L_0x0061;
    L_0x0053:
        r9 = r7[r4];
        r0 = ~r8;
        r9 = r9 & r0;
        r0 = r2[r4];
        r0 = r0 & r8;
        r9 = r9 | r0;
        r9 = (byte) r9;
        r7[r4] = r9;
        r4 = r4 + 1;
        goto L_0x0051;
    L_0x0061:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsRSAUtils.a(org.spongycastle.crypto.tls.TlsContext, org.spongycastle.crypto.params.RSAKeyParameters, byte[]):byte[]");
    }
}
