package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.C0494b;
import android.support.v4.view.p033a.C0483b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: RecyclerViewAccessibilityDelegate */
public class ba extends C0494b {
    /* renamed from: a */
    final RecyclerView f8795a;
    /* renamed from: b */
    final C0494b f8796b = new C3311a(this);

    /* compiled from: RecyclerViewAccessibilityDelegate */
    /* renamed from: android.support.v7.widget.ba$a */
    public static class C3311a extends C0494b {
        /* renamed from: a */
        final ba f8794a;

        public C3311a(ba baVar) {
            this.f8794a = baVar;
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0483b c0483b) {
            super.onInitializeAccessibilityNodeInfo(view, c0483b);
            if (!this.f8794a.m10506a() && this.f8794a.f8795a.getLayoutManager() != null) {
                this.f8794a.f8795a.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, c0483b);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            return (this.f8794a.m10506a() || this.f8794a.f8795a.getLayoutManager() == null) ? null : this.f8794a.f8795a.getLayoutManager().performAccessibilityActionForItem(view, i, bundle);
        }
    }

    public ba(RecyclerView recyclerView) {
        this.f8795a = recyclerView;
    }

    /* renamed from: a */
    boolean m10506a() {
        return this.f8795a.hasPendingAdapterUpdates();
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle) != null) {
            return true;
        }
        return (m10506a() != null || this.f8795a.getLayoutManager() == null) ? null : this.f8795a.getLayoutManager().performAccessibilityAction(i, bundle);
    }

    public void onInitializeAccessibilityNodeInfo(View view, C0483b c0483b) {
        super.onInitializeAccessibilityNodeInfo(view, c0483b);
        c0483b.m1512b(RecyclerView.class.getName());
        if (m10506a() == null && this.f8795a.getLayoutManager() != null) {
            this.f8795a.getLayoutManager().onInitializeAccessibilityNodeInfo(c0483b);
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !m10506a()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }

    /* renamed from: b */
    public C0494b m10507b() {
        return this.f8796b;
    }
}
