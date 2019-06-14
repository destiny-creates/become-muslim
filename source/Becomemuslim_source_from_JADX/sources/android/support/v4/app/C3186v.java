package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.Transition.TransitionListener;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FragmentTransitionCompat21 */
/* renamed from: android.support.v4.app.v */
class C3186v extends C0340w {
    C3186v() {
    }

    /* renamed from: a */
    public boolean mo111a(Object obj) {
        return obj instanceof Transition;
    }

    /* renamed from: b */
    public Object mo112b(Object obj) {
        return obj != null ? ((Transition) obj).clone() : null;
    }

    /* renamed from: c */
    public Object mo117c(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    /* renamed from: a */
    public void mo107a(Object obj, View view, ArrayList<View> arrayList) {
        obj = (TransitionSet) obj;
        List targets = obj.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C0340w.m1000a(targets, (View) arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        mo109a(obj, (ArrayList) arrayList);
    }

    /* renamed from: a */
    public void mo106a(Object obj, View view) {
        if (view != null) {
            Transition transition = (Transition) obj;
            final Rect rect = new Rect();
            m1005a(view, rect);
            transition.setEpicenterCallback(new EpicenterCallback(this) {
                /* renamed from: b */
                final /* synthetic */ C3186v f903b;

                public Rect onGetEpicenter(Transition transition) {
                    return rect;
                }
            });
        }
    }

    /* renamed from: a */
    public void mo109a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i = 0;
            int transitionCount;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                transitionCount = transitionSet.getTransitionCount();
                while (i < transitionCount) {
                    mo109a(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
                    i++;
                }
            } else if (!C3186v.m9627a(transition) && C0340w.m1001a(transition.getTargets())) {
                transitionCount = arrayList.size();
                while (i < transitionCount) {
                    transition.addTarget((View) arrayList.get(i));
                    i++;
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m9627a(Transition transition) {
        if (C0340w.m1001a(transition.getTargetIds()) && C0340w.m1001a(transition.getTargetNames())) {
            if (C0340w.m1001a((List) transition.getTargetTypes()) != null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    public Object mo103a(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    /* renamed from: b */
    public void mo115b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new TransitionListener(this) {
            /* renamed from: c */
            final /* synthetic */ C3186v f906c;

            public void onTransitionCancel(Transition transition) {
            }

            public void onTransitionPause(Transition transition) {
            }

            public void onTransitionResume(Transition transition) {
            }

            public void onTransitionStart(Transition transition) {
            }

            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                view.setVisibility(8);
                transition = arrayList.size();
                for (int i = 0; i < transition; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }
        });
    }

    /* renamed from: b */
    public Object mo113b(Object obj, Object obj2, Object obj3) {
        obj = (Transition) obj;
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        if (obj != null && transition != null) {
            obj = new TransitionSet().addTransition(obj).addTransition(transition).setOrdering(1);
        } else if (obj == null) {
            obj = transition != null ? transition : null;
        }
        if (transition2 == null) {
            return obj;
        }
        obj2 = new TransitionSet();
        if (obj != null) {
            obj2.addTransition(obj);
        }
        obj2.addTransition(transition2);
        return obj2;
    }

    /* renamed from: a */
    public void mo104a(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    /* renamed from: a */
    public void mo108a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((Transition) obj).addListener(new TransitionListener(this) {
            /* renamed from: g */
            final /* synthetic */ C3186v f913g;

            public void onTransitionCancel(Transition transition) {
            }

            public void onTransitionEnd(Transition transition) {
            }

            public void onTransitionPause(Transition transition) {
            }

            public void onTransitionResume(Transition transition) {
            }

            public void onTransitionStart(Transition transition) {
                if (obj5 != null) {
                    this.f913g.mo116b(obj5, arrayList4, null);
                }
                if (obj6 != null) {
                    this.f913g.mo116b(obj6, arrayList5, null);
                }
                if (obj7 != null) {
                    this.f913g.mo116b(obj7, arrayList6, null);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo110a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        obj = (TransitionSet) obj;
        if (obj != null) {
            obj.getTargets().clear();
            obj.getTargets().addAll(arrayList2);
            mo116b(obj, (ArrayList) arrayList, (ArrayList) arrayList2);
        }
    }

    /* renamed from: b */
    public void mo116b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Transition transition = (Transition) obj;
        int i = 0;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                mo116b(transitionSet.getTransitionAt(i), (ArrayList) arrayList, (ArrayList) arrayList2);
                i++;
            }
        } else if (!C3186v.m9627a(transition)) {
            List targets = transition.getTargets();
            if (targets != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    transitionCount = 0;
                } else {
                    transitionCount = arrayList2.size();
                }
                while (i < transitionCount) {
                    transition.addTarget((View) arrayList2.get(i));
                    i++;
                }
                for (arrayList2 = arrayList.size() - 1; arrayList2 >= null; arrayList2--) {
                    transition.removeTarget((View) arrayList.get(arrayList2));
                }
            }
        }
    }

    /* renamed from: b */
    public void mo114b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    /* renamed from: c */
    public void mo118c(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    /* renamed from: a */
    public void mo105a(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new EpicenterCallback(this) {
                /* renamed from: b */
                final /* synthetic */ C3186v f915b;

                public Rect onGetEpicenter(Transition transition) {
                    if (rect != null) {
                        if (rect.isEmpty() == null) {
                            return rect;
                        }
                    }
                    return null;
                }
            });
        }
    }
}
