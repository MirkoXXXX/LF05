package LF05.tresor;

public class Aktie extends Gegenstand{

    String company;
    double listValue;

    public Aktie(int id, double value, String company, double listValue) {
        super(id, value);
        this.company = company;
        this.listValue = listValue;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getListValue() {
        return listValue;
    }

    public void setListValue(double listValue) {
        this.listValue = listValue;
    }

    @Override
    public String toString() {
        return "Aktie{" +
                "company='" + company + '\'' +
                ", listValue=" + listValue +
                '}';
    }
}
