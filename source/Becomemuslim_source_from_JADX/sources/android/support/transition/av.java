package android.support.transition;

import android.view.View;
import android.view.WindowId;

/* compiled from: WindowIdApi18 */
class av implements aw {
    /* renamed from: a */
    private final WindowId f8091a;

    av(View view) {
        this.f8091a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (!(obj instanceof av) || ((av) obj).f8091a.equals(this.f8091a) == null) ? null : true;
    }

    public int hashCode() {
        return this.f8091a.hashCode();
    }
}
