package expo.modules.appauth;

import expo.p304a.C6009f;
import net.openid.appauth.C6584d;

public class AuthTask {
    private C6009f mPromise;
    private String mTag;

    public boolean update(C6009f c6009f, String str) {
        if (this.mPromise == null) {
            this.mPromise = c6009f;
            this.mTag = str;
            return true;
        }
        c6009f.m25152a("ERR_APP_AUTH", "cannot set promise - some async operation is still in progress");
        return null;
    }

    public void resolve(Object obj) {
        if (this.mPromise != null) {
            this.mPromise.mo5137a(obj);
            clear();
        }
    }

    public void reject(Exception exception) {
        if (exception instanceof C6584d) {
            C6584d c6584d = (C6584d) exception;
            reject(String.valueOf(c6584d.f21149b), c6584d.getLocalizedMessage());
            return;
        }
        reject("ERR_APP_AUTH", exception.getLocalizedMessage());
    }

    public void reject(String str, String str2) {
        if (this.mPromise != null) {
            C6009f c6009f = this.mPromise;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ExpoAppAuth.");
            stringBuilder.append(this.mTag);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            c6009f.m25152a(str, stringBuilder.toString());
            clear();
        }
    }

    private void clear() {
        this.mPromise = null;
        this.mTag = null;
    }
}
