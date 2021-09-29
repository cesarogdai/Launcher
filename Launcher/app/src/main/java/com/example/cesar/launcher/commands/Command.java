package com.example.cesar.launcher.commands;

import com.example.cesar.launcher.R;
import com.example.cesar.launcher.commands.main.Param;

public class Command {
    public CommandAsbtracion cmd;
    public Object[] mArgs;
    public int nArgs;
    public int indexNotFound =-1;
    public String exec(ExecutePack info) throws Exception {
        info.set(mArgs);

        if(cmd instanceof ParamCommand) {
            if(indexNotFound == 0) {
                return info.context.getString(R.string.output_invalid_param) + Tuils.SPACE + mArgs[0];
            }

            ParamCommand pCmd = (ParamCommand) cmd;
            Param param = (Param) mArgs[0];

            int[] args = param.args();
//            if(args == null || mArgs[0] instanceof String) {
//                if(((String) mArgs[0]).length() == 0) return cmd.onNotArgEnough(info, 0);
//                else return resources.getString(R.string.output_invalid_param) + Tuils.SPACE + mArgs[0];
//            }

            if(indexNotFound != -1) {
                return param.onArgNotFound(info, indexNotFound);
            }

            if(pCmd.defaultParamReference() != null) {
                if(args.length > nArgs) {
                    return param.onNotArgEnough(info, nArgs);
                }
            } else {
                if(args.length + 1 > nArgs) {
                    return param.onNotArgEnough(info, nArgs);
                }
            }
        } else if(indexNotFound != -1) {
            return cmd.onArgNotFound(info, indexNotFound);
        }
        else {
            int[] args = cmd.argType();
            if (nArgs < args.length || (mArgs == null && args.length > 0)) {
                return cmd.onNotArgEnough(info, nArgs);
            }
        }

        return cmd.exec(info);
    }
    public int nextArgs() {
    boolean useParamsArgs = cmd instanceof ParamCommand && mArgs != null && mArgs.length >= 1;
    int[] args;
    if(useParamsArgs){
        if(!(mArgs[0] instanceof  Param)) args = null;
        else args = ((Param) mArgs[0]).args();
    }else{
        args = cmd.argType();
    }
    if (args == null || args.length == 0){
        return 0;
    }
    try{
        return  args[useParamsArgs ? nArgs -1 : nArgs];
    }catch (ArrayIndexOutOfBoundsException e){
        return 0;
    }
    }
}

