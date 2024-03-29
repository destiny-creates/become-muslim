package com.facebook.react.bridge;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public final class JavaScriptModuleRegistry {
    private final HashMap<Class<? extends JavaScriptModule>, JavaScriptModule> mModuleInstances = new HashMap();

    private static class JavaScriptModuleInvocationHandler implements InvocationHandler {
        private final CatalystInstance mCatalystInstance;
        private final Class<? extends JavaScriptModule> mModuleInterface;
        private String mName;

        public JavaScriptModuleInvocationHandler(CatalystInstance catalystInstance, Class<? extends JavaScriptModule> cls) {
            this.mCatalystInstance = catalystInstance;
            this.mModuleInterface = cls;
        }

        private String getJSModuleName() {
            if (this.mName == null) {
                String simpleName = this.mModuleInterface.getSimpleName();
                int lastIndexOf = simpleName.lastIndexOf(36);
                if (lastIndexOf != -1) {
                    simpleName = simpleName.substring(lastIndexOf + 1);
                }
                this.mName = simpleName;
            }
            return this.mName;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            this.mCatalystInstance.callFunction(getJSModuleName(), method.getName(), objArr != null ? Arguments.fromJavaArgs(objArr) : new WritableNativeArray());
            return null;
        }
    }

    public synchronized <T extends JavaScriptModule> T getJavaScriptModule(CatalystInstance catalystInstance, Class<T> cls) {
        JavaScriptModule javaScriptModule = (JavaScriptModule) this.mModuleInstances.get(cls);
        if (javaScriptModule != null) {
            return javaScriptModule;
        }
        JavaScriptModule javaScriptModule2 = (JavaScriptModule) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new JavaScriptModuleInvocationHandler(catalystInstance, cls));
        this.mModuleInstances.put(cls, javaScriptModule2);
        return javaScriptModule2;
    }
}
