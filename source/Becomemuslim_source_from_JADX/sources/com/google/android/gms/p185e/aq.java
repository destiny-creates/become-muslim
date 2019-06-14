package com.google.android.gms.p185e;

import com.google.android.gms.internal.p210i.ct;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.e.aq */
abstract class aq {
    /* renamed from: a */
    private final Set<String> f7456a;
    /* renamed from: b */
    private final String f7457b;

    /* renamed from: a */
    public abstract ct mo2506a(Map<String, ct> map);

    /* renamed from: a */
    public abstract boolean mo2507a();

    /* renamed from: b */
    public String mo2512b() {
        return this.f7457b;
    }

    public aq(String str, String... strArr) {
        this.f7457b = str;
        this.f7456a = new HashSet(strArr.length);
        for (Object add : strArr) {
            this.f7456a.add(add);
        }
    }

    /* renamed from: c */
    public Set<String> mo2513c() {
        return this.f7456a;
    }

    /* renamed from: a */
    final boolean m8555a(Set<String> set) {
        return set.containsAll(this.f7456a);
    }
}
