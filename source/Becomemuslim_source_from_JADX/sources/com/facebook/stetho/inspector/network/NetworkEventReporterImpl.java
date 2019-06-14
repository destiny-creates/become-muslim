package com.facebook.stetho.inspector.network;

import android.os.SystemClock;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorHeaders;
import com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorRequest;
import com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorResponse;
import com.facebook.stetho.inspector.protocol.module.Console.CallFrame;
import com.facebook.stetho.inspector.protocol.module.Console.MessageLevel;
import com.facebook.stetho.inspector.protocol.module.Console.MessageSource;
import com.facebook.stetho.inspector.protocol.module.Network.DataReceivedParams;
import com.facebook.stetho.inspector.protocol.module.Network.Initiator;
import com.facebook.stetho.inspector.protocol.module.Network.InitiatorType;
import com.facebook.stetho.inspector.protocol.module.Network.LoadingFailedParams;
import com.facebook.stetho.inspector.protocol.module.Network.LoadingFinishedParams;
import com.facebook.stetho.inspector.protocol.module.Network.Request;
import com.facebook.stetho.inspector.protocol.module.Network.RequestWillBeSentParams;
import com.facebook.stetho.inspector.protocol.module.Network.Response;
import com.facebook.stetho.inspector.protocol.module.Network.ResponseReceivedParams;
import com.facebook.stetho.inspector.protocol.module.Page.ResourceType;
import com.facebook.stetho.server.http.HttpHeaders;
import java.util.ArrayList;
import org.json.JSONObject;

public class NetworkEventReporterImpl implements NetworkEventReporter {
    private static NetworkEventReporter sInstance;
    private ResourceTypeHelper mResourceTypeHelper;

    private NetworkEventReporterImpl() {
    }

    public static synchronized NetworkEventReporter get() {
        NetworkEventReporter networkEventReporter;
        synchronized (NetworkEventReporterImpl.class) {
            if (sInstance == null) {
                sInstance = new NetworkEventReporterImpl();
            }
            networkEventReporter = sInstance;
        }
        return networkEventReporter;
    }

    public boolean isEnabled() {
        return getPeerManagerIfEnabled() != null;
    }

    private NetworkPeerManager getPeerManagerIfEnabled() {
        NetworkPeerManager instanceOrNull = NetworkPeerManager.getInstanceOrNull();
        return (instanceOrNull == null || !instanceOrNull.hasRegisteredPeers()) ? null : instanceOrNull;
    }

    public void requestWillBeSent(InspectorRequest inspectorRequest) {
        NetworkPeerManager peerManagerIfEnabled = getPeerManagerIfEnabled();
        if (peerManagerIfEnabled != null) {
            Request request = new Request();
            request.url = inspectorRequest.url();
            request.method = inspectorRequest.method();
            request.headers = formatHeadersAsJSON(inspectorRequest);
            request.postData = readBodyAsString(peerManagerIfEnabled, inspectorRequest);
            String friendlyName = inspectorRequest.friendlyName();
            Integer friendlyNameExtra = inspectorRequest.friendlyNameExtra();
            Initiator initiator = new Initiator();
            initiator.type = InitiatorType.SCRIPT;
            initiator.stackTrace = new ArrayList();
            initiator.stackTrace.add(new CallFrame(friendlyName, friendlyName, friendlyNameExtra != null ? friendlyNameExtra.intValue() : 0, 0));
            RequestWillBeSentParams requestWillBeSentParams = new RequestWillBeSentParams();
            requestWillBeSentParams.requestId = inspectorRequest.id();
            requestWillBeSentParams.frameId = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            requestWillBeSentParams.loaderId = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            requestWillBeSentParams.documentURL = inspectorRequest.url();
            requestWillBeSentParams.request = request;
            requestWillBeSentParams.timestamp = ((double) stethoNow()) / 1000.0d;
            requestWillBeSentParams.initiator = initiator;
            requestWillBeSentParams.redirectResponse = null;
            requestWillBeSentParams.type = ResourceType.OTHER;
            peerManagerIfEnabled.sendNotificationToPeers("Network.requestWillBeSent", requestWillBeSentParams);
        }
    }

    private static String readBodyAsString(NetworkPeerManager networkPeerManager, InspectorRequest inspectorRequest) {
        try {
            inspectorRequest = inspectorRequest.body();
            if (inspectorRequest != null) {
                return new String(inspectorRequest, Utf8Charset.INSTANCE);
            }
        } catch (InspectorRequest inspectorRequest2) {
            MessageLevel messageLevel = MessageLevel.WARNING;
            MessageSource messageSource = MessageSource.NETWORK;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not reproduce POST body: ");
            stringBuilder.append(inspectorRequest2);
            CLog.writeToConsole(networkPeerManager, messageLevel, messageSource, stringBuilder.toString());
        }
        return null;
    }

