package EdYass.emprestimos.domains;

public class Customer {

    private Integer age;
    private String cpf;
    private String name;
    private Double income;
    private String location;

    public Customer(Integer age, String cpf, String name, Double income, String location) {
        this.age = age;
        this.cpf = cpf;
        this.name = name;
        this.income = income;
        this.location = location;
    }

    public boolean isIncomeEsqualOrLowerThan(double v) {
        return income <= v;
    }
    public boolean isIncomeEsqualOrGreaterThan(double v) {
        return income >= v;
    }

    public boolean isIncomeBetween(double minV, double maxV) {
        return income >= minV && income <= maxV;
    }

    public boolean isAgeLower(Integer v) {
        return age < v;
    }

    public boolean isFromLocation(String location) {
        return this.location.equalsIgnoreCase(location);
    }
}
