package com.gettipsi.stripe.p125a;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.content.C0366b;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.devmarvel.creditcardentry.library.C1192c;
import com.devmarvel.creditcardentry.library.CreditCardForm;
import com.devmarvel.creditcardentry.p077a.C3493d;
import com.facebook.appevents.UserDataStore;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableMap;
import com.gettipsi.stripe.C2116d.C2111b;
import com.gettipsi.stripe.C2116d.C2112c;
import com.gettipsi.stripe.C2116d.C2113d;
import com.gettipsi.stripe.C2116d.C2114e;
import com.gettipsi.stripe.StripeModule;
import com.gettipsi.stripe.p126b.C2105b;
import com.gettipsi.stripe.p126b.C2108e;
import com.stripe.android.C5817w;
import com.stripe.android.p285b.C7157c;
import com.stripe.android.p285b.C7168u;

/* compiled from: AddCardDialogFragment */
/* renamed from: com.gettipsi.stripe.a.a */
public class C2103a extends DialogFragment {
    /* renamed from: a */
    private static final String f5023a = "a";
    /* renamed from: b */
    private static final String f5024b = C3493d.class.getSimpleName();
    /* renamed from: c */
    private String f5025c;
    /* renamed from: d */
    private ProgressBar f5026d;
    /* renamed from: e */
    private CreditCardForm f5027e;
    /* renamed from: f */
    private ImageView f5028f;
    /* renamed from: g */
    private ImageView f5029g;
    /* renamed from: h */
    private volatile Promise f5030h;
    /* renamed from: i */
    private boolean f5031i;
    /* renamed from: j */
    private C2105b f5032j;
    /* renamed from: k */
    private Button f5033k;

    /* compiled from: AddCardDialogFragment */
    /* renamed from: com.gettipsi.stripe.a.a$1 */
    class C20991 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2103a f5019a;

