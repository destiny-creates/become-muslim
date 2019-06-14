package net.openid.appauth;

import android.util.Base64;
import java.util.Collections;
import java.util.Map;
import net.openid.appauth.p370c.C6579b;

/* compiled from: ClientSecretBasic */
/* renamed from: net.openid.appauth.k */
public class C7641k implements C6599j {
    /* renamed from: a */
    private String f26413a;

    /* renamed from: b */
    public final Map<String, String> mo5514b(String str) {
        return null;
    }

    public C7641k(String str) {
        this.f26413a = (String) C6605p.m26933a((Object) str, (Object) "mClientSecret cannot be null");
    }

    /* renamed from: a */
    public final Map<String, String> mo5513a(String str) {
        str = C6579b.m26815b(str);
        String b = C6579b.m26815b(this.f26413a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(":");
        stringBuilder.append(b);
        str = Base64.encodeToString(stringBuilder.toString().getBytes(), 2);
        stringBuilder = new StringBuilder();
        stringBuilder.append("Basic ");
        stringBuilder.append(str);
        return Collections.singletonMap("Authorization", stringBuilder.toString());
    }
}
