package Model;

public class bankTranfer extends paymentMethod {
    private String accName;
    private String bankName;

    public bankTranfer(String accName, String bankName) {
        this.accName = accName;
        this.bankName = bankName;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public void processPayment() {
        System.out.println("Procesando transferencia bancaria desde el banco " + bankName +
                           " a nombre de " + accName);
    }
}
