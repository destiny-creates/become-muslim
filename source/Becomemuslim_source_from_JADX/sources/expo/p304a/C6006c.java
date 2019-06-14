package expo.p304a;

import android.content.Context;
import expo.p304a.p305a.C5996c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ExportedModule */
/* renamed from: expo.a.c */
public abstract class C6006c {
    private Context mContext;
    private Map<String, C6005a> mExportedMethodInfos;
    private Map<String, Method> mExportedMethods;

    /* compiled from: ExportedModule */
    /* renamed from: expo.a.c$a */
    public class C6005a {
        /* renamed from: a */
        final /* synthetic */ C6006c f19787a;
        /* renamed from: b */
        private Class<?>[] f19788b;

        C6005a(C6006c c6006c, Method method) {
            this.f19787a = c6006c;
            this.f19788b = method.getParameterTypes();
        }

        /* renamed from: a */
        public Class<?>[] m25130a() {
            return this.f19788b;
        }
    }

    public abstract String getName();

    public C6006c(Context context) {
        this.mContext = context;
    }

    public Map<String, Object> getConstants() {
        return Collections.unmodifiableMap(Collections.emptyMap());
    }

    protected Context getContext() {
        return this.mContext;
    }

    public Map<String, C6005a> getExportedMethodInfos() {
        if (this.mExportedMethodInfos != null) {
            return this.mExportedMethodInfos;
        }
        Map hashMap = new HashMap();
        for (Entry entry : getExportedMethods().entrySet()) {
            hashMap.put(entry.getKey(), new C6005a(this, (Method) entry.getValue()));
        }
        this.mExportedMethodInfos = hashMap;
        return this.mExportedMethodInfos;
    }

    public Object invokeExportedMethod(String str, Collection<Object> collection) {
        Method method = (Method) this.mExportedMethods.get(str);
        if (method != null) {
            int length = method.getParameterTypes().length;
            if (collection.size() == length) {
                Class[] parameterTypes = method.getParameterTypes();
                Iterator it = collection.iterator();
                List arrayList = new ArrayList(collection.size());
                for (collection = null; collection < length; collection++) {
                    arrayList.add(transformArgumentToClass(it.next(), parameterTypes[collection]));
                }
                try {
                    return method.invoke(this, arrayList.toArray());
                } catch (Collection<Object> collection2) {
                    collection2.printStackTrace();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Exception occurred while executing exported method ");
                    stringBuilder.append(str);
                    stringBuilder.append(" on module ");
                    stringBuilder.append(getName());
                    stringBuilder.append(": ");
                    stringBuilder.append(collection2.getMessage());
                    throw new RuntimeException(stringBuilder.toString(), collection2);
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Method ");
            stringBuilder2.append(str);
            stringBuilder2.append(" on class ");
            stringBuilder2.append(getName());
            stringBuilder2.append(" expects ");
            stringBuilder2.append(length);
            stringBuilder2.append(" arguments, whereas ");
            stringBuilder2.append(collection2.size());
            stringBuilder2.append(" arguments have been provided.");
            throw new IllegalArgumentException(stringBuilder2.toString());
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Module ");
        stringBuilder3.append(getName());
        stringBuilder3.append("does not export method ");
        stringBuilder3.append(str);
        stringBuilder3.append(".");
        throw new NoSuchMethodException(stringBuilder3.toString());
    }

    protected Object transformArgumentToClass(Object obj, Class<?> cls) {
        return C6004a.m25129a(obj, cls);
    }

    public Map<String, Method> getExportedMethods() {
        if (this.mExportedMethods != null) {
            return this.mExportedMethods;
        }
        this.mExportedMethods = new HashMap();
        Class cls = getClass();
        while (cls != null && C6006c.class.isAssignableFrom(cls)) {
            for (Entry entry : getExportedMethods(cls).entrySet()) {
                if (!this.mExportedMethods.containsKey(entry.getKey())) {
                    this.mExportedMethods.put(entry.getKey(), entry.getValue());
                }
            }
            cls = cls.getSuperclass();
        }
        return this.mExportedMethods;
    }

    protected Map<String, Method> getExportedMethods(Class cls) {
        Map<String, Method> hashMap = new HashMap();
        for (Method method : cls.getDeclaredMethods()) {
            if (method.getAnnotation(C5996c.class) != null) {
                String name = method.getName();
                Class[] parameterTypes = method.getParameterTypes();
                StringBuilder stringBuilder;
                if (parameterTypes.length < 1) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Method ");
                    stringBuilder.append(name);
                    stringBuilder.append(" of Java Module ");
                    stringBuilder.append(getName());
                    stringBuilder.append(" does not define any arguments - minimum argument set is a Promise");
                    throw new IllegalArgumentException(stringBuilder.toString());
                } else if (parameterTypes[parameterTypes.length - 1] != C6009f.class) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Last argument of method ");
                    stringBuilder.append(name);
                    stringBuilder.append(" of Java Module ");
                    stringBuilder.append(getName());
                    stringBuilder.append(" does not expect a Promise");
                    throw new IllegalArgumentException(stringBuilder.toString());
                } else if (hashMap.containsKey(name)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Java Module ");
                    stringBuilder.append(getName());
                    stringBuilder.append(" method name already registered: ");
                    stringBuilder.append(name);
                    stringBuilder.append(".");
                    throw new IllegalArgumentException(stringBuilder.toString());
                } else {
                    hashMap.put(name, method);
                }
            }
        }
        return hashMap;
    }
}
