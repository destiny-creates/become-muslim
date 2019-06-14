package versioned.host.exp.exponent;

import com.facebook.react.bridge.NativeDeltaClient;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import host.exp.exponent.experience.C6317d;

public class ExponentDevBundleDownloadListener implements DevBundleDownloadListener {
    private C6317d mListener;

    public ExponentDevBundleDownloadListener(C6317d c6317d) {
        this.mListener = c6317d;
    }

    public void onSuccess(NativeDeltaClient nativeDeltaClient) {
        this.mListener.mo5400a();
    }

    public void onProgress(String str, Integer num, Integer num2) {
        this.mListener.mo5402a(str, num, num2);
    }

    public void onFailure(Exception exception) {
        this.mListener.mo5401a(exception);
    }
}
