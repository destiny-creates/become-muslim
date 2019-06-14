package org.spongycastle.asn1.x500.style;

import com.facebook.appevents.UserDataStore;
import com.raizlabs.android.dbflow.config.C5679e;
import host.exp.exponent.p339f.C6352l;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.X500NameStyle;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;

public class BCStyle extends AbstractX500NameStyle {
    /* renamed from: A */
    public static final ASN1ObjectIdentifier f31124A = new ASN1ObjectIdentifier("2.5.4.16").m42988c();
    /* renamed from: B */
    public static final ASN1ObjectIdentifier f31125B = new ASN1ObjectIdentifier("2.5.4.54").m42988c();
    /* renamed from: C */
    public static final ASN1ObjectIdentifier f31126C = X509ObjectIdentifiers.f22086g;
    /* renamed from: D */
    public static final ASN1ObjectIdentifier f31127D = X509ObjectIdentifiers.c_;
    /* renamed from: E */
    public static final ASN1ObjectIdentifier f31128E = PKCSObjectIdentifiers.f21855V;
    /* renamed from: F */
    public static final ASN1ObjectIdentifier f31129F = PKCSObjectIdentifiers.f21856W;
    /* renamed from: G */
    public static final ASN1ObjectIdentifier f31130G = PKCSObjectIdentifiers.ac;
    /* renamed from: H */
    public static final ASN1ObjectIdentifier f31131H = f31128E;
    /* renamed from: I */
    public static final ASN1ObjectIdentifier f31132I = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
    /* renamed from: J */
    public static final ASN1ObjectIdentifier f31133J = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
    /* renamed from: K */
    public static final X500NameStyle f31134K = new BCStyle();
    /* renamed from: N */
    private static final Hashtable f31135N = new Hashtable();
    /* renamed from: a */
    private static final Hashtable f31136a = new Hashtable();
    /* renamed from: b */
    public static final ASN1ObjectIdentifier f31137b = new ASN1ObjectIdentifier("2.5.4.6").m42988c();
    /* renamed from: c */
    public static final ASN1ObjectIdentifier f31138c = new ASN1ObjectIdentifier("2.5.4.10").m42988c();
    /* renamed from: d */
    public static final ASN1ObjectIdentifier f31139d = new ASN1ObjectIdentifier("2.5.4.11").m42988c();
    /* renamed from: e */
    public static final ASN1ObjectIdentifier f31140e = new ASN1ObjectIdentifier("2.5.4.12").m42988c();
    /* renamed from: f */
    public static final ASN1ObjectIdentifier f31141f = new ASN1ObjectIdentifier("2.5.4.3").m42988c();
    /* renamed from: g */
    public static final ASN1ObjectIdentifier f31142g = new ASN1ObjectIdentifier("2.5.4.5").m42988c();
    /* renamed from: h */
    public static final ASN1ObjectIdentifier f31143h = new ASN1ObjectIdentifier("2.5.4.9").m42988c();
    /* renamed from: i */
    public static final ASN1ObjectIdentifier f31144i = f31142g;
    /* renamed from: j */
    public static final ASN1ObjectIdentifier f31145j = new ASN1ObjectIdentifier("2.5.4.7").m42988c();
    /* renamed from: k */
    public static final ASN1ObjectIdentifier f31146k = new ASN1ObjectIdentifier("2.5.4.8").m42988c();
    /* renamed from: l */
    public static final ASN1ObjectIdentifier f31147l = new ASN1ObjectIdentifier("2.5.4.4").m42988c();
    /* renamed from: m */
    public static final ASN1ObjectIdentifier f31148m = new ASN1ObjectIdentifier("2.5.4.42").m42988c();
    /* renamed from: n */
    public static final ASN1ObjectIdentifier f31149n = new ASN1ObjectIdentifier("2.5.4.43").m42988c();
    /* renamed from: o */
    public static final ASN1ObjectIdentifier f31150o = new ASN1ObjectIdentifier("2.5.4.44").m42988c();
    /* renamed from: p */
    public static final ASN1ObjectIdentifier f31151p = new ASN1ObjectIdentifier("2.5.4.45").m42988c();
    /* renamed from: q */
    public static final ASN1ObjectIdentifier f31152q = new ASN1ObjectIdentifier("2.5.4.15").m42988c();
    /* renamed from: r */
    public static final ASN1ObjectIdentifier f31153r = new ASN1ObjectIdentifier("2.5.4.17").m42988c();
    /* renamed from: s */
    public static final ASN1ObjectIdentifier f31154s = new ASN1ObjectIdentifier("2.5.4.46").m42988c();
    /* renamed from: t */
    public static final ASN1ObjectIdentifier f31155t = new ASN1ObjectIdentifier("2.5.4.65").m42988c();
    /* renamed from: u */
    public static final ASN1ObjectIdentifier f31156u = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.1").m42988c();
    /* renamed from: v */
    public static final ASN1ObjectIdentifier f31157v = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.2").m42988c();
    /* renamed from: w */
    public static final ASN1ObjectIdentifier f31158w = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.3").m42988c();
    /* renamed from: x */
    public static final ASN1ObjectIdentifier f31159x = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.4").m42988c();
    /* renamed from: y */
    public static final ASN1ObjectIdentifier f31160y = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.5").m42988c();
    /* renamed from: z */
    public static final ASN1ObjectIdentifier f31161z = new ASN1ObjectIdentifier("1.3.36.8.3.14").m42988c();
    /* renamed from: L */
    protected final Hashtable f31162L = AbstractX500NameStyle.m34661a(f31135N);
    /* renamed from: M */
    protected final Hashtable f31163M = AbstractX500NameStyle.m34661a(f31136a);

