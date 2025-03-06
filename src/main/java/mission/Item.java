package mission;

public class Item {

    private static final int MINIMUM_VALUE = 1;

    private long id;
    private String name;
    private int price;

    public Item(final long id, final String name, final int price) {
        validateItem(name, price);
        this.id = id;
        this.name = name;
        this.price = price;
    }

    private void validateItem(final String name, final int price) {
        validateNameExistence(name);
        validatePositivePrice(price);
    }

    private void validateNameExistence(final String name) {
        if (name.isBlank()) {
            throw new RuntimeException("올바르지 않은 이름 형식입니다.");
        }
    }

    private void validatePositivePrice(final int price) {
        if (price < MINIMUM_VALUE) {
            throw new RuntimeException("올바르지 않은 가격입니다.");
        }
    }
}
