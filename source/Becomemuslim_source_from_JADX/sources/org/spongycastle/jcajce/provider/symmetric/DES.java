package org.spongycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.engines.DESEngine;
import org.spongycastle.crypto.engines.RFC3211WrapEngine;
import org.spongycastle.crypto.generators.DESKeyGenerator;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.macs.CFBBlockCipherMac;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.macs.ISO9797Alg3Mac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.symmetric.util.PBE.Util;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class DES {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DES parameter generation.");
        }

        protected AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[8];
            if (this.b == null) {
                this.b = new SecureRandom();
            }
            this.b.nextBytes(bArr);
            try {
                AlgorithmParameters a = m28076a("DES");
                a.init(new IvParameterSpec(bArr));
                return a;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("DES", 64, new DESKeyGenerator());
        }

        protected void engineInit(int i, SecureRandom secureRandom) {
            super.engineInit(i, secureRandom);
        }

        protected SecretKey engineGenerateKey() {
            if (this.e) {
                this.d.mo5756a(new KeyGenerationParameters(new SecureRandom(), this.c));
                this.e = false;
            }
            return new SecretKeySpec(this.d.mo5757a(), this.a);
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27458a = DES.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.DES", stringBuilder.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier = OIWObjectIdentifiers.f21826e;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f27458a);
            stringBuilder2.append("$CBC");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            m36062a(configurableProvider, OIWObjectIdentifiers.f21826e, "DES");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$RFC3211");
            configurableProvider.mo5883a("Cipher.DESRFC3211WRAP", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$KeyGenerator");
            configurableProvider.mo5883a("KeyGenerator.DES", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$KeyFactory");
            configurableProvider.mo5883a("SecretKeyFactory.DES", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$CMAC");
            configurableProvider.mo5883a("Mac.DESCMAC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$CBCMAC");
            configurableProvider.mo5883a("Mac.DESMAC", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.DES", "DESMAC");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$DESCFB8");
            configurableProvider.mo5883a("Mac.DESMAC/CFB8", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.DES/CFB8", "DESMAC/CFB8");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$DES64");
            configurableProvider.mo5883a("Mac.DESMAC64", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.DES64", "DESMAC64");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$DES64with7816d4");
            configurableProvider.mo5883a("Mac.DESMAC64WITHISO7816-4PADDING", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.DES64WITHISO7816-4PADDING", "DESMAC64WITHISO7816-4PADDING");
            configurableProvider.mo5883a("Alg.Alias.Mac.DESISO9797ALG1MACWITHISO7816-4PADDING", "DESMAC64WITHISO7816-4PADDING");
            configurableProvider.mo5883a("Alg.Alias.Mac.DESISO9797ALG1WITHISO7816-4PADDING", "DESMAC64WITHISO7816-4PADDING");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$DES9797Alg3");
            configurableProvider.mo5883a("Mac.DESWITHISO9797", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.DESISO9797MAC", "DESWITHISO9797");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$DES9797Alg3");
            configurableProvider.mo5883a("Mac.ISO9797ALG3MAC", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.ISO9797ALG3", "ISO9797ALG3MAC");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$DES9797Alg3with7816d4");
            configurableProvider.mo5883a("Mac.ISO9797ALG3WITHISO7816-4PADDING", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.ISO9797ALG3MACWITHISO7816-4PADDING", "ISO9797ALG3WITHISO7816-4PADDING");
            configurableProvider.mo5883a("AlgorithmParameters.DES", "org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters");
            configurableProvider.mo5884a("Alg.Alias.AlgorithmParameters", OIWObjectIdentifiers.f21826e, "DES");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$AlgParamGen");
            configurableProvider.mo5883a("AlgorithmParameterGenerator.DES", stringBuilder.toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Alg.Alias.AlgorithmParameterGenerator.");
            stringBuilder3.append(OIWObjectIdentifiers.f21826e);
            configurableProvider.mo5883a(stringBuilder3.toString(), "DES");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$PBEWithMD2");
            configurableProvider.mo5883a("Cipher.PBEWITHMD2ANDDES", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$PBEWithMD5");
            configurableProvider.mo5883a("Cipher.PBEWITHMD5ANDDES", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$PBEWithSHA1");
            configurableProvider.mo5883a("Cipher.PBEWITHSHA1ANDDES", stringBuilder.toString());
            configurableProvider.mo5884a("Alg.Alias.Cipher", PKCSObjectIdentifiers.s_, "PBEWITHMD2ANDDES");
            configurableProvider.mo5884a("Alg.Alias.Cipher", PKCSObjectIdentifiers.f21866u, "PBEWITHMD5ANDDES");
            configurableProvider.mo5884a("Alg.Alias.Cipher", PKCSObjectIdentifiers.f21868w, "PBEWITHSHA1ANDDES");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHMD2ANDDES-CBC", "PBEWITHMD2ANDDES");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHMD5ANDDES-CBC", "PBEWITHMD5ANDDES");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA1ANDDES-CBC", "PBEWITHSHA1ANDDES");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$PBEWithMD2KeyFactory");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHMD2ANDDES", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$PBEWithMD5KeyFactory");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHMD5ANDDES", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27458a);
            stringBuilder.append("$PBEWithSHA1KeyFactory");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHSHA1ANDDES", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBEWITHMD2ANDDES-CBC", "PBEWITHMD2ANDDES");
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBEWITHMD5ANDDES-CBC", "PBEWITHMD5ANDDES");
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBEWITHSHA1ANDDES-CBC", "PBEWITHSHA1ANDDES");
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Alg.Alias.SecretKeyFactory.");
            stringBuilder3.append(PKCSObjectIdentifiers.s_);
            configurableProvider.mo5883a(stringBuilder3.toString(), "PBEWITHMD2ANDDES");
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Alg.Alias.SecretKeyFactory.");
            stringBuilder3.append(PKCSObjectIdentifiers.f21866u);
            configurableProvider.mo5883a(stringBuilder3.toString(), "PBEWITHMD5ANDDES");
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Alg.Alias.SecretKeyFactory.");
            stringBuilder3.append(PKCSObjectIdentifiers.f21868w);
            configurableProvider.mo5883a(stringBuilder3.toString(), "PBEWITHSHA1ANDDES");
        }

        /* renamed from: a */
        private void m36062a(ConfigurableProvider configurableProvider, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Alg.Alias.KeyGenerator.");
            stringBuilder.append(aSN1ObjectIdentifier.m42986b());
            configurableProvider.mo5883a(stringBuilder.toString(), str);
            stringBuilder = new StringBuilder();
            stringBuilder.append("Alg.Alias.KeyFactory.");
            stringBuilder.append(aSN1ObjectIdentifier.m42986b());
            configurableProvider.mo5883a(stringBuilder.toString(), str);
        }
    }

    public static class CBCMAC extends BaseMac {
        public CBCMAC() {
            super(new CBCBlockCipherMac(new DESEngine()));
        }
    }

    public static class CMAC extends BaseMac {
        public CMAC() {
            super(new CMac(new DESEngine()));
        }
    }

    public static class DES64 extends BaseMac {
        public DES64() {
            super(new CBCBlockCipherMac(new DESEngine(), 64));
        }
    }

    public static class DES64with7816d4 extends BaseMac {
        public DES64with7816d4() {
            super(new CBCBlockCipherMac(new DESEngine(), 64, new ISO7816d4Padding()));
        }
    }

    public static class DES9797Alg3 extends BaseMac {
        public DES9797Alg3() {
            super(new ISO9797Alg3Mac(new DESEngine()));
        }
    }

    public static class DES9797Alg3with7816d4 extends BaseMac {
        public DES9797Alg3with7816d4() {
            super(new ISO9797Alg3Mac(new DESEngine(), new ISO7816d4Padding()));
        }
    }

    public static class DESCFB8 extends BaseMac {
        public DESCFB8() {
            super(new CFBBlockCipherMac(new DESEngine()));
        }
    }

    public static class DESPBEKeyFactory extends BaseSecretKeyFactory {
        /* renamed from: c */
        private boolean f31949c;
        /* renamed from: d */
        private int f31950d;
        /* renamed from: e */
        private int f31951e;
        /* renamed from: f */
        private int f31952f;
        /* renamed from: g */
        private int f31953g;

        public DESPBEKeyFactory(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, int i, int i2, int i3, int i4) {
            super(str, aSN1ObjectIdentifier);
            this.f31949c = z;
            this.f31950d = i;
            this.f31951e = i2;
            this.f31952f = i3;
            this.f31953g = i4;
        }

        protected SecretKey engineGenerateSecret(KeySpec keySpec) {
            if (keySpec instanceof PBEKeySpec) {
                PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
                if (pBEKeySpec.getSalt() == null) {
                    return new BCPBEKey(this.a, this.b, this.f31950d, this.f31951e, this.f31952f, this.f31953g, pBEKeySpec, null);
                }
                if (this.f31949c != null) {
                    keySpec = Util.m28091a(pBEKeySpec, this.f31950d, this.f31951e, this.f31952f, this.f31953g);
                } else {
                    keySpec = Util.m28090a(pBEKeySpec, this.f31950d, this.f31951e, this.f31952f);
                }
                KeySpec keySpec2 = keySpec;
                if ((keySpec2 instanceof ParametersWithIV) != null) {
                    keySpec = (KeyParameter) ((ParametersWithIV) keySpec2).m35696b();
                } else {
                    keySpec = (KeyParameter) keySpec2;
                }
                DESParameters.m40788a(keySpec.m35685a());
                return new BCPBEKey(this.a, this.b, this.f31950d, this.f31951e, this.f31952f, this.f31953g, pBEKeySpec, keySpec2);
            }
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public static class KeyFactory extends BaseSecretKeyFactory {
        public KeyFactory() {
            super("DES", null);
        }

        protected KeySpec engineGetKeySpec(SecretKey secretKey, Class cls) {
            if (cls == null) {
                throw new InvalidKeySpecException("keySpec parameter is null");
            } else if (secretKey == null) {
                throw new InvalidKeySpecException("key parameter is null");
            } else if (SecretKeySpec.class.isAssignableFrom(cls)) {
                return new SecretKeySpec(secretKey.getEncoded(), this.a);
            } else {
                if (DESKeySpec.class.isAssignableFrom(cls) != null) {
                    try {
                        return new DESKeySpec(secretKey.getEncoded());
                    } catch (SecretKey secretKey2) {
                        throw new InvalidKeySpecException(secretKey2.toString());
                    }
                }
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
        }

        protected SecretKey engineGenerateSecret(KeySpec keySpec) {
            if (keySpec instanceof DESKeySpec) {
                return new SecretKeySpec(((DESKeySpec) keySpec).getKey(), "DES");
            }
            return super.engineGenerateSecret(keySpec);
        }
    }

    public static class RFC3211 extends BaseWrapCipher {
        public RFC3211() {
            super(new RFC3211WrapEngine(new DESEngine()), 8);
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new DESEngine()), 64);
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super(new DESEngine());
        }
    }

    public static class PBEWithMD2 extends BaseBlockCipher {
        public PBEWithMD2() {
            super(new CBCBlockCipher(new DESEngine()), 0, 5, 64, 8);
        }
    }

    public static class PBEWithMD2KeyFactory extends DESPBEKeyFactory {
        public PBEWithMD2KeyFactory() {
            super("PBEwithMD2andDES", PKCSObjectIdentifiers.s_, true, 0, 5, 64, 64);
        }
    }

    public static class PBEWithMD5 extends BaseBlockCipher {
        public PBEWithMD5() {
            super(new CBCBlockCipher(new DESEngine()), 0, 0, 64, 8);
        }
    }

    public static class PBEWithMD5KeyFactory extends DESPBEKeyFactory {
        public PBEWithMD5KeyFactory() {
            super("PBEwithMD5andDES", PKCSObjectIdentifiers.f21866u, true, 0, 0, 64, 64);
        }
    }

    public static class PBEWithSHA1 extends BaseBlockCipher {
        public PBEWithSHA1() {
            super(new CBCBlockCipher(new DESEngine()), 0, 1, 64, 8);
        }
    }

    public static class PBEWithSHA1KeyFactory extends DESPBEKeyFactory {
        public PBEWithSHA1KeyFactory() {
            super("PBEwithSHA1andDES", PKCSObjectIdentifiers.f21868w, true, 0, 1, 64, 64);
        }
    }

    private DES() {
    }
}
