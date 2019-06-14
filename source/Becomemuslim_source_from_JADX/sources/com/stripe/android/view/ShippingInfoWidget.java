package com.stripe.android.view;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.facebook.internal.ServerProtocol;
import com.facebook.places.model.PlaceFields;
import com.stripe.android.C5756m.C5750e;
import com.stripe.android.C5756m.C5752g;
import com.stripe.android.C5756m.C5754i;
import com.stripe.android.p285b.C7156a;
import com.stripe.android.p285b.C7156a.C5721a;
import com.stripe.android.p285b.C7160g;
import com.stripe.android.view.CountryAutoCompleteTextView.C5788a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ShippingInfoWidget extends LinearLayout {
    /* renamed from: a */
    private List<String> f19208a = new ArrayList();
    /* renamed from: b */
    private List<String> f19209b = new ArrayList();
    /* renamed from: c */
    private CountryAutoCompleteTextView f19210c;
    /* renamed from: d */
    private TextInputLayout f19211d;
    /* renamed from: e */
    private TextInputLayout f19212e;
    /* renamed from: f */
    private TextInputLayout f19213f;
    /* renamed from: g */
    private TextInputLayout f19214g;
    /* renamed from: h */
    private TextInputLayout f19215h;
    /* renamed from: i */
    private TextInputLayout f19216i;
    /* renamed from: j */
    private TextInputLayout f19217j;
    /* renamed from: k */
    private StripeEditText f19218k;
    /* renamed from: l */
    private StripeEditText f19219l;
    /* renamed from: m */
    private StripeEditText f19220m;
    /* renamed from: n */
    private StripeEditText f19221n;
    /* renamed from: o */
    private StripeEditText f19222o;
    /* renamed from: p */
    private StripeEditText f19223p;
    /* renamed from: q */
    private StripeEditText f19224q;

    /* renamed from: com.stripe.android.view.ShippingInfoWidget$1 */
    class C71861 implements C5788a {
        /* renamed from: a */
        final /* synthetic */ ShippingInfoWidget f25448a;

        C71861(ShippingInfoWidget shippingInfoWidget) {
            this.f25448a = shippingInfoWidget;
        }

        /* renamed from: a */
        public void mo5078a(String str) {
            this.f25448a.m24481a(this.f25448a.f19210c.getSelectedCountryCode());
        }
    }

    public ShippingInfoWidget(Context context) {
        super(context);
        m24482b();
    }

    public ShippingInfoWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24482b();
    }

    public ShippingInfoWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24482b();
    }

    public void setOptionalFields(List<String> list) {
        if (list != null) {
            this.f19208a = list;
        } else {
            this.f19208a = new ArrayList();
        }
        m24484d();
        m24481a(this.f19210c.getSelectedCountryCode());
    }

    public void setHiddenFields(List<String> list) {
        if (list != null) {
            this.f19209b = list;
        } else {
            this.f19209b = new ArrayList();
        }
        m24484d();
        m24481a(this.f19210c.getSelectedCountryCode());
    }

    public C7160g getShippingInformation() {
        if (m24491a()) {
            return new C7160g(new C5721a().m24177a(this.f19220m.getText().toString()).m24179b(this.f19210c.getSelectedCountryCode()).m24180c(this.f19218k.getText().toString()).m24181d(this.f19219l.getText().toString()).m24182e(this.f19222o.getText().toString()).m24183f(this.f19223p.getText().toString()).m24178a(), this.f19221n.getText().toString(), this.f19224q.getText().toString());
        }
        return null;
    }

    /* renamed from: a */
    public void m24490a(C7160g c7160g) {
        if (c7160g != null) {
            C7156a c = c7160g.m33265c();
            if (c != null) {
                this.f19220m.setText(c.m33207c());
                if (!(c.m33208d() == null || c.m33208d().isEmpty())) {
                    this.f19210c.setCountrySelected(c.m33208d());
                }
                this.f19218k.setText(c.m33209e());
                this.f19219l.setText(c.m33210f());
                this.f19222o.setText(c.m33211g());
                this.f19223p.setText(c.m33212h());
            }
            this.f19221n.setText(c7160g.m33266d());
            this.f19224q.setText(c7160g.m33267e());
        }
    }

    /* renamed from: a */
    public boolean m24491a() {
        boolean b;
        boolean z;
        boolean z2;
        boolean isEmpty;
        boolean z3;
        boolean z4;
        String selectedCountryCode = this.f19210c.getSelectedCountryCode();
        if (!(this.f19222o.getText().toString().isEmpty() && (this.f19208a.contains("postal_code") || this.f19209b.contains("postal_code")))) {
            if (selectedCountryCode.equals(Locale.US.getCountry())) {
                b = C5806d.m24506b(this.f19222o.getText().toString().trim());
            } else if (selectedCountryCode.equals(Locale.UK.getCountry())) {
                b = C5806d.m24506b(this.f19222o.getText().toString().trim());
            } else if (selectedCountryCode.equals(Locale.CANADA.getCountry())) {
                b = C5806d.m24506b(this.f19222o.getText().toString().trim());
            } else if (C5806d.m24505a(selectedCountryCode)) {
                b = this.f19222o.getText().toString().isEmpty() ^ true;
            }
            this.f19222o.setShouldShowError(b);
            z = (!this.f19218k.getText().toString().isEmpty() || this.f19208a.contains("address_line_one") || this.f19209b.contains("address_line_one")) ? false : true;
            this.f19218k.setShouldShowError(z);
            z2 = (!this.f19220m.getText().toString().isEmpty() || this.f19208a.contains("city") || this.f19209b.contains("city")) ? false : true;
            this.f19220m.setShouldShowError(z2);
            isEmpty = this.f19221n.getText().toString().isEmpty();
            this.f19221n.setShouldShowError(isEmpty);
            z3 = (!this.f19223p.getText().toString().isEmpty() || this.f19208a.contains(ServerProtocol.DIALOG_PARAM_STATE) || this.f19209b.contains(ServerProtocol.DIALOG_PARAM_STATE)) ? false : true;
            this.f19223p.setShouldShowError(z3);
            z4 = (!this.f19224q.getText().toString().isEmpty() || this.f19208a.contains(PlaceFields.PHONE) || this.f19209b.contains(PlaceFields.PHONE)) ? false : true;
            this.f19224q.setShouldShowError(z4);
            if (b || z || z2 || z3 || isEmpty || z4) {
                return false;
            }
            return true;
        }
        b = true;
        if (b) {
        }
        this.f19222o.setShouldShowError(b);
        if (!!this.f19218k.getText().toString().isEmpty()) {
        }
        this.f19218k.setShouldShowError(z);
        if (!!this.f19220m.getText().toString().isEmpty()) {
        }
        this.f19220m.setShouldShowError(z2);
        isEmpty = this.f19221n.getText().toString().isEmpty();
        this.f19221n.setShouldShowError(isEmpty);
        if (!!this.f19223p.getText().toString().isEmpty()) {
        }
        this.f19223p.setShouldShowError(z3);
        if (!!this.f19224q.getText().toString().isEmpty()) {
        }
        this.f19224q.setShouldShowError(z4);
        if (b) {
        }
        return false;
    }

    /* renamed from: b */
    private void m24482b() {
        setOrientation(1);
        inflate(getContext(), C5752g.add_address_widget, this);
        this.f19210c = (CountryAutoCompleteTextView) findViewById(C5750e.country_autocomplete_aaw);
        this.f19211d = (TextInputLayout) findViewById(C5750e.tl_address_line1_aaw);
        this.f19212e = (TextInputLayout) findViewById(C5750e.tl_address_line2_aaw);
        this.f19213f = (TextInputLayout) findViewById(C5750e.tl_city_aaw);
        this.f19214g = (TextInputLayout) findViewById(C5750e.tl_name_aaw);
        this.f19215h = (TextInputLayout) findViewById(C5750e.tl_postal_code_aaw);
        this.f19216i = (TextInputLayout) findViewById(C5750e.tl_state_aaw);
        this.f19218k = (StripeEditText) findViewById(C5750e.et_address_line_one_aaw);
        this.f19219l = (StripeEditText) findViewById(C5750e.et_address_line_two_aaw);
        this.f19220m = (StripeEditText) findViewById(C5750e.et_city_aaw);
        this.f19221n = (StripeEditText) findViewById(C5750e.et_name_aaw);
        this.f19222o = (StripeEditText) findViewById(C5750e.et_postal_code_aaw);
        this.f19223p = (StripeEditText) findViewById(C5750e.et_state_aaw);
        this.f19224q = (StripeEditText) findViewById(C5750e.et_phone_number_aaw);
        this.f19217j = (TextInputLayout) findViewById(C5750e.tl_phone_number_aaw);
        this.f19210c.setCountryChangeListener(new C71861(this));
        this.f19224q.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        m24483c();
        m24484d();
        m24481a(this.f19210c.getSelectedCountryCode());
    }

    /* renamed from: c */
    private void m24483c() {
        this.f19218k.setErrorMessageListener(new C7188f(this.f19211d));
        this.f19220m.setErrorMessageListener(new C7188f(this.f19213f));
        this.f19221n.setErrorMessageListener(new C7188f(this.f19214g));
        this.f19222o.setErrorMessageListener(new C7188f(this.f19215h));
        this.f19223p.setErrorMessageListener(new C7188f(this.f19216i));
        this.f19224q.setErrorMessageListener(new C7188f(this.f19217j));
        this.f19218k.setErrorMessage(getResources().getString(C5754i.address_required));
        this.f19220m.setErrorMessage(getResources().getString(C5754i.address_city_required));
        this.f19221n.setErrorMessage(getResources().getString(C5754i.address_name_required));
        this.f19224q.setErrorMessage(getResources().getString(C5754i.address_phone_number_required));
    }

    /* renamed from: d */
    private void m24484d() {
        this.f19214g.setHint(getResources().getString(C5754i.address_label_name));
        if (this.f19208a.contains("city")) {
            this.f19213f.setHint(getResources().getString(C5754i.address_label_city_optional));
        } else {
            this.f19213f.setHint(getResources().getString(C5754i.address_label_city));
        }
        if (this.f19208a.contains(PlaceFields.PHONE)) {
            this.f19217j.setHint(getResources().getString(C5754i.address_label_phone_number_optional));
        } else {
            this.f19217j.setHint(getResources().getString(C5754i.address_label_phone_number));
        }
        m24485e();
    }

    /* renamed from: e */
    private void m24485e() {
        if (this.f19209b.contains("address_line_one")) {
            this.f19211d.setVisibility(8);
        }
        if (this.f19209b.contains("address_line_two")) {
            this.f19212e.setVisibility(8);
        }
        if (this.f19209b.contains(ServerProtocol.DIALOG_PARAM_STATE)) {
            this.f19216i.setVisibility(8);
        }
        if (this.f19209b.contains("city")) {
            this.f19213f.setVisibility(8);
        }
        if (this.f19209b.contains("postal_code")) {
            this.f19215h.setVisibility(8);
        }
        if (this.f19209b.contains(PlaceFields.PHONE)) {
            this.f19217j.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m24481a(String str) {
        if (str.equals(Locale.US.getCountry())) {
            m24486f();
        } else if (str.equals(Locale.UK.getCountry())) {
            m24487g();
        } else if (str.equals(Locale.CANADA.getCountry())) {
            m24488h();
        } else {
            m24489i();
        }
        if (C5806d.m24505a(str) == null || this.f19209b.contains("postal_code") != null) {
            this.f19215h.setVisibility(8);
        } else {
            this.f19215h.setVisibility(0);
        }
    }

    /* renamed from: f */
    private void m24486f() {
        if (this.f19208a.contains("address_line_one")) {
            this.f19211d.setHint(getResources().getString(C5754i.address_label_address_optional));
        } else {
            this.f19211d.setHint(getResources().getString(C5754i.address_label_address));
        }
        this.f19212e.setHint(getResources().getString(C5754i.address_label_apt_optional));
        if (this.f19208a.contains("postal_code")) {
            this.f19215h.setHint(getResources().getString(C5754i.address_label_zip_code_optional));
        } else {
            this.f19215h.setHint(getResources().getString(C5754i.address_label_zip_code));
        }
        if (this.f19208a.contains(ServerProtocol.DIALOG_PARAM_STATE)) {
            this.f19216i.setHint(getResources().getString(C5754i.address_label_state_optional));
        } else {
            this.f19216i.setHint(getResources().getString(C5754i.address_label_state));
        }
        this.f19222o.setErrorMessage(getResources().getString(C5754i.address_zip_invalid));
        this.f19223p.setErrorMessage(getResources().getString(C5754i.address_state_required));
    }

    /* renamed from: g */
    private void m24487g() {
        if (this.f19208a.contains("address_line_one")) {
            this.f19211d.setHint(getResources().getString(C5754i.address_label_address_line1_optional));
        } else {
            this.f19211d.setHint(getResources().getString(C5754i.address_label_address_line1));
        }
        this.f19212e.setHint(getResources().getString(C5754i.address_label_address_line2_optional));
        if (this.f19208a.contains("postal_code")) {
            this.f19215h.setHint(getResources().getString(C5754i.address_label_postcode_optional));
        } else {
            this.f19215h.setHint(getResources().getString(C5754i.address_label_postcode));
        }
        if (this.f19208a.contains(ServerProtocol.DIALOG_PARAM_STATE)) {
            this.f19216i.setHint(getResources().getString(C5754i.address_label_county_optional));
        } else {
            this.f19216i.setHint(getResources().getString(C5754i.address_label_county));
        }
        this.f19222o.setErrorMessage(getResources().getString(C5754i.address_postcode_invalid));
        this.f19223p.setErrorMessage(getResources().getString(C5754i.address_county_required));
    }

    /* renamed from: h */
    private void m24488h() {
        if (this.f19208a.contains("address_line_one")) {
            this.f19211d.setHint(getResources().getString(C5754i.address_label_address_optional));
        } else {
            this.f19211d.setHint(getResources().getString(C5754i.address_label_address));
        }
        this.f19212e.setHint(getResources().getString(C5754i.address_label_apt_optional));
        if (this.f19208a.contains("postal_code")) {
            this.f19215h.setHint(getResources().getString(C5754i.address_label_postal_code_optional));
        } else {
            this.f19215h.setHint(getResources().getString(C5754i.address_label_postal_code));
        }
        if (this.f19208a.contains(ServerProtocol.DIALOG_PARAM_STATE)) {
            this.f19216i.setHint(getResources().getString(C5754i.address_label_province_optional));
        } else {
            this.f19216i.setHint(getResources().getString(C5754i.address_label_province));
        }
        this.f19222o.setErrorMessage(getResources().getString(C5754i.address_postal_code_invalid));
        this.f19223p.setErrorMessage(getResources().getString(C5754i.address_province_required));
    }

    /* renamed from: i */
    private void m24489i() {
        if (this.f19208a.contains("address_line_one")) {
            this.f19211d.setHint(getResources().getString(C5754i.address_label_address_line1_optional));
        } else {
            this.f19211d.setHint(getResources().getString(C5754i.address_label_address_line1));
        }
        this.f19212e.setHint(getResources().getString(C5754i.address_label_address_line2_optional));
        if (this.f19208a.contains("postal_code")) {
            this.f19215h.setHint(getResources().getString(C5754i.address_label_zip_postal_code_optional));
        } else {
            this.f19215h.setHint(getResources().getString(C5754i.address_label_zip_postal_code));
        }
        if (this.f19208a.contains(ServerProtocol.DIALOG_PARAM_STATE)) {
            this.f19216i.setHint(getResources().getString(C5754i.address_label_region_generic_optional));
        } else {
            this.f19216i.setHint(getResources().getString(C5754i.address_label_region_generic));
        }
        this.f19222o.setErrorMessage(getResources().getString(C5754i.address_zip_postal_invalid));
        this.f19223p.setErrorMessage(getResources().getString(C5754i.address_region_generic_required));
    }
}
