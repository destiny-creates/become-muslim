package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.util.Arrays;

public class PBKDF2Params extends ASN1Object {
    /* renamed from: a */
    private static final AlgorithmIdentifier f30994a = new AlgorithmIdentifier(PKCSObjectIdentifiers.f21842I, DERNull.f32850a);
    /* renamed from: b */
    private final ASN1OctetString f30995b;
    /* renamed from: c */
    private final ASN1Integer f30996c;
    /* renamed from: d */
    private final ASN1Integer f30997d;
    /* renamed from: e */
    private final AlgorithmIdentifier f30998e;

    /* renamed from: a */
    public static PBKDF2Params m40097a(Object obj) {
        if (obj instanceof PBKDF2Params) {
            return (PBKDF2Params) obj;
        }
        return obj != null ? new PBKDF2Params(ASN1Sequence.m43000a(obj)) : null;
    }

    public PBKDF2Params(byte[] bArr, int i) {
        this(bArr, i, 0);
    }

    public PBKDF2Params(byte[] bArr, int i, int i2) {
        this(bArr, i, i2, null);
    }

    public PBKDF2Params(byte[] bArr, int i, int i2, AlgorithmIdentifier algorithmIdentifier) {
        this.f30995b = new DEROctetString(Arrays.m29373b(bArr));
        this.f30996c = new ASN1Integer((long) i);
        if (i2 > 0) {
            this.f30997d = new ASN1Integer((long) i2);
        } else {
            this.f30997d = null;
        }
        this.f30998e = algorithmIdentifier;
    }

    private PBKDF2Params(ASN1Sequence aSN1Sequence) {
        aSN1Sequence = aSN1Sequence.mo6861c();
        this.f30995b = (ASN1OctetString) aSN1Sequence.nextElement();
        this.f30996c = (ASN1Integer) aSN1Sequence.nextElement();
        if (aSN1Sequence.hasMoreElements()) {
            ASN1Sequence nextElement = aSN1Sequence.nextElement();
            if (nextElement instanceof ASN1Integer) {
                this.f30997d = ASN1Integer.m42963a((Object) nextElement);
                aSN1Sequence = aSN1Sequence.hasMoreElements() ? aSN1Sequence.nextElement() : null;
            } else {
                this.f30997d = null;
                aSN1Sequence = nextElement;
            }
            if (aSN1Sequence != null) {
                this.f30998e = AlgorithmIdentifier.m40228a(aSN1Sequence);
                return;
            } else {
                this.f30998e = null;
                return;
            }
        }
        this.f30997d = null;
        this.f30998e = null;
    }

    /* renamed from: a */
    public byte[] m40098a() {
        return this.f30995b.mo6859c();
    }

    /* renamed from: b */
    public BigInteger m40099b() {
        return this.f30996c.m42968b();
    }

    /* renamed from: c */
    public boolean m40100c() {
        if (this.f30998e != null) {
            if (!this.f30998e.equals(f30994a)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public AlgorithmIdentifier m40101d() {
        if (this.f30998e != null) {
            return this.f30998e;
        }
        return f30994a;
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m27141a(this.f30995b);
        aSN1EncodableVector.m27141a(this.f30996c);
        if (this.f30997d != null) {
            aSN1EncodableVector.m27141a(this.f30997d);
        }
        if (!(this.f30998e == null || this.f30998e.equals(f30994a))) {
            aSN1EncodableVector.m27141a(this.f30998e);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
