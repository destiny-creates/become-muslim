package co.apptailor.googlesignin;

import android.util.Log;
import com.facebook.react.bridge.Promise;

/* compiled from: PromiseWrapper */
/* renamed from: co.apptailor.googlesignin.b */
public class C0849b {
    /* renamed from: a */
    private Promise f2352a;
    /* renamed from: b */
    private String f2353b;

    /* renamed from: a */
    public boolean m3056a(Promise promise, String str) {
        if (this.f2352a != null) {
            return null;
        }
        this.f2352a = promise;
        this.f2353b = str;
        return true;
    }

    /* renamed from: a */
    public void m3053a(Object obj) {
        Promise promise = this.f2352a;
        if (promise == null) {
            Log.w(RNGoogleSigninModule.MODULE_NAME, "cannot resolve promise because it's null");
            return;
        }
        m3051b();
        promise.resolve(obj);
    }

    /* renamed from: a */
    public void m3055a(String str, Throwable th) {
        Promise promise = this.f2352a;
        if (promise == null) {
            Log.w(RNGoogleSigninModule.MODULE_NAME, "cannot reject promise because it's null");
            return;
        }
        m3051b();
        promise.reject(str, th.getLocalizedMessage(), th);
    }

    /* renamed from: a */
    public void m3054a(String str, String str2) {
        Promise promise = this.f2352a;
        if (promise == null) {
            Log.w(RNGoogleSigninModule.MODULE_NAME, "cannot reject promise because it's null");
            return;
        }
        m3051b();
        promise.reject(str, str2);
    }

    /* renamed from: a */
    public String m3052a() {
        return this.f2353b;
    }

    /* renamed from: b */
    private void m3051b() {
        this.f2352a = null;
        this.f2353b = null;
    }
}
