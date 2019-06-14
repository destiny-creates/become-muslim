package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* compiled from: ActionBarBackgroundDrawable */
/* renamed from: android.support.v7.widget.b */
class C0771b extends Drawable {
    /* renamed from: a */
    final ActionBarContainer f2055a;

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public C0771b(ActionBarContainer actionBarContainer) {
        this.f2055a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f2055a.f1716d) {
            if (this.f2055a.f1713a != null) {
                this.f2055a.f1713a.draw(canvas);
            }
            if (this.f2055a.f1714b != null && this.f2055a.f1717e) {
                this.f2055a.f1714b.draw(canvas);
            }
        } else if (this.f2055a.f1715c != null) {
            this.f2055a.f1715c.draw(canvas);
        }
    }
}
