package com.example.cesar.launcher.managers.xml.options;

import com.example.cesar.launcher.managers.xml.classes.XMLPrefsElement;
import com.example.cesar.launcher.managers.xml.classes.XMLPrefsSave;

public enum Apps  implements XMLPrefsSave {

    default_app_n1 {
        @Override
        public String defaultValue(){
            return MOST_USED;
        }

        @Override
        public String info(){
            return "La primera app sugerida";
        }
    },
    default_app_n2 {
        @Override
        public String defaultValue(){
            return MOST_USED;
        }

        @Override
        public String info(){
            return "La segunda app sugerida";
        }
    },
    default_app_n3 {
        @Override
        public String defaultValue(){
            return MOST_USED;
        }

        @Override
        public String info(){
            return "La tercera app sugerida";
        }
    },
    default_app_n4 {
        @Override
        public String defaultValue(){
            return MOST_USED;
        }

        @Override
        public String info(){
            return "La cuarta app sugerida";
        }
    },
    default_app_n5 {
        @Override
        public String defaultValue(){
            return MOST_USED;
        }

        @Override
        public String info(){
            return "La quinta app sugerida";
        }
    },
    app_groups_sorting {
        @Override
        public String defaultValue() {
            return "2";
        }
        @Override
        public String info(){
            return "0 = time up->down; 1 = time down->up' 2 alphabetical up->down; 3 = alphabetical down->up; 4 = most used up->down; 5 = most used down->up";
        }

        @Override
        public String type(){
            return XMLPrefsSave.INTEGER;
        }
    };

    public static final String MOST_USED = "most_used";
    public static final String NULL = "null";

    @Override
    public String label(){
        return name();
    }

    @Override
    public XMLPrefsElement parent(){
        return AppsManager().instance;
    }

    @Override
    public String type(){
        return XMLPrefsSave.APP;
    }

    @Override
    public String[] invalidValues(){
        return null;
    }
    @Override
    public String getLowercaseString(){
        return label();
    }

    @Override
    public String getString(){
        return label();
    }

}
