package android.support.v4.widget;

import android.widget.ListView;

/* compiled from: ListViewAutoScrollHelper */
/* renamed from: android.support.v4.widget.l */
public class C3242l extends C0533a {
    /* renamed from: f */
    private final ListView f8324f;

    /* renamed from: e */
    public boolean mo346e(int i) {
        return false;
    }

    public C3242l(ListView listView) {
        super(listView);
        this.f8324f = listView;
    }

    /* renamed from: a */
    public void mo345a(int i, int i2) {
        C0558m.m1889a(this.f8324f, i2);
    }

    /* renamed from: f */
    public boolean mo347f(int i) {
        ListView listView = this.f8324f;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 < count || listView.getChildAt(childCount - 1).getBottom() > listView.getHeight()) {
                return true;
            }
            return false;
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition > 0 || listView.getChildAt(0).getTop() < 0) {
                return true;
            }
            return false;
        }
        return true;
    }
}
