package zookeeper;

public class ZookeeperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gorilla g1 = new Gorilla(100);
		System.out.println(g1.throwSomething());
		System.out.println(g1.climb());
		System.out.println(g1.eatBananas());
		System.out.println(g1.throwSomething());
		System.out.println(g1.eatBananas());
		System.out.println(g1.throwSomething());
		System.out.println(g1.displayEnergy());


	
	}
}
