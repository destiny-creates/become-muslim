package org.spongycastle.asn1;

import com.facebook.imageutils.JfifUtil;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.util.io.Streams;

public class ASN1InputStream extends FilterInputStream implements BERTags {
    /* renamed from: a */
    private final int f26445a;
    /* renamed from: b */
    private final boolean f26446b;
    /* renamed from: c */
    private final byte[][] f26447c;

    public ASN1InputStream(InputStream inputStream) {
        this(inputStream, StreamUtil.m27169a(inputStream));
    }

    public ASN1InputStream(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }

    public ASN1InputStream(byte[] bArr, boolean z) {
        this(new ByteArrayInputStream(bArr), bArr.length, z);
    }

    public ASN1InputStream(InputStream inputStream, int i) {
        this(inputStream, i, false);
    }

    public ASN1InputStream(InputStream inputStream, boolean z) {
        this(inputStream, StreamUtil.m27169a(inputStream), z);
    }

    public ASN1InputStream(InputStream inputStream, int i, boolean z) {
        super(inputStream);
        this.f26445a = i;
        this.f26446b = z;
        this.f26447c = new byte[11][];
    }

    /* renamed from: a */
    int m34590a() {
        return this.f26445a;
    }

    /* renamed from: b */
    protected int m34593b() {
        return m34588b(this, this.f26445a);
    }

    /* renamed from: a */
    protected ASN1Primitive m34592a(int i, int i2, int i3) {
        boolean z = (i & 32) != 0;
        DefiniteLengthInputStream definiteLengthInputStream = new DefiniteLengthInputStream(this, i3);
        if ((i & 64) != 0) {
            return new DERApplicationSpecific(z, i2, definiteLengthInputStream.m34609b());
        }
        if ((i & 128) != 0) {
            return new ASN1StreamParser(definiteLengthInputStream).m27156a(z, i2);
        }
        if (!z) {
            return m34586a(i2, definiteLengthInputStream, this.f26447c);
        }
        if (i2 == 4) {
            i = m34591a(definiteLengthInputStream);
            ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[i.m27139a()];
            for (int i4 = 0; i4 != aSN1OctetStringArr.length; i4++) {
                aSN1OctetStringArr[i4] = (ASN1OctetString) i.m27140a(i4);
            }
            return new BEROctetString(aSN1OctetStringArr);
        } else if (i2 == 8) {
            return new DERExternal(m34591a(definiteLengthInputStream));
        } else {
            switch (i2) {
                case 16:
                    if (this.f26446b != 0) {
                        return new LazyEncodedSequence(definiteLengthInputStream.m34609b());
                    }
                    return DERFactory.m27160a(m34591a(definiteLengthInputStream));
                case 17:
                    return DERFactory.m27161b(m34591a(definiteLengthInputStream));
                default:
                    i3 = new StringBuilder();
                    i3.append("unknown tag ");
                    i3.append(i2);
                    i3.append(" encountered");
                    throw new IOException(i3.toString());
            }
        }
    }

