package org.spongycastle.asn1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class ASN1UTCTime extends ASN1Primitive {
    /* renamed from: a */
    private byte[] f32495a;

    /* renamed from: a */
    boolean mo6788a() {
        return false;
    }

    ASN1UTCTime(byte[] bArr) {
        this.f32495a = bArr;
    }

    /* renamed from: b */
    public Date m43040b() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        return simpleDateFormat.parse(m43043g());
    }

    /* renamed from: c */
    public String m43041c() {
        String b = Strings.m29425b(this.f32495a);
        StringBuilder stringBuilder;
        if (b.indexOf(45) >= 0 || b.indexOf(43) >= 0) {
            int indexOf = b.indexOf(45);
            if (indexOf < 0) {
                indexOf = b.indexOf(43);
            }
            if (indexOf == b.length() - 3) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(b);
                stringBuilder2.append("00");
                b = stringBuilder2.toString();
            }
            if (indexOf == 10) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(b.substring(0, 10));
                stringBuilder.append("00GMT");
                stringBuilder.append(b.substring(10, 13));
                stringBuilder.append(":");
                stringBuilder.append(b.substring(13, 15));
                return stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(b.substring(0, 12));
            stringBuilder.append("GMT");
            stringBuilder.append(b.substring(12, 15));
            stringBuilder.append(":");
            stringBuilder.append(b.substring(15, 17));
            return stringBuilder.toString();
        } else if (b.length() == 11) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(b.substring(0, 10));
            stringBuilder.append("00GMT+00:00");
            return stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(b.substring(0, 12));
            stringBuilder.append("GMT+00:00");
            return stringBuilder.toString();
        }
    }

    /* renamed from: g */
    public String m43043g() {
        String c = m43041c();
        if (c.charAt(0) < '5') {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("20");
            stringBuilder.append(c);
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("19");
        stringBuilder.append(c);
        return stringBuilder.toString();
    }

    /* renamed from: d */
    int mo6790d() {
        int length = this.f32495a.length;
        return (StreamUtil.m27168a(length) + 1) + length;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.mo5710b(23);
        int length = this.f32495a.length;
        aSN1OutputStream.m27143a(length);
        for (int i = 0; i != length; i++) {
            aSN1OutputStream.mo5710b(this.f32495a[i]);
        }
    }

    /* renamed from: a */
    boolean mo6789a(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1UTCTime) {
            return Arrays.m29353a(this.f32495a, ((ASN1UTCTime) aSN1Primitive).f32495a);
        }
        return null;
    }

    public int hashCode() {
        return Arrays.m29342a(this.f32495a);
    }

    public String toString() {
        return Strings.m29425b(this.f32495a);
    }
}
