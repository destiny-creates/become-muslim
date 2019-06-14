package host.exp.exponent;

import host.exp.exponent.p334a.C6289b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: RNObject */
/* renamed from: host.exp.exponent.j */
public class C6394j {
    /* renamed from: a */
    private static final String f20694a = "j";
    /* renamed from: b */
    private final String f20695b;
    /* renamed from: c */
    private Class f20696c;
    /* renamed from: d */
    private Object f20697d;

    public C6394j(String str) {
        this.f20695b = str;
    }

    /* renamed from: a */
    public static C6394j m26225a(Object obj) {
        return new C6394j(obj);
    }

    private C6394j(Object obj) {
        m26242b(obj);
        this.f20695b = m26226a(this.f20696c);
    }

    /* renamed from: a */
    public boolean m26240a() {
        return this.f20697d == null;
    }

    /* renamed from: b */
    public boolean m26243b() {
        return this.f20697d != null;
    }

    /* renamed from: a */
    public C6394j m26233a(String str) {
        try {
            if (!str.equals("UNVERSIONED")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("abi");
                stringBuilder.append(str.replace('.', '_'));
                stringBuilder.append('.');
                stringBuilder.append(this.f20695b);
                this.f20696c = Class.forName(stringBuilder.toString());
            } else if (this.f20695b.startsWith("host.exp.exponent") != null) {
                str = new StringBuilder();
                str.append("versioned.");
                str.append(this.f20695b);
                this.f20696c = Class.forName(str.toString());
            } else {
                this.f20696c = Class.forName(this.f20695b);
            }
        } catch (Throwable e) {
            C6289b.m25950a(f20694a, e);
        }
        return this;
    }

    /* renamed from: b */
    public void m26242b(Object obj) {
        if (obj != null) {
            this.f20696c = obj.getClass();
        }
        this.f20697d = obj;
    }

    /* renamed from: c */
    public Object m26244c() {
        return this.f20697d;
    }

    /* renamed from: d */
    public Class m26247d() {
        return this.f20696c;
    }

    /* renamed from: e */
    public String m26248e() {
        String name = this.f20696c.getName();
        return name.startsWith("abi") ? name.split("\\.")[0].substring(3) : "UNVERSIONED";
    }

    /* renamed from: b */
    public static String m26231b(String str) {
        return str.startsWith("abi") ? str.split("\\.")[0].substring(3) : "UNVERSIONED";
    }

    /* renamed from: a */
    public C6394j m26234a(Object... objArr) {
        try {
            this.f20697d = m26227a(this.f20696c, m26232b(objArr)).newInstance(objArr);
        } catch (Throwable e) {
            C6289b.m25950a(f20694a, e);
        }
        return this;
    }

    /* renamed from: a */
    public Object m26236a(String str, Object... objArr) {
        return m26235a(this.f20697d, str, objArr);
    }

    /* renamed from: b */
    public C6394j m26241b(String str, Object... objArr) {
        Object a = m26236a(str, objArr);
        if (a == null) {
            return null;
        }
        return C6394j.m26225a(a);
    }

    /* renamed from: c */
    public Object m26245c(String str, Object... objArr) {
        return m26235a(null, str, objArr);
    }

    /* renamed from: d */
    public C6394j m26246d(String str, Object... objArr) {
        return C6394j.m26225a(m26245c(str, objArr));
    }

    /* renamed from: a */
    public void m26239a(String str, Object obj) {
        m26238a(this.f20697d, str, obj);
    }

    /* renamed from: a */
    private String m26226a(Class cls) {
        cls = cls.getName();
        return cls.startsWith("abi") ? cls.substring(cls.indexOf(46) + 1) : cls;
    }

    /* renamed from: b */
    private Class[] m26232b(Object... objArr) {
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i] != null) {
                clsArr[i] = objArr[i].getClass();
            }
        }
        return clsArr;
    }

    /* renamed from: a */
    public Object m26235a(Object obj, String str, Object... objArr) {
        try {
            return m26229a(this.f20696c, str, m26232b(objArr)).invoke(obj, objArr);
        } catch (Throwable e) {
            C6289b.m25950a(f20694a, e);
            e.printStackTrace();
            return null;
        } catch (Object obj2) {
            objArr = f20694a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Runtime exception in RNObject when calling method ");
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(obj2.toString());
            C6289b.m25953c(objArr, stringBuilder.toString());
            return null;
        }
    }

    /* renamed from: a */
    public void m26238a(Object obj, String str, Object obj2) {
        try {
            m26228a(this.f20696c, str, obj2.getClass()).set(obj, obj2);
        } catch (Throwable e) {
            C6289b.m25950a(f20694a, e);
            e.printStackTrace();
        } catch (Object obj3) {
            obj2 = f20694a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Runtime exception in RNObject when setting field ");
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(obj3.toString());
            C6289b.m25953c(obj2, stringBuilder.toString());
        }
    }

    /* renamed from: a */
    private Method m26229a(Class cls, String str, Class... clsArr) {
        cls = cls.getMethods();
        for (Method method : cls) {
            if (method.getName().equals(str)) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == clsArr.length) {
                    Object obj;
                    for (int i = 0; i < parameterTypes.length; i++) {
                        if (!m26230a(parameterTypes[i], clsArr[i])) {
                            obj = null;
                            break;
                        }
                    }
                    obj = 1;
                    if (obj != null) {
                        return method;
                    }
                }
            }
        }
        throw new NoSuchMethodException();
    }

    /* renamed from: a */
    private Field m26228a(Class cls, String str, Class cls2) {
        cls = cls.getFields();
        for (Field field : cls) {
            if (field.getName().equals(str)) {
                if (m26230a(field.getType(), cls2)) {
                    return field;
                }
            }
        }
        throw new NoSuchFieldException();
    }

    /* renamed from: a */
    private Constructor m26227a(Class cls, Class... clsArr) {
        cls = cls.getConstructors();
        for (Constructor constructor : cls) {
            Class[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                Object obj;
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (!m26230a(parameterTypes[i], clsArr[i])) {
                        obj = null;
                        break;
                    }
                }
                obj = 1;
                if (obj != null) {
                    return constructor;
                }
            }
        }
        throw new NoSuchMethodError();
    }

    /* renamed from: a */
    private boolean m26230a(Class cls, Class cls2) {
        if (cls2 == null || cls.isAssignableFrom(cls2)) {
            return true;
        }
        if (cls.equals(Boolean.TYPE) && cls2.equals(Boolean.class)) {
            return true;
        }
        if (cls.equals(Byte.TYPE) && cls2.equals(Byte.class)) {
            return true;
        }
        if (cls.equals(Character.TYPE) && cls2.equals(Character.class)) {
            return true;
        }
        if (cls.equals(Float.TYPE) && cls2.equals(Float.class)) {
            return true;
        }
        if (cls.equals(Integer.TYPE) && cls2.equals(Integer.class)) {
            return true;
        }
        if (cls.equals(Long.TYPE) && cls2.equals(Long.class)) {
            return true;
        }
        if (cls.equals(Short.TYPE) && cls2.equals(Short.class)) {
            return true;
        }
        if (cls.equals(Double.TYPE) == null || cls2.equals(Double.class) == null) {
            return null;
        }
        return true;
    }

    /* renamed from: a */
    public void m26237a(Object obj, Object obj2) {
        m26236a("onHostResume", obj, obj2);
    }

    /* renamed from: f */
    public void m26249f() {
        m26236a("onHostPause", new Object[0]);
    }

    /* renamed from: g */
    public void m26250g() {
        m26236a("onHostDestroy", new Object[0]);
    }
}
