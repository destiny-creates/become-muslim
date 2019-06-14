package android.support.design.widget;

import android.widget.ImageButton;

/* compiled from: VisibilityAwareImageButton */
/* renamed from: android.support.design.widget.s */
class C0201s extends ImageButton {
    /* renamed from: a */
    private int f460a;

    public void setVisibility(int i) {
        m462a(i, true);
    }

    /* renamed from: a */
    final void m462a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f460a = i;
        }
    }

    final int getUserSetVisibility() {
        return this.f460a;
    }
}
