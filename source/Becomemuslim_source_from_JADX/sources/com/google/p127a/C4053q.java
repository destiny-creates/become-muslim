package com.google.p127a;

import com.google.p127a.p129b.C2128a;
import com.google.p127a.p129b.C2135f;
import java.math.BigInteger;

/* compiled from: JsonPrimitive */
/* renamed from: com.google.a.q */
public final class C4053q extends C2162l {
    /* renamed from: a */
    private static final Class<?>[] f10125a = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    /* renamed from: b */
    private Object f10126b;

    public C4053q(Boolean bool) {
        m12478a((Object) bool);
    }

    public C4053q(Number number) {
        m12478a((Object) number);
    }

    public C4053q(String str) {
        m12478a((Object) str);
    }

    /* renamed from: a */
    void m12478a(Object obj) {
        if (obj instanceof Character) {
            this.f10126b = String.valueOf(((Character) obj).charValue());
            return;
        }
        boolean z;
        if (!(obj instanceof Number)) {
            if (!C4053q.m12476b(obj)) {
                z = false;
                C2128a.m5835a(z);
                this.f10126b = obj;
            }
        }
        z = true;
        C2128a.m5835a(z);
        this.f10126b = obj;
    }

    /* renamed from: o */
    public boolean m12485o() {
        return this.f10126b instanceof Boolean;
    }

    /* renamed from: n */
    Boolean mo2037n() {
        return (Boolean) this.f10126b;
    }

    /* renamed from: f */
    public boolean mo2036f() {
        if (m12485o()) {
            return mo2037n().booleanValue();
        }
        return Boolean.parseBoolean(mo2032b());
    }

    /* renamed from: p */
    public boolean m12486p() {
        return this.f10126b instanceof Number;
    }

    /* renamed from: a */
    public Number mo2031a() {
        return this.f10126b instanceof String ? new C2135f((String) this.f10126b) : (Number) this.f10126b;
    }

    /* renamed from: q */
    public boolean m12487q() {
        return this.f10126b instanceof String;
    }

    /* renamed from: b */
    public String mo2032b() {
        if (m12486p()) {
            return mo2031a().toString();
        }
        if (m12485o()) {
            return mo2037n().toString();
        }
        return (String) this.f10126b;
    }

    /* renamed from: c */
    public double mo2033c() {
        return m12486p() ? mo2031a().doubleValue() : Double.parseDouble(mo2032b());
    }

    /* renamed from: d */
    public long mo2034d() {
        return m12486p() ? mo2031a().longValue() : Long.parseLong(mo2032b());
    }

    /* renamed from: e */
    public int mo2035e() {
        return m12486p() ? mo2031a().intValue() : Integer.parseInt(mo2032b());
    }

    /* renamed from: b */
    private static boolean m12476b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        obj = obj.getClass();
        for (Class isAssignableFrom : f10125a) {
            if (isAssignableFrom.isAssignableFrom(obj)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f10126b == null) {
            return 31;
        }
        long longValue;
        if (C4053q.m12475a(this)) {
            longValue = mo2031a().longValue();
            return (int) ((longValue >>> 32) ^ longValue);
        } else if (!(this.f10126b instanceof Number)) {
            return this.f10126b.hashCode();
        } else {
            longValue = Double.doubleToLongBits(mo2031a().doubleValue());
            return (int) ((longValue >>> 32) ^ longValue);
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C4053q c4053q = (C4053q) obj;
                if (this.f10126b == null) {
                    if (c4053q.f10126b != null) {
                        z = false;
                    }
                    return z;
                } else if (C4053q.m12475a(this) && C4053q.m12475a(c4053q)) {
                    if (mo2031a().longValue() != c4053q.mo2031a().longValue()) {
                        z = false;
                    }
                    return z;
                } else if (!(this.f10126b instanceof Number) || !(c4053q.f10126b instanceof Number)) {
                    return this.f10126b.equals(c4053q.f10126b);
                } else {
                    double doubleValue = mo2031a().doubleValue();
                    double doubleValue2 = c4053q.mo2031a().doubleValue();
                    if (doubleValue != doubleValue2) {
                        if (Double.isNaN(doubleValue) == null || Double.isNaN(doubleValue2) == null) {
                            z = false;
                        }
                    }
                    return z;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m12475a(C4053q c4053q) {
        boolean z = false;
        if (!(c4053q.f10126b instanceof Number)) {
            return false;
        }
        Number number = (Number) c4053q.f10126b;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte) != null) {
            z = true;
        }
        return z;
    }
}
