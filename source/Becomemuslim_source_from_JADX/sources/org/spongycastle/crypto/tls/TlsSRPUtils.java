package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Hashtable;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.Integers;

public class TlsSRPUtils {
    /* renamed from: a */
    public static final Integer f22632a = Integers.m29396a(12);

    /* renamed from: a */
    public static boolean m27784a(int i) {
        switch (i) {
            case 49178:
            case 49179:
            case 49180:
            case 49181:
            case 49182:
            case 49183:
            case 49184:
            case 49185:
            case 49186:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public static byte[] m27785a(Hashtable hashtable) {
        byte[] a = TlsUtils.m27827a(hashtable, f22632a);
        if (a == null) {
            return null;
        }
        return m27786a(a);
    }

    /* renamed from: a */
    public static byte[] m27786a(byte[] bArr) {
        if (bArr != null) {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            bArr = TlsUtils.m27872e(byteArrayInputStream);
            TlsProtocol.m27739d(byteArrayInputStream);
            return bArr;
        }
        throw new IllegalArgumentException("'extensionData' cannot be null");
    }

    /* renamed from: a */
    public static BigInteger m27782a(InputStream inputStream) {
        return new BigInteger(1, TlsUtils.m27875f(inputStream));
    }

    /* renamed from: a */
    public static void m27783a(BigInteger bigInteger, OutputStream outputStream) {
        TlsUtils.m27844b(BigIntegers.m29389a(bigInteger), outputStream);
    }
}
