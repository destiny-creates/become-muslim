package com.p050a.p051a.p060d;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import com.facebook.imageutils.JfifUtil;
import com.p050a.p051a.p056c.p058b.C0896c;
import com.p050a.p051a.p061e.C0947e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientColorParser */
/* renamed from: com.a.a.d.m */
public class C3388m implements ak<C0896c> {
    /* renamed from: a */
    private int f9020a;

    /* renamed from: b */
    public /* synthetic */ Object mo739b(JsonReader jsonReader, float f) {
        return m10786a(jsonReader, f);
    }

    public C3388m(int i) {
        this.f9020a = i;
    }

    /* renamed from: a */
    public C0896c m10786a(JsonReader jsonReader, float f) {
        List arrayList = new ArrayList();
        Object obj = jsonReader.peek() == JsonToken.BEGIN_ARRAY ? 1 : null;
        if (obj != null) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (obj != null) {
            jsonReader.endArray();
        }
        if (this.f9020a == -1) {
            this.f9020a = arrayList.size() / 4;
        }
        jsonReader = new float[this.f9020a];
        int[] iArr = new int[this.f9020a];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f9020a * 4; i3++) {
            int i4 = i3 / 4;
            double floatValue = (double) ((Float) arrayList.get(i3)).floatValue();
            switch (i3 % 4) {
                case 0:
                    jsonReader[i4] = (float) floatValue;
                    break;
                case 1:
                    i = (int) (floatValue * 255.0d);
                    break;
                case 2:
                    i2 = (int) (floatValue * 255.0d);
                    break;
                case 3:
                    iArr[i4] = Color.argb(JfifUtil.MARKER_FIRST_BYTE, i, i2, (int) (floatValue * 255.0d));
                    break;
                default:
                    break;
            }
        }
        C0896c c0896c = new C0896c(jsonReader, iArr);
        m10785a(c0896c, arrayList);
        return c0896c;
    }

    /* renamed from: a */
    private void m10785a(C0896c c0896c, List<Float> list) {
        int i = this.f9020a * 4;
        if (list.size() > i) {
            int size = (list.size() - i) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i2 = 0;
            while (i < list.size()) {
                if (i % 2 == 0) {
                    dArr[i2] = (double) ((Float) list.get(i)).floatValue();
                } else {
                    dArr2[i2] = (double) ((Float) list.get(i)).floatValue();
                    i2++;
                }
                i++;
            }
            for (int i3 = 0; i3 < c0896c.m3175c(); i3++) {
                list = c0896c.m3174b()[i3];
                c0896c.m3174b()[i3] = Color.argb(m10784a((double) c0896c.m3173a()[i3], dArr, dArr2), Color.red(list), Color.green(list), Color.blue(list));
            }
        }
    }

    /* renamed from: a */
    private int m10784a(double d, double[] dArr, double[] dArr2) {
        double[] dArr3 = dArr;
        double[] dArr4 = dArr2;
        for (int i = 1; i < dArr3.length; i++) {
            int i2 = i - 1;
            double d2 = dArr3[i2];
            double d3 = dArr3[i];
            if (dArr3[i] >= d) {
                return (int) (C0947e.m3301a(dArr4[i2], dArr4[i], (d - d2) / (d3 - d2)) * 255.0d);
            }
        }
        return (int) (dArr4[dArr4.length - 1] * 255.0d);
    }
}
