package expo.adapters.react;

import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import expo.p304a.C6009f;
import java.util.List;

/* compiled from: PromiseWrapper */
/* renamed from: expo.adapters.react.c */
class C7371c extends C6009f {
    /* renamed from: a */
    private Promise f25772a;

    C7371c(Promise promise) {
        this.f25772a = promise;
    }

    /* renamed from: a */
    public void mo5137a(Object obj) {
        if (obj instanceof Bundle) {
            this.f25772a.resolve(Arguments.fromBundle((Bundle) obj));
        } else if (obj instanceof List) {
            this.f25772a.resolve(Arguments.fromList((List) obj));
        } else {
            this.f25772a.resolve(obj);
        }
    }

    /* renamed from: a */
    public void mo5138a(String str, String str2, Throwable th) {
        this.f25772a.reject(str, str2, th);
    }
}
