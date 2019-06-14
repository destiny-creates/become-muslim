package com.devmarvel.creditcardentry.library;

import com.devmarvel.creditcardentry.C1175a.C1169c;
import com.facebook.internal.AnalyticsEvents;
import java.io.Serializable;

/* compiled from: CardType */
/* renamed from: com.devmarvel.creditcardentry.library.a */
public enum C1190a implements Serializable {
    VISA("Visa", C1169c.ic_card_visa, "^4[0-9]{15}?", "^4[0-9]{3}?"),
    MASTERCARD("MasterCard", C1169c.ic_card_mastercard, "^5[1-5][0-9]{14}$", "^5[1-5][0-9]{2}$"),
    AMEX("American Express", C1169c.ic_card_amex, "^3[47][0-9]{13}$", "^3[47][0-9]{2}$"),
    DISCOVER("Discover", C1169c.ic_card_discover, "^6(?:011|5[0-9]{2})[0-9]{12}$", "^6(?:011|5[0-9]{2})$"),
    DINERS("Diners Club", C1169c.ic_card_diners, "^3(?:0[0-5]|[68][0-9])[0-9]{11}$", "^3(?:0[0-5]|[68][0-9])[0-9]$"),
    JCB("JCB", C1169c.ic_card_jcb, "^35[0-9]{14}$", "^35[0-9]{2}$"),
    INVALID(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, C1169c.ic_card_placeholder, null, null);
    
    /* renamed from: h */
    public final String f3337h;
    /* renamed from: i */
    public final String f3338i;
    /* renamed from: j */
    public final String f3339j;
    /* renamed from: k */
    public final int f3340k;
    /* renamed from: l */
    public final int f3341l;

    private C1190a(String str, int i, String str2, String str3) {
        this.f3341l = C1169c.ic_card_placeholder;
        this.f3337h = str;
        this.f3340k = i;
        this.f3338i = str2;
        this.f3339j = str3;
    }

    public String toString() {
        return this.f3337h;
    }
}
