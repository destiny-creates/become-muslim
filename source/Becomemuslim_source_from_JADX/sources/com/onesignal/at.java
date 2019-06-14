package com.onesignal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.onesignal.C5503e.C5501c;
import com.onesignal.C5526p.C5521a;
import com.onesignal.C5526p.C5523d;
import com.onesignal.C5526p.C5525f;
import com.onesignal.am.C5464i;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: OneSignalSyncServiceUtils */
class at {
    /* renamed from: a */
    private static Long f18460a = Long.valueOf(0);
    /* renamed from: b */
    private static AtomicBoolean f18461b = new AtomicBoolean();
    /* renamed from: c */
    private static Thread f18462c;

    /* compiled from: OneSignalSyncServiceUtils */
    /* renamed from: com.onesignal.at$c */
    static abstract class C5481c implements Runnable {

        /* compiled from: OneSignalSyncServiceUtils */
        /* renamed from: com.onesignal.at$c$1 */
        class C69541 implements C5523d {
            /* renamed from: a */
            final /* synthetic */ C5481c f24815a;

            C69541(C5481c c5481c) {
                this.f24815a = c5481c;
            }

            /* renamed from: a */
            public C5521a mo4937a() {
                return C5521a.SYNC_SERVICE;
            }

            /* renamed from: a */
            public void mo4938a(C5525f c5525f) {
                if (c5525f != null) {
                    as.m23302a(c5525f);
                }
                as.m23307a(true);
                at.m23327a();
                this.f24815a.mo4941a();
            }
        }

        /* renamed from: a */
        protected abstract void mo4941a();

        C5481c() {
        }

        public final void run() {
            synchronized (at.f18460a) {
                at.f18460a = Long.valueOf(0);
            }
            if (am.m23244m() == null) {
                mo4941a();
                return;
            }
            am.f18400a = am.m23237k();
            as.m23316e();
            C5526p.m23513a(am.f18401b, false, new C69541(this));
        }
    }

    /* compiled from: OneSignalSyncServiceUtils */
    /* renamed from: com.onesignal.at$a */
    static class C6952a extends C5481c {
        /* renamed from: a */
        Service f24812a;

        C6952a(Service service) {
            this.f24812a = service;
        }

        /* renamed from: a */
        protected void mo4941a() {
            am.m23187b(C5464i.DEBUG, "LegacySyncRunnable:Stopped");
            this.f24812a.stopSelf();
        }
    }

    /* compiled from: OneSignalSyncServiceUtils */
    /* renamed from: com.onesignal.at$b */
    static class C6953b extends C5481c {
        /* renamed from: a */
        private JobService f24813a;
        /* renamed from: b */
        private JobParameters f24814b;

        C6953b(JobService jobService, JobParameters jobParameters) {
            this.f24813a = jobService;
            this.f24814b = jobParameters;
        }

        /* renamed from: a */
        protected void mo4941a() {
            am.m23187b(C5464i.DEBUG, "LollipopSyncRunnable:JobFinished");
            this.f24813a.jobFinished(this.f24814b, false);
        }
    }

    /* renamed from: a */
    static void m23329a(Context context, long j) {
        C5464i c5464i = C5464i.VERBOSE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("scheduleLocationUpdateTask:delayMs: ");
        stringBuilder.append(j);
        am.m23187b(c5464i, stringBuilder.toString());
        m23332b(context, j);
    }

