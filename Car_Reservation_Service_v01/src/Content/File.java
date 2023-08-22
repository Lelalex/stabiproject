package Content;

import java.text.SimpleDateFormat;
import java.util.Date;

public class File extends Content {

    public File(ContentDetails contentDetails) {
        super(contentDetails);
    }

	@Override
	public void printStructure(String indent) {
		System.out.println(indent + getName());
	}

	@Override
	public String getName() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		return date.format(new Date(creationDate)) + ".java";
	}

//
//    public Booking getBooking() {
//        return booking;
//    }
//
//    public PaymentReceipt getPaymentReceipt() {
//        return paymentReceipt;
    }