package org.leadfar.raiden.model;

import org.leadfar.raiden.utils.CollidersConfiguration;

public class ColliderChain {
	private Entry current ;
	private Entry head;
	private static final ColliderChain chain=new ColliderChain();
	private class Entry {
		Collider c;
		Entry next;
	}

	private  ColliderChain() {
		
		head = new Entry(); // 没有用的头结点
		 current = head; // 可以移动的当前结点
//		for (int i = 0; i < 2; i++) {
//			Entry e = new Entry();
//			switch (i) {
//			case 0:
//				e.c = new HeroChangeFireStrategyCollider();
//				break;
//			case 1:
//				e.c = new HeroBloodUpObjectCollider();
//				break;
//			}
//			e.next = null;
//			current.next = e;
//			current = current.next;
//		}
		 for(int i=1;i<=CollidersConfiguration.size();i++){
			 Entry e = new Entry();
			 e.c=CollidersConfiguration.getColliderInstance("C"+i);
			 e.next=null;
			 current.next=e;
			 current = current.next;
			 
		 }
		current=head;
		//System.out.println(current.next);
	}

	public void doCollide(GameObject go1, GameObject go2) {
			if(current==null){
				current=head;
			}
			current=current.next;
			//System.out.println(current);
			if(current!=null){
				current.c.collide(go1, go2,this);
			}
		
	}

	public static ColliderChain getInstance() {
		return chain;
	}
}
