package com.facebook.ads.internal.view.p114c.p115a;

import android.support.v7.widget.RecyclerView.C0689a;
import android.support.v7.widget.RecyclerView.C0718x;
import android.view.ViewGroup;
import com.facebook.ads.internal.adapters.p086a.C1312d;
import com.facebook.ads.internal.p089d.C1364b;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1520t;
import com.facebook.ads.internal.p111r.C1545a;
import com.facebook.ads.internal.view.C1566a.C1551a;
import com.facebook.ads.internal.view.component.p116a.C1597d.C1596a;
import com.facebook.ads.internal.view.component.p116a.p117a.C1592c;
import java.util.List;

/* renamed from: com.facebook.ads.internal.view.c.a.d */
public class C3622d extends C0689a<C3627g> {
    /* renamed from: a */
    private final C1412c f9676a;
    /* renamed from: b */
    private final C1364b f9677b;
    /* renamed from: c */
    private final C1545a f9678c;
    /* renamed from: d */
    private final C1520t f9679d;
    /* renamed from: e */
    private final C1312d f9680e;
    /* renamed from: f */
    private C1551a f9681f;
    /* renamed from: g */
    private int f9682g;
    /* renamed from: h */
    private int f9683h;
    /* renamed from: i */
    private String f9684i;
    /* renamed from: j */
    private int f9685j;
    /* renamed from: k */
    private int f9686k;
    /* renamed from: l */
    private List<C1580b> f9687l;
    /* renamed from: m */
    private final C3621a f9688m;

    /* renamed from: com.facebook.ads.internal.view.c.a.d$a */
    public interface C1581a {
        /* renamed from: a */
        void mo1021a(int i);
    }

    C3622d(List<C1580b> list, C1412c c1412c, C1364b c1364b, C1545a c1545a, C1520t c1520t, C1551a c1551a, C1312d c1312d, String str, int i, int i2, int i3, int i4, C3621a c3621a) {
        this.f9676a = c1412c;
        this.f9677b = c1364b;
        this.f9678c = c1545a;
        this.f9679d = c1520t;
        this.f9681f = c1551a;
        this.f9687l = list;
        this.f9683h = i;
        this.f9680e = c1312d;
        this.f9685j = i4;
        this.f9684i = str;
        this.f9682g = i3;
        this.f9686k = i2;
        this.f9688m = c3621a;
    }

    /* renamed from: a */
    public C3627g m11840a(ViewGroup viewGroup, int i) {
        return new C3627g(C1592c.m5534a(new C1596a(viewGroup.getContext(), this.f9676a, this.f9681f, null, null, this.f9678c, this.f9679d).m5562a(), this.f9685j, this.f9680e, this.f9684i, this.f9688m), this.f9678c, this.f9683h, this.f9682g, this.f9686k, this.f9687l.size());
    }

    /* renamed from: a */
    public void m11841a(C3627g c3627g, int i) {
        c3627g.m11851a((C1580b) this.f9687l.get(i), this.f9676a, this.f9677b, this.f9679d, this.f9684i, false);
    }

    public int getItemCount() {
        return this.f9687l.size();
    }

    public /* synthetic */ void onBindViewHolder(C0718x c0718x, int i) {
        m11841a((C3627g) c0718x, i);
    }

    public /* synthetic */ C0718x onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m11840a(viewGroup, i);
    }
}
