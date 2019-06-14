package org.spongycastle.crypto.tls;

import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.soloader.MinElf;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.KeyUsage;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.util.PublicKeyFactory;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Strings;
import org.spongycastle.util.io.Streams;

public class TlsUtils {
    /* renamed from: a */
    public static final byte[] f22634a = new byte[0];
    /* renamed from: b */
    public static final short[] f22635b = new short[0];
    /* renamed from: c */
    public static final int[] f22636c = new int[0];
    /* renamed from: d */
    public static final long[] f22637d = new long[0];
    /* renamed from: e */
    public static final Integer f22638e = Integers.m29396a(13);
    /* renamed from: f */
    static final byte[] f22639f = new byte[]{(byte) 67, (byte) 76, (byte) 78, (byte) 84};
    /* renamed from: g */
    static final byte[] f22640g = new byte[]{(byte) 83, (byte) 82, (byte) 86, (byte) 82};
    /* renamed from: h */
    static final byte[][] f22641h = m27868d();

    /* renamed from: b */
    public static boolean m27848b(short s) {
        return (s & JfifUtil.MARKER_FIRST_BYTE) == s;
    }

    /* renamed from: d */
    public static boolean m27866d(int i) {
        return (i & JfifUtil.MARKER_FIRST_BYTE) == i;
    }

    /* renamed from: e */
    public static boolean m27870e(int i) {
        return (MinElf.PN_XNUM & i) == i;
    }

    /* renamed from: e */
    public static boolean m27871e(short s) {
        if (s != (short) 64) {
            switch (s) {
                case (short) 1:
                case (short) 2:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public static boolean m27874f(int i) {
        return (16777215 & i) == i;
    }

    /* renamed from: a */
    public static void m27816a(short s) {
        if (m27848b(s) == (short) 0) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    /* renamed from: a */
    public static void m27805a(int i) {
        if (m27866d(i) == 0) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    /* renamed from: b */
    public static void m27841b(int i) {
        if (m27870e(i) == 0) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    /* renamed from: c */
    public static void m27856c(int i) {
        if (m27874f(i) == 0) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    /* renamed from: a */
    public static boolean m27825a(TlsContext tlsContext) {
        return tlsContext.mo5812e().m27573d();
    }

    /* renamed from: b */
    public static boolean m27847b(TlsContext tlsContext) {
        return ProtocolVersion.f22513c.m27568a(tlsContext.mo5812e().m27574e());
    }

    /* renamed from: c */
    public static boolean m27860c(TlsContext tlsContext) {
        return ProtocolVersion.f22514d.m27568a(tlsContext.mo5812e().m27574e());
    }

    /* renamed from: a */
    public static void m27817a(short s, OutputStream outputStream) {
        outputStream.write(s);
    }

    /* renamed from: a */
    public static void m27806a(int i, OutputStream outputStream) {
        outputStream.write(i);
    }

    /* renamed from: a */
    public static void m27818a(short s, byte[] bArr, int i) {
        bArr[i] = (byte) s;
    }

    /* renamed from: a */
    public static void m27807a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
    }

    /* renamed from: b */
    public static void m27842b(int i, OutputStream outputStream) {
        outputStream.write(i >>> 8);
        outputStream.write(i);
    }

    /* renamed from: b */
    public static void m27843b(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 8);
        bArr[i2 + 1] = (byte) i;
    }

    /* renamed from: c */
    public static void m27857c(int i, OutputStream outputStream) {
        outputStream.write((byte) (i >>> 16));
        outputStream.write((byte) (i >>> 8));
        outputStream.write((byte) i);
    }

    /* renamed from: c */
    public static void m27858c(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 16);
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) i;
    }

    /* renamed from: a */
    public static void m27808a(long j, OutputStream outputStream) {
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) j));
    }

    /* renamed from: a */
    public static void m27809a(long j, byte[] bArr, int i) {
        bArr[i] = (byte) ((int) (j >>> 56));
        bArr[i + 1] = (byte) ((int) (j >>> 48));
        bArr[i + 2] = (byte) ((int) (j >>> 40));
        bArr[i + 3] = (byte) ((int) (j >>> 32));
        bArr[i + 4] = (byte) ((int) (j >>> 24));
        bArr[i + 5] = (byte) ((int) (j >>> 16));
        bArr[i + 6] = (byte) ((int) (j >>> 8));
        bArr[i + 7] = (byte) ((int) j);
    }

