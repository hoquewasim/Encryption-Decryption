package Strategy;

public class Encoding implements StrategyEnc {

    @Override
    public String enc(int key, String data){
        //Scanner scanner = new Scanner(System.in);
        //String userInput1 = scanner.nextLine();
        //int userInput2 = scanner.nextInt();
        //Welcome to hyperskill!
        String cipherText =" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        int userInputLen = data.length();
        int cipherTextLen = cipherText.length();
        String result ="";
        for (int i = 0; i <userInputLen; i++) {
            char encryptVal = data.charAt(i);
            for (int j = 0; j <cipherTextLen ; j++) {

                char cyperval = cipherText.charAt(j);
                if(encryptVal == cyperval)
                {
                    //ABCDEFGHIJKLMNOPQRSTUVWXYZ
                    int index = cipherText.indexOf(cyperval);
                    int position = index+key;
                    result += cipherText.charAt(position);

                }

            }


        }

        return result;

    }



}
