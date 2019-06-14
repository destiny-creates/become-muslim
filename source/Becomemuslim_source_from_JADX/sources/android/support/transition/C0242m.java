package android.support.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* compiled from: PathProperty */
/* renamed from: android.support.transition.m */
class C0242m<T> extends Property<T, Float> {
    /* renamed from: a */
    private final Property<T, PointF> f595a;
    /* renamed from: b */
    private final PathMeasure f596b;
    /* renamed from: c */
    private final float f597c;
    /* renamed from: d */
    private final float[] f598d = new float[2];
    /* renamed from: e */
    private final PointF f599e = new PointF();
    /* renamed from: f */
    private float f600f;

    public /* synthetic */ Object get(Object obj) {
        return m615a(obj);
    }

    public /* synthetic */ void set(Object obj, Object obj2) {
        m616a(obj, (Float) obj2);
    }

    C0242m(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f595a = property;
        this.f596b = new PathMeasure(path, false);
        this.f597c = this.f596b.getLength();
    }

    /* renamed from: a */
    public Float m615a(T t) {
        return Float.valueOf(this.f600f);
    }

    /* renamed from: a */
    public void m616a(T t, Float f) {
        this.f600f = f.floatValue();
        this.f596b.getPosTan(this.f597c * f.floatValue(), this.f598d, null);
        this.f599e.x = this.f598d[0];
        this.f599e.y = this.f598d[1];
        this.f595a.set(t, this.f599e);
    }
}
