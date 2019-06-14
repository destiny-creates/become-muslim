package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ResourceCursorAdapter */
/* renamed from: android.support.v4.widget.o */
public abstract class C4471o extends C3235f {
    /* renamed from: j */
    private int f11944j;
    /* renamed from: k */
    private int f11945k;
    /* renamed from: l */
    private LayoutInflater f11946l;

    @Deprecated
    public C4471o(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f11945k = i;
        this.f11944j = i;
        this.f11946l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    public View mo2706a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f11946l.inflate(this.f11944j, viewGroup, false);
    }

    /* renamed from: b */
    public View mo2707b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f11946l.inflate(this.f11945k, viewGroup, false);
    }
}
