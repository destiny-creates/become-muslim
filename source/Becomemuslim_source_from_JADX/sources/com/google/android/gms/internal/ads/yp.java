package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class yp {
    /* renamed from: a */
    private ECPublicKey f16099a;

    public yp(ECPublicKey eCPublicKey) {
        this.f16099a = eCPublicKey;
    }

    /* renamed from: a */
    public final yq m20172a(String str, byte[] bArr, byte[] bArr2, int i, yu yuVar) {
        KeyPair a = yr.m20176a(this.f16099a.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) a.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) a.getPrivate();
        ECPublicKey eCPublicKey2 = this.f16099a;
        ECParameterSpec params = eCPublicKey2.getParams();
        ECParameterSpec params2 = eCPrivateKey.getParams();
        if (params.getCurve().equals(params2.getCurve()) && params.getGenerator().equals(params2.getGenerator()) && params.getOrder().equals(params2.getOrder()) && params.getCofactor() == params2.getCofactor()) {
            byte[] bArr3;
            byte[] a2 = yr.m20181a(eCPrivateKey, eCPublicKey2.getW());
            EllipticCurve curve = eCPublicKey.getParams().getCurve();
            ECPoint w = eCPublicKey.getW();
            yr.m20180a(w, curve);
            int a3 = yr.m20175a(curve);
            int i2 = 1;
            Object obj;
            switch (ys.f16102a[yuVar.ordinal()]) {
                case 1:
                    int i3 = (a3 * 2) + 1;
                    obj = new byte[i3];
                    Object toByteArray = w.getAffineX().toByteArray();
                    Object toByteArray2 = w.getAffineY().toByteArray();
                    System.arraycopy(toByteArray2, 0, obj, i3 - toByteArray2.length, toByteArray2.length);
                    System.arraycopy(toByteArray, 0, obj, (a3 + 1) - toByteArray.length, toByteArray.length);
                    obj[0] = (byte) 4;
                    bArr3 = obj;
                    break;
                case 2:
                    a3++;
                    bArr3 = new byte[a3];
                    obj = w.getAffineX().toByteArray();
                    System.arraycopy(obj, 0, bArr3, a3 - obj.length, obj.length);
                    bArr3[0] = (byte) (w.getAffineY().testBit(0) ? 3 : 2);
                    break;
                default:
                    String valueOf = String.valueOf(yuVar);
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 15);
                    stringBuilder.append("invalid format:");
                    stringBuilder.append(valueOf);
                    throw new GeneralSecurityException(stringBuilder.toString());
            }
            a2 = yi.m20169a(bArr3, a2);
            Mac mac = (Mac) yw.f16112b.m20184a(str);
            if (i <= mac.getMacLength() * JfifUtil.MARKER_FIRST_BYTE) {
                Object obj2;
                byte[] bArr4;
                int i4;
                if (bArr != null) {
                    if (bArr.length != 0) {
                        mac.init(new SecretKeySpec(bArr, str));
                        bArr = mac.doFinal(a2);
                        obj2 = new byte[i];
                        mac.init(new SecretKeySpec(bArr, str));
                        bArr4 = new byte[0];
                        i4 = 0;
                        while (true) {
                            mac.update(bArr4);
                            mac.update(bArr2);
                            mac.update((byte) i2);
                            bArr4 = mac.doFinal();
                            if (bArr4.length + i4 >= i) {
                                System.arraycopy(bArr4, 0, obj2, i4, bArr4.length);
                                i4 += bArr4.length;
                                i2++;
                            } else {
                                System.arraycopy(bArr4, 0, obj2, i4, i - i4);
                                return new yq(bArr3, obj2);
                            }
                        }
                    }
                }
                mac.init(new SecretKeySpec(new byte[mac.getMacLength()], str));
                bArr = mac.doFinal(a2);
                obj2 = new byte[i];
                mac.init(new SecretKeySpec(bArr, str));
                bArr4 = new byte[0];
                i4 = 0;
                while (true) {
                    mac.update(bArr4);
                    mac.update(bArr2);
                    mac.update((byte) i2);
                    bArr4 = mac.doFinal();
                    if (bArr4.length + i4 >= i) {
                        System.arraycopy(bArr4, 0, obj2, i4, i - i4);
                        return new yq(bArr3, obj2);
                    }
                    System.arraycopy(bArr4, 0, obj2, i4, bArr4.length);
                    i4 += bArr4.length;
                    i2++;
                }
            } else {
                throw new GeneralSecurityException("size too large");
            }
        }
        throw new GeneralSecurityException("invalid public key spec");
    }
}
