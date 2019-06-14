package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* compiled from: ViewGroupOverlayApi18 */
class ad implements ae {
    /* renamed from: a */
    private final ViewGroupOverlay f11886a;

    ad(ViewGroup viewGroup) {
        this.f11886a = viewGroup.getOverlay();
    }

    /* renamed from: a */
    public void mo121a(Drawable drawable) {
        this.f11886a.add(drawable);
    }

    /* renamed from: b */
    public void mo122b(Drawable drawable) {
        this.f11886a.remove(drawable);
    }

    /* renamed from: a */
    public void mo2651a(View view) {
        this.f11886a.add(view);
    }

    /* renamed from: b */
    public void mo2652b(View view) {
        this.f11886a.remove(view);
    }
}
