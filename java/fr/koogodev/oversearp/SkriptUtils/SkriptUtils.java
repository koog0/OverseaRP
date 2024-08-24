package fr.koogodev.oversearp.SkriptUtils;

import ch.njol.skript.variables.Variables;

public class SkriptUtils {
    public Object getVariable(String name){
        Object variable = Variables.getVariable(name, null, false);
        if (variable!=null) {
            return variable;
        }
        else{
            return null;
        }
    }

    public void setVariable(String name, String value){
        Object newValue = null;
        try {
            newValue = Long.parseLong(value);
        }
        catch(Exception e){
        }
        try {
            newValue = Double.parseDouble(value);
        }
        catch(Exception e){
        }
        try {
            newValue = Boolean.parseBoolean(value);
        }
        catch(Exception e){
        }
        if(newValue == null){
            Variables.setVariable(name, value, null, false);
        }
        else{
            Variables.setVariable(name, newValue, null, false);
        }
    }
}
