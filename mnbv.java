package INS;

import java.util.*;
class cipher{
    public static void Encryption(String text,Integer n){
        String ciphertext = "";
        char alphabet;
        for(int i=0; i < text.length();i++) 
        {
            alphabet=text.charAt(i);
            

            if(alphabet >= 'a' && alphabet <= 'z') {
                alphabet = (char)(alphabet - n);
                if(alphabet > 'z')
                 {
                    alphabet = (char)(alphabet+'a'+'z'+1);
                 }
             ciphertext = ciphertext + alphabet;
            }
            else if(alphabet >= 'A' && alphabet <= 'Z') {
                alphabet = (char) (alphabet - n);    
                   
                
                if(alphabet > 'Z') {
                    
                    alphabet = (char) (alphabet+'A'+'Z'+1);
                }
                ciphertext = ciphertext + alphabet;
               } 
        }
        System.out.println(" Decoded Text : " + ciphertext);
    }
    public static void Decryption(String text,Integer n){
        String ciphertext = "";
        char alphabet;
        for(int i=0; i < text.length();i++) 
        {
            alphabet=text.charAt(i);
            

            if(alphabet >= 'a' && alphabet <= 'z') {
                alphabet = (char)(alphabet + n);
             
                if(alphabet > 'z')
                 {
                    alphabet = (char)(alphabet+'a'-'z'-1);
                 }
             ciphertext = ciphertext + alphabet;
            }
            else if(alphabet >= 'A' && alphabet <= 'Z') {
                alphabet = (char) (alphabet + n);    
                   
                
                if(alphabet > 'Z') {
                    
                    alphabet = (char) (alphabet+'A'-'Z'-1);
                }
                ciphertext = ciphertext + alphabet;
               } 
        }
        System.out.println(" Encoded Text : " + ciphertext);
    }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter Text");
    String text=sc.nextLine();
    System.out.println("Enter the shift factor");
    int n = sc.nextInt();
    // int n = Integer.parseInt(sc.nextLine());
    // System.out.println("Do you want to Encode or Decode the message??");
    System.out.println("To Encode the message press '1' and to Decode the message press '2'.");
    int ans = sc.nextInt();
    

    switch(ans){
        case 1:
        Decryption(text, n);
         
        break;

        case 2:
        Encryption(text, n);
        break;

        default:System.out.println("Invalid Input!");  

        
    }
   
   }
}
