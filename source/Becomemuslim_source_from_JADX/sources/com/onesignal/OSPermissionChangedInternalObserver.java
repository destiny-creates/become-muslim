package com.onesignal;

class OSPermissionChangedInternalObserver {
    OSPermissionChangedInternalObserver() {
    }

    void changed(ah ahVar) {
        m23033a(ahVar);
        m23034b(ahVar);
    }

    /* renamed from: a */
    static void m23033a(ah ahVar) {
        if (ahVar.m23077b() == null) {
            C5504f.m23441a((int) null, am.f18401b);
        }
        as.m23312c(am.m23259w());
    }

    /* renamed from: b */
    static void m23034b(ah ahVar) {
        ai aiVar = new ai();
        aiVar.f18319b = am.f18412m;
        aiVar.f18318a = (ah) ahVar.clone();
        if (am.m23145a().m23074c(aiVar)) {
            am.f18412m = (ah) ahVar.clone();
            am.f18412m.m23078c();
        }
    }
}
