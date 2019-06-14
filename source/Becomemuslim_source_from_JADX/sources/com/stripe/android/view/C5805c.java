package com.stripe.android.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.TextView;
import com.stripe.android.C5756m.C5752g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* compiled from: CountryAdapter */
/* renamed from: com.stripe.android.view.c */
class C5805c extends ArrayAdapter {
    /* renamed from: a */
    List<String> f19232a;
    /* renamed from: b */
    List<String> f19233b = this.f19232a;
    /* renamed from: c */
    private Filter f19234c = new C58031(this);
    /* renamed from: d */
    private Context f19235d;

    /* compiled from: CountryAdapter */
    /* renamed from: com.stripe.android.view.c$1 */
    class C58031 extends Filter {
        /* renamed from: a */
        final /* synthetic */ C5805c f19230a;

        C58031(C5805c c5805c) {
            this.f19230a = c5805c;
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            Object arrayList = new ArrayList();
            if (charSequence == null) {
                filterResults.values = this.f19230a.f19232a;
                return filterResults;
            }
            String toLowerCase = charSequence.toString().toLowerCase();
            for (String str : this.f19230a.f19232a) {
                if (str.toLowerCase().startsWith(toLowerCase)) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() == 0 || (arrayList.size() == 1 && ((String) arrayList.get(0)).equals(charSequence) != null)) {
                arrayList = this.f19230a.f19232a;
            }
            filterResults.values = arrayList;
            return filterResults;
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            this.f19230a.f19233b = (List) filterResults.values;
            this.f19230a.notifyDataSetChanged();
        }
    }

    /* compiled from: CountryAdapter */
    /* renamed from: com.stripe.android.view.c$2 */
    class C58042 implements Comparator<String> {
        /* renamed from: a */
        final /* synthetic */ C5805c f19231a;

        C58042(C5805c c5805c) {
            this.f19231a = c5805c;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m24500a((String) obj, (String) obj2);
        }

        /* renamed from: a */
        public int m24500a(String str, String str2) {
            return str.toLowerCase().compareTo(str2.toLowerCase());
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public /* synthetic */ Object getItem(int i) {
        return m24501a(i);
    }

    C5805c(Context context, List<String> list) {
        super(context, C5752g.menu_text_view);
        this.f19235d = context;
        this.f19232a = m24502a((List) list);
    }

    public int getCount() {
        return this.f19233b.size();
    }

    /* renamed from: a */
    public String m24501a(int i) {
        return (String) this.f19233b.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || !(view instanceof TextView)) {
            TextView textView = (TextView) LayoutInflater.from(this.f19235d).inflate(C5752g.menu_text_view, viewGroup, false);
            textView.setText(m24501a(i));
            return textView;
        }
        ((TextView) view).setText(m24501a(i));
        return view;
    }

    public Filter getFilter() {
        return this.f19234c;
    }

    /* renamed from: a */
    List m24502a(List<String> list) {
        Collections.sort(list, new C58042(this));
        list.remove(m24503a().getDisplayCountry());
        list.add(0, m24503a().getDisplayCountry());
        return list;
    }

    /* renamed from: a */
    Locale m24503a() {
        if (VERSION.SDK_INT >= 24) {
            return this.f19235d.getResources().getConfiguration().getLocales().get(0);
        }
        return this.f19235d.getResources().getConfiguration().locale;
    }
}
