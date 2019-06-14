package expo.modules.google.signin;

import expo.p304a.C6009f;

public class AuthTask {
    private C6009f mPromise;
    private String mTag;

    public boolean update(C6009f c6009f, String str) {
        if (this.mPromise == null) {
            this.mPromise = c6009f;
            this.mTag = str;
            return true;
        }
        c6009f.m25152a("E_CONCURRENT_TASK_IN_PROGRESS", "cannot set promise - some async operation is still in progress");
        return null;
    }

    public void resolve(Object obj) {
        if (this.mPromise != null) {
            this.mPromise.mo5137a(obj);
            clear();
        }
    }

    public void reject(String str, String str2) {
        if (this.mPromise != null) {
            C6009f c6009f = this.mPromise;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GoogleSignIn.");
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
