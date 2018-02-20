package hello;

public class Status {
    private int id;
    private String status;

    public Status() {
    }

    public Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }
}