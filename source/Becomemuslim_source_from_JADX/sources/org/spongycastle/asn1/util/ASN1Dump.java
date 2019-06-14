package org.spongycastle.asn1.util;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.ASN1UTCTime;
import org.spongycastle.asn1.BERApplicationSpecific;
import org.spongycastle.asn1.BEROctetString;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.BERSet;
import org.spongycastle.asn1.BERTaggedObject;
import org.spongycastle.asn1.DERApplicationSpecific;
import org.spongycastle.asn1.DERBMPString;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERExternal;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERT61String;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.asn1.DERVisibleString;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

public class ASN1Dump {
    /* renamed from: a */
    static void m27222a(String str, boolean z, ASN1Primitive aSN1Primitive, StringBuffer stringBuffer) {
        String a = Strings.m29418a();
        Enumeration c;
        StringBuilder stringBuilder;
        String stringBuilder2;
        if (aSN1Primitive instanceof ASN1Sequence) {
            c = ((ASN1Sequence) aSN1Primitive).mo6861c();
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("    ");
            stringBuilder2 = stringBuilder.toString();
            stringBuffer.append(str);
            if ((aSN1Primitive instanceof BERSequence) != null) {
                stringBuffer.append("BER Sequence");
            } else if ((aSN1Primitive instanceof DERSequence) != null) {
                stringBuffer.append("DER Sequence");
            } else {
                stringBuffer.append("Sequence");
            }
            stringBuffer.append(a);
            while (c.hasMoreElements() != null) {
                str = c.nextElement();
                if (str != null) {
                    if (str.equals(DERNull.f32850a) == null) {
                        if ((str instanceof ASN1Primitive) != null) {
                            m27222a(stringBuilder2, z, (ASN1Primitive) str, stringBuffer);
                        } else {
                            m27222a(stringBuilder2, z, ((ASN1Encodable) str).mo5709e(), stringBuffer);
                        }
                    }
                }
                stringBuffer.append(stringBuilder2);
                stringBuffer.append("NULL");
                stringBuffer.append(a);
            }
        } else if (aSN1Primitive instanceof ASN1TaggedObject) {
            r1 = new StringBuilder();
            r1.append(str);
            r1.append("    ");
            String stringBuilder3 = r1.toString();
            stringBuffer.append(str);
            if ((aSN1Primitive instanceof BERTaggedObject) != null) {
                stringBuffer.append("BER Tagged [");
            } else {
                stringBuffer.append("Tagged [");
            }
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
            stringBuffer.append(Integer.toString(aSN1TaggedObject.m43030b()));
            stringBuffer.append(']');
            if (aSN1TaggedObject.m43031c() == null) {
                stringBuffer.append(" IMPLICIT ");
            }
            stringBuffer.append(a);
            if (aSN1TaggedObject.m43035j() != null) {
                stringBuffer.append(stringBuilder3);
                stringBuffer.append("EMPTY");
                stringBuffer.append(a);
                return;
            }
            m27222a(stringBuilder3, z, aSN1TaggedObject.m43036k(), stringBuffer);
        } else if (aSN1Primitive instanceof ASN1Set) {
            c = ((ASN1Set) aSN1Primitive).m43020b();
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("    ");
            stringBuilder2 = stringBuilder.toString();
            stringBuffer.append(str);
            if ((aSN1Primitive instanceof BERSet) != null) {
                stringBuffer.append("BER Set");
            } else {
                stringBuffer.append("DER Set");
            }
            stringBuffer.append(a);
            while (c.hasMoreElements() != null) {
                str = c.nextElement();
                if (str == null) {
                    stringBuffer.append(stringBuilder2);
                    stringBuffer.append("NULL");
                    stringBuffer.append(a);
                } else if ((str instanceof ASN1Primitive) != null) {
                    m27222a(stringBuilder2, z, (ASN1Primitive) str, stringBuffer);
                } else {
                    m27222a(stringBuilder2, z, ((ASN1Encodable) str).mo5709e(), stringBuffer);
                }
            }
        } else if (aSN1Primitive instanceof ASN1OctetString) {
            ASN1OctetString aSN1OctetString = (ASN1OctetString) aSN1Primitive;
            if ((aSN1Primitive instanceof BEROctetString) != null) {
                aSN1Primitive = new StringBuilder();
                aSN1Primitive.append(str);
                aSN1Primitive.append("BER Constructed Octet String");
                aSN1Primitive.append("[");
                aSN1Primitive.append(aSN1OctetString.mo6859c().length);
                aSN1Primitive.append("] ");
                stringBuffer.append(aSN1Primitive.toString());
            } else {
                aSN1Primitive = new StringBuilder();
                aSN1Primitive.append(str);
                aSN1Primitive.append("DER Octet String");
                aSN1Primitive.append("[");
                aSN1Primitive.append(aSN1OctetString.mo6859c().length);
                aSN1Primitive.append("] ");
                stringBuffer.append(aSN1Primitive.toString());
            }
            if (z) {
                stringBuffer.append(m27220a(str, aSN1OctetString.mo6859c()));
            } else {
                stringBuffer.append(a);
            }
        } else if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
            z = new StringBuilder();
            z.append(str);
            z.append("ObjectIdentifier(");
            z.append(((ASN1ObjectIdentifier) aSN1Primitive).m42986b());
            z.append(")");
            z.append(a);
            stringBuffer.append(z.toString());
        } else if (aSN1Primitive instanceof ASN1Boolean) {
            z = new StringBuilder();
            z.append(str);
            z.append("Boolean(");
            z.append(((ASN1Boolean) aSN1Primitive).m42944b());
            z.append(")");
            z.append(a);
            stringBuffer.append(z.toString());
        } else if (aSN1Primitive instanceof ASN1Integer) {
            z = new StringBuilder();
            z.append(str);
            z.append("Integer(");
            z.append(((ASN1Integer) aSN1Primitive).m42968b());
            z.append(")");
            z.append(a);
            stringBuffer.append(z.toString());
        } else if (aSN1Primitive instanceof DERBitString) {
            DERBitString dERBitString = (DERBitString) aSN1Primitive;
            r1 = new StringBuilder();
            r1.append(str);
            r1.append("DER Bit String");
            r1.append("[");
            r1.append(dERBitString.m43059c().length);
            r1.append(", ");
            r1.append(dERBitString.m43061g());
            r1.append("] ");
            stringBuffer.append(r1.toString());
            if (z) {
                stringBuffer.append(m27220a(str, dERBitString.m43059c()));
            } else {
                stringBuffer.append(a);
            }
        } else if (aSN1Primitive instanceof DERIA5String) {
            z = new StringBuilder();
            z.append(str);
            z.append("IA5String(");
            z.append(((DERIA5String) aSN1Primitive).mo6440b());
            z.append(") ");
            z.append(a);
            stringBuffer.append(z.toString());
        } else if (aSN1Primitive instanceof DERUTF8String) {
            z = new StringBuilder();
            z.append(str);
            z.append("UTF8String(");
            z.append(((DERUTF8String) aSN1Primitive).mo6440b());
            z.append(") ");
            z.append(a);
            stringBuffer.append(z.toString());
        } else if (aSN1Primitive instanceof DERPrintableString) {
            z = new StringBuilder();
            z.append(str);
            z.append("PrintableString(");
            z.append(((DERPrintableString) aSN1Primitive).mo6440b());
            z.append(") ");
            z.append(a);
            stringBuffer.append(z.toString());
        } else if (aSN1Primitive instanceof DERVisibleString) {
            z = new StringBuilder();
            z.append(str);
            z.append("VisibleString(");
            z.append(((DERVisibleString) aSN1Primitive).mo6440b());
            z.append(") ");
            z.append(a);
            stringBuffer.append(z.toString());
        } else if (aSN1Primitive instanceof DERBMPString) {
            z = new StringBuilder();
            z.append(str);
            z.append("BMPString(");
            z.append(((DERBMPString) aSN1Primitive).mo6440b());
            z.append(") ");
            z.append(a);
            stringBuffer.append(z.toString());
        } else if (aSN1Primitive instanceof DERT61String) {
            z = new StringBuilder();
            z.append(str);
            z.append("T61String(");
            z.append(((DERT61String) aSN1Primitive).mo6440b());
            z.append(") ");
            z.append(a);
            stringBuffer.append(z.toString());
        } else if (aSN1Primitive instanceof ASN1UTCTime) {
            z = new StringBuilder();
            z.append(str);
            z.append("UTCTime(");
            z.append(((ASN1UTCTime) aSN1Primitive).m43041c());
            z.append(") ");
            z.append(a);
            stringBuffer.append(z.toString());
        } else if (aSN1Primitive instanceof ASN1GeneralizedTime) {
            z = new StringBuilder();
            z.append(str);
            z.append("GeneralizedTime(");
            z.append(((ASN1GeneralizedTime) aSN1Primitive).m42960b());
            z.append(") ");
            z.append(a);
            stringBuffer.append(z.toString());
        } else if (aSN1Primitive instanceof BERApplicationSpecific) {
            stringBuffer.append(m27219a("BER", str, z, aSN1Primitive, a));
        } else if (aSN1Primitive instanceof DERApplicationSpecific) {
            stringBuffer.append(m27219a("DER", str, z, aSN1Primitive, a));
        } else if (aSN1Primitive instanceof ASN1Enumerated) {
            ASN1Enumerated aSN1Enumerated = (ASN1Enumerated) aSN1Primitive;
            z = new StringBuilder();
            z.append(str);
            z.append("DER Enumerated(");
            z.append(aSN1Enumerated.m42951b());
            z.append(")");
            z.append(a);
            stringBuffer.append(z.toString());
        } else if (aSN1Primitive instanceof DERExternal) {
            DERExternal dERExternal = (DERExternal) aSN1Primitive;
            r1 = new StringBuilder();
            r1.append(str);
            r1.append("External ");
            r1.append(a);
            stringBuffer.append(r1.toString());
            r1 = new StringBuilder();
            r1.append(str);
            r1.append("    ");
            str = r1.toString();
            if (dERExternal.m43069c() != null) {
                r1 = new StringBuilder();
                r1.append(str);
                r1.append("Direct Reference: ");
                r1.append(dERExternal.m43069c().m42986b());
                r1.append(a);
                stringBuffer.append(r1.toString());
            }
            if (dERExternal.m43073k() != null) {
                r1 = new StringBuilder();
                r1.append(str);
                r1.append("Indirect Reference: ");
                r1.append(dERExternal.m43073k().toString());
                r1.append(a);
                stringBuffer.append(r1.toString());
            }
            if (dERExternal.m43068b() != null) {
                m27222a(str, z, dERExternal.m43068b(), stringBuffer);
            }
            r1 = new StringBuilder();
            r1.append(str);
            r1.append("Encoding: ");
            r1.append(dERExternal.m43071g());
            r1.append(a);
            stringBuffer.append(r1.toString());
            m27222a(str, z, dERExternal.m43072j(), stringBuffer);
        } else {
            z = new StringBuilder();
            z.append(str);
            z.append(aSN1Primitive.toString());
            z.append(a);
            stringBuffer.append(z.toString());
        }
    }

    /* renamed from: a */
    private static String m27219a(String str, String str2, boolean z, ASN1Primitive aSN1Primitive, String str3) {
        DERApplicationSpecific dERApplicationSpecific = (DERApplicationSpecific) aSN1Primitive;
        StringBuffer stringBuffer = new StringBuffer();
        if (dERApplicationSpecific.mo6788a()) {
            try {
                ASN1Sequence a = ASN1Sequence.m43000a(dERApplicationSpecific.m42930a(16));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str2);
                stringBuilder.append(str);
                stringBuilder.append(" ApplicationSpecific[");
                stringBuilder.append(dERApplicationSpecific.m42935c());
                stringBuilder.append("]");
                stringBuilder.append(str3);
                stringBuffer.append(stringBuilder.toString());
                str = a.mo6861c();
                while (str.hasMoreElements() != null) {
                    aSN1Primitive = new StringBuilder();
                    aSN1Primitive.append(str2);
                    aSN1Primitive.append("    ");
                    m27222a(aSN1Primitive.toString(), z, (ASN1Primitive) str.nextElement(), stringBuffer);
                }
            } catch (String str4) {
                stringBuffer.append(str4);
            }
            return stringBuffer.toString();
        }
        z = new StringBuilder();
        z.append(str2);
        z.append(str4);
        z.append(" ApplicationSpecific[");
        z.append(dERApplicationSpecific.m42935c());
        z.append("] (");
        z.append(new String(Hex.m29437a(dERApplicationSpecific.m42934b())));
        z.append(")");
        z.append(str3);
        return z.toString();
    }

    /* renamed from: a */
    public static String m27217a(Object obj) {
        return m27218a(obj, false);
    }

    /* renamed from: a */
    public static String m27218a(Object obj, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        if (obj instanceof ASN1Primitive) {
            m27222a("", z, (ASN1Primitive) obj, stringBuffer);
        } else if (obj instanceof ASN1Encodable) {
            m27222a("", z, ((ASN1Encodable) obj).mo5709e(), stringBuffer);
        } else {
            z = new StringBuilder();
            z.append("unknown object type ");
            z.append(obj.toString());
            return z.toString();
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static String m27220a(String str, byte[] bArr) {
        String a = Strings.m29418a();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("    ");
        str = stringBuilder.toString();
        stringBuffer.append(a);
        for (int i = 0; i < bArr.length; i += 32) {
            if (bArr.length - i > 32) {
                stringBuffer.append(str);
                stringBuffer.append(new String(Hex.m29438a(bArr, i, 32)));
                stringBuffer.append("    ");
                stringBuffer.append(m27221a(bArr, i, 32));
                stringBuffer.append(a);
            } else {
                stringBuffer.append(str);
                stringBuffer.append(new String(Hex.m29438a(bArr, i, bArr.length - i)));
                for (int length = bArr.length - i; length != 32; length++) {
                    stringBuffer.append("  ");
                }
                stringBuffer.append("    ");
                stringBuffer.append(m27221a(bArr, i, bArr.length - i));
                stringBuffer.append(a);
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static String m27221a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i;
        while (i3 != i + i2) {
            if (bArr[i3] >= (byte) 32 && bArr[i3] <= (byte) 126) {
                stringBuffer.append((char) bArr[i3]);
            }
            i3++;
        }
        return stringBuffer.toString();
    }
}
