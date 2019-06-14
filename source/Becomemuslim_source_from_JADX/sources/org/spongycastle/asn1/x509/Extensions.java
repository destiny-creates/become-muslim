package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class Extensions extends ASN1Object {
    /* renamed from: a */
    private Hashtable f31306a = new Hashtable();
    /* renamed from: b */
    private Vector f31307b = new Vector();

    /* renamed from: a */
    public static Extensions m40330a(Object obj) {
        if (obj instanceof Extensions) {
            return (Extensions) obj;
        }
        return obj != null ? new Extensions(ASN1Sequence.m43000a(obj)) : null;
    }

    private Extensions(ASN1Sequence aSN1Sequence) {
        aSN1Sequence = aSN1Sequence.mo6861c();
        while (aSN1Sequence.hasMoreElements()) {
            Extension a = Extension.m40324a(aSN1Sequence.nextElement());
            this.f31306a.put(a.m40325a(), a);
            this.f31307b.addElement(a.m40325a());
        }
    }

    /* renamed from: a */
    public Enumeration m40331a() {
        return this.f31307b.elements();
    }

    /* renamed from: a */
    public Extension m40332a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (Extension) this.f31306a.get(aSN1ObjectIdentifier);
    }

    /* renamed from: b */
    public ASN1Encodable m40333b(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        aSN1ObjectIdentifier = m40332a(aSN1ObjectIdentifier);
        return aSN1ObjectIdentifier != null ? aSN1ObjectIdentifier.m40328d() : null;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration elements = this.f31307b.elements();
        while (elements.hasMoreElements()) {
            aSN1EncodableVector.m27141a((Extension) this.f31306a.get((ASN1ObjectIdentifier) elements.nextElement()));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
