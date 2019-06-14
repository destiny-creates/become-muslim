package org.spongycastle.x509;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSASSAPSSparams;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;

class X509Util {
    /* renamed from: a */
    private static Hashtable f23489a = new Hashtable();
    /* renamed from: b */
    private static Hashtable f23490b = new Hashtable();
    /* renamed from: c */
    private static Set f23491c = new HashSet();

    static class Implementation {
    }

    X509Util() {
    }

    static {
        f23489a.put("MD2WITHRSAENCRYPTION", PKCSObjectIdentifiers.i_);
        f23489a.put("MD2WITHRSA", PKCSObjectIdentifiers.i_);
        f23489a.put("MD5WITHRSAENCRYPTION", PKCSObjectIdentifiers.f21861e);
        f23489a.put("MD5WITHRSA", PKCSObjectIdentifiers.f21861e);
        f23489a.put("SHA1WITHRSAENCRYPTION", PKCSObjectIdentifiers.j_);
        f23489a.put("SHA1WITHRSA", PKCSObjectIdentifiers.j_);
        f23489a.put("SHA224WITHRSAENCRYPTION", PKCSObjectIdentifiers.p_);
        f23489a.put("SHA224WITHRSA", PKCSObjectIdentifiers.p_);
        f23489a.put("SHA256WITHRSAENCRYPTION", PKCSObjectIdentifiers.m_);
        f23489a.put("SHA256WITHRSA", PKCSObjectIdentifiers.m_);
        f23489a.put("SHA384WITHRSAENCRYPTION", PKCSObjectIdentifiers.n_);
        f23489a.put("SHA384WITHRSA", PKCSObjectIdentifiers.n_);
        f23489a.put("SHA512WITHRSAENCRYPTION", PKCSObjectIdentifiers.o_);
        f23489a.put("SHA512WITHRSA", PKCSObjectIdentifiers.o_);
        f23489a.put("SHA1WITHRSAANDMGF1", PKCSObjectIdentifiers.f21864k);
        f23489a.put("SHA224WITHRSAANDMGF1", PKCSObjectIdentifiers.f21864k);
        f23489a.put("SHA256WITHRSAANDMGF1", PKCSObjectIdentifiers.f21864k);
        f23489a.put("SHA384WITHRSAANDMGF1", PKCSObjectIdentifiers.f21864k);
        f23489a.put("SHA512WITHRSAANDMGF1", PKCSObjectIdentifiers.f21864k);
        f23489a.put("RIPEMD160WITHRSAENCRYPTION", TeleTrusTObjectIdentifiers.f21986f);
        f23489a.put("RIPEMD160WITHRSA", TeleTrusTObjectIdentifiers.f21986f);
        f23489a.put("RIPEMD128WITHRSAENCRYPTION", TeleTrusTObjectIdentifiers.f21987g);
        f23489a.put("RIPEMD128WITHRSA", TeleTrusTObjectIdentifiers.f21987g);
        f23489a.put("RIPEMD256WITHRSAENCRYPTION", TeleTrusTObjectIdentifiers.f21988h);
        f23489a.put("RIPEMD256WITHRSA", TeleTrusTObjectIdentifiers.f21988h);
        f23489a.put("SHA1WITHDSA", X9ObjectIdentifiers.f22155V);
        f23489a.put("DSAWITHSHA1", X9ObjectIdentifiers.f22155V);
        f23489a.put("SHA224WITHDSA", NISTObjectIdentifiers.f21776L);
        f23489a.put("SHA256WITHDSA", NISTObjectIdentifiers.f21777M);
        f23489a.put("SHA384WITHDSA", NISTObjectIdentifiers.f21778N);
        f23489a.put("SHA512WITHDSA", NISTObjectIdentifiers.f21779O);
        f23489a.put("SHA1WITHECDSA", X9ObjectIdentifiers.f22168i);
        f23489a.put("ECDSAWITHSHA1", X9ObjectIdentifiers.f22168i);
        f23489a.put("SHA224WITHECDSA", X9ObjectIdentifiers.f22172m);
        f23489a.put("SHA256WITHECDSA", X9ObjectIdentifiers.f22173n);
        f23489a.put("SHA384WITHECDSA", X9ObjectIdentifiers.f22174o);
        f23489a.put("SHA512WITHECDSA", X9ObjectIdentifiers.f22175p);
        f23489a.put("GOST3411WITHGOST3410", CryptoProObjectIdentifiers.f21565k);
        f23489a.put("GOST3411WITHGOST3410-94", CryptoProObjectIdentifiers.f21565k);
        f23489a.put("GOST3411WITHECGOST3410", CryptoProObjectIdentifiers.f21566l);
        f23489a.put("GOST3411WITHECGOST3410-2001", CryptoProObjectIdentifiers.f21566l);
        f23489a.put("GOST3411WITHGOST3410-2001", CryptoProObjectIdentifiers.f21566l);
        f23491c.add(X9ObjectIdentifiers.f22168i);
        f23491c.add(X9ObjectIdentifiers.f22172m);
        f23491c.add(X9ObjectIdentifiers.f22173n);
        f23491c.add(X9ObjectIdentifiers.f22174o);
        f23491c.add(X9ObjectIdentifiers.f22175p);
        f23491c.add(X9ObjectIdentifiers.f22155V);
        f23491c.add(NISTObjectIdentifiers.f21776L);
        f23491c.add(NISTObjectIdentifiers.f21777M);
        f23491c.add(NISTObjectIdentifiers.f21778N);
        f23491c.add(NISTObjectIdentifiers.f21779O);
        f23491c.add(CryptoProObjectIdentifiers.f21565k);
        f23491c.add(CryptoProObjectIdentifiers.f21566l);
        f23490b.put("SHA1WITHRSAANDMGF1", m29474a(new AlgorithmIdentifier(OIWObjectIdentifiers.f21830i, DERNull.f32850a), 20));
        f23490b.put("SHA224WITHRSAANDMGF1", m29474a(new AlgorithmIdentifier(NISTObjectIdentifiers.f21785f, DERNull.f32850a), 28));
        f23490b.put("SHA256WITHRSAANDMGF1", m29474a(new AlgorithmIdentifier(NISTObjectIdentifiers.f21782c, DERNull.f32850a), 32));
        f23490b.put("SHA384WITHRSAANDMGF1", m29474a(new AlgorithmIdentifier(NISTObjectIdentifiers.f21783d, DERNull.f32850a), 48));
        f23490b.put("SHA512WITHRSAANDMGF1", m29474a(new AlgorithmIdentifier(NISTObjectIdentifiers.f21784e, DERNull.f32850a), 64));
    }

    /* renamed from: a */
    private static RSASSAPSSparams m29474a(AlgorithmIdentifier algorithmIdentifier, int i) {
        return new RSASSAPSSparams(algorithmIdentifier, new AlgorithmIdentifier(PKCSObjectIdentifiers.l_, algorithmIdentifier), new ASN1Integer((long) i), new ASN1Integer(1));
    }
}
