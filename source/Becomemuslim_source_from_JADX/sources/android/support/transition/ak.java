package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* compiled from: ViewOverlayApi18 */
class ak implements al {
    /* renamed from: a */
    private final ViewOverlay f8081a;

    ak(View view) {
        this.f8081a = view.getOverlay();
    }

    /* renamed from: a */
    public void mo121a(Drawable drawable) {
        this.f8081a.add(drawable);
    }

    /* renamed from: b */
    public void mo122b(Drawable drawable) {
        this.f8081a.remove(drawable);
    }
}
