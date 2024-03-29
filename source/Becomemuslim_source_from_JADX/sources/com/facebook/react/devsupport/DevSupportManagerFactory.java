package com.facebook.react.devsupport;

import android.content.Context;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.packagerconnection.RequestHandler;
import java.util.Map;

public class DevSupportManagerFactory {
    private static final String DEVSUPPORT_IMPL_CLASS = "DevSupportManagerImpl";
    private static final String DEVSUPPORT_IMPL_PACKAGE = "com.facebook.react.devsupport";

    public static DevSupportManager create(Context context, ReactInstanceManagerDevHelper reactInstanceManagerDevHelper, String str, boolean z, int i) {
        return create(context, reactInstanceManagerDevHelper, str, z, null, null, i, null);
    }

    public static DevSupportManager create(Context context, ReactInstanceManagerDevHelper reactInstanceManagerDevHelper, String str, boolean z, RedBoxHandler redBoxHandler, DevBundleDownloadListener devBundleDownloadListener, int i, Map<String, RequestHandler> map) {
        if (!z) {
            return new DisabledDevSupportManager();
        }
        try {
            StringBuilder stringBuilder = new StringBuilder(DEVSUPPORT_IMPL_PACKAGE);
            stringBuilder.append(".");
            stringBuilder.append(DEVSUPPORT_IMPL_CLASS);
            return (DevSupportManager) Class.forName(stringBuilder.toString()).getConstructor(new Class[]{Context.class, ReactInstanceManagerDevHelper.class, String.class, Boolean.TYPE, RedBoxHandler.class, DevBundleDownloadListener.class, Integer.TYPE, Map.class}).newInstance(new Object[]{context, reactInstanceManagerDevHelper, str, Boolean.valueOf(true), redBoxHandler, devBundleDownloadListener, Integer.valueOf(i), map});
        } catch (Throwable e) {
            throw new RuntimeException("Requested enabled DevSupportManager, but DevSupportManagerImpl class was not found or could not be created", e);
        }
    }
}
