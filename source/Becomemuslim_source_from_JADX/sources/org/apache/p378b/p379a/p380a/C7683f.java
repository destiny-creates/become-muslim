package org.apache.p378b.p379a.p380a;

/* compiled from: SimpleMessage */
/* renamed from: org.apache.b.a.a.f */
public class C7683f implements C6647b {
    private static final long serialVersionUID = -8398002534962715992L;
    /* renamed from: a */
    private final String f26430a;

    /* renamed from: b */
    public Object[] mo5700b() {
        return null;
    }

    /* renamed from: c */
    public Throwable mo5701c() {
        return null;
    }

    public C7683f() {
        this(null);
    }

    public C7683f(String str) {
        this.f26430a = str;
    }

    /* renamed from: a */
    public String mo5699a() {
        return this.f26430a;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C7683f c7683f = (C7683f) obj;
                if (this.f26430a != null) {
                    if (this.f26430a.equals(c7683f.f26430a) == null) {
                    }
                    return z;
                } else if (c7683f.f26430a == null) {
                    return z;
                }
                z = false;
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f26430a != null ? this.f26430a.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SimpleMessage[message=");
        stringBuilder.append(this.f26430a);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
