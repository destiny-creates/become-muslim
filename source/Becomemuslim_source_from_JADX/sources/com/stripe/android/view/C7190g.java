package com.stripe.android.view;

import android.support.v7.widget.RecyclerView.C0689a;
import android.support.v7.widget.RecyclerView.C0718x;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.stripe.android.C5756m.C5750e;
import com.stripe.android.C5756m.C5752g;
import com.stripe.android.p285b.C7158d;
import com.stripe.android.p285b.C7159e;
import com.stripe.android.p285b.C7162i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MaskedCardAdapter */
/* renamed from: com.stripe.android.view.g */
class C7190g extends C0689a<C7189a> {
    /* renamed from: a */
    private List<C7159e> f25454a = new ArrayList();
    /* renamed from: b */
    private int f25455b = -1;

    /* compiled from: MaskedCardAdapter */
    /* renamed from: com.stripe.android.view.g$a */
    class C7189a extends C0718x {
        /* renamed from: a */
        MaskedCardView f25451a;
        /* renamed from: b */
        int f25452b;
        /* renamed from: c */
        final /* synthetic */ C7190g f25453c;

        C7189a(final C7190g c7190g, FrameLayout frameLayout) {
            this.f25453c = c7190g;
            super(frameLayout);
            this.f25451a = (MaskedCardView) frameLayout.findViewById(C5750e.masked_card_item);
            frameLayout.setOnClickListener(new OnClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ C7189a f19239b;

                public void onClick(View view) {
                    if (this.f19239b.f25451a.isSelected() == null) {
                        this.f19239b.f25451a.m24470a();
                        this.f19239b.f25453c.m33397a(this.f19239b.f25452b);
                    }
                }
            });
        }

        /* renamed from: a */
        void m33393a(C7159e c7159e) {
            this.f25451a.setCustomerSource(c7159e);
        }

        /* renamed from: a */
        void m33392a(int i) {
            this.f25452b = i;
        }

        /* renamed from: a */
        void m33394a(boolean z) {
            this.f25451a.setSelected(z);
        }
    }

    public /* synthetic */ void onBindViewHolder(C0718x c0718x, int i) {
        m33399a((C7189a) c0718x, i);
    }

    public /* synthetic */ C0718x onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m33396a(viewGroup, i);
    }

    C7190g(List<C7159e> list) {
        m33401a((C7159e[]) list.toArray(new C7159e[list.size()]));
    }

    /* renamed from: a */
    void m33400a(List<C7159e> list) {
        this.f25454a.clear();
        this.f25454a = list;
        notifyDataSetChanged();
    }

    /* renamed from: a */
    void m33398a(C7158d c7158d) {
        this.f25454a = c7158d.m33253d();
        String c = c7158d.m33252c();
        if (c == null) {
            m33397a(-1);
        } else {
            m33403a(c);
        }
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f25454a.size();
    }

    /* renamed from: a */
    public void m33399a(C7189a c7189a, int i) {
        c7189a.m33393a((C7159e) this.f25454a.get(i));
        c7189a.m33392a(i);
        c7189a.m33394a(i == this.f25455b);
    }

    /* renamed from: a */
    public C7189a m33396a(ViewGroup viewGroup, int i) {
        return new C7189a(this, (FrameLayout) LayoutInflater.from(viewGroup.getContext()).inflate(C5752g.masked_card_row, viewGroup, false));
    }

    /* renamed from: a */
    boolean m33403a(String str) {
        for (int i = 0; i < this.f25454a.size(); i++) {
            if (str.equals(((C7159e) this.f25454a.get(i)).mo5067y())) {
                m33397a(i);
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    C7159e m33395a() {
        if (this.f25455b == -1) {
            return null;
        }
        return (C7159e) this.f25454a.get(this.f25455b);
    }

    /* renamed from: a */
    void m33401a(C7159e... c7159eArr) {
        if (c7159eArr != null) {
            for (C7159e c7159e : c7159eArr) {
                if (c7159e.m33259e() != null || m33402a(c7159e.m33257c())) {
                    this.f25454a.add(c7159e);
                }
            }
            notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    boolean m33402a(C7162i c7162i) {
        return (c7162i == null || "card".equals(c7162i.m33297q()) == null) ? null : true;
    }

    /* renamed from: a */
    void m33397a(int i) {
        this.f25455b = i;
        notifyDataSetChanged();
    }
}
