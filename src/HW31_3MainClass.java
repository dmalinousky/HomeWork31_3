import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HW31_3MainClass {
    public static void main(String[] args) throws Exception {
        // Creating default requests
        Request request1 = new Request("User_1", Priority.LOW, Calendar.getInstance().getTime());
        Request request2 = new Request("User_2", Priority.HIGH, Calendar.getInstance().getTime());
        Request request3 = new Request("User_3", Priority.EXTREME, Calendar.getInstance().getTime());
        Request request4 = new Request("User_4", Priority.MEDIUM, Calendar.getInstance().getTime());
        Request request5 = new Request("User_5",Priority.MEDIUM, Calendar.getInstance().getTime());

        // Set which sets priority operating (press "3" in menu to see)
        RequestComparator requestComparator = new RequestComparator();
        TreeSet<Request> requestTreeSet = new TreeSet<>(requestComparator);
        requestTreeSet.add(request1);
        requestTreeSet.add(request2);
        requestTreeSet.add(request3);
        requestTreeSet.add(request4);
        requestTreeSet.add(request5);

        // Set which just shows stats (order in which sets get into it)
        LinkedHashSet<Request> stats = new LinkedHashSet<>();
        stats.add(request1);
        stats.add(request2);
        stats.add(request3);
        stats.add(request4);
        stats.add(request5);

        // Menu caller + catching exceptions
        try {
            getMenu(requestTreeSet, stats);
        } catch (Exception exception) {
            System.out.println("Incorrect data!\n");
            getMenu(requestTreeSet, stats);
        }

    }

    // Menu method
    public static void getMenu(TreeSet<Request> requestTreeSet, LinkedHashSet<Request> stats) throws Exception {
        System.out.println("""
                Enter what you want to do:
                1. Add request.
                2. Get stats.
                3. Exit and show how the requests will be operated.""");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 1 -> {
                    Request request = addNewRequest();
                    requestTreeSet.add(request);
                    stats.add(request);
                    getMenu(requestTreeSet, stats);
                }
                case 2 -> {
                    showStats(stats);
                    getMenu(requestTreeSet, stats);
                }
                case 3 -> {
                    requestTreeSet.forEach(x -> System.out.println(x));
                    System.out.println("Exiting...");
                }
            }
        } catch (Exception exception) {
            System.out.println("Incorrect data!\n");
            getMenu(requestTreeSet, stats);
        }
    }

    // Request-creator
    public static Request addNewRequest() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Request request = new Request();
        System.out.println("Provide user's name:");
        request.setName(reader.readLine());
        request.setTimeOfRequest(Calendar.getInstance().getTime());
        System.out.println("""
                Choose the priority level for request.
                1. Low.
                2. Medium.
                3. High.
                4. Extreme.""");
        int choice = Integer.parseInt(reader.readLine());
        switch (choice) {
            case 1 -> request.setLevel(Priority.LOW);
            case 2 -> request.setLevel(Priority.MEDIUM);
            case 3 -> request.setLevel(Priority.HIGH);
            case 4 -> request.setLevel(Priority.EXTREME);
        }
        return request;
    }

    // Stats-shower
    public static void showStats(LinkedHashSet<Request> stats) {
        stats.forEach(x -> {
            System.out.println("Name: " + x.getName());
            System.out.println("Priority: " + x.getLevel());
            System.out.println("Time of request: " + x.getTimeOfRequest());
            System.out.println();
        });
    }
}
