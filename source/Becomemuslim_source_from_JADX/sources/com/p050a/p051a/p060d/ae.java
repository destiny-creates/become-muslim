package com.p050a.p051a.p060d;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.p050a.p051a.p056c.C0894a;
import com.p050a.p051a.p056c.p058b.C0902l;
import com.p050a.p051a.p061e.C0947e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeDataParser */
/* renamed from: com.a.a.d.ae */
public class ae implements ak<C0902l> {
    /* renamed from: a */
    public static final ae f9015a = new ae();

    /* renamed from: b */
    public /* synthetic */ Object mo739b(JsonReader jsonReader, float f) {
        return m10773a(jsonReader, f);
    }

    private ae() {
    }

    /* renamed from: a */
    public C0902l m10773a(JsonReader jsonReader, float f) {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List list = null;
        List list2 = null;
        List list3 = list2;
        boolean z = false;
        while (jsonReader.hasNext()) {
            Object obj;
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode == 99) {
                if (nextName.equals("c")) {
                    obj = null;
                    switch (obj) {
                        case null:
                            z = jsonReader.nextBoolean();
                            break;
                        case 1:
                            list = C0932q.m3263a(jsonReader, f);
                            break;
                        case 2:
                            list2 = C0932q.m3263a(jsonReader, f);
                            break;
                        case 3:
                            list3 = C0932q.m3263a(jsonReader, f);
                            break;
                        default:
                            break;
                    }
                }
            } else if (hashCode == 105) {
                if (nextName.equals("i")) {
                    obj = 2;
                    switch (obj) {
                        case null:
                            z = jsonReader.nextBoolean();
                            break;
                        case 1:
                            list = C0932q.m3263a(jsonReader, f);
                            break;
                        case 2:
                            list2 = C0932q.m3263a(jsonReader, f);
                            break;
                        case 3:
                            list3 = C0932q.m3263a(jsonReader, f);
                            break;
                        default:
                            break;
                    }
                }
            } else if (hashCode == 111) {
                if (nextName.equals("o")) {
                    obj = 3;
                    switch (obj) {
                        case null:
                            z = jsonReader.nextBoolean();
                            break;
                        case 1:
                            list = C0932q.m3263a(jsonReader, f);
                            break;
                        case 2:
                            list2 = C0932q.m3263a(jsonReader, f);
                            break;
                        case 3:
                            list3 = C0932q.m3263a(jsonReader, f);
                            break;
                        default:
                            break;
                    }
                }
            } else if (hashCode == 118) {
                if (nextName.equals("v")) {
                    obj = 1;
                    switch (obj) {
                        case null:
                            z = jsonReader.nextBoolean();
                            break;
                        case 1:
                            list = C0932q.m3263a(jsonReader, f);
                            break;
                        case 2:
                            list2 = C0932q.m3263a(jsonReader, f);
                            break;
                        case 3:
                            list3 = C0932q.m3263a(jsonReader, f);
                            break;
                        default:
                            break;
                    }
                }
            }
            obj = -1;
            switch (obj) {
                case null:
                    z = jsonReader.nextBoolean();
                    break;
                case 1:
                    list = C0932q.m3263a(jsonReader, f);
                    break;
                case 2:
                    list2 = C0932q.m3263a(jsonReader, f);
                    break;
                case 3:
                    list3 = C0932q.m3263a(jsonReader, f);
                    break;
                default:
                    break;
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonToken.END_ARRAY) {
            jsonReader.endArray();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else if (list.isEmpty() != null) {
            return new C0902l(new PointF(), false, Collections.emptyList());
        } else {
            jsonReader = list.size();
            PointF pointF = (PointF) list.get(0);
            List arrayList = new ArrayList(jsonReader);
            for (int i = 1; i < jsonReader; i++) {
                PointF pointF2 = (PointF) list.get(i);
                int i2 = i - 1;
                arrayList.add(new C0894a(C0947e.m3307a((PointF) list.get(i2), (PointF) list3.get(i2)), C0947e.m3307a(pointF2, (PointF) list2.get(i)), pointF2));
            }
            if (z) {
                PointF pointF3 = (PointF) list.get(0);
                jsonReader--;
                arrayList.add(new C0894a(C0947e.m3307a((PointF) list.get(jsonReader), (PointF) list3.get(jsonReader)), C0947e.m3307a(pointF3, (PointF) list2.get(0)), pointF3));
            }
            return new C0902l(pointF, z, arrayList);
        }
    }
}
