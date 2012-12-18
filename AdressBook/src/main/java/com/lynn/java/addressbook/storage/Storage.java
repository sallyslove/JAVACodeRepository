package com.lynn.java.addressbook.storage;

public interface Storage {

    public void generateNewStorage();

    public void loadData();

    public void transformData();

    public void refreshData();

    public void deleteData();

    public Object searchData();

    public void saveData();

    public void loadData(Object obj);

    public void refreshData(Object obj);

    public void deleteData(Object obj);

    public Object searchData(Object obj);

    public void savaData(Object obj);

    public void transformData(Object obj);
}
