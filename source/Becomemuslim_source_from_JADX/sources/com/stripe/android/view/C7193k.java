package com.stripe.android.view;

import android.support.v7.widget.RecyclerView.C0689a;
import android.support.v7.widget.RecyclerView.C0718x;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.stripe.android.p285b.C7161h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShippingMethodAdapter */
/* renamed from: com.stripe.android.view.k */
class C7193k extends C0689a<C7192a> {
    /* renamed from: a */
    private List<C7161h> f25465a = new ArrayList();
    /* renamed from: b */
    private int f25466b = 0;

    /* compiled from: ShippingMethodAdapter */
    /* renamed from: com.stripe.android.view.k$a */
    class C7192a extends C0718x {
        /* renamed from: a */
        C5812l f25462a;
        /* renamed from: b */
        int f25463b;
        /* renamed from: c */
        final /* synthetic */ C7193k f25464c;

        C7192a(final C7193k c7193k, C5812l c5812l) {
            this.f25464c = c7193k;
            super(c5812l);
            this.f25462a = c5812l;
            c5812l.setOnClickListener(new OnClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ C7192a f19246b;

                public void onClick(View view) {
                    this.f19246b.f25464c.m33414a(this.f19246b.f25463b);
                }
            });
        }

        /* renamed from: a */
        void m33410a(C7161h c7161h) {
            this.f25462a.m24519a(c7161h);
        }

        /* renamed from: a */
        void m33411a(boolean z) {
            this.f25462a.setSelected(z);
        }

        /* renamed from: a */
        void m33409a(int i) {
            this.f25463b = i;
        }
    }

    public /* synthetic */ void onBindViewHolder(C0718x c0718x, int i) {
        m33415a((C7192a) c0718x, i);
    }

    public /* synthetic */ C0718x onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m33413a(viewGroup, i);
    }

    C7193k() {
    }

    public int getItemCount() {
        return this.f25465a.size();
    }

    public long getItemId(int i) {
        return super.getItemId(i);
    }

    /* renamed from: a */
    public C7192a m33413a(ViewGroup viewGroup, int i) {
        return new C7192a(this, new C5812l(viewGroup.getContext()));
    }

    /* renamed from: a */
    public void m33415a(C7192a c7192a, int i) {
        c7192a.m33410a((C7161h) this.f25465a.get(i));
        c7192a.m33409a(i);
        c7192a.m33411a(i == this.f25466b);
    }

    /* renamed from: a */
    C7161h m33412a() {
        return (C7161h) this.f25465a.get(this.f25466b);
    }

    /* renamed from: a */
    void m33416a(List<C7161h> list, C7161h c7161h) {
        if (list != null) {
            this.f25465a = list;
        }
        if (c7161h == null) {
            this.f25466b = null;
        } else {
            this.f25466b = this.f25465a.indexOf(c7161h);
        }
        notifyDataSetChanged();
    }

    /* renamed from: a */
    void m33414a(int i) {
        this.f25466b = i;
        notifyDataSetChanged();
    }
}
