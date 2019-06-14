package com.google.android.gms.internal.p210i;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.google.android.gms.common.internal.C2872v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.bg */
public final class bg {
    /* renamed from: a */
    private final Map<String, String> f16410a;
    /* renamed from: b */
    private final List<am> f16411b;
    /* renamed from: c */
    private final long f16412c;
    /* renamed from: d */
    private final long f16413d;
    /* renamed from: e */
    private final int f16414e;
    /* renamed from: f */
    private final boolean f16415f;
    /* renamed from: g */
    private final String f16416g;

    public bg(C5006n c5006n, Map<String, String> map, long j, boolean z) {
        this(c5006n, map, j, z, 0, 0, null);
    }

    public bg(C5006n c5006n, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(c5006n, map, j, z, j2, i, null);
    }

    public bg(C5006n c5006n, Map<String, String> map, long j, boolean z, long j2, int i, List<am> list) {
        CharSequence b;
        C2872v.a(c5006n);
        C2872v.a(map);
        this.f16413d = j;
        this.f16415f = z;
        this.f16412c = j2;
        this.f16414e = i;
        if (list != null) {
            j = list;
        } else {
            j = Collections.emptyList();
        }
        this.f16411b = j;
        j = null;
        if (list != null) {
            for (am amVar : list) {
                if ("appendVersion".equals(amVar.m20279a()) != null) {
                    b = amVar.m20280b();
                    break;
                }
            }
        }
        b = null;
        if (!TextUtils.isEmpty(b)) {
            j = b;
        }
        this.f16416g = j;
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (bg.m20318a(entry.getKey()) != null) {
                j2 = bg.m20316a(c5006n, entry.getKey());
                if (j2 != null) {
                    hashMap.put(j2, bg.m20319b(c5006n, entry.getValue()));
                }
            }
        }
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry2 = (Entry) map.next();
            if (!bg.m20318a(entry2.getKey())) {
                z = bg.m20316a(c5006n, entry2.getKey());
                if (z) {
                    hashMap.put(z, bg.m20319b(c5006n, entry2.getValue()));
                }
            }
        }
        if (TextUtils.isEmpty(this.f16416g) == null) {
            bz.m20373a(hashMap, "_v", this.f16416g);
            if (!(this.f16416g.equals("ma4.0.0") == null && this.f16416g.equals("ma4.0.1") == null)) {
                hashMap.remove("adid");
            }
        }
        this.f16410a = Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: a */
    private static boolean m20318a(Object obj) {
        return obj == null ? null : obj.toString().startsWith("&");
    }

    /* renamed from: a */
    private static String m20316a(C5006n c5006n, Object obj) {
        if (obj == null) {
            return null;
        }
        obj = obj.toString();
        if (obj.startsWith("&")) {
            obj = obj.substring(1);
        }
        int length = obj.length();
        if (length > 256) {
            obj = obj.substring(0, 256);
            c5006n.m21033c("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj);
        }
        if (TextUtils.isEmpty(obj) != null) {
            return null;
        }
        return obj;
    }

    /* renamed from: b */
    private static String m20319b(C5006n c5006n, Object obj) {
        obj = obj == null ? "" : obj.toString();
        int length = obj.length();
        if (length <= Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            return obj;
        }
        obj = obj.substring(0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        c5006n.m21033c("Hit param value is too long and will be trimmed", Integer.valueOf(length), obj);
        return obj;
    }

    /* renamed from: a */
    public final int m20320a() {
        return this.f16414e;
    }

    /* renamed from: b */
    public final Map<String, String> m20321b() {
        return this.f16410a;
    }

    /* renamed from: c */
    public final long m20322c() {
        return this.f16412c;
    }

    /* renamed from: d */
    public final long m20323d() {
        return this.f16413d;
    }

    /* renamed from: e */
    public final List<am> m20324e() {
        return this.f16411b;
    }

    /* renamed from: f */
    public final boolean m20325f() {
        return this.f16415f;
    }

    /* renamed from: g */
    public final long m20326g() {
        return bz.m20380b(m20317a("_s", AppEventsConstants.EVENT_PARAM_VALUE_NO));
    }

    /* renamed from: h */
    public final String m20327h() {
        return m20317a("_m", "");
    }

    /* renamed from: a */
    private final String m20317a(String str, String str2) {
        C2872v.a(str);
        C2872v.b(str.startsWith("&") ^ 1, "Short param name required");
        str = (String) this.f16410a.get(str);
        return str != null ? str : str2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ht=");
        stringBuilder.append(this.f16413d);
        if (this.f16412c != 0) {
            stringBuilder.append(", dbId=");
            stringBuilder.append(this.f16412c);
        }
        if (this.f16414e != 0) {
            stringBuilder.append(", appUID=");
            stringBuilder.append(this.f16414e);
        }
        List arrayList = new ArrayList(this.f16410a.keySet());
        Collections.sort(arrayList);
        ArrayList arrayList2 = (ArrayList) arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            String str = (String) obj;
            stringBuilder.append(", ");
            stringBuilder.append(str);
            stringBuilder.append("=");
            stringBuilder.append((String) this.f16410a.get(str));
        }
        return stringBuilder.toString();
    }
}
