package org.spongycastle.asn1.x509;

import com.facebook.appevents.UserDataStore;
import com.facebook.imageutils.JfifUtil;
import com.raizlabs.android.dbflow.config.C5679e;
import host.exp.exponent.p339f.C6352l;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

public class X509Name extends ASN1Object {
    /* renamed from: A */
    public static final ASN1ObjectIdentifier f31444A = new ASN1ObjectIdentifier("2.5.4.54");
    /* renamed from: B */
    public static final ASN1ObjectIdentifier f31445B = X509ObjectIdentifiers.f22086g;
    /* renamed from: C */
    public static final ASN1ObjectIdentifier f31446C = X509ObjectIdentifiers.c_;
    /* renamed from: D */
    public static final ASN1ObjectIdentifier f31447D = PKCSObjectIdentifiers.f21855V;
    /* renamed from: E */
    public static final ASN1ObjectIdentifier f31448E = PKCSObjectIdentifiers.f21856W;
    /* renamed from: F */
    public static final ASN1ObjectIdentifier f31449F = PKCSObjectIdentifiers.ac;
    /* renamed from: G */
    public static final ASN1ObjectIdentifier f31450G = f31447D;
    /* renamed from: H */
    public static final ASN1ObjectIdentifier f31451H = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
    /* renamed from: I */
    public static final ASN1ObjectIdentifier f31452I = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
    /* renamed from: J */
    public static boolean f31453J = false;
    /* renamed from: K */
    public static final Hashtable f31454K = new Hashtable();
    /* renamed from: L */
    public static final Hashtable f31455L = new Hashtable();
    /* renamed from: M */
    public static final Hashtable f31456M = new Hashtable();
    /* renamed from: N */
    public static final Hashtable f31457N = new Hashtable();
    /* renamed from: O */
    public static final Hashtable f31458O = f31454K;
    /* renamed from: P */
    public static final Hashtable f31459P = f31457N;
    /* renamed from: Q */
    private static final Boolean f31460Q = new Boolean(true);
    /* renamed from: R */
    private static final Boolean f31461R = new Boolean(false);
    /* renamed from: a */
    public static final ASN1ObjectIdentifier f31462a = new ASN1ObjectIdentifier("2.5.4.6");
    /* renamed from: b */
    public static final ASN1ObjectIdentifier f31463b = new ASN1ObjectIdentifier("2.5.4.10");
    /* renamed from: c */
    public static final ASN1ObjectIdentifier f31464c = new ASN1ObjectIdentifier("2.5.4.11");
    /* renamed from: d */
    public static final ASN1ObjectIdentifier f31465d = new ASN1ObjectIdentifier("2.5.4.12");
    /* renamed from: e */
    public static final ASN1ObjectIdentifier f31466e = new ASN1ObjectIdentifier("2.5.4.3");
    /* renamed from: f */
    public static final ASN1ObjectIdentifier f31467f = new ASN1ObjectIdentifier("2.5.4.5");
    /* renamed from: g */
    public static final ASN1ObjectIdentifier f31468g = new ASN1ObjectIdentifier("2.5.4.9");
    /* renamed from: h */
    public static final ASN1ObjectIdentifier f31469h = f31467f;
    /* renamed from: i */
    public static final ASN1ObjectIdentifier f31470i = new ASN1ObjectIdentifier("2.5.4.7");
    /* renamed from: j */
    public static final ASN1ObjectIdentifier f31471j = new ASN1ObjectIdentifier("2.5.4.8");
    /* renamed from: k */
    public static final ASN1ObjectIdentifier f31472k = new ASN1ObjectIdentifier("2.5.4.4");
    /* renamed from: l */
    public static final ASN1ObjectIdentifier f31473l = new ASN1ObjectIdentifier("2.5.4.42");
    /* renamed from: m */
    public static final ASN1ObjectIdentifier f31474m = new ASN1ObjectIdentifier("2.5.4.43");
    /* renamed from: n */
    public static final ASN1ObjectIdentifier f31475n = new ASN1ObjectIdentifier("2.5.4.44");
    /* renamed from: o */
    public static final ASN1ObjectIdentifier f31476o = new ASN1ObjectIdentifier("2.5.4.45");
    /* renamed from: p */
    public static final ASN1ObjectIdentifier f31477p = new ASN1ObjectIdentifier("2.5.4.15");
    /* renamed from: q */
    public static final ASN1ObjectIdentifier f31478q = new ASN1ObjectIdentifier("2.5.4.17");
    /* renamed from: r */
    public static final ASN1ObjectIdentifier f31479r = new ASN1ObjectIdentifier("2.5.4.46");
    /* renamed from: s */
    public static final ASN1ObjectIdentifier f31480s = new ASN1ObjectIdentifier("2.5.4.65");
    /* renamed from: t */
    public static final ASN1ObjectIdentifier f31481t = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.1");
    /* renamed from: u */
    public static final ASN1ObjectIdentifier f31482u = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.2");
    /* renamed from: v */
    public static final ASN1ObjectIdentifier f31483v = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.3");
    /* renamed from: w */
    public static final ASN1ObjectIdentifier f31484w = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.4");
    /* renamed from: x */
    public static final ASN1ObjectIdentifier f31485x = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.5");
    /* renamed from: y */
    public static final ASN1ObjectIdentifier f31486y = new ASN1ObjectIdentifier("1.3.36.8.3.14");
    /* renamed from: z */
    public static final ASN1ObjectIdentifier f31487z = new ASN1ObjectIdentifier("2.5.4.16");
    /* renamed from: S */
    private X509NameEntryConverter f31488S = null;
    /* renamed from: T */
    private Vector f31489T = new Vector();
    /* renamed from: U */
    private Vector f31490U = new Vector();
    /* renamed from: V */
    private Vector f31491V = new Vector();
    /* renamed from: W */
    private ASN1Sequence f31492W;
    /* renamed from: X */
    private boolean f31493X;
    /* renamed from: Y */
    private int f31494Y;

