package com.bugsnag.android;

import com.bugsnag.android.NativeInterface.C1068a;
import com.bugsnag.android.NativeInterface.C1069b;
import com.bugsnag.android.ab.C1071a;
import java.util.Observable;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

class Breadcrumbs extends Observable implements C1071a {
    private static final int MAX_PAYLOAD_SIZE = 4096;
    private final C1091l configuration;
    final Queue<Breadcrumb> store = new ConcurrentLinkedQueue();

    Breadcrumbs(C1091l c1091l) {
        this.configuration = c1091l;
    }

    public void toStream(ab abVar) {
        pruneBreadcrumbs();
        abVar.mo776e();
        for (Breadcrumb toStream : this.store) {
            toStream.toStream(abVar);
        }
        abVar.mo775d();
    }

    void add(Breadcrumb breadcrumb) {
        addToStore(breadcrumb);
    }

    void clear() {
        this.store.clear();
        setChanged();
        notifyObservers(new C1068a(C1069b.CLEAR_BREADCRUMBS, null));
    }

    private void addToStore(Breadcrumb breadcrumb) {
        try {
            if (breadcrumb.payloadSize() > MAX_PAYLOAD_SIZE) {
                ad.m3736b("Dropping breadcrumb because payload exceeds 4KB limit");
                return;
            }
            this.store.add(breadcrumb);
            pruneBreadcrumbs();
            setChanged();
            notifyObservers(new C1068a(C1069b.ADD_BREADCRUMB, breadcrumb));
        } catch (Breadcrumb breadcrumb2) {
            ad.m3733a("Dropping breadcrumb because it could not be serialized", breadcrumb2);
        }
    }

    private void pruneBreadcrumbs() {
        int u = this.configuration.m3868u();
        while (this.store.size() > u) {
            this.store.poll();
        }
    }
}
