package com.facebook.stetho.inspector;

import com.facebook.stetho.common.LogRedirector;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.PendingRequest;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError.ErrorCode;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcRequest;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcResponse;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.websocket.CloseCodes;
import com.facebook.stetho.websocket.SimpleEndpoint;
import com.facebook.stetho.websocket.SimpleSession;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ChromeDevtoolsServer implements SimpleEndpoint {
    public static final String PATH = "/inspector";
    private static final String TAG = "ChromeDevtoolsServer";
    private final MethodDispatcher mMethodDispatcher;
    private final ObjectMapper mObjectMapper = new ObjectMapper();
    private final Map<SimpleSession, JsonRpcPeer> mPeers = Collections.synchronizedMap(new HashMap());

    /* renamed from: com.facebook.stetho.inspector.ChromeDevtoolsServer$1 */
    static /* synthetic */ class C20571 {
        /* renamed from: $SwitchMap$com$facebook$stetho$inspector$jsonrpc$protocol$JsonRpcError$ErrorCode */
        static final /* synthetic */ int[] f4998x978b462 = new int[ErrorCode.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r0 = com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError.ErrorCode.values();
            r0 = r0.length;
            r0 = new int[r0];
            f4998x978b462 = r0;
            r0 = f4998x978b462;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError.ErrorCode.METHOD_NOT_FOUND;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.inspector.ChromeDevtoolsServer.1.<clinit>():void");
        }
    }

    public ChromeDevtoolsServer(Iterable<ChromeDevtoolsDomain> iterable) {
        this.mMethodDispatcher = new MethodDispatcher(this.mObjectMapper, iterable);
    }

    public void onOpen(SimpleSession simpleSession) {
        LogRedirector.m5728d(TAG, "onOpen");
        this.mPeers.put(simpleSession, new JsonRpcPeer(this.mObjectMapper, simpleSession));
    }

    public void onClose(SimpleSession simpleSession, int i, String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onClose: reason=");
        stringBuilder.append(i);
        stringBuilder.append(" ");
        stringBuilder.append(str);
        LogRedirector.m5728d(str2, stringBuilder.toString());
        JsonRpcPeer jsonRpcPeer = (JsonRpcPeer) this.mPeers.remove(simpleSession);
        if (jsonRpcPeer != null) {
            jsonRpcPeer.invokeDisconnectReceivers();
        }
    }

    public void onMessage(SimpleSession simpleSession, byte[] bArr, int i) {
        simpleSession = TAG;
        bArr = new StringBuilder();
        bArr.append("Ignoring binary message of length ");
        bArr.append(i);
        LogRedirector.m5728d(simpleSession, bArr.toString());
    }

    public void onMessage(SimpleSession simpleSession, String str) {
        String str2;
        if (LogRedirector.isLoggable(TAG, 2)) {
            String str3 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onMessage: message=");
            stringBuilder.append(str);
            LogRedirector.m5734v(str3, stringBuilder.toString());
        }
        try {
            JsonRpcPeer jsonRpcPeer = (JsonRpcPeer) this.mPeers.get(simpleSession);
            Util.throwIfNull(jsonRpcPeer);
            handleRemoteMessage(jsonRpcPeer, str);
        } catch (String str4) {
            if (LogRedirector.isLoggable(TAG, 2)) {
                str2 = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected I/O exception processing message: ");
                stringBuilder.append(str4);
                LogRedirector.m5734v(str2, stringBuilder.toString());
            }
            closeSafely(simpleSession, CloseCodes.UNEXPECTED_CONDITION, str4.getClass().getSimpleName());
        } catch (String str42) {
            str2 = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Message could not be processed by implementation: ");
            stringBuilder.append(str42);
            LogRedirector.m5732i(str2, stringBuilder.toString());
            closeSafely(simpleSession, CloseCodes.UNEXPECTED_CONDITION, str42.getClass().getSimpleName());
        } catch (String str422) {
            LogRedirector.m5735v(TAG, "Unexpected JSON exception processing message", str422);
            closeSafely(simpleSession, CloseCodes.UNEXPECTED_CONDITION, str422.getClass().getSimpleName());
        }
    }

    private void closeSafely(SimpleSession simpleSession, int i, String str) {
        simpleSession.close(i, str);
    }

    private void handleRemoteMessage(JsonRpcPeer jsonRpcPeer, String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("method")) {
            handleRemoteRequest(jsonRpcPeer, jSONObject);
        } else if (jSONObject.has("result")) {
            handleRemoteResponse(jsonRpcPeer, jSONObject);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Improper JSON-RPC message: ");
            stringBuilder.append(str);
            throw new MessageHandlingException(stringBuilder.toString());
        }
    }

    private void handleRemoteRequest(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        JSONObject dispatch;
        JSONObject jSONObject2;
        JsonRpcRequest jsonRpcRequest = (JsonRpcRequest) this.mObjectMapper.convertValue(jSONObject, JsonRpcRequest.class);
        try {
            dispatch = this.mMethodDispatcher.dispatch(jsonRpcPeer, jsonRpcRequest.method, jsonRpcRequest.params);
            jSONObject2 = null;
        } catch (JsonRpcException e) {
            logDispatchException(e);
            jSONObject2 = (JSONObject) this.mObjectMapper.convertValue(e.getErrorMessage(), JSONObject.class);
            dispatch = null;
        }
        if (jsonRpcRequest.id != null) {
            JsonRpcResponse jsonRpcResponse = new JsonRpcResponse();
            jsonRpcResponse.id = jsonRpcRequest.id.longValue();
            jsonRpcResponse.result = dispatch;
            jsonRpcResponse.error = jSONObject2;
            try {
                jSONObject = ((JSONObject) this.mObjectMapper.convertValue(jsonRpcResponse, JSONObject.class)).toString();
            } catch (JSONObject jSONObject3) {
                jsonRpcResponse.result = null;
                jsonRpcResponse.error = (JSONObject) this.mObjectMapper.convertValue(jSONObject3.getMessage(), JSONObject.class);
                jSONObject3 = ((JSONObject) this.mObjectMapper.convertValue(jsonRpcResponse, JSONObject.class)).toString();
            }
            jsonRpcPeer.getWebSocket().sendText(jSONObject3);
        }
    }

    private static void logDispatchException(JsonRpcException jsonRpcException) {
        JsonRpcError errorMessage = jsonRpcException.getErrorMessage();
        if (C20571.f4998x978b462[errorMessage.code.ordinal()] != 1) {
            LogRedirector.m5737w(TAG, "Error processing remote message", jsonRpcException);
            return;
        }
        jsonRpcException = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Method not implemented: ");
        stringBuilder.append(errorMessage.message);
        LogRedirector.m5728d(jsonRpcException, stringBuilder.toString());
    }

    private void handleRemoteResponse(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        JsonRpcResponse jsonRpcResponse = (JsonRpcResponse) this.mObjectMapper.convertValue(jSONObject, JsonRpcResponse.class);
        PendingRequest andRemovePendingRequest = jsonRpcPeer.getAndRemovePendingRequest(jsonRpcResponse.id);
        if (andRemovePendingRequest == null) {
            throw new MismatchedResponseException(jsonRpcResponse.id);
        } else if (andRemovePendingRequest.callback != null) {
            andRemovePendingRequest.callback.onResponse(jsonRpcPeer, jsonRpcResponse);
        }
    }

    public void onError(SimpleSession simpleSession, Throwable th) {
        simpleSession = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onError: ex=");
        stringBuilder.append(th.toString());
        LogRedirector.m5730e(simpleSession, stringBuilder.toString());
    }
}
