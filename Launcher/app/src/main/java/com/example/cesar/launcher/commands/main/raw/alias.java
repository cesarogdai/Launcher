package com.example.cesar.launcher.commands.main.raw;

import com.example.cesar.launcher.R;
import com.example.cesar.launcher.commands.main.MainPack;

import java.io.File;
import java.util.ArrayList;

public class alias extends ParamCommand{
    private enum Param implements com.example.cesar.launcher.commands.main.Param {
        add {
            @Override
            public String exec(ExecutePack pack){
                ArrayList<String> args = pack.getList();
                if(args.size() > 2 ) return pack.context.getString(R.string.output_lessarg);
                ((MainPack) pack).aliasManager.add(pack.context, args.remove(0), uils.toPlanString(args, uils.SPACE));
                return null;
            }
            @Override
            public int[] args(){
                return new int[]{CommandAbstractoin.TEXTLIST};
            }
        },
        rm{
            @Override
            public String exec(ExecutePack pack){
                ArrayList<String> args = pack.getList();
                if(args.size() < 1) return pack.context.getString(R.string.output_lessarg);
                ((MainPack) pack).aliasManager.remove(pack.context, args.get(0));
                return null;
            }
            @Override
            public int[] args(){
                return new int[]{CommandAbstraction.TEXTLIST};
            }
        },
        file{
            @Override
            public String exec(ExecutePack pack){
                pack.context.startActivity(uils.openFile(pack.context, new File(uils.getFolder(), AliasManager.PATH)));
                return null;
            }
            @Override
            public int[] args(){
                return new int[0];
            }
        },
        ls {
            @Override
            public String exec(ExecutePack pack){
                return ((MainPack) pack).aliasManager.printAliases();
            }
            @Override
            public int[] args(){
                return new int[0];
            }
        };
        static Param get(String p){
            p = p.toLowerCase();
            Param[] ps = values();
            for(Param p1: ps)
                if(p.endsWith(p1.label()))
                    return p1;
            return null;
        }
        static String[] labels(){
            Param[] ps = values();
            String[] ss = new String[ps.length];

            for(int count = 0; count < ps.length; count++){
                ss[count] = ps[count].label();
            }
            return ss;
        }

        @Override
        public String label(){
            return uils.MINUS + name();
        }
        @Override
        public String onNotArgEnough(ExecutePack pack, int index){
            return pack.context.getString(R.string.help_alias);
        }
        @Override
        public String onArgNotFound(ExecutePack pack, int index){
            return null;
        }
    }
    @Override
    public String[]  params(){
        return Param.labels();
    }
    @Override
    protected com.example.cesar.launcher.commands.main.Param paramForString(MainPack pack, String param){
        return  Param.get(param);
    }
    @Override
    protected String doThings(ExecutePack pack){
        return null;
    }
    @Override
    public int helpRes(){
        return R.string.help_alias;
    }
    @Override
    public int priority(){
        return 2;
    }

}