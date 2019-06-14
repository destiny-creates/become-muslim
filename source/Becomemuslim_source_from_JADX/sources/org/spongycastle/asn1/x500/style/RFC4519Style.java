package org.spongycastle.asn1.x500.style;

import com.facebook.appevents.UserDataStore;
import host.exp.exponent.p339f.C6352l;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.X500NameStyle;

public class RFC4519Style extends AbstractX500NameStyle {
    /* renamed from: A */
    public static final ASN1ObjectIdentifier f31164A = new ASN1ObjectIdentifier("2.5.4.26").m42988c();
    /* renamed from: B */
    public static final ASN1ObjectIdentifier f31165B = new ASN1ObjectIdentifier("2.5.4.33").m42988c();
    /* renamed from: C */
    public static final ASN1ObjectIdentifier f31166C = new ASN1ObjectIdentifier("2.5.4.14").m42988c();
    /* renamed from: D */
    public static final ASN1ObjectIdentifier f31167D = new ASN1ObjectIdentifier("2.5.4.34").m42988c();
    /* renamed from: E */
    public static final ASN1ObjectIdentifier f31168E = new ASN1ObjectIdentifier("2.5.4.5").m42988c();
    /* renamed from: F */
    public static final ASN1ObjectIdentifier f31169F = new ASN1ObjectIdentifier("2.5.4.4").m42988c();
    /* renamed from: G */
    public static final ASN1ObjectIdentifier f31170G = new ASN1ObjectIdentifier("2.5.4.8").m42988c();
    /* renamed from: H */
    public static final ASN1ObjectIdentifier f31171H = new ASN1ObjectIdentifier("2.5.4.9").m42988c();
    /* renamed from: I */
    public static final ASN1ObjectIdentifier f31172I = new ASN1ObjectIdentifier("2.5.4.20").m42988c();
    /* renamed from: J */
    public static final ASN1ObjectIdentifier f31173J = new ASN1ObjectIdentifier("2.5.4.22").m42988c();
    /* renamed from: K */
    public static final ASN1ObjectIdentifier f31174K = new ASN1ObjectIdentifier("2.5.4.21").m42988c();
    /* renamed from: L */
    public static final ASN1ObjectIdentifier f31175L = new ASN1ObjectIdentifier("2.5.4.12").m42988c();
    /* renamed from: M */
    public static final ASN1ObjectIdentifier f31176M = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1").m42988c();
    /* renamed from: N */
    public static final ASN1ObjectIdentifier f31177N = new ASN1ObjectIdentifier("2.5.4.50").m42988c();
    /* renamed from: O */
    public static final ASN1ObjectIdentifier f31178O = new ASN1ObjectIdentifier("2.5.4.35").m42988c();
    /* renamed from: P */
    public static final ASN1ObjectIdentifier f31179P = new ASN1ObjectIdentifier("2.5.4.24").m42988c();
    /* renamed from: Q */
    public static final ASN1ObjectIdentifier f31180Q = new ASN1ObjectIdentifier("2.5.4.45").m42988c();
    /* renamed from: R */
    public static final X500NameStyle f31181R = new RFC4519Style();
    /* renamed from: U */
    private static final Hashtable f31182U = new Hashtable();
    /* renamed from: V */
    private static final Hashtable f31183V = new Hashtable();
    /* renamed from: a */
    public static final ASN1ObjectIdentifier f31184a = new ASN1ObjectIdentifier("2.5.4.15").m42988c();
    /* renamed from: b */
    public static final ASN1ObjectIdentifier f31185b = new ASN1ObjectIdentifier("2.5.4.6").m42988c();
    /* renamed from: c */
    public static final ASN1ObjectIdentifier f31186c = new ASN1ObjectIdentifier("2.5.4.3").m42988c();
    /* renamed from: d */
    public static final ASN1ObjectIdentifier f31187d = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25").m42988c();
    /* renamed from: e */
    public static final ASN1ObjectIdentifier f31188e = new ASN1ObjectIdentifier("2.5.4.13").m42988c();
    /* renamed from: f */
    public static final ASN1ObjectIdentifier f31189f = new ASN1ObjectIdentifier("2.5.4.27").m42988c();
    /* renamed from: g */
    public static final ASN1ObjectIdentifier f31190g = new ASN1ObjectIdentifier("2.5.4.49").m42988c();
    /* renamed from: h */
    public static final ASN1ObjectIdentifier f31191h = new ASN1ObjectIdentifier("2.5.4.46").m42988c();
    /* renamed from: i */
    public static final ASN1ObjectIdentifier f31192i = new ASN1ObjectIdentifier("2.5.4.47").m42988c();
    /* renamed from: j */
    public static final ASN1ObjectIdentifier f31193j = new ASN1ObjectIdentifier("2.5.4.23").m42988c();
    /* renamed from: k */
    public static final ASN1ObjectIdentifier f31194k = new ASN1ObjectIdentifier("2.5.4.44").m42988c();
    /* renamed from: l */
    public static final ASN1ObjectIdentifier f31195l = new ASN1ObjectIdentifier("2.5.4.42").m42988c();
    /* renamed from: m */
    public static final ASN1ObjectIdentifier f31196m = new ASN1ObjectIdentifier("2.5.4.51").m42988c();
    /* renamed from: n */
    public static final ASN1ObjectIdentifier f31197n = new ASN1ObjectIdentifier("2.5.4.43").m42988c();
    /* renamed from: o */
    public static final ASN1ObjectIdentifier f31198o = new ASN1ObjectIdentifier("2.5.4.25").m42988c();
    /* renamed from: p */
    public static final ASN1ObjectIdentifier f31199p = new ASN1ObjectIdentifier("2.5.4.7").m42988c();
    /* renamed from: q */
    public static final ASN1ObjectIdentifier f31200q = new ASN1ObjectIdentifier("2.5.4.31").m42988c();
    /* renamed from: r */
    public static final ASN1ObjectIdentifier f31201r = new ASN1ObjectIdentifier("2.5.4.41").m42988c();
    /* renamed from: s */
    public static final ASN1ObjectIdentifier f31202s = new ASN1ObjectIdentifier("2.5.4.10").m42988c();
    /* renamed from: t */
    public static final ASN1ObjectIdentifier f31203t = new ASN1ObjectIdentifier("2.5.4.11").m42988c();
    /* renamed from: u */
    public static final ASN1ObjectIdentifier f31204u = new ASN1ObjectIdentifier("2.5.4.32").m42988c();
    /* renamed from: v */
    public static final ASN1ObjectIdentifier f31205v = new ASN1ObjectIdentifier("2.5.4.19").m42988c();
    /* renamed from: w */
    public static final ASN1ObjectIdentifier f31206w = new ASN1ObjectIdentifier("2.5.4.16").m42988c();
    /* renamed from: x */
    public static final ASN1ObjectIdentifier f31207x = new ASN1ObjectIdentifier("2.5.4.17").m42988c();
    /* renamed from: y */
    public static final ASN1ObjectIdentifier f31208y = new ASN1ObjectIdentifier("2.5.4.18").m42988c();
    /* renamed from: z */
    public static final ASN1ObjectIdentifier f31209z = new ASN1ObjectIdentifier("2.5.4.28").m42988c();
    /* renamed from: S */
    protected final Hashtable f31210S = AbstractX500NameStyle.m34661a(f31183V);
    /* renamed from: T */
    protected final Hashtable f31211T = AbstractX500NameStyle.m34661a(f31182U);

