package model;

import java.util.Date;

public class Transaction_Info extends BaseModel {
    private int transaction_id;
    private float txn_amount;
    private String card_number;
    private int address_id;
    private int payment_type_id;
    private Date txn_date;
    private String txn_status;
    private String expiry_date;

    private int cvv;

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public float getTxn_amount() {
        return txn_amount;
    }

    public void setTxn_amount(float txn_amount) {
        this.txn_amount = txn_amount;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getPayment_type_id() {
        return payment_type_id;
    }

    public void setPayment_type_id(int payment_type_id) {
        this.payment_type_id = payment_type_id;
    }

    public Date getTxn_date() {
        return txn_date;
    }

    public void setTxn_date(Date txn_date) {
        this.txn_date = txn_date;
    }

    public String getTxn_status() {
        return txn_status;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setTxn_status(String txn_status) {
        this.txn_status = txn_status;
    }
}
