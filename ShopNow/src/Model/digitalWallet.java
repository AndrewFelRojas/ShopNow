package Model;

public class digitalWallet extends paymentMethod {
    private int walletID;

    public digitalWallet(int walletID) {
        this.walletID = walletID;
    }

    public int getWalletID() {
        return walletID;
    }

    public void setWalletID(int walletID) {
        this.walletID = walletID;
    }

    @Override
    public void processPayment() {
        String idStr = String.valueOf(walletID);
        String lastFour = idStr.length() >= 4
            ? idStr.substring(idStr.length() - 4)
            : idStr;
        System.out.println("Procesando billetera digital con ID terminado en " + lastFour);
    }
}
