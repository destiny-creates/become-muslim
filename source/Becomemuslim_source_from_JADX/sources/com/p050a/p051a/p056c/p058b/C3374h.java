package com.p050a.p051a.p056c.p058b;

import android.util.Log;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.p052a.p053a.C0880b;
import com.p050a.p051a.p052a.p053a.C4508k;
import com.p050a.p051a.p056c.p059c.C4529a;

/* compiled from: MergePaths */
/* renamed from: com.a.a.c.b.h */
public class C3374h implements C0895b {
    /* renamed from: a */
    private final String f8970a;
    /* renamed from: b */
    private final C0900a f8971b;

    /* compiled from: MergePaths */
    /* renamed from: com.a.a.c.b.h$a */
    public enum C0900a {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        /* renamed from: a */
        public static C0900a m3179a(int i) {
            switch (i) {
                case 1:
                    return Merge;
                case 2:
                    return Add;
                case 3:
                    return Subtract;
                case 4:
                    return Intersect;
                case 5:
                    return ExcludeIntersections;
                default:
                    return Merge;
            }
        }
    }

    public C3374h(String str, C0900a c0900a) {
        this.f8970a = str;
        this.f8971b = c0900a;
    }

    /* renamed from: a */
    public String m10722a() {
        return this.f8970a;
    }

    /* renamed from: b */
    public C0900a m10723b() {
        return this.f8971b;
    }

    /* renamed from: a */
    public C0880b mo738a(C0957g c0957g, C4529a c4529a) {
        if (c0957g.m3371a() != null) {
            return new C4508k(this);
        }
        Log.w("LOTTIE", "Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MergePaths{mode=");
        stringBuilder.append(this.f8971b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
