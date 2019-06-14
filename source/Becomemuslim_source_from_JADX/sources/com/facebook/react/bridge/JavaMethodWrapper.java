package com.facebook.react.bridge;

import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.react.bridge.NativeModule.NativeMethod;
import com.facebook.systrace.SystraceMessage;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.lang.reflect.Method;

public class JavaMethodWrapper implements NativeMethod {
    private static final ArgumentExtractor<ReadableNativeArray> ARGUMENT_EXTRACTOR_ARRAY = new C38246();
    private static final ArgumentExtractor<Boolean> ARGUMENT_EXTRACTOR_BOOLEAN = new C38191();
    private static final ArgumentExtractor<Callback> ARGUMENT_EXTRACTOR_CALLBACK = new C38279();
    private static final ArgumentExtractor<Double> ARGUMENT_EXTRACTOR_DOUBLE = new C38202();
    private static final ArgumentExtractor<Dynamic> ARGUMENT_EXTRACTOR_DYNAMIC = new C38257();
    private static final ArgumentExtractor<Float> ARGUMENT_EXTRACTOR_FLOAT = new C38213();
    private static final ArgumentExtractor<Integer> ARGUMENT_EXTRACTOR_INTEGER = new C38224();
    private static final ArgumentExtractor<ReadableMap> ARGUMENT_EXTRACTOR_MAP = new C38268();
    private static final ArgumentExtractor<Promise> ARGUMENT_EXTRACTOR_PROMISE = new ArgumentExtractor<Promise>() {
        public int getJSArgumentsNeeded() {
            return 2;
        }

        public Promise extractArgument(JSInstance jSInstance, ReadableNativeArray readableNativeArray, int i) {
            return new PromiseImpl((Callback) JavaMethodWrapper.ARGUMENT_EXTRACTOR_CALLBACK.extractArgument(jSInstance, readableNativeArray, i), (Callback) JavaMethodWrapper.ARGUMENT_EXTRACTOR_CALLBACK.extractArgument(jSInstance, readableNativeArray, i + 1));
        }
    };
    private static final ArgumentExtractor<String> ARGUMENT_EXTRACTOR_STRING = new C38235();
    private static final boolean DEBUG = PrinterHolder.getPrinter().shouldDisplayLogMessage(ReactDebugOverlayTags.BRIDGE_CALLS);
    private ArgumentExtractor[] mArgumentExtractors;
    private Object[] mArguments;
    private boolean mArgumentsProcessed = false;
    private int mJSArgumentsNeeded;
    private final Method mMethod;
    private final JavaModuleWrapper mModuleWrapper;
    private final int mParamLength;
    private final Class[] mParameterTypes;
    private String mSignature;
    private String mType = BaseJavaModule.METHOD_TYPE_ASYNC;

    private static abstract class ArgumentExtractor<T> {
        public abstract T extractArgument(JSInstance jSInstance, ReadableNativeArray readableNativeArray, int i);

        public int getJSArgumentsNeeded() {
            return 1;
        }

        private ArgumentExtractor() {
        }
    }

    /* renamed from: com.facebook.react.bridge.JavaMethodWrapper$1 */
    static class C38191 extends ArgumentExtractor<Boolean> {
        C38191() {
            super();
        }

        public Boolean extractArgument(JSInstance jSInstance, ReadableNativeArray readableNativeArray, int i) {
            return Boolean.valueOf(readableNativeArray.getBoolean(i));
        }
    }

    /* renamed from: com.facebook.react.bridge.JavaMethodWrapper$2 */
    static class C38202 extends ArgumentExtractor<Double> {
        C38202() {
            super();
        }

        public Double extractArgument(JSInstance jSInstance, ReadableNativeArray readableNativeArray, int i) {
            return Double.valueOf(readableNativeArray.getDouble(i));
        }
    }

    /* renamed from: com.facebook.react.bridge.JavaMethodWrapper$3 */
    static class C38213 extends ArgumentExtractor<Float> {
        C38213() {
            super();
        }

        public Float extractArgument(JSInstance jSInstance, ReadableNativeArray readableNativeArray, int i) {
            return Float.valueOf((float) readableNativeArray.getDouble(i));
        }
    }