    /* renamed from: a */
    public static void m27819a(byte[] bArr, OutputStream outputStream) {
        m27805a(bArr.length);
        m27806a(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    /* renamed from: b */
    public static void m27844b(byte[] bArr, OutputStream outputStream) {
        m27841b(bArr.length);
        m27842b(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    /* renamed from: c */
    public static void m27859c(byte[] bArr, OutputStream outputStream) {
        m27856c(bArr.length);
        m27857c(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    /* renamed from: a */
    public static void m27820a(short[] sArr, OutputStream outputStream) {
        for (short a : sArr) {
            m27817a(a, outputStream);
        }
    }

    /* renamed from: a */
    public static void m27821a(short[] sArr, byte[] bArr, int i) {
        for (short a : sArr) {
            m27818a(a, bArr, i);
            i++;
        }
    }

    /* renamed from: b */
    public static void m27845b(short[] sArr, OutputStream outputStream) {
        m27805a(sArr.length);
        m27806a(sArr.length, outputStream);
        m27820a(sArr, outputStream);
    }

    /* renamed from: b */
    public static void m27846b(short[] sArr, byte[] bArr, int i) {
        m27805a(sArr.length);
        m27807a(sArr.length, bArr, i);
        m27821a(sArr, bArr, i + 1);
    }

    /* renamed from: a */
    public static byte[] m27832a(byte[] bArr) {
        m27805a(bArr.length);
        return Arrays.m29374b(bArr, (byte) bArr.length);
    }

    /* renamed from: a */
    public static byte[] m27836a(short[] sArr) {
        byte[] bArr = new byte[(sArr.length + 1)];
        m27846b(sArr, bArr, 0);
        return bArr;
    }

    /* renamed from: a */
    public static short m27802a(InputStream inputStream) {
        inputStream = inputStream.read();
        if (inputStream >= null) {
            return (short) inputStream;
        }
        throw new EOFException();
    }

    /* renamed from: a */
    public static short m27804a(byte[] bArr, int i) {
        return (short) bArr[i];
    }

    /* renamed from: b */
    public static int m27837b(InputStream inputStream) {
        int read = inputStream.read();
        inputStream = inputStream.read();
        if (inputStream >= null) {
            return inputStream | (read << 8);
        }
        throw new EOFException();
    }

    /* renamed from: b */
    public static int m27838b(byte[] bArr, int i) {
        return (bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 8);
    }

    /* renamed from: c */
    public static int m27851c(InputStream inputStream) {
        int read = inputStream.read();
        int read2 = inputStream.read();
        inputStream = inputStream.read();
        if (inputStream >= null) {
            return inputStream | ((read << 16) | (read2 << 8));
        }
        throw new EOFException();
    }

    /* renamed from: c */
    public static int m27852c(byte[] bArr, int i) {
        i++;
        return (bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) | (((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 16) | ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 8));
    }

    /* renamed from: d */
    public static long m27862d(InputStream inputStream) {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        inputStream = inputStream.read();
        if (inputStream >= null) {
            return ((long) (inputStream | (((read << 2) | (read2 << 16)) | (read3 << 8)))) & 4294967295L;
        }
        throw new EOFException();
    }

    /* renamed from: a */
    public static byte[] m27826a(int i, InputStream inputStream) {
        if (i < 1) {
            return f22634a;
        }
        byte[] bArr = new byte[i];
        inputStream = Streams.m29439a(inputStream, bArr);
        if (inputStream == null) {
            return 0;
        }
        if (inputStream == i) {
            return bArr;
        }
        throw new EOFException();
    }

    /* renamed from: b */
    public static byte[] m27849b(int i, InputStream inputStream) {
        if (i < 1) {
            return f22634a;
        }
        byte[] bArr = new byte[i];
        if (i == Streams.m29439a(inputStream, bArr)) {
            return bArr;
        }
        throw new EOFException();
    }

    /* renamed from: e */
    public static byte[] m27872e(InputStream inputStream) {
        return m27849b(m27802a(inputStream), inputStream);
    }

    /* renamed from: f */
    public static byte[] m27875f(InputStream inputStream) {
        return m27849b(m27837b(inputStream), inputStream);
    }

    /* renamed from: g */
    public static byte[] m27877g(InputStream inputStream) {
        return m27849b(m27851c(inputStream), inputStream);
    }

    /* renamed from: c */
    public static short[] m27861c(int i, InputStream inputStream) {
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = m27802a(inputStream);
        }
        return sArr;
    }

    /* renamed from: d */
    public static int[] m27867d(int i, InputStream inputStream) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = m27837b(inputStream);
        }
        return iArr;
    }

    /* renamed from: d */
    public static ProtocolVersion m27865d(byte[] bArr, int i) {
        return ProtocolVersion.m27565a(bArr[i] & JfifUtil.MARKER_FIRST_BYTE, bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE);
    }

    /* renamed from: h */
    public static ProtocolVersion m27878h(InputStream inputStream) {
        int read = inputStream.read();
        inputStream = inputStream.read();
        if (inputStream >= null) {
            return ProtocolVersion.m27565a(read, inputStream);
        }
        throw new EOFException();
    }

    /* renamed from: e */
    public static int m27869e(byte[] bArr, int i) {
        return bArr[i + 1] | (bArr[i] << 8);
    }

    /* renamed from: b */
    public static ASN1Primitive m27840b(byte[] bArr) {
        ASN1InputStream aSN1InputStream = new ASN1InputStream(bArr);
        bArr = aSN1InputStream.m34595d();
        if (bArr == null) {
            throw new TlsFatalAlert((short) 50);
        } else if (aSN1InputStream.m34595d() == null) {
            return bArr;
        } else {
            throw new TlsFatalAlert((short) 50);
        }
    }

    /* renamed from: c */
    public static ASN1Primitive m27854c(byte[] bArr) {
        ASN1Primitive b = m27840b(bArr);
        if (Arrays.m29353a(b.m34596a("DER"), bArr) != null) {
            return b;
        }
        throw new TlsFatalAlert((short) 50);
    }

    /* renamed from: a */
    public static void m27813a(ProtocolVersion protocolVersion, OutputStream outputStream) {
        outputStream.write(protocolVersion.m27567a());
        outputStream.write(protocolVersion.m27569b());
    }

    /* renamed from: a */
    public static void m27814a(ProtocolVersion protocolVersion, byte[] bArr, int i) {
        bArr[i] = (byte) protocolVersion.m27567a();
        bArr[i + 1] = (byte) protocolVersion.m27569b();
    }

    /* renamed from: a */
    public static Vector m27795a() {
        return m27796a(new SignatureAndHashAlgorithm((short) 2, (short) 2));
    }

    /* renamed from: b */
    public static Vector m27839b() {
        return m27796a(new SignatureAndHashAlgorithm((short) 2, (short) 3));
    }

    /* renamed from: c */
    public static Vector m27853c() {
        return m27796a(new SignatureAndHashAlgorithm((short) 2, (short) 1));
    }

    /* renamed from: a */
    public static SignatureAndHashAlgorithm m27801a(TlsContext tlsContext, TlsSignerCredentials tlsSignerCredentials) {
        if (m27860c(tlsContext) == null) {
            return null;
        }
        tlsContext = tlsSignerCredentials.S_();
        if (tlsContext != null) {
            return tlsContext;
        }
        throw new TlsFatalAlert((short) 80);
    }

    /* renamed from: a */
    public static byte[] m27827a(Hashtable hashtable, Integer num) {
        return hashtable == null ? null : (byte[]) hashtable.get(num);
    }

    /* renamed from: a */
    public static boolean m27823a(Hashtable hashtable, Integer num, short s) {
        hashtable = m27827a(hashtable, num);
        if (hashtable == null) {
            return null;
        }
        if (hashtable.length == null) {
            return true;
        }
        throw new TlsFatalAlert(s);
    }

    /* renamed from: a */
    public static boolean m27824a(ProtocolVersion protocolVersion) {
        return ProtocolVersion.f22514d.m27568a(protocolVersion.m27574e());
    }

    /* renamed from: a */
    public static Vector m27797a(Hashtable hashtable) {
        byte[] a = m27827a(hashtable, f22638e);
        if (a == null) {
            return null;
        }
        return m27863d(a);
    }

    /* renamed from: d */
    public static Vector m27863d(byte[] bArr) {
        if (bArr != null) {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            bArr = m27798a((boolean) null, byteArrayInputStream);
            TlsProtocol.m27739d(byteArrayInputStream);
            return bArr;
        }
        throw new IllegalArgumentException("'extensionData' cannot be null");
    }

    /* renamed from: a */
    public static void m27810a(Vector vector, boolean z, OutputStream outputStream) {
        if (vector == null || vector.size() < 1 || vector.size() >= 32768) {
            throw new IllegalArgumentException("'supportedSignatureAlgorithms' must have length from 1 to (2^15 - 1)");
        }
        int size = vector.size() * 2;
        m27841b(size);
        m27842b(size, outputStream);
        for (size = 0; size < vector.size(); size++) {
            SignatureAndHashAlgorithm signatureAndHashAlgorithm = (SignatureAndHashAlgorithm) vector.elementAt(size);
            if (!z) {
                if (signatureAndHashAlgorithm.m27620b() == (short) 0) {
                    throw new IllegalArgumentException("SignatureAlgorithm.anonymous MUST NOT appear in the signature_algorithms extension");
                }
            }
            signatureAndHashAlgorithm.m27619a(outputStream);
        }
    }

    /* renamed from: a */
    public static Vector m27798a(boolean z, InputStream inputStream) {
        int b = m27837b(inputStream);
        if (b < 2 || (b & 1) != 0) {
            throw new TlsFatalAlert((short) 50);
        }
        b /= 2;
        Vector vector = new Vector(b);
        for (int i = 0; i < b; i++) {
            SignatureAndHashAlgorithm a = SignatureAndHashAlgorithm.m27617a(inputStream);
            if (!z) {
                if (a.m27620b() == (short) 0) {
                    throw new TlsFatalAlert((short) 47);
                }
            }
            vector.addElement(a);
        }
        return vector;
    }

    /* renamed from: a */
    public static byte[] m27831a(TlsContext tlsContext, byte[] bArr, String str, byte[] bArr2, int i) {
        if (tlsContext.mo5812e().m27573d()) {
            throw new IllegalStateException("No PRF available for SSLv3 session");
        }
        byte[] d = Strings.m29429d(str);
        bArr2 = m27833a(d, bArr2);
        int b = tlsContext.mo5810c().m27597b();
        if (b == null) {
            return m27835a(bArr, d, bArr2, i);
        }
        d = new byte[i];
        m27812a(m27876g(b), bArr, bArr2, d);
        return d;
    }

    /* renamed from: a */
    static byte[] m27835a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        bArr2 = (bArr.length + 1) / 2;
        byte[] bArr4 = new byte[bArr2];
        byte[] bArr5 = new byte[bArr2];
        int i2 = 0;
        System.arraycopy(bArr, 0, bArr4, 0, bArr2);
        System.arraycopy(bArr, bArr.length - bArr2, bArr5, 0, bArr2);
        bArr = new byte[i];
        bArr2 = new byte[i];
        m27812a(m27855c((short) 1), bArr4, bArr3, bArr);
        m27812a(m27855c((short) 2), bArr5, bArr3, bArr2);
        while (i2 < i) {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
            i2++;
        }
        return bArr;
    }

    /* renamed from: a */
    static byte[] m27833a(byte[] bArr, byte[] bArr2) {
        Object obj = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        System.arraycopy(bArr2, 0, obj, bArr.length, bArr2.length);
        return obj;
    }

    /* renamed from: a */
    static void m27812a(Digest digest, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        HMac hMac = new HMac(digest);
        hMac.mo5764a(new KeyParameter(bArr));
        digest = digest.mo5732b();
        bArr = ((bArr3.length + digest) - 1) / digest;
        byte[] bArr4 = new byte[hMac.mo5766b()];
        Object obj = new byte[hMac.mo5766b()];
        byte[] bArr5 = bArr2;
        int i = 0;
        while (i < bArr) {
            hMac.mo5765a(bArr5, 0, bArr5.length);
            hMac.mo5761a(bArr4, 0);
            hMac.mo5765a(bArr4, 0, bArr4.length);
            hMac.mo5765a(bArr2, 0, bArr2.length);
            hMac.mo5761a(obj, 0);
            int i2 = digest * i;
            System.arraycopy(obj, 0, bArr3, i2, Math.min(digest, bArr3.length - i2));
            i++;
            bArr5 = bArr4;
        }
    }

    /* renamed from: a */
    static void m27811a(Certificate certificate, int i) {
        Extensions m = certificate.m40274a().m40442m();
        if (m != null) {
            certificate = KeyUsage.m40376a(m);
            if (certificate == null) {
                return;
            }
            if (((certificate.m40377a()[0] & JfifUtil.MARKER_FIRST_BYTE) & i) != i) {
                throw new TlsFatalAlert(46);
            }
        }
    }

    /* renamed from: a */
    static byte[] m27828a(TlsContext tlsContext, int i) {
        SecurityParameters c = tlsContext.mo5810c();
        byte[] d = c.m27599d();
        byte[] a = m27833a(c.m27601f(), c.m27600e());
        if (m27825a(tlsContext)) {
            return m27834a(d, a, i);
        }
        return m27831a(tlsContext, d, "key expansion", a, i);
    }

    /* renamed from: a */
    static byte[] m27834a(byte[] bArr, byte[] bArr2, int i) {
        Digest c = m27855c((short) 1);
        Digest c2 = m27855c((short) 2);
        int b = c.mo5732b();
        byte[] bArr3 = new byte[c2.mo5732b()];
        byte[] bArr4 = new byte[(i + b)];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            byte[] bArr5 = f22641h[i3];
            c2.mo5731a(bArr5, 0, bArr5.length);
            c2.mo5731a(bArr, 0, bArr.length);
            c2.mo5731a(bArr2, 0, bArr2.length);
            c2.mo5728a(bArr3, 0);
            c.mo5731a(bArr, 0, bArr.length);
            c.mo5731a(bArr3, 0, bArr3.length);
            c.mo5728a(bArr4, i2);
            i2 += b;
            i3++;
        }
        return Arrays.m29361a(bArr4, 0, i);
    }

    /* renamed from: a */
    static byte[] m27830a(TlsContext tlsContext, byte[] bArr) {
        byte[] g;
        SecurityParameters c = tlsContext.mo5810c();
        if (c.f22553o) {
            g = c.m27602g();
        } else {
            g = m27833a(c.m27600e(), c.m27601f());
        }
        if (m27825a(tlsContext)) {
            return m27850b(bArr, g);
        }
        return m27831a(tlsContext, bArr, c.f22553o ? "extended master secret" : "master secret", g, 48);
    }

    /* renamed from: b */
    static byte[] m27850b(byte[] bArr, byte[] bArr2) {
        Digest c = m27855c((short) 1);
        Digest c2 = m27855c((short) 2);
        int b = c.mo5732b();
        byte[] bArr3 = new byte[c2.mo5732b()];
        byte[] bArr4 = new byte[(b * 3)];
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            byte[] bArr5 = f22641h[i2];
            c2.mo5731a(bArr5, 0, bArr5.length);
            c2.mo5731a(bArr, 0, bArr.length);
            c2.mo5731a(bArr2, 0, bArr2.length);
            c2.mo5728a(bArr3, 0);
            c.mo5731a(bArr, 0, bArr.length);
            c.mo5731a(bArr3, 0, bArr3.length);
            c.mo5728a(bArr4, i);
            i += b;
        }
        return bArr4;
    }

