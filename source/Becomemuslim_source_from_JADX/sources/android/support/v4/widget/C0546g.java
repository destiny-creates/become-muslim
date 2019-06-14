package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* compiled from: CursorFilter */
/* renamed from: android.support.v4.widget.g */
class C0546g extends Filter {
    /* renamed from: a */
    C0545a f1384a;

    /* compiled from: CursorFilter */
    /* renamed from: android.support.v4.widget.g$a */
    interface C0545a {
        /* renamed from: a */
        Cursor mo331a();

        /* renamed from: a */
        Cursor mo332a(CharSequence charSequence);

        /* renamed from: a */
        void mo333a(Cursor cursor);

        /* renamed from: c */
        CharSequence mo334c(Cursor cursor);
    }

    C0546g(C0545a c0545a) {
        this.f1384a = c0545a;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f1384a.mo334c((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        charSequence = this.f1384a.mo332a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (charSequence != null) {
            filterResults.count = charSequence.getCount();
            filterResults.values = charSequence;
        } else {
            filterResults.count = null;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        charSequence = this.f1384a.mo331a();
        if (filterResults.values != null && filterResults.values != charSequence) {
            this.f1384a.mo333a((Cursor) filterResults.values);
        }
    }
}
