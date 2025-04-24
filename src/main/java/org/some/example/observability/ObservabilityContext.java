package org.some.example.observability;

import java.util.HashMap;
import java.util.Map;

public class ObservabilityContext {

    private static ThreadLocal<Data> contextHolder = ThreadLocal.withInitial(Data::new);

    public static Data getContext() {
        return contextHolder.get();
    }

    public static void setId(String key, String value) {
        contextHolder.get().ids.put(key, value);
    }

    public static void clear() {
        contextHolder.remove();
    }

    private static class Data {
        public Map<String, String> ids = new HashMap<>();

        @Override
        public String toString() {
            return "Data{" +
                    "ids=" + ids +
                    '}';
        }
    }
}
