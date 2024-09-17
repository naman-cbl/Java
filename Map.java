import java.util.*;

public class Map<K,V> {
    int bucketsize;
    ArrayList<HashNode<K,V>> bucket;
    int count;

    public Map(){
        bucket = new ArrayList<HashNode<K,V>>();
        bucketsize = 5;
        for(int i=0;i<bucketsize;i++){
            bucket.add(null);
        }
        count = 0;
    }

    private int getIndex(K key){
        int hc = key.hashCode();
        int index = hc % bucketsize;
        return index;
    }

    public int size(){
        return count;
    }

    private double loadFactor(){
        return (1.0)*count/bucketsize;
    }

    private void reHash(){
        ArrayList<HashNode<K,V>> temp = bucket;
        bucket = new ArrayList<HashNode<K,V>>();
        for(int i=0;i<2*bucketsize;i++){
            bucket.add(null);
        }
        bucketsize = 2*bucketsize;
        count = 0;

        for(int i=0;i<temp.size();i++){
            HashNode<K,V> head = temp.get(i);

            while(head != null){
                insert(head.key, head.value);
                head = head.next;
            }
        }
    }

    public void insert(K key, V value){
        int index = getIndex(key);
        HashNode<K,V> head = bucket.get(index);

        while(head != null){
            if(key.equals(head.key)){
                head.value = value;
                return;
            }
            head = head.next;
        }

        head = bucket.get(index);
        HashNode<K,V> newNode = new HashNode<>(key,value);
        newNode.next = head;
        bucket.set(index,newNode);
        count++;

        double loadFactor = (1.0)*count/bucketsize;
        if(loadFactor >= 0.7){
            reHash();
        }

    }

    public V getValue(K key){
        int index = getIndex(key);
        HashNode<K,V> head = bucket.get(index);

        while(head != null){
            if(key.equals(head.key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V delete(K key){
        int index = getIndex(key);
        HashNode<K,V> head = bucket.get(index);
        HashNode<K,V> prev = null;
        while(head != null){
            if(key.equals(head.key)){
                if(prev == null){
                    bucket.set(index,head.next);
                }else{
                    prev.next = head.next;
                }
                count--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
   
        Map<String,Integer> map = new Map<>();
        System.out.println(map.loadFactor());

        for(int i=0;i<25;i++){
            map.insert("abc"+i,i);
            System.out.println(map.loadFactor());
        }
        map.insert("abc",5);
        map.insert("def",7);
        
        // System.out.println(map.size());
        // System.out.println(map.getValue("def"));

        map.delete("abc2");
        map.delete("abc22");
        
        // System.out.println(map.size());
        // System.out.println(map.getValue("abc"));

        for(int i=0;i<25;i++){
            System.out.println("abc"+i +":"+ map.getValue("abc"+i));
            
        }
    }

}
    