    static {
        f31454K.put(f31462a, "C");
        f31454K.put(f31463b, "O");
        f31454K.put(f31465d, "T");
        f31454K.put(f31464c, "OU");
        f31454K.put(f31466e, "CN");
        f31454K.put(f31470i, "L");
        f31454K.put(f31471j, "ST");
        f31454K.put(f31467f, "SERIALNUMBER");
        f31454K.put(f31447D, "E");
        f31454K.put(f31451H, "DC");
        f31454K.put(f31452I, "UID");
        f31454K.put(f31468g, "STREET");
        f31454K.put(f31472k, "SURNAME");
        f31454K.put(f31473l, "GIVENNAME");
        f31454K.put(f31474m, "INITIALS");
        f31454K.put(f31475n, "GENERATION");
        f31454K.put(f31449F, "unstructuredAddress");
        f31454K.put(f31448E, "unstructuredName");
        f31454K.put(f31476o, "UniqueIdentifier");
        f31454K.put(f31479r, "DN");
        f31454K.put(f31480s, "Pseudonym");
        f31454K.put(f31487z, "PostalAddress");
        f31454K.put(f31486y, "NameAtBirth");
        f31454K.put(f31484w, "CountryOfCitizenship");
        f31454K.put(f31485x, "CountryOfResidence");
        f31454K.put(f31483v, "Gender");
        f31454K.put(f31482u, "PlaceOfBirth");
        f31454K.put(f31481t, "DateOfBirth");
        f31454K.put(f31478q, "PostalCode");
        f31454K.put(f31477p, "BusinessCategory");
        f31454K.put(f31445B, "TelephoneNumber");
        f31454K.put(f31446C, "Name");
        f31455L.put(f31462a, "C");
        f31455L.put(f31463b, "O");
        f31455L.put(f31464c, "OU");
        f31455L.put(f31466e, "CN");
        f31455L.put(f31470i, "L");
        f31455L.put(f31471j, "ST");
        f31455L.put(f31468g, "STREET");
        f31455L.put(f31451H, "DC");
        f31455L.put(f31452I, "UID");
        f31456M.put(f31462a, "C");
        f31456M.put(f31463b, "O");
        f31456M.put(f31464c, "OU");
        f31456M.put(f31466e, "CN");
        f31456M.put(f31470i, "L");
        f31456M.put(f31471j, "ST");
        f31456M.put(f31468g, "STREET");
        f31457N.put("c", f31462a);
        f31457N.put("o", f31463b);
        f31457N.put("t", f31465d);
        f31457N.put("ou", f31464c);
        f31457N.put("cn", f31466e);
        f31457N.put(C6352l.f20613a, f31470i);
        f31457N.put(UserDataStore.STATE, f31471j);
        f31457N.put("sn", f31467f);
        f31457N.put("serialnumber", f31467f);
        f31457N.put("street", f31468g);
        f31457N.put("emailaddress", f31450G);
        f31457N.put("dc", f31451H);
        f31457N.put(C5679e.f18978a, f31450G);
        f31457N.put("uid", f31452I);
        f31457N.put("surname", f31472k);
        f31457N.put("givenname", f31473l);
        f31457N.put("initials", f31474m);
        f31457N.put("generation", f31475n);
        f31457N.put("unstructuredaddress", f31449F);
        f31457N.put("unstructuredname", f31448E);
        f31457N.put("uniqueidentifier", f31476o);
        f31457N.put("dn", f31479r);
        f31457N.put("pseudonym", f31480s);
        f31457N.put("postaladdress", f31487z);
        f31457N.put("nameofbirth", f31486y);
        f31457N.put("countryofcitizenship", f31484w);
        f31457N.put("countryofresidence", f31485x);
        f31457N.put("gender", f31483v);
        f31457N.put("placeofbirth", f31482u);
        f31457N.put("dateofbirth", f31481t);
        f31457N.put("postalcode", f31478q);
        f31457N.put("businesscategory", f31477p);
        f31457N.put("telephonenumber", f31445B);
        f31457N.put("name", f31446C);
    }

