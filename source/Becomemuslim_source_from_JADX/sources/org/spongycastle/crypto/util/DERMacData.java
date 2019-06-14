package org.spongycastle.crypto.util;

public final class DERMacData {

    /* renamed from: org.spongycastle.crypto.util.DERMacData$1 */
    static /* synthetic */ class C66821 {
        /* renamed from: a */
        static final /* synthetic */ int[] f22642a = new int[Type.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = org.spongycastle.crypto.util.DERMacData.Type.values();
            r0 = r0.length;
            r0 = new int[r0];
            f22642a = r0;
            r0 = f22642a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = org.spongycastle.crypto.util.DERMacData.Type.UNILATERALU;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f22642a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = org.spongycastle.crypto.util.DERMacData.Type.BILATERALU;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = f22642a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = org.spongycastle.crypto.util.DERMacData.Type.UNILATERALV;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = f22642a;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = org.spongycastle.crypto.util.DERMacData.Type.BILATERALV;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.util.DERMacData.1.<clinit>():void");
        }
    }

    public static final class Builder {
    }

    public enum Type {
        UNILATERALU("KC_1_U"),
        UNILATERALV("KC_1_V"),
        BILATERALU("KC_2_U"),
        BILATERALV("KC_2_V");
        
        /* renamed from: e */
        private final String f22648e;

        private Type(String str) {
            this.f22648e = str;
        }
    }
}
