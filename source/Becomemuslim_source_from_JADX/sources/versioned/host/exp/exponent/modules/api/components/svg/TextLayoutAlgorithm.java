package versioned.host.exp.exponent.modules.api.components.svg;

import android.view.View;
import java.util.ArrayList;

class TextLayoutAlgorithm {

    /* renamed from: versioned.host.exp.exponent.modules.api.components.svg.TextLayoutAlgorithm$1CharacterPositioningResolver */
    class AnonymousClass1CharacterPositioningResolver {
        private int global = 0;
        private boolean horizontal = true;
        private boolean in_text_path = false;
        private String[] resolve_dx;
        private String[] resolve_dy;
        private String[] resolve_x;
        private String[] resolve_y;
        private CharacterInformation[] result;

        AnonymousClass1CharacterPositioningResolver(CharacterInformation[] characterInformationArr, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
            this.result = characterInformationArr;
            this.resolve_x = strArr;
            this.resolve_y = strArr2;
            this.resolve_dx = strArr3;
            this.resolve_dy = strArr4;
        }

        private void resolveCharacterPositioning(TextView textView) {
            int i;
            int max;
            if (textView.getClass() != TextView.class) {
                if (textView.getClass() != TSpanView.class) {
                    if (textView.getClass() == TextPathView.class) {
                        this.result[this.global].anchoredChunk = true;
                        this.in_text_path = true;
                        for (i = 0; i < textView.getChildCount(); i++) {
                            resolveCharacterPositioning((TextView) textView.getChildAt(i));
                        }
                        if ((textView instanceof TextPathView) != null) {
                            this.in_text_path = false;
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            i = this.global;
            String[] strArr = new String[0];
            String[] strArr2 = new String[0];
            String[] strArr3 = new String[0];
            String[] strArr4 = new String[0];
            double[] dArr = new double[0];
            if (!this.in_text_path) {
                max = Math.max(strArr.length, strArr2.length);
            } else if (this.horizontal) {
                max = strArr.length;
            } else {
                max = strArr2.length;
            }
            textView = ((TSpanView) textView).mContent;
            if (textView == null) {
                textView = null;
            } else {
                textView = textView.length();
            }
            int i2 = 0;
            for (int i3 = 0; i3 < textView; i3++) {
                int i4 = i + i3;
                if (this.result[i4].addressable) {
                    this.result[i4].anchoredChunk = i2 < max;
                    if (i2 < strArr.length) {
                        this.resolve_x[i4] = strArr[i2];
                    }
                    if (this.in_text_path && !this.horizontal) {
                        this.resolve_x[i] = "";
                    }
                    if (i2 < strArr2.length) {
                        this.resolve_y[i4] = strArr2[i2];
                    }
                    if (this.in_text_path && this.horizontal) {
                        this.resolve_y[i] = "";
                    }
                    if (i2 < strArr3.length) {
                        this.resolve_dx[i4] = strArr3[i2];
                    }
                    if (i2 < strArr4.length) {
                        this.resolve_dy[i4] = strArr4[i2];
                    }
                    if (i2 < dArr.length) {
                        this.result[i4].rotate = dArr[i2];
                    } else if (dArr.length != 0) {
                        this.result[i4].rotate = this.result[i4 - 1].rotate;
                    }
                }
                i2++;
            }
        }
    }

    class CharacterInformation {
        boolean addressable = true;
        double advance;
        boolean anchoredChunk = false;
        char character;
        TextView element;
        boolean firstCharacterInResolvedDescendant = false;
        boolean hidden = false;
        int index;
        boolean middle = false;
        boolean resolved = false;
        double rotate = 0.0d;
        boolean rotateSpecified = false;
        /* renamed from: x */
        double f23511x = 0.0d;
        boolean xSpecified = false;
        /* renamed from: y */
        double f23512y = 0.0d;
        boolean ySpecified = false;

        CharacterInformation(int i, char c) {
            this.index = i;
            this.character = c;
        }
    }

    class LayoutInput {
        boolean horizontal;
        TextView text;

        LayoutInput() {
        }
    }

    TextLayoutAlgorithm() {
    }

    private void getSubTreeTypographicCharacterPositions(ArrayList<TextPathView> arrayList, ArrayList<TextView> arrayList2, StringBuilder stringBuilder, View view, TextPathView textPathView) {
        int i = 0;
        if (view instanceof TSpanView) {
            TSpanView tSpanView = (TSpanView) view;
            String str = tSpanView.mContent;
            if (str == null) {
                while (i < tSpanView.getChildCount()) {
                    getSubTreeTypographicCharacterPositions(arrayList, arrayList2, stringBuilder, tSpanView.getChildAt(i), textPathView);
                    i++;
                }
                return;
            }
            while (i < str.length()) {
                arrayList2.add(tSpanView);
                arrayList.add(textPathView);
                i++;
            }
            stringBuilder.append(str);
            return;
        }
        if (view instanceof TextPathView) {
            textPathView = (TextPathView) view;
        }
        while (i < textPathView.getChildCount()) {
            getSubTreeTypographicCharacterPositions(arrayList, arrayList2, stringBuilder, textPathView.getChildAt(i), textPathView);
            i++;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    versioned.host.exp.exponent.modules.api.components.svg.TextLayoutAlgorithm.CharacterInformation[] layoutText(versioned.host.exp.exponent.modules.api.components.svg.TextLayoutAlgorithm.LayoutInput r32) {
        /*
        r31 = this;
        r7 = r31;
        r0 = r32;
        r8 = r0.text;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r2 = new java.util.ArrayList;
        r2.<init>();
        r9 = new java.util.ArrayList;
        r9.<init>();
        r5 = 0;
        r0 = r31;
        r1 = r9;
        r3 = r6;
        r4 = r8;
        r0.getSubTreeTypographicCharacterPositions(r1, r2, r3, r4, r5);
        r0 = r6.toString();
        r0 = r0.toCharArray();
        r10 = r0.length;
        r11 = new versioned.host.exp.exponent.modules.api.components.svg.TextLayoutAlgorithm.CharacterInformation[r10];
        r12 = 0;
        r1 = 0;
    L_0x002b:
        if (r1 >= r10) goto L_0x0039;
    L_0x002d:
        r2 = new versioned.host.exp.exponent.modules.api.components.svg.TextLayoutAlgorithm$CharacterInformation;
        r3 = r0[r1];
        r2.<init>(r1, r3);
        r11[r1] = r2;
        r1 = r1 + 1;
        goto L_0x002b;
    L_0x0039:
        if (r10 != 0) goto L_0x003c;
    L_0x003b:
        return r11;
    L_0x003c:
        r13 = new android.graphics.PointF[r10];
        r0 = 0;
    L_0x003f:
        r14 = 0;
        if (r0 >= r10) goto L_0x004c;
    L_0x0042:
        r1 = new android.graphics.PointF;
        r1.<init>(r14, r14);
        r13[r0] = r1;
        r0 = r0 + 1;
        goto L_0x003f;
    L_0x004c:
        r0 = 0;
    L_0x004d:
        r15 = 1;
        if (r0 >= r10) goto L_0x0080;
    L_0x0050:
        r1 = r11[r0];
        r1.addressable = r15;
        r1 = r11[r0];
        r1.middle = r12;
        r1 = r11[r0];
        if (r0 != 0) goto L_0x005d;
    L_0x005c:
        goto L_0x005e;
    L_0x005d:
        r15 = 0;
    L_0x005e:
        r1.anchoredChunk = r15;
        r1 = r11[r0];
        r1 = r1.addressable;
        if (r1 == 0) goto L_0x0072;
    L_0x0066:
        r1 = r11[r0];
        r1 = r1.middle;
        if (r1 != 0) goto L_0x0072;
    L_0x006c:
        r1 = r13[r0];
        r1.set(r14, r14);
        goto L_0x007d;
    L_0x0072:
        if (r0 <= 0) goto L_0x007d;
    L_0x0074:
        r1 = r13[r0];
        r2 = r0 + -1;
        r2 = r13[r2];
        r1.set(r2);
    L_0x007d:
        r0 = r0 + 1;
        goto L_0x004d;
    L_0x0080:
        r6 = new java.lang.String[r10];
        r5 = new java.lang.String[r10];
        r4 = new java.lang.String[r10];
        r3 = new java.lang.String[r10];
        r0 = new versioned.host.exp.exponent.modules.api.components.svg.TextLayoutAlgorithm$1CharacterPositioningResolver;
        r1 = r31;
        r2 = r11;
        r16 = r3;
        r3 = r6;
        r17 = r4;
        r4 = r5;
        r18 = r5;
        r5 = r17;
        r17 = r6;
        r6 = r16;
        r0.<init>(r2, r3, r4, r5, r6);
        r0 = new android.graphics.PointF;
        r0.<init>(r14, r14);
        r1 = 0;
    L_0x00a4:
        if (r1 >= r10) goto L_0x00f3;
    L_0x00a6:
        r2 = r17[r1];
        r3 = "";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00b4;
    L_0x00b0:
        r2 = "0";
        r17[r1] = r2;
    L_0x00b4:
        r2 = r18[r1];
        r3 = "";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00c2;
    L_0x00be:
        r2 = "0";
        r18[r1] = r2;
    L_0x00c2:
        r2 = r0.x;
        r3 = r17[r1];
        r3 = java.lang.Float.parseFloat(r3);
        r2 = r2 + r3;
        r0.x = r2;
        r2 = r0.y;
        r3 = r18[r1];
        r3 = java.lang.Float.parseFloat(r3);
        r2 = r2 + r3;
        r0.y = r2;
        r2 = r11[r1];
        r3 = r13[r1];
        r3 = r3.x;
        r4 = r0.x;
        r3 = r3 + r4;
        r3 = (double) r3;
        r2.f23511x = r3;
        r2 = r11[r1];
        r3 = r13[r1];
        r3 = r3.y;
        r4 = r0.y;
        r3 = r3 + r4;
        r3 = (double) r3;
        r2.f23512y = r3;
        r1 = r1 + 1;
        goto L_0x00a4;
    L_0x00f3:
        r1 = new versioned.host.exp.exponent.modules.api.components.svg.TextLayoutAlgorithm$1TextLengthResolver;
        r1.<init>(r11);
        r1.resolveTextLength(r8);
        r0.set(r14, r14);
        r1 = 1;
    L_0x00ff:
        if (r1 >= r10) goto L_0x0152;
    L_0x0101:
        r2 = r17[r1];
        if (r2 == 0) goto L_0x0113;
    L_0x0105:
        r2 = r17[r1];
        r2 = java.lang.Double.parseDouble(r2);
        r4 = r11[r1];
        r4 = r4.f23511x;
        r2 = r2 - r4;
        r2 = (float) r2;
        r0.x = r2;
    L_0x0113:
        r2 = r18[r1];
        if (r2 == 0) goto L_0x0125;
    L_0x0117:
        r2 = r18[r1];
        r2 = java.lang.Double.parseDouble(r2);
        r4 = r11[r1];
        r4 = r4.f23512y;
        r2 = r2 - r4;
        r2 = (float) r2;
        r0.y = r2;
    L_0x0125:
        r2 = r11[r1];
        r3 = r2.f23511x;
        r5 = r0.x;
        r5 = (double) r5;
        r3 = r3 + r5;
        r2.f23511x = r3;
        r2 = r11[r1];
        r3 = r2.f23512y;
        r5 = r0.y;
        r5 = (double) r5;
        r3 = r3 + r5;
        r2.f23512y = r3;
        r2 = r11[r1];
        r2 = r2.middle;
        if (r2 == 0) goto L_0x0149;
    L_0x013f:
        r2 = r11[r1];
        r2 = r2.anchoredChunk;
        if (r2 == 0) goto L_0x0149;
    L_0x0145:
        r2 = r11[r1];
        r2.anchoredChunk = r12;
    L_0x0149:
        r1 = r1 + 1;
        if (r1 >= r10) goto L_0x00ff;
    L_0x014d:
        r2 = r11[r1];
        r2.anchoredChunk = r15;
        goto L_0x00ff;
    L_0x0152:
        r4 = 0;
        r5 = 9218868437227405312; // 0x7ff0000000000000 float:0.0 double:Infinity;
        r8 = 0;
        r16 = -4503599627370496; // 0xfff0000000000000 float:0.0 double:-Infinity;
        r18 = 9218868437227405312; // 0x7ff0000000000000 float:0.0 double:Infinity;
        r20 = -4503599627370496; // 0xfff0000000000000 float:0.0 double:-Infinity;
    L_0x015c:
        r22 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        if (r4 >= r10) goto L_0x020a;
    L_0x0160:
        r13 = r11[r4];
        r13 = r13.addressable;
        if (r13 != 0) goto L_0x0168;
    L_0x0166:
        goto L_0x0203;
    L_0x0168:
        r13 = r11[r4];
        r13 = r13.anchoredChunk;
        if (r13 == 0) goto L_0x0175;
    L_0x016e:
        r18 = r5;
        r0 = -4503599627370496; // 0xfff0000000000000 float:0.0 double:-Infinity;
        r5 = 9218868437227405312; // 0x7ff0000000000000 float:0.0 double:Infinity;
        goto L_0x0179;
    L_0x0175:
        r0 = r16;
        r16 = r20;
    L_0x0179:
        r13 = r11[r4];
        r12 = r13.f23511x;
        r15 = r11[r4];
        r14 = r15.advance;
        r14 = r14 + r12;
        r2 = java.lang.Math.min(r12, r14);
        r2 = java.lang.Math.min(r5, r2);
        r5 = java.lang.Math.max(r12, r14);
        r0 = java.lang.Math.max(r0, r5);
        if (r4 <= 0) goto L_0x01a1;
    L_0x0194:
        r5 = r11[r4];
        r5 = r5.anchoredChunk;
        if (r5 == 0) goto L_0x01a1;
    L_0x019a:
        r5 = 9218868437227405312; // 0x7ff0000000000000 float:0.0 double:Infinity;
        r12 = (r18 > r5 ? 1 : (r18 == r5 ? 0 : -1));
        if (r12 != 0) goto L_0x01a7;
    L_0x01a0:
        goto L_0x01a3;
    L_0x01a1:
        r5 = 9218868437227405312; // 0x7ff0000000000000 float:0.0 double:Infinity;
    L_0x01a3:
        r12 = r10 + -1;
        if (r4 != r12) goto L_0x01fe;
    L_0x01a7:
        r12 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.TextAnchor.start;
        r13 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.Direction.ltr;
        r14 = r10 + -1;
        if (r4 != r14) goto L_0x01b3;
    L_0x01af:
        r16 = r0;
        r18 = r2;
    L_0x01b3:
        r15 = r11[r8];
        r5 = r15.f23511x;
        r15 = versioned.host.exp.exponent.modules.api.components.svg.TextLayoutAlgorithm.C67481.f23510x482da85e;
        r12 = r12.ordinal();
        r12 = r15[r12];
        switch(r12) {
            case 1: goto L_0x01df;
            case 2: goto L_0x01ce;
            case 3: goto L_0x01c3;
            default: goto L_0x01c2;
        };
    L_0x01c2:
        goto L_0x01e9;
    L_0x01c3:
        r12 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.Direction.ltr;
        if (r13 != r12) goto L_0x01ca;
    L_0x01c7:
        r5 = r5 - r16;
        goto L_0x01e9;
    L_0x01ca:
        r12 = 0;
        r5 = r5 - r18;
        goto L_0x01e9;
    L_0x01ce:
        r12 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.Direction.ltr;
        if (r13 != r12) goto L_0x01d8;
    L_0x01d2:
        r12 = r18 + r16;
        r12 = r12 / r22;
        r5 = r5 - r12;
        goto L_0x01e9;
    L_0x01d8:
        r12 = 0;
        r12 = r18 + r16;
        r12 = r12 / r22;
        r5 = r5 - r12;
        goto L_0x01e9;
    L_0x01df:
        r12 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.Direction.ltr;
        if (r13 != r12) goto L_0x01e6;
    L_0x01e3:
        r5 = r5 - r18;
        goto L_0x01e9;
    L_0x01e6:
        r12 = 0;
        r5 = r5 - r16;
    L_0x01e9:
        if (r4 != r14) goto L_0x01ed;
    L_0x01eb:
        r12 = r4;
        goto L_0x01ef;
    L_0x01ed:
        r12 = r4 + -1;
    L_0x01ef:
        if (r8 > r12) goto L_0x01fb;
    L_0x01f1:
        r13 = r11[r8];
        r14 = r13.f23511x;
        r14 = r14 + r5;
        r13.f23511x = r14;
        r8 = r8 + 1;
        goto L_0x01ef;
    L_0x01fb:
        r5 = r2;
        r8 = r4;
        goto L_0x01ff;
    L_0x01fe:
        r5 = r2;
    L_0x01ff:
        r20 = r16;
        r16 = r0;
    L_0x0203:
        r4 = r4 + 1;
        r12 = 0;
        r14 = 0;
        r15 = 1;
        goto L_0x015c;
    L_0x020a:
        r0 = new android.graphics.PointF;
        r1 = 0;
        r0.<init>(r1, r1);
        r1 = new android.graphics.PathMeasure;
        r1.<init>();
        r2 = 0;
        r4 = r2;
        r3 = 0;
        r5 = 0;
        r15 = 0;
    L_0x021a:
        if (r3 >= r10) goto L_0x03c2;
    L_0x021c:
        r6 = r9.get(r3);
        r6 = (versioned.host.exp.exponent.modules.api.components.svg.TextPathView) r6;
        if (r6 == 0) goto L_0x0366;
    L_0x0224:
        r13 = r11[r3];
        r13 = r13.addressable;
        if (r13 == 0) goto L_0x0366;
    L_0x022a:
        r4 = r6.getTextPath(r2, r2);
        r5 = r11[r3];
        r5 = r5.middle;
        if (r5 != 0) goto L_0x033e;
    L_0x0234:
        r6.getSide();
        r5 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.TextPathSide.right;
        r5 = 0;
        r1.setPath(r4, r5);
        r5 = r1.getLength();
        r13 = (double) r5;
        r5 = r6.getStartOffset();
        r24 = r13;
        r12 = r5.value;
        r5 = r11[r3];
        r26 = r4;
        r4 = r5.advance;
        r14 = r11[r3];
        r27 = r9;
        r28 = r10;
        r9 = r14.f23511x;
        r14 = r11[r3];
        r29 = r15;
        r14 = r14.f23512y;
        r14 = r11[r3];
        r14 = r14.rotate;
        r4 = r4 / r22;
        r9 = r9 + r4;
        r9 = r9 + r12;
        r4 = r1.isClosed();
        r12 = 0;
        if (r4 != 0) goto L_0x027b;
    L_0x026e:
        r4 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1));
        if (r4 < 0) goto L_0x0276;
    L_0x0272:
        r4 = (r9 > r24 ? 1 : (r9 == r24 ? 0 : -1));
        if (r4 <= 0) goto L_0x027b;
    L_0x0276:
        r4 = r11[r3];
        r5 = 1;
        r4.hidden = r5;
    L_0x027b:
        r4 = r1.isClosed();
        if (r4 == 0) goto L_0x02f9;
    L_0x0281:
        r4 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.TextAnchor.start;
        r5 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.Direction.ltr;
        r14 = r11[r8];
        r14 = r14.f23511x;
        r14 = versioned.host.exp.exponent.modules.api.components.svg.TextLayoutAlgorithm.C67481.f23510x482da85e;
        r4 = r4.ordinal();
        r4 = r14[r4];
        switch(r4) {
            case 1: goto L_0x02d4;
            case 2: goto L_0x02bb;
            case 3: goto L_0x0296;
            default: goto L_0x0294;
        };
    L_0x0294:
        goto L_0x02f9;
    L_0x0296:
        r4 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.Direction.ltr;
        if (r5 != r4) goto L_0x02ab;
    L_0x029a:
        r14 = r24;
        r4 = -r14;
        r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1));
        if (r4 < 0) goto L_0x02a5;
    L_0x02a1:
        r4 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1));
        if (r4 <= 0) goto L_0x02cb;
    L_0x02a5:
        r4 = r11[r3];
        r5 = 1;
        r4.hidden = r5;
        goto L_0x02cb;
    L_0x02ab:
        r14 = r24;
        r5 = 1;
        r4 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1));
        if (r4 < 0) goto L_0x02b6;
    L_0x02b2:
        r4 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1));
        if (r4 <= 0) goto L_0x02cb;
    L_0x02b6:
        r4 = r11[r3];
        r4.hidden = r5;
        goto L_0x02cb;
    L_0x02bb:
        r14 = r24;
        r4 = -r14;
        r4 = r4 / r22;
        r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1));
        if (r4 < 0) goto L_0x02ce;
    L_0x02c4:
        r4 = r14 / r22;
        r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x02cb;
    L_0x02ca:
        goto L_0x02ce;
    L_0x02cb:
        r30 = r6;
        goto L_0x02fd;
    L_0x02ce:
        r4 = r11[r3];
        r5 = 1;
        r4.hidden = r5;
        goto L_0x02cb;
    L_0x02d4:
        r14 = r24;
        r4 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.Direction.ltr;
        if (r5 != r4) goto L_0x02e8;
    L_0x02da:
        r4 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1));
        if (r4 < 0) goto L_0x02e2;
    L_0x02de:
        r4 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1));
        if (r4 <= 0) goto L_0x02cb;
    L_0x02e2:
        r4 = r11[r3];
        r5 = 1;
        r4.hidden = r5;
        goto L_0x02cb;
    L_0x02e8:
        r30 = r6;
        r5 = -r14;
        r4 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r4 < 0) goto L_0x02f3;
    L_0x02ef:
        r4 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1));
        if (r4 <= 0) goto L_0x02fd;
    L_0x02f3:
        r4 = r11[r3];
        r5 = 1;
        r4.hidden = r5;
        goto L_0x02fd;
    L_0x02f9:
        r30 = r6;
        r14 = r24;
    L_0x02fd:
        r9 = r9 % r14;
        r4 = r11[r3];
        r4 = r4.hidden;
        if (r4 != 0) goto L_0x0362;
    L_0x0304:
        r4 = 2;
        r5 = new float[r4];
        r6 = new float[r4];
        r4 = (float) r9;
        r1.getPosTan(r4, r5, r6);
        r4 = 1;
        r5 = r6[r4];
        r4 = (double) r5;
        r9 = 0;
        r6 = r6[r9];
        r12 = (double) r6;
        r4 = java.lang.Math.atan2(r4, r12);
        r12 = 4633260481411531256; // 0x404ca5dc1a63c1f8 float:4.7099186E-23 double:57.29577951308232;
        r4 = r4 * r12;
        r12 = 4636033603912859648; // 0x4056800000000000 float:0.0 double:90.0;
        r12 = r12 + r4;
        r6 = 2;
        r10 = new double[r6];
        r14 = java.lang.Math.cos(r12);
        r10[r9] = r14;
        r12 = java.lang.Math.sin(r12);
        r6 = 1;
        r10[r6] = r12;
        r6 = r11[r3];
        r9 = r6.rotate;
        r9 = r9 + r4;
        r6.rotate = r9;
        goto L_0x0362;
    L_0x033e:
        r26 = r4;
        r30 = r6;
        r27 = r9;
        r28 = r10;
        r29 = r15;
        r4 = r11[r3];
        r5 = r3 + -1;
        r6 = r11[r5];
        r9 = r6.f23511x;
        r4.f23511x = r9;
        r4 = r11[r3];
        r6 = r11[r5];
        r9 = r6.f23512y;
        r4.f23512y = r9;
        r4 = r11[r3];
        r5 = r11[r5];
        r5 = r5.rotate;
        r4.rotate = r5;
    L_0x0362:
        r4 = r26;
        r12 = 1;
        goto L_0x036f;
    L_0x0366:
        r30 = r6;
        r27 = r9;
        r28 = r10;
        r29 = r15;
        r12 = r5;
    L_0x036f:
        if (r30 != 0) goto L_0x03b5;
    L_0x0371:
        r5 = r11[r3];
        r5 = r5.addressable;
        if (r5 == 0) goto L_0x03b5;
    L_0x0377:
        if (r12 == 0) goto L_0x0393;
    L_0x0379:
        r5 = 0;
        r1.setPath(r4, r5);
        r6 = 2;
        r6 = new float[r6];
        r9 = r1.getLength();
        r1.getPosTan(r9, r6, r2);
        r9 = r6[r5];
        r15 = 1;
        r6 = r6[r15];
        r0.set(r9, r6);
        r12 = 0;
        r29 = 1;
        goto L_0x0395;
    L_0x0393:
        r5 = 0;
        r15 = 1;
    L_0x0395:
        if (r29 == 0) goto L_0x03b7;
    L_0x0397:
        r6 = r11[r3];
        r6 = r6.anchoredChunk;
        if (r6 == 0) goto L_0x03a0;
    L_0x039d:
        r29 = 0;
        goto L_0x03b7;
    L_0x03a0:
        r6 = r11[r3];
        r9 = r6.f23511x;
        r13 = r0.x;
        r13 = (double) r13;
        r9 = r9 + r13;
        r6.f23511x = r9;
        r6 = r11[r3];
        r9 = r6.f23512y;
        r13 = r0.y;
        r13 = (double) r13;
        r9 = r9 + r13;
        r6.f23512y = r9;
        goto L_0x03b7;
    L_0x03b5:
        r5 = 0;
        r15 = 1;
    L_0x03b7:
        r3 = r3 + 1;
        r5 = r12;
        r9 = r27;
        r10 = r28;
        r15 = r29;
        goto L_0x021a;
    L_0x03c2:
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.components.svg.TextLayoutAlgorithm.layoutText(versioned.host.exp.exponent.modules.api.components.svg.TextLayoutAlgorithm$LayoutInput):versioned.host.exp.exponent.modules.api.components.svg.TextLayoutAlgorithm$CharacterInformation[]");
    }
}
