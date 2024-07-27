package hashmap;

import java.util.*;

public class Solution {
    public static String[] method(String[][] requests) {
        String[] response = new String[requests.length];
        class UserData {
            List<String> files = new ArrayList<>();
            int capacity = 0;

            public UserData(ArrayList<String> files, String capacity) {
                this.files = files;
                this.capacity = Integer.valueOf(capacity);
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof UserData userData)) return false;
                return capacity == userData.capacity && Objects.equals(files, userData.files);
            }

            @Override
            public int hashCode() {
                return Objects.hash(files, capacity);
            }
        }
        Map<String, Integer> map = new HashMap<>();
        Map<String, UserData> userDataMap = new HashMap<>();
        int i = 0;
        for (String[] request : requests) {
            if (request[0].equals("ADD_USER")) {
                String userName = request[1];
                String capacity = request[2];
                if (!userDataMap.containsKey(userName)) {
                    userDataMap.put(userName, new UserData(new ArrayList<>(), capacity));
                    response[i] = capacity;
                } else {
                    response[i] = "";
                }
            } else if (request[0].equals("ADD_FILE_BY_USER")) {
                String userName = request[1];
                String fileName = request[2];
                String size = request[3];
                if (!map.containsKey(fileName)) {
                    if (userDataMap.containsKey(userName) && !userName.equals("admin")) {
                        UserData userData = userDataMap.get(userName);
                        int userCapacity = userData.capacity;
                        if (userCapacity - Integer.valueOf(size) >= 0) {
                            userData.files.add(fileName);
                            userData.capacity = userCapacity - Integer.valueOf(size);
                            map.put(fileName, Integer.valueOf(size));
                            response[i] = size;
                        } else {
                            response[i] = "";
                        }
                    } else {
                        response[i] = "";
                    }
                }
            } else if (request[0].equals("ADD_FILE")) {
                String fileName = request[1];
                String userName = "admin";
                if (!map.containsKey(fileName)) {
                    map.put(fileName, Integer.valueOf(request[2]));
                    userDataMap.computeIfAbsent
                            (userName, k -> new UserData(new ArrayList<>(), -1 + "")).files.add(fileName);
                    response[i] = request[2];
                } else {
                    response[i] = "";
                }
            } else if (request[0].equals("GET_FILE")) {
                String fileName = request[1];
                if (!map.containsKey(fileName)) {
                    response[i] = "";
                } else {
                    response[i] = map.get(fileName).toString();
                }
            } else if (request[0].equals("DELETE_FILE")) {
                String fileName = request[1];
                String userName = "admin";
                if (!map.containsKey(fileName)) {
                    response[i] = "";
                } else {
                    String value = map.get(fileName).toString();
                    List<String> files = userDataMap.get(userName).files;
                    if (!files.contains(fileName)) {
                        response[i] = "";
                    } else {
                        map.remove(fileName);
                        response[i] = value;
                    }
                }
            } else if (request[0].equals("DELETE_FILE_BY_USER")) {
                String fileName = request[1];
                String userName = request[2];
                if (!map.containsKey(fileName)) {
                    response[i] = "";
                } else {
                    String value = map.get(fileName).toString();
                    List<String> files = userDataMap.get(userName).files;
                    if (!files.contains(fileName)) {
                        response[i] = "";
                    } else {
                        map.remove(fileName);
                        response[i] = value;
                    }
                }
            } else if(request[0].equals("MERGE")){
                String user1 = request[1];
                String user2 = request[2];
                if(user1.equals("admin") || user2.equals("admin")){
                    response[i] = "";
                    continue;
                }
                UserData user1Data = userDataMap.get(user1);
                UserData user2Data = userDataMap.get(user2);
                user1Data.files.addAll(user2Data.files);
                user1Data.capacity = (Integer.valueOf(user1Data.capacity) + Integer.valueOf(user2Data.capacity));
                userDataMap.remove(user2);
                response[i] = user1Data.capacity + "";
            }else if (request[0].equals("GET_FILES_BY")) {
                String prefix = request[1];
                String count = request[2];
                String result = map.keySet().stream()
                        .filter(key -> key.startsWith(prefix))
                        .sorted(new Comparator<String>() {
                            @Override
                            public int compare(String o1, String o2) {
                                int val1 = Integer.valueOf(map.get(o1));
                                int val2 = Integer.valueOf(map.get(o2));
                                if (val1 == val2) {
                                    return o1.compareTo(o2);
                                }
                                if (val1 > val2) {
                                    return -1;
                                }
                                ;
                                return 1;
                            }
                        })
                        .limit(Integer.valueOf(count))
                        .reduce("", (a, b) -> a + "," + b + "(" + map.get(b) + ")");
                response[i] = result.substring(1);
            }
            i++;
        }
        return response;
    }

    public static void main(String[] args) {
        String[][] requests = {{"ADD_FILE", "a", "1"},
                {"ADD_FILE", "b", "2"},
                {"ADD_FILE", "a/b", "3"},
                {"ADD_FILE", "a/c", "3"},
                {"ADD_FILE", "a/bc", "4"},
                {"GET_FILE", "a"},
                {"GET_FILE", "a/bcd"},
                {"DELETE_FILE", "b"},
                {"GET_FILES_BY", "a", "2"}};
        String[] response = method(requests);
        System.out.println(Arrays.toString(response));
    }
}
