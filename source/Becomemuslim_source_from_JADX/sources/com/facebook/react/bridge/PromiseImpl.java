package com.facebook.react.bridge;

import com.facebook.share.internal.ShareConstants;

public class PromiseImpl implements Promise {
    private static final String DEFAULT_ERROR = "EUNSPECIFIED";
    private Callback mReject;
    private Callback mResolve;

    public PromiseImpl(Callback callback, Callback callback2) {
        this.mResolve = callback;
        this.mReject = callback2;
    }

    public void resolve(Object obj) {
        if (this.mResolve != null) {
            this.mResolve.invoke(obj);
        }
    }

    public void reject(String str, String str2) {
        reject(str, str2, null);
    }

    @Deprecated
    public void reject(String str) {
        reject(DEFAULT_ERROR, str, null);
    }

    public void reject(String str, Throwable th) {
        reject(str, th.getMessage(), th);
    }

    public void reject(Throwable th) {
        reject(DEFAULT_ERROR, th.getMessage(), th);
    }

    public void reject(String str, String str2, Throwable th) {
        if (this.mReject != null) {
            if (str == null) {
                str = DEFAULT_ERROR;
            }
            th = new WritableNativeMap();
            th.putString("code", str);
            th.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str2);
            this.mReject.invoke(new Object[]{th});
        }
    }
}
