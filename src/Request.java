import java.util.Date;

public class Request {
    private String name;
    private Priority level;
    private Date timeOfRequest;

    public Request(String name, Priority level, Date timeOfRequest) {
        this.name = name;
        this.level = level;
        this.timeOfRequest = timeOfRequest;
    }

    public Request() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priority getLevel() {
        return level;
    }

    public void setLevel(Priority level) {
        this.level = level;
    }

    public Date getTimeOfRequest() {
        return timeOfRequest;
    }

    public void setTimeOfRequest(Date timeOfRequest) {
        this.timeOfRequest = timeOfRequest;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", timeOfRequest=" + timeOfRequest +
                '}';
    }
}
