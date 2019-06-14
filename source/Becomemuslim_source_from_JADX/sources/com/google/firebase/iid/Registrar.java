package com.google.firebase.iid;

import android.support.annotation.Keep;
import com.google.firebase.C5335b;
import com.google.firebase.components.C5340a;
import com.google.firebase.components.C5343d;
import com.google.firebase.components.C5344e;
import com.google.firebase.iid.p246a.C5350a;
import com.google.firebase.p244a.C5323d;
import java.util.Arrays;
import java.util.List;

@Keep
public final class Registrar implements C5343d {

    /* renamed from: com.google.firebase.iid.Registrar$a */
    private static class C6910a implements C5350a {
        /* renamed from: a */
        private final FirebaseInstanceId f24734a;

        public C6910a(FirebaseInstanceId firebaseInstanceId) {
            this.f24734a = firebaseInstanceId;
        }
    }

    @Keep
    public final List<C5340a<?>> getComponents() {
        C5340a c = C5340a.m22635a(FirebaseInstanceId.class).m22632a(C5344e.m22648a(C5335b.class)).m22632a(C5344e.m22648a(C5323d.class)).m22631a(C6913r.f24754a).m22630a().m22634c();
        C5340a c2 = C5340a.m22635a(C5350a.class).m22632a(C5344e.m22648a(FirebaseInstanceId.class)).m22631a(C6914s.f24755a).m22634c();
        return Arrays.asList(new C5340a[]{c, c2});
    }
}
