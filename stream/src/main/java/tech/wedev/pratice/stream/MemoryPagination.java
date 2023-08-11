package tech.wedev.pratice.stream;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryPagination {
    public static <T> List<T> pagination(List<T> records, int pageNum, int pageSize) {
        if (CollectionUtils.isEmpty(records)) {
            return Collections.emptyList();
        }
        int totalCount = records.size();
        int remainder = totalCount % pageSize;
        int pageCount = (remainder > 0) ? totalCount / pageSize + 1 : totalCount / pageSize;
        if (remainder == 0) {
            return records.stream().skip((pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        } else {
            if (pageNum == pageCount) {
                return records.stream().skip((pageNum - 1) * pageSize).limit(totalCount).collect(Collectors.toList());
            } else {
                return records.stream().skip((pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList();
        Collections.addAll(myList, "q", "w", "e", "r");
        List<String> pagination = pagination(myList, 2, 2);
        for (String i : pagination) {
            System.out.println(i);
        }
    }
}
