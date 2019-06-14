package android.arch.lifecycle;

/* compiled from: ViewModelProvider */
/* renamed from: android.arch.lifecycle.o */
public class C0087o {
    /* renamed from: a */
    private final C0086a f214a;
    /* renamed from: b */
    private final C0088p f215b;

    /* compiled from: ViewModelProvider */
    /* renamed from: android.arch.lifecycle.o$a */
    public interface C0086a {
        /* renamed from: a */
        <T extends C0085n> T mo172a(Class<T> cls);
    }

    public C0087o(C0088p c0088p, C0086a c0086a) {
        this.f214a = c0086a;
        this.f215b = c0088p;
    }

    /* renamed from: a */
    public <T extends C0085n> T m202a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("android.arch.lifecycle.ViewModelProvider.DefaultKey:");
            stringBuilder.append(canonicalName);
            return m203a(stringBuilder.toString(), cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* renamed from: a */
    public <T extends C0085n> T m203a(String str, Class<T> cls) {
        T a = this.f215b.m204a(str);
        if (cls.isInstance(a)) {
            return a;
        }
        cls = this.f214a.mo172a(cls);
        this.f215b.m206a(str, cls);
        return cls;
    }
}
