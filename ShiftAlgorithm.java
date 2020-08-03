package Strategy;

public class ShiftAlgorithm implements ShiftStrategy {

    @Override
    public String shiftAlg(int key, String data) {
        String userInput1 = data;
        int userInput2 = key;
        String cipherText = "abcdefghijklmnopqrstuvwxyz";
        int userInputLen = userInput1.length();
        int cipherTextLen = cipherText.length();
        String result = "";
        for (int i = 0; i < userInputLen; i++) {
            char encryptVal = userInput1.charAt(i);
            if (encryptVal == ' ') {
                result += encryptVal;
            } else if (!(Character.isLetter(encryptVal))) {
                result += encryptVal;
            } else {
                {
                    for (int j = 0; j < cipherTextLen; j++) {

                        char cyperval = cipherText.charAt(j);
                        if (encryptVal == cyperval) {
                            //ABCDEFGHIJKLMNOPQRSTUVWXYZ
                            int index = cipherText.indexOf(cyperval);
                            int position = index + userInput2;
                            if (position <= 25) {
                                result += cipherText.charAt(position);
                                break;
                            } else {
                                int temp = position - cipherTextLen;
                                result += cipherText.charAt(temp);

                            }

                        }

                    }

                }
            }


        }

        return result;

    }

}