    static {
        f31182U.put(f31184a, "businessCategory");
        f31182U.put(f31185b, "c");
        f31182U.put(f31186c, "cn");
        f31182U.put(f31187d, "dc");
        f31182U.put(f31188e, "description");
        f31182U.put(f31189f, "destinationIndicator");
        f31182U.put(f31190g, "distinguishedName");
        f31182U.put(f31191h, "dnQualifier");
        f31182U.put(f31192i, "enhancedSearchGuide");
        f31182U.put(f31193j, "facsimileTelephoneNumber");
        f31182U.put(f31194k, "generationQualifier");
        f31182U.put(f31195l, "givenName");
        f31182U.put(f31196m, "houseIdentifier");
        f31182U.put(f31197n, "initials");
        f31182U.put(f31198o, "internationalISDNNumber");
        f31182U.put(f31199p, C6352l.f20613a);
        f31182U.put(f31200q, "member");
        f31182U.put(f31201r, "name");
        f31182U.put(f31202s, "o");
        f31182U.put(f31203t, "ou");
        f31182U.put(f31204u, "owner");
        f31182U.put(f31205v, "physicalDeliveryOfficeName");
        f31182U.put(f31206w, "postalAddress");
        f31182U.put(f31207x, "postalCode");
        f31182U.put(f31208y, "postOfficeBox");
        f31182U.put(f31209z, "preferredDeliveryMethod");
        f31182U.put(f31164A, "registeredAddress");
        f31182U.put(f31165B, "roleOccupant");
        f31182U.put(f31166C, "searchGuide");
        f31182U.put(f31167D, "seeAlso");
        f31182U.put(f31168E, "serialNumber");
        f31182U.put(f31169F, "sn");
        f31182U.put(f31170G, UserDataStore.STATE);
        f31182U.put(f31171H, "street");
        f31182U.put(f31172I, "telephoneNumber");
        f31182U.put(f31173J, "teletexTerminalIdentifier");
        f31182U.put(f31174K, "telexNumber");
        f31182U.put(f31175L, "title");
        f31182U.put(f31176M, "uid");
        f31182U.put(f31177N, "uniqueMember");
        f31182U.put(f31178O, "userPassword");
        f31182U.put(f31179P, "x121Address");
        f31182U.put(f31180Q, "x500UniqueIdentifier");
        f31183V.put("businesscategory", f31184a);
        f31183V.put("c", f31185b);
        f31183V.put("cn", f31186c);
        f31183V.put("dc", f31187d);
        f31183V.put("description", f31188e);
        f31183V.put("destinationindicator", f31189f);
        f31183V.put("distinguishedname", f31190g);
        f31183V.put("dnqualifier", f31191h);
        f31183V.put("enhancedsearchguide", f31192i);
        f31183V.put("facsimiletelephonenumber", f31193j);
        f31183V.put("generationqualifier", f31194k);
        f31183V.put("givenname", f31195l);
        f31183V.put("houseidentifier", f31196m);
        f31183V.put("initials", f31197n);
        f31183V.put("internationalisdnnumber", f31198o);
        f31183V.put(C6352l.f20613a, f31199p);
        f31183V.put("member", f31200q);
        f31183V.put("name", f31201r);
        f31183V.put("o", f31202s);
        f31183V.put("ou", f31203t);
        f31183V.put("owner", f31204u);
        f31183V.put("physicaldeliveryofficename", f31205v);
        f31183V.put("postaladdress", f31206w);
        f31183V.put("postalcode", f31207x);
        f31183V.put("postofficebox", f31208y);
        f31183V.put("preferreddeliverymethod", f31209z);
        f31183V.put("registeredaddress", f31164A);
        f31183V.put("roleoccupant", f31165B);
        f31183V.put("searchguide", f31166C);
        f31183V.put("seealso", f31167D);
        f31183V.put("serialnumber", f31168E);
        f31183V.put("sn", f31169F);
        f31183V.put(UserDataStore.STATE, f31170G);
        f31183V.put("street", f31171H);
        f31183V.put("telephonenumber", f31172I);
        f31183V.put("teletexterminalidentifier", f31173J);
        f31183V.put("telexnumber", f31174K);
        f31183V.put("title", f31175L);
        f31183V.put("uid", f31176M);
        f31183V.put("uniquemember", f31177N);
        f31183V.put("userpassword", f31178O);
        f31183V.put("x121address", f31179P);
        f31183V.put("x500uniqueidentifier", f31180Q);
    }

