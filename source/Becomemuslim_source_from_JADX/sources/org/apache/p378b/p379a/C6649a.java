package org.apache.p378b.p379a;

import java.io.Serializable;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.p378b.p379a.p381c.C6655i;

/* compiled from: Level */
/* renamed from: org.apache.b.a.a */
public final class C6649a implements Serializable, Comparable<C6649a> {
    /* renamed from: a */
    public static final C6649a f21364a = new C6649a("OFF", C6655i.OFF.m27088a());
    /* renamed from: b */
    public static final C6649a f21365b = new C6649a("FATAL", C6655i.FATAL.m27088a());
    /* renamed from: c */
    public static final C6649a f21366c = new C6649a("ERROR", C6655i.ERROR.m27088a());
    /* renamed from: d */
    public static final C6649a f21367d = new C6649a("WARN", C6655i.WARN.m27088a());
    /* renamed from: e */
    public static final C6649a f21368e = new C6649a("INFO", C6655i.INFO.m27088a());
    /* renamed from: f */
    public static final C6649a f21369f = new C6649a("DEBUG", C6655i.DEBUG.m27088a());
    /* renamed from: g */
    public static final C6649a f21370g = new C6649a("TRACE", C6655i.TRACE.m27088a());
    /* renamed from: h */
    public static final C6649a f21371h = new C6649a("ALL", C6655i.ALL.m27088a());
    /* renamed from: i */
    private static final ConcurrentMap<String, C6649a> f21372i = new ConcurrentHashMap();
    private static final long serialVersionUID = 1581082;
    /* renamed from: j */
    private final String f21373j;
    /* renamed from: k */
    private final int f21374k;
    /* renamed from: l */
    private final C6655i f21375l;

    public /* synthetic */ Object clone() {
        return m27074b();
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m27073b((C6649a) obj);
    }

    private C6649a(String str, int i) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Illegal null Level constant");
        } else if (i >= 0) {
            this.f21373j = str;
            this.f21374k = i;
            this.f21375l = C6655i.m27087a(i);
            if (f21372i.putIfAbsent(str, this) != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Level ");
                stringBuilder.append(str);
                stringBuilder.append(" has already been defined.");
                throw new IllegalStateException(stringBuilder.toString());
            }
        } else {
            throw new IllegalArgumentException("Illegal Level int less than zero.");
        }
    }

    /* renamed from: a */
    public int m27071a() {
        return this.f21374k;
    }

    /* renamed from: a */
    public boolean m27072a(C6649a c6649a) {
        return this.f21374k <= c6649a.f21374k ? true : null;
    }

    /* renamed from: b */
    public C6649a m27074b() {
        throw new CloneNotSupportedException();
    }

    /* renamed from: b */
    public int m27073b(C6649a c6649a) {
        if (this.f21374k < c6649a.f21374k) {
            return -1;
        }
        return this.f21374k > c6649a.f21374k ? 1 : null;
    }

    public boolean equals(Object obj) {
        return ((obj instanceof C6649a) && obj == this) ? true : null;
    }

    public int hashCode() {
        return this.f21373j.hashCode();
    }

    public String toString() {
        return this.f21373j;
    }

    /* renamed from: a */
    public static C6649a m27070a(String str, C6649a c6649a) {
        if (str == null) {
            return c6649a;
        }
        str = (C6649a) f21372i.get(str.toUpperCase(Locale.ENGLISH));
        if (str == null) {
            str = c6649a;
        }
        return str;
    }

    /* renamed from: a */
    public static C6649a m27069a(String str) {
        if (str != null) {
            str = str.toUpperCase(Locale.ENGLISH);
            if (f21372i.containsKey(str)) {
                return (C6649a) f21372i.get(str);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown level constant [");
            stringBuilder.append(str);
            stringBuilder.append("].");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new NullPointerException("No level name given.");
    }

    protected Object readResolve() {
        return C6649a.m27069a(this.f21373j);
    }
}
