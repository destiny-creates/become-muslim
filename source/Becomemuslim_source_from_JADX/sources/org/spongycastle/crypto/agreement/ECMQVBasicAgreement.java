package org.spongycastle.crypto.agreement;

import java.math.BigInteger;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.MQVPrivateParameters;
import org.spongycastle.crypto.params.MQVPublicParameters;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Properties;

public class ECMQVBasicAgreement implements BasicAgreement {
    /* renamed from: a */
    MQVPrivateParameters f26475a;

    /* renamed from: a */
    public void mo5724a(CipherParameters cipherParameters) {
        this.f26475a = (MQVPrivateParameters) cipherParameters;
    }

    /* renamed from: a */
    public int mo5723a() {
        return (this.f26475a.m35687a().m40792b().m35647a().mo6540a() + 7) / 8;
    }

    /* renamed from: b */
    public BigInteger mo5725b(CipherParameters cipherParameters) {
        if (Properties.m29413a("org.spongycastle.ec.disable_mqv")) {
            throw new IllegalStateException("ECMQV explicitly disabled");
        }
        MQVPublicParameters mQVPublicParameters = (MQVPublicParameters) cipherParameters;
        ECPrivateKeyParameters a = this.f26475a.m35687a();
        cipherParameters = m34711a(a.m40792b(), a, this.f26475a.m35688b(), this.f26475a.m35689c(), mQVPublicParameters.m35690a(), mQVPublicParameters.m35691b()).m28418p();
        if (!cipherParameters.m28419q()) {
            return cipherParameters.m28409g().mo6549a();
        }
        throw new IllegalStateException("Infinity is not a valid agreement value for MQV");
    }

    /* renamed from: a */
    private ECPoint m34711a(ECDomainParameters eCDomainParameters, ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters, ECPublicKeyParameters eCPublicKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters3) {
        BigInteger c = eCDomainParameters.m35649c();
        int bitLength = (c.bitLength() + 1) / 2;
        BigInteger shiftLeft = ECConstants.f23076d.shiftLeft(bitLength);
        ECCurve a = eCDomainParameters.m35647a();
        ECPoint[] eCPointArr = new ECPoint[3];
        eCPointArr[0] = ECAlgorithms.m28340a(a, eCPublicKeyParameters == null ? eCDomainParameters.m35648b().m28393a(eCPrivateKeyParameters2.m43369c()) : eCPublicKeyParameters.m43370c());
        eCPointArr[1] = ECAlgorithms.m28340a(a, eCPublicKeyParameters2.m43370c());
        eCPointArr[2] = ECAlgorithms.m28340a(a, eCPublicKeyParameters3.m43370c());
        a.m28370a(eCPointArr);
        eCPublicKeyParameters = eCPointArr[0];
        ECPoint eCPoint = eCPointArr[1];
        ECPoint eCPoint2 = eCPointArr[2];
        eCPrivateKeyParameters = eCPrivateKeyParameters.m43369c().multiply(eCPublicKeyParameters.m28409g().mo6549a().mod(shiftLeft).setBit(bitLength)).add(eCPrivateKeyParameters2.m43369c()).mod(c);
        eCPrivateKeyParameters2 = eCPoint2.m28409g().mo6549a().mod(shiftLeft).setBit(bitLength);
        BigInteger mod = eCDomainParameters.m35650d().multiply(eCPrivateKeyParameters).mod(c);
        return ECAlgorithms.m28343a(eCPoint, eCPrivateKeyParameters2.multiply(mod).mod(c), eCPoint2, mod);
    }
}
