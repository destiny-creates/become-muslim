package expo.adapters.react;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;

/* compiled from: ArgumentsHelper */
/* renamed from: expo.adapters.react.a */
public class C6014a {

    /* compiled from: ArgumentsHelper */
    /* renamed from: expo.adapters.react.a$1 */
    static /* synthetic */ class C60131 {
        /* renamed from: a */
        static final /* synthetic */ int[] f19803a = new int[ReadableType.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = com.facebook.react.bridge.ReadableType.values();
            r0 = r0.length;
            r0 = new int[r0];
            f19803a = r0;
            r0 = f19803a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = com.facebook.react.bridge.ReadableType.String;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f19803a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = com.facebook.react.bridge.ReadableType.Map;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = f19803a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = com.facebook.react.bridge.ReadableType.Array;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = f19803a;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = com.facebook.react.bridge.ReadableType.Number;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r0 = f19803a;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = com.facebook.react.bridge.ReadableType.Boolean;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            r0 = f19803a;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = com.facebook.react.bridge.ReadableType.Null;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x004b }
            r2 = 6;	 Catch:{ NoSuchFieldError -> 0x004b }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.adapters.react.a.1.<clinit>():void");
        }
    }

    /* renamed from: a */
    public static Object m25157a(Dynamic dynamic, Class<?> cls) {
        switch (C60131.f19803a[dynamic.getType().ordinal()]) {
            case 1:
                return dynamic.asString();
            case 2:
                return dynamic.asMap().toHashMap();
            case 3:
                return dynamic.asArray().toArrayList();
            case 4:
                dynamic = Double.valueOf(dynamic.asDouble());
                if (cls != Byte.TYPE) {
                    if (cls != Byte.class) {
                        if (cls != Short.TYPE) {
                            if (cls != Short.class) {
                                if (cls != Integer.TYPE) {
                                    if (cls != Integer.class) {
                                        if (cls != Float.TYPE) {
                                            if (cls != Float.class) {
                                                if (cls != Long.TYPE) {
                                                    if (cls != Long.class) {
                                                        return dynamic;
                                                    }
                                                }
                                                return Long.valueOf(dynamic.longValue());
                                            }
                                        }
                                        return Float.valueOf(dynamic.floatValue());
                                    }
                                }
                                return Integer.valueOf(dynamic.intValue());
                            }
                        }
                        return Short.valueOf(dynamic.shortValue());
                    }
                }
                return Byte.valueOf(dynamic.byteValue());
            case 5:
                return Boolean.valueOf(dynamic.asBoolean());
            case 6:
                return null;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Don't know how to convert React Native argument of type ");
                stringBuilder.append(dynamic.getType());
                stringBuilder.append(" to native.");
                throw new RuntimeException(stringBuilder.toString());
        }
    }
}
