package org.spongycastle.asn1.x509;

import com.facebook.internal.ServerProtocol;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.util.Strings;

public class IssuingDistributionPoint extends ASN1Object {
    /* renamed from: a */
    private DistributionPointName f31324a;
    /* renamed from: b */
    private boolean f31325b;
    /* renamed from: c */
    private boolean f31326c;
    /* renamed from: d */
    private ReasonFlags f31327d;
    /* renamed from: e */
    private boolean f31328e;
    /* renamed from: f */
    private boolean f31329f;
    /* renamed from: g */
    private ASN1Sequence f31330g;

    /* renamed from: a */
    private String m40364a(boolean z) {
        return z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
    }

    /* renamed from: a */
    public static IssuingDistributionPoint m40365a(Object obj) {
        if (obj instanceof IssuingDistributionPoint) {
            return (IssuingDistributionPoint) obj;
        }
        return obj != null ? new IssuingDistributionPoint(ASN1Sequence.m43000a(obj)) : null;
    }

    private IssuingDistributionPoint(ASN1Sequence aSN1Sequence) {
        this.f31330g = aSN1Sequence;
        for (int i = 0; i != aSN1Sequence.mo6862g(); i++) {
            ASN1TaggedObject a = ASN1TaggedObject.m43026a(aSN1Sequence.mo6860a(i));
            switch (a.m43030b()) {
                case 0:
                    this.f31324a = DistributionPointName.m40317a(a, true);
                    break;
                case 1:
                    this.f31325b = ASN1Boolean.m42938a(a, false).m42944b();
                    break;
                case 2:
                    this.f31326c = ASN1Boolean.m42938a(a, false).m42944b();
                    break;
                case 3:
                    this.f31327d = new ReasonFlags(DERBitString.m43052a(a, false));
                    break;
                case 4:
                    this.f31328e = ASN1Boolean.m42938a(a, false).m42944b();
                    break;
                case 5:
                    this.f31329f = ASN1Boolean.m42938a(a, false).m42944b();
                    break;
                default:
                    throw new IllegalArgumentException("unknown tag in IssuingDistributionPoint");
            }
        }
    }

    /* renamed from: a */
    public boolean m40367a() {
        return this.f31325b;
    }

    /* renamed from: b */
    public boolean m40368b() {
        return this.f31326c;
    }

    /* renamed from: c */
    public boolean m40369c() {
        return this.f31328e;
    }

    /* renamed from: d */
    public boolean m40370d() {
        return this.f31329f;
    }

    /* renamed from: g */
    public DistributionPointName m40372g() {
        return this.f31324a;
    }

    /* renamed from: h */
    public ReasonFlags m40373h() {
        return this.f31327d;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f31330g;
    }

    public String toString() {
        String a = Strings.m29418a();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("IssuingDistributionPoint: [");
        stringBuffer.append(a);
        if (this.f31324a != null) {
            m40366a(stringBuffer, a, "distributionPoint", this.f31324a.toString());
        }
        if (this.f31325b) {
            m40366a(stringBuffer, a, "onlyContainsUserCerts", m40364a(this.f31325b));
        }
        if (this.f31326c) {
            m40366a(stringBuffer, a, "onlyContainsCACerts", m40364a(this.f31326c));
        }
        if (this.f31327d != null) {
            m40366a(stringBuffer, a, "onlySomeReasons", this.f31327d.toString());
        }
        if (this.f31329f) {
            m40366a(stringBuffer, a, "onlyContainsAttributeCerts", m40364a(this.f31329f));
        }
        if (this.f31328e) {
            m40366a(stringBuffer, a, "indirectCRL", m40364a(this.f31328e));
        }
        stringBuffer.append("]");
        stringBuffer.append(a);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private void m40366a(StringBuffer stringBuffer, String str, String str2, String str3) {
        String str4 = "    ";
        stringBuffer.append(str4);
        stringBuffer.append(str2);
        stringBuffer.append(":");
        stringBuffer.append(str);
        stringBuffer.append(str4);
        stringBuffer.append(str4);
        stringBuffer.append(str3);
        stringBuffer.append(str);
    }
}
