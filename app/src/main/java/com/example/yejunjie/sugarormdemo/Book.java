package com.example.yejunjie.sugarormdemo;

import com.orm.SugarRecord;

/**
 * Created by yejunjie on 16/7/12.
 */

public class Book extends SugarRecord {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
    String price;
    String edition;



    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
}
