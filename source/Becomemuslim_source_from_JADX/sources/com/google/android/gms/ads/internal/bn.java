package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.facebook.applinks.AppLinkData;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.internal.ads.aoq;
import com.google.android.gms.internal.ads.aou;
import com.google.android.gms.internal.ads.cm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

@cm
public final class bn {
    /* renamed from: a */
    private static String m7502a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            String a = obj == null ? "null" : obj instanceof Bundle ? m7502a((Bundle) obj) : obj.toString();
            stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static Object[] m7503a(String str, aoq aoq, String str2, int i, aou aou) {
        Set hashSet = new HashSet(Arrays.asList(str.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        if (hashSet.contains("formatString")) {
            arrayList.add(null);
        }
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(aoq.f28262b));
        }
        if (hashSet.contains(AppLinkData.ARGUMENTS_EXTRAS_KEY)) {
            arrayList.add(m7502a(aoq.f28263c));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(aoq.f28264d));
        }
        if (hashSet.contains("keywords")) {
            if (aoq.f28265e != null) {
                arrayList.add(aoq.f28265e.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(aoq.f28266f));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(aoq.f28267g));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(aoq.f28268h));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(aoq.f28269i);
        }
        if (hashSet.contains(PlaceFields.LOCATION)) {
            if (aoq.f28271k != null) {
                arrayList.add(aoq.f28271k.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(aoq.f28272l);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(m7502a(aoq.f28273m));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(m7502a(aoq.f28274n));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (aoq.f28275o != null) {
                arrayList.add(aoq.f28275o.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(aoq.f28276p);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(aoq.f28277q);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(aoq.f28278r));
        }
        return arrayList.toArray();
    }
}
