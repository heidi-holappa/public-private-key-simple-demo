public class publicPrivateKeyMain {
    
    public static void main(String[] args) {
        // This example is a Java code based directly on the Question 3.3 of University of Helsinki application exam 2018
        // The purpose is to help to understand how a simple public/private key encryption works.
        // This is solely meant for educational purposes and I do not claim any ownership for the content. 
        // Note that this example only works with whole numbers Z that fill the requirement 1 < Z < n 
        // 0, 1 one 'work' too, but all values are the same, so the level of encryption is a bit lacking
                
        System.out.println("WELCOME TO PUBLIC/PRIVATE KEY DEMO.");
        Scanner reader = new Scanner(System.in);
               
        
        // We start by choosing two prime numbers p and q. Numbers used in the exam task are 3 and 11
        // n is the multiplication of these selected numbers

        int p = 3;
        int q = 11;
        
        int n = p*q;
               
        // Next we choose d in a way that the numbers d, (p-1) and (d-1) do not share in common divisors. 
        // (p-1) = 2 and (a-1) = 10. We choose d to be 3, since it has no common divisors with 2 and 10. 
        
        int d = 3; 
        
        
        // We select number x in a way that for the formula (d*x) / ((p-1)*(q-1)) the remainder is 1. 
        // In this instance (p-1)*(q-1) = 2 * 10 = 20. For the calculation 21/20 the remainder is 1. 
        // d * x = 21 => 3 * x = 21 => x = 7. 
        
        int x = 7; 
        
        System.out.println("PARAMETERS:");
        System.out.println("p = " + p);
        System.out.println("q = " + q);
        System.out.println("n = " + n);
        System.out.println("d = " + d);
        System.out.println("x = " + x);
        System.out.println("");
        
        
        while (true) {
        
            System.out.println("CHOOSE ACTION: ");
            System.out.println("1. ENCRYPT MESSAGE");
            System.out.println("2. DECRYPT CODED MESSAGE");
            System.out.println("3. LIST ALL POSSIBLE ENCRYPTIONS AND CHECK VALIDITY");
            System.out.print("> ");
            int action = Integer.valueOf(reader.nextLine());
            
            
            if (action == 1) {
                
                           
                System.out.println("INPUT CODE THAT NEEDS TO BE ENCRYPTED ");
                System.out.print("> ");
                int input = Integer.valueOf(reader.nextLine());

                // Check that input valid (0 <= input < n)
                if (input < 0 || input >= 33) {
                    System.out.println("ERROR: CODE C MUST BE 0 <= C < " + n + ".");
                    continue; 
                }
                
                // The message is encrypted by first raising the message to the exponent of x (x=7) and by taking the remainder of message^x/n.        

                long encryptionPhaseOne = (long)Math.pow(input, x);
                System.out.println("MESSAGE TO THE EXPONENT OF X: " + encryptionPhaseOne);
                long encryptionPhaseTwo = encryptionPhaseOne % n;
                System.out.println("ENCRYPTED MESSAGE (REMAINDER OF MESSAGE^X/N): " + encryptionPhaseTwo);


                // Encrypted message is decrypted in the same way, 
                // but this time raising the message to the exponent of d and taking the remainder of encryptedMessage^d/n. 

                long decryptionPhaseOne = (long)Math.pow(encryptionPhaseTwo, d);
                System.out.println("ENCRYPTEDMESSAGE TO THE EXPONENT OF D: " + decryptionPhaseOne);
                long decryptionPhaseTwo = decryptionPhaseOne % n; 
                System.out.println("DECRYPTED MESSAGE (REMAINDER OF ENCRYPTEDMESSAGE^D/N): " + decryptionPhaseTwo);
                System.out.println("");
                System.out.println("ENCRYPTED MESSAGE " + encryptionPhaseTwo);
                boolean compareOriginalToDecrypted = false;
                if (decryptionPhaseTwo == input) {
                    compareOriginalToDecrypted = true;
                }
                System.out.println("DECRYPTED MESSAGE MATCHES ORIGINAL: " + compareOriginalToDecrypted);
                System.out.println("");
            
            }

            if (action == 2) {

                // WITH THE CODE ABOVE YOU COULD ENCRYPT AND DECRYPT A MESSAGE. WITH THE CODE BELOW YOU CAN JUST DECRYPT AND ALREADY ENCRYPTED MESSAGE.

                System.out.println("DECRYPT CODE");
                System.out.print("> ");
                long encryptedMessage = Integer.valueOf(reader.nextLine());
                long decryptMessagePhaseOne = (long)Math.pow(encryptedMessage, d);
                long decryptMessagePhaseTwo = decryptMessagePhaseOne % n; 
                System.out.println("DECRYPTED CODE: " + decryptMessagePhaseTwo);
                System.out.println("");
        
            }
            
            if (action == 3) {
            
                for (int i = 0; i < n; i++) {
                    
                    long encryptionPhaseOne = (long)Math.pow(i, x);
                    long encryptionPhaseTwo = encryptionPhaseOne % n;
                    long decryptionPhaseOne = (long)Math.pow(encryptionPhaseTwo, d);
                    long decryptionPhaseTwo = decryptionPhaseOne % n; 
                    boolean compareOriginalToDecrypted = false;
                    if (decryptionPhaseTwo == i) {
                        compareOriginalToDecrypted = true;
                    }
                    
                    System.out.println("VALUE OF i = " + i + ", ENCRYPTED MESSAGE: " + encryptionPhaseTwo + ", ENCRYPTION/DECRYPTION MATCH: " + compareOriginalToDecrypted);
                    
                }
                System.out.println("");

                
            
            }
        }
        
        
            
    }
    
}
