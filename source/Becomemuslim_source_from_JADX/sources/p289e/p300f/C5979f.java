package p289e.p300f;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: RxJavaPlugins */
/* renamed from: e.f.f */
public class C5979f {
    /* renamed from: a */
    static final C5976b f19768a = new C73501();
    /* renamed from: b */
    private static final C5979f f19769b = new C5979f();
    /* renamed from: c */
    private final AtomicReference<C5976b> f19770c = new AtomicReference();
    /* renamed from: d */
    private final AtomicReference<C5978d> f19771d = new AtomicReference();
    /* renamed from: e */
    private final AtomicReference<C5981h> f19772e = new AtomicReference();
    /* renamed from: f */
    private final AtomicReference<C5975a> f19773f = new AtomicReference();
    /* renamed from: g */
    private final AtomicReference<C5980g> f19774g = new AtomicReference();

    /* compiled from: RxJavaPlugins */
    /* renamed from: e.f.f$1 */
    static class C73501 extends C5976b {
        C73501() {
        }
    }

    /* compiled from: RxJavaPlugins */
    /* renamed from: e.f.f$2 */
    class C73512 extends C5975a {
        /* renamed from: a */
        final /* synthetic */ C5979f f25748a;

        C73512(C5979f c5979f) {
            this.f25748a = c5979f;
        }
    }

    @Deprecated
    /* renamed from: a */
    public static C5979f m25082a() {
        return f19769b;
    }

    C5979f() {
    }

    /* renamed from: b */
    public C5976b m25084b() {
        if (this.f19770c.get() == null) {
            Object a = C5979f.m25083a(C5976b.class, System.getProperties());
            if (a == null) {
                this.f19770c.compareAndSet(null, f19768a);
            } else {
                this.f19770c.compareAndSet(null, (C5976b) a);
            }
        }
        return (C5976b) this.f19770c.get();
    }

    /* renamed from: c */
    public C5978d m25085c() {
        if (this.f19771d.get() == null) {
            Object a = C5979f.m25083a(C5978d.class, System.getProperties());
            if (a == null) {
                this.f19771d.compareAndSet(null, C7349e.m33741a());
            } else {
                this.f19771d.compareAndSet(null, (C5978d) a);
            }
        }
        return (C5978d) this.f19771d.get();
    }

    /* renamed from: d */
    public C5981h m25086d() {
        if (this.f19772e.get() == null) {
            Object a = C5979f.m25083a(C5981h.class, System.getProperties());
            if (a == null) {
                this.f19772e.compareAndSet(null, C7352i.m33742a());
            } else {
                this.f19772e.compareAndSet(null, (C5981h) a);
            }
        }
        return (C5981h) this.f19772e.get();
    }

    /* renamed from: e */
    public C5975a m25087e() {
        if (this.f19773f.get() == null) {
            Object a = C5979f.m25083a(C5975a.class, System.getProperties());
            if (a == null) {
                this.f19773f.compareAndSet(null, new C73512(this));
            } else {
                this.f19773f.compareAndSet(null, (C5975a) a);
            }
        }
        return (C5975a) this.f19773f.get();
    }

    /* renamed from: a */
    static Object m25083a(Class<?> cls, Properties properties) {
        StringBuilder stringBuilder;
        properties = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String str = "rxjava.plugin.";
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(simpleName);
        stringBuilder2.append(".implementation");
        String property = properties.getProperty(stringBuilder2.toString());
        if (property == null) {
            String str2 = ".class";
            String str3 = ".impl";
            for (Entry entry : properties.entrySet()) {
                String obj = entry.getKey().toString();
                if (obj.startsWith(str) && obj.endsWith(str2) && simpleName.equals(entry.getValue().toString())) {
                    property = obj.substring(0, obj.length() - str2.length()).substring(str.length());
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(str);
                    stringBuilder3.append(property);
                    stringBuilder3.append(str3);
                    str = stringBuilder3.toString();
                    property = properties.getProperty(str);
                    if (property == null) {
                        properties = new StringBuilder();
                        properties.append("Implementing class declaration for ");
                        properties.append(simpleName);
                        properties.append(" missing: ");
                        properties.append(str);
                        throw new IllegalStateException(properties.toString());
                    }
                }
            }
        }
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (Class<?> cls2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(simpleName);
            stringBuilder.append(" implementation is not an instance of ");
            stringBuilder.append(simpleName);
            stringBuilder.append(": ");
            stringBuilder.append(property);
            throw new IllegalStateException(stringBuilder.toString(), cls2);
        } catch (Class<?> cls22) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(simpleName);
            stringBuilder.append(" implementation class not found: ");
            stringBuilder.append(property);
            throw new IllegalStateException(stringBuilder.toString(), cls22);
        } catch (Class<?> cls222) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(simpleName);
            stringBuilder.append(" implementation not able to be instantiated: ");
            stringBuilder.append(property);
            throw new IllegalStateException(stringBuilder.toString(), cls222);
        } catch (Class<?> cls2222) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(simpleName);
            stringBuilder.append(" implementation not able to be accessed: ");
            stringBuilder.append(property);
            throw new IllegalStateException(stringBuilder.toString(), cls2222);
        }
    }

    /* renamed from: f */
    public C5980g m25088f() {
        if (this.f19774g.get() == null) {
            Object a = C5979f.m25083a(C5980g.class, System.getProperties());
            if (a == null) {
                this.f19774g.compareAndSet(null, C5980g.m25095g());
            } else {
                this.f19774g.compareAndSet(null, (C5980g) a);
            }
        }
        return (C5980g) this.f19774g.get();
    }
}
