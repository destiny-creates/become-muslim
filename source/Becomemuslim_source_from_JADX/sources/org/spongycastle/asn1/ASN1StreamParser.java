package org.spongycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

public class ASN1StreamParser {
    /* renamed from: a */
    private final InputStream f21441a;
    /* renamed from: b */
    private final int f21442b;
    /* renamed from: c */
    private final byte[][] f21443c;

    public ASN1StreamParser(InputStream inputStream) {
        this(inputStream, StreamUtil.m27169a(inputStream));
    }

    public ASN1StreamParser(InputStream inputStream, int i) {
        this.f21441a = inputStream;
        this.f21442b = i;
        this.f21443c = new byte[11][];
    }

    /* renamed from: a */
    ASN1Encodable m27155a(int i) {
        if (i == 4) {
            return new BEROctetStringParser(this);
        }
        if (i == 8) {
            return new DERExternalParser(this);
        }
        switch (i) {
            case 16:
                return new BERSequenceParser(this);
            case 17:
                return new BERSetParser(this);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unknown BER object encountered: 0x");
                stringBuilder.append(Integer.toHexString(i));
                throw new ASN1Exception(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    ASN1Primitive m27156a(boolean z, int i) {
        if (!z) {
            return new DERTaggedObject(false, i, new DEROctetString(((DefiniteLengthInputStream) this.f21441a).m34609b()));
        }
        z = m27157b();
        ASN1Primitive bERTaggedObject;
        if (this.f21441a instanceof IndefiniteLengthInputStream) {
            if (z.m27139a() == 1) {
                bERTaggedObject = new BERTaggedObject(true, i, z.m27140a(0));
            } else {
                bERTaggedObject = new BERTaggedObject(false, i, BERFactory.m27159a(z));
            }
            return bERTaggedObject;
        }
        if (z.m27139a() == 1) {
            bERTaggedObject = new DERTaggedObject(true, i, z.m27140a(0));
        } else {
            bERTaggedObject = new DERTaggedObject(false, i, DERFactory.m27160a(z));
        }
        return bERTaggedObject;
    }

    /* renamed from: a */
    public ASN1Encodable m27154a() {
        int read = this.f21441a.read();
        if (read == -1) {
            return null;
        }
        boolean z = false;
        m27153a(false);
        int a = ASN1InputStream.m34585a(this.f21441a, read);
        if ((read & 32) != 0) {
            z = true;
        }
        int b = ASN1InputStream.m34588b(this.f21441a, this.f21442b);
        if (b >= 0) {
            DefiniteLengthInputStream definiteLengthInputStream = new DefiniteLengthInputStream(this.f21441a, b);
            if ((read & 64) != 0) {
                return new DERApplicationSpecific(z, a, definiteLengthInputStream.m34609b());
            }
            if ((read & 128) != 0) {
                return new BERTaggedObjectParser(z, a, new ASN1StreamParser(definiteLengthInputStream));
            }
            if (z) {
                if (a == 4) {
                    return new BEROctetStringParser(new ASN1StreamParser(definiteLengthInputStream));
                }
                if (a == 8) {
                    return new DERExternalParser(new ASN1StreamParser(definiteLengthInputStream));
                }
                switch (a) {
                    case 16:
                        return new DERSequenceParser(new ASN1StreamParser(definiteLengthInputStream));
                    case 17:
                        return new DERSetParser(new ASN1StreamParser(definiteLengthInputStream));
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("unknown tag ");
                        stringBuilder.append(a);
                        stringBuilder.append(" encountered");
                        throw new IOException(stringBuilder.toString());
                }
            } else if (a == 4) {
                return new DEROctetStringParser(definiteLengthInputStream);
            } else {
                try {
                    return ASN1InputStream.m34586a(a, definiteLengthInputStream, this.f21443c);
                } catch (Throwable e) {
                    throw new ASN1Exception("corrupted stream detected", e);
                }
            }
        } else if (z) {
            ASN1StreamParser aSN1StreamParser = new ASN1StreamParser(new IndefiniteLengthInputStream(this.f21441a, this.f21442b), this.f21442b);
            if ((read & 64) != 0) {
                return new BERApplicationSpecificParser(a, aSN1StreamParser);
            }
            if ((read & 128) != 0) {
                return new BERTaggedObjectParser(true, a, aSN1StreamParser);
            }
            return aSN1StreamParser.m27155a(a);
        } else {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
    }

    /* renamed from: a */
    private void m27153a(boolean z) {
        if (this.f21441a instanceof IndefiniteLengthInputStream) {
            ((IndefiniteLengthInputStream) this.f21441a).m34611a(z);
        }
    }

    /* renamed from: b */
    ASN1EncodableVector m27157b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        while (true) {
            ASN1Encodable a = m27154a();
            if (a == null) {
                return aSN1EncodableVector;
            }
            if (a instanceof InMemoryRepresentable) {
                aSN1EncodableVector.m27141a(((InMemoryRepresentable) a).mo5711g());
            } else {
                aSN1EncodableVector.m27141a(a.mo5709e());
            }
        }
    }
}