    /* renamed from: a */
    static void m23328a(Context context) {
        am.m23187b(C5464i.VERBOSE, "scheduleSyncTask:SYNC_AFTER_BG_DELAY_MS: 120000");
        m23332b(context, 120000);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    static void m23331b(android.content.Context r3) {
        /*
        r0 = f18460a;
        monitor-enter(r0);
        r1 = 0;
        r1 = java.lang.Long.valueOf(r1);	 Catch:{ all -> 0x0039 }
        f18460a = r1;	 Catch:{ all -> 0x0039 }
        r1 = com.onesignal.C5526p.m23515a(r3);	 Catch:{ all -> 0x0039 }
        if (r1 == 0) goto L_0x0013;
    L_0x0011:
        monitor-exit(r0);	 Catch:{ all -> 0x0039 }
        return;
    L_0x0013:
        r1 = m23338d();	 Catch:{ all -> 0x0039 }
        if (r1 == 0) goto L_0x0028;
    L_0x0019:
        r1 = "jobscheduler";
        r3 = r3.getSystemService(r1);	 Catch:{ all -> 0x0039 }
        r3 = (android.app.job.JobScheduler) r3;	 Catch:{ all -> 0x0039 }
        r1 = 2071862118; // 0x7b7e1b66 float:1.3193991E36 double:1.0236358954E-314;
        r3.cancel(r1);	 Catch:{ all -> 0x0039 }
        goto L_0x0037;
    L_0x0028:
        r1 = "alarm";
        r1 = r3.getSystemService(r1);	 Catch:{ all -> 0x0039 }
        r1 = (android.app.AlarmManager) r1;	 Catch:{ all -> 0x0039 }
        r3 = m23334c(r3);	 Catch:{ all -> 0x0039 }
        r1.cancel(r3);	 Catch:{ all -> 0x0039 }
    L_0x0037:
        monitor-exit(r0);	 Catch:{ all -> 0x0039 }
        return;
    L_0x0039:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0039 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.at.b(android.content.Context):void");
    }

    /* renamed from: c */
    private static PendingIntent m23334c(Context context) {
        return PendingIntent.getService(context, 2071862118, new Intent(context, SyncService.class), 134217728);
    }

    /* renamed from: d */
    private static boolean m23338d() {
        return VERSION.SDK_INT >= 21;
    }

    /* renamed from: b */
    private static void m23332b(Context context, long j) {
        synchronized (f18460a) {
            if (f18460a.longValue() == 0 || System.currentTimeMillis() + j <= f18460a.longValue()) {
                if (j < 5000) {
                    j = 5000;
                }
                if (m23338d()) {
                    m23336c(context, j);
                } else {
                    m23337d(context, j);
                }
                f18460a = Long.valueOf(System.currentTimeMillis() + j);
                return;
            }
        }
    }

    /* renamed from: d */
    private static boolean m23339d(Context context) {
        return C5501c.m23439a(context, "android.permission.RECEIVE_BOOT_COMPLETED") == null ? true : null;
    }

    /* renamed from: c */
    private static void m23336c(Context context, long j) {
        C5464i c5464i = C5464i.VERBOSE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("scheduleSyncServiceAsJob:atTime: ");
        stringBuilder.append(j);
        am.m23187b(c5464i, stringBuilder.toString());
        Builder builder = new Builder(2071862118, new ComponentName(context, SyncJobService.class));
        builder.setMinimumLatency(j).setRequiredNetworkType(1);
        if (m23339d(context) != null) {
            builder.setPersisted(true);
        }
        try {
            context = ((JobScheduler) context.getSystemService("jobscheduler")).schedule(builder.build());
            C5464i c5464i2 = C5464i.INFO;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("scheduleSyncServiceAsJob:result: ");
            stringBuilder2.append(context);
            am.m23187b(c5464i2, stringBuilder2.toString());
        } catch (Throwable e) {
            am.m23161a(C5464i.ERROR, "scheduleSyncServiceAsJob called JobScheduler.jobScheduler which triggered an internal null Android error. Skipping job.", e);
        }
    }

    /* renamed from: d */
    private static void m23337d(Context context, long j) {
        C5464i c5464i = C5464i.VERBOSE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("scheduleServiceSyncTask:atTime: ");
        stringBuilder.append(j);
        am.m23187b(c5464i, stringBuilder.toString());
        ((AlarmManager) context.getSystemService("alarm")).set(0, (System.currentTimeMillis() + j) + j, m23334c(context));
    }

    /* renamed from: a */
    static void m23327a() {
        if (!f18461b.get()) {
            synchronized (f18461b) {
                f18461b.set(true);
                m23340e();
                f18461b.set(false);
            }
        }
    }

    /* renamed from: e */
    private static void m23340e() {
        long t = am.m23256t();
        if (t >= 60) {
            am.m23151a(t, true);
        }
    }

    /* renamed from: a */
    static void m23330a(Context context, C5481c c5481c) {
        am.m23152a(context);
        f18462c = new Thread(c5481c, "OS_SYNCSRV_BG_SYNC");
        f18462c.start();
    }

    /* renamed from: b */
    static boolean m23333b() {
        if (f18462c == null || !f18462c.isAlive()) {
            return false;
        }
        f18462c.interrupt();
        return true;
    }
}
