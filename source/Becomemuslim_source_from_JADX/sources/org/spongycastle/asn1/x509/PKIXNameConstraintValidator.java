package org.spongycastle.asn1.x509;

import com.facebook.imageutils.JfifUtil;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.util.Arrays;

public class PKIXNameConstraintValidator implements NameConstraintValidator {
    /* renamed from: a */
    private Set f26460a = new HashSet();
    /* renamed from: b */
    private Set f26461b = new HashSet();
    /* renamed from: c */
    private Set f26462c = new HashSet();
    /* renamed from: d */
    private Set f26463d = new HashSet();
    /* renamed from: e */
    private Set f26464e = new HashSet();
    /* renamed from: f */
    private Set f26465f;
    /* renamed from: g */
    private Set f26466g;
    /* renamed from: h */
    private Set f26467h;
    /* renamed from: i */
    private Set f26468i;
    /* renamed from: j */
    private Set f26469j;

    public int hashCode() {
        return ((((((((m34668a(this.f26460a) + m34668a(this.f26461b)) + m34668a(this.f26462c)) + m34668a(this.f26464e)) + m34668a(this.f26463d)) + m34668a(this.f26465f)) + m34668a(this.f26466g)) + m34668a(this.f26467h)) + m34668a(this.f26469j)) + m34668a(this.f26468i);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof PKIXNameConstraintValidator)) {
            return false;
        }
        PKIXNameConstraintValidator pKIXNameConstraintValidator = (PKIXNameConstraintValidator) obj;
        if (m34672a(pKIXNameConstraintValidator.f26460a, this.f26460a) && m34672a(pKIXNameConstraintValidator.f26461b, this.f26461b) && m34672a(pKIXNameConstraintValidator.f26462c, this.f26462c) && m34672a(pKIXNameConstraintValidator.f26464e, this.f26464e) && m34672a(pKIXNameConstraintValidator.f26463d, this.f26463d) && m34672a(pKIXNameConstraintValidator.f26465f, this.f26465f) && m34672a(pKIXNameConstraintValidator.f26466g, this.f26466g) && m34672a(pKIXNameConstraintValidator.f26467h, this.f26467h) && m34672a(pKIXNameConstraintValidator.f26469j, this.f26469j) && m34672a(pKIXNameConstraintValidator.f26468i, this.f26468i) != null) {
            z = true;
        }
        return z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append("permitted:\n");
        String stringBuilder2 = stringBuilder.toString();
        if (this.f26465f != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append("DN:\n");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(this.f26465f.toString());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder.toString();
        }
        if (this.f26466g != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append("DNS:\n");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(this.f26466g.toString());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder.toString();
        }
        if (this.f26467h != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append("Email:\n");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(this.f26467h.toString());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder.toString();
        }
        if (this.f26468i != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append("URI:\n");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(this.f26468i.toString());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder.toString();
        }
        if (this.f26469j != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append("IP:\n");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(m34669a(this.f26469j));
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append("excluded:\n");
        stringBuilder2 = stringBuilder.toString();
        if (!this.f26460a.isEmpty()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append("DN:\n");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(this.f26460a.toString());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder.toString();
        }
        if (!this.f26461b.isEmpty()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append("DNS:\n");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(this.f26461b.toString());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder.toString();
        }
        if (!this.f26462c.isEmpty()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append("Email:\n");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(this.f26462c.toString());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder.toString();
        }
        if (!this.f26463d.isEmpty()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append("URI:\n");
            stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(this.f26463d.toString());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder.toString();
        }
        if (this.f26464e.isEmpty()) {
            return stringBuilder2;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append("IP:\n");
        stringBuilder2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append(m34669a(this.f26464e));
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private int m34668a(Collection collection) {
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

    /* renamed from: a */
    private boolean m34672a(Collection collection, Collection collection2) {
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
                        if (m34671a(next2, a)) {
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
    private boolean m34671a(Object obj, Object obj2) {
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
    private String m34670a(byte[] bArr) {
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
    private String m34669a(Set set) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append("[");
        String stringBuilder2 = stringBuilder.toString();
        for (byte[] a : set) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder2);
            stringBuilder.append(m34670a(a));
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
}
