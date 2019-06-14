package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ViewManagersPropertyCache {
    private static final Map<Class, Map<String, PropSetter>> CLASS_PROPS_CACHE = new HashMap();
    private static final Map<String, PropSetter> EMPTY_PROPS_MAP = new HashMap();

    static abstract class PropSetter {
        private static final Object[] SHADOW_ARGS = new Object[1];
        private static final Object[] SHADOW_GROUP_ARGS = new Object[2];
        private static final Object[] VIEW_MGR_ARGS = new Object[2];
        private static final Object[] VIEW_MGR_GROUP_ARGS = new Object[3];
        protected final Integer mIndex;
        protected final String mPropName;
        protected final String mPropType;
        protected final Method mSetter;

        protected abstract Object extractProperty(ReactStylesDiffMap reactStylesDiffMap);

        private PropSetter(ReactProp reactProp, String str, Method method) {
            this.mPropName = reactProp.name();
            if (!"__default_type__".equals(reactProp.customType())) {
                str = reactProp.customType();
            }
            this.mPropType = str;
            this.mSetter = method;
            this.mIndex = null;
        }

        private PropSetter(ReactPropGroup reactPropGroup, String str, Method method, int i) {
            this.mPropName = reactPropGroup.names()[i];
            if (!"__default_type__".equals(reactPropGroup.customType())) {
                str = reactPropGroup.customType();
            }
            this.mPropType = str;
            this.mSetter = method;
            this.mIndex = Integer.valueOf(i);
        }

        public String getPropName() {
            return this.mPropName;
        }

        public String getPropType() {
            return this.mPropType;
        }

        public void updateViewProp(ViewManager viewManager, View view, ReactStylesDiffMap reactStylesDiffMap) {
            try {
                if (this.mIndex == null) {
                    VIEW_MGR_ARGS[0] = view;
                    VIEW_MGR_ARGS[1] = extractProperty(reactStylesDiffMap);
                    this.mSetter.invoke(viewManager, VIEW_MGR_ARGS);
                    Arrays.fill(VIEW_MGR_ARGS, null);
                    return;
                }
                VIEW_MGR_GROUP_ARGS[0] = view;
                VIEW_MGR_GROUP_ARGS[1] = this.mIndex;
                VIEW_MGR_GROUP_ARGS[2] = extractProperty(reactStylesDiffMap);
                this.mSetter.invoke(viewManager, VIEW_MGR_GROUP_ARGS);
                Arrays.fill(VIEW_MGR_GROUP_ARGS, null);
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error while updating prop ");
                stringBuilder.append(this.mPropName);
                FLog.m5671e(ViewManager.class, stringBuilder.toString(), th);
                stringBuilder = new StringBuilder();
                stringBuilder.append("Error while updating property '");
                stringBuilder.append(this.mPropName);
                stringBuilder.append("' of a view managed by: ");
                stringBuilder.append(viewManager.getName());
                reactStylesDiffMap = new JSApplicationIllegalArgumentException(stringBuilder.toString(), th);
            }
        }

        public void updateShadowNodeProp(ReactShadowNode reactShadowNode, ReactStylesDiffMap reactStylesDiffMap) {
            try {
                if (this.mIndex == null) {
                    SHADOW_ARGS[0] = extractProperty(reactStylesDiffMap);
                    this.mSetter.invoke(reactShadowNode, SHADOW_ARGS);
                    Arrays.fill(SHADOW_ARGS, null);
                    return;
                }
                SHADOW_GROUP_ARGS[0] = this.mIndex;
                SHADOW_GROUP_ARGS[1] = extractProperty(reactStylesDiffMap);
                this.mSetter.invoke(reactShadowNode, SHADOW_GROUP_ARGS);
                Arrays.fill(SHADOW_GROUP_ARGS, null);
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error while updating prop ");
                stringBuilder.append(this.mPropName);
                FLog.m5671e(ViewManager.class, stringBuilder.toString(), th);
                stringBuilder = new StringBuilder();
                stringBuilder.append("Error while updating property '");
                stringBuilder.append(this.mPropName);
                stringBuilder.append("' in shadow node of type: ");
                stringBuilder.append(reactShadowNode.getViewClass());
                JSApplicationIllegalArgumentException jSApplicationIllegalArgumentException = new JSApplicationIllegalArgumentException(stringBuilder.toString(), th);
            }
        }
    }

    private static class ArrayPropSetter extends PropSetter {
        public ArrayPropSetter(ReactProp reactProp, Method method) {
            super(reactProp, "Array", method);
        }

        protected Object extractProperty(ReactStylesDiffMap reactStylesDiffMap) {
            return reactStylesDiffMap.getArray(this.mPropName);
        }
    }

    private static class BooleanPropSetter extends PropSetter {
        private final boolean mDefaultValue;

        public BooleanPropSetter(ReactProp reactProp, Method method, boolean z) {
            super(reactProp, "boolean", method);
            this.mDefaultValue = z;
        }

        protected Object extractProperty(ReactStylesDiffMap reactStylesDiffMap) {
            return reactStylesDiffMap.getBoolean(this.mPropName, this.mDefaultValue) != null ? Boolean.TRUE : Boolean.FALSE;
        }
    }

    private static class BoxedBooleanPropSetter extends PropSetter {
        public BoxedBooleanPropSetter(ReactProp reactProp, Method method) {
            super(reactProp, "boolean", method);
        }

        protected Object extractProperty(ReactStylesDiffMap reactStylesDiffMap) {
            if (reactStylesDiffMap.isNull(this.mPropName)) {
                return null;
            }
            return reactStylesDiffMap.getBoolean(this.mPropName, false) != null ? Boolean.TRUE : Boolean.FALSE;
        }
    }

    private static class BoxedIntPropSetter extends PropSetter {
        public BoxedIntPropSetter(ReactProp reactProp, Method method) {
            super(reactProp, "number", method);
        }

        public BoxedIntPropSetter(ReactPropGroup reactPropGroup, Method method, int i) {
            super(reactPropGroup, "number", method, i);
        }

        protected Object extractProperty(ReactStylesDiffMap reactStylesDiffMap) {
            return !reactStylesDiffMap.isNull(this.mPropName) ? Integer.valueOf(reactStylesDiffMap.getInt(this.mPropName, 0)) : null;
        }
    }

    private static class DoublePropSetter extends PropSetter {
        private final double mDefaultValue;

        public DoublePropSetter(ReactProp reactProp, Method method, double d) {
            super(reactProp, "number", method);
            this.mDefaultValue = d;
        }

        public DoublePropSetter(ReactPropGroup reactPropGroup, Method method, int i, double d) {
            super(reactPropGroup, "number", method, i);
            this.mDefaultValue = d;
        }

        protected Object extractProperty(ReactStylesDiffMap reactStylesDiffMap) {
            return Double.valueOf(reactStylesDiffMap.getDouble(this.mPropName, this.mDefaultValue));
        }
    }

    private static class DynamicPropSetter extends PropSetter {
        public DynamicPropSetter(ReactProp reactProp, Method method) {
            super(reactProp, "mixed", method);
        }

        public DynamicPropSetter(ReactPropGroup reactPropGroup, Method method, int i) {
            super(reactPropGroup, "mixed", method, i);
        }

        protected Object extractProperty(ReactStylesDiffMap reactStylesDiffMap) {
            return reactStylesDiffMap.getDynamic(this.mPropName);
        }
    }

    private static class FloatPropSetter extends PropSetter {
        private final float mDefaultValue;

        public FloatPropSetter(ReactProp reactProp, Method method, float f) {
            super(reactProp, "number", method);
            this.mDefaultValue = f;
        }

        public FloatPropSetter(ReactPropGroup reactPropGroup, Method method, int i, float f) {
            super(reactPropGroup, "number", method, i);
            this.mDefaultValue = f;
        }

        protected Object extractProperty(ReactStylesDiffMap reactStylesDiffMap) {
            return Float.valueOf(reactStylesDiffMap.getFloat(this.mPropName, this.mDefaultValue));
        }
    }

    private static class IntPropSetter extends PropSetter {
        private final int mDefaultValue;

        public IntPropSetter(ReactProp reactProp, Method method, int i) {
            super(reactProp, "number", method);
            this.mDefaultValue = i;
        }

        public IntPropSetter(ReactPropGroup reactPropGroup, Method method, int i, int i2) {
            super(reactPropGroup, "number", method, i);
            this.mDefaultValue = i2;
        }

        protected Object extractProperty(ReactStylesDiffMap reactStylesDiffMap) {
            return Integer.valueOf(reactStylesDiffMap.getInt(this.mPropName, this.mDefaultValue));
        }
    }

    private static class MapPropSetter extends PropSetter {
        public MapPropSetter(ReactProp reactProp, Method method) {
            super(reactProp, "Map", method);
        }

        protected Object extractProperty(ReactStylesDiffMap reactStylesDiffMap) {
            return reactStylesDiffMap.getMap(this.mPropName);
        }
    }

    private static class StringPropSetter extends PropSetter {
        public StringPropSetter(ReactProp reactProp, Method method) {
            super(reactProp, "String", method);
        }

        protected Object extractProperty(ReactStylesDiffMap reactStylesDiffMap) {
            return reactStylesDiffMap.getString(this.mPropName);
        }
    }

    ViewManagersPropertyCache() {
    }

    public static void clear() {
        CLASS_PROPS_CACHE.clear();
        EMPTY_PROPS_MAP.clear();
    }

    static Map<String, String> getNativePropsForView(Class<? extends ViewManager> cls, Class<? extends ReactShadowNode> cls2) {
        Map<String, String> hashMap = new HashMap();
        cls = getNativePropSettersForViewManagerClass(cls).values().iterator();
        while (cls.hasNext()) {
            PropSetter propSetter = (PropSetter) cls.next();
            hashMap.put(propSetter.getPropName(), propSetter.getPropType());
        }
        cls = getNativePropSettersForShadowNodeClass(cls2).values().iterator();
        while (cls.hasNext() != null) {
            PropSetter propSetter2 = (PropSetter) cls.next();
            hashMap.put(propSetter2.getPropName(), propSetter2.getPropType());
        }
        return hashMap;
    }

    static Map<String, PropSetter> getNativePropSettersForViewManagerClass(Class<? extends ViewManager> cls) {
        if (cls == ViewManager.class) {
            return EMPTY_PROPS_MAP;
        }
        Map<String, PropSetter> map = (Map) CLASS_PROPS_CACHE.get(cls);
        if (map != null) {
            return map;
        }
        map = new HashMap(getNativePropSettersForViewManagerClass(cls.getSuperclass()));
        extractPropSettersFromViewManagerClassDefinition(cls, map);
        CLASS_PROPS_CACHE.put(cls, map);
        return map;
    }

    static Map<String, PropSetter> getNativePropSettersForShadowNodeClass(Class<? extends ReactShadowNode> cls) {
        for (Class cls2 : cls.getInterfaces()) {
            if (cls2 == ReactShadowNode.class) {
                return EMPTY_PROPS_MAP;
            }
        }
        Map<String, PropSetter> map = (Map) CLASS_PROPS_CACHE.get(cls);
        if (map != null) {
            return map;
        }
        map = new HashMap(getNativePropSettersForShadowNodeClass(cls.getSuperclass()));
        extractPropSettersFromShadowNodeClassDefinition(cls, map);
        CLASS_PROPS_CACHE.put(cls, map);
        return map;
    }

    private static PropSetter createPropSetter(ReactProp reactProp, Method method, Class<?> cls) {
        if (cls == Dynamic.class) {
            return new DynamicPropSetter(reactProp, method);
        }
        if (cls == Boolean.TYPE) {
            return new BooleanPropSetter(reactProp, method, reactProp.defaultBoolean());
        }
        if (cls == Integer.TYPE) {
            return new IntPropSetter(reactProp, method, reactProp.defaultInt());
        }
        if (cls == Float.TYPE) {
            return new FloatPropSetter(reactProp, method, reactProp.defaultFloat());
        }
        if (cls == Double.TYPE) {
            return new DoublePropSetter(reactProp, method, reactProp.defaultDouble());
        }
        if (cls == String.class) {
            return new StringPropSetter(reactProp, method);
        }
        if (cls == Boolean.class) {
            return new BoxedBooleanPropSetter(reactProp, method);
        }
        if (cls == Integer.class) {
            return new BoxedIntPropSetter(reactProp, method);
        }
        if (cls == ReadableArray.class) {
            return new ArrayPropSetter(reactProp, method);
        }
        if (cls == ReadableMap.class) {
            return new MapPropSetter(reactProp, method);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unrecognized type: ");
        stringBuilder.append(cls);
        stringBuilder.append(" for method: ");
        stringBuilder.append(method.getDeclaringClass().getName());
        stringBuilder.append("#");
        stringBuilder.append(method.getName());
        throw new RuntimeException(stringBuilder.toString());
    }

    private static void createPropSetters(ReactPropGroup reactPropGroup, Method method, Class<?> cls, Map<String, PropSetter> map) {
        String[] names = reactPropGroup.names();
        int i = 0;
        if (cls == Dynamic.class) {
            while (i < names.length) {
                map.put(names[i], new DynamicPropSetter(reactPropGroup, method, i));
                i++;
            }
        } else if (cls == Integer.TYPE) {
            while (i < names.length) {
                map.put(names[i], new IntPropSetter(reactPropGroup, method, i, reactPropGroup.defaultInt()));
                i++;
            }
        } else if (cls == Float.TYPE) {
            while (i < names.length) {
                map.put(names[i], new FloatPropSetter(reactPropGroup, method, i, reactPropGroup.defaultFloat()));
                i++;
            }
        } else if (cls == Double.TYPE) {
            while (i < names.length) {
                map.put(names[i], new DoublePropSetter(reactPropGroup, method, i, reactPropGroup.defaultDouble()));
                i++;
            }
        } else if (cls == Integer.class) {
            while (i < names.length) {
                map.put(names[i], new BoxedIntPropSetter(reactPropGroup, method, i));
                i++;
            }
        } else {
            map = new StringBuilder();
            map.append("Unrecognized type: ");
            map.append(cls);
            map.append(" for method: ");
            map.append(method.getDeclaringClass().getName());
            map.append("#");
            map.append(method.getName());
            throw new RuntimeException(map.toString());
        }
    }

    private static void extractPropSettersFromViewManagerClassDefinition(Class<? extends ViewManager> cls, Map<String, PropSetter> map) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method method : declaredMethods) {
            Class[] parameterTypes;
            StringBuilder stringBuilder;
            ReactProp reactProp = (ReactProp) method.getAnnotation(ReactProp.class);
            if (reactProp != null) {
                parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 2) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Wrong number of args for prop setter: ");
                    stringBuilder.append(cls.getName());
                    stringBuilder.append("#");
                    stringBuilder.append(method.getName());
                    throw new RuntimeException(stringBuilder.toString());
                } else if (View.class.isAssignableFrom(parameterTypes[0])) {
                    map.put(reactProp.name(), createPropSetter(reactProp, method, parameterTypes[1]));
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("First param should be a view subclass to be updated: ");
                    stringBuilder.append(cls.getName());
                    stringBuilder.append("#");
                    stringBuilder.append(method.getName());
                    throw new RuntimeException(stringBuilder.toString());
                }
            }
            ReactPropGroup reactPropGroup = (ReactPropGroup) method.getAnnotation(ReactPropGroup.class);
            if (reactPropGroup != null) {
                parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 3) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Wrong number of args for group prop setter: ");
                    stringBuilder.append(cls.getName());
                    stringBuilder.append("#");
                    stringBuilder.append(method.getName());
                    throw new RuntimeException(stringBuilder.toString());
                } else if (!View.class.isAssignableFrom(parameterTypes[0])) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("First param should be a view subclass to be updated: ");
                    stringBuilder.append(cls.getName());
                    stringBuilder.append("#");
                    stringBuilder.append(method.getName());
                    throw new RuntimeException(stringBuilder.toString());
                } else if (parameterTypes[1] == Integer.TYPE) {
                    createPropSetters(reactPropGroup, method, parameterTypes[2], map);
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Second argument should be property index: ");
                    stringBuilder.append(cls.getName());
                    stringBuilder.append("#");
                    stringBuilder.append(method.getName());
                    throw new RuntimeException(stringBuilder.toString());
                }
            }
        }
    }

    private static void extractPropSettersFromShadowNodeClassDefinition(Class<? extends ReactShadowNode> cls, Map<String, PropSetter> map) {
        for (Method method : cls.getDeclaredMethods()) {
            Class[] parameterTypes;
            ReactProp reactProp = (ReactProp) method.getAnnotation(ReactProp.class);
            if (reactProp != null) {
                parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    map.put(reactProp.name(), createPropSetter(reactProp, method, parameterTypes[0]));
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Wrong number of args for prop setter: ");
                    stringBuilder.append(cls.getName());
                    stringBuilder.append("#");
                    stringBuilder.append(method.getName());
                    throw new RuntimeException(stringBuilder.toString());
                }
            }
            ReactPropGroup reactPropGroup = (ReactPropGroup) method.getAnnotation(ReactPropGroup.class);
            if (reactPropGroup != null) {
                parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 2) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Wrong number of args for group prop setter: ");
                    stringBuilder.append(cls.getName());
                    stringBuilder.append("#");
                    stringBuilder.append(method.getName());
                    throw new RuntimeException(stringBuilder.toString());
                } else if (parameterTypes[0] == Integer.TYPE) {
                    createPropSetters(reactPropGroup, method, parameterTypes[1], map);
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Second argument should be property index: ");
                    stringBuilder.append(cls.getName());
                    stringBuilder.append("#");
                    stringBuilder.append(method.getName());
                    throw new RuntimeException(stringBuilder.toString());
                }
            }
        }
    }
}