    /* renamed from: a */
    static byte[] m27829a(TlsContext tlsContext, String str, byte[] bArr) {
        if (m27825a(tlsContext)) {
            return bArr;
        }
        SecurityParameters c = tlsContext.mo5810c();
        return m27831a(tlsContext, c.m27599d(), str, bArr, c.m27598c());
    }

    /* renamed from: c */
    public static Digest m27855c(short s) {
        switch (s) {
            case (short) 1:
                return new MD5Digest();
            case (short) 2:
                return new SHA1Digest();
            case (short) 3:
                return new SHA224Digest();
            case (short) 4:
                return new SHA256Digest();
            case (short) 5:
                return new SHA384Digest();
            case (short) 6:
                return new SHA512Digest();
            default:
                throw new IllegalArgumentException("unknown HashAlgorithm");
        }
    }

    /* renamed from: a */
    public static Digest m27799a(SignatureAndHashAlgorithm signatureAndHashAlgorithm) {
        if (signatureAndHashAlgorithm == null) {
            return new CombinedHash();
        }
        return m27855c(signatureAndHashAlgorithm.m27618a());
    }

    /* renamed from: a */
    public static Digest m27800a(short s, Digest digest) {
        switch (s) {
            case (short) 1:
                return new MD5Digest((MD5Digest) digest);
            case (short) 2:
                return new SHA1Digest((SHA1Digest) digest);
            case (short) 3:
                return new SHA224Digest((SHA224Digest) digest);
            case (short) 4:
                return new SHA256Digest((SHA256Digest) digest);
            case (short) 5:
                return new SHA384Digest((SHA384Digest) digest);
            case (short) 6:
                return new SHA512Digest((SHA512Digest) digest);
            default:
                throw new IllegalArgumentException("unknown HashAlgorithm");
        }
    }

    /* renamed from: g */
    public static Digest m27876g(int i) {
        if (i != 0) {
            return m27855c(m27879h(i));
        }
        return new CombinedHash();
    }

    /* renamed from: h */
    public static short m27879h(int i) {
        switch (i) {
            case 0:
                throw new IllegalArgumentException("legacy PRF not a valid algorithm");
            case 1:
                return (short) 4;
            case 2:
                return (short) 5;
            default:
                throw new IllegalArgumentException("unknown PRFAlgorithm");
        }
    }

    /* renamed from: d */
    public static ASN1ObjectIdentifier m27864d(short s) {
        switch (s) {
            case (short) 1:
                return PKCSObjectIdentifiers.f21841H;
            case (short) 2:
                return X509ObjectIdentifiers.f22087i;
            case (short) 3:
                return NISTObjectIdentifiers.f21785f;
            case (short) 4:
                return NISTObjectIdentifiers.f21782c;
            case (short) 5:
                return NISTObjectIdentifiers.f21783d;
            case (short) 6:
                return NISTObjectIdentifiers.f21784e;
            default:
                throw new IllegalArgumentException("unknown HashAlgorithm");
        }
    }

    /* renamed from: a */
    static short m27803a(Certificate certificate, Certificate certificate2) {
        if (certificate.m27545a() != null) {
            return (short) -1;
        }
        Certificate a = certificate.m27543a((int) null);
        try {
            certificate2 = PublicKeyFactory.m27886a(a.m40282j());
            if (certificate2.m35630a()) {
                throw new TlsFatalAlert((short) 80);
            } else if (certificate2 instanceof RSAKeyParameters) {
                m27811a(a, 128);
                return (short) 1;
            } else if (certificate2 instanceof DSAPublicKeyParameters) {
                m27811a(a, 128);
                return (short) 2;
            } else if ((certificate2 instanceof ECPublicKeyParameters) != null) {
                m27811a(a, 128);
                return (short) 64;
            } else {
                throw new TlsFatalAlert((short) 43);
            }
        } catch (Certificate certificate3) {
            throw new TlsFatalAlert((short) 43, certificate3);
        }
    }