    static {
        f31136a.put(f31137b, "C");
        f31136a.put(f31138c, "O");
        f31136a.put(f31140e, "T");
        f31136a.put(f31139d, "OU");
        f31136a.put(f31141f, "CN");
        f31136a.put(f31145j, "L");
        f31136a.put(f31146k, "ST");
        f31136a.put(f31142g, "SERIALNUMBER");
        f31136a.put(f31128E, "E");
        f31136a.put(f31132I, "DC");
        f31136a.put(f31133J, "UID");
        f31136a.put(f31143h, "STREET");
        f31136a.put(f31147l, "SURNAME");
        f31136a.put(f31148m, "GIVENNAME");
        f31136a.put(f31149n, "INITIALS");
        f31136a.put(f31150o, "GENERATION");
        f31136a.put(f31130G, "unstructuredAddress");
        f31136a.put(f31129F, "unstructuredName");
        f31136a.put(f31151p, "UniqueIdentifier");
        f31136a.put(f31154s, "DN");
        f31136a.put(f31155t, "Pseudonym");
        f31136a.put(f31124A, "PostalAddress");
        f31136a.put(f31161z, "NameAtBirth");
        f31136a.put(f31159x, "CountryOfCitizenship");
        f31136a.put(f31160y, "CountryOfResidence");
        f31136a.put(f31158w, "Gender");
        f31136a.put(f31157v, "PlaceOfBirth");
        f31136a.put(f31156u, "DateOfBirth");
        f31136a.put(f31153r, "PostalCode");
        f31136a.put(f31152q, "BusinessCategory");
        f31136a.put(f31126C, "TelephoneNumber");
        f31136a.put(f31127D, "Name");
        f31135N.put("c", f31137b);
        f31135N.put("o", f31138c);
        f31135N.put("t", f31140e);
        f31135N.put("ou", f31139d);
        f31135N.put("cn", f31141f);
        f31135N.put(C6352l.f20613a, f31145j);
        f31135N.put(UserDataStore.STATE, f31146k);
        f31135N.put("sn", f31142g);
        f31135N.put("serialnumber", f31142g);
        f31135N.put("street", f31143h);
        f31135N.put("emailaddress", f31131H);
        f31135N.put("dc", f31132I);
        f31135N.put(C5679e.f18978a, f31131H);
        f31135N.put("uid", f31133J);
        f31135N.put("surname", f31147l);
        f31135N.put("givenname", f31148m);
        f31135N.put("initials", f31149n);
        f31135N.put("generation", f31150o);
        f31135N.put("unstructuredaddress", f31130G);
        f31135N.put("unstructuredname", f31129F);
        f31135N.put("uniqueidentifier", f31151p);
        f31135N.put("dn", f31154s);
        f31135N.put("pseudonym", f31155t);
        f31135N.put("postaladdress", f31124A);
        f31135N.put("nameofbirth", f31161z);
        f31135N.put("countryofcitizenship", f31159x);
        f31135N.put("countryofresidence", f31160y);
        f31135N.put("gender", f31158w);
        f31135N.put("placeofbirth", f31157v);
        f31135N.put("dateofbirth", f31156u);
        f31135N.put("postalcode", f31153r);
        f31135N.put("businesscategory", f31152q);
        f31135N.put("telephonenumber", f31126C);
        f31135N.put("name", f31127D);
    }

    protected BCStyle() {
    }

    /* renamed from: b */
    protected ASN1Encodable mo6443b(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (!aSN1ObjectIdentifier.equals(f31128E)) {
            if (!aSN1ObjectIdentifier.equals(f31132I)) {
                if (aSN1ObjectIdentifier.equals(f31156u)) {
                    return new ASN1GeneralizedTime(str);
                }
                if (!(aSN1ObjectIdentifier.equals(f31137b) || aSN1ObjectIdentifier.equals(f31142g) || aSN1ObjectIdentifier.equals(f31154s))) {
                    if (!aSN1ObjectIdentifier.equals(f31126C)) {
                        return super.mo6443b(aSN1ObjectIdentifier, str);
                    }
                }
                return new DERPrintableString(str);
            }
        }
        return new DERIA5String(str);
    }

    /* renamed from: a */
    public ASN1ObjectIdentifier mo6441a(String str) {
        return IETFUtils.m27239a(str, this.f31162L);
    }

    /* renamed from: b */
    public RDN[] mo6444b(String str) {
        return IETFUtils.m27246a(str, (X500NameStyle) this);
    }

    /* renamed from: b */
    public String mo6442b(X500Name x500Name) {
        StringBuffer stringBuffer = new StringBuffer();
        x500Name = x500Name.m40215a();
        Object obj = 1;
        for (RDN a : x500Name) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuffer.append(',');
            }
            IETFUtils.m27241a(stringBuffer, a, this.f31163M);
        }
        return stringBuffer.toString();
    }
}