    /* renamed from: a */
    public static X509Name m40471a(Object obj) {
        if (obj != null) {
            if (!(obj instanceof X509Name)) {
                if (obj instanceof X500Name) {
                    return new X509Name(ASN1Sequence.m43000a(((X500Name) obj).mo5709e()));
                }
                return obj != null ? new X509Name(ASN1Sequence.m43000a(obj)) : null;
            }
        }
        return (X509Name) obj;
    }

    protected X509Name() {
    }

    public X509Name(org.spongycastle.asn1.ASN1Sequence r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r7.<init>();
        r0 = 0;
        r7.f31488S = r0;
        r0 = new java.util.Vector;
        r0.<init>();
        r7.f31489T = r0;
        r0 = new java.util.Vector;
        r0.<init>();
        r7.f31490U = r0;
        r0 = new java.util.Vector;
        r0.<init>();
        r7.f31491V = r0;
        r7.f31492W = r8;
        r8 = r8.mo6861c();
    L_0x0021:
        r0 = r8.hasMoreElements();
        if (r0 == 0) goto L_0x00e3;
    L_0x0027:
        r0 = r8.nextElement();
        r0 = (org.spongycastle.asn1.ASN1Encodable) r0;
        r0 = r0.mo5709e();
        r0 = org.spongycastle.asn1.ASN1Set.m43012a(r0);
        r1 = 0;
        r2 = 0;
    L_0x0037:
        r3 = r0.m43021c();
        if (r2 >= r3) goto L_0x0021;
    L_0x003d:
        r3 = r0.m43016a(r2);
        r3 = r3.mo5709e();
        r3 = org.spongycastle.asn1.ASN1Sequence.m43000a(r3);
        r4 = r3.mo6862g();
        r5 = 2;
        if (r4 != r5) goto L_0x00db;
    L_0x0050:
        r4 = r7.f31489T;
        r5 = r3.mo6860a(r1);
        r5 = org.spongycastle.asn1.ASN1ObjectIdentifier.m42973a(r5);
        r4.addElement(r5);
        r4 = 1;
        r3 = r3.mo6860a(r4);
        r4 = r3 instanceof org.spongycastle.asn1.ASN1String;
        if (r4 == 0) goto L_0x009b;
    L_0x0066:
        r4 = r3 instanceof org.spongycastle.asn1.DERUniversalString;
        if (r4 != 0) goto L_0x009b;
    L_0x006a:
        r3 = (org.spongycastle.asn1.ASN1String) r3;
        r3 = r3.mo6440b();
        r4 = r3.length();
        if (r4 <= 0) goto L_0x0095;
    L_0x0076:
        r4 = r3.charAt(r1);
        r5 = 35;
        if (r4 != r5) goto L_0x0095;
    L_0x007e:
        r4 = r7.f31490U;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "\\";
        r5.append(r6);
        r5.append(r3);
        r3 = r5.toString();
        r4.addElement(r3);
        goto L_0x00c3;
    L_0x0095:
        r4 = r7.f31490U;
        r4.addElement(r3);
        goto L_0x00c3;
    L_0x009b:
        r4 = r7.f31490U;	 Catch:{ IOException -> 0x00d3 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00d3 }
        r5.<init>();	 Catch:{ IOException -> 0x00d3 }
        r6 = "#";	 Catch:{ IOException -> 0x00d3 }
        r5.append(r6);	 Catch:{ IOException -> 0x00d3 }
        r3 = r3.mo5709e();	 Catch:{ IOException -> 0x00d3 }
        r6 = "DER";	 Catch:{ IOException -> 0x00d3 }
        r3 = r3.m34596a(r6);	 Catch:{ IOException -> 0x00d3 }
        r3 = org.spongycastle.util.encoders.Hex.m29437a(r3);	 Catch:{ IOException -> 0x00d3 }
        r3 = r7.m40470a(r3);	 Catch:{ IOException -> 0x00d3 }
        r5.append(r3);	 Catch:{ IOException -> 0x00d3 }
        r3 = r5.toString();	 Catch:{ IOException -> 0x00d3 }
        r4.addElement(r3);	 Catch:{ IOException -> 0x00d3 }
    L_0x00c3:
        r3 = r7.f31491V;
        if (r2 == 0) goto L_0x00ca;
    L_0x00c7:
        r4 = f31460Q;
        goto L_0x00cc;
    L_0x00ca:
        r4 = f31461R;
    L_0x00cc:
        r3.addElement(r4);
        r2 = r2 + 1;
        goto L_0x0037;
    L_0x00d3:
        r8 = new java.lang.IllegalArgumentException;
        r0 = "cannot encode value";
        r8.<init>(r0);
        throw r8;
    L_0x00db:
        r8 = new java.lang.IllegalArgumentException;
        r0 = "badly sized pair";
        r8.<init>(r0);
        throw r8;
    L_0x00e3:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x509.X509Name.<init>(org.spongycastle.asn1.ASN1Sequence):void");
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        if (this.f31492W == null) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            ASN1ObjectIdentifier aSN1ObjectIdentifier = null;
            int i = 0;
            while (i != this.f31489T.size()) {
                ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
                ASN1ObjectIdentifier aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) this.f31489T.elementAt(i);
                aSN1EncodableVector3.m27141a((ASN1Encodable) aSN1ObjectIdentifier2);
                aSN1EncodableVector3.m27141a(this.f31488S.mo5720a(aSN1ObjectIdentifier2, (String) this.f31490U.elementAt(i)));
                if (aSN1ObjectIdentifier != null) {
                    if (!((Boolean) this.f31491V.elementAt(i)).booleanValue()) {
                        aSN1EncodableVector.m27141a(new DERSet(aSN1EncodableVector2));
                        aSN1EncodableVector2 = new ASN1EncodableVector();
                        aSN1EncodableVector2.m27141a(new DERSequence(aSN1EncodableVector3));
                        i++;
                        aSN1ObjectIdentifier = aSN1ObjectIdentifier2;
                    }
                }
                aSN1EncodableVector2.m27141a(new DERSequence(aSN1EncodableVector3));
                i++;
                aSN1ObjectIdentifier = aSN1ObjectIdentifier2;
            }
            aSN1EncodableVector.m27141a(new DERSet(aSN1EncodableVector2));
            this.f31492W = new DERSequence(aSN1EncodableVector);
        }
        return this.f31492W;
    }

    public int hashCode() {
        if (this.f31493X) {
            return this.f31494Y;
        }
        this.f31493X = true;
        for (int i = 0; i != this.f31489T.size(); i++) {
            String d = m40476d(m40474b((String) this.f31490U.elementAt(i)));
            this.f31494Y ^= this.f31489T.elementAt(i).hashCode();
            this.f31494Y = d.hashCode() ^ this.f31494Y;
        }
        return this.f31494Y;
    }

    public boolean equals(java.lang.Object r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = 1;
        if (r12 != r11) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r12 instanceof org.spongycastle.asn1.x509.X509Name;
        r2 = 0;
        if (r1 != 0) goto L_0x000e;
    L_0x0009:
        r1 = r12 instanceof org.spongycastle.asn1.ASN1Sequence;
        if (r1 != 0) goto L_0x000e;
    L_0x000d:
        return r2;
    L_0x000e:
        r1 = r12;
        r1 = (org.spongycastle.asn1.ASN1Encodable) r1;
        r1 = r1.mo5709e();
        r3 = r11.mo5709e();
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0020;
    L_0x001f:
        return r0;
    L_0x0020:
        r12 = m40471a(r12);	 Catch:{ IllegalArgumentException -> 0x0093 }
        r1 = r11.f31489T;
        r1 = r1.size();
        r3 = r12.f31489T;
        r3 = r3.size();
        if (r1 == r3) goto L_0x0033;
    L_0x0032:
        return r2;
    L_0x0033:
        r3 = new boolean[r1];
        r4 = r11.f31489T;
        r4 = r4.elementAt(r2);
        r5 = r12.f31489T;
        r5 = r5.elementAt(r2);
        r4 = r4.equals(r5);
        r5 = -1;
        if (r4 == 0) goto L_0x004c;
    L_0x0048:
        r5 = r1;
        r4 = 0;
        r6 = 1;
        goto L_0x004f;
    L_0x004c:
        r4 = r1 + -1;
        r6 = -1;
    L_0x004f:
        if (r4 == r5) goto L_0x0092;
    L_0x0051:
        r7 = r11.f31489T;
        r7 = r7.elementAt(r4);
        r7 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r7;
        r8 = r11.f31490U;
        r8 = r8.elementAt(r4);
        r8 = (java.lang.String) r8;
        r9 = 0;
    L_0x0062:
        if (r9 >= r1) goto L_0x008c;
    L_0x0064:
        r10 = r3[r9];
        if (r10 == 0) goto L_0x0069;
    L_0x0068:
        goto L_0x0089;
    L_0x0069:
        r10 = r12.f31489T;
        r10 = r10.elementAt(r9);
        r10 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r10;
        r10 = r7.equals(r10);
        if (r10 == 0) goto L_0x0089;
    L_0x0077:
        r10 = r12.f31490U;
        r10 = r10.elementAt(r9);
        r10 = (java.lang.String) r10;
        r10 = r11.m40473a(r8, r10);
        if (r10 == 0) goto L_0x0089;
    L_0x0085:
        r3[r9] = r0;
        r7 = 1;
        goto L_0x008d;
    L_0x0089:
        r9 = r9 + 1;
        goto L_0x0062;
    L_0x008c:
        r7 = 0;
    L_0x008d:
        if (r7 != 0) goto L_0x0090;
    L_0x008f:
        return r2;
    L_0x0090:
        r4 = r4 + r6;
        goto L_0x004f;
    L_0x0092:
        return r0;
    L_0x0093:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x509.X509Name.equals(java.lang.Object):boolean");
    }

    /* renamed from: a */
    private boolean m40473a(String str, String str2) {
        str = m40474b(str);
        str2 = m40474b(str2);
        return (str.equals(str2) || m40476d(str).equals(m40476d(str2)) != null) ? true : null;
    }

    /* renamed from: b */
    private String m40474b(String str) {
        str = Strings.m29427c(str.trim());
        if (str.length() <= 0 || str.charAt(0) != '#') {
            return str;
        }
        ASN1Primitive c = m40475c(str);
        return c instanceof ASN1String ? Strings.m29427c(((ASN1String) c).mo6440b().trim()) : str;
    }

    /* renamed from: c */
    private ASN1Primitive m40475c(String str) {
        try {
            return ASN1Primitive.m39798b(Hex.m29436a(str.substring(1)));
        } catch (String str2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unknown encoding in name: ");
            stringBuilder.append(str2);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* renamed from: d */
    private String m40476d(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str.length() != 0) {
            char charAt = str.charAt(0);
            stringBuffer.append(charAt);
            int i = 1;
            while (i < str.length()) {
                char charAt2 = str.charAt(i);
                if (charAt != ' ' || charAt2 != ' ') {
                    stringBuffer.append(charAt2);
                }
                i++;
                charAt = charAt2;
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private void m40472a(StringBuffer stringBuffer, Hashtable hashtable, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        String str2 = (String) hashtable.get(aSN1ObjectIdentifier);
        if (str2 != null) {
            stringBuffer.append(str2);
        } else {
            stringBuffer.append(aSN1ObjectIdentifier.m42986b());
        }
        stringBuffer.append('=');
        hashtable = stringBuffer.length();
        stringBuffer.append(str);
        aSN1ObjectIdentifier = stringBuffer.length();
        if (str.length() >= 2 && str.charAt(0) == '\\' && str.charAt(1) == 35) {
            hashtable += 2;
        }
        while (hashtable < aSN1ObjectIdentifier && stringBuffer.charAt(hashtable) == ' ') {
            stringBuffer.insert(hashtable, "\\");
            hashtable += 2;
            aSN1ObjectIdentifier++;
        }
        while (true) {
            aSN1ObjectIdentifier--;
            if (aSN1ObjectIdentifier <= hashtable || stringBuffer.charAt(aSN1ObjectIdentifier) != ' ') {
                while (hashtable <= aSN1ObjectIdentifier) {
                    str = stringBuffer.charAt(hashtable);
                    if (!(str == 34 || str == 92)) {
                        switch (str) {
                            case 43:
                            case 44:
                                break;
                            default:
                                switch (str) {
                                    case 59:
                                    case 60:
                                    case 61:
                                    case 62:
                                        break;
                                    default:
                                        hashtable++;
                                        continue;
                                        continue;
                                        continue;
                                        continue;
                                }
                        }
                    }
                    stringBuffer.insert(hashtable, "\\");
                    hashtable += 2;
                    aSN1ObjectIdentifier++;
                }
            } else {
                stringBuffer.insert(aSN1ObjectIdentifier, '\\');
            }
        }
        while (hashtable <= aSN1ObjectIdentifier) {
            str = stringBuffer.charAt(hashtable);
            switch (str) {
                case 43:
                case 44:
                    break;
                default:
                    switch (str) {
                        case 59:
                        case 60:
                        case 61:
                        case 62:
                            break;
                        default:
                            hashtable++;
                            continue;
                            continue;
                            continue;
                            continue;
                    }
            }
            stringBuffer.insert(hashtable, "\\");
            hashtable += 2;
            aSN1ObjectIdentifier++;
        }
    }

    /* renamed from: a */
    public String m40477a(boolean z, Hashtable hashtable) {
        int i;
        StringBuffer stringBuffer = new StringBuffer();
        Vector vector = new Vector();
        StringBuffer stringBuffer2 = null;
        for (i = 0; i < this.f31489T.size(); i++) {
            if (((Boolean) this.f31491V.elementAt(i)).booleanValue()) {
                stringBuffer2.append('+');
                m40472a(stringBuffer2, hashtable, (ASN1ObjectIdentifier) this.f31489T.elementAt(i), (String) this.f31490U.elementAt(i));
            } else {
                stringBuffer2 = new StringBuffer();
                m40472a(stringBuffer2, hashtable, (ASN1ObjectIdentifier) this.f31489T.elementAt(i), (String) this.f31490U.elementAt(i));
                vector.addElement(stringBuffer2);
            }
        }
        i = 1;
        if (z) {
            for (z = vector.size() - true; z < false; z--) {
                if (i != 0) {
                    i = 0;
                } else {
                    stringBuffer.append(',');
                }
                stringBuffer.append(vector.elementAt(z).toString());
            }
        } else {
            for (z = false; z < vector.size(); z++) {
                if (i != 0) {
                    i = 0;
                } else {
                    stringBuffer.append(',');
                }
                stringBuffer.append(vector.elementAt(z).toString());
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private String m40470a(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i != cArr.length; i++) {
            cArr[i] = (char) (bArr[i] & JfifUtil.MARKER_FIRST_BYTE);
        }
        return new String(cArr);
    }

    public String toString() {
        return m40477a(f31453J, f31454K);
    }
}
