package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.dr */
public abstract class dr<MessageType extends dr<MessageType, BuilderType>, BuilderType extends ds<MessageType, BuilderType>> implements gt {
    private static boolean zzavq = false;
    protected int zzavp = 0;

    /* renamed from: m */
    public final dy mo6148m() {
        try {
            eh c = dy.m20456c(mo6736r());
            mo6734a(c.m20470b());
            return c.m20469a();
        } catch (Throwable e) {
            String str = "ByteString";
            String name = getClass().getName();
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(name).length() + 62) + String.valueOf(str).length());
            stringBuilder.append("Serializing ");
            stringBuilder.append(name);
            stringBuilder.append(" to a ");
            stringBuilder.append(str);
            stringBuilder.append(" threw an IOException (should never happen).");
            throw new RuntimeException(stringBuilder.toString(), e);
        }
    }

    /* renamed from: n */
    int mo6735n() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    void mo6733a(int i) {
        throw new UnsupportedOperationException();
    }
}
