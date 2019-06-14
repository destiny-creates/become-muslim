package com.facebook.ads.internal.p087b;

import android.os.Bundle;
import android.view.View;
import com.facebook.ads.internal.p105q.p106a.C1513p;
import com.facebook.ads.internal.p111r.C1545a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.internal.b.a */
public final class C3573a implements C1513p<Bundle> {
    /* renamed from: a */
    private final View f9547a;
    /* renamed from: b */
    private final List<C3574d> f9548b;
    /* renamed from: c */
    private C1349c f9549c;

    public C3573a(View view, List<C1347b> list) {
        this.f9547a = view;
        this.f9548b = new ArrayList(list.size());
        for (C1347b c3574d : list) {
            this.f9548b.add(new C3574d(c3574d));
        }
        this.f9549c = new C1349c();
    }

    public C3573a(View view, List<C1347b> list, Bundle bundle) {
        this.f9547a = view;
        this.f9548b = new ArrayList(list.size());
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("TESTS");
        for (int i = 0; i < list.size(); i++) {
            this.f9548b.add(new C3574d((C1347b) list.get(i), (Bundle) parcelableArrayList.get(i)));
        }
        this.f9549c = (C1349c) bundle.getSerializable("STATISTICS");
    }

    /* renamed from: a */
    public void m11634a() {
        this.f9549c.m4627a();
    }

    /* renamed from: a */
    public void m11635a(double d, double d2) {
        if (d2 >= 0.0d) {
            this.f9549c.m4630b(d, d2);
        }
        d2 = (double) C1545a.m5413a(this.f9547a, 0).m5440c();
        this.f9549c.m4628a(d, d2);
        for (C3574d a : this.f9548b) {
            a.m11643a(d, d2);
        }
    }

    /* renamed from: b */
    public void m11636b() {
        this.f9549c.m4629b();
        for (C3574d a : this.f9548b) {
            a.m11642a();
        }
    }

    /* renamed from: c */
    public C1349c m11637c() {
        return this.f9549c;
    }

    /* renamed from: g */
    public Bundle mo937g() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("STATISTICS", this.f9549c);
        ArrayList arrayList = new ArrayList(this.f9548b.size());
        for (C3574d g : this.f9548b) {
            arrayList.add(g.mo937g());
        }
        bundle.putParcelableArrayList("TESTS", arrayList);
        return bundle;
    }
}
