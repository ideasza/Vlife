package teerayut.dev.vlife.home.Item;

import android.os.Parcel;
import android.os.Parcelable;

import com.android.tonyvu.sc.model.Saleable;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by teerayut.k on 7/10/2017.
 */

public class ProductItem implements Saleable, Serializable {
    private static final long serialVersionUID = -4073256626483275668L;

    private int PRODUCT_ID;
    private String PRODUCT_NAME1;
    private String PRODUCT_NAME2;
    private String PRODUCT_DETAIL1;
    private String PRODUCT_DETAIL2;
    private String PRODUCT_DETAIL3;
    private String PRODUCT_DETAIL4;
    private BigDecimal PRODUCT_PRICE;
    private String PRODUCT_PV;
    private String PRODUCT_STATUS_RECOMMEND;
    private String PRODUCT_STATUS_BESTSELLER;
    private String PRODUCT_IMAGE;
    private int GROUP_ID;
    private boolean added;

    public boolean isAdded() {
        return added;
    }

    public void setAdded(boolean added) {
        this.added = added;
    }

    @Override
    public BigDecimal getPrice() {
        return PRODUCT_PRICE;
    }

    @Override
    public String getName() {
        return PRODUCT_NAME1;
    }

    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(int PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public void setPRODUCT_NAME1(String PRODUCT_NAME1) {
        this.PRODUCT_NAME1 = PRODUCT_NAME1;
    }

    public String getPRODUCT_NAME2() {
        return PRODUCT_NAME2;
    }

    public void setPRODUCT_NAME2(String PRODUCT_NAME2) {
        this.PRODUCT_NAME2 = PRODUCT_NAME2;
    }

    public String getPRODUCT_DETAIL1() {
        return PRODUCT_DETAIL1;
    }

    public void setPRODUCT_DETAIL1(String PRODUCT_DETAIL1) {
        this.PRODUCT_DETAIL1 = PRODUCT_DETAIL1;
    }

    public String getPRODUCT_DETAIL2() {
        return PRODUCT_DETAIL2;
    }

    public void setPRODUCT_DETAIL2(String PRODUCT_DETAIL2) {
        this.PRODUCT_DETAIL2 = PRODUCT_DETAIL2;
    }

    public String getPRODUCT_DETAIL3() {
        return PRODUCT_DETAIL3;
    }

    public void setPRODUCT_DETAIL3(String PRODUCT_DETAIL3) {
        this.PRODUCT_DETAIL3 = PRODUCT_DETAIL3;
    }

    public String getPRODUCT_DETAIL4() {
        return PRODUCT_DETAIL4;
    }

    public void setPRODUCT_DETAIL4(String PRODUCT_DETAIL4) {
        this.PRODUCT_DETAIL4 = PRODUCT_DETAIL4;
    }

    public void setPRODUCT_PRICE(BigDecimal PRODUCT_PRICE) {
        this.PRODUCT_PRICE = PRODUCT_PRICE;
    }

    public String getPRODUCT_PV() {
        return PRODUCT_PV;
    }

    public void setPRODUCT_PV(String PRODUCT_PV) {
        this.PRODUCT_PV = PRODUCT_PV;
    }

    public String getPRODUCT_STATUS_RECOMMEND() {
        return PRODUCT_STATUS_RECOMMEND;
    }

    public void setPRODUCT_STATUS_RECOMMEND(String PRODUCT_STATUS_RECOMMEND) {
        this.PRODUCT_STATUS_RECOMMEND = PRODUCT_STATUS_RECOMMEND;
    }

    public String getPRODUCT_STATUS_BESTSELLER() {
        return PRODUCT_STATUS_BESTSELLER;
    }

    public void setPRODUCT_STATUS_BESTSELLER(String PRODUCT_STATUS_BESTSELLER) {
        this.PRODUCT_STATUS_BESTSELLER = PRODUCT_STATUS_BESTSELLER;
    }

    public String getPRODUCT_IMAGE() {
        return PRODUCT_IMAGE;
    }

    public void setPRODUCT_IMAGE(String PRODUCT_IMAGE) {
        this.PRODUCT_IMAGE = PRODUCT_IMAGE;
    }

    public int getGROUP_ID() {
        return GROUP_ID;
    }

    public void setGROUP_ID(int GROUP_ID) {
        this.GROUP_ID = GROUP_ID;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof ProductItem)) return false;

        return (this.PRODUCT_ID == ((ProductItem) o).getPRODUCT_ID());
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = hash * prime + PRODUCT_ID;
        hash = hash * prime + (PRODUCT_NAME1 == null ? 0 : PRODUCT_NAME1.hashCode());
        hash = hash * prime + (PRODUCT_NAME2 == null ? 0 : PRODUCT_NAME2.hashCode());
        hash = hash * prime + (PRODUCT_DETAIL1 == null ? 0 : PRODUCT_DETAIL1.hashCode());
        hash = hash * prime + (PRODUCT_DETAIL2 == null ? 0 : PRODUCT_DETAIL2.hashCode());
        hash = hash * prime + (PRODUCT_DETAIL3 == null ? 0 : PRODUCT_DETAIL3.hashCode());
        hash = hash * prime + (PRODUCT_DETAIL4 == null ? 0 : PRODUCT_DETAIL4.hashCode());
        hash = hash * prime + (PRODUCT_PRICE == null ? 0 : PRODUCT_PRICE.hashCode());
        hash = hash * prime + (PRODUCT_PV == null ? 0 : PRODUCT_PV.hashCode());
        hash = hash * prime + (PRODUCT_STATUS_RECOMMEND == null ? 0 : PRODUCT_STATUS_RECOMMEND.hashCode());
        hash = hash * prime + (PRODUCT_STATUS_BESTSELLER == null ? 0 : PRODUCT_STATUS_BESTSELLER.hashCode());
        hash = hash * prime + (PRODUCT_IMAGE == null ? 0 : PRODUCT_IMAGE.hashCode());
        hash = hash * prime + GROUP_ID;

        return hash;
    }
}
