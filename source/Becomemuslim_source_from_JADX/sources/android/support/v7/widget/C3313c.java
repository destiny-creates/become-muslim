package android.support.v7.widget;

import android.graphics.Outline;

/* compiled from: ActionBarBackgroundDrawableV21 */
/* renamed from: android.support.v7.widget.c */
class C3313c extends C0771b {
    public C3313c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(Outline outline) {
        if (this.a.f1716d) {
            if (this.a.f1715c != null) {
                this.a.f1715c.getOutline(outline);
            }
        } else if (this.a.f1713a != null) {
            this.a.f1713a.getOutline(outline);
        }
    }
}
