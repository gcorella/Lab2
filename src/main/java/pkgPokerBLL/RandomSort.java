package pkgPokerBLL;

import java.util.Random;

public class RandomSort {    
    private Random random = new Random();    
    private static final int SIZE = 52;    
    private int[] positions = new int[SIZE];    
        
	public int[] getPositions() {
		return positions;
	}


	public RandomSort() {    
        for(int index=0; index<SIZE; index++) {    
            positions[index] = index;    
        }    
    }    
        
    public RandomSort changePosition() {    
        for(int index=SIZE-1; index>=0; index--) {    
            exchange(random.nextInt(index+1), index);    
        }
		return this;    
    }    
        
    private void exchange(int p1, int p2) {    
        int temp = positions[p1];    
        positions[p1] = positions[p2];    
        positions[p2] = temp; 
    }    
    
    public static void main(String[] args) {    
    	
    }    
} 