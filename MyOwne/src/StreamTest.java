import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
//		test1();
//		for (int i = 0; i < 5; i++)
//			testSpeed();
//		testFilter();
		joining();
//		List<String> list=new ArrayList<>();
//		list.add("1");
//		list.add("2");
//		list.add("3");
//		int i=0;
//		System.out.println(list.get(i++));
//		System.out.println(list.get(i++));
//		System.out.println(list.get(i++));
	}

	/**
	 * 初始化stream
	 */
	private static void sum() {
		Integer integer = Stream.of(1, 2, 3, 4, 5, 100, 5).reduce(new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer integer, Integer integer2) {
				return integer + integer2;
			}
		}).get();
//		integer.collect(Collectors.toMap(User::getId,User::getName));
		System.out.println(integer);
	}

	private static void joining() {
		String str = Stream.of(new String[] { "1", "2" }).collect(Collectors.joining("--"));
		System.out.println(str);
	}

	private static void initStream() {
		Stream.of(1, 2, 3, 4, 5);
		Stream.generate(Math::random).limit(5);
		Stream.of(new String[] { "1", "2" });
		Arrays.stream(new String[] { "1", "2" });
		new ArrayList<String>().stream();
		new HashMap<String, String>().entrySet().stream().forEach(e -> {
			System.out.println(e.getKey());
		});
	}

	private static void test1() {
		Stream.of(1, 2, 3, 4, 5).filter(e -> e > 3).forEach(System.out::println);
		Stream.of(1, 2, 3, 4, 5).limit(3).forEach(System.out::println);
		Stream.of(1, 2, 3, 4, 5).skip(2).forEach(System.out::println);
		Stream.of(1, 3, 2, 4, 5, 2, 3).distinct().sorted().forEach(System.out::println);
		Stream.of(1, 2, 3, 4, 5).map(e -> e++).forEach(System.out::println);

		boolean allMatch = Stream.of(1, 3, 2, 4, 5, 2, 3).allMatch(e -> e > 2);
		boolean anyMatch = Stream.of(1, 3, 2, 4, 5, 2, 3).anyMatch(e -> e > 2);
		boolean noneMatch = Stream.of(1, 3, 2, 4, 5, 2, 3).noneMatch(e -> e > 2);
		Stream.of(1, 2, 3, 4, 5).max(Integer::compareTo);
		Optional<Integer> min = Stream.of(1, 2, 3, 4, 5).min((e1, e2) -> Integer.compare(e1, e2));
		Optional<Integer> min1 = Stream.of(1, 2, 3, 4, 5).min((e1, e2) -> {
			return e1 - e2;
		});
		Optional<Integer> findAny = Stream.of(1, 2, 3, 4, 5).filter(e -> e > 3).findAny();
		Optional<Integer> findFirst = Stream.of(1, 2, 3, 4, 5).filter(e -> e > 3).findFirst();
		long count = Stream.of(1, 2, 3, 4, 5).filter(e -> e > 2).count();

	}

	private static void test2() {
	}

	private static void testSpeed() {
		List<UUID> list = new ArrayList<>();
		long currentTimeMillis = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			list.add(UUID.randomUUID());
		}
		list.sort((o1, o2) -> o1.compareTo(o2));
		System.out.println("FOR======" + (System.currentTimeMillis() - currentTimeMillis));
		currentTimeMillis = System.currentTimeMillis();
		Stream<UUID> generateA = Stream.generate(() -> UUID.randomUUID()).limit(10000);
		generateA.sorted((o1, o2) -> o1.compareTo(o2));
		System.out.println("Stream======" + (System.currentTimeMillis() - currentTimeMillis));
		System.out.println("========================================================");
	}

	private static void testConcat() {
		System.out.println(Stream.concat(Stream.of(1, 4, 2).sorted(), Stream.of(3, 5).sorted()).map(String::valueOf)
				.collect(Collectors.joining(",")));

	}

	private static void testPeek() {
		Stream.of(1, 2, 3, 4, 5).peek(integer -> System.out.println("accept:" + integer)).forEach(System.out::println);
	}

	private static void testMax() {
		System.out.println(Stream.of(1, 3, 4, 2, 5, 7, 6).max((o1, o2) -> o1 - o2).get());
		System.out.println(Stream.of(1, 3, 4, 2, 5, 7, 6).min((o1, o2) -> o1 - o2).get());
	}

	private static void testMap() {
		Stream<UUID> stream = Stream.generate(() -> UUID.randomUUID()).limit(10000);
		stream.map(id -> id.toString());
	}

	private static void testFilter() {
		Optional<Integer> first = Stream.of(1, 2, 3, 4, 5).filter(i -> i == 1).findFirst();
		if (first.isPresent()) {
			System.out.println(first.get());
		} else {
			System.out.println("木有");
		}
	}
}
