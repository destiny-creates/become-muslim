package com.p050a.p051a.p052a.p054b;

import android.graphics.Path;
import com.p050a.p051a.p056c.p058b.C0899g;
import com.p050a.p051a.p056c.p058b.C0902l;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MaskKeyframeAnimation */
/* renamed from: com.a.a.a.b.g */
public class C0886g {
    /* renamed from: a */
    private final List<C0885a<C0902l, Path>> f2483a;
    /* renamed from: b */
    private final List<C0885a<Integer, Integer>> f2484b;
    /* renamed from: c */
    private final List<C0899g> f2485c;

    public C0886g(List<C0899g> list) {
        this.f2485c = list;
        this.f2483a = new ArrayList(list.size());
        this.f2484b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f2483a.add(((C0899g) list.get(i)).m3177b().mo737a());
            this.f2484b.add(((C0899g) list.get(i)).m3178c().mo737a());
        }
    }

    /* renamed from: a */
    public List<C0899g> m3140a() {
        return this.f2485c;
    }

    /* renamed from: b */
    public List<C0885a<C0902l, Path>> m3141b() {
        return this.f2483a;
    }

    /* renamed from: c */
    public List<C0885a<Integer, Integer>> m3142c() {
        return this.f2484b;
    }
}