    /* renamed from: c */
    ASN1EncodableVector m34594c() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        while (true) {
            ASN1Encodable d = m34595d();
            if (d == null) {
                return aSN1EncodableVector;
            }
            aSN1EncodableVector.m27141a(d);
        }
    }

    /* renamed from: a */
    ASN1EncodableVector m34591a(DefiniteLengthInputStream definiteLengthInputStream) {
        return new ASN1InputStream((InputStream) definiteLengthInputStream).m34594c();
    }

    /* renamed from: d */
    public ASN1Primitive m34595d() {
        int read = read();
        if (read > 0) {
            int a = m34585a((InputStream) this, read);
            Object obj = (read & 32) != 0 ? 1 : null;
            int b = m34593b();
            if (b >= 0) {
                try {
                    return m34592a(read, a, b);
                } catch (Throwable e) {
                    throw new ASN1Exception("corrupted stream detected", e);
                }
            } else if (obj != null) {
                ASN1StreamParser aSN1StreamParser = new ASN1StreamParser(new IndefiniteLengthInputStream(this, this.f26445a), this.f26445a);
                if ((read & 64) != 0) {
                    return new BERApplicationSpecificParser(a, aSN1StreamParser).mo5711g();
                }
                if ((read & 128) != 0) {
                    return new BERTaggedObjectParser(true, a, aSN1StreamParser).mo5711g();
                }
                if (a == 4) {
                    return new BEROctetStringParser(aSN1StreamParser).mo5711g();
                }
                if (a == 8) {
                    return new DERExternalParser(aSN1StreamParser).mo5711g();
                }
                switch (a) {
                    case 16:
                        return new BERSequenceParser(aSN1StreamParser).mo5711g();
                    case 17:
                        return new BERSetParser(aSN1StreamParser).mo5711g();
                    default:
                        throw new IOException("unknown BER object encountered");
                }
            } else {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
        } else if (read != 0) {
            return null;
        } else {
            throw new IOException("unexpected end-of-contents marker");
        }
    }

    /* renamed from: a */
    static int m34585a(InputStream inputStream, int i) {
        i &= 31;
        if (i != 31) {
            return i;
        }
        i = 0;
        int read = inputStream.read();
        if ((read & 127) != 0) {
            while (read >= 0 && (read & 128) != 0) {
                i = (i | (read & 127)) << 7;
                read = inputStream.read();
            }
            if (read >= 0) {
                return i | (read & 127);
            }
            throw new EOFException("EOF found inside tag value.");
        }
        throw new IOException("corrupted stream - invalid high tag number found");
    }

    /* renamed from: b */
    static int m34588b(InputStream inputStream, int i) {
        int read = inputStream.read();
        if (read < 0) {
            throw new EOFException("EOF found when length expected");
        } else if (read == 128) {
            return -1;
        } else {
            if (read > 127) {
                read &= 127;
                if (read <= 4) {
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < read) {
                        int read2 = inputStream.read();
                        if (read2 >= 0) {
                            i3 = (i3 << 8) + read2;
                            i2++;
                        } else {
                            throw new EOFException("EOF found reading length");
                        }
                    }
                    if (i3 < 0) {
                        throw new IOException("corrupted stream - negative length found");
                    } else if (i3 < i) {
                        read = i3;
                    } else {
                        throw new IOException("corrupted stream - out of bounds length found");
                    }
                }
                i = new StringBuilder();
                i.append("DER length more than 4 bytes: ");
                i.append(read);
                throw new IOException(i.toString());
            }
            return read;
        }
    }

    /* renamed from: a */
    private static byte[] m34587a(DefiniteLengthInputStream definiteLengthInputStream, byte[][] bArr) {
        int a = definiteLengthInputStream.mo5715a();
        if (definiteLengthInputStream.mo5715a() >= bArr.length) {
            return definiteLengthInputStream.m34609b();
        }
        byte[] bArr2 = bArr[a];
        if (bArr2 == null) {
            bArr2 = new byte[a];
            bArr[a] = bArr2;
        }
        Streams.m29439a((InputStream) definiteLengthInputStream, bArr2);
        return bArr2;
    }

    /* renamed from: b */
    private static char[] m34589b(DefiniteLengthInputStream definiteLengthInputStream) {
        int a = definiteLengthInputStream.mo5715a() / 2;
        char[] cArr = new char[a];
        int i = 0;
        while (i < a) {
            int read = definiteLengthInputStream.read();
            if (read < 0) {
                break;
            }
            int read2 = definiteLengthInputStream.read();
            if (read2 < 0) {
                break;
            }
            int i2 = i + 1;
            cArr[i] = (char) ((read << 8) | (read2 & JfifUtil.MARKER_FIRST_BYTE));
            i = i2;
        }
        return cArr;
    }

    /* renamed from: a */
    static ASN1Primitive m34586a(int i, DefiniteLengthInputStream definiteLengthInputStream, byte[][] bArr) {
        switch (i) {
            case 1:
                return ASN1Boolean.m42940a(m34587a(definiteLengthInputStream, bArr));
            case 2:
                return new ASN1Integer(definiteLengthInputStream.m34609b(), null);
            case 3:
                return DERBitString.m43050a(definiteLengthInputStream.mo5715a(), (InputStream) definiteLengthInputStream);
            case 4:
                return new DEROctetString(definiteLengthInputStream.m34609b());
            case 5:
                return DERNull.f32850a;
            case 6:
                return ASN1ObjectIdentifier.m42975a(m34587a(definiteLengthInputStream, bArr));
            case 10:
                return ASN1Enumerated.m42947a(m34587a(definiteLengthInputStream, bArr));
            case 12:
                return new DERUTF8String(definiteLengthInputStream.m34609b());
            case 18:
                return new DERNumericString(definiteLengthInputStream.m34609b());
            case 19:
                return new DERPrintableString(definiteLengthInputStream.m34609b());
            case 20:
                return new DERT61String(definiteLengthInputStream.m34609b());
            case 22:
                return new DERIA5String(definiteLengthInputStream.m34609b());
            case 23:
                return new ASN1UTCTime(definiteLengthInputStream.m34609b());
            case 24:
                return new ASN1GeneralizedTime(definiteLengthInputStream.m34609b());
            case 26:
                return new DERVisibleString(definiteLengthInputStream.m34609b());
            case 27:
                return new DERGeneralString(definiteLengthInputStream.m34609b());
            case 28:
                return new DERUniversalString(definiteLengthInputStream.m34609b());
            case 30:
                return new DERBMPString(m34589b(definiteLengthInputStream));
            default:
                bArr = new StringBuilder();
                bArr.append("unknown tag ");
                bArr.append(i);
                bArr.append(" encountered");
                throw new IOException(bArr.toString());
        }
    }
}
