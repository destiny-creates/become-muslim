package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Hashtable;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.agreement.ECDHBasicAgreement;
import org.spongycastle.crypto.ec.CustomNamedCurves;
import org.spongycastle.crypto.generators.ECKeyPairGenerator;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECCurve.F2m;
import org.spongycastle.math.ec.ECCurve.Fp;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.field.PolynomialExtensionField;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.Integers;

public class TlsECCUtils {
    /* renamed from: a */
    public static final Integer f22581a = Integers.m29396a(10);
    /* renamed from: b */
    public static final Integer f22582b = Integers.m29396a(11);
    /* renamed from: c */
    private static final String[] f22583c = new String[]{"sect163k1", "sect163r1", "sect163r2", "sect193r1", "sect193r2", "sect233k1", "sect233r1", "sect239k1", "sect283k1", "sect283r1", "sect409k1", "sect409r1", "sect571k1", "sect571r1", "secp160k1", "secp160r1", "secp160r2", "secp192k1", "secp192r1", "secp224k1", "secp224r1", "secp256k1", "secp256r1", "secp384r1", "secp521r1", "brainpoolP256r1", "brainpoolP384r1", "brainpoolP512r1"};

    /* renamed from: a */
    public static ECPublicKeyParameters m27656a(ECPublicKeyParameters eCPublicKeyParameters) {
        return eCPublicKeyParameters;
    }

