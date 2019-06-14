package com.google.android.gms.location;

import java.util.Comparator;

final class ah implements Comparator<C7834c> {
    ah() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        C7834c c7834c = (C7834c) obj;
        C7834c c7834c2 = (C7834c) obj2;
        int compareTo = Integer.valueOf(c7834c2.m38222b()).compareTo(Integer.valueOf(c7834c.m38222b()));
        return compareTo == 0 ? Integer.valueOf(c7834c.m38221a()).compareTo(Integer.valueOf(c7834c2.m38221a())) : compareTo;
    }
}
