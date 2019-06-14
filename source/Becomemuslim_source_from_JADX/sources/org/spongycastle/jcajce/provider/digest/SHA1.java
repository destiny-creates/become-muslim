package org.spongycastle.jcajce.provider.digest;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import org.spongycastle.asn1.iana.IANAObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import org.spongycastle.jcajce.provider.symmetric.util.PBE.Util;
import org.spongycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;

public class SHA1 {

    public static class Digest extends BCMessageDigest implements Cloneable {
        public Digest() {
            super(new SHA1Digest());
        }

        public Object clone() {
            Digest digest = (Digest) super.clone();
            digest.a = new SHA1Digest((SHA1Digest) this.a);
            return digest;
        }
    }

    public static class KeyGenerator extends BaseKeyGenerator {
        public KeyGenerator() {
            super("HMACSHA1", 160, new CipherKeyGenerator());
        }
    }

    public static class BasePBKDF2WithHmacSHA1 extends BaseSecretKeyFactory {
        /* renamed from: c */
        private int f31935c;

        public BasePBKDF2WithHmacSHA1(String str, int i) {
            super(str, PKCSObjectIdentifiers.f21871z);
            this.f31935c = i;
        }

        protected SecretKey engineGenerateSecret(KeySpec keySpec) {
            if (keySpec instanceof PBEKeySpec) {
                PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
                if (pBEKeySpec.getSalt() == null) {
                    throw new InvalidKeySpecException("missing required salt");
                } else if (pBEKeySpec.getIterationCount() <= null) {
                    r0 = new StringBuilder();
                    r0.append("positive iteration count required: ");
                    r0.append(pBEKeySpec.getIterationCount());
                    throw new InvalidKeySpecException(r0.toString());
                } else if (pBEKeySpec.getKeyLength() <= null) {
                    r0 = new StringBuilder();
                    r0.append("positive key length required: ");
                    r0.append(pBEKeySpec.getKeyLength());
                    throw new InvalidKeySpecException(r0.toString());
                } else if (pBEKeySpec.getPassword().length != null) {
                    int keyLength = pBEKeySpec.getKeyLength();
                    return new BCPBEKey(this.a, this.b, this.f31935c, 1, keyLength, -1, pBEKeySpec, Util.m28090a(pBEKeySpec, this.f31935c, 1, keyLength));
                } else {
                    throw new IllegalArgumentException("password empty");
                }
            }
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public static class HashMac extends BaseMac {
        public HashMac() {
            super(new HMac(new SHA1Digest()));
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        /* renamed from: a */
        private static final String f31936a = SHA1.class.getName();

        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(f31936a);
            stringBuilder.append("$Digest");
            configurableProvider.mo5883a("MessageDigest.SHA-1", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.MessageDigest.SHA1", "SHA-1");
            configurableProvider.mo5883a("Alg.Alias.MessageDigest.SHA", "SHA-1");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.MessageDigest.");
            stringBuilder2.append(OIWObjectIdentifiers.f21830i);
            configurableProvider.mo5883a(stringBuilder2.toString(), "SHA-1");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31936a);
            stringBuilder.append("$HashMac");
            String stringBuilder3 = stringBuilder.toString();
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(f31936a);
            stringBuilder4.append("$KeyGenerator");
            m36031a(configurableProvider, "SHA1", stringBuilder3, stringBuilder4.toString());
            m36032a(configurableProvider, "SHA1", PKCSObjectIdentifiers.f21842I);
            m36032a(configurableProvider, "SHA1", IANAObjectIdentifiers.f21682o);
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31936a);
            stringBuilder.append("$SHA1Mac");
            configurableProvider.mo5883a("Mac.PBEWITHHMACSHA", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31936a);
            stringBuilder.append("$SHA1Mac");
            configurableProvider.mo5883a("Mac.PBEWITHHMACSHA1", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBEWITHHMACSHA", "PBEWITHHMACSHA1");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.SecretKeyFactory.");
            stringBuilder2.append(OIWObjectIdentifiers.f21830i);
            configurableProvider.mo5883a(stringBuilder2.toString(), "PBEWITHHMACSHA1");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Alg.Alias.Mac.");
            stringBuilder2.append(OIWObjectIdentifiers.f21830i);
            configurableProvider.mo5883a(stringBuilder2.toString(), "PBEWITHHMACSHA");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31936a);
            stringBuilder.append("$PBEWithMacKeyFactory");
            configurableProvider.mo5883a("SecretKeyFactory.PBEWITHHMACSHA1", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31936a);
            stringBuilder.append("$PBKDF2WithHmacSHA1UTF8");
            configurableProvider.mo5883a("SecretKeyFactory.PBKDF2WithHmacSHA1", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBKDF2WithHmacSHA1AndUTF8", "PBKDF2WithHmacSHA1");
            stringBuilder = new StringBuilder();
            stringBuilder.append(f31936a);
            stringBuilder.append("$PBKDF2WithHmacSHA18BIT");
            configurableProvider.mo5883a("SecretKeyFactory.PBKDF2WithHmacSHA1And8BIT", stringBuilder.toString());
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBKDF2withASCII", "PBKDF2WithHmacSHA1And8BIT");
            configurableProvider.mo5883a("Alg.Alias.SecretKeyFactory.PBKDF2with8BIT", "PBKDF2WithHmacSHA1And8BIT");
        }
    }

    public static class SHA1Mac extends BaseMac {
        public SHA1Mac() {
            super(new HMac(new SHA1Digest()));
        }
    }

    public static class PBEWithMacKeyFactory extends PBESecretKeyFactory {
        public PBEWithMacKeyFactory() {
            super("PBEwithHmacSHA", null, false, 2, 1, 160, 0);
        }
    }

    public static class PBKDF2WithHmacSHA18BIT extends BasePBKDF2WithHmacSHA1 {
        public PBKDF2WithHmacSHA18BIT() {
            super("PBKDF2WithHmacSHA1And8bit", 1);
        }
    }

    public static class PBKDF2WithHmacSHA1UTF8 extends BasePBKDF2WithHmacSHA1 {
        public PBKDF2WithHmacSHA1UTF8() {
            super("PBKDF2WithHmacSHA1", 5);
        }
    }

    private SHA1() {
    }
}
