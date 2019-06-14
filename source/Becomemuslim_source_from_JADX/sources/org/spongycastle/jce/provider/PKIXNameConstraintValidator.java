package org.spongycastle.jce.provider;

import com.facebook.imageutils.JfifUtil;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.facebook.soloader.MinElf;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralSubtree;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Strings;

public class PKIXNameConstraintValidator {
    /* renamed from: a */
    private Set f22991a = new HashSet();
    /* renamed from: b */
    private Set f22992b = new HashSet();
    /* renamed from: c */
    private Set f22993c = new HashSet();
    /* renamed from: d */
    private Set f22994d = new HashSet();
    /* renamed from: e */
    private Set f22995e = new HashSet();
    /* renamed from: f */
    private Set f22996f;
    /* renamed from: g */
    private Set f22997g;
    /* renamed from: h */
    private Set f22998h;
    /* renamed from: i */
    private Set f22999i;
    /* renamed from: j */
    private Set f23000j;

    /* renamed from: a */
    private static boolean m28193a(ASN1Sequence aSN1Sequence, ASN1Sequence aSN1Sequence2) {
        if (aSN1Sequence2.mo6862g() < 1 || aSN1Sequence2.mo6862g() > aSN1Sequence.mo6862g()) {
            return false;
        }
        for (int g = aSN1Sequence2.mo6862g() - 1; g >= 0; g--) {
            if (!aSN1Sequence2.mo6860a(g).equals(aSN1Sequence.mo6860a(g))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void m28226a(ASN1Sequence aSN1Sequence) {
        m28189a(this.f22996f, aSN1Sequence);
    }

    /* renamed from: b */
    public void m28230b(ASN1Sequence aSN1Sequence) {
        m28199b(this.f22991a, aSN1Sequence);
    }

    /* renamed from: a */
    private void m28189a(Set set, ASN1Sequence aSN1Sequence) {
        if (set != null) {
            if (!set.isEmpty() || aSN1Sequence.mo6862g() != 0) {
                for (ASN1Sequence a : set) {
                    if (m28193a(aSN1Sequence, a)) {
                        return;
                    }
                }
                throw new PKIXNameConstraintValidatorException("Subject distinguished name is not from a permitted subtree");
            }
        }
    }

    /* renamed from: b */
    private void m28199b(Set set, ASN1Sequence aSN1Sequence) {
        if (!set.isEmpty()) {
            for (ASN1Sequence a : set) {
                if (m28193a(aSN1Sequence, a)) {
                    throw new PKIXNameConstraintValidatorException("Subject distinguished name is from an excluded subtree");
                }
            }
        }
    }

    /* renamed from: a */
    private Set m28185a(Set set, Set set2) {
        Set hashSet = new HashSet();
        for (GeneralSubtree a : set2) {
            ASN1Sequence a2 = ASN1Sequence.m43000a(a.m40351a().m40344b().mo5709e());
            if (set != null) {
                for (ASN1Sequence aSN1Sequence : set) {
                    if (m28193a(a2, aSN1Sequence)) {
                        hashSet.add(a2);
                    } else if (m28193a(aSN1Sequence, a2)) {
                        hashSet.add(aSN1Sequence);
                    }
                }
            } else if (a2 != null) {
                hashSet.add(a2);
            }
        }
        return hashSet;
    }

    /* renamed from: c */
    private Set m28204c(Set set, ASN1Sequence aSN1Sequence) {
        if (!set.isEmpty()) {
            Set hashSet = new HashSet();
            for (ASN1Sequence aSN1Sequence2 : set) {
                if (m28193a(aSN1Sequence, aSN1Sequence2)) {
                    hashSet.add(aSN1Sequence2);
                } else if (m28193a(aSN1Sequence2, aSN1Sequence)) {
                    hashSet.add(aSN1Sequence);
                } else {
                    hashSet.add(aSN1Sequence2);
                    hashSet.add(aSN1Sequence);
                }
            }
            return hashSet;
        } else if (aSN1Sequence == null) {
            return set;
        } else {
            set.add(aSN1Sequence);
            return set;
        }
    }

    /* renamed from: b */
    private Set m28196b(Set set, Set set2) {
        Set hashSet = new HashSet();
        for (GeneralSubtree a : set2) {
            String c = m28202c(a.m40351a());
            if (set != null) {
                for (String c2 : set) {
                    m28205c(c, c2, hashSet);
                }
            } else if (c != null) {
                hashSet.add(c);
            }
        }
        return hashSet;
    }

    /* renamed from: b */
    private Set m28195b(Set set, String str) {
        if (!set.isEmpty()) {
            Set hashSet = new HashSet();
            for (String a : set) {
                m28188a(a, str, hashSet);
            }
            return hashSet;
        } else if (str == null) {
            return set;
        } else {
            set.add(str);
            return set;
        }
    }

    /* renamed from: c */
    private Set m28203c(Set set, Set set2) {
        Set hashSet = new HashSet();
        for (GeneralSubtree a : set2) {
            byte[] c = ASN1OctetString.m42990a(a.m40351a().m40344b()).mo6859c();
            if (set != null) {
                for (byte[] b : set) {
                    hashSet.addAll(m28197b(b, c));
                }
            } else if (c != null) {
                hashSet.add(c);
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    private Set m28186a(Set set, byte[] bArr) {
        if (!set.isEmpty()) {
            Set hashSet = new HashSet();
            for (byte[] a : set) {
                hashSet.addAll(m28187a(a, bArr));
            }
            return hashSet;
        } else if (bArr == null) {
            return set;
        } else {
            set.add(bArr);
            return set;
        }
    }

    /* renamed from: a */
    private Set m28187a(byte[] bArr, byte[] bArr2) {
        Set hashSet = new HashSet();
        if (Arrays.m29353a(bArr, bArr2)) {
            hashSet.add(bArr);
        } else {
            hashSet.add(bArr);
            hashSet.add(bArr2);
        }
        return hashSet;
    }

    /* renamed from: b */
    private Set m28197b(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return Collections.EMPTY_SET;
        }
        bArr = m28213d(bArr, bArr2);
        byte[] bArr3 = bArr[0];
        byte[] bArr4 = bArr[1];
        byte[] bArr5 = bArr[2];
        bArr = bArr[3];
        byte[][] a = m28194a(bArr3, bArr4, bArr5, bArr);
        if (m28221h(m28218f(a[0], a[2]), m28220g(a[1], a[3])) == 1) {
            return Collections.EMPTY_SET;
        }
        return Collections.singleton(m28209c(m28224i(a[0], a[2]), m28224i(bArr4, bArr)));
    }

    /* renamed from: c */
    private byte[] m28209c(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        Object obj = new byte[(length * 2)];
        System.arraycopy(bArr, 0, obj, 0, length);
        System.arraycopy(bArr2, 0, obj, length, length);
        return obj;
    }

    /* renamed from: d */
    private byte[][] m28213d(byte[] bArr, byte[] bArr2) {
        int length = bArr.length / 2;
        Object obj = new byte[length];
        System.arraycopy(bArr, 0, new byte[length], 0, length);
        System.arraycopy(bArr, length, obj, 0, length);
        Object obj2 = new byte[length];
        System.arraycopy(bArr2, 0, new byte[length], 0, length);
        System.arraycopy(bArr2, length, obj2, 0, length);
        return new byte[][]{r2, obj, bArr, obj2};
    }

    /* renamed from: a */
    private byte[][] m28194a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int length = bArr.length;
        byte[] bArr5 = new byte[length];
        byte[] bArr6 = new byte[length];
        byte[] bArr7 = new byte[length];
        byte[] bArr8 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr5[i] = (byte) (bArr[i] & bArr2[i]);
            bArr6[i] = (byte) ((bArr[i] & bArr2[i]) | (~bArr2[i]));
            bArr7[i] = (byte) (bArr3[i] & bArr4[i]);
            bArr8[i] = (byte) ((bArr3[i] & bArr4[i]) | (~bArr4[i]));
        }
        return new byte[][]{bArr5, bArr6, bArr7, bArr8};
    }

    /* renamed from: c */
    private void m28206c(Set set, String str) {
        if (set != null) {
            for (String a : set) {
                if (m28191a(str, a)) {
                    return;
                }
            }
            if (str.length() != null || set.size() != null) {
                throw new PKIXNameConstraintValidatorException("Subject email address is not from a permitted subtree.");
            }
        }
    }

    /* renamed from: d */
    private void m28212d(Set set, String str) {
        if (!set.isEmpty()) {
            for (String a : set) {
                if (m28191a(str, a)) {
                    throw new PKIXNameConstraintValidatorException("Email address is from an excluded subtree.");
                }
            }
        }
    }

    /* renamed from: b */
    private void m28200b(Set set, byte[] bArr) {
        if (set != null) {
            for (byte[] e : set) {
                if (m28216e(bArr, e)) {
                    return;
                }
            }
            if (bArr.length != null || set.size() != null) {
                throw new PKIXNameConstraintValidatorException("IP is not from a permitted subtree.");
            }
        }
    }

    /* renamed from: c */
    private void m28207c(Set set, byte[] bArr) {
        if (!set.isEmpty()) {
            for (byte[] e : set) {
                if (m28216e(bArr, e)) {
                    throw new PKIXNameConstraintValidatorException("IP is from an excluded subtree.");
                }
            }
        }
    }

    /* renamed from: e */
    private boolean m28216e(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = 0;
        if (length != bArr2.length / 2) {
            return false;
        }
        Object obj = new byte[length];
        System.arraycopy(bArr2, length, obj, 0, length);
        byte[] bArr3 = new byte[length];
        byte[] bArr4 = new byte[length];
        while (i < length) {
            bArr3[i] = (byte) (bArr2[i] & obj[i]);
            bArr4[i] = (byte) (bArr[i] & obj[i]);
            i++;
        }
        return Arrays.m29353a(bArr3, bArr4);
    }

    /* renamed from: a */
    private boolean m28191a(String str, String str2) {
        String substring = str.substring(str.indexOf(64) + 1);
        if (str2.indexOf(64) != -1) {
            if (str.equalsIgnoreCase(str2) == null && substring.equalsIgnoreCase(str2.substring(1)) == null) {
                return false;
            }
            return true;
        } else if (str2.charAt(0) != 46) {
            if (substring.equalsIgnoreCase(str2) != null) {
                return true;
            }
        } else if (m28201b(substring, str2) != null) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private boolean m28201b(String str, String str2) {
        if (str2.startsWith(".")) {
            str2 = str2.substring(1);
        }
        str2 = Strings.m29423a(str2, '.');
        str = Strings.m29423a(str, '.');
        if (str.length <= str2.length) {
            return false;
        }
        int length = str.length - str2.length;
        for (int i = -1; i < str2.length; i++) {
            if (i == -1) {
                if (str[i + length].equals("")) {
                    return false;
                }
            } else if (!str2[i].equalsIgnoreCase(str[i + length])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    private void m28215e(Set set, String str) {
        if (set != null) {
            for (String str2 : set) {
                if (!m28201b(str, str2)) {
                    if (str.equalsIgnoreCase(str2)) {
                    }
                }
                return;
            }
            if (str.length() != null || set.size() != null) {
                throw new PKIXNameConstraintValidatorException("DNS is not from a permitted subtree.");
            }
        }
    }

    /* renamed from: f */
    private void m28217f(Set set, String str) {
        if (!set.isEmpty()) {
            for (String str2 : set) {
                if (m28201b(str, str2) || str.equalsIgnoreCase(str2)) {
                    throw new PKIXNameConstraintValidatorException("DNS is from an excluded subtree.");
                }
            }
        }
    }

    /* renamed from: a */
    private void m28188a(String str, String str2, Set set) {
        if (str.indexOf(64) != -1) {
            String substring = str.substring(str.indexOf(64) + 1);
            if (str2.indexOf(64) != -1) {
                if (str.equalsIgnoreCase(str2)) {
                    set.add(str);
                    return;
                }
                set.add(str);
                set.add(str2);
            } else if (str2.startsWith(".")) {
                if (m28201b(substring, str2)) {
                    set.add(str2);
                    return;
                }
                set.add(str);
                set.add(str2);
            } else if (substring.equalsIgnoreCase(str2)) {
                set.add(str2);
            } else {
                set.add(str);
                set.add(str2);
            }
        } else if (str.startsWith(".")) {
            if (str2.indexOf(64) != -1) {
                if (m28201b(str2.substring(str.indexOf(64) + 1), str)) {
                    set.add(str);
                    return;
                }
                set.add(str);
                set.add(str2);
            } else if (str2.startsWith(".")) {
                if (!m28201b(str, str2)) {
                    if (!str.equalsIgnoreCase(str2)) {
                        if (m28201b(str2, str)) {
                            set.add(str);
                            return;
                        }
                        set.add(str);
                        set.add(str2);
                        return;
                    }
                }
                set.add(str2);
            } else if (m28201b(str2, str)) {
                set.add(str);
            } else {
                set.add(str);
                set.add(str2);
            }
        } else if (str2.indexOf(64) != -1) {
            if (str2.substring(str.indexOf(64) + 1).equalsIgnoreCase(str)) {
                set.add(str);
                return;
            }
            set.add(str);
            set.add(str2);
        } else if (str2.startsWith(".")) {
            if (m28201b(str, str2)) {
                set.add(str2);
                return;
            }
            set.add(str);
            set.add(str2);
        } else if (str.equalsIgnoreCase(str2)) {
            set.add(str);
        } else {
            set.add(str);
            set.add(str2);
        }
    }

    /* renamed from: b */
    private void m28198b(String str, String str2, Set set) {
        if (str.indexOf(64) != -1) {
            String substring = str.substring(str.indexOf(64) + 1);
            if (str2.indexOf(64) != -1) {
                if (str.equalsIgnoreCase(str2)) {
                    set.add(str);
                    return;
                }
                set.add(str);
                set.add(str2);
            } else if (str2.startsWith(".")) {
                if (m28201b(substring, str2)) {
                    set.add(str2);
                    return;
                }
                set.add(str);
                set.add(str2);
            } else if (substring.equalsIgnoreCase(str2)) {
                set.add(str2);
            } else {
                set.add(str);
                set.add(str2);
            }
        } else if (str.startsWith(".")) {
            if (str2.indexOf(64) != -1) {
                if (m28201b(str2.substring(str.indexOf(64) + 1), str)) {
                    set.add(str);
                    return;
                }
                set.add(str);
                set.add(str2);
            } else if (str2.startsWith(".")) {
                if (!m28201b(str, str2)) {
                    if (!str.equalsIgnoreCase(str2)) {
                        if (m28201b(str2, str)) {
                            set.add(str);
                            return;
                        }
                        set.add(str);
                        set.add(str2);
                        return;
                    }
                }
                set.add(str2);
            } else if (m28201b(str2, str)) {
                set.add(str);
            } else {
                set.add(str);
                set.add(str2);
            }
        } else if (str2.indexOf(64) != -1) {
            if (str2.substring(str.indexOf(64) + 1).equalsIgnoreCase(str)) {
                set.add(str);
                return;
            }
            set.add(str);
            set.add(str2);
        } else if (str2.startsWith(".")) {
            if (m28201b(str, str2)) {
                set.add(str2);
                return;
            }
            set.add(str);
            set.add(str2);
        } else if (str.equalsIgnoreCase(str2)) {
            set.add(str);
        } else {
            set.add(str);
            set.add(str2);
        }
    }

    /* renamed from: d */
    private Set m28210d(Set set, Set set2) {
        Set hashSet = new HashSet();
        for (GeneralSubtree a : set2) {
            String c = m28202c(a.m40351a());
            if (set != null) {
                for (String str : set) {
                    if (m28201b(str, c)) {
                        hashSet.add(str);
                    } else if (m28201b(c, str)) {
                        hashSet.add(c);
                    }
                }
            } else if (c != null) {
                hashSet.add(c);
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    protected Set m28225a(Set set, String str) {
        if (!set.isEmpty()) {
            Set hashSet = new HashSet();
            for (String str2 : set) {
                if (m28201b(str2, str)) {
                    hashSet.add(str);
                } else if (m28201b(str, str2)) {
                    hashSet.add(str2);
                } else {
                    hashSet.add(str2);
                    hashSet.add(str);
                }
            }
            return hashSet;
        } else if (str == null) {
            return set;
        } else {
            set.add(str);
            return set;
        }
    }

    /* renamed from: c */
    private void m28205c(String str, String str2, Set set) {
        if (str.indexOf(64) != -1) {
            String substring = str.substring(str.indexOf(64) + 1);
            if (str2.indexOf(64) != -1) {
                if (str.equalsIgnoreCase(str2) != null) {
                    set.add(str);
                }
            } else if (str2.startsWith(".")) {
                if (m28201b(substring, str2) != null) {
                    set.add(str);
                }
            } else if (substring.equalsIgnoreCase(str2) != null) {
                set.add(str);
            }
        } else if (str.startsWith(".")) {
            if (str2.indexOf(64) != -1) {
                if (m28201b(str2.substring(str.indexOf(64) + 1), str) != null) {
                    set.add(str2);
                }
            } else if (str2.startsWith(".")) {
                if (!m28201b(str, str2)) {
                    if (!str.equalsIgnoreCase(str2)) {
                        if (m28201b(str2, str) != null) {
                            set.add(str2);
                            return;
                        }
                        return;
                    }
                }
                set.add(str);
            } else if (m28201b(str2, str) != null) {
                set.add(str2);
            }
        } else if (str2.indexOf(64) != -1) {
            if (str2.substring(str2.indexOf(64) + 1).equalsIgnoreCase(str) != null) {
                set.add(str2);
            }
        } else if (str2.startsWith(".")) {
            if (m28201b(str, str2) != null) {
                set.add(str);
            }
        } else if (str.equalsIgnoreCase(str2) != null) {
            set.add(str);
        }
    }

    /* renamed from: g */
    private void m28219g(Set set, String str) {
        if (!set.isEmpty()) {
            for (String c : set) {
                if (m28208c(str, c)) {
                    throw new PKIXNameConstraintValidatorException("URI is from an excluded subtree.");
                }
            }
        }
    }

    /* renamed from: e */
    private Set m28214e(Set set, Set set2) {
        Set hashSet = new HashSet();
        for (GeneralSubtree a : set2) {
            String c = m28202c(a.m40351a());
            if (set != null) {
                for (String d : set) {
                    m28211d(d, c, hashSet);
                }
            } else if (c != null) {
                hashSet.add(c);
            }
        }
        return hashSet;
    }

    /* renamed from: h */
    private Set m28222h(Set set, String str) {
        if (!set.isEmpty()) {
            Set hashSet = new HashSet();
            for (String b : set) {
                m28198b(b, str, hashSet);
            }
            return hashSet;
        } else if (str == null) {
            return set;
        } else {
            set.add(str);
            return set;
        }
    }

    /* renamed from: d */
    private void m28211d(String str, String str2, Set set) {
        if (str.indexOf(64) != -1) {
            String substring = str.substring(str.indexOf(64) + 1);
            if (str2.indexOf(64) != -1) {
                if (str.equalsIgnoreCase(str2) != null) {
                    set.add(str);
                }
            } else if (str2.startsWith(".")) {
                if (m28201b(substring, str2) != null) {
                    set.add(str);
                }
            } else if (substring.equalsIgnoreCase(str2) != null) {
                set.add(str);
            }
        } else if (str.startsWith(".")) {
            if (str2.indexOf(64) != -1) {
                if (m28201b(str2.substring(str.indexOf(64) + 1), str) != null) {
                    set.add(str2);
                }
            } else if (str2.startsWith(".")) {
                if (!m28201b(str, str2)) {
                    if (!str.equalsIgnoreCase(str2)) {
                        if (m28201b(str2, str) != null) {
                            set.add(str2);
                            return;
                        }
                        return;
                    }
                }
                set.add(str);
            } else if (m28201b(str2, str) != null) {
                set.add(str2);
            }
        } else if (str2.indexOf(64) != -1) {
            if (str2.substring(str2.indexOf(64) + 1).equalsIgnoreCase(str) != null) {
                set.add(str2);
            }
        } else if (str2.startsWith(".")) {
            if (m28201b(str, str2) != null) {
                set.add(str);
            }
        } else if (str.equalsIgnoreCase(str2) != null) {
            set.add(str);
        }
    }

    /* renamed from: i */
    private void m28223i(Set set, String str) {
        if (set != null) {
            for (String c : set) {
                if (m28208c(str, c)) {
                    return;
                }
            }
            if (str.length() != null || set.size() != null) {
                throw new PKIXNameConstraintValidatorException("URI is not from a permitted subtree.");
            }
        }
    }

    /* renamed from: c */
    private boolean m28208c(String str, String str2) {
        str = m28182a(str);
        if (str2.startsWith(".")) {
            if (m28201b(str, str2) != null) {
                return true;
            }
        } else if (str.equalsIgnoreCase(str2) != null) {
            return true;
        }
        return null;
    }

    /* renamed from: a */
    private static String m28182a(String str) {
        str = str.substring(str.indexOf(58) + 1);
        if (str.indexOf("//") != -1) {
            str = str.substring(str.indexOf("//") + 2);
        }
        if (str.lastIndexOf(58) != -1) {
            str = str.substring(0, str.lastIndexOf(58));
        }
        str = str.substring(str.indexOf(58) + 1);
        str = str.substring(str.indexOf(64) + 1);
        return str.indexOf(47) != -1 ? str.substring(0, str.indexOf(47)) : str;
    }

    /* renamed from: a */
    public void m28227a(GeneralName generalName) {
        switch (generalName.m40343a()) {
            case 1:
                m28206c(this.f22998h, m28202c(generalName));
                return;
            case 2:
                m28215e(this.f22997g, DERIA5String.m43079a(generalName.m40344b()).mo6440b());
                return;
            case 4:
                m28226a(ASN1Sequence.m43000a(generalName.m40344b().mo5709e()));
                return;
            case 6:
                m28223i(this.f22999i, DERIA5String.m43079a(generalName.m40344b()).mo6440b());
                return;
            case 7:
                m28200b(this.f23000j, ASN1OctetString.m42990a(generalName.m40344b()).mo6859c());
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    public void m28231b(GeneralName generalName) {
        switch (generalName.m40343a()) {
            case 1:
                m28212d(this.f22993c, m28202c(generalName));
                return;
            case 2:
                m28217f(this.f22992b, DERIA5String.m43079a(generalName.m40344b()).mo6440b());
                return;
            case 4:
                m28230b(ASN1Sequence.m43000a(generalName.m40344b().mo5709e()));
                return;
            case 6:
                m28219g(this.f22994d, DERIA5String.m43079a(generalName.m40344b()).mo6440b());
                return;
            case 7:
                m28207c(this.f22995e, ASN1OctetString.m42990a(generalName.m40344b()).mo6859c());
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void m28229a(GeneralSubtree[] generalSubtreeArr) {
        Map hashMap = new HashMap();
        for (int i = 0; i != generalSubtreeArr.length; i++) {
            GeneralSubtree generalSubtree = generalSubtreeArr[i];
            Integer a = Integers.m29396a(generalSubtree.m40351a().m40343a());
            if (hashMap.get(a) == null) {
                hashMap.put(a, new HashSet());
            }
            ((Set) hashMap.get(a)).add(generalSubtree);
        }
        for (Entry entry : hashMap.entrySet()) {
            switch (((Integer) entry.getKey()).intValue()) {
                case 1:
                    this.f22998h = m28196b(this.f22998h, (Set) entry.getValue());
                    break;
                case 2:
                    this.f22997g = m28210d(this.f22997g, (Set) entry.getValue());
                    break;
                case 4:
                    this.f22996f = m28185a(this.f22996f, (Set) entry.getValue());
                    break;
                case 6:
                    this.f22999i = m28214e(this.f22999i, (Set) entry.getValue());
                    break;
                case 7:
                    this.f23000j = m28203c(this.f23000j, (Set) entry.getValue());
                    break;
                default:
                    break;
            }
        }
    }

    /* renamed from: c */
    private String m28202c(GeneralName generalName) {
        return DERIA5String.m43079a(generalName.m40344b()).mo6440b();
    }

    /* renamed from: a */
    public void m28228a(GeneralSubtree generalSubtree) {
        generalSubtree = generalSubtree.m40351a();
        switch (generalSubtree.m40343a()) {
            case 1:
                this.f22993c = m28195b(this.f22993c, m28202c(generalSubtree));
                return;
            case 2:
                this.f22992b = m28225a(this.f22992b, m28202c(generalSubtree));
                return;
            case 4:
                this.f22991a = m28204c(this.f22991a, (ASN1Sequence) generalSubtree.m40344b().mo5709e());
                return;
            case 6:
                this.f22994d = m28222h(this.f22994d, m28202c(generalSubtree));
                return;
            case 7:
                this.f22995e = m28186a(this.f22995e, ASN1OctetString.m42990a(generalSubtree.m40344b()).mo6859c());
                return;
            default:
                return;
        }
    }

    /* renamed from: f */
    private static byte[] m28218f(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length; i++) {
            if ((bArr[i] & MinElf.PN_XNUM) > (MinElf.PN_XNUM & bArr2[i])) {
                return bArr;
            }
        }
        return bArr2;
    }

    /* renamed from: g */
    private static byte[] m28220g(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length; i++) {
            if ((bArr[i] & MinElf.PN_XNUM) < (MinElf.PN_XNUM & bArr2[i])) {
                return bArr;
            }
        }
        return bArr2;
    }

    /* renamed from: h */
    private static int m28221h(byte[] bArr, byte[] bArr2) {
        if (Arrays.m29353a(bArr, bArr2)) {
            return null;
        }
        return Arrays.m29353a(m28218f(bArr, bArr2), bArr) != null ? 1 : -1;
    }

    /* renamed from: i */
    private static byte[] m28224i(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] | bArr2[i]);
        }
        return bArr3;
    }

    public int hashCode() {
        return ((((((((m28181a(this.f22991a) + m28181a(this.f22992b)) + m28181a(this.f22993c)) + m28181a(this.f22995e)) + m28181a(this.f22994d)) + m28181a(this.f22996f)) + m28181a(this.f22997g)) + m28181a(this.f22998h)) + m28181a(this.f23000j)) + m28181a(this.f22999i);
    }

    /* renamed from: a */
    private int m28181a(Collection collection) {
        int i = 0;
        if (collection == null) {
            return 0;
        }
        for (Object next : collection) {
            if (next instanceof byte[]) {
                i += Arrays.m29342a((byte[]) next);
            } else {
                i += next.hashCode();
            }
        }
        return i;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof PKIXNameConstraintValidator)) {
            return false;
        }
        PKIXNameConstraintValidator pKIXNameConstraintValidator = (PKIXNameConstraintValidator) obj;
        if (m28192a(pKIXNameConstraintValidator.f22991a, this.f22991a) && m28192a(pKIXNameConstraintValidator.f22992b, this.f22992b) && m28192a(pKIXNameConstraintValidator.f22993c, this.f22993c) && m28192a(pKIXNameConstraintValidator.f22995e, this.f22995e) && m28192a(pKIXNameConstraintValidator.f22994d, this.f22994d) && m28192a(pKIXNameConstraintValidator.f22996f, this.f22996f) && m28192a(pKIXNameConstraintValidator.f22997g, this.f22997g) && m28192a(pKIXNameConstraintValidator.f22998h, this.f22998h) && m28192a(pKIXNameConstraintValidator.f23000j, this.f23000j) && m28192a(pKIXNameConstraintValidator.f22999i, this.f22999i) != null) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private boolean m28192a(Collection collection, Collection collection2) {
        if (collection == collection2) {
            return true;
        }
        if (collection != null) {
            if (collection2 != null) {
                if (collection.size() != collection2.size()) {
                    return false;
                }
                for (Object next : collection) {
                    Object next2;
                    for (Object a : collection2) {
                        if (m28190a(next2, a)) {
                            next2 = 1;
                            continue;
                            break;
                        }
                    }
                    next2 = null;
                    continue;
                    if (next2 == null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m28190a(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null) {
            if (obj2 != null) {
                if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
                    return Arrays.m29353a((byte[]) obj, (byte[]) obj2);
                }
                return obj.equals(obj2);
            }
        }
        return null;
    }

    /* renamed from: a */
    private String m28184a(byte[] bArr) {
        String str = "";
        for (int i = 0; i < bArr.length / 2; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(Integer.toString(bArr[i] & JfifUtil.MARKER_FIRST_BYTE));
            stringBuilder.append(".");
            str = stringBuilder.toString();
        }
        String substring = str.substring(0, str.length() - 1);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(substring);
        stringBuilder2.append("/");
        substring = stringBuilder2.toString();
        for (int length = bArr.length / 2; length < bArr.length; length++) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(substring);
            stringBuilder.append(Integer.toString(bArr[length] & JfifUtil.MARKER_FIRST_BYTE));
            stringBuilder.append(".");
            substring = stringBuilder.toString();
        }
        return substring.substring(0, substring.length() - 1);
    }

    /* renamed from: a */
    private String m28183a(Set set) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append("[");
        String stringBuilder2 = stringBuilder.toString();
        for (byte[] a : set) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(m28184a(a));
            stringBuilder.append(",");
            stringBuilder2 = stringBuilder.toString();
        }
        if (stringBuilder2.length() > 1) {
            stringBuilder2 = stringBuilder2.substring(null, stringBuilder2.length() - 1);
        }
        set = new StringBuilder();
        set.append(stringBuilder2);
        set.append("]");
        return set.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append("permitted:\n");
        String stringBuilder2 = stringBuilder.toString();
        if (this.f22996f != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append("DN:\n");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(this.f22996f.toString());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder.toString();
        }
        if (this.f22997g != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append("DNS:\n");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(this.f22997g.toString());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder.toString();
        }
        if (this.f22998h != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append("Email:\n");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(this.f22998h.toString());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder.toString();
        }
        if (this.f22999i != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append("URI:\n");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(this.f22999i.toString());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder.toString();
        }
        if (this.f23000j != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append("IP:\n");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(m28183a(this.f23000j));
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append("excluded:\n");
        stringBuilder2 = stringBuilder.toString();
        if (!this.f22991a.isEmpty()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append("DN:\n");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(this.f22991a.toString());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder.toString();
        }
        if (!this.f22992b.isEmpty()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append("DNS:\n");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(this.f22992b.toString());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder.toString();
        }
        if (!this.f22993c.isEmpty()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append("Email:\n");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(this.f22993c.toString());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder.toString();
        }
        if (!this.f22994d.isEmpty()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append("URI:\n");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(this.f22994d.toString());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder.toString();
        }
        if (this.f22995e.isEmpty()) {
            return stringBuilder2;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append("IP:\n");
        stringBuilder2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append(m28183a(this.f22995e));
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        return stringBuilder.toString();
    }
}