    public void responseHeadersReceived(InspectorResponse inspectorResponse) {
        NetworkPeerManager peerManagerIfEnabled = getPeerManagerIfEnabled();
        if (peerManagerIfEnabled != null) {
            Response response = new Response();
            response.url = inspectorResponse.url();
            response.status = inspectorResponse.statusCode();
            response.statusText = inspectorResponse.reasonPhrase();
            response.headers = formatHeadersAsJSON(inspectorResponse);
            String contentType = getContentType(inspectorResponse);
            response.mimeType = contentType != null ? getResourceTypeHelper().stripContentExtras(contentType) : "application/octet-stream";
            response.connectionReused = inspectorResponse.connectionReused();
            response.connectionId = inspectorResponse.connectionId();
            response.fromDiskCache = Boolean.valueOf(inspectorResponse.fromDiskCache());
            ResponseReceivedParams responseReceivedParams = new ResponseReceivedParams();
            responseReceivedParams.requestId = inspectorResponse.requestId();
            responseReceivedParams.frameId = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            responseReceivedParams.loaderId = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            responseReceivedParams.timestamp = ((double) stethoNow()) / 1000.0d;
            responseReceivedParams.response = response;
            responseReceivedParams.type = determineResourceType(initAsyncPrettyPrinterForResponse(inspectorResponse, peerManagerIfEnabled), contentType, getResourceTypeHelper());
            peerManagerIfEnabled.sendNotificationToPeers("Network.responseReceived", responseReceivedParams);
        }
    }

    private static AsyncPrettyPrinter initAsyncPrettyPrinterForResponse(InspectorResponse inspectorResponse, NetworkPeerManager networkPeerManager) {
        AsyncPrettyPrinter createPrettyPrinterForResponse = createPrettyPrinterForResponse(inspectorResponse, networkPeerManager.getAsyncPrettyPrinterRegistry());
        if (createPrettyPrinterForResponse != null) {
            networkPeerManager.getResponseBodyFileManager().associateAsyncPrettyPrinterWithId(inspectorResponse.requestId(), createPrettyPrinterForResponse);
        }
        return createPrettyPrinterForResponse;
    }

    private static ResourceType determineResourceType(AsyncPrettyPrinter asyncPrettyPrinter, String str, ResourceTypeHelper resourceTypeHelper) {
        if (asyncPrettyPrinter != null) {
            return asyncPrettyPrinter.getPrettifiedType().getResourceType();
        }
        return str != null ? resourceTypeHelper.determineResourceType(str) : ResourceType.OTHER;
    }

    static AsyncPrettyPrinter createPrettyPrinterForResponse(InspectorResponse inspectorResponse, AsyncPrettyPrinterRegistry asyncPrettyPrinterRegistry) {
        if (asyncPrettyPrinterRegistry != null) {
            int headerCount = inspectorResponse.headerCount();
            for (int i = 0; i < headerCount; i++) {
                AsyncPrettyPrinterFactory lookup = asyncPrettyPrinterRegistry.lookup(inspectorResponse.headerName(i));
                if (lookup != null) {
                    return lookup.getInstance(inspectorResponse.headerName(i), inspectorResponse.headerValue(i));
                }
            }
        }
        return null;
    }

