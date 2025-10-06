package Model;

public class Card extends paymentMethod {
	private int Cvv;
private int cardNumber;
private int expirationDate;
public Card(int cvv, int cardNumber, int expirationDate) {
		super();
		Cvv = cvv;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
	}




public int getCvv() {
	return Cvv;
}
public void setCvv(int cvv) {
	Cvv = cvv;
}
public int getCardNumber() {
	return cardNumber;
}
public void setCardNumber(int cardNumber) {
	this.cardNumber = cardNumber;
}
public int getExpirationDate() {
	return expirationDate;
}
public void setExpirationDate(int expirationDate) {
	this.expirationDate = expirationDate;
}

@Override
public void processPayment() {
    String cardStr = String.valueOf(cardNumber);
    String lastFourDigits = cardStr.length() >= 4
        ? cardStr.substring(cardStr.length() - 4)
        : cardStr;
    System.out.println("Procesando pago con tarjeta terminada en " + lastFourDigits);
}

}
