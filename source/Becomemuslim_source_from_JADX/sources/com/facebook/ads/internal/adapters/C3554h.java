package com.facebook.ads.internal.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView.C0689a;
import android.support.v7.widget.RecyclerView.C0718x;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.facebook.ads.internal.p099n.C1425f;
import com.facebook.ads.internal.p099n.C1426g;
import com.facebook.ads.internal.p099n.C1427h;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.p111r.C1545a.C1544a;
import com.facebook.ads.internal.view.C1676s;
import com.facebook.ads.internal.view.C3628c;
import com.facebook.ads.internal.view.C3693l;
import com.facebook.ads.internal.view.hscroll.C4895b;
import com.facebook.ads.internal.view.p113b.C1577d;
import com.facebook.ads.internal.view.p113b.C1578e;
import java.util.List;

/* renamed from: com.facebook.ads.internal.adapters.h */
public class C3554h extends C0689a<C3628c> {
    /* renamed from: a */
    private static final int f9497a = Color.argb(51, 0, 0, 0);
    /* renamed from: b */
    private final C1544a f9498b = new C35521(this);
    /* renamed from: c */
    private final List<C1425f> f9499c;
    /* renamed from: d */
    private final int f9500d;
    /* renamed from: e */
    private final int f9501e;
    /* renamed from: f */
    private C1330a f9502f;

    /* renamed from: com.facebook.ads.internal.adapters.h$a */
    public interface C1330a {
        /* renamed from: a */
        void mo869a();
    }

    /* renamed from: com.facebook.ads.internal.adapters.h$1 */
    class C35521 extends C1544a {
        /* renamed from: a */
        final /* synthetic */ C3554h f9492a;

        C35521(C3554h c3554h) {
            this.f9492a = c3554h;
        }

        /* renamed from: a */
        public void mo925a() {
            if (this.f9492a.f9502f != null) {
                this.f9492a.f9502f.mo869a();
            }
        }
    }

    public C3554h(C4895b c4895b, List<C1425f> list) {
        float f = c4895b.getContext().getResources().getDisplayMetrics().density;
        this.f9499c = list;
        this.f9500d = Math.round(f * 1.0f);
        this.f9501e = c4895b.getChildSpacing();
    }

    /* renamed from: a */
    public C3628c m11521a(ViewGroup viewGroup, int i) {
        return new C3628c(new C3693l(viewGroup.getContext()));
    }

    /* renamed from: a */
    public void m11522a(C1330a c1330a) {
        this.f9502f = c1330a;
    }

    /* renamed from: a */
    public void m11523a(C3628c c3628c, final int i) {
        LayoutParams marginLayoutParams = new MarginLayoutParams(-2, -1);
        marginLayoutParams.setMargins(i == 0 ? this.f9501e * 2 : this.f9501e, 0, i >= this.f9499c.size() + -1 ? this.f9501e * 2 : this.f9501e, 0);
        View view = (C3693l) c3628c.f9707a;
        view.setLayoutParams(marginLayoutParams);
        view.setPadding(this.f9500d, this.f9500d, this.f9500d, this.f9500d);
        final ImageView imageView = (C1676s) view.getAdContentsView();
        C1523w.m5342a((View) imageView, 0);
        imageView.setImageDrawable(null);
        final C1425f c1425f = (C1425f) this.f9499c.get(i);
        c1425f.m4983a(view, (C1426g) view);
        C1427h k = c1425f.m5005k();
        if (k != null) {
            C1577d a = new C1577d(imageView).m5504a();
            a.m5506a(new C1578e(this) {
                /* renamed from: d */
                final /* synthetic */ C3554h f9496d;

                /* renamed from: a */
                public void mo841a(boolean z) {
                    if (i == 0) {
                        c1425f.m4990a(this.f9496d.f9498b);
                    }
                    c1425f.m4992a(z, true);
                    C1523w.m5342a(imageView, C3554h.f9497a);
                }
            });
            a.m5508a(k.m5022a());
        }
    }

    public int getItemCount() {
        return this.f9499c.size();
    }

    public /* synthetic */ void onBindViewHolder(C0718x c0718x, int i) {
        m11523a((C3628c) c0718x, i);
    }

    public /* synthetic */ C0718x onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m11521a(viewGroup, i);
    }
}
