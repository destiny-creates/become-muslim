package org.spongycastle.asn1;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Iterable;

public abstract class ASN1Sequence extends ASN1Primitive implements Iterable<ASN1Encodable> {
    /* renamed from: a */
    protected Vector f32488a = new Vector();

    /* renamed from: org.spongycastle.asn1.ASN1Sequence$1 */
    class C81961 implements ASN1SequenceParser {
        /* renamed from: a */
        final /* synthetic */ ASN1Sequence f30419a;

        /* renamed from: g */
        public ASN1Primitive mo5711g() {
            return this.f30419a;
        }

        /* renamed from: e */
        public ASN1Primitive mo5709e() {
            return this.f30419a;
        }
    }

    /* renamed from: a */
    abstract void mo6787a(ASN1OutputStream aSN1OutputStream);

    /* renamed from: a */
    boolean mo6788a() {
        return true;
    }

    /* renamed from: a */
    public static ASN1Sequence m43000a(Object obj) {
        if (obj != null) {
            if (!(obj instanceof ASN1Sequence)) {
                if (obj instanceof ASN1SequenceParser) {
                    return m43000a(((ASN1SequenceParser) obj).mo5709e());
                }
                StringBuilder stringBuilder;
                if (obj instanceof byte[]) {
                    try {
                        return m43000a(ASN1Primitive.m39798b((byte[]) obj));
                    } catch (Object obj2) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("failed to construct sequence from byte[]: ");
                        stringBuilder.append(obj2.getMessage());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                if (obj2 instanceof ASN1Encodable) {
                    ASN1Primitive e = ((ASN1Encodable) obj2).mo5709e();
                    if (e instanceof ASN1Sequence) {
                        return (ASN1Sequence) e;
                    }
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("unknown object in getInstance: ");
                stringBuilder.append(obj2.getClass().getName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return (ASN1Sequence) obj2;
    }

    /* renamed from: a */
    public static ASN1Sequence m43001a(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            if (aSN1TaggedObject.m43031c()) {
                return m43000a(aSN1TaggedObject.m43036k().mo5709e());
            }
            throw new IllegalArgumentException("object implicit - explicit expected.");
        } else if (aSN1TaggedObject.m43031c()) {
            if (aSN1TaggedObject instanceof BERTaggedObject) {
                return new BERSequence(aSN1TaggedObject.m43036k());
            }
            return new DLSequence(aSN1TaggedObject.m43036k());
        } else if (aSN1TaggedObject.m43036k() instanceof ASN1Sequence) {
            return (ASN1Sequence) aSN1TaggedObject.m43036k();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unknown object in getInstance: ");
            stringBuilder.append(aSN1TaggedObject.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    protected ASN1Sequence() {
    }

    protected ASN1Sequence(ASN1Encodable aSN1Encodable) {
        this.f32488a.addElement(aSN1Encodable);
    }

    protected ASN1Sequence(ASN1EncodableVector aSN1EncodableVector) {
        for (int i = 0; i != aSN1EncodableVector.m27139a(); i++) {
            this.f32488a.addElement(aSN1EncodableVector.m27140a(i));
        }
    }

    protected ASN1Sequence(ASN1Encodable[] aSN1EncodableArr) {
        for (int i = 0; i != aSN1EncodableArr.length; i++) {
            this.f32488a.addElement(aSN1EncodableArr[i]);
        }
    }

    /* renamed from: b */
    public ASN1Encodable[] m43006b() {
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[mo6862g()];
        for (int i = 0; i != mo6862g(); i++) {
            aSN1EncodableArr[i] = mo6860a(i);
        }
        return aSN1EncodableArr;
    }

    /* renamed from: c */
    public Enumeration mo6861c() {
        return this.f32488a.elements();
    }

    /* renamed from: a */
    public ASN1Encodable mo6860a(int i) {
        return (ASN1Encodable) this.f32488a.elementAt(i);
    }

    /* renamed from: g */
    public int mo6862g() {
        return this.f32488a.size();
    }

    public int hashCode() {
        Enumeration c = mo6861c();
        int g = mo6862g();
        while (c.hasMoreElements()) {
            g = (g * 17) ^ m42999a(c).hashCode();
        }
        return g;
    }

    /* renamed from: a */
    boolean mo6789a(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Sequence)) {
            return false;
        }
        ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1Primitive;
        if (mo6862g() != aSN1Sequence.mo6862g()) {
            return false;
        }
        Enumeration c = mo6861c();
        Enumeration c2 = aSN1Sequence.mo6861c();
        while (c.hasMoreElements()) {
            ASN1Encodable a = m42999a(c);
            ASN1Encodable a2 = m42999a(c2);
            ASN1Primitive e = a.mo5709e();
            ASN1Primitive e2 = a2.mo5709e();
            if (e != e2) {
                if (!e.equals(e2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    private ASN1Encodable m42999a(Enumeration enumeration) {
        return (ASN1Encodable) enumeration.nextElement();
    }

    /* renamed from: h */
    ASN1Primitive mo6791h() {
        ASN1Primitive dERSequence = new DERSequence();
        dERSequence.f32488a = this.f32488a;
        return dERSequence;
    }

    /* renamed from: i */
    ASN1Primitive mo6792i() {
        ASN1Primitive dLSequence = new DLSequence();
        dLSequence.f32488a = this.f32488a;
        return dLSequence;
    }

    public String toString() {
        return this.f32488a.toString();
    }

    public Iterator<ASN1Encodable> iterator() {
        return new Arrays.Iterator(m43006b());
    }
}
