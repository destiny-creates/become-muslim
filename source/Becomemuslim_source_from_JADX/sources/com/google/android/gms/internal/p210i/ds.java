package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.ds */
public abstract class ds<MessageType extends dr<MessageType, BuilderType>, BuilderType extends ds<MessageType, BuilderType>> implements gu {
    /* renamed from: a */
    public abstract BuilderType mo6726a();

    /* renamed from: a */
    protected abstract BuilderType mo6727a(MessageType messageType);

    public /* synthetic */ Object clone() {
        return mo6726a();
    }

    /* renamed from: a */
    public final /* synthetic */ gu mo6149a(gt gtVar) {
        if (mo6732v().getClass().isInstance(gtVar)) {
            return mo6727a((dr) gtVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
