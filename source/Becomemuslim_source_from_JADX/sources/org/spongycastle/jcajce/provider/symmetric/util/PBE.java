package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.GOST3411Digest;
import org.spongycastle.crypto.digests.MD2Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.TigerDigest;
import org.spongycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.spongycastle.crypto.generators.PKCS12ParametersGenerator;
import org.spongycastle.crypto.generators.PKCS5S1ParametersGenerator;
import org.spongycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public interface PBE {

    public static class Util {
        /* renamed from: a */
        private static PBEParametersGenerator m28095a(int i, int i2) {
            if (i != 0) {
                if (i != 4) {
                    if (i != 1) {
                        if (i != 5) {
                            if (i != 2) {
                                return new OpenSSLPBEParametersGenerator();
                            }
                            switch (i2) {
                                case 0:
                                    return new PKCS12ParametersGenerator(new MD5Digest());
                                case 1:
                                    return new PKCS12ParametersGenerator(new SHA1Digest());
                                case 2:
                                    return new PKCS12ParametersGenerator(new RIPEMD160Digest());
                                case 3:
                                    return new PKCS12ParametersGenerator(new TigerDigest());
                                case 4:
                                    return new PKCS12ParametersGenerator(new SHA256Digest());
                                case 5:
                                    return new PKCS12ParametersGenerator(new MD2Digest());
                                case 6:
                                    return new PKCS12ParametersGenerator(new GOST3411Digest());
                                default:
                                    throw new IllegalStateException("unknown digest scheme for PBE encryption.");
                            }
                        }
                    }
                    switch (i2) {
                        case 0:
                            return new PKCS5S2ParametersGenerator(new MD5Digest());
                        case 1:
                            return new PKCS5S2ParametersGenerator(new SHA1Digest());
                        case 2:
                            return new PKCS5S2ParametersGenerator(new RIPEMD160Digest());
                        case 3:
                            return new PKCS5S2ParametersGenerator(new TigerDigest());
                        case 4:
                            return new PKCS5S2ParametersGenerator(new SHA256Digest());
                        case 5:
                            return new PKCS5S2ParametersGenerator(new MD2Digest());
                        case 6:
                            return new PKCS5S2ParametersGenerator(new GOST3411Digest());
                        default:
                            throw new IllegalStateException("unknown digest scheme for PBE PKCS5S2 encryption.");
                    }
                }
            }
            if (i2 == 5) {
                return new PKCS5S1ParametersGenerator(new MD2Digest());
            }
            switch (i2) {
                case 0:
                    return new PKCS5S1ParametersGenerator(new MD5Digest());
                case 1:
                    return new PKCS5S1ParametersGenerator(new SHA1Digest());
                default:
                    throw new IllegalStateException("PKCS5 scheme 1 only supports MD2, MD5 and SHA1.");
            }
        }

        /* renamed from: a */
        public static CipherParameters m28094a(byte[] bArr, int i, int i2, int i3, int i4, AlgorithmParameterSpec algorithmParameterSpec, String str) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new InvalidAlgorithmParameterException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            i = m28095a(i, i2);
            i.m27339a(bArr, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            if (i4 != 0) {
                i = i.mo5759a(i3, i4);
            } else {
                i = i.mo5758a(i3);
            }
            if (str.startsWith("DES") != 0) {
                if ((i instanceof ParametersWithIV) != 0) {
                    DESParameters.m40788a(((KeyParameter) ((ParametersWithIV) i).m35696b()).m35685a());
                } else {
                    DESParameters.m40788a(((KeyParameter) i).m35685a());
                }
            }
            for (i3 = 0; i3 != bArr.length; i3++) {
                bArr[i3] = 0;
            }
            return i;
        }

        /* renamed from: a */
        public static CipherParameters m28093a(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec, String str) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            PBEParametersGenerator a = m28095a(bCPBEKey.m28069a(), bCPBEKey.m28070b());
            byte[] encoded = bCPBEKey.getEncoded();
            if (bCPBEKey.m28075g()) {
                encoded = new byte[2];
            }
            a.m27339a(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            if (bCPBEKey.m28072d() != null) {
                bCPBEKey = a.mo5759a(bCPBEKey.m28071c(), bCPBEKey.m28072d());
            } else {
                bCPBEKey = a.mo5758a(bCPBEKey.m28071c());
            }
            if (str.startsWith("DES") != null) {
                if ((bCPBEKey instanceof ParametersWithIV) != null) {
                    DESParameters.m40788a(((KeyParameter) ((ParametersWithIV) bCPBEKey).m35696b()).m35685a());
                } else {
                    DESParameters.m40788a(((KeyParameter) bCPBEKey).m35685a());
                }
            }
            for (str = null; str != encoded.length; str++) {
                encoded[str] = null;
            }
            return bCPBEKey;
        }

        /* renamed from: a */
        public static CipherParameters m28092a(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            PBEParametersGenerator a = m28095a(bCPBEKey.m28069a(), bCPBEKey.m28070b());
            byte[] encoded = bCPBEKey.getEncoded();
            a.m27339a(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            bCPBEKey = a.mo5760b(bCPBEKey.m28071c());
            for (int i = 0; i != encoded.length; i++) {
                encoded[i] = null;
            }
            return bCPBEKey;
        }

        /* renamed from: a */
        public static CipherParameters m28090a(PBEKeySpec pBEKeySpec, int i, int i2, int i3) {
            i2 = m28095a(i, i2);
            i = m28096a(i, pBEKeySpec);
            i2.m27339a(i, pBEKeySpec.getSalt(), pBEKeySpec.getIterationCount());
            pBEKeySpec = i2.mo5760b(i3);
            for (i3 = 0; i3 != i.length; i3++) {
                i[i3] = 0;
            }
            return pBEKeySpec;
        }

        /* renamed from: a */
        public static CipherParameters m28091a(PBEKeySpec pBEKeySpec, int i, int i2, int i3, int i4) {
            i2 = m28095a(i, i2);
            i = m28096a(i, pBEKeySpec);
            i2.m27339a(i, pBEKeySpec.getSalt(), pBEKeySpec.getIterationCount());
            if (i4 != 0) {
                pBEKeySpec = i2.mo5759a(i3, i4);
            } else {
                pBEKeySpec = i2.mo5758a(i3);
            }
            for (i3 = 0; i3 != i.length; i3++) {
                i[i3] = 0;
            }
            return pBEKeySpec;
        }

        /* renamed from: a */
        public static CipherParameters m28089a(SecretKey secretKey, int i, int i2, int i3, PBEParameterSpec pBEParameterSpec) {
            i = m28095a(i, i2);
            i2 = secretKey.getEncoded();
            i.m27339a(secretKey.getEncoded(), pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            secretKey = i.mo5760b(i3);
            for (i3 = 0; i3 != i2.length; i3++) {
                i2[i3] = 0;
            }
            return secretKey;
        }

        /* renamed from: a */
        private static byte[] m28096a(int i, PBEKeySpec pBEKeySpec) {
            if (i == 2) {
                return PBEParametersGenerator.m27336c(pBEKeySpec.getPassword());
            }
            if (i != 5) {
                if (i != 4) {
                    return PBEParametersGenerator.m27334a(pBEKeySpec.getPassword());
                }
            }
            return PBEParametersGenerator.m27335b(pBEKeySpec.getPassword());
        }
    }
}
