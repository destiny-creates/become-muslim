package com.facebook.react.bridge;

import java.lang.reflect.Constructor;
import javax.inject.Provider;

public class ModuleSpec {
    private static final Class[] CONTEXT_SIGNATURE = new Class[]{ReactApplicationContext.class};
    private static final Class[] EMPTY_SIGNATURE = new Class[0];
    private final String mClassName;
    private final Provider<? extends NativeModule> mProvider;
    private final Class<? extends NativeModule> mType;

    private static abstract class ConstructorProvider implements Provider<NativeModule> {
        protected Constructor<? extends NativeModule> mConstructor;

        public ConstructorProvider(Class<? extends NativeModule> cls, Class[] clsArr) {
        }

        protected Constructor<? extends NativeModule> getConstructor(Class<? extends NativeModule> cls, Class[] clsArr) {
            if (this.mConstructor != null) {
                return this.mConstructor;
            }
            return cls.getConstructor(clsArr);
        }
    }

    public static ModuleSpec simple(final Class<? extends NativeModule> cls) {
        return new ModuleSpec((Class) cls, new ConstructorProvider(EMPTY_SIGNATURE, cls) {
            public NativeModule get() {
                try {
                    return (NativeModule) getConstructor(cls, ModuleSpec.EMPTY_SIGNATURE).newInstance(new Object[0]);
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("ModuleSpec with class: ");
                    stringBuilder.append(cls.getName());
                    throw new RuntimeException(stringBuilder.toString(), e);
                }
            }
        });
    }

    public static ModuleSpec simple(final Class<? extends NativeModule> cls, final ReactApplicationContext reactApplicationContext) {
        return new ModuleSpec((Class) cls, new ConstructorProvider(CONTEXT_SIGNATURE, cls) {
            public NativeModule get() {
                try {
                    return (NativeModule) getConstructor(cls, ModuleSpec.CONTEXT_SIGNATURE).newInstance(new Object[]{reactApplicationContext});
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("ModuleSpec with class: ");
                    stringBuilder.append(cls.getName());
                    throw new RuntimeException(stringBuilder.toString(), e);
                }
            }
        });
    }

    public static ModuleSpec viewManagerSpec(Provider<? extends NativeModule> provider) {
        return new ModuleSpec(null, (Provider) provider);
    }

    public static ModuleSpec nativeModuleSpec(Class<? extends NativeModule> cls, Provider<? extends NativeModule> provider) {
        return new ModuleSpec((Provider) provider, cls.getName());
    }

    public static ModuleSpec nativeModuleSpec(String str, Provider<? extends NativeModule> provider) {
        return new ModuleSpec((Provider) provider, str);
    }

    private ModuleSpec(Class<? extends NativeModule> cls, Provider<? extends NativeModule> provider) {
        this.mType = cls;
        this.mProvider = provider;
        if (cls == null) {
            cls = null;
        } else {
            cls = cls.getName();
        }
        this.mClassName = cls;
    }

    public ModuleSpec(Provider<? extends NativeModule> provider, String str) {
        this.mType = null;
        this.mProvider = provider;
        this.mClassName = str;
    }

    public Class<? extends NativeModule> getType() {
        return this.mType;
    }

    public String getClassName() {
        return this.mClassName;
    }

    public Provider<? extends NativeModule> getProvider() {
        return this.mProvider;
    }
}
