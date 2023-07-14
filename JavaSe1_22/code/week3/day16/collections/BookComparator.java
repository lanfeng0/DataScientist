package org.example.week3.day16.collections;

import java.util.Comparator;

//外部比较器
public class BookComparator  implements Comparator<BookEntity> {

	@Override
	public int compare(BookEntity o1, BookEntity o2) {
		if(o1.getPrice()>o2.getPrice()) {
			return 1;
		}else if (o1.getPrice()==o2.getPrice()) {
			return 0;
		}else {
			return -1;	
		}
	}

}
