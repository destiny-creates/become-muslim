package org.spongycastle.asn1.x509;

import java.text.ParseException;
import java.util.Date;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1UTCTime;

public class Time extends ASN1Object implements ASN1Choice {
    /* renamed from: a */
    ASN1Primitive f31405a;

    public Time(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1UTCTime)) {
            if (!(aSN1Primitive instanceof ASN1GeneralizedTime)) {
                throw new IllegalArgumentException("unknown object passed to Time");
            }
        }
        this.f31405a = aSN1Primitive;
    }

    /* renamed from: a */
    public static Time m40457a(Object obj) {
        if (obj != null) {
            if (!(obj instanceof Time)) {
                if (obj instanceof ASN1UTCTime) {
                    return new Time((ASN1UTCTime) obj);
                }
                if (obj instanceof ASN1GeneralizedTime) {
                    return new Time((ASN1GeneralizedTime) obj);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unknown object in factory: ");
                stringBuilder.append(obj.getClass().getName());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return (Time) obj;
    }

    /* renamed from: a */
    public String m40458a() {
        if (this.f31405a instanceof ASN1UTCTime) {
            return ((ASN1UTCTime) this.f31405a).m43043g();
        }
        return ((ASN1GeneralizedTime) this.f31405a).m42960b();
    }

    /* renamed from: b */
    public Date m40459b() {
        try {
            if (this.f31405a instanceof ASN1UTCTime) {
                return ((ASN1UTCTime) this.f31405a).m43040b();
            }
            return ((ASN1GeneralizedTime) this.f31405a).m42961c();
        } catch (ParseException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid date string: ");
            stringBuilder.append(e.getMessage());
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* renamed from: e */
    public ASN1Primitive mo5709e() {
        return this.f31405a;
    }

    public String toString() {
        return m40458a();
    }
}
