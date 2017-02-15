package com.data;

import java.util.Scanner; 
public class CaesarCipher {
 
 
	// Caesar Encryption Function
		public static String encrypt(String pass) {
		char chars[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','!','@','#','$','%','^','&','(',')','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','+','-','*','/','[',']','{','}','=','<','>','?','_'};
	    String empty = "empty"; 
		    String plainText = pass;
		    String cipher = null;
		    char[] plain = plainText.toCharArray(); 
		    
		    for(int i = 0;i<plain.length;i++){
		        for(int j = 0 ; j<85;j++){
		            if(j<=80){
		                if(plain[i]==chars[j]){
		                    plain[i] = chars[j+5];
		                    break;
		                }  
		            }//End nested If
		            else if(plain[i] == chars[j]){
		                plain[i] = chars [j-81];
		            }  //End else
		         } //End nested for loop 
		      } //End of For loop
		     cipher = String.valueOf(plain);
			 return cipher;
			 
		   }
	
	// Caesar Decryption Function	
		public static String decrypt(String cipherText) {
		char chars[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','!','@','#','$','%','^','&','(',')','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','+','-','*','/','[',']','{','}','=','<','>','?','_'};
	    String cipher = null;
	    String empty = "empty";
	    char[] cipher1 = cipherText.toCharArray();
                  for(int i = 0;i<cipher1.length;i++){
                        for(int j = 0 ; j<85;j++){
                            if(j>=5 && cipher1[i]==chars[j]){
                                cipher1[i] = chars[j-5];
                                break;
                            }
                                if(cipher1[i] == chars[j] && j<5){
                                    cipher1[i] = chars[81+j];
                                    break;
                      }  //End IF
                } //End nested for loop
            } //End of For loop
	    
            cipher=String.valueOf(cipher1);
			return cipher;
        }
}


/*class demosssssss{
	public static void main(String args[]){
		//System.out.println(CaesarCipher.encrypt("qwe123"));
		System.out.println(CaesarCipher.decrypt("v1j678&"));
		
	}
}*/