package org.spongycastle.jcajce.provider.symmetric.util;

import java.util.Hashtable;
import java.util.Map;
import javax.crypto.MacSpi;
import org.spongycastle.crypto.Mac;

public class BaseMac extends MacSpi implements PBE {
    /* renamed from: a */
    private Mac f27493a;
    /* renamed from: b */
    private int f27494b = 2;
    /* renamed from: c */
    private int f27495c = 1;
    /* renamed from: d */
    private int f27496d = 160;

    protected BaseMac(Mac mac) {
        this.f27493a = mac;
    }

    protected BaseMac(Mac mac, int i, int i2, int i3) {
        this.f27493a = mac;
        this.f27494b = i;
        this.f27495c = i2;
        this.f27496d = i3;
    }

    protected void engineInit(java.security.Key r6, java.security.spec.AlgorithmParameterSpec r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        if (r6 == 0) goto L_0x00d4;
    L_0x0002:
        r0 = r6 instanceof org.spongycastle.jcajce.PKCS12Key;
        if (r0 == 0) goto L_0x005e;
    L_0x0006:
        r6 = (javax.crypto.SecretKey) r6;	 Catch:{ Exception -> 0x0056 }
        r7 = (javax.crypto.spec.PBEParameterSpec) r7;	 Catch:{ Exception -> 0x004e }
        r0 = r6 instanceof javax.crypto.interfaces.PBEKey;
        if (r0 == 0) goto L_0x0020;
    L_0x000e:
        if (r7 != 0) goto L_0x0020;
    L_0x0010:
        r7 = new javax.crypto.spec.PBEParameterSpec;
        r0 = r6;
        r0 = (javax.crypto.interfaces.PBEKey) r0;
        r1 = r0.getSalt();
        r0 = r0.getIterationCount();
        r7.<init>(r1, r0);
    L_0x0020:
        r0 = 1;
        r1 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        r2 = r5.f27493a;
        r2 = r2.mo5762a();
        r3 = "GOST";
        r2 = r2.startsWith(r3);
        r3 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r2 == 0) goto L_0x0035;
    L_0x0033:
        r0 = 6;
        goto L_0x0047;
    L_0x0035:
        r2 = r5.f27493a;
        r2 = r2.mo5762a();
        r4 = "SHA256";
        r2 = r2.startsWith(r4);
        if (r2 == 0) goto L_0x0045;
    L_0x0043:
        r0 = 4;
        goto L_0x0047;
    L_0x0045:
        r3 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
    L_0x0047:
        r1 = 2;
        r6 = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util.m28089a(r6, r1, r0, r3, r7);
        goto L_0x00c6;
    L_0x004e:
        r6 = new java.security.InvalidAlgorithmParameterException;
        r7 = "PKCS12 requires a PBEParameterSpec";
        r6.<init>(r7);
        throw r6;
    L_0x0056:
        r6 = new java.security.InvalidKeyException;
        r7 = "PKCS12 requires a SecretKey/PBEKey";
        r6.<init>(r7);
        throw r6;
    L_0x005e:
        r0 = r6 instanceof org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey;
        if (r0 == 0) goto L_0x0080;
    L_0x0062:
        r6 = (org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey) r6;
        r0 = r6.m28073e();
        if (r0 == 0) goto L_0x006f;
    L_0x006a:
        r6 = r6.m28073e();
        goto L_0x00c6;
    L_0x006f:
        r0 = r7 instanceof javax.crypto.spec.PBEParameterSpec;
        if (r0 == 0) goto L_0x0078;
    L_0x0073:
        r6 = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util.m28092a(r6, r7);
        goto L_0x00c6;
    L_0x0078:
        r6 = new java.security.InvalidAlgorithmParameterException;
        r7 = "PBE requires PBE parameters to be set.";
        r6.<init>(r7);
        throw r6;
    L_0x0080:
        r0 = r7 instanceof javax.crypto.spec.IvParameterSpec;
        if (r0 == 0) goto L_0x009a;
    L_0x0084:
        r0 = new org.spongycastle.crypto.params.ParametersWithIV;
        r1 = new org.spongycastle.crypto.params.KeyParameter;
        r6 = r6.getEncoded();
        r1.<init>(r6);
        r7 = (javax.crypto.spec.IvParameterSpec) r7;
        r6 = r7.getIV();
        r0.<init>(r1, r6);
        r6 = r0;
        goto L_0x00c6;
    L_0x009a:
        r0 = r7 instanceof org.spongycastle.jcajce.spec.SkeinParameterSpec;
        if (r0 == 0) goto L_0x00ba;
    L_0x009e:
        r0 = new org.spongycastle.crypto.params.SkeinParameters$Builder;
        r7 = (org.spongycastle.jcajce.spec.SkeinParameterSpec) r7;
        r7 = r7.m28111a();
        r7 = m36120a(r7);
        r0.<init>(r7);
        r6 = r6.getEncoded();
        r6 = r0.m27503a(r6);
        r6 = r6.m27504a();
        goto L_0x00c6;
    L_0x00ba:
        if (r7 != 0) goto L_0x00cc;
    L_0x00bc:
        r7 = new org.spongycastle.crypto.params.KeyParameter;
        r6 = r6.getEncoded();
        r7.<init>(r6);
        r6 = r7;
    L_0x00c6:
        r7 = r5.f27493a;
        r7.mo5764a(r6);
        return;
    L_0x00cc:
        r6 = new java.security.InvalidAlgorithmParameterException;
        r7 = "unknown parameter type.";
        r6.<init>(r7);
        throw r6;
    L_0x00d4:
        r6 = new java.security.InvalidKeyException;
        r7 = "key is null";
        r6.<init>(r7);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.util.BaseMac.engineInit(java.security.Key, java.security.spec.AlgorithmParameterSpec):void");
    }

    protected int engineGetMacLength() {
        return this.f27493a.mo5766b();
    }

    protected void engineReset() {
        this.f27493a.mo5767c();
    }

    protected void engineUpdate(byte b) {
        this.f27493a.mo5763a(b);
    }

    protected void engineUpdate(byte[] bArr, int i, int i2) {
        this.f27493a.mo5765a(bArr, i, i2);
    }

    protected byte[] engineDoFinal() {
        byte[] bArr = new byte[engineGetMacLength()];
        this.f27493a.mo5761a(bArr, 0);
        return bArr;
    }

    /* renamed from: a */
    private static Hashtable m36120a(Map map) {
        Hashtable hashtable = new Hashtable();
        for (Object next : map.keySet()) {
            hashtable.put(next, map.get(next));
        }
        return hashtable;
    }
}