    protected RFC4519Style() {
    }

    /* renamed from: b */
    protected ASN1Encodable mo6443b(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (aSN1ObjectIdentifier.equals(f31187d)) {
            return new DERIA5String(str);
        }
        if (!(aSN1ObjectIdentifier.equals(f31185b) || aSN1ObjectIdentifier.equals(f31168E) || aSN1ObjectIdentifier.equals(f31191h))) {
            if (!aSN1ObjectIdentifier.equals(f31172I)) {
                return super.mo6443b(aSN1ObjectIdentifier, str);
            }
        }
        return new DERPrintableString(str);
    }

    /* renamed from: a */
    public ASN1ObjectIdentifier mo6441a(String str) {
        return IETFUtils.m27239a(str, this.f31210S);
    }

    /* renamed from: b */
    public RDN[] mo6444b(String str) {
        str = IETFUtils.m27246a(str, (X500NameStyle) this);
        RDN[] rdnArr = new RDN[str.length];
        for (int i = 0; i != str.length; i++) {
            rdnArr[(rdnArr.length - i) - 1] = str[i];
        }
        return rdnArr;
    }

    /* renamed from: b */
    public String mo6442b(X500Name x500Name) {
        StringBuffer stringBuffer = new StringBuffer();
        x500Name = x500Name.m40215a();
        int i = 1;
        for (int length = x500Name.length - 1; length >= 0; length--) {
            if (i != 0) {
                i = 0;
            } else {
                stringBuffer.append(',');
            }
            IETFUtils.m27241a(stringBuffer, x500Name[length], this.f31211T);
        }
        return stringBuffer.toString();
    }
}
