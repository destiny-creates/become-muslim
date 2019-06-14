package com.polidea.reactnativeble.p269e;

import com.facebook.react.bridge.Promise;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SafePromise */
/* renamed from: com.polidea.reactnativeble.e.h */
public class C5648h {
    /* renamed from: a */
    private Promise f18886a;
    /* renamed from: b */
    private AtomicBoolean f18887b = new AtomicBoolean();

    public C5648h(Promise promise) {
        this.f18886a = promise;
    }

    /* renamed from: a */
    public void m23980a(Object obj) {
        if (this.f18887b.compareAndSet(false, true)) {
            this.f18886a.resolve(obj);
        }
    }

    /* renamed from: a */
    public void m23981a(String str, String str2) {
        if (this.f18887b.compareAndSet(false, true)) {
            this.f18886a.reject(str, str2);
        }
    }
}