    /* renamed from: com.facebook.react.bridge.JavaMethodWrapper$4 */
    static class C38224 extends ArgumentExtractor<Integer> {
        C38224() {
            super();
        }

        public Integer extractArgument(JSInstance jSInstance, ReadableNativeArray readableNativeArray, int i) {
            return Integer.valueOf((int) readableNativeArray.getDouble(i));
        }
    }

    /* renamed from: com.facebook.react.bridge.JavaMethodWrapper$5 */
    static class C38235 extends ArgumentExtractor<String> {
        C38235() {
            super();
        }

        public String extractArgument(JSInstance jSInstance, ReadableNativeArray readableNativeArray, int i) {
            return readableNativeArray.getString(i);
        }
    }

    /* renamed from: com.facebook.react.bridge.JavaMethodWrapper$6 */
    static class C38246 extends ArgumentExtractor<ReadableNativeArray> {
        C38246() {
            super();
        }

        public ReadableNativeArray extractArgument(JSInstance jSInstance, ReadableNativeArray readableNativeArray, int i) {
            return readableNativeArray.getArray(i);
        }
    }

    /* renamed from: com.facebook.react.bridge.JavaMethodWrapper$7 */
    static class C38257 extends ArgumentExtractor<Dynamic> {
        C38257() {
            super();
        }

        public Dynamic extractArgument(JSInstance jSInstance, ReadableNativeArray readableNativeArray, int i) {
            return DynamicFromArray.create(readableNativeArray, i);
        }
    }

    /* renamed from: com.facebook.react.bridge.JavaMethodWrapper$8 */
    static class C38268 extends ArgumentExtractor<ReadableMap> {
        C38268() {
            super();
        }

        public ReadableMap extractArgument(JSInstance jSInstance, ReadableNativeArray readableNativeArray, int i) {
            return readableNativeArray.getMap(i);
        }
    }

    /* renamed from: com.facebook.react.bridge.JavaMethodWrapper$9 */
    static class C38279 extends ArgumentExtractor<Callback> {
        C38279() {
            super();
        }

        public Callback extractArgument(JSInstance jSInstance, ReadableNativeArray readableNativeArray, int i) {
            if (readableNativeArray.isNull(i)) {
                return null;
            }
            return new CallbackImpl(jSInstance, (int) readableNativeArray.getDouble(i));
        }
    }

    private static char paramTypeToChar(Class cls) {
        char commonTypeToChar = commonTypeToChar(cls);
        if (commonTypeToChar != '\u0000') {
            return commonTypeToChar;
        }
        if (cls == Callback.class) {
            return 'X';
        }
        if (cls == Promise.class) {
            return 'P';
        }
        if (cls == ReadableMap.class) {
            return 'M';
        }
        if (cls == ReadableArray.class) {
            return 'A';
        }
        if (cls == Dynamic.class) {
            return 'Y';
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Got unknown param class: ");
        stringBuilder.append(cls.getSimpleName());
        throw new RuntimeException(stringBuilder.toString());
    }

    private static char returnTypeToChar(Class cls) {
        char commonTypeToChar = commonTypeToChar(cls);
        if (commonTypeToChar != '\u0000') {
            return commonTypeToChar;
        }
        if (cls == Void.TYPE) {
            return 'v';
        }
        if (cls == WritableMap.class) {
            return 'M';
        }
        if (cls == WritableArray.class) {
            return 'A';
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Got unknown return class: ");
        stringBuilder.append(cls.getSimpleName());
        throw new RuntimeException(stringBuilder.toString());
    }

    private static char commonTypeToChar(Class cls) {
        if (cls == Boolean.TYPE) {
            return 'z';
        }
        if (cls == Boolean.class) {
            return 'Z';
        }
        if (cls == Integer.TYPE) {
            return 'i';
        }
        if (cls == Integer.class) {
            return 'I';
        }
        if (cls == Double.TYPE) {
            return 'd';
        }
        if (cls == Double.class) {
            return 'D';
        }
        if (cls == Float.TYPE) {
            return 'f';
        }
        if (cls == Float.class) {
            return 'F';
        }
        return cls == String.class ? 'S' : null;
    }

    public JavaMethodWrapper(JavaModuleWrapper javaModuleWrapper, Method method, boolean z) {
        this.mModuleWrapper = javaModuleWrapper;
        this.mMethod = method;
        this.mMethod.setAccessible(true);
        this.mParameterTypes = this.mMethod.getParameterTypes();
        this.mParamLength = this.mParameterTypes.length;
        if (z) {
            this.mType = BaseJavaModule.METHOD_TYPE_SYNC;
        } else if (this.mParamLength > null && this.mParameterTypes[this.mParamLength - true] == Promise.class) {
            this.mType = BaseJavaModule.METHOD_TYPE_PROMISE;
        }
    }

    private void processArguments() {
        if (!this.mArgumentsProcessed) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.mModuleWrapper.getName());
            stringBuilder.append(".");
            stringBuilder.append(this.mMethod.getName());
            SystraceMessage.beginSection(0, "processArguments").arg("method", stringBuilder.toString()).flush();
            try {
                this.mArgumentsProcessed = true;
                this.mArgumentExtractors = buildArgumentExtractors(this.mParameterTypes);
                this.mSignature = buildSignature(this.mMethod, this.mParameterTypes, this.mType.equals(BaseJavaModule.METHOD_TYPE_SYNC));
                this.mArguments = new Object[this.mParameterTypes.length];
                this.mJSArgumentsNeeded = calculateJSArgumentsNeeded();
            } finally {
                SystraceMessage.endSection(0).flush();
            }
        }
    }

