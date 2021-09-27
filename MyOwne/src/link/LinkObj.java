package link;

import java.util.UUID;

public class LinkObj implements Comparable<LinkObj> {
	String key = UUID.randomUUID().toString();
	int posx;
	int posy;

	public LinkObj(int x, int y) {
		posx = x;
		posy = y;
	}

	@Override
	public int compareTo(LinkObj o) {
		if (o.posx == this.posx) {
			return this.posy - o.posy;
		} else {
			return this.posx - o.posx;
		}
	}
}
