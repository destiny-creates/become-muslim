package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.crypto.generators.DHParametersGenerator;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;

public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {
    /* renamed from: a */
    protected SecureRandom f27372a;
    /* renamed from: b */
    protected int f27373b = 1024;
    /* renamed from: c */
    private int f27374c = 0;

    protected void engineInit(int i, SecureRandom secureRandom) {
        this.f27373b = i;
        this.f27372a = secureRandom;
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (algorithmParameterSpec instanceof DHGenParameterSpec) {
            DHGenParameterSpec dHGenParameterSpec = (DHGenParameterSpec) algorithmParameterSpec;
            this.f27373b = dHGenParameterSpec.getPrimeSize();
            this.f27374c = dHGenParameterSpec.getExponentSize();
            this.f27372a = secureRandom;
            return;
        }
        throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
    }

    protected AlgorithmParameters engineGenerateParameters() {
        DHParametersGenerator dHParametersGenerator = new DHParametersGenerator();
        if (this.f27372a != null) {
            dHParametersGenerator.m27436a(this.f27373b, 20, this.f27372a);
        } else {
            dHParametersGenerator.m27436a(this.f27373b, 20, new SecureRandom());
        }
        DHParameters a = dHParametersGenerator.m27435a();
        try {
            AlgorithmParameters a2 = m27989a("DH");
            a2.init(new DHParameterSpec(a.m35638a(), a.m35639b(), this.f27374c));
            return a2;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
