package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.RemoteInput;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ac.C0278a;
import android.support.v4.app.ac.C0279d;
import android.support.v4.app.ac.C0281g;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotificationCompatBuilder */
class ad implements ab {
    /* renamed from: a */
    private final Builder f8133a;
    /* renamed from: b */
    private final C0279d f8134b;
    /* renamed from: c */
    private RemoteViews f8135c;
    /* renamed from: d */
    private RemoteViews f8136d;
    /* renamed from: e */
    private final List<Bundle> f8137e = new ArrayList();
    /* renamed from: f */
    private final Bundle f8138f = new Bundle();
    /* renamed from: g */
    private int f8139g;
    /* renamed from: h */
    private RemoteViews f8140h;

    ad(C0279d c0279d) {
        this.f8134b = c0279d;
        if (VERSION.SDK_INT >= 26) {
            this.f8133a = new Builder(c0279d.f704a, c0279d.f697H);
        } else {
            this.f8133a = new Builder(c0279d.f704a);
        }
        Notification notification = c0279d.f702M;
        this.f8133a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, c0279d.f710g).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(c0279d.f706c).setContentText(c0279d.f707d).setContentInfo(c0279d.f712i).setContentIntent(c0279d.f708e).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(c0279d.f709f, (notification.flags & 128) != 0).setLargeIcon(c0279d.f711h).setNumber(c0279d.f713j).setProgress(c0279d.f720q, c0279d.f721r, c0279d.f722s);
        if (VERSION.SDK_INT < 21) {
            this.f8133a.setSound(notification.sound, notification.audioStreamType);
        }
        if (VERSION.SDK_INT >= 16) {
            this.f8133a.setSubText(c0279d.f718o).setUsesChronometer(c0279d.f716m).setPriority(c0279d.f714k);
            Iterator it = c0279d.f705b.iterator();
            while (it.hasNext()) {
                m9444a((C0278a) it.next());
            }
            if (c0279d.f690A != null) {
                this.f8138f.putAll(c0279d.f690A);
            }
            if (VERSION.SDK_INT < 20) {
                if (c0279d.f726w) {
                    this.f8138f.putBoolean("android.support.localOnly", true);
                }
                if (c0279d.f723t != null) {
                    this.f8138f.putString("android.support.groupKey", c0279d.f723t);
                    if (c0279d.f724u) {
                        this.f8138f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f8138f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (c0279d.f725v != null) {
                    this.f8138f.putString("android.support.sortKey", c0279d.f725v);
                }
            }
            this.f8135c = c0279d.f694E;
            this.f8136d = c0279d.f695F;
        }
        if (VERSION.SDK_INT >= 19) {
            this.f8133a.setShowWhen(c0279d.f715l);
            if (!(VERSION.SDK_INT >= 21 || c0279d.f703N == null || c0279d.f703N.isEmpty())) {
                this.f8138f.putStringArray("android.people", (String[]) c0279d.f703N.toArray(new String[c0279d.f703N.size()]));
            }
        }
        if (VERSION.SDK_INT >= 20) {
            this.f8133a.setLocalOnly(c0279d.f726w).setGroup(c0279d.f723t).setGroupSummary(c0279d.f724u).setSortKey(c0279d.f725v);
            this.f8139g = c0279d.f701L;
        }
        if (VERSION.SDK_INT >= 21) {
            this.f8133a.setCategory(c0279d.f729z).setColor(c0279d.f691B).setVisibility(c0279d.f692C).setPublicVersion(c0279d.f693D).setSound(notification.sound, notification.audioAttributes);
            Iterator it2 = c0279d.f703N.iterator();
            while (it2.hasNext()) {
                this.f8133a.addPerson((String) it2.next());
            }
            this.f8140h = c0279d.f696G;
        }
        if (VERSION.SDK_INT >= 24) {
            this.f8133a.setExtras(c0279d.f690A).setRemoteInputHistory(c0279d.f719p);
            if (c0279d.f694E != null) {
                this.f8133a.setCustomContentView(c0279d.f694E);
            }
            if (c0279d.f695F != null) {
                this.f8133a.setCustomBigContentView(c0279d.f695F);
            }
            if (c0279d.f696G != null) {
                this.f8133a.setCustomHeadsUpContentView(c0279d.f696G);
            }
        }
        if (VERSION.SDK_INT >= 26) {
            this.f8133a.setBadgeIconType(c0279d.f698I).setShortcutId(c0279d.f699J).setTimeoutAfter(c0279d.f700K).setGroupAlertBehavior(c0279d.f701L);
            if (c0279d.f728y) {
                this.f8133a.setColorized(c0279d.f727x);
            }
            if (TextUtils.isEmpty(c0279d.f697H) == null) {
                this.f8133a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
    }

    /* renamed from: a */
    public Builder mo179a() {
        return this.f8133a;
    }

    /* renamed from: b */
    public Notification m9446b() {
        C0281g c0281g = this.f8134b.f717n;
        if (c0281g != null) {
            c0281g.mo178a((ab) this);
        }
        RemoteViews b = c0281g != null ? c0281g.m806b(this) : null;
        Notification c = m9447c();
        if (b != null) {
            c.contentView = b;
        } else if (this.f8134b.f694E != null) {
            c.contentView = this.f8134b.f694E;
        }
        if (VERSION.SDK_INT >= 16 && c0281g != null) {
            b = c0281g.m807c(this);
            if (b != null) {
                c.bigContentView = b;
            }
        }
        if (VERSION.SDK_INT >= 21 && c0281g != null) {
            b = this.f8134b.f717n.m808d(this);
            if (b != null) {
                c.headsUpContentView = b;
            }
        }
        if (VERSION.SDK_INT >= 16 && c0281g != null) {
            Bundle a = ac.m809a(c);
            if (a != null) {
                c0281g.m803a(a);
            }
        }
        return c;
    }

    /* renamed from: a */
    private void m9444a(C0278a c0278a) {
        if (VERSION.SDK_INT >= 20) {
            Bundle bundle;
            Action.Builder builder = new Action.Builder(c0278a.m762a(), c0278a.m763b(), c0278a.m764c());
            if (c0278a.m767f() != null) {
                for (RemoteInput addRemoteInput : ah.m840a(c0278a.m767f())) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            if (c0278a.m765d() != null) {
                bundle = new Bundle(c0278a.m765d());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", c0278a.m766e());
            if (VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(c0278a.m766e());
            }
            builder.addExtras(bundle);
            this.f8133a.addAction(builder.build());
        } else if (VERSION.SDK_INT >= 16) {
            this.f8137e.add(ae.m810a(this.f8133a, c0278a));
        }
    }

    /* renamed from: c */
    protected Notification m9447c() {
        if (VERSION.SDK_INT >= 26) {
            return this.f8133a.build();
        }
        Notification build;
        if (VERSION.SDK_INT >= 24) {
            build = this.f8133a.build();
            if (this.f8139g != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f8139g != 2)) {
                    m9443a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f8139g == 1) {
                    m9443a(build);
                }
            }
            return build;
        } else if (VERSION.SDK_INT >= 21) {
            this.f8133a.setExtras(this.f8138f);
            build = this.f8133a.build();
            if (this.f8135c != null) {
                build.contentView = this.f8135c;
            }
            if (this.f8136d != null) {
                build.bigContentView = this.f8136d;
            }
            if (this.f8140h != null) {
                build.headsUpContentView = this.f8140h;
            }
            if (this.f8139g != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f8139g != 2)) {
                    m9443a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f8139g == 1) {
                    m9443a(build);
                }
            }
            return build;
        } else if (VERSION.SDK_INT >= 20) {
            this.f8133a.setExtras(this.f8138f);
            build = this.f8133a.build();
            if (this.f8135c != null) {
                build.contentView = this.f8135c;
            }
            if (this.f8136d != null) {
                build.bigContentView = this.f8136d;
            }
            if (this.f8139g != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f8139g != 2)) {
                    m9443a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f8139g == 1) {
                    m9443a(build);
                }
            }
            return build;
        } else if (VERSION.SDK_INT >= 19) {
            SparseArray a = ae.m813a(this.f8137e);
            if (a != null) {
                this.f8138f.putSparseParcelableArray("android.support.actionExtras", a);
            }
            this.f8133a.setExtras(this.f8138f);
            build = this.f8133a.build();
            if (this.f8135c != null) {
                build.contentView = this.f8135c;
            }
            if (this.f8136d != null) {
                build.bigContentView = this.f8136d;
            }
            return build;
        } else if (VERSION.SDK_INT < 16) {
            return this.f8133a.getNotification();
        } else {
            build = this.f8133a.build();
            Bundle a2 = ac.m809a(build);
            Bundle bundle = new Bundle(this.f8138f);
            for (String str : this.f8138f.keySet()) {
                if (a2.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a2.putAll(bundle);
            SparseArray a3 = ae.m813a(this.f8137e);
            if (a3 != null) {
                ac.m809a(build).putSparseParcelableArray("android.support.actionExtras", a3);
            }
            if (this.f8135c != null) {
                build.contentView = this.f8135c;
            }
            if (this.f8136d != null) {
                build.bigContentView = this.f8136d;
            }
            return build;
        }
    }

    /* renamed from: a */
    private void m9443a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
