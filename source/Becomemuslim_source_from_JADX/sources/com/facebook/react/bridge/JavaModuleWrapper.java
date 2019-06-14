package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.NativeModule.NativeMethod;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@DoNotStrip
public class JavaModuleWrapper {
    private final String mClassName;
    private final ArrayList<MethodDescriptor> mDescs = new ArrayList();
    private final JSInstance mJSInstance;
    private final ArrayList<NativeMethod> mMethods = new ArrayList();
    private final ModuleHolder mModuleHolder;

    @DoNotStrip
    public class MethodDescriptor {
        @DoNotStrip
        Method method;
        @DoNotStrip
        String name;
        @DoNotStrip
        String signature;
        @DoNotStrip
        String type;
    }

    public JavaModuleWrapper(JSInstance jSInstance, String str, ModuleHolder moduleHolder) {
        this.mJSInstance = jSInstance;
        this.mModuleHolder = moduleHolder;
        this.mClassName = str;
    }

    @DoNotStrip
    public BaseJavaModule getModule() {
        return (BaseJavaModule) this.mModuleHolder.getModule();
    }

    @DoNotStrip
    public String getName() {
        return this.mModuleHolder.getName();
    }

    @DoNotStrip
    private void findMethods() {
        Systrace.beginSection(0, "findMethods");
        Set hashSet = new HashSet();
        Class cls = this.mModuleHolder.getModule().getClass();
        Class superclass = cls.getSuperclass();
        if (ReactModuleWithSpec.class.isAssignableFrom(superclass)) {
            cls = superclass;
        }
        for (Method method : r3.getDeclaredMethods()) {
            ReactMethod reactMethod = (ReactMethod) method.getAnnotation(ReactMethod.class);
            if (reactMethod != null) {
                String name = method.getName();
                if (hashSet.contains(name)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Java Module ");
                    stringBuilder.append(getName());
                    stringBuilder.append(" method name already registered: ");
                    stringBuilder.append(name);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                MethodDescriptor methodDescriptor = new MethodDescriptor();
                JavaMethodWrapper javaMethodWrapper = new JavaMethodWrapper(this, method, reactMethod.isBlockingSynchronousMethod());
                methodDescriptor.name = name;
                methodDescriptor.type = javaMethodWrapper.getType();
                if (methodDescriptor.type == BaseJavaModule.METHOD_TYPE_SYNC) {
                    methodDescriptor.signature = javaMethodWrapper.getSignature();
                    methodDescriptor.method = method;
                }
                this.mMethods.add(javaMethodWrapper);
                this.mDescs.add(methodDescriptor);
            }
        }
        Systrace.endSection(0);
    }

    @DoNotStrip
    public List<MethodDescriptor> getMethodDescriptors() {
        if (this.mDescs.isEmpty()) {
            findMethods();
        }
        return this.mDescs;
    }

    @DoNotStrip
    public NativeMap getConstants() {
        if (!this.mModuleHolder.getHasConstants()) {
            return null;
        }
        String name = getName();
        SystraceMessage.beginSection(0, "JavaModuleWrapper.getConstants").arg("moduleName", (Object) name).flush();
        ReactMarker.logMarker(ReactMarkerConstants.GET_CONSTANTS_START, name);
        BaseJavaModule module = getModule();
        Systrace.beginSection(0, "module.getConstants");
        Map constants = module.getConstants();
        Systrace.endSection(0);
        Systrace.beginSection(0, "create WritableNativeMap");
        ReactMarker.logMarker(ReactMarkerConstants.CONVERT_CONSTANTS_START, name);
        try {
            NativeMap makeNativeMap = Arguments.makeNativeMap(constants);
            return makeNativeMap;
        } finally {
            ReactMarker.logMarker(ReactMarkerConstants.CONVERT_CONSTANTS_END);
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.GET_CONSTANTS_END);
            SystraceMessage.endSection(0).flush();
        }
    }

    @DoNotStrip
    public void invoke(int i, ReadableNativeArray readableNativeArray) {
        if (this.mMethods != null) {
            if (i < this.mMethods.size()) {
                ((NativeMethod) this.mMethods.get(i)).invoke(this.mJSInstance, readableNativeArray);
            }
        }
    }
}
