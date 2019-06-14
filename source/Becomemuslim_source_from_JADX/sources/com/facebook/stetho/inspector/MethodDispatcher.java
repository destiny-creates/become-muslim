package com.facebook.stetho.inspector;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.EmptyResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError.ErrorCode;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class MethodDispatcher {
    private final Iterable<ChromeDevtoolsDomain> mDomainHandlers;
    private Map<String, MethodDispatchHelper> mMethods;
    private final ObjectMapper mObjectMapper;

    private static class MethodDispatchHelper {
        private final ChromeDevtoolsDomain mInstance;
        private final Method mMethod;
        private final ObjectMapper mObjectMapper;

        public MethodDispatchHelper(ObjectMapper objectMapper, ChromeDevtoolsDomain chromeDevtoolsDomain, Method method) {
            this.mObjectMapper = objectMapper;
            this.mInstance = chromeDevtoolsDomain;
            this.mMethod = method;
        }

        public JSONObject invoke(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
            jsonRpcPeer = this.mMethod.invoke(this.mInstance, new Object[]{jsonRpcPeer, jSONObject});
            if (jsonRpcPeer != null) {
                if ((jsonRpcPeer instanceof EmptyResult) == null) {
                    return (JSONObject) this.mObjectMapper.convertValue((JsonRpcResult) jsonRpcPeer, JSONObject.class);
                }
            }
            return new JSONObject();
        }
    }

    public MethodDispatcher(ObjectMapper objectMapper, Iterable<ChromeDevtoolsDomain> iterable) {
        this.mObjectMapper = objectMapper;
        this.mDomainHandlers = iterable;
    }

    private synchronized MethodDispatchHelper findMethodDispatcher(String str) {
        if (this.mMethods == null) {
            this.mMethods = buildDispatchTable(this.mObjectMapper, this.mDomainHandlers);
        }
        return (MethodDispatchHelper) this.mMethods.get(str);
    }

    public JSONObject dispatch(JsonRpcPeer jsonRpcPeer, String str, JSONObject jSONObject) {
        MethodDispatchHelper findMethodDispatcher = findMethodDispatcher(str);
        if (findMethodDispatcher != null) {
            try {
                return findMethodDispatcher.invoke(jsonRpcPeer, jSONObject);
            } catch (JsonRpcPeer jsonRpcPeer2) {
                jsonRpcPeer2 = jsonRpcPeer2.getCause();
                ExceptionUtil.propagateIfInstanceOf(jsonRpcPeer2, JsonRpcException.class);
                throw ExceptionUtil.propagate(jsonRpcPeer2);
            } catch (JsonRpcPeer jsonRpcPeer22) {
                throw new RuntimeException(jsonRpcPeer22);
            } catch (JsonRpcPeer jsonRpcPeer222) {
                throw new JsonRpcException(new JsonRpcError(ErrorCode.INTERNAL_ERROR, jsonRpcPeer222.toString(), null));
            }
        }
        ErrorCode errorCode = ErrorCode.METHOD_NOT_FOUND;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not implemented: ");
        stringBuilder.append(str);
        throw new JsonRpcException(new JsonRpcError(errorCode, stringBuilder.toString(), null));
    }

    private static Map<String, MethodDispatchHelper> buildDispatchTable(ObjectMapper objectMapper, Iterable<ChromeDevtoolsDomain> iterable) {
        Util.throwIfNull(objectMapper);
        Map hashMap = new HashMap();
        for (ChromeDevtoolsDomain chromeDevtoolsDomain : (Iterable) Util.throwIfNull(iterable)) {
            Class cls = chromeDevtoolsDomain.getClass();
            String simpleName = cls.getSimpleName();
            for (Method method : cls.getDeclaredMethods()) {
                if (isDevtoolsMethod(method)) {
                    MethodDispatchHelper methodDispatchHelper = new MethodDispatchHelper(objectMapper, chromeDevtoolsDomain, method);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(simpleName);
                    stringBuilder.append(".");
                    stringBuilder.append(method.getName());
                    hashMap.put(stringBuilder.toString(), methodDispatchHelper);
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    private static boolean isDevtoolsMethod(Method method) {
        if (!method.isAnnotationPresent(ChromeDevtoolsMethod.class)) {
            return false;
        }
        Class[] parameterTypes = method.getParameterTypes();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(method.getDeclaringClass().getSimpleName());
        stringBuilder.append(".");
        stringBuilder.append(method.getName());
        String stringBuilder2 = stringBuilder.toString();
        Util.throwIfNot(parameterTypes.length == 2, "%s: expected 2 args, got %s", stringBuilder2, Integer.valueOf(parameterTypes.length));
        Util.throwIfNot(parameterTypes[0].equals(JsonRpcPeer.class), "%s: expected 1st arg of JsonRpcPeer, got %s", stringBuilder2, parameterTypes[0].getName());
        Util.throwIfNot(parameterTypes[1].equals(JSONObject.class), "%s: expected 2nd arg of JSONObject, got %s", stringBuilder2, parameterTypes[1].getName());
        method = method.getReturnType();
        if (!method.equals(Void.TYPE)) {
            Util.throwIfNot(JsonRpcResult.class.isAssignableFrom(method), "%s: expected JsonRpcResult return type, got %s", stringBuilder2, method.getName());
        }
        return true;
    }
}
