package rocks.zipcode.io.quiz3.collections;

import rocks.zipcode.io.quiz3.objectorientation.enums.LabStatus;

import java.util.*;

/**
 * @author leon on 10/12/2018.
 */
public class Student {

    private Map<Lab, LabStatus> map;

    public Student() {
        map = new HashMap<>();
    }

    public Student(Map<Lab, LabStatus> map) {
        this.map = map;
    }

    public Lab getLab(String labName) {
        Lab requested = null;
        for (Lab lab: map.keySet()) {
            if (lab.getName() == labName) {
                requested = lab;
            }
        }
        return requested;
    }

    public void setLabStatus(String labName, LabStatus labStatus) {
        Lab lab = getLab(labName);
        if (map.containsKey(lab)) {
            map.put(getLab(labName), labStatus);
        } else {
            throw new UnsupportedOperationException("Lab has not been forked.");
        }
    }


    public void forkLab(Lab lab) {
        map.put(lab, LabStatus.PENDING);
    }

    public LabStatus getLabStatus(String labName) {
        return map.get(getLab(labName));
    }

    @Override
    public String toString() {
        String str = "";
        Map<Lab, LabStatus> sortedMap = new TreeMap<>(
                Comparator.comparing(Lab::getName)
        );
        sortedMap.putAll(map);
        for (Map.Entry<Lab, LabStatus> entry: sortedMap.entrySet()) {
            str += String.format("%s > %s\n", entry.getKey().getName(), entry.getValue().toString());
        }
        return str.trim();
    }
}
