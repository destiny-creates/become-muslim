package org.spongycastle.asn1;

import com.facebook.appevents.AppEventsConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class ASN1GeneralizedTime extends ASN1Primitive {
    /* renamed from: a */
    private byte[] f32482a;

    /* renamed from: a */
    boolean mo6788a() {
        return false;
    }

    /* renamed from: a */
    public static ASN1GeneralizedTime m42954a(Object obj) {
        StringBuilder stringBuilder;
        if (obj != null) {
            if (!(obj instanceof ASN1GeneralizedTime)) {
                if (obj instanceof byte[]) {
                    try {
                        return (ASN1GeneralizedTime) ASN1Primitive.m39798b((byte[]) obj);
                    } catch (Object obj2) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("encoding error in getInstance: ");
                        stringBuilder.append(obj2.toString());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("illegal object in getInstance: ");
                stringBuilder.append(obj2.getClass().getName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return (ASN1GeneralizedTime) obj2;
    }

    public ASN1GeneralizedTime(String str) {
        this.f32482a = Strings.m29429d(str);
        try {
            m42961c();
        } catch (String str2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid date string: ");
            stringBuilder.append(str2.getMessage());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    ASN1GeneralizedTime(byte[] bArr) {
        this.f32482a = bArr;
    }

    /* renamed from: b */
    public String m42960b() {
        String b = Strings.m29425b(this.f32482a);
        if (b.charAt(b.length() - 1) == 'Z') {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b.substring(0, b.length() - 1));
            stringBuilder.append("GMT+00:00");
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder2;
        int length = b.length() - 5;
        char charAt = b.charAt(length);
        if (charAt != '-') {
            if (charAt != '+') {
                length = b.length() - 3;
                charAt = b.charAt(length);
                if (charAt != '-') {
                    if (charAt != '+') {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(b);
                        stringBuilder.append(m42955g());
                        return stringBuilder.toString();
                    }
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(b.substring(0, length));
                stringBuilder2.append("GMT");
                stringBuilder2.append(b.substring(length));
                stringBuilder2.append(":00");
                return stringBuilder2.toString();
            }
        }
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(b.substring(0, length));
        stringBuilder2.append("GMT");
        int i = length + 3;
        stringBuilder2.append(b.substring(length, i));
        stringBuilder2.append(":");
        stringBuilder2.append(b.substring(i));
        return stringBuilder2.toString();
    }

    /* renamed from: g */
    private java.lang.String m42955g() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = "+";
        r1 = java.util.TimeZone.getDefault();
        r2 = r1.getRawOffset();
        if (r2 >= 0) goto L_0x000f;
    L_0x000c:
        r0 = "-";
        r2 = -r2;
    L_0x000f:
        r3 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r3 = r2 / r3;
        r4 = r3 * 60;
        r4 = r4 * 60;
        r4 = r4 * 1000;
        r2 = r2 - r4;
        r4 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r2 = r2 / r4;
        r4 = r1.useDaylightTime();	 Catch:{ ParseException -> 0x003b }
        if (r4 == 0) goto L_0x003b;	 Catch:{ ParseException -> 0x003b }
    L_0x0025:
        r4 = r5.m42961c();	 Catch:{ ParseException -> 0x003b }
        r1 = r1.inDaylightTime(r4);	 Catch:{ ParseException -> 0x003b }
        if (r1 == 0) goto L_0x003b;	 Catch:{ ParseException -> 0x003b }
    L_0x002f:
        r1 = "+";	 Catch:{ ParseException -> 0x003b }
        r1 = r0.equals(r1);	 Catch:{ ParseException -> 0x003b }
        if (r1 == 0) goto L_0x0039;
    L_0x0037:
        r1 = 1;
        goto L_0x003a;
    L_0x0039:
        r1 = -1;
    L_0x003a:
        r3 = r3 + r1;
    L_0x003b:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = "GMT";
        r1.append(r4);
        r1.append(r0);
        r0 = r5.m42953a(r3);
        r1.append(r0);
        r0 = ":";
        r1.append(r0);
        r0 = r5.m42953a(r2);
        r1.append(r0);
        r0 = r1.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.ASN1GeneralizedTime.g():java.lang.String");
    }

    /* renamed from: a */
    private String m42953a(int i) {
        if (i >= 10) {
            return Integer.toString(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    /* renamed from: c */
    public Date m42961c() {
        SimpleDateFormat simpleDateFormat;
        String b = Strings.m29425b(this.f32482a);
        if (b.endsWith("Z")) {
            if (m42956j()) {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
            } else {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
            }
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        } else {
            if (b.indexOf(45) <= 0) {
                if (b.indexOf(43) <= 0) {
                    if (m42956j()) {
                        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
                    } else {
                        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                    }
                    simpleDateFormat.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
                }
            }
            b = m42960b();
            if (m42956j()) {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
            } else {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
            }
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        }
        if (m42956j()) {
            String substring = b.substring(14);
            int i = 1;
            while (i < substring.length()) {
                char charAt = substring.charAt(i);
                if ('0' > charAt) {
                    break;
                } else if (charAt > '9') {
                    break;
                } else {
                    i++;
                }
            }
            int i2 = i - 1;
            StringBuilder stringBuilder;
            if (i2 > 3) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(substring.substring(0, 4));
                stringBuilder.append(substring.substring(i));
                substring = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(b.substring(0, 14));
                stringBuilder.append(substring);
                b = stringBuilder.toString();
            } else if (i2 == 1) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(substring.substring(0, i));
                stringBuilder.append("00");
                stringBuilder.append(substring.substring(i));
                substring = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(b.substring(0, 14));
                stringBuilder.append(substring);
                b = stringBuilder.toString();
            } else if (i2 == 2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(substring.substring(0, i));
                stringBuilder.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                stringBuilder.append(substring.substring(i));
                substring = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(b.substring(0, 14));
                stringBuilder.append(substring);
                b = stringBuilder.toString();
            }
        }
        return simpleDateFormat.parse(b);
    }

    /* renamed from: j */
    private boolean m42956j() {
        int i = 0;
        while (i != this.f32482a.length) {
            if (this.f32482a[i] == (byte) 46 && i == 14) {
                return true;
            }
            i++;
        }
        return false;
    }

    /* renamed from: d */
    int mo6790d() {
        int length = this.f32482a.length;
        return (StreamUtil.m27168a(length) + 1) + length;
    }

    /* renamed from: a */
    void mo6787a(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.m27146a(24, this.f32482a);
    }

    /* renamed from: a */
    boolean mo6789a(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1GeneralizedTime) {
            return Arrays.m29353a(this.f32482a, ((ASN1GeneralizedTime) aSN1Primitive).f32482a);
        }
        return null;
    }

    public int hashCode() {
        return Arrays.m29342a(this.f32482a);
    }
}
