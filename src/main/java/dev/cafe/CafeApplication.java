package dev.cafe;

import dev.cafe.service.OrderProcessor;
import java.io.*;

/**
 * Hello world!
 *
 */
public class CafeApplication {
    public static void main(String[] args) {
    	OrderProcessor processor = new OrderProcessor();
    	
    	while(true) {
    		int result = processor.selectType();
    		
    		if (result == 2 ) {
    			System.out.println("주문이 완료되었습니다");
    			break;
    		}
    	}
    	
    
    }
}