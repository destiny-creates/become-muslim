package com.p050a.p051a.p060d;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.facebook.imageutils.JfifUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonUtils */
/* renamed from: com.a.a.d.q */
class C0932q {

    /* compiled from: JsonUtils */
    /* renamed from: com.a.a.d.q$1 */
    static /* synthetic */ class C09311 {
        /* renamed from: a */
        static final /* synthetic */ int[] f2615a = new int[JsonToken.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r0 = android.util.JsonToken.values();
            r0 = r0.length;
            r0 = new int[r0];
            f2615a = r0;
            r0 = f2615a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = android.util.JsonToken.NUMBER;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f2615a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = android.util.JsonToken.BEGIN_ARRAY;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = f2615a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = android.util.JsonToken.BEGIN_OBJECT;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.a.a.d.q.1.<clinit>():void");
        }
    }

    /* renamed from: a */
    static int m3262a(JsonReader jsonReader) {
        jsonReader.beginArray();
        int nextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb(JfifUtil.MARKER_FIRST_BYTE, nextDouble, nextDouble2, nextDouble3);
    }

    /* renamed from: a */
    static List<PointF> m3263a(JsonReader jsonReader, float f) {
        List<PointF> arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(C0932q.m3265b(jsonReader, f));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    /* renamed from: b */
    static PointF m3265b(JsonReader jsonReader, float f) {
        switch (C09311.f2615a[jsonReader.peek().ordinal()]) {
            case 1:
                return C0932q.m3266c(jsonReader, f);
            case 2:
                return C0932q.m3267d(jsonReader, f);
            case 3:
                return C0932q.m3268e(jsonReader, f);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown point starts with ");
                stringBuilder.append(jsonReader.peek());
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: c */
    private static PointF m3266c(JsonReader jsonReader, float f) {
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new PointF(nextDouble * f, nextDouble2 * f);
    }

    /* renamed from: d */
    private static PointF m3267d(JsonReader jsonReader, float f) {
        jsonReader.beginArray();
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.peek() != JsonToken.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new PointF(nextDouble * f, nextDouble2 * f);
    }

    /* renamed from: e */
    private static PointF m3268e(JsonReader jsonReader, float f) {
        jsonReader.beginObject();
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            switch (nextName.hashCode()) {
                case 120:
                    if (nextName.equals("x")) {
                        obj = null;
                        break;
                    }
                    break;
                case 121:
                    if (nextName.equals("y")) {
                        obj = 1;
                        break;
                    }
                    break;
                default:
                    break;
            }
            switch (obj) {
                case null:
                    f2 = C0932q.m3264b(jsonReader);
                    break;
                case 1:
                    f3 = C0932q.m3264b(jsonReader);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new PointF(f2 * f, f3 * f);
    }

    /* renamed from: b */
    static float m3264b(JsonReader jsonReader) {
        JsonToken peek = jsonReader.peek();
        switch (C09311.f2615a[peek.ordinal()]) {
            case 1:
                return (float) jsonReader.nextDouble();
            case 2:
                jsonReader.beginArray();
                float nextDouble = (float) jsonReader.nextDouble();
                while (jsonReader.hasNext()) {
                    jsonReader.skipValue();
                }
                jsonReader.endArray();
                return nextDouble;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown value for token of type ");
                stringBuilder.append(peek);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
