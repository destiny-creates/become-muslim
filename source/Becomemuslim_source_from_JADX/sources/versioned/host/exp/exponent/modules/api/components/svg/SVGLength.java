package versioned.host.exp.exponent.modules.api.components.svg;

import com.facebook.appevents.UserDataStore;

class SVGLength {
    final SVGLengthUnitType unit;
    final double value;

    SVGLength() {
        this.value = 0.0d;
        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_UNKNOWN;
    }

    SVGLength(double d) {
        this.value = d;
        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
    }

    SVGLength(String str) {
        str = str.trim();
        int length = str.length();
        int i = length - 1;
        if (length != 0) {
            if (!str.equals("normal")) {
                if (str.codePointAt(i) == 37) {
                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PERCENTAGE;
                    this.value = Double.valueOf(str.substring(0, i)).doubleValue();
                    return;
                }
                i = length - 2;
                if (i > 0) {
                    Object obj;
                    String substring = str.substring(i);
                    int hashCode = substring.hashCode();
                    if (hashCode != 3178) {
                        if (hashCode != 3240) {
                            if (hashCode != 3251) {
                                if (hashCode != 3365) {
                                    if (hashCode != 3488) {
                                        if (hashCode != 3571) {
                                            if (hashCode != 3588) {
                                                if (hashCode == 3592) {
                                                    if (substring.equals("px")) {
                                                        obj = null;
                                                        switch (obj) {
                                                            case null:
                                                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                                                                break;
                                                            case 1:
                                                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_EMS;
                                                                break;
                                                            case 2:
                                                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_EXS;
                                                                break;
                                                            case 3:
                                                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PT;
                                                                break;
                                                            case 4:
                                                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PC;
                                                                break;
                                                            case 5:
                                                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_MM;
                                                                break;
                                                            case 6:
                                                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_CM;
                                                                break;
                                                            case 7:
                                                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_IN;
                                                                break;
                                                            default:
                                                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                                                                break;
                                                        }
                                                        length = i;
                                                        this.value = Double.valueOf(str.substring(0, length)).doubleValue();
                                                        return;
                                                    }
                                                }
                                            } else if (substring.equals("pt")) {
                                                obj = 3;
                                                switch (obj) {
                                                    case null:
                                                        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                                                        break;
                                                    case 1:
                                                        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_EMS;
                                                        break;
                                                    case 2:
                                                        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_EXS;
                                                        break;
                                                    case 3:
                                                        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PT;
                                                        break;
                                                    case 4:
                                                        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PC;
                                                        break;
                                                    case 5:
                                                        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_MM;
                                                        break;
                                                    case 6:
                                                        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_CM;
                                                        break;
                                                    case 7:
                                                        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_IN;
                                                        break;
                                                    default:
                                                        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                                                        break;
                                                }
                                                length = i;
                                                this.value = Double.valueOf(str.substring(0, length)).doubleValue();
                                                return;
                                            }
                                        } else if (substring.equals("pc")) {
                                            obj = 4;
                                            switch (obj) {
                                                case null:
                                                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                                                    break;
                                                case 1:
                                                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_EMS;
                                                    break;
                                                case 2:
                                                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_EXS;
                                                    break;
                                                case 3:
                                                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PT;
                                                    break;
                                                case 4:
                                                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PC;
                                                    break;
                                                case 5:
                                                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_MM;
                                                    break;
                                                case 6:
                                                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_CM;
                                                    break;
                                                case 7:
                                                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_IN;
                                                    break;
                                                default:
                                                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                                                    break;
                                            }
                                            length = i;
                                            this.value = Double.valueOf(str.substring(0, length)).doubleValue();
                                            return;
                                        }
                                    } else if (substring.equals("mm")) {
                                        obj = 5;
                                        switch (obj) {
                                            case null:
                                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                                                break;
                                            case 1:
                                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_EMS;
                                                break;
                                            case 2:
                                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_EXS;
                                                break;
                                            case 3:
                                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PT;
                                                break;
                                            case 4:
                                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PC;
                                                break;
                                            case 5:
                                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_MM;
                                                break;
                                            case 6:
                                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_CM;
                                                break;
                                            case 7:
                                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_IN;
                                                break;
                                            default:
                                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                                                break;
                                        }
                                        length = i;
                                        this.value = Double.valueOf(str.substring(0, length)).doubleValue();
                                        return;
                                    }
                                } else if (substring.equals("in")) {
                                    obj = 7;
                                    switch (obj) {
                                        case null:
                                            this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                                            break;
                                        case 1:
                                            this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_EMS;
                                            break;
                                        case 2:
                                            this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_EXS;
                                            break;
                                        case 3:
                                            this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PT;
                                            break;
                                        case 4:
                                            this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PC;
                                            break;
                                        case 5:
                                            this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_MM;
                                            break;
                                        case 6:
                                            this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_CM;
                                            break;
                                        case 7:
                                            this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_IN;
                                            break;
                                        default:
                                            this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                                            break;
                                    }
                                    length = i;
                                    this.value = Double.valueOf(str.substring(0, length)).doubleValue();
                                    return;
                                }
                            } else if (substring.equals("ex")) {
                                obj = 2;
                                switch (obj) {
                                    case null:
                                        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                                        break;
                                    case 1:
                                        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_EMS;
                                        break;
                                    case 2:
                                        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_EXS;
                                        break;
                                    case 3:
                                        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PT;
                                        break;
                                    case 4:
                                        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PC;
                                        break;
                                    case 5:
                                        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_MM;
                                        break;
                                    case 6:
                                        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_CM;
                                        break;
                                    case 7:
                                        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_IN;
                                        break;
                                    default:
                                        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                                        break;
                                }
                                length = i;
                                this.value = Double.valueOf(str.substring(0, length)).doubleValue();
                                return;
                            }
                        } else if (substring.equals(UserDataStore.EMAIL)) {
                            obj = 1;
                            switch (obj) {
                                case null:
                                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                                    break;
                                case 1:
                                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_EMS;
                                    break;
                                case 2:
                                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_EXS;
                                    break;
                                case 3:
                                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PT;
                                    break;
                                case 4:
                                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PC;
                                    break;
                                case 5:
                                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_MM;
                                    break;
                                case 6:
                                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_CM;
                                    break;
                                case 7:
                                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_IN;
                                    break;
                                default:
                                    this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                                    break;
                            }
                            length = i;
                            this.value = Double.valueOf(str.substring(0, length)).doubleValue();
                            return;
                        }
                    } else if (substring.equals("cm")) {
                        obj = 6;
                        switch (obj) {
                            case null:
                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                                break;
                            case 1:
                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_EMS;
                                break;
                            case 2:
                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_EXS;
                                break;
                            case 3:
                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PT;
                                break;
                            case 4:
                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PC;
                                break;
                            case 5:
                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_MM;
                                break;
                            case 6:
                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_CM;
                                break;
                            case 7:
                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_IN;
                                break;
                            default:
                                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                                break;
                        }
                        length = i;
                        this.value = Double.valueOf(str.substring(0, length)).doubleValue();
                        return;
                    }
                    obj = -1;
                    switch (obj) {
                        case null:
                            this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                            break;
                        case 1:
                            this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_EMS;
                            break;
                        case 2:
                            this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_EXS;
                            break;
                        case 3:
                            this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PT;
                            break;
                        case 4:
                            this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_PC;
                            break;
                        case 5:
                            this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_MM;
                            break;
                        case 6:
                            this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_CM;
                            break;
                        case 7:
                            this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_IN;
                            break;
                        default:
                            this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                            break;
                    }
                    length = i;
                    this.value = Double.valueOf(str.substring(0, length)).doubleValue();
                    return;
                }
                this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER;
                this.value = Double.valueOf(str).doubleValue();
                return;
            }
        }
        this.unit = SVGLengthUnitType.SVG_LENGTHTYPE_UNKNOWN;
        this.value = 0.0d;
    }
}
