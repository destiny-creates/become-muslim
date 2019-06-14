package com.google.android.gms.internal.p210i;

import com.google.android.gms.common.internal.C2872v;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.bl */
public class bl extends C6797o {
    /* renamed from: a */
    private static bl f28805a;

    public bl(C5008q c5008q) {
        super(c5008q);
    }

    /* renamed from: a */
    protected final void mo6145a() {
        synchronized (bl.class) {
            f28805a = this;
        }
    }

    /* renamed from: b */
    public static bl m37751b() {
        return f28805a;
    }

    /* renamed from: a */
    public final void m37754a(bg bgVar, String str) {
        bgVar = bgVar != null ? bgVar.toString() : "no hit data";
        String str2 = "Discarding hit. ";
        str = String.valueOf(str);
        m21034d(str.length() != 0 ? str2.concat(str) : new String(str2), bgVar);
    }

    /* renamed from: a */
    public final void m37755a(Map<String, String> map, String str) {
        if (map != null) {
            StringBuilder stringBuilder = new StringBuilder();
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(',');
                }
                stringBuilder.append((String) entry.getKey());
                stringBuilder.append('=');
                stringBuilder.append((String) entry.getValue());
            }
            map = stringBuilder.toString();
        } else {
            map = "no hit data";
        }
        String str2 = "Discarding hit. ";
        str = String.valueOf(str);
        m21034d(str.length() != 0 ? str2.concat(str) : new String(str2), map);
    }

    /* renamed from: a */
    public final synchronized void mo6146a(int i, String str, Object obj, Object obj2, Object obj3) {
        C2872v.a(str);
        if (i < 0) {
            i = 0;
        }
        if (i >= 9) {
            i = 8;
        }
        char c = m21046m().m20297a() ? 'C' : 'c';
        i = "01VDIWEA?".charAt(i);
        String str2 = C5007p.f16813a;
        str = C5006n.m21024c(str, bl.m37750a(obj), bl.m37750a(obj2), bl.m37750a(obj3));
        obj2 = new StringBuilder((String.valueOf(str2).length() + 4) + String.valueOf(str).length());
        obj2.append("3");
        obj2.append(i);
        obj2.append(c);
        obj2.append(str2);
        obj2.append(":");
        obj2.append(str);
        i = obj2.toString();
        if (i.length() > 1024) {
            i = i.substring(0, 1024);
        }
        str = m21041i().m21071m();
        if (str != null) {
            str.m37778g().m20351a(i);
        }
    }

    /* renamed from: a */
    private static String m37750a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            obj = String.valueOf(obj).charAt(0) == 45 ? "-" : "";
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(obj);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1))));
            stringBuilder.append("...");
            stringBuilder.append(obj);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d));
            return stringBuilder.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            return obj instanceof Throwable ? obj.getClass().getCanonicalName() : "-";
        }
    }
}
