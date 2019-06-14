package com.google.android.gms.p185e;

import android.content.Context;
import com.google.android.gms.internal.p210i.dl;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.e.az */
final class az extends Thread implements ay {
    /* renamed from: d */
    private static az f11623d;
    /* renamed from: a */
    private final LinkedBlockingQueue<Runnable> f11624a = new LinkedBlockingQueue();
    /* renamed from: b */
    private volatile boolean f11625b = false;
    /* renamed from: c */
    private volatile boolean f11626c = false;
    /* renamed from: e */
    private volatile bc f11627e;
    /* renamed from: f */
    private final Context f11628f;

    /* renamed from: a */
    static az m14443a(Context context) {
        if (f11623d == null) {
            f11623d = new az(context);
        }
        return f11623d;
    }

    private az(Context context) {
        super("GAThread");
        if (context != null) {
            this.f11628f = context.getApplicationContext();
        } else {
            this.f11628f = context;
        }
        start();
    }

    /* renamed from: a */
    public final void mo2509a(String str) {
        mo2508a(new bb(this, this, System.currentTimeMillis(), str));
    }

    /* renamed from: a */
    public final void mo2508a(Runnable runnable) {
        this.f11624a.add(runnable);
    }

    public final void run() {
        while (true) {
            boolean z = this.f11626c;
            try {
                Runnable runnable = (Runnable) this.f11624a.take();
                if (!this.f11625b) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                try {
                    bs.m8586c(e.toString());
                } catch (Throwable e2) {
                    String str = "Error on Google TagManager Thread: ";
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    PrintStream printStream = new PrintStream(byteArrayOutputStream);
                    dl.a(e2, printStream);
                    printStream.flush();
                    String valueOf = String.valueOf(new String(byteArrayOutputStream.toByteArray()));
                    bs.m8582a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    bs.m8582a("Google TagManager is shutting down.");
                    this.f11625b = true;
                }
            }
        }
    }
}
