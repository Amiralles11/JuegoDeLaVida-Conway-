package com.example.juegodelavida1.EstructurasDatos.ListaSimple;

import com.google.gson.annotations.Expose;

public class ElementoLS<T> {
    @Expose
    private T data;
    public ElementoLS(T o){
        this.data = o;
    }
    public ElementoLS(){

    }
    public T getData(){
        return data;
    }
    public void setData(T newData){
        this.data = newData;
    }
}
