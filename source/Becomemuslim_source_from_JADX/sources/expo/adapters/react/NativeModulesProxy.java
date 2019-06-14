package expo.adapters.react;

import android.util.SparseArray;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import expo.p304a.C6006c;
import expo.p304a.C6006c.C6005a;
import expo.p304a.C6007d;
import expo.p304a.C6012g;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class NativeModulesProxy extends ReactContextBaseJavaModule {
    private static final String ARGS_TYPES_MISMATCH_ERROR = "E_ARGS_TYPES_MISMATCH";
    private static final String EXPORTED_METHODS_KEY = "exportedMethods";
    private static final String METHOD_INFO_ARGUMENTS_COUNT = "argumentsCount";
    private static final String METHOD_INFO_KEY = "key";
    private static final String METHOD_INFO_NAME = "name";
    private static final String MODULES_CONSTANTS_KEY = "modulesConstants";
    private static final String NAME = "ExpoNativeModuleProxy";
    private static final String UNDEFINED_METHOD_ERROR = "E_UNDEFINED_METHOD";
    private static final String UNEXPECTED_ERROR = "E_UNEXPECTED_ERROR";
    private static final String VIEW_MANAGERS_NAMES_KEY = "viewManagersNames";
    private Map<String, Map<String, Integer>> mExportedMethodsKeys = new HashMap();
    private Map<String, SparseArray<String>> mExportedMethodsReverseKeys = new HashMap();
    private C6007d mModuleRegistry;

    public String getName() {
        return NAME;
    }

    public NativeModulesProxy(ReactApplicationContext reactApplicationContext, C6007d c6007d) {
        super(reactApplicationContext);
        this.mModuleRegistry = c6007d;
    }

    public Map<String, Object> getConstants() {
        this.mModuleRegistry.m25143c();
        Collection<C6006c> b = this.mModuleRegistry.m25142b();
        Collection<C6012g> a = this.mModuleRegistry.m25135a();
        Map hashMap = new HashMap(b.size());
        Map hashMap2 = new HashMap(b.size());
        List arrayList = new ArrayList(a.size());
        for (C6006c c6006c : b) {
            String name = c6006c.getName();
            hashMap.put(name, c6006c.getConstants());
            List transformExportedMethodsMap = transformExportedMethodsMap(c6006c.getExportedMethods());
            assignExportedMethodsKeys(name, transformExportedMethodsMap);
            hashMap2.put(name, transformExportedMethodsMap);
        }
        for (C6012g name2 : a) {
            arrayList.add(name2.getName());
        }
        Map<String, Object> hashMap3 = new HashMap(2);
        hashMap3.put(MODULES_CONSTANTS_KEY, hashMap);
        hashMap3.put(EXPORTED_METHODS_KEY, hashMap2);
        hashMap3.put(VIEW_MANAGERS_NAMES_KEY, arrayList);
        return hashMap3;
    }

    @ReactMethod
    public void callMethod(String str, Dynamic dynamic, ReadableArray readableArray, Promise promise) {
        if (dynamic.getType() == ReadableType.String) {
            dynamic = dynamic.asString();
        } else if (dynamic.getType() == ReadableType.Number) {
            dynamic = (String) ((SparseArray) this.mExportedMethodsReverseKeys.get(str)).get(dynamic.asInt());
        } else {
            promise.reject(UNEXPECTED_ERROR, "Method key is neither a String nor an Integer -- don't know how to map it to method name.");
            return;
        }
        try {
            readableArray = getNativeArgumentsForMethod(readableArray, (C6005a) this.mModuleRegistry.m25132a(str).getExportedMethodInfos().get(dynamic));
            readableArray.add(new C7371c(promise));
            this.mModuleRegistry.m25132a(str).invokeExportedMethod(dynamic, readableArray);
        } catch (String str2) {
            promise.reject(ARGS_TYPES_MISMATCH_ERROR, str2.getMessage(), str2);
        } catch (String str22) {
            dynamic = UNEXPECTED_ERROR;
            readableArray = new StringBuilder();
            readableArray.append("Encountered an exception while calling native method: ");
            readableArray.append(str22.getMessage());
            promise.reject(dynamic, readableArray.toString(), str22);
        } catch (ReadableArray readableArray2) {
            String str3 = UNDEFINED_METHOD_ERROR;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Method ");
            stringBuilder.append(dynamic);
            stringBuilder.append(" of Java module ");
            stringBuilder.append(str22);
            stringBuilder.append(" is undefined.");
            promise.reject(str3, stringBuilder.toString(), readableArray2);
        }
    }

    private static List<Object> getNativeArgumentsForMethod(ReadableArray readableArray, C6005a c6005a) {
        List<Object> arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(C6014a.m25157a(readableArray.getDynamic(i), c6005a.m25130a()[i]));
        }
        return arrayList;
    }

    private List<Map<String, Object>> transformExportedMethodsMap(Map<String, Method> map) {
        List<Map<String, Object>> arrayList = new ArrayList(map.size());
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            arrayList.add(getMethodInfo((String) entry.getKey(), (Method) entry.getValue()));
        }
        return arrayList;
    }

    private Map<String, Object> getMethodInfo(String str, Method method) {
        Map<String, Object> hashMap = new HashMap(1);
        hashMap.put("name", str);
        hashMap.put(METHOD_INFO_ARGUMENTS_COUNT, Integer.valueOf(method.getParameterTypes().length - 1));
        return hashMap;
    }

    private void assignExportedMethodsKeys(String str, List<Map<String, Object>> list) {
        if (this.mExportedMethodsKeys.get(str) == null) {
            this.mExportedMethodsKeys.put(str, new HashMap());
        }
        if (this.mExportedMethodsReverseKeys.get(str) == null) {
            this.mExportedMethodsReverseKeys.put(str, new SparseArray());
        }
        for (int i = 0; i < list.size(); i++) {
            Map map = (Map) list.get(i);
            if (map.get("name") == null || !(map.get("name") instanceof String)) {
                list = new StringBuilder();
                list.append("No method name in MethodInfo - ");
                list.append(map.toString());
                throw new RuntimeException(list.toString());
            }
            String str2 = (String) map.get("name");
            Integer num = (Integer) ((Map) this.mExportedMethodsKeys.get(str)).get(str2);
            if (num == null) {
                int size = ((Map) this.mExportedMethodsKeys.get(str)).values().size();
                map.put(METHOD_INFO_KEY, Integer.valueOf(size));
                ((Map) this.mExportedMethodsKeys.get(str)).put(str2, Integer.valueOf(size));
                ((SparseArray) this.mExportedMethodsReverseKeys.get(str)).put(size, str2);
            } else {
                map.put(METHOD_INFO_KEY, Integer.valueOf(num.intValue()));
            }
        }
    }
}
