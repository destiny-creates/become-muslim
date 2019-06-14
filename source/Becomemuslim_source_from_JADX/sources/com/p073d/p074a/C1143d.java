package com.p073d.p074a;

import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: Cartographer */
/* renamed from: com.d.a.d */
public class C1143d {
    /* renamed from: a */
    static final C1143d f3242a = new C1142a().m4035a(true).m4037b(false).m4036a();
    /* renamed from: b */
    private final boolean f3243b;
    /* renamed from: c */
    private final boolean f3244c;

    /* compiled from: Cartographer */
    /* renamed from: com.d.a.d$1 */
    static /* synthetic */ class C11411 {
        /* renamed from: a */
        static final /* synthetic */ int[] f3239a = new int[JsonToken.values().length];

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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r0 = android.util.JsonToken.values();
            r0 = r0.length;
            r0 = new int[r0];
            f3239a = r0;
            r0 = f3239a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = android.util.JsonToken.BEGIN_OBJECT;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f3239a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = android.util.JsonToken.BEGIN_ARRAY;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = f3239a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = android.util.JsonToken.BOOLEAN;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = f3239a;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = android.util.JsonToken.NULL;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r0 = f3239a;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = android.util.JsonToken.NUMBER;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            r0 = f3239a;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = android.util.JsonToken.STRING;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x004b }
            r2 = 6;	 Catch:{ NoSuchFieldError -> 0x004b }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.d.a.d.1.<clinit>():void");
        }
    }

    /* compiled from: Cartographer */
    /* renamed from: com.d.a.d$a */
    public static class C1142a {
        /* renamed from: a */
        private boolean f3240a;
        /* renamed from: b */
        private boolean f3241b;

        /* renamed from: a */
        public C1142a m4035a(boolean z) {
            this.f3240a = z;
            return this;
        }

        /* renamed from: b */
        public C1142a m4037b(boolean z) {
            this.f3241b = z;
            return this;
        }

        /* renamed from: a */
        public C1143d m4036a() {
            return new C1143d(this.f3240a, this.f3241b);
        }
    }

    C1143d(boolean z, boolean z2) {
        this.f3243b = z;
        this.f3244c = z2;
    }

    /* renamed from: a */
    public Map<String, Object> m4047a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("json == null");
        } else if (str.length() != 0) {
            return m4046a(new StringReader(str));
        } else {
            throw new IllegalArgumentException("json empty");
        }
    }

    /* renamed from: a */
    public Map<String, Object> m4046a(Reader reader) {
        if (reader != null) {
            JsonReader jsonReader = new JsonReader(reader);
            jsonReader.setLenient(this.f3243b);
            try {
                Map<String, Object> a = C1143d.m4038a(jsonReader);
                return a;
            } finally {
                reader.close();
            }
        } else {
            throw new IllegalArgumentException("reader == null");
        }
    }

    /* renamed from: a */
    public String m4045a(Map<?, ?> map) {
        Writer stringWriter = new StringWriter();
        try {
            m4048a((Map) map, stringWriter);
            return stringWriter.toString();
        } catch (Map<?, ?> map2) {
            throw new AssertionError(map2);
        }
    }

    /* renamed from: a */
    public void m4048a(Map<?, ?> map, Writer writer) {
        if (map == null) {
            throw new IllegalArgumentException("map == null");
        } else if (writer != null) {
            JsonWriter jsonWriter = new JsonWriter(writer);
            jsonWriter.setLenient(this.f3243b);
            if (this.f3244c != null) {
                jsonWriter.setIndent("  ");
            }
            try {
                C1143d.m4041a((Map) map, jsonWriter);
            } finally {
                jsonWriter.close();
            }
        } else {
            throw new IllegalArgumentException("writer == null");
        }
    }

    /* renamed from: a */
    private static Map<String, Object> m4038a(JsonReader jsonReader) {
        Map<String, Object> linkedHashMap = new LinkedHashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            linkedHashMap.put(jsonReader.nextName(), C1143d.m4044c(jsonReader));
        }
        jsonReader.endObject();
        return linkedHashMap;
    }

    /* renamed from: b */
    private static List<Object> m4042b(JsonReader jsonReader) {
        List<Object> arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(C1143d.m4044c(jsonReader));
        }
        jsonReader.endArray();
        return arrayList;
    }

    /* renamed from: c */
    private static Object m4044c(JsonReader jsonReader) {
        JsonToken peek = jsonReader.peek();
        switch (C11411.f3239a[peek.ordinal()]) {
            case 1:
                return C1143d.m4038a(jsonReader);
            case 2:
                return C1143d.m4042b(jsonReader);
            case 3:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 4:
                jsonReader.nextNull();
                return null;
            case 5:
                return Double.valueOf(jsonReader.nextDouble());
            case 6:
                return jsonReader.nextString();
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid token ");
                stringBuilder.append(peek);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    private static void m4041a(Map<?, ?> map, JsonWriter jsonWriter) {
        jsonWriter.beginObject();
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            jsonWriter.name(String.valueOf(entry.getKey()));
            C1143d.m4043b(entry.getValue(), jsonWriter);
        }
        jsonWriter.endObject();
    }

    /* renamed from: a */
    private static void m4040a(List<?> list, JsonWriter jsonWriter) {
        jsonWriter.beginArray();
        for (Object b : list) {
            C1143d.m4043b(b, jsonWriter);
        }
        jsonWriter.endArray();
    }

    /* renamed from: a */
    private static void m4039a(Object obj, JsonWriter jsonWriter) {
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            C1143d.m4043b(Array.get(obj, i), jsonWriter);
        }
        jsonWriter.endArray();
    }

    /* renamed from: b */
    private static void m4043b(Object obj, JsonWriter jsonWriter) {
        if (obj == null) {
            jsonWriter.nullValue();
        } else if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
        } else if (obj instanceof Boolean) {
            jsonWriter.value(((Boolean) obj).booleanValue());
        } else if (obj instanceof List) {
            C1143d.m4040a((List) obj, jsonWriter);
        } else if (obj instanceof Map) {
            C1143d.m4041a((Map) obj, jsonWriter);
        } else if (obj.getClass().isArray()) {
            C1143d.m4039a(obj, jsonWriter);
        } else {
            jsonWriter.value(String.valueOf(obj));
        }
    }
}
