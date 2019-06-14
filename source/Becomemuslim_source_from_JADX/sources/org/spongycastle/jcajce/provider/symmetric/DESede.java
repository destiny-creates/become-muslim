package org.spongycastle.jcajce.provider.symmetric;

import com.facebook.imageutils.JfifUtil;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.DESedeWrapEngine;
import org.spongycastle.crypto.engines.RFC3211WrapEngine;
import org.spongycastle.crypto.generators.DESedeKeyGenerator;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.macs.CFBBlockCipherMac;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.DES.DESPBEKeyFactory;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class DESede {

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

    public static class KeyGenerator3 extends BaseKeyGenerator {
        public KeyGenerator3() {
            super("DESede3", JfifUtil.MARKER_SOFn, new DESedeKeyGenerator());
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        /* renamed from: f */
        private boolean f27459f = false;

        public KeyGenerator() {
            super("DESede", JfifUtil.MARKER_SOFn, new DESedeKeyGenerator());
        }

        protected void engineInit(int i, SecureRandom secureRandom) {
            super.engineInit(i, secureRandom);
            this.f27459f = true;
        }

        protected SecretKey engineGenerateKey() {
            if (this.e) {
                this.d.mo5756a(new KeyGenerationParameters(new SecureRandom(), this.c));
                this.e = false;
            }
            if (this.f27459f) {
                return new SecretKeySpec(this.d.mo5757a(), this.a);
            }
            Object a = this.d.mo5757a();
            System.arraycopy(a, 0, a, 16, 8);
            return new SecretKeySpec(a, this.a);
        }
    }

    public static class Mappings extends AlgorithmProvider {
        /* renamed from: a */
        private static final String f27460a = DESede.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f27460a);
            stringBuilder.append("$ECB");
            configurableProvider.mo5883a("Cipher.DESEDE", stringBuilder.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.f21835B;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f27460a);
            stringBuilder2.append("$CBC");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27460a);
            stringBuilder.append("$Wrap");
            configurableProvider.mo5883a("Cipher.DESEDEWRAP", stringBuilder.toString());
            aSN1ObjectIdentifier = PKCSObjectIdentifiers.bD;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(f27460a);
            stringBuilder2.append("$Wrap");
            configurableProvider.mo5884a("Cipher", aSN1ObjectIdentifier, stringBuilder2.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27460a);
            stringBuilder.append("$RFC3211");
            configurableProvider.mo5883a("Cipher.DESEDERFC3211WRAP", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Cipher.DESEDERFC3217WRAP", "DESEDEWRAP");
            configurableProvider.mo5883a("Alg.Alias.Cipher.TDEA", "DESEDE");
            configurableProvider.mo5883a("Alg.Alias.Cipher.TDEAWRAP", "DESEDEWRAP");
            configurableProvider.mo5883a("Alg.Alias.KeyGenerator.TDEA", "DESEDE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.TDEA", "DESEDE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameterGenerator.TDEA", "DESEDE");
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.TDEA", "DESEDE");
            if (configurableProvider.mo5886b("MessageDigest", "SHA-1")) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(f27460a);
                stringBuilder.append("$PBEWithSHAAndDES3Key");
                configurableProvider.mo5883a("Cipher.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(f27460a);
                stringBuilder.append("$BrokePBEWithSHAAndDES3Key");
                configurableProvider.mo5883a("Cipher.BROKENPBEWITHSHAAND3-KEYTRIPLEDES-CBC", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(f27460a);
                stringBuilder.append("$OldPBEWithSHAAndDES3Key");
                configurableProvider.mo5883a("Cipher.OLDPBEWITHSHAAND3-KEYTRIPLEDES-CBC", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(f27460a);
                stringBuilder.append("$PBEWithSHAAndDES2Key");
                configurableProvider.mo5883a("Cipher.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(f27460a);
                stringBuilder.append("$BrokePBEWithSHAAndDES2Key");
                configurableProvider.mo5883a("Cipher.BROKENPBEWITHSHAAND2-KEYTRIPLEDES-CBC", stringBuilder.toString());
                configurableProvider.mo5884a("Alg.Alias.Cipher", PKCSObjectIdentifiers.by, "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                configurableProvider.mo5884a("Alg.Alias.Cipher", PKCSObjectIdentifiers.bz, "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
                configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA1ANDDESEDE", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA1AND3-KEYTRIPLEDES-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA1AND2-KEYTRIPLEDES-CBC", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
                configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHAAND3-KEYDESEDE-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHAAND2-KEYDESEDE-CBC", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
                configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA1AND3-KEYDESEDE-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA1AND2-KEYDESEDE-CBC", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
                configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWITHSHA1ANDDESEDE-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27460a);
            stringBuilder.append("$KeyGenerator");
            configurableProvider.mo5883a("KeyGenerator.DESEDE", stringBuilder.toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("KeyGenerator.");
            stringBuilder3.append(PKCSObjectIdentifiers.f21835B);
            String stringBuilder4 = stringBuilder3.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27460a);
            stringBuilder.append("$KeyGenerator3");
            configurableProvider.mo5883a(stringBuilder4, stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27460a);
            stringBuilder.append("$KeyGenerator");
            configurableProvider.mo5883a("KeyGenerator.DESEDEWRAP", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27460a);
            stringBuilder.append("$KeyFactory");
            configurableProvider.mo5883a("SecretKeyFactory.DESEDE", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27460a);
            stringBuilder.append("$CMAC");
            configurableProvider.mo5883a("Mac.DESEDECMAC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27460a);
            stringBuilder.append("$CBCMAC");
            configurableProvider.mo5883a("Mac.DESEDEMAC", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.DESEDE", "DESEDEMAC");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27460a);
            stringBuilder.append("$DESedeCFB8");
            configurableProvider.mo5883a("Mac.DESEDEMAC/CFB8", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.DESEDE/CFB8", "DESEDEMAC/CFB8");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27460a);
            stringBuilder.append("$DESede64");
            configurableProvider.mo5883a("Mac.DESEDEMAC64", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.DESEDE64", "DESEDEMAC64");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27460a);
            stringBuilder.append("$DESede64with7816d4");
            configurableProvider.mo5883a("Mac.DESEDEMAC64WITHISO7816-4PADDING", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.Mac.DESEDE64WITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
            configurableProvider.mo5883a("Alg.Alias.Mac.DESEDEISO9797ALG1MACWITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
            configurableProvider.mo5883a("Alg.Alias.Mac.DESEDEISO9797ALG1WITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
            configurableProvider.mo5883a("AlgorithmParameters.DESEDE", "org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters");
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Alg.Alias.AlgorithmParameters.");
            stringBuilder3.append(PKCSObjectIdentifiers.f21835B);
            configurableProvider.mo5883a(stringBuilder3.toString(), "DESEDE");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27460a);
            stringBuilder.append("$AlgParamGen");
            configurableProvider.mo5883a("AlgorithmParameterGenerator.DESEDE", stringBuilder.toString());
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Alg.Alias.AlgorithmParameterGenerator.");
            stringBuilder3.append(PKCSObjectIdentifiers.f21835B);
            configurableProvider.mo5883a(stringBuilder3.toString(), "DESEDE");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27460a);
            stringBuilder.append("$PBEWithSHAAndDES3KeyFactory");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f27460a);
            stringBuilder.append("$PBEWithSHAAndDES2KeyFactory");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND3-KEYTRIPLEDES", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND2-KEYTRIPLEDES", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDDES3KEY-CBC", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDDES2KEY-CBC", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.3", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.4", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBEWithSHAAnd3KeyTripleDES", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.3", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.4", "PKCS12PBE");
            configurableProvider.mo5883a("Alg.Alias.Cipher.PBEWithSHAAnd3KeyTripleDES", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        }
    }

    public static class CBCMAC extends BaseMac {
        public CBCMAC() {
            super(new CBCBlockCipherMac(new DESedeEngine()));
        }
    }

    public static class CMAC extends BaseMac {
        public CMAC() {
            super(new CMac(new DESedeEngine()));
        }
    }

    public static class DESede64 extends BaseMac {
        public DESede64() {
            super(new CBCBlockCipherMac(new DESedeEngine(), 64));
        }
    }

    public static class DESede64with7816d4 extends BaseMac {
        public DESede64with7816d4() {
            super(new CBCBlockCipherMac(new DESedeEngine(), 64, new ISO7816d4Padding()));
        }
    }

    public static class DESedeCFB8 extends BaseMac {
        public DESedeCFB8() {
            super(new CFBBlockCipherMac(new DESedeEngine()));
        }
    }

    public static class KeyFactory extends BaseSecretKeyFactory {
        public KeyFactory() {
            super("DESede", null);
        }

        protected KeySpec engineGetKeySpec(SecretKey secretKey, Class cls) {
            if (cls == null) {
                throw new InvalidKeySpecException("keySpec parameter is null");
            } else if (secretKey == null) {
                throw new InvalidKeySpecException("key parameter is null");
            } else if (SecretKeySpec.class.isAssignableFrom(cls)) {
                return new SecretKeySpec(secretKey.getEncoded(), this.a);
            } else {
                if (DESedeKeySpec.class.isAssignableFrom(cls) != null) {
                    secretKey = secretKey.getEncoded();
                    try {
                        if (secretKey.length != 16) {
                            return new DESedeKeySpec(secretKey);
                        }
                        cls = new byte[24];
                        System.arraycopy(secretKey, 0, cls, 0, 16);
                        System.arraycopy(secretKey, 0, cls, 16, 8);
                        return new DESedeKeySpec(cls);
                    } catch (SecretKey secretKey2) {
                        throw new InvalidKeySpecException(secretKey2.toString());
                    }
                }
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
        }

        protected SecretKey engineGenerateSecret(KeySpec keySpec) {
            if (keySpec instanceof DESedeKeySpec) {
                return new SecretKeySpec(((DESedeKeySpec) keySpec).getKey(), "DESede");
            }
            return super.engineGenerateSecret(keySpec);
        }
    }

    public static class RFC3211 extends BaseWrapCipher {
        public RFC3211() {
            super(new RFC3211WrapEngine(new DESedeEngine()), 8);
        }
    }

    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new DESedeWrapEngine());
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new DESedeEngine()), 64);
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super(new DESedeEngine());
        }
    }

    public static class PBEWithSHAAndDES2Key extends BaseBlockCipher {
        public PBEWithSHAAndDES2Key() {
            super(new CBCBlockCipher(new DESedeEngine()), 2, 1, 128, 8);
        }
    }

    public static class PBEWithSHAAndDES2KeyFactory extends DESPBEKeyFactory {
        public PBEWithSHAAndDES2KeyFactory() {
            super("PBEwithSHAandDES2Key-CBC", PKCSObjectIdentifiers.bz, true, 2, 1, 128, 64);
        }
    }

    public static class PBEWithSHAAndDES3Key extends BaseBlockCipher {
        public PBEWithSHAAndDES3Key() {
            super(new CBCBlockCipher(new DESedeEngine()), 2, 1, JfifUtil.MARKER_SOFn, 8);
        }
    }

    public static class PBEWithSHAAndDES3KeyFactory extends DESPBEKeyFactory {
        public PBEWithSHAAndDES3KeyFactory() {
            super("PBEwithSHAandDES3Key-CBC", PKCSObjectIdentifiers.by, true, 2, 1, JfifUtil.MARKER_SOFn, 64);
        }
    }

    private DESede() {
    }
}
