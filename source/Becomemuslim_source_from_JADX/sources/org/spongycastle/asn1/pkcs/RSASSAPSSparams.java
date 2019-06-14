package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class RSASSAPSSparams extends ASN1Object {
    /* renamed from: a */
    public static final AlgorithmIdentifier f31034a = new AlgorithmIdentifier(OIWObjectIdentifiers.f21830i, DERNull.f32850a);
    /* renamed from: b */
    public static final AlgorithmIdentifier f31035b = new AlgorithmIdentifier(PKCSObjectIdentifiers.l_, f31034a);
    /* renamed from: c */
    public static final ASN1Integer f31036c = new ASN1Integer(20);
    /* renamed from: d */
    public static final ASN1Integer f31037d = new ASN1Integer(1);
    /* renamed from: e */
    private AlgorithmIdentifier f31038e;
    /* renamed from: f */
    private AlgorithmIdentifier f31039f;
    /* renamed from: g */
    private ASN1Integer f31040g;
    /* renamed from: h */
    private ASN1Integer f31041h;

    /* renamed from: a */
    public static RSASSAPSSparams m40148a(Object obj) {
        if (obj instanceof RSASSAPSSparams) {
            return (RSASSAPSSparams) obj;
        }
        return obj != null ? new RSASSAPSSparams(ASN1Sequence.m43000a(obj)) : null;
    }

    public RSASSAPSSparams() {
        this.f31038e = f31034a;
        this.f31039f = f31035b;
        this.f31040g = f31036c;
        this.f31041h = f31037d;
    }

    public RSASSAPSSparams(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, ASN1Integer aSN1Integer, ASN1Integer aSN1Integer2) {
        this.f31038e = algorithmIdentifier;
        this.f31039f = algorithmIdentifier2;
        this.f31040g = aSN1Integer;
        this.f31041h = aSN1Integer2;
    }

    private RSASSAPSSparams(ASN1Sequence aSN1Sequence) {
        this.f31038e = f31034a;
        this.f31039f = f31035b;
        this.f31040g = f31036c;
        this.f31041h = f31037d;
        for (int i = 0; i != aSN1Sequence.mo6862g(); i++) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.mo6860a(i);
            switch (aSN1TaggedObject.m43030b()) {
                case 0:
                    this.f31038e = AlgorithmIdentifier.m40229a(aSN1TaggedObject, true);
                    break;
                case 1:
                    this.f31039f = AlgorithmIdentifier.m40229a(aSN1TaggedObject, true);
                    break;
                case 2:
                    this.f31040g = ASN1Integer.m42964a(aSN1TaggedObject, true);
                    break;
                case 3:
                    this.f31041h = ASN1Integer.m42964a(aSN1TaggedObject, true);
                    break;
                default:
                    throw new IllegalArgumentException("unknown tag");
            }
        }
    }

    /* renamed from: a */
    public AlgorithmIdentifier m40149a() {
        return this.f31038e;
    }

    /* renamed from: b */
    public AlgorithmIdentifier m40150b() {
        return this.f31039f;
    }

    /* renamed from: c */
    public BigInteger m40151c() {
        return this.f31040g.m42968b();
    }

    /* renamed from: d */
    public BigInteger m40152d() {
        return this.f31041h.m42968b();
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (!this.f31038e.equals(f31034a)) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 0, this.f31038e));
        }
        if (!this.f31039f.equals(f31035b)) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 1, this.f31039f));
        }
        if (!this.f31040g.equals(f31036c)) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 2, this.f31040g));
        }
        if (!this.f31041h.equals(f31037d)) {
            aSN1EncodableVector.m27141a(new DERTaggedObject(true, 3, this.f31041h));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
