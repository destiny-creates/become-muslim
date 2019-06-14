package host.exp.exponent.p336c;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import host.exp.exponent.C6356f;
import host.exp.exponent.C6369g;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p339f.C6329a;
import host.exp.exponent.p339f.p340a.C6328c;
import host.exp.exponent.p343g.C6368f;
import host.exp.exponent.p344h.C6373d;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import javax.inject.C6562a;

/* compiled from: NativeModuleDepsProvider */
/* renamed from: host.exp.exponent.c.a */
public class C6294a {
    /* renamed from: i */
    private static final String f20458i = "a";
    /* renamed from: k */
    private static C6294a f20459k = null;
    /* renamed from: l */
    private static boolean f20460l = false;
    @C6562a
    /* renamed from: a */
    Context f20461a;
    @C6562a
    /* renamed from: b */
    Application f20462b;
    @C6562a
    /* renamed from: c */
    C6356f f20463c;
    @C6562a
    /* renamed from: d */
    C6373d f20464d;
    @C6562a
    /* renamed from: e */
    C6368f f20465e;
    @C6562a
    /* renamed from: f */
    C6329a f20466f;
    @C6562a
    /* renamed from: g */
    C6369g f20467g;
    @C6562a
    /* renamed from: h */
    C6328c f20468h;
    /* renamed from: j */
    private Map<Class, Object> f20469j = new HashMap();

    public C6294a(Application application) {
        this.f20461a = application;
        this.f20462b = application;
        this.f20463c = new C6356f(new Handler(Looper.getMainLooper()));
        this.f20464d = new C6373d(this.f20461a);
        this.f20465e = new C6368f(this.f20461a, this.f20464d);
        this.f20468h = new C6328c(this.f20461a, this.f20464d);
        this.f20466f = new C6329a(this.f20465e);
        this.f20467g = new C6369g(this.f20461a, this.f20465e, this.f20466f, this.f20464d);
        for (Field field : C6294a.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(C6562a.class)) {
                try {
                    this.f20469j.put(field.getType(), field.get(this));
                } catch (IllegalAccessException e) {
                    C6289b.m25953c(f20458i, e.toString());
                }
            }
        }
    }

    /* renamed from: a */
    public static void m25958a(Application application) {
        if (!f20460l) {
            f20459k = new C6294a(application);
        }
    }

    /* renamed from: a */
    public static C6294a m25957a() {
        return f20459k;
    }

    /* renamed from: a */
    public void m25960a(Class cls, Object obj) {
        this.f20469j.put(cls, obj);
    }

    /* renamed from: b */
    public void m25961b(Class cls, Object obj) {
        for (Field a : cls.getDeclaredFields()) {
            m25959a(obj, a);
        }
    }

    /* renamed from: a */
    private void m25959a(Object obj, Field field) {
        if (field.isAnnotationPresent(C6562a.class)) {
            Class type = field.getType();
            if (this.f20469j.containsKey(type)) {
                Object obj2 = this.f20469j.get(type);
                try {
                    field.setAccessible(true);
                    field.set(obj, obj2);
                    return;
                } catch (Object obj3) {
                    C6289b.m25953c(f20458i, obj3.toString());
                    return;
                }
            }
            field = new StringBuilder();
            field.append("NativeModuleDepsProvider could not find object for class ");
            field.append(type.toString());
            throw new RuntimeException(field.toString());
        }
    }
}
