package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.widget.C0546g.C0545a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import expo.modules.contacts.EXColumns;

/* compiled from: CursorAdapter */
/* renamed from: android.support.v4.widget.f */
public abstract class C3235f extends BaseAdapter implements C0545a, Filterable {
    /* renamed from: a */
    protected boolean f8304a;
    /* renamed from: b */
    protected boolean f8305b;
    /* renamed from: c */
    protected Cursor f8306c;
    /* renamed from: d */
    protected Context f8307d;
    /* renamed from: e */
    protected int f8308e;
    /* renamed from: f */
    protected C0543a f8309f;
    /* renamed from: g */
    protected DataSetObserver f8310g;
    /* renamed from: h */
    protected C0546g f8311h;
    /* renamed from: i */
    protected FilterQueryProvider f8312i;

    /* compiled from: CursorAdapter */
    /* renamed from: android.support.v4.widget.f$a */
    private class C0543a extends ContentObserver {
        /* renamed from: a */
        final /* synthetic */ C3235f f1382a;

        public boolean deliverSelfNotifications() {
            return true;
        }

        C0543a(C3235f c3235f) {
            this.f1382a = c3235f;
            super(new Handler());
        }

        public void onChange(boolean z) {
            this.f1382a.m9820b();
        }
    }

    /* compiled from: CursorAdapter */
    /* renamed from: android.support.v4.widget.f$b */
    private class C0544b extends DataSetObserver {
        /* renamed from: a */
        final /* synthetic */ C3235f f1383a;

        C0544b(C3235f c3235f) {
            this.f1383a = c3235f;
        }

        public void onChanged() {
            this.f1383a.f8304a = true;
            this.f1383a.notifyDataSetChanged();
        }

        public void onInvalidated() {
            this.f1383a.f8304a = false;
            this.f1383a.notifyDataSetInvalidated();
        }
    }

    /* renamed from: a */
    public abstract View mo2706a(Context context, Cursor cursor, ViewGroup viewGroup);

    /* renamed from: a */
    public abstract void mo3341a(View view, Context context, Cursor cursor);

    public boolean hasStableIds() {
        return true;
    }

    public C3235f(Context context, Cursor cursor, boolean z) {
        m9815a(context, cursor, z ? true : true);
    }

    /* renamed from: a */
    void m9815a(Context context, Cursor cursor, int i) {
        boolean z = false;
        if ((i & 1) == 1) {
            i |= 2;
            this.f8305b = true;
        } else {
            this.f8305b = false;
        }
        if (cursor != null) {
            z = true;
        }
        this.f8306c = cursor;
        this.f8304a = z;
        this.f8307d = context;
        this.f8308e = z ? cursor.getColumnIndexOrThrow(EXColumns.ID) : -1;
        if ((i & 2) == 2) {
            this.f8309f = new C0543a(this);
            this.f8310g = new C0544b(this);
        } else {
            this.f8309f = null;
            this.f8310g = null;
        }
        if (z) {
            if (this.f8309f != null) {
                cursor.registerContentObserver(this.f8309f);
            }
            if (this.f8310g != null) {
                cursor.registerDataSetObserver(this.f8310g);
            }
        }
    }

    /* renamed from: a */
    public Cursor mo331a() {
        return this.f8306c;
    }

    public int getCount() {
        return (!this.f8304a || this.f8306c == null) ? 0 : this.f8306c.getCount();
    }

    public Object getItem(int i) {
        if (!this.f8304a || this.f8306c == null) {
            return 0;
        }
        this.f8306c.moveToPosition(i);
        return this.f8306c;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getItemId(int r4) {
        /*
        r3 = this;
        r0 = r3.f8304a;
        r1 = 0;
        if (r0 == 0) goto L_0x001c;
    L_0x0006:
        r0 = r3.f8306c;
        if (r0 == 0) goto L_0x001c;
    L_0x000a:
        r0 = r3.f8306c;
        r4 = r0.moveToPosition(r4);
        if (r4 == 0) goto L_0x001b;
    L_0x0012:
        r4 = r3.f8306c;
        r0 = r3.f8308e;
        r0 = r4.getLong(r0);
        return r0;
    L_0x001b:
        return r1;
    L_0x001c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.f.getItemId(int):long");
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f8304a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f8306c.moveToPosition(i)) {
            if (view == null) {
                view = mo2706a(this.f8307d, this.f8306c, viewGroup);
            }
            mo3341a(view, this.f8307d, this.f8306c);
            return view;
        } else {
            viewGroup = new StringBuilder();
            viewGroup.append("couldn't move cursor to position ");
            viewGroup.append(i);
            throw new IllegalStateException(viewGroup.toString());
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f8304a) {
            return 0;
        }
        this.f8306c.moveToPosition(i);
        if (view == null) {
            view = mo2707b(this.f8307d, this.f8306c, viewGroup);
        }
        mo3341a(view, this.f8307d, this.f8306c);
        return view;
    }

    /* renamed from: b */
    public View mo2707b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo2706a(context, cursor, viewGroup);
    }

    /* renamed from: a */
    public void mo333a(Cursor cursor) {
        cursor = m9818b(cursor);
        if (cursor != null) {
            cursor.close();
        }
    }

    /* renamed from: b */
    public Cursor m9818b(Cursor cursor) {
        if (cursor == this.f8306c) {
            return null;
        }
        Cursor cursor2 = this.f8306c;
        if (cursor2 != null) {
            if (this.f8309f != null) {
                cursor2.unregisterContentObserver(this.f8309f);
            }
            if (this.f8310g != null) {
                cursor2.unregisterDataSetObserver(this.f8310g);
            }
        }
        this.f8306c = cursor;
        if (cursor != null) {
            if (this.f8309f != null) {
                cursor.registerContentObserver(this.f8309f);
            }
            if (this.f8310g != null) {
                cursor.registerDataSetObserver(this.f8310g);
            }
            this.f8308e = cursor.getColumnIndexOrThrow(EXColumns.ID);
            this.f8304a = true;
            notifyDataSetChanged();
        } else {
            this.f8308e = -1;
            this.f8304a = null;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    /* renamed from: c */
    public CharSequence mo334c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    /* renamed from: a */
    public Cursor mo332a(CharSequence charSequence) {
        if (this.f8312i != null) {
            return this.f8312i.runQuery(charSequence);
        }
        return this.f8306c;
    }

    public Filter getFilter() {
        if (this.f8311h == null) {
            this.f8311h = new C0546g(this);
        }
        return this.f8311h;
    }

    /* renamed from: b */
    protected void m9820b() {
        if (this.f8305b && this.f8306c != null && !this.f8306c.isClosed()) {
            this.f8304a = this.f8306c.requery();
        }
    }
}
