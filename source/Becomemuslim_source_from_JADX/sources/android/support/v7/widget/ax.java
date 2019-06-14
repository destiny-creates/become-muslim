package android.support.v7.widget;

import android.support.v7.widget.C3319f.C0794b;
import java.util.List;

/* compiled from: OpReorderer */
class ax {
    /* renamed from: a */
    final C0770a f2051a;

    /* compiled from: OpReorderer */
    /* renamed from: android.support.v7.widget.ax$a */
    interface C0770a {
        /* renamed from: a */
        C0794b mo703a(int i, int i2, int i3, Object obj);

        /* renamed from: a */
        void mo704a(C0794b c0794b);
    }

    ax(C0770a c0770a) {
        this.f2051a = c0770a;
    }

    /* renamed from: a */
    void m2684a(List<C0794b> list) {
        while (true) {
            int b = m2682b(list);
            if (b != -1) {
                m2681a(list, b, b + 1);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m2681a(List<C0794b> list, int i, int i2) {
        C0794b c0794b = (C0794b) list.get(i);
        C0794b c0794b2 = (C0794b) list.get(i2);
        int i3 = c0794b2.f2200a;
        if (i3 != 4) {
            switch (i3) {
                case 1:
                    m2683c(list, i, c0794b, i2, c0794b2);
                    return;
                case 2:
                    m2685a(list, i, c0794b, i2, c0794b2);
                    return;
                default:
                    return;
            }
        }
        m2686b(list, i, c0794b, i2, c0794b2);
    }

    /* renamed from: a */
    void m2685a(List<C0794b> list, int i, C0794b c0794b, int i2, C0794b c0794b2) {
        Object obj;
        C0794b c0794b3;
        Object obj2 = null;
        if (c0794b.f2201b < c0794b.f2203d) {
            if (c0794b2.f2201b == c0794b.f2201b && c0794b2.f2203d == c0794b.f2203d - c0794b.f2201b) {
                obj = null;
            } else {
                obj = null;
                if (c0794b.f2203d >= c0794b2.f2201b) {
                    c0794b2.f2201b--;
                } else if (c0794b.f2203d < c0794b2.f2201b + c0794b2.f2203d) {
                    c0794b2.f2203d--;
                    c0794b.f2200a = 2;
                    c0794b.f2203d = 1;
                    if (c0794b2.f2203d == 0) {
                        list.remove(i2);
                        this.f2051a.mo704a(c0794b2);
                    }
                    return;
                }
                c0794b3 = null;
                if (c0794b.f2201b > c0794b2.f2201b) {
                    c0794b2.f2201b++;
                } else if (c0794b.f2201b < c0794b2.f2201b + c0794b2.f2203d) {
                    c0794b3 = this.f2051a.mo703a(2, c0794b.f2201b + 1, (c0794b2.f2201b + c0794b2.f2203d) - c0794b.f2201b, null);
                    c0794b2.f2203d = c0794b.f2201b - c0794b2.f2201b;
                }
                if (obj2 != null) {
                    list.set(i, c0794b2);
                    list.remove(i2);
                    this.f2051a.mo704a(c0794b);
                    return;
                }
                if (obj != null) {
                    if (c0794b3 != null) {
                        if (c0794b.f2201b > c0794b3.f2201b) {
                            c0794b.f2201b -= c0794b3.f2203d;
                        }
                        if (c0794b.f2203d > c0794b3.f2201b) {
                            c0794b.f2203d -= c0794b3.f2203d;
                        }
                    }
                    if (c0794b.f2201b > c0794b2.f2201b) {
                        c0794b.f2201b -= c0794b2.f2203d;
                    }
                    if (c0794b.f2203d > c0794b2.f2201b) {
                        c0794b.f2203d -= c0794b2.f2203d;
                    }
                } else {
                    if (c0794b3 != null) {
                        if (c0794b.f2201b >= c0794b3.f2201b) {
                            c0794b.f2201b -= c0794b3.f2203d;
                        }
                        if (c0794b.f2203d >= c0794b3.f2201b) {
                            c0794b.f2203d -= c0794b3.f2203d;
                        }
                    }
                    if (c0794b.f2201b >= c0794b2.f2201b) {
                        c0794b.f2201b -= c0794b2.f2203d;
                    }
                    if (c0794b.f2203d >= c0794b2.f2201b) {
                        c0794b.f2203d -= c0794b2.f2203d;
                    }
                }
                list.set(i, c0794b2);
                if (c0794b.f2201b != c0794b.f2203d) {
                    list.set(i2, c0794b);
                } else {
                    list.remove(i2);
                }
                if (c0794b3 != null) {
                    list.add(i, c0794b3);
                }
            }
        } else if (c0794b2.f2201b == c0794b.f2203d + 1 && c0794b2.f2203d == c0794b.f2201b - c0794b.f2203d) {
            obj = 1;
        } else {
            obj = 1;
            if (c0794b.f2203d >= c0794b2.f2201b) {
                c0794b2.f2201b--;
            } else if (c0794b.f2203d < c0794b2.f2201b + c0794b2.f2203d) {
                c0794b2.f2203d--;
                c0794b.f2200a = 2;
                c0794b.f2203d = 1;
                if (c0794b2.f2203d == 0) {
                    list.remove(i2);
                    this.f2051a.mo704a(c0794b2);
                }
                return;
            }
            c0794b3 = null;
            if (c0794b.f2201b > c0794b2.f2201b) {
                c0794b2.f2201b++;
            } else if (c0794b.f2201b < c0794b2.f2201b + c0794b2.f2203d) {
                c0794b3 = this.f2051a.mo703a(2, c0794b.f2201b + 1, (c0794b2.f2201b + c0794b2.f2203d) - c0794b.f2201b, null);
                c0794b2.f2203d = c0794b.f2201b - c0794b2.f2201b;
            }
            if (obj2 != null) {
                if (obj != null) {
                    if (c0794b3 != null) {
                        if (c0794b.f2201b >= c0794b3.f2201b) {
                            c0794b.f2201b -= c0794b3.f2203d;
                        }
                        if (c0794b.f2203d >= c0794b3.f2201b) {
                            c0794b.f2203d -= c0794b3.f2203d;
                        }
                    }
                    if (c0794b.f2201b >= c0794b2.f2201b) {
                        c0794b.f2201b -= c0794b2.f2203d;
                    }
                    if (c0794b.f2203d >= c0794b2.f2201b) {
                        c0794b.f2203d -= c0794b2.f2203d;
                    }
                } else {
                    if (c0794b3 != null) {
                        if (c0794b.f2201b > c0794b3.f2201b) {
                            c0794b.f2201b -= c0794b3.f2203d;
                        }
                        if (c0794b.f2203d > c0794b3.f2201b) {
                            c0794b.f2203d -= c0794b3.f2203d;
                        }
                    }
                    if (c0794b.f2201b > c0794b2.f2201b) {
                        c0794b.f2201b -= c0794b2.f2203d;
                    }
                    if (c0794b.f2203d > c0794b2.f2201b) {
                        c0794b.f2203d -= c0794b2.f2203d;
                    }
                }
                list.set(i, c0794b2);
                if (c0794b.f2201b != c0794b.f2203d) {
                    list.remove(i2);
                } else {
                    list.set(i2, c0794b);
                }
                if (c0794b3 != null) {
                    list.add(i, c0794b3);
                }
            }
            list.set(i, c0794b2);
            list.remove(i2);
            this.f2051a.mo704a(c0794b);
            return;
        }
        obj2 = 1;
        if (c0794b.f2203d >= c0794b2.f2201b) {
            c0794b2.f2201b--;
        } else if (c0794b.f2203d < c0794b2.f2201b + c0794b2.f2203d) {
            c0794b2.f2203d--;
            c0794b.f2200a = 2;
            c0794b.f2203d = 1;
            if (c0794b2.f2203d == 0) {
                list.remove(i2);
                this.f2051a.mo704a(c0794b2);
            }
            return;
        }
        c0794b3 = null;
        if (c0794b.f2201b > c0794b2.f2201b) {
            c0794b2.f2201b++;
        } else if (c0794b.f2201b < c0794b2.f2201b + c0794b2.f2203d) {
            c0794b3 = this.f2051a.mo703a(2, c0794b.f2201b + 1, (c0794b2.f2201b + c0794b2.f2203d) - c0794b.f2201b, null);
            c0794b2.f2203d = c0794b.f2201b - c0794b2.f2201b;
        }
        if (obj2 != null) {
            list.set(i, c0794b2);
            list.remove(i2);
            this.f2051a.mo704a(c0794b);
            return;
        }
        if (obj != null) {
            if (c0794b3 != null) {
                if (c0794b.f2201b > c0794b3.f2201b) {
                    c0794b.f2201b -= c0794b3.f2203d;
                }
                if (c0794b.f2203d > c0794b3.f2201b) {
                    c0794b.f2203d -= c0794b3.f2203d;
                }
            }
            if (c0794b.f2201b > c0794b2.f2201b) {
                c0794b.f2201b -= c0794b2.f2203d;
            }
            if (c0794b.f2203d > c0794b2.f2201b) {
                c0794b.f2203d -= c0794b2.f2203d;
            }
        } else {
            if (c0794b3 != null) {
                if (c0794b.f2201b >= c0794b3.f2201b) {
                    c0794b.f2201b -= c0794b3.f2203d;
                }
                if (c0794b.f2203d >= c0794b3.f2201b) {
                    c0794b.f2203d -= c0794b3.f2203d;
                }
            }
            if (c0794b.f2201b >= c0794b2.f2201b) {
                c0794b.f2201b -= c0794b2.f2203d;
            }
            if (c0794b.f2203d >= c0794b2.f2201b) {
                c0794b.f2203d -= c0794b2.f2203d;
            }
        }
        list.set(i, c0794b2);
        if (c0794b.f2201b != c0794b.f2203d) {
            list.set(i2, c0794b);
        } else {
            list.remove(i2);
        }
        if (c0794b3 != null) {
            list.add(i, c0794b3);
        }
    }

    /* renamed from: c */
    private void m2683c(List<C0794b> list, int i, C0794b c0794b, int i2, C0794b c0794b2) {
        int i3 = c0794b.f2203d < c0794b2.f2201b ? -1 : 0;
        if (c0794b.f2201b < c0794b2.f2201b) {
            i3++;
        }
        if (c0794b2.f2201b <= c0794b.f2201b) {
            c0794b.f2201b += c0794b2.f2203d;
        }
        if (c0794b2.f2201b <= c0794b.f2203d) {
            c0794b.f2203d += c0794b2.f2203d;
        }
        c0794b2.f2201b += i3;
        list.set(i, c0794b2);
        list.set(i2, c0794b);
    }

    /* renamed from: b */
    void m2686b(List<C0794b> list, int i, C0794b c0794b, int i2, C0794b c0794b2) {
        Object a;
        Object obj = null;
        if (c0794b.f2203d < c0794b2.f2201b) {
            c0794b2.f2201b--;
        } else if (c0794b.f2203d < c0794b2.f2201b + c0794b2.f2203d) {
            c0794b2.f2203d--;
            a = this.f2051a.mo703a(4, c0794b.f2201b, 1, c0794b2.f2202c);
            if (c0794b.f2201b <= c0794b2.f2201b) {
                c0794b2.f2201b++;
            } else if (c0794b.f2201b < c0794b2.f2201b + c0794b2.f2203d) {
                int i3 = (c0794b2.f2201b + c0794b2.f2203d) - c0794b.f2201b;
                obj = this.f2051a.mo703a(4, c0794b.f2201b + 1, i3, c0794b2.f2202c);
                c0794b2.f2203d -= i3;
            }
            list.set(i2, c0794b);
            if (c0794b2.f2203d <= null) {
                list.set(i, c0794b2);
            } else {
                list.remove(i);
                this.f2051a.mo704a(c0794b2);
            }
            if (a != null) {
                list.add(i, a);
            }
            if (obj != null) {
                list.add(i, obj);
            }
        }
        a = null;
        if (c0794b.f2201b <= c0794b2.f2201b) {
            c0794b2.f2201b++;
        } else if (c0794b.f2201b < c0794b2.f2201b + c0794b2.f2203d) {
            int i32 = (c0794b2.f2201b + c0794b2.f2203d) - c0794b.f2201b;
            obj = this.f2051a.mo703a(4, c0794b.f2201b + 1, i32, c0794b2.f2202c);
            c0794b2.f2203d -= i32;
        }
        list.set(i2, c0794b);
        if (c0794b2.f2203d <= null) {
            list.remove(i);
            this.f2051a.mo704a(c0794b2);
        } else {
            list.set(i, c0794b2);
        }
        if (a != null) {
            list.add(i, a);
        }
        if (obj != null) {
            list.add(i, obj);
        }
    }

    /* renamed from: b */
    private int m2682b(List<C0794b> list) {
        Object obj = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((C0794b) list.get(size)).f2200a != 8) {
                obj = 1;
            } else if (obj != null) {
                return size;
            }
        }
        return -1;
    }
}
