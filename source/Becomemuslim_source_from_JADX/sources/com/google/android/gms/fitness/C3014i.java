package com.google.android.gms.fitness;

import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.fitness.i */
public final class C3014i {
    /* renamed from: a */
    public static Set<Scope> m8865a(Collection<Scope> collection) {
        Set<Scope> hashSet = new HashSet(collection.size());
        for (Scope scope : collection) {
            Scope scope2 = scope.equals(new Scope("https://www.googleapis.com/auth/fitness.activity.read")) ? new Scope("https://www.googleapis.com/auth/fitness.activity.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.location.read")) ? new Scope("https://www.googleapis.com/auth/fitness.location.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.body.read")) ? new Scope("https://www.googleapis.com/auth/fitness.body.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.nutrition.read")) ? new Scope("https://www.googleapis.com/auth/fitness.nutrition.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.blood_pressure.read")) ? new Scope("https://www.googleapis.com/auth/fitness.blood_pressure.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.blood_glucose.read")) ? new Scope("https://www.googleapis.com/auth/fitness.blood_glucose.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.oxygen_saturation.read")) ? new Scope("https://www.googleapis.com/auth/fitness.oxygen_saturation.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.body_temperature.read")) ? new Scope("https://www.googleapis.com/auth/fitness.body_temperature.write") : scope.equals(new Scope("https://www.googleapis.com/auth/fitness.reproductive_health.read")) ? new Scope("https://www.googleapis.com/auth/fitness.reproductive_health.write") : scope;
            if (scope2.equals(scope) || !collection.contains(scope2)) {
                hashSet.add(scope);
            }
        }
        return hashSet;
    }
}
