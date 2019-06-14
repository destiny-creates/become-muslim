package com.onesignal;

class OSSubscriptionChangedInternalObserver {
    OSSubscriptionChangedInternalObserver() {
    }

    public void changed(OSSubscriptionState oSSubscriptionState) {
        m23035a(oSSubscriptionState);
    }

    /* renamed from: a */
    static void m23035a(OSSubscriptionState oSSubscriptionState) {
        ak akVar = new ak();
        akVar.f18324b = am.f18413n;
        akVar.f18323a = (OSSubscriptionState) oSSubscriptionState.clone();
        if (am.m23181b().m23074c(akVar)) {
            am.f18413n = (OSSubscriptionState) oSSubscriptionState.clone();
            am.f18413n.m23044e();
        }
    }
}
