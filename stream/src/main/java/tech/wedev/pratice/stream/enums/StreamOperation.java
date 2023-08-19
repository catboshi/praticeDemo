package tech.wedev.pratice.stream.enums;

import tech.wedev.pratice.stream.entity.*;
import tech.wedev.pratice.stream.utils.DateUtils;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public enum StreamOperation {

    /**
     * 根据personId属性去重，生成一个新的集合
     *
     * @see <a ref="https://blog.csdn.net/qq_35634181/article/details/108867857?spm=1001.2014.3001.5506"></a>
     */
    DISTINCT {
        @Override
        public void operate() {
            List<User> temperatureList = new ArrayList<>();
            temperatureList.add(User.builder().personId(1).name("张三").build());
            temperatureList.add(User.builder().personId(2).name("李四").build());
            temperatureList.add(User.builder().personId(3).name("王五").build());

            temperatureList.add(User.builder().personId(1).name("张三").build());
            temperatureList.add(User.builder().personId(2).name("王五").build());

            List<User> result = temperatureList.stream()
                    .collect(
                            collectingAndThen(
                                    toCollection(
                                            () -> new TreeSet<>(comparing(User::getPersonId))
                                    ),
                                    ArrayList::new
                            )
                    );

            result.forEach(System.out::println);

        /*
            输出结果为：
                User(personId=1, name=haha)
                User(personId=2, name=haha)
                User(personId=3, name=haha)
            因为TreeSet底层是使用TreeMap进行实现的，传入了根据getPersonId进行比较的比较器
            在判断personId相同时，其比较结果为0，然后就会替换其value值，而key值是不会变化的，
            又因为TreeSet是将传入的元素作为key的，所以使用TreeSet时，当比较器比较的结果相同时，以不会将原来的值替换成比较后的值
         */

        }
    },

    /**
     * @see <a href="https://juejin.cn/s/java%208%20stream%20max%20date%20comparator"></a>
     */
    DATE_COMPARE {
        @Override
        public void operate() {
            List<LocalDate> dates = Arrays.asList(LocalDate.of(2022, 1, 1),
                    LocalDate.of(2022, 2, 1),
                    LocalDate.of(2022, 3, 1));

            LocalDate latestDate = dates.stream()
                    .max(Comparator.naturalOrder())
                    .orElseThrow(NoSuchElementException::new);

            System.out.println("Latest date: " + latestDate);
        }
    },

    /**
     * @see <a href="https://blog.csdn.net/qq_31635851/article/details/120324130?spm=1001.2014.3001.5506">...</a>
     */
    NATURAL_ORDER {
        @Override
        public void operate() {
            List<Integer> numList = Arrays.asList(12, 10, 15, 8, 11);
            numList.stream().sorted(Comparator.naturalOrder()).forEach(n -> System.out.print(n + " "));
            System.out.println("\n-----------");

            List<String> strList = Arrays.asList("Varanasi", "Allahabad", "Kanpur", "Noida");
            strList.stream().sorted(Comparator.naturalOrder()).forEach(s -> System.out.print(s + " "));
            System.out.println("\n-----------");

            List<Student> stdList = Student.getStudentList();
            stdList.stream().sorted(Comparator.naturalOrder()).forEach(s -> System.out.print(s.getName() + " "));
            System.out.println("\n-----------");

            //reverse order of natural order using Comparator.reverseOrder()
            stdList = Student.getStudentList();
            stdList.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s.getName() + " "));
        }
    },

    /**
     * @see <a href="https://blog.csdn.net/weixin_43735471/article/details/121345569?spm=1001.2014.3001.5506">...</a>
     */
    MAX {
        @Override
        public void operate() {
            ProductVO xiaomi = new ProductVO();
            xiaomi.setName("小米8");
            xiaomi.setBrand("小米");
            xiaomi.setPrice(3000);

            ProductVO huawei = new ProductVO();
            huawei.setName("华为8");
            huawei.setBrand("华为");
            huawei.setPrice(4000);

            ProductVO zhongxing = new ProductVO();
            zhongxing.setName("中兴8");
            zhongxing.setBrand("中兴");
            zhongxing.setPrice(5000);
            ArrayList<ProductVO> productVOS = new ArrayList<>();
            productVOS.add(xiaomi);
            productVOS.add(huawei);
            productVOS.add(zhongxing);
            //取出价格最低的手机
            ProductVO productVO = productVOS.stream().min(Comparator.comparing(ProductVO::getPrice)).get();
            System.out.println(productVO);
        }
    },

    /**
     * 单条件筛选： Stream 分组后找出年纪最大的用户
     *
     * @see <a href="https://blog.csdn.net/m0_55694435/article/details/131228720">...</a>
     */
    MAX2 {
        @Override
        public void operate() {
            Boss user1 = new Boss("张三", 12, 150, 1);
            Boss user2 = new Boss("李四", 13, 150, 1);
            Boss user3 = new Boss("王五", 12, 140, 0);
            Boss user4 = new Boss("赵六", 11, 140, 0);
            // 将User对象转为List<Boss>
            List<Boss> users = Arrays.asList(user1, user2, user3, user4);
            /**
             *  key我用的是 Boss::getSex  性别
             *  Function.identity() 保持stream中的对象作为value ，你用User::getName map的 value 便是 String（name）
             *  （a,b）-> a.getAge() > b.getAge() ? a : b  就是筛选出分组后年纪最大的一个 Boss 对象作为 value
             */
            Map<Integer, Boss> map = users.stream().collect(
                    Collectors.toMap(Boss::getSex, Function.identity(), (a, b) -> a.getAge() > b.getAge() ? a : b)
            );
            for (Integer key : map.keySet()) {
                System.out.println(map.get(key));
            }
        }
    },

    /**
     * 多条件筛选：Stream 分组后的找到年纪最大的之后再筛选出身高最高的
     */
    MAX3 {
        @Override
        public void operate() {
            Boss user1 = new Boss("张三", 12, 150, 1);
            Boss user2 = new Boss("李四", 13, 150, 1);
            Boss user3 = new Boss("王五", 12, 140, 0);
            Boss user4 = new Boss("赵六", 11, 140, 0);
            // 增加两个人做筛选
            Boss user5 = new Boss("陆七", 12, 150, 0);
            Boss user6 = new Boss("田八", 13, 160, 1);

            List<Boss> users = Arrays.asList(user1, user2, user3, user4,user5,user6);

            /**
             *  筛选出男生、女生中 年纪最大、身高最高的一个
             */
            Map<Integer, Boss> map = users.stream().collect(
                    Collectors.toMap(Boss::getSex, Function.identity(), (a, b) ->
                            a.getAge() > b.getAge() ?
                                    a : a.getAge() == b.getAge() ? a.getHeight() > b.getHeight() ? a : b : b)
            );
            for (Integer key : map.keySet()) {
                System.out.println(map.get(key));
            }
        }
    },

    /**
     * @see <a href="https://blog.csdn.net/Fanzongshen/article/details/125732366?spm=1001.2014.3001.5506">...</a>
     */
    NEWEST {
        @Override
        public void operate() throws Exception {
            List<Teacher> list = new ArrayList<>();
            list.add(new Teacher("zhangsan",10, DateUtils.formatStrToDate("2022-07-07 22:20:41")));
            list.add(new Teacher("zhangsan",30,DateUtils.formatStrToDate("2022-07-07 22:20:43")));
            list.add(new Teacher("zhangsan",20,DateUtils.formatStrToDate("2022-07-07 22:20:42")));
            list.add(new Teacher("zhangsan",40,DateUtils.formatStrToDate("2022-07-07 22:20:46")));
            list.add(new Teacher("lisi",30,DateUtils.formatStrToDate("2022-07-07 22:20:43")));

            Map<String, List<Teacher>> map = list.stream().collect(Collectors.groupingBy(Teacher::getName));
            map.keySet().forEach(key -> {
                List<Teacher> students = map.get(key);
                //int maxAge = l.stream().map(s -> s.getAge()).mapToInt(Integer::intValue).max().getAsInt();
                List<Date> dateList = students.stream().map(Teacher::getBirth).collect(Collectors.toList());
                Date date = dateList.stream().max(Date::compareTo).get();
                List<Teacher> maxAgeStu = students.stream().filter(s -> s.getBirth().getTime() == date.getTime()).collect(Collectors.toList());
                System.out.println(maxAgeStu);
            });
        }
    },
    ;

    public abstract void operate() throws Exception;
}