    public Method getMethod() {
        return this.mMethod;
    }

    public String getSignature() {
        if (!this.mArgumentsProcessed) {
            processArguments();
        }
        return (String) Assertions.assertNotNull(this.mSignature);
    }

    private String buildSignature(Method method, Class[] clsArr, boolean z) {
        StringBuilder stringBuilder = new StringBuilder(clsArr.length + 2);
        if (z) {
            stringBuilder.append(returnTypeToChar(method.getReturnType()));
            stringBuilder.append('.');
        } else {
            stringBuilder.append("v.");
        }
        for (z = false; z < clsArr.length; z++) {
            Class cls = clsArr[z];
            if (cls == Promise.class) {
                boolean z2 = true;
                if (z != clsArr.length - 1) {
                    z2 = false;
                }
                Assertions.assertCondition(z2, "Promise must be used as last parameter only");
            }
            stringBuilder.append(paramTypeToChar(cls));
        }
        return stringBuilder.toString();
    }

    private ArgumentExtractor[] buildArgumentExtractors(Class[] clsArr) {
        ArgumentExtractor[] argumentExtractorArr = new ArgumentExtractor[clsArr.length];
        for (int i = 0; i < clsArr.length; i += argumentExtractorArr[i].getJSArgumentsNeeded()) {
            Class cls = clsArr[i];
            if (cls != Boolean.class) {
                if (cls != Boolean.TYPE) {
                    if (cls != Integer.class) {
                        if (cls != Integer.TYPE) {
                            if (cls != Double.class) {
                                if (cls != Double.TYPE) {
                                    if (cls != Float.class) {
                                        if (cls != Float.TYPE) {
                                            if (cls == String.class) {
                                                argumentExtractorArr[i] = ARGUMENT_EXTRACTOR_STRING;
                                            } else if (cls == Callback.class) {
                                                argumentExtractorArr[i] = ARGUMENT_EXTRACTOR_CALLBACK;
                                            } else if (cls == Promise.class) {
                                                argumentExtractorArr[i] = ARGUMENT_EXTRACTOR_PROMISE;
                                                boolean z = true;
                                                if (i != clsArr.length - 1) {
                                                    z = false;
                                                }
                                                Assertions.assertCondition(z, "Promise must be used as last parameter only");
                                            } else if (cls == ReadableMap.class) {
                                                argumentExtractorArr[i] = ARGUMENT_EXTRACTOR_MAP;
                                            } else if (cls == ReadableArray.class) {
                                                argumentExtractorArr[i] = ARGUMENT_EXTRACTOR_ARRAY;
                                            } else if (cls == Dynamic.class) {
                                                argumentExtractorArr[i] = ARGUMENT_EXTRACTOR_DYNAMIC;
                                            } else {
                                                StringBuilder stringBuilder = new StringBuilder();
                                                stringBuilder.append("Got unknown argument class: ");
                                                stringBuilder.append(cls.getSimpleName());
                                                throw new RuntimeException(stringBuilder.toString());
                                            }
                                        }
                                    }
                                    argumentExtractorArr[i] = ARGUMENT_EXTRACTOR_FLOAT;
                                }
                            }
                            argumentExtractorArr[i] = ARGUMENT_EXTRACTOR_DOUBLE;
                        }
                    }
                    argumentExtractorArr[i] = ARGUMENT_EXTRACTOR_INTEGER;
                }
            }
            argumentExtractorArr[i] = ARGUMENT_EXTRACTOR_BOOLEAN;
        }
        return argumentExtractorArr;
    }

