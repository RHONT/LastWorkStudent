package com.example.lastworkstudent.entity;

import java.util.HashMap;
import java.util.Map;

public enum Departments {
    NONE(0), HRD(1), ACCOUNTING(2), PRODUCTION(3), SALES(4), ANALYTICS(5);

    private int id_dep;

    private static final Map<Integer,Departments> dictDepartments;
    static {
        dictDepartments = new HashMap<Integer,Departments>();
        for (Departments v : Departments.values()) {
            dictDepartments.put(v.id_dep, v);
        }
    }
    public static Departments findByKey(int i) {
        return dictDepartments.get(i);
    }

    Departments(int id_dep) {
        this.id_dep = id_dep;
    }

    public int getId_dep() {
        return id_dep;
    }
}
