public class customer {
    private int customer_id;
    private String customer_name;
    private String email;


    public customer(int customer_id, String customer_name, String email) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.email = email;
    }

    // Getter 和 Setter 方法
    public int getId() {
        return customer_id;
    }

    public void setId(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getcustomer_name() {
        return customer_name;
    }

    public void setUsername(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "customer{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}