        C20991(C2103a c2103a) {
            this.f5019a = c2103a;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5019a.m5773a();
        }
    }

    /* compiled from: AddCardDialogFragment */
    /* renamed from: com.gettipsi.stripe.a.a$2 */
    class C21002 implements View.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2103a f5020a;

        C21002(C2103a c2103a) {
            this.f5020a = c2103a;
        }

        public void onClick(View view) {
            this.f5020a.m5773a();
        }
    }

    /* compiled from: AddCardDialogFragment */
    /* renamed from: com.gettipsi.stripe.a.a$3 */
    class C21023 implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ C2103a f5022a;

        /* compiled from: AddCardDialogFragment */
        /* renamed from: com.gettipsi.stripe.a.a$3$1 */
        class C21011 implements TextWatcher {
            /* renamed from: a */
            final /* synthetic */ C21023 f5021a;

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            C21011(C21023 c21023) {
                this.f5021a = c21023;
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.f5021a.f5022a.f5033k.setEnabled(charSequence.length() >= 3 ? true : null);
            }
        }

        C21023(C2103a c2103a) {
            this.f5022a = c2103a;
        }

        public void onFocusChange(View view, boolean z) {
            if (!C2103a.f5024b.equals(view.getClass().getSimpleName())) {
                return;
            }
            if (z) {
                this.f5022a.f5032j.m5781a();
                if (!view.getTag()) {
                    view.setTag("TAG");
                    ((C3493d) view).addTextChangedListener(new C21011(this));
                    return;
                }
                return;
            }
            this.f5022a.f5032j.m5782b();
        }
    }

    /* compiled from: AddCardDialogFragment */
    /* renamed from: com.gettipsi.stripe.a.a$4 */
    class C39854 implements C5817w {
        /* renamed from: a */
        final /* synthetic */ C2103a f9997a;

        C39854(C2103a c2103a) {
            this.f9997a = c2103a;
        }

        /* renamed from: a */
        public void m12197a(C7168u c7168u) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("tokenId", c7168u.y());
            createMap.putBoolean("livemode", c7168u.b());
            createMap.putDouble("created", (double) c7168u.a().getTime());
            createMap.putBoolean("user", c7168u.c());
            WritableMap createMap2 = Arguments.createMap();
            c7168u = c7168u.d();
            createMap2.putString("cardId", c7168u.y());
            createMap2.putString("brand", c7168u.u());
            createMap2.putString("last4", c7168u.t());
            createMap2.putInt("expMonth", c7168u.j().intValue());
            createMap2.putInt("expYear", c7168u.k().intValue());
            createMap2.putString(UserDataStore.COUNTRY, c7168u.x());
            createMap2.putString("currency", c7168u.s());
            createMap2.putString("name", c7168u.l());
            createMap2.putString("addressLine1", c7168u.m());
            createMap2.putString("addressLine2", c7168u.n());
            createMap2.putString("addressCity", c7168u.o());
            createMap2.putString("addressState", c7168u.q());
            createMap2.putString("addressCountry", c7168u.r());
            createMap2.putString("addressZip", c7168u.p());
            createMap.putMap("card", createMap2);
            if (this.f9997a.f5030h != null) {
                this.f9997a.f5030h.resolve(createMap);
                this.f9997a.f5030h = null;
            }
            this.f9997a.f5031i = true;
            this.f9997a.dismiss();
        }

        /* renamed from: a */
        public void m12198a(Exception exception) {
            this.f9997a.f5033k.setEnabled(true);
            this.f9997a.f5026d.setVisibility(8);
            this.f9997a.m5775b(exception.getLocalizedMessage());
        }
    }

    /* renamed from: a */
    public static C2103a m5764a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("KEY", str);
        str = new C2103a();
        str.setArguments(bundle);
        return str;
    }

    /* renamed from: a */
    public void m5774a(Promise promise) {
        this.f5030h = promise;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f5025c = getArguments().getString("KEY");
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        View inflate = View.inflate(getActivity(), C2113d.payment_form_fragment_two, null);
        Dialog create = new Builder(getActivity()).setView(inflate).setTitle(C2114e.gettipsi_card_enter_dialog_title).setPositiveButton(C2114e.gettipsi_card_enter_dialog_positive_button, new C20991(this)).setNegativeButton(17039360, null).create();
        create.show();
        this.f5033k = create.getButton(-1);
        this.f5033k.setOnClickListener(new C21002(this));
        this.f5033k.setTextColor(C0366b.m1112c(getActivity(), C2111b.colorAccent));
        create.getButton(-2).setTextColor(C0366b.m1112c(getActivity(), C2111b.colorAccent));
        this.f5033k.setEnabled(false);
        m5766a(inflate);
        m5771c();
        return create;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!(this.f5031i || this.f5030h == null)) {
            this.f5030h.reject(f5023a, getString(C2114e.gettipsi_user_cancel_dialog));
            this.f5030h = null;
        }
        super.onDismiss(dialogInterface);
    }

    /* renamed from: a */
    private void m5766a(View view) {
        this.f5026d = (ProgressBar) view.findViewById(C2112c.buttonProgress);
        this.f5027e = (CreditCardForm) view.findViewById(C2112c.credit_card_form);
        this.f5028f = (ImageView) view.findViewById(C2112c.imageFlippedCard);
        this.f5029g = (ImageView) view.findViewById(C2112c.imageFlippedCardBack);
    }

    /* renamed from: c */
    private void m5771c() {
        this.f5027e.setOnFocusChangeListener(new C21023(this));
        this.f5032j = new C2105b(getActivity(), this.f5028f, this.f5029g);
        this.f5031i = false;
    }

    /* renamed from: a */
    public void m5773a() {
        this.f5033k.setEnabled(false);
        this.f5026d.setVisibility(0);
        C1192c creditCard = this.f5027e.getCreditCard();
        C7157c c7157c = new C7157c(creditCard.m4168a(), creditCard.m4170c(), creditCard.m4171d(), creditCard.m4169b());
        String a = C2108e.m5808a(c7157c);
        if (a == null) {
            StripeModule.getInstance().getStripe().a(c7157c, this.f5025c, new C39854(this));
            return;
        }
        this.f5033k.setEnabled(true);
        this.f5026d.setVisibility(8);
        m5775b(a);
    }

    /* renamed from: b */
    public void m5775b(String str) {
        Context activity = getActivity();
        if (activity != null && !TextUtils.isEmpty(str)) {
            Toast.makeText(activity, str, 1).show();
        }
    }
}
