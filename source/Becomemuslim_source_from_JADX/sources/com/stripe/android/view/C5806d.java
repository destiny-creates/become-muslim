package com.stripe.android.view;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: CountryUtils */
/* renamed from: com.stripe.android.view.d */
class C5806d {
    /* renamed from: a */
    static final String[] f19236a = new String[]{"AE", "AG", "AN", "AO", "AW", "BF", "BI", "BJ", "BO", "BS", "BW", "BZ", "CD", "CF", "CG", "CI", "CK", "CM", "DJ", "DM", "ER", "FJ", "GD", "GH", "GM", "GN", "GQ", "GY", "HK", "IE", "JM", "KE", "KI", "KM", "KN", "KP", "LC", "ML", "MO", "MR", "MS", "MU", "MW", "NR", "NU", "PA", "QA", "RW", "SA", "SB", "SC", "SL", "SO", "SR", "ST", "SY", "TF", "TK", "TL", "TO", "TT", "TV", "TZ", "UG", "VU", "YE", "ZA", "ZW"};
    /* renamed from: b */
    static final Set<String> f19237b = new HashSet(Arrays.asList(f19236a));

    /* renamed from: a */
    static boolean m24505a(String str) {
        return f19237b.contains(str) ^ 1;
    }

    /* renamed from: b */
    static boolean m24506b(String str) {
        return Pattern.matches("^[0-9]{5}(?:-[0-9]{4})?$", str);
    }

    /* renamed from: a */
    static Map<String, String> m24504a() {
        Map<String, String> hashMap = new HashMap();
        for (String str : Locale.getISOCountries()) {
            hashMap.put(new Locale("", str).getDisplayCountry(), str);
        }
        return hashMap;
    }
}
