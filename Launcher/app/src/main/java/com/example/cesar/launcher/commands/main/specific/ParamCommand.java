package com.example.cesar.launcher.commands.main.specific;

import android.widget.Toast;

import com.example.cesar.launcher.R;
import com.example.cesar.launcher.commands.CommandAbstraction;
import com.example.cesar.launcher.commands.ExecutePack;
import com.example.cesar.launcher.commands.main.MainPack;
import com.example.cesar.launcher.commands.main.Param;

public abstract class ParamCommand implements CommandAbstraction {

    @Override
    public final int[] argType(){
        return new int[] {CommandAbstraction.PARAM};
    }

    @Override
    public final String exec(ExecutePack pack) throws Exception {
        String o = doThings(pack);
        if(o !=null)return o;

        Param param = pack.get(Param.class);
        if(param == null){
            Object o1 = pack.get(Object.class, 0);

            if(o1 == null || o1.toString().length() ==0)return pack.context.getString(helpRes());
            else return pack.context.getString(R.string.output_invalid_param)+ Tuils.SPACE + o1.toString();
        }
        return param.exec(pack);
    }

    public SimpleMutableEntry<Boolean, Param> getParam(MainPack pack, String param) {
        Param p = paramForString(pack, param);
        if(p == null && defaultParamReference() != null){
            return new SimpleMutableEntry<>(false, p);
        }
    }
    public String defaultParamReference(MainPack pack){
        String def = pack.cmdPrefs.get(defaultParamReference());
        if(!def.startsWith("-")) def = "-" + def;
        return def;
    }

    @Override
    public String onNotArgEnough(ExecutePack pack, int nArgs){
        return pack.context.getString(helpRes());
    }

    @Override
    public String onArgEnough(ExecutePack pack. int index){
        Tuils.log("inf", index);
        if(index == 0){
            try{
                Tuils.log("last");
                String param = pack.get(String.class, 0);
                return pack.context.getString(R.string.output_invalid_param) +  Tuils.SPACE + param;
            }catch (Exception e) {}
        }
        return pack.context.getString(helpRes());
    }

    public abstract  String[] params();
    protected abstract  Param paramForString(MainPack pack, String param);
    protected abstract String doThings(ExecutePack pack);
    public XMLPrefsSave defaultParamReference(){
        return null;
    }
}
