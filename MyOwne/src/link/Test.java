package link;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<LinkObj> init0 = init0();
		printList(init0);
	}

//	【1，1】【1，2】【1，3】【1，7】【1，8】【1，9】
//	【2，1】【2，2】【2，3】【2，7】【2，8】【2，9】
//	【3，1】【3，2】【3，3】【3，7】【3，8】【3，9】
//	【6，1】【6，2】【6，3】【6，7】【6，8】【6，9】
//	【7，1】【7，2】【7，3】【7，7】【7，8】【7，9】
	private static List<LinkObj> init0() {
		List<LinkObj> list = new ArrayList<LinkObj>();
		fixList(list, 1, 4, 1, 4);
		fixList(list, 1, 4, 7, 10);
		fixList(list, 6, 8, 1, 4);
		fixList(list, 6, 8, 7, 10);
		return list;
	}

	private static void fixList(List<LinkObj> list, int beginx, int endx, int beginy, int endy) {
		for (int i = beginx; i < endx; i++) {
			for (int j = beginy; j < endy; i++) {
				list.add(new LinkObj(i, j));
			}
		}
	}

	private static void printList(List<LinkObj> list) {
		System.out.println("==========begin==============");
		Collections.sort(list);
		int curx = -1;
		for (LinkObj link : list) {
			if (curx < 0) {
				curx = link.posx;
			} else if (curx != link.posx) {
				System.out.println("");
				curx=link.posx;
			}
			System.out.print("【"+link.posx+","+link.posy+"】");
			System.out.println("/t");

		}
	}
}
