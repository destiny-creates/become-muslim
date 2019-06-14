package com.p050a.p051a;

import android.content.Context;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.v4.util.C0452f;
import android.support.v4.util.C0464m;
import android.util.JsonReader;
import android.util.Log;
import com.p050a.p051a.p056c.C0915c;
import com.p050a.p051a.p056c.C0916d;
import com.p050a.p051a.p056c.p059c.C0912d;
import com.p050a.p051a.p060d.C0936u;
import com.p050a.p051a.p060d.C3384e;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: LottieComposition */
/* renamed from: com.a.a.f */
public class C0954f {
    /* renamed from: a */
    private final C0963k f2666a = new C0963k();
    /* renamed from: b */
    private final HashSet<String> f2667b = new HashSet();
    /* renamed from: c */
    private Map<String, List<C0912d>> f2668c;
    /* renamed from: d */
    private Map<String, C0958h> f2669d;
    /* renamed from: e */
    private Map<String, C0915c> f2670e;
    /* renamed from: f */
    private C0464m<C0916d> f2671f;
    /* renamed from: g */
    private C0452f<C0912d> f2672g;
    /* renamed from: h */
    private List<C0912d> f2673h;
    /* renamed from: i */
    private Rect f2674i;
    /* renamed from: j */
    private float f2675j;
    /* renamed from: k */
    private float f2676k;
    /* renamed from: l */
    private float f2677l;

    /* compiled from: LottieComposition */
    /* renamed from: com.a.a.f$a */
    public static class C0949a {
        /* renamed from: a */
        public static C0888a m3321a(Context context, String str, C0960j c0960j) {
            try {
                return C0949a.m3323a(context.getAssets().open(str), c0960j);
            } catch (Context context2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to find file ");
                stringBuilder.append(str);
                throw new IllegalArgumentException(stringBuilder.toString(), context2);
            }
        }

        /* renamed from: a */
        public static C0888a m3320a(Context context, int i, C0960j c0960j) {
            return C0949a.m3323a(context.getResources().openRawResource(i), c0960j);
        }

        /* renamed from: a */
        public static C0888a m3323a(InputStream inputStream, C0960j c0960j) {
            return C0949a.m3322a(new JsonReader(new InputStreamReader(inputStream)), c0960j);
        }

        /* renamed from: a */
        public static C0888a m3322a(JsonReader jsonReader, C0960j c0960j) {
            C0888a c3384e = new C3384e(c0960j);
            c3384e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JsonReader[]{jsonReader});
            return c3384e;
        }

        /* renamed from: a */
        public static C0954f m3324a(JsonReader jsonReader) {
            return C0936u.m3279a(jsonReader);
        }
    }

    /* renamed from: a */
    public void m3337a(Rect rect, float f, float f2, float f3, List<C0912d> list, C0452f<C0912d> c0452f, Map<String, List<C0912d>> map, Map<String, C0958h> map2, C0464m<C0916d> c0464m, Map<String, C0915c> map3) {
        this.f2674i = rect;
        this.f2675j = f;
        this.f2676k = f2;
        this.f2677l = f3;
        this.f2673h = list;
        this.f2672g = c0452f;
        this.f2668c = map;
        this.f2669d = map2;
        this.f2671f = c0464m;
        this.f2670e = map3;
    }

    /* renamed from: a */
    public void m3338a(String str) {
        Log.w("LOTTIE", str);
        this.f2667b.add(str);
    }

    /* renamed from: a */
    public void m3339a(boolean z) {
        this.f2666a.m3408a(z);
    }

    /* renamed from: a */
    public C0963k m3336a() {
        return this.f2666a;
    }

    /* renamed from: a */
    public C0912d m3335a(long j) {
        return (C0912d) this.f2672g.m1412a(j);
    }

    /* renamed from: b */
    public Rect m3340b() {
        return this.f2674i;
    }

    /* renamed from: c */
    public float m3342c() {
        return (float) ((long) ((m3350k() / this.f2677l) * 1000.0f));
    }

    /* renamed from: d */
    public float m3343d() {
        return this.f2675j;
    }

    /* renamed from: e */
    public float m3344e() {
        return this.f2676k;
    }

    /* renamed from: f */
    public float m3345f() {
        return this.f2677l;
    }

    /* renamed from: g */
    public List<C0912d> m3346g() {
        return this.f2673h;
    }

    /* renamed from: b */
    public List<C0912d> m3341b(String str) {
        return (List) this.f2668c.get(str);
    }

    /* renamed from: h */
    public C0464m<C0916d> m3347h() {
        return this.f2671f;
    }

    /* renamed from: i */
    public Map<String, C0915c> m3348i() {
        return this.f2670e;
    }

    /* renamed from: j */
    public Map<String, C0958h> m3349j() {
        return this.f2669d;
    }

    /* renamed from: k */
    public float m3350k() {
        return this.f2676k - this.f2675j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LottieComposition:\n");
        for (C0912d a : this.f2673h) {
            stringBuilder.append(a.m3190a("\t"));
        }
        return stringBuilder.toString();
    }
}
