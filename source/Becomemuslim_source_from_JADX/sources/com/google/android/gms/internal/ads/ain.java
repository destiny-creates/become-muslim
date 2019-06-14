package com.google.android.gms.internal.ads;

import android.provider.Settings.SettingNotFoundException;
import java.lang.reflect.InvocationTargetException;

public final class ain extends ajk {
    public ain(ahz ahz, String str, String str2, aaa aaa, int i, int i2) {
        super(ahz, str, str2, aaa, i, 49);
    }

    /* renamed from: a */
    protected final void mo3820a() {
        this.b.f27933F = Integer.valueOf(2);
        try {
            boolean booleanValue = ((Boolean) this.c.invoke(null, new Object[]{this.a.m18454a()})).booleanValue();
            this.b.f27933F = Integer.valueOf(booleanValue);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
