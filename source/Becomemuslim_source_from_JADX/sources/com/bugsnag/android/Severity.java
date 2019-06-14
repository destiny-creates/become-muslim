package com.bugsnag.android;

import com.bugsnag.android.ab.C1071a;

public enum Severity implements C1071a {
    ERROR("error"),
    WARNING("warning"),
    INFO("info");
    
    private final String name;

    private Severity(String str) {
        this.name = str;
    }

    public void toStream(ab abVar) {
        abVar.mo771b(this.name);
    }

    static Severity fromString(String str) {
        int hashCode = str.hashCode();
        if (hashCode != 3237038) {
            if (hashCode != 96784904) {
                if (hashCode == 1124446108) {
                    if (str.equals("warning") != null) {
                        str = true;
                        switch (str) {
                            case null:
                                return ERROR;
                            case 1:
                                return WARNING;
                            case 2:
                                return INFO;
                            default:
                                return null;
                        }
                    }
                }
            } else if (str.equals("error") != null) {
                str = null;
                switch (str) {
                    case null:
                        return ERROR;
                    case 1:
                        return WARNING;
                    case 2:
                        return INFO;
                    default:
                        return null;
                }
            }
        } else if (str.equals("info") != null) {
            str = 2;
            switch (str) {
                case null:
                    return ERROR;
                case 1:
                    return WARNING;
                case 2:
                    return INFO;
                default:
                    return null;
            }
        }
        str = -1;
        switch (str) {
            case null:
                return ERROR;
            case 1:
                return WARNING;
            case 2:
                return INFO;
            default:
                return null;
        }
    }

    public String getName() {
        return this.name;
    }
}
