package com.facebook.react.modules.netinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.p029e.C0385a;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;

@ReactModule(name = "NetInfo")
public class NetInfoModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private static final String CONNECTION_TYPE_BLUETOOTH = "bluetooth";
    private static final String CONNECTION_TYPE_CELLULAR = "cellular";
    private static final String CONNECTION_TYPE_ETHERNET = "ethernet";
    private static final String CONNECTION_TYPE_NONE = "none";
    private static final String CONNECTION_TYPE_NONE_DEPRECATED = "NONE";
    private static final String CONNECTION_TYPE_UNKNOWN = "unknown";
    private static final String CONNECTION_TYPE_UNKNOWN_DEPRECATED = "UNKNOWN";
    private static final String CONNECTION_TYPE_WIFI = "wifi";
    private static final String CONNECTION_TYPE_WIMAX = "wimax";
    private static final String EFFECTIVE_CONNECTION_TYPE_2G = "2g";
    private static final String EFFECTIVE_CONNECTION_TYPE_3G = "3g";
    private static final String EFFECTIVE_CONNECTION_TYPE_4G = "4g";
    private static final String EFFECTIVE_CONNECTION_TYPE_UNKNOWN = "unknown";
    private static final String ERROR_MISSING_PERMISSION = "E_MISSING_PERMISSION";
    private static final String MISSING_PERMISSION_MESSAGE = "To use NetInfo on Android, add the following to your AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />";
    private String mConnectionType = "unknown";
    private final ConnectivityBroadcastReceiver mConnectivityBroadcastReceiver;
    private String mConnectivityDeprecated = CONNECTION_TYPE_UNKNOWN_DEPRECATED;
    private final ConnectivityManager mConnectivityManager;
    private String mEffectiveConnectionType = "unknown";
    private boolean mNoNetworkPermission = false;

    private class ConnectivityBroadcastReceiver extends BroadcastReceiver {
        private boolean isRegistered;

        private ConnectivityBroadcastReceiver() {
            this.isRegistered = null;
        }

        public void setRegistered(boolean z) {
            this.isRegistered = z;
        }

        public boolean isRegistered() {
            return this.isRegistered;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") != null) {
                NetInfoModule.this.updateAndSendConnectionType();
            }
        }
    }

    public String getName() {
        return "NetInfo";
    }

    public void onHostDestroy() {
    }

    public NetInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mConnectivityManager = (ConnectivityManager) reactApplicationContext.getSystemService("connectivity");
        this.mConnectivityBroadcastReceiver = new ConnectivityBroadcastReceiver();
    }

    public void onHostResume() {
        registerReceiver();
    }

    public void onHostPause() {
        unregisterReceiver();
    }

    public void initialize() {
        getReactApplicationContext().addLifecycleEventListener(this);
    }

    @ReactMethod
    public void getCurrentConnectivity(Promise promise) {
        if (this.mNoNetworkPermission) {
            promise.reject(ERROR_MISSING_PERMISSION, MISSING_PERMISSION_MESSAGE, null);
        } else {
            promise.resolve(createConnectivityEventMap());
        }
    }

    @ReactMethod
    public void isConnectionMetered(Promise promise) {
        if (this.mNoNetworkPermission) {
            promise.reject(ERROR_MISSING_PERMISSION, MISSING_PERMISSION_MESSAGE, null);
        } else {
            promise.resolve(Boolean.valueOf(C0385a.m1164a(this.mConnectivityManager)));
        }
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        getReactApplicationContext().registerReceiver(this.mConnectivityBroadcastReceiver, intentFilter);
        this.mConnectivityBroadcastReceiver.setRegistered(true);
        updateAndSendConnectionType();
    }

    private void unregisterReceiver() {
        if (this.mConnectivityBroadcastReceiver.isRegistered()) {
            getReactApplicationContext().unregisterReceiver(this.mConnectivityBroadcastReceiver);
            this.mConnectivityBroadcastReceiver.setRegistered(false);
        }
    }

    private void updateAndSendConnectionType() {
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
        r4 = this;
        r0 = "unknown";
        r1 = r4.mConnectivityManager;	 Catch:{ SecurityException -> 0x0033 }
        r1 = r1.getActiveNetworkInfo();	 Catch:{ SecurityException -> 0x0033 }
        if (r1 == 0) goto L_0x0030;	 Catch:{ SecurityException -> 0x0033 }
    L_0x000a:
        r2 = r1.isConnected();	 Catch:{ SecurityException -> 0x0033 }
        if (r2 != 0) goto L_0x0011;	 Catch:{ SecurityException -> 0x0033 }
    L_0x0010:
        goto L_0x0030;	 Catch:{ SecurityException -> 0x0033 }
    L_0x0011:
        r2 = r1.getType();	 Catch:{ SecurityException -> 0x0033 }
        switch(r2) {
            case 0: goto L_0x0027;
            case 1: goto L_0x0024;
            case 2: goto L_0x0018;
            case 3: goto L_0x0018;
            case 4: goto L_0x0027;
            case 5: goto L_0x0018;
            case 6: goto L_0x0021;
            case 7: goto L_0x001e;
            case 8: goto L_0x0018;
            case 9: goto L_0x001b;
            default: goto L_0x0018;
        };	 Catch:{ SecurityException -> 0x0033 }
    L_0x0018:
        r1 = "unknown";	 Catch:{ SecurityException -> 0x0033 }
        goto L_0x0038;	 Catch:{ SecurityException -> 0x0033 }
    L_0x001b:
        r1 = "ethernet";	 Catch:{ SecurityException -> 0x0033 }
        goto L_0x0038;	 Catch:{ SecurityException -> 0x0033 }
    L_0x001e:
        r1 = "bluetooth";	 Catch:{ SecurityException -> 0x0033 }
        goto L_0x0038;	 Catch:{ SecurityException -> 0x0033 }
    L_0x0021:
        r1 = "wimax";	 Catch:{ SecurityException -> 0x0033 }
        goto L_0x0038;	 Catch:{ SecurityException -> 0x0033 }
    L_0x0024:
        r1 = "wifi";	 Catch:{ SecurityException -> 0x0033 }
        goto L_0x0038;	 Catch:{ SecurityException -> 0x0033 }
    L_0x0027:
        r2 = "cellular";	 Catch:{ SecurityException -> 0x0033 }
        r1 = r4.getEffectiveConnectionType(r1);	 Catch:{ SecurityException -> 0x0033 }
        r0 = r1;	 Catch:{ SecurityException -> 0x0033 }
        r1 = r2;	 Catch:{ SecurityException -> 0x0033 }
        goto L_0x0038;	 Catch:{ SecurityException -> 0x0033 }
    L_0x0030:
        r1 = "none";	 Catch:{ SecurityException -> 0x0033 }
        goto L_0x0038;
    L_0x0033:
        r1 = 1;
        r4.mNoNetworkPermission = r1;
        r1 = "unknown";
    L_0x0038:
        r2 = r4.getCurrentConnectionType();
        r3 = r4.mConnectionType;
        r3 = r1.equalsIgnoreCase(r3);
        if (r3 == 0) goto L_0x0054;
    L_0x0044:
        r3 = r4.mEffectiveConnectionType;
        r3 = r0.equalsIgnoreCase(r3);
        if (r3 == 0) goto L_0x0054;
    L_0x004c:
        r3 = r4.mConnectivityDeprecated;
        r3 = r2.equalsIgnoreCase(r3);
        if (r3 != 0) goto L_0x005d;
    L_0x0054:
        r4.mConnectionType = r1;
        r4.mEffectiveConnectionType = r0;
        r4.mConnectivityDeprecated = r2;
        r4.sendConnectivityChangedEvent();
    L_0x005d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.netinfo.NetInfoModule.updateAndSendConnectionType():void");
    }

    private java.lang.String getCurrentConnectionType() {
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
        r2 = this;
        r0 = r2.mConnectivityManager;	 Catch:{ SecurityException -> 0x0028 }
        r0 = r0.getActiveNetworkInfo();	 Catch:{ SecurityException -> 0x0028 }
        if (r0 == 0) goto L_0x0025;	 Catch:{ SecurityException -> 0x0028 }
    L_0x0008:
        r1 = r0.isConnected();	 Catch:{ SecurityException -> 0x0028 }
        if (r1 != 0) goto L_0x000f;	 Catch:{ SecurityException -> 0x0028 }
    L_0x000e:
        goto L_0x0025;	 Catch:{ SecurityException -> 0x0028 }
    L_0x000f:
        r1 = r0.getType();	 Catch:{ SecurityException -> 0x0028 }
        r1 = android.net.ConnectivityManager.isNetworkTypeValid(r1);	 Catch:{ SecurityException -> 0x0028 }
        if (r1 == 0) goto L_0x0022;	 Catch:{ SecurityException -> 0x0028 }
    L_0x0019:
        r0 = r0.getTypeName();	 Catch:{ SecurityException -> 0x0028 }
        r0 = r0.toUpperCase();	 Catch:{ SecurityException -> 0x0028 }
        return r0;	 Catch:{ SecurityException -> 0x0028 }
    L_0x0022:
        r0 = "UNKNOWN";	 Catch:{ SecurityException -> 0x0028 }
        return r0;	 Catch:{ SecurityException -> 0x0028 }
    L_0x0025:
        r0 = "NONE";	 Catch:{ SecurityException -> 0x0028 }
        return r0;
    L_0x0028:
        r0 = 1;
        r2.mNoNetworkPermission = r0;
        r0 = "UNKNOWN";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.netinfo.NetInfoModule.getCurrentConnectionType():java.lang.String");
    }

    private String getEffectiveConnectionType(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return EFFECTIVE_CONNECTION_TYPE_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
                return EFFECTIVE_CONNECTION_TYPE_3G;
            case 13:
            case 15:
                return EFFECTIVE_CONNECTION_TYPE_4G;
            default:
                return "unknown";
        }
    }

    private void sendConnectivityChangedEvent() {
        ((RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit("networkStatusDidChange", createConnectivityEventMap());
    }

    private WritableMap createConnectivityEventMap() {
        WritableMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("network_info", this.mConnectivityDeprecated);
        writableNativeMap.putString("connectionType", this.mConnectionType);
        writableNativeMap.putString("effectiveConnectionType", this.mEffectiveConnectionType);
        return writableNativeMap;
    }
}
