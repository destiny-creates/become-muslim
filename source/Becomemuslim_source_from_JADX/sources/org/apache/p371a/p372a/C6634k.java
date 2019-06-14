package org.apache.p371a.p372a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Options */
/* renamed from: org.apache.a.a.k */
public class C6634k implements Serializable {
    private static final long serialVersionUID = 1;
    /* renamed from: a */
    private Map f21322a = new HashMap();
    /* renamed from: b */
    private Map f21323b = new HashMap();
    /* renamed from: c */
    private List f21324c = new ArrayList();
    /* renamed from: d */
    private Map f21325d = new HashMap();

    /* renamed from: a */
    public C6634k m27015a(C6631h c6631h) {
        String a = c6631h.m26990a();
        if (c6631h.m26995e()) {
            this.f21323b.put(c6631h.m26993c(), c6631h);
        }
        if (c6631h.m26998h()) {
            if (this.f21324c.contains(a)) {
                this.f21324c.remove(this.f21324c.indexOf(a));
            }
            this.f21324c.add(a);
        }
        this.f21322a.put(a, c6631h);
        return this;
    }

    /* renamed from: a */
    List m27013a() {
        return new ArrayList(this.f21322a.values());
    }

    /* renamed from: b */
    public List m27016b() {
        return this.f21324c;
    }

    /* renamed from: a */
    public C6631h m27014a(String str) {
        str = C6636o.m27019a(str);
        if (this.f21322a.containsKey(str)) {
            return (C6631h) this.f21322a.get(str);
        }
        return (C6631h) this.f21323b.get(str);
    }

    /* renamed from: b */
    public boolean m27018b(String str) {
        str = C6636o.m27019a(str);
        if (!this.f21322a.containsKey(str)) {
            if (this.f21323b.containsKey(str) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: b */
    public C6632i m27017b(C6631h c6631h) {
        return (C6632i) this.f21325d.get(c6631h.m26990a());
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ Options: [ short ");
        stringBuffer.append(this.f21322a.toString());
        stringBuffer.append(" ] [ long ");
        stringBuffer.append(this.f21323b);
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }
}
