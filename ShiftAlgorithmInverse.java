package Strategy;

public class ShiftAlgorithmInverse implements  ShiftStrategy{

    private String cipher(String message, int offset)
    {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    @Override
    public String shiftAlg(int key, String data) {
//        String userInput1 = resMode;
//        int userInput2 = key;
//        //\jqhtrj%yt%m~ujwxpnqq&
//        String cipherText =" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
//        int userInputLen = userInput1.length();
//        int cipherTextLen = cipherText.length();
//        String result ="";
//        for (int i = 0; i <userInputLen; i++) {
//            char encryptVal = userInput1.charAt(i);
//            for (int j = 0; j <cipherTextLen ; j++) {
//
//                char cyperval = cipherText.charAt(j);
//                if(encryptVal == cyperval)
//                {
//                    //ABCDEFGHIJKLMNOPQRSTUVWXYZ
//                    int index = cipherText.indexOf(cyperval);
//                    int position = index-userInput2;
//                            /*if(position>=0)
//                            {
//                                result += cipherText.charAt(position);
//                                break;
//                            } else
//                            {
//                                int temp = cipherTextLen- Math.abs(position);
//                                result += cipherText.charAt(temp);
//
//                            }*/
//
//                    result += cipherText.charAt(position);
//                }
//
//            }
//
//        }
//
//        return result;
//        StringBuilder sb = new StringBuilder("");
//        for (int i = 0; i < data.length(); i++) {
//            sb.append((char) (data.charAt(i) - key));
//        }
//
//        return sb.toString();
        return cipher(data, 26 - (key % 26));
    }
}
