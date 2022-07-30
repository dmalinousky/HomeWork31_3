import java.util.Comparator;

public class RequestComparator implements Comparator<Request> {
    @Override
    public int compare(Request o1, Request o2) {
        if (o2.getLevel().ordinal() > o1.getLevel().ordinal()) {
            return 1;
        } else if (o2.getLevel().ordinal() < o1.getLevel().ordinal()) {
            return -1;
        } else if (o2.getLevel().ordinal() == o1.getLevel().ordinal()) {
            if (o2.getTimeOfRequest().before(o1.getTimeOfRequest())) {
                return 1;
            } else if ((o2.getTimeOfRequest().after(o1.getTimeOfRequest()))) {
                return -1;
            } else {
                return -1;
            }
        }
        return -1;
    }
}
