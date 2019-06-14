package com.facebook.stetho.inspector.protocol.module;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.console.RuntimeRepl;
import com.facebook.stetho.inspector.console.RuntimeReplFactory;
import com.facebook.stetho.inspector.helper.ObjectIdMapper;
import com.facebook.stetho.inspector.jsonrpc.DisconnectReceiver;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError.ErrorCode;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.inspector.runtime.RhinoDetectingRuntimeReplFactory;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.facebook.stetho.json.annotation.JsonValue;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class Runtime implements ChromeDevtoolsDomain {
    private static final Map<JsonRpcPeer, Session> sSessions = Collections.synchronizedMap(new HashMap());
    private final ObjectMapper mObjectMapper;
    private final RuntimeReplFactory mReplFactory;

    private static class CallArgument {
        @JsonProperty(required = false)
        public String objectId;
        @JsonProperty(required = false)
        public ObjectType type;
        @JsonProperty(required = false)
        public Object value;

        private CallArgument() {
        }
    }

    private static class CallFunctionOnRequest {
        @JsonProperty
        public List<CallArgument> arguments;
        @JsonProperty(required = false)
        public Boolean doNotPauseOnExceptionsAndMuteConsole;
        @JsonProperty
        public String functionDeclaration;
        @JsonProperty(required = false)
        public Boolean generatePreview;
        @JsonProperty
        public String objectId;
        @JsonProperty(required = false)
        public Boolean returnByValue;

        private CallFunctionOnRequest() {
        }
    }

    private static class ExceptionDetails {
        @JsonProperty(required = true)
        public String text;

        private ExceptionDetails() {
        }
    }

    private static class ObjectProtoContainer {
        public final Object object;

        public ObjectProtoContainer(Object obj) {
            this.object = obj;
        }
    }

    public enum ObjectSubType {
        ARRAY("array"),
        NULL("null"),
        NODE("node"),
        REGEXP("regexp"),
        DATE("date"),
        MAP("map"),
        SET("set"),
        ITERATOR("iterator"),
        GENERATOR("generator"),
        ERROR("error");
        
        private final String mProtocolValue;

        private ObjectSubType(String str) {
            this.mProtocolValue = str;
        }

        @JsonValue
        public String getProtocolValue() {
            return this.mProtocolValue;
        }
    }

    public enum ObjectType {
        OBJECT("object"),
        FUNCTION("function"),
        UNDEFINED("undefined"),
        STRING("string"),
        NUMBER("number"),
        BOOLEAN("boolean"),
        SYMBOL("symbol");
        
        private final String mProtocolValue;

        private ObjectType(String str) {
            this.mProtocolValue = str;
        }

        @JsonValue
        public String getProtocolValue() {
            return this.mProtocolValue;
        }
    }

    private static class PropertyDescriptor {
        @JsonProperty(required = true)
        public final boolean configurable;
        @JsonProperty(required = true)
        public final boolean enumerable;
        @JsonProperty(required = true)
        public final boolean isOwn;
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public RemoteObject value;
        @JsonProperty(required = true)
        public final boolean writable;

        private PropertyDescriptor() {
            this.isOwn = true;
            this.configurable = false;
            this.enumerable = true;
            this.writable = false;
        }
    }

    public static class RemoteObject {
        @JsonProperty
        public String className;
        @JsonProperty
        public String description;
        @JsonProperty
        public String objectId;
        @JsonProperty
        public ObjectSubType subtype;
        @JsonProperty(required = true)
        public ObjectType type;
        @JsonProperty
        public Object value;
    }

    private static class Session {
        private final ObjectMapper mObjectMapper;
        private final ObjectIdMapper mObjects;
        private RuntimeRepl mRepl;

        private Session() {
            this.mObjects = new ObjectIdMapper();
            this.mObjectMapper = new ObjectMapper();
        }

        public ObjectIdMapper getObjects() {
            return this.mObjects;
        }

        public Object getObjectOrThrow(String str) {
            Object objectForId = getObjects().getObjectForId(Integer.parseInt(str));
            if (objectForId != null) {
                return objectForId;
            }
            ErrorCode errorCode = ErrorCode.INVALID_REQUEST;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No object found for ");
            stringBuilder.append(str);
            throw new JsonRpcException(new JsonRpcError(errorCode, stringBuilder.toString(), null));
        }

        public RemoteObject objectForRemote(Object obj) {
            RemoteObject remoteObject = new RemoteObject();
            if (obj == null) {
                remoteObject.type = ObjectType.OBJECT;
                remoteObject.subtype = ObjectSubType.NULL;
                remoteObject.value = JSONObject.NULL;
            } else if (obj instanceof Boolean) {
                remoteObject.type = ObjectType.BOOLEAN;
                remoteObject.value = obj;
            } else if (obj instanceof Number) {
                remoteObject.type = ObjectType.NUMBER;
                remoteObject.value = obj;
            } else if (obj instanceof Character) {
                remoteObject.type = ObjectType.NUMBER;
                remoteObject.value = Integer.valueOf(((Character) obj).charValue());
            } else if (obj instanceof String) {
                remoteObject.type = ObjectType.STRING;
                remoteObject.value = String.valueOf(obj);
            } else {
                remoteObject.type = ObjectType.OBJECT;
                remoteObject.className = "What??";
                remoteObject.objectId = String.valueOf(this.mObjects.putObject(obj));
                if (obj.getClass().isArray()) {
                    remoteObject.description = "array";
                } else if (obj instanceof List) {
                    remoteObject.description = "List";
                } else if (obj instanceof Set) {
                    remoteObject.description = "Set";
                } else if (obj instanceof Map) {
                    remoteObject.description = "Map";
                } else {
                    remoteObject.description = Runtime.getPropertyClassName(obj);
                }
            }
            return remoteObject;
        }

        public EvaluateResponse evaluate(RuntimeReplFactory runtimeReplFactory, JSONObject jSONObject) {
            EvaluateRequest evaluateRequest = (EvaluateRequest) this.mObjectMapper.convertValue(jSONObject, EvaluateRequest.class);
            try {
                if (evaluateRequest.objectGroup.equals("console")) {
                    return buildNormalResponse(getRepl(runtimeReplFactory).evaluate(evaluateRequest.expression));
                }
                return buildExceptionResponse("Not supported by FAB");
            } catch (RuntimeReplFactory runtimeReplFactory2) {
                return buildExceptionResponse(runtimeReplFactory2);
            }
        }

        private synchronized RuntimeRepl getRepl(RuntimeReplFactory runtimeReplFactory) {
            if (this.mRepl == null) {
                this.mRepl = runtimeReplFactory.newInstance();
            }
            return this.mRepl;
        }

        private EvaluateResponse buildNormalResponse(Object obj) {
            EvaluateResponse evaluateResponse = new EvaluateResponse();
            evaluateResponse.wasThrown = false;
            evaluateResponse.result = objectForRemote(obj);
            return evaluateResponse;
        }

        private EvaluateResponse buildExceptionResponse(Object obj) {
            EvaluateResponse evaluateResponse = new EvaluateResponse();
            evaluateResponse.wasThrown = true;
            evaluateResponse.result = objectForRemote(obj);
            evaluateResponse.exceptionDetails = new ExceptionDetails();
            evaluateResponse.exceptionDetails.text = obj.toString();
            return evaluateResponse;
        }

        public GetPropertiesResponse getProperties(JSONObject jSONObject) {
            GetPropertiesRequest getPropertiesRequest = (GetPropertiesRequest) this.mObjectMapper.convertValue(jSONObject, GetPropertiesRequest.class);
            if (getPropertiesRequest.ownProperties) {
                jSONObject = getObjectOrThrow(getPropertiesRequest.objectId);
                if (jSONObject.getClass().isArray()) {
                    jSONObject = arrayToList(jSONObject);
                }
                if (jSONObject instanceof ObjectProtoContainer) {
                    return getPropertiesForProtoContainer((ObjectProtoContainer) jSONObject);
                }
                if (jSONObject instanceof List) {
                    return getPropertiesForIterable((List) jSONObject, true);
                }
                if (jSONObject instanceof Set) {
                    return getPropertiesForIterable((Set) jSONObject, false);
                }
                if (jSONObject instanceof Map) {
                    return getPropertiesForMap(jSONObject);
                }
                return getPropertiesForObject(jSONObject);
            }
            jSONObject = new GetPropertiesResponse();
            jSONObject.result = new ArrayList();
            return jSONObject;
        }

        private List<?> arrayToList(Object obj) {
            Class cls = obj.getClass();
            if (!cls.isArray()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Argument must be an array.  Was ");
                stringBuilder.append(cls);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (!cls.getComponentType().isPrimitive()) {
                return Arrays.asList((Object[]) obj);
            } else {
                int length = Array.getLength(obj);
                List<?> arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(Array.get(obj, i));
                }
                return arrayList;
            }
        }

        private GetPropertiesResponse getPropertiesForProtoContainer(ObjectProtoContainer objectProtoContainer) {
            objectProtoContainer = objectProtoContainer.object;
            RemoteObject remoteObject = new RemoteObject();
            remoteObject.type = ObjectType.OBJECT;
            remoteObject.subtype = ObjectSubType.NODE;
            remoteObject.className = objectProtoContainer.getClass().getName();
            remoteObject.description = Runtime.getPropertyClassName(objectProtoContainer);
            remoteObject.objectId = String.valueOf(this.mObjects.putObject(objectProtoContainer));
            objectProtoContainer = new PropertyDescriptor();
            objectProtoContainer.name = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            objectProtoContainer.value = remoteObject;
            GetPropertiesResponse getPropertiesResponse = new GetPropertiesResponse();
            getPropertiesResponse.result = new ArrayList(1);
            getPropertiesResponse.result.add(objectProtoContainer);
            return getPropertiesResponse;
        }

        private GetPropertiesResponse getPropertiesForIterable(Iterable<?> iterable, boolean z) {
            GetPropertiesResponse getPropertiesResponse = new GetPropertiesResponse();
            List arrayList = new ArrayList();
            int i = 0;
            for (Object next : iterable) {
                int i2;
                String valueOf;
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor();
                if (z) {
                    i2 = i + 1;
                    valueOf = String.valueOf(i);
                } else {
                    i2 = i;
                    valueOf = null;
                }
                propertyDescriptor.name = valueOf;
                propertyDescriptor.value = objectForRemote(next);
                arrayList.add(propertyDescriptor);
                i = i2;
            }
            getPropertiesResponse.result = arrayList;
            return getPropertiesResponse;
        }

        private GetPropertiesResponse getPropertiesForMap(Object obj) {
            GetPropertiesResponse getPropertiesResponse = new GetPropertiesResponse();
            List arrayList = new ArrayList();
            for (Entry entry : ((Map) obj).entrySet()) {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor();
                propertyDescriptor.name = String.valueOf(entry.getKey());
                propertyDescriptor.value = objectForRemote(entry.getValue());
                arrayList.add(propertyDescriptor);
            }
            getPropertiesResponse.result = arrayList;
            return getPropertiesResponse;
        }

        private GetPropertiesResponse getPropertiesForObject(Object obj) {
            GetPropertiesResponse getPropertiesResponse = new GetPropertiesResponse();
            List arrayList = new ArrayList();
            for (Class cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
                String str;
                List<Field> arrayList2 = new ArrayList(Arrays.asList(cls.getDeclaredFields()));
                Collections.reverse(arrayList2);
                if (cls == obj.getClass()) {
                    str = "";
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(cls.getSimpleName());
                    stringBuilder.append(".");
                    str = stringBuilder.toString();
                }
                for (Field field : arrayList2) {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        field.setAccessible(true);
                        try {
                            Object obj2 = field.get(obj);
                            PropertyDescriptor propertyDescriptor = new PropertyDescriptor();
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(str);
                            stringBuilder2.append(field.getName());
                            propertyDescriptor.name = stringBuilder2.toString();
                            propertyDescriptor.value = objectForRemote(obj2);
                            arrayList.add(propertyDescriptor);
                        } catch (Object obj3) {
                            throw new RuntimeException(obj3);
                        }
                    }
                }
            }
            Collections.reverse(arrayList);
            getPropertiesResponse.result = arrayList;
            return getPropertiesResponse;
        }
    }

    /* renamed from: com.facebook.stetho.inspector.protocol.module.Runtime$1 */
    class C39681 implements RuntimeReplFactory {

        /* renamed from: com.facebook.stetho.inspector.protocol.module.Runtime$1$1 */
        class C39671 implements RuntimeRepl {
            public Object evaluate(String str) {
                return "Not supported with legacy Runtime module";
            }

            C39671() {
            }
        }

        C39681() {
        }

        public RuntimeRepl newInstance() {
            return new C39671();
        }
    }

    private static class CallFunctionOnResponse implements JsonRpcResult {
        @JsonProperty
        public RemoteObject result;
        @JsonProperty(required = false)
        public Boolean wasThrown;

        private CallFunctionOnResponse() {
        }
    }

    private static class EvaluateRequest implements JsonRpcResult {
        @JsonProperty(required = true)
        public String expression;
        @JsonProperty(required = true)
        public String objectGroup;

        private EvaluateRequest() {
        }
    }

    private static class EvaluateResponse implements JsonRpcResult {
        @JsonProperty
        public ExceptionDetails exceptionDetails;
        @JsonProperty(required = true)
        public RemoteObject result;
        @JsonProperty(required = true)
        public boolean wasThrown;

        private EvaluateResponse() {
        }
    }

    private static class GetPropertiesRequest implements JsonRpcResult {
        @JsonProperty(required = true)
        public String objectId;
        @JsonProperty(required = true)
        public boolean ownProperties;

        private GetPropertiesRequest() {
        }
    }

    private static class GetPropertiesResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public List<PropertyDescriptor> result;

        private GetPropertiesResponse() {
        }
    }

    @Deprecated
    public Runtime() {
        this(new C39681());
    }

    public Runtime(Context context) {
        this(new RhinoDetectingRuntimeReplFactory(context));
    }

    public Runtime(RuntimeReplFactory runtimeReplFactory) {
        this.mObjectMapper = new ObjectMapper();
        this.mReplFactory = runtimeReplFactory;
    }

    public static int mapObject(JsonRpcPeer jsonRpcPeer, Object obj) {
        return getSession(jsonRpcPeer).getObjects().putObject(obj);
    }

    private static synchronized Session getSession(final JsonRpcPeer jsonRpcPeer) {
        Session session;
        synchronized (Runtime.class) {
            session = (Session) sSessions.get(jsonRpcPeer);
            if (session == null) {
                session = new Session();
                sSessions.put(jsonRpcPeer, session);
                jsonRpcPeer.registerDisconnectReceiver(new DisconnectReceiver() {
                    public void onDisconnect() {
                        Runtime.sSessions.remove(jsonRpcPeer);
                    }
                });
            }
        }
        return session;
    }

    @ChromeDevtoolsMethod
    public void releaseObject(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        getSession(jsonRpcPeer).getObjects().removeObjectById(Integer.parseInt(jSONObject.getString("objectId")));
    }

    @ChromeDevtoolsMethod
    public void releaseObjectGroup(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        jsonRpcPeer = new StringBuilder();
        jsonRpcPeer.append("Ignoring request to releaseObjectGroup: ");
        jsonRpcPeer.append(jSONObject);
        LogUtil.m5754w(jsonRpcPeer.toString());
    }

    @ChromeDevtoolsMethod
    public CallFunctionOnResponse callFunctionOn(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        CallFunctionOnRequest callFunctionOnRequest = (CallFunctionOnRequest) this.mObjectMapper.convertValue(jSONObject, CallFunctionOnRequest.class);
        jsonRpcPeer = getSession(jsonRpcPeer);
        Object objectOrThrow = jsonRpcPeer.getObjectOrThrow(callFunctionOnRequest.objectId);
        if (callFunctionOnRequest.functionDeclaration.startsWith("function protoList(")) {
            jSONObject = new ObjectProtoContainer(objectOrThrow);
            RemoteObject remoteObject = new RemoteObject();
            remoteObject.type = ObjectType.OBJECT;
            remoteObject.subtype = ObjectSubType.NODE;
            remoteObject.className = objectOrThrow.getClass().getName();
            remoteObject.description = getPropertyClassName(objectOrThrow);
            remoteObject.objectId = String.valueOf(jsonRpcPeer.getObjects().putObject(jSONObject));
            jsonRpcPeer = new CallFunctionOnResponse();
            jsonRpcPeer.result = remoteObject;
            jsonRpcPeer.wasThrown = Boolean.valueOf(null);
            return jsonRpcPeer;
        }
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected protoList, got: ");
        stringBuilder.append(callFunctionOnRequest.functionDeclaration);
        throw new JsonRpcException(new JsonRpcError(errorCode, stringBuilder.toString(), null));
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult evaluate(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        return getSession(jsonRpcPeer).evaluate(this.mReplFactory, jSONObject);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getProperties(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        return getSession(jsonRpcPeer).getProperties(jSONObject);
    }

    private static String getPropertyClassName(Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        return (simpleName == null || simpleName.length() == 0) ? obj.getClass().getName() : simpleName;
    }
}
