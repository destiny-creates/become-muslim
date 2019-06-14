package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.C0150b;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: ViewOffsetBehavior */
/* renamed from: android.support.design.widget.o */
class C3139o<V extends View> extends C0150b<V> {
    /* renamed from: a */
    private C0198p f8055a;
    /* renamed from: b */
    private int f8056b = 0;
    /* renamed from: c */
    private int f8057c = 0;

    public C3139o(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public boolean mo55a(CoordinatorLayout coordinatorLayout, V v, int i) {
        mo2649b(coordinatorLayout, v, i);
        if (this.f8055a == null) {
            this.f8055a = new C0198p(v);
        }
        this.f8055a.m456a();
        if (this.f8056b != null) {
            this.f8055a.m457a(this.f8056b);
            this.f8056b = 0;
        }
        if (this.f8057c != null) {
            this.f8055a.m459b(this.f8057c);
            this.f8057c = 0;
        }
        return true;
    }

    /* renamed from: b */
    protected void mo2649b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.m14796a((View) v, i);
    }

    /* renamed from: a */
    public boolean mo3315a(int i) {
        if (this.f8055a != null) {
            return this.f8055a.m457a(i);
        }
        this.f8056b = i;
        return false;
    }

    /* renamed from: b */
    public int mo3317b() {
        return this.f8055a != null ? this.f8055a.m458b() : 0;
    }
}
