package people;

import java.util.Objects;

public class PersonAddress {

    private int id;
    private int person_id;
    private int address_id;

    public PersonAddress(int id, int person_id, int address_id) {
        this.id = id;
        this.person_id = person_id;
        this.address_id = address_id;
    }

    public int getId() {
        return id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public static PersonAddressBuilder builder() {
        return new PersonAddressBuilder();
    }

    public static class PersonAddressBuilder {
        private int id;
        private int person_id;
        private int address_id;

        public PersonAddressBuilder id(int id) {
            this.id = id;
            return this;
        }

        public PersonAddressBuilder person_id(int person_id) {
            this.person_id = person_id;
            return this;
        }

        public PersonAddressBuilder address_id(int address_id) {
            this.address_id = address_id;
            return this;
        }

        public PersonAddress build() {
            return new PersonAddress(id, person_id, address_id);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonAddress that = (PersonAddress) o;
        return id == that.id &&
                person_id == that.person_id &&
                address_id == that.address_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person_id, address_id);
    }

    @Override
    public String toString() {
        return "PersonAddress{" +
                "id=" + id +
                ", person_id=" + person_id +
                ", address_id=" + address_id +
                '}';
    }
}
