package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.common.ReactConstants;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@DoNotStrip
public class Inspector {
    private final HybridData mHybridData;

    @DoNotStrip
    public static class LocalConnection {
        private final HybridData mHybridData;

        public native void disconnect();

        public native void sendMessage(String str);

        private LocalConnection(HybridData hybridData) {
            this.mHybridData = hybridData;
        }
    }

    @DoNotStrip
    public static class Page {
        private final int mId;
        private final String mTitle;
        private final String mVM;

        public int getId() {
            return this.mId;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public String getVM() {
            return this.mVM;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Page{mId=");
            stringBuilder.append(this.mId);
            stringBuilder.append(", mTitle='");
            stringBuilder.append(this.mTitle);
            stringBuilder.append('\'');
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        @DoNotStrip
        private Page(int i, String str, String str2) {
            this.mId = i;
            this.mTitle = str;
            this.mVM = str2;
        }
    }

    @DoNotStrip
    public interface RemoteConnection {
        @DoNotStrip
        void onDisconnect();

        @DoNotStrip
        void onMessage(String str);
    }

    private native LocalConnection connectNative(int i, RemoteConnection remoteConnection);

    private native Page[] getPagesNative();

    private static native Inspector instance();

    static {
        ReactBridge.staticInit();
    }

    public static List<Page> getPages() {
        try {
            return Arrays.asList(instance().getPagesNative());
        } catch (Throwable e) {
            FLog.m5675e(ReactConstants.TAG, "Inspector doesn't work in open source yet", e);
            return Collections.emptyList();
        }
    }

    public static LocalConnection connect(int i, RemoteConnection remoteConnection) {
        try {
            return instance().connectNative(i, remoteConnection);
        } catch (Throwable e) {
            FLog.m5675e(ReactConstants.TAG, "Inspector doesn't work in open source yet", e);
            throw new RuntimeException(e);
        }
    }

    private Inspector(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
