package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.math.ec.ECCurve;

public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    /* renamed from: a */
    private ECParameterSpec f22747a;
    /* renamed from: b */
    private String f22748b;

    protected String engineToString() {
        return "EC AlgorithmParameters ";
    }

    /* renamed from: a */
    protected boolean m27967a(String str) {
        if (str != null) {
            if (str.equals("ASN.1") == null) {
                return null;
            }
        }
        return true;
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
        StringBuilder stringBuilder;
        if (algorithmParameterSpec instanceof ECGenParameterSpec) {
            ECGenParameterSpec eCGenParameterSpec = (ECGenParameterSpec) algorithmParameterSpec;
            X9ECParameters a = ECUtils.m27969a(eCGenParameterSpec);
            if (a != null) {
                this.f22748b = eCGenParameterSpec.getName();
                this.f22747a = EC5Util.m27998a(a);
                return;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("EC curve name not recognized: ");
            stringBuilder.append(eCGenParameterSpec.getName());
            throw new InvalidParameterSpecException(stringBuilder.toString());
        } else if (algorithmParameterSpec instanceof ECParameterSpec) {
            this.f22748b = null;
            this.f22747a = (ECParameterSpec) algorithmParameterSpec;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("AlgorithmParameterSpec class not recognized: ");
            stringBuilder.append(algorithmParameterSpec.getClass().getName());
            throw new InvalidParameterSpecException(stringBuilder.toString());
        }
    }

    protected void engineInit(byte[] bArr) {
        engineInit(bArr, "ASN.1");
    }

    protected void engineInit(byte[] bArr, String str) {
        if (m27967a(str)) {
            X962Parameters a = X962Parameters.m40506a(bArr);
            ECCurve a2 = EC5Util.m28002a(BouncyCastleProvider.f27551a, a);
            if (a.m40507a()) {
                this.f22748b = ECNamedCurveTable.m27260a(ASN1ObjectIdentifier.m42973a(a.m40509c()));
            }
            this.f22747a = EC5Util.m27997a(a, a2);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown encoded parameters format in AlgorithmParameters object: ");
        stringBuilder.append(str);
        throw new IOException(stringBuilder.toString());
    }

    protected <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) {
        if (!ECParameterSpec.class.isAssignableFrom(cls)) {
            if (cls != AlgorithmParameterSpec.class) {
                if (ECGenParameterSpec.class.isAssignableFrom(cls)) {
                    if (this.f22748b != null) {
                        String substring;
                        if (this.f22748b.indexOf(32) > null) {
                            substring = this.f22748b.substring(this.f22748b.indexOf(32) + 1);
                        } else {
                            substring = this.f22748b;
                        }
                        cls = ECUtil.m28006a(substring);
                        if (cls != null) {
                            return new ECGenParameterSpec(cls.m42986b());
                        }
                        return new ECGenParameterSpec(this.f22748b);
                    }
                    ASN1ObjectIdentifier a = ECUtil.m28007a(EC5Util.m28000a(this.f22747a, false));
                    if (a != null) {
                        return new ECGenParameterSpec(a.m42986b());
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("EC AlgorithmParameters cannot convert to ");
                stringBuilder.append(cls.getName());
                throw new InvalidParameterSpecException(stringBuilder.toString());
            }
        }
        return this.f22747a;
    }

    protected byte[] engineGetEncoded() {
        return engineGetEncoded("ASN.1");
    }

    protected byte[] engineGetEncoded(String str) {
        if (m27967a(str)) {
            if (this.f22747a == null) {
                str = new X962Parameters(DERNull.f32850a);
            } else if (this.f22748b != null) {
                str = new X962Parameters(ECNamedCurveTable.m27264b(this.f22748b));
            } else {
                str = EC5Util.m28000a(this.f22747a, false);
                str = new X962Parameters(new X9ECParameters(str.m28315b(), str.m28316c(), str.m28317d(), str.m28318e(), str.m28319f()));
            }
            return str.mo6822f();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown parameters format in AlgorithmParameters object: ");
        stringBuilder.append(str);
        throw new IOException(stringBuilder.toString());
    }
}
