package org.spongycastle.jcajce.provider.config;

import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;
import org.spongycastle.util.Strings;

public class ProviderConfigurationPermission extends BasicPermission {
    /* renamed from: a */
    private final String f22854a;
    /* renamed from: b */
    private final int f22855b;

    public ProviderConfigurationPermission(String str, String str2) {
        super(str, str2);
        this.f22854a = str2;
        this.f22855b = m28049a(str2);
    }

    /* renamed from: a */
    private int m28049a(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(Strings.m29427c(str), " ,");
        str = null;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.equals("threadlocalecimplicitlyca")) {
                str |= 1;
            } else if (nextToken.equals("ecimplicitlyca")) {
                str |= 2;
            } else if (nextToken.equals("threadlocaldhdefaultparams")) {
                str |= 4;
            } else if (nextToken.equals("dhdefaultparams")) {
                str |= 8;
            } else if (nextToken.equals("all")) {
                str |= 15;
            }
        }
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("unknown permissions passed to mask");
    }

    public String getActions() {
        return this.f22854a;
    }

    public boolean implies(Permission permission) {
        boolean z = false;
        if (!(permission instanceof ProviderConfigurationPermission) || !getName().equals(permission.getName())) {
            return false;
        }
        ProviderConfigurationPermission providerConfigurationPermission = (ProviderConfigurationPermission) permission;
        if ((this.f22855b & providerConfigurationPermission.f22855b) == providerConfigurationPermission.f22855b) {
            z = true;
        }
        return z;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProviderConfigurationPermission)) {
            return false;
        }
        ProviderConfigurationPermission providerConfigurationPermission = (ProviderConfigurationPermission) obj;
        if (this.f22855b != providerConfigurationPermission.f22855b || getName().equals(providerConfigurationPermission.getName()) == null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return getName().hashCode() + this.f22855b;
    }
}
