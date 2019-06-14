package org.spongycastle.asn1.x500.style;

import com.facebook.imageutils.JfifUtil;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.x500.AttributeTypeAndValue;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500NameBuilder;
import org.spongycastle.asn1.x500.X500NameStyle;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

public class IETFUtils {
    /* renamed from: a */
    private static boolean m27242a(char c) {
        return ('0' <= c && c <= '9') || (('a' <= c && c <= 'f') || ('A' <= c && c <= 'F'));
    }

    /* renamed from: b */
    private static int m27247b(char c) {
        return ('0' > c || c > '9') ? ('a' > c || c > 'f') ? (c - 65) + 10 : (c - 97) + 10 : c - 48;
    }

    /* renamed from: c */
    private static String m27250c(String str) {
        if (str.length() != 0) {
            if (str.indexOf(92) >= 0 || str.indexOf(34) >= 0) {
                int i;
                char[] toCharArray = str.toCharArray();
                StringBuffer stringBuffer = new StringBuffer(str.length());
                if (toCharArray[null] == '\\' && toCharArray[1] == '#') {
                    i = 2;
                    stringBuffer.append("\\#");
                } else {
                    i = 0;
                }
                Object obj = null;
                int i2 = 0;
                int i3 = 0;
                Object obj2 = null;
                char c = '\u0000';
                for (i = 
/*
Method generation error in method: org.spongycastle.asn1.x500.style.IETFUtils.c(java.lang.String):java.lang.String, dex: classes2.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r4_4 'i' int) = (r4_2 'i' int), (r4_3 'i' int) binds: {(r4_3 'i' int)=B:12:0x0038, (r4_2 'i' int)=B:11:0x0031} in method: org.spongycastle.asn1.x500.style.IETFUtils.c(java.lang.String):java.lang.String, dex: classes2.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:187)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:320)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:257)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:12)
	at jadx.core.ProcessClass.process(ProcessClass.java:40)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:537)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:509)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 28 more

*/

                /* renamed from: a */
                public static RDN[] m27246a(String str, X500NameStyle x500NameStyle) {
                    X500NameTokenizer x500NameTokenizer = new X500NameTokenizer(str);
                    str = new X500NameBuilder(x500NameStyle);
                    while (x500NameTokenizer.m27252a()) {
                        String b = x500NameTokenizer.m27253b();
                        if (b.indexOf(43) > 0) {
                            X500NameTokenizer x500NameTokenizer2 = new X500NameTokenizer(b, '+');
                            X500NameTokenizer x500NameTokenizer3 = new X500NameTokenizer(x500NameTokenizer2.m27253b(), '=');
                            String b2 = x500NameTokenizer3.m27253b();
                            if (x500NameTokenizer3.m27252a()) {
                                b = x500NameTokenizer3.m27253b();
                                ASN1ObjectIdentifier a = x500NameStyle.mo6441a(b2.trim());
                                if (x500NameTokenizer2.m27252a()) {
                                    Vector vector = new Vector();
                                    Vector vector2 = new Vector();
                                    vector.addElement(a);
                                    vector2.addElement(m27250c(b));
                                    while (x500NameTokenizer2.m27252a()) {
                                        x500NameTokenizer3 = new X500NameTokenizer(x500NameTokenizer2.m27253b(), '=');
                                        b2 = x500NameTokenizer3.m27253b();
                                        if (x500NameTokenizer3.m27252a()) {
                                            b = x500NameTokenizer3.m27253b();
                                            vector.addElement(x500NameStyle.mo6441a(b2.trim()));
                                            vector2.addElement(m27250c(b));
                                        } else {
                                            throw new IllegalArgumentException("badly formatted directory string");
                                        }
                                    }
                                    str.m27226a(m27249b(vector), m27245a(vector2));
                                } else {
                                    str.m27224a(a, m27250c(b));
                                }
                            } else {
                                throw new IllegalArgumentException("badly formatted directory string");
                            }
                        }
                        X500NameTokenizer x500NameTokenizer4 = new X500NameTokenizer(b, '=');
                        b = x500NameTokenizer4.m27253b();
                        if (x500NameTokenizer4.m27252a()) {
                            str.m27224a(x500NameStyle.mo6441a(b.trim()), m27250c(x500NameTokenizer4.m27253b()));
                        } else {
                            throw new IllegalArgumentException("badly formatted directory string");
                        }
                    }
                    return str.m27223a().m40215a();
                }

                /* renamed from: a */
                private static String[] m27245a(Vector vector) {
                    String[] strArr = new String[vector.size()];
                    for (int i = 0; i != strArr.length; i++) {
                        strArr[i] = (String) vector.elementAt(i);
                    }
                    return strArr;
                }

                /* renamed from: b */
                private static ASN1ObjectIdentifier[] m27249b(Vector vector) {
                    ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = new ASN1ObjectIdentifier[vector.size()];
                    for (int i = 0; i != aSN1ObjectIdentifierArr.length; i++) {
                        aSN1ObjectIdentifierArr[i] = (ASN1ObjectIdentifier) vector.elementAt(i);
                    }
                    return aSN1ObjectIdentifierArr;
                }

                /* renamed from: a */
                public static ASN1ObjectIdentifier m27239a(String str, Hashtable hashtable) {
                    if (Strings.m29424b(str).startsWith("OID.")) {
                        return new ASN1ObjectIdentifier(str.substring(4));
                    }
                    if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                        return new ASN1ObjectIdentifier(str);
                    }
                    ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) hashtable.get(Strings.m29427c(str));
                    if (aSN1ObjectIdentifier != null) {
                        return aSN1ObjectIdentifier;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown object id - ");
                    stringBuilder.append(str);
                    stringBuilder.append(" - passed to distinguished name");
                    throw new IllegalArgumentException(stringBuilder.toString());
                }

                /* renamed from: a */
                public static ASN1Encodable m27238a(String str, int i) {
                    byte[] bArr = new byte[((str.length() - i) / 2)];
                    for (int i2 = 0; i2 != bArr.length; i2++) {
                        int i3 = (i2 * 2) + i;
                        char charAt = str.charAt(i3);
                        int b = m27247b(charAt) << 4;
                        bArr[i2] = (byte) (m27247b(str.charAt(i3 + 1)) | b);
                    }
                    return ASN1Primitive.m39798b(bArr);
                }

                /* renamed from: a */
                public static void m27241a(StringBuffer stringBuffer, RDN rdn, Hashtable hashtable) {
                    if (rdn.m40208a()) {
                        rdn = rdn.m40210c();
                        Object obj = 1;
                        for (int i = 0; i != rdn.length; i++) {
                            if (obj != null) {
                                obj = null;
                            } else {
                                stringBuffer.append('+');
                            }
                            m27240a(stringBuffer, rdn[i], hashtable);
                        }
                    } else if (rdn.m40209b() != null) {
                        m27240a(stringBuffer, rdn.m40209b(), hashtable);
                    }
                }

                /* renamed from: a */
                public static void m27240a(StringBuffer stringBuffer, AttributeTypeAndValue attributeTypeAndValue, Hashtable hashtable) {
                    String str = (String) hashtable.get(attributeTypeAndValue.m40202a());
                    if (str != null) {
                        stringBuffer.append(str);
                    } else {
                        stringBuffer.append(attributeTypeAndValue.m40202a().m42986b());
                    }
                    stringBuffer.append('=');
                    stringBuffer.append(m27236a(attributeTypeAndValue.m40203b()));
                }

                /* renamed from: a */
                public static java.lang.String m27236a(org.spongycastle.asn1.ASN1Encodable r7) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r0 = new java.lang.StringBuffer;
                    r0.<init>();
                    r1 = r7 instanceof org.spongycastle.asn1.ASN1String;
                    r2 = 35;
                    r3 = 0;
                    if (r1 == 0) goto L_0x003b;
                L_0x000c:
                    r1 = r7 instanceof org.spongycastle.asn1.DERUniversalString;
                    if (r1 != 0) goto L_0x003b;
                L_0x0010:
                    r7 = (org.spongycastle.asn1.ASN1String) r7;
                    r7 = r7.mo6440b();
                    r1 = r7.length();
                    if (r1 <= 0) goto L_0x0037;
                L_0x001c:
                    r1 = r7.charAt(r3);
                    if (r1 != r2) goto L_0x0037;
                L_0x0022:
                    r1 = new java.lang.StringBuilder;
                    r1.<init>();
                    r4 = "\\";
                    r1.append(r4);
                    r1.append(r7);
                    r7 = r1.toString();
                    r0.append(r7);
                    goto L_0x0061;
                L_0x0037:
                    r0.append(r7);
                    goto L_0x0061;
                L_0x003b:
                    r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00fc }
                    r1.<init>();	 Catch:{ IOException -> 0x00fc }
                    r4 = "#";	 Catch:{ IOException -> 0x00fc }
                    r1.append(r4);	 Catch:{ IOException -> 0x00fc }
                    r7 = r7.mo5709e();	 Catch:{ IOException -> 0x00fc }
                    r4 = "DER";	 Catch:{ IOException -> 0x00fc }
                    r7 = r7.m34596a(r4);	 Catch:{ IOException -> 0x00fc }
                    r7 = org.spongycastle.util.encoders.Hex.m29437a(r7);	 Catch:{ IOException -> 0x00fc }
                    r7 = m27237a(r7);	 Catch:{ IOException -> 0x00fc }
                    r1.append(r7);	 Catch:{ IOException -> 0x00fc }
                    r7 = r1.toString();	 Catch:{ IOException -> 0x00fc }
                    r0.append(r7);	 Catch:{ IOException -> 0x00fc }
                L_0x0061:
                    r7 = r0.length();
                    r1 = r0.length();
                    r4 = 92;
                    r5 = 2;
                    r6 = 1;
                    if (r1 < r5) goto L_0x007c;
                L_0x006f:
                    r1 = r0.charAt(r3);
                    if (r1 != r4) goto L_0x007c;
                L_0x0075:
                    r1 = r0.charAt(r6);
                    if (r1 != r2) goto L_0x007c;
                L_0x007b:
                    goto L_0x007d;
                L_0x007c:
                    r5 = 0;
                L_0x007d:
                    if (r5 == r7) goto L_0x00c8;
                L_0x007f:
                    r1 = r0.charAt(r5);
                    r2 = 44;
                    if (r1 == r2) goto L_0x00bd;
                L_0x0087:
                    r1 = r0.charAt(r5);
                    r2 = 34;
                    if (r1 == r2) goto L_0x00bd;
                L_0x008f:
                    r1 = r0.charAt(r5);
                    if (r1 == r4) goto L_0x00bd;
                L_0x0095:
                    r1 = r0.charAt(r5);
                    r2 = 43;
                    if (r1 == r2) goto L_0x00bd;
                L_0x009d:
                    r1 = r0.charAt(r5);
                    r2 = 61;
                    if (r1 == r2) goto L_0x00bd;
                L_0x00a5:
                    r1 = r0.charAt(r5);
                    r2 = 60;
                    if (r1 == r2) goto L_0x00bd;
                L_0x00ad:
                    r1 = r0.charAt(r5);
                    r2 = 62;
                    if (r1 == r2) goto L_0x00bd;
                L_0x00b5:
                    r1 = r0.charAt(r5);
                    r2 = 59;
                    if (r1 != r2) goto L_0x00c6;
                L_0x00bd:
                    r1 = "\\";
                    r0.insert(r5, r1);
                    r5 = r5 + 1;
                    r7 = r7 + 1;
                L_0x00c6:
                    r5 = r5 + r6;
                    goto L_0x007d;
                L_0x00c8:
                    r7 = r0.length();
                    r1 = 32;
                    if (r7 <= 0) goto L_0x00e4;
                L_0x00d0:
                    r7 = r0.length();
                    if (r7 <= r3) goto L_0x00e4;
                L_0x00d6:
                    r7 = r0.charAt(r3);
                    if (r7 != r1) goto L_0x00e4;
                L_0x00dc:
                    r7 = "\\";
                    r0.insert(r3, r7);
                    r3 = r3 + 2;
                    goto L_0x00d0;
                L_0x00e4:
                    r7 = r0.length();
                    r7 = r7 - r6;
                L_0x00e9:
                    if (r7 < 0) goto L_0x00f7;
                L_0x00eb:
                    r2 = r0.charAt(r7);
                    if (r2 != r1) goto L_0x00f7;
                L_0x00f1:
                    r0.insert(r7, r4);
                    r7 = r7 + -1;
                    goto L_0x00e9;
                L_0x00f7:
                    r7 = r0.toString();
                    return r7;
                L_0x00fc:
                    r7 = new java.lang.IllegalArgumentException;
                    r0 = "Other value has no encoded form";
                    r7.<init>(r0);
                    throw r7;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x500.style.IETFUtils.a(org.spongycastle.asn1.ASN1Encodable):java.lang.String");
                }

                /* renamed from: a */
                private static String m27237a(byte[] bArr) {
                    char[] cArr = new char[bArr.length];
                    for (int i = 0; i != cArr.length; i++) {
                        cArr[i] = (char) (bArr[i] & JfifUtil.MARKER_FIRST_BYTE);
                    }
                    return new String(cArr);
                }

                /* renamed from: a */
                public static String m27235a(String str) {
                    str = Strings.m29427c(str);
                    int i = 0;
                    if (str.length() > 0 && str.charAt(0) == '#') {
                        ASN1Primitive d = m27251d(str);
                        if (d instanceof ASN1String) {
                            str = Strings.m29427c(((ASN1String) d).mo6440b());
                        }
                    }
                    if (str.length() > 1) {
                        int i2;
                        while (true) {
                            i2 = i + 1;
                            if (i2 < str.length() && str.charAt(i) == '\\' && str.charAt(i2) == ' ') {
                                i += 2;
                            } else {
                                i2 = str.length() - 1;
                            }
                        }
                        i2 = str.length() - 1;
                        while (true) {
                            int i3 = i2 - 1;
                            if (i3 > 0 && str.charAt(i3) == '\\' && str.charAt(i2) == ' ') {
                                i2 -= 2;
                            } else if (i > 0 || i2 < str.length() - 1) {
                                str = str.substring(i, i2 + 1);
                            }
                        }
                        str = str.substring(i, i2 + 1);
                    }
                    return m27248b(str);
                }

                /* renamed from: d */
                private static ASN1Primitive m27251d(String str) {
                    try {
                        return ASN1Primitive.m39798b(Hex.m29436a(str.substring(1)));
                    } catch (String str2) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("unknown encoding in name: ");
                        stringBuilder.append(str2);
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                }

                /* renamed from: b */
                public static String m27248b(String str) {
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
                public static boolean m27244a(RDN rdn, RDN rdn2) {
                    if (rdn.m40208a()) {
                        if (!rdn2.m40208a()) {
                            return false;
                        }
                        rdn = rdn.m40210c();
                        rdn2 = rdn2.m40210c();
                        if (rdn.length != rdn2.length) {
                            return false;
                        }
                        for (int i = 0; i != rdn.length; i++) {
                            if (!m27243a(rdn[i], rdn2[i])) {
                                return false;
                            }
                        }
                        return true;
                    } else if (rdn2.m40208a()) {
                        return false;
                    } else {
                        return m27243a(rdn.m40209b(), rdn2.m40209b());
                    }
                }

                /* renamed from: a */
                private static boolean m27243a(AttributeTypeAndValue attributeTypeAndValue, AttributeTypeAndValue attributeTypeAndValue2) {
                    if (attributeTypeAndValue == attributeTypeAndValue2) {
                        return true;
                    }
                    return (attributeTypeAndValue == null || attributeTypeAndValue2 == null || !attributeTypeAndValue.m40202a().equals(attributeTypeAndValue2.m40202a()) || m27235a(m27236a(attributeTypeAndValue.m40203b())).equals(m27235a(m27236a(attributeTypeAndValue2.m40203b()))) == null) ? false : true;
                }
            }
