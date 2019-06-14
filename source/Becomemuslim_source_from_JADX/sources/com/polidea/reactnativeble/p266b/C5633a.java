package com.polidea.reactnativeble.p266b;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

/* compiled from: JSObjectConverter */
/* renamed from: com.polidea.reactnativeble.b.a */
abstract class C5633a<T> {
    /* renamed from: a */
    public abstract WritableMap mo5038a(T t);

    C5633a() {
    }

    /* renamed from: b */
    public WritableArray m23948b(T t) {
        WritableArray createArray = Arguments.createArray();
        createArray.pushNull();
        createArray.pushMap(mo5038a(t));
        return createArray;
    }
}
