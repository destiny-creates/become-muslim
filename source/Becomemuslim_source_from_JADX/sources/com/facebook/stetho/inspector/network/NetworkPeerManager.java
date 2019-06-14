package com.facebook.stetho.inspector.network;

import android.content.Context;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;

public class NetworkPeerManager extends ChromePeerManager {
    private static NetworkPeerManager sInstance;
    private AsyncPrettyPrinterRegistry mAsyncPrettyPrinterRegistry;
    private AsyncPrettyPrinterInitializer mPrettyPrinterInitializer;
    private final ResponseBodyFileManager mResponseBodyFileManager;
    private final PeersRegisteredListener mTempFileCleanup = new C46801();

    /* renamed from: com.facebook.stetho.inspector.network.NetworkPeerManager$1 */
    class C46801 extends PeersRegisteredListener {
        C46801() {
        }

        protected void onFirstPeerRegistered() {
            AsyncPrettyPrinterExecutorHolder.ensureInitialized();
            if (NetworkPeerManager.this.mAsyncPrettyPrinterRegistry == null && NetworkPeerManager.this.mPrettyPrinterInitializer != null) {
                NetworkPeerManager.this.mAsyncPrettyPrinterRegistry = new AsyncPrettyPrinterRegistry();
                NetworkPeerManager.this.mPrettyPrinterInitializer.populatePrettyPrinters(NetworkPeerManager.this.mAsyncPrettyPrinterRegistry);
            }
            NetworkPeerManager.this.mResponseBodyFileManager.cleanupFiles();
        }

        protected void onLastPeerUnregistered() {
            NetworkPeerManager.this.mResponseBodyFileManager.cleanupFiles();
            AsyncPrettyPrinterExecutorHolder.shutdown();
        }
    }

    public static synchronized NetworkPeerManager getInstanceOrNull() {
        NetworkPeerManager networkPeerManager;
        synchronized (NetworkPeerManager.class) {
            networkPeerManager = sInstance;
        }
        return networkPeerManager;
    }

    public static synchronized NetworkPeerManager getOrCreateInstance(Context context) {
        synchronized (NetworkPeerManager.class) {
            if (sInstance == null) {
                sInstance = new NetworkPeerManager(new ResponseBodyFileManager(context.getApplicationContext()));
            }
            context = sInstance;
        }
        return context;
    }

    public NetworkPeerManager(ResponseBodyFileManager responseBodyFileManager) {
        this.mResponseBodyFileManager = responseBodyFileManager;
        setListener(this.mTempFileCleanup);
    }

    public ResponseBodyFileManager getResponseBodyFileManager() {
        return this.mResponseBodyFileManager;
    }

    public AsyncPrettyPrinterRegistry getAsyncPrettyPrinterRegistry() {
        return this.mAsyncPrettyPrinterRegistry;
    }

    public void setPrettyPrinterInitializer(AsyncPrettyPrinterInitializer asyncPrettyPrinterInitializer) {
        Util.throwIfNotNull(this.mPrettyPrinterInitializer);
        this.mPrettyPrinterInitializer = (AsyncPrettyPrinterInitializer) Util.throwIfNull(asyncPrettyPrinterInitializer);
    }
}
