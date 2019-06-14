package android.support.transition;

import android.os.IBinder;

/* compiled from: WindowIdApi14 */
class au implements aw {
    /* renamed from: a */
    private final IBinder f8090a;

    au(IBinder iBinder) {
        this.f8090a = iBinder;
    }

    public boolean equals(Object obj) {
        return (!(obj instanceof au) || ((au) obj).f8090a.equals(this.f8090a) == null) ? null : true;
    }

    public int hashCode() {
        return this.f8090a.hashCode();
    }
}
