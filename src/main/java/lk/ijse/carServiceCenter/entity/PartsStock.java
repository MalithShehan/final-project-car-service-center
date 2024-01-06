package lk.ijse.carServiceCenter.entity;

public class PartsStock {
    private String itemId;
    private String partName;
    private String partPrice;
    private int qtyOnHand;

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setPartPrice(String partPrice) {
        this.partPrice = partPrice;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public String getItemId() {
        return itemId;
    }

    public String getPartName() {
        return partName;
    }

    public String getPartPrice() {
        return partPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public PartsStock(String itemId, String partName, String partPrice, int qtyOnHand) {
        this.itemId = itemId;
        this.partName = partName;
        this.partPrice = partPrice;
        this.qtyOnHand = qtyOnHand;
    }
}