    /* renamed from: c */
    public static boolean m27679c(int i) {
        switch (i) {
            case 49153:
            case 49154:
            case 49155:
            case 49156:
            case 49157:
            case 49158:
            case 49159:
            case 49160:
            case 49161:
            case 49162:
            case 49163:
            case 49164:
            case 49165:
            case 49166:
            case 49167:
            case 49168:
            case 49169:
            case 49170:
            case 49171:
            case 49172:
            case 49173:
            case 49174:
            case 49175:
            case 49176:
            case 49177:
                break;
            default:
                switch (i) {
                    case 49187:
                    case 49188:
                    case 49189:
                    case 49190:
                    case 49191:
                    case 49192:
                    case 49193:
                    case 49194:
                    case 49195:
                    case 49196:
                    case 49197:
                    case 49198:
                    case 49199:
                    case 49200:
                    case 49201:
                    case 49202:
                    case 49203:
                    case 49204:
                    case 49205:
                    case 49206:
                    case 49207:
                    case 49208:
                    case 49209:
                    case 49210:
                    case 49211:
                        break;
                    default:
                        switch (i) {
                            case 49266:
                            case 49267:
                            case 49268:
                            case 49269:
                            case 49270:
                            case 49271:
                            case 49272:
                            case 49273:
                                break;
                            default:
                                switch (i) {
                                    case 49286:
                                    case 49287:
                                    case 49288:
                                    case 49289:
                                    case 49290:
                                    case 49291:
                                    case 49292:
                                    case 49293:
                                        break;
                                    default:
                                        switch (i) {
                                            case 49306:
                                            case 49307:
                                                break;
                                            default:
                                                switch (i) {
                                                    case 49324:
                                                    case 49325:
                                                    case 49326:
                                                    case 49327:
                                                        break;
                                                    default:
                                                        switch (i) {
                                                            case 52243:
                                                            case 52244:
                                                                break;
                                                            default:
                                                                switch (i) {
                                                                    case 58386:
                                                                    case 58387:
                                                                    case 58388:
                                                                    case 58389:
                                                                        break;
                                                                    default:
                                                                        switch (i) {
                                                                            case 58392:
                                                                            case 58393:
                                                                                break;
                                                                            default:
                                                                                return false;
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
        return true;
    }

    /* renamed from: a */
    public static void m27661a(Hashtable hashtable, short[] sArr) {
        hashtable.put(f22582b, m27670a(sArr));
    }

    /* renamed from: a */
    public static int[] m27672a(Hashtable hashtable) {
        byte[] a = TlsUtils.m27827a(hashtable, f22581a);
        if (a == null) {
            return null;
        }
        return m27673a(a);
    }

    /* renamed from: b */
    public static short[] m27677b(Hashtable hashtable) {
        byte[] a = TlsUtils.m27827a(hashtable, f22582b);
        if (a == null) {
            return null;
        }
        return m27678b(a);
    }

    /* renamed from: a */
    public static byte[] m27670a(short[] sArr) {
        if (sArr == null || !Arrays.m29359a(sArr, (short) 0)) {
            sArr = Arrays.m29384c(sArr, (short) 0);
        }
        return TlsUtils.m27836a(sArr);
    }

    /* renamed from: a */
    public static int[] m27673a(byte[] bArr) {
        if (bArr != null) {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            bArr = TlsUtils.m27837b(byteArrayInputStream);
            if (bArr < 2 || (bArr & 1) != 0) {
                throw new TlsFatalAlert((short) 50);
            }
            bArr = TlsUtils.m27867d(bArr / 2, byteArrayInputStream);
            TlsProtocol.m27739d(byteArrayInputStream);
            return bArr;
        }
        throw new IllegalArgumentException("'extensionData' cannot be null");
    }

    /* renamed from: b */
    public static short[] m27678b(byte[] bArr) {
        if (bArr != null) {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            int a = TlsUtils.m27802a(byteArrayInputStream);
            if (a >= 1) {
                short[] c = TlsUtils.m27861c(a, byteArrayInputStream);
                TlsProtocol.m27739d(byteArrayInputStream);
                if (Arrays.m29359a(c, (short) 0)) {
                    return c;
                }
                throw new TlsFatalAlert((short) 47);
            }
            throw new TlsFatalAlert((short) 50);
        }
        throw new IllegalArgumentException("'extensionData' cannot be null");
    }

    /* renamed from: a */
    public static String m27649a(int i) {
        return m27680d(i) ? f22583c[i - 1] : 0;
    }

    /* renamed from: b */
    public static ECDomainParameters m27675b(int i) {
        String a = m27649a(i);
        if (a == 0) {
            return null;
        }
        X9ECParameters a2 = CustomNamedCurves.m27403a(a);
        if (a2 == null) {
            a2 = ECNamedCurveTable.m27262a(a);
            if (a2 == null) {
                return null;
            }
        }
        return new ECDomainParameters(a2.m40516a(), a2.m40517b(), a2.m40518c(), a2.m40519d(), a2.m40521g());
    }

    /* renamed from: a */
    public static boolean m27666a() {
        return f22583c.length > 0;
    }

    /* renamed from: a */
    public static boolean m27667a(int[] iArr) {
        for (int c : iArr) {
            if (m27679c(c)) {
                return 1;
            }
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m27680d(int i) {
        return i > 0 && i <= f22583c.length;
    }

    /* renamed from: a */
    public static boolean m27668a(short[] sArr, short s) {
        if (sArr == null) {
            return false;
        }
        for (short s2 : sArr) {
            if (s2 == (short) 0) {
                return false;
            }
            if (s2 == s) {
                return 1;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static byte[] m27671a(short[] sArr, ECPoint eCPoint) {
        ECCurve d = eCPoint.m28406d();
        boolean a = ECAlgorithms.m28354b(d) ? m27668a(sArr, (short) 1) : ECAlgorithms.m28351a(d) ? m27668a(sArr, (short) 2) : null;
        return eCPoint.m28398a(a);
    }

    /* renamed from: a */
    public static BigInteger m27650a(int i, byte[] bArr) {
        if (bArr.length == (i + 7) / 8) {
            return new BigInteger(1, bArr);
        }
        throw new TlsFatalAlert(50);
    }

    /* renamed from: a */
    public static ECPoint m27658a(short[] sArr, ECCurve eCCurve, byte[] bArr) {
        if (bArr != null) {
            short s = (short) 1;
            if (bArr.length >= 1) {
                switch (bArr[0]) {
                    case (byte) 2:
                    case (byte) 3:
                        if (ECAlgorithms.m28351a(eCCurve)) {
                            s = (short) 2;
                            break;
                        } else if (!ECAlgorithms.m28354b(eCCurve)) {
                            throw new TlsFatalAlert((short) 47);
                        }
                        break;
                    case (byte) 4:
                        s = (short) 0;
                        break;
                    default:
                        throw new TlsFatalAlert((short) 47);
                }
                if (s != (short) 0) {
                    if (sArr == null || Arrays.m29359a(sArr, s) == null) {
                        throw new TlsFatalAlert((short) 47);
                    }
                }
                return eCCurve.m28367a(bArr);
            }
        }
        throw new TlsFatalAlert((short) 47);
    }

    /* renamed from: a */
    public static ECPublicKeyParameters m27657a(short[] sArr, ECDomainParameters eCDomainParameters, byte[] bArr) {
        try {
            return new ECPublicKeyParameters(m27658a(sArr, eCDomainParameters.m35647a(), bArr), eCDomainParameters);
        } catch (short[] sArr2) {
            throw new TlsFatalAlert(47, sArr2);
        }
    }

    /* renamed from: a */
    public static byte[] m27669a(ECPublicKeyParameters eCPublicKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters) {
        ECDHBasicAgreement eCDHBasicAgreement = new ECDHBasicAgreement();
        eCDHBasicAgreement.mo5724a(eCPrivateKeyParameters);
        return BigIntegers.m29388a(eCDHBasicAgreement.mo5723a(), eCDHBasicAgreement.mo5725b(eCPublicKeyParameters));
    }

    /* renamed from: a */
    public static AsymmetricCipherKeyPair m27652a(SecureRandom secureRandom, ECDomainParameters eCDomainParameters) {
        ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
        eCKeyPairGenerator.m35332a(new ECKeyGenerationParameters(eCDomainParameters, secureRandom));
        return eCKeyPairGenerator.mo5755a();
    }

    /* renamed from: a */
    public static ECPrivateKeyParameters m27655a(SecureRandom secureRandom, short[] sArr, ECDomainParameters eCDomainParameters, OutputStream outputStream) {
        secureRandom = m27652a(secureRandom, eCDomainParameters);
        m27665a(sArr, ((ECPublicKeyParameters) secureRandom.m27281a()).m43370c(), outputStream);
        return (ECPrivateKeyParameters) secureRandom.m27282b();
    }

    /* renamed from: a */
    static ECPrivateKeyParameters m27654a(SecureRandom secureRandom, int[] iArr, short[] sArr, OutputStream outputStream) {
        int i;
        if (iArr == null) {
            i = 23;
        } else {
            for (int i2 : iArr) {
                if (NamedCurve.m27561a(i2) && m27680d(i2)) {
                    i = i2;
                    break;
                }
            }
            i = -1;
        }
        ECDomainParameters eCDomainParameters = null;
        if (i >= 0) {
            eCDomainParameters = m27675b(i);
        } else if (Arrays.m29355a(iArr, 65281)) {
            eCDomainParameters = m27675b(23);
        } else if (Arrays.m29355a(iArr, 65282) != null) {
            eCDomainParameters = m27675b((int) 10);
        }
        if (eCDomainParameters != null) {
            if (i < 0) {
                m27664a(sArr, eCDomainParameters, outputStream);
            } else {
                m27676b(i, outputStream);
            }
            return m27655a(secureRandom, sArr, eCDomainParameters, outputStream);
        }
        throw new TlsFatalAlert(80);
    }

    /* renamed from: a */
    public static int m27648a(int i, InputStream inputStream) {
        inputStream = m27651a(inputStream);
        if (inputStream.bitLength() < 32) {
            inputStream = inputStream.intValue();
            if (inputStream > null && inputStream < i) {
                return inputStream;
            }
        }
        throw new TlsFatalAlert((short) 47);
    }

    /* renamed from: b */
    public static BigInteger m27674b(int i, InputStream inputStream) {
        return m27650a(i, TlsUtils.m27872e(inputStream));
    }

    /* renamed from: a */
    public static BigInteger m27651a(InputStream inputStream) {
        return new BigInteger(1, TlsUtils.m27872e(inputStream));
    }

    /* renamed from: a */
    public static ECDomainParameters m27653a(int[] iArr, short[] sArr, InputStream inputStream) {
        try {
            ECCurve fp;
            switch (TlsUtils.m27802a(inputStream)) {
                case (short) 1:
                    m27663a(iArr, 65281);
                    BigInteger a = m27651a(inputStream);
                    BigInteger b = m27674b(a.bitLength(), inputStream);
                    BigInteger b2 = m27674b(a.bitLength(), inputStream);
                    byte[] e = TlsUtils.m27872e(inputStream);
                    BigInteger a2 = m27651a(inputStream);
                    inputStream = m27651a(inputStream);
                    fp = new Fp(a, b, b2, a2, inputStream);
                    return new ECDomainParameters(fp, m27658a(sArr, fp, e), a2, inputStream);
                case (short) 2:
                    m27663a(iArr, 65282);
                    int b3 = TlsUtils.m27837b(inputStream);
                    iArr = TlsUtils.m27802a(inputStream);
                    if (ECBasisType.m27559a(iArr)) {
                        int a3;
                        int i;
                        int a4 = m27648a(b3, inputStream);
                        if (iArr == 2) {
                            int a5 = m27648a(b3, inputStream);
                            a3 = m27648a(b3, inputStream);
                            i = a5;
                        } else {
                            i = -1;
                            a3 = -1;
                        }
                        BigInteger b4 = m27674b(b3, inputStream);
                        BigInteger b5 = m27674b(b3, inputStream);
                        byte[] e2 = TlsUtils.m27872e(inputStream);
                        BigInteger a6 = m27651a(inputStream);
                        inputStream = m27651a(inputStream);
                        if (iArr == 2) {
                            fp = new F2m(b3, a4, i, a3, b4, b5, a6, (BigInteger) inputStream);
                        } else {
                            fp = new F2m(b3, a4, b4, b5, a6, (BigInteger) inputStream);
                        }
                        return new ECDomainParameters(r13, m27658a(sArr, r13, e2), a6, inputStream);
                    }
                    throw new TlsFatalAlert((short) 47);
                case (short) 3:
                    int b6 = TlsUtils.m27837b(inputStream);
                    if (NamedCurve.m27562b(b6) != null) {
                        m27663a(iArr, b6);
                        return m27675b(b6);
                    }
                    throw new TlsFatalAlert((short) 47);
                default:
                    throw new TlsFatalAlert((short) 47);
            }
        } catch (int[] iArr2) {
            throw new TlsFatalAlert((short) 47, iArr2);
        }
    }

    /* renamed from: a */
    private static void m27663a(int[] iArr, int i) {
        if (iArr == null) {
            return;
        }
        if (Arrays.m29355a(iArr, i) == null) {
            throw new TlsFatalAlert(47);
        }
    }

    /* renamed from: a */
    public static void m27659a(int i, OutputStream outputStream) {
        m27660a(BigInteger.valueOf((long) i), outputStream);
    }

    /* renamed from: a */
    public static void m27662a(ECFieldElement eCFieldElement, OutputStream outputStream) {
        TlsUtils.m27819a(eCFieldElement.m36293l(), outputStream);
    }

    /* renamed from: a */
    public static void m27660a(BigInteger bigInteger, OutputStream outputStream) {
        TlsUtils.m27819a(BigIntegers.m29389a(bigInteger), outputStream);
    }

    /* renamed from: a */
    public static void m27664a(short[] sArr, ECDomainParameters eCDomainParameters, OutputStream outputStream) {
        ECCurve a = eCDomainParameters.m35647a();
        if (ECAlgorithms.m28354b(a)) {
            TlsUtils.m27817a((short) 1, outputStream);
            m27660a(a.m28382f().mo5911a(), outputStream);
        } else if (ECAlgorithms.m28351a(a)) {
            int[] b = ((PolynomialExtensionField) a.m28382f()).mo6823c().mo5910b();
            TlsUtils.m27817a((short) 2, outputStream);
            int i = b[b.length - 1];
            TlsUtils.m27841b(i);
            TlsUtils.m27842b(i, outputStream);
            if (b.length == 3) {
                TlsUtils.m27817a((short) 1, outputStream);
                m27659a(b[1], outputStream);
            } else if (b.length == 5) {
                TlsUtils.m27817a((short) 2, outputStream);
                m27659a(b[1], outputStream);
                m27659a(b[2], outputStream);
                m27659a(b[3], outputStream);
            } else {
                throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
            }
        } else {
            throw new IllegalArgumentException("'ecParameters' not a known curve type");
        }
        m27662a(a.m28383g(), outputStream);
        m27662a(a.m28384h(), outputStream);
        TlsUtils.m27819a(m27671a(sArr, eCDomainParameters.m35648b()), outputStream);
        m27660a(eCDomainParameters.m35649c(), outputStream);
        m27660a(eCDomainParameters.m35650d(), outputStream);
    }

    /* renamed from: a */
    public static void m27665a(short[] sArr, ECPoint eCPoint, OutputStream outputStream) {
        TlsUtils.m27819a(m27671a(sArr, eCPoint), outputStream);
    }

    /* renamed from: b */
    public static void m27676b(int i, OutputStream outputStream) {
        if (NamedCurve.m27562b(i)) {
            TlsUtils.m27817a((short) 3, outputStream);
            TlsUtils.m27841b(i);
            TlsUtils.m27842b(i, outputStream);
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }
}
