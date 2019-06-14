package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.generators.ECKeyPairGenerator;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECConstants;

public class ECNRSigner implements DSA {
    /* renamed from: a */
    private boolean f27253a;
    /* renamed from: b */
    private ECKeyParameters f27254b;
    /* renamed from: c */
    private SecureRandom f27255c;

    /* renamed from: a */
    public void mo5800a(boolean z, CipherParameters cipherParameters) {
        this.f27253a = z;
        if (!z) {
            this.f27254b = (ECPublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f27255c = parametersWithRandom.m35697a();
            this.f27254b = (ECPrivateKeyParameters) parametersWithRandom.m35698b();
        } else {
            this.f27255c = new SecureRandom();
            this.f27254b = (ECPrivateKeyParameters) cipherParameters;
        }
    }

    /* renamed from: a */
    public BigInteger[] mo5802a(byte[] bArr) {
        if (this.f27253a) {
            BigInteger c = ((ECPrivateKeyParameters) this.f27254b).m40792b().m35649c();
            int bitLength = c.bitLength();
            BigInteger bigInteger = new BigInteger(1, bArr);
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) this.f27254b;
            if (bigInteger.bitLength() <= bitLength) {
                BigInteger mod;
                do {
                    bArr = new ECKeyPairGenerator();
                    bArr.m35332a(new ECKeyGenerationParameters(eCPrivateKeyParameters.m40792b(), this.f27255c));
                    bArr = bArr.mo5755a();
                    mod = ((ECPublicKeyParameters) bArr.m27281a()).m43370c().m28409g().mo6549a().add(bigInteger).mod(c);
                } while (mod.equals(ECConstants.f23075c));
                bArr = ((ECPrivateKeyParameters) bArr.m27282b()).m43369c().subtract(mod.multiply(eCPrivateKeyParameters.m43369c())).mod(c);
                return new BigInteger[]{mod, bArr};
            }
            throw new DataLengthException("input too large for ECNR key.");
        }
        throw new IllegalStateException("not initialised for signing");
    }

    /* renamed from: a */
    public boolean mo5801a(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        if (this.f27253a) {
            throw new IllegalStateException("not initialised for verifying");
        }
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) this.f27254b;
        BigInteger c = eCPublicKeyParameters.m40792b().m35649c();
        int bitLength = c.bitLength();
        BigInteger bigInteger3 = new BigInteger(1, bArr);
        if (bigInteger3.bitLength() <= bitLength) {
            if (bigInteger.compareTo(ECConstants.f23076d) >= null) {
                if (bigInteger.compareTo(c) < null) {
                    if (bigInteger2.compareTo(ECConstants.f23075c) >= null) {
                        if (bigInteger2.compareTo(c) < null) {
                            bArr = ECAlgorithms.m28343a(eCPublicKeyParameters.m40792b().m35648b(), bigInteger2, eCPublicKeyParameters.m43370c(), bigInteger).m28418p();
                            if (bArr.m28419q() != null) {
                                return false;
                            }
                            return bigInteger.subtract(bArr.m28409g().mo6549a()).mod(c).equals(bigInteger3);
                        }
                    }
                    return false;
                }
            }
            return false;
        }
        throw new DataLengthException("input too large for ECNR key.");
    }
}
