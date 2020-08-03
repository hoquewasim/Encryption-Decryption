package Strategy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Client {
    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
    public static void writeFileOutSide(String fileName, String outPutFiles){
        File file = new File("/Users/wasimhoque/Desktop/test/src/Strategy/"+ fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(outPutFiles);
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }
    public static void main(String[] args) {

        String resMode = "";
        String resDec = "";
        int key = 0;
        String data="";
        String fileName = "";
        String outPutFile = "";
        String resultOutPut = "";
        String encOutPut = "";
        String algChoice = "";




        for (int i = 0; i <args.length ; i++) {
            if (args[i].equals("-mode")) {
                resMode = args[i+1];
                //System.out.println(resMode);

            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i+1]);

            } else if (args[i].equals("-data")) {
                data = args[i+1];
            } else if(args[i].equals("-in"))
            {
                fileName = args[i+1];
            } else if(args[i].equals("-out"))
            {
                outPutFile = args[i+1];
            } else if(args[i].equals("-alg"))
            {
                algChoice = args[i+1];
            }

        }
        String storeFile = "";
        if(!(fileName.isEmpty()))
        {


            String pathToHelloWorldJava = "/Users/wasimhoque/Desktop/test/src/Strategy/"+ fileName;
            try {
                //System.out.println(readFileAsString(pathToHelloWorldJava));
                storeFile = readFileAsString(pathToHelloWorldJava);
            } catch (IOException e) {
                System.out.println("Cannot read file: " + e.getMessage());
            }
        }


        Context context = null;
        if(algChoice.equals("unicode"))
        {
            if(resMode.equals("enc"))
            {
                if(key==0){
                    if(fileName.isEmpty())
                    {
                        if(outPutFile.isEmpty()){
                            context = new Context(new Encoding());
                            //context.findEnc(0, data);
                            //encOutPut = enc(0, data);
                            System.out.println(context.findEnc(0, data));
                        } else
                        {
                            //System.out.println(" sono dentro");
                            //encOutPut = enc(0, data);
                            context = new Context(new Encoding());
                            writeFileOutSide(outPutFile, context.findEnc(0, data));
                        }

                    } else
                    {
                        //System.out.println("ok3");
                        //encOutPut = enc(0, storeFile);
                        //writeFileOutSide(outPutFile, encOutPut);
                        context = new Context(new Encoding());
                        writeFileOutSide(outPutFile, context.findEnc(0, storeFile));

                    }


                }
                // se k divero da zero.
                else
                {
                    if(fileName.isEmpty())
                    {

                        if(outPutFile.isEmpty()){
                            //encOutPut = enc(key, data);
                            //System.out.println(encOutPut);
                            context = new Context(new Encoding());
                            System.out.println(context.findEnc(key, data));
                        } else
                        {
                            //encOutPut = enc(key, data);
                            //writeFileOutSide(outPutFile, encOutPut);
                            context = new Context(new Encoding());
                            writeFileOutSide(outPutFile, context.findEnc(key, data));

                        }
                    } else
                    {
                        if(outPutFile.isEmpty()){
                            //encOutPut = enc(key, storeFile);
                            //System.out.println(encOutPut);
                            context = new Context(new Encoding());
                            System.out.println(context.findEnc(key, storeFile));
                        } else
                        {
                            context = new Context(new Encoding());
                            //encOutPut = enc(key, storeFile);
                            //writeFileOutSide(outPutFile, encOutPut);
                            writeFileOutSide(outPutFile, context.findEnc(key, storeFile));

                        }
                    }
                }

            } else if(resMode.equals("dec"))
            {
                //System.out.println(" ok");
                if(key==0){
                    if(fileName.isEmpty())
                    {
                        if (outPutFile.isEmpty())
                        {
                            //System.out.println("sono dentro");
                            //resultOutPut = dec(key, data);
                            //System.out.println(resultOutPut);
                            context = new Context(new Decoding());
                            System.out.println(context.findDec(key, data));

                        } else
                        {
                            //resultOutPut = dec(key, data);
                            //writeFileOutSide(outPutFile, resultOutPut);
                            context = new Context(new Decoding());
                            writeFileOutSide(outPutFile, context.findDec(key, data));
                        }
                    } else
                    {
                        if (outPutFile.isEmpty())
                        {
                            //resultOutPut = dec(key, storeFile);
                            //System.out.println(resultOutPut);
                            context = new Context(new Decoding());
                            System.out.println(context.findDec(key, storeFile));
                        } else
                        {
                            //resultOutPut = dec(key, storeFile);
                            //writeFileOutSide(outPutFile, resultOutPut);
                            context = new Context(new Decoding());
                            writeFileOutSide(outPutFile, context.findDec(key, storeFile));
                        }

                    }
                } else
                {
                    //System.out.println("ok");
                    if(fileName.isEmpty())
                    {
                        if (outPutFile.isEmpty())
                        {
                            //resultOutPut = dec(key, data);
                            //System.out.println(resultOutPut);
                            context = new Context(new Decoding());
                            //writeFileOutSide(outPutFile, context.findDec(key, data));
                            System.out.println(context.findDec(key, data));
                        } else
                        {
                            //resultOutPut = dec(key, data);
                            //writeFileOutSide(outPutFile, resultOutPut);
                            context = new Context(new Decoding());
                            writeFileOutSide(outPutFile, context.findDec(key, data));
                        }

                    } else
                    {
                        if (outPutFile.isEmpty())
                        {
                            //resultOutPut = dec(key, storeFile);
                            //System.out.println(resultOutPut);
                            context = new Context(new Decoding());
                            System.out.println(context.findDec(key, storeFile));
                        } else
                        {
                            //System.out.println("scrivo");
                            //resultOutPut = dec(key, storeFile);
                            //System.out.println(resultOutPut);
                            //System.out.println(key);
                            //writeFileOutSide(outPutFile, resultOutPut);
                            context = new Context(new Decoding());
                            writeFileOutSide(outPutFile, context.findDec(key, storeFile));
                        }

                    }
                }
            } else{

                if(key==0){
                    if(fileName.isEmpty())
                    {
                        if(outPutFile.isEmpty()){
                            //encOutPut = enc(0, data);
                            //System.out.println(encOutPut);
                            context = new Context(new Encoding());
                            System.out.println(context.findEnc(0, data));
                        } else
                        {
                            //encOutPut = enc(0, data);
                            //writeFileOutSide(outPutFile, encOutPut);
                            context = new Context(new Encoding());
                            writeFileOutSide(outPutFile, context.findEnc(0, data));
                        }

                    } else
                    {
                        //enc(0, storeFile);
                        context = new Context(new Encoding());
                        context.findEnc(0, storeFile);
                    }


                }
                // se k divero da zero.
                else
                {
                    if(fileName.isEmpty())
                    {

                        if(outPutFile.isEmpty()){
                            //encOutPut = enc(key, data);
                            //System.out.println(encOutPut);
                            context = new Context(new Encoding());
                            System.out.println(context.findEnc(key, data));
                        } else
                        {
                            //encOutPut = enc(key, data);
                            //writeFileOutSide(outPutFile, encOutPut);
                            context = new Context(new Encoding());
                            writeFileOutSide(outPutFile, context.findEnc(key, data));

                        }
                    } else
                    {
                        //enc(key, storeFile);
                        context = new Context(new Encoding());
                        context.findEnc(key, storeFile);

                    }
                }
            }

        } else if(algChoice.equals("shift"))
        {
//            if(resMode.equals("enc"))
//            {
//                context = new Context(new ShiftAlgorithm());
//                System.out.println( context.findShift(data, key));
//            } else
//            {
//                context = new Context(new ShiftAlgorithmInverse());
//                System.out.println(context.findShiftInverse(data, key));
//
//            }
            if(resMode.equals("enc"))
            {
                if(key==0){
                    if(fileName.isEmpty())
                    {
                        if(outPutFile.isEmpty()){
                            context = new Context(new ShiftAlgorithm());
                            //context.findEnc(0, data);
                            //encOutPut = enc(0, data);
                            System.out.println(context.findShift(0, data));
                        } else
                        {
                            //System.out.println(" sono dentro");
                            //encOutPut = enc(0, data);
                            context = new Context(new ShiftAlgorithm());
                            writeFileOutSide(outPutFile, context.findShift(0, data));
                        }

                    } else
                    {
                        //System.out.println("ok3");
                        //encOutPut = enc(0, storeFile);
                        //writeFileOutSide(outPutFile, encOutPut);
                        context = new Context(new ShiftAlgorithm());
                        writeFileOutSide(outPutFile, context.findShift(0, storeFile));

                    }


                }
                // se k divero da zero.
                else
                {
                    if(fileName.isEmpty())
                    {

                        if(outPutFile.isEmpty()){
                            //encOutPut = enc(key, data);
                            //System.out.println(encOutPut);
                            context = new Context(new ShiftAlgorithm());
                            System.out.println(context.findShift(key, data));
                        } else
                        {
                            //encOutPut = enc(key, data);
                            //writeFileOutSide(outPutFile, encOutPut);
                            context = new Context(new ShiftAlgorithm());
                            writeFileOutSide(outPutFile, context.findShift(key, data));

                        }
                    } else
                    {
                        if(outPutFile.isEmpty()){
                            //encOutPut = enc(key, storeFile);
                            //System.out.println(encOutPut);
                            context = new Context(new ShiftAlgorithm());
                            System.out.println(context.findShift(key, storeFile));
                        } else
                        {
                            context = new Context(new ShiftAlgorithm());
                            //encOutPut = enc(key, storeFile);
                            //writeFileOutSide(outPutFile, encOutPut);
                            writeFileOutSide(outPutFile, context.findShift(key, storeFile));

                        }
                    }
                }

            } else if(resMode.equals("dec"))
            {
                //System.out.println(" ok");
                if(key==0){
                    if(fileName.isEmpty())
                    {
                        if (outPutFile.isEmpty())
                        {
                            //System.out.println("sono dentro");
                            //resultOutPut = dec(key, data);
                            //System.out.println(resultOutPut);
                            context = new Context(new ShiftAlgorithmInverse());
                            System.out.println(context.findShiftInverse(key, data));

                        } else
                        {
                            //resultOutPut = dec(key, data);
                            //writeFileOutSide(outPutFile, resultOutPut);
                            context = new Context(new ShiftAlgorithmInverse());
                            writeFileOutSide(outPutFile, context.findShiftInverse(key, data));
                        }
                    } else
                    {
                        if (outPutFile.isEmpty())
                        {
                            //resultOutPut = dec(key, storeFile);
                            //System.out.println(resultOutPut);
                            context = new Context(new ShiftAlgorithmInverse());
                            System.out.println(context.findShiftInverse(key, storeFile));
                        } else
                        {
                            //resultOutPut = dec(key, storeFile);
                            //writeFileOutSide(outPutFile, resultOutPut);
                            context = new Context(new ShiftAlgorithmInverse());
                            writeFileOutSide(outPutFile, context.findShiftInverse(key, storeFile));
                        }

                    }
                } else
                {
                    //System.out.println("ok");
                    if(fileName.isEmpty())
                    {
                        if (outPutFile.isEmpty())
                        {
                            //resultOutPut = dec(key, data);
                            //System.out.println(resultOutPut);
                            context = new Context(new ShiftAlgorithmInverse());
                            //writeFileOutSide(outPutFile, context.findDec(key, data));
                            System.out.println(context.findShiftInverse(key, data));
                        } else
                        {
                            //resultOutPut = dec(key, data);
                            //writeFileOutSide(outPutFile, resultOutPut);
                            context = new Context(new ShiftAlgorithmInverse());
                            writeFileOutSide(outPutFile, context.findShiftInverse(key, data));
                        }

                    } else
                    {
                        if (outPutFile.isEmpty())
                        {
                            //resultOutPut = dec(key, storeFile);
                            //System.out.println(resultOutPut);
                            context = new Context(new ShiftAlgorithmInverse());
                            System.out.println(context.findShiftInverse(key, storeFile));
                        } else
                        {
                            //System.out.println("scrivo");
                            //resultOutPut = dec(key, storeFile);
                            //System.out.println(resultOutPut);
                            //System.out.println(key);
                            //writeFileOutSide(outPutFile, resultOutPut);
                            context = new Context(new ShiftAlgorithmInverse());
                            writeFileOutSide(outPutFile, context.findShiftInverse(key, storeFile));
                        }

                    }
                }
            } else{

                if(key==0){
                    if(fileName.isEmpty())
                    {
                        if(outPutFile.isEmpty()){
                            //encOutPut = enc(0, data);
                            //System.out.println(encOutPut);
                            context = new Context(new ShiftAlgorithm());
                            System.out.println(context.findShift(0, data));
                        } else
                        {
                            //encOutPut = enc(0, data);
                            //writeFileOutSide(outPutFile, encOutPut);
                            context = new Context(new ShiftAlgorithm());
                            writeFileOutSide(outPutFile, context.findShift(0, data));
                        }

                    } else
                    {
                        //enc(0, storeFile);
                        context = new Context(new ShiftAlgorithm());
                        context.findShift(0, storeFile);
                    }


                }
                // se k divero da zero.
                else
                {
                    if(fileName.isEmpty())
                    {

                        if(outPutFile.isEmpty()){
                            //encOutPut = enc(key, data);
                            //System.out.println(encOutPut);
                            context = new Context(new ShiftAlgorithm());
                            System.out.println(context.findShift(key, data));
                        } else
                        {
                            //encOutPut = enc(key, data);
                            //writeFileOutSide(outPutFile, encOutPut);
                            context = new Context(new ShiftAlgorithm());
                            writeFileOutSide(outPutFile, context.findShift(key, data));

                        }
                    } else
                    {
                        //enc(key, storeFile);
                        context = new Context(new ShiftAlgorithm());
                        context.findShift(key, storeFile);

                    }
                }
            }



        }
        else
        {

            if(key==0){
                if(fileName.isEmpty())
                {
                    if(outPutFile.isEmpty()){
                        context = new Context(new ShiftAlgorithm());
                        //context.findEnc(0, data);
                        //encOutPut = enc(0, data);
                        System.out.println(context.findShift(0, data));
                    } else
                    {
                        //System.out.println(" sono dentro");
                        //encOutPut = enc(0, data);
                        context = new Context(new ShiftAlgorithm());
                        writeFileOutSide(outPutFile, context.findShift(0, data));
                    }

                } else
                {
                    //System.out.println("ok3");
                    //encOutPut = enc(0, storeFile);
                    //writeFileOutSide(outPutFile, encOutPut);
                    context = new Context(new ShiftAlgorithm());
                    writeFileOutSide(outPutFile, context.findShift(0, storeFile));

                }


            }
            // se k divero da zero.
            else
            {
                if(fileName.isEmpty())
                {

                    if(outPutFile.isEmpty()){
                        //encOutPut = enc(key, data);
                        //System.out.println(encOutPut);
                        context = new Context(new ShiftAlgorithm());
                        System.out.println(context.findShift(key, data));
                    } else
                    {
                        //encOutPut = enc(key, data);
                        //writeFileOutSide(outPutFile, encOutPut);
                        context = new Context(new ShiftAlgorithm());
                        writeFileOutSide(outPutFile, context.findShift(key, data));

                    }
                } else
                {
                    if(outPutFile.isEmpty()){
                        //encOutPut = enc(key, storeFile);
                        //System.out.println(encOutPut);
                        context = new Context(new ShiftAlgorithm());
                        System.out.println(context.findShift(key, storeFile));
                    } else
                    {
                        context = new Context(new ShiftAlgorithm());
                        //encOutPut = enc(key, storeFile);
                        //writeFileOutSide(outPutFile, encOutPut);
                        writeFileOutSide(outPutFile, context.findShift(key, storeFile));

                    }
                }
            }


        }



        }


    }

