package com.base;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CollectionTest extends AbstractCollection<Object>{
	
public static void main(String[] args) {
		CollectionTest col = new CollectionTest();
		col.add( "first" );
		col.add( "second" );
		col.add( "third" );
		col.add( "first" );
		
		System.out.println( "size(): " + col.size() );
		System.out.println( "contains(): " + col.contains("second") );
		System.out.println( "toString(): " + col );
		
		System.out.print( "iterator: " );
		Iterator<?> iter = col.iterator();
		while( iter.hasNext() ) // 이터레이터의 다음 요소가 없을 때까지 반복
			System.out.print( iter.next() + ", " );
		System.out.println();
		
		System.out.print( "toArray(): " );
		Object[] array = col.toArray();
		for( int i = 0; i < array.length; i++)
			System.out.print( array[i] + ", " );
		System.out.println();
		
		col.remove( "first" );
		System.out.println( "remove(): " + col );
		
		CollectionTest col2 = new CollectionTest();
		col2.add( "third" );
		col2.add( "fourth" );
		
		System.out.println( "containsAll(): " + col.containsAll(col2) );
		col.addAll( col2 );
		System.out.println( "addAll(): " + col );
		
		col.removeAll( col2 );
		System.out.println( "removeAll(): " + col );
		
		col.clear();
		System.out.println( col.size() );
		System.out.println( "clear(): " + col );
		
	}

	private int _size = 0;
	private Object[] data = new Object[100];
		
	public int size()
	{
		return _size;
	}
	
	public boolean add(Object o)
	{
		data[_size++] = o;
		return true;
	}
	
	public Iterator iterator()
	{
		return new Iterator(){
			private int current = -1;
			
			public boolean hasNext() {
				return current + 1 < _size;
			}
			
			public Object next() {
				current++;
				if(_size <= current)
					throw new NoSuchElementException();
					return data[current];
			}
			
			public void remove() {
				if(current ==-1 || _size <= current)
					throw new NoSuchElementException();
				for(int i = current+1; i<_size;i++)
					data[i-1] = data[i];
				current--;
				_size--;
				
			}
		};
	}
}
