package com.example.assignment2cashregistry;

import android.os.Parcelable;
import android.os.Parcel;

public class StoreItem implements Parcelable {
    String productName;
    Double price;
    int  quantity;


    public StoreItem(){
        this.productName=null;
        this.price=-1.0;
        this.quantity=0;

    }
    public StoreItem(String productName,double price,int quantity){
        this.productName=productName;
        this.price=price;
        this.quantity=quantity;

    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getTotal() {
        return quantity*price;
    }

    public void buy(int amount) {
        if(amount<=0) {
            throw new IllegalArgumentException("The amount must be larger than zero");
        } else if (amount > quantity) {
            throw new IllegalArgumentException("No enough quentity in the stock!!");
        }
        quantity -= amount;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public static Creator<StoreItem> getCREATOR() {
        return CREATOR;
    }

    protected StoreItem(Parcel in) {
        if(in.readByte()==0){
            price=null;

        }
        else{
            price=in.readDouble();
        }
        quantity=in.readInt();


    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if(price==null) {
            parcel.writeByte((byte) 0);
        }
        else{
            parcel.writeByte((byte) 1);
            parcel.writeDouble(price);
        }
        parcel.writeInt(quantity);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<StoreItem> CREATOR = new Creator<StoreItem>() {
        @Override
        public StoreItem createFromParcel(Parcel in) {
            return new StoreItem(in);
        }

        @Override
        public StoreItem[] newArray(int size) {
            return new StoreItem[size];
        }
    };
}
