package mission;

public class Customer {

    private long id;
    private String name;
    private String address;
    private String phoneNumber;

    public Customer(final long id, final String name, final String address, final String phoneNumber) {
        validateCustomer(name, address, phoneNumber);
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    private void validateCustomer(final String name, final String address, final String phoneNumber) {
        validateName(name);
        validateAddress(address);
        validatePhoneNumber(phoneNumber);
    }

    private void validateName(final String name) {
        if (name.isBlank()) {
            throw new RuntimeException("이름이 존재하지 않습니다.");
        }
    }

    private void validateAddress(final String address) {
        if (address.isBlank()) {
            throw new RuntimeException("주소가 존재하지 않습니다.");
        }
    }

    private void validatePhoneNumber(final String phoneNumber) {
        if (phoneNumber.isBlank()) {
            throw new RuntimeException("핸드폰 번호가 존재하지 않습니다.");
        }
    }
}
