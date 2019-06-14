package com.google.android.gms.internal.ads;

public abstract class zx<MessageType extends zx<MessageType, BuilderType>, BuilderType extends zy<MessageType, BuilderType>> implements acx {
    private static boolean zzdpg = false;
    protected int zzdpf = 0;

    /* renamed from: a */
    void mo6634a(int i) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: h */
    public final aai mo6142h() {
        try {
            aan b = aai.m17835b(mo6637l());
            mo6635a(b.m17851b());
            return b.m17850a();
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

    /* renamed from: i */
    public final byte[] mo6143i() {
        try {
            byte[] bArr = new byte[mo6637l()];
            aaw a = aaw.m29595a(bArr);
            mo6635a(a);
            a.m29661b();
            return bArr;
        } catch (Throwable e) {
            String str = "byte array";
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

    /* renamed from: j */
    int mo6636j() {
        throw new UnsupportedOperationException();
    }
}
