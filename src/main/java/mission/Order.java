package mission;

import java.util.List;

public class Order {

    private long id;
    private List<Item> items;
    private Customer customer;

    public Order(final List<Item> items, final Customer customer) {
        validateOrder(items, customer);
        this.items = items;
        this.customer = customer;
    }

    private void validateOrder(final List<Item> items, final Customer customer) {
        if (doesNotHaveItems(items)) {
            throw new RuntimeException("주문 항목이 없습니다.");
        }
        if (doesNotHaveCustomerInfo(customer)) {
            throw new RuntimeException("사용자 정보가 없습니다.");
        }
    }

    public boolean doesNotHaveItems(final List<Item> items) {
        return items.isEmpty();
    }

    public boolean doesNotHaveCustomerInfo(final Customer customer) {
        return customer == null;
    }
}
