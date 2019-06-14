package org.apache.p371a.p372a;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: OptionGroup */
/* renamed from: org.apache.a.a.i */
public class C6632i implements Serializable {
    private static final long serialVersionUID = 1;
    /* renamed from: a */
    private Map f21319a = new HashMap();
    /* renamed from: b */
    private String f21320b;
    /* renamed from: c */
    private boolean f21321c;

    /* renamed from: a */
    public Collection m27006a() {
        return this.f21319a.values();
    }

    /* renamed from: a */
    public void m27007a(C6631h c6631h) {
        if (this.f21320b != null) {
            if (!this.f21320b.equals(c6631h.m26992b())) {
                throw new C7675a(this, c6631h);
            }
        }
        this.f21320b = c6631h.m26992b();
    }

    /* renamed from: b */
    public String m27008b() {
        return this.f21320b;
    }

    /* renamed from: c */
    public boolean m27009c() {
        return this.f21321c;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = m27006a().iterator();
        stringBuffer.append("[");
        while (it.hasNext()) {
            C6631h c6631h = (C6631h) it.next();
            if (c6631h.m26992b() != null) {
                stringBuffer.append("-");
                stringBuffer.append(c6631h.m26992b());
            } else {
                stringBuffer.append("--");
                stringBuffer.append(c6631h.m26993c());
            }
            stringBuffer.append(" ");
            stringBuffer.append(c6631h.m26997g());
            if (it.hasNext()) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
