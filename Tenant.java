public class Tenant {

        private String name;
        private int age;
        private boolean isPermanent;

        public Tenant(String name, int age, boolean isPermanent) {
            this.name = name;
            this.age = age;
            this.isPermanent = isPermanent;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public boolean isPermanent() {
            return isPermanent;
        }

        public void setPermanent(boolean permanent) {
            isPermanent = permanent;
        }

        public void tanentInfo() {
            System.out.println("Name: " + name + "\nAge: " + age + "\nPermanent: " + isPermanent);
        }
    }