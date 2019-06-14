package org.apache.p371a.p372a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: GnuParser */
/* renamed from: org.apache.a.a.d */
public class C8190d extends C7678m {
    /* renamed from: b */
    protected String[] mo6422b(C6634k c6634k, String[] strArr, boolean z) {
        List arrayList = new ArrayList();
        int i = 0;
        boolean z2 = false;
        while (i < strArr.length) {
            String str = strArr[i];
            if ("--".equals(str)) {
                arrayList.add("--");
                z2 = true;
            } else if ("-".equals(str)) {
                arrayList.add("-");
            } else if (str.startsWith("-")) {
                String a = C6636o.m27019a(str);
                if (c6634k.m27018b(a)) {
                    arrayList.add(str);
                } else if (a.indexOf(61) != -1 && c6634k.m27018b(a.substring(0, a.indexOf(61)))) {
                    arrayList.add(str.substring(0, str.indexOf(61)));
                    arrayList.add(str.substring(str.indexOf(61) + 1));
                } else if (c6634k.m27018b(str.substring(0, 2))) {
                    arrayList.add(str.substring(0, 2));
                    arrayList.add(str.substring(2));
                } else {
                    arrayList.add(str);
                    z2 = z;
                }
            } else {
                arrayList.add(str);
            }
            if (z2) {
                while (true) {
                    i++;
                    if (i >= strArr.length) {
                        break;
                    }
                    arrayList.add(strArr[i]);
                }
            }
            i++;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
