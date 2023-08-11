package hello.core.order;

public class Order {  //주문 엔티티

    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;
    public Order(Long memberId, String itemName, int itemPrice, int
            discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }
    public int calculatePrice() {       // 계산된 결과
        return itemPrice - discountPrice;
    }
    public Long getMemberId() {
        return memberId;
    }
    public String getItemName() {
        return itemName;
    }
    public int getItemPrice() {
        return itemPrice;
    }
    public int getDiscountPrice() {
        return discountPrice;
    }
    @Override
    public String toString() {  //객체를 출력하면 결과가 쭉 나옴
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
