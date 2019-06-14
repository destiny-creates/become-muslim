package org.spongycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SkeinParameterSpec implements AlgorithmParameterSpec {
    /* renamed from: a */
    private Map f22909a;

    public static class Builder {
        /* renamed from: a */
        private Map f22908a = new HashMap();
    }

    public SkeinParameterSpec() {
        this(new HashMap());
    }

    private SkeinParameterSpec(Map map) {
        this.f22909a = Collections.unmodifiableMap(map);
    }

    /* renamed from: a */
    public Map m28111a() {
        return this.f22909a;
    }
}
