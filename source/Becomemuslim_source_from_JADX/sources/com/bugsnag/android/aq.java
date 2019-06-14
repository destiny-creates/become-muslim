package com.bugsnag.android;

import com.bugsnag.android.NativeInterface.C1068a;
import com.bugsnag.android.NativeInterface.C1069b;
import com.bugsnag.android.ab.C1071a;
import java.util.Observable;

/* compiled from: User */
class aq extends Observable implements C1071a {
    /* renamed from: a */
    private String f9191a;
    /* renamed from: b */
    private String f9192b;
    /* renamed from: c */
    private String f9193c;

    aq() {
    }

    public void toStream(ab abVar) {
        abVar.mo772c();
        abVar.mo764a("id").mo771b(this.f9191a);
        abVar.mo764a("email").mo771b(this.f9192b);
        abVar.mo764a("name").mo771b(this.f9193c);
        abVar.mo770b();
    }

    /* renamed from: a */
    public String m11052a() {
        return this.f9191a;
    }

    /* renamed from: a */
    public void m11053a(String str) {
        this.f9191a = str;
        setChanged();
        notifyObservers(new C1068a(C1069b.UPDATE_USER_ID, str));
    }

    /* renamed from: b */
    public String m11054b() {
        return this.f9192b;
    }

    /* renamed from: b */
    public void m11055b(String str) {
        this.f9192b = str;
        setChanged();
        notifyObservers(new C1068a(C1069b.UPDATE_USER_EMAIL, str));
    }

    /* renamed from: c */
    public String m11056c() {
        return this.f9193c;
    }

    /* renamed from: c */
    public void m11057c(String str) {
        this.f9193c = str;
        setChanged();
        notifyObservers(new C1068a(C1069b.UPDATE_USER_NAME, str));
    }
}
