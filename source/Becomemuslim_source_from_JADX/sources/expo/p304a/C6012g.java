package expo.p304a;

import android.content.Context;
import android.view.View;
import expo.p304a.p305a.C5997d;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ViewManager */
/* renamed from: expo.a.g */
public abstract class C6012g<V extends View> {
    private Map<String, C6010a> mPropSetterInfos;
    private Map<String, Method> mPropSetters;

    /* compiled from: ViewManager */
    /* renamed from: expo.a.g$a */
    public class C6010a {
        /* renamed from: a */
        final /* synthetic */ C6012g f19798a;
        /* renamed from: b */
        private Class<?> f19799b;

        C6010a(C6012g c6012g, Class<?>[] clsArr) {
            this.f19798a = c6012g;
            this.f19799b = clsArr[clsArr.length - 1];
        }

        /* renamed from: a */
        public Class<?> m25156a() {
            return this.f19799b;
        }
    }

    /* compiled from: ViewManager */
    /* renamed from: expo.a.g$b */
    public enum C6011b {
        SIMPLE,
        GROUP
    }

    public abstract V createViewInstance(Context context);

    public abstract String getName();

    public abstract C6011b getViewManagerType();

    public void onDropViewInstance(V v) {
    }

    public List<String> getExportedEventNames() {
        return Collections.emptyList();
    }

    public Map<String, C6010a> getPropSetterInfos() {
        if (this.mPropSetterInfos != null) {
            return this.mPropSetterInfos;
        }
        Map hashMap = new HashMap();
        for (Entry entry : getPropSetters().entrySet()) {
            hashMap.put(entry.getKey(), new C6010a(this, ((Method) entry.getValue()).getParameterTypes()));
        }
        this.mPropSetterInfos = hashMap;
        return this.mPropSetterInfos;
    }

    public void updateProp(V v, String str, Object obj) {
        Method method = (Method) getPropSetters().get(str);
        if (method != null) {
            obj = transformArgumentToClass(obj, ((C6010a) getPropSetterInfos().get(str)).m25156a());
            try {
                method.invoke(this, new Object[]{v, obj});
                return;
            } catch (V v2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Exception occurred while updating property ");
                stringBuilder.append(str);
                stringBuilder.append(" on module ");
                stringBuilder.append(getName());
                stringBuilder.append(": ");
                stringBuilder.append(v2.getMessage());
                throw new RuntimeException(stringBuilder.toString(), v2);
            }
        }
        obj = new StringBuilder();
        obj.append("There is no propSetter in ");
        obj.append(getName());
        obj.append(" for prop of name ");
        obj.append(str);
        obj.append(".");
        throw new IllegalArgumentException(obj.toString());
    }

    protected Object transformArgumentToClass(Object obj, Class<?> cls) {
        return C6004a.m25129a(obj, cls);
    }

    private Map<String, Method> getPropSetters() {
        if (this.mPropSetters != null) {
            return this.mPropSetters;
        }
        this.mPropSetters = new HashMap();
        for (Method method : getClass().getDeclaredMethods()) {
            if (method.getAnnotation(C5997d.class) != null) {
                String a = ((C5997d) method.getAnnotation(C5997d.class)).m25128a();
                StringBuilder stringBuilder;
                if (method.getParameterTypes().length != 2) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Expo prop setter should define at least two arguments: view and prop value. Propsetter for ");
                    stringBuilder.append(a);
                    stringBuilder.append(" of module ");
                    stringBuilder.append(getName());
                    stringBuilder.append(" does not define these arguments.");
                    throw new IllegalArgumentException(stringBuilder.toString());
                } else if (this.mPropSetters.containsKey(a)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("View manager ");
                    stringBuilder.append(getName());
                    stringBuilder.append(" prop setter name already registered: ");
                    stringBuilder.append(a);
                    stringBuilder.append(".");
                    throw new IllegalArgumentException(stringBuilder.toString());
                } else {
                    this.mPropSetters.put(a, method);
                }
            }
        }
        return this.mPropSetters;
    }
}
