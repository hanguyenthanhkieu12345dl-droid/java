package communityuni.com;

public class Invoice {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    // Constructor
    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;

        if (quantity > 0)
            this.quantity = quantity;
        else
            this.quantity = 0;

        if (pricePerItem > 0)
            this.pricePerItem = pricePerItem;
        else
            this.pricePerItem = 0.0;
    }

    // Getter và Setter
    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0)
            this.quantity = quantity;
        else
            this.quantity = 0;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        if (pricePerItem > 0)
            this.pricePerItem = pricePerItem;
        else
            this.pricePerItem = 0.0;
    }

    // Tính tiền hóa đơn
    public double getInvoiceAmount() {
        return quantity * pricePerItem;
    }

    // Hiển thị thông tin
    public void display() {
        System.out.println("Mã mặt hàng: " + partNumber);
        System.out.println("Mô tả: " + partDescription);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Giá: " + pricePerItem);
        System.out.println("Thành tiền: " + getInvoiceAmount());
        System.out.println("");
    }
}