package org.spongycastle.asn1.cryptopro;

import com.facebook.appevents.AppEventsConstants;
import java.math.BigInteger;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECCurve.Fp;

public class ECGOST3410NamedCurves {
    /* renamed from: a */
    static final Hashtable f21581a = new Hashtable();
    /* renamed from: b */
    static final Hashtable f21582b = new Hashtable();
    /* renamed from: c */
    static final Hashtable f21583c = new Hashtable();

    static {
        BigInteger bigInteger = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
        BigInteger bigInteger2 = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
        ECCurve fp = new Fp(bigInteger, new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316"), new BigInteger("166"), bigInteger2, ECConstants.f23076d);
        f21582b.put(CryptoProObjectIdentifiers.f21575u, new ECDomainParameters(fp, fp.m28376b(new BigInteger(AppEventsConstants.EVENT_PARAM_VALUE_YES), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612")), bigInteger2));
        BigInteger bigInteger3 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
        bigInteger2 = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
        ECCurve fp2 = new Fp(bigInteger3, new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316"), new BigInteger("166"), bigInteger2, ECConstants.f23076d);
        f21582b.put(CryptoProObjectIdentifiers.f21578x, new ECDomainParameters(fp2, fp2.m28376b(new BigInteger(AppEventsConstants.EVENT_PARAM_VALUE_YES), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612")), bigInteger2));
        bigInteger3 = new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823193");
        bigInteger2 = new BigInteger("57896044618658097711785492504343953927102133160255826820068844496087732066703");
        fp2 = new Fp(bigInteger3, new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823190"), new BigInteger("28091019353058090096996979000309560759124368558014865957655842872397301267595"), bigInteger2, ECConstants.f23076d);
        f21582b.put(CryptoProObjectIdentifiers.f21576v, new ECDomainParameters(fp2, fp2.m28376b(new BigInteger(AppEventsConstants.EVENT_PARAM_VALUE_YES), new BigInteger("28792665814854611296992347458380284135028636778229113005756334730996303888124")), bigInteger2));
        bigInteger3 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
        bigInteger2 = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
        fp2 = new Fp(bigInteger3, new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502616"), new BigInteger("32858"), bigInteger2, ECConstants.f23076d);
        f21582b.put(CryptoProObjectIdentifiers.f21579y, new ECDomainParameters(fp2, fp2.m28376b(new BigInteger(AppEventsConstants.EVENT_PARAM_VALUE_NO), new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247")), bigInteger2));
        bigInteger3 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
        bigInteger2 = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
        fp2 = new Fp(bigInteger3, new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502616"), new BigInteger("32858"), bigInteger2, ECConstants.f23076d);
        f21582b.put(CryptoProObjectIdentifiers.f21577w, new ECDomainParameters(fp2, fp2.m28376b(new BigInteger(AppEventsConstants.EVENT_PARAM_VALUE_NO), new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247")), bigInteger2));
        f21581a.put("GostR3410-2001-CryptoPro-A", CryptoProObjectIdentifiers.f21575u);
        f21581a.put("GostR3410-2001-CryptoPro-B", CryptoProObjectIdentifiers.f21576v);
        f21581a.put("GostR3410-2001-CryptoPro-C", CryptoProObjectIdentifiers.f21577w);
        f21581a.put("GostR3410-2001-CryptoPro-XchA", CryptoProObjectIdentifiers.f21578x);
        f21581a.put("GostR3410-2001-CryptoPro-XchB", CryptoProObjectIdentifiers.f21579y);
        f21583c.put(CryptoProObjectIdentifiers.f21575u, "GostR3410-2001-CryptoPro-A");
        f21583c.put(CryptoProObjectIdentifiers.f21576v, "GostR3410-2001-CryptoPro-B");
        f21583c.put(CryptoProObjectIdentifiers.f21577w, "GostR3410-2001-CryptoPro-C");
        f21583c.put(CryptoProObjectIdentifiers.f21578x, "GostR3410-2001-CryptoPro-XchA");
        f21583c.put(CryptoProObjectIdentifiers.f21579y, "GostR3410-2001-CryptoPro-XchB");
    }

    /* renamed from: a */
    public static ECDomainParameters m27181a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (ECDomainParameters) f21582b.get(aSN1ObjectIdentifier);
    }

    /* renamed from: a */
    public static ECDomainParameters m27180a(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) f21581a.get(str);
        return aSN1ObjectIdentifier != null ? (ECDomainParameters) f21582b.get(aSN1ObjectIdentifier) : null;
    }

    /* renamed from: b */
    public static String m27182b(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String) f21583c.get(aSN1ObjectIdentifier);
    }

    /* renamed from: b */
    public static ASN1ObjectIdentifier m27183b(String str) {
        return (ASN1ObjectIdentifier) f21581a.get(str);
    }
}
