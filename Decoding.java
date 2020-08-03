package Strategy;

public class Decoding implements StrategyDec {


    @Override
    public String dec(int key, String data)
    {
        //Scanner scanner = new Scanner(System.in);
        //String userInput1 = scanner.nextLine();
        //int userInput2 = scanner.nextInt();
        //\jqhtrj%yt%m~ujwxpnqq&
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
                    int position = index-key;
                            /*if(position>=0)
                            {
                                result += cipherText.charAt(position);
                                break;
                            } else
                            {
                                int temp = cipherTextLen- Math.abs(position);
                                result += cipherText.charAt(temp);

                            }*/

                    result += cipherText.charAt(position);
                }

            }

        }

        return result;

    }

}
