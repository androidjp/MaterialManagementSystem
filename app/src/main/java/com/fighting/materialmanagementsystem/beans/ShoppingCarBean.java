package com.fighting.materialmanagementsystem.beans;

import java.io.Serializable;

/**购物车的bean，增加在购物车的数量
 * Created by laisixiang on 2016/1/31.
 */
public class ShoppingCarBean implements Serializable{
    Material material;
    int courtInCar;

    public ShoppingCarBean(Material material,int addNum){
        this.material = material;
        this.courtInCar+=addNum;
    }

    public Material getMaterial() {
        return material;
    }

    public int getCourtInCar() {
        return courtInCar;
    }

    public void addCourtInCar(int courtInCar) {
        this.courtInCar += courtInCar;
    }

    public void removeCourtInCar(int courtInCar) {
        this.courtInCar -= courtInCar;
    }
}
