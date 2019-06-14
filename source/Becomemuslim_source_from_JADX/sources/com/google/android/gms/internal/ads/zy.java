package com.google.android.gms.internal.ads;

public abstract class zy<MessageType extends zx<MessageType, BuilderType>, BuilderType extends zy<MessageType, BuilderType>> implements acy {
    /* renamed from: a */
    public final /* synthetic */ acy mo6144a(acx acx) {
        if (mo6633p().getClass().isInstance(acx)) {
            return mo6628a((zx) acx);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    /* renamed from: a */
    public abstract BuilderType mo6627a();

    /* renamed from: a */
    protected abstract BuilderType mo6628a(MessageType messageType);

    public /* synthetic */ Object clone() {
        return mo6627a();
    }
}