    public java.io.InputStream interpretResponseStream(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.io.InputStream r11, com.facebook.stetho.inspector.network.ResponseHandler r12) {
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
        r7 = this;
        r6 = r7.getPeerManagerIfEnabled();
        if (r6 == 0) goto L_0x0049;
    L_0x0006:
        r0 = 0;
        if (r11 != 0) goto L_0x000d;
    L_0x0009:
        r12.onEOF();
        return r0;
    L_0x000d:
        if (r9 == 0) goto L_0x0017;
    L_0x000f:
        r0 = r7.getResourceTypeHelper();
        r0 = r0.determineResourceType(r9);
    L_0x0017:
        r9 = 0;
        if (r0 == 0) goto L_0x001f;
    L_0x001a:
        r1 = com.facebook.stetho.inspector.protocol.module.Page.ResourceType.IMAGE;
        if (r0 != r1) goto L_0x001f;
    L_0x001e:
        r9 = 1;
    L_0x001f:
        r0 = r6.getResponseBodyFileManager();	 Catch:{ IOException -> 0x0031 }
        r3 = r0.openResponseBodyFile(r8, r9);	 Catch:{ IOException -> 0x0031 }
        r0 = r6;	 Catch:{ IOException -> 0x0031 }
        r1 = r8;	 Catch:{ IOException -> 0x0031 }
        r2 = r11;	 Catch:{ IOException -> 0x0031 }
        r4 = r10;	 Catch:{ IOException -> 0x0031 }
        r5 = r12;	 Catch:{ IOException -> 0x0031 }
        r9 = com.facebook.stetho.inspector.network.DecompressionHelper.teeInputWithDecompression(r0, r1, r2, r3, r4, r5);	 Catch:{ IOException -> 0x0031 }
        return r9;
    L_0x0031:
        r9 = com.facebook.stetho.inspector.protocol.module.Console.MessageLevel.ERROR;
        r10 = com.facebook.stetho.inspector.protocol.module.Console.MessageSource.NETWORK;
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r0 = "Error writing response body data for request #";
        r12.append(r0);
        r12.append(r8);
        r8 = r12.toString();
        com.facebook.stetho.inspector.console.CLog.writeToConsole(r6, r9, r10, r8);
    L_0x0049:
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.inspector.network.NetworkEventReporterImpl.interpretResponseStream(java.lang.String, java.lang.String, java.lang.String, java.io.InputStream, com.facebook.stetho.inspector.network.ResponseHandler):java.io.InputStream");
    }

    public void httpExchangeFailed(String str, String str2) {
        loadingFailed(str, str2);
    }

    public void responseReadFinished(String str) {
        loadingFinished(str);
    }

    private void loadingFinished(String str) {
        NetworkPeerManager peerManagerIfEnabled = getPeerManagerIfEnabled();
        if (peerManagerIfEnabled != null) {
            LoadingFinishedParams loadingFinishedParams = new LoadingFinishedParams();
            loadingFinishedParams.requestId = str;
            loadingFinishedParams.timestamp = ((double) stethoNow()) / 1000.0d;
            peerManagerIfEnabled.sendNotificationToPeers("Network.loadingFinished", loadingFinishedParams);
        }
    }

    public void responseReadFailed(String str, String str2) {
        loadingFailed(str, str2);
    }

    private void loadingFailed(String str, String str2) {
        NetworkPeerManager peerManagerIfEnabled = getPeerManagerIfEnabled();
        if (peerManagerIfEnabled != null) {
            LoadingFailedParams loadingFailedParams = new LoadingFailedParams();
            loadingFailedParams.requestId = str;
            loadingFailedParams.timestamp = ((double) stethoNow()) / 1000.0d;
            loadingFailedParams.errorText = str2;
            loadingFailedParams.type = ResourceType.OTHER;
            peerManagerIfEnabled.sendNotificationToPeers("Network.loadingFailed", loadingFailedParams);
        }
    }

    public void dataSent(String str, int i, int i2) {
        dataReceived(str, i, i2);
    }

    public void dataReceived(String str, int i, int i2) {
        NetworkPeerManager peerManagerIfEnabled = getPeerManagerIfEnabled();
        if (peerManagerIfEnabled != null) {
            DataReceivedParams dataReceivedParams = new DataReceivedParams();
            dataReceivedParams.requestId = str;
            dataReceivedParams.timestamp = ((double) stethoNow()) / 1000.0d;
            dataReceivedParams.dataLength = i;
            dataReceivedParams.encodedDataLength = i2;
            peerManagerIfEnabled.sendNotificationToPeers("Network.dataReceived", dataReceivedParams);
        }
    }

    private String getContentType(InspectorHeaders inspectorHeaders) {
        return inspectorHeaders.firstHeaderValue(HttpHeaders.CONTENT_TYPE);
    }

    private static JSONObject formatHeadersAsJSON(InspectorHeaders inspectorHeaders) {
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        while (i < inspectorHeaders.headerCount()) {
            String headerName = inspectorHeaders.headerName(i);
            String headerValue = inspectorHeaders.headerValue(i);
            try {
                if (jSONObject.has(headerName)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(jSONObject.getString(headerName));
                    stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                    stringBuilder.append(headerValue);
                    jSONObject.put(headerName, stringBuilder.toString());
                } else {
                    jSONObject.put(headerName, headerValue);
                }
                i++;
            } catch (InspectorHeaders inspectorHeaders2) {
                throw new RuntimeException(inspectorHeaders2);
            }
        }
        return jSONObject;
    }

    private ResourceTypeHelper getResourceTypeHelper() {
        if (this.mResourceTypeHelper == null) {
            this.mResourceTypeHelper = new ResourceTypeHelper();
        }
        return this.mResourceTypeHelper;
    }

    private static long stethoNow() {
        return SystemClock.elapsedRealtime();
    }
}
