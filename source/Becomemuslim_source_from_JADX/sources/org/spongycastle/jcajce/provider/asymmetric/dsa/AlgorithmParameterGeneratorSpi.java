package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.generators.DSAParametersGenerator;
import org.spongycastle.crypto.params.DSAParameterGenerationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;

public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {
    /* renamed from: a */
    protected SecureRandom f27384a;
    /* renamed from: b */
    protected int f27385b = 1024;
    /* renamed from: c */
    protected DSAParameterGenerationParameters f27386c;

    protected void engineInit(int i, SecureRandom secureRandom) {
        if (i < 512 || i > 3072) {
            throw new InvalidParameterException("strength must be from 512 - 3072");
        }
        if (i <= 1024) {
            if (i % 64 != 0) {
                throw new InvalidParameterException("strength must be a multiple of 64 below 1024 bits.");
            }
        }
        if (i > 1024) {
            if (i % 1024 != 0) {
                throw new InvalidParameterException("strength must be a multiple of 1024 above 1024 bits.");
            }
        }
        this.f27385b = i;
        this.f27384a = secureRandom;
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DSA parameter generation.");
    }

    protected AlgorithmParameters engineGenerateParameters() {
        DSAParametersGenerator dSAParametersGenerator;
        if (this.f27385b <= 1024) {
            dSAParametersGenerator = new DSAParametersGenerator();
        } else {
            dSAParametersGenerator = new DSAParametersGenerator(new SHA256Digest());
        }
        if (this.f27384a == null) {
            this.f27384a = new SecureRandom();
        }
        if (this.f27385b == 1024) {
            this.f27386c = new DSAParameterGenerationParameters(1024, 160, 80, this.f27384a);
            dSAParametersGenerator.m27451a(this.f27386c);
        } else if (this.f27385b > 1024) {
            this.f27386c = new DSAParameterGenerationParameters(this.f27385b, 256, 80, this.f27384a);
            dSAParametersGenerator.m27451a(this.f27386c);
        } else {
            dSAParametersGenerator.m27450a(this.f27385b, 20, this.f27384a);
        }
        DSAParameters a = dSAParametersGenerator.m27449a();
        try {
            AlgorithmParameters a2 = m27989a("DSA");
            a2.init(new DSAParameterSpec(a.m35644a(), a.m35645b(), a.m35646c()));
            return a2;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
