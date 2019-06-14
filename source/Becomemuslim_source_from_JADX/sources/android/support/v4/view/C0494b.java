package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.p033a.C0483b;
import android.support.v4.view.p033a.C0485c;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* compiled from: AccessibilityDelegateCompat */
/* renamed from: android.support.v4.view.b */
public class C0494b {
    private static final AccessibilityDelegate DEFAULT_DELEGATE = new AccessibilityDelegate();
    private static final C0490b IMPL;
    final AccessibilityDelegate mBridge = IMPL.mo314a(this);

    /* compiled from: AccessibilityDelegateCompat */
    /* renamed from: android.support.v4.view.b$b */
    static class C0490b {
        /* renamed from: a */
        public C0485c mo313a(AccessibilityDelegate accessibilityDelegate, View view) {
            return null;
        }

        /* renamed from: a */
        public boolean mo315a(AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return false;
        }

        C0490b() {
        }

        /* renamed from: a */
        public AccessibilityDelegate mo314a(final C0494b c0494b) {
            return new AccessibilityDelegate(this) {
                /* renamed from: b */
                final /* synthetic */ C0490b f1262b;

                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return c0494b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    c0494b.onInitializeAccessibilityEvent(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    c0494b.onInitializeAccessibilityNodeInfo(view, C0483b.m1499a(accessibilityNodeInfo));
                }

                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    c0494b.onPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return c0494b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                public void sendAccessibilityEvent(View view, int i) {
                    c0494b.sendAccessibilityEvent(view, i);
                }

                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    c0494b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
                }
            };
        }
    }

    /* compiled from: AccessibilityDelegateCompat */
    /* renamed from: android.support.v4.view.b$a */
    static class C3218a extends C0490b {
        C3218a() {
        }

        /* renamed from: a */
        public AccessibilityDelegate mo314a(final C0494b c0494b) {
            return new AccessibilityDelegate(this) {
                /* renamed from: b */
                final /* synthetic */ C3218a f1260b;

                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return c0494b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    c0494b.onInitializeAccessibilityEvent(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    c0494b.onInitializeAccessibilityNodeInfo(view, C0483b.m1499a(accessibilityNodeInfo));
                }

                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    c0494b.onPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return c0494b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                public void sendAccessibilityEvent(View view, int i) {
                    c0494b.sendAccessibilityEvent(view, i);
                }

                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    c0494b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
                }

                public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                    view = c0494b.getAccessibilityNodeProvider(view);
                    return view != null ? (AccessibilityNodeProvider) view.m1552a() : null;
                }

                public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    return c0494b.performAccessibilityAction(view, i, bundle);
                }
            };
        }

        /* renamed from: a */
        public C0485c mo313a(AccessibilityDelegate accessibilityDelegate, View view) {
            accessibilityDelegate = accessibilityDelegate.getAccessibilityNodeProvider(view);
            return accessibilityDelegate != null ? new C0485c(accessibilityDelegate) : null;
        }

        /* renamed from: a */
        public boolean mo315a(AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i, bundle);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            IMPL = new C3218a();
        } else {
            IMPL = new C0490b();
        }
    }

    AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void sendAccessibilityEvent(View view, int i) {
        DEFAULT_DELEGATE.sendAccessibilityEvent(view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        DEFAULT_DELEGATE.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return DEFAULT_DELEGATE.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        DEFAULT_DELEGATE.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        DEFAULT_DELEGATE.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, C0483b c0483b) {
        DEFAULT_DELEGATE.onInitializeAccessibilityNodeInfo(view, c0483b.m1501a());
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return DEFAULT_DELEGATE.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public C0485c getAccessibilityNodeProvider(View view) {
        return IMPL.mo313a(DEFAULT_DELEGATE, view);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return IMPL.mo315a(DEFAULT_DELEGATE, view, i, bundle);
    }
}
