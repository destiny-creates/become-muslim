package com.facebook.react.bridge;

import android.content.Context;
import com.facebook.react.common.DebugServerException;

public abstract class JSBundleLoader {
    public abstract String loadScript(CatalystInstanceImpl catalystInstanceImpl);

    public static JSBundleLoader createAssetLoader(final Context context, final String str, final boolean z) {
        return new JSBundleLoader() {
            public String loadScript(CatalystInstanceImpl catalystInstanceImpl) {
                catalystInstanceImpl.loadScriptFromAssets(context.getAssets(), str, z);
                return str;
            }
        };
    }

    public static JSBundleLoader createFileLoader(String str) {
        return createFileLoader(str, str, false);
    }

    public static JSBundleLoader createFileLoader(final String str, final String str2, final boolean z) {
        return new JSBundleLoader() {
            public String loadScript(CatalystInstanceImpl catalystInstanceImpl) {
                catalystInstanceImpl.loadScriptFromFile(str, str2, z);
                return str;
            }
        };
    }

    public static JSBundleLoader createCachedBundleFromNetworkLoader(final String str, final String str2) {
        return new JSBundleLoader() {
            public String loadScript(CatalystInstanceImpl catalystInstanceImpl) {
                try {
                    catalystInstanceImpl.loadScriptFromFile(str2, str, false);
                    return str;
                } catch (CatalystInstanceImpl catalystInstanceImpl2) {
                    throw DebugServerException.makeGeneric(catalystInstanceImpl2.getMessage(), catalystInstanceImpl2);
                }
            }
        };
    }

    public static JSBundleLoader createDeltaFromNetworkLoader(final String str, final NativeDeltaClient nativeDeltaClient) {
        return new JSBundleLoader() {
            public String loadScript(CatalystInstanceImpl catalystInstanceImpl) {
                try {
                    catalystInstanceImpl.loadScriptFromDeltaBundle(str, nativeDeltaClient, false);
                    return str;
                } catch (CatalystInstanceImpl catalystInstanceImpl2) {
                    throw DebugServerException.makeGeneric(catalystInstanceImpl2.getMessage(), catalystInstanceImpl2);
                }
            }
        };
    }

    public static JSBundleLoader createRemoteDebuggerBundleLoader(final String str, final String str2) {
        return new JSBundleLoader() {
            public String loadScript(CatalystInstanceImpl catalystInstanceImpl) {
                catalystInstanceImpl.setSourceURLs(str2, str);
                return str2;
            }
        };
    }
}
