package org.spongycastle.jcajce.provider.asymmetric.elgamal;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.crypto.generators.ElGamalParametersGenerator;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;

public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {
    /* renamed from: a */
    protected SecureRandom f27412a;
    /* renamed from: b */
    protected int f27413b = 1024;
    /* renamed from: c */
    private int f27414c = 0;

    protected void engineInit(int i, SecureRandom secureRandom) {
        this.f27413b = i;
        this.f27412a = secureRandom;
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (algorithmParameterSpec instanceof DHGenParameterSpec) {
            DHGenParameterSpec dHGenParameterSpec = (DHGenParameterSpec) algorithmParameterSpec;
            this.f27413b = dHGenParameterSpec.getPrimeSize();
            this.f27414c = dHGenParameterSpec.getExponentSize();
            this.f27412a = secureRandom;
            return;
        }
        throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
    }

    protected AlgorithmParameters engineGenerateParameters() {
        ElGamalParametersGenerator elGamalParametersGenerator = new ElGamalParametersGenerator();
        if (this.f27412a != null) {
            elGamalParametersGenerator.m27453a(this.f27413b, 20, this.f27412a);
        } else {
            elGamalParametersGenerator.m27453a(this.f27413b, 20, new SecureRandom());
        }
        ElGamalParameters a = elGamalParametersGenerator.m27452a();
        try {
            AlgorithmParameters a2 = m27989a("ElGamal");
            a2.init(new DHParameterSpec(a.m35655a(), a.m35656b(), this.f27414c));
            return a2;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
