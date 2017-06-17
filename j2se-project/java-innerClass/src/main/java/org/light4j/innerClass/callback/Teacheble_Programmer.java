package org.light4j.innerClass.callback;

/**
 * 下面的类Teacheble_Programmer只有一个work方法,这个work方法只能进行"教学",不可以进行"编程"。
 * 但实际需要Teacheble_Programmer类里即包含"教学"的work方法,也包含"编程"的work方法。
 *
 */
public class Teacheble_Programmer extends Programmer implements Teachable {
	@Override
	public void work() {
		System.out.println(getName() + "教师在讲台上讲解...");
	}
}
