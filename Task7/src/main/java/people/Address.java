package people;

import java.util.Objects;

public class Address {

    private int id;
    private String street;
    private int house;

    public Address(int id, String street, int house) {
        this.id = id;
        this.street = street;
        this.house = house;
    }

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }

    public static AddressBuilder builder() {
        return new AddressBuilder();
    }

    public static class AddressBuilder {
        private int id;
        private String street;
        private int house;

        public AddressBuilder id(int id) {
            this.id = id;
            return this;
        }

        public AddressBuilder street(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder house(int house) {
            this.house = house;
            return this;
        }

        public Address build() {
            return new Address(id, street, house);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id &&
                house == address.house &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, house);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", house=" + house +
                '}';
    }
}