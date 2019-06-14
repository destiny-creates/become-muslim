package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.HashMap;
import java.util.Map;

public class ViewManagerPropertyUpdater {
    private static final Map<Class<?>, ShadowNodeSetter<?>> SHADOW_NODE_SETTER_MAP = new HashMap();
    private static final String TAG = "ViewManagerPropertyUpdater";
    private static final Map<Class<?>, ViewManagerSetter<?, ?>> VIEW_MANAGER_SETTER_MAP = new HashMap();

    public interface Settable {
        void getProperties(Map<String, String> map);
    }

    public interface ShadowNodeSetter<T extends ReactShadowNode> extends Settable {
        void setProperty(T t, String str, ReactStylesDiffMap reactStylesDiffMap);
    }

    public interface ViewManagerSetter<T extends ViewManager, V extends View> extends Settable {
        void setProperty(T t, V v, String str, ReactStylesDiffMap reactStylesDiffMap);
    }

    private static class FallbackShadowNodeSetter<T extends ReactShadowNode> implements ShadowNodeSetter<T> {
        private final Map<String, PropSetter> mPropSetters;

        private FallbackShadowNodeSetter(Class<? extends ReactShadowNode> cls) {
            this.mPropSetters = ViewManagersPropertyCache.getNativePropSettersForShadowNodeClass(cls);
        }

        public void setProperty(ReactShadowNode reactShadowNode, String str, ReactStylesDiffMap reactStylesDiffMap) {
            PropSetter propSetter = (PropSetter) this.mPropSetters.get(str);
            if (propSetter != null) {
                propSetter.updateShadowNodeProp(reactShadowNode, reactStylesDiffMap);
            }
        }

        public void getProperties(Map<String, String> map) {
            for (PropSetter propSetter : this.mPropSetters.values()) {
                map.put(propSetter.getPropName(), propSetter.getPropType());
            }
        }
    }

    private static class FallbackViewManagerSetter<T extends ViewManager, V extends View> implements ViewManagerSetter<T, V> {
        private final Map<String, PropSetter> mPropSetters;

        private FallbackViewManagerSetter(Class<? extends ViewManager> cls) {
            this.mPropSetters = ViewManagersPropertyCache.getNativePropSettersForViewManagerClass(cls);
        }

        public void setProperty(T t, V v, String str, ReactStylesDiffMap reactStylesDiffMap) {
            PropSetter propSetter = (PropSetter) this.mPropSetters.get(str);
            if (propSetter != null) {
                propSetter.updateViewProp(t, v, reactStylesDiffMap);
            }
        }

        public void getProperties(Map<String, String> map) {
            for (PropSetter propSetter : this.mPropSetters.values()) {
                map.put(propSetter.getPropName(), propSetter.getPropType());
            }
        }
    }

    public static void clear() {
        ViewManagersPropertyCache.clear();
        VIEW_MANAGER_SETTER_MAP.clear();
        SHADOW_NODE_SETTER_MAP.clear();
    }

    public static <T extends ViewManager, V extends View> void updateProps(T t, V v, ReactStylesDiffMap reactStylesDiffMap) {
        ViewManagerSetter findManagerSetter = findManagerSetter(t.getClass());
        ReadableMapKeySetIterator keySetIterator = reactStylesDiffMap.mBackingMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            findManagerSetter.setProperty(t, v, keySetIterator.nextKey(), reactStylesDiffMap);
        }
    }

    public static <T extends ReactShadowNode> void updateProps(T t, ReactStylesDiffMap reactStylesDiffMap) {
        ShadowNodeSetter findNodeSetter = findNodeSetter(t.getClass());
        ReadableMapKeySetIterator keySetIterator = reactStylesDiffMap.mBackingMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            findNodeSetter.setProperty(t, keySetIterator.nextKey(), reactStylesDiffMap);
        }
    }

    public static Map<String, String> getNativeProps(Class<? extends ViewManager> cls, Class<? extends ReactShadowNode> cls2) {
        Map<String, String> hashMap = new HashMap();
        findManagerSetter(cls).getProperties(hashMap);
        findNodeSetter(cls2).getProperties(hashMap);
        return hashMap;
    }

    private static <T extends ViewManager, V extends View> ViewManagerSetter<T, V> findManagerSetter(Class<? extends ViewManager> cls) {
        ViewManagerSetter<T, V> viewManagerSetter = (ViewManagerSetter) VIEW_MANAGER_SETTER_MAP.get(cls);
        if (viewManagerSetter == null) {
            viewManagerSetter = (ViewManagerSetter) findGeneratedSetter(cls);
            if (viewManagerSetter == null) {
                viewManagerSetter = new FallbackViewManagerSetter(cls);
            }
            VIEW_MANAGER_SETTER_MAP.put(cls, viewManagerSetter);
        }
        return viewManagerSetter;
    }

    private static <T extends ReactShadowNode> ShadowNodeSetter<T> findNodeSetter(Class<? extends ReactShadowNode> cls) {
        ShadowNodeSetter<T> shadowNodeSetter = (ShadowNodeSetter) SHADOW_NODE_SETTER_MAP.get(cls);
        if (shadowNodeSetter == null) {
            shadowNodeSetter = (ShadowNodeSetter) findGeneratedSetter(cls);
            if (shadowNodeSetter == null) {
                shadowNodeSetter = new FallbackShadowNodeSetter(cls);
            }
            SHADOW_NODE_SETTER_MAP.put(cls, shadowNodeSetter);
        }
        return shadowNodeSetter;
    }

    private static <T> T findGeneratedSetter(java.lang.Class<?> r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = r4.getName();
        r1 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0036, InstantiationException -> 0x001e, InstantiationException -> 0x001e }
        r1.<init>();	 Catch:{ ClassNotFoundException -> 0x0036, InstantiationException -> 0x001e, InstantiationException -> 0x001e }
        r1.append(r0);	 Catch:{ ClassNotFoundException -> 0x0036, InstantiationException -> 0x001e, InstantiationException -> 0x001e }
        r2 = "$$PropsSetter";	 Catch:{ ClassNotFoundException -> 0x0036, InstantiationException -> 0x001e, InstantiationException -> 0x001e }
        r1.append(r2);	 Catch:{ ClassNotFoundException -> 0x0036, InstantiationException -> 0x001e, InstantiationException -> 0x001e }
        r1 = r1.toString();	 Catch:{ ClassNotFoundException -> 0x0036, InstantiationException -> 0x001e, InstantiationException -> 0x001e }
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0036, InstantiationException -> 0x001e, InstantiationException -> 0x001e }
        r1 = r1.newInstance();	 Catch:{ ClassNotFoundException -> 0x0036, InstantiationException -> 0x001e, InstantiationException -> 0x001e }
        return r1;
    L_0x001e:
        r4 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Unable to instantiate methods getter for ";
        r2.append(r3);
        r2.append(r0);
        r0 = r2.toString();
        r1.<init>(r0, r4);
        throw r1;
    L_0x0036:
        r0 = "ViewManagerPropertyUpdater";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Could not find generated setter for ";
        r1.append(r2);
        r1.append(r4);
        r4 = r1.toString();
        com.facebook.common.logging.FLog.m5714w(r0, r4);
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.ViewManagerPropertyUpdater.findGeneratedSetter(java.lang.Class):T");
    }
}
