package com;

public class Currency {

    private Integer r030;
    private String txt;
    private Double rate;
    private String cc;
    private String exchangedate;

    public Currency() {
    }

    public Currency(Integer r030, String txt, Double rate, String cc, String exchangedate) {
        this.r030 = r030;
        this.txt = txt;
        this.rate = rate;
        this.cc = cc;
        this.exchangedate = exchangedate;
    }

    public Integer getR030() {
        return r030;
    }

    public void setR030(Integer r030) {
        this.r030 = r030;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getExchangedate() {
        return exchangedate;
    }

    public void setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;

        Currency currency = (Currency) o;

        if (r030 != null ? !r030.equals(currency.r030) : currency.r030 != null) return false;
        if (txt != null ? !txt.equals(currency.txt) : currency.txt != null) return false;
        if (rate != null ? !rate.equals(currency.rate) : currency.rate != null) return false;
        if (cc != null ? !cc.equals(currency.cc) : currency.cc != null) return false;
        return exchangedate != null ? exchangedate.equals(currency.exchangedate) : currency.exchangedate == null;
    }

    @Override
    public int hashCode() {
        int result = r030 != null ? r030.hashCode() : 0;
        result = 31 * result + (txt != null ? txt.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (cc != null ? cc.hashCode() : 0);
        result = 31 * result + (exchangedate != null ? exchangedate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "r030=" + r030 +
                ", txt='" + txt + '\'' +
                ", rate=" + rate +
                ", cc='" + cc + '\'' +
                ", exchangedate='" + exchangedate + '\'' +
                '}';
    }
}
