package com.in;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.locks.ReentrantLock;

public class TransactionHistory implements List<Transaction>
{
private final List<Transaction> transactions =new ArrayList<>();
private final ReentrantLock lock = new ReentrantLock();


     @Override
	public boolean add(Transaction transaction)
	{
		lock.lock();
		try
		{
			return transactions.add(transaction);
		}finally
		{
			lock.unlock();
		}
	}
     
     @Override
    public Transaction get(int index)
    {
    	lock.lock();
    	try {
    		return transactions.get(index);
    	
    	}finally
    	{
    		lock.unlock();
    	}
    }
    
     @Override
    public int size()
    {
    	lock.lock();
    	try
    	{
    		return transactions.size();
    	}finally {
    		lock.unlock();
    	}
    }
    
     
     
    @Override
    public Transaction remove(int index)
    {
    	lock.lock();
    	try{
            return transactions .remove(index);
    	}  finally {
    		lock.unlock();
    	}
    }
    
    @Override
    
    public void add(int index, Transaction element)
    {
    	lock.lock();
    	try
    	{
    		transactions.add(index,element);
    		
    	}
    	finally
    	{
    		lock.unlock();
    
            
    	}
    }
    
    @Override
    public boolean addAll(Collection <? extends Transaction> c)
    {
    	lock.lock();
    	try
    	{
    		return transactions.addAll(c);
    		
    	}finally
    	{
    		lock.unlock();
    	}
    }
    
    @Override
    public boolean addAll(int index, Collection<? extends Transaction> c) {
        lock.lock();
        try {
            return transactions.addAll(index, c);
        } finally {
            lock.unlock();
        }
    }
    
    @Override
     public void clear()
     {
    	 lock.lock();
    	 try
    	 {
    		 transactions.clear();
    	 }finally {
			lock.unlock();
		}
     }
    
    @Override
    public boolean contains(Object o)
    {
    	lock.lock();
    	try
    	{
    		return transactions.contains(o);
    		
    	}
    	finally
    	{
    		lock.unlock();
    	}
    }
     
    @Override
    public boolean containsAll(Collection<?> c) {
        lock.lock();
        try {
            return transactions.containsAll(c);
        } finally {
            lock.unlock();
        }
    }
    @Override
    public boolean equals(Object o) {
        lock.lock();
        try {
            return transactions.equals(o);
        } finally {
            lock.unlock();
        }
    }
    @Override
    public int hashCode() {
        lock.lock();
        try {
            return transactions.hashCode();
        } finally {
            lock.unlock();
        }
    }
    @Override
    public int indexOf(Object o) {
        lock.lock();
        try {
            return transactions.indexOf(o);
        } finally {
            lock.unlock();
        }
    }
    @Override
    public boolean isEmpty() {
        lock.lock();
        try {
            return transactions.isEmpty();
        } finally {
            lock.unlock();
        }
    }
    @Override
    public Iterator<Transaction> iterator() {
        return transactions.iterator(); // Not thread-safe iteration
    }
    
    @Override
    public int lastIndexOf(Object o) {
        lock.lock();
        try {
            return transactions.lastIndexOf(o);
        } finally {
            lock.unlock();
        }
    }
    
    @Override
    public ListIterator<Transaction> listIterator() {
        return transactions.listIterator(); // Not thread-safe iteration
    }

    @Override
    public ListIterator<Transaction> listIterator(int index) {
        return transactions.listIterator(index); // Not thread-safe iteration
    }
    
    @Override
    public boolean remove(Object o) {
        lock.lock();
        try {
            return transactions.remove(o);
        } finally {
            lock.unlock();
        }
    }
    
    @Override
    public Transaction set(int index, Transaction element) {
        lock.lock();
        try {
            return transactions.set(index, element);
        } finally {
            lock.unlock();
        }
    }
    
    @Override
    public List<Transaction> subList(int fromIndex, int toIndex) {
        lock.lock();
        try {
            return transactions.subList(fromIndex, toIndex);
        } finally {
            lock.unlock();
        }
    }
    
    @Override
    public Object[] toArray() {
        lock.lock();
        try {
            return transactions.toArray();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        lock.lock();
        try {
            return transactions.toArray(a);
        } finally {
            lock.unlock();
        }
    }

	@Override
	public boolean removeAll(Collection<?> c) {
		
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		
		return false;
	}
	
}
