package com.stripe.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import com.stripe.android.C5756m.C5750e;
import com.stripe.android.C5756m.C5752g;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

public class CountryAutoCompleteTextView extends FrameLayout {
    /* renamed from: a */
    private AutoCompleteTextView f19182a;
    /* renamed from: b */
    private Map<String, String> f19183b;
    /* renamed from: c */
    private String f19184c;
    /* renamed from: d */
    private C5788a f19185d;

    /* renamed from: com.stripe.android.view.CountryAutoCompleteTextView$1 */
    class C57861 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ CountryAutoCompleteTextView f19180a;

        C57861(CountryAutoCompleteTextView countryAutoCompleteTextView) {
            this.f19180a = countryAutoCompleteTextView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f19180a.m24461a(this.f19180a.f19182a.getText().toString());
        }
    }

    /* renamed from: com.stripe.android.view.CountryAutoCompleteTextView$2 */
    class C57872 implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ CountryAutoCompleteTextView f19181a;

        C57872(CountryAutoCompleteTextView countryAutoCompleteTextView) {
            this.f19181a = countryAutoCompleteTextView;
        }

        public void onFocusChange(View view, boolean z) {
            String obj = this.f19181a.f19182a.getText().toString();
            if (z) {
                this.f19181a.f19182a.showDropDown();
            } else {
                this.f19181a.m24461a(obj);
            }
        }
    }

    /* renamed from: com.stripe.android.view.CountryAutoCompleteTextView$a */
    interface C5788a {
        /* renamed from: a */
        void mo5078a(String str);
    }

    public CountryAutoCompleteTextView(Context context) {
        super(context);
        m24460a();
    }

    public CountryAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24460a();
    }

    public CountryAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24460a();
    }

    String getSelectedCountryCode() {
        return this.f19184c;
    }

    void setCountrySelected(String str) {
        m24461a(new Locale("", str).getDisplayCountry());
    }

    void setCountryChangeListener(C5788a c5788a) {
        this.f19185d = c5788a;
    }

    /* renamed from: a */
    private void m24460a() {
        inflate(getContext(), C5752g.country_autocomplete_textview, this);
        this.f19182a = (AutoCompleteTextView) findViewById(C5750e.autocomplete_country_cat);
        this.f19183b = C5806d.m24504a();
        Object c5805c = new C5805c(getContext(), new ArrayList(this.f19183b.keySet()));
        this.f19182a.setThreshold(0);
        this.f19182a.setAdapter(c5805c);
        this.f19182a.setOnItemClickListener(new C57861(this));
        String str = (String) c5805c.getItem(0);
        m24461a(str);
        this.f19182a.setText(str);
        this.f19182a.setOnFocusChangeListener(new C57872(this));
    }

    /* renamed from: a */
    void m24461a(String str) {
        String str2 = (String) this.f19183b.get(str);
        if (str2 != null) {
            if (this.f19184c == null || !this.f19184c.equals(str2)) {
                this.f19184c = str2;
                if (this.f19185d != null) {
                    this.f19185d.mo5078a(this.f19184c);
                }
            }
            this.f19182a.setText(str);
            return;
        }
        this.f19182a.setText(new Locale("", this.f19184c).getDisplayCountry());
    }
}
