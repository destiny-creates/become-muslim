package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
/* renamed from: com.google.firebase.components.f */
public class C6901f extends C5345g {
    /* renamed from: a */
    private final List<C5340a<?>> f24719a;

    public C6901f(List<C5340a<?>> list) {
        StringBuilder stringBuilder = new StringBuilder("Dependency cycle detected: ");
        stringBuilder.append(Arrays.toString(list.toArray()));
        super(stringBuilder.toString());
        this.f24719a = list;
    }
}
