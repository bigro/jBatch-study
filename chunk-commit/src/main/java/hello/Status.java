package hello;

public class Status {
    private String status;

    public Status() {
    }

    public Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "status='" + status + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }
}