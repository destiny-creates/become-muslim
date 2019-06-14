package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.io.InputStream;

class PEMUtil {
    /* renamed from: a */
    private final String f22835a;
    /* renamed from: b */
    private final String f22836b;
    /* renamed from: c */
    private final String f22837c;
    /* renamed from: d */
    private final String f22838d;

    PEMUtil(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----BEGIN ");
        stringBuilder.append(str);
        stringBuilder.append("-----");
        this.f22835a = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("-----BEGIN X509 ");
        stringBuilder.append(str);
        stringBuilder.append("-----");
        this.f22836b = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("-----END ");
        stringBuilder.append(str);
        stringBuilder.append("-----");
        this.f22837c = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("-----END X509 ");
        stringBuilder.append(str);
        stringBuilder.append("-----");
        this.f22838d = stringBuilder.toString();
    }

    /* renamed from: b */
    private String m28028b(InputStream inputStream) {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int read = inputStream.read();
            if (read != 13 && read != 10 && read >= 0) {
                stringBuffer.append((char) read);
            } else if (read < 0 || stringBuffer.length() != 0) {
                if (read >= 0) {
                    return null;
                }
                return stringBuffer.toString();
            }
        }
        if (read >= 0) {
            return stringBuffer.toString();
        }
        return null;
    }

    /* renamed from: a */
    org.spongycastle.asn1.ASN1Sequence m28029a(java.io.InputStream r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new java.lang.StringBuffer;
        r0.<init>();
    L_0x0005:
        r1 = r3.m28028b(r4);
        if (r1 == 0) goto L_0x001b;
    L_0x000b:
        r2 = r3.f22835a;
        r2 = r1.startsWith(r2);
        if (r2 != 0) goto L_0x001b;
    L_0x0013:
        r2 = r3.f22836b;
        r1 = r1.startsWith(r2);
        if (r1 == 0) goto L_0x0005;
    L_0x001b:
        r1 = r3.m28028b(r4);
        if (r1 == 0) goto L_0x0036;
    L_0x0021:
        r2 = r3.f22837c;
        r2 = r1.startsWith(r2);
        if (r2 != 0) goto L_0x0036;
    L_0x0029:
        r2 = r3.f22838d;
        r2 = r1.startsWith(r2);
        if (r2 == 0) goto L_0x0032;
    L_0x0031:
        goto L_0x0036;
    L_0x0032:
        r0.append(r1);
        goto L_0x001b;
    L_0x0036:
        r4 = r0.length();
        if (r4 == 0) goto L_0x0051;
    L_0x003c:
        r4 = r0.toString();	 Catch:{ Exception -> 0x0049 }
        r4 = org.spongycastle.util.encoders.Base64.m29431a(r4);	 Catch:{ Exception -> 0x0049 }
        r4 = org.spongycastle.asn1.ASN1Sequence.m43000a(r4);	 Catch:{ Exception -> 0x0049 }
        return r4;
    L_0x0049:
        r4 = new java.io.IOException;
        r0 = "malformed PEM data encountered";
        r4.<init>(r0);
        throw r4;
    L_0x0051:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.x509.PEMUtil.a(java.io.InputStream):org.spongycastle.asn1.ASN1Sequence");
    }
}