    private int calculateJSArgumentsNeeded() {
        int i = 0;
        for (ArgumentExtractor jSArgumentsNeeded : (ArgumentExtractor[]) Assertions.assertNotNull(this.mArgumentExtractors)) {
            i += jSArgumentsNeeded.getJSArgumentsNeeded();
        }
        return i;
    }

    private String getAffectedRange(int i, int i2) {
        if (i2 > 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(i);
            stringBuilder.append("-");
            stringBuilder.append((i + i2) - 1);
            return stringBuilder.toString();
        }
        i2 = new StringBuilder();
        i2.append("");
        i2.append(i);
        return i2.toString();
    }

    public void invoke(JSInstance jSInstance, ReadableNativeArray readableNativeArray) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.mModuleWrapper.getName());
        stringBuilder2.append(".");
        stringBuilder2.append(this.mMethod.getName());
        Object stringBuilder3 = stringBuilder2.toString();
        SystraceMessage.beginSection(0, "callJavaModuleMethod").arg("method", stringBuilder3).flush();
        int i = 0;
        if (DEBUG) {
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.BRIDGE_CALLS, "JS->Java: %s.%s()", this.mModuleWrapper.getName(), this.mMethod.getName());
        }
        int i2;
        try {
            if (!this.mArgumentsProcessed) {
                processArguments();
            }
            if (this.mArguments == null || this.mArgumentExtractors == null) {
                throw new Error("processArguments failed");
            } else if (this.mJSArgumentsNeeded == readableNativeArray.size()) {
                i2 = 0;
                while (i < this.mArgumentExtractors.length) {
                    this.mArguments[i] = this.mArgumentExtractors[i].extractArgument(jSInstance, readableNativeArray, i2);
                    i2 += this.mArgumentExtractors[i].getJSArgumentsNeeded();
                    i++;
                }
                this.mMethod.invoke(this.mModuleWrapper.getModule(), this.mArguments);
                SystraceMessage.endSection(0).flush();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(stringBuilder3);
                stringBuilder.append(" got ");
                stringBuilder.append(readableNativeArray.size());
                stringBuilder.append(" arguments, expected ");
                stringBuilder.append(this.mJSArgumentsNeeded);
                throw new NativeArgumentsParseException(stringBuilder.toString());
            }
        } catch (JSInstance jSInstance2) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(jSInstance2.getMessage());
            stringBuilder4.append(" (constructing arguments for ");
            stringBuilder4.append(stringBuilder3);
            stringBuilder4.append(" at argument index ");
            stringBuilder4.append(getAffectedRange(i2, this.mArgumentExtractors[i].getJSArgumentsNeeded()));
            stringBuilder4.append(")");
            throw new NativeArgumentsParseException(stringBuilder4.toString(), jSInstance2);
        } catch (JSInstance jSInstance22) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not invoke ");
            stringBuilder.append(stringBuilder3);
            throw new RuntimeException(stringBuilder.toString(), jSInstance22);
        } catch (JSInstance jSInstance222) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not invoke ");
            stringBuilder.append(stringBuilder3);
            throw new RuntimeException(stringBuilder.toString(), jSInstance222);
        } catch (JSInstance jSInstance2222) {
            if ((jSInstance2222.getCause() instanceof RuntimeException) != null) {
                throw ((RuntimeException) jSInstance2222.getCause());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not invoke ");
            stringBuilder.append(stringBuilder3);
            throw new RuntimeException(stringBuilder.toString(), jSInstance2222);
        } catch (Throwable th) {
            SystraceMessage.endSection(0).flush();
        }
    }

    public String getType() {
        return this.mType;
    }
}
