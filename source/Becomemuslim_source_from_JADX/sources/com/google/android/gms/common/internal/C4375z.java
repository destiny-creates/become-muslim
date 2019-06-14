package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.p174b.C2762f;
import com.google.android.gms.p174b.C2762f.C2761a;
import com.google.android.gms.p174b.C4757d;

/* renamed from: com.google.android.gms.common.internal.z */
public final class C4375z extends C2762f<C2866s> {
    /* renamed from: a */
    private static final C4375z f11595a = new C4375z();

    private C4375z() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    /* renamed from: a */
    public static View m14393a(Context context, int i, int i2) {
        return f11595a.m14394b(context, i, i2);
    }

    /* renamed from: b */
    private final View m14394b(Context context, int i, int i2) {
        try {
            C4788y c4788y = new C4788y(i, i2, null);
            return (View) C4757d.m16685a(((C2866s) m7875a(context)).mo2465a(C4757d.m16684a((Object) context), c4788y));
        } catch (Context context2) {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("Could not get button with size ");
            stringBuilder.append(i);
            stringBuilder.append(" and color ");
            stringBuilder.append(i2);
            throw new C2761a(stringBuilder.toString(), context2);
        }
    }

    /* renamed from: a */
    public final C2866s m14395a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        if (queryLocalInterface instanceof C2866s) {
            return (C2866s) queryLocalInterface;
        }
        return new aj(iBinder);
    }

    /* renamed from: b */
    public final /* synthetic */ Object mo2481b(IBinder iBinder) {
        return m14395a(iBinder);
    }
}
