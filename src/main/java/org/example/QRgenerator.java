package org.example;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;


import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;


public class QRgenerator {


    private List<String> codigos = new ArrayList<>();

    private String texto = "https://formulario.com";
    private String caminho = "CodeImages/QrCode_.png";


    public void GenerateQR(int bikeid) {
        caminho = "CodeImages/QrCode_{" + bikeid +"}.png";
        texto = "https://bike:" + bikeid + "//formulario.com";
        try {
            BitMatrix matrix = new MultiFormatWriter().encode(
                    texto,
                    BarcodeFormat.QR_CODE,
                    300,
                    300
            );

            Path path = FileSystems.getDefault().getPath(caminho);
            if(Files.exists(path)){
                System.out.println("Código já existente, cheque no diretorio deste projeto em CodeImages");
            }else {
                MatrixToImageWriter.writeToPath(matrix, "PNG", path);
                System.out.println("Códgio qr gerado com sucesso, confira em na pasta CodeImages no diretorio do projeto");
                codigos.add(caminho);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ListarQRCodes(){

        Path dir = Paths.get("CodeImages");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.png")) {
            for(Path file : stream){
                codigos.add(file.getFileName().toString());
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        for(int i = 0; i < codigos.size(); i++)
        {
            System.out.println(codigos.get(i));
        }

    }


}

