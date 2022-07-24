package Assigiment2.Student;

public class product {
        int id;
        String name;
        double price;

        public product(int id) {
            this.id = id;
        }

        public product(String name) {
            this.name = name;
        }

        public product(int id, String name, double price) {
                this.id = id;
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

