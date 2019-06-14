package org.spongycastle.jce;

import java.io.IOException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.CertificationRequest;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSASSAPSSparams;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;

public class PKCS10CertificationRequest extends CertificationRequest {
    /* renamed from: d */
    private static Hashtable f32670d = new Hashtable();
    /* renamed from: e */
    private static Hashtable f32671e = new Hashtable();
    /* renamed from: f */
    private static Hashtable f32672f = new Hashtable();
    /* renamed from: g */
    private static Hashtable f32673g = new Hashtable();
    /* renamed from: h */
    private static Set f32674h = new HashSet();

    static {
        f32670d.put("MD2WITHRSAENCRYPTION", new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"));
        f32670d.put("MD2WITHRSA", new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"));
        f32670d.put("MD5WITHRSAENCRYPTION", new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"));
        f32670d.put("MD5WITHRSA", new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"));
        f32670d.put("RSAWITHMD5", new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"));
        f32670d.put("SHA1WITHRSAENCRYPTION", new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"));
        f32670d.put("SHA1WITHRSA", new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"));
        f32670d.put("SHA224WITHRSAENCRYPTION", PKCSObjectIdentifiers.p_);
        f32670d.put("SHA224WITHRSA", PKCSObjectIdentifiers.p_);
        f32670d.put("SHA256WITHRSAENCRYPTION", PKCSObjectIdentifiers.m_);
        f32670d.put("SHA256WITHRSA", PKCSObjectIdentifiers.m_);
        f32670d.put("SHA384WITHRSAENCRYPTION", PKCSObjectIdentifiers.n_);
        f32670d.put("SHA384WITHRSA", PKCSObjectIdentifiers.n_);
        f32670d.put("SHA512WITHRSAENCRYPTION", PKCSObjectIdentifiers.o_);
        f32670d.put("SHA512WITHRSA", PKCSObjectIdentifiers.o_);
        f32670d.put("SHA1WITHRSAANDMGF1", PKCSObjectIdentifiers.f21864k);
        f32670d.put("SHA224WITHRSAANDMGF1", PKCSObjectIdentifiers.f21864k);
        f32670d.put("SHA256WITHRSAANDMGF1", PKCSObjectIdentifiers.f21864k);
        f32670d.put("SHA384WITHRSAANDMGF1", PKCSObjectIdentifiers.f21864k);
        f32670d.put("SHA512WITHRSAANDMGF1", PKCSObjectIdentifiers.f21864k);
        f32670d.put("RSAWITHSHA1", new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"));
        f32670d.put("RIPEMD128WITHRSAENCRYPTION", TeleTrusTObjectIdentifiers.f21987g);
        f32670d.put("RIPEMD128WITHRSA", TeleTrusTObjectIdentifiers.f21987g);
        f32670d.put("RIPEMD160WITHRSAENCRYPTION", TeleTrusTObjectIdentifiers.f21986f);
        f32670d.put("RIPEMD160WITHRSA", TeleTrusTObjectIdentifiers.f21986f);
        f32670d.put("RIPEMD256WITHRSAENCRYPTION", TeleTrusTObjectIdentifiers.f21988h);
        f32670d.put("RIPEMD256WITHRSA", TeleTrusTObjectIdentifiers.f21988h);
        f32670d.put("SHA1WITHDSA", new ASN1ObjectIdentifier("1.2.840.10040.4.3"));
        f32670d.put("DSAWITHSHA1", new ASN1ObjectIdentifier("1.2.840.10040.4.3"));
        f32670d.put("SHA224WITHDSA", NISTObjectIdentifiers.f21776L);
        f32670d.put("SHA256WITHDSA", NISTObjectIdentifiers.f21777M);
        f32670d.put("SHA384WITHDSA", NISTObjectIdentifiers.f21778N);
        f32670d.put("SHA512WITHDSA", NISTObjectIdentifiers.f21779O);
        f32670d.put("SHA1WITHECDSA", X9ObjectIdentifiers.f22168i);
        f32670d.put("SHA224WITHECDSA", X9ObjectIdentifiers.f22172m);
        f32670d.put("SHA256WITHECDSA", X9ObjectIdentifiers.f22173n);
        f32670d.put("SHA384WITHECDSA", X9ObjectIdentifiers.f22174o);
        f32670d.put("SHA512WITHECDSA", X9ObjectIdentifiers.f22175p);
        f32670d.put("ECDSAWITHSHA1", X9ObjectIdentifiers.f22168i);
        f32670d.put("GOST3411WITHGOST3410", CryptoProObjectIdentifiers.f21565k);
        f32670d.put("GOST3410WITHGOST3411", CryptoProObjectIdentifiers.f21565k);
        f32670d.put("GOST3411WITHECGOST3410", CryptoProObjectIdentifiers.f21566l);
        f32670d.put("GOST3411WITHECGOST3410-2001", CryptoProObjectIdentifiers.f21566l);
        f32670d.put("GOST3411WITHGOST3410-2001", CryptoProObjectIdentifiers.f21566l);
        f32673g.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
        f32673g.put(PKCSObjectIdentifiers.p_, "SHA224WITHRSA");
        f32673g.put(PKCSObjectIdentifiers.m_, "SHA256WITHRSA");
        f32673g.put(PKCSObjectIdentifiers.n_, "SHA384WITHRSA");
        f32673g.put(PKCSObjectIdentifiers.o_, "SHA512WITHRSA");
        f32673g.put(CryptoProObjectIdentifiers.f21565k, "GOST3411WITHGOST3410");
        f32673g.put(CryptoProObjectIdentifiers.f21566l, "GOST3411WITHECGOST3410");
        f32673g.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"), "MD5WITHRSA");
        f32673g.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"), "MD2WITHRSA");
        f32673g.put(new ASN1ObjectIdentifier("1.2.840.10040.4.3"), "SHA1WITHDSA");
        f32673g.put(X9ObjectIdentifiers.f22168i, "SHA1WITHECDSA");
        f32673g.put(X9ObjectIdentifiers.f22172m, "SHA224WITHECDSA");
        f32673g.put(X9ObjectIdentifiers.f22173n, "SHA256WITHECDSA");
        f32673g.put(X9ObjectIdentifiers.f22174o, "SHA384WITHECDSA");
        f32673g.put(X9ObjectIdentifiers.f22175p, "SHA512WITHECDSA");
        f32673g.put(OIWObjectIdentifiers.f21832k, "SHA1WITHRSA");
        f32673g.put(OIWObjectIdentifiers.f21831j, "SHA1WITHDSA");
        f32673g.put(NISTObjectIdentifiers.f21776L, "SHA224WITHDSA");
        f32673g.put(NISTObjectIdentifiers.f21777M, "SHA256WITHDSA");
        f32672f.put(PKCSObjectIdentifiers.h_, "RSA");
        f32672f.put(X9ObjectIdentifiers.f22154U, "DSA");
        f32674h.add(X9ObjectIdentifiers.f22168i);
        f32674h.add(X9ObjectIdentifiers.f22172m);
        f32674h.add(X9ObjectIdentifiers.f22173n);
        f32674h.add(X9ObjectIdentifiers.f22174o);
        f32674h.add(X9ObjectIdentifiers.f22175p);
        f32674h.add(X9ObjectIdentifiers.f22155V);
        f32674h.add(NISTObjectIdentifiers.f21776L);
        f32674h.add(NISTObjectIdentifiers.f21777M);
        f32674h.add(CryptoProObjectIdentifiers.f21565k);
        f32674h.add(CryptoProObjectIdentifiers.f21566l);
        f32671e.put("SHA1WITHRSAANDMGF1", m43427a(new AlgorithmIdentifier(OIWObjectIdentifiers.f21830i, DERNull.f32850a), 20));
        f32671e.put("SHA224WITHRSAANDMGF1", m43427a(new AlgorithmIdentifier(NISTObjectIdentifiers.f21785f, DERNull.f32850a), 28));
        f32671e.put("SHA256WITHRSAANDMGF1", m43427a(new AlgorithmIdentifier(NISTObjectIdentifiers.f21782c, DERNull.f32850a), 32));
        f32671e.put("SHA384WITHRSAANDMGF1", m43427a(new AlgorithmIdentifier(NISTObjectIdentifiers.f21783d, DERNull.f32850a), 48));
        f32671e.put("SHA512WITHRSAANDMGF1", m43427a(new AlgorithmIdentifier(NISTObjectIdentifiers.f21784e, DERNull.f32850a), 64));
    }

    /* renamed from: a */
    private static RSASSAPSSparams m43427a(AlgorithmIdentifier algorithmIdentifier, int i) {
        return new RSASSAPSSparams(algorithmIdentifier, new AlgorithmIdentifier(PKCSObjectIdentifiers.l_, algorithmIdentifier), new ASN1Integer((long) i), new ASN1Integer(1));
    }

    /* renamed from: f */
    public byte[] mo6822f() {
        try {
            return m34596a("DER");
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }
}