    /* renamed from: a */
    static void m27815a(TlsHandshakeHash tlsHandshakeHash, Vector vector) {
        if (vector != null) {
            for (int i = 0; i < vector.size(); i++) {
                tlsHandshakeHash.mo6481a(((SignatureAndHashAlgorithm) vector.elementAt(i)).m27618a());
            }
        }
    }

    /* renamed from: f */
    public static TlsSigner m27873f(short s) {
        if (s == (short) 64) {
            return new TlsECDSASigner();
        }
        switch (s) {
            case (short) 1:
                return new TlsRSASigner();
            case (short) 2:
                return new TlsDSSSigner();
            default:
                throw new IllegalArgumentException("'clientCertificateType' is not a type with signing capability");
        }
    }

    /* renamed from: d */
    private static byte[][] m27868d() {
        byte[][] bArr = new byte[10][];
        int i = 0;
        while (i < 10) {
            int i2 = i + 1;
            byte[] bArr2 = new byte[i2];
            Arrays.m29351a(bArr2, (byte) (i + 65));
            bArr[i] = bArr2;
            i = i2;
        }
        return bArr;
    }

    /* renamed from: a */
    private static Vector m27796a(Object obj) {
        Vector vector = new Vector(1);
        vector.addElement(obj);
        return vector;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: i */
    public static int m27880i(int r1) {
        /*
        r1 = m27881j(r1);
        switch(r1) {
            case 1: goto L_0x0016;
            case 2: goto L_0x0016;
            case 3: goto L_0x0014;
            case 4: goto L_0x0014;
            case 5: goto L_0x0014;
            case 6: goto L_0x0014;
            case 7: goto L_0x0014;
            case 8: goto L_0x0014;
            case 9: goto L_0x0014;
            case 10: goto L_0x0012;
            case 11: goto L_0x0012;
            case 12: goto L_0x0014;
            case 13: goto L_0x0014;
            case 14: goto L_0x0014;
            case 15: goto L_0x0012;
            case 16: goto L_0x0012;
            case 17: goto L_0x0012;
            case 18: goto L_0x0012;
            case 19: goto L_0x0012;
            case 20: goto L_0x0012;
            default: goto L_0x0007;
        };
    L_0x0007:
        switch(r1) {
            case 100: goto L_0x0016;
            case 101: goto L_0x0016;
            case 102: goto L_0x0012;
            default: goto L_0x000a;
        };
    L_0x000a:
        r1 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r0 = 80;
        r1.<init>(r0);
        throw r1;
    L_0x0012:
        r1 = 2;
        return r1;
    L_0x0014:
        r1 = 1;
        return r1;
    L_0x0016:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsUtils.i(int):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: j */
    public static int m27881j(int r6) {
        /*
        r0 = 0;
        switch(r6) {
            case 1: goto L_0x007d;
            case 2: goto L_0x007c;
            default: goto L_0x0004;
        };
    L_0x0004:
        r1 = 2;
        switch(r6) {
            case 4: goto L_0x007b;
            case 5: goto L_0x007a;
            default: goto L_0x0008;
        };
    L_0x0008:
        r2 = 8;
        switch(r6) {
            case 44: goto L_0x007c;
            case 45: goto L_0x007c;
            case 46: goto L_0x007c;
            case 47: goto L_0x0079;
            case 48: goto L_0x0079;
            case 49: goto L_0x0079;
            case 50: goto L_0x0079;
            case 51: goto L_0x0079;
            default: goto L_0x000d;
        };
    L_0x000d:
        r3 = 9;
        switch(r6) {
            case 53: goto L_0x0078;
            case 54: goto L_0x0078;
            case 55: goto L_0x0078;
            case 56: goto L_0x0078;
            case 57: goto L_0x0078;
            default: goto L_0x0012;
        };
    L_0x0012:
        r4 = 12;
        switch(r6) {
            case 59: goto L_0x0077;
            case 60: goto L_0x0076;
            case 61: goto L_0x0075;
            case 62: goto L_0x0076;
            case 63: goto L_0x0076;
            case 64: goto L_0x0076;
            case 65: goto L_0x0074;
            case 66: goto L_0x0074;
            case 67: goto L_0x0074;
            case 68: goto L_0x0074;
            case 69: goto L_0x0074;
            default: goto L_0x0017;
        };
    L_0x0017:
        switch(r6) {
            case 103: goto L_0x0076;
            case 104: goto L_0x0075;
            case 105: goto L_0x0075;
            case 106: goto L_0x0075;
            case 107: goto L_0x0075;
            default: goto L_0x001a;
        };
    L_0x001a:
        r5 = 13;
        switch(r6) {
            case 132: goto L_0x0073;
            case 133: goto L_0x0073;
            case 134: goto L_0x0073;
            case 135: goto L_0x0073;
            case 136: goto L_0x0073;
            default: goto L_0x001f;
        };
    L_0x001f:
        switch(r6) {
            case 138: goto L_0x007a;
            case 139: goto L_0x0071;
            case 140: goto L_0x0079;
            case 141: goto L_0x0078;
            case 142: goto L_0x007a;
            case 143: goto L_0x0071;
            case 144: goto L_0x0079;
            case 145: goto L_0x0078;
            case 146: goto L_0x007a;
            case 147: goto L_0x0071;
            case 148: goto L_0x0079;
            case 149: goto L_0x0078;
            case 150: goto L_0x006e;
            case 151: goto L_0x006e;
            case 152: goto L_0x006e;
            case 153: goto L_0x006e;
            case 154: goto L_0x006e;
            default: goto L_0x0022;
        };
    L_0x0022:
        switch(r6) {
            case 156: goto L_0x006b;
            case 157: goto L_0x0068;
            case 158: goto L_0x006b;
            case 159: goto L_0x0068;
            case 160: goto L_0x006b;
            case 161: goto L_0x0068;
            case 162: goto L_0x006b;
            case 163: goto L_0x0068;
            case 164: goto L_0x006b;
            case 165: goto L_0x0068;
            default: goto L_0x0025;
        };
    L_0x0025:
        switch(r6) {
            case 168: goto L_0x006b;
            case 169: goto L_0x0068;
            case 170: goto L_0x006b;
            case 171: goto L_0x0068;
            case 172: goto L_0x006b;
            case 173: goto L_0x0068;
            case 174: goto L_0x0076;
            case 175: goto L_0x0067;
            case 176: goto L_0x0077;
            case 177: goto L_0x0066;
            case 178: goto L_0x0076;
            case 179: goto L_0x0067;
            case 180: goto L_0x0077;
            case 181: goto L_0x0066;
            case 182: goto L_0x0076;
            case 183: goto L_0x0067;
            case 184: goto L_0x0077;
            case 185: goto L_0x0066;
            case 186: goto L_0x0065;
            case 187: goto L_0x0065;
            case 188: goto L_0x0065;
            case 189: goto L_0x0065;
            case 190: goto L_0x0065;
            default: goto L_0x0028;
        };
    L_0x0028:
        switch(r6) {
            case 192: goto L_0x0064;
            case 193: goto L_0x0064;
            case 194: goto L_0x0064;
            case 195: goto L_0x0064;
            case 196: goto L_0x0064;
            default: goto L_0x002b;
        };
    L_0x002b:
        switch(r6) {
            case 49153: goto L_0x007c;
            case 49154: goto L_0x007a;
            case 49155: goto L_0x0071;
            case 49156: goto L_0x0079;
            case 49157: goto L_0x0078;
            case 49158: goto L_0x007c;
            case 49159: goto L_0x007a;
            case 49160: goto L_0x0071;
            case 49161: goto L_0x0079;
            case 49162: goto L_0x0078;
            case 49163: goto L_0x007c;
            case 49164: goto L_0x007a;
            case 49165: goto L_0x0071;
            case 49166: goto L_0x0079;
            case 49167: goto L_0x0078;
            case 49168: goto L_0x007c;
            case 49169: goto L_0x007a;
            case 49170: goto L_0x0071;
            case 49171: goto L_0x0079;
            case 49172: goto L_0x0078;
            default: goto L_0x002e;
        };
    L_0x002e:
        switch(r6) {
            case 49178: goto L_0x0071;
            case 49179: goto L_0x0071;
            case 49180: goto L_0x0071;
            case 49181: goto L_0x0079;
            case 49182: goto L_0x0079;
            case 49183: goto L_0x0079;
            case 49184: goto L_0x0078;
            case 49185: goto L_0x0078;
            case 49186: goto L_0x0078;
            case 49187: goto L_0x0076;
            case 49188: goto L_0x0067;
            case 49189: goto L_0x0076;
            case 49190: goto L_0x0067;
            case 49191: goto L_0x0076;
            case 49192: goto L_0x0067;
            case 49193: goto L_0x0076;
            case 49194: goto L_0x0067;
            case 49195: goto L_0x006b;
            case 49196: goto L_0x0068;
            case 49197: goto L_0x006b;
            case 49198: goto L_0x0068;
            case 49199: goto L_0x006b;
            case 49200: goto L_0x0068;
            case 49201: goto L_0x006b;
            case 49202: goto L_0x0068;
            case 49203: goto L_0x007a;
            case 49204: goto L_0x0071;
            case 49205: goto L_0x0079;
            case 49206: goto L_0x0078;
            case 49207: goto L_0x0076;
            case 49208: goto L_0x0067;
            case 49209: goto L_0x007c;
            case 49210: goto L_0x0077;
            case 49211: goto L_0x0066;
            default: goto L_0x0031;
        };
    L_0x0031:
        switch(r6) {
            case 49266: goto L_0x0065;
            case 49267: goto L_0x0063;
            case 49268: goto L_0x0065;
            case 49269: goto L_0x0063;
            case 49270: goto L_0x0065;
            case 49271: goto L_0x0063;
            case 49272: goto L_0x0065;
            case 49273: goto L_0x0063;
            case 49274: goto L_0x0060;
            case 49275: goto L_0x005d;
            case 49276: goto L_0x0060;
            case 49277: goto L_0x005d;
            case 49278: goto L_0x0060;
            case 49279: goto L_0x005d;
            case 49280: goto L_0x0060;
            case 49281: goto L_0x005d;
            case 49282: goto L_0x0060;
            case 49283: goto L_0x005d;
            default: goto L_0x0034;
        };
    L_0x0034:
        switch(r6) {
            case 49286: goto L_0x0060;
            case 49287: goto L_0x005d;
            case 49288: goto L_0x0060;
            case 49289: goto L_0x005d;
            case 49290: goto L_0x0060;
            case 49291: goto L_0x005d;
            case 49292: goto L_0x0060;
            case 49293: goto L_0x005d;
            case 49294: goto L_0x0060;
            case 49295: goto L_0x005d;
            case 49296: goto L_0x0060;
            case 49297: goto L_0x005d;
            case 49298: goto L_0x0060;
            case 49299: goto L_0x005d;
            case 49300: goto L_0x0065;
            case 49301: goto L_0x0063;
            case 49302: goto L_0x0065;
            case 49303: goto L_0x0063;
            case 49304: goto L_0x0065;
            case 49305: goto L_0x0063;
            case 49306: goto L_0x0065;
            case 49307: goto L_0x0063;
            case 49308: goto L_0x005a;
            case 49309: goto L_0x0057;
            case 49310: goto L_0x005a;
            case 49311: goto L_0x0057;
            case 49312: goto L_0x0054;
            case 49313: goto L_0x0051;
            case 49314: goto L_0x0054;
            case 49315: goto L_0x0051;
            case 49316: goto L_0x005a;
            case 49317: goto L_0x0057;
            case 49318: goto L_0x005a;
            case 49319: goto L_0x0057;
            case 49320: goto L_0x0054;
            case 49321: goto L_0x0051;
            case 49322: goto L_0x0054;
            case 49323: goto L_0x0051;
            case 49324: goto L_0x005a;
            case 49325: goto L_0x0057;
            case 49326: goto L_0x0054;
            case 49327: goto L_0x0051;
            default: goto L_0x0037;
        };
    L_0x0037:
        switch(r6) {
            case 52243: goto L_0x004e;
            case 52244: goto L_0x004e;
            case 52245: goto L_0x004e;
            default: goto L_0x003a;
        };
    L_0x003a:
        switch(r6) {
            case 58384: goto L_0x004b;
            case 58385: goto L_0x0048;
            case 58386: goto L_0x004b;
            case 58387: goto L_0x0048;
            case 58388: goto L_0x004b;
            case 58389: goto L_0x0048;
            case 58390: goto L_0x004b;
            case 58391: goto L_0x0048;
            case 58392: goto L_0x004b;
            case 58393: goto L_0x0048;
            case 58394: goto L_0x004b;
            case 58395: goto L_0x0048;
            case 58396: goto L_0x004b;
            case 58397: goto L_0x0048;
            case 58398: goto L_0x004b;
            case 58399: goto L_0x0048;
            default: goto L_0x003d;
        };
    L_0x003d:
        switch(r6) {
            case 10: goto L_0x0071;
            case 13: goto L_0x0071;
            case 16: goto L_0x0071;
            case 19: goto L_0x0071;
            case 22: goto L_0x0071;
            case 24: goto L_0x007b;
            case 49174: goto L_0x007a;
            default: goto L_0x0040;
        };
    L_0x0040:
        r6 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r0 = 80;
        r6.<init>(r0);
        throw r6;
    L_0x0048:
        r6 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        return r6;
    L_0x004b:
        r6 = 100;
        return r6;
    L_0x004e:
        r6 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        return r6;
    L_0x0051:
        r6 = 18;
        return r6;
    L_0x0054:
        r6 = 16;
        return r6;
    L_0x0057:
        r6 = 17;
        return r6;
    L_0x005a:
        r6 = 15;
        return r6;
    L_0x005d:
        r6 = 20;
        return r6;
    L_0x0060:
        r6 = 19;
        return r6;
    L_0x0063:
        return r5;
    L_0x0064:
        return r5;
    L_0x0065:
        return r4;
    L_0x0066:
        return r0;
    L_0x0067:
        return r3;
    L_0x0068:
        r6 = 11;
        return r6;
    L_0x006b:
        r6 = 10;
        return r6;
    L_0x006e:
        r6 = 14;
        return r6;
    L_0x0071:
        r6 = 7;
        return r6;
    L_0x0073:
        return r5;
    L_0x0074:
        return r4;
    L_0x0075:
        return r3;
    L_0x0076:
        return r2;
    L_0x0077:
        return r0;
    L_0x0078:
        return r3;
    L_0x0079:
        return r2;
    L_0x007a:
        return r1;
    L_0x007b:
        return r1;
    L_0x007c:
        return r0;
    L_0x007d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsUtils.j(int):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: k */
    public static int m27882k(int r1) {
        /*
        switch(r1) {
            case 1: goto L_0x0068;
            case 2: goto L_0x0068;
            default: goto L_0x0003;
        };
    L_0x0003:
        switch(r1) {
            case 4: goto L_0x0068;
            case 5: goto L_0x0068;
            default: goto L_0x0006;
        };
    L_0x0006:
        switch(r1) {
            case 44: goto L_0x0065;
            case 45: goto L_0x0062;
            case 46: goto L_0x005f;
            case 47: goto L_0x0068;
            case 48: goto L_0x005d;
            case 49: goto L_0x005a;
            case 50: goto L_0x0058;
            case 51: goto L_0x0056;
            default: goto L_0x0009;
        };
    L_0x0009:
        switch(r1) {
            case 53: goto L_0x0068;
            case 54: goto L_0x005d;
            case 55: goto L_0x005a;
            case 56: goto L_0x0058;
            case 57: goto L_0x0056;
            default: goto L_0x000c;
        };
    L_0x000c:
        switch(r1) {
            case 59: goto L_0x0068;
            case 60: goto L_0x0068;
            case 61: goto L_0x0068;
            case 62: goto L_0x005d;
            case 63: goto L_0x005a;
            case 64: goto L_0x0058;
            case 65: goto L_0x0068;
            case 66: goto L_0x005d;
            case 67: goto L_0x005a;
            case 68: goto L_0x0058;
            case 69: goto L_0x0056;
            default: goto L_0x000f;
        };
    L_0x000f:
        switch(r1) {
            case 103: goto L_0x0056;
            case 104: goto L_0x005d;
            case 105: goto L_0x005a;
            case 106: goto L_0x0058;
            case 107: goto L_0x0056;
            default: goto L_0x0012;
        };
    L_0x0012:
        switch(r1) {
            case 132: goto L_0x0068;
            case 133: goto L_0x005d;
            case 134: goto L_0x005a;
            case 135: goto L_0x0058;
            case 136: goto L_0x0056;
            default: goto L_0x0015;
        };
    L_0x0015:
        switch(r1) {
            case 138: goto L_0x0065;
            case 139: goto L_0x0065;
            case 140: goto L_0x0065;
            case 141: goto L_0x0065;
            case 142: goto L_0x0062;
            case 143: goto L_0x0062;
            case 144: goto L_0x0062;
            case 145: goto L_0x0062;
            case 146: goto L_0x005f;
            case 147: goto L_0x005f;
            case 148: goto L_0x005f;
            case 149: goto L_0x005f;
            case 150: goto L_0x0068;
            case 151: goto L_0x005d;
            case 152: goto L_0x005a;
            case 153: goto L_0x0058;
            case 154: goto L_0x0056;
            default: goto L_0x0018;
        };
    L_0x0018:
        switch(r1) {
            case 156: goto L_0x0068;
            case 157: goto L_0x0068;
            case 158: goto L_0x0056;
            case 159: goto L_0x0056;
            case 160: goto L_0x005a;
            case 161: goto L_0x005a;
            case 162: goto L_0x0058;
            case 163: goto L_0x0058;
            case 164: goto L_0x005d;
            case 165: goto L_0x005d;
            default: goto L_0x001b;
        };
    L_0x001b:
        switch(r1) {
            case 168: goto L_0x0065;
            case 169: goto L_0x0065;
            case 170: goto L_0x0062;
            case 171: goto L_0x0062;
            case 172: goto L_0x005f;
            case 173: goto L_0x005f;
            case 174: goto L_0x0065;
            case 175: goto L_0x0065;
            case 176: goto L_0x0065;
            case 177: goto L_0x0065;
            case 178: goto L_0x0062;
            case 179: goto L_0x0062;
            case 180: goto L_0x0062;
            case 181: goto L_0x0062;
            case 182: goto L_0x005f;
            case 183: goto L_0x005f;
            case 184: goto L_0x005f;
            case 185: goto L_0x005f;
            case 186: goto L_0x0068;
            case 187: goto L_0x005d;
            case 188: goto L_0x005a;
            case 189: goto L_0x0058;
            case 190: goto L_0x0056;
            default: goto L_0x001e;
        };
    L_0x001e:
        switch(r1) {
            case 192: goto L_0x0068;
            case 193: goto L_0x005d;
            case 194: goto L_0x005a;
            case 195: goto L_0x0058;
            case 196: goto L_0x0056;
            default: goto L_0x0021;
        };
    L_0x0021:
        switch(r1) {
            case 49153: goto L_0x0053;
            case 49154: goto L_0x0053;
            case 49155: goto L_0x0053;
            case 49156: goto L_0x0053;
            case 49157: goto L_0x0053;
            case 49158: goto L_0x0050;
            case 49159: goto L_0x0050;
            case 49160: goto L_0x0050;
            case 49161: goto L_0x0050;
            case 49162: goto L_0x0050;
            case 49163: goto L_0x004d;
            case 49164: goto L_0x004d;
            case 49165: goto L_0x004d;
            case 49166: goto L_0x004d;
            case 49167: goto L_0x004d;
            case 49168: goto L_0x004a;
            case 49169: goto L_0x004a;
            case 49170: goto L_0x004a;
            case 49171: goto L_0x004a;
            case 49172: goto L_0x004a;
            default: goto L_0x0024;
        };
    L_0x0024:
        switch(r1) {
            case 49178: goto L_0x0047;
            case 49179: goto L_0x0044;
            case 49180: goto L_0x0041;
            case 49181: goto L_0x0047;
            case 49182: goto L_0x0044;
            case 49183: goto L_0x0041;
            case 49184: goto L_0x0047;
            case 49185: goto L_0x0044;
            case 49186: goto L_0x0041;
            case 49187: goto L_0x0050;
            case 49188: goto L_0x0050;
            case 49189: goto L_0x0053;
            case 49190: goto L_0x0053;
            case 49191: goto L_0x004a;
            case 49192: goto L_0x004a;
            case 49193: goto L_0x004d;
            case 49194: goto L_0x004d;
            case 49195: goto L_0x0050;
            case 49196: goto L_0x0050;
            case 49197: goto L_0x0053;
            case 49198: goto L_0x0053;
            case 49199: goto L_0x004a;
            case 49200: goto L_0x004a;
            case 49201: goto L_0x004d;
            case 49202: goto L_0x004d;
            case 49203: goto L_0x003e;
            case 49204: goto L_0x003e;
            case 49205: goto L_0x003e;
            case 49206: goto L_0x003e;
            case 49207: goto L_0x003e;
            case 49208: goto L_0x003e;
            case 49209: goto L_0x003e;
            case 49210: goto L_0x003e;
            case 49211: goto L_0x003e;
            default: goto L_0x0027;
        };
    L_0x0027:
        switch(r1) {
            case 49266: goto L_0x0050;
            case 49267: goto L_0x0050;
            case 49268: goto L_0x0053;
            case 49269: goto L_0x0053;
            case 49270: goto L_0x004a;
            case 49271: goto L_0x004a;
            case 49272: goto L_0x004d;
            case 49273: goto L_0x004d;
            case 49274: goto L_0x0068;
            case 49275: goto L_0x0068;
            case 49276: goto L_0x0056;
            case 49277: goto L_0x0056;
            case 49278: goto L_0x005a;
            case 49279: goto L_0x005a;
            case 49280: goto L_0x0058;
            case 49281: goto L_0x0058;
            case 49282: goto L_0x005d;
            case 49283: goto L_0x005d;
            default: goto L_0x002a;
        };
    L_0x002a:
        switch(r1) {
            case 49286: goto L_0x0050;
            case 49287: goto L_0x0050;
            case 49288: goto L_0x0053;
            case 49289: goto L_0x0053;
            case 49290: goto L_0x004a;
            case 49291: goto L_0x004a;
            case 49292: goto L_0x004d;
            case 49293: goto L_0x004d;
            case 49294: goto L_0x0065;
            case 49295: goto L_0x0065;
            case 49296: goto L_0x0062;
            case 49297: goto L_0x0062;
            case 49298: goto L_0x005f;
            case 49299: goto L_0x005f;
            case 49300: goto L_0x0065;
            case 49301: goto L_0x0065;
            case 49302: goto L_0x0062;
            case 49303: goto L_0x0062;
            case 49304: goto L_0x005f;
            case 49305: goto L_0x005f;
            case 49306: goto L_0x003e;
            case 49307: goto L_0x003e;
            case 49308: goto L_0x0068;
            case 49309: goto L_0x0068;
            case 49310: goto L_0x0056;
            case 49311: goto L_0x0056;
            case 49312: goto L_0x0068;
            case 49313: goto L_0x0068;
            case 49314: goto L_0x0056;
            case 49315: goto L_0x0056;
            case 49316: goto L_0x0065;
            case 49317: goto L_0x0065;
            case 49318: goto L_0x0062;
            case 49319: goto L_0x0062;
            case 49320: goto L_0x0065;
            case 49321: goto L_0x0065;
            case 49322: goto L_0x0062;
            case 49323: goto L_0x0062;
            case 49324: goto L_0x0050;
            case 49325: goto L_0x0050;
            case 49326: goto L_0x0050;
            case 49327: goto L_0x0050;
            default: goto L_0x002d;
        };
    L_0x002d:
        switch(r1) {
            case 52243: goto L_0x004a;
            case 52244: goto L_0x0050;
            case 52245: goto L_0x0056;
            default: goto L_0x0030;
        };
    L_0x0030:
        switch(r1) {
            case 58384: goto L_0x0068;
            case 58385: goto L_0x0068;
            case 58386: goto L_0x004a;
            case 58387: goto L_0x004a;
            case 58388: goto L_0x0050;
            case 58389: goto L_0x0050;
            case 58390: goto L_0x0065;
            case 58391: goto L_0x0065;
            case 58392: goto L_0x003e;
            case 58393: goto L_0x003e;
            case 58394: goto L_0x005f;
            case 58395: goto L_0x005f;
            case 58396: goto L_0x0062;
            case 58397: goto L_0x0062;
            case 58398: goto L_0x0056;
            case 58399: goto L_0x0056;
            default: goto L_0x0033;
        };
    L_0x0033:
        switch(r1) {
            case 10: goto L_0x0068;
            case 13: goto L_0x005d;
            case 16: goto L_0x005a;
            case 19: goto L_0x0058;
            case 22: goto L_0x0056;
            default: goto L_0x0036;
        };
    L_0x0036:
        r1 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r0 = 80;
        r1.<init>(r0);
        throw r1;
    L_0x003e:
        r1 = 24;
        return r1;
    L_0x0041:
        r1 = 22;
        return r1;
    L_0x0044:
        r1 = 23;
        return r1;
    L_0x0047:
        r1 = 21;
        return r1;
    L_0x004a:
        r1 = 19;
        return r1;
    L_0x004d:
        r1 = 18;
        return r1;
    L_0x0050:
        r1 = 17;
        return r1;
    L_0x0053:
        r1 = 16;
        return r1;
    L_0x0056:
        r1 = 5;
        return r1;
    L_0x0058:
        r1 = 3;
        return r1;
    L_0x005a:
        r1 = 9;
        return r1;
    L_0x005d:
        r1 = 7;
        return r1;
    L_0x005f:
        r1 = 15;
        return r1;
    L_0x0062:
        r1 = 14;
        return r1;
    L_0x0065:
        r1 = 13;
        return r1;
    L_0x0068:
        r1 = 1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsUtils.k(int):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: l */
    public static int m27883l(int r1) {
        /*
        switch(r1) {
            case 1: goto L_0x0046;
            case 2: goto L_0x0044;
            default: goto L_0x0003;
        };
    L_0x0003:
        switch(r1) {
            case 4: goto L_0x0046;
            case 5: goto L_0x0044;
            default: goto L_0x0006;
        };
    L_0x0006:
        switch(r1) {
            case 44: goto L_0x0044;
            case 45: goto L_0x0044;
            case 46: goto L_0x0044;
            case 47: goto L_0x0044;
            case 48: goto L_0x0044;
            case 49: goto L_0x0044;
            case 50: goto L_0x0044;
            case 51: goto L_0x0044;
            default: goto L_0x0009;
        };
    L_0x0009:
        switch(r1) {
            case 53: goto L_0x0044;
            case 54: goto L_0x0044;
            case 55: goto L_0x0044;
            case 56: goto L_0x0044;
            case 57: goto L_0x0044;
            default: goto L_0x000c;
        };
    L_0x000c:
        switch(r1) {
            case 59: goto L_0x0042;
            case 60: goto L_0x0042;
            case 61: goto L_0x0042;
            case 62: goto L_0x0042;
            case 63: goto L_0x0042;
            case 64: goto L_0x0042;
            case 65: goto L_0x0044;
            case 66: goto L_0x0044;
            case 67: goto L_0x0044;
            case 68: goto L_0x0044;
            case 69: goto L_0x0044;
            default: goto L_0x000f;
        };
    L_0x000f:
        switch(r1) {
            case 103: goto L_0x0042;
            case 104: goto L_0x0042;
            case 105: goto L_0x0042;
            case 106: goto L_0x0042;
            case 107: goto L_0x0042;
            default: goto L_0x0012;
        };
    L_0x0012:
        switch(r1) {
            case 132: goto L_0x0044;
            case 133: goto L_0x0044;
            case 134: goto L_0x0044;
            case 135: goto L_0x0044;
            case 136: goto L_0x0044;
            default: goto L_0x0015;
        };
    L_0x0015:
        switch(r1) {
            case 138: goto L_0x0044;
            case 139: goto L_0x0044;
            case 140: goto L_0x0044;
            case 141: goto L_0x0044;
            case 142: goto L_0x0044;
            case 143: goto L_0x0044;
            case 144: goto L_0x0044;
            case 145: goto L_0x0044;
            case 146: goto L_0x0044;
            case 147: goto L_0x0044;
            case 148: goto L_0x0044;
            case 149: goto L_0x0044;
            case 150: goto L_0x0044;
            case 151: goto L_0x0044;
            case 152: goto L_0x0044;
            case 153: goto L_0x0044;
            case 154: goto L_0x0044;
            default: goto L_0x0018;
        };
    L_0x0018:
        switch(r1) {
            case 156: goto L_0x0040;
            case 157: goto L_0x0040;
            case 158: goto L_0x0040;
            case 159: goto L_0x0040;
            case 160: goto L_0x0040;
            case 161: goto L_0x0040;
            case 162: goto L_0x0040;
            case 163: goto L_0x0040;
            case 164: goto L_0x0040;
            case 165: goto L_0x0040;
            default: goto L_0x001b;
        };
    L_0x001b:
        switch(r1) {
            case 168: goto L_0x0040;
            case 169: goto L_0x0040;
            case 170: goto L_0x0040;
            case 171: goto L_0x0040;
            case 172: goto L_0x0040;
            case 173: goto L_0x0040;
            case 174: goto L_0x0042;
            case 175: goto L_0x003e;
            case 176: goto L_0x0042;
            case 177: goto L_0x003e;
            case 178: goto L_0x0042;
            case 179: goto L_0x003e;
            case 180: goto L_0x0042;
            case 181: goto L_0x003e;
            case 182: goto L_0x0042;
            case 183: goto L_0x003e;
            case 184: goto L_0x0042;
            case 185: goto L_0x003e;
            case 186: goto L_0x0042;
            case 187: goto L_0x0042;
            case 188: goto L_0x0042;
            case 189: goto L_0x0042;
            case 190: goto L_0x0042;
            default: goto L_0x001e;
        };
    L_0x001e:
        switch(r1) {
            case 192: goto L_0x0042;
            case 193: goto L_0x0042;
            case 194: goto L_0x0042;
            case 195: goto L_0x0042;
            case 196: goto L_0x0042;
            default: goto L_0x0021;
        };
    L_0x0021:
        switch(r1) {
            case 49153: goto L_0x0044;
            case 49154: goto L_0x0044;
            case 49155: goto L_0x0044;
            case 49156: goto L_0x0044;
            case 49157: goto L_0x0044;
            case 49158: goto L_0x0044;
            case 49159: goto L_0x0044;
            case 49160: goto L_0x0044;
            case 49161: goto L_0x0044;
            case 49162: goto L_0x0044;
            case 49163: goto L_0x0044;
            case 49164: goto L_0x0044;
            case 49165: goto L_0x0044;
            case 49166: goto L_0x0044;
            case 49167: goto L_0x0044;
            case 49168: goto L_0x0044;
            case 49169: goto L_0x0044;
            case 49170: goto L_0x0044;
            case 49171: goto L_0x0044;
            case 49172: goto L_0x0044;
            default: goto L_0x0024;
        };
    L_0x0024:
        switch(r1) {
            case 49178: goto L_0x0044;
            case 49179: goto L_0x0044;
            case 49180: goto L_0x0044;
            case 49181: goto L_0x0044;
            case 49182: goto L_0x0044;
            case 49183: goto L_0x0044;
            case 49184: goto L_0x0044;
            case 49185: goto L_0x0044;
            case 49186: goto L_0x0044;
            case 49187: goto L_0x0042;
            case 49188: goto L_0x003e;
            case 49189: goto L_0x0042;
            case 49190: goto L_0x003e;
            case 49191: goto L_0x0042;
            case 49192: goto L_0x003e;
            case 49193: goto L_0x0042;
            case 49194: goto L_0x003e;
            case 49195: goto L_0x0040;
            case 49196: goto L_0x0040;
            case 49197: goto L_0x0040;
            case 49198: goto L_0x0040;
            case 49199: goto L_0x0040;
            case 49200: goto L_0x0040;
            case 49201: goto L_0x0040;
            case 49202: goto L_0x0040;
            case 49203: goto L_0x0044;
            case 49204: goto L_0x0044;
            case 49205: goto L_0x0044;
            case 49206: goto L_0x0044;
            case 49207: goto L_0x0042;
            case 49208: goto L_0x003e;
            case 49209: goto L_0x0044;
            case 49210: goto L_0x0042;
            case 49211: goto L_0x003e;
            default: goto L_0x0027;
        };
    L_0x0027:
        switch(r1) {
            case 49266: goto L_0x0042;
            case 49267: goto L_0x003e;
            case 49268: goto L_0x0042;
            case 49269: goto L_0x003e;
            case 49270: goto L_0x0042;
            case 49271: goto L_0x003e;
            case 49272: goto L_0x0042;
            case 49273: goto L_0x003e;
            case 49274: goto L_0x0040;
            case 49275: goto L_0x0040;
            case 49276: goto L_0x0040;
            case 49277: goto L_0x0040;
            case 49278: goto L_0x0040;
            case 49279: goto L_0x0040;
            case 49280: goto L_0x0040;
            case 49281: goto L_0x0040;
            case 49282: goto L_0x0040;
            case 49283: goto L_0x0040;
            default: goto L_0x002a;
        };
    L_0x002a:
        switch(r1) {
            case 49286: goto L_0x0040;
            case 49287: goto L_0x0040;
            case 49288: goto L_0x0040;
            case 49289: goto L_0x0040;
            case 49290: goto L_0x0040;
            case 49291: goto L_0x0040;
            case 49292: goto L_0x0040;
            case 49293: goto L_0x0040;
            case 49294: goto L_0x0040;
            case 49295: goto L_0x0040;
            case 49296: goto L_0x0040;
            case 49297: goto L_0x0040;
            case 49298: goto L_0x0040;
            case 49299: goto L_0x0040;
            case 49300: goto L_0x0042;
            case 49301: goto L_0x003e;
            case 49302: goto L_0x0042;
            case 49303: goto L_0x003e;
            case 49304: goto L_0x0042;
            case 49305: goto L_0x003e;
            case 49306: goto L_0x0042;
            case 49307: goto L_0x003e;
            case 49308: goto L_0x0040;
            case 49309: goto L_0x0040;
            case 49310: goto L_0x0040;
            case 49311: goto L_0x0040;
            case 49312: goto L_0x0040;
            case 49313: goto L_0x0040;
            case 49314: goto L_0x0040;
            case 49315: goto L_0x0040;
            case 49316: goto L_0x0040;
            case 49317: goto L_0x0040;
            case 49318: goto L_0x0040;
            case 49319: goto L_0x0040;
            case 49320: goto L_0x0040;
            case 49321: goto L_0x0040;
            case 49322: goto L_0x0040;
            case 49323: goto L_0x0040;
            case 49324: goto L_0x0040;
            case 49325: goto L_0x0040;
            case 49326: goto L_0x0040;
            case 49327: goto L_0x0040;
            default: goto L_0x002d;
        };
    L_0x002d:
        switch(r1) {
            case 52243: goto L_0x0040;
            case 52244: goto L_0x0040;
            case 52245: goto L_0x0040;
            default: goto L_0x0030;
        };
    L_0x0030:
        switch(r1) {
            case 58384: goto L_0x0044;
            case 58385: goto L_0x0044;
            case 58386: goto L_0x0044;
            case 58387: goto L_0x0044;
            case 58388: goto L_0x0044;
            case 58389: goto L_0x0044;
            case 58390: goto L_0x0044;
            case 58391: goto L_0x0044;
            case 58392: goto L_0x0044;
            case 58393: goto L_0x0044;
            case 58394: goto L_0x0044;
            case 58395: goto L_0x0044;
            case 58396: goto L_0x0044;
            case 58397: goto L_0x0044;
            case 58398: goto L_0x0044;
            case 58399: goto L_0x0044;
            default: goto L_0x0033;
        };
    L_0x0033:
        switch(r1) {
            case 10: goto L_0x0044;
            case 13: goto L_0x0044;
            case 16: goto L_0x0044;
            case 19: goto L_0x0044;
            case 22: goto L_0x0044;
            default: goto L_0x0036;
        };
    L_0x0036:
        r1 = new org.spongycastle.crypto.tls.TlsFatalAlert;
        r0 = 80;
        r1.<init>(r0);
        throw r1;
    L_0x003e:
        r1 = 4;
        return r1;
    L_0x0040:
        r1 = 0;
        return r1;
    L_0x0042:
        r1 = 3;
        return r1;
    L_0x0044:
        r1 = 2;
        return r1;
    L_0x0046:
        r1 = 1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsUtils.l(int):int");
    }

    /* renamed from: m */
    public static ProtocolVersion m27884m(int i) {
        switch (i) {
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
                break;
            default:
                switch (i) {
                    case 103:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                        break;
                    default:
                        switch (i) {
                            case 156:
                            case 157:
                            case 158:
                            case 159:
                            case 160:
                            case 161:
                            case 162:
                            case 163:
                            case 164:
                            case 165:
                                break;
                            default:
                                switch (i) {
                                    case 168:
                                    case 169:
                                    case 170:
                                    case 171:
                                    case 172:
                                    case 173:
                                        break;
                                    default:
                                        switch (i) {
                                            case 186:
                                            case 187:
                                            case 188:
                                            case 189:
                                            case FacebookRequestErrorClassification.EC_INVALID_TOKEN /*190*/:
                                            case 191:
                                            case JfifUtil.MARKER_SOFn /*192*/:
                                            case 193:
                                            case 194:
                                            case 195:
                                            case 196:
                                            case 197:
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
                                                            case 49274:
                                                            case 49275:
                                                            case 49276:
                                                            case 49277:
                                                            case 49278:
                                                            case 49279:
                                                            case 49280:
                                                            case 49281:
                                                            case 49282:
                                                            case 49283:
                                                            case 49284:
                                                            case 49285:
                                                            case 49286:
                                                            case 49287:
                                                            case 49288:
                                                            case 49289:
                                                            case 49290:
                                                            case 49291:
                                                            case 49292:
                                                            case 49293:
                                                            case 49294:
                                                            case 49295:
                                                            case 49296:
                                                            case 49297:
                                                            case 49298:
                                                            case 49299:
                                                                break;
                                                            default:
                                                                switch (i) {
                                                                    case 49308:
                                                                    case 49309:
                                                                    case 49310:
                                                                    case 49311:
                                                                    case 49312:
                                                                    case 49313:
                                                                    case 49314:
                                                                    case 49315:
                                                                    case 49316:
                                                                    case 49317:
                                                                    case 49318:
                                                                    case 49319:
                                                                    case 49320:
                                                                    case 49321:
                                                                    case 49322:
                                                                    case 49323:
                                                                    case 49324:
                                                                    case 49325:
                                                                    case 49326:
                                                                    case 49327:
                                                                        break;
                                                                    default:
                                                                        switch (i) {
                                                                            case 52243:
                                                                            case 52244:
                                                                            case 52245:
                                                                                break;
                                                                            default:
                                                                                return ProtocolVersion.f22511a;
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
        return ProtocolVersion.f22514d;
    }

    /* renamed from: n */
    public static boolean m27885n(int i) {
        return 1 == m27880i(i);
    }

    /* renamed from: a */
    public static boolean m27822a(int i, ProtocolVersion protocolVersion) {
        return m27884m(i).m27568a(protocolVersion.m27574e());
    }
}
