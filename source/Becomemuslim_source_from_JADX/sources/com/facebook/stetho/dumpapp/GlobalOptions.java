package com.facebook.stetho.dumpapp;

import host.exp.exponent.p339f.C6352l;
import org.apache.p371a.p372a.C6631h;
import org.apache.p371a.p372a.C6634k;

public class GlobalOptions {
    public final C6631h optionHelp = new C6631h("h", "help", false, "Print this help");
    public final C6631h optionListPlugins = new C6631h(C6352l.f20613a, "list", false, "List available plugins");
    public final C6631h optionProcess = new C6631h("p", "process", true, "Specify target process");
    public final C6634k options = new C6634k();

    public GlobalOptions() {
        this.options.a(this.optionHelp);
        this.options.a(this.optionListPlugins);
        this.options.a(this.optionProcess);
    }
}
