package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.helpers;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

public class Utils {

    public static void savePhoto(String photoName, String imagemBase64) {
        try {
            if (photoName == null || imagemBase64 == null)
                throw new Exception("Erro ao salvar a foto!");

            // Remove prefixo se vier do tipo "data:image/png;base64,..."
            if (imagemBase64.contains(",")) {
                imagemBase64 = imagemBase64.split(",")[1];
            }

            byte[] imagemBytes = Base64.getDecoder().decode(imagemBase64);

            // Garante que a pasta existe
            File pasta = new File("uploads");
            if (!pasta.exists()) pasta.mkdirs();

            if (!photoName.toLowerCase().endsWith(".jpg")) {
                photoName += ".png";
            }
            // Caminho do arquivo
            String caminho = "uploads/" + photoName;

            try (FileOutputStream fos = new FileOutputStream(caminho)) {
                fos.write(imagemBytes);
            }

            System.out.println("Imagem salva com sucesso em: " + caminho);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
