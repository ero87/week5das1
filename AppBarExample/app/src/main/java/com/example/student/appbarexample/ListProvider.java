package com.example.student.appbarexample;

import java.util.ArrayList;
import java.util.List;

public class ListProvider {

    private static List<ModelList> list = new ArrayList<>();

    public static List<ModelList> getUserList(){
        if(!list.isEmpty()){
            list.clear();
        }

        list.add(new ModelList("hecaniv","vat",""));
        list.add(new ModelList("motocikl","laveric",""));
        list.add(new ModelList("avto","laveric",""));
        list.add(new ModelList("lav hecaniv","laveric",""));
        list.add(new ModelList("sirun avto","laveric",""));
        list.add(new ModelList("kvadracikl","laveric",""));
        list.add(new ModelList("komp","laveric",""));
        list.add(new ModelList("kompyutr","laveric",""));
        list.add(new ModelList("mard","laveric",""));

        return list;
    }




}
