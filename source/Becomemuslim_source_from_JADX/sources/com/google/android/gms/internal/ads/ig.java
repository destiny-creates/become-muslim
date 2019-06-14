package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.util.C2904o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(21)
@cm
final class ig {
    /* renamed from: a */
    private static final Map<String, String> f15538a;
    /* renamed from: b */
    private final Context f15539b;
    /* renamed from: c */
    private final List<String> f15540c;
    /* renamed from: d */
    private final hs f15541d;

    static {
        Map hashMap = new HashMap();
        if (C2904o.i()) {
            hashMap.put("android.webkit.resource.AUDIO_CAPTURE", "android.permission.RECORD_AUDIO");
            hashMap.put("android.webkit.resource.VIDEO_CAPTURE", "android.permission.CAMERA");
        }
        f15538a = hashMap;
    }

    ig(Context context, List<String> list, hs hsVar) {
        this.f15539b = context;
        this.f15540c = list;
        this.f15541d = hsVar;
    }

    /* renamed from: a */
    final List<String> m19527a(String[] strArr) {
        List<String> arrayList = new ArrayList();
        for (String str : strArr) {
            Object obj;
            Iterator it = this.f15540c.iterator();
            String valueOf;
            String str2;
            do {
                Object obj2 = 1;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                str2 = (String) it.next();
                if (str2.equals(str)) {
                    break;
                }
                valueOf = String.valueOf("android.webkit.resource.");
                str2 = String.valueOf(str2);
            } while (!(str2.length() != 0 ? valueOf.concat(str2) : new String(valueOf)).equals(str));
            obj = 1;
            if (obj != null) {
                if (f15538a.containsKey(str)) {
                    ax.e();
                    if (!jw.m19707a(this.f15539b, (String) f15538a.get(str))) {
                        obj2 = null;
                    }
                }
                if (obj2 != null) {
                    arrayList.add(str);
                } else {
                    this.f15541d.m30805c(str);
                }
            } else {
                this.f15541d.m30802b(str);
            }
        }
        return arrayList;
    }
}